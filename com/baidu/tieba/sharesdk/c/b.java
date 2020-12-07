package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes24.dex */
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
            arVar.al("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bAj = shareEntity.bAj();
        if (bAj != null) {
            int i3 = bAj.getInt("obj_param1");
            if (i3 != 0) {
                arVar.al("obj_param1", i3);
                if (i3 == 2) {
                    arVar.dY("fid", bAj.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bAj.getInt("obj_type");
                    if (i4 != 0) {
                        arVar.al("obj_type", i4);
                    }
                    arVar.dY("tid", bAj.getString("tid")).dY("fid", bAj.getString("fid"));
                }
            }
            String string = bAj.getString(TiebaInitialize.Params.OBJ_URL);
            if (!au.isEmpty(string)) {
                arVar.dY(TiebaInitialize.Params.OBJ_URL, string);
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
            arVar.al("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(arVar);
            return;
        }
        Bundle bAj = shareEntity.bAj();
        if (bAj != null) {
            arVar.dY("tid", bAj.getString("tid"));
            arVar.dY("uid", bAj.getString("uid"));
            arVar.dY("fid", bAj.getString("fid"));
        }
        TiebaStatic.log(arVar);
    }
}
