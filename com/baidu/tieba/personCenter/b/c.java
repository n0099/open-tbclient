package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.personCenter.g.e;
import com.baidu.tieba.personCenter.g.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.g.c eLP;
    private f eLQ;
    private e eLR;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!x.t(arrayList) && this.eLP == null) {
                this.eLP = new com.baidu.tieba.personCenter.g.c(context, linearLayout);
            }
            if (this.eLP != null) {
                this.eLP.cG(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eLQ == null) {
                this.eLQ = new f(context, linearLayout);
            }
            if (this.eLQ != null) {
                this.eLQ.pU(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eLR == null) {
                this.eLR = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eLR != null) {
                this.eLR.pi(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eLP != null) {
            this.eLP.onChangeSkinType(i);
        }
        if (this.eLQ != null) {
            this.eLQ.onChangeSkinType(i);
        }
        if (this.eLR != null) {
            this.eLR.onChangeSkinType(i);
        }
    }
}
