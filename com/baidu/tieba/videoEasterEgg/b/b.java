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
/* loaded from: classes22.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.a.a nws = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b nwt;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.nwt = bVar;
        this.nws.L(intent);
        this.nws.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.nwt != null) {
            this.nwt.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bxM() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bsT();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRI() {
        if (this.nws != null && this.nwt != null) {
            this.nwt.Ul(this.nws.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dwR() {
        if (this.nwt != null) {
            this.nwt.arD();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRJ() {
        if (this.nwt != null && this.nws != null) {
            this.nwt.gC(this.nws.getPopText(), this.nws.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dRK() {
        if (this.nws != null) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.nws.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dRL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRL() {
        if (this.nws != null && this.nwt != null) {
            this.nwt.Uk(this.nws.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void bsT() {
        if (this.nws != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.nws.getShareTitle();
            shareItem.content = this.nws.getShareContent();
            shareItem.linkUrl = this.nws.getShareUrl();
            shareItem.fgS = this.nws.getShareUrl();
            if (!at.isEmpty(this.nws.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.nws.getShareImageUrl());
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
                    b.this.dRL();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
