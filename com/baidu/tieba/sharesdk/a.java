package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.coreExtra.c.b {
    private com.baidu.tbadk.coreExtra.c.a axk;
    private Context mContext;

    public a(Context context, com.baidu.tbadk.coreExtra.c.a aVar) {
        this.mContext = null;
        this.mContext = context;
        this.axk = aVar;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public void a(d dVar, int i, boolean z) {
        a(dVar, i);
    }

    private void a(d dVar, int i) {
        if (this.mContext != null && dVar != null) {
            IntentConfig intentConfig = new IntentConfig(this.mContext);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(dVar.title);
            shareEntity.setContent(dVar.content);
            shareEntity.g(dVar.awV);
            String str = dVar.linkUrl;
            if (i == 6 && !StringUtils.isNull(dVar.awU)) {
                str = dVar.awU;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.setLocation(dVar.awW);
            shareEntity.sz(i);
            shareEntity.f(dVar.BL());
            shareEntity.lW(dVar.axd);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            intentConfig.getIntent().putExtras(bundle);
            intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
        }
    }
}
