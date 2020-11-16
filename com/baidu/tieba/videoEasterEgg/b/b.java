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
/* loaded from: classes21.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.b nxA;
    private com.baidu.tieba.videoEasterEgg.a.a nxz = new com.baidu.tieba.videoEasterEgg.a.b();

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.nxA = bVar;
        this.nxz.L(intent);
        this.nxz.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.nxA != null) {
            this.nxA.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bxc() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bsj();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRH() {
        if (this.nxz != null && this.nxA != null) {
            this.nxA.TW(this.nxz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dwr() {
        if (this.nxA != null) {
            this.nxA.aqV();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRI() {
        if (this.nxA != null && this.nxz != null) {
            this.nxA.gC(this.nxz.getPopText(), this.nxz.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRJ() {
        if (this.nxz != null) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.nxz.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dRK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRK() {
        if (this.nxz != null && this.nxA != null) {
            this.nxA.TV(this.nxz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void bsj() {
        if (this.nxz != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.nxz.getShareTitle();
            shareItem.content = this.nxz.getShareContent();
            shareItem.linkUrl = this.nxz.getShareUrl();
            shareItem.fga = this.nxz.getShareUrl();
            if (!au.isEmpty(this.nxz.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.nxz.getShareImageUrl());
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
                    b.this.dRK();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
