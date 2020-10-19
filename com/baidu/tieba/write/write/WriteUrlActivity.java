package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private m nwE;
    private com.baidu.tieba.write.model.a nwF;
    private WriteUrlModel nwG;
    private com.baidu.tieba.write.a.a nwH;
    private l nwI;
    private boolean isLoading = false;
    private Runnable fZz = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.nwE != null) {
                WriteUrlActivity.this.nwE.a(WriteUrlActivity.this.nwH, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.nwE != null) {
                if (view == WriteUrlActivity.this.nwE.cPq()) {
                    if (WriteUrlActivity.this.nwE == null || WriteUrlActivity.this.nwE.dRh() == null || WriteUrlActivity.this.nwE.dRh().getVisibility() != 0) {
                        if (WriteUrlActivity.this.nwH != null || (WriteUrlActivity.this.nwE != null && !StringUtils.isNull(WriteUrlActivity.this.nwE.dQY()))) {
                            WriteUrlActivity.this.dyJ();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.nwE.dRe();
                } else if (view == WriteUrlActivity.this.nwE.dQZ()) {
                    if (WriteUrlActivity.this.nwH != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.nwH.noi != 2 || WriteUrlActivity.this.nwE.dQY().length() <= 31) {
                            if (!WriteUrlActivity.this.nwI.dQT()) {
                                WriteUrlActivity.this.nwI.cjK();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nwE.dRb() || view == WriteUrlActivity.this.nwE.dRc()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.nwF != null) {
                        WriteUrlActivity.this.nwF.dOc();
                    }
                    WriteUrlActivity.this.nwH = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.nwE.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.nwE.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.nwE.dRd()) {
                    WriteUrlActivity.this.nwE.b(WriteUrlActivity.this.nwH);
                } else if (view == WriteUrlActivity.this.nwE.getVideoContainer()) {
                    if (WriteUrlActivity.this.nwH != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.nwH.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.nwH.videoUrl, WriteUrlActivity.this.nwH.videoWidth, WriteUrlActivity.this.nwH.videoHeight, WriteUrlActivity.this.nwH.non);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nwE.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.nwE.dRa());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nwE = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nwF = new com.baidu.tieba.write.model.a(getUniqueId());
        this.nwF.a(new a.InterfaceC0848a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0848a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.nwH = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.nwE != null) {
                    if (WriteUrlActivity.this.nwH.noi == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fZz, 800L);
                    } else {
                        WriteUrlActivity.this.nwE.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.noi == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.nwI != null) {
                        WriteUrlActivity.this.nwI.dEV();
                    }
                }
            }
        });
        this.nwG = new WriteUrlModel(getPageContext());
        this.nwG.au(getIntent());
        this.nwI = new l(getPageContext(), this.nwE, this.nwF, this.nwG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nwE != null) {
            this.nwE.onChangeSkinType(i);
        }
        this.nwI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nwE != null && this.nwE.dRh() != null && this.nwE.dRh().getVisibility() == 0) {
                this.nwE.dRe();
                return true;
            } else if (this.nwH != null || (this.nwE != null && !StringUtils.isNull(this.nwE.dQY()))) {
                dyJ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.ob(R.string.tip_draft_no_publish);
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
        aVar.bkJ();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nwI.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nwI.destroy();
        if (this.nwE != null) {
            this.nwE.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
