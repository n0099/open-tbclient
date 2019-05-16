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
    private k jNH;
    private com.baidu.tieba.write.model.a jNI;
    private WriteUrlModel jNJ;
    private com.baidu.tieba.write.a.a jNK;
    private j jNL;
    private boolean isLoading = false;
    private Runnable drd = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jNH != null) {
                WriteUrlActivity.this.jNH.a(WriteUrlActivity.this.jNK, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jNH != null) {
                if (view == WriteUrlActivity.this.jNH.bDz()) {
                    if (WriteUrlActivity.this.jNH == null || WriteUrlActivity.this.jNH.czS() == null || WriteUrlActivity.this.jNH.czS().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jNK != null || (WriteUrlActivity.this.jNH != null && !StringUtils.isNull(WriteUrlActivity.this.jNH.czJ()))) {
                            WriteUrlActivity.this.chI();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jNH.czP();
                } else if (view == WriteUrlActivity.this.jNH.czK()) {
                    if (WriteUrlActivity.this.jNK != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jNK.jHp != 2 || WriteUrlActivity.this.jNH.czJ().length() <= 31) {
                            if (!WriteUrlActivity.this.jNL.czE()) {
                                WriteUrlActivity.this.jNL.aZp();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNH.czM() || view == WriteUrlActivity.this.jNH.czN()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jNI != null) {
                        WriteUrlActivity.this.jNI.cxD();
                    }
                    WriteUrlActivity.this.jNK = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jNH.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jNH.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.jNH.czO()) {
                    WriteUrlActivity.this.jNH.b(WriteUrlActivity.this.jNK);
                } else if (view == WriteUrlActivity.this.jNH.getVideoContainer()) {
                    if (WriteUrlActivity.this.jNK != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jNK.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jNK.videoUrl, WriteUrlActivity.this.jNK.videoWidth, WriteUrlActivity.this.jNK.videoHeight, WriteUrlActivity.this.jNK.jHu);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jNH.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jNH.czL());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jNH = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jNI = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jNI.a(new a.InterfaceC0428a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0428a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jNK = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jNH != null) {
                    if (WriteUrlActivity.this.jNK.jHp == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.drd, 800L);
                    } else {
                        WriteUrlActivity.this.jNH.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jHp == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jNL != null) {
                        WriteUrlActivity.this.jNL.cnb();
                    }
                }
            }
        });
        this.jNJ = new WriteUrlModel(getPageContext());
        this.jNJ.aH(getIntent());
        this.jNL = new j(getPageContext(), this.jNH, this.jNI, this.jNJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jNH != null) {
            this.jNH.onChangeSkinType(i);
        }
        this.jNL.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jNH != null && this.jNH.czS() != null && this.jNH.czS().getVisibility() == 0) {
                this.jNH.czP();
                return true;
            } else if (this.jNK != null || (this.jNH != null && !StringUtils.isNull(this.jNH.czJ()))) {
                chI();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chI() {
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
        this.jNL.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jNL.destroy();
        if (this.jNH != null) {
            this.jNH.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
