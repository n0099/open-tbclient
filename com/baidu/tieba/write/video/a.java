package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> mqW;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0773a {
        public View dQh;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.mqW)) {
            return 0;
        }
        return this.mqW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GO */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) w.getItem(this.mqW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0773a c0773a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0773a c0773a2 = new C0773a();
            c0773a2.title = (TextView) view.findViewById(R.id.title);
            c0773a2.dQh = view.findViewById(R.id.divider_line);
            an.setViewTextColor(c0773a2.title, (int) R.color.cp_cont_b);
            an.setBackgroundColor(c0773a2.dQh, R.color.cp_bg_line_c);
            view.setTag(c0773a2);
            c0773a = c0773a2;
        } else {
            c0773a = (C0773a) view.getTag();
        }
        an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0773a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void fj(List<VideoTitleData> list) {
        this.mqW = list;
        notifyDataSetChanged();
    }
}
