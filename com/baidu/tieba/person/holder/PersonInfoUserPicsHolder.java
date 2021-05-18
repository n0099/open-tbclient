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
import d.a.k0.f2.d;
import d.a.k0.f2.h.e;
import d.a.k0.f2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19720a;

    /* renamed from: b  reason: collision with root package name */
    public View f19721b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19722c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f19723d;

    /* renamed from: e  reason: collision with root package name */
    public e f19724e;

    /* renamed from: f  reason: collision with root package name */
    public int f19725f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19726g;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.f19725f = 3;
        this.f19720a = view;
        this.f19726g = tbPageContext;
        this.f19721b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f19722c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f19723d = hTypeListView;
        this.f19724e = new e(this.f19726g, hTypeListView);
    }

    public void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.f19724e.c(d(fVar.c()));
    }

    public void c() {
        if (this.f19725f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f19725f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f19720a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19721b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f19722c, R.color.CAM_X0109, 1);
            this.f19724e.b();
        }
    }

    public final List<n> d(List<n> list) {
        if (ListUtils.getCount(list) <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        d dVar = new d(l.g(this.f19726g.getPageActivity(), R.dimen.ds32), l.g(this.f19726g.getPageActivity(), R.dimen.ds120));
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
