package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
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
    private d gNR;
    private com.baidu.tieba.write.model.a gNS;
    private WriteUrlModel gNT;
    private com.baidu.tieba.write.a.a gNU;
    private c gNV;
    private boolean isLoading = false;
    private Runnable gNW = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gNR != null) {
                WriteUrlActivity.this.gNR.a(WriteUrlActivity.this.gNU, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aPe = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gNR != null) {
                if (view == WriteUrlActivity.this.gNR.ayX()) {
                    if (WriteUrlActivity.this.gNR == null || WriteUrlActivity.this.gNR.bCe() == null || WriteUrlActivity.this.gNR.bCe().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gNU != null || (WriteUrlActivity.this.gNR != null && !StringUtils.isNull(WriteUrlActivity.this.gNR.bBW()))) {
                            WriteUrlActivity.this.biQ();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gNR.bCb();
                } else if (view == WriteUrlActivity.this.gNR.bBX()) {
                    if (WriteUrlActivity.this.gNU != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!j.hh()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gNU.gIo != 2 || WriteUrlActivity.this.gNR.bBW().length() <= 31) {
                            WriteUrlActivity.this.gNV.bBS();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNR.bnV() || view == WriteUrlActivity.this.gNR.bBZ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gNS != null) {
                        WriteUrlActivity.this.gNS.bzS();
                    }
                    WriteUrlActivity.this.gNU = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gNR.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gNR.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gNR.bCa()) {
                    WriteUrlActivity.this.gNR.b(WriteUrlActivity.this.gNU);
                } else if (view == WriteUrlActivity.this.gNR.getVideoContainer()) {
                    if (WriteUrlActivity.this.gNU != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gNU.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gNU.videoUrl, WriteUrlActivity.this.gNU.videoWidth, WriteUrlActivity.this.gNU.videoHeight, WriteUrlActivity.this.gNU.gIt);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNR.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gNR.bBY());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gNR = new d(this, this.aPe);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gNS = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gNS.a(new a.InterfaceC0137a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0137a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gNU = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gNR != null) {
                    if (WriteUrlActivity.this.gNU.gIo == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gNW, 800L);
                    } else {
                        WriteUrlActivity.this.gNR.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gNT = new WriteUrlModel(getPageContext());
        this.gNT.ah(getIntent());
        this.gNV = new c(getPageContext(), this.gNR, this.gNS, this.gNT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gNR != null) {
            this.gNR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gNR != null && this.gNR.bCe() != null && this.gNR.bCe().getVisibility() == 0) {
                this.gNR.bCb();
                return true;
            } else if (this.gNU != null || (this.gNR != null && !StringUtils.isNull(this.gNR.bBW()))) {
                biQ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cd(d.l.tip_draft_no_publish);
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
        aVar.ti();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gNV.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gNV.destroy();
        if (this.gNR != null) {
            this.gNR.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
