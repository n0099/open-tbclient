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
    private k juW;
    private com.baidu.tieba.write.model.a juX;
    private WriteUrlModel juY;
    private com.baidu.tieba.write.a.a juZ;
    private j jva;
    private boolean isLoading = false;
    private Runnable fvW = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.juW != null) {
                WriteUrlActivity.this.juW.a(WriteUrlActivity.this.juZ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.juW != null) {
                if (view == WriteUrlActivity.this.juW.bvV()) {
                    if (WriteUrlActivity.this.juW == null || WriteUrlActivity.this.juW.crK() == null || WriteUrlActivity.this.juW.crK().getVisibility() != 0) {
                        if (WriteUrlActivity.this.juZ != null || (WriteUrlActivity.this.juW != null && !StringUtils.isNull(WriteUrlActivity.this.juW.crB()))) {
                            WriteUrlActivity.this.bZG();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.juW.crH();
                } else if (view == WriteUrlActivity.this.juW.crC()) {
                    if (WriteUrlActivity.this.juZ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.juZ.joF != 2 || WriteUrlActivity.this.juW.crB().length() <= 31) {
                            if (!WriteUrlActivity.this.jva.crw()) {
                                WriteUrlActivity.this.jva.aSj();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juW.crE() || view == WriteUrlActivity.this.juW.crF()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.juX != null) {
                        WriteUrlActivity.this.juX.cpw();
                    }
                    WriteUrlActivity.this.juZ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.juW.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.juW.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.juW.crG()) {
                    WriteUrlActivity.this.juW.b(WriteUrlActivity.this.juZ);
                } else if (view == WriteUrlActivity.this.juW.getVideoContainer()) {
                    if (WriteUrlActivity.this.juZ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.juZ.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.juZ.videoUrl, WriteUrlActivity.this.juZ.videoWidth, WriteUrlActivity.this.juZ.videoHeight, WriteUrlActivity.this.juZ.joK);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.juW.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.juW.crD());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.juW = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.juX = new com.baidu.tieba.write.model.a(getUniqueId());
        this.juX.a(new a.InterfaceC0316a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0316a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.juZ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.juW != null) {
                    if (WriteUrlActivity.this.juZ.joF == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fvW, 800L);
                    } else {
                        WriteUrlActivity.this.juW.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.joF == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jva != null) {
                        WriteUrlActivity.this.jva.ceZ();
                    }
                }
            }
        });
        this.juY = new WriteUrlModel(getPageContext());
        this.juY.aE(getIntent());
        this.jva = new j(getPageContext(), this.juW, this.juX, this.juY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juW != null) {
            this.juW.onChangeSkinType(i);
        }
        this.jva.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.juW != null && this.juW.crK() != null && this.juW.crK().getVisibility() == 0) {
                this.juW.crH();
                return true;
            } else if (this.juZ != null || (this.juW != null && !StringUtils.isNull(this.juW.crB()))) {
                bZG();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZG() {
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
        this.jva.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jva.destroy();
        if (this.juW != null) {
            this.juW.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
