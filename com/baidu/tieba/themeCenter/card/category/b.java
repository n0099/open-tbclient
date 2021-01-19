package com.baidu.tieba.themeCenter.card.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private int iWk;
    private List<Object> nwG;
    private int nyk;
    private PersonalCardItemView.a nyl;

    /* loaded from: classes8.dex */
    public static class a {
        public PersonalCardItemView nym;
        public PersonalCardItemView nyn;
        public PersonalCardItemView nyo;
        public View nyp;
    }

    /* renamed from: com.baidu.tieba.themeCenter.card.category.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0879b {
        public TextView eFr;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.nyk = 0;
        this.iWk = 0;
        this.eSJ = tbPageContext;
        this.nyk = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.iWk = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nwG != null) {
            return this.nwG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nwG == null || this.nwG.size() <= 0 || i < 0 || i >= this.nwG.size()) {
            return null;
        }
        return this.nwG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (!(getItem(i) instanceof List)) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        C0879b c0879b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C0879b)) {
                c0879b = (C0879b) view.getTag();
            } else {
                C0879b c0879b2 = new C0879b();
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0879b2.eFr = (TextView) view.findViewById(R.id.group_name);
                c0879b2.eFr.setPadding(0, this.nyk, 0, this.iWk);
                view.setTag(c0879b2);
                c0879b = c0879b2;
            }
            if (item != null) {
                c0879b.eFr.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                aVar = new a();
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar.nym = (PersonalCardItemView) view.findViewById(R.id.card1);
                aVar.nyn = (PersonalCardItemView) view.findViewById(R.id.card2);
                aVar.nyo = (PersonalCardItemView) view.findViewById(R.id.card3);
                aVar.nyp = view.findViewById(R.id.divider_line);
                aVar.nym.setCardViewController(this.nyl);
                aVar.nyn.setCardViewController(this.nyl);
                aVar.nyo.setCardViewController(this.nyl);
                view.setTag(aVar);
            }
            if (item != null) {
                List list = (List) item;
                switch (list.size()) {
                    case 1:
                        aVar.nym.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nym.setVisibility(0);
                        aVar.nyn.setVisibility(8);
                        aVar.nyo.setVisibility(8);
                        break;
                    case 2:
                        aVar.nym.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nyn.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nym.setVisibility(0);
                        aVar.nyn.setVisibility(0);
                        aVar.nyo.setVisibility(8);
                        break;
                    case 3:
                        aVar.nym.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nyn.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nyo.b((com.baidu.tieba.themeCenter.a) list.get(2));
                        aVar.nym.setVisibility(0);
                        aVar.nyn.setVisibility(0);
                        aVar.nyo.setVisibility(0);
                        break;
                    default:
                        view.setVisibility(8);
                        break;
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.nyp.setVisibility(8);
                } else {
                    aVar.nyp.setVisibility(0);
                }
            }
        }
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nwG = list;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nyl = aVar;
    }
}
