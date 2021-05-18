package com.baidu.tieba.livesdk.scheme;

import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.a.j0.a.f;
/* loaded from: classes3.dex */
public class AlaSchemeEmptyActivity extends BaseActivity {
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String uri;
        super.onCreate(bundle);
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        Uri data = getIntent().getData();
        String host = data.getHost();
        String path = data.getPath();
        if (!"video".equals(host) || path == null || !path.startsWith("/live") || (uri = data.toString()) == null) {
            return;
        }
        String replace = uri.replace(f.f48687a + "://", UrlSchemaHelper.SCHEMA_LIVE_SDK);
        if (StringUtils.isNull(replace)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{replace});
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        finish();
    }
}
