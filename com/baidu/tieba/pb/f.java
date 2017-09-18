package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f {
    private static String eDc = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void oY(String str) {
        if (!am.isEmpty(str)) {
            eDc = str;
        }
    }

    public static boolean Y(bj bjVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (bjVar != null && bjVar.aac) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eDc).tw();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean d(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.gjO) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), eDc).tw();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iM(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), eDc).tw();
            return true;
        }
        return false;
    }
}
