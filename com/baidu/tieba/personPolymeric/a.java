package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bln() != null && !StringUtils.isNull(aVar.bln().getTid())) {
            ar arVar = new ar("c13564");
            arVar.ap("obj_source", 3);
            cb bln = aVar.bln();
            if (bln.bmx()) {
                arVar.ap("obj_type", 1);
            } else if (bln.bmy()) {
                arVar.ap("obj_type", 2);
            } else if (bln.bpN()) {
                arVar.ap("obj_type", 3);
            } else if (bln.bpO()) {
                arVar.ap("obj_type", 4);
            } else if (bln.threadType == 0) {
                arVar.ap("obj_type", 5);
            } else if (bln.bmv()) {
                arVar.ap("obj_type", 6);
            }
            if (aVar.bln().bnQ() != null) {
                arVar.dR("uid", aVar.bln().bnQ().getUserId());
            }
            if (bln.getBaijiahaoData() != null) {
                arVar.dR("obj_id", bln.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dR("obj_id", bln.getTid());
            }
            arVar.ap("obj_locate", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        ar arVar = new ar("c13578");
        cb bln = aVar.bln();
        if (bln.bmx()) {
            arVar.ap("obj_type", 1);
        } else if (bln.bmy()) {
            arVar.ap("obj_type", 2);
        } else if (bln.bpN()) {
            arVar.ap("obj_type", 3);
        } else if (bln.bpO()) {
            arVar.ap("obj_type", 4);
        } else if (bln.threadType == 0) {
            arVar.ap("obj_type", 5);
        } else if (bln.bmv()) {
            arVar.ap("obj_type", 6);
        }
        if (bln.getBaijiahaoData() != null) {
            arVar.dR("obj_id", bln.getBaijiahaoData().oriUgcNid);
        } else {
            arVar.dR("obj_id", bln.getTid());
        }
        arVar.dR("uid", bln.bnQ().getUserId());
        TiebaStatic.log(arVar);
    }
}
