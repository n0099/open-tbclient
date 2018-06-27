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
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k hzK;
    private com.baidu.tieba.write.model.a hzL;
    private WriteUrlModel hzM;
    private com.baidu.tieba.write.a.a hzN;
    private j hzO;
    private boolean isLoading = false;
    private Runnable dEf = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hzK != null) {
                WriteUrlActivity.this.hzK.a(WriteUrlActivity.this.hzN, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hzK != null) {
                if (view == WriteUrlActivity.this.hzK.aMn()) {
                    if (WriteUrlActivity.this.hzK == null || WriteUrlActivity.this.hzK.bJV() == null || WriteUrlActivity.this.hzK.bJV().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hzN != null || (WriteUrlActivity.this.hzK != null && !StringUtils.isNull(WriteUrlActivity.this.hzK.bJM()))) {
                            WriteUrlActivity.this.brI();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hzK.bJS();
                } else if (view == WriteUrlActivity.this.hzK.bJN()) {
                    if (WriteUrlActivity.this.hzN != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            WriteUrlActivity.this.showToast(d.k.neterror);
                        }
                        if (WriteUrlActivity.this.hzN.hui != 2 || WriteUrlActivity.this.hzK.bJM().length() <= 31) {
                            if (!WriteUrlActivity.this.hzO.bJH()) {
                                WriteUrlActivity.this.hzO.ake();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hzK.bJP() || view == WriteUrlActivity.this.hzK.bJQ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hzL != null) {
                        WriteUrlActivity.this.hzL.bHL();
                    }
                    WriteUrlActivity.this.hzN = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hzK.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hzK.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.hzK.bJR()) {
                    WriteUrlActivity.this.hzK.b(WriteUrlActivity.this.hzN);
                } else if (view == WriteUrlActivity.this.hzK.getVideoContainer()) {
                    if (WriteUrlActivity.this.hzN != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hzN.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.k.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hzN.videoUrl, WriteUrlActivity.this.hzN.videoWidth, WriteUrlActivity.this.hzN.videoHeight, WriteUrlActivity.this.hzN.hun);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hzK.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hzK.bJO());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hzK = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hzL = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hzL.a(new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0253a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hzN = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hzK != null) {
                    if (WriteUrlActivity.this.hzN.hui == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dEf, 800L);
                    } else {
                        WriteUrlActivity.this.hzK.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hui == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hzO != null) {
                        WriteUrlActivity.this.hzO.bym();
                    }
                }
            }
        });
        this.hzM = new WriteUrlModel(getPageContext());
        this.hzM.aj(getIntent());
        this.hzO = new j(getPageContext(), this.hzK, this.hzL, this.hzM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hzK != null) {
            this.hzK.onChangeSkinType(i);
        }
        this.hzO.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hzK != null && this.hzK.bJV() != null && this.hzK.bJV().getVisibility() == 0) {
                this.hzK.bJS();
                return true;
            } else if (this.hzN != null || (this.hzK != null && !StringUtils.isNull(this.hzK.bJM()))) {
                brI();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cd(d.k.tip_draft_no_publish);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.xn();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hzO.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hzO.destroy();
        if (this.hzK != null) {
            this.hzK.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
