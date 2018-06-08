package com.baidu.tieba.videoEasterEgg.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.o.ar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a hhh = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hhi;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hhi = bVar;
        this.hhh.C(intent);
        this.hhh.s(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hhi != null) {
            this.hhi.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bEu() {
        if (this.mPageContext != null) {
            if (ar.ip() || ba.aU(this.mPageContext.getPageActivity())) {
                AD();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bEv() {
        if (this.hhh != null && this.hhi != null) {
            this.hhi.vm(this.hhh.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bEw() {
        if (this.hhi != null) {
            this.hhi.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bEx() {
        if (this.hhi != null && this.hhh != null) {
            this.hhi.ct(this.hhh.getPopText(), this.hhh.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bEy() {
        if (this.hhh != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hhh.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hhh != null && this.hhi != null) {
            this.hhi.vl(this.hhh.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void AD() {
        if (this.hhh != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hhh.getShareTitle();
            dVar.content = this.hhh.getShareContent();
            dVar.linkUrl = this.hhh.getShareUrl();
            dVar.aFi = this.hhh.getShareUrl();
            if (!ao.isEmpty(this.hhh.getShareImageUrl())) {
                dVar.aFj = Uri.parse(this.hhh.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aN(dVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(d.k.copy_pb_url_success));
                }
            });
            shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.playVideo();
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
