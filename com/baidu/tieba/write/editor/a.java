package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0258a {
        void vW(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0258a interfaceC0258a) {
        if (!StringUtils.isNull(str) && interfaceC0258a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                x.a(new w<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> dQ = com.baidu.tbadk.core.c.a.yh().dQ("tb.write_privacy_state_space" + currentAccount);
                        if (dQ != null) {
                            i2 = com.baidu.adp.lib.g.b.l(dQ.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: n */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0258a.this != null) {
                            InterfaceC0258a.this.vW(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aV(String str, int i) {
        l<String> dQ;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (dQ = com.baidu.tbadk.core.c.a.yh().dQ("tb.write_privacy_state_space" + currentAccount)) != null) {
                dQ.f(str, String.valueOf(i));
            }
        }
    }
}
