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
    private List<List<DressItemData>> nGq;
    com.baidu.tieba.themeCenter.bubble.all.a nHu;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0881a {
        public View mEmptyView;
        public BubbleItemView nHC;
        public BubbleItemView nHD;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eUY = tbPageContext;
        this.nHu = aVar;
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
        C0881a c0881a;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            c0881a = (C0881a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0881a = new C0881a();
            c0881a.mEmptyView = view.findViewById(R.id.top_white_line);
            c0881a.nHC = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0881a.nHD = (BubbleItemView) view.findViewById(R.id.bg_view2);
            view.setTag(c0881a);
        }
        if (item != null) {
            if (i == 0) {
                c0881a.mEmptyView.setVisibility(0);
            } else {
                c0881a.mEmptyView.setVisibility(8);
            }
            c0881a.nHC.d(item.get(0));
            c0881a.nHC.setController(this.nHu);
            c0881a.nHC.setFromBubbleGroup(false);
            if (item.size() > 1) {
                c0881a.nHD.d(item.get(1));
                c0881a.nHD.setController(this.nHu);
                c0881a.nHD.setFromBubbleGroup(false);
            } else {
                c0881a.nHD.hide();
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.nGq = list;
    }
}
