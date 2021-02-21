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
    private List<List<DressItemData>> nGQ;
    d nGR;

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.eUY = tbPageContext;
        this.nGR = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGQ != null) {
            return this.nGQ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xW */
    public List<DressItemData> getItem(int i) {
        if (this.nGQ == null || this.nGQ.size() <= 0 || i < 0 || i >= this.nGQ.size()) {
            return null;
        }
        return this.nGQ.get(i);
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
            aVar.nGT = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.nGU = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.nGV = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.nGT.d(item.get(0));
            aVar.nGT.setController(this.nGR);
            if (item.size() > 2) {
                aVar.nGU.d(item.get(1));
                aVar.nGV.d(item.get(2));
                aVar.nGU.setController(this.nGR);
                aVar.nGV.setController(this.nGR);
            } else if (item.size() > 1) {
                aVar.nGU.d(item.get(1));
                aVar.nGU.setController(this.nGR);
                aVar.nGV.hide();
            } else {
                aVar.nGU.hide();
                aVar.nGV.hide();
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes9.dex */
    public class a {
        public View mEmptyView;
        public BackgroundItemView nGT;
        public BackgroundItemView nGU;
        public BackgroundItemView nGV;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.nGQ = list;
    }
}
