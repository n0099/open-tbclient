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
    private j hmY;
    private com.baidu.tieba.write.model.a hmZ;
    private WriteUrlModel hna;
    private com.baidu.tieba.write.a.a hnb;
    private i hnc;
    private boolean isLoading = false;
    private Runnable hnd = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hmY != null) {
                WriteUrlActivity.this.hmY.a(WriteUrlActivity.this.hnb, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hmY != null) {
                if (view == WriteUrlActivity.this.hmY.aDa()) {
                    if (WriteUrlActivity.this.hmY == null || WriteUrlActivity.this.hmY.bJs() == null || WriteUrlActivity.this.hmY.bJs().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hnb != null || (WriteUrlActivity.this.hmY != null && !StringUtils.isNull(WriteUrlActivity.this.hmY.bJk()))) {
                            WriteUrlActivity.this.boH();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hmY.bJp();
                } else if (view == WriteUrlActivity.this.hmY.bJl()) {
                    if (WriteUrlActivity.this.hnb != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.hh()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hnb.hgL != 2 || WriteUrlActivity.this.hmY.bJk().length() <= 31) {
                            if (!WriteUrlActivity.this.hnc.bJf()) {
                                WriteUrlActivity.this.hnc.bJe();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hmY.btq() || view == WriteUrlActivity.this.hmY.bJn()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hmZ != null) {
                        WriteUrlActivity.this.hmZ.bGO();
                    }
                    WriteUrlActivity.this.hnb = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hmY.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hmY.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hmY.bJo()) {
                    WriteUrlActivity.this.hmY.b(WriteUrlActivity.this.hnb);
                } else if (view == WriteUrlActivity.this.hmY.getVideoContainer()) {
                    if (WriteUrlActivity.this.hnb != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hnb.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hnb.videoUrl, WriteUrlActivity.this.hnb.videoWidth, WriteUrlActivity.this.hnb.videoHeight, WriteUrlActivity.this.hnb.hgQ);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hmY.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hmY.bJm());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hmY = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hmZ = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hmZ.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0156a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hnb = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hmY != null) {
                    if (WriteUrlActivity.this.hnb.hgL == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hnd, 800L);
                    } else {
                        WriteUrlActivity.this.hmY.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hgL == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hnc != null) {
                        WriteUrlActivity.this.hnc.bxF();
                    }
                }
            }
        });
        this.hna = new WriteUrlModel(getPageContext());
        this.hna.am(getIntent());
        this.hnc = new i(getPageContext(), this.hmY, this.hmZ, this.hna);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hmY != null) {
            this.hmY.onChangeSkinType(i);
        }
        this.hnc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hmY != null && this.hmY.bJs() != null && this.hmY.bJs().getVisibility() == 0) {
                this.hmY.bJp();
                return true;
            } else if (this.hnb != null || (this.hmY != null && !StringUtils.isNull(this.hmY.bJk()))) {
                boH();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cd(d.j.tip_draft_no_publish);
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
        this.hnc.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hnc.destroy();
        if (this.hmY != null) {
            this.hmY.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
