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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.f2.d;
import d.b.i0.f2.h.e;
import d.b.i0.f2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19920a;

    /* renamed from: b  reason: collision with root package name */
    public View f19921b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19922c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f19923d;

    /* renamed from: e  reason: collision with root package name */
    public e f19924e;

    /* renamed from: f  reason: collision with root package name */
    public int f19925f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19926g;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.f19925f = 3;
        this.f19920a = view;
        this.f19926g = tbPageContext;
        this.f19921b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f19922c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f19923d = hTypeListView;
        this.f19924e = new e(this.f19926g, hTypeListView);
    }

    public void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.f19924e.c(d(fVar.a()));
    }

    public void c() {
        if (this.f19925f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f19925f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f19920a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19921b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f19922c, R.color.CAM_X0109, 1);
            this.f19924e.b();
        }
    }

    public final List<n> d(List<n> list) {
        if (ListUtils.getCount(list) <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        d dVar = new d(l.g(this.f19926g.getPageActivity(), R.dimen.ds32), l.g(this.f19926g.getPageActivity(), R.dimen.ds120));
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
