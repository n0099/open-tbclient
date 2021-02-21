package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private GridView lsK;

    public e(ViewGroup viewGroup) {
        this.lsK = (GridView) viewGroup.findViewById(R.id.tail_edit_color_gridview);
    }

    public void a(a aVar) {
        this.lsK.setAdapter((ListAdapter) aVar);
    }
}
