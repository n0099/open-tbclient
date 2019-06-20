package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> jJB;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0431a {
        public View divider;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.jJB)) {
            return 0;
        }
        return this.jJB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cx */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.jJB, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0431a c0431a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0431a c0431a2 = new C0431a();
            c0431a2.title = (TextView) view.findViewById(R.id.title);
            c0431a2.divider = view.findViewById(R.id.divider_line);
            al.j(c0431a2.title, R.color.cp_cont_b);
            al.l(c0431a2.divider, R.color.cp_bg_line_c);
            view.setTag(c0431a2);
            c0431a = c0431a2;
        } else {
            c0431a = (C0431a) view.getTag();
        }
        al.k(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0431a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void ew(List<VideoTitleData> list) {
        this.jJB = list;
        notifyDataSetChanged();
    }
}
