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
    public interface InterfaceC0408a {
        void Bn(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0408a interfaceC0408a) {
        if (!StringUtils.isNull(str) && interfaceC0408a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                aa.a(new z<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.z
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.write_privacy_state_space" + currentAccount);
                        if (lv != null) {
                            i2 = com.baidu.adp.lib.g.b.l(lv.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new k<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: i */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0408a.this != null) {
                            InterfaceC0408a.this.Bn(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bx(String str, int i) {
        l<String> lv;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.write_privacy_state_space" + currentAccount)) != null) {
                lv.f(str, String.valueOf(i));
            }
        }
    }
}
