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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.o.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a gUF = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b gUG;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.gUG = bVar;
        this.gUF.C(intent);
        this.gUF.r(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.gUG != null) {
            this.gUG.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bzq() {
        if (this.mPageContext != null) {
            if (ap.fz() || az.aK(this.mPageContext.getPageActivity())) {
                xd();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bzr() {
        if (this.gUF != null && this.gUG != null) {
            this.gUG.up(this.gUF.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bzs() {
        if (this.gUG != null) {
            this.gUG.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bzt() {
        if (this.gUG != null && this.gUF != null) {
            this.gUG.cl(this.gUF.getPopText(), this.gUF.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bzu() {
        if (this.gUF != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.gUF.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.gUF != null && this.gUG != null) {
            this.gUG.uo(this.gUF.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void xd() {
        if (this.gUF != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.gUF.getShareTitle();
            dVar.content = this.gUF.getShareContent();
            dVar.linkUrl = this.gUF.getShareUrl();
            dVar.awU = this.gUF.getShareUrl();
            if (!an.isEmpty(this.gUF.getShareImageUrl())) {
                dVar.awV = Uri.parse(this.gUF.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.util.a.aB(dVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view2.getResources().getString(d.k.copy_pb_url_success));
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
