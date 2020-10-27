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
    private m nJc;
    private com.baidu.tieba.write.model.a nJd;
    private WriteUrlModel nJe;
    private com.baidu.tieba.write.a.a nJf;
    private l nJg;
    private boolean isLoading = false;
    private Runnable gjE = new Runnable() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteUrlActivity.this.nJc != null) {
                WriteUrlActivity.this.nJc.a(WriteUrlActivity.this.nJf, WriteUrlActivity.this.isLoading);
            }
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && WriteUrlActivity.this.nJc != null) {
                if (view == WriteUrlActivity.this.nJc.cSx()) {
                    if (WriteUrlActivity.this.nJc == null || WriteUrlActivity.this.nJc.dUp() == null || WriteUrlActivity.this.nJc.dUp().getVisibility() != 0) {
                        if (WriteUrlActivity.this.nJf != null || (WriteUrlActivity.this.nJc != null && !StringUtils.isNull(WriteUrlActivity.this.nJc.dUg()))) {
                            WriteUrlActivity.this.dBR();
                            return;
                        } else {
                            WriteUrlActivity.this.finish();
                            return;
                        }
                    }
                    WriteUrlActivity.this.nJc.dUm();
                } else if (view == WriteUrlActivity.this.nJc.dUh()) {
                    if (WriteUrlActivity.this.nJf != null) {
                        if (WriteUrlActivity.this.isLoading) {
                            WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                            return;
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteUrlActivity.this.showToast(R.string.neterror);
                        }
                        if (WriteUrlActivity.this.nJf.nAJ != 2 || WriteUrlActivity.this.nJc.dUg().length() <= 31) {
                            if (!WriteUrlActivity.this.nJg.dUb()) {
                                WriteUrlActivity.this.nJg.cmR();
                                return;
                            }
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_publish_video_link_limit);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nJc.dUj() || view == WriteUrlActivity.this.nJc.dUk()) {
                    if (WriteUrlActivity.this.isLoading && WriteUrlActivity.this.nJd != null) {
                        WriteUrlActivity.this.nJd.dRk();
                    }
                    WriteUrlActivity.this.nJf = null;
                    WriteUrlActivity.this.isLoading = false;
                    WriteUrlActivity.this.nJc.a(null, WriteUrlActivity.this.isLoading);
                    WriteUrlActivity.this.nJc.b((com.baidu.tieba.write.a.a) null);
                    TiebaStatic.log(new aq("c12167"));
                } else if (view == WriteUrlActivity.this.nJc.dUl()) {
                    WriteUrlActivity.this.nJc.b(WriteUrlActivity.this.nJf);
                } else if (view == WriteUrlActivity.this.nJc.getVideoContainer()) {
                    if (WriteUrlActivity.this.nJf != null) {
                        if (!WriteUrlActivity.this.isLoading) {
                            if (StringUtils.isNull(WriteUrlActivity.this.nJf.videoUrl)) {
                                WriteUrlActivity.this.showToast(R.string.tip_play_video);
                                return;
                            }
                            TiebaStatic.log("c12170");
                            XiaoyingUtil.startPlayXiaoyingVideo(WriteUrlActivity.this.getPageContext().getPageActivity(), WriteUrlActivity.this.nJf.videoUrl, WriteUrlActivity.this.nJf.videoWidth, WriteUrlActivity.this.nJf.videoHeight, WriteUrlActivity.this.nJf.nAO);
                            return;
                        }
                        WriteUrlActivity.this.showToast(R.string.tip_loading_to_publish);
                        return;
                    }
                    WriteUrlActivity.this.showToast(R.string.tip_no_data_to_publish);
                } else if (view == WriteUrlActivity.this.nJc.getRootView()) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteUrlActivity.this.getActivity(), WriteUrlActivity.this.nJc.dUi());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nJc = new m(this, this.mClickListener);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.nJd = new com.baidu.tieba.write.model.a(getUniqueId());
        this.nJd.a(new a.InterfaceC0863a() { // from class: com.baidu.tieba.write.write.WriteUrlActivity.3
            @Override // com.baidu.tieba.write.model.a.InterfaceC0863a
            public void a(com.baidu.tieba.write.a.a aVar) {
                WriteUrlActivity.this.nJf = aVar;
                WriteUrlActivity.this.isLoading = false;
                if (WriteUrlActivity.this.nJc != null) {
                    if (WriteUrlActivity.this.nJf.nAJ == 1) {
                        WriteUrlActivity.this.getSafeHandler().postDelayed(WriteUrlActivity.this.gjE, 800L);
                    } else {
                        WriteUrlActivity.this.nJc.a(aVar, WriteUrlActivity.this.isLoading);
                    }
                    if ((aVar.nAJ == 2 || !TextUtils.isEmpty(aVar.videoUrl)) && WriteUrlActivity.this.nJg != null) {
                        WriteUrlActivity.this.nJg.dId();
                    }
                }
            }
        });
        this.nJe = new WriteUrlModel(getPageContext());
        this.nJe.au(getIntent());
        this.nJg = new l(getPageContext(), this.nJc, this.nJd, this.nJe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nJc != null) {
            this.nJc.onChangeSkinType(i);
        }
        this.nJg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nJc != null && this.nJc.dUp() != null && this.nJc.dUp().getVisibility() == 0) {
                this.nJc.dUm();
                return true;
            } else if (this.nJf != null || (this.nJc != null && !StringUtils.isNull(this.nJc.dUg()))) {
                dBR();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.om(R.string.tip_draft_no_publish);
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
        aVar.bmC();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nJg.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nJg.destroy();
        if (this.nJc != null) {
            this.nJc.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
