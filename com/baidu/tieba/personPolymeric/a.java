package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes7.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.blp() != null && !StringUtils.isNull(aVar.blp().getTid())) {
            ar arVar = new ar("c13564");
            arVar.aq("obj_source", 3);
            cb blp = aVar.blp();
            if (blp.bmz()) {
                arVar.aq("obj_type", 1);
            } else if (blp.bmA()) {
                arVar.aq("obj_type", 2);
            } else if (blp.bpP()) {
                arVar.aq("obj_type", 3);
            } else if (blp.bpQ()) {
                arVar.aq("obj_type", 4);
            } else if (blp.threadType == 0) {
                arVar.aq("obj_type", 5);
            } else if (blp.bmx()) {
                arVar.aq("obj_type", 6);
            }
            if (aVar.blp().bnS() != null) {
                arVar.dR("uid", aVar.blp().bnS().getUserId());
            }
            if (blp.getBaijiahaoData() != null) {
                arVar.dR("obj_id", blp.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dR("obj_id", blp.getTid());
            }
            arVar.aq("obj_locate", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        ar arVar = new ar("c13578");
        cb blp = aVar.blp();
        if (blp.bmz()) {
            arVar.aq("obj_type", 1);
        } else if (blp.bmA()) {
            arVar.aq("obj_type", 2);
        } else if (blp.bpP()) {
            arVar.aq("obj_type", 3);
        } else if (blp.bpQ()) {
            arVar.aq("obj_type", 4);
        } else if (blp.threadType == 0) {
            arVar.aq("obj_type", 5);
        } else if (blp.bmx()) {
            arVar.aq("obj_type", 6);
        }
        if (blp.getBaijiahaoData() != null) {
            arVar.dR("obj_id", blp.getBaijiahaoData().oriUgcNid);
        } else {
            arVar.dR("obj_id", blp.getTid());
        }
        arVar.dR("uid", blp.bnS().getUserId());
        TiebaStatic.log(arVar);
    }
}
