package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private SquareSearchActivity byv;
    private List<e> byw;

    public c(SquareSearchActivity squareSearchActivity) {
        this.byv = squareSearchActivity;
    }

    public void setData(List<e> list) {
        if (list == null || list.isEmpty()) {
            this.byw = new ArrayList();
        } else {
            this.byw = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byw == null) {
            return 0;
        }
        return this.byw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gL */
    public e getItem(int i) {
        if (this.byw == null || this.byw.size() == 0 || i < 0 || i > this.byw.size() - 1) {
            return null;
        }
        return this.byw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        TextView textView;
        TextView textView2;
        BarImageView barImageView;
        TextView textView3;
        if (view == null || !(view.getTag() instanceof d)) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.byv.getPageContext().getPageActivity(), com.baidu.tieba.w.search_history_hot_forum_item, null);
            d dVar2 = new d(null);
            dVar2.byx = (BarImageView) view.findViewById(com.baidu.tieba.v.search_history_hot_forum_avatar);
            dVar2.aEv = (TextView) view.findViewById(com.baidu.tieba.v.hot_forum_title_tv);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            barImageView = dVar.byx;
            barImageView.c(item.Wz(), 10, false);
            if (item.getForumName() != null) {
                textView3 = dVar.aEv;
                textView3.setText(this.byv.getPageContext().getPageActivity().getString(com.baidu.tieba.y.official_msg_list_name, new Object[]{item.getForumName()}));
            }
        }
        textView = dVar.aEv;
        ba.b(textView, com.baidu.tieba.s.cp_cont_g, 1);
        textView2 = dVar.aEv;
        ba.i((View) textView2, com.baidu.tieba.u.hot_forum_textview_bg_shape);
        return view;
    }
}
