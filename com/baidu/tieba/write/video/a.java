package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> myX;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0783a {
        public View dWz;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.myX)) {
            return 0;
        }
        return this.myX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Hj */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) x.getItem(this.myX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0783a c0783a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0783a c0783a2 = new C0783a();
            c0783a2.title = (TextView) view.findViewById(R.id.title);
            c0783a2.dWz = view.findViewById(R.id.divider_line);
            ao.setViewTextColor(c0783a2.title, R.color.cp_cont_b);
            ao.setBackgroundColor(c0783a2.dWz, R.color.cp_bg_line_c);
            view.setTag(c0783a2);
            c0783a = c0783a2;
        } else {
            c0783a = (C0783a) view.getTag();
        }
        ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0783a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void fs(List<VideoTitleData> list) {
        this.myX = list;
        notifyDataSetChanged();
    }
}
