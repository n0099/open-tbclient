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
    private List<VideoTitleData> hVs;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0339a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.hVs)) {
            return 0;
        }
        return this.hVs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xn */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.d(this.hVs, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0339a c0339a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.video_activity_title_item, (ViewGroup) null);
            C0339a c0339a2 = new C0339a();
            c0339a2.title = (TextView) view.findViewById(e.g.title);
            c0339a2.divider = view.findViewById(e.g.divider_line);
            al.h(c0339a2.title, e.d.cp_cont_b);
            al.j(c0339a2.divider, e.d.cp_bg_line_c);
            view.setTag(c0339a2);
            c0339a = c0339a2;
        } else {
            c0339a = (C0339a) view.getTag();
        }
        al.i(view, e.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0339a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void ei(List<VideoTitleData> list) {
        this.hVs = list;
        notifyDataSetChanged();
    }
}
