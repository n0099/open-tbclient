package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes6.dex */
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
            amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle ajP = shareEntity.ajP();
        if (ajP != null) {
            int i3 = ajP.getInt("obj_param1");
            if (i3 != 0) {
                amVar.T("obj_param1", i3);
                if (i3 == 2) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, ajP.getString(ImageViewerConfig.FORUM_ID));
                } else if (i3 == 3) {
                    int i4 = ajP.getInt("obj_type");
                    if (i4 != 0) {
                        amVar.T("obj_type", i4);
                    }
                    amVar.bJ("tid", ajP.getString("tid")).bJ(ImageViewerConfig.FORUM_ID, ajP.getString(ImageViewerConfig.FORUM_ID));
                }
            }
            String string = ajP.getString("obj_url");
            if (!ap.isEmpty(string)) {
                amVar.bJ("obj_url", string);
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
            amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle ajP = shareEntity.ajP();
        if (ajP != null) {
            amVar.bJ("tid", ajP.getString("tid"));
            amVar.bJ("uid", ajP.getString("uid"));
            amVar.bJ(ImageViewerConfig.FORUM_ID, ajP.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(amVar);
    }
}
