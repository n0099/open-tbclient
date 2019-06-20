package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0427a {
        void Cs(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0427a interfaceC0427a) {
        if (!StringUtils.isNull(str) && interfaceC0427a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                aa.a(new z<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.z
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> mA = com.baidu.tbadk.core.c.a.afD().mA("tb.write_privacy_state_space" + currentAccount);
                        if (mA != null) {
                            i2 = com.baidu.adp.lib.g.b.f(mA.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new k<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: i */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0427a.this != null) {
                            InterfaceC0427a.this.Cs(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bt(String str, int i) {
        l<String> mA;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (mA = com.baidu.tbadk.core.c.a.afD().mA("tb.write_privacy_state_space" + currentAccount)) != null) {
                mA.g(str, String.valueOf(i));
            }
        }
    }
}
