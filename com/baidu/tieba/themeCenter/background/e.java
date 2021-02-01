package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private TbPageContext<?> eUY;
    private List<List<DressItemData>> nGq;
    d nGr;

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.eUY = tbPageContext;
        this.nGr = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGq != null) {
            return this.nGq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xW */
    public List<DressItemData> getItem(int i) {
        if (this.nGq == null || this.nGq.size() <= 0 || i < 0 || i >= this.nGq.size()) {
            return null;
        }
        return this.nGq.get(i);
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
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(R.id.top_white_line);
            aVar.nGt = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.nGu = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.nGv = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.nGt.d(item.get(0));
            aVar.nGt.setController(this.nGr);
            if (item.size() > 2) {
                aVar.nGu.d(item.get(1));
                aVar.nGv.d(item.get(2));
                aVar.nGu.setController(this.nGr);
                aVar.nGv.setController(this.nGr);
            } else if (item.size() > 1) {
                aVar.nGu.d(item.get(1));
                aVar.nGu.setController(this.nGr);
                aVar.nGv.hide();
            } else {
                aVar.nGu.hide();
                aVar.nGv.hide();
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes9.dex */
    public class a {
        public View mEmptyView;
        public BackgroundItemView nGt;
        public BackgroundItemView nGu;
        public BackgroundItemView nGv;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.nGq = list;
    }
}
