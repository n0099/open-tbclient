package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0698a {
        void EQ(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0698a interfaceC0698a) {
        if (!StringUtils.isNull(str) && interfaceC0698a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ac.a(new ab<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.write_privacy_state_space" + currentAccount);
                        if (ug != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(ug.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: l */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0698a.this != null) {
                            InterfaceC0698a.this.EQ(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bK(String str, int i) {
        l<String> ug;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.write_privacy_state_space" + currentAccount)) != null) {
                ug.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
