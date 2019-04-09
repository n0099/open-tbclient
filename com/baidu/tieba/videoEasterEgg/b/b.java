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
    private com.baidu.tieba.videoEasterEgg.a.a jfe = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b jff;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.jff = bVar;
        this.jfe.T(intent);
        this.jfe.w(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.jff != null) {
            this.jff.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmj() {
        if (this.mPageContext != null) {
            if (az.jK() || bc.cZ(this.mPageContext.getPageActivity())) {
                aeU();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmk() {
        if (this.jfe != null && this.jff != null) {
            this.jff.DW(this.jfe.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void azE() {
        if (this.jff != null) {
            this.jff.zX();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cml() {
        if (this.jff != null && this.jfe != null) {
            this.jff.eh(this.jfe.getPopText(), this.jfe.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cmm() {
        if (this.jfe != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.jfe.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.jfe != null && this.jff != null) {
            this.jff.DV(this.jfe.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void aeU() {
        if (this.jfe != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.jfe.getShareTitle();
            dVar.content = this.jfe.getShareContent();
            dVar.linkUrl = this.jfe.getShareUrl();
            dVar.cbw = this.jfe.getShareUrl();
            if (!ap.isEmpty(this.jfe.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.jfe.getShareImageUrl());
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
