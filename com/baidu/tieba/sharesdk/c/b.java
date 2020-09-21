package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes23.dex */
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
            aqVar.ai("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aqVar);
            return;
        }
        Bundle bqr = shareEntity.bqr();
        if (bqr != null) {
            int i3 = bqr.getInt("obj_param1");
            if (i3 != 0) {
                aqVar.ai("obj_param1", i3);
                if (i3 == 2) {
                    aqVar.dF("fid", bqr.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bqr.getInt("obj_type");
                    if (i4 != 0) {
                        aqVar.ai("obj_type", i4);
                    }
                    aqVar.dF("tid", bqr.getString("tid")).dF("fid", bqr.getString("fid"));
                }
            }
            String string = bqr.getString(TiebaInitialize.Params.OBJ_URL);
            if (!at.isEmpty(string)) {
                aqVar.dF(TiebaInitialize.Params.OBJ_URL, string);
            }
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
            aqVar.ai("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aqVar);
            return;
        }
        Bundle bqr = shareEntity.bqr();
        if (bqr != null) {
            aqVar.dF("tid", bqr.getString("tid"));
            aqVar.dF("uid", bqr.getString("uid"));
            aqVar.dF("fid", bqr.getString("fid"));
        }
        TiebaStatic.log(aqVar);
    }
}
