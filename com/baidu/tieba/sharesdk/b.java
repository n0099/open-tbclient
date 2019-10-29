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
    private com.baidu.tbadk.coreExtra.c.b czi;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.c.b bVar) {
        this.mContext = null;
        this.mContext = context;
        this.czi = bVar;
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
            shareEntity.czc = eVar.czc;
            String str = eVar.linkUrl;
            if (i == 6 && !StringUtils.isNull(eVar.cyF)) {
                str = eVar.cyF;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.Dn(eVar.cyG);
            shareEntity.setLocation(eVar.cyI);
            shareEntity.zc(i);
            shareEntity.E(eVar.ase());
            shareEntity.zd(eVar.shareType);
            shareEntity.setTid(eVar.tid);
            shareEntity.topic = eVar.topic;
            if (i == 6 && !StringUtils.isNull(eVar.cyT)) {
                shareEntity.topic = eVar.cyS + eVar.cyT;
                shareEntity.setContent("");
            }
            shareEntity.cyU = eVar.cyU;
            shareEntity.cyH = eVar.cyH;
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(RequestResponseCode.REQUEST_TO_SHARE, ShareHandlerActivity.class);
        }
    }
}
