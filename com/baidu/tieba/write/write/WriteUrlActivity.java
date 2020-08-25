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
    private m mWP;
    private com.baidu.tieba.write.model.a mWQ;
    private WriteUrlModel mWR;
    private com.baidu.tieba.write.a.a mWS;
    private l mWT;
    private boolean isLoading = false;
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mWP != null) {
                WriteUrlActivity.this.mWP.a(WriteUrlActivity.this.mWS, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mWP != null) {
                if (view == WriteUrlActivity.this.mWP.cIb()) {
                    if (WriteUrlActivity.this.mWP == null || WriteUrlActivity.this.mWP.dJo() == null || WriteUrlActivity.this.mWP.dJo().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mWS != null || (WriteUrlActivity.this.mWP != null && !StringUtils.isNull(WriteUrlActivity.this.mWP.dJf()))) {
                            WriteUrlActivity.this.drf();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mWP.dJl();
                } else if (view == WriteUrlActivity.this.mWP.dJg()) {
                    if (WriteUrlActivity.this.mWS != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mWS.mOv != 2 || WriteUrlActivity.this.mWP.dJf().length() <= 31) {
                            if (!WriteUrlActivity.this.mWT.dJa()) {
                                WriteUrlActivity.this.mWT.ccY();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mWP.dJi() || view == WriteUrlActivity.this.mWP.dJj()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mWQ != null) {
                        WriteUrlActivity.this.mWQ.dGn();
                    }
                    WriteUrlActivity.this.mWS = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mWP.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mWP.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.mWP.dJk()) {
                    WriteUrlActivity.this.mWP.b(WriteUrlActivity.this.mWS);
                } else if (view == WriteUrlActivity.this.mWP.getVideoContainer()) {
                    if (WriteUrlActivity.this.mWS != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mWS.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mWS.videoUrl, WriteUrlActivity.this.mWS.videoWidth, WriteUrlActivity.this.mWS.videoHeight, WriteUrlActivity.this.mWS.mOA);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mWP.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mWP.dJh());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mWP = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mWQ = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mWQ.a(new a.InterfaceC0833a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0833a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mWS = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mWP != null) {
                    if (WriteUrlActivity.this.mWS.mOv == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fJQ, 800L);
                    } else {
                        WriteUrlActivity.this.mWP.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mOv == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mWT != null) {
                        WriteUrlActivity.this.mWT.dxl();
                    }
                }
            }
        });
        this.mWR = new WriteUrlModel(getPageContext());
        this.mWR.ax(getIntent());
        this.mWT = new l(getPageContext(), this.mWP, this.mWQ, this.mWR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mWP != null) {
            this.mWP.onChangeSkinType(i);
        }
        this.mWT.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mWP != null && this.mWP.dJo() != null && this.mWP.dJo().getVisibility() == 0) {
                this.mWP.dJl();
                return true;
            } else if (this.mWS != null || (this.mWP != null && !StringUtils.isNull(this.mWP.dJf()))) {
                drf();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drf() {
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
        this.mWT.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mWT.destroy();
        if (this.mWP != null) {
            this.mWP.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
