package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.d;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes23.dex */
public class b implements d {
    private com.baidu.tbadk.coreExtra.share.c eHb;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.share.c cVar) {
        this.mContext = null;
        this.mContext = context;
        this.eHb = cVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.d
    public void a(ShareItem shareItem, int i, boolean z) {
        b(shareItem, i);
    }

    private void b(ShareItem shareItem, int i) {
        if (this.mContext != null && shareItem != null) {
            IntentConfig intentConfig = new IntentConfig(this.mContext);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(shareItem.title);
            shareEntity.setContent(shareItem.content);
            shareEntity.gi(shareItem.readCount);
            shareEntity.vS(shareItem.eGH == 2 || shareItem.eGH == 6 || shareItem.eGH == 8);
            shareEntity.setImageUri(shareItem.imageUri);
            shareEntity.canShareBySmartApp = shareItem.canShareBySmartApp;
            String str = shareItem.linkUrl;
            if (i == 6 && !StringUtils.isNull(shareItem.eGy)) {
                str = shareItem.eGy;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Qy(shareItem.localFile);
            shareEntity.setLocation(shareItem.location);
            shareEntity.HC(i);
            shareEntity.ae(shareItem.bqr());
            shareEntity.HE(shareItem.shareType);
            shareEntity.setTid(shareItem.tid);
            shareEntity.QA(shareItem.fName);
            shareEntity.HD(shareItem.typeShareToSmallApp);
            shareEntity.topic = shareItem.topic;
            if (i == 6 && !StringUtils.isNull(shareItem.eGJ)) {
                shareEntity.topic = shareItem.eGI + shareItem.eGJ;
                shareEntity.setContent("");
            }
            shareEntity.taskCompleteId = shareItem.taskCompleteId;
            shareEntity.diskPicOperate = shareItem.diskPicOperate;
            shareEntity.Qz(shareItem.extLiveInfo);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(RequestResponseCode.REQUEST_TO_SHARE, ShareHandlerActivity.class);
        }
    }
}
