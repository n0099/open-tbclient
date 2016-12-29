package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    private TextView epS;

    public f(Context context, ViewGroup viewGroup) {
        this.epS = (TextView) LayoutInflater.from(context).inflate(r.h.item_person_center_extra_txt_view, viewGroup, true).findViewById(r.g.person_center_item_extra_txt);
    }

    public void ow(String str) {
        this.epS.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        this.epS.setText(str);
    }

    public void onChangeSkinType(int i) {
        ar.b(this.epS, r.d.cp_cont_d, 1, i);
    }
}
