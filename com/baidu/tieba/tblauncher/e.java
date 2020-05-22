package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class e {
    private TbPageContext dIF;

    public e(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public boolean ai(Intent intent) {
        return intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1;
    }

    public void a(Intent intent, d dVar) {
        int i = 2;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
            if (!TextUtils.isEmpty(stringExtra)) {
                String string = this.dIF.getString(R.string.des_page_home_recommend);
                ax axVar = new ax();
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
                if (matcher.find()) {
                    axVar.tid = matcher.group(1);
                }
                if (stringExtra.equals(string)) {
                    axVar.dDN = 1;
                } else {
                    axVar.dDN = 2;
                    axVar.tabName = stringExtra;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, axVar));
                if (stringExtra.equals(string)) {
                    intent.putExtra("sub_locate_type", 1);
                } else {
                    intent.putExtra("sub_locate_type", stringExtra);
                    i = 1;
                }
                if (dVar != null && dVar.bWI() != null) {
                    dVar.bWI().setCurrentTabByType(i);
                    FragmentTabHost.b kW = dVar.bWI().kW(i);
                    if (kW != null && (kW.mContentFragment instanceof g)) {
                        ((g) kW.mContentFragment).z(intent);
                    }
                }
            }
            intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
            intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        }
    }
}
