package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.share.ImplicitShareMessage;
/* loaded from: classes4.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    private String dXX;
    private String jUu;
    private String jUv;
    private com.baidu.tieba.livesdk.share.a.a jUw;
    private String mContent;
    private String mLiveId;
    private ShareItem mShareItem;
    private String mTitle;
    private int mChannel = 0;
    private int mAction = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.jUw = new com.baidu.tieba.livesdk.share.a.a(getPageContext());
        if (bundle != null) {
            this.mTitle = bundle.getString("title");
            this.mContent = bundle.getString("content");
            this.jUu = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.dXX = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = bundle.getInt("channel");
            this.mAction = bundle.getInt("action");
            this.mLiveId = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.jUv = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
        } else if (getIntent() == null) {
            finish();
            return;
        } else {
            this.mTitle = getIntent().getStringExtra("title");
            this.mContent = getIntent().getStringExtra("content");
            this.jUu = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.dXX = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = getIntent().getIntExtra("channel", 0);
            this.mAction = getIntent().getIntExtra("action", 0);
            this.mLiveId = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            this.jUv = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
        }
        this.mShareItem = cNT();
        if (this.mAction == 1) {
            cNS();
        } else if (this.mAction == 2) {
            cNR();
        } else {
            finish();
        }
    }

    private void cNR() {
        if (this.mShareItem != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.mChannel, this.mShareItem, true));
        }
    }

    private void cNS() {
        if (this.mShareItem != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this, this.mShareItem, true);
            shareDialogConfig.setAlaLiveRoomShare(true);
            shareDialogConfig.setIsSupportNightMode(false);
            shareDialogConfig.setIsLandscape(false);
            shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaSDKShareEmptyActivity.this.finish();
                }
            });
            shareDialogConfig.addOutsideTextView(b.C0735b.ala_share_to_tieba_frs_title, b.a.icon_pure_ala_share_morebar40_svg, new View.OnClickListener() { // from class: com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSDKShareEmptyActivity.this.cNU();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            if (this.jUw != null) {
                this.jUw.cNW();
            }
        }
    }

    private ShareItem cNT() {
        ShareItem shareItem = new ShareItem();
        shareItem.title = this.mTitle;
        shareItem.content = this.mContent;
        if (!StringUtils.isNull(this.jUu)) {
            if (this.jUu.startsWith("file://")) {
                shareItem.localFile = this.jUu.substring(7);
            } else {
                shareItem.imageUri = Uri.parse(this.jUu);
            }
        }
        shareItem.linkUrl = this.dXX;
        shareItem.extData = this.mLiveId;
        shareItem.extLiveInfo = this.jUv;
        return shareItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNU() {
        if (bg.checkUpIsLogin(getPageContext().getPageActivity()) && this.jUw != null) {
            if (y.isEmpty(this.jUw.cNX())) {
                this.jUw.cNW();
            }
            this.jUw.fv(com.baidu.adp.lib.f.b.toLong(this.mLiveId, 0L));
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("title", this.mTitle);
        bundle.putString("content", this.mContent);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.jUu);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY, this.dXX);
        bundle.putInt("channel", this.mChannel);
        bundle.putInt("action", this.mAction);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.mLiveId);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO, this.jUv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jUw != null) {
            this.jUw.onDestroy();
        }
    }
}
