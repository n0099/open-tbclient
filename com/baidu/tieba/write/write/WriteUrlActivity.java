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
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k jYn;
    private com.baidu.tieba.write.model.a jYo;
    private WriteUrlModel jYp;
    private com.baidu.tieba.write.a.a jYq;
    private j jYr;
    private boolean isLoading = false;
    private Runnable dvf = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jYn != null) {
                WriteUrlActivity.this.jYn.a(WriteUrlActivity.this.jYq, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jYn != null) {
                if (view == WriteUrlActivity.this.jYn.bHm()) {
                    if (WriteUrlActivity.this.jYn == null || WriteUrlActivity.this.jYn.cEa() == null || WriteUrlActivity.this.jYn.cEa().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jYq != null || (WriteUrlActivity.this.jYn != null && !StringUtils.isNull(WriteUrlActivity.this.jYn.cDR()))) {
                            WriteUrlActivity.this.clG();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jYn.cDX();
                } else if (view == WriteUrlActivity.this.jYn.cDS()) {
                    if (WriteUrlActivity.this.jYq != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jYq.jRY != 2 || WriteUrlActivity.this.jYn.cDR().length() <= 31) {
                            if (!WriteUrlActivity.this.jYr.cDM()) {
                                WriteUrlActivity.this.jYr.bbX();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jYn.cDU() || view == WriteUrlActivity.this.jYn.cDV()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jYo != null) {
                        WriteUrlActivity.this.jYo.cBM();
                    }
                    WriteUrlActivity.this.jYq = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jYn.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jYn.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.jYn.cDW()) {
                    WriteUrlActivity.this.jYn.b(WriteUrlActivity.this.jYq);
                } else if (view == WriteUrlActivity.this.jYn.getVideoContainer()) {
                    if (WriteUrlActivity.this.jYq != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jYq.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jYq.videoUrl, WriteUrlActivity.this.jYq.videoWidth, WriteUrlActivity.this.jYq.videoHeight, WriteUrlActivity.this.jYq.jSd);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jYn.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jYn.cDT());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jYn = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jYo = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jYo.a(new a.InterfaceC0444a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0444a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jYq = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jYn != null) {
                    if (WriteUrlActivity.this.jYq.jRY == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dvf, 800L);
                    } else {
                        WriteUrlActivity.this.jYn.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jRY == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jYr != null) {
                        WriteUrlActivity.this.jYr.crh();
                    }
                }
            }
        });
        this.jYp = new WriteUrlModel(getPageContext());
        this.jYp.aJ(getIntent());
        this.jYr = new j(getPageContext(), this.jYn, this.jYo, this.jYp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jYn != null) {
            this.jYn.onChangeSkinType(i);
        }
        this.jYr.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jYn != null && this.jYn.cEa() != null && this.jYn.cEa().getVisibility() == 0) {
                this.jYn.cDX();
                return true;
            } else if (this.jYq != null || (this.jYn != null && !StringUtils.isNull(this.jYn.cDR()))) {
                clG();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hv(R.string.tip_draft_no_publish);
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
        aVar.agO();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jYr.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jYr.destroy();
        if (this.jYn != null) {
            this.jYn.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
