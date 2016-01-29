package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> bdK;
    private View.OnClickListener ckV;
    private List<c> cvA;

    public b(BaseActivity<?> baseActivity) {
        this.bdK = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cvA == null) {
            return 0;
        }
        if (this.cvA.size() >= 8) {
            return 4;
        }
        return this.cvA.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kg */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.x.b(this.cvA, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bdK.getPageContext().getPageActivity()).inflate(t.h.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(t.g.recommand_forum_item_left));
            arrayList.add(view.findViewById(t.g.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0070b c0070b = new C0070b(this, null);
                c0070b.cuz = (BarImageView) view2.findViewById(t.g.forum_avatar);
                c0070b.cuz.setGifIconSupport(false);
                c0070b.aPa = (TextView) view2.findViewById(t.g.name);
                c0070b.cuA = (TextView) view2.findViewById(t.g.member_count);
                view2.setOnClickListener(this.ckV);
                c0070b.cvD = view2;
                aVar.cvB.add(c0070b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.cvB.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.x.b(this.cvA, (i * 2) + i3);
                C0070b c0070b2 = (C0070b) com.baidu.tbadk.core.util.x.b(aVar.cvB, i3);
                if (cVar == null || c0070b2 == null) {
                    break;
                }
                String aki = cVar.aki();
                c0070b2.cuz.setTag(aki);
                c0070b2.cuz.d(aki, 10, false);
                c0070b2.aPa.setText(cVar.getForumName());
                c0070b2.cuA.setText(String.valueOf(this.bdK.getPageContext().getString(t.j.forum_list_attention_tv)) + bh(cVar.akj() > 0 ? cVar.akj() : 0L));
                c0070b2.cvD.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.bdK.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.bdK.getLayoutMode().x(view);
            }
        }
        return view;
    }

    public String bh(long j) {
        if (j >= 100000) {
            return aw.C(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070b {
        TextView aPa;
        TextView cuA;
        BarImageView cuz;
        View cvD;

        private C0070b() {
        }

        /* synthetic */ C0070b(b bVar, C0070b c0070b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0070b> cvB;

        private a() {
            this.cvB = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.ckV = onClickListener;
    }
}
