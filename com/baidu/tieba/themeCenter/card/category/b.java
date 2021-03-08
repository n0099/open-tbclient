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
    private TbPageContext<?> eWx;
    private int jdO;
    private List<Object> nIW;
    private int nKA;
    private PersonalCardItemView.a nKB;

    /* loaded from: classes8.dex */
    public static class a {
        public PersonalCardItemView nKC;
        public PersonalCardItemView nKD;
        public PersonalCardItemView nKE;
        public View nKF;
    }

    /* renamed from: com.baidu.tieba.themeCenter.card.category.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0890b {
        public TextView eIY;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.nKA = 0;
        this.jdO = 0;
        this.eWx = tbPageContext;
        this.nKA = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.jdO = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nIW != null) {
            return this.nIW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nIW == null || this.nIW.size() <= 0 || i < 0 || i >= this.nIW.size()) {
            return null;
        }
        return this.nIW.get(i);
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
        C0890b c0890b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C0890b)) {
                c0890b = (C0890b) view.getTag();
            } else {
                C0890b c0890b2 = new C0890b();
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0890b2.eIY = (TextView) view.findViewById(R.id.group_name);
                c0890b2.eIY.setPadding(0, this.nKA, 0, this.jdO);
                view.setTag(c0890b2);
                c0890b = c0890b2;
            }
            if (item != null) {
                c0890b.eIY.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                aVar = new a();
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar.nKC = (PersonalCardItemView) view.findViewById(R.id.card1);
                aVar.nKD = (PersonalCardItemView) view.findViewById(R.id.card2);
                aVar.nKE = (PersonalCardItemView) view.findViewById(R.id.card3);
                aVar.nKF = view.findViewById(R.id.divider_line);
                aVar.nKC.setCardViewController(this.nKB);
                aVar.nKD.setCardViewController(this.nKB);
                aVar.nKE.setCardViewController(this.nKB);
                view.setTag(aVar);
            }
            if (item != null) {
                List list = (List) item;
                switch (list.size()) {
                    case 1:
                        aVar.nKC.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nKC.setVisibility(0);
                        aVar.nKD.setVisibility(8);
                        aVar.nKE.setVisibility(8);
                        break;
                    case 2:
                        aVar.nKC.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nKD.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nKC.setVisibility(0);
                        aVar.nKD.setVisibility(0);
                        aVar.nKE.setVisibility(8);
                        break;
                    case 3:
                        aVar.nKC.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nKD.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nKE.b((com.baidu.tieba.themeCenter.a) list.get(2));
                        aVar.nKC.setVisibility(0);
                        aVar.nKD.setVisibility(0);
                        aVar.nKE.setVisibility(0);
                        break;
                    default:
                        view.setVisibility(8);
                        break;
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.nKF.setVisibility(8);
                } else {
                    aVar.nKF.setVisibility(0);
                }
            }
        }
        this.eWx.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nIW = list;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nKB = aVar;
    }
}
