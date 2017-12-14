package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public interface a {
        void vZ(int i);
    }

    public static void a(final String str, final int i, final a aVar) {
        if (!StringUtils.isNull(str) && aVar != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                v.a(new u<Integer>() { // from class: com.baidu.tieba.write.editor.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.u
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> cP = com.baidu.tbadk.core.c.a.td().cP("tb.write_privacy_state_space" + currentAccount);
                        if (cP != null) {
                            i2 = com.baidu.adp.lib.g.b.g(cP.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: g */
                    public void onReturnDataInUI(Integer num) {
                        if (a.this != null) {
                            a.this.vZ(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aM(String str, int i) {
        l<String> cP;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (cP = com.baidu.tbadk.core.c.a.td().cP("tb.write_privacy_state_space" + currentAccount)) != null) {
                cP.f(str, String.valueOf(i));
            }
        }
    }
}
