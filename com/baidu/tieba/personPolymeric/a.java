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
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && !StringUtils.isNull(absThreadDataSupport.bjZ().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.al("obj_source", 3);
            bw bjZ = absThreadDataSupport.bjZ();
            if (bjZ.bli()) {
                aqVar.al("obj_type", 1);
            } else if (bjZ.blj()) {
                aqVar.al("obj_type", 2);
            } else if (bjZ.bov()) {
                aqVar.al("obj_type", 3);
            } else if (bjZ.bow()) {
                aqVar.al("obj_type", 4);
            } else if (bjZ.threadType == 0) {
                aqVar.al("obj_type", 5);
            } else if (bjZ.blg()) {
                aqVar.al("obj_type", 6);
            }
            if (absThreadDataSupport.bjZ().bmA() != null) {
                aqVar.dR("uid", absThreadDataSupport.bjZ().bmA().getUserId());
            }
            if (bjZ.getBaijiahaoData() != null) {
                aqVar.dR("obj_id", bjZ.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dR("obj_id", bjZ.getTid());
            }
            aqVar.al("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void i(AbsThreadDataSupport absThreadDataSupport) {
        aq aqVar = new aq("c13578");
        bw bjZ = absThreadDataSupport.bjZ();
        if (bjZ.bli()) {
            aqVar.al("obj_type", 1);
        } else if (bjZ.blj()) {
            aqVar.al("obj_type", 2);
        } else if (bjZ.bov()) {
            aqVar.al("obj_type", 3);
        } else if (bjZ.bow()) {
            aqVar.al("obj_type", 4);
        } else if (bjZ.threadType == 0) {
            aqVar.al("obj_type", 5);
        } else if (bjZ.blg()) {
            aqVar.al("obj_type", 6);
        }
        if (bjZ.getBaijiahaoData() != null) {
            aqVar.dR("obj_id", bjZ.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dR("obj_id", bjZ.getTid());
        }
        aqVar.dR("uid", bjZ.bmA().getUserId());
        TiebaStatic.log(aqVar);
    }
}
