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
    private TbPageContext<?> eWx;
    private List<List<DressItemData>> nIW;
    com.baidu.tieba.themeCenter.bubble.all.a nKa;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0889a {
        public View mEmptyView;
        public BubbleItemView nKi;
        public BubbleItemView nKj;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eWx = tbPageContext;
        this.nKa = aVar;
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
        C0889a c0889a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c0889a = (C0889a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0889a = new C0889a();
            c0889a.mEmptyView = view.findViewById(R.id.top_white_line);
            c0889a.nKi = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0889a.nKj = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c0889a);
        }
        if (item != null) {
            if (i == 0) {
                c0889a.mEmptyView.setVisibility(0);
            } else {
                c0889a.mEmptyView.setVisibility(8);
            }
            c0889a.nKi.d(item.get(0));
            c0889a.nKi.setController(this.nKa);
            c0889a.nKi.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c0889a.nKj.d(item.get(1));
                c0889a.nKj.setController(this.nKa);
                c0889a.nKj.setFromBubbleGroup(false);
            } else {
                c0889a.nKj.hide();
            }
        }
        this.eWx.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.nIW = list;
    }
}
