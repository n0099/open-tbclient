package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0252a {
        void vx(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0252a interfaceC0252a) {
        if (!StringUtils.isNull(str) && interfaceC0252a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                w.a(new v<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.v
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> dB = com.baidu.tbadk.core.c.a.xj().dB("tb.write_privacy_state_space" + currentAccount);
                        if (dB != null) {
                            i2 = com.baidu.adp.lib.g.b.g(dB.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: n */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0252a.this != null) {
                            InterfaceC0252a.this.vx(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aU(String str, int i) {
        l<String> dB;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (dB = com.baidu.tbadk.core.c.a.xj().dB("tb.write_privacy_state_space" + currentAccount)) != null) {
                dB.f(str, String.valueOf(i));
            }
        }
    }
}
