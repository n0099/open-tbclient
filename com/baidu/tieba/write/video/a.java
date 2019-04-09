package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> jqv;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0412a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.jqv)) {
            return 0;
        }
        return this.jqv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bo */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.jqv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0412a c0412a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.video_activity_title_item, (ViewGroup) null);
            C0412a c0412a2 = new C0412a();
            c0412a2.title = (TextView) view.findViewById(d.g.title);
            c0412a2.divider = view.findViewById(d.g.divider_line);
            al.j(c0412a2.title, d.C0277d.cp_cont_b);
            al.l(c0412a2.divider, d.C0277d.cp_bg_line_c);
            view.setTag(c0412a2);
            c0412a = c0412a2;
        } else {
            c0412a = (C0412a) view.getTag();
        }
        al.k(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0412a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void em(List<VideoTitleData> list) {
        this.jqv = list;
        notifyDataSetChanged();
    }
}
