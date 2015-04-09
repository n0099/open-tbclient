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
    private SquareSearchActivity byL;
    private List<e> byM;

    public c(SquareSearchActivity squareSearchActivity) {
        this.byL = squareSearchActivity;
    }

    public void setData(List<e> list) {
        if (list == null || list.isEmpty()) {
            this.byM = new ArrayList();
        } else {
            this.byM = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byM == null) {
            return 0;
        }
        return this.byM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gN */
    public e getItem(int i) {
        if (this.byM == null || this.byM.size() == 0 || i < 0 || i > this.byM.size() - 1) {
            return null;
        }
        return this.byM.get(i);
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
            view = com.baidu.adp.lib.g.b.hH().inflate(this.byL.getPageContext().getPageActivity(), com.baidu.tieba.w.search_history_hot_forum_item, null);
            d dVar2 = new d(null);
            dVar2.byN = (BarImageView) view.findViewById(com.baidu.tieba.v.search_history_hot_forum_avatar);
            dVar2.aED = (TextView) view.findViewById(com.baidu.tieba.v.hot_forum_title_tv);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            barImageView = dVar.byN;
            barImageView.c(item.WM(), 10, false);
            if (item.getForumName() != null) {
                textView3 = dVar.aED;
                textView3.setText(this.byL.getPageContext().getPageActivity().getString(com.baidu.tieba.y.official_msg_list_name, new Object[]{item.getForumName()}));
            }
        }
        textView = dVar.aED;
        ba.b(textView, com.baidu.tieba.s.cp_cont_g, 1);
        textView2 = dVar.aED;
        ba.i((View) textView2, com.baidu.tieba.u.hot_forum_textview_bg_shape);
        return view;
    }
}
