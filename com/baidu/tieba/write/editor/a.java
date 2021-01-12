package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0895a {
        void KT(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0895a interfaceC0895a) {
        if (!StringUtils.isNull(str) && interfaceC0895a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ac.a(new ab<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.write_privacy_state_space" + currentAccount);
                        if (Ab != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(Ab.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: r */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0895a.this != null) {
                            InterfaceC0895a.this.KT(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void ca(String str, int i) {
        l<String> Ab;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.write_privacy_state_space" + currentAccount)) != null) {
                Ab.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
