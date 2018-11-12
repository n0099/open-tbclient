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
    private k hSo;
    private com.baidu.tieba.write.model.a hSp;
    private WriteUrlModel hSq;
    private com.baidu.tieba.write.a.a hSr;
    private j hSs;
    private boolean isLoading = false;
    private Runnable dWW = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hSo != null) {
                WriteUrlActivity.this.hSo.a(WriteUrlActivity.this.hSr, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hSo != null) {
                if (view == WriteUrlActivity.this.hSo.aSk()) {
                    if (WriteUrlActivity.this.hSo == null || WriteUrlActivity.this.hSo.bOn() == null || WriteUrlActivity.this.hSo.bOn().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hSr != null || (WriteUrlActivity.this.hSo != null && !StringUtils.isNull(WriteUrlActivity.this.hSo.bOe()))) {
                            WriteUrlActivity.this.bvA();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hSo.bOk();
                } else if (view == WriteUrlActivity.this.hSo.bOf()) {
                    if (WriteUrlActivity.this.hSr != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.hSr.hMj != 2 || WriteUrlActivity.this.hSo.bOe().length() <= 31) {
                            if (!WriteUrlActivity.this.hSs.bNZ()) {
                                WriteUrlActivity.this.hSs.apr();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hSo.bOh() || view == WriteUrlActivity.this.hSo.bOi()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hSp != null) {
                        WriteUrlActivity.this.hSp.bMb();
                    }
                    WriteUrlActivity.this.hSr = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hSo.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hSo.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hSo.bOj()) {
                    WriteUrlActivity.this.hSo.b(WriteUrlActivity.this.hSr);
                } else if (view == WriteUrlActivity.this.hSo.getVideoContainer()) {
                    if (WriteUrlActivity.this.hSr != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hSr.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hSr.videoUrl, WriteUrlActivity.this.hSr.videoWidth, WriteUrlActivity.this.hSr.videoHeight, WriteUrlActivity.this.hSr.hMo);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hSo.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hSo.bOg());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hSo = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hSp = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hSp.a(new a.InterfaceC0322a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0322a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hSr = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hSo != null) {
                    if (WriteUrlActivity.this.hSr.hMj == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.dWW, 800L);
                    } else {
                        WriteUrlActivity.this.hSo.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hMj == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hSs != null) {
                        WriteUrlActivity.this.hSs.bCe();
                    }
                }
            }
        });
        this.hSq = new WriteUrlModel(getPageContext());
        this.hSq.an(getIntent());
        this.hSs = new j(getPageContext(), this.hSo, this.hSp, this.hSq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hSo != null) {
            this.hSo.onChangeSkinType(i);
        }
        this.hSs.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hSo != null && this.hSo.bOn() != null && this.hSo.bOn().getVisibility() == 0) {
                this.hSo.bOk();
                return true;
            } else if (this.hSr != null || (this.hSo != null && !StringUtils.isNull(this.hSo.bOe()))) {
                bvA();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cN(e.j.tip_draft_no_publish);
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
        aVar.AB();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hSs.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hSs.destroy();
        if (this.hSo != null) {
            this.hSo.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
