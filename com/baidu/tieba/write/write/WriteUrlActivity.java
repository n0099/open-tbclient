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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private com.baidu.tieba.write.model.a nQA;
    private WriteUrlModel nQB;
    private com.baidu.tieba.write.a.a nQC;
    private l nQD;
    private m nQz;
    private boolean isLoading = false;
    private Runnable goY = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.nQz != null) {
                WriteUrlActivity.this.nQz.a(WriteUrlActivity.this.nQC, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.nQz != null) {
                if (view == WriteUrlActivity.this.nQz.cUE()) {
                    if (WriteUrlActivity.this.nQz == null || WriteUrlActivity.this.nQz.dWO() == null || WriteUrlActivity.this.nQz.dWO().getVisibility() != 0) {
                        if (WriteUrlActivity.this.nQC != null || (WriteUrlActivity.this.nQz != null && !StringUtils.isNull(WriteUrlActivity.this.nQz.dWF()))) {
                            WriteUrlActivity.this.dDY();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.nQz.dWL();
                } else if (view == WriteUrlActivity.this.nQz.dWG()) {
                    if (WriteUrlActivity.this.nQC != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.nQC.nIe != 2 || WriteUrlActivity.this.nQz.dWF().length() <= 31) {
                            if (!WriteUrlActivity.this.nQD.dWA()) {
                                WriteUrlActivity.this.nQD.coT();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nQz.dWI() || view == WriteUrlActivity.this.nQz.dWJ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.nQA != null) {
                        WriteUrlActivity.this.nQA.dTJ();
                    }
                    WriteUrlActivity.this.nQC = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.nQz.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.nQz.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ar("c12167"));
                } else if (view == WriteUrlActivity.this.nQz.dWK()) {
                    WriteUrlActivity.this.nQz.b(WriteUrlActivity.this.nQC);
                } else if (view == WriteUrlActivity.this.nQz.getVideoContainer()) {
                    if (WriteUrlActivity.this.nQC != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.nQC.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.nQC.videoUrl, WriteUrlActivity.this.nQC.videoWidth, WriteUrlActivity.this.nQC.videoHeight, WriteUrlActivity.this.nQC.nIj);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nQz.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.nQz.dWH());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nQz = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nQA = new com.baidu.tieba.write.model.a(getUniqueId());
        this.nQA.a(new a.InterfaceC0881a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0881a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.nQC = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.nQz != null) {
                    if (WriteUrlActivity.this.nQC.nIe == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.goY, 800L);
                    } else {
                        WriteUrlActivity.this.nQz.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.nIe == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.nQD != null) {
                        WriteUrlActivity.this.nQD.dKE();
                    }
                }
            }
        });
        this.nQB = new WriteUrlModel(getPageContext());
        this.nQB.au(getIntent());
        this.nQD = new l(getPageContext(), this.nQz, this.nQA, this.nQB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nQz != null) {
            this.nQz.onChangeSkinType(i);
        }
        this.nQD.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nQz != null && this.nQz.dWO() != null && this.nQz.dWO().getVisibility() == 0) {
                this.nQz.dWL();
                return true;
            } else if (this.nQC != null || (this.nQz != null && !StringUtils.isNull(this.nQz.dWF()))) {
                dDY();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.os(R.string.tip_draft_no_publish);
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
        aVar.bog();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nQD.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nQD.destroy();
        if (this.nQz != null) {
            this.nQz.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
