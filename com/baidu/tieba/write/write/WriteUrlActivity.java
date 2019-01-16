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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k idT;
    private com.baidu.tieba.write.model.a idU;
    private WriteUrlModel idV;
    private com.baidu.tieba.write.a.a idW;
    private j idX;
    private boolean isLoading = false;
    private Runnable egX = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.idT != null) {
                WriteUrlActivity.this.idT.a(WriteUrlActivity.this.idW, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.idT != null) {
                if (view == WriteUrlActivity.this.idT.aVp()) {
                    if (WriteUrlActivity.this.idT == null || WriteUrlActivity.this.idT.bRR() == null || WriteUrlActivity.this.idT.bRR().getVisibility() != 0) {
                        if (WriteUrlActivity.this.idW != null || (WriteUrlActivity.this.idT != null && !StringUtils.isNull(WriteUrlActivity.this.idT.bRI()))) {
                            WriteUrlActivity.this.byR();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.idT.bRO();
                } else if (view == WriteUrlActivity.this.idT.bRJ()) {
                    if (WriteUrlActivity.this.idW != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.idW.hXM != 2 || WriteUrlActivity.this.idT.bRI().length() <= 31) {
                            if (!WriteUrlActivity.this.idX.bRD()) {
                                WriteUrlActivity.this.idX.asq();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.idT.bRL() || view == WriteUrlActivity.this.idT.bRM()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.idU != null) {
                        WriteUrlActivity.this.idU.bPF();
                    }
                    WriteUrlActivity.this.idW = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.idT.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.idT.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.idT.bRN()) {
                    WriteUrlActivity.this.idT.b(WriteUrlActivity.this.idW);
                } else if (view == WriteUrlActivity.this.idT.getVideoContainer()) {
                    if (WriteUrlActivity.this.idW != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.idW.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.idW.videoUrl, WriteUrlActivity.this.idW.videoWidth, WriteUrlActivity.this.idW.videoHeight, WriteUrlActivity.this.idW.hXR);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.idT.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.idT.bRK());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.idT = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.idU = new com.baidu.tieba.write.model.a(getUniqueId());
        this.idU.a(new a.InterfaceC0335a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0335a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.idW = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.idT != null) {
                    if (WriteUrlActivity.this.idW.hXM == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.egX, 800L);
                    } else {
                        WriteUrlActivity.this.idT.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hXM == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.idX != null) {
                        WriteUrlActivity.this.idX.bFz();
                    }
                }
            }
        });
        this.idV = new WriteUrlModel(getPageContext());
        this.idV.an(getIntent());
        this.idX = new j(getPageContext(), this.idT, this.idU, this.idV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.idT != null) {
            this.idT.onChangeSkinType(i);
        }
        this.idX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.idT != null && this.idT.bRR() != null && this.idT.bRR().getVisibility() == 0) {
                this.idT.bRO();
                return true;
            } else if (this.idW != null || (this.idT != null && !StringUtils.isNull(this.idT.bRI()))) {
                byR();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.db(e.j.tip_draft_no_publish);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.BS();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.idX.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.idX.destroy();
        if (this.idT != null) {
            this.idT.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
