package com.baidu.tieba.pb;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i {
    private static String epx = TbadkCoreApplication.m9getInst().getContext().getString(w.l.ueg_host_msg);

    public static void oz(String str) {
        if (!aw.isEmpty(str)) {
            epx = str;
        }
    }

    public static boolean N(bm bmVar) {
        if (TbadkCoreApplication.isLogin()) {
            if (bmVar != null && bmVar.Zh) {
                BdToast.a(TbadkCoreApplication.m9getInst().getContext(), epx).ti();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean d(PostData postData) {
        if (TbadkCoreApplication.isLogin()) {
            if (postData != null && postData.fMR) {
                BdToast.a(TbadkCoreApplication.m9getInst().getContext(), epx).ti();
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean io(boolean z) {
        if (z) {
            BdToast.a(TbadkCoreApplication.m9getInst().getContext(), epx).ti();
            return true;
        }
        return false;
    }
}
