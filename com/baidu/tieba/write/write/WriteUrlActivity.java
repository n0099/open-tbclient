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
/* loaded from: classes13.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k kWl;
    private com.baidu.tieba.write.model.a kWm;
    private WriteUrlModel kWn;
    private com.baidu.tieba.write.a.a kWo;
    private j kWp;
    private boolean isLoading = false;
    private Runnable erI = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kWl != null) {
                WriteUrlActivity.this.kWl.a(WriteUrlActivity.this.kWo, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kWl != null) {
                if (view == WriteUrlActivity.this.kWl.bYm()) {
                    if (WriteUrlActivity.this.kWl == null || WriteUrlActivity.this.kWl.cXD() == null || WriteUrlActivity.this.kWl.cXD().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kWo != null || (WriteUrlActivity.this.kWl != null && !StringUtils.isNull(WriteUrlActivity.this.kWl.cXu()))) {
                            WriteUrlActivity.this.cGz();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kWl.cXA();
                } else if (view == WriteUrlActivity.this.kWl.cXv()) {
                    if (WriteUrlActivity.this.kWo != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kWo.kPQ != 2 || WriteUrlActivity.this.kWl.cXu().length() <= 31) {
                            if (!WriteUrlActivity.this.kWp.cXp()) {
                                WriteUrlActivity.this.kWp.bwl();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kWl.cXx() || view == WriteUrlActivity.this.kWl.cXy()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kWm != null) {
                        WriteUrlActivity.this.kWm.cVn();
                    }
                    WriteUrlActivity.this.kWo = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kWl.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kWl.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kWl.cXz()) {
                    WriteUrlActivity.this.kWl.b(WriteUrlActivity.this.kWo);
                } else if (view == WriteUrlActivity.this.kWl.getVideoContainer()) {
                    if (WriteUrlActivity.this.kWo != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kWo.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kWo.videoUrl, WriteUrlActivity.this.kWo.videoWidth, WriteUrlActivity.this.kWo.videoHeight, WriteUrlActivity.this.kWo.kPV);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kWl.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kWl.cXw());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kWl = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kWm = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kWm.a(new a.InterfaceC0633a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0633a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kWo = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kWl != null) {
                    if (WriteUrlActivity.this.kWo.kPQ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.erI, 800L);
                    } else {
                        WriteUrlActivity.this.kWl.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kPQ == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kWp != null) {
                        WriteUrlActivity.this.kWp.cMe();
                    }
                }
            }
        });
        this.kWn = new WriteUrlModel(getPageContext());
        this.kWn.aG(getIntent());
        this.kWp = new j(getPageContext(), this.kWl, this.kWm, this.kWn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kWl != null) {
            this.kWl.onChangeSkinType(i);
        }
        this.kWp.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kWl != null && this.kWl.cXD() != null && this.kWl.cXD().getVisibility() == 0) {
                this.kWl.cXA();
                return true;
            } else if (this.kWo != null || (this.kWl != null && !StringUtils.isNull(this.kWl.cXu()))) {
                cGz();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jW(R.string.tip_draft_no_publish);
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
        aVar.aEG();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kWp.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kWp.destroy();
        if (this.kWl != null) {
            this.kWl.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
