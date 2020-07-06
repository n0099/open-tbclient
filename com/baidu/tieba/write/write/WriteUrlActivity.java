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
    private k mvJ;
    private com.baidu.tieba.write.model.a mvK;
    private WriteUrlModel mvL;
    private com.baidu.tieba.write.a.a mvM;
    private j mvN;
    private boolean isLoading = false;
    private Runnable ftq = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.mvJ != null) {
                WriteUrlActivity.this.mvJ.a(WriteUrlActivity.this.mvM, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.mvJ != null) {
                if (view == WriteUrlActivity.this.mvJ.cti()) {
                    if (WriteUrlActivity.this.mvJ == null || WriteUrlActivity.this.mvJ.dun() == null || WriteUrlActivity.this.mvJ.dun().getVisibility() != 0) {
                        if (WriteUrlActivity.this.mvM != null || (WriteUrlActivity.this.mvJ != null && !StringUtils.isNull(WriteUrlActivity.this.mvJ.due()))) {
                            WriteUrlActivity.this.dcE();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.mvJ.duk();
                } else if (view == WriteUrlActivity.this.mvJ.duf()) {
                    if (WriteUrlActivity.this.mvM != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.mvM.mog != 2 || WriteUrlActivity.this.mvJ.due().length() <= 31) {
                            if (!WriteUrlActivity.this.mvN.dtZ()) {
                                WriteUrlActivity.this.mvN.bPB();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mvJ.duh() || view == WriteUrlActivity.this.mvJ.dui()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.mvK != null) {
                        WriteUrlActivity.this.mvK.drE();
                    }
                    WriteUrlActivity.this.mvM = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.mvJ.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.mvJ.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ao("c12167"));
                } else if (view == WriteUrlActivity.this.mvJ.duj()) {
                    WriteUrlActivity.this.mvJ.b(WriteUrlActivity.this.mvM);
                } else if (view == WriteUrlActivity.this.mvJ.getVideoContainer()) {
                    if (WriteUrlActivity.this.mvM != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.mvM.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.mvM.videoUrl, WriteUrlActivity.this.mvM.videoWidth, WriteUrlActivity.this.mvM.videoHeight, WriteUrlActivity.this.mvM.mol);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.mvJ.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.mvJ.dug());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mvJ = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mvK = new com.baidu.tieba.write.model.a(getUniqueId());
        this.mvK.a(new a.InterfaceC0770a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0770a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.mvM = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.mvJ != null) {
                    if (WriteUrlActivity.this.mvM.mog == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.ftq, 800L);
                    } else {
                        WriteUrlActivity.this.mvJ.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mog == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.mvN != null) {
                        WriteUrlActivity.this.mvN.diH();
                    }
                }
            }
        });
        this.mvL = new WriteUrlModel(getPageContext());
        this.mvL.au(getIntent());
        this.mvN = new j(getPageContext(), this.mvJ, this.mvK, this.mvL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mvJ != null) {
            this.mvJ.onChangeSkinType(i);
        }
        this.mvN.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mvJ != null && this.mvJ.dun() != null && this.mvJ.dun().getVisibility() == 0) {
                this.mvJ.duk();
                return true;
            } else if (this.mvM != null || (this.mvJ != null && !StringUtils.isNull(this.mvJ.due()))) {
                dcE();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcE() {
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
        this.mvN.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mvN.destroy();
        if (this.mvJ != null) {
            this.mvJ.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
