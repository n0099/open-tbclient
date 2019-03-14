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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.s.az;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a jfp = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b jfq;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.jfq = bVar;
        this.jfp.T(intent);
        this.jfp.w(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.jfq != null) {
            this.jfq.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cml() {
        if (this.mPageContext != null) {
            if (az.jK() || bc.cZ(this.mPageContext.getPageActivity())) {
                aeX();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmm() {
        if (this.jfp != null && this.jfq != null) {
            this.jfq.DX(this.jfp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void azH() {
        if (this.jfq != null) {
            this.jfq.zY();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmn() {
        if (this.jfq != null && this.jfp != null) {
            this.jfq.eg(this.jfp.getPopText(), this.jfp.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmo() {
        if (this.jfp != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.jfp.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.jfp != null && this.jfq != null) {
            this.jfq.DW(this.jfp.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void aeX() {
        if (this.jfp != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.jfp.getShareTitle();
            dVar.content = this.jfp.getShareContent();
            dVar.linkUrl = this.jfp.getShareUrl();
            dVar.cbt = this.jfp.getShareUrl();
            if (!ap.isEmpty(this.jfp.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.jfp.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(d.j.copy_pb_url_success));
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
