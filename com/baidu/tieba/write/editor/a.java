package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0896a {
        void MN(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0896a interfaceC0896a) {
        if (!StringUtils.isNull(str) && interfaceC0896a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ad.a(new ac<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ac
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.write_privacy_state_space" + currentAccount);
                        if (Bo != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(Bo.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: p */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0896a.this != null) {
                            InterfaceC0896a.this.MN(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bT(String str, int i) {
        l<String> Bo;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.write_privacy_state_space" + currentAccount)) != null) {
                Bo.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
