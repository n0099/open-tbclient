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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a jHO = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b jHP;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.jHP = bVar;
        this.jHO.Y(intent);
        this.jHO.y(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.jHP != null) {
            this.jHP.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cym() {
        if (this.mPageContext != null) {
            if (bf.iN() || bc.cF(this.mPageContext.getPageActivity())) {
                alm();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cyn() {
        if (this.jHO != null && this.jHP != null) {
            this.jHP.GK(this.jHO.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void aHm() {
        if (this.jHP != null) {
            this.jHP.BR();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cyo() {
        if (this.jHP != null && this.jHO != null) {
            this.jHP.ew(this.jHO.getPopText(), this.jHO.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cyp() {
        if (this.jHO != null) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.jHO.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.jHO != null && this.jHP != null) {
            this.jHP.GJ(this.jHO.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void alm() {
        if (this.jHO != null && this.mPageContext != null) {
            final e eVar = new e();
            eVar.title = this.jHO.getShareTitle();
            eVar.content = this.jHO.getShareContent();
            eVar.linkUrl = this.jHO.getShareUrl();
            eVar.clF = this.jHO.getShareUrl();
            if (!aq.isEmpty(this.jHO.getShareImageUrl())) {
                eVar.imageUri = Uri.parse(this.jHO.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aS(eVar.linkUrl);
                    l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
