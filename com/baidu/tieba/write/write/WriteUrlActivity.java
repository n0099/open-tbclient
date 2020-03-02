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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes13.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private j kUA;
    private k kUw;
    private com.baidu.tieba.write.model.a kUx;
    private WriteUrlModel kUy;
    private com.baidu.tieba.write.a.a kUz;
    private boolean isLoading = false;
    private Runnable eqY = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.kUw != null) {
                WriteUrlActivity.this.kUw.a(WriteUrlActivity.this.kUz, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.kUw != null) {
                if (view == WriteUrlActivity.this.kUw.bXT()) {
                    if (WriteUrlActivity.this.kUw == null || WriteUrlActivity.this.kUw.cXe() == null || WriteUrlActivity.this.kUw.cXe().getVisibility() != 0) {
                        if (WriteUrlActivity.this.kUz != null || (WriteUrlActivity.this.kUw != null && !StringUtils.isNull(WriteUrlActivity.this.kUw.cWV()))) {
                            WriteUrlActivity.this.cGe();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.kUw.cXb();
                } else if (view == WriteUrlActivity.this.kUw.cWW()) {
                    if (WriteUrlActivity.this.kUz != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.kUz.kNU != 2 || WriteUrlActivity.this.kUw.cWV().length() <= 31) {
                            if (!WriteUrlActivity.this.kUA.cWQ()) {
                                WriteUrlActivity.this.kUA.bwf();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUw.cWY() || view == WriteUrlActivity.this.kUw.cWZ()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.kUx != null) {
                        WriteUrlActivity.this.kUx.cUR();
                    }
                    WriteUrlActivity.this.kUz = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.kUw.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.kUw.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.kUw.cXa()) {
                    WriteUrlActivity.this.kUw.b(WriteUrlActivity.this.kUz);
                } else if (view == WriteUrlActivity.this.kUw.getVideoContainer()) {
                    if (WriteUrlActivity.this.kUz != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.kUz.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.kUz.videoUrl, WriteUrlActivity.this.kUz.videoWidth, WriteUrlActivity.this.kUz.videoHeight, WriteUrlActivity.this.kUz.kNZ);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.kUw.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.kUw.cWX());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kUw = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kUx = new com.baidu.tieba.write.model.a(getUniqueId());
        this.kUx.a(new a.InterfaceC0632a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0632a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.kUz = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.kUw != null) {
                    if (WriteUrlActivity.this.kUz.kNU == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.eqY, 800L);
                    } else {
                        WriteUrlActivity.this.kUw.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.kNU == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.kUA != null) {
                        WriteUrlActivity.this.kUA.cLJ();
                    }
                }
            }
        });
        this.kUy = new WriteUrlModel(getPageContext());
        this.kUy.aG(getIntent());
        this.kUA = new j(getPageContext(), this.kUw, this.kUx, this.kUy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kUw != null) {
            this.kUw.onChangeSkinType(i);
        }
        this.kUA.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kUw != null && this.kUw.cXe() != null && this.kUw.cXe().getVisibility() == 0) {
                this.kUw.cXb();
                return true;
            } else if (this.kUz != null || (this.kUw != null && !StringUtils.isNull(this.kUw.cWV()))) {
                cGe();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGe() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jW(R.string.tip_draft_no_publish);
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
        aVar.aEC();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kUA.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kUA.destroy();
        if (this.kUw != null) {
            this.kUw.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
