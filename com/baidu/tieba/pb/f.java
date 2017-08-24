package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f {
    private static String eDP = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void pk(String str) {
        if (!al.isEmpty(str)) {
            eDP = str;
        }
    }

    public static boolean T(bl blVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (blVar != null && blVar.aaW) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eDP).tA();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean d(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.gkt) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eDP).tA();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iL(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), eDP).tA();
            return true;
        }
        return false;
    }
}
