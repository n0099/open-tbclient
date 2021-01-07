package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0912a {
        void MA(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0912a interfaceC0912a) {
        if (!StringUtils.isNull(str) && interfaceC0912a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ac.a(new ab<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ab
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.write_privacy_state_space" + currentAccount);
                        if (Bm != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(Bm.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new com.baidu.tbadk.util.l<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: r */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0912a.this != null) {
                            InterfaceC0912a.this.MA(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void ca(String str, int i) {
        l<String> Bm;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.write_privacy_state_space" + currentAccount)) != null) {
                Bm.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
