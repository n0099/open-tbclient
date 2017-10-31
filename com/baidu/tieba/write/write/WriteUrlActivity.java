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
    private f gXL;
    private com.baidu.tieba.write.model.a gXM;
    private WriteUrlModel gXN;
    private com.baidu.tieba.write.a.a gXO;
    private e gXP;
    private boolean isLoading = false;
    private Runnable gXQ = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gXL != null) {
                WriteUrlActivity.this.gXL.a(WriteUrlActivity.this.gXO, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gXL != null) {
                if (view == WriteUrlActivity.this.gXL.aBn()) {
                    if (WriteUrlActivity.this.gXL == null || WriteUrlActivity.this.gXL.bFw() == null || WriteUrlActivity.this.gXL.bFw().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gXO != null || (WriteUrlActivity.this.gXL != null && !StringUtils.isNull(WriteUrlActivity.this.gXL.bFo()))) {
                            WriteUrlActivity.this.blS();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gXL.bFt();
                } else if (view == WriteUrlActivity.this.gXL.bFp()) {
                    if (WriteUrlActivity.this.gXO != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!j.hh()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.gXO.gRX != 2 || WriteUrlActivity.this.gXL.bFo().length() <= 31) {
                            if (!WriteUrlActivity.this.gXP.bFk()) {
                                WriteUrlActivity.this.gXP.bFj();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gXL.bqS() || view == WriteUrlActivity.this.gXL.bFr()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gXM != null) {
                        WriteUrlActivity.this.gXM.bDk();
                    }
                    WriteUrlActivity.this.gXO = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gXL.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gXL.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gXL.bFs()) {
                    WriteUrlActivity.this.gXL.b(WriteUrlActivity.this.gXO);
                } else if (view == WriteUrlActivity.this.gXL.getVideoContainer()) {
                    if (WriteUrlActivity.this.gXO != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gXO.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gXO.videoUrl, WriteUrlActivity.this.gXO.videoWidth, WriteUrlActivity.this.gXO.videoHeight, WriteUrlActivity.this.gXO.gSc);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gXL.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gXL.bFq());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gXL = new f(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gXM = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gXM.a(new a.InterfaceC0138a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0138a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gXO = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gXL != null) {
                    if (WriteUrlActivity.this.gXO.gRX == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gXQ, 800L);
                    } else {
                        WriteUrlActivity.this.gXL.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gXN = new WriteUrlModel(getPageContext());
        this.gXN.ah(getIntent());
        this.gXP = new e(getPageContext(), this.gXL, this.gXM, this.gXN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gXL != null) {
            this.gXL.onChangeSkinType(i);
        }
        this.gXP.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gXL != null && this.gXL.bFw() != null && this.gXL.bFw().getVisibility() == 0) {
                this.gXL.bFt();
                return true;
            } else if (this.gXO != null || (this.gXL != null && !StringUtils.isNull(this.gXL.bFo()))) {
                blS();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.j.tip_draft_no_publish);
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
        aVar.th();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gXP.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gXP.destroy();
        if (this.gXL != null) {
            this.gXL.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
