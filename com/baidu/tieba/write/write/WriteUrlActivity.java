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
    private d gNC;
    private com.baidu.tieba.write.model.a gND;
    private WriteUrlModel gNE;
    private com.baidu.tieba.write.a.a gNF;
    private c gNG;
    private boolean isLoading = false;
    private Runnable gNH = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gNC != null) {
                WriteUrlActivity.this.gNC.a(WriteUrlActivity.this.gNF, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aOR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gNC != null) {
                if (view == WriteUrlActivity.this.gNC.ayS()) {
                    if (WriteUrlActivity.this.gNC == null || WriteUrlActivity.this.gNC.bBY() == null || WriteUrlActivity.this.gNC.bBY().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gNF != null || (WriteUrlActivity.this.gNC != null && !StringUtils.isNull(WriteUrlActivity.this.gNC.bBQ()))) {
                            WriteUrlActivity.this.biL();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gNC.bBV();
                } else if (view == WriteUrlActivity.this.gNC.bBR()) {
                    if (WriteUrlActivity.this.gNF != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!j.hh()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gNF.gHZ != 2 || WriteUrlActivity.this.gNC.bBQ().length() <= 31) {
                            WriteUrlActivity.this.gNG.bBM();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNC.bnO() || view == WriteUrlActivity.this.gNC.bBT()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gND != null) {
                        WriteUrlActivity.this.gND.bzM();
                    }
                    WriteUrlActivity.this.gNF = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gNC.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gNC.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gNC.bBU()) {
                    WriteUrlActivity.this.gNC.b(WriteUrlActivity.this.gNF);
                } else if (view == WriteUrlActivity.this.gNC.getVideoContainer()) {
                    if (WriteUrlActivity.this.gNF != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gNF.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gNF.videoUrl, WriteUrlActivity.this.gNF.videoWidth, WriteUrlActivity.this.gNF.videoHeight, WriteUrlActivity.this.gNF.gIe);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gNC.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gNC.bBS());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gNC = new d(this, this.aOR);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gND = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gND.a(new a.InterfaceC0137a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0137a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gNF = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gNC != null) {
                    if (WriteUrlActivity.this.gNF.gHZ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gNH, 800L);
                    } else {
                        WriteUrlActivity.this.gNC.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gNE = new WriteUrlModel(getPageContext());
        this.gNE.ah(getIntent());
        this.gNG = new c(getPageContext(), this.gNC, this.gND, this.gNE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gNC != null) {
            this.gNC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gNC != null && this.gNC.bBY() != null && this.gNC.bBY().getVisibility() == 0) {
                this.gNC.bBV();
                return true;
            } else if (this.gNF != null || (this.gNC != null && !StringUtils.isNull(this.gNC.bBQ()))) {
                biL();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.l.tip_draft_no_publish);
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
        aVar.tb();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gNG.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gNG.destroy();
        if (this.gNC != null) {
            this.gNC.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
