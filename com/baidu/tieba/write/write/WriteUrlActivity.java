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
    private WriteUrlModel hZA;
    private com.baidu.tieba.write.a.a hZB;
    private j hZC;
    private k hZy;
    private com.baidu.tieba.write.model.a hZz;
    private boolean isLoading = false;
    private Runnable edA = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hZy != null) {
                WriteUrlActivity.this.hZy.a(WriteUrlActivity.this.hZB, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hZy != null) {
                if (view == WriteUrlActivity.this.hZy.aUc()) {
                    if (WriteUrlActivity.this.hZy == null || WriteUrlActivity.this.hZy.bQt() == null || WriteUrlActivity.this.hZy.bQt().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hZB != null || (WriteUrlActivity.this.hZy != null && !StringUtils.isNull(WriteUrlActivity.this.hZy.bQk()))) {
                            WriteUrlActivity.this.bxt();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hZy.bQq();
                } else if (view == WriteUrlActivity.this.hZy.bQl()) {
                    if (WriteUrlActivity.this.hZB != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            WriteUrlActivity.this.showToast(e.j.neterror);
                        }
                        if (WriteUrlActivity.this.hZB.hTu != 2 || WriteUrlActivity.this.hZy.bQk().length() <= 31) {
                            if (!WriteUrlActivity.this.hZC.bQf()) {
                                WriteUrlActivity.this.hZC.ard();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hZy.bQn() || view == WriteUrlActivity.this.hZy.bQo()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hZz != null) {
                        WriteUrlActivity.this.hZz.bOh();
                    }
                    WriteUrlActivity.this.hZB = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hZy.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hZy.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new am("c12167"));
                } else if (view == WriteUrlActivity.this.hZy.bQp()) {
                    WriteUrlActivity.this.hZy.b(WriteUrlActivity.this.hZB);
                } else if (view == WriteUrlActivity.this.hZy.getVideoContainer()) {
                    if (WriteUrlActivity.this.hZB != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hZB.videoUrl)) {
                                WriteUrlActivity.this.showToast(e.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hZB.videoUrl, WriteUrlActivity.this.hZB.videoWidth, WriteUrlActivity.this.hZB.videoHeight, WriteUrlActivity.this.hZB.hTz);
                            return;
                        }
                        WriteUrlActivity.this.showToast(e.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(e.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hZy.getRootView()) {
                    l.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hZy.bQm());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hZy = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hZz = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hZz.a(new a.InterfaceC0336a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0336a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hZB = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hZy != null) {
                    if (WriteUrlActivity.this.hZB.hTu == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.edA, 800L);
                    } else {
                        WriteUrlActivity.this.hZy.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hTu == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hZC != null) {
                        WriteUrlActivity.this.hZC.bDZ();
                    }
                }
            }
        });
        this.hZA = new WriteUrlModel(getPageContext());
        this.hZA.an(getIntent());
        this.hZC = new j(getPageContext(), this.hZy, this.hZz, this.hZA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hZy != null) {
            this.hZy.onChangeSkinType(i);
        }
        this.hZC.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hZy != null && this.hZy.bQt() != null && this.hZy.bQt().getVisibility() == 0) {
                this.hZy.bQq();
                return true;
            } else if (this.hZB != null || (this.hZy != null && !StringUtils.isNull(this.hZy.bQk()))) {
                bxt();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.db(e.j.tip_draft_no_publish);
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
        aVar.BF();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hZC.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hZC.destroy();
        if (this.hZy != null) {
            this.hZy.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }
}
