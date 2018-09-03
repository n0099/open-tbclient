package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> hwO;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0256a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.hwO)) {
            return 0;
        }
        return this.hwO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vA */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) w.d(this.hwO, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0256a c0256a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.video_activity_title_item, (ViewGroup) null);
            C0256a c0256a2 = new C0256a();
            c0256a2.title = (TextView) view.findViewById(f.g.title);
            c0256a2.divider = view.findViewById(f.g.divider_line);
            am.h(c0256a2.title, f.d.cp_cont_b);
            am.j(c0256a2.divider, f.d.cp_bg_line_c);
            view.setTag(c0256a2);
            c0256a = c0256a2;
        } else {
            c0256a = (C0256a) view.getTag();
        }
        am.i(view, f.C0146f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0256a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dR(List<VideoTitleData> list) {
        this.hwO = list;
        notifyDataSetChanged();
    }
}
