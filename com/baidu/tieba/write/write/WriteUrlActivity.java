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
    private j hMG;
    private com.baidu.tieba.write.model.a hMH;
    private WriteUrlModel hMI;
    private com.baidu.tieba.write.a.a hMJ;
    private i hMK;
    private boolean isLoading = false;
    private Runnable dVH = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hMG != null) {
                WriteUrlActivity.this.hMG.a(WriteUrlActivity.this.hMJ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hMG != null) {
                if (view == WriteUrlActivity.this.hMG.aLO()) {
                    if (WriteUrlActivity.this.hMG == null || WriteUrlActivity.this.hMG.bJz() == null || WriteUrlActivity.this.hMG.bJz().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hMJ != null || (WriteUrlActivity.this.hMG != null && !StringUtils.isNull(WriteUrlActivity.this.hMG.bJq()))) {
                            WriteUrlActivity.this.brb();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hMG.bJw();
                } else if (view == WriteUrlActivity.this.hMG.bJr()) {
                    if (WriteUrlActivity.this.hMJ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hMJ.hGm != 2 || WriteUrlActivity.this.hMG.bJq().length() <= 31) {
                            if (!WriteUrlActivity.this.hMK.bJl()) {
                                WriteUrlActivity.this.hMK.ane();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMG.bJt() || view == WriteUrlActivity.this.hMG.bJu()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hMH != null) {
                        WriteUrlActivity.this.hMH.bGR();
                    }
                    WriteUrlActivity.this.hMJ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hMG.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hMG.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hMG.bJv()) {
                    WriteUrlActivity.this.hMG.b(WriteUrlActivity.this.hMJ);
                } else if (view == WriteUrlActivity.this.hMG.getVideoContainer()) {
                    if (WriteUrlActivity.this.hMJ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hMJ.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hMJ.videoUrl, WriteUrlActivity.this.hMJ.videoWidth, WriteUrlActivity.this.hMJ.videoHeight, WriteUrlActivity.this.hMJ.hGr);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMG.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hMG.bJs());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hMG = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hMH = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hMH.a(new a.InterfaceC0251a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0251a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hMJ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hMG != null) {
                    if (WriteUrlActivity.this.hMJ.hGm == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dVH, 800L);
                    } else {
                        WriteUrlActivity.this.hMG.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hGm == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hMK != null) {
                        WriteUrlActivity.this.hMK.bxC();
                    }
                }
            }
        });
        this.hMI = new WriteUrlModel(getPageContext());
        this.hMI.al(getIntent());
        this.hMK = new i(getPageContext(), this.hMG, this.hMH, this.hMI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMG != null) {
            this.hMG.onChangeSkinType(i);
        }
        this.hMK.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hMG != null && this.hMG.bJz() != null && this.hMG.bJz().getVisibility() == 0) {
                this.hMG.bJw();
                return true;
            } else if (this.hMJ != null || (this.hMG != null && !StringUtils.isNull(this.hMG.bJq()))) {
                brb();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
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
        aVar.AU();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hMK.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hMK.destroy();
        if (this.hMG != null) {
            this.hMG.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
