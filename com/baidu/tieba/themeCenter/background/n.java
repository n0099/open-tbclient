package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private List<List<DressItemData>> deZ;
    i dfa;
    private TbPageContext<?> mContext;

    public n(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dfa = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.deZ != null) {
            return this.deZ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lx */
    public List<DressItemData> getItem(int i) {
        if (this.deZ == null || this.deZ.size() <= 0 || i < 0 || i >= this.deZ.size()) {
            return null;
        }
        return this.deZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(i.f.top_white_line);
            aVar.dfc = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.dfd = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.dfe = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.dfc.setListenerTag(this.mContext.getUniqueId());
            aVar.dfd.setListenerTag(this.mContext.getUniqueId());
            aVar.dfe.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dfc.b(item.get(0));
            aVar.dfc.setController(this.dfa);
            if (item.size() > 2) {
                aVar.dfd.b(item.get(1));
                aVar.dfe.b(item.get(2));
                aVar.dfd.setController(this.dfa);
                aVar.dfe.setController(this.dfa);
            } else if (item.size() > 1) {
                aVar.dfd.b(item.get(1));
                aVar.dfd.setController(this.dfa);
                aVar.dfe.hide();
            } else {
                aVar.dfd.hide();
                aVar.dfe.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public BackgroundItemView dfc;
        public BackgroundItemView dfd;
        public BackgroundItemView dfe;
        public View mEmptyView;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.deZ = list;
    }
}
