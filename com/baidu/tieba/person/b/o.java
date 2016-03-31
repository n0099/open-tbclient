package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private View.OnClickListener OZ;
    private List<com.baidu.tbadk.data.h> aTc;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public View aAh;
        public ImageView dAE;
        public TextView dAF;
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbImageView aJQ;
        public TextView dAG;
        public View dAH;
    }

    public o(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aTc != null) {
            return this.aTc.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mI */
    public com.baidu.tbadk.data.h getItem(int i) {
        if (this.aTc == null || i >= this.aTc.size() || i < 0) {
            return null;
        }
        return this.aTc.get(i);
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
        com.baidu.tbadk.data.h item = getItem(i);
        if (item != null) {
            if (itemViewType == 1) {
                if (view == null || !(view.getTag(t.g.tag_person_photo_item_viewholder) instanceof a)) {
                    view = LayoutInflater.from(this.mContext).inflate(t.h.user_pic_add_item, (ViewGroup) null);
                    a aVar2 = new a();
                    aVar2.aAh = view.findViewById(t.g.add_pic_root);
                    aVar2.dAE = (ImageView) view.findViewById(t.g.add_image_view);
                    aVar2.dAF = (TextView) view.findViewById(t.g.tip_left_count_view);
                    view.setTag(t.g.tag_person_photo_item_viewholder, aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag(t.g.tag_person_photo_item_viewholder);
                }
                at.c(aVar.dAE, t.f.icon_pic_add);
                if (this.aTc != null && (size = 10 - this.aTc.size()) > 0) {
                    aVar.dAF.setText(String.format(this.mContext.getString(t.j.have_left_some_picture_upload), Integer.valueOf(size)));
                    at.b(aVar.dAF, t.d.cp_cont_c, 1);
                }
                at.k(view, t.f.add_pic_item_bg);
            } else {
                if (view == null || !(view.getTag(t.g.tag_person_photo_item_viewholder) instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(t.h.user_pic_nomal_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.aJQ = (TbImageView) view.findViewById(t.g.photo_image_view);
                    bVar2.aJQ.setDefaultBgResource(t.d.cp_bg_line_e);
                    bVar2.dAH = view.findViewById(t.g.normal_pic_click_bg);
                    bVar2.dAG = (TextView) view.findViewById(t.g.tip_default_view);
                    view.setTag(t.g.tag_person_photo_item_viewholder, bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag(t.g.tag_person_photo_item_viewholder);
                }
                if (item.CM()) {
                    String dm = com.baidu.tbadk.core.util.q.dm(item.getSmallUrl());
                    bVar.dAG.setVisibility(0);
                    at.b(bVar.dAG, t.d.cp_cont_i, 1);
                    if (StringUtils.isNull(dm)) {
                        bVar.aJQ.setDefaultResource(t.f.pic_mycenter_avatar_def_i);
                    } else {
                        bVar.aJQ.c(dm, 25, false);
                    }
                } else {
                    bVar.aJQ.setDefaultResource(t.f.img_default_100);
                    bVar.dAG.setVisibility(8);
                    bVar.aJQ.c(item.getSmallUrl(), 10, false);
                }
            }
            view.setOnClickListener(this.OZ);
            view.setTag(t.g.tag_person_photo_item_position, Integer.valueOf(i));
        }
        return view;
    }

    public void setData(List<com.baidu.tbadk.data.h> list) {
        this.aTc = list;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.OZ = onClickListener;
    }
}
