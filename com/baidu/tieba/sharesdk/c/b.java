package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes23.dex */
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
            arVar.ak("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bwJ = shareEntity.bwJ();
        if (bwJ != null) {
            int i3 = bwJ.getInt("obj_param1");
            if (i3 != 0) {
                arVar.ak("obj_param1", i3);
                if (i3 == 2) {
                    arVar.dR("fid", bwJ.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bwJ.getInt("obj_type");
                    if (i4 != 0) {
                        arVar.ak("obj_type", i4);
                    }
                    arVar.dR("tid", bwJ.getString("tid")).dR("fid", bwJ.getString("fid"));
                }
            }
            String string = bwJ.getString(TiebaInitialize.Params.OBJ_URL);
            if (!au.isEmpty(string)) {
                arVar.dR(TiebaInitialize.Params.OBJ_URL, string);
            }
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
            arVar.ak("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bwJ = shareEntity.bwJ();
        if (bwJ != null) {
            arVar.dR("tid", bwJ.getString("tid"));
            arVar.dR("uid", bwJ.getString("uid"));
            arVar.dR("fid", bwJ.getString("fid"));
        }
        TiebaStatic.log(arVar);
    }
}
