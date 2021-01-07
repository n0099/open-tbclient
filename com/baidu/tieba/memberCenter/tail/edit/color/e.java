package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private GridView lpa;

    public e(ViewGroup viewGroup) {
        this.lpa = (GridView) viewGroup.findViewById(R.id.tail_edit_color_gridview);
    }

    public void a(a aVar) {
        this.lpa.setAdapter((ListAdapter) aVar);
    }
}
