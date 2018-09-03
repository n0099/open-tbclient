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
import com.baidu.tieba.f;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k hAU;
    private com.baidu.tieba.write.model.a hAV;
    private WriteUrlModel hAW;
    private com.baidu.tieba.write.a.a hAX;
    private j hAY;
    private boolean isLoading = false;
    private Runnable dGN = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hAU != null) {
                WriteUrlActivity.this.hAU.a(WriteUrlActivity.this.hAX, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hAU != null) {
                if (view == WriteUrlActivity.this.hAU.aNk()) {
                    if (WriteUrlActivity.this.hAU == null || WriteUrlActivity.this.hAU.bIM() == null || WriteUrlActivity.this.hAU.bIM().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hAX != null || (WriteUrlActivity.this.hAU != null && !StringUtils.isNull(WriteUrlActivity.this.hAU.bID()))) {
                            WriteUrlActivity.this.bqm();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hAU.bIJ();
                } else if (view == WriteUrlActivity.this.hAU.bIE()) {
                    if (WriteUrlActivity.this.hAX != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(f.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            WriteUrlActivity.this.showToast(f.j.neterror);
                        }
                        if (WriteUrlActivity.this.hAX.hvq != 2 || WriteUrlActivity.this.hAU.bID().length() <= 31) {
                            if (!WriteUrlActivity.this.hAY.bIy()) {
                                WriteUrlActivity.this.hAY.akF();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(f.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(f.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hAU.bIG() || view == WriteUrlActivity.this.hAU.bIH()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hAV != null) {
                        WriteUrlActivity.this.hAV.bGA();
                    }
                    WriteUrlActivity.this.hAX = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hAU.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hAU.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.hAU.bII()) {
                    WriteUrlActivity.this.hAU.b(WriteUrlActivity.this.hAX);
                } else if (view == WriteUrlActivity.this.hAU.getVideoContainer()) {
                    if (WriteUrlActivity.this.hAX != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hAX.videoUrl)) {
                                WriteUrlActivity.this.showToast(f.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hAX.videoUrl, WriteUrlActivity.this.hAX.videoWidth, WriteUrlActivity.this.hAX.videoHeight, WriteUrlActivity.this.hAX.hvv);
                            return;
                        }
                        WriteUrlActivity.this.showToast(f.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(f.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hAU.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hAU.bIF());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hAU = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hAV = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hAV.a(new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0253a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hAX = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hAU != null) {
                    if (WriteUrlActivity.this.hAX.hvq == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dGN, 800L);
                    } else {
                        WriteUrlActivity.this.hAU.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hvq == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hAY != null) {
                        WriteUrlActivity.this.hAY.bwQ();
                    }
                }
            }
        });
        this.hAW = new WriteUrlModel(getPageContext());
        this.hAW.aj(getIntent());
        this.hAY = new j(getPageContext(), this.hAU, this.hAV, this.hAW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hAU != null) {
            this.hAU.onChangeSkinType(i);
        }
        this.hAY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hAU != null && this.hAU.bIM() != null && this.hAU.bIM().getVisibility() == 0) {
                this.hAU.bIJ();
                return true;
            } else if (this.hAX != null || (this.hAU != null && !StringUtils.isNull(this.hAU.bID()))) {
                bqm();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cf(f.j.tip_draft_no_publish);
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.xe();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hAY.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hAY.destroy();
        if (this.hAU != null) {
            this.hAU.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(f.a.activity_open_from_bottom, f.a.activity_close_from_top);
    }
}
