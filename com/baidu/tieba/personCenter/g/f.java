package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    private TextView eMw;

    public f(Context context, ViewGroup viewGroup) {
        this.eMw = (TextView) LayoutInflater.from(context).inflate(r.h.item_person_center_extra_txt_view, viewGroup, true).findViewById(r.g.person_center_item_extra_txt);
    }

    public void pU(String str) {
        this.eMw.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        this.eMw.setText(str);
    }

    public void onChangeSkinType(int i) {
        at.b(this.eMw, r.d.cp_cont_d, 1, i);
    }
}
