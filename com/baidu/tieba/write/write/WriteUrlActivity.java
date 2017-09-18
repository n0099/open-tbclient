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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.write.model.a;
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private d gIV;
    private com.baidu.tieba.write.model.a gIW;
    private WriteUrlModel gIX;
    private com.baidu.tieba.write.a.a gIY;
    private c gIZ;
    private boolean isLoading = false;
    private Runnable gJa = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gIV != null) {
                WriteUrlActivity.this.gIV.a(WriteUrlActivity.this.gIY, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener aYH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gIV != null) {
                if (view == WriteUrlActivity.this.gIV.XH()) {
                    if (WriteUrlActivity.this.gIV == null || WriteUrlActivity.this.gIV.bAR() == null || WriteUrlActivity.this.gIV.bAR().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gIY != null || (WriteUrlActivity.this.gIV != null && !StringUtils.isNull(WriteUrlActivity.this.gIV.bAJ()))) {
                            WriteUrlActivity.this.bko();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gIV.bAO();
                } else if (view == WriteUrlActivity.this.gIV.bAK()) {
                    if (WriteUrlActivity.this.gIY != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                            return;
                        }
                        if (!i.hi()) {
                            WriteUrlActivity.this.showToast(d.l.neterror);
                        }
                        if (WriteUrlActivity.this.gIY.gDs != 2 || WriteUrlActivity.this.gIV.bAJ().length() <= 31) {
                            WriteUrlActivity.this.gIZ.bAF();
                            return;
                        } else {
                            WriteUrlActivity.this.showToast(d.l.tip_publish_video_link_limit);
                            return;
                        }
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gIV.bpb() || view == WriteUrlActivity.this.gIV.bAM()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gIW != null) {
                        WriteUrlActivity.this.gIW.byC();
                    }
                    WriteUrlActivity.this.gIY = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gIV.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gIV.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gIV.bAN()) {
                    WriteUrlActivity.this.gIV.b(WriteUrlActivity.this.gIY);
                } else if (view == WriteUrlActivity.this.gIV.getVideoContainer()) {
                    if (WriteUrlActivity.this.gIY != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gIY.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.l.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gIY.videoUrl, WriteUrlActivity.this.gIY.videoWidth, WriteUrlActivity.this.gIY.videoHeight, WriteUrlActivity.this.gIY.gDx);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.l.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.l.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gIV.getRootView()) {
                    k.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gIV.bAL());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gIV = new d(this, this.aYH);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gIW = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gIW.a(new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0126a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gIY = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gIV != null) {
                    if (WriteUrlActivity.this.gIY.gDs == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gJa, 800L);
                    } else {
                        WriteUrlActivity.this.gIV.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gIX = new WriteUrlModel(getPageContext());
        this.gIX.al(getIntent());
        this.gIZ = new c(getPageContext(), this.gIV, this.gIW, this.gIX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIV != null) {
            this.gIV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gIV != null && this.gIV.bAR() != null && this.gIV.bAR().getVisibility() == 0) {
                this.gIV.bAO();
                return true;
            } else if (this.gIY != null || (this.gIV != null && !StringUtils.isNull(this.gIV.bAJ()))) {
                bko();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
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
        aVar.to();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gIZ.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gIZ.destroy();
        if (this.gIV != null) {
            this.gIV.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
