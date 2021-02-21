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
    private TbPageContext<?> eUY;
    private List<List<DressItemData>> nGQ;
    com.baidu.tieba.themeCenter.bubble.all.a nHU;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0883a {
        public View mEmptyView;
        public BubbleItemView nIc;
        public BubbleItemView nId;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eUY = tbPageContext;
        this.nHU = aVar;
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
        C0883a c0883a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c0883a = (C0883a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0883a = new C0883a();
            c0883a.mEmptyView = view.findViewById(R.id.top_white_line);
            c0883a.nIc = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0883a.nId = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c0883a);
        }
        if (item != null) {
            if (i == 0) {
                c0883a.mEmptyView.setVisibility(0);
            } else {
                c0883a.mEmptyView.setVisibility(8);
            }
            c0883a.nIc.d(item.get(0));
            c0883a.nIc.setController(this.nHU);
            c0883a.nIc.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c0883a.nId.d(item.get(1));
                c0883a.nId.setController(this.nHU);
                c0883a.nId.setFromBubbleGroup(false);
            } else {
                c0883a.nId.hide();
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.nGQ = list;
    }
}
