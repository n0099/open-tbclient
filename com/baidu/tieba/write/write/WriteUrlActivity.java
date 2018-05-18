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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k hjG;
    private com.baidu.tieba.write.model.a hjH;
    private WriteUrlModel hjI;
    private com.baidu.tieba.write.a.a hjJ;
    private j hjK;
    private boolean isLoading = false;
    private Runnable drG = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hjG != null) {
                WriteUrlActivity.this.hjG.a(WriteUrlActivity.this.hjJ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && WriteUrlActivity.this.hjG != null) {
                if (view2 == WriteUrlActivity.this.hjG.aGM()) {
                    if (WriteUrlActivity.this.hjG == null || WriteUrlActivity.this.hjG.bEp() == null || WriteUrlActivity.this.hjG.bEp().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hjJ != null || (WriteUrlActivity.this.hjG != null && !StringUtils.isNull(WriteUrlActivity.this.hjG.bEg()))) {
                            WriteUrlActivity.this.bmj();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hjG.bEm();
                } else if (view2 == WriteUrlActivity.this.hjG.bEh()) {
                    if (WriteUrlActivity.this.hjJ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            WriteUrlActivity.this.showToast(d.k.neterror);
                        }
                        if (WriteUrlActivity.this.hjJ.hed != 2 || WriteUrlActivity.this.hjG.bEg().length() <= 31) {
                            if (!WriteUrlActivity.this.hjK.bEb()) {
                                WriteUrlActivity.this.hjK.ahc();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view2 == WriteUrlActivity.this.hjG.bEj() || view2 == WriteUrlActivity.this.hjG.bEk()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hjH != null) {
                        WriteUrlActivity.this.hjH.bCf();
                    }
                    WriteUrlActivity.this.hjJ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hjG.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hjG.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new al("c12167"));
                } else if (view2 == WriteUrlActivity.this.hjG.bEl()) {
                    WriteUrlActivity.this.hjG.b(WriteUrlActivity.this.hjJ);
                } else if (view2 == WriteUrlActivity.this.hjG.getVideoContainer()) {
                    if (WriteUrlActivity.this.hjJ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hjJ.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.k.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hjJ.videoUrl, WriteUrlActivity.this.hjJ.videoWidth, WriteUrlActivity.this.hjJ.videoHeight, WriteUrlActivity.this.hjJ.hei);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.k.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.k.tip_no_data_to_publish);
                } else if (view2 == WriteUrlActivity.this.hjG.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hjG.bEi());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hjG = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hjH = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hjH.a(new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0234a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hjJ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hjG != null) {
                    if (WriteUrlActivity.this.hjJ.hed == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.drG, 800L);
                    } else {
                        WriteUrlActivity.this.hjG.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hed == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hjK != null) {
                        WriteUrlActivity.this.hjK.bsE();
                    }
                }
            }
        });
        this.hjI = new WriteUrlModel(getPageContext());
        this.hjI.aj(getIntent());
        this.hjK = new j(getPageContext(), this.hjG, this.hjH, this.hjI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hjG != null) {
            this.hjG.onChangeSkinType(i);
        }
        this.hjK.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hjG != null && this.hjG.bEp() != null && this.hjG.bEp().getVisibility() == 0) {
                this.hjG.bEm();
                return true;
            } else if (this.hjJ != null || (this.hjG != null && !StringUtils.isNull(this.hjG.bEg()))) {
                bmj();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ca(d.k.tip_draft_no_publish);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.tC();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hjK.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hjK.destroy();
        if (this.hjG != null) {
            this.hjG.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
