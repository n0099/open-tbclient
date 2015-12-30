package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.a.ae;
/* loaded from: classes.dex */
public class m extends x.a {
    public TextView aOS;
    public int ahf;
    public View cUE;
    public HorizontalListView cUF;
    public n cUG;
    public View rootView;

    public m(View view, Context context) {
        super(view);
        this.ahf = 3;
        this.rootView = view;
        this.cUE = view.findViewById(n.g.divider_view_under_photo_album);
        this.aOS = (TextView) view.findViewById(n.g.text_view_photo_album);
        this.cUF = (HorizontalListView) view.findViewById(n.g.listview_photo_album);
        this.cUG = new n(context);
        this.cUF.setAdapter((ListAdapter) this.cUG);
        this.cUF.setDisableParentEvent(false);
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.cUG.setData(aeVar.getPhotoAlbum());
            this.cUG.notifyDataSetChanged();
        }
    }

    public void apC() {
        if (this.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ahf = TbadkCoreApplication.m411getInst().getSkinType();
            as.j(this.rootView, n.d.cp_bg_line_d);
            as.j(this.cUE, n.d.cp_bg_line_c);
            as.b(this.aOS, n.d.cp_cont_f, 1);
            this.cUG.notifyDataSetChanged();
        }
    }
}
