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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private j hKO;
    private com.baidu.tieba.write.model.a hKP;
    private WriteUrlModel hKQ;
    private com.baidu.tieba.write.a.a hKR;
    private i hKS;
    private boolean isLoading = false;
    private Runnable hKT = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hKO != null) {
                WriteUrlActivity.this.hKO.a(WriteUrlActivity.this.hKR, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hKO != null) {
                if (view == WriteUrlActivity.this.hKO.aKh()) {
                    if (WriteUrlActivity.this.hKO == null || WriteUrlActivity.this.hKO.bIK() == null || WriteUrlActivity.this.hKO.bIK().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hKR != null || (WriteUrlActivity.this.hKO != null && !StringUtils.isNull(WriteUrlActivity.this.hKO.bIB()))) {
                            WriteUrlActivity.this.bpJ();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hKO.bIH();
                } else if (view == WriteUrlActivity.this.hKO.bIC()) {
                    if (WriteUrlActivity.this.hKR != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hKR.hEu != 2 || WriteUrlActivity.this.hKO.bIB().length() <= 31) {
                            if (!WriteUrlActivity.this.hKS.bIw()) {
                                WriteUrlActivity.this.hKS.bIv();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hKO.bIE() || view == WriteUrlActivity.this.hKO.bIF()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hKP != null) {
                        WriteUrlActivity.this.hKP.bGb();
                    }
                    WriteUrlActivity.this.hKR = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hKO.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hKO.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hKO.bIG()) {
                    WriteUrlActivity.this.hKO.b(WriteUrlActivity.this.hKR);
                } else if (view == WriteUrlActivity.this.hKO.getVideoContainer()) {
                    if (WriteUrlActivity.this.hKR != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hKR.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hKR.videoUrl, WriteUrlActivity.this.hKR.videoWidth, WriteUrlActivity.this.hKR.videoHeight, WriteUrlActivity.this.hKR.hEz);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hKO.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hKO.bID());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hKO = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hKP = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hKP.a(new a.InterfaceC0168a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0168a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hKR = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hKO != null) {
                    if (WriteUrlActivity.this.hKR.hEu == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hKT, 800L);
                    } else {
                        WriteUrlActivity.this.hKO.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hEu == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hKS != null) {
                        WriteUrlActivity.this.hKS.bwr();
                    }
                }
            }
        });
        this.hKQ = new WriteUrlModel(getPageContext());
        this.hKQ.an(getIntent());
        this.hKS = new i(getPageContext(), this.hKO, this.hKP, this.hKQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hKO != null) {
            this.hKO.onChangeSkinType(i);
        }
        this.hKS.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hKO != null && this.hKO.bIK() != null && this.hKO.bIK().getVisibility() == 0) {
                this.hKO.bIH();
                return true;
            } else if (this.hKR != null || (this.hKO != null && !StringUtils.isNull(this.hKO.bIB()))) {
                bpJ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.fb(d.j.tip_draft_no_publish);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.AA();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hKS.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hKS.destroy();
        if (this.hKO != null) {
            this.hKO.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
