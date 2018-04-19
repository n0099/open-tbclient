package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> heB;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0237a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.heB)) {
            return 0;
        }
        return this.heB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vb */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.heB, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0237a c0237a;
        if (view2 == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.video_activity_title_item, (ViewGroup) null);
            C0237a c0237a2 = new C0237a();
            c0237a2.title = (TextView) view2.findViewById(d.g.title);
            c0237a2.divider = view2.findViewById(d.g.divider_line);
            ak.h(c0237a2.title, d.C0126d.cp_cont_b);
            ak.j(c0237a2.divider, d.C0126d.cp_bg_line_c);
            view2.setTag(c0237a2);
            c0237a = c0237a2;
        } else {
            c0237a = (C0237a) view2.getTag();
        }
        ak.i(view2, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            c0237a.title.setText("#" + getItem(i).name + "#");
        }
        return view2;
    }

    public void dJ(List<VideoTitleData> list) {
        this.heB = list;
        notifyDataSetChanged();
    }
}
