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
            anVar.af("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle aUR = shareEntity.aUR();
        if (aUR != null) {
            int i3 = aUR.getInt("obj_param1");
            if (i3 != 0) {
                anVar.af("obj_param1", i3);
                if (i3 == 2) {
                    anVar.cI("fid", aUR.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = aUR.getInt("obj_type");
                    if (i4 != 0) {
                        anVar.af("obj_type", i4);
                    }
                    anVar.cI("tid", aUR.getString("tid")).cI("fid", aUR.getString("fid"));
                }
            }
            String string = aUR.getString(TiebaInitialize.Params.OBJ_URL);
            if (!aq.isEmpty(string)) {
                anVar.cI(TiebaInitialize.Params.OBJ_URL, string);
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
            anVar.af("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle aUR = shareEntity.aUR();
        if (aUR != null) {
            anVar.cI("tid", aUR.getString("tid"));
            anVar.cI("uid", aUR.getString("uid"));
            anVar.cI("fid", aUR.getString("fid"));
        }
        TiebaStatic.log(anVar);
    }
}
