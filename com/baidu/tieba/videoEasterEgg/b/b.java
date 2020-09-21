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
/* loaded from: classes21.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a mOp = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b mOq;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.mOq = bVar;
        this.mOp.L(intent);
        this.mOp.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.mOq != null) {
            this.mOq.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bqK() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                blQ();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dIm() {
        if (this.mOp != null && this.mOq != null) {
            this.mOq.SH(this.mOp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dnx() {
        if (this.mOq != null) {
            this.mOq.akx();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dIn() {
        if (this.mOq != null && this.mOp != null) {
            this.mOq.gq(this.mOp.getPopText(), this.mOp.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dIo() {
        if (this.mOp != null) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.mOp.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIp() {
        if (this.mOp != null && this.mOq != null) {
            this.mOq.SG(this.mOp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void blQ() {
        if (this.mOp != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.mOp.getShareTitle();
            shareItem.content = this.mOp.getShareContent();
            shareItem.linkUrl = this.mOp.getShareUrl();
            shareItem.eGy = this.mOp.getShareUrl();
            if (!at.isEmpty(this.mOp.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.mOp.getShareImageUrl());
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
                    b.this.dIp();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
