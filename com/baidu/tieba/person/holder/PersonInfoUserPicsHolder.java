package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.j0.f2.d;
import d.a.j0.f2.h.e;
import d.a.j0.f2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f20432a;

    /* renamed from: b  reason: collision with root package name */
    public View f20433b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20434c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f20435d;

    /* renamed from: e  reason: collision with root package name */
    public e f20436e;

    /* renamed from: f  reason: collision with root package name */
    public int f20437f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f20438g;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.f20437f = 3;
        this.f20432a = view;
        this.f20438g = tbPageContext;
        this.f20433b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f20434c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f20435d = hTypeListView;
        this.f20436e = new e(this.f20438g, hTypeListView);
    }

    public void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.f20436e.c(d(fVar.c()));
    }

    public void c() {
        if (this.f20437f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f20437f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f20432a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f20433b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f20434c, R.color.CAM_X0109, 1);
            this.f20436e.b();
        }
    }

    public final List<n> d(List<n> list) {
        if (ListUtils.getCount(list) <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        d dVar = new d(l.g(this.f20438g.getPageActivity(), R.dimen.ds32), l.g(this.f20438g.getPageActivity(), R.dimen.ds120));
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
