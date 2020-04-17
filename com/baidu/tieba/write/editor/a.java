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
    public interface InterfaceC0677a {
        void EQ(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0677a interfaceC0677a) {
        if (!StringUtils.isNull(str) && interfaceC0677a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ac.a(new ab<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.write_privacy_state_space" + currentAccount);
                        if (ud != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(ud.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: l */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0677a.this != null) {
                            InterfaceC0677a.this.EQ(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bK(String str, int i) {
        l<String> ud;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.write_privacy_state_space" + currentAccount)) != null) {
                ud.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
