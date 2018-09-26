package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        int i2;
        am amVar = new am("share_success");
        int i3 = 0;
        switch (i) {
            case 2:
                i3 = 3;
                break;
            case 3:
                i3 = 2;
                break;
            case 4:
                i3 = 4;
                break;
            case 6:
                i3 = 6;
                break;
            case 8:
                i3 = 5;
                break;
        }
        if (i3 != 0) {
            amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle GP = shareEntity.GP();
        if (GP != null && (i2 = GP.getInt("obj_param1")) != 0) {
            amVar.w("obj_param1", i2);
            if (i2 == 2) {
                amVar.al(ImageViewerConfig.FORUM_ID, GP.getString(ImageViewerConfig.FORUM_ID));
            } else if (i2 == 3) {
                int i4 = GP.getInt("obj_type");
                if (i4 != 0) {
                    amVar.w("obj_type", i4);
                }
                amVar.al("tid", GP.getString("tid")).al(ImageViewerConfig.FORUM_ID, GP.getString(ImageViewerConfig.FORUM_ID));
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
            amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle GP = shareEntity.GP();
        if (GP != null) {
            amVar.al("tid", GP.getString("tid"));
            amVar.al("uid", GP.getString("uid"));
            amVar.al(ImageViewerConfig.FORUM_ID, GP.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(amVar);
    }
}
