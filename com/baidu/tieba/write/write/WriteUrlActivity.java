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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private j hVe;
    private com.baidu.tieba.write.model.a hVf;
    private WriteUrlModel hVg;
    private com.baidu.tieba.write.a.a hVh;
    private i hVi;
    private boolean isLoading = false;
    private Runnable hVj = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hVe != null) {
                WriteUrlActivity.this.hVe.a(WriteUrlActivity.this.hVh, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hVe != null) {
                if (view == WriteUrlActivity.this.hVe.aKc()) {
                    if (WriteUrlActivity.this.hVe == null || WriteUrlActivity.this.hVe.bPh() == null || WriteUrlActivity.this.hVe.bPh().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hVh != null || (WriteUrlActivity.this.hVe != null && !StringUtils.isNull(WriteUrlActivity.this.hVe.bOY()))) {
                            WriteUrlActivity.this.bwp();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hVe.bPe();
                } else if (view == WriteUrlActivity.this.hVe.bOZ()) {
                    if (WriteUrlActivity.this.hVh != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hVh.hOM != 2 || WriteUrlActivity.this.hVe.bOY().length() <= 31) {
                            if (!WriteUrlActivity.this.hVi.bOT()) {
                                WriteUrlActivity.this.hVi.bOS();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hVe.bPb() || view == WriteUrlActivity.this.hVe.bPc()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hVf != null) {
                        WriteUrlActivity.this.hVf.bMB();
                    }
                    WriteUrlActivity.this.hVh = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hVe.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hVe.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hVe.bPd()) {
                    WriteUrlActivity.this.hVe.b(WriteUrlActivity.this.hVh);
                } else if (view == WriteUrlActivity.this.hVe.getVideoContainer()) {
                    if (WriteUrlActivity.this.hVh != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hVh.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hVh.videoUrl, WriteUrlActivity.this.hVh.videoWidth, WriteUrlActivity.this.hVh.videoHeight, WriteUrlActivity.this.hVh.hOR);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hVe.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hVe.bPa());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hVe = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hVf = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hVf.a(new a.InterfaceC0169a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0169a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hVh = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hVe != null) {
                    if (WriteUrlActivity.this.hVh.hOM == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hVj, 800L);
                    } else {
                        WriteUrlActivity.this.hVe.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hOM == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hVi != null) {
                        WriteUrlActivity.this.hVi.bCV();
                    }
                }
            }
        });
        this.hVg = new WriteUrlModel(getPageContext());
        this.hVg.an(getIntent());
        this.hVi = new i(getPageContext(), this.hVe, this.hVf, this.hVg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hVe != null) {
            this.hVe.onChangeSkinType(i);
        }
        this.hVi.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hVe != null && this.hVe.bPh() != null && this.hVe.bPh().getVisibility() == 0) {
                this.hVe.bPe();
                return true;
            } else if (this.hVh != null || (this.hVe != null && !StringUtils.isNull(this.hVe.bOY()))) {
                bwp();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.fd(d.j.tip_draft_no_publish);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.AI();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hVi.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hVi.destroy();
        if (this.hVe != null) {
            this.hVe.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
