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
    private List<VideoTitleData> jRm;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0542a {
        public View cfh;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.jRm)) {
            return 0;
        }
        return this.jRm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BF */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.getItem(this.jRm, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0542a c0542a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0542a c0542a2 = new C0542a();
            c0542a2.title = (TextView) view.findViewById(R.id.title);
            c0542a2.cfh = view.findViewById(R.id.divider_line);
            am.setViewTextColor(c0542a2.title, (int) R.color.cp_cont_b);
            am.setBackgroundColor(c0542a2.cfh, R.color.cp_bg_line_c);
            view.setTag(c0542a2);
            c0542a = c0542a2;
        } else {
            c0542a = (C0542a) view.getTag();
        }
        am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0542a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void eL(List<VideoTitleData> list) {
        this.jRm = list;
        notifyDataSetChanged();
    }
}
