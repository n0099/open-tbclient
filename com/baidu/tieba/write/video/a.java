package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> gUr;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0144a {
        public TextView awD;
        public View divider;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.gUr)) {
            return 0;
        }
        return this.gUr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vu */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.gUr, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0144a c0144a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.video_activity_title_item, (ViewGroup) null);
            C0144a c0144a2 = new C0144a();
            c0144a2.awD = (TextView) view.findViewById(d.g.title);
            c0144a2.divider = view.findViewById(d.g.divider_line);
            aj.i(c0144a2.awD, d.C0080d.cp_cont_b);
            aj.k(c0144a2.divider, d.C0080d.cp_bg_line_c);
            view.setTag(c0144a2);
            c0144a = c0144a2;
        } else {
            c0144a = (C0144a) view.getTag();
        }
        aj.j(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0144a.awD.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dL(List<VideoTitleData> list) {
        this.gUr = list;
        notifyDataSetChanged();
    }
}
