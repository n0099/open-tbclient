package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0829a {
        void Kh(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0829a interfaceC0829a) {
        if (!StringUtils.isNull(str) && interfaceC0829a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ae.a(new ad<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ad
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.write_privacy_state_space" + currentAccount);
                        if (zT != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(zT.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: n */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0829a.this != null) {
                            InterfaceC0829a.this.Kh(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bN(String str, int i) {
        l<String> zT;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.write_privacy_state_space" + currentAccount)) != null) {
                zT.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
