package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    private TbPageContext<?> eWx;
    private List<List<DressItemData>> nIW;
    d nIX;

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.eWx = tbPageContext;
        this.nIX = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nIW != null) {
            return this.nIW.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xX */
    public List<DressItemData> getItem(int i) {
        if (this.nIW == null || this.nIW.size() <= 0 || i < 0 || i >= this.nIW.size()) {
            return null;
        }
        return this.nIW.get(i);
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
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(R.id.top_white_line);
            aVar.nIZ = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.nJa = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.nJb = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.nIZ.d(item.get(0));
            aVar.nIZ.setController(this.nIX);
            if (item.size() > 2) {
                aVar.nJa.d(item.get(1));
                aVar.nJb.d(item.get(2));
                aVar.nJa.setController(this.nIX);
                aVar.nJb.setController(this.nIX);
            } else if (item.size() > 1) {
                aVar.nJa.d(item.get(1));
                aVar.nJa.setController(this.nIX);
                aVar.nJb.hide();
            } else {
                aVar.nJa.hide();
                aVar.nJb.hide();
            }
        }
        this.eWx.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes8.dex */
    public class a {
        public View mEmptyView;
        public BackgroundItemView nIZ;
        public BackgroundItemView nJa;
        public BackgroundItemView nJb;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.nIW = list;
    }
}
