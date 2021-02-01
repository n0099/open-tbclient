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
    private TbPageContext<?> eUY;
    private int jbR;
    private List<Object> nGq;
    private int nHU;
    private PersonalCardItemView.a nHV;

    /* loaded from: classes9.dex */
    public static class a {
        public PersonalCardItemView nHW;
        public PersonalCardItemView nHX;
        public PersonalCardItemView nHY;
        public View nHZ;
    }

    /* renamed from: com.baidu.tieba.themeCenter.card.category.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0882b {
        public TextView eHx;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.nHU = 0;
        this.jbR = 0;
        this.eUY = tbPageContext;
        this.nHU = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.jbR = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGq != null) {
            return this.nGq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nGq == null || this.nGq.size() <= 0 || i < 0 || i >= this.nGq.size()) {
            return null;
        }
        return this.nGq.get(i);
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
        C0882b c0882b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C0882b)) {
                c0882b = (C0882b) view.getTag();
            } else {
                C0882b c0882b2 = new C0882b();
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0882b2.eHx = (TextView) view.findViewById(R.id.group_name);
                c0882b2.eHx.setPadding(0, this.nHU, 0, this.jbR);
                view.setTag(c0882b2);
                c0882b = c0882b2;
            }
            if (item != null) {
                c0882b.eHx.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                aVar = new a();
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar.nHW = (PersonalCardItemView) view.findViewById(R.id.card1);
                aVar.nHX = (PersonalCardItemView) view.findViewById(R.id.card2);
                aVar.nHY = (PersonalCardItemView) view.findViewById(R.id.card3);
                aVar.nHZ = view.findViewById(R.id.divider_line);
                aVar.nHW.setCardViewController(this.nHV);
                aVar.nHX.setCardViewController(this.nHV);
                aVar.nHY.setCardViewController(this.nHV);
                view.setTag(aVar);
            }
            if (item != null) {
                List list = (List) item;
                switch (list.size()) {
                    case 1:
                        aVar.nHW.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nHW.setVisibility(0);
                        aVar.nHX.setVisibility(8);
                        aVar.nHY.setVisibility(8);
                        break;
                    case 2:
                        aVar.nHW.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nHX.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nHW.setVisibility(0);
                        aVar.nHX.setVisibility(0);
                        aVar.nHY.setVisibility(8);
                        break;
                    case 3:
                        aVar.nHW.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nHX.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nHY.b((com.baidu.tieba.themeCenter.a) list.get(2));
                        aVar.nHW.setVisibility(0);
                        aVar.nHX.setVisibility(0);
                        aVar.nHY.setVisibility(0);
                        break;
                    default:
                        view.setVisibility(8);
                        break;
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.nHZ.setVisibility(8);
                } else {
                    aVar.nHZ.setVisibility(0);
                }
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nGq = list;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nHV = aVar;
    }
}
