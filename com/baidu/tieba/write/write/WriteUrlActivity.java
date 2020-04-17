package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k lGm;
    private com.baidu.tieba.write.model.a lGn;
    private WriteUrlModel lGo;
    private com.baidu.tieba.write.a.a lGp;
    private j lGq;
    private boolean isLoading = false;
    private Runnable eVe = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.lGm != null) {
                WriteUrlActivity.this.lGm.a(WriteUrlActivity.this.lGp, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.lGm != null) {
                if (view == WriteUrlActivity.this.lGm.ciN()) {
                    if (WriteUrlActivity.this.lGm == null || WriteUrlActivity.this.lGm.dil() == null || WriteUrlActivity.this.lGm.dil().getVisibility() != 0) {
                        if (WriteUrlActivity.this.lGp != null || (WriteUrlActivity.this.lGm != null && !StringUtils.isNull(WriteUrlActivity.this.lGm.dic()))) {
                            WriteUrlActivity.this.cQX();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.lGm.dii();
                } else if (view == WriteUrlActivity.this.lGm.did()) {
                    if (WriteUrlActivity.this.lGp != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.lGp.lzi != 2 || WriteUrlActivity.this.lGm.dic().length() <= 31) {
                            if (!WriteUrlActivity.this.lGq.dhX()) {
                                WriteUrlActivity.this.lGq.bFW();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lGm.dif() || view == WriteUrlActivity.this.lGm.dig()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.lGn != null) {
                        WriteUrlActivity.this.lGn.dfJ();
                    }
                    WriteUrlActivity.this.lGp = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.lGm.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.lGm.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.lGm.dih()) {
                    WriteUrlActivity.this.lGm.b(WriteUrlActivity.this.lGp);
                } else if (view == WriteUrlActivity.this.lGm.getVideoContainer()) {
                    if (WriteUrlActivity.this.lGp != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.lGp.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.lGp.videoUrl, WriteUrlActivity.this.lGp.videoWidth, WriteUrlActivity.this.lGp.videoHeight, WriteUrlActivity.this.lGp.lzn);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lGm.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.lGm.die());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lGm = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lGn = new com.baidu.tieba.write.model.a(getUniqueId());
        this.lGn.a(new a.InterfaceC0678a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0678a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.lGp = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.lGm != null) {
                    if (WriteUrlActivity.this.lGp.lzi == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.eVe, 800L);
                    } else {
                        WriteUrlActivity.this.lGm.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.lzi == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.lGq != null) {
                        WriteUrlActivity.this.lGq.cXa();
                    }
                }
            }
        });
        this.lGo = new WriteUrlModel(getPageContext());
        this.lGo.aF(getIntent());
        this.lGq = new j(getPageContext(), this.lGm, this.lGn, this.lGo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lGm != null) {
            this.lGm.onChangeSkinType(i);
        }
        this.lGq.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lGm != null && this.lGm.dil() != null && this.lGm.dil().getVisibility() == 0) {
                this.lGm.dii();
                return true;
            } else if (this.lGp != null || (this.lGm != null && !StringUtils.isNull(this.lGm.dic()))) {
                cQX();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kd(R.string.tip_draft_no_publish);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.aMU();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lGq.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lGq.destroy();
        if (this.lGm != null) {
            this.lGm.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
