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
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle IQ = shareEntity.IQ();
        if (IQ != null && (i2 = IQ.getInt("obj_param1")) != 0) {
            amVar.x("obj_param1", i2);
            if (i2 == 2) {
                amVar.ax(ImageViewerConfig.FORUM_ID, IQ.getString(ImageViewerConfig.FORUM_ID));
            } else if (i2 == 3) {
                int i4 = IQ.getInt("obj_type");
                if (i4 != 0) {
                    amVar.x("obj_type", i4);
                }
                amVar.ax("tid", IQ.getString("tid")).ax(ImageViewerConfig.FORUM_ID, IQ.getString(ImageViewerConfig.FORUM_ID));
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
        Bundle IQ = shareEntity.IQ();
        if (IQ != null) {
            amVar.ax("tid", IQ.getString("tid"));
            amVar.ax("uid", IQ.getString("uid"));
            amVar.ax(ImageViewerConfig.FORUM_ID, IQ.getString(ImageViewerConfig.FORUM_ID));
        }
        TiebaStatic.log(amVar);
    }
}
