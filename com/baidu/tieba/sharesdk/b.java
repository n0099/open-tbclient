package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes6.dex */
public class b implements com.baidu.tbadk.coreExtra.c.c {
    private com.baidu.tbadk.coreExtra.c.b cyr;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.c.b bVar) {
        this.mContext = null;
        this.mContext = context;
        this.cyr = bVar;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(e eVar, int i, boolean z) {
        b(eVar, i);
    }

    private void b(e eVar, int i) {
        if (this.mContext != null && eVar != null) {
            IntentConfig intentConfig = new IntentConfig(this.mContext);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(eVar.title);
            shareEntity.setContent(eVar.content);
            shareEntity.setImageUri(eVar.imageUri);
            shareEntity.cyl = eVar.cyl;
            String str = eVar.linkUrl;
            if (i == 6 && !StringUtils.isNull(eVar.cxO)) {
                str = eVar.cxO;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Dn(eVar.cxP);
            shareEntity.setLocation(eVar.cxR);
            shareEntity.zb(i);
            shareEntity.E(eVar.asc());
            shareEntity.zc(eVar.shareType);
            shareEntity.setTid(eVar.tid);
            shareEntity.topic = eVar.topic;
            if (i == 6 && !StringUtils.isNull(eVar.cyc)) {
                shareEntity.topic = eVar.cyb + eVar.cyc;
                shareEntity.setContent("");
            }
            shareEntity.cyd = eVar.cyd;
            shareEntity.cxQ = eVar.cxQ;
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(RequestResponseCode.REQUEST_TO_SHARE, ShareHandlerActivity.class);
        }
    }
}
