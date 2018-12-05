package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        am amVar = new am("share_success");
        int i2 = 0;
        switch (i) {
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 4;
                break;
            case 6:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
        }
        if (i2 != 0) {
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle Kg = shareEntity.Kg();
        if (Kg != null) {
            int i3 = Kg.getInt("obj_param1");
            if (i3 != 0) {
                amVar.x("obj_param1", i3);
                if (i3 == 2) {
                    amVar.aA(ImageViewerConfig.FORUM_ID, Kg.getString(ImageViewerConfig.FORUM_ID));
                } else if (i3 == 3) {
                    int i4 = Kg.getInt("obj_type");
                    if (i4 != 0) {
                        amVar.x("obj_type", i4);
                    }
                    amVar.aA("tid", Kg.getString("tid")).aA(ImageViewerConfig.FORUM_ID, Kg.getString(ImageViewerConfig.FORUM_ID));
                }
            }
            String string = Kg.getString("obj_url");
            if (!ao.isEmpty(string)) {
                amVar.aA("obj_url", string);
            }
        }
        TiebaStatic.log(amVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        am amVar = new am("c12481");
        int i2 = 0;
        switch (i) {
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 4;
                break;
            case 6:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
        }
        if (i2 != 0) {
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle Kg = shareEntity.Kg();
        if (Kg != null) {
            amVar.aA("tid", Kg.getString("tid"));
            amVar.aA("uid", Kg.getString("uid"));
            amVar.aA(ImageViewerConfig.FORUM_ID, Kg.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(amVar);
    }
}
