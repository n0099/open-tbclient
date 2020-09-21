package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes23.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bcY() != null && !StringUtils.isNull(absThreadDataSupport.bcY().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.ai("obj_source", 3);
            bw bcY = absThreadDataSupport.bcY();
            if (bcY.beg()) {
                aqVar.ai("obj_type", 1);
            } else if (bcY.beh()) {
                aqVar.ai("obj_type", 2);
            } else if (bcY.bht()) {
                aqVar.ai("obj_type", 3);
            } else if (bcY.bhu()) {
                aqVar.ai("obj_type", 4);
            } else if (bcY.threadType == 0) {
                aqVar.ai("obj_type", 5);
            } else if (bcY.bee()) {
                aqVar.ai("obj_type", 6);
            }
            if (absThreadDataSupport.bcY().bfy() != null) {
                aqVar.dF("uid", absThreadDataSupport.bcY().bfy().getUserId());
            }
            if (bcY.getBaijiahaoData() != null) {
                aqVar.dF("obj_id", bcY.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dF("obj_id", bcY.getTid());
            }
            aqVar.ai("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void i(AbsThreadDataSupport absThreadDataSupport) {
        aq aqVar = new aq("c13578");
        bw bcY = absThreadDataSupport.bcY();
        if (bcY.beg()) {
            aqVar.ai("obj_type", 1);
        } else if (bcY.beh()) {
            aqVar.ai("obj_type", 2);
        } else if (bcY.bht()) {
            aqVar.ai("obj_type", 3);
        } else if (bcY.bhu()) {
            aqVar.ai("obj_type", 4);
        } else if (bcY.threadType == 0) {
            aqVar.ai("obj_type", 5);
        } else if (bcY.bee()) {
            aqVar.ai("obj_type", 6);
        }
        if (bcY.getBaijiahaoData() != null) {
            aqVar.dF("obj_id", bcY.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dF("obj_id", bcY.getTid());
        }
        aqVar.dF("uid", bcY.bfy().getUserId());
        TiebaStatic.log(aqVar);
    }
}
