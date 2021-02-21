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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.b nUA;
    private com.baidu.tieba.videoEasterEgg.a.a nUz = new com.baidu.tieba.videoEasterEgg.a.b();

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.nUA = bVar;
        this.nUz.M(intent);
        this.nUz.F(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.nUA != null) {
            this.nUA.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void daw() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                buF();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dVh() {
        if (this.nUz != null && this.nUA != null) {
            this.nUA.UQ(this.nUz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cMO() {
        if (this.nUA != null) {
            this.nUA.arY();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dVi() {
        if (this.nUA != null && this.nUz != null) {
            this.nUA.gL(this.nUz.getPopText(), this.nUz.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dVj() {
        if (this.nUz != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.nUz.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dVk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        if (this.nUz != null && this.nUA != null) {
            this.nUA.UP(this.nUz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void buF() {
        if (this.nUz != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.nUz.getShareTitle();
            shareItem.content = this.nUz.getShareContent();
            shareItem.linkUrl = this.nUz.getShareUrl();
            shareItem.fuT = this.nUz.getShareUrl();
            if (!au.isEmpty(this.nUz.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.nUz.getShareImageUrl());
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
                    b.this.dVk();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
