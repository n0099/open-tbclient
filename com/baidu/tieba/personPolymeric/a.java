package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aIw() != null && !StringUtils.isNull(aVar.aIw().getTid())) {
            an anVar = new an("c13564");
            anVar.af("obj_source", 3);
            bj aIw = aVar.aIw();
            if (aIw.aJt()) {
                anVar.af("obj_type", 1);
            } else if (aIw.aJu()) {
                anVar.af("obj_type", 2);
            } else if (aIw.aMy()) {
                anVar.af("obj_type", 3);
            } else if (aIw.aMz()) {
                anVar.af("obj_type", 4);
            } else if (aIw.threadType == 0) {
                anVar.af("obj_type", 5);
            } else if (aIw.aJr()) {
                anVar.af("obj_type", 6);
            }
            if (aVar.aIw().aKE() != null) {
                anVar.cI("uid", aVar.aIw().aKE().getUserId());
            }
            if (aIw.getBaijiahaoData() != null) {
                anVar.cI("obj_id", aIw.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.cI("obj_id", aIw.getTid());
            }
            anVar.af("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void e(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj aIw = aVar.aIw();
        if (aIw.aJt()) {
            anVar.af("obj_type", 1);
        } else if (aIw.aJu()) {
            anVar.af("obj_type", 2);
        } else if (aIw.aMy()) {
            anVar.af("obj_type", 3);
        } else if (aIw.aMz()) {
            anVar.af("obj_type", 4);
        } else if (aIw.threadType == 0) {
            anVar.af("obj_type", 5);
        } else if (aIw.aJr()) {
            anVar.af("obj_type", 6);
        }
        if (aIw.getBaijiahaoData() != null) {
            anVar.cI("obj_id", aIw.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cI("obj_id", aIw.getTid());
        }
        anVar.cI("uid", aIw.aKE().getUserId());
        TiebaStatic.log(anVar);
    }
}
