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
    private j hkb;
    private com.baidu.tieba.write.model.a hkc;
    private WriteUrlModel hkd;
    private com.baidu.tieba.write.a.a hke;
    private i hkf;
    private boolean isLoading = false;
    private Runnable hkg = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hkb != null) {
                WriteUrlActivity.this.hkb.a(WriteUrlActivity.this.hke, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hkb != null) {
                if (view == WriteUrlActivity.this.hkb.aCR()) {
                    if (WriteUrlActivity.this.hkb == null || WriteUrlActivity.this.hkb.bIF() == null || WriteUrlActivity.this.hkb.bIF().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hke != null || (WriteUrlActivity.this.hkb != null && !StringUtils.isNull(WriteUrlActivity.this.hkb.bIx()))) {
                            WriteUrlActivity.this.bob();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hkb.bIC();
                } else if (view == WriteUrlActivity.this.hkb.bIy()) {
                    if (WriteUrlActivity.this.hke != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.hh()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hke.hdQ != 2 || WriteUrlActivity.this.hkb.bIx().length() <= 31) {
                            if (!WriteUrlActivity.this.hkf.bIs()) {
                                WriteUrlActivity.this.hkf.bIr();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hkb.bsK() || view == WriteUrlActivity.this.hkb.bIA()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hkc != null) {
                        WriteUrlActivity.this.hkc.bGc();
                    }
                    WriteUrlActivity.this.hke = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hkb.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hkb.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hkb.bIB()) {
                    WriteUrlActivity.this.hkb.b(WriteUrlActivity.this.hke);
                } else if (view == WriteUrlActivity.this.hkb.getVideoContainer()) {
                    if (WriteUrlActivity.this.hke != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hke.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hke.videoUrl, WriteUrlActivity.this.hke.videoWidth, WriteUrlActivity.this.hke.videoHeight, WriteUrlActivity.this.hke.hdV);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hkb.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hkb.bIz());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hkb = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hkc = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hkc.a(new a.InterfaceC0140a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0140a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hke = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hkb != null) {
                    if (WriteUrlActivity.this.hke.hdQ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hkg, 800L);
                    } else {
                        WriteUrlActivity.this.hkb.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hdQ == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hkf != null) {
                        WriteUrlActivity.this.hkf.bwY();
                    }
                }
            }
        });
        this.hkd = new WriteUrlModel(getPageContext());
        this.hkd.am(getIntent());
        this.hkf = new i(getPageContext(), this.hkb, this.hkc, this.hkd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hkb != null) {
            this.hkb.onChangeSkinType(i);
        }
        this.hkf.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hkb != null && this.hkb.bIF() != null && this.hkb.bIF().getVisibility() == 0) {
                this.hkb.bIC();
                return true;
            } else if (this.hke != null || (this.hkb != null && !StringUtils.isNull(this.hkb.bIx()))) {
                bob();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bob() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cd(d.j.tip_draft_no_publish);
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
        aVar.tk();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hkf.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hkf.destroy();
        if (this.hkb != null) {
            this.hkb.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
