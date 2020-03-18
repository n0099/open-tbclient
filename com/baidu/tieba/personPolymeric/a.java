package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aAj() != null && !StringUtils.isNull(aVar.aAj().getTid())) {
            an anVar = new an("c13564");
            anVar.X("obj_source", 3);
            bj aAj = aVar.aAj();
            if (aAj.aBg()) {
                anVar.X("obj_type", 1);
            } else if (aAj.aBh()) {
                anVar.X("obj_type", 2);
            } else if (aAj.aEk()) {
                anVar.X("obj_type", 3);
            } else if (aAj.aEl()) {
                anVar.X("obj_type", 4);
            } else if (aAj.threadType == 0) {
                anVar.X("obj_type", 5);
            } else if (aAj.aBe()) {
                anVar.X("obj_type", 6);
            }
            anVar.X("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void e(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj aAj = aVar.aAj();
        if (aAj.aBg()) {
            anVar.X("obj_type", 1);
        } else if (aAj.aBh()) {
            anVar.X("obj_type", 2);
        } else if (aAj.aEk()) {
            anVar.X("obj_type", 3);
        } else if (aAj.aEl()) {
            anVar.X("obj_type", 4);
        } else if (aAj.threadType == 0) {
            anVar.X("obj_type", 5);
        } else if (aAj.aBe()) {
            anVar.X("obj_type", 6);
        }
        if (aAj.getBaijiahaoData() != null) {
            anVar.cx("obj_id", aAj.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cx("obj_id", aAj.getTid());
        }
        anVar.cx("uid", aAj.aCr().getUserId());
        TiebaStatic.log(anVar);
    }
}
