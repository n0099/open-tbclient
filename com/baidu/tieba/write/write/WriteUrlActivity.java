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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k mvG;
    private com.baidu.tieba.write.model.a mvH;
    private WriteUrlModel mvI;
    private com.baidu.tieba.write.a.a mvJ;
    private j mvK;
    private boolean isLoading = false;
    private Runnable ftq = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mvG != null) {
                WriteUrlActivity.this.mvG.a(WriteUrlActivity.this.mvJ, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mvG != null) {
                if (view == WriteUrlActivity.this.mvG.cth()) {
                    if (WriteUrlActivity.this.mvG == null || WriteUrlActivity.this.mvG.duj() == null || WriteUrlActivity.this.mvG.duj().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mvJ != null || (WriteUrlActivity.this.mvG != null && !StringUtils.isNull(WriteUrlActivity.this.mvG.dua()))) {
                            WriteUrlActivity.this.dcD();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mvG.dug();
                } else if (view == WriteUrlActivity.this.mvG.dub()) {
                    if (WriteUrlActivity.this.mvJ != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mvJ.mod != 2 || WriteUrlActivity.this.mvG.dua().length() <= 31) {
                            if (!WriteUrlActivity.this.mvK.dtV()) {
                                WriteUrlActivity.this.mvK.bPA();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mvG.dud() || view == WriteUrlActivity.this.mvG.due()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mvH != null) {
                        WriteUrlActivity.this.mvH.drA();
                    }
                    WriteUrlActivity.this.mvJ = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mvG.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mvG.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ao("c12167"));
                } else if (view == WriteUrlActivity.this.mvG.duf()) {
                    WriteUrlActivity.this.mvG.b(WriteUrlActivity.this.mvJ);
                } else if (view == WriteUrlActivity.this.mvG.getVideoContainer()) {
                    if (WriteUrlActivity.this.mvJ != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mvJ.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mvJ.videoUrl, WriteUrlActivity.this.mvJ.videoWidth, WriteUrlActivity.this.mvJ.videoHeight, WriteUrlActivity.this.mvJ.moi);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mvG.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mvG.duc());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mvG = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mvH = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mvH.a(new a.InterfaceC0769a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0769a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mvJ = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mvG != null) {
                    if (WriteUrlActivity.this.mvJ.mod == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.ftq, 800L);
                    } else {
                        WriteUrlActivity.this.mvG.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mod == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mvK != null) {
                        WriteUrlActivity.this.mvK.diG();
                    }
                }
            }
        });
        this.mvI = new WriteUrlModel(getPageContext());
        this.mvI.au(getIntent());
        this.mvK = new j(getPageContext(), this.mvG, this.mvH, this.mvI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mvG != null) {
            this.mvG.onChangeSkinType(i);
        }
        this.mvK.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mvG != null && this.mvG.duj() != null && this.mvG.duj().getVisibility() == 0) {
                this.mvG.dug();
                return true;
            } else if (this.mvJ != null || (this.mvG != null && !StringUtils.isNull(this.mvG.dua()))) {
                dcD();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kT(R.string.tip_draft_no_publish);
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
        aVar.aUN();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mvK.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mvK.destroy();
        if (this.mvG != null) {
            this.mvG.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
