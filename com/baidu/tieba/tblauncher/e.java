package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes16.dex */
public class e {
    private TbPageContext dVN;

    public e(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public boolean al(Intent intent) {
        return intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1;
    }

    public void a(Intent intent, d dVar) {
        int i = 2;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
            if (!TextUtils.isEmpty(stringExtra)) {
                String string = this.dVN.getString(R.string.des_page_home_recommend);
                bd bdVar = new bd();
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
                if (matcher.find()) {
                    bdVar.tid = matcher.group(1);
                }
                if (stringExtra.equals(string)) {
                    bdVar.dQv = 1;
                } else {
                    bdVar.dQv = 2;
                    bdVar.tabName = stringExtra;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, bdVar));
                if (stringExtra.equals(string)) {
                    intent.putExtra("sub_locate_type", 1);
                } else {
                    intent.putExtra("sub_locate_type", stringExtra);
                    i = 1;
                }
                if (dVar != null && dVar.cds() != null) {
                    dVar.cds().setCurrentTabByType(i);
                    FragmentTabHost.b lG = dVar.cds().lG(i);
                    if (lG != null && (lG.mContentFragment instanceof g)) {
                        ((g) lG.mContentFragment).z(intent);
                    }
                }
            }
            intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
            intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        }
    }
}
