package com.baidu.tieba.write.b;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes7.dex */
public class b {
    private static boolean ojw = false;

    public static void dXF() {
        ojw = true;
    }

    public static boolean dXG() {
        return d.biY();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dXG() || ojw || dXH() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dXU();
            dXF();
            ar.Bk("c13996").bsR();
        }
    }

    private static int dXH() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt("show_write_title_tip_count", 0);
    }

    public static void g(WriteData writeData) {
        if (writeData != null && dXG() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("show_write_title_tip_count", dXH() + 1);
        }
    }

    public static boolean j(ImageFileInfo imageFileInfo) {
        String filePath;
        if (LimitLowQualityPicUploadSwitch.isOff() || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
            return false;
        }
        long fileSize = o.getFileSize(filePath);
        if (fileSize < 5120) {
            cg(1, "" + fileSize);
            return true;
        }
        int[] imageFileWH = o.getImageFileWH(filePath);
        if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
            cg(2, imageFileWH[0] + "*" + imageFileWH[1]);
            return true;
        }
        return false;
    }

    private static void cg(int i, String str) {
        TiebaStatic.log(new ar("c14021").dR("uid", TbadkApplication.getCurrentAccount()).aq("obj_type", i).dR("obj_param1", str));
    }
}
