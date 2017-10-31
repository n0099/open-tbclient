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
    private List<VideoTitleData> gTj;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0141a {
        public TextView awv;
        public View divider;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.gTj)) {
            return 0;
        }
        return this.gTj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vq */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.gTj, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0141a c0141a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.video_activity_title_item, (ViewGroup) null);
            C0141a c0141a2 = new C0141a();
            c0141a2.awv = (TextView) view.findViewById(d.g.title);
            c0141a2.divider = view.findViewById(d.g.divider_line);
            aj.i(c0141a2.awv, d.C0080d.cp_cont_b);
            aj.k(c0141a2.divider, d.C0080d.cp_bg_line_c);
            view.setTag(c0141a2);
            c0141a = c0141a2;
        } else {
            c0141a = (C0141a) view.getTag();
        }
        aj.j(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0141a.awv.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dK(List<VideoTitleData> list) {
        this.gTj = list;
        notifyDataSetChanged();
    }
}
