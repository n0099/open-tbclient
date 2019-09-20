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
    public interface InterfaceC0443a {
        void Df(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0443a interfaceC0443a) {
        if (!StringUtils.isNull(str) && interfaceC0443a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                z.a(new y<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.y
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> mN = com.baidu.tbadk.core.d.a.agL().mN("tb.write_privacy_state_space" + currentAccount);
                        if (mN != null) {
                            i2 = com.baidu.adp.lib.g.b.f(mN.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new j<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: i */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0443a.this != null) {
                            InterfaceC0443a.this.Df(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bw(String str, int i) {
        l<String> mN;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (mN = com.baidu.tbadk.core.d.a.agL().mN("tb.write_privacy_state_space" + currentAccount)) != null) {
                mN.g(str, String.valueOf(i));
            }
        }
    }
}
