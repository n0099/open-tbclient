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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.b mmA;
    private com.baidu.tieba.videoEasterEgg.a.a mmz = new com.baidu.tieba.videoEasterEgg.a.b();

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.mmA = bVar;
        this.mmz.J(intent);
        this.mmz.E(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.mmA != null) {
            this.mmA.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bhd() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bcy();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dsO() {
        if (this.mmz != null && this.mmA != null) {
            this.mmA.Pj(this.mmz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cYL() {
        if (this.mmA != null) {
            this.mmA.ads();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dsP() {
        if (this.mmA != null && this.mmz != null) {
            this.mmA.fM(this.mmz.getPopText(), this.mmz.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dsQ() {
        if (this.mmz != null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.mmz.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dsR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsR() {
        if (this.mmz != null && this.mmA != null) {
            this.mmA.Pi(this.mmz.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void bcy() {
        if (this.mmz != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.mmz.getShareTitle();
            shareItem.content = this.mmz.getShareContent();
            shareItem.linkUrl = this.mmz.getShareUrl();
            shareItem.etO = this.mmz.getShareUrl();
            if (!as.isEmpty(this.mmz.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.mmz.getShareImageUrl());
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
                    b.this.dsR();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
