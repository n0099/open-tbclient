package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0847a {
        void KN(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0847a interfaceC0847a) {
        if (!StringUtils.isNull(str) && interfaceC0847a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ae.a(new ad<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ad
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.write_privacy_state_space" + currentAccount);
                        if (AF != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(AF.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: p */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0847a.this != null) {
                            InterfaceC0847a.this.KN(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bO(String str, int i) {
        l<String> AF;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.write_privacy_state_space" + currentAccount)) != null) {
                AF.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
