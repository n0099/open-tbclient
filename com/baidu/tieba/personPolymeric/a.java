package com.baidu.tieba.personPolymeric;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes18.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aTN() != null && !StringUtils.isNull(absThreadDataSupport.aTN().getTid())) {
            ap apVar = new ap("c13564");
            apVar.ah("obj_source", 3);
            bv aTN = absThreadDataSupport.aTN();
            if (aTN.aUT()) {
                apVar.ah("obj_type", 1);
            } else if (aTN.aUU()) {
                apVar.ah("obj_type", 2);
            } else if (aTN.aYg()) {
                apVar.ah("obj_type", 3);
            } else if (aTN.aYh()) {
                apVar.ah("obj_type", 4);
            } else if (aTN.threadType == 0) {
                apVar.ah("obj_type", 5);
            } else if (aTN.aUR()) {
                apVar.ah("obj_type", 6);
            }
            if (absThreadDataSupport.aTN().aWl() != null) {
                apVar.dn("uid", absThreadDataSupport.aTN().aWl().getUserId());
            }
            if (aTN.getBaijiahaoData() != null) {
                apVar.dn("obj_id", aTN.getBaijiahaoData().oriUgcNid);
            } else {
                apVar.dn("obj_id", aTN.getTid());
            }
            apVar.ah("obj_locate", i);
            TiebaStatic.log(apVar);
        }
    }

    public static void h(AbsThreadDataSupport absThreadDataSupport) {
        ap apVar = new ap("c13578");
        bv aTN = absThreadDataSupport.aTN();
        if (aTN.aUT()) {
            apVar.ah("obj_type", 1);
        } else if (aTN.aUU()) {
            apVar.ah("obj_type", 2);
        } else if (aTN.aYg()) {
            apVar.ah("obj_type", 3);
        } else if (aTN.aYh()) {
            apVar.ah("obj_type", 4);
        } else if (aTN.threadType == 0) {
            apVar.ah("obj_type", 5);
        } else if (aTN.aUR()) {
            apVar.ah("obj_type", 6);
        }
        if (aTN.getBaijiahaoData() != null) {
            apVar.dn("obj_id", aTN.getBaijiahaoData().oriUgcNid);
        } else {
            apVar.dn("obj_id", aTN.getTid());
        }
        apVar.dn("uid", aTN.aWl().getUserId());
        TiebaStatic.log(apVar);
    }
}
