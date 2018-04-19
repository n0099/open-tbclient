package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0233a {
        void uX(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0233a interfaceC0233a) {
        if (!StringUtils.isNull(str) && interfaceC0233a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                v.a(new u<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.u
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> cZ = com.baidu.tbadk.core.c.a.tz().cZ("tb.write_privacy_state_space" + currentAccount);
                        if (cZ != null) {
                            i2 = com.baidu.adp.lib.g.b.g(cZ.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: h */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0233a.this != null) {
                            InterfaceC0233a.this.uX(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aQ(String str, int i) {
        l<String> cZ;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (cZ = com.baidu.tbadk.core.c.a.tz().cZ("tb.write_privacy_state_space" + currentAccount)) != null) {
                cZ.f(str, String.valueOf(i));
            }
        }
    }
}
