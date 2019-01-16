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
    private List<VideoTitleData> hZK;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0338a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.hZK)) {
            return 0;
        }
        return this.hZK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xC */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.d(this.hZK, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0338a c0338a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.video_activity_title_item, (ViewGroup) null);
            C0338a c0338a2 = new C0338a();
            c0338a2.title = (TextView) view.findViewById(e.g.title);
            c0338a2.divider = view.findViewById(e.g.divider_line);
            al.h(c0338a2.title, e.d.cp_cont_b);
            al.j(c0338a2.divider, e.d.cp_bg_line_c);
            view.setTag(c0338a2);
            c0338a = c0338a2;
        } else {
            c0338a = (C0338a) view.getTag();
        }
        al.i(view, e.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0338a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void ek(List<VideoTitleData> list) {
        this.hZK = list;
        notifyDataSetChanged();
    }
}
