package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.person.a.d;
import com.baidu.tieba.person.a.e;
import com.baidu.tieba.person.h;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends z.a {
    public TextView Qs;
    public TbPageContext ajP;
    public int aoa;
    public View bJH;
    public HTypeListView eQQ;
    public d eQR;
    public View rootView;

    public c(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoa = 3;
        this.rootView = view;
        this.ajP = tbPageContext;
        this.bJH = view.findViewById(w.h.divider_view_under_photo_album);
        this.Qs = (TextView) view.findViewById(w.h.text_view_photo_album);
        this.eQQ = (HTypeListView) view.findViewById(w.h.listview_photo_album);
        this.eQR = new d(this.ajP, this.eQQ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eQR.setDatas(cp(eVar.getPhotoAlbum()));
        }
    }

    private List<v> cp(List<v> list) {
        if (com.baidu.tbadk.core.util.z.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            h hVar = new h(k.g(this.ajP.getPageActivity(), w.f.ds32), k.g(this.ajP.getPageActivity(), w.f.ds120));
            com.baidu.tbadk.core.util.z.a(arrayList, 0, hVar);
            com.baidu.tbadk.core.util.z.b(arrayList, hVar);
            return arrayList;
        }
        return list;
    }

    public void aTY() {
        if (this.aoa != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aoa = TbadkCoreApplication.m9getInst().getSkinType();
            as.k(this.rootView, w.e.cp_bg_line_d);
            as.k(this.bJH, w.e.cp_bg_line_c);
            as.c(this.Qs, w.e.cp_cont_d, 1);
            this.eQR.notifyDataSetChanged();
        }
    }
}
