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
    private k idU;
    private com.baidu.tieba.write.model.a idV;
    private WriteUrlModel idW;
    private com.baidu.tieba.write.a.a idX;
    private j idY;
    private boolean isLoading = false;
    private Runnable egY = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.idU != null) {
                WriteUrlActivity.this.idU.a(WriteUrlActivity.this.idX, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.idU != null) {
                if (view == WriteUrlActivity.this.idU.aVp()) {
                    if (WriteUrlActivity.this.idU == null || WriteUrlActivity.this.idU.bRR() == null || WriteUrlActivity.this.idU.bRR().getVisibility() != 0) {
                        if (WriteUrlActivity.this.idX != null || (WriteUrlActivity.this.idU != null && !StringUtils.isNull(WriteUrlActivity.this.idU.bRI()))) {
                            WriteUrlActivity.this.byR();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.idU.bRO();
                } else if (view == WriteUrlActivity.this.idU.bRJ()) {
                    if (WriteUrlActivity.this.idX != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.idX.hXN != 2 || WriteUrlActivity.this.idU.bRI().length() <= 31) {
                            if (!WriteUrlActivity.this.idY.bRD()) {
                                WriteUrlActivity.this.idY.asq();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.idU.bRL() || view == WriteUrlActivity.this.idU.bRM()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.idV != null) {
                        WriteUrlActivity.this.idV.bPF();
                    }
                    WriteUrlActivity.this.idX = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.idU.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.idU.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.idU.bRN()) {
                    WriteUrlActivity.this.idU.b(WriteUrlActivity.this.idX);
                } else if (view == WriteUrlActivity.this.idU.getVideoContainer()) {
                    if (WriteUrlActivity.this.idX != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.idX.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.idX.videoUrl, WriteUrlActivity.this.idX.videoWidth, WriteUrlActivity.this.idX.videoHeight, WriteUrlActivity.this.idX.hXS);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.idU.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.idU.bRK());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.idU = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.idV = new com.baidu.tieba.write.model.a(getUniqueId());
        this.idV.a(new a.InterfaceC0335a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0335a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.idX = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.idU != null) {
                    if (WriteUrlActivity.this.idX.hXN == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.egY, 800L);
                    } else {
                        WriteUrlActivity.this.idU.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hXN == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.idY != null) {
                        WriteUrlActivity.this.idY.bFz();
                    }
                }
            }
        });
        this.idW = new WriteUrlModel(getPageContext());
        this.idW.an(getIntent());
        this.idY = new j(getPageContext(), this.idU, this.idV, this.idW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.idU != null) {
            this.idU.onChangeSkinType(i);
        }
        this.idY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.idU != null && this.idU.bRR() != null && this.idU.bRR().getVisibility() == 0) {
                this.idU.bRO();
                return true;
            } else if (this.idX != null || (this.idU != null && !StringUtils.isNull(this.idU.bRI()))) {
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
        this.idY.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.idY.destroy();
        if (this.idU != null) {
            this.idU.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
