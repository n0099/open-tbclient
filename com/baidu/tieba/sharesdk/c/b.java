package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes3.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        int i2;
        ak akVar = new ak("share_success");
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
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3);
        }
        if (shareEntity == null) {
            TiebaStatic.log(akVar);
            return;
        }
        Bundle IW = shareEntity.IW();
        if (IW != null && (i2 = IW.getInt("obj_param1")) != 0) {
            akVar.s("obj_param1", i2);
            if (i2 == 2) {
                akVar.ab(ImageViewerConfig.FORUM_ID, IW.getString(ImageViewerConfig.FORUM_ID));
            } else if (i2 == 3) {
                int i4 = IW.getInt("obj_type");
                if (i4 != 0) {
                    akVar.s("obj_type", i4);
                }
                akVar.ab("tid", IW.getString("tid")).ab(ImageViewerConfig.FORUM_ID, IW.getString(ImageViewerConfig.FORUM_ID));
            }
        }
        TiebaStatic.log(akVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        ak akVar = new ak("c12481");
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
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(akVar);
            return;
        }
        Bundle IW = shareEntity.IW();
        if (IW != null) {
            akVar.ab("tid", IW.getString("tid"));
            akVar.ab("uid", IW.getString("uid"));
            akVar.ab(ImageViewerConfig.FORUM_ID, IW.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(akVar);
    }
}
