package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes8.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
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
            arVar.ap("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bzc = shareEntity.bzc();
        if (bzc != null) {
            int i3 = bzc.getInt("obj_param1");
            if (i3 != 0) {
                arVar.ap("obj_param1", i3);
                if (i3 == 2) {
                    arVar.dR("fid", bzc.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bzc.getInt("obj_type");
                    if (i4 != 0) {
                        arVar.ap("obj_type", i4);
                    }
                    arVar.dR("tid", bzc.getString("tid")).dR("fid", bzc.getString("fid"));
                }
            }
            String string = bzc.getString(TiebaInitialize.Params.OBJ_URL);
            if (!au.isEmpty(string)) {
                arVar.dR(TiebaInitialize.Params.OBJ_URL, string);
            }
            arVar.ap("obj_locate", bzc.getInt("obj_locate"));
        }
        TiebaStatic.log(arVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
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
            arVar.ap("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bzc = shareEntity.bzc();
        if (bzc != null) {
            arVar.dR("tid", bzc.getString("tid"));
            arVar.dR("uid", bzc.getString("uid"));
            arVar.dR("fid", bzc.getString("fid"));
        }
        TiebaStatic.log(arVar);
    }
}
