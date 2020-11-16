package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes23.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bjd() != null && !StringUtils.isNull(aVar.bjd().getTid())) {
            ar arVar = new ar("c13564");
            arVar.ak("obj_source", 3);
            bx bjd = aVar.bjd();
            if (bjd.bkk()) {
                arVar.ak("obj_type", 1);
            } else if (bjd.bkl()) {
                arVar.ak("obj_type", 2);
            } else if (bjd.bnz()) {
                arVar.ak("obj_type", 3);
            } else if (bjd.bnA()) {
                arVar.ak("obj_type", 4);
            } else if (bjd.threadType == 0) {
                arVar.ak("obj_type", 5);
            } else if (bjd.bki()) {
                arVar.ak("obj_type", 6);
            }
            if (aVar.bjd().blC() != null) {
                arVar.dR("uid", aVar.bjd().blC().getUserId());
            }
            if (bjd.getBaijiahaoData() != null) {
                arVar.dR("obj_id", bjd.getBaijiahaoData().oriUgcNid);
            } else {
                arVar.dR("obj_id", bjd.getTid());
            }
            arVar.ak("obj_locate", i);
            TiebaStatic.log(arVar);
        }
    }

    public static void i(com.baidu.tbadk.core.data.a aVar) {
        ar arVar = new ar("c13578");
        bx bjd = aVar.bjd();
        if (bjd.bkk()) {
            arVar.ak("obj_type", 1);
        } else if (bjd.bkl()) {
            arVar.ak("obj_type", 2);
        } else if (bjd.bnz()) {
            arVar.ak("obj_type", 3);
        } else if (bjd.bnA()) {
            arVar.ak("obj_type", 4);
        } else if (bjd.threadType == 0) {
            arVar.ak("obj_type", 5);
        } else if (bjd.bki()) {
            arVar.ak("obj_type", 6);
        }
        if (bjd.getBaijiahaoData() != null) {
            arVar.dR("obj_id", bjd.getBaijiahaoData().oriUgcNid);
        } else {
            arVar.dR("obj_id", bjd.getTid());
        }
        arVar.dR("uid", bjd.blC().getUserId());
        TiebaStatic.log(arVar);
    }
}
