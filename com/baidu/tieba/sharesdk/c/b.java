package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes11.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
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
            aoVar.ag("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aoVar);
            return;
        }
        Bundle bde = shareEntity.bde();
        if (bde != null) {
            int i3 = bde.getInt("obj_param1");
            if (i3 != 0) {
                aoVar.ag("obj_param1", i3);
                if (i3 == 2) {
                    aoVar.dk("fid", bde.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bde.getInt("obj_type");
                    if (i4 != 0) {
                        aoVar.ag("obj_type", i4);
                    }
                    aoVar.dk("tid", bde.getString("tid")).dk("fid", bde.getString("fid"));
                }
            }
            String string = bde.getString(TiebaInitialize.Params.OBJ_URL);
            if (!ar.isEmpty(string)) {
                aoVar.dk(TiebaInitialize.Params.OBJ_URL, string);
            }
        }
        TiebaStatic.log(aoVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
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
            aoVar.ag("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(aoVar);
            return;
        }
        Bundle bde = shareEntity.bde();
        if (bde != null) {
            aoVar.dk("tid", bde.getString("tid"));
            aoVar.dk("uid", bde.getString("uid"));
            aoVar.dk("fid", bde.getString("fid"));
        }
        TiebaStatic.log(aoVar);
    }
}
