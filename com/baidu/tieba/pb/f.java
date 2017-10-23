package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f {
    private static String ewf = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void oB(String str) {
        if (!am.isEmpty(str)) {
            ewf = str;
        }
    }

    public static boolean T(bh bhVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (bhVar != null && bhVar.ZQ) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), ewf).tj();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean c(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.ghj) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), ewf).tj();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iv(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), ewf).tj();
            return true;
        }
        return false;
    }
}
