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
    private com.baidu.tieba.videoEasterEgg.a.a hDp = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hDq;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hDq = bVar;
        this.hDp.D(intent);
        this.hDp.r(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hDq != null) {
            this.hDq.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJh() {
        if (this.mPageContext != null) {
            if (ax.jJ() || ba.bG(this.mPageContext.getPageActivity())) {
                El();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJi() {
        if (this.hDp != null && this.hDq != null) {
            this.hDq.wA(this.hDp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void XP() {
        if (this.hDq != null) {
            this.hDq.showErrorView();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJj() {
        if (this.hDq != null && this.hDp != null) {
            this.hDq.cP(this.hDp.getPopText(), this.hDp.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bJk() {
        if (this.hDp != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hDp.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hDp != null && this.hDq != null) {
            this.hDq.wz(this.hDp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void El() {
        if (this.hDp != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hDp.getShareTitle();
            dVar.content = this.hDp.getShareContent();
            dVar.linkUrl = this.hDp.getShareUrl();
            dVar.aOH = this.hDp.getShareUrl();
            if (!ao.isEmpty(this.hDp.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.hDp.getShareImageUrl());
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
