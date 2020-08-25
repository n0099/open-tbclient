package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes18.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bce() != null && !StringUtils.isNull(absThreadDataSupport.bce().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.ai("obj_source", 3);
            bw bce = absThreadDataSupport.bce();
            if (bce.bdm()) {
                aqVar.ai("obj_type", 1);
            } else if (bce.bdn()) {
                aqVar.ai("obj_type", 2);
            } else if (bce.bgz()) {
                aqVar.ai("obj_type", 3);
            } else if (bce.bgA()) {
                aqVar.ai("obj_type", 4);
            } else if (bce.threadType == 0) {
                aqVar.ai("obj_type", 5);
            } else if (bce.bdk()) {
                aqVar.ai("obj_type", 6);
            }
            if (absThreadDataSupport.bce().beE() != null) {
                aqVar.dD("uid", absThreadDataSupport.bce().beE().getUserId());
            }
            if (bce.getBaijiahaoData() != null) {
                aqVar.dD("obj_id", bce.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dD("obj_id", bce.getTid());
            }
            aqVar.ai("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void h(AbsThreadDataSupport absThreadDataSupport) {
        aq aqVar = new aq("c13578");
        bw bce = absThreadDataSupport.bce();
        if (bce.bdm()) {
            aqVar.ai("obj_type", 1);
        } else if (bce.bdn()) {
            aqVar.ai("obj_type", 2);
        } else if (bce.bgz()) {
            aqVar.ai("obj_type", 3);
        } else if (bce.bgA()) {
            aqVar.ai("obj_type", 4);
        } else if (bce.threadType == 0) {
            aqVar.ai("obj_type", 5);
        } else if (bce.bdk()) {
            aqVar.ai("obj_type", 6);
        }
        if (bce.getBaijiahaoData() != null) {
            aqVar.dD("obj_id", bce.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dD("obj_id", bce.getTid());
        }
        aqVar.dD("uid", bce.beE().getUserId());
        TiebaStatic.log(aqVar);
    }
}
