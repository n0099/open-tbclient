package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> jQC;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0430a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.jQC)) {
            return 0;
        }
        return this.jQC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: De */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.jQC, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0430a c0430a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0430a c0430a2 = new C0430a();
            c0430a2.title = (TextView) view.findViewById(R.id.title);
            c0430a2.divider = view.findViewById(R.id.divider_line);
            am.j(c0430a2.title, R.color.cp_cont_b);
            am.l(c0430a2.divider, R.color.cp_bg_line_c);
            view.setTag(c0430a2);
            c0430a = c0430a2;
        } else {
            c0430a = (C0430a) view.getTag();
        }
        am.k(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0430a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void ez(List<VideoTitleData> list) {
        this.jQC = list;
        notifyDataSetChanged();
    }
}
