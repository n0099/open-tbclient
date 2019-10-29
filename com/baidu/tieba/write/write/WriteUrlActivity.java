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
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k jWm;
    private com.baidu.tieba.write.model.a jWn;
    private WriteUrlModel jWo;
    private com.baidu.tieba.write.a.a jWp;
    private j jWq;
    private boolean isLoading = false;
    private Runnable dBG = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jWm != null) {
                WriteUrlActivity.this.jWm.a(WriteUrlActivity.this.jWp, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jWm != null) {
                if (view == WriteUrlActivity.this.jWm.bDX()) {
                    if (WriteUrlActivity.this.jWm == null || WriteUrlActivity.this.jWm.cAK() == null || WriteUrlActivity.this.jWm.cAK().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jWp != null || (WriteUrlActivity.this.jWm != null && !StringUtils.isNull(WriteUrlActivity.this.jWm.cAB()))) {
                            WriteUrlActivity.this.cjt();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jWm.cAH();
                } else if (view == WriteUrlActivity.this.jWm.cAC()) {
                    if (WriteUrlActivity.this.jWp != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jWp.jPK != 2 || WriteUrlActivity.this.jWm.cAB().length() <= 31) {
                            if (!WriteUrlActivity.this.jWq.cAw()) {
                                WriteUrlActivity.this.jWq.bcc();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jWm.cAE() || view == WriteUrlActivity.this.jWm.cAF()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jWn != null) {
                        WriteUrlActivity.this.jWn.cyw();
                    }
                    WriteUrlActivity.this.jWp = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jWm.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jWm.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.jWm.cAG()) {
                    WriteUrlActivity.this.jWm.b(WriteUrlActivity.this.jWp);
                } else if (view == WriteUrlActivity.this.jWm.getVideoContainer()) {
                    if (WriteUrlActivity.this.jWp != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jWp.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jWp.videoUrl, WriteUrlActivity.this.jWp.videoWidth, WriteUrlActivity.this.jWp.videoHeight, WriteUrlActivity.this.jWp.jPP);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jWm.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jWm.cAD());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jWm = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jWn = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jWn.a(new a.InterfaceC0539a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0539a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jWp = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jWm != null) {
                    if (WriteUrlActivity.this.jWp.jPK == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dBG, 800L);
                    } else {
                        WriteUrlActivity.this.jWm.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jPK == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jWq != null) {
                        WriteUrlActivity.this.jWq.coZ();
                    }
                }
            }
        });
        this.jWo = new WriteUrlModel(getPageContext());
        this.jWo.aN(getIntent());
        this.jWq = new j(getPageContext(), this.jWm, this.jWn, this.jWo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jWm != null) {
            this.jWm.onChangeSkinType(i);
        }
        this.jWq.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jWm != null && this.jWm.cAK() != null && this.jWm.cAK().getVisibility() == 0) {
                this.jWm.cAH();
                return true;
            } else if (this.jWp != null || (this.jWm != null && !StringUtils.isNull(this.jWm.cAB()))) {
                cjt();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hU(R.string.tip_draft_no_publish);
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
        aVar.akO();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jWq.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jWq.destroy();
        if (this.jWm != null) {
            this.jWm.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
