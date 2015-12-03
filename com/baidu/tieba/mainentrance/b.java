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
    private BaseActivity<?> aXA;
    private View.OnClickListener ccv;
    private List<c> ckN;

    public b(BaseActivity<?> baseActivity) {
        this.aXA = baseActivity;
    }

    public void bh(List<c> list) {
        this.ckN = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ckN == null) {
            return 0;
        }
        if (this.ckN.size() >= 8) {
            return 4;
        }
        return this.ckN.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ji */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.y.b(this.ckN, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.aXA.getPageContext().getPageActivity()).inflate(n.g.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(n.f.recommand_forum_item_left));
            arrayList.add(view.findViewById(n.f.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0074b c0074b = new C0074b(this, null);
                c0074b.cjM = (BarImageView) view2.findViewById(n.f.forum_avatar);
                c0074b.cjM.setGifIconSupport(false);
                c0074b.aLY = (TextView) view2.findViewById(n.f.name);
                c0074b.cjN = (TextView) view2.findViewById(n.f.member_count);
                view2.setOnClickListener(this.ccv);
                c0074b.ckQ = view2;
                aVar.ckO.add(c0074b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.ckO.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.y.b(this.ckN, (i * 2) + i3);
                C0074b c0074b2 = (C0074b) com.baidu.tbadk.core.util.y.b(aVar.ckO, i3);
                if (cVar == null || c0074b2 == null) {
                    break;
                }
                String aeX = cVar.aeX();
                c0074b2.cjM.setTag(aeX);
                c0074b2.cjM.d(aeX, 10, false);
                c0074b2.aLY.setText(cVar.getForumName());
                c0074b2.cjN.setText(String.valueOf(this.aXA.getPageContext().getString(n.i.forum_list_attention_tv)) + ba(cVar.aeY() > 0 ? cVar.aeY() : 0L));
                c0074b2.ckQ.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.aXA.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.aXA.getLayoutMode().k(view);
            }
        }
        return view;
    }

    public String ba(long j) {
        if (j >= 100000) {
            return ax.z(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0074b {
        TextView aLY;
        BarImageView cjM;
        TextView cjN;
        View ckQ;

        private C0074b() {
        }

        /* synthetic */ C0074b(b bVar, C0074b c0074b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0074b> ckO;

        private a() {
            this.ckO = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.ccv = onClickListener;
    }
}
