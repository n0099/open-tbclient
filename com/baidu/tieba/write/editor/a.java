package com.baidu.tieba.write.editor;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.tieba.write.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0906a {
        void Lt(int i);
    }

    public static void a(final String str, final int i, final InterfaceC0906a interfaceC0906a) {
        if (!StringUtils.isNull(str) && interfaceC0906a != null) {
            final String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                af.a(new ae<Integer>() { // from class: com.baidu.tieba.write.editor.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tbadk.util.ae
                    public Integer doInBackground() {
                        int i2 = i;
                        l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.write_privacy_state_space" + currentAccount);
                        if (Az != null) {
                            i2 = com.baidu.adp.lib.f.b.toInt(Az.get(str), i);
                        }
                        return Integer.valueOf(i2);
                    }
                }, new m<Integer>() { // from class: com.baidu.tieba.write.editor.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.m
                    /* renamed from: s */
                    public void onReturnDataInUI(Integer num) {
                        if (InterfaceC0906a.this != null) {
                            InterfaceC0906a.this.Lt(num.intValue());
                        }
                    }
                });
            }
        }
    }

    public static void cb(String str, int i) {
        l<String> Az;
        if (!StringUtils.isNull(str)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && (Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.write_privacy_state_space" + currentAccount)) != null) {
                Az.asyncSetForever(str, String.valueOf(i));
            }
        }
    }
}
