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
import com.baidu.tbadk.p.ax;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a hKB = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hKC;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hKC = bVar;
        this.hKB.D(intent);
        this.hKB.r(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hKC != null) {
            this.hKC.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bLm() {
        if (this.mPageContext != null) {
            if (ax.jJ() || ba.bJ(this.mPageContext.getPageActivity())) {
                Fp();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bLn() {
        if (this.hKB != null && this.hKC != null) {
            this.hKC.xd(this.hKB.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void YS() {
        if (this.hKC != null) {
            this.hKC.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bLo() {
        if (this.hKC != null && this.hKB != null) {
            this.hKC.cU(this.hKB.getPopText(), this.hKB.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bLp() {
        if (this.hKB != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hKB.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hKB != null && this.hKC != null) {
            this.hKC.xc(this.hKB.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void Fp() {
        if (this.hKB != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hKB.getShareTitle();
            dVar.content = this.hKB.getShareContent();
            dVar.linkUrl = this.hKB.getShareUrl();
            dVar.aSg = this.hKB.getShareUrl();
            if (!ao.isEmpty(this.hKB.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.hKB.getShareImageUrl());
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
