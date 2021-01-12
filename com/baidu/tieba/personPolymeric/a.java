package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes7.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.bkV() != null && !StringUtils.isNull(aVar.bkV().getTid())) {
            aq aqVar = new aq("c13564");
            aqVar.an("obj_source", 3);
            bz bkV = aVar.bkV();
            if (bkV.bme()) {
                aqVar.an("obj_type", 1);
            } else if (bkV.bmf()) {
                aqVar.an("obj_type", 2);
            } else if (bkV.bpv()) {
                aqVar.an("obj_type", 3);
            } else if (bkV.bpw()) {
                aqVar.an("obj_type", 4);
            } else if (bkV.threadType == 0) {
                aqVar.an("obj_type", 5);
            } else if (bkV.bmc()) {
                aqVar.an("obj_type", 6);
            }
            if (aVar.bkV().bnx() != null) {
                aqVar.dW("uid", aVar.bkV().bnx().getUserId());
            }
            if (bkV.getBaijiahaoData() != null) {
                aqVar.dW("obj_id", bkV.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dW("obj_id", bkV.getTid());
            }
            aqVar.an("obj_locate", i);
            TiebaStatic.log(aqVar);
        }
    }

    public static void j(com.baidu.tbadk.core.data.a aVar) {
        aq aqVar = new aq("c13578");
        bz bkV = aVar.bkV();
        if (bkV.bme()) {
            aqVar.an("obj_type", 1);
        } else if (bkV.bmf()) {
            aqVar.an("obj_type", 2);
        } else if (bkV.bpv()) {
            aqVar.an("obj_type", 3);
        } else if (bkV.bpw()) {
            aqVar.an("obj_type", 4);
        } else if (bkV.threadType == 0) {
            aqVar.an("obj_type", 5);
        } else if (bkV.bmc()) {
            aqVar.an("obj_type", 6);
        }
        if (bkV.getBaijiahaoData() != null) {
            aqVar.dW("obj_id", bkV.getBaijiahaoData().oriUgcNid);
        } else {
            aqVar.dW("obj_id", bkV.getTid());
        }
        aqVar.dW("uid", bkV.bnx().getUserId());
        TiebaStatic.log(aqVar);
    }
}
