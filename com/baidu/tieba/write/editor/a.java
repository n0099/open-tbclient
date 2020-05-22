package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0751a {
        void FD(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0751a interfaceC0751a) {
        if (!StringUtils.isNull(str) && interfaceC0751a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ad.a(new ac<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ac
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.write_privacy_state_space" + currentAccount);
                        if (vM != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(vM.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: m */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0751a.this != null) {
                            InterfaceC0751a.this.FD(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bL(String str, int i) {
        l<String> vM;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.write_privacy_state_space" + currentAccount)) != null) {
                vM.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
