package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
/* loaded from: classes6.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    private String bXT;
    private String hki;
    private String mContent;
    private e mShareItem;
    private String mTitle;
    private int mChannel = 0;
    private int hkj = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (bundle != null) {
            this.mTitle = bundle.getString("title");
            this.mContent = bundle.getString("content");
            this.hki = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.bXT = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = bundle.getInt("channel");
            this.hkj = bundle.getInt("action");
        } else if (getIntent() == null) {
            finish();
            return;
        } else {
            this.mTitle = getIntent().getStringExtra("title");
            this.mContent = getIntent().getStringExtra("content");
            this.hki = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
            this.bXT = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
            this.mChannel = getIntent().getIntExtra("channel", 0);
            this.hkj = getIntent().getIntExtra("action", 0);
        }
        this.mShareItem = bJG();
        if (this.hkj == 1) {
            bJF();
        } else if (this.hkj == 2) {
            bJE();
        } else {
            finish();
        }
    }

    private void bJE() {
        if (this.mShareItem != null) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.mChannel, this.mShareItem, true));
        }
    }

    private void bJF() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private e bJG() {
        e eVar = new e();
        eVar.title = this.mTitle;
        eVar.content = this.mContent;
        if (!StringUtils.isNull(this.hki)) {
            if (this.hki.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                eVar.cxP = this.hki.substring(7);
            } else {
                eVar.imageUri = Uri.parse(this.hki);
            }
        }
        eVar.linkUrl = this.bXT;
        return eVar;
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
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.hki);
        bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY, this.bXT);
        bundle.putInt("channel", this.mChannel);
        bundle.putInt("action", this.hkj);
    }
}
