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
/* loaded from: classes22.dex */
public class b implements a {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.videoEasterEgg.a.a nLC = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b nLD;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.nLD = bVar;
        this.nLC.L(intent);
        this.nLC.D(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.nLD != null) {
            this.nLD.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bAC() {
        if (this.mPageContext != null) {
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bvJ();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dXc() {
        if (this.nLC != null && this.nLD != null) {
            this.nLD.Vl(this.nLC.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dBK() {
        if (this.nLD != null) {
            this.nLD.aud();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dXd() {
        if (this.nLD != null && this.nLC != null) {
            this.nLD.gH(this.nLC.getPopText(), this.nLC.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void dXe() {
        if (this.nLC != null) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.nLC.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        dXf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXf() {
        if (this.nLC != null && this.nLD != null) {
            this.nLD.Vk(this.nLC.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void bvJ() {
        if (this.nLC != null && this.mPageContext != null) {
            final ShareItem shareItem = new ShareItem();
            shareItem.title = this.nLC.getShareTitle();
            shareItem.content = this.nLC.getShareContent();
            shareItem.linkUrl = this.nLC.getShareUrl();
            shareItem.fnA = this.nLC.getShareUrl();
            if (!au.isEmpty(this.nLC.getShareImageUrl())) {
                shareItem.imageUri = Uri.parse(this.nLC.getShareImageUrl());
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
                    b.this.dXf();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
