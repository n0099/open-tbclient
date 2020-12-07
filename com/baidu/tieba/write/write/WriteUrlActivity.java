package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private m ofb;
    private com.baidu.tieba.write.model.a ofc;
    private WriteUrlModel ofd;
    private com.baidu.tieba.write.a.a ofe;
    private l ofg;
    private boolean isLoading = false;
    private Runnable gxh = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.ofb != null) {
                WriteUrlActivity.this.ofb.a(WriteUrlActivity.this.ofe, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.ofb != null) {
                if (view == WriteUrlActivity.this.ofb.cZQ()) {
                    if (WriteUrlActivity.this.ofb == null || WriteUrlActivity.this.ofb.ecl() == null || WriteUrlActivity.this.ofb.ecl().getVisibility() != 0) {
                        if (WriteUrlActivity.this.ofe != null || (WriteUrlActivity.this.ofb != null && !StringUtils.isNull(WriteUrlActivity.this.ofb.ecc()))) {
                            WriteUrlActivity.this.dJj();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.ofb.eci();
                } else if (view == WriteUrlActivity.this.ofb.ecd()) {
                    if (WriteUrlActivity.this.ofe != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.ofe.nWk != 2 || WriteUrlActivity.this.ofb.ecc().length() <= 31) {
                            if (!WriteUrlActivity.this.ofg.ebX()) {
                                WriteUrlActivity.this.ofg.cth();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.ofb.ecf() || view == WriteUrlActivity.this.ofb.ecg()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.ofc != null) {
                        WriteUrlActivity.this.ofc.dZd();
                    }
                    WriteUrlActivity.this.ofe = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.ofb.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.ofb.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ar("c12167"));
                } else if (view == WriteUrlActivity.this.ofb.ech()) {
                    WriteUrlActivity.this.ofb.b(WriteUrlActivity.this.ofe);
                } else if (view == WriteUrlActivity.this.ofb.getVideoContainer()) {
                    if (WriteUrlActivity.this.ofe != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.ofe.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.ofe.videoUrl, WriteUrlActivity.this.ofe.videoWidth, WriteUrlActivity.this.ofe.videoHeight, WriteUrlActivity.this.ofe.nWp);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.ofb.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.ofb.ece());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ofb = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ofc = new com.baidu.tieba.write.model.a(getUniqueId());
        this.ofc.a(new a.InterfaceC0897a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0897a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.ofe = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.ofb != null) {
                    if (WriteUrlActivity.this.ofe.nWk == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gxh, 800L);
                    } else {
                        WriteUrlActivity.this.ofb.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.nWk == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.ofg != null) {
                        WriteUrlActivity.this.ofg.dPW();
                    }
                }
            }
        });
        this.ofd = new WriteUrlModel(getPageContext());
        this.ofd.au(getIntent());
        this.ofg = new l(getPageContext(), this.ofb, this.ofc, this.ofd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ofb != null) {
            this.ofb.onChangeSkinType(i);
        }
        this.ofg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ofb != null && this.ofb.ecl() != null && this.ofb.ecl().getVisibility() == 0) {
                this.ofb.eci();
                return true;
            } else if (this.ofe != null || (this.ofb != null && !StringUtils.isNull(this.ofb.ecc()))) {
                dJj();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.oQ(R.string.tip_draft_no_publish);
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
        aVar.brv();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ofg.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ofg.destroy();
        if (this.ofb != null) {
            this.ofb.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
