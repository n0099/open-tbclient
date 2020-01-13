package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.axQ() != null && !StringUtils.isNull(aVar.axQ().getTid())) {
            an anVar = new an("c13564");
            anVar.Z("obj_source", 3);
            bj axQ = aVar.axQ();
            if (axQ.ayL()) {
                anVar.Z("obj_type", 1);
            } else if (axQ.aBS()) {
                anVar.Z("obj_type", 2);
            } else if (axQ.aBT()) {
                anVar.Z("obj_type", 3);
            } else if (axQ.aBU()) {
                anVar.Z("obj_type", 4);
            } else if (axQ.threadType == 0) {
                anVar.Z("obj_type", 5);
            } else if (axQ.aAX()) {
                anVar.Z("obj_type", 6);
            }
            anVar.Z("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void d(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj axQ = aVar.axQ();
        if (axQ.ayL()) {
            anVar.Z("obj_type", 1);
        } else if (axQ.aBS()) {
            anVar.Z("obj_type", 2);
        } else if (axQ.aBT()) {
            anVar.Z("obj_type", 3);
        } else if (axQ.aBU()) {
            anVar.Z("obj_type", 4);
        } else if (axQ.threadType == 0) {
            anVar.Z("obj_type", 5);
        } else if (axQ.aAX()) {
            anVar.Z("obj_type", 6);
        }
        if (axQ.getBaijiahaoData() != null) {
            anVar.cp("obj_id", axQ.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cp("obj_id", axQ.getTid());
        }
        anVar.cp("uid", axQ.azX().getUserId());
        TiebaStatic.log(anVar);
    }
}
