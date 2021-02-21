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
    private int jcf;
    private List<Object> nGQ;
    private int nIu;
    private PersonalCardItemView.a nIv;

    /* loaded from: classes9.dex */
    public static class a {
        public PersonalCardItemView nIw;
        public PersonalCardItemView nIx;
        public PersonalCardItemView nIy;
        public View nIz;
    }

    /* renamed from: com.baidu.tieba.themeCenter.card.category.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0884b {
        public TextView eHx;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.nIu = 0;
        this.jcf = 0;
        this.eUY = tbPageContext;
        this.nIu = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28);
        this.jcf = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds20);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGQ != null) {
            return this.nGQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nGQ == null || this.nGQ.size() <= 0 || i < 0 || i >= this.nGQ.size()) {
            return null;
        }
        return this.nGQ.get(i);
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
        C0884b c0884b;
        int itemViewType = getItemViewType(i);
        Object item = getItem(i);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof C0884b)) {
                c0884b = (C0884b) view.getTag();
            } else {
                C0884b c0884b2 = new C0884b();
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c0884b2.eHx = (TextView) view.findViewById(R.id.group_name);
                c0884b2.eHx.setPadding(0, this.nIu, 0, this.jcf);
                view.setTag(c0884b2);
                c0884b = c0884b2;
            }
            if (item != null) {
                c0884b.eHx.setText(item.toString());
            }
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                aVar = new a();
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.category_card_list_item, viewGroup, false);
                aVar.nIw = (PersonalCardItemView) view.findViewById(R.id.card1);
                aVar.nIx = (PersonalCardItemView) view.findViewById(R.id.card2);
                aVar.nIy = (PersonalCardItemView) view.findViewById(R.id.card3);
                aVar.nIz = view.findViewById(R.id.divider_line);
                aVar.nIw.setCardViewController(this.nIv);
                aVar.nIx.setCardViewController(this.nIv);
                aVar.nIy.setCardViewController(this.nIv);
                view.setTag(aVar);
            }
            if (item != null) {
                List list = (List) item;
                switch (list.size()) {
                    case 1:
                        aVar.nIw.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nIw.setVisibility(0);
                        aVar.nIx.setVisibility(8);
                        aVar.nIy.setVisibility(8);
                        break;
                    case 2:
                        aVar.nIw.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nIx.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nIw.setVisibility(0);
                        aVar.nIx.setVisibility(0);
                        aVar.nIy.setVisibility(8);
                        break;
                    case 3:
                        aVar.nIw.b((com.baidu.tieba.themeCenter.a) list.get(0));
                        aVar.nIx.b((com.baidu.tieba.themeCenter.a) list.get(1));
                        aVar.nIy.b((com.baidu.tieba.themeCenter.a) list.get(2));
                        aVar.nIw.setVisibility(0);
                        aVar.nIx.setVisibility(0);
                        aVar.nIy.setVisibility(0);
                        break;
                    default:
                        view.setVisibility(8);
                        break;
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.nIz.setVisibility(8);
                } else {
                    aVar.nIz.setVisibility(0);
                }
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nGQ = list;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nIv = aVar;
    }
}
