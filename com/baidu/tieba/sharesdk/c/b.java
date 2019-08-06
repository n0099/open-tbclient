package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes6.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        an anVar = new an("share_success");
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
            anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle apY = shareEntity.apY();
        if (apY != null) {
            int i3 = apY.getInt("obj_param1");
            if (i3 != 0) {
                anVar.P("obj_param1", i3);
                if (i3 == 2) {
                    anVar.bT("fid", apY.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = apY.getInt("obj_type");
                    if (i4 != 0) {
                        anVar.P("obj_type", i4);
                    }
                    anVar.bT("tid", apY.getString("tid")).bT("fid", apY.getString("fid"));
                }
            }
            String string = apY.getString("obj_url");
            if (!aq.isEmpty(string)) {
                anVar.bT("obj_url", string);
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
            anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle apY = shareEntity.apY();
        if (apY != null) {
            anVar.bT("tid", apY.getString("tid"));
            anVar.bT("uid", apY.getString("uid"));
            anVar.bT("fid", apY.getString("fid"));
        }
        TiebaStatic.log(anVar);
    }
}
