package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.personCenter.f.e;
import com.baidu.tieba.personCenter.f.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.f.c ezg;
    private f ezh;
    private e ezi;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!w.s(arrayList) && this.ezg == null) {
                this.ezg = new com.baidu.tieba.personCenter.f.c(context, linearLayout);
            }
            if (this.ezg != null) {
                this.ezg.cB(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.ezh == null) {
                this.ezh = new f(context, linearLayout);
            }
            if (this.ezh != null) {
                this.ezh.oO(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.ezi == null) {
                this.ezi = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.ezi != null) {
                this.ezi.pa(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ezg != null) {
            this.ezg.onChangeSkinType(i);
        }
        if (this.ezh != null) {
            this.ezh.onChangeSkinType(i);
        }
        if (this.ezi != null) {
            this.ezi.onChangeSkinType(i);
        }
    }
}
