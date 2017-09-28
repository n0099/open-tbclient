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
    private d gNS;
    private com.baidu.tieba.write.model.a gNT;
    private WriteUrlModel gNU;
    private com.baidu.tieba.write.a.a gNV;
    private c gNW;
    private boolean isLoading = false;
    private Runnable gNX = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gNS != null) {
                WriteUrlActivity.this.gNS.a(WriteUrlActivity.this.gNV, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aPe = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gNS != null) {
                if (view == WriteUrlActivity.this.gNS.ayX()) {
                    if (WriteUrlActivity.this.gNS == null || WriteUrlActivity.this.gNS.bCf() == null || WriteUrlActivity.this.gNS.bCf().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gNV != null || (WriteUrlActivity.this.gNS != null && !StringUtils.isNull(WriteUrlActivity.this.gNS.bBX()))) {
                            WriteUrlActivity.this.biR();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gNS.bCc();
                } else if (view == WriteUrlActivity.this.gNS.bBY()) {
                    if (WriteUrlActivity.this.gNV != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!j.hh()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gNV.gIp != 2 || WriteUrlActivity.this.gNS.bBX().length() <= 31) {
                            WriteUrlActivity.this.gNW.bBT();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNS.bnW() || view == WriteUrlActivity.this.gNS.bCa()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gNT != null) {
                        WriteUrlActivity.this.gNT.bzT();
                    }
                    WriteUrlActivity.this.gNV = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gNS.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gNS.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gNS.bCb()) {
                    WriteUrlActivity.this.gNS.b(WriteUrlActivity.this.gNV);
                } else if (view == WriteUrlActivity.this.gNS.getVideoContainer()) {
                    if (WriteUrlActivity.this.gNV != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gNV.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gNV.videoUrl, WriteUrlActivity.this.gNV.videoWidth, WriteUrlActivity.this.gNV.videoHeight, WriteUrlActivity.this.gNV.gIu);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNS.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gNS.bBZ());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gNS = new d(this, this.aPe);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gNT = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gNT.a(new a.InterfaceC0137a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0137a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gNV = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gNS != null) {
                    if (WriteUrlActivity.this.gNV.gIp == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gNX, 800L);
                    } else {
                        WriteUrlActivity.this.gNS.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gNU = new WriteUrlModel(getPageContext());
        this.gNU.ah(getIntent());
        this.gNW = new c(getPageContext(), this.gNS, this.gNT, this.gNU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gNS != null) {
            this.gNS.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gNS != null && this.gNS.bCf() != null && this.gNS.bCf().getVisibility() == 0) {
                this.gNS.bCc();
                return true;
            } else if (this.gNV != null || (this.gNS != null && !StringUtils.isNull(this.gNS.bBX()))) {
                biR();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biR() {
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
        this.gNW.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gNW.destroy();
        if (this.gNS != null) {
            this.gNS.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
