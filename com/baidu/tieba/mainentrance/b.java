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
    private BaseActivity<?> aRT;
    private View.OnClickListener bML;
    private List<c> bTO;

    public b(BaseActivity<?> baseActivity) {
        this.aRT = baseActivity;
    }

    public void aS(List<c> list) {
        this.bTO = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bTO == null) {
            return 0;
        }
        if (this.bTO.size() >= 8) {
            return 4;
        }
        return this.bTO.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ia */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.u.b(this.bTO, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.aRT.getPageContext().getPageActivity()).inflate(i.g.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(i.f.recommand_forum_item_left));
            arrayList.add(view.findViewById(i.f.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0066b c0066b = new C0066b(this, null);
                c0066b.bSS = (BarImageView) view2.findViewById(i.f.forum_avatar);
                c0066b.bSS.setGifIconSupport(false);
                c0066b.aNr = (TextView) view2.findViewById(i.f.name);
                c0066b.bST = (TextView) view2.findViewById(i.f.member_count);
                view2.setOnClickListener(this.bML);
                c0066b.bTR = view2;
                aVar.bTP.add(c0066b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.bTP.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.u.b(this.bTO, (i * 2) + i3);
                C0066b c0066b2 = (C0066b) com.baidu.tbadk.core.util.u.b(aVar.bTP, i3);
                if (cVar == null || c0066b2 == null) {
                    break;
                }
                String aba = cVar.aba();
                c0066b2.bSS.setTag(aba);
                c0066b2.bSS.d(aba, 10, false);
                c0066b2.aNr.setText(cVar.getForumName());
                c0066b2.bST.setText(String.valueOf(this.aRT.getPageContext().getString(i.h.forum_list_attention_tv)) + aE(cVar.abb() > 0 ? cVar.abb() : 0L));
                c0066b2.bTR.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.aRT.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.aRT.getLayoutMode().k(view);
            }
        }
        return view;
    }

    public String aE(long j) {
        if (j >= 100000) {
            return com.baidu.tbadk.core.util.ar.v(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066b {
        TextView aNr;
        BarImageView bSS;
        TextView bST;
        View bTR;

        private C0066b() {
        }

        /* synthetic */ C0066b(b bVar, C0066b c0066b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0066b> bTP;

        private a() {
            this.bTP = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.bML = onClickListener;
    }
}
