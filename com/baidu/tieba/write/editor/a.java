package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0880a {
        void LV(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0880a interfaceC0880a) {
        if (!StringUtils.isNull(str) && interfaceC0880a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                ad.a(new ac<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ac
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.write_privacy_state_space" + currentAccount);
                        if (AH != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(AH.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: p */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0880a.this != null) {
                            InterfaceC0880a.this.LV(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void bQ(String str, int i) {
        l<String> AH;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (AH = com.baidu.tbadk.core.c.a.bob().AH("tb.write_privacy_state_space" + currentAccount)) != null) {
                AH.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
