package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.coreExtra.c.b {
    private com.baidu.tbadk.coreExtra.c.a aSx;
    private Context mContext;

    public b(Context context, com.baidu.tbadk.coreExtra.c.a aVar) {
        this.mContext = null;
        this.mContext = context;
        this.aSx = aVar;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public void a(d dVar, int i, boolean z) {
        b(dVar, i);
    }

    private void b(d dVar, int i) {
        if (this.mContext != null && dVar != null) {
            IntentConfig intentConfig = new IntentConfig(this.mContext);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(dVar.title);
            shareEntity.setContent(dVar.content);
            shareEntity.setImageUri(dVar.imageUri);
            String str = dVar.linkUrl;
            if (i == 6 && !StringUtils.isNull(dVar.aSi)) {
                str = dVar.aSi;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.setLocation(dVar.aSj);
            shareEntity.uO(i);
            shareEntity.k(dVar.Kh());
            shareEntity.uP(dVar.shareType);
            shareEntity.topic = dVar.topic;
            shareEntity.aSq = dVar.aSq;
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
        }
    }
}
