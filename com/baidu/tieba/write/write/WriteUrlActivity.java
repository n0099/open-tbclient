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
    private k kTJ;
    private com.baidu.tieba.write.model.a kTK;
    private WriteUrlModel kTL;
    private com.baidu.tieba.write.a.a kTM;
    private j kTN;
    private boolean isLoading = false;
    private Runnable emJ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kTJ != null) {
                WriteUrlActivity.this.kTJ.a(WriteUrlActivity.this.kTM, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kTJ != null) {
                if (view == WriteUrlActivity.this.kTJ.bWq()) {
                    if (WriteUrlActivity.this.kTJ == null || WriteUrlActivity.this.kTJ.cVM() == null || WriteUrlActivity.this.kTJ.cVM().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kTM != null || (WriteUrlActivity.this.kTJ != null && !StringUtils.isNull(WriteUrlActivity.this.kTJ.cVD()))) {
                            WriteUrlActivity.this.cEz();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kTJ.cVJ();
                } else if (view == WriteUrlActivity.this.kTJ.cVE()) {
                    if (WriteUrlActivity.this.kTM != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kTM.kNh != 2 || WriteUrlActivity.this.kTJ.cVD().length() <= 31) {
                            if (!WriteUrlActivity.this.kTN.cVy()) {
                                WriteUrlActivity.this.kTN.buz();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kTJ.cVG() || view == WriteUrlActivity.this.kTJ.cVH()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kTK != null) {
                        WriteUrlActivity.this.kTK.cTz();
                    }
                    WriteUrlActivity.this.kTM = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kTJ.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kTJ.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kTJ.cVI()) {
                    WriteUrlActivity.this.kTJ.b(WriteUrlActivity.this.kTM);
                } else if (view == WriteUrlActivity.this.kTJ.getVideoContainer()) {
                    if (WriteUrlActivity.this.kTM != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kTM.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kTM.videoUrl, WriteUrlActivity.this.kTM.videoWidth, WriteUrlActivity.this.kTM.videoHeight, WriteUrlActivity.this.kTM.kNm);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kTJ.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kTJ.cVF());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kTJ = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kTK = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kTK.a(new a.InterfaceC0624a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0624a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kTM = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kTJ != null) {
                    if (WriteUrlActivity.this.kTM.kNh == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.emJ, 800L);
                    } else {
                        WriteUrlActivity.this.kTJ.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kNh == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kTN != null) {
                        WriteUrlActivity.this.kTN.cKh();
                    }
                }
            }
        });
        this.kTL = new WriteUrlModel(getPageContext());
        this.kTL.aG(getIntent());
        this.kTN = new j(getPageContext(), this.kTJ, this.kTK, this.kTL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kTJ != null) {
            this.kTJ.onChangeSkinType(i);
        }
        this.kTN.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kTJ != null && this.kTJ.cVM() != null && this.kTJ.cVM().getVisibility() == 0) {
                this.kTJ.cVJ();
                return true;
            } else if (this.kTM != null || (this.kTJ != null && !StringUtils.isNull(this.kTJ.cVD()))) {
                cEz();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEz() {
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
        this.kTN.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kTN.destroy();
        if (this.kTJ != null) {
            this.kTJ.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
