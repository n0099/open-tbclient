package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private TextView eBl;

    public f(Context context, ViewGroup viewGroup) {
        this.eBl = (TextView) LayoutInflater.from(context).inflate(w.j.item_person_center_extra_txt_view, viewGroup, true).findViewById(w.h.person_center_item_extra_txt);
    }

    public void oa(String str) {
        this.eBl.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        this.eBl.setText(str);
    }

    public void onChangeSkinType(int i) {
        aq.b(this.eBl, w.e.cp_cont_d, 1, i);
    }
}
