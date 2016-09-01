package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f {
    private TextView eDT;

    public f(Context context, ViewGroup viewGroup) {
        this.eDT = (TextView) LayoutInflater.from(context).inflate(t.h.item_person_center_extra_txt_view, viewGroup, true).findViewById(t.g.person_center_item_extra_txt);
    }

    public void pv(String str) {
        this.eDT.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        this.eDT.setText(str);
    }

    public void onChangeSkinType(int i) {
        av.b(this.eDT, t.d.cp_cont_d, 1, i);
    }
}
