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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes11.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k kTO;
    private com.baidu.tieba.write.model.a kTP;
    private WriteUrlModel kTQ;
    private com.baidu.tieba.write.a.a kTR;
    private j kTS;
    private boolean isLoading = false;
    private Runnable emJ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kTO != null) {
                WriteUrlActivity.this.kTO.a(WriteUrlActivity.this.kTR, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kTO != null) {
                if (view == WriteUrlActivity.this.kTO.bWq()) {
                    if (WriteUrlActivity.this.kTO == null || WriteUrlActivity.this.kTO.cVO() == null || WriteUrlActivity.this.kTO.cVO().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kTR != null || (WriteUrlActivity.this.kTO != null && !StringUtils.isNull(WriteUrlActivity.this.kTO.cVF()))) {
                            WriteUrlActivity.this.cEB();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kTO.cVL();
                } else if (view == WriteUrlActivity.this.kTO.cVG()) {
                    if (WriteUrlActivity.this.kTR != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kTR.kNm != 2 || WriteUrlActivity.this.kTO.cVF().length() <= 31) {
                            if (!WriteUrlActivity.this.kTS.cVA()) {
                                WriteUrlActivity.this.kTS.buz();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kTO.cVI() || view == WriteUrlActivity.this.kTO.cVJ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kTP != null) {
                        WriteUrlActivity.this.kTP.cTB();
                    }
                    WriteUrlActivity.this.kTR = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kTO.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kTO.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kTO.cVK()) {
                    WriteUrlActivity.this.kTO.b(WriteUrlActivity.this.kTR);
                } else if (view == WriteUrlActivity.this.kTO.getVideoContainer()) {
                    if (WriteUrlActivity.this.kTR != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kTR.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kTR.videoUrl, WriteUrlActivity.this.kTR.videoWidth, WriteUrlActivity.this.kTR.videoHeight, WriteUrlActivity.this.kTR.kNr);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kTO.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kTO.cVH());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kTO = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kTP = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kTP.a(new a.InterfaceC0624a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0624a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kTR = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kTO != null) {
                    if (WriteUrlActivity.this.kTR.kNm == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.emJ, 800L);
                    } else {
                        WriteUrlActivity.this.kTO.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kNm == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kTS != null) {
                        WriteUrlActivity.this.kTS.cKj();
                    }
                }
            }
        });
        this.kTQ = new WriteUrlModel(getPageContext());
        this.kTQ.aG(getIntent());
        this.kTS = new j(getPageContext(), this.kTO, this.kTP, this.kTQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kTO != null) {
            this.kTO.onChangeSkinType(i);
        }
        this.kTS.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kTO != null && this.kTO.cVO() != null && this.kTO.cVO().getVisibility() == 0) {
                this.kTO.cVL();
                return true;
            } else if (this.kTR != null || (this.kTO != null && !StringUtils.isNull(this.kTO.cVF()))) {
                cEB();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jF(R.string.tip_draft_no_publish);
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
        aVar.aCp();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kTS.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kTS.destroy();
        if (this.kTO != null) {
            this.kTO.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
