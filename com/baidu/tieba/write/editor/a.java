package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0321a {
        void wM(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0321a interfaceC0321a) {
        if (!StringUtils.isNull(str) && interfaceC0321a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                x.a(new w<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.w
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> eg = com.baidu.tbadk.core.c.a.Ax().eg("tb.write_privacy_state_space" + currentAccount);
                        if (eg != null) {
                            i2 = com.baidu.adp.lib.g.b.l(eg.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new h<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: n */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0321a.this != null) {
                            InterfaceC0321a.this.wM(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void aZ(String str, int i) {
        l<String> eg;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (eg = com.baidu.tbadk.core.c.a.Ax().eg("tb.write_privacy_state_space" + currentAccount)) != null) {
                eg.f(str, String.valueOf(i));
            }
        }
    }
}
