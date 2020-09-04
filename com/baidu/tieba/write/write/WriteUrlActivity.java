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
    private m mXh;
    private com.baidu.tieba.write.model.a mXi;
    private WriteUrlModel mXj;
    private com.baidu.tieba.write.a.a mXk;
    private l mXl;
    private boolean isLoading = false;
    private Runnable fJU = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mXh != null) {
                WriteUrlActivity.this.mXh.a(WriteUrlActivity.this.mXk, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mXh != null) {
                if (view == WriteUrlActivity.this.mXh.cIc()) {
                    if (WriteUrlActivity.this.mXh == null || WriteUrlActivity.this.mXh.dJx() == null || WriteUrlActivity.this.mXh.dJx().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mXk != null || (WriteUrlActivity.this.mXh != null && !StringUtils.isNull(WriteUrlActivity.this.mXh.dJo()))) {
                            WriteUrlActivity.this.dri();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mXh.dJu();
                } else if (view == WriteUrlActivity.this.mXh.dJp()) {
                    if (WriteUrlActivity.this.mXk != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mXk.mON != 2 || WriteUrlActivity.this.mXh.dJo().length() <= 31) {
                            if (!WriteUrlActivity.this.mXl.dJj()) {
                                WriteUrlActivity.this.mXl.ccZ();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mXh.dJr() || view == WriteUrlActivity.this.mXh.dJs()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mXi != null) {
                        WriteUrlActivity.this.mXi.dGw();
                    }
                    WriteUrlActivity.this.mXk = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mXh.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mXh.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.mXh.dJt()) {
                    WriteUrlActivity.this.mXh.b(WriteUrlActivity.this.mXk);
                } else if (view == WriteUrlActivity.this.mXh.getVideoContainer()) {
                    if (WriteUrlActivity.this.mXk != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mXk.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mXk.videoUrl, WriteUrlActivity.this.mXk.videoWidth, WriteUrlActivity.this.mXk.videoHeight, WriteUrlActivity.this.mXk.mOS);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mXh.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mXh.dJq());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mXh = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mXi = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mXi.a(new a.InterfaceC0833a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0833a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mXk = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mXh != null) {
                    if (WriteUrlActivity.this.mXk.mON == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fJU, 800L);
                    } else {
                        WriteUrlActivity.this.mXh.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mON == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mXl != null) {
                        WriteUrlActivity.this.mXl.dxq();
                    }
                }
            }
        });
        this.mXj = new WriteUrlModel(getPageContext());
        this.mXj.ax(getIntent());
        this.mXl = new l(getPageContext(), this.mXh, this.mXi, this.mXj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mXh != null) {
            this.mXh.onChangeSkinType(i);
        }
        this.mXl.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mXh != null && this.mXh.dJx() != null && this.mXh.dJx().getVisibility() == 0) {
                this.mXh.dJu();
                return true;
            } else if (this.mXk != null || (this.mXh != null && !StringUtils.isNull(this.mXh.dJo()))) {
                dri();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dri() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nt(R.string.tip_draft_no_publish);
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
        aVar.bhg();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mXl.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mXl.destroy();
        if (this.mXh != null) {
            this.mXh.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
