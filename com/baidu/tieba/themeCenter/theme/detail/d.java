package com.baidu.tieba.themeCenter.theme.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private ArrayList<String> dOl;
    private int height;
    private TbPageContext<?> mContext;
    private int width;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.width = k.d(tbPageContext.getPageActivity(), n.e.ds396);
        this.height = k.d(tbPageContext.getPageActivity(), n.e.ds704);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dOl != null) {
            return this.dOl.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dOl == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.dOl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.skin_detail_item, (ViewGroup) null);
            a aVar2 = new a(null);
            aVar2.Nm = (TbImageView) view.findViewById(n.g.skin_detail_thumb_item_thumb_iv);
            aVar2.Nm.setDefaultBgResource(n.d.cp_bg_line_e);
            aVar2.Nn = view.findViewById(n.g.skin_detail_thumb_item_left_empty_view);
            aVar2.No = view.findViewById(n.g.skin_detail_thumb_item_right_empty_view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Nn.setVisibility(i == 0 ? 0 : 8);
        aVar.No.setVisibility(i == getCount() + (-1) ? 0 : 8);
        aVar.Nm.a(this.dOl.get(i), 10, this.width, this.height, false);
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TbImageView Nm;
        View Nn;
        View No;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public ArrayList<String> aHP() {
        return this.dOl;
    }

    public void ao(ArrayList<String> arrayList) {
        this.dOl = arrayList;
    }
}
