package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes9.dex */
public class b implements com.baidu.tbadk.coreExtra.share.c {
    private com.baidu.tbadk.coreExtra.share.b dmp;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.share.b bVar) {
        this.mContext = null;
        this.mContext = context;
        this.dmp = bVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.c
    public void a(ShareItem shareItem, int i, boolean z) {
        b(shareItem, i);
    }

    private void b(ShareItem shareItem, int i) {
        if (this.mContext != null && shareItem != null) {
            IntentConfig intentConfig = new IntentConfig(this.mContext);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(shareItem.title);
            shareEntity.setContent(shareItem.content);
            shareEntity.setImageUri(shareItem.imageUri);
            shareEntity.canShareBySmartApp = shareItem.canShareBySmartApp;
            String str = shareItem.linkUrl;
            if (i == 6 && !StringUtils.isNull(shareItem.dlQ)) {
                str = shareItem.dlQ;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Ij(shareItem.localFile);
            shareEntity.setLocation(shareItem.location);
            shareEntity.BB(i);
            shareEntity.Y(shareItem.aJV());
            shareEntity.BD(shareItem.shareType);
            shareEntity.setTid(shareItem.tid);
            shareEntity.Ik(shareItem.fName);
            shareEntity.BC(shareItem.typeShareToSmallApp);
            shareEntity.topic = shareItem.topic;
            if (i == 6 && !StringUtils.isNull(shareItem.dmb)) {
                shareEntity.topic = shareItem.dma + shareItem.dmb;
                shareEntity.setContent("");
            }
            shareEntity.taskCompleteId = shareItem.taskCompleteId;
            shareEntity.diskPicOperate = shareItem.diskPicOperate;
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(RequestResponseCode.REQUEST_TO_SHARE, ShareHandlerActivity.class);
        }
    }
}
