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
            anVar.X("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle aMp = shareEntity.aMp();
        if (aMp != null) {
            int i3 = aMp.getInt("obj_param1");
            if (i3 != 0) {
                anVar.X("obj_param1", i3);
                if (i3 == 2) {
                    anVar.cy("fid", aMp.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = aMp.getInt("obj_type");
                    if (i4 != 0) {
                        anVar.X("obj_type", i4);
                    }
                    anVar.cy("tid", aMp.getString("tid")).cy("fid", aMp.getString("fid"));
                }
            }
            String string = aMp.getString(TiebaInitialize.Params.OBJ_URL);
            if (!aq.isEmpty(string)) {
                anVar.cy(TiebaInitialize.Params.OBJ_URL, string);
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
            anVar.X("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(anVar);
            return;
        }
        Bundle aMp = shareEntity.aMp();
        if (aMp != null) {
            anVar.cy("tid", aMp.getString("tid"));
            anVar.cy("uid", aMp.getString("uid"));
            anVar.cy("fid", aMp.getString("fid"));
        }
        TiebaStatic.log(anVar);
    }
}
