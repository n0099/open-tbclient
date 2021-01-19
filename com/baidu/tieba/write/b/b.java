package com.baidu.tieba.write.b;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes7.dex */
public class b {
    private static boolean nWL = false;

    public static void dVb() {
        nWL = true;
    }

    public static boolean dVc() {
        return d.biK();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dVc() || nWL || dVd() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dVq();
            dVb();
            aq.AM("c13996").bsu();
        }
    }

    private static int dVd() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("show_write_title_tip_count", 0);
    }

    public static void g(WriteData writeData) {
        if (writeData != null && dVc() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("show_write_title_tip_count", dVd() + 1);
        }
    }

    public static boolean j(ImageFileInfo imageFileInfo) {
        String filePath;
        if (LimitLowQualityPicUploadSwitch.isOff() || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
            return false;
        }
        long fileSize = n.getFileSize(filePath);
        if (fileSize < 5120) {
            bZ(1, "" + fileSize);
            return true;
        }
        int[] imageFileWH = n.getImageFileWH(filePath);
        if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
            bZ(2, imageFileWH[0] + "*" + imageFileWH[1]);
            return true;
        }
        return false;
    }

    private static void bZ(int i, String str) {
        TiebaStatic.log(new aq("c14021").dW("uid", TbadkApplication.getCurrentAccount()).an("obj_type", i).dW("obj_param1", str));
    }
}
