package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    private TextView ezP;

    public f(Context context, ViewGroup viewGroup) {
        this.ezP = (TextView) LayoutInflater.from(context).inflate(r.j.item_person_center_extra_txt_view, viewGroup, true).findViewById(r.h.person_center_item_extra_txt);
    }

    public void oO(String str) {
        this.ezP.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        this.ezP.setText(str);
    }

    public void onChangeSkinType(int i) {
        ap.b(this.ezP, r.e.cp_cont_d, 1, i);
    }
}
