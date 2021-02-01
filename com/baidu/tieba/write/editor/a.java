package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0898a {
        void Lo(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0898a interfaceC0898a) {
        if (!StringUtils.isNull(str) && interfaceC0898a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                af.a(new ae<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ae
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.write_privacy_state_space" + currentAccount);
                        if (As != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(As.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: s */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0898a.this != null) {
                            InterfaceC0898a.this.Lo(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void cb(String str, int i) {
        l<String> As;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (As = com.baidu.tbadk.core.c.a.bqr().As("tb.write_privacy_state_space" + currentAccount)) != null) {
                As.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
