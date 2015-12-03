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
public class l extends BaseAdapter {
    private List<com.baidu.tbadk.data.g> aIF;
    private final int cQf = 0;
    private final int cQg = 1;
    private final int cQh = 10;
    private View.OnClickListener mClickListener;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class a {
        public ImageView cQi;
        public TextView cQj;
        public View rootView;
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbImageView aEB;
        public TextView cQk;
        public View cQl;
    }

    public l(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIF != null) {
            return this.aIF.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kt */
    public com.baidu.tbadk.data.g getItem(int i) {
        if (this.aIF == null || i >= this.aIF.size() || i < 0) {
            return null;
        }
        return this.aIF.get(i);
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
                if (view == null || !(view.getTag(n.f.tag_person_photo_item_viewholder) instanceof a)) {
                    view = LayoutInflater.from(this.mContext).inflate(n.g.user_pic_add_item, (ViewGroup) null);
                    a aVar2 = new a();
                    aVar2.rootView = view.findViewById(n.f.add_pic_root);
                    aVar2.cQi = (ImageView) view.findViewById(n.f.add_image_view);
                    aVar2.cQj = (TextView) view.findViewById(n.f.tip_left_count_view);
                    view.setTag(n.f.tag_person_photo_item_viewholder, aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag(n.f.tag_person_photo_item_viewholder);
                }
                as.c(aVar.cQi, n.e.icon_pic_add);
                if (this.aIF != null && (size = 10 - this.aIF.size()) > 0) {
                    aVar.cQj.setText(String.format(this.mContext.getString(n.i.have_left_some_picture_upload), Integer.valueOf(size)));
                    as.b(aVar.cQj, n.c.cp_cont_c, 1);
                }
                as.i(view, n.e.add_pic_item_bg);
            } else {
                if (view == null || !(view.getTag(n.f.tag_person_photo_item_viewholder) instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(n.g.user_pic_nomal_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.aEB = (TbImageView) view.findViewById(n.f.photo_image_view);
                    bVar2.aEB.setDefaultBgResource(n.c.cp_bg_line_e);
                    bVar2.cQl = view.findViewById(n.f.normal_pic_click_bg);
                    bVar2.cQk = (TextView) view.findViewById(n.f.tip_default_view);
                    view.setTag(n.f.tag_person_photo_item_viewholder, bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag(n.f.tag_person_photo_item_viewholder);
                }
                if (item.Bb()) {
                    String dj = r.dj(item.getSmallUrl());
                    bVar.cQk.setVisibility(0);
                    as.b(bVar.cQk, n.c.cp_cont_i, 1);
                    if (StringUtils.isNull(dj)) {
                        bVar.aEB.setDefaultResource(n.e.pic_mycenter_avatar_def_i);
                    } else {
                        bVar.aEB.d(dj, 25, false);
                    }
                } else {
                    bVar.aEB.setDefaultResource(n.e.img_default_100);
                    bVar.cQk.setVisibility(8);
                    bVar.aEB.d(item.getSmallUrl(), 10, false);
                }
            }
            view.setOnClickListener(this.mClickListener);
            view.setTag(n.f.tag_person_photo_item_position, Integer.valueOf(i));
        }
        return view;
    }

    public void setData(List<com.baidu.tbadk.data.g> list) {
        this.aIF = list;
    }

    public void G(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
