package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f {
    private static String eAG = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void oX(String str) {
        if (!al.isEmpty(str)) {
            eAG = str;
        }
    }

    public static boolean T(bl blVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (blVar != null && blVar.Zy) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eAG).tp();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean d(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.ghp) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eAG).tp();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iI(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), eAG).tp();
            return true;
        }
        return false;
    }
}
