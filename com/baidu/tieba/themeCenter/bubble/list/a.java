package com.baidu.tieba.themeCenter.bubble.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private List<List<DressItemData>> nwG;
    com.baidu.tieba.themeCenter.bubble.all.a nxK;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0878a {
        public View mEmptyView;
        public BubbleItemView nxS;
        public BubbleItemView nxT;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eSJ = tbPageContext;
        this.nxK = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nwG != null) {
            return this.nwG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xM */
    public List<DressItemData> getItem(int i) {
        if (this.nwG == null || this.nwG.size() <= 0 || i < 0 || i >= this.nwG.size()) {
            return null;
        }
        return this.nwG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0878a c0878a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c0878a = (C0878a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0878a = new C0878a();
            c0878a.mEmptyView = view.findViewById(R.id.top_white_line);
            c0878a.nxS = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0878a.nxT = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c0878a);
        }
        if (item != null) {
            if (i == 0) {
                c0878a.mEmptyView.setVisibility(0);
            } else {
                c0878a.mEmptyView.setVisibility(8);
            }
            c0878a.nxS.d(item.get(0));
            c0878a.nxS.setController(this.nxK);
            c0878a.nxS.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c0878a.nxT.d(item.get(1));
                c0878a.nxT.setController(this.nxK);
                c0878a.nxT.setFromBubbleGroup(false);
            } else {
                c0878a.nxT.hide();
            }
        }
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.nwG = list;
    }
}
