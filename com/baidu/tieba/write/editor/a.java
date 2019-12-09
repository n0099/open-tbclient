package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0533a {
        void BA(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0533a interfaceC0533a) {
        if (!StringUtils.isNull(str) && interfaceC0533a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                z.a(new y<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.y
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> nl = com.baidu.tbadk.core.d.a.akL().nl("tb.write_privacy_state_space" + currentAccount);
                        if (nl != null) {
                            i2 = com.baidu.adp.lib.g.b.toInt(nl.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new j<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: f */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0533a.this != null) {
                            InterfaceC0533a.this.BA(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void br(String str, int i) {
        l<String> nl;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (nl = com.baidu.tbadk.core.d.a.akL().nl("tb.write_privacy_state_space" + currentAccount)) != null) {
                nl.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
