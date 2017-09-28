package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class f {
    private static String ewt = TbadkCoreApplication.getInst().getContext().getString(d.l.ueg_host_msg);

    public static void oC(String str) {
        if (!am.isEmpty(str)) {
            ewt = str;
        }
    }

    public static boolean T(bh bhVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (bhVar != null && bhVar.aac) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), ewt).tq();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean c(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.ghy) {
                BdToast.a(TbadkCoreApplication.getInst().getContext(), ewt).tq();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean iw(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.getInst().getContext(), ewt).tq();
            return true;
        }
        return false;
    }
}
