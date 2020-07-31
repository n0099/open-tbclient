package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0779a {
        void Hf(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0779a interfaceC0779a) {
        if (!StringUtils.isNull(str) && interfaceC0779a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ad.a(new ac<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ac
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.write_privacy_state_space" + currentAccount);
                        if (xj != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(xj.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: m */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0779a.this != null) {
                            InterfaceC0779a.this.Hf(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bI(String str, int i) {
        l<String> xj;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.write_privacy_state_space" + currentAccount)) != null) {
                xj.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
