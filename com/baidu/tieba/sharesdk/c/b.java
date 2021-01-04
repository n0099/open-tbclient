package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes8.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
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
            aqVar.an("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aqVar);
            return;
        }
        Bundle bCD = shareEntity.bCD();
        if (bCD != null) {
            int i3 = bCD.getInt("obj_param1");
            if (i3 != 0) {
                aqVar.an("obj_param1", i3);
                if (i3 == 2) {
                    aqVar.dX("fid", bCD.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bCD.getInt("obj_type");
                    if (i4 != 0) {
                        aqVar.an("obj_type", i4);
                    }
                    aqVar.dX("tid", bCD.getString("tid")).dX("fid", bCD.getString("fid"));
                }
            }
            String string = bCD.getString(TiebaInitialize.Params.OBJ_URL);
            if (!at.isEmpty(string)) {
                aqVar.dX(TiebaInitialize.Params.OBJ_URL, string);
            }
            aqVar.an("obj_locate", bCD.getInt("obj_locate"));
        }
        TiebaStatic.log(aqVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
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
            aqVar.an("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aqVar);
            return;
        }
        Bundle bCD = shareEntity.bCD();
        if (bCD != null) {
            aqVar.dX("tid", bCD.getString("tid"));
            aqVar.dX("uid", bCD.getString("uid"));
            aqVar.dX("fid", bCD.getString("fid"));
        }
        TiebaStatic.log(aqVar);
    }
}
