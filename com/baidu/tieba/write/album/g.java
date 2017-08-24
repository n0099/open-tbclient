package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class g {
    public static void a(TbPageContext<?> tbPageContext, String str, TbCameraView tbCameraView) {
        try {
            if (!com.baidu.tbadk.core.util.k.dR()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(com.baidu.tbadk.core.util.k.uJ());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(com.baidu.tbadk.core.util.k.uJ());
                }
            } else {
                String str2 = com.baidu.tbadk.core.util.k.zW + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
                if (com.baidu.tbadk.core.util.k.dv(str2)) {
                    String str3 = str2 + "/" + str;
                    if (tbCameraView != null) {
                        tbCameraView.setStorePath(str3);
                        tbCameraView.takePicture();
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
