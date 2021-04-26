package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.share.ImplicitShareMessage;
import d.a.j0.m1.d;
import d.a.j0.m1.g;
/* loaded from: classes3.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    public String mContent;
    public String mImageUri;
    public String mLinkUrl;
    public String mLiveExtInfo;
    public String mLiveId;
    public d.a.j0.m1.l.a.a mSelectBarController;
    public ShareItem mShareItem;
    public String mTitle;
    public String mYyAnchorBdUid;
    public int mChannel = 0;
    public int mAction = 0;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (AlaSDKShareEmptyActivity.this.mShareItem == null || !AlaSDKShareEmptyActivity.this.mShareItem.d()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, 3));
                AlaSDKShareEmptyActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaSDKShareEmptyActivity.this.shareInBar();
        }
    }

    private ShareItem dealShareEntity() {
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.mTitle;
        shareItem.s = this.mContent;
        if (!StringUtils.isNull(this.mImageUri)) {
            if (this.mImageUri.startsWith("file://")) {
                shareItem.x = this.mImageUri.substring(7);
            } else {
                shareItem.v = Uri.parse(this.mImageUri);
            }
        }
        shareItem.t = this.mLinkUrl;
        shareItem.q = this.mLiveId;
        shareItem.k0 = this.mLiveExtInfo;
        shareItem.z = this.mYyAnchorBdUid;
        return shareItem;
    }

    private void sendChannelShareReq() {
        ShareItem shareItem = this.mShareItem;
        if (shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.mChannel, shareItem, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareInBar() {
        d.a.j0.m1.l.a.a aVar;
        if (!ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) || (aVar = this.mSelectBarController) == null) {
            return;
        }
        if (ListUtils.isEmpty(aVar.b())) {
            this.mSelectBarController.c();
        }
        this.mSelectBarController.e(d.a.c.e.m.b.f(this.mLiveId, 0L), this.mYyAnchorBdUid, this.mShareItem);
    }

    private void showSharePanel() {
        ShareItem shareItem = this.mShareItem;
        if (shareItem == null) {
            return;
        }
        shareItem.j(false);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this, this.mShareItem, true);
        shareDialogConfig.setAlaLiveRoomShare(true);
        shareDialogConfig.setIsSupportNightMode(false);
        shareDialogConfig.setIsLandscape(false);
        shareDialogConfig.setOnDismissListener(new a());
        if (!TextUtils.isEmpty(this.mLiveId) || !TextUtils.isEmpty(this.mYyAnchorBdUid)) {
            shareDialogConfig.addOutsideTextView(g.ala_share_to_tieba_frs_title, d.icon_pure_ala_share_morebar40_svg, new b());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        d.a.j0.m1.l.a.a aVar = this.mSelectBarController;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 24007 && intent != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, Integer.valueOf(intent.getIntExtra("extra_share_status", 2))));
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mSelectBarController = new d.a.j0.m1.l.a.a(getPageContext());
        if (bundle != null) {
            this.mTitle = bundle.getString("title");
            this.mContent = bundle.getString("content");
            this.mImageUri = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.mLinkUrl = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = bundle.getInt("channel");
            this.mAction = bundle.getInt("action");
            this.mLiveId = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.mLiveExtInfo = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
            this.mYyAnchorBdUid = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
        } else if (getIntent() == null) {
            finish();
            return;
        } else {
            this.mTitle = getIntent().getStringExtra("title");
            this.mContent = getIntent().getStringExtra("content");
            this.mImageUri = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.mLinkUrl = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = getIntent().getIntExtra("channel", 0);
            this.mAction = getIntent().getIntExtra("action", 0);
            this.mLiveId = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.mLiveExtInfo = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
            this.mYyAnchorBdUid = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
        }
        this.mShareItem = dealShareEntity();
        int i2 = this.mAction;
        if (i2 == 1) {
            showSharePanel();
        } else if (i2 == 2) {
            sendChannelShareReq();
        } else {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.m1.l.a.a aVar = this.mSelectBarController;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("title", this.mTitle);
        bundle.putString("content", this.mContent);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.mImageUri);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY, this.mLinkUrl);
        bundle.putInt("channel", this.mChannel);
        bundle.putInt("action", this.mAction);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.mLiveId);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO, this.mLiveExtInfo);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID, this.mYyAnchorBdUid);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(0, 0);
    }
}
