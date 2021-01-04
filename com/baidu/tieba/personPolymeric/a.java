package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes8.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.boO() != null && !StringUtils.isNull(aVar.boO().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.an("obj_source", 3);
            bz boO = aVar.boO();
            if (boO.bpX()) {
                aqVar.an("obj_type", 1);
            } else if (boO.bpY()) {
                aqVar.an("obj_type", 2);
            } else if (boO.bto()) {
                aqVar.an("obj_type", 3);
            } else if (boO.btp()) {
                aqVar.an("obj_type", 4);
            } else if (boO.threadType == 0) {
                aqVar.an("obj_type", 5);
            } else if (boO.bpV()) {
                aqVar.an("obj_type", 6);
            }
            if (aVar.boO().brq() != null) {
                aqVar.dX("uid", aVar.boO().brq().getUserId());
            }
            if (boO.getBaijiahaoData() != null) {
                aqVar.dX("obj_id", boO.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dX("obj_id", boO.getTid());
            }
            aqVar.an("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        aq aqVar = new aq("c13578");
        bz boO = aVar.boO();
        if (boO.bpX()) {
            aqVar.an("obj_type", 1);
        } else if (boO.bpY()) {
            aqVar.an("obj_type", 2);
        } else if (boO.bto()) {
            aqVar.an("obj_type", 3);
        } else if (boO.btp()) {
            aqVar.an("obj_type", 4);
        } else if (boO.threadType == 0) {
            aqVar.an("obj_type", 5);
        } else if (boO.bpV()) {
            aqVar.an("obj_type", 6);
        }
        if (boO.getBaijiahaoData() != null) {
            aqVar.dX("obj_id", boO.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dX("obj_id", boO.getTid());
        }
        aqVar.dX("uid", boO.brq().getUserId());
        TiebaStatic.log(aqVar);
    }
}
