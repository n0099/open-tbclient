package com.baidu.tieba.yuyinala.liveroom.q;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes11.dex */
public class a {
    public static int I(boolean z, int i) {
        if (z) {
            return (int) ((BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) * 0.3f) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_tbds64));
        }
        int wheatHeight = o.eff().getWheatHeight();
        if (wheatHeight <= 0) {
            if (i == 1) {
                wheatHeight = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds935);
            } else {
                wheatHeight = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds856);
            }
        }
        return ((BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) - UtilHelper.getStatusBarHeight()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds20)) - wheatHeight;
    }

    public static int dn(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds120);
    }
}
