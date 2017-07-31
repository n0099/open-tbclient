package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private d gHE;
    private com.baidu.tieba.write.model.a gHF;
    private WriteUrlModel gHG;
    private com.baidu.tieba.write.a.a gHH;
    private c gHI;
    private boolean isLoading = false;
    private Runnable gHJ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gHE != null) {
                WriteUrlActivity.this.gHE.a(WriteUrlActivity.this.gHH, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aYW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gHE != null) {
                if (view == WriteUrlActivity.this.gHE.Wa()) {
                    if (WriteUrlActivity.this.gHE == null || WriteUrlActivity.this.gHE.bAR() == null || WriteUrlActivity.this.gHE.bAR().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gHH != null || (WriteUrlActivity.this.gHE != null && !StringUtils.isNull(WriteUrlActivity.this.gHE.bAJ()))) {
                            WriteUrlActivity.this.bkE();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gHE.bAO();
                } else if (view == WriteUrlActivity.this.gHE.bAK()) {
                    if (WriteUrlActivity.this.gHH != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!i.hr()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gHH.gBT != 2 || WriteUrlActivity.this.gHE.bAJ().length() <= 31) {
                            WriteUrlActivity.this.gHI.bAF();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gHE.boZ() || view == WriteUrlActivity.this.gHE.bAM()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gHF != null) {
                        WriteUrlActivity.this.gHF.byC();
                    }
                    WriteUrlActivity.this.gHH = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gHE.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gHE.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aj("c12167"));
                } else if (view == WriteUrlActivity.this.gHE.bAN()) {
                    WriteUrlActivity.this.gHE.b(WriteUrlActivity.this.gHH);
                } else if (view == WriteUrlActivity.this.gHE.getVideoContainer()) {
                    if (WriteUrlActivity.this.gHH != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gHH.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gHH.videoUrl, WriteUrlActivity.this.gHH.videoWidth, WriteUrlActivity.this.gHH.videoHeight, WriteUrlActivity.this.gHH.gBZ);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gHE.getRootView()) {
                    k.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gHE.bAL());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gHE = new d(this, this.aYW);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gHF = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gHF.a(new a.InterfaceC0123a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0123a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gHH = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gHE != null) {
                    if (WriteUrlActivity.this.gHH.gBT == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gHJ, 800L);
                    } else {
                        WriteUrlActivity.this.gHE.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gHG = new WriteUrlModel(getPageContext());
        this.gHG.aj(getIntent());
        this.gHI = new c(getPageContext(), this.gHE, this.gHF, this.gHG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gHE != null) {
            this.gHE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gHE != null && this.gHE.bAR() != null && this.gHE.bAR().getVisibility() == 0) {
                this.gHE.bAO();
                return true;
            } else if (this.gHH != null || (this.gHE != null && !StringUtils.isNull(this.gHE.bAJ()))) {
                bkE();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.l.tip_draft_no_publish);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.tr();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gHI.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gHI.destroy();
        if (this.gHE != null) {
            this.gHE.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
