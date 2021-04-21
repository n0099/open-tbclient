package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.share.ImplicitShareMessage;
import d.b.j0.m1.c;
import d.b.j0.m1.f;
/* loaded from: classes3.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    public String mContent;
    public String mImageUri;
    public String mLinkUrl;
    public String mLiveExtInfo;
    public String mLiveId;
    public d.b.j0.m1.k.a.a mSelectBarController;
    public ShareItem mShareItem;
    public String mTitle;
    public int mChannel = 0;
    public int mAction = 0;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AlaSDKShareEmptyActivity.this.finish();
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
        shareItem.i0 = this.mLiveExtInfo;
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
        d.b.j0.m1.k.a.a aVar;
        if (!ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) || (aVar = this.mSelectBarController) == null) {
            return;
        }
        if (ListUtils.isEmpty(aVar.b())) {
            this.mSelectBarController.c();
        }
        this.mSelectBarController.e(d.b.c.e.m.b.f(this.mLiveId, 0L));
    }

    private void showSharePanel() {
        if (this.mShareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this, this.mShareItem, true);
        shareDialogConfig.setAlaLiveRoomShare(true);
        shareDialogConfig.setIsSupportNightMode(false);
        shareDialogConfig.setIsLandscape(false);
        shareDialogConfig.setOnDismissListener(new a());
        if (!TextUtils.isEmpty(this.mLiveId)) {
            shareDialogConfig.addOutsideTextView(f.ala_share_to_tieba_frs_title, c.icon_pure_ala_share_morebar40_svg, new b());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        d.b.j0.m1.k.a.a aVar = this.mSelectBarController;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mSelectBarController = new d.b.j0.m1.k.a.a(getPageContext());
        if (bundle != null) {
            this.mTitle = bundle.getString("title");
            this.mContent = bundle.getString("content");
            this.mImageUri = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.mLinkUrl = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = bundle.getInt("channel");
            this.mAction = bundle.getInt("action");
            this.mLiveId = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.mLiveExtInfo = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
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
        }
        this.mShareItem = dealShareEntity();
        int i = this.mAction;
        if (i == 1) {
            showSharePanel();
        } else if (i == 2) {
            sendChannelShareReq();
        } else {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.m1.k.a.a aVar = this.mSelectBarController;
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
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }
}
