package com.baidu.tieba.yuyinala.liveroom.o;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a {
    public static int yM(boolean z) {
        if (z) {
            return (int) ((BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) * 0.3f) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_tbds64));
        }
        return (BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) - UtilHelper.getStatusBarHeight()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds900);
    }

    public static int cN(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    }
}
