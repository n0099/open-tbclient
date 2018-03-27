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
    private j hMR;
    private com.baidu.tieba.write.model.a hMS;
    private WriteUrlModel hMT;
    private com.baidu.tieba.write.a.a hMU;
    private i hMV;
    private boolean isLoading = false;
    private Runnable dVB = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hMR != null) {
                WriteUrlActivity.this.hMR.a(WriteUrlActivity.this.hMU, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hMR != null) {
                if (view == WriteUrlActivity.this.hMR.aLO()) {
                    if (WriteUrlActivity.this.hMR == null || WriteUrlActivity.this.hMR.bJD() == null || WriteUrlActivity.this.hMR.bJD().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hMU != null || (WriteUrlActivity.this.hMR != null && !StringUtils.isNull(WriteUrlActivity.this.hMR.bJu()))) {
                            WriteUrlActivity.this.brb();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hMR.bJA();
                } else if (view == WriteUrlActivity.this.hMR.bJv()) {
                    if (WriteUrlActivity.this.hMU != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hMU.hGx != 2 || WriteUrlActivity.this.hMR.bJu().length() <= 31) {
                            if (!WriteUrlActivity.this.hMV.bJp()) {
                                WriteUrlActivity.this.hMV.ane();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMR.bJx() || view == WriteUrlActivity.this.hMR.bJy()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hMS != null) {
                        WriteUrlActivity.this.hMS.bGV();
                    }
                    WriteUrlActivity.this.hMU = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hMR.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hMR.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hMR.bJz()) {
                    WriteUrlActivity.this.hMR.b(WriteUrlActivity.this.hMU);
                } else if (view == WriteUrlActivity.this.hMR.getVideoContainer()) {
                    if (WriteUrlActivity.this.hMU != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hMU.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hMU.videoUrl, WriteUrlActivity.this.hMU.videoWidth, WriteUrlActivity.this.hMU.videoHeight, WriteUrlActivity.this.hMU.hGC);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMR.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hMR.bJw());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hMR = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hMS = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hMS.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0252a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hMU = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hMR != null) {
                    if (WriteUrlActivity.this.hMU.hGx == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dVB, 800L);
                    } else {
                        WriteUrlActivity.this.hMR.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hGx == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hMV != null) {
                        WriteUrlActivity.this.hMV.bxG();
                    }
                }
            }
        });
        this.hMT = new WriteUrlModel(getPageContext());
        this.hMT.al(getIntent());
        this.hMV = new i(getPageContext(), this.hMR, this.hMS, this.hMT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMR != null) {
            this.hMR.onChangeSkinType(i);
        }
        this.hMV.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hMR != null && this.hMR.bJD() != null && this.hMR.bJD().getVisibility() == 0) {
                this.hMR.bJA();
                return true;
            } else if (this.hMU != null || (this.hMR != null && !StringUtils.isNull(this.hMR.bJu()))) {
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
        aVar.AV();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hMV.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hMV.destroy();
        if (this.hMR != null) {
            this.hMR.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
