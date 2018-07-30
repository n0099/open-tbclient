package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        int i2;
        an anVar = new an("share_success");
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
            anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle Fz = shareEntity.Fz();
        if (Fz != null && (i2 = Fz.getInt("obj_param1")) != 0) {
            anVar.r("obj_param1", i2);
            if (i2 == 2) {
                anVar.af(ImageViewerConfig.FORUM_ID, Fz.getString(ImageViewerConfig.FORUM_ID));
            } else if (i2 == 3) {
                int i4 = Fz.getInt("obj_type");
                if (i4 != 0) {
                    anVar.r("obj_type", i4);
                }
                anVar.af("tid", Fz.getString("tid")).af(ImageViewerConfig.FORUM_ID, Fz.getString(ImageViewerConfig.FORUM_ID));
            }
        }
        TiebaStatic.log(anVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        an anVar = new an("c12481");
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
            anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle Fz = shareEntity.Fz();
        if (Fz != null) {
            anVar.af("tid", Fz.getString("tid"));
            anVar.af("uid", Fz.getString("uid"));
            anVar.af(ImageViewerConfig.FORUM_ID, Fz.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(anVar);
    }
}
