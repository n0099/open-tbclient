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
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bfG() != null && !StringUtils.isNull(absThreadDataSupport.bfG().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.aj("obj_source", 3);
            bw bfG = absThreadDataSupport.bfG();
            if (bfG.bgP()) {
                aqVar.aj("obj_type", 1);
            } else if (bfG.bgQ()) {
                aqVar.aj("obj_type", 2);
            } else if (bfG.bkc()) {
                aqVar.aj("obj_type", 3);
            } else if (bfG.bkd()) {
                aqVar.aj("obj_type", 4);
            } else if (bfG.threadType == 0) {
                aqVar.aj("obj_type", 5);
            } else if (bfG.bgN()) {
                aqVar.aj("obj_type", 6);
            }
            if (absThreadDataSupport.bfG().bih() != null) {
                aqVar.dK("uid", absThreadDataSupport.bfG().bih().getUserId());
            }
            if (bfG.getBaijiahaoData() != null) {
                aqVar.dK("obj_id", bfG.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dK("obj_id", bfG.getTid());
            }
            aqVar.aj("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void i(AbsThreadDataSupport absThreadDataSupport) {
        aq aqVar = new aq("c13578");
        bw bfG = absThreadDataSupport.bfG();
        if (bfG.bgP()) {
            aqVar.aj("obj_type", 1);
        } else if (bfG.bgQ()) {
            aqVar.aj("obj_type", 2);
        } else if (bfG.bkc()) {
            aqVar.aj("obj_type", 3);
        } else if (bfG.bkd()) {
            aqVar.aj("obj_type", 4);
        } else if (bfG.threadType == 0) {
            aqVar.aj("obj_type", 5);
        } else if (bfG.bgN()) {
            aqVar.aj("obj_type", 6);
        }
        if (bfG.getBaijiahaoData() != null) {
            aqVar.dK("obj_id", bfG.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dK("obj_id", bfG.getTid());
        }
        aqVar.dK("uid", bfG.bih().getUserId());
        TiebaStatic.log(aqVar);
    }
}
