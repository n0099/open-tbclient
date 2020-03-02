package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aAg() != null && !StringUtils.isNull(aVar.aAg().getTid())) {
            an anVar = new an("c13564");
            anVar.X("obj_source", 3);
            bj aAg = aVar.aAg();
            if (aAg.aBd()) {
                anVar.X("obj_type", 1);
            } else if (aAg.aBe()) {
                anVar.X("obj_type", 2);
            } else if (aAg.aEg()) {
                anVar.X("obj_type", 3);
            } else if (aAg.aEh()) {
                anVar.X("obj_type", 4);
            } else if (aAg.threadType == 0) {
                anVar.X("obj_type", 5);
            } else if (aAg.aBb()) {
                anVar.X("obj_type", 6);
            }
            anVar.X("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void e(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj aAg = aVar.aAg();
        if (aAg.aBd()) {
            anVar.X("obj_type", 1);
        } else if (aAg.aBe()) {
            anVar.X("obj_type", 2);
        } else if (aAg.aEg()) {
            anVar.X("obj_type", 3);
        } else if (aAg.aEh()) {
            anVar.X("obj_type", 4);
        } else if (aAg.threadType == 0) {
            anVar.X("obj_type", 5);
        } else if (aAg.aBb()) {
            anVar.X("obj_type", 6);
        }
        if (aAg.getBaijiahaoData() != null) {
            anVar.cy("obj_id", aAg.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cy("obj_id", aAg.getTid());
        }
        anVar.cy("uid", aAg.aCo().getUserId());
        TiebaStatic.log(anVar);
    }
}
