package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.write.model.a;
/* loaded from: classes3.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private m nhf;
    private com.baidu.tieba.write.model.a nhg;
    private WriteUrlModel nhh;
    private com.baidu.tieba.write.a.a nhi;
    private l nhj;
    private boolean isLoading = false;
    private Runnable fNi = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.nhf != null) {
                WriteUrlActivity.this.nhf.a(WriteUrlActivity.this.nhi, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.nhf != null) {
                if (view == WriteUrlActivity.this.nhf.cLI()) {
                    if (WriteUrlActivity.this.nhf == null || WriteUrlActivity.this.nhf.dNv() == null || WriteUrlActivity.this.nhf.dNv().getVisibility() != 0) {
                        if (WriteUrlActivity.this.nhi != null || (WriteUrlActivity.this.nhf != null && !StringUtils.isNull(WriteUrlActivity.this.nhf.dNm()))) {
                            WriteUrlActivity.this.duY();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.nhf.dNs();
                } else if (view == WriteUrlActivity.this.nhf.dNn()) {
                    if (WriteUrlActivity.this.nhi != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.nhi.mYK != 2 || WriteUrlActivity.this.nhf.dNm().length() <= 31) {
                            if (!WriteUrlActivity.this.nhj.dNh()) {
                                WriteUrlActivity.this.nhj.cgo();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nhf.dNp() || view == WriteUrlActivity.this.nhf.dNq()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.nhg != null) {
                        WriteUrlActivity.this.nhg.dKq();
                    }
                    WriteUrlActivity.this.nhi = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.nhf.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.nhf.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.nhf.dNr()) {
                    WriteUrlActivity.this.nhf.b(WriteUrlActivity.this.nhi);
                } else if (view == WriteUrlActivity.this.nhf.getVideoContainer()) {
                    if (WriteUrlActivity.this.nhi != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.nhi.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.nhi.videoUrl, WriteUrlActivity.this.nhi.videoWidth, WriteUrlActivity.this.nhi.videoHeight, WriteUrlActivity.this.nhi.mYP);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nhf.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.nhf.dNo());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nhf = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nhg = new com.baidu.tieba.write.model.a(getUniqueId());
        this.nhg.a(new a.InterfaceC0830a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0830a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.nhi = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.nhf != null) {
                    if (WriteUrlActivity.this.nhi.mYK == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.fNi, 800L);
                    } else {
                        WriteUrlActivity.this.nhf.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.mYK == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.nhj != null) {
                        WriteUrlActivity.this.nhj.dBj();
                    }
                }
            }
        });
        this.nhh = new WriteUrlModel(getPageContext());
        this.nhh.aw(getIntent());
        this.nhj = new l(getPageContext(), this.nhf, this.nhg, this.nhh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nhf != null) {
            this.nhf.onChangeSkinType(i);
        }
        this.nhj.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nhf != null && this.nhf.dNv() != null && this.nhf.dNv().getVisibility() == 0) {
                this.nhf.dNs();
                return true;
            } else if (this.nhi != null || (this.nhf != null && !StringUtils.isNull(this.nhf.dNm()))) {
                duY();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.nE(R.string.tip_draft_no_publish);
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
        aVar.bia();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nhj.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nhj.destroy();
        if (this.nhf != null) {
            this.nhf.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
