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
    private List<List<DressItemData>> dgF;
    i dgG;
    private TbPageContext<?> mContext;

    public n(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dgG = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dgF != null) {
            return this.dgF.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lL */
    public List<DressItemData> getItem(int i) {
        if (this.dgF == null || this.dgF.size() <= 0 || i < 0 || i >= this.dgF.size()) {
            return null;
        }
        return this.dgF.get(i);
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
            aVar.dgI = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.dgJ = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.dgK = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.dgI.setListenerTag(this.mContext.getUniqueId());
            aVar.dgJ.setListenerTag(this.mContext.getUniqueId());
            aVar.dgK.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dgI.b(item.get(0));
            aVar.dgI.setController(this.dgG);
            if (item.size() > 2) {
                aVar.dgJ.b(item.get(1));
                aVar.dgK.b(item.get(2));
                aVar.dgJ.setController(this.dgG);
                aVar.dgK.setController(this.dgG);
            } else if (item.size() > 1) {
                aVar.dgJ.b(item.get(1));
                aVar.dgJ.setController(this.dgG);
                aVar.dgK.hide();
            } else {
                aVar.dgJ.hide();
                aVar.dgK.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public BackgroundItemView dgI;
        public BackgroundItemView dgJ;
        public BackgroundItemView dgK;
        public View mEmptyView;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.dgF = list;
    }
}
