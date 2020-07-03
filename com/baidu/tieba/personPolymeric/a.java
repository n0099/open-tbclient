package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes11.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aPS() != null && !StringUtils.isNull(absThreadDataSupport.aPS().getTid())) {
            ao aoVar = new ao("c13564");
            aoVar.ag("obj_source", 3);
            bu aPS = absThreadDataSupport.aPS();
            if (aPS.aQX()) {
                aoVar.ag("obj_type", 1);
            } else if (aPS.aQY()) {
                aoVar.ag("obj_type", 2);
            } else if (aPS.aUl()) {
                aoVar.ag("obj_type", 3);
            } else if (aPS.aUm()) {
                aoVar.ag("obj_type", 4);
            } else if (aPS.threadType == 0) {
                aoVar.ag("obj_type", 5);
            } else if (aPS.aQV()) {
                aoVar.ag("obj_type", 6);
            }
            if (absThreadDataSupport.aPS().aSp() != null) {
                aoVar.dk("uid", absThreadDataSupport.aPS().aSp().getUserId());
            }
            if (aPS.getBaijiahaoData() != null) {
                aoVar.dk("obj_id", aPS.getBaijiahaoData().oriUgcNid);
            } else {
                aoVar.dk("obj_id", aPS.getTid());
            }
            aoVar.ag("obj_locate", i);
            TiebaStatic.log(aoVar);
        }
    }

    public static void h(AbsThreadDataSupport absThreadDataSupport) {
        ao aoVar = new ao("c13578");
        bu aPS = absThreadDataSupport.aPS();
        if (aPS.aQX()) {
            aoVar.ag("obj_type", 1);
        } else if (aPS.aQY()) {
            aoVar.ag("obj_type", 2);
        } else if (aPS.aUl()) {
            aoVar.ag("obj_type", 3);
        } else if (aPS.aUm()) {
            aoVar.ag("obj_type", 4);
        } else if (aPS.threadType == 0) {
            aoVar.ag("obj_type", 5);
        } else if (aPS.aQV()) {
            aoVar.ag("obj_type", 6);
        }
        if (aPS.getBaijiahaoData() != null) {
            aoVar.dk("obj_id", aPS.getBaijiahaoData().oriUgcNid);
        } else {
            aoVar.dk("obj_id", aPS.getTid());
        }
        aoVar.dk("uid", aPS.aSp().getUserId());
        TiebaStatic.log(aoVar);
    }
}
