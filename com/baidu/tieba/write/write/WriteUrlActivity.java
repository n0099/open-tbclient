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
    private k mDN;
    private com.baidu.tieba.write.model.a mDO;
    private WriteUrlModel mDP;
    private com.baidu.tieba.write.a.a mDQ;
    private j mDR;
    private boolean isLoading = false;
    private Runnable fyy = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mDN != null) {
                WriteUrlActivity.this.mDN.a(WriteUrlActivity.this.mDQ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mDN != null) {
                if (view == WriteUrlActivity.this.mDN.cxk()) {
                    if (WriteUrlActivity.this.mDN == null || WriteUrlActivity.this.mDN.dxz() == null || WriteUrlActivity.this.mDN.dxz().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mDQ != null || (WriteUrlActivity.this.mDN != null && !StringUtils.isNull(WriteUrlActivity.this.mDN.dxq()))) {
                            WriteUrlActivity.this.dfL();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mDN.dxw();
                } else if (view == WriteUrlActivity.this.mDN.dxr()) {
                    if (WriteUrlActivity.this.mDQ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mDQ.mwg != 2 || WriteUrlActivity.this.mDN.dxq().length() <= 31) {
                            if (!WriteUrlActivity.this.mDR.dxl()) {
                                WriteUrlActivity.this.mDR.bSM();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mDN.dxt() || view == WriteUrlActivity.this.mDN.dxu()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mDO != null) {
                        WriteUrlActivity.this.mDO.duQ();
                    }
                    WriteUrlActivity.this.mDQ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mDN.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mDN.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ap("c12167"));
                } else if (view == WriteUrlActivity.this.mDN.dxv()) {
                    WriteUrlActivity.this.mDN.b(WriteUrlActivity.this.mDQ);
                } else if (view == WriteUrlActivity.this.mDN.getVideoContainer()) {
                    if (WriteUrlActivity.this.mDQ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mDQ.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mDQ.videoUrl, WriteUrlActivity.this.mDQ.videoWidth, WriteUrlActivity.this.mDQ.videoHeight, WriteUrlActivity.this.mDQ.mwl);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mDN.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mDN.dxs());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mDN = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mDO = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mDO.a(new a.InterfaceC0780a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0780a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mDQ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mDN != null) {
                    if (WriteUrlActivity.this.mDQ.mwg == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fyy, 800L);
                    } else {
                        WriteUrlActivity.this.mDN.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mwg == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mDR != null) {
                        WriteUrlActivity.this.mDR.dlP();
                    }
                }
            }
        });
        this.mDP = new WriteUrlModel(getPageContext());
        this.mDP.av(getIntent());
        this.mDR = new j(getPageContext(), this.mDN, this.mDO, this.mDP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDN != null) {
            this.mDN.onChangeSkinType(i);
        }
        this.mDR.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mDN != null && this.mDN.dxz() != null && this.mDN.dxz().getVisibility() == 0) {
                this.mDN.dxw();
                return true;
            } else if (this.mDQ != null || (this.mDN != null && !StringUtils.isNull(this.mDN.dxq()))) {
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
        this.mDR.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mDR.destroy();
        if (this.mDN != null) {
            this.mDN.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
