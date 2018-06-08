package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> hrx;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0254a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.hrx)) {
            return 0;
        }
        return this.hrx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) w.c(this.hrx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0254a c0254a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.video_activity_title_item, (ViewGroup) null);
            C0254a c0254a2 = new C0254a();
            c0254a2.title = (TextView) view.findViewById(d.g.title);
            c0254a2.divider = view.findViewById(d.g.divider_line);
            al.h(c0254a2.title, d.C0141d.cp_cont_b);
            al.j(c0254a2.divider, d.C0141d.cp_bg_line_c);
            view.setTag(c0254a2);
            c0254a = c0254a2;
        } else {
            c0254a = (C0254a) view.getTag();
        }
        al.i(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0254a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dS(List<VideoTitleData> list) {
        this.hrx = list;
        notifyDataSetChanged();
    }
}
