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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.livesdk.c;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    private ArrayList<TransmitForumData> kYw;
    private AlaShareInBarModel kYx;
    private String mLiveId = "";
    private final AlaShareInBarModel.a kYy = new AlaShareInBarModel.a() { // from class: com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity.2
        @Override // com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.a
        public void a(int i, String str, com.baidu.tieba.livesdk.share.b.a aVar) {
            AlaShareInBarEmptyActivity.this.closeLoadingDialog();
            if (i == 0 && aVar != null) {
                BdToast.a(AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity(), AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity().getString(c.b.share_alert_success), c.a.icon_pure_toast_succeed40_svg, 3000, true).brB();
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
        dfE();
    }

    private void initData(Bundle bundle) {
        this.kYx = new AlaShareInBarModel();
        this.kYx.a(this.kYy);
        Intent intent = getIntent();
        if (intent != null) {
            this.mLiveId = intent.getStringExtra("extra_key_live_id");
            this.kYw = intent.getParcelableArrayListExtra(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        } else if (bundle != null) {
            this.mLiveId = bundle.getString("extra_key_live_id");
            this.kYw = bundle.getParcelableArrayList(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        }
    }

    private void dfE() {
        if (!j.isNetWorkAvailable()) {
            showToast(c.b.neterror);
            finish();
        } else if (StringUtils.isNull(this.mLiveId) || y.isEmpty(this.kYw)) {
            finish();
        } else {
            showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AlaShareInBarEmptyActivity.this.kYx.cancelLoadData();
                }
            });
            TransmitForumData transmitForumData = this.kYw.get(0);
            if (transmitForumData != null) {
                this.kYx.aH(this.mLiveId, String.valueOf(transmitForumData.forumId), "");
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
        if (this.kYx != null) {
            this.kYx.onDestroy();
        }
    }
}
