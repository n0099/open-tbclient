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
    private j hMt;
    private com.baidu.tieba.write.model.a hMu;
    private WriteUrlModel hMv;
    private com.baidu.tieba.write.a.a hMw;
    private i hMx;
    private boolean isLoading = false;
    private Runnable dVv = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hMt != null) {
                WriteUrlActivity.this.hMt.a(WriteUrlActivity.this.hMw, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hMt != null) {
                if (view == WriteUrlActivity.this.hMt.aLN()) {
                    if (WriteUrlActivity.this.hMt == null || WriteUrlActivity.this.hMt.bJy() == null || WriteUrlActivity.this.hMt.bJy().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hMw != null || (WriteUrlActivity.this.hMt != null && !StringUtils.isNull(WriteUrlActivity.this.hMt.bJp()))) {
                            WriteUrlActivity.this.bra();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hMt.bJv();
                } else if (view == WriteUrlActivity.this.hMt.bJq()) {
                    if (WriteUrlActivity.this.hMw != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hMw.hFZ != 2 || WriteUrlActivity.this.hMt.bJp().length() <= 31) {
                            if (!WriteUrlActivity.this.hMx.bJk()) {
                                WriteUrlActivity.this.hMx.and();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMt.bJs() || view == WriteUrlActivity.this.hMt.bJt()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hMu != null) {
                        WriteUrlActivity.this.hMu.bGQ();
                    }
                    WriteUrlActivity.this.hMw = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hMt.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hMt.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hMt.bJu()) {
                    WriteUrlActivity.this.hMt.b(WriteUrlActivity.this.hMw);
                } else if (view == WriteUrlActivity.this.hMt.getVideoContainer()) {
                    if (WriteUrlActivity.this.hMw != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hMw.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hMw.videoUrl, WriteUrlActivity.this.hMw.videoWidth, WriteUrlActivity.this.hMw.videoHeight, WriteUrlActivity.this.hMw.hGe);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hMt.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hMt.bJr());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hMt = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hMu = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hMu.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0252a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hMw = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hMt != null) {
                    if (WriteUrlActivity.this.hMw.hFZ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dVv, 800L);
                    } else {
                        WriteUrlActivity.this.hMt.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hFZ == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hMx != null) {
                        WriteUrlActivity.this.hMx.bxB();
                    }
                }
            }
        });
        this.hMv = new WriteUrlModel(getPageContext());
        this.hMv.al(getIntent());
        this.hMx = new i(getPageContext(), this.hMt, this.hMu, this.hMv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMt != null) {
            this.hMt.onChangeSkinType(i);
        }
        this.hMx.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hMt != null && this.hMt.bJy() != null && this.hMt.bJy().getVisibility() == 0) {
                this.hMt.bJv();
                return true;
            } else if (this.hMw != null || (this.hMt != null && !StringUtils.isNull(this.hMt.bJp()))) {
                bra();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.fb(d.j.tip_draft_no_publish);
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
        aVar.AU();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hMx.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hMx.destroy();
        if (this.hMt != null) {
            this.hMt.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
