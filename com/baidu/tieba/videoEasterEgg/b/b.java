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
import com.baidu.tbadk.p.aw;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a hBE = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hBF;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hBF = bVar;
        this.hBE.D(intent);
        this.hBE.r(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hBF != null) {
            this.hBF.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJI() {
        if (this.mPageContext != null) {
            if (aw.jL() || ba.bI(this.mPageContext.getPageActivity())) {
                Eb();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJJ() {
        if (this.hBE != null && this.hBF != null) {
            this.hBF.wv(this.hBE.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void XE() {
        if (this.hBF != null) {
            this.hBF.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJK() {
        if (this.hBF != null && this.hBE != null) {
            this.hBF.cP(this.hBE.getPopText(), this.hBE.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJL() {
        if (this.hBE != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hBE.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hBE != null && this.hBF != null) {
            this.hBF.wu(this.hBE.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void Eb() {
        if (this.hBE != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hBE.getShareTitle();
            dVar.content = this.hBE.getShareContent();
            dVar.linkUrl = this.hBE.getShareUrl();
            dVar.aNR = this.hBE.getShareUrl();
            if (!ao.isEmpty(this.hBE.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.hBE.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(e.j.copy_pb_url_success));
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
