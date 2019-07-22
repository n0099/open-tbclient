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
    private k jUK;
    private com.baidu.tieba.write.model.a jUL;
    private WriteUrlModel jUM;
    private com.baidu.tieba.write.a.a jUN;
    private j jUO;
    private boolean isLoading = false;
    private Runnable dtn = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jUK != null) {
                WriteUrlActivity.this.jUK.a(WriteUrlActivity.this.jUN, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jUK != null) {
                if (view == WriteUrlActivity.this.jUK.bGk()) {
                    if (WriteUrlActivity.this.jUK == null || WriteUrlActivity.this.jUK.cCR() == null || WriteUrlActivity.this.jUK.cCR().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jUN != null || (WriteUrlActivity.this.jUK != null && !StringUtils.isNull(WriteUrlActivity.this.jUK.cCI()))) {
                            WriteUrlActivity.this.ckC();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jUK.cCO();
                } else if (view == WriteUrlActivity.this.jUK.cCJ()) {
                    if (WriteUrlActivity.this.jUN != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jUN.jOw != 2 || WriteUrlActivity.this.jUK.cCI().length() <= 31) {
                            if (!WriteUrlActivity.this.jUO.cCD()) {
                                WriteUrlActivity.this.jUO.bbr();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jUK.cCL() || view == WriteUrlActivity.this.jUK.cCM()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jUL != null) {
                        WriteUrlActivity.this.jUL.cAD();
                    }
                    WriteUrlActivity.this.jUN = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jUK.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jUK.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.jUK.cCN()) {
                    WriteUrlActivity.this.jUK.b(WriteUrlActivity.this.jUN);
                } else if (view == WriteUrlActivity.this.jUK.getVideoContainer()) {
                    if (WriteUrlActivity.this.jUN != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jUN.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jUN.videoUrl, WriteUrlActivity.this.jUN.videoWidth, WriteUrlActivity.this.jUN.videoHeight, WriteUrlActivity.this.jUN.jOB);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jUK.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jUK.cCK());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jUK = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jUL = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jUL.a(new a.InterfaceC0427a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0427a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jUN = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jUK != null) {
                    if (WriteUrlActivity.this.jUN.jOw == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dtn, 800L);
                    } else {
                        WriteUrlActivity.this.jUK.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jOw == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jUO != null) {
                        WriteUrlActivity.this.jUO.cpX();
                    }
                }
            }
        });
        this.jUM = new WriteUrlModel(getPageContext());
        this.jUM.aH(getIntent());
        this.jUO = new j(getPageContext(), this.jUK, this.jUL, this.jUM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jUK != null) {
            this.jUK.onChangeSkinType(i);
        }
        this.jUO.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jUK != null && this.jUK.cCR() != null && this.jUK.cCR().getVisibility() == 0) {
                this.jUK.cCO();
                return true;
            } else if (this.jUN != null || (this.jUK != null && !StringUtils.isNull(this.jUK.cCI()))) {
                ckC();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hu(R.string.tip_draft_no_publish);
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
        aVar.agI();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jUO.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jUO.destroy();
        if (this.jUK != null) {
            this.jUK.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
