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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a lLn = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b lLo;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.lLo = bVar;
        this.lLn.I(intent);
        this.lLn.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.lLo != null) {
            this.lLo.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dlo() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                aWJ();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dlp() {
        if (this.lLn != null && this.lLo != null) {
            this.lLo.NY(this.lLn.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cQG() {
        if (this.lLo != null) {
            this.lLo.abh();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dlq() {
        if (this.lLo != null && this.lLn != null) {
            this.lLo.fA(this.lLn.getPopText(), this.lLn.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dlr() {
        if (this.lLn != null) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.lLn.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dls() {
        if (this.lLn != null && this.lLo != null) {
            this.lLo.NX(this.lLn.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void aWJ() {
        if (this.lLn != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.lLn.getShareTitle();
            shareItem.content = this.lLn.getShareContent();
            shareItem.linkUrl = this.lLn.getShareUrl();
            shareItem.eeR = this.lLn.getShareUrl();
            if (!aq.isEmpty(this.lLn.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.lLn.getShareImageUrl());
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
                    b.this.dls();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
