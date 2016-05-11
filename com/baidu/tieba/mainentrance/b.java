package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> bek;
    private View.OnClickListener bxd;
    private List<c> cLr;

    public b(BaseActivity<?> baseActivity) {
        this.bek = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cLr == null) {
            return 0;
        }
        if (this.cLr.size() >= 8) {
            return 4;
        }
        return this.cLr.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kx */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.y.c(this.cLr, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bek.getPageContext().getPageActivity()).inflate(t.h.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(t.g.recommand_forum_item_left));
            arrayList.add(view.findViewById(t.g.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0064b c0064b = new C0064b(this, null);
                c0064b.cEQ = (BarImageView) view2.findViewById(t.g.forum_avatar);
                c0064b.cEQ.setGifIconSupport(false);
                c0064b.aZB = (TextView) view2.findViewById(t.g.name);
                c0064b.cER = (TextView) view2.findViewById(t.g.member_count);
                view2.setOnClickListener(this.bxd);
                c0064b.cLu = view2;
                aVar.cLs.add(c0064b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.cLs.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.y.c(this.cLr, (i * 2) + i3);
                C0064b c0064b2 = (C0064b) com.baidu.tbadk.core.util.y.c(aVar.cLs, i3);
                if (cVar == null || c0064b2 == null) {
                    break;
                }
                String aov = cVar.aov();
                c0064b2.cEQ.setTag(aov);
                c0064b2.cEQ.c(aov, 10, false);
                c0064b2.aZB.setText(cVar.getForumName());
                c0064b2.cER.setText(String.valueOf(this.bek.getPageContext().getString(t.j.forum_list_attention_tv)) + bp(cVar.aow() > 0 ? cVar.aow() : 0L));
                c0064b2.cLu.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.bek.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
                this.bek.getLayoutMode().x(view);
            }
        }
        return view;
    }

    public String bp(long j) {
        if (j >= 100000) {
            return ay.F(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064b {
        TextView aZB;
        BarImageView cEQ;
        TextView cER;
        View cLu;

        private C0064b() {
        }

        /* synthetic */ C0064b(b bVar, C0064b c0064b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0064b> cLs;

        private a() {
            this.cLs = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.bxd = onClickListener;
    }
}
