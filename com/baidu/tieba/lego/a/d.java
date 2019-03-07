package com.baidu.tieba.lego.a;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.b.g;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d implements g {
    @Override // com.baidu.tbadk.b.g
    public String key() {
        return TbConfig.LIKE_ADDRESS;
    }

    @Override // com.baidu.tbadk.b.g
    public void a(HashMap<String, String> hashMap, h hVar) {
        if (hVar != null && hashMap != null && !hashMap.isEmpty()) {
            String str = hashMap.get(ImageViewerConfig.FORUM_ID);
            if (!TextUtils.isEmpty(str)) {
                String str2 = hashMap.get("kw");
                if (!TextUtils.isEmpty(str2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.d(str, 0L))));
                    TbadkCoreApplication.getInst().addLikeForum(str2);
                }
            }
        }
    }
}
