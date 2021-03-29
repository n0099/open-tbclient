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
import d.b.b.e.p.j;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.h0.t.i;
import d.b.i0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class LatelyView extends FrameLayout implements d<String> {

    /* renamed from: e  reason: collision with root package name */
    public int f18524e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f18525f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f18526g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f18527h;
    public g i;
    public h j;

    /* loaded from: classes3.dex */
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

    @Override // d.b.i0.d
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f18524e) {
            return;
        }
        this.f18524e = skinType;
        g gVar = this.i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f18526g.notifyDataSetChanged();
    }

    @Override // d.b.i0.d
    public void b(String str) {
    }

    public void d() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
        this.f18525f.setVisibility(0);
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.f18525f = (RecyclerView) findViewById(R.id.select_forum_list);
        SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
        this.f18526g = selectForumItemAdapter;
        selectForumItemAdapter.h(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f18527h = linearLayoutManager;
        this.f18525f.setLayoutManager(linearLayoutManager);
        this.f18525f.setAdapter(this.f18526g);
    }

    public boolean f() {
        h hVar = this.j;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.d
    /* renamed from: g */
    public void c(String str) {
        RecentlyVisitedForumData j = d.b.i0.i0.g.a.l().j();
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
                i iVar = new i();
                iVar.f51471a = next.getForumId();
                iVar.f51472b = next.u();
                iVar.f51473c = next.getForumName();
                iVar.f51474d = next.getLevel();
                iVar.f51475e = next.D();
                iVar.f51476f = next.C();
                iVar.f51477g = next.s();
                iVar.f51478h = next.y();
                iVar.i = next.w();
                if (iVar.f51475e) {
                    arrayList2.add(iVar);
                } else {
                    arrayList.add(iVar);
                }
                iVar.j = next.isForumBusinessAccount;
            }
        }
        arrayList2.addAll(arrayList);
        this.f18526g.g(arrayList2);
        this.f18526g.notifyDataSetChanged();
    }

    @Override // d.b.i0.d
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
        this.f18525f.setVisibility(8);
    }

    @Override // d.b.i0.d
    public void onDestroy() {
    }

    public LatelyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LatelyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18524e = 3;
        e();
    }
}
