package com.baidu.tieba.livesdk.k;

import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class a implements ICustomToast {
    @Override // com.baidu.live.adp.widget.ICustomToast
    public void showToast(String str, int i) {
        l.showToast(TbadkCoreApplication.getInst(), str);
    }

    @Override // com.baidu.live.adp.widget.ICustomToast
    public void cancel() {
    }
}
