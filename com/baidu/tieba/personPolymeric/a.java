package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aIu() != null && !StringUtils.isNull(aVar.aIu().getTid())) {
            an anVar = new an("c13564");
            anVar.af("obj_source", 3);
            bj aIu = aVar.aIu();
            if (aIu.aJr()) {
                anVar.af("obj_type", 1);
            } else if (aIu.aJs()) {
                anVar.af("obj_type", 2);
            } else if (aIu.aMw()) {
                anVar.af("obj_type", 3);
            } else if (aIu.aMx()) {
                anVar.af("obj_type", 4);
            } else if (aIu.threadType == 0) {
                anVar.af("obj_type", 5);
            } else if (aIu.aJp()) {
                anVar.af("obj_type", 6);
            }
            if (aVar.aIu().aKC() != null) {
                anVar.cI("uid", aVar.aIu().aKC().getUserId());
            }
            if (aIu.getBaijiahaoData() != null) {
                anVar.cI("obj_id", aIu.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.cI("obj_id", aIu.getTid());
            }
            anVar.af("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void e(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj aIu = aVar.aIu();
        if (aIu.aJr()) {
            anVar.af("obj_type", 1);
        } else if (aIu.aJs()) {
            anVar.af("obj_type", 2);
        } else if (aIu.aMw()) {
            anVar.af("obj_type", 3);
        } else if (aIu.aMx()) {
            anVar.af("obj_type", 4);
        } else if (aIu.threadType == 0) {
            anVar.af("obj_type", 5);
        } else if (aIu.aJp()) {
            anVar.af("obj_type", 6);
        }
        if (aIu.getBaijiahaoData() != null) {
            anVar.cI("obj_id", aIu.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cI("obj_id", aIu.getTid());
        }
        anVar.cI("uid", aIu.aKC().getUserId());
        TiebaStatic.log(anVar);
    }
}
