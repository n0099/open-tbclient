package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
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
    private f gYV;
    private com.baidu.tieba.write.model.a gYW;
    private WriteUrlModel gYX;
    private com.baidu.tieba.write.a.a gYY;
    private e gYZ;
    private boolean isLoading = false;
    private Runnable gZa = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.gYV != null) {
                WriteUrlActivity.this.gYV.a(WriteUrlActivity.this.gYY, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.gYV != null) {
                if (view == WriteUrlActivity.this.gYV.aBr()) {
                    if (WriteUrlActivity.this.gYV == null || WriteUrlActivity.this.gYV.bFJ() == null || WriteUrlActivity.this.gYV.bFJ().getVisibility() != 0) {
                        if (WriteUrlActivity.this.gYY != null || (WriteUrlActivity.this.gYV != null && !StringUtils.isNull(WriteUrlActivity.this.gYV.bFB()))) {
                            WriteUrlActivity.this.bmd();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.gYV.bFG();
                } else if (view == WriteUrlActivity.this.gYV.bFC()) {
                    if (WriteUrlActivity.this.gYY != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                            return;
                        }
                        if (!j.hh()) {
                            WriteUrlActivity.this.showToast(d.j.neterror);
                        }
                        if (WriteUrlActivity.this.gYY.gTf != 2 || WriteUrlActivity.this.gYV.bFB().length() <= 31) {
                            if (!WriteUrlActivity.this.gYZ.bFx()) {
                                WriteUrlActivity.this.gYZ.bFw();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gYV.brd() || view == WriteUrlActivity.this.gYV.bFE()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.gYW != null) {
                        WriteUrlActivity.this.gYW.bDw();
                    }
                    WriteUrlActivity.this.gYY = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.gYV.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.gYV.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new ak("c12167"));
                } else if (view == WriteUrlActivity.this.gYV.bFF()) {
                    WriteUrlActivity.this.gYV.b(WriteUrlActivity.this.gYY);
                } else if (view == WriteUrlActivity.this.gYV.getVideoContainer()) {
                    if (WriteUrlActivity.this.gYY != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.gYY.videoUrl)) {
                                WriteUrlActivity.this.showToast(d.j.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.gYY.videoUrl, WriteUrlActivity.this.gYY.videoWidth, WriteUrlActivity.this.gYY.videoHeight, WriteUrlActivity.this.gYY.gTk);
                            return;
                        }
                        WriteUrlActivity.this.showToast(d.j.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(d.j.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.gYV.getRootView()) {
                    l.b(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.gYV.bFD());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gYV = new f(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gYW = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gYW.a(new a.InterfaceC0141a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0141a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.gYY = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.gYV != null) {
                    if (WriteUrlActivity.this.gYY.gTf == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gZa, 800L);
                    } else {
                        WriteUrlActivity.this.gYV.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                }
            }
        });
        this.gYX = new WriteUrlModel(getPageContext());
        this.gYX.ah(getIntent());
        this.gYZ = new e(getPageContext(), this.gYV, this.gYW, this.gYX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gYV != null) {
            this.gYV.onChangeSkinType(i);
        }
        this.gYZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gYV != null && this.gYV.bFJ() != null && this.gYV.bFJ().getVisibility() == 0) {
                this.gYV.bFG();
                return true;
            } else if (this.gYY != null || (this.gYV != null && !StringUtils.isNull(this.gYV.bFB()))) {
                bmd();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cc(d.j.tip_draft_no_publish);
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
        this.gYZ.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gYZ.destroy();
        if (this.gYV != null) {
            this.gYV.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }
}
