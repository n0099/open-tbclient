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
/* loaded from: classes10.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k kQi;
    private com.baidu.tieba.write.model.a kQj;
    private WriteUrlModel kQk;
    private com.baidu.tieba.write.a.a kQl;
    private j kQm;
    private boolean isLoading = false;
    private Runnable elO = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kQi != null) {
                WriteUrlActivity.this.kQi.a(WriteUrlActivity.this.kQl, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kQi != null) {
                if (view == WriteUrlActivity.this.kQi.bVh()) {
                    if (WriteUrlActivity.this.kQi == null || WriteUrlActivity.this.kQi.cUJ() == null || WriteUrlActivity.this.kQi.cUJ().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kQl != null || (WriteUrlActivity.this.kQi != null && !StringUtils.isNull(WriteUrlActivity.this.kQi.cUA()))) {
                            WriteUrlActivity.this.cDv();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kQi.cUG();
                } else if (view == WriteUrlActivity.this.kQi.cUB()) {
                    if (WriteUrlActivity.this.kQl != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kQl.kJG != 2 || WriteUrlActivity.this.kQi.cUA().length() <= 31) {
                            if (!WriteUrlActivity.this.kQm.cUv()) {
                                WriteUrlActivity.this.kQm.btx();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kQi.cUD() || view == WriteUrlActivity.this.kQi.cUE()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kQj != null) {
                        WriteUrlActivity.this.kQj.cSw();
                    }
                    WriteUrlActivity.this.kQl = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kQi.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kQi.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kQi.cUF()) {
                    WriteUrlActivity.this.kQi.b(WriteUrlActivity.this.kQl);
                } else if (view == WriteUrlActivity.this.kQi.getVideoContainer()) {
                    if (WriteUrlActivity.this.kQl != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kQl.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kQl.videoUrl, WriteUrlActivity.this.kQl.videoWidth, WriteUrlActivity.this.kQl.videoHeight, WriteUrlActivity.this.kQl.kJL);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kQi.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kQi.cUC());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kQi = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kQj = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kQj.a(new a.InterfaceC0619a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0619a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kQl = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kQi != null) {
                    if (WriteUrlActivity.this.kQl.kJG == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.elO, 800L);
                    } else {
                        WriteUrlActivity.this.kQi.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kJG == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kQm != null) {
                        WriteUrlActivity.this.kQm.cJd();
                    }
                }
            }
        });
        this.kQk = new WriteUrlModel(getPageContext());
        this.kQk.aG(getIntent());
        this.kQm = new j(getPageContext(), this.kQi, this.kQj, this.kQk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kQi != null) {
            this.kQi.onChangeSkinType(i);
        }
        this.kQm.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kQi != null && this.kQi.cUJ() != null && this.kQi.cUJ().getVisibility() == 0) {
                this.kQi.cUG();
                return true;
            } else if (this.kQl != null || (this.kQi != null && !StringUtils.isNull(this.kQi.cUA()))) {
                cDv();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDv() {
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
        aVar.aBW();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kQm.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kQm.destroy();
        if (this.kQi != null) {
            this.kQi.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
