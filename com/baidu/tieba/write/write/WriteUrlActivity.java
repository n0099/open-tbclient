package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private m nOW;
    private com.baidu.tieba.write.model.a nOX;
    private WriteUrlModel nOY;
    private com.baidu.tieba.write.a.a nOZ;
    private l nPa;
    private boolean isLoading = false;
    private Runnable gpr = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.nOW != null) {
                WriteUrlActivity.this.nOW.a(WriteUrlActivity.this.nOZ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.nOW != null) {
                if (view == WriteUrlActivity.this.nOW.cUY()) {
                    if (WriteUrlActivity.this.nOW == null || WriteUrlActivity.this.nOW.dWP() == null || WriteUrlActivity.this.nOW.dWP().getVisibility() != 0) {
                        if (WriteUrlActivity.this.nOZ != null || (WriteUrlActivity.this.nOW != null && !StringUtils.isNull(WriteUrlActivity.this.nOW.dWG()))) {
                            WriteUrlActivity.this.dEt();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.nOW.dWM();
                } else if (view == WriteUrlActivity.this.nOW.dWH()) {
                    if (WriteUrlActivity.this.nOZ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.nOZ.nGD != 2 || WriteUrlActivity.this.nOW.dWG().length() <= 31) {
                            if (!WriteUrlActivity.this.nPa.dWB()) {
                                WriteUrlActivity.this.nPa.cps();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nOW.dWJ() || view == WriteUrlActivity.this.nOW.dWK()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.nOX != null) {
                        WriteUrlActivity.this.nOX.dTK();
                    }
                    WriteUrlActivity.this.nOZ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.nOW.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.nOW.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.nOW.dWL()) {
                    WriteUrlActivity.this.nOW.b(WriteUrlActivity.this.nOZ);
                } else if (view == WriteUrlActivity.this.nOW.getVideoContainer()) {
                    if (WriteUrlActivity.this.nOZ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.nOZ.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.nOZ.videoUrl, WriteUrlActivity.this.nOZ.videoWidth, WriteUrlActivity.this.nOZ.videoHeight, WriteUrlActivity.this.nOZ.nGI);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nOW.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.nOW.dWI());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nOW = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nOX = new com.baidu.tieba.write.model.a(getUniqueId());
        this.nOX.a(new a.InterfaceC0878a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0878a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.nOZ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.nOW != null) {
                    if (WriteUrlActivity.this.nOZ.nGD == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gpr, 800L);
                    } else {
                        WriteUrlActivity.this.nOW.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.nGD == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.nPa != null) {
                        WriteUrlActivity.this.nPa.dKF();
                    }
                }
            }
        });
        this.nOY = new WriteUrlModel(getPageContext());
        this.nOY.au(getIntent());
        this.nPa = new l(getPageContext(), this.nOW, this.nOX, this.nOY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nOW != null) {
            this.nOW.onChangeSkinType(i);
        }
        this.nPa.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nOW != null && this.nOW.dWP() != null && this.nOW.dWP().getVisibility() == 0) {
                this.nOW.dWM();
                return true;
            } else if (this.nOZ != null || (this.nOW != null && !StringUtils.isNull(this.nOW.dWG()))) {
                dEt();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ow(R.string.tip_draft_no_publish);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.bpc();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nPa.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nPa.destroy();
        if (this.nOW != null) {
            this.nOW.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
