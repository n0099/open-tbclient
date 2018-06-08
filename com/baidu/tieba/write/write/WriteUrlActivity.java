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
    private k hvB;
    private com.baidu.tieba.write.model.a hvC;
    private WriteUrlModel hvD;
    private com.baidu.tieba.write.a.a hvE;
    private j hvF;
    private boolean isLoading = false;
    private Runnable dAT = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hvB != null) {
                WriteUrlActivity.this.hvB.a(WriteUrlActivity.this.hvE, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hvB != null) {
                if (view == WriteUrlActivity.this.hvB.aLH()) {
                    if (WriteUrlActivity.this.hvB == null || WriteUrlActivity.this.hvB.bJu() == null || WriteUrlActivity.this.hvB.bJu().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hvE != null || (WriteUrlActivity.this.hvB != null && !StringUtils.isNull(WriteUrlActivity.this.hvB.bJl()))) {
                            WriteUrlActivity.this.brh();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hvB.bJr();
                } else if (view == WriteUrlActivity.this.hvB.bJm()) {
                    if (WriteUrlActivity.this.hvE != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            WriteUrlActivity.this.showToast(d.k.neterror);
                        }
                        if (WriteUrlActivity.this.hvE.hpY != 2 || WriteUrlActivity.this.hvB.bJl().length() <= 31) {
                            if (!WriteUrlActivity.this.hvF.bJg()) {
                                WriteUrlActivity.this.hvF.akK();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hvB.bJo() || view == WriteUrlActivity.this.hvB.bJp()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hvC != null) {
                        WriteUrlActivity.this.hvC.bHk();
                    }
                    WriteUrlActivity.this.hvE = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hvB.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hvB.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hvB.bJq()) {
                    WriteUrlActivity.this.hvB.b(WriteUrlActivity.this.hvE);
                } else if (view == WriteUrlActivity.this.hvB.getVideoContainer()) {
                    if (WriteUrlActivity.this.hvE != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hvE.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.k.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hvE.videoUrl, WriteUrlActivity.this.hvE.videoWidth, WriteUrlActivity.this.hvE.videoHeight, WriteUrlActivity.this.hvE.hqd);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hvB.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hvB.bJn());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hvB = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hvC = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hvC.a(new a.InterfaceC0251a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0251a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hvE = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hvB != null) {
                    if (WriteUrlActivity.this.hvE.hpY == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dAT, 800L);
                    } else {
                        WriteUrlActivity.this.hvB.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hpY == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hvF != null) {
                        WriteUrlActivity.this.hvF.bxJ();
                    }
                }
            }
        });
        this.hvD = new WriteUrlModel(getPageContext());
        this.hvD.aj(getIntent());
        this.hvF = new j(getPageContext(), this.hvB, this.hvC, this.hvD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hvB != null) {
            this.hvB.onChangeSkinType(i);
        }
        this.hvF.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hvB != null && this.hvB.bJu() != null && this.hvB.bJu().getVisibility() == 0) {
                this.hvB.bJr();
                return true;
            } else if (this.hvE != null || (this.hvB != null && !StringUtils.isNull(this.hvB.bJl()))) {
                brh();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.k.tip_draft_no_publish);
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
        aVar.xa();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hvF.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hvF.destroy();
        if (this.hvB != null) {
            this.hvB.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
