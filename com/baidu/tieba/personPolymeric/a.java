package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes8.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.boP() != null && !StringUtils.isNull(aVar.boP().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.an("obj_source", 3);
            bz boP = aVar.boP();
            if (boP.bpY()) {
                aqVar.an("obj_type", 1);
            } else if (boP.bpZ()) {
                aqVar.an("obj_type", 2);
            } else if (boP.btp()) {
                aqVar.an("obj_type", 3);
            } else if (boP.btq()) {
                aqVar.an("obj_type", 4);
            } else if (boP.threadType == 0) {
                aqVar.an("obj_type", 5);
            } else if (boP.bpW()) {
                aqVar.an("obj_type", 6);
            }
            if (aVar.boP().brr() != null) {
                aqVar.dX("uid", aVar.boP().brr().getUserId());
            }
            if (boP.getBaijiahaoData() != null) {
                aqVar.dX("obj_id", boP.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dX("obj_id", boP.getTid());
            }
            aqVar.an("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        aq aqVar = new aq("c13578");
        bz boP = aVar.boP();
        if (boP.bpY()) {
            aqVar.an("obj_type", 1);
        } else if (boP.bpZ()) {
            aqVar.an("obj_type", 2);
        } else if (boP.btp()) {
            aqVar.an("obj_type", 3);
        } else if (boP.btq()) {
            aqVar.an("obj_type", 4);
        } else if (boP.threadType == 0) {
            aqVar.an("obj_type", 5);
        } else if (boP.bpW()) {
            aqVar.an("obj_type", 6);
        }
        if (boP.getBaijiahaoData() != null) {
            aqVar.dX("obj_id", boP.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dX("obj_id", boP.getTid());
        }
        aqVar.dX("uid", boP.brr().getUserId());
        TiebaStatic.log(aqVar);
    }
}
