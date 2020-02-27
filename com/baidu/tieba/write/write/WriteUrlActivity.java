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
    private k kUu;
    private com.baidu.tieba.write.model.a kUv;
    private WriteUrlModel kUw;
    private com.baidu.tieba.write.a.a kUx;
    private j kUy;
    private boolean isLoading = false;
    private Runnable eqX = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kUu != null) {
                WriteUrlActivity.this.kUu.a(WriteUrlActivity.this.kUx, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kUu != null) {
                if (view == WriteUrlActivity.this.kUu.bXR()) {
                    if (WriteUrlActivity.this.kUu == null || WriteUrlActivity.this.kUu.cXc() == null || WriteUrlActivity.this.kUu.cXc().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kUx != null || (WriteUrlActivity.this.kUu != null && !StringUtils.isNull(WriteUrlActivity.this.kUu.cWT()))) {
                            WriteUrlActivity.this.cGc();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kUu.cWZ();
                } else if (view == WriteUrlActivity.this.kUu.cWU()) {
                    if (WriteUrlActivity.this.kUx != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kUx.kNS != 2 || WriteUrlActivity.this.kUu.cWT().length() <= 31) {
                            if (!WriteUrlActivity.this.kUy.cWO()) {
                                WriteUrlActivity.this.kUy.bwd();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUu.cWW() || view == WriteUrlActivity.this.kUu.cWX()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kUv != null) {
                        WriteUrlActivity.this.kUv.cUP();
                    }
                    WriteUrlActivity.this.kUx = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kUu.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kUu.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kUu.cWY()) {
                    WriteUrlActivity.this.kUu.b(WriteUrlActivity.this.kUx);
                } else if (view == WriteUrlActivity.this.kUu.getVideoContainer()) {
                    if (WriteUrlActivity.this.kUx != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kUx.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kUx.videoUrl, WriteUrlActivity.this.kUx.videoWidth, WriteUrlActivity.this.kUx.videoHeight, WriteUrlActivity.this.kUx.kNX);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUu.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kUu.cWV());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kUu = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kUv = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kUv.a(new a.InterfaceC0632a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0632a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kUx = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kUu != null) {
                    if (WriteUrlActivity.this.kUx.kNS == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.eqX, 800L);
                    } else {
                        WriteUrlActivity.this.kUu.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kNS == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kUy != null) {
                        WriteUrlActivity.this.kUy.cLH();
                    }
                }
            }
        });
        this.kUw = new WriteUrlModel(getPageContext());
        this.kUw.aG(getIntent());
        this.kUy = new j(getPageContext(), this.kUu, this.kUv, this.kUw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kUu != null) {
            this.kUu.onChangeSkinType(i);
        }
        this.kUy.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kUu != null && this.kUu.cXc() != null && this.kUu.cXc().getVisibility() == 0) {
                this.kUu.cWZ();
                return true;
            } else if (this.kUx != null || (this.kUu != null && !StringUtils.isNull(this.kUu.cWT()))) {
                cGc();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGc() {
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
        aVar.aEA();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kUy.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kUy.destroy();
        if (this.kUu != null) {
            this.kUu.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
