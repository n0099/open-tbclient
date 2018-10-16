package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> hMx;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0297a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.hMx)) {
            return 0;
        }
        return this.hMx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wx */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.d(this.hMx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0297a c0297a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.video_activity_title_item, (ViewGroup) null);
            C0297a c0297a2 = new C0297a();
            c0297a2.title = (TextView) view.findViewById(e.g.title);
            c0297a2.divider = view.findViewById(e.g.divider_line);
            al.h(c0297a2.title, e.d.cp_cont_b);
            al.j(c0297a2.divider, e.d.cp_bg_line_c);
            view.setTag(c0297a2);
            c0297a = c0297a2;
        } else {
            c0297a = (C0297a) view.getTag();
        }
        al.i(view, e.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0297a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void eg(List<VideoTitleData> list) {
        this.hMx = list;
        notifyDataSetChanged();
    }
}
