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
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eXu;
    private int jaR;
    private List<Object> nBk;
    private int nCO;
    private PersonalCardItemView.a nCP;

    /* loaded from: classes9.dex */
    public static class a {
        public PersonalCardItemView nCQ;
        public PersonalCardItemView nCR;
        public PersonalCardItemView nCS;
        public View nCT;
    }

    /* renamed from: com.baidu.tieba.themeCenter.card.category.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0896b {
        public TextView eKc;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.nCO = 0;
        this.jaR = 0;
        this.eXu = tbPageContext;
        this.nCO = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.jaR = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nBk != null) {
            return this.nBk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nBk == null || this.nBk.size() <= 0 || i < 0 || i >= this.nBk.size()) {
            return null;
        }
        return this.nBk.get(i);
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
        C0896b c0896b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C0896b)) {
                c0896b = (C0896b) view.getTag();
            } else {
                C0896b c0896b2 = new C0896b();
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0896b2.eKc = (TextView) view.findViewById(R.id.group_name);
                c0896b2.eKc.setPadding(0, this.nCO, 0, this.jaR);
                view.setTag(c0896b2);
                c0896b = c0896b2;
            }
            if (item != null) {
                c0896b.eKc.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                aVar = new a();
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar.nCQ = (PersonalCardItemView) view.findViewById(R.id.card1);
                aVar.nCR = (PersonalCardItemView) view.findViewById(R.id.card2);
                aVar.nCS = (PersonalCardItemView) view.findViewById(R.id.card3);
                aVar.nCT = view.findViewById(R.id.divider_line);
                aVar.nCQ.setCardViewController(this.nCP);
                aVar.nCR.setCardViewController(this.nCP);
                aVar.nCS.setCardViewController(this.nCP);
                view.setTag(aVar);
            }
            if (item != null) {
                List list = (List) item;
                switch (list.size()) {
                    case 1:
                        aVar.nCQ.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nCQ.setVisibility(0);
                        aVar.nCR.setVisibility(8);
                        aVar.nCS.setVisibility(8);
                        break;
                    case 2:
                        aVar.nCQ.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nCR.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nCQ.setVisibility(0);
                        aVar.nCR.setVisibility(0);
                        aVar.nCS.setVisibility(8);
                        break;
                    case 3:
                        aVar.nCQ.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nCR.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nCS.b((com.baidu.tieba.themeCenter.a) list.get(2));
                        aVar.nCQ.setVisibility(0);
                        aVar.nCR.setVisibility(0);
                        aVar.nCS.setVisibility(0);
                        break;
                    default:
                        view.setVisibility(8);
                        break;
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.nCT.setVisibility(8);
                } else {
                    aVar.nCT.setVisibility(0);
                }
            }
        }
        this.eXu.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nBk = list;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nCP = aVar;
    }
}
