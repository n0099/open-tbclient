package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class u {
    public static void a(TbPageContext<?> tbPageContext, String str, TbCameraView tbCameraView) {
        String str2;
        try {
            if (!com.baidu.tbadk.core.util.l.dH()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(com.baidu.tbadk.core.util.l.ua());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(com.baidu.tbadk.core.util.l.ua());
                }
            } else {
                if (com.baidu.tbadk.core.util.l.cP(com.baidu.tbadk.core.util.l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
                    String str3 = String.valueOf(str2) + "/" + str;
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
