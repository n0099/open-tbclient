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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private d gIc;
    private com.baidu.tieba.write.model.a gId;
    private WriteUrlModel gIe;
    private com.baidu.tieba.write.a.a gIf;
    private c gIg;
    private boolean isLoading = false;
    private Runnable gIh = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gIc != null) {
                WriteUrlActivity.this.gIc.a(WriteUrlActivity.this.gIf, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aYK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gIc != null) {
                if (view == WriteUrlActivity.this.gIc.Xw()) {
                    if (WriteUrlActivity.this.gIc == null || WriteUrlActivity.this.gIc.bAG() == null || WriteUrlActivity.this.gIc.bAG().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gIf != null || (WriteUrlActivity.this.gIc != null && !StringUtils.isNull(WriteUrlActivity.this.gIc.bAy()))) {
                            WriteUrlActivity.this.bkd();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gIc.bAD();
                } else if (view == WriteUrlActivity.this.gIc.bAz()) {
                    if (WriteUrlActivity.this.gIf != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!i.hi()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gIf.gCz != 2 || WriteUrlActivity.this.gIc.bAy().length() <= 31) {
                            WriteUrlActivity.this.gIg.bAu();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gIc.boQ() || view == WriteUrlActivity.this.gIc.bAB()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gId != null) {
                        WriteUrlActivity.this.gId.byr();
                    }
                    WriteUrlActivity.this.gIf = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gIc.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gIc.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gIc.bAC()) {
                    WriteUrlActivity.this.gIc.b(WriteUrlActivity.this.gIf);
                } else if (view == WriteUrlActivity.this.gIc.getVideoContainer()) {
                    if (WriteUrlActivity.this.gIf != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gIf.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gIf.videoUrl, WriteUrlActivity.this.gIf.videoWidth, WriteUrlActivity.this.gIf.videoHeight, WriteUrlActivity.this.gIf.gCE);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gIc.getRootView()) {
                    k.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gIc.bAA());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gIc = new d(this, this.aYK);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gId = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gId.a(new a.InterfaceC0127a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0127a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gIf = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gIc != null) {
                    if (WriteUrlActivity.this.gIf.gCz == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gIh, 800L);
                    } else {
                        WriteUrlActivity.this.gIc.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gIe = new WriteUrlModel(getPageContext());
        this.gIe.am(getIntent());
        this.gIg = new c(getPageContext(), this.gIc, this.gId, this.gIe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIc != null) {
            this.gIc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gIc != null && this.gIc.bAG() != null && this.gIc.bAG().getVisibility() == 0) {
                this.gIc.bAD();
                return true;
            } else if (this.gIf != null || (this.gIc != null && !StringUtils.isNull(this.gIc.bAy()))) {
                bkd();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkd() {
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
        aVar.to();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gIg.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gIg.destroy();
        if (this.gIc != null) {
            this.gIc.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
