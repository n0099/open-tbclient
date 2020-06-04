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
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k maS;
    private com.baidu.tieba.write.model.a maT;
    private WriteUrlModel maU;
    private com.baidu.tieba.write.a.a maV;
    private j maW;
    private boolean isLoading = false;
    private Runnable fic = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.maS != null) {
                WriteUrlActivity.this.maS.a(WriteUrlActivity.this.maV, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.maS != null) {
                if (view == WriteUrlActivity.this.maS.cps()) {
                    if (WriteUrlActivity.this.maS == null || WriteUrlActivity.this.maS.dpO() == null || WriteUrlActivity.this.maS.dpO().getVisibility() != 0) {
                        if (WriteUrlActivity.this.maV != null || (WriteUrlActivity.this.maS != null && !StringUtils.isNull(WriteUrlActivity.this.maS.dpF()))) {
                            WriteUrlActivity.this.cYo();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.maS.dpL();
                } else if (view == WriteUrlActivity.this.maS.dpG()) {
                    if (WriteUrlActivity.this.maV != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.maV.lTM != 2 || WriteUrlActivity.this.maS.dpF().length() <= 31) {
                            if (!WriteUrlActivity.this.maW.dpA()) {
                                WriteUrlActivity.this.maW.bMq();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.maS.dpI() || view == WriteUrlActivity.this.maS.dpJ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.maT != null) {
                        WriteUrlActivity.this.maT.dnn();
                    }
                    WriteUrlActivity.this.maV = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.maS.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.maS.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.maS.dpK()) {
                    WriteUrlActivity.this.maS.b(WriteUrlActivity.this.maV);
                } else if (view == WriteUrlActivity.this.maS.getVideoContainer()) {
                    if (WriteUrlActivity.this.maV != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.maV.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.maV.videoUrl, WriteUrlActivity.this.maV.videoWidth, WriteUrlActivity.this.maV.videoHeight, WriteUrlActivity.this.maV.lTR);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.maS.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.maS.dpH());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.maS = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.maT = new com.baidu.tieba.write.model.a(getUniqueId());
        this.maT.a(new a.InterfaceC0753a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0753a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.maV = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.maS != null) {
                    if (WriteUrlActivity.this.maV.lTM == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fic, 800L);
                    } else {
                        WriteUrlActivity.this.maS.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.lTM == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.maW != null) {
                        WriteUrlActivity.this.maW.deu();
                    }
                }
            }
        });
        this.maU = new WriteUrlModel(getPageContext());
        this.maU.ar(getIntent());
        this.maW = new j(getPageContext(), this.maS, this.maT, this.maU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.maS != null) {
            this.maS.onChangeSkinType(i);
        }
        this.maW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.maS != null && this.maS.dpO() != null && this.maS.dpO().getVisibility() == 0) {
                this.maS.dpL();
                return true;
            } else if (this.maV != null || (this.maS != null && !StringUtils.isNull(this.maS.dpF()))) {
                cYo();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYo() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kF(R.string.tip_draft_no_publish);
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
        aVar.aST();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.maW.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.maW.destroy();
        if (this.maS != null) {
            this.maS.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
