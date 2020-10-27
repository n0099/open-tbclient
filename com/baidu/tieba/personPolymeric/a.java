package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes24.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bhz() != null && !StringUtils.isNull(absThreadDataSupport.bhz().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.aj("obj_source", 3);
            bw bhz = absThreadDataSupport.bhz();
            if (bhz.biI()) {
                aqVar.aj("obj_type", 1);
            } else if (bhz.biJ()) {
                aqVar.aj("obj_type", 2);
            } else if (bhz.blV()) {
                aqVar.aj("obj_type", 3);
            } else if (bhz.blW()) {
                aqVar.aj("obj_type", 4);
            } else if (bhz.threadType == 0) {
                aqVar.aj("obj_type", 5);
            } else if (bhz.biG()) {
                aqVar.aj("obj_type", 6);
            }
            if (absThreadDataSupport.bhz().bka() != null) {
                aqVar.dR("uid", absThreadDataSupport.bhz().bka().getUserId());
            }
            if (bhz.getBaijiahaoData() != null) {
                aqVar.dR("obj_id", bhz.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dR("obj_id", bhz.getTid());
            }
            aqVar.aj("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void i(AbsThreadDataSupport absThreadDataSupport) {
        aq aqVar = new aq("c13578");
        bw bhz = absThreadDataSupport.bhz();
        if (bhz.biI()) {
            aqVar.aj("obj_type", 1);
        } else if (bhz.biJ()) {
            aqVar.aj("obj_type", 2);
        } else if (bhz.blV()) {
            aqVar.aj("obj_type", 3);
        } else if (bhz.blW()) {
            aqVar.aj("obj_type", 4);
        } else if (bhz.threadType == 0) {
            aqVar.aj("obj_type", 5);
        } else if (bhz.biG()) {
            aqVar.aj("obj_type", 6);
        }
        if (bhz.getBaijiahaoData() != null) {
            aqVar.dR("obj_id", bhz.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dR("obj_id", bhz.getTid());
        }
        aqVar.dR("uid", bhz.bka().getUserId());
        TiebaStatic.log(aqVar);
    }
}
