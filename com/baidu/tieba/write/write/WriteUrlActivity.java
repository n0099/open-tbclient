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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k mDP;
    private com.baidu.tieba.write.model.a mDQ;
    private WriteUrlModel mDR;
    private com.baidu.tieba.write.a.a mDS;
    private j mDT;
    private boolean isLoading = false;
    private Runnable fyy = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mDP != null) {
                WriteUrlActivity.this.mDP.a(WriteUrlActivity.this.mDS, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mDP != null) {
                if (view == WriteUrlActivity.this.mDP.cxk()) {
                    if (WriteUrlActivity.this.mDP == null || WriteUrlActivity.this.mDP.dxA() == null || WriteUrlActivity.this.mDP.dxA().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mDS != null || (WriteUrlActivity.this.mDP != null && !StringUtils.isNull(WriteUrlActivity.this.mDP.dxr()))) {
                            WriteUrlActivity.this.dfL();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mDP.dxx();
                } else if (view == WriteUrlActivity.this.mDP.dxs()) {
                    if (WriteUrlActivity.this.mDS != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mDS.mwi != 2 || WriteUrlActivity.this.mDP.dxr().length() <= 31) {
                            if (!WriteUrlActivity.this.mDT.dxm()) {
                                WriteUrlActivity.this.mDT.bSM();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mDP.dxu() || view == WriteUrlActivity.this.mDP.dxv()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mDQ != null) {
                        WriteUrlActivity.this.mDQ.duR();
                    }
                    WriteUrlActivity.this.mDS = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mDP.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mDP.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ap("c12167"));
                } else if (view == WriteUrlActivity.this.mDP.dxw()) {
                    WriteUrlActivity.this.mDP.b(WriteUrlActivity.this.mDS);
                } else if (view == WriteUrlActivity.this.mDP.getVideoContainer()) {
                    if (WriteUrlActivity.this.mDS != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mDS.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mDS.videoUrl, WriteUrlActivity.this.mDS.videoWidth, WriteUrlActivity.this.mDS.videoHeight, WriteUrlActivity.this.mDS.mwn);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mDP.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mDP.dxt());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mDP = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mDQ = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mDQ.a(new a.InterfaceC0780a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0780a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mDS = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mDP != null) {
                    if (WriteUrlActivity.this.mDS.mwi == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fyy, 800L);
                    } else {
                        WriteUrlActivity.this.mDP.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mwi == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mDT != null) {
                        WriteUrlActivity.this.mDT.dlQ();
                    }
                }
            }
        });
        this.mDR = new WriteUrlModel(getPageContext());
        this.mDR.av(getIntent());
        this.mDT = new j(getPageContext(), this.mDP, this.mDQ, this.mDR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDP != null) {
            this.mDP.onChangeSkinType(i);
        }
        this.mDT.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mDP != null && this.mDP.dxA() != null && this.mDP.dxA().getVisibility() == 0) {
                this.mDP.dxx();
                return true;
            } else if (this.mDS != null || (this.mDP != null && !StringUtils.isNull(this.mDP.dxr()))) {
                dfL();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ln(R.string.tip_draft_no_publish);
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
        aVar.aYL();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mDT.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mDT.destroy();
        if (this.mDP != null) {
            this.mDP.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
