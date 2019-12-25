package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0618a {
        void DX(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0618a interfaceC0618a) {
        if (!StringUtils.isNull(str) && interfaceC0618a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ac.a(new ab<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.write_privacy_state_space" + currentAccount);
                        if (sx != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(sx.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: l */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0618a.this != null) {
                            InterfaceC0618a.this.DX(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bA(String str, int i) {
        l<String> sx;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.write_privacy_state_space" + currentAccount)) != null) {
                sx.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
