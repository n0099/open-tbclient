package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> aSm;
    private View.OnClickListener bNr;
    private List<c> bUA;

    public b(BaseActivity<?> baseActivity) {
        this.aSm = baseActivity;
    }

    public void aW(List<c> list) {
        this.bUA = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bUA == null) {
            return 0;
        }
        if (this.bUA.size() >= 8) {
            return 4;
        }
        return this.bUA.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: io */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.u.b(this.bUA, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.aSm.getPageContext().getPageActivity()).inflate(i.g.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(i.f.recommand_forum_item_left));
            arrayList.add(view.findViewById(i.f.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0066b c0066b = new C0066b(this, null);
                c0066b.bTy = (BarImageView) view2.findViewById(i.f.forum_avatar);
                c0066b.bTy.setGifIconSupport(false);
                c0066b.aNK = (TextView) view2.findViewById(i.f.name);
                c0066b.bTz = (TextView) view2.findViewById(i.f.member_count);
                view2.setOnClickListener(this.bNr);
                c0066b.bUD = view2;
                aVar.bUB.add(c0066b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.bUB.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.u.b(this.bUA, (i * 2) + i3);
                C0066b c0066b2 = (C0066b) com.baidu.tbadk.core.util.u.b(aVar.bUB, i3);
                if (cVar == null || c0066b2 == null) {
                    break;
                }
                String abr = cVar.abr();
                c0066b2.bTy.setTag(abr);
                c0066b2.bTy.d(abr, 10, false);
                c0066b2.aNK.setText(cVar.getForumName());
                c0066b2.bTz.setText(String.valueOf(this.aSm.getPageContext().getString(i.h.forum_list_attention_tv)) + aM(cVar.abs() > 0 ? cVar.abs() : 0L));
                c0066b2.bUD.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.aSm.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.aSm.getLayoutMode().k(view);
            }
        }
        return view;
    }

    public String aM(long j) {
        if (j >= 100000) {
            return com.baidu.tbadk.core.util.as.t(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066b {
        TextView aNK;
        BarImageView bTy;
        TextView bTz;
        View bUD;

        private C0066b() {
        }

        /* synthetic */ C0066b(b bVar, C0066b c0066b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0066b> bUB;

        private a() {
            this.bUB = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.bNr = onClickListener;
    }
}
