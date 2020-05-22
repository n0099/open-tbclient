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
    private k lZE;
    private com.baidu.tieba.write.model.a lZF;
    private WriteUrlModel lZG;
    private com.baidu.tieba.write.a.a lZH;
    private j lZI;
    private boolean isLoading = false;
    private Runnable fhR = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.lZE != null) {
                WriteUrlActivity.this.lZE.a(WriteUrlActivity.this.lZH, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.lZE != null) {
                if (view == WriteUrlActivity.this.lZE.cpj()) {
                    if (WriteUrlActivity.this.lZE == null || WriteUrlActivity.this.lZE.dpA() == null || WriteUrlActivity.this.lZE.dpA().getVisibility() != 0) {
                        if (WriteUrlActivity.this.lZH != null || (WriteUrlActivity.this.lZE != null && !StringUtils.isNull(WriteUrlActivity.this.lZE.dpr()))) {
                            WriteUrlActivity.this.cXY();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.lZE.dpx();
                } else if (view == WriteUrlActivity.this.lZE.dps()) {
                    if (WriteUrlActivity.this.lZH != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.lZH.lSB != 2 || WriteUrlActivity.this.lZE.dpr().length() <= 31) {
                            if (!WriteUrlActivity.this.lZI.dpm()) {
                                WriteUrlActivity.this.lZI.bMo();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lZE.dpu() || view == WriteUrlActivity.this.lZE.dpv()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.lZF != null) {
                        WriteUrlActivity.this.lZF.dmX();
                    }
                    WriteUrlActivity.this.lZH = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.lZE.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.lZE.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.lZE.dpw()) {
                    WriteUrlActivity.this.lZE.b(WriteUrlActivity.this.lZH);
                } else if (view == WriteUrlActivity.this.lZE.getVideoContainer()) {
                    if (WriteUrlActivity.this.lZH != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.lZH.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.lZH.videoUrl, WriteUrlActivity.this.lZH.videoWidth, WriteUrlActivity.this.lZH.videoHeight, WriteUrlActivity.this.lZH.lSG);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lZE.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.lZE.dpt());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lZE = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lZF = new com.baidu.tieba.write.model.a(getUniqueId());
        this.lZF.a(new a.InterfaceC0752a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0752a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.lZH = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.lZE != null) {
                    if (WriteUrlActivity.this.lZH.lSB == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fhR, 800L);
                    } else {
                        WriteUrlActivity.this.lZE.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.lSB == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.lZI != null) {
                        WriteUrlActivity.this.lZI.def();
                    }
                }
            }
        });
        this.lZG = new WriteUrlModel(getPageContext());
        this.lZG.aq(getIntent());
        this.lZI = new j(getPageContext(), this.lZE, this.lZF, this.lZG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lZE != null) {
            this.lZE.onChangeSkinType(i);
        }
        this.lZI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lZE != null && this.lZE.dpA() != null && this.lZE.dpA().getVisibility() == 0) {
                this.lZE.dpx();
                return true;
            } else if (this.lZH != null || (this.lZE != null && !StringUtils.isNull(this.lZE.dpr()))) {
                cXY();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kD(R.string.tip_draft_no_publish);
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
        this.lZI.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lZI.destroy();
        if (this.lZE != null) {
            this.lZE.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
