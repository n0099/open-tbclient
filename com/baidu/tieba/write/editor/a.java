package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0334a {
        void xy(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0334a interfaceC0334a) {
        if (!StringUtils.isNull(str) && interfaceC0334a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                y.a(new x<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.x
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> eH = com.baidu.tbadk.core.c.a.BO().eH("tb.write_privacy_state_space" + currentAccount);
                        if (eH != null) {
                            i2 = com.baidu.adp.lib.g.b.l(eH.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: n */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0334a.this != null) {
                            InterfaceC0334a.this.xy(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bb(String str, int i) {
        l<String> eH;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (eH = com.baidu.tbadk.core.c.a.BO().eH("tb.write_privacy_state_space" + currentAccount)) != null) {
                eH.f(str, String.valueOf(i));
            }
        }
    }
}
