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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k hiC;
    private com.baidu.tieba.write.model.a hiD;
    private WriteUrlModel hiE;
    private com.baidu.tieba.write.a.a hiF;
    private j hiG;
    private boolean isLoading = false;
    private Runnable dqy = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hiC != null) {
                WriteUrlActivity.this.hiC.a(WriteUrlActivity.this.hiF, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && WriteUrlActivity.this.hiC != null) {
                if (view2 == WriteUrlActivity.this.hiC.aGO()) {
                    if (WriteUrlActivity.this.hiC == null || WriteUrlActivity.this.hiC.bEr() == null || WriteUrlActivity.this.hiC.bEr().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hiF != null || (WriteUrlActivity.this.hiC != null && !StringUtils.isNull(WriteUrlActivity.this.hiC.bEi()))) {
                            WriteUrlActivity.this.bmk();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hiC.bEo();
                } else if (view2 == WriteUrlActivity.this.hiC.bEj()) {
                    if (WriteUrlActivity.this.hiF != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            WriteUrlActivity.this.showToast(d.k.neterror);
                        }
                        if (WriteUrlActivity.this.hiF.hcZ != 2 || WriteUrlActivity.this.hiC.bEi().length() <= 31) {
                            if (!WriteUrlActivity.this.hiG.bEd()) {
                                WriteUrlActivity.this.hiG.ahc();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view2 == WriteUrlActivity.this.hiC.bEl() || view2 == WriteUrlActivity.this.hiC.bEm()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hiD != null) {
                        WriteUrlActivity.this.hiD.bCh();
                    }
                    WriteUrlActivity.this.hiF = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hiC.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hiC.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new al("c12167"));
                } else if (view2 == WriteUrlActivity.this.hiC.bEn()) {
                    WriteUrlActivity.this.hiC.b(WriteUrlActivity.this.hiF);
                } else if (view2 == WriteUrlActivity.this.hiC.getVideoContainer()) {
                    if (WriteUrlActivity.this.hiF != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hiF.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.k.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hiF.videoUrl, WriteUrlActivity.this.hiF.videoWidth, WriteUrlActivity.this.hiF.videoHeight, WriteUrlActivity.this.hiF.hde);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view2 == WriteUrlActivity.this.hiC.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hiC.bEk());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hiC = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hiD = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hiD.a(new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0234a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hiF = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hiC != null) {
                    if (WriteUrlActivity.this.hiF.hcZ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dqy, 800L);
                    } else {
                        WriteUrlActivity.this.hiC.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hcZ == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hiG != null) {
                        WriteUrlActivity.this.hiG.bsG();
                    }
                }
            }
        });
        this.hiE = new WriteUrlModel(getPageContext());
        this.hiE.aj(getIntent());
        this.hiG = new j(getPageContext(), this.hiC, this.hiD, this.hiE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hiC != null) {
            this.hiC.onChangeSkinType(i);
        }
        this.hiG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hiC != null && this.hiC.bEr() != null && this.hiC.bEr().getVisibility() == 0) {
                this.hiC.bEo();
                return true;
            } else if (this.hiF != null || (this.hiC != null && !StringUtils.isNull(this.hiC.bEi()))) {
                bmk();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bZ(d.k.tip_draft_no_publish);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.tD();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hiG.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hiG.destroy();
        if (this.hiC != null) {
            this.hiC.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
