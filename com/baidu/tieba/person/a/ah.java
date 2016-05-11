package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.High;
/* loaded from: classes.dex */
public class ah extends BaseAdapter {
    private View.OnClickListener Fn;
    private List<High> aZH;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aFZ;
    }

    public ah(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZH != null) {
            return this.aZH.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mt */
    public High getItem(int i) {
        if (this.aZH == null || i >= this.aZH.size() || i < 0) {
            return null;
        }
        return this.aZH.get(i);
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
                view = LayoutInflater.from(this.mContext).inflate(t.h.user_pic_nomal_item, (ViewGroup) null);
                aVar2.aFZ = (TbImageView) view.findViewById(t.g.photo_image_view);
                aVar2.aFZ.setDefaultErrorResource(t.d.cp_bg_line_e);
                aVar2.aFZ.setDefaultBgResource(t.d.cp_bg_line_e);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.aFZ.c(getItem(i).pic_url, 13, false);
            view.setOnClickListener(this.Fn);
        }
        return view;
    }

    public void setData(List<High> list) {
        this.aZH = list;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.Fn = onClickListener;
    }
}
