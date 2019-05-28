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
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k jNI;
    private com.baidu.tieba.write.model.a jNJ;
    private WriteUrlModel jNK;
    private com.baidu.tieba.write.a.a jNL;
    private j jNM;
    private boolean isLoading = false;
    private Runnable dre = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jNI != null) {
                WriteUrlActivity.this.jNI.a(WriteUrlActivity.this.jNL, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jNI != null) {
                if (view == WriteUrlActivity.this.jNI.bDC()) {
                    if (WriteUrlActivity.this.jNI == null || WriteUrlActivity.this.jNI.czU() == null || WriteUrlActivity.this.jNI.czU().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jNL != null || (WriteUrlActivity.this.jNI != null && !StringUtils.isNull(WriteUrlActivity.this.jNI.czL()))) {
                            WriteUrlActivity.this.chK();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jNI.czR();
                } else if (view == WriteUrlActivity.this.jNI.czM()) {
                    if (WriteUrlActivity.this.jNL != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jNL.jHq != 2 || WriteUrlActivity.this.jNI.czL().length() <= 31) {
                            if (!WriteUrlActivity.this.jNM.czG()) {
                                WriteUrlActivity.this.jNM.aZs();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNI.czO() || view == WriteUrlActivity.this.jNI.czP()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jNJ != null) {
                        WriteUrlActivity.this.jNJ.cxF();
                    }
                    WriteUrlActivity.this.jNL = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jNI.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jNI.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.jNI.czQ()) {
                    WriteUrlActivity.this.jNI.b(WriteUrlActivity.this.jNL);
                } else if (view == WriteUrlActivity.this.jNI.getVideoContainer()) {
                    if (WriteUrlActivity.this.jNL != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jNL.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jNL.videoUrl, WriteUrlActivity.this.jNL.videoWidth, WriteUrlActivity.this.jNL.videoHeight, WriteUrlActivity.this.jNL.jHv);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNI.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jNI.czN());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jNI = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jNJ = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jNJ.a(new a.InterfaceC0428a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0428a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jNL = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jNI != null) {
                    if (WriteUrlActivity.this.jNL.jHq == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dre, 800L);
                    } else {
                        WriteUrlActivity.this.jNI.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jHq == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jNM != null) {
                        WriteUrlActivity.this.jNM.cnd();
                    }
                }
            }
        });
        this.jNK = new WriteUrlModel(getPageContext());
        this.jNK.aH(getIntent());
        this.jNM = new j(getPageContext(), this.jNI, this.jNJ, this.jNK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jNI != null) {
            this.jNI.onChangeSkinType(i);
        }
        this.jNM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jNI != null && this.jNI.czU() != null && this.jNI.czU().getVisibility() == 0) {
                this.jNI.czR();
                return true;
            } else if (this.jNL != null || (this.jNI != null && !StringUtils.isNull(this.jNI.czL()))) {
                chK();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ho(R.string.tip_draft_no_publish);
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
        aVar.afG();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jNM.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jNM.destroy();
        if (this.jNI != null) {
            this.jNI.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
