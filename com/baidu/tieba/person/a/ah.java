package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.High;
/* loaded from: classes.dex */
public class ah extends BaseAdapter {
    private List<High> aJj;
    private View.OnClickListener aew;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aGB;
    }

    public ah(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJj != null) {
            return this.aJj.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nT */
    public High getItem(int i) {
        if (this.aJj == null || i >= this.aJj.size() || i < 0) {
            return null;
        }
        return this.aJj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (getItem(i) != null) {
            if (view == null) {
                a aVar2 = new a();
                view = LayoutInflater.from(this.mContext).inflate(u.h.user_pic_nomal_item, (ViewGroup) null);
                aVar2.aGB = (TbImageView) view.findViewById(u.g.photo_image_view);
                aVar2.aGB.setDefaultErrorResource(u.d.cp_bg_line_e);
                aVar2.aGB.setDefaultBgResource(u.d.cp_bg_line_e);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.aGB.c(getItem(i).pic_url, 13, false);
            view.setOnClickListener(this.aew);
        }
        return view;
    }

    public void setData(List<High> list) {
        this.aJj = list;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.aew = onClickListener;
    }
}
