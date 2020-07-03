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
    private com.baidu.tbadk.coreExtra.share.b eob;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.share.b bVar) {
        this.mContext = null;
        this.mContext = context;
        this.eob = bVar;
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
            shareEntity.ft(shareItem.readCount);
            shareEntity.up(shareItem.enL == 2 || shareItem.enL == 6 || shareItem.enL == 8);
            shareEntity.setImageUri(shareItem.imageUri);
            shareEntity.canShareBySmartApp = shareItem.canShareBySmartApp;
            String str = shareItem.linkUrl;
            if (i == 6 && !StringUtils.isNull(shareItem.enC)) {
                str = shareItem.enC;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Ms(shareItem.localFile);
            shareEntity.setLocation(shareItem.location);
            shareEntity.Eg(i);
            shareEntity.ae(shareItem.bde());
            shareEntity.Ei(shareItem.shareType);
            shareEntity.setTid(shareItem.tid);
            shareEntity.Mu(shareItem.fName);
            shareEntity.Eh(shareItem.typeShareToSmallApp);
            shareEntity.topic = shareItem.topic;
            if (i == 6 && !StringUtils.isNull(shareItem.enN)) {
                shareEntity.topic = shareItem.enM + shareItem.enN;
                shareEntity.setContent("");
            }
            shareEntity.taskCompleteId = shareItem.taskCompleteId;
            shareEntity.diskPicOperate = shareItem.diskPicOperate;
            shareEntity.Mt(shareItem.extLiveInfo);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(RequestResponseCode.REQUEST_TO_SHARE, ShareHandlerActivity.class);
        }
    }
}
