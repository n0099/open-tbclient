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
    private com.baidu.tieba.personCenter.f.c eAC;
    private f eAD;
    private e eAE;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!x.q(arrayList) && this.eAC == null) {
                this.eAC = new com.baidu.tieba.personCenter.f.c(context, linearLayout);
            }
            if (this.eAC != null) {
                this.eAC.ch(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eAD == null) {
                this.eAD = new f(context, linearLayout);
            }
            if (this.eAD != null) {
                this.eAD.oa(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eAE == null) {
                this.eAE = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eAE != null) {
                this.eAE.oU(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eAC != null) {
            this.eAC.onChangeSkinType(i);
        }
        if (this.eAD != null) {
            this.eAD.onChangeSkinType(i);
        }
        if (this.eAE != null) {
            this.eAE.onChangeSkinType(i);
        }
    }
}
