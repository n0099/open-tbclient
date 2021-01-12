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
    private TbPageContext<?> eSJ;
    private List<List<DressItemData>> nwF;
    d nwG;

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.eSJ = tbPageContext;
        this.nwG = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nwF != null) {
            return this.nwF.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xM */
    public List<DressItemData> getItem(int i) {
        if (this.nwF == null || this.nwF.size() <= 0 || i < 0 || i >= this.nwF.size()) {
            return null;
        }
        return this.nwF.get(i);
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
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(R.id.top_white_line);
            aVar.nwI = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.nwJ = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.nwK = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.nwI.d(item.get(0));
            aVar.nwI.setController(this.nwG);
            if (item.size() > 2) {
                aVar.nwJ.d(item.get(1));
                aVar.nwK.d(item.get(2));
                aVar.nwJ.setController(this.nwG);
                aVar.nwK.setController(this.nwG);
            } else if (item.size() > 1) {
                aVar.nwJ.d(item.get(1));
                aVar.nwJ.setController(this.nwG);
                aVar.nwK.hide();
            } else {
                aVar.nwJ.hide();
                aVar.nwK.hide();
            }
        }
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes8.dex */
    public class a {
        public View mEmptyView;
        public BackgroundItemView nwI;
        public BackgroundItemView nwJ;
        public BackgroundItemView nwK;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.nwF = list;
    }
}
