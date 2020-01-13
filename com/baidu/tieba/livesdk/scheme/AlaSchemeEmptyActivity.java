package com.baidu.tieba.livesdk.scheme;

import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes2.dex */
public class AlaSchemeEmptyActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String uri;
        super.onCreate(bundle);
        if (getIntent() != null) {
            Uri data = getIntent().getData();
            String host = data.getHost();
            String path = data.getPath();
            if ("video".equals(host) && path != null && path.startsWith("/live") && (uri = data.toString()) != null) {
                String replace = uri.replace(f.cEb + "://", "bdtiebalive://");
                if (!StringUtils.isNull(replace)) {
                    ba.aEt().b(getPageContext(), new String[]{replace});
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        finish();
    }
}
