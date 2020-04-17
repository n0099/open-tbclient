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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.share.ImplicitShareMessage;
/* loaded from: classes3.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    private String dnT;
    private String iPv;
    private com.baidu.tieba.livesdk.share.a.a iPw;
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
        this.iPw = new com.baidu.tieba.livesdk.share.a.a(getPageContext());
        if (bundle != null) {
            this.mTitle = bundle.getString("title");
            this.mContent = bundle.getString("content");
            this.iPv = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.dnT = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = bundle.getInt("channel");
            this.mAction = bundle.getInt("action");
            this.mLiveId = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
        } else if (getIntent() == null) {
            finish();
            return;
        } else {
            this.mTitle = getIntent().getStringExtra("title");
            this.mContent = getIntent().getStringExtra("content");
            this.iPv = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.dnT = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = getIntent().getIntExtra("channel", 0);
            this.mAction = getIntent().getIntExtra("action", 0);
            this.mLiveId = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
        }
        this.mShareItem = coE();
        if (this.mAction == 1) {
            coD();
        } else if (this.mAction == 2) {
            coC();
        } else {
            finish();
        }
    }

    private void coC() {
        if (this.mShareItem != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.mChannel, this.mShareItem, true));
        }
    }

    private void coD() {
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
            shareDialogConfig.addOutsideTextView(b.C0589b.ala_share_to_tieba_frs_title, b.a.icon_pure_ala_share_morebar40_svg, new View.OnClickListener() { // from class: com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSDKShareEmptyActivity.this.coF();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            if (this.iPw != null) {
                this.iPw.coH();
            }
        }
    }

    private ShareItem coE() {
        ShareItem shareItem = new ShareItem();
        shareItem.title = this.mTitle;
        shareItem.content = this.mContent;
        if (!StringUtils.isNull(this.iPv)) {
            if (this.iPv.startsWith("file://")) {
                shareItem.localFile = this.iPv.substring(7);
            } else {
                shareItem.imageUri = Uri.parse(this.iPv);
            }
        }
        shareItem.linkUrl = this.dnT;
        shareItem.extData = this.mLiveId;
        return shareItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coF() {
        if (bc.checkUpIsLogin(getPageContext().getPageActivity()) && this.iPw != null) {
            if (v.isEmpty(this.iPw.coI())) {
                this.iPw.coH();
            }
            this.iPw.eR(com.baidu.adp.lib.f.b.toLong(this.mLiveId, 0L));
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
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.iPv);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY, this.dnT);
        bundle.putInt("channel", this.mChannel);
        bundle.putInt("action", this.mAction);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, this.mLiveId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iPw != null) {
            this.iPw.onDestroy();
        }
    }
}
