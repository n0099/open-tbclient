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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.p.at;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a hmD = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b hmE;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.hmE = bVar;
        this.hmD.C(intent);
        this.hmD.s(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.hmE != null) {
            this.hmE.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bDG() {
        if (this.mPageContext != null) {
            if (at.iq() || bb.aU(this.mPageContext.getPageActivity())) {
                AJ();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bDH() {
        if (this.hmD != null && this.hmE != null) {
            this.hmE.vl(this.hmD.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bDI() {
        if (this.hmE != null) {
            this.hmE.akh();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bDJ() {
        if (this.hmE != null && this.hmD != null) {
            this.hmE.cu(this.hmD.getPopText(), this.hmD.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void bDK() {
        if (this.hmD != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.hmD.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.hmD != null && this.hmE != null) {
            this.hmE.vk(this.hmD.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void AJ() {
        if (this.hmD != null && this.mPageContext != null) {
            final d dVar = new d();
            dVar.title = this.hmD.getShareTitle();
            dVar.content = this.hmD.getShareContent();
            dVar.linkUrl = this.hmD.getShareUrl();
            dVar.aGb = this.hmD.getShareUrl();
            if (!ap.isEmpty(this.hmD.getShareImageUrl())) {
                dVar.imageUri = Uri.parse(this.hmD.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aQ(dVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(f.j.copy_pb_url_success));
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
