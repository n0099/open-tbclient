package com.baidu.tieba.videoEasterEgg.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a mEm = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b mEn;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.mEn = bVar;
        this.mEm.L(intent);
        this.mEm.E(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.mEn != null) {
            this.mEn.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bpP() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bkV();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dEj() {
        if (this.mEm != null && this.mEn != null) {
            this.mEn.Sh(this.mEm.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void djO() {
        if (this.mEn != null) {
            this.mEn.ajN();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dEk() {
        if (this.mEn != null && this.mEm != null) {
            this.mEn.gd(this.mEm.getPopText(), this.mEm.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dEl() {
        if (this.mEm != null) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.mEm.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dEm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEm() {
        if (this.mEm != null && this.mEn != null) {
            this.mEn.Sg(this.mEm.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void bkV() {
        if (this.mEm != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.mEm.getShareTitle();
            shareItem.content = this.mEm.getShareContent();
            shareItem.linkUrl = this.mEm.getShareUrl();
            shareItem.eEo = this.mEm.getShareUrl();
            if (!at.isEmpty(this.mEm.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.mEm.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.dEm();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
