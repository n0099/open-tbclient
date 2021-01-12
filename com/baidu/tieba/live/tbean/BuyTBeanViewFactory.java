package com.baidu.tieba.live.tbean;

import android.os.Build;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class BuyTBeanViewFactory {
    public static AbsBuyTBeanView buildBuyTBeanView(TbPageContext<?> tbPageContext, BuyTBeanController buyTBeanController, boolean z, boolean z2, boolean z3) {
        return Build.VERSION.SDK_INT == 26 ? new BuyTBeanFullView(tbPageContext, buyTBeanController, z, z2, z3) : new BuyTBeanView(tbPageContext, buyTBeanController, z, z2, z3);
    }
}
