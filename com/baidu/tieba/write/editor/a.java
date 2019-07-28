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
    public interface InterfaceC0432a {
        void CZ(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0432a interfaceC0432a) {
        if (!StringUtils.isNull(str) && interfaceC0432a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                aa.a(new z<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.z
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.write_privacy_state_space" + currentAccount);
                        if (mL != null) {
                            i2 = com.baidu.adp.lib.g.b.f(mL.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new k<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.k
                    /* renamed from: i */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0432a.this != null) {
                            InterfaceC0432a.this.CZ(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bu(String str, int i) {
        l<String> mL;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (mL = com.baidu.tbadk.core.d.a.agF().mL("tb.write_privacy_state_space" + currentAccount)) != null) {
                mL.g(str, String.valueOf(i));
            }
        }
    }
}
