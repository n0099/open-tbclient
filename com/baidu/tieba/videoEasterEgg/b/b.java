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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.a.a mfh = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b mfi;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.mfi = bVar;
        this.mfh.I(intent);
        this.mfh.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.mfi != null) {
            this.mfi.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dpE() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                aYB();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dpF() {
        if (this.mfh != null && this.mfi != null) {
            this.mfi.OB(this.mfh.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cUY() {
        if (this.mfi != null) {
            this.mfi.acn();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dpG() {
        if (this.mfi != null && this.mfh != null) {
            this.mfi.fK(this.mfh.getPopText(), this.mfh.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dpH() {
        if (this.mfh != null) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.mfh.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dpI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpI() {
        if (this.mfh != null && this.mfi != null) {
            this.mfi.OA(this.mfh.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void aYB() {
        if (this.mfh != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.mfh.getShareTitle();
            shareItem.content = this.mfh.getShareContent();
            shareItem.linkUrl = this.mfh.getShareUrl();
            shareItem.enC = this.mfh.getShareUrl();
            if (!ar.isEmpty(this.mfh.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.mfh.getShareImageUrl());
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
                    b.this.dpI();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
