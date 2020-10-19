package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes22.dex */
public class e {
    private TbPageContext etO;

    public e(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
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
                String string = this.etO.getString(R.string.des_page_home_recommend);
                be beVar = new be();
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
                if (matcher.find()) {
                    beVar.tid = matcher.group(1);
                }
                if (stringExtra.equals(string)) {
                    beVar.eoh = 1;
                } else {
                    beVar.eoh = 2;
                    beVar.tabName = stringExtra;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, beVar));
                if (stringExtra.equals(string)) {
                    intent.putExtra("sub_locate_type", 1);
                } else {
                    intent.putExtra("sub_locate_type", stringExtra);
                    i = 1;
                }
                if (dVar != null && dVar.cuD() != null) {
                    dVar.cuD().setCurrentTabByType(i);
                    FragmentTabHost.b ov = dVar.cuD().ov(i);
                    if (ov != null && (ov.mContentFragment instanceof g)) {
                        ((g) ov.mContentFragment).B(intent);
                    }
                }
            }
            intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
            intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        }
    }
}
