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
    private ArrayList<String> dGK;
    private int height;
    private TbPageContext<?> mContext;
    private int width;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.width = k.d(tbPageContext.getPageActivity(), n.d.ds396);
        this.height = k.d(tbPageContext.getPageActivity(), n.d.ds704);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dGK != null) {
            return this.dGK.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dGK == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.dGK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.skin_detail_item, (ViewGroup) null);
            a aVar2 = new a(null);
            aVar2.MW = (TbImageView) view.findViewById(n.f.skin_detail_thumb_item_thumb_iv);
            aVar2.MW.setDefaultBgResource(n.c.cp_bg_line_e);
            aVar2.MX = view.findViewById(n.f.skin_detail_thumb_item_left_empty_view);
            aVar2.MY = view.findViewById(n.f.skin_detail_thumb_item_right_empty_view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.MX.setVisibility(i == 0 ? 0 : 8);
        aVar.MY.setVisibility(i == getCount() + (-1) ? 0 : 8);
        aVar.MW.a(this.dGK.get(i), 10, this.width, this.height, false);
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TbImageView MW;
        View MX;
        View MY;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public ArrayList<String> aFA() {
        return this.dGK;
    }

    public void ao(ArrayList<String> arrayList) {
        this.dGK = arrayList;
    }
}
