package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    private ArrayList<TransmitForumData> jFh;
    private AlaShareInBarModel jFi;
    private String mLiveId = "";
    private final AlaShareInBarModel.a jFj = new AlaShareInBarModel.a() { // from class: com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity.2
        @Override // com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.a
        public void a(int i, String str, com.baidu.tieba.livesdk.share.b.a aVar) {
            AlaShareInBarEmptyActivity.this.closeLoadingDialog();
            if (i == 0 && aVar != null) {
                BdToast.a(AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity(), AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity().getString(b.C0684b.share_alert_success), b.a.icon_pure_toast_succeed40_svg, 3000, true).aYR();
            } else {
                AlaShareInBarEmptyActivity.this.showToast(str);
            }
            AlaShareInBarEmptyActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initData(bundle);
        cDe();
    }

    private void initData(Bundle bundle) {
        this.jFi = new AlaShareInBarModel();
        this.jFi.a(this.jFj);
        Intent intent = getIntent();
        if (intent != null) {
            this.mLiveId = intent.getStringExtra("extra_key_live_id");
            this.jFh = intent.getParcelableArrayListExtra(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        } else if (bundle != null) {
            this.mLiveId = bundle.getString("extra_key_live_id");
            this.jFh = bundle.getParcelableArrayList(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        }
    }

    private void cDe() {
        if (!j.isNetWorkAvailable()) {
            showToast(b.C0684b.neterror);
            finish();
        } else if (StringUtils.isNull(this.mLiveId) || x.isEmpty(this.jFh)) {
            finish();
        } else {
            showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AlaShareInBarEmptyActivity.this.jFi.cancelLoadData();
                }
            });
            TransmitForumData transmitForumData = this.jFh.get(0);
            if (transmitForumData != null) {
                this.jFi.au(this.mLiveId, String.valueOf(transmitForumData.forumId), "");
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jFi != null) {
            this.jFi.onDestroy();
        }
    }
}
