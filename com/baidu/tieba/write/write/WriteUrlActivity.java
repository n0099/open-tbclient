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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private j hLi;
    private com.baidu.tieba.write.model.a hLj;
    private WriteUrlModel hLk;
    private com.baidu.tieba.write.a.a hLl;
    private i hLm;
    private boolean isLoading = false;
    private Runnable hLn = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hLi != null) {
                WriteUrlActivity.this.hLi.a(WriteUrlActivity.this.hLl, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hLi != null) {
                if (view == WriteUrlActivity.this.hLi.aKm()) {
                    if (WriteUrlActivity.this.hLi == null || WriteUrlActivity.this.hLi.bIM() == null || WriteUrlActivity.this.hLi.bIM().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hLl != null || (WriteUrlActivity.this.hLi != null && !StringUtils.isNull(WriteUrlActivity.this.hLi.bID()))) {
                            WriteUrlActivity.this.bpL();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hLi.bIJ();
                } else if (view == WriteUrlActivity.this.hLi.bIE()) {
                    if (WriteUrlActivity.this.hLl != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hLl.hEO != 2 || WriteUrlActivity.this.hLi.bID().length() <= 31) {
                            if (!WriteUrlActivity.this.hLm.bIy()) {
                                WriteUrlActivity.this.hLm.bIx();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hLi.bIG() || view == WriteUrlActivity.this.hLi.bIH()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hLj != null) {
                        WriteUrlActivity.this.hLj.bGd();
                    }
                    WriteUrlActivity.this.hLl = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hLi.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hLi.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hLi.bII()) {
                    WriteUrlActivity.this.hLi.b(WriteUrlActivity.this.hLl);
                } else if (view == WriteUrlActivity.this.hLi.getVideoContainer()) {
                    if (WriteUrlActivity.this.hLl != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hLl.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hLl.videoUrl, WriteUrlActivity.this.hLl.videoWidth, WriteUrlActivity.this.hLl.videoHeight, WriteUrlActivity.this.hLl.hET);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hLi.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hLi.bIF());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hLi = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hLj = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hLj.a(new a.InterfaceC0169a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0169a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hLl = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hLi != null) {
                    if (WriteUrlActivity.this.hLl.hEO == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hLn, 800L);
                    } else {
                        WriteUrlActivity.this.hLi.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hEO == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hLm != null) {
                        WriteUrlActivity.this.hLm.bwt();
                    }
                }
            }
        });
        this.hLk = new WriteUrlModel(getPageContext());
        this.hLk.an(getIntent());
        this.hLm = new i(getPageContext(), this.hLi, this.hLj, this.hLk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hLi != null) {
            this.hLi.onChangeSkinType(i);
        }
        this.hLm.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hLi != null && this.hLi.bIM() != null && this.hLi.bIM().getVisibility() == 0) {
                this.hLi.bIJ();
                return true;
            } else if (this.hLl != null || (this.hLi != null && !StringUtils.isNull(this.hLi.bID()))) {
                bpL();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.fb(d.j.tip_draft_no_publish);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.AB();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hLm.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hLm.destroy();
        if (this.hLi != null) {
            this.hLi.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
