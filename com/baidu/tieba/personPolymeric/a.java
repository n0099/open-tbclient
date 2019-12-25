package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.axx() != null && !StringUtils.isNull(aVar.axx().getTid())) {
            an anVar = new an("c13564");
            anVar.Z("obj_source", 3);
            bj axx = aVar.axx();
            if (axx.ays()) {
                anVar.Z("obj_type", 1);
            } else if (axx.aBz()) {
                anVar.Z("obj_type", 2);
            } else if (axx.aBA()) {
                anVar.Z("obj_type", 3);
            } else if (axx.aBB()) {
                anVar.Z("obj_type", 4);
            } else if (axx.threadType == 0) {
                anVar.Z("obj_type", 5);
            } else if (axx.aAE()) {
                anVar.Z("obj_type", 6);
            }
            anVar.Z("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void d(com.baidu.tbadk.core.data.a aVar) {
        an anVar = new an("c13578");
        bj axx = aVar.axx();
        if (axx.ays()) {
            anVar.Z("obj_type", 1);
        } else if (axx.aBz()) {
            anVar.Z("obj_type", 2);
        } else if (axx.aBA()) {
            anVar.Z("obj_type", 3);
        } else if (axx.aBB()) {
            anVar.Z("obj_type", 4);
        } else if (axx.threadType == 0) {
            anVar.Z("obj_type", 5);
        } else if (axx.aAE()) {
            anVar.Z("obj_type", 6);
        }
        if (axx.getBaijiahaoData() != null) {
            anVar.cp("obj_id", axx.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.cp("obj_id", axx.getTid());
        }
        anVar.cp("uid", axx.azE().getUserId());
        TiebaStatic.log(anVar);
    }
}
