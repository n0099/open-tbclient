package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> hvG;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0256a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.hvG)) {
            return 0;
        }
        return this.hvG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vB */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) w.d(this.hvG, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0256a c0256a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.video_activity_title_item, (ViewGroup) null);
            C0256a c0256a2 = new C0256a();
            c0256a2.title = (TextView) view.findViewById(d.g.title);
            c0256a2.divider = view.findViewById(d.g.divider_line);
            am.h(c0256a2.title, d.C0142d.cp_cont_b);
            am.j(c0256a2.divider, d.C0142d.cp_bg_line_c);
            view.setTag(c0256a2);
            c0256a = c0256a2;
        } else {
            c0256a = (C0256a) view.getTag();
        }
        am.i(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0256a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dV(List<VideoTitleData> list) {
        this.hvG = list;
        notifyDataSetChanged();
    }
}
