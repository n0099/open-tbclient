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
/* loaded from: classes13.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k kUI;
    private com.baidu.tieba.write.model.a kUJ;
    private WriteUrlModel kUK;
    private com.baidu.tieba.write.a.a kUL;
    private j kUM;
    private boolean isLoading = false;
    private Runnable erl = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kUI != null) {
                WriteUrlActivity.this.kUI.a(WriteUrlActivity.this.kUL, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kUI != null) {
                if (view == WriteUrlActivity.this.kUI.bXU()) {
                    if (WriteUrlActivity.this.kUI == null || WriteUrlActivity.this.kUI.cXf() == null || WriteUrlActivity.this.kUI.cXf().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kUL != null || (WriteUrlActivity.this.kUI != null && !StringUtils.isNull(WriteUrlActivity.this.kUI.cWW()))) {
                            WriteUrlActivity.this.cGf();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kUI.cXc();
                } else if (view == WriteUrlActivity.this.kUI.cWX()) {
                    if (WriteUrlActivity.this.kUL != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kUL.kOg != 2 || WriteUrlActivity.this.kUI.cWW().length() <= 31) {
                            if (!WriteUrlActivity.this.kUM.cWR()) {
                                WriteUrlActivity.this.kUM.bwg();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUI.cWZ() || view == WriteUrlActivity.this.kUI.cXa()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kUJ != null) {
                        WriteUrlActivity.this.kUJ.cUS();
                    }
                    WriteUrlActivity.this.kUL = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kUI.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kUI.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kUI.cXb()) {
                    WriteUrlActivity.this.kUI.b(WriteUrlActivity.this.kUL);
                } else if (view == WriteUrlActivity.this.kUI.getVideoContainer()) {
                    if (WriteUrlActivity.this.kUL != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kUL.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kUL.videoUrl, WriteUrlActivity.this.kUL.videoWidth, WriteUrlActivity.this.kUL.videoHeight, WriteUrlActivity.this.kUL.kOl);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUI.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kUI.cWY());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kUI = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kUJ = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kUJ.a(new a.InterfaceC0632a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0632a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kUL = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kUI != null) {
                    if (WriteUrlActivity.this.kUL.kOg == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.erl, 800L);
                    } else {
                        WriteUrlActivity.this.kUI.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kOg == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kUM != null) {
                        WriteUrlActivity.this.kUM.cLK();
                    }
                }
            }
        });
        this.kUK = new WriteUrlModel(getPageContext());
        this.kUK.aG(getIntent());
        this.kUM = new j(getPageContext(), this.kUI, this.kUJ, this.kUK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kUI != null) {
            this.kUI.onChangeSkinType(i);
        }
        this.kUM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kUI != null && this.kUI.cXf() != null && this.kUI.cXf().getVisibility() == 0) {
                this.kUI.cXc();
                return true;
            } else if (this.kUL != null || (this.kUI != null && !StringUtils.isNull(this.kUI.cWW()))) {
                cGf();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jW(R.string.tip_draft_no_publish);
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
        aVar.aEC();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kUM.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kUM.destroy();
        if (this.kUI != null) {
            this.kUI.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
