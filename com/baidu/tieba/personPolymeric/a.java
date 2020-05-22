package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aOi() != null && !StringUtils.isNull(absThreadDataSupport.aOi().getTid())) {
            an anVar = new an("c13564");
            anVar.ag("obj_source", 3);
            bk aOi = absThreadDataSupport.aOi();
            if (aOi.aPm()) {
                anVar.ag("obj_type", 1);
            } else if (aOi.aPn()) {
                anVar.ag("obj_type", 2);
            } else if (aOi.aSv()) {
                anVar.ag("obj_type", 3);
            } else if (aOi.aSw()) {
                anVar.ag("obj_type", 4);
            } else if (aOi.threadType == 0) {
                anVar.ag("obj_type", 5);
            } else if (aOi.aPk()) {
                anVar.ag("obj_type", 6);
            }
            if (absThreadDataSupport.aOi().aQx() != null) {
                anVar.dh("uid", absThreadDataSupport.aOi().aQx().getUserId());
            }
            if (aOi.getBaijiahaoData() != null) {
                anVar.dh("obj_id", aOi.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.dh("obj_id", aOi.getTid());
            }
            anVar.ag("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    public static void h(AbsThreadDataSupport absThreadDataSupport) {
        an anVar = new an("c13578");
        bk aOi = absThreadDataSupport.aOi();
        if (aOi.aPm()) {
            anVar.ag("obj_type", 1);
        } else if (aOi.aPn()) {
            anVar.ag("obj_type", 2);
        } else if (aOi.aSv()) {
            anVar.ag("obj_type", 3);
        } else if (aOi.aSw()) {
            anVar.ag("obj_type", 4);
        } else if (aOi.threadType == 0) {
            anVar.ag("obj_type", 5);
        } else if (aOi.aPk()) {
            anVar.ag("obj_type", 6);
        }
        if (aOi.getBaijiahaoData() != null) {
            anVar.dh("obj_id", aOi.getBaijiahaoData().oriUgcNid);
        } else {
            anVar.dh("obj_id", aOi.getTid());
        }
        anVar.dh("uid", aOi.aQx().getUserId());
        TiebaStatic.log(anVar);
    }
}
