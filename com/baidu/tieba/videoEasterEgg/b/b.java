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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b implements a {
    private com.baidu.tieba.videoEasterEgg.a.a jyc = new com.baidu.tieba.videoEasterEgg.a.b();
    private com.baidu.tieba.videoEasterEgg.b jyd;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.videoEasterEgg.b bVar, Intent intent) {
        this.mPageContext = tbPageContext;
        this.jyd = bVar;
        this.jyc.W(intent);
        this.jyc.y(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onClose() {
        if (this.jyd != null) {
            this.jyd.finishActivity();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cun() {
        if (this.mPageContext != null) {
            if (bf.iE() || bc.cE(this.mPageContext.getPageActivity())) {
                ajT();
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cuo() {
        if (this.jyc != null && this.jyd != null) {
            this.jyd.Fu(this.jyc.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void aFm() {
        if (this.jyd != null) {
            this.jyd.Bf();
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cup() {
        if (this.jyd != null && this.jyc != null) {
            this.jyd.eu(this.jyc.getPopText(), this.jyc.getPopImageUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void cuq() {
        if (this.jyc != null) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(this.jyc.getID()), false);
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onResume() {
        playVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        if (this.jyc != null && this.jyd != null) {
            this.jyd.Ft(this.jyc.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onPause() {
    }

    @Override // com.baidu.tieba.videoEasterEgg.b.a
    public void onDestroy() {
    }

    private void ajT() {
        if (this.jyc != null && this.mPageContext != null) {
            final e eVar = new e();
            eVar.title = this.jyc.getShareTitle();
            eVar.content = this.jyc.getShareContent();
            eVar.linkUrl = this.jyc.getShareUrl();
            eVar.cjy = this.jyc.getShareUrl();
            if (!ap.isEmpty(this.jyc.getShareImageUrl())) {
                eVar.imageUri = Uri.parse(this.jyc.getShareImageUrl());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mPageContext.getPageActivity(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoEasterEgg.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aR(eVar.linkUrl);
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
