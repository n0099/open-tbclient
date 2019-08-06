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
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k jVQ;
    private com.baidu.tieba.write.model.a jVR;
    private WriteUrlModel jVS;
    private com.baidu.tieba.write.a.a jVT;
    private j jVU;
    private boolean isLoading = false;
    private Runnable dtu = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.jVQ != null) {
                WriteUrlActivity.this.jVQ.a(WriteUrlActivity.this.jVT, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.jVQ != null) {
                if (view == WriteUrlActivity.this.jVQ.bGy()) {
                    if (WriteUrlActivity.this.jVQ == null || WriteUrlActivity.this.jVQ.cDm() == null || WriteUrlActivity.this.jVQ.cDm().getVisibility() != 0) {
                        if (WriteUrlActivity.this.jVT != null || (WriteUrlActivity.this.jVQ != null && !StringUtils.isNull(WriteUrlActivity.this.jVQ.cDd()))) {
                            WriteUrlActivity.this.ckU();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.jVQ.cDj();
                } else if (view == WriteUrlActivity.this.jVQ.cDe()) {
                    if (WriteUrlActivity.this.jVT != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.jVT.jPD != 2 || WriteUrlActivity.this.jVQ.cDd().length() <= 31) {
                            if (!WriteUrlActivity.this.jVU.cCY()) {
                                WriteUrlActivity.this.jVU.bbt();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jVQ.cDg() || view == WriteUrlActivity.this.jVQ.cDh()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.jVR != null) {
                        WriteUrlActivity.this.jVR.cAY();
                    }
                    WriteUrlActivity.this.jVT = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.jVQ.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.jVQ.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.jVQ.cDi()) {
                    WriteUrlActivity.this.jVQ.b(WriteUrlActivity.this.jVT);
                } else if (view == WriteUrlActivity.this.jVQ.getVideoContainer()) {
                    if (WriteUrlActivity.this.jVT != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.jVT.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.jVT.videoUrl, WriteUrlActivity.this.jVT.videoWidth, WriteUrlActivity.this.jVT.videoHeight, WriteUrlActivity.this.jVT.jPI);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.jVQ.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.jVQ.cDf());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.jVQ = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVR = new com.baidu.tieba.write.model.a(getUniqueId());
        this.jVR.a(new a.InterfaceC0433a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0433a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.jVT = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.jVQ != null) {
                    if (WriteUrlActivity.this.jVT.jPD == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dtu, 800L);
                    } else {
                        WriteUrlActivity.this.jVQ.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.jPD == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.jVU != null) {
                        WriteUrlActivity.this.jVU.cqt();
                    }
                }
            }
        });
        this.jVS = new WriteUrlModel(getPageContext());
        this.jVS.aJ(getIntent());
        this.jVU = new j(getPageContext(), this.jVQ, this.jVR, this.jVS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jVQ != null) {
            this.jVQ.onChangeSkinType(i);
        }
        this.jVU.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jVQ != null && this.jVQ.cDm() != null && this.jVQ.cDm().getVisibility() == 0) {
                this.jVQ.cDj();
                return true;
            } else if (this.jVT != null || (this.jVQ != null && !StringUtils.isNull(this.jVQ.cDd()))) {
                ckU();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hu(R.string.tip_draft_no_publish);
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
        aVar.agK();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jVU.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jVU.destroy();
        if (this.jVQ != null) {
            this.jVQ.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
