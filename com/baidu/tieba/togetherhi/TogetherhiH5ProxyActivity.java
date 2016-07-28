package com.baidu.tieba.togetherhi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.plugins.g;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class TogetherhiH5ProxyActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = new View(getActivity());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setBackgroundColor(-1);
        setContentView(view);
        h(getIntent());
    }

    private void h(Intent intent) {
        Uri data = intent.getData();
        if (data == null || TextUtils.isEmpty(data.getScheme())) {
            bjN();
            return;
        }
        String scheme = intent.getScheme();
        if (g.Fl()) {
            if ("thactivity".equals(scheme)) {
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(getActivity());
                thActivityDetailActivityConfig.createActivityDetailConfig(qR(data.getPath()), "FROM_H5");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            } else if ("thhi".equals(scheme)) {
                ThHiDetailConfig thHiDetailConfig = new ThHiDetailConfig(getActivity());
                thHiDetailConfig.createHiDetailConfig(qS(data.getPath()), "FROM_H5");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thHiDetailConfig));
            }
            finish();
            return;
        }
        bjN();
    }

    private String qR(String str) {
        int indexOf;
        int length;
        if (!TextUtils.isEmpty(str) && !StringUtils.isNull(str) && (indexOf = str.indexOf("album_id=")) >= 0 && (length = indexOf + "album_id=".length()) <= str.length()) {
            return str.substring(length);
        }
        return null;
    }

    private long qS(String str) {
        int indexOf;
        int length;
        if (!TextUtils.isEmpty(str) && !StringUtils.isNull(str) && (indexOf = str.indexOf("hid=")) >= 0 && (length = indexOf + "hid=".length()) <= str.length()) {
            try {
                return Long.parseLong(str.substring(length));
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    private void bjN() {
        a aVar = new a(getActivity());
        aVar.cz(getResources().getString(u.j.th_plugin_not_install_tips));
        aVar.b(u.j.know, new du(this));
        aVar.b(getPageContext()).rS();
    }
}
