package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personCenter.g.e;
import com.baidu.tieba.personCenter.g.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.g.c eDn;
    private f eDo;
    private e eDp;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!y.t(arrayList) && this.eDn == null) {
                this.eDn = new com.baidu.tieba.personCenter.g.c(context, linearLayout);
            }
            if (this.eDn != null) {
                this.eDn.cD(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eDo == null) {
                this.eDo = new f(context, linearLayout);
            }
            if (this.eDo != null) {
                this.eDo.pv(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eDp == null) {
                this.eDp = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eDp != null) {
                this.eDp.oL(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eDn != null) {
            this.eDn.onChangeSkinType(i);
        }
        if (this.eDo != null) {
            this.eDo.onChangeSkinType(i);
        }
        if (this.eDp != null) {
            this.eDp.onChangeSkinType(i);
        }
    }
}
