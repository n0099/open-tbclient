package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private c gJA;
    private d gJw;
    private com.baidu.tieba.write.model.a gJx;
    private WriteUrlModel gJy;
    private com.baidu.tieba.write.a.a gJz;
    private boolean isLoading = false;
    private Runnable gJB = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gJw != null) {
                WriteUrlActivity.this.gJw.a(WriteUrlActivity.this.gJz, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aYX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gJw != null) {
                if (view == WriteUrlActivity.this.gJw.Ww()) {
                    if (WriteUrlActivity.this.gJw == null || WriteUrlActivity.this.gJw.bBy() == null || WriteUrlActivity.this.gJw.bBy().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gJz != null || (WriteUrlActivity.this.gJw != null && !StringUtils.isNull(WriteUrlActivity.this.gJw.bBq()))) {
                            WriteUrlActivity.this.blk();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gJw.bBv();
                } else if (view == WriteUrlActivity.this.gJw.bBr()) {
                    if (WriteUrlActivity.this.gJz != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!i.hr()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gJz.gDL != 2 || WriteUrlActivity.this.gJw.bBq().length() <= 31) {
                            WriteUrlActivity.this.gJA.bBm();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gJw.bpH() || view == WriteUrlActivity.this.gJw.bBt()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gJx != null) {
                        WriteUrlActivity.this.gJx.bzj();
                    }
                    WriteUrlActivity.this.gJz = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gJw.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gJw.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aj("c12167"));
                } else if (view == WriteUrlActivity.this.gJw.bBu()) {
                    WriteUrlActivity.this.gJw.b(WriteUrlActivity.this.gJz);
                } else if (view == WriteUrlActivity.this.gJw.getVideoContainer()) {
                    if (WriteUrlActivity.this.gJz != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gJz.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gJz.videoUrl, WriteUrlActivity.this.gJz.videoWidth, WriteUrlActivity.this.gJz.videoHeight, WriteUrlActivity.this.gJz.gDR);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gJw.getRootView()) {
                    k.c(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gJw.bBs());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gJw = new d(this, this.aYX);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gJx = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gJx.a(new a.InterfaceC0124a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0124a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gJz = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gJw != null) {
                    if (WriteUrlActivity.this.gJz.gDL == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gJB, 800L);
                    } else {
                        WriteUrlActivity.this.gJw.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gJy = new WriteUrlModel(getPageContext());
        this.gJy.al(getIntent());
        this.gJA = new c(getPageContext(), this.gJw, this.gJx, this.gJy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gJw != null) {
            this.gJw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gJw != null && this.gJw.bBy() != null && this.gJw.bBy().getVisibility() == 0) {
                this.gJw.bBv();
                return true;
            } else if (this.gJz != null || (this.gJw != null && !StringUtils.isNull(this.gJw.bBq()))) {
                blk();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.l.tip_draft_no_publish);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteUrlActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.tr();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gJA.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gJA.destroy();
        if (this.gJw != null) {
            this.gJw.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
