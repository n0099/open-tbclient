package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes11.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
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
            anVar.ag("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle bbb = shareEntity.bbb();
        if (bbb != null) {
            int i3 = bbb.getInt("obj_param1");
            if (i3 != 0) {
                anVar.ag("obj_param1", i3);
                if (i3 == 2) {
                    anVar.dh("fid", bbb.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bbb.getInt("obj_type");
                    if (i4 != 0) {
                        anVar.ag("obj_type", i4);
                    }
                    anVar.dh("tid", bbb.getString("tid")).dh("fid", bbb.getString("fid"));
                }
            }
            String string = bbb.getString(TiebaInitialize.Params.OBJ_URL);
            if (!aq.isEmpty(string)) {
                anVar.dh(TiebaInitialize.Params.OBJ_URL, string);
            }
        }
        TiebaStatic.log(anVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
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
            anVar.ag("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle bbb = shareEntity.bbb();
        if (bbb != null) {
            anVar.dh("tid", bbb.getString("tid"));
            anVar.dh("uid", bbb.getString("uid"));
            anVar.dh("fid", bbb.getString("fid"));
        }
        TiebaStatic.log(anVar);
    }
}
