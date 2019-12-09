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
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k jVv;
    private com.baidu.tieba.write.model.a jVw;
    private WriteUrlModel jVx;
    private com.baidu.tieba.write.a.a jVy;
    private j jVz;
    private boolean isLoading = false;
    private Runnable dAP = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jVv != null) {
                WriteUrlActivity.this.jVv.a(WriteUrlActivity.this.jVy, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jVv != null) {
                if (view == WriteUrlActivity.this.jVv.bDV()) {
                    if (WriteUrlActivity.this.jVv == null || WriteUrlActivity.this.jVv.cAI() == null || WriteUrlActivity.this.jVv.cAI().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jVy != null || (WriteUrlActivity.this.jVv != null && !StringUtils.isNull(WriteUrlActivity.this.jVv.cAz()))) {
                            WriteUrlActivity.this.cjr();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jVv.cAF();
                } else if (view == WriteUrlActivity.this.jVv.cAA()) {
                    if (WriteUrlActivity.this.jVy != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jVy.jOT != 2 || WriteUrlActivity.this.jVv.cAz().length() <= 31) {
                            if (!WriteUrlActivity.this.jVz.cAu()) {
                                WriteUrlActivity.this.jVz.bca();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jVv.cAC() || view == WriteUrlActivity.this.jVv.cAD()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jVw != null) {
                        WriteUrlActivity.this.jVw.cyu();
                    }
                    WriteUrlActivity.this.jVy = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jVv.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jVv.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.jVv.cAE()) {
                    WriteUrlActivity.this.jVv.b(WriteUrlActivity.this.jVy);
                } else if (view == WriteUrlActivity.this.jVv.getVideoContainer()) {
                    if (WriteUrlActivity.this.jVy != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jVy.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jVy.videoUrl, WriteUrlActivity.this.jVy.videoWidth, WriteUrlActivity.this.jVy.videoHeight, WriteUrlActivity.this.jVy.jOY);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jVv.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jVv.cAB());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jVv = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVw = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jVw.a(new a.InterfaceC0534a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0534a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jVy = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jVv != null) {
                    if (WriteUrlActivity.this.jVy.jOT == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dAP, 800L);
                    } else {
                        WriteUrlActivity.this.jVv.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jOT == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jVz != null) {
                        WriteUrlActivity.this.jVz.coX();
                    }
                }
            }
        });
        this.jVx = new WriteUrlModel(getPageContext());
        this.jVx.aN(getIntent());
        this.jVz = new j(getPageContext(), this.jVv, this.jVw, this.jVx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jVv != null) {
            this.jVv.onChangeSkinType(i);
        }
        this.jVz.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jVv != null && this.jVv.cAI() != null && this.jVv.cAI().getVisibility() == 0) {
                this.jVv.cAF();
                return true;
            } else if (this.jVy != null || (this.jVv != null && !StringUtils.isNull(this.jVv.cAz()))) {
                cjr();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hT(R.string.tip_draft_no_publish);
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
        aVar.akM();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jVz.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jVz.destroy();
        if (this.jVv != null) {
            this.jVv.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
