package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes24.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bmn() != null && !StringUtils.isNull(aVar.bmn().getTid())) {
            ar arVar = new ar("c13564");
            arVar.al("obj_source", 3);
            by bmn = aVar.bmn();
            if (bmn.bnx()) {
                arVar.al("obj_type", 1);
            } else if (bmn.bny()) {
                arVar.al("obj_type", 2);
            } else if (bmn.bqM()) {
                arVar.al("obj_type", 3);
            } else if (bmn.bqN()) {
                arVar.al("obj_type", 4);
            } else if (bmn.threadType == 0) {
                arVar.al("obj_type", 5);
            } else if (bmn.bnv()) {
                arVar.al("obj_type", 6);
            }
            if (aVar.bmn().boP() != null) {
                arVar.dY("uid", aVar.bmn().boP().getUserId());
            }
            if (bmn.getBaijiahaoData() != null) {
                arVar.dY("obj_id", bmn.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dY("obj_id", bmn.getTid());
            }
            arVar.al("obj_locate", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        ar arVar = new ar("c13578");
        by bmn = aVar.bmn();
        if (bmn.bnx()) {
            arVar.al("obj_type", 1);
        } else if (bmn.bny()) {
            arVar.al("obj_type", 2);
        } else if (bmn.bqM()) {
            arVar.al("obj_type", 3);
        } else if (bmn.bqN()) {
            arVar.al("obj_type", 4);
        } else if (bmn.threadType == 0) {
            arVar.al("obj_type", 5);
        } else if (bmn.bnv()) {
            arVar.al("obj_type", 6);
        }
        if (bmn.getBaijiahaoData() != null) {
            arVar.dY("obj_id", bmn.getBaijiahaoData().oriUgcNid);
        } else {
            arVar.dY("obj_id", bmn.getTid());
        }
        arVar.dY("uid", bmn.boP().getUserId());
        TiebaStatic.log(arVar);
    }
}
