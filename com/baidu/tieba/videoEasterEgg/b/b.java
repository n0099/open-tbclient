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
    private com.baidu.tieba.videoEasterEgg.a.a hBF = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hBG;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hBG = bVar;
        this.hBF.D(intent);
        this.hBF.r(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hBG != null) {
            this.hBG.finishActivity();
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
        if (this.hBF != null && this.hBG != null) {
            this.hBG.wv(this.hBF.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void XF() {
        if (this.hBG != null) {
            this.hBG.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJK() {
        if (this.hBG != null && this.hBF != null) {
            this.hBG.cP(this.hBF.getPopText(), this.hBF.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJL() {
        if (this.hBF != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hBF.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hBF != null && this.hBG != null) {
            this.hBG.wu(this.hBF.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void Eb() {
        if (this.hBF != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hBF.getShareTitle();
            dVar.content = this.hBF.getShareContent();
            dVar.linkUrl = this.hBF.getShareUrl();
            dVar.aNR = this.hBF.getShareUrl();
            if (!ao.isEmpty(this.hBF.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.hBF.getShareImageUrl());
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
