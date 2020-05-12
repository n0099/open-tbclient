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
    private com.baidu.tieba.videoEasterEgg.a.a lrA = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b lrB;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.lrB = bVar;
        this.lrA.L(intent);
        this.lrA.A(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.lrB != null) {
            this.lrB.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void ddL() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                aQA();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void ddM() {
        if (this.lrA != null && this.lrB != null) {
            this.lrB.Mk(this.lrA.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cJr() {
        if (this.lrB != null) {
            this.lrB.Yl();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void ddN() {
        if (this.lrB != null && this.lrA != null) {
            this.lrB.eZ(this.lrA.getPopText(), this.lrA.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void ddO() {
        if (this.lrA != null) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.lrA.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        ddP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddP() {
        if (this.lrA != null && this.lrB != null) {
            this.lrB.Mj(this.lrA.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void aQA() {
        if (this.lrA != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.lrA.getShareTitle();
            shareItem.content = this.lrA.getShareContent();
            shareItem.linkUrl = this.lrA.getShareUrl();
            shareItem.dQy = this.lrA.getShareUrl();
            if (!aq.isEmpty(this.lrA.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.lrA.getShareImageUrl());
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
                    b.this.ddP();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
