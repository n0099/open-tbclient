package com.baidu.tieba.lately;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import d.a.c.e.p.j;
import d.a.j0.d0.g;
import d.a.j0.d0.h;
import d.a.k0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class LatelyView extends FrameLayout implements d<String> {

    /* renamed from: e  reason: collision with root package name */
    public int f17874e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f17875f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f17876g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f17877h;

    /* renamed from: i  reason: collision with root package name */
    public g f17878i;
    public h j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                LatelyView.this.c(null);
            }
        }
    }

    public LatelyView(Context context) {
        this(context, null);
    }

    @Override // d.a.k0.d
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17874e) {
            return;
        }
        this.f17874e = skinType;
        g gVar = this.f17878i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f17876g.notifyDataSetChanged();
    }

    @Override // d.a.k0.d
    public void b(String str) {
    }

    public void d() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
        this.f17875f.setVisibility(0);
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.f17875f = (RecyclerView) findViewById(R.id.select_forum_list);
        SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
        this.f17876g = selectForumItemAdapter;
        selectForumItemAdapter.h(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f17877h = linearLayoutManager;
        this.f17875f.setLayoutManager(linearLayoutManager);
        this.f17875f.setAdapter(this.f17876g);
    }

    public boolean f() {
        h hVar = this.j;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.d
    /* renamed from: g */
    public void c(String str) {
        RecentlyVisitedForumData j = d.a.k0.i0.g.a.l().j();
        if (j == null) {
            h(false, false);
            return;
        }
        LinkedList<VisitedForumData> u = j.u();
        if (ListUtils.isEmpty(u)) {
            h(false, false);
            return;
        }
        d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = u.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                d.a.j0.t.j jVar = new d.a.j0.t.j();
                jVar.f50712a = next.getForumId();
                jVar.f50713b = next.u();
                jVar.f50714c = next.getForumName();
                jVar.f50715d = next.getLevel();
                jVar.f50716e = next.D();
                jVar.f50717f = next.C();
                jVar.f50718g = next.s();
                jVar.f50719h = next.y();
                jVar.f50720i = next.w();
                if (jVar.f50716e) {
                    arrayList2.add(jVar);
                } else {
                    arrayList.add(jVar);
                }
                jVar.j = next.isForumBusinessAccount;
            }
        }
        arrayList2.addAll(arrayList);
        this.f17876g.g(arrayList2);
        this.f17876g.notifyDataSetChanged();
    }

    @Override // d.a.k0.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    public void h(boolean z, boolean z2) {
        if (f()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new a());
        }
        this.j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.j.attachView(this, z);
        if (z2) {
            this.j.o();
        } else {
            this.j.h(R.drawable.new_pic_emotion_01);
            this.j.e();
        }
        this.j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f17875f.setVisibility(8);
    }

    @Override // d.a.k0.d
    public void onDestroy() {
    }

    public LatelyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LatelyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17874e = 3;
        e();
    }
}
