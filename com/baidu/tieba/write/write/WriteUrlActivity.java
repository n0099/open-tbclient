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
/* loaded from: classes2.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private k lGq;
    private com.baidu.tieba.write.model.a lGr;
    private WriteUrlModel lGs;
    private com.baidu.tieba.write.a.a lGt;
    private j lGu;
    private boolean isLoading = false;
    private Runnable eVj = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.lGq != null) {
                WriteUrlActivity.this.lGq.a(WriteUrlActivity.this.lGt, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.lGq != null) {
                if (view == WriteUrlActivity.this.lGq.ciM()) {
                    if (WriteUrlActivity.this.lGq == null || WriteUrlActivity.this.lGq.dij() == null || WriteUrlActivity.this.lGq.dij().getVisibility() != 0) {
                        if (WriteUrlActivity.this.lGt != null || (WriteUrlActivity.this.lGq != null && !StringUtils.isNull(WriteUrlActivity.this.lGq.dia()))) {
                            WriteUrlActivity.this.cQV();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.lGq.dig();
                } else if (view == WriteUrlActivity.this.lGq.dib()) {
                    if (WriteUrlActivity.this.lGt != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.lGt.lzm != 2 || WriteUrlActivity.this.lGq.dia().length() <= 31) {
                            if (!WriteUrlActivity.this.lGu.dhV()) {
                                WriteUrlActivity.this.lGu.bFV();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lGq.did() || view == WriteUrlActivity.this.lGq.die()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.lGr != null) {
                        WriteUrlActivity.this.lGr.dfH();
                    }
                    WriteUrlActivity.this.lGt = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.lGq.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.lGq.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new an("c12167"));
                } else if (view == WriteUrlActivity.this.lGq.dif()) {
                    WriteUrlActivity.this.lGq.b(WriteUrlActivity.this.lGt);
                } else if (view == WriteUrlActivity.this.lGq.getVideoContainer()) {
                    if (WriteUrlActivity.this.lGt != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.lGt.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.lGt.videoUrl, WriteUrlActivity.this.lGt.videoWidth, WriteUrlActivity.this.lGt.videoHeight, WriteUrlActivity.this.lGt.lzr);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.lGq.getRootView()) {
                    l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.lGq.dic());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lGq = new k(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lGr = new com.baidu.tieba.write.model.a(getUniqueId());
        this.lGr.a(new a.InterfaceC0699a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0699a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.lGt = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.lGq != null) {
                    if (WriteUrlActivity.this.lGt.lzm == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.eVj, 800L);
                    } else {
                        WriteUrlActivity.this.lGq.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.lzm == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.lGu != null) {
                        WriteUrlActivity.this.lGu.cWY();
                    }
                }
            }
        });
        this.lGs = new WriteUrlModel(getPageContext());
        this.lGs.as(getIntent());
        this.lGu = new j(getPageContext(), this.lGq, this.lGr, this.lGs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lGq != null) {
            this.lGq.onChangeSkinType(i);
        }
        this.lGu.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lGq != null && this.lGq.dij() != null && this.lGq.dij().getVisibility() == 0) {
                this.lGq.dig();
                return true;
            } else if (this.lGt != null || (this.lGq != null && !StringUtils.isNull(this.lGq.dia()))) {
                cQV();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kd(R.string.tip_draft_no_publish);
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
        aVar.aMS();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lGu.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lGu.destroy();
        if (this.lGq != null) {
            this.lGq.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
