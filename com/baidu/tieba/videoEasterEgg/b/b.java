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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a jGN = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b jGO;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.jGO = bVar;
        this.jGN.ae(intent);
        this.jGN.z(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.jGO != null) {
            this.jGO.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cwa() {
        if (this.mPageContext != null) {
            if (bf.isOn() || bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                anY();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cwb() {
        if (this.jGN != null && this.jGO != null) {
            this.jGO.Fm(this.jGN.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void aHx() {
        if (this.jGO != null) {
            this.jGO.GM();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cwc() {
        if (this.jGO != null && this.jGN != null) {
            this.jGO.ei(this.jGN.getPopText(), this.jGN.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cwd() {
        if (this.jGN != null) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.jGN.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.jGN != null && this.jGO != null) {
            this.jGO.Fl(this.jGN.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void anY() {
        if (this.jGN != null && this.mPageContext != null) {
            final e eVar = new e();
            eVar.title = this.jGN.getShareTitle();
            eVar.content = this.jGN.getShareContent();
            eVar.linkUrl = this.jGN.getShareUrl();
            eVar.cxO = this.jGN.getShareUrl();
            if (!aq.isEmpty(this.jGN.getShareImageUrl())) {
                eVar.imageUri = Uri.parse(this.jGN.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(eVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.playVideo();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
