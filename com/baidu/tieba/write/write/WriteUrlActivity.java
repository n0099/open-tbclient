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
    private j hmT;
    private com.baidu.tieba.write.model.a hmU;
    private WriteUrlModel hmV;
    private com.baidu.tieba.write.a.a hmW;
    private i hmX;
    private boolean isLoading = false;
    private Runnable hmY = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.hmT != null) {
                WriteUrlActivity.this.hmT.a(WriteUrlActivity.this.hmW, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.hmT != null) {
                if (view == WriteUrlActivity.this.hmT.aCZ()) {
                    if (WriteUrlActivity.this.hmT == null || WriteUrlActivity.this.hmT.bJr() == null || WriteUrlActivity.this.hmT.bJr().getVisibility() != 0) {
                        if (WriteUrlActivity.this.hmW != null || (WriteUrlActivity.this.hmT != null && !StringUtils.isNull(WriteUrlActivity.this.hmT.bJj()))) {
                            WriteUrlActivity.this.boG();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.hmT.bJo();
                } else if (view == WriteUrlActivity.this.hmT.bJk()) {
                    if (WriteUrlActivity.this.hmW != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.hh()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.hmW.hgG != 2 || WriteUrlActivity.this.hmT.bJj().length() <= 31) {
                            if (!WriteUrlActivity.this.hmX.bJe()) {
                                WriteUrlActivity.this.hmX.bJd();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hmT.btp() || view == WriteUrlActivity.this.hmT.bJm()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.hmU != null) {
                        WriteUrlActivity.this.hmU.bGN();
                    }
                    WriteUrlActivity.this.hmW = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.hmT.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.hmT.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.hmT.bJn()) {
                    WriteUrlActivity.this.hmT.b(WriteUrlActivity.this.hmW);
                } else if (view == WriteUrlActivity.this.hmT.getVideoContainer()) {
                    if (WriteUrlActivity.this.hmW != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.hmW.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.hmW.videoUrl, WriteUrlActivity.this.hmW.videoWidth, WriteUrlActivity.this.hmW.videoHeight, WriteUrlActivity.this.hmW.hgL);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.hmT.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.hmT.bJl());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hmT = new j(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hmU = new com.baidu.tieba.write.model.a(getUniqueId());
        this.hmU.a(new a.InterfaceC0157a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0157a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.hmW = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.hmT != null) {
                    if (WriteUrlActivity.this.hmW.hgG == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.hmY, 800L);
                    } else {
                        WriteUrlActivity.this.hmT.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.hgG == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.hmX != null) {
                        WriteUrlActivity.this.hmX.bxE();
                    }
                }
            }
        });
        this.hmV = new WriteUrlModel(getPageContext());
        this.hmV.am(getIntent());
        this.hmX = new i(getPageContext(), this.hmT, this.hmU, this.hmV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hmT != null) {
            this.hmT.onChangeSkinType(i);
        }
        this.hmX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hmT != null && this.hmT.bJr() != null && this.hmT.bJr().getVisibility() == 0) {
                this.hmT.bJo();
                return true;
            } else if (this.hmW != null || (this.hmT != null && !StringUtils.isNull(this.hmT.bJj()))) {
                boG();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
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
        aVar.th();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.hmX.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hmX.destroy();
        if (this.hmT != null) {
            this.hmT.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
