package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private static String egA = TbadkCoreApplication.m9getInst().getContext().getString(w.l.ueg_host_msg);

    public static void nF(String str) {
        if (!au.isEmpty(str)) {
            egA = str;
        }
    }

    public static boolean M(bl blVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (blVar != null && blVar.Zg) {
                BdToast.a(TbadkCoreApplication.m9getInst().getContext(), egA).tk();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean c(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.fCM) {
                BdToast.a(TbadkCoreApplication.m9getInst().getContext(), egA).tk();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean hS(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.m9getInst().getContext(), egA).tk();
            return true;
        }
        return false;
    }
}
