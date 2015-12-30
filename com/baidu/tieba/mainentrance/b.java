package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> bbA;
    private View.OnClickListener cgv;
    private List<c> coR;

    public b(BaseActivity<?> baseActivity) {
        this.bbA = baseActivity;
    }

    public void be(List<c> list) {
        this.coR = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.coR == null) {
            return 0;
        }
        if (this.coR.size() >= 8) {
            return 4;
        }
        return this.coR.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jG */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.y.b(this.coR, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bbA.getPageContext().getPageActivity()).inflate(n.h.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(n.g.recommand_forum_item_left));
            arrayList.add(view.findViewById(n.g.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0068b c0068b = new C0068b(this, null);
                c0068b.cnQ = (BarImageView) view2.findViewById(n.g.forum_avatar);
                c0068b.cnQ.setGifIconSupport(false);
                c0068b.aNz = (TextView) view2.findViewById(n.g.name);
                c0068b.cnR = (TextView) view2.findViewById(n.g.member_count);
                view2.setOnClickListener(this.cgv);
                c0068b.coU = view2;
                aVar.coS.add(c0068b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.coS.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.y.b(this.coR, (i * 2) + i3);
                C0068b c0068b2 = (C0068b) com.baidu.tbadk.core.util.y.b(aVar.coS, i3);
                if (cVar == null || c0068b2 == null) {
                    break;
                }
                String agg = cVar.agg();
                c0068b2.cnQ.setTag(agg);
                c0068b2.cnQ.d(agg, 10, false);
                c0068b2.aNz.setText(cVar.getForumName());
                c0068b2.cnR.setText(String.valueOf(this.bbA.getPageContext().getString(n.j.forum_list_attention_tv)) + bf(cVar.agh() > 0 ? cVar.agh() : 0L));
                c0068b2.coU.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.bbA.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.bbA.getLayoutMode().k(view);
            }
        }
        return view;
    }

    public String bf(long j) {
        if (j >= 100000) {
            return ax.A(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068b {
        TextView aNz;
        BarImageView cnQ;
        TextView cnR;
        View coU;

        private C0068b() {
        }

        /* synthetic */ C0068b(b bVar, C0068b c0068b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0068b> coS;

        private a() {
            this.coS = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.cgv = onClickListener;
    }
}
