package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private d gGt;
    private com.baidu.tieba.write.model.a gGu;
    private WriteUrlModel gGv;
    private com.baidu.tieba.write.a.a gGw;
    private c gGx;
    private boolean isLoading = false;
    private Runnable gGy = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gGt != null) {
                WriteUrlActivity.this.gGt.a(WriteUrlActivity.this.gGw, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aXL = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gGt != null) {
                if (view == WriteUrlActivity.this.gGt.VV()) {
                    if (WriteUrlActivity.this.gGt == null || WriteUrlActivity.this.gGt.bAK() == null || WriteUrlActivity.this.gGt.bAK().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gGw != null || (WriteUrlActivity.this.gGt != null && !StringUtils.isNull(WriteUrlActivity.this.gGt.bAC()))) {
                            WriteUrlActivity.this.bku();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gGt.bAH();
                } else if (view == WriteUrlActivity.this.gGt.bAD()) {
                    if (WriteUrlActivity.this.gGw != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!i.hh()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gGw.gAI != 2 || WriteUrlActivity.this.gGt.bAC().length() <= 31) {
                            WriteUrlActivity.this.gGx.bAy();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gGt.boS() || view == WriteUrlActivity.this.gGt.bAF()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gGu != null) {
                        WriteUrlActivity.this.gGu.byv();
                    }
                    WriteUrlActivity.this.gGw = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gGt.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gGt.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aj("c12167"));
                } else if (view == WriteUrlActivity.this.gGt.bAG()) {
                    WriteUrlActivity.this.gGt.b(WriteUrlActivity.this.gGw);
                } else if (view == WriteUrlActivity.this.gGt.getVideoContainer()) {
                    if (WriteUrlActivity.this.gGw != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gGw.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gGw.videoUrl, WriteUrlActivity.this.gGw.videoWidth, WriteUrlActivity.this.gGw.videoHeight, WriteUrlActivity.this.gGw.gAO);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gGt.getRootView()) {
                    k.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gGt.bAE());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gGt = new d(this, this.aXL);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gGu = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gGu.a(new a.InterfaceC0124a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0124a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gGw = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gGt != null) {
                    if (WriteUrlActivity.this.gGw.gAI == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gGy, 800L);
                    } else {
                        WriteUrlActivity.this.gGt.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gGv = new WriteUrlModel(getPageContext());
        this.gGv.aj(getIntent());
        this.gGx = new c(getPageContext(), this.gGt, this.gGu, this.gGv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGt != null) {
            this.gGt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gGt != null && this.gGt.bAK() != null && this.gGt.bAK().getVisibility() == 0) {
                this.gGt.bAH();
                return true;
            } else if (this.gGw != null || (this.gGt != null && !StringUtils.isNull(this.gGt.bAC()))) {
                bku();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bku() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ca(d.l.tip_draft_no_publish);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.th();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gGx.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gGx.destroy();
        if (this.gGt != null) {
            this.gGt.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
