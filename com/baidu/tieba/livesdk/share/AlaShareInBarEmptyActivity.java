package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import d.a.c.e.p.j;
import d.a.n0.n1.d;
import d.a.n0.n1.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    public String mLiveId = "";
    public final AlaShareInBarModel.b mOnPostDataCallBack = new b();
    public AlaShareInBarModel mPostModel;
    public ArrayList<TransmitForumData> mTransmitForumDataList;
    public String mYyAnchorBdUid;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AlaShareInBarEmptyActivity.this.mPostModel.cancelLoadData();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AlaShareInBarModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.b
        public void a(int i2, String str, d.a.n0.n1.l.b.a aVar) {
            AlaShareInBarEmptyActivity.this.closeLoadingDialog();
            int i3 = 1;
            if (i2 == 0 && aVar != null) {
                BdToast.h(AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity(), AlaShareInBarEmptyActivity.this.getPageContext().getPageActivity().getString(g.share_alert_success), d.icon_pure_toast_succeed40_svg, 3000, true).q();
            } else {
                AlaShareInBarEmptyActivity.this.showToast(str);
                i3 = 2;
            }
            Intent intent = new Intent();
            intent.putExtra("extra_share_status", i3);
            AlaShareInBarEmptyActivity.this.setResult(-1, intent);
            AlaShareInBarEmptyActivity.this.finish();
        }
    }

    private void initData(Bundle bundle) {
        AlaShareInBarModel alaShareInBarModel = new AlaShareInBarModel();
        this.mPostModel = alaShareInBarModel;
        alaShareInBarModel.z(this.mOnPostDataCallBack);
        Intent intent = getIntent();
        if (intent != null) {
            this.mLiveId = intent.getStringExtra("extra_key_live_id");
            this.mYyAnchorBdUid = intent.getStringExtra("extra_key_yy_anchor_bduid");
            this.mTransmitForumDataList = intent.getParcelableArrayListExtra(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        } else if (bundle != null) {
            this.mLiveId = bundle.getString("extra_key_live_id");
            this.mYyAnchorBdUid = bundle.getString("extra_key_yy_anchor_bduid");
            this.mTransmitForumDataList = bundle.getParcelableArrayList(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
        }
    }

    private void sendRequest() {
        if (!j.z()) {
            showToast(g.neterror);
            finish();
        } else if ((StringUtils.isNull(this.mLiveId) && TextUtils.isEmpty(this.mYyAnchorBdUid)) || ListUtils.isEmpty(this.mTransmitForumDataList)) {
            finish();
        } else {
            showLoadingDialog((String) null, new a());
            TransmitForumData transmitForumData = this.mTransmitForumDataList.get(0);
            if (transmitForumData != null) {
                this.mPostModel.y(this.mLiveId, this.mYyAnchorBdUid, String.valueOf(transmitForumData.forumId), "");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        initData(bundle);
        sendRequest();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlaShareInBarModel alaShareInBarModel = this.mPostModel;
        if (alaShareInBarModel != null) {
            alaShareInBarModel.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(0, 0);
    }
}
