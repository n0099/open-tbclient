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
        void xt(int i);
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
                        l<String> cW = com.baidu.tbadk.core.c.a.Aw().cW("tb.write_privacy_state_space" + currentAccount);
                        if (cW != null) {
                            i2 = com.baidu.adp.lib.g.b.h(cW.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: g */
                    public void onReturnDataInUI(Integer num) {
                        if (a.this != null) {
                            a.this.xt(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aO(String str, int i) {
        l<String> cW;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (cW = com.baidu.tbadk.core.c.a.Aw().cW("tb.write_privacy_state_space" + currentAccount)) != null) {
                cW.f(str, String.valueOf(i));
            }
        }
    }
}
