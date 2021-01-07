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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eXu;
    private List<List<DressItemData>> nBk;
    com.baidu.tieba.themeCenter.bubble.all.a nCo;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0895a {
        public View mEmptyView;
        public BubbleItemView nCw;
        public BubbleItemView nCx;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eXu = tbPageContext;
        this.nCo = aVar;
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
        C0895a c0895a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c0895a = (C0895a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0895a = new C0895a();
            c0895a.mEmptyView = view.findViewById(R.id.top_white_line);
            c0895a.nCw = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0895a.nCx = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c0895a);
        }
        if (item != null) {
            if (i == 0) {
                c0895a.mEmptyView.setVisibility(0);
            } else {
                c0895a.mEmptyView.setVisibility(8);
            }
            c0895a.nCw.d(item.get(0));
            c0895a.nCw.setController(this.nCo);
            c0895a.nCw.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c0895a.nCx.d(item.get(1));
                c0895a.nCx.setController(this.nCo);
                c0895a.nCx.setFromBubbleGroup(false);
            } else {
                c0895a.nCx.hide();
            }
        }
        this.eXu.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.nBk = list;
    }
}
