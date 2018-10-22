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
    private k hQE;
    private com.baidu.tieba.write.model.a hQF;
    private WriteUrlModel hQG;
    private com.baidu.tieba.write.a.a hQH;
    private j hQI;
    private boolean isLoading = false;
    private Runnable dVQ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hQE != null) {
                WriteUrlActivity.this.hQE.a(WriteUrlActivity.this.hQH, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hQE != null) {
                if (view == WriteUrlActivity.this.hQE.aSN()) {
                    if (WriteUrlActivity.this.hQE == null || WriteUrlActivity.this.hQE.bOO() == null || WriteUrlActivity.this.hQE.bOO().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hQH != null || (WriteUrlActivity.this.hQE != null && !StringUtils.isNull(WriteUrlActivity.this.hQE.bOF()))) {
                            WriteUrlActivity.this.bwe();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hQE.bOL();
                } else if (view == WriteUrlActivity.this.hQE.bOG()) {
                    if (WriteUrlActivity.this.hQH != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.hQH.hKz != 2 || WriteUrlActivity.this.hQE.bOF().length() <= 31) {
                            if (!WriteUrlActivity.this.hQI.bOA()) {
                                WriteUrlActivity.this.hQI.apQ();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hQE.bOI() || view == WriteUrlActivity.this.hQE.bOJ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hQF != null) {
                        WriteUrlActivity.this.hQF.bMC();
                    }
                    WriteUrlActivity.this.hQH = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hQE.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hQE.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hQE.bOK()) {
                    WriteUrlActivity.this.hQE.b(WriteUrlActivity.this.hQH);
                } else if (view == WriteUrlActivity.this.hQE.getVideoContainer()) {
                    if (WriteUrlActivity.this.hQH != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hQH.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hQH.videoUrl, WriteUrlActivity.this.hQH.videoWidth, WriteUrlActivity.this.hQH.videoHeight, WriteUrlActivity.this.hQH.hKE);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hQE.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hQE.bOH());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hQE = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hQF = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hQF.a(new a.InterfaceC0294a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0294a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hQH = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hQE != null) {
                    if (WriteUrlActivity.this.hQH.hKz == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dVQ, 800L);
                    } else {
                        WriteUrlActivity.this.hQE.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hKz == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hQI != null) {
                        WriteUrlActivity.this.hQI.bCJ();
                    }
                }
            }
        });
        this.hQG = new WriteUrlModel(getPageContext());
        this.hQG.an(getIntent());
        this.hQI = new j(getPageContext(), this.hQE, this.hQF, this.hQG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hQE != null) {
            this.hQE.onChangeSkinType(i);
        }
        this.hQI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hQE != null && this.hQE.bOO() != null && this.hQE.bOO().getVisibility() == 0) {
                this.hQE.bOL();
                return true;
            } else if (this.hQH != null || (this.hQE != null && !StringUtils.isNull(this.hQE.bOF()))) {
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
        this.hQI.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hQI.destroy();
        if (this.hQE != null) {
            this.hQE.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
