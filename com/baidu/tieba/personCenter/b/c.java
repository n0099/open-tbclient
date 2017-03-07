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
    private com.baidu.tieba.personCenter.f.c eCF;
    private f eCG;
    private e eCH;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!x.q(arrayList) && this.eCF == null) {
                this.eCF = new com.baidu.tieba.personCenter.f.c(context, linearLayout);
            }
            if (this.eCF != null) {
                this.eCF.ci(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eCG == null) {
                this.eCG = new f(context, linearLayout);
            }
            if (this.eCG != null) {
                this.eCG.nW(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eCH == null) {
                this.eCH = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eCH != null) {
                this.eCH.oW(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eCF != null) {
            this.eCF.onChangeSkinType(i);
        }
        if (this.eCG != null) {
            this.eCG.onChangeSkinType(i);
        }
        if (this.eCH != null) {
            this.eCH.onChangeSkinType(i);
        }
    }
}
