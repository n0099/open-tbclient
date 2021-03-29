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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.e2.d;
import d.b.i0.e2.h.e;
import d.b.i0.e2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f20228a;

    /* renamed from: b  reason: collision with root package name */
    public View f20229b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20230c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f20231d;

    /* renamed from: e  reason: collision with root package name */
    public e f20232e;

    /* renamed from: f  reason: collision with root package name */
    public int f20233f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f20234g;

    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        this.f20233f = 3;
        this.f20228a = view;
        this.f20234g = tbPageContext;
        this.f20229b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f20230c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f20231d = hTypeListView;
        this.f20232e = new e(this.f20234g, hTypeListView);
    }

    public void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.f20232e.c(d(fVar.a()));
    }

    public void c() {
        if (this.f20233f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f20233f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f20228a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f20229b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f20230c, R.color.CAM_X0109, 1);
            this.f20232e.b();
        }
    }

    public final List<n> d(List<n> list) {
        if (ListUtils.getCount(list) <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        d dVar = new d(l.g(this.f20234g.getPageActivity(), R.dimen.ds32), l.g(this.f20234g.getPageActivity(), R.dimen.ds120));
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
