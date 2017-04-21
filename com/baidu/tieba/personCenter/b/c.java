package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.personCenter.f.e;
import com.baidu.tieba.personCenter.f.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.f.c eCS;
    private f eCT;
    private e eCU;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!x.q(arrayList) && this.eCS == null) {
                this.eCS = new com.baidu.tieba.personCenter.f.c(context, linearLayout);
            }
            if (this.eCS != null) {
                this.eCS.ci(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eCT == null) {
                this.eCT = new f(context, linearLayout);
            }
            if (this.eCT != null) {
                this.eCT.ob(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eCU == null) {
                this.eCU = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eCU != null) {
                this.eCU.pa(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCS != null) {
            this.eCS.onChangeSkinType(i);
        }
        if (this.eCT != null) {
            this.eCT.onChangeSkinType(i);
        }
        if (this.eCU != null) {
            this.eCU.onChangeSkinType(i);
        }
    }
}
