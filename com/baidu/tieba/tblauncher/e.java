package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes21.dex */
public class e {
    private TbPageContext eGu;

    public e(TbPageContext tbPageContext) {
        this.eGu = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public boolean ak(Intent intent) {
        return intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1;
    }

    public void a(Intent intent, d dVar) {
        int i = 2;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
            if (!TextUtils.isEmpty(stringExtra)) {
                String string = this.eGu.getString(R.string.des_page_home_recommend);
                bf bfVar = new bf();
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
                if (matcher.find()) {
                    bfVar.tid = matcher.group(1);
                }
                if (stringExtra.equals(string)) {
                    bfVar.eAN = 1;
                } else {
                    bfVar.eAN = 2;
                    bfVar.tabName = stringExtra;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, bfVar));
                if (stringExtra.equals(string)) {
                    intent.putExtra("sub_locate_type", 1);
                } else {
                    intent.putExtra("sub_locate_type", stringExtra);
                    i = 1;
                }
                if (dVar != null && dVar.czO() != null) {
                    dVar.czO().setCurrentTabByType(i);
                    FragmentTabHost.b pl2 = dVar.czO().pl(i);
                    if (pl2 != null && (pl2.mContentFragment instanceof g)) {
                        ((g) pl2.mContentFragment).B(intent);
                    }
                }
            }
            intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
            intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        }
    }
}
