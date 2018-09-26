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
    private k hJr;
    private com.baidu.tieba.write.model.a hJs;
    private WriteUrlModel hJt;
    private com.baidu.tieba.write.a.a hJu;
    private j hJv;
    private boolean isLoading = false;
    private Runnable dNU = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hJr != null) {
                WriteUrlActivity.this.hJr.a(WriteUrlActivity.this.hJu, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hJr != null) {
                if (view == WriteUrlActivity.this.hJr.aPz()) {
                    if (WriteUrlActivity.this.hJr == null || WriteUrlActivity.this.hJr.bLD() == null || WriteUrlActivity.this.hJr.bLD().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hJu != null || (WriteUrlActivity.this.hJr != null && !StringUtils.isNull(WriteUrlActivity.this.hJr.bLu()))) {
                            WriteUrlActivity.this.bsP();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hJr.bLA();
                } else if (view == WriteUrlActivity.this.hJr.bLv()) {
                    if (WriteUrlActivity.this.hJu != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.hJu.hDl != 2 || WriteUrlActivity.this.hJr.bLu().length() <= 31) {
                            if (!WriteUrlActivity.this.hJv.bLp()) {
                                WriteUrlActivity.this.hJv.amq();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hJr.bLx() || view == WriteUrlActivity.this.hJr.bLy()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hJs != null) {
                        WriteUrlActivity.this.hJs.bJq();
                    }
                    WriteUrlActivity.this.hJu = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hJr.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hJr.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hJr.bLz()) {
                    WriteUrlActivity.this.hJr.b(WriteUrlActivity.this.hJu);
                } else if (view == WriteUrlActivity.this.hJr.getVideoContainer()) {
                    if (WriteUrlActivity.this.hJu != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hJu.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hJu.videoUrl, WriteUrlActivity.this.hJu.videoWidth, WriteUrlActivity.this.hJu.videoHeight, WriteUrlActivity.this.hJu.hDq);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hJr.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hJr.bLw());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hJr = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hJs = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hJs.a(new a.InterfaceC0259a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0259a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hJu = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hJr != null) {
                    if (WriteUrlActivity.this.hJu.hDl == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dNU, 800L);
                    } else {
                        WriteUrlActivity.this.hJr.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hDl == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hJv != null) {
                        WriteUrlActivity.this.hJv.bzu();
                    }
                }
            }
        });
        this.hJt = new WriteUrlModel(getPageContext());
        this.hJt.aj(getIntent());
        this.hJv = new j(getPageContext(), this.hJr, this.hJs, this.hJt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJr != null) {
            this.hJr.onChangeSkinType(i);
        }
        this.hJv.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hJr != null && this.hJr.bLD() != null && this.hJr.bLD().getVisibility() == 0) {
                this.hJr.bLA();
                return true;
            } else if (this.hJu != null || (this.hJr != null && !StringUtils.isNull(this.hJr.bLu()))) {
                bsP();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cp(e.j.tip_draft_no_publish);
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
        aVar.yl();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hJv.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hJv.destroy();
        if (this.hJr != null) {
            this.hJr.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
