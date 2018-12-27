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
import com.baidu.tieba.e;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k icJ;
    private com.baidu.tieba.write.model.a icK;
    private WriteUrlModel icL;
    private com.baidu.tieba.write.a.a icM;
    private j icN;
    private boolean isLoading = false;
    private Runnable egr = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.icJ != null) {
                WriteUrlActivity.this.icJ.a(WriteUrlActivity.this.icM, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.icJ != null) {
                if (view == WriteUrlActivity.this.icJ.aUP()) {
                    if (WriteUrlActivity.this.icJ == null || WriteUrlActivity.this.icJ.bRj() == null || WriteUrlActivity.this.icJ.bRj().getVisibility() != 0) {
                        if (WriteUrlActivity.this.icM != null || (WriteUrlActivity.this.icJ != null && !StringUtils.isNull(WriteUrlActivity.this.icJ.bRa()))) {
                            WriteUrlActivity.this.byi();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.icJ.bRg();
                } else if (view == WriteUrlActivity.this.icJ.bRb()) {
                    if (WriteUrlActivity.this.icM != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.icM.hWF != 2 || WriteUrlActivity.this.icJ.bRa().length() <= 31) {
                            if (!WriteUrlActivity.this.icN.bQV()) {
                                WriteUrlActivity.this.icN.arS();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.icJ.bRd() || view == WriteUrlActivity.this.icJ.bRe()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.icK != null) {
                        WriteUrlActivity.this.icK.bOX();
                    }
                    WriteUrlActivity.this.icM = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.icJ.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.icJ.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.icJ.bRf()) {
                    WriteUrlActivity.this.icJ.b(WriteUrlActivity.this.icM);
                } else if (view == WriteUrlActivity.this.icJ.getVideoContainer()) {
                    if (WriteUrlActivity.this.icM != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.icM.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.icM.videoUrl, WriteUrlActivity.this.icM.videoWidth, WriteUrlActivity.this.icM.videoHeight, WriteUrlActivity.this.icM.hWK);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.icJ.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.icJ.bRc());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.icJ = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.icK = new com.baidu.tieba.write.model.a(getUniqueId());
        this.icK.a(new a.InterfaceC0336a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0336a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.icM = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.icJ != null) {
                    if (WriteUrlActivity.this.icM.hWF == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.egr, 800L);
                    } else {
                        WriteUrlActivity.this.icJ.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hWF == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.icN != null) {
                        WriteUrlActivity.this.icN.bEQ();
                    }
                }
            }
        });
        this.icL = new WriteUrlModel(getPageContext());
        this.icL.an(getIntent());
        this.icN = new j(getPageContext(), this.icJ, this.icK, this.icL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.icJ != null) {
            this.icJ.onChangeSkinType(i);
        }
        this.icN.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.icJ != null && this.icJ.bRj() != null && this.icJ.bRj().getVisibility() == 0) {
                this.icJ.bRg();
                return true;
            } else if (this.icM != null || (this.icJ != null && !StringUtils.isNull(this.icJ.bRa()))) {
                byi();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.db(e.j.tip_draft_no_publish);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.BF();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.icN.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.icN.destroy();
        if (this.icJ != null) {
            this.icJ.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
