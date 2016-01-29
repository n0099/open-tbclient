package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private View.OnClickListener OS;
    private List<com.baidu.tbadk.data.g> aQh;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public View azA;
        public ImageView dgf;
        public TextView dgg;
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbImageView aGU;
        public TextView dgh;
        public View dgi;
    }

    public o(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQh != null) {
            return this.aQh.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lz */
    public com.baidu.tbadk.data.g getItem(int i) {
        if (this.aQh == null || i >= this.aQh.size() || i < 0) {
            return null;
        }
        return this.aQh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItem(i) == null || !getItem(i).isAdded()) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a aVar;
        int size;
        int itemViewType = getItemViewType(i);
        com.baidu.tbadk.data.g item = getItem(i);
        if (item != null) {
            if (itemViewType == 1) {
                if (view == null || !(view.getTag(t.g.tag_person_photo_item_viewholder) instanceof a)) {
                    view = LayoutInflater.from(this.mContext).inflate(t.h.user_pic_add_item, (ViewGroup) null);
                    a aVar2 = new a();
                    aVar2.azA = view.findViewById(t.g.add_pic_root);
                    aVar2.dgf = (ImageView) view.findViewById(t.g.add_image_view);
                    aVar2.dgg = (TextView) view.findViewById(t.g.tip_left_count_view);
                    view.setTag(t.g.tag_person_photo_item_viewholder, aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag(t.g.tag_person_photo_item_viewholder);
                }
                ar.c(aVar.dgf, t.f.icon_pic_add);
                if (this.aQh != null && (size = 10 - this.aQh.size()) > 0) {
                    aVar.dgg.setText(String.format(this.mContext.getString(t.j.have_left_some_picture_upload), Integer.valueOf(size)));
                    ar.b(aVar.dgg, t.d.cp_cont_c, 1);
                }
                ar.k(view, t.f.add_pic_item_bg);
            } else {
                if (view == null || !(view.getTag(t.g.tag_person_photo_item_viewholder) instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(t.h.user_pic_nomal_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.aGU = (TbImageView) view.findViewById(t.g.photo_image_view);
                    bVar2.aGU.setDefaultBgResource(t.d.cp_bg_line_e);
                    bVar2.dgi = view.findViewById(t.g.normal_pic_click_bg);
                    bVar2.dgh = (TextView) view.findViewById(t.g.tip_default_view);
                    view.setTag(t.g.tag_person_photo_item_viewholder, bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag(t.g.tag_person_photo_item_viewholder);
                }
                if (item.Ch()) {
                    String dj = com.baidu.tbadk.core.util.q.dj(item.getSmallUrl());
                    bVar.dgh.setVisibility(0);
                    ar.b(bVar.dgh, t.d.cp_cont_i, 1);
                    if (StringUtils.isNull(dj)) {
                        bVar.aGU.setDefaultResource(t.f.pic_mycenter_avatar_def_i);
                    } else {
                        bVar.aGU.d(dj, 25, false);
                    }
                } else {
                    bVar.aGU.setDefaultResource(t.f.img_default_100);
                    bVar.dgh.setVisibility(8);
                    bVar.aGU.d(item.getSmallUrl(), 10, false);
                }
            }
            view.setOnClickListener(this.OS);
            view.setTag(t.g.tag_person_photo_item_position, Integer.valueOf(i));
        }
        return view;
    }

    public void setData(List<com.baidu.tbadk.data.g> list) {
        this.aQh = list;
    }

    public void M(View.OnClickListener onClickListener) {
        this.OS = onClickListener;
    }
}
