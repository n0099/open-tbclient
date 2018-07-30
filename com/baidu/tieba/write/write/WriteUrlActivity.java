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
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k hAS;
    private com.baidu.tieba.write.model.a hAT;
    private WriteUrlModel hAU;
    private com.baidu.tieba.write.a.a hAV;
    private j hAW;
    private boolean isLoading = false;
    private Runnable dGR = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hAS != null) {
                WriteUrlActivity.this.hAS.a(WriteUrlActivity.this.hAV, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hAS != null) {
                if (view == WriteUrlActivity.this.hAS.aNn()) {
                    if (WriteUrlActivity.this.hAS == null || WriteUrlActivity.this.hAS.bII() == null || WriteUrlActivity.this.hAS.bII().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hAV != null || (WriteUrlActivity.this.hAS != null && !StringUtils.isNull(WriteUrlActivity.this.hAS.bIz()))) {
                            WriteUrlActivity.this.bql();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hAS.bIF();
                } else if (view == WriteUrlActivity.this.hAS.bIA()) {
                    if (WriteUrlActivity.this.hAV != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hAV.hvo != 2 || WriteUrlActivity.this.hAS.bIz().length() <= 31) {
                            if (!WriteUrlActivity.this.hAW.bIu()) {
                                WriteUrlActivity.this.hAW.akD();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hAS.bIC() || view == WriteUrlActivity.this.hAS.bID()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hAT != null) {
                        WriteUrlActivity.this.hAT.bGw();
                    }
                    WriteUrlActivity.this.hAV = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hAS.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hAS.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.hAS.bIE()) {
                    WriteUrlActivity.this.hAS.b(WriteUrlActivity.this.hAV);
                } else if (view == WriteUrlActivity.this.hAS.getVideoContainer()) {
                    if (WriteUrlActivity.this.hAV != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hAV.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hAV.videoUrl, WriteUrlActivity.this.hAV.videoWidth, WriteUrlActivity.this.hAV.videoHeight, WriteUrlActivity.this.hAV.hvt);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hAS.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hAS.bIB());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hAS = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hAT = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hAT.a(new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0253a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hAV = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hAS != null) {
                    if (WriteUrlActivity.this.hAV.hvo == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dGR, 800L);
                    } else {
                        WriteUrlActivity.this.hAS.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hvo == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hAW != null) {
                        WriteUrlActivity.this.hAW.bwP();
                    }
                }
            }
        });
        this.hAU = new WriteUrlModel(getPageContext());
        this.hAU.aj(getIntent());
        this.hAW = new j(getPageContext(), this.hAS, this.hAT, this.hAU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hAS != null) {
            this.hAS.onChangeSkinType(i);
        }
        this.hAW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hAS != null && this.hAS.bII() != null && this.hAS.bII().getVisibility() == 0) {
                this.hAS.bIF();
                return true;
            } else if (this.hAV != null || (this.hAS != null && !StringUtils.isNull(this.hAS.bIz()))) {
                bql();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bql() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cf(d.j.tip_draft_no_publish);
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
        aVar.xf();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hAW.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hAW.destroy();
        if (this.hAS != null) {
            this.hAS.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
