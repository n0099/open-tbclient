package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class e {
    private static String eBT = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void pb(String str) {
        if (!al.isEmpty(str)) {
            eBT = str;
        }
    }

    public static boolean T(bl blVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (blVar != null && blVar.aaU) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eBT).tz();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean d(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.giB) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eBT).tz();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iI(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), eBT).tz();
            return true;
        }
        return false;
    }
}
