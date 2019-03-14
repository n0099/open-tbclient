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
    private k juO;
    private com.baidu.tieba.write.model.a juP;
    private WriteUrlModel juQ;
    private com.baidu.tieba.write.a.a juR;
    private j juS;
    private boolean isLoading = false;
    private Runnable fvV = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.juO != null) {
                WriteUrlActivity.this.juO.a(WriteUrlActivity.this.juR, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.juO != null) {
                if (view == WriteUrlActivity.this.juO.bvU()) {
                    if (WriteUrlActivity.this.juO == null || WriteUrlActivity.this.juO.crN() == null || WriteUrlActivity.this.juO.crN().getVisibility() != 0) {
                        if (WriteUrlActivity.this.juR != null || (WriteUrlActivity.this.juO != null && !StringUtils.isNull(WriteUrlActivity.this.juO.crE()))) {
                            WriteUrlActivity.this.bZI();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.juO.crK();
                } else if (view == WriteUrlActivity.this.juO.crF()) {
                    if (WriteUrlActivity.this.juR != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.juR.jox != 2 || WriteUrlActivity.this.juO.crE().length() <= 31) {
                            if (!WriteUrlActivity.this.juS.crz()) {
                                WriteUrlActivity.this.juS.aSi();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juO.crH() || view == WriteUrlActivity.this.juO.crI()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.juP != null) {
                        WriteUrlActivity.this.juP.cpz();
                    }
                    WriteUrlActivity.this.juR = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.juO.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.juO.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.juO.crJ()) {
                    WriteUrlActivity.this.juO.b(WriteUrlActivity.this.juR);
                } else if (view == WriteUrlActivity.this.juO.getVideoContainer()) {
                    if (WriteUrlActivity.this.juR != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.juR.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.juR.videoUrl, WriteUrlActivity.this.juR.videoWidth, WriteUrlActivity.this.juR.videoHeight, WriteUrlActivity.this.juR.joC);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juO.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.juO.crG());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.juO = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.juP = new com.baidu.tieba.write.model.a(getUniqueId());
        this.juP.a(new a.InterfaceC0409a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0409a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.juR = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.juO != null) {
                    if (WriteUrlActivity.this.juR.jox == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fvV, 800L);
                    } else {
                        WriteUrlActivity.this.juO.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jox == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.juS != null) {
                        WriteUrlActivity.this.juS.cfb();
                    }
                }
            }
        });
        this.juQ = new WriteUrlModel(getPageContext());
        this.juQ.aE(getIntent());
        this.juS = new j(getPageContext(), this.juO, this.juP, this.juQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juO != null) {
            this.juO.onChangeSkinType(i);
        }
        this.juS.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.juO != null && this.juO.crN() != null && this.juO.crN().getVisibility() == 0) {
                this.juO.crK();
                return true;
            } else if (this.juR != null || (this.juO != null && !StringUtils.isNull(this.juO.crE()))) {
                bZI();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZI() {
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
        this.juS.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.juS.destroy();
        if (this.juO != null) {
            this.juO.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
