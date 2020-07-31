package com.baidu.tieba.sharesdk.c;

import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes18.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
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
            apVar.ah("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(apVar);
            return;
        }
        Bundle bgL = shareEntity.bgL();
        if (bgL != null) {
            int i3 = bgL.getInt("obj_param1");
            if (i3 != 0) {
                apVar.ah("obj_param1", i3);
                if (i3 == 2) {
                    apVar.dn("fid", bgL.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = bgL.getInt("obj_type");
                    if (i4 != 0) {
                        apVar.ah("obj_type", i4);
                    }
                    apVar.dn("tid", bgL.getString("tid")).dn("fid", bgL.getString("fid"));
                }
            }
            String string = bgL.getString(TiebaInitialize.Params.OBJ_URL);
            if (!as.isEmpty(string)) {
                apVar.dn(TiebaInitialize.Params.OBJ_URL, string);
            }
        }
        TiebaStatic.log(apVar);
    }

    public static void b(int i, ShareEntity shareEntity) {
        ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
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
            apVar.ah("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(apVar);
            return;
        }
        Bundle bgL = shareEntity.bgL();
        if (bgL != null) {
            apVar.dn("tid", bgL.getString("tid"));
            apVar.dn("uid", bgL.getString("uid"));
            apVar.dn("fid", bgL.getString("fid"));
        }
        TiebaStatic.log(apVar);
    }
}
