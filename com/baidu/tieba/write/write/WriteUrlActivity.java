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
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k juE;
    private com.baidu.tieba.write.model.a juF;
    private WriteUrlModel juG;
    private com.baidu.tieba.write.a.a juH;
    private j juI;
    private boolean isLoading = false;
    private Runnable fvH = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.juE != null) {
                WriteUrlActivity.this.juE.a(WriteUrlActivity.this.juH, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.juE != null) {
                if (view == WriteUrlActivity.this.juE.bvR()) {
                    if (WriteUrlActivity.this.juE == null || WriteUrlActivity.this.juE.crL() == null || WriteUrlActivity.this.juE.crL().getVisibility() != 0) {
                        if (WriteUrlActivity.this.juH != null || (WriteUrlActivity.this.juE != null && !StringUtils.isNull(WriteUrlActivity.this.juE.crC()))) {
                            WriteUrlActivity.this.bZE();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.juE.crI();
                } else if (view == WriteUrlActivity.this.juE.crD()) {
                    if (WriteUrlActivity.this.juH != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.juH.jom != 2 || WriteUrlActivity.this.juE.crC().length() <= 31) {
                            if (!WriteUrlActivity.this.juI.crx()) {
                                WriteUrlActivity.this.juI.aSg();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juE.crF() || view == WriteUrlActivity.this.juE.crG()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.juF != null) {
                        WriteUrlActivity.this.juF.cpx();
                    }
                    WriteUrlActivity.this.juH = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.juE.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.juE.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.juE.crH()) {
                    WriteUrlActivity.this.juE.b(WriteUrlActivity.this.juH);
                } else if (view == WriteUrlActivity.this.juE.getVideoContainer()) {
                    if (WriteUrlActivity.this.juH != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.juH.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.juH.videoUrl, WriteUrlActivity.this.juH.videoWidth, WriteUrlActivity.this.juH.videoHeight, WriteUrlActivity.this.juH.jor);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juE.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.juE.crE());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.juE = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.juF = new com.baidu.tieba.write.model.a(getUniqueId());
        this.juF.a(new a.InterfaceC0409a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0409a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.juH = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.juE != null) {
                    if (WriteUrlActivity.this.juH.jom == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fvH, 800L);
                    } else {
                        WriteUrlActivity.this.juE.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jom == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.juI != null) {
                        WriteUrlActivity.this.juI.ceX();
                    }
                }
            }
        });
        this.juG = new WriteUrlModel(getPageContext());
        this.juG.aE(getIntent());
        this.juI = new j(getPageContext(), this.juE, this.juF, this.juG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juE != null) {
            this.juE.onChangeSkinType(i);
        }
        this.juI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.juE != null && this.juE.crL() != null && this.juE.crL().getVisibility() == 0) {
                this.juE.crI();
                return true;
            } else if (this.juH != null || (this.juE != null && !StringUtils.isNull(this.juE.crC()))) {
                bZE();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.gC(d.j.tip_draft_no_publish);
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
        aVar.aaW();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.juI.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.juI.destroy();
        if (this.juE != null) {
            this.juE.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
