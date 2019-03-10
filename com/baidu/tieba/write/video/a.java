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
    private List<VideoTitleData> jqN;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0319a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.jqN)) {
            return 0;
        }
        return this.jqN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bs */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.jqN, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0319a c0319a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.video_activity_title_item, (ViewGroup) null);
            C0319a c0319a2 = new C0319a();
            c0319a2.title = (TextView) view.findViewById(d.g.title);
            c0319a2.divider = view.findViewById(d.g.divider_line);
            al.j(c0319a2.title, d.C0236d.cp_cont_b);
            al.l(c0319a2.divider, d.C0236d.cp_bg_line_c);
            view.setTag(c0319a2);
            c0319a = c0319a2;
        } else {
            c0319a = (C0319a) view.getTag();
        }
        al.k(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0319a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void ep(List<VideoTitleData> list) {
        this.jqN = list;
        notifyDataSetChanged();
    }
}
