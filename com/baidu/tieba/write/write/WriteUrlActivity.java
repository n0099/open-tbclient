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
    private k hQD;
    private com.baidu.tieba.write.model.a hQE;
    private WriteUrlModel hQF;
    private com.baidu.tieba.write.a.a hQG;
    private j hQH;
    private boolean isLoading = false;
    private Runnable dVP = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hQD != null) {
                WriteUrlActivity.this.hQD.a(WriteUrlActivity.this.hQG, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hQD != null) {
                if (view == WriteUrlActivity.this.hQD.aSN()) {
                    if (WriteUrlActivity.this.hQD == null || WriteUrlActivity.this.hQD.bOO() == null || WriteUrlActivity.this.hQD.bOO().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hQG != null || (WriteUrlActivity.this.hQD != null && !StringUtils.isNull(WriteUrlActivity.this.hQD.bOF()))) {
                            WriteUrlActivity.this.bwe();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hQD.bOL();
                } else if (view == WriteUrlActivity.this.hQD.bOG()) {
                    if (WriteUrlActivity.this.hQG != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.hQG.hKy != 2 || WriteUrlActivity.this.hQD.bOF().length() <= 31) {
                            if (!WriteUrlActivity.this.hQH.bOA()) {
                                WriteUrlActivity.this.hQH.apP();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hQD.bOI() || view == WriteUrlActivity.this.hQD.bOJ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hQE != null) {
                        WriteUrlActivity.this.hQE.bMC();
                    }
                    WriteUrlActivity.this.hQG = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hQD.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hQD.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hQD.bOK()) {
                    WriteUrlActivity.this.hQD.b(WriteUrlActivity.this.hQG);
                } else if (view == WriteUrlActivity.this.hQD.getVideoContainer()) {
                    if (WriteUrlActivity.this.hQG != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hQG.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hQG.videoUrl, WriteUrlActivity.this.hQG.videoWidth, WriteUrlActivity.this.hQG.videoHeight, WriteUrlActivity.this.hQG.hKD);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hQD.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hQD.bOH());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hQD = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hQE = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hQE.a(new a.InterfaceC0294a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0294a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hQG = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hQD != null) {
                    if (WriteUrlActivity.this.hQG.hKy == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dVP, 800L);
                    } else {
                        WriteUrlActivity.this.hQD.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hKy == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hQH != null) {
                        WriteUrlActivity.this.hQH.bCJ();
                    }
                }
            }
        });
        this.hQF = new WriteUrlModel(getPageContext());
        this.hQF.an(getIntent());
        this.hQH = new j(getPageContext(), this.hQD, this.hQE, this.hQF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hQD != null) {
            this.hQD.onChangeSkinType(i);
        }
        this.hQH.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hQD != null && this.hQD.bOO() != null && this.hQD.bOO().getVisibility() == 0) {
                this.hQD.bOL();
                return true;
            } else if (this.hQG != null || (this.hQD != null && !StringUtils.isNull(this.hQD.bOF()))) {
                bwe();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cz(e.j.tip_draft_no_publish);
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
        aVar.Au();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hQH.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hQH.destroy();
        if (this.hQD != null) {
            this.hQD.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
