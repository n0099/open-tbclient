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
    private TbPageContext<?> eXu;
    private List<List<DressItemData>> nBk;
    d nBl;

    public e(TbPageContext<?> tbPageContext, d dVar) {
        this.eXu = tbPageContext;
        this.nBl = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nBk != null) {
            return this.nBk.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zs */
    public List<DressItemData> getItem(int i) {
        if (this.nBk == null || this.nBk.size() <= 0 || i < 0 || i >= this.nBk.size()) {
            return null;
        }
        return this.nBk.get(i);
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
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(R.id.top_white_line);
            aVar.nBn = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            aVar.nBo = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            aVar.nBp = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.nBn.d(item.get(0));
            aVar.nBn.setController(this.nBl);
            if (item.size() > 2) {
                aVar.nBo.d(item.get(1));
                aVar.nBp.d(item.get(2));
                aVar.nBo.setController(this.nBl);
                aVar.nBp.setController(this.nBl);
            } else if (item.size() > 1) {
                aVar.nBo.d(item.get(1));
                aVar.nBo.setController(this.nBl);
                aVar.nBp.hide();
            } else {
                aVar.nBo.hide();
                aVar.nBp.hide();
            }
        }
        this.eXu.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes9.dex */
    public class a {
        public View mEmptyView;
        public BackgroundItemView nBn;
        public BackgroundItemView nBo;
        public BackgroundItemView nBp;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.nBk = list;
    }
}
