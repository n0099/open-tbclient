package com.baidu.tieba.person.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private List<com.baidu.tbadk.data.g> aOe;
    private final int cUH = 0;
    private final int cUI = 1;
    private final int cUJ = 10;
    private View.OnClickListener mClickListener;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public ImageView cUK;
        public TextView cUL;
        public View rootView;
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbImageView aGb;
        public TextView cUM;
        public View cUN;
    }

    public n(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aOe != null) {
            return this.aOe.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kQ */
    public com.baidu.tbadk.data.g getItem(int i) {
        if (this.aOe == null || i >= this.aOe.size() || i < 0) {
            return null;
        }
        return this.aOe.get(i);
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
                if (view == null || !(view.getTag(n.g.tag_person_photo_item_viewholder) instanceof a)) {
                    view = LayoutInflater.from(this.mContext).inflate(n.h.user_pic_add_item, (ViewGroup) null);
                    a aVar2 = new a();
                    aVar2.rootView = view.findViewById(n.g.add_pic_root);
                    aVar2.cUK = (ImageView) view.findViewById(n.g.add_image_view);
                    aVar2.cUL = (TextView) view.findViewById(n.g.tip_left_count_view);
                    view.setTag(n.g.tag_person_photo_item_viewholder, aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag(n.g.tag_person_photo_item_viewholder);
                }
                as.c(aVar.cUK, n.f.icon_pic_add);
                if (this.aOe != null && (size = 10 - this.aOe.size()) > 0) {
                    aVar.cUL.setText(String.format(this.mContext.getString(n.j.have_left_some_picture_upload), Integer.valueOf(size)));
                    as.b(aVar.cUL, n.d.cp_cont_c, 1);
                }
                as.i(view, n.f.add_pic_item_bg);
            } else {
                if (view == null || !(view.getTag(n.g.tag_person_photo_item_viewholder) instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(n.h.user_pic_nomal_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.aGb = (TbImageView) view.findViewById(n.g.photo_image_view);
                    bVar2.aGb.setDefaultBgResource(n.d.cp_bg_line_e);
                    bVar2.cUN = view.findViewById(n.g.normal_pic_click_bg);
                    bVar2.cUM = (TextView) view.findViewById(n.g.tip_default_view);
                    view.setTag(n.g.tag_person_photo_item_viewholder, bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag(n.g.tag_person_photo_item_viewholder);
                }
                if (item.AR()) {
                    String dm = r.dm(item.getSmallUrl());
                    bVar.cUM.setVisibility(0);
                    as.b(bVar.cUM, n.d.cp_cont_i, 1);
                    if (StringUtils.isNull(dm)) {
                        bVar.aGb.setDefaultResource(n.f.pic_mycenter_avatar_def_i);
                    } else {
                        bVar.aGb.d(dm, 25, false);
                    }
                } else {
                    bVar.aGb.setDefaultResource(n.f.img_default_100);
                    bVar.cUM.setVisibility(8);
                    bVar.aGb.d(item.getSmallUrl(), 10, false);
                }
            }
            view.setOnClickListener(this.mClickListener);
            view.setTag(n.g.tag_person_photo_item_position, Integer.valueOf(i));
        }
        return view;
    }

    public void setData(List<com.baidu.tbadk.data.g> list) {
        this.aOe = list;
    }

    public void G(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
