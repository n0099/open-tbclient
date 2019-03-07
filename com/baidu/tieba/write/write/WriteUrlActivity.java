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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k juD;
    private com.baidu.tieba.write.model.a juE;
    private WriteUrlModel juF;
    private com.baidu.tieba.write.a.a juG;
    private j juH;
    private boolean isLoading = false;
    private Runnable fvW = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.juD != null) {
                WriteUrlActivity.this.juD.a(WriteUrlActivity.this.juG, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.juD != null) {
                if (view == WriteUrlActivity.this.juD.bvU()) {
                    if (WriteUrlActivity.this.juD == null || WriteUrlActivity.this.juD.crA() == null || WriteUrlActivity.this.juD.crA().getVisibility() != 0) {
                        if (WriteUrlActivity.this.juG != null || (WriteUrlActivity.this.juD != null && !StringUtils.isNull(WriteUrlActivity.this.juD.crr()))) {
                            WriteUrlActivity.this.bZF();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.juD.crx();
                } else if (view == WriteUrlActivity.this.juD.crs()) {
                    if (WriteUrlActivity.this.juG != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.juG.jom != 2 || WriteUrlActivity.this.juD.crr().length() <= 31) {
                            if (!WriteUrlActivity.this.juH.crm()) {
                                WriteUrlActivity.this.juH.aSi();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juD.cru() || view == WriteUrlActivity.this.juD.crv()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.juE != null) {
                        WriteUrlActivity.this.juE.cpm();
                    }
                    WriteUrlActivity.this.juG = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.juD.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.juD.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.juD.crw()) {
                    WriteUrlActivity.this.juD.b(WriteUrlActivity.this.juG);
                } else if (view == WriteUrlActivity.this.juD.getVideoContainer()) {
                    if (WriteUrlActivity.this.juG != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.juG.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.juG.videoUrl, WriteUrlActivity.this.juG.videoWidth, WriteUrlActivity.this.juG.videoHeight, WriteUrlActivity.this.juG.jor);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juD.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.juD.crt());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.juD = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.juE = new com.baidu.tieba.write.model.a(getUniqueId());
        this.juE.a(new a.InterfaceC0313a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0313a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.juG = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.juD != null) {
                    if (WriteUrlActivity.this.juG.jom == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fvW, 800L);
                    } else {
                        WriteUrlActivity.this.juD.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jom == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.juH != null) {
                        WriteUrlActivity.this.juH.ceY();
                    }
                }
            }
        });
        this.juF = new WriteUrlModel(getPageContext());
        this.juF.aE(getIntent());
        this.juH = new j(getPageContext(), this.juD, this.juE, this.juF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juD != null) {
            this.juD.onChangeSkinType(i);
        }
        this.juH.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.juD != null && this.juD.crA() != null && this.juD.crA().getVisibility() == 0) {
                this.juD.crx();
                return true;
            } else if (this.juG != null || (this.juD != null && !StringUtils.isNull(this.juD.crr()))) {
                bZF();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.gD(d.j.tip_draft_no_publish);
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
        aVar.aaZ();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.juH.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.juH.destroy();
        if (this.juD != null) {
            this.juD.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
