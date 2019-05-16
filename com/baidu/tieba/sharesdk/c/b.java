package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
            amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle aoQ = shareEntity.aoQ();
        if (aoQ != null) {
            int i3 = aoQ.getInt("obj_param1");
            if (i3 != 0) {
                amVar.P("obj_param1", i3);
                if (i3 == 2) {
                    amVar.bT("fid", aoQ.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = aoQ.getInt("obj_type");
                    if (i4 != 0) {
                        amVar.P("obj_type", i4);
                    }
                    amVar.bT("tid", aoQ.getString("tid")).bT("fid", aoQ.getString("fid"));
                }
            }
            String string = aoQ.getString("obj_url");
            if (!ap.isEmpty(string)) {
                amVar.bT("obj_url", string);
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
            amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(amVar);
            return;
        }
        Bundle aoQ = shareEntity.aoQ();
        if (aoQ != null) {
            amVar.bT("tid", aoQ.getString("tid"));
            amVar.bT("uid", aoQ.getString("uid"));
            amVar.bT("fid", aoQ.getString("fid"));
        }
        TiebaStatic.log(amVar);
    }
}
