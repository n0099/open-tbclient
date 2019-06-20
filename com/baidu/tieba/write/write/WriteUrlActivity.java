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
    private k jNL;
    private com.baidu.tieba.write.model.a jNM;
    private WriteUrlModel jNN;
    private com.baidu.tieba.write.a.a jNO;
    private j jNP;
    private boolean isLoading = false;
    private Runnable dre = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jNL != null) {
                WriteUrlActivity.this.jNL.a(WriteUrlActivity.this.jNO, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jNL != null) {
                if (view == WriteUrlActivity.this.jNL.bDD()) {
                    if (WriteUrlActivity.this.jNL == null || WriteUrlActivity.this.jNL.czT() == null || WriteUrlActivity.this.jNL.czT().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jNO != null || (WriteUrlActivity.this.jNL != null && !StringUtils.isNull(WriteUrlActivity.this.jNL.czK()))) {
                            WriteUrlActivity.this.chL();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jNL.czQ();
                } else if (view == WriteUrlActivity.this.jNL.czL()) {
                    if (WriteUrlActivity.this.jNO != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jNO.jHt != 2 || WriteUrlActivity.this.jNL.czK().length() <= 31) {
                            if (!WriteUrlActivity.this.jNP.czF()) {
                                WriteUrlActivity.this.jNP.aZs();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNL.czN() || view == WriteUrlActivity.this.jNL.czO()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jNM != null) {
                        WriteUrlActivity.this.jNM.cxE();
                    }
                    WriteUrlActivity.this.jNO = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jNL.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jNL.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.jNL.czP()) {
                    WriteUrlActivity.this.jNL.b(WriteUrlActivity.this.jNO);
                } else if (view == WriteUrlActivity.this.jNL.getVideoContainer()) {
                    if (WriteUrlActivity.this.jNO != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jNO.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jNO.videoUrl, WriteUrlActivity.this.jNO.videoWidth, WriteUrlActivity.this.jNO.videoHeight, WriteUrlActivity.this.jNO.jHy);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNL.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jNL.czM());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jNL = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jNM = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jNM.a(new a.InterfaceC0428a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0428a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jNO = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jNL != null) {
                    if (WriteUrlActivity.this.jNO.jHt == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dre, 800L);
                    } else {
                        WriteUrlActivity.this.jNL.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jHt == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jNP != null) {
                        WriteUrlActivity.this.jNP.cne();
                    }
                }
            }
        });
        this.jNN = new WriteUrlModel(getPageContext());
        this.jNN.aH(getIntent());
        this.jNP = new j(getPageContext(), this.jNL, this.jNM, this.jNN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jNL != null) {
            this.jNL.onChangeSkinType(i);
        }
        this.jNP.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jNL != null && this.jNL.czT() != null && this.jNL.czT().getVisibility() == 0) {
                this.jNL.czQ();
                return true;
            } else if (this.jNO != null || (this.jNL != null && !StringUtils.isNull(this.jNL.czK()))) {
                chL();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chL() {
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
        this.jNP.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jNP.destroy();
        if (this.jNL != null) {
            this.jNL.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
