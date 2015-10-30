package com.baidu.tieba.themeCenter.theme.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private ArrayList<String> dgT;
    private int height;
    private TbPageContext<?> mContext;
    private int width;

    public c(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        this.width = k.d(tbPageContext.getPageActivity(), i.d.ds396);
        this.height = k.d(tbPageContext.getPageActivity(), i.d.ds704);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dgT != null) {
            return this.dgT.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dgT == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.dgT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.skin_detail_item, (ViewGroup) null);
            a aVar2 = new a(null);
            aVar2.ME = (TbImageView) view.findViewById(i.f.skin_detail_thumb_item_thumb_iv);
            aVar2.ME.setDefaultBgResource(i.c.cp_bg_line_e);
            aVar2.MF = view.findViewById(i.f.skin_detail_thumb_item_left_empty_view);
            aVar2.MG = view.findViewById(i.f.skin_detail_thumb_item_right_empty_view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.MF.setVisibility(i == 0 ? 0 : 8);
        aVar.MG.setVisibility(i == getCount() + (-1) ? 0 : 8);
        aVar.ME.a(this.dgT.get(i), 10, this.width, this.height, false);
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TbImageView ME;
        View MF;
        View MG;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public ArrayList<String> azz() {
        return this.dgT;
    }

    public void ah(ArrayList<String> arrayList) {
        this.dgT = arrayList;
    }
}
