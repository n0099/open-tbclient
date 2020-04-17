package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes11.dex */
public class b implements com.baidu.tbadk.coreExtra.share.c {
    private com.baidu.tbadk.coreExtra.share.b dQS;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.share.b bVar) {
        this.mContext = null;
        this.mContext = context;
        this.dQS = bVar;
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
            shareEntity.fp(shareItem.readCount);
            shareEntity.tC(shareItem.dQC == 2 || shareItem.dQC == 6 || shareItem.dQC == 8);
            shareEntity.setImageUri(shareItem.imageUri);
            shareEntity.canShareBySmartApp = shareItem.canShareBySmartApp;
            String str = shareItem.linkUrl;
            if (i == 6 && !StringUtils.isNull(shareItem.dQt)) {
                str = shareItem.dQt;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Kb(shareItem.localFile);
            shareEntity.setLocation(shareItem.location);
            shareEntity.Cs(i);
            shareEntity.Y(shareItem.aUT());
            shareEntity.Cu(shareItem.shareType);
            shareEntity.setTid(shareItem.tid);
            shareEntity.Kc(shareItem.fName);
            shareEntity.Ct(shareItem.typeShareToSmallApp);
            shareEntity.topic = shareItem.topic;
            if (i == 6 && !StringUtils.isNull(shareItem.dQE)) {
                shareEntity.topic = shareItem.dQD + shareItem.dQE;
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
