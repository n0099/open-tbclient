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
    private k juF;
    private com.baidu.tieba.write.model.a juG;
    private WriteUrlModel juH;
    private com.baidu.tieba.write.a.a juI;
    private j juJ;
    private boolean isLoading = false;
    private Runnable fvH = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.juF != null) {
                WriteUrlActivity.this.juF.a(WriteUrlActivity.this.juI, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.juF != null) {
                if (view == WriteUrlActivity.this.juF.bvR()) {
                    if (WriteUrlActivity.this.juF == null || WriteUrlActivity.this.juF.crL() == null || WriteUrlActivity.this.juF.crL().getVisibility() != 0) {
                        if (WriteUrlActivity.this.juI != null || (WriteUrlActivity.this.juF != null && !StringUtils.isNull(WriteUrlActivity.this.juF.crC()))) {
                            WriteUrlActivity.this.bZE();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.juF.crI();
                } else if (view == WriteUrlActivity.this.juF.crD()) {
                    if (WriteUrlActivity.this.juI != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.juI.jon != 2 || WriteUrlActivity.this.juF.crC().length() <= 31) {
                            if (!WriteUrlActivity.this.juJ.crx()) {
                                WriteUrlActivity.this.juJ.aSg();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juF.crF() || view == WriteUrlActivity.this.juF.crG()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.juG != null) {
                        WriteUrlActivity.this.juG.cpx();
                    }
                    WriteUrlActivity.this.juI = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.juF.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.juF.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.juF.crH()) {
                    WriteUrlActivity.this.juF.b(WriteUrlActivity.this.juI);
                } else if (view == WriteUrlActivity.this.juF.getVideoContainer()) {
                    if (WriteUrlActivity.this.juI != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.juI.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.juI.videoUrl, WriteUrlActivity.this.juI.videoWidth, WriteUrlActivity.this.juI.videoHeight, WriteUrlActivity.this.juI.jos);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juF.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.juF.crE());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.juF = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.juG = new com.baidu.tieba.write.model.a(getUniqueId());
        this.juG.a(new a.InterfaceC0409a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0409a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.juI = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.juF != null) {
                    if (WriteUrlActivity.this.juI.jon == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fvH, 800L);
                    } else {
                        WriteUrlActivity.this.juF.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jon == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.juJ != null) {
                        WriteUrlActivity.this.juJ.ceX();
                    }
                }
            }
        });
        this.juH = new WriteUrlModel(getPageContext());
        this.juH.aE(getIntent());
        this.juJ = new j(getPageContext(), this.juF, this.juG, this.juH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juF != null) {
            this.juF.onChangeSkinType(i);
        }
        this.juJ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.juF != null && this.juF.crL() != null && this.juF.crL().getVisibility() == 0) {
                this.juF.crI();
                return true;
            } else if (this.juI != null || (this.juF != null && !StringUtils.isNull(this.juF.crC()))) {
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
        this.juJ.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.juJ.destroy();
        if (this.juF != null) {
            this.juF.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
