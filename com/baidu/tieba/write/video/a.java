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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> kPz;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0627a {
        public View cRQ;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.kPz)) {
            return 0;
        }
        return this.kPz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eh */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.getItem(this.kPz, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0627a c0627a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0627a c0627a2 = new C0627a();
            c0627a2.title = (TextView) view.findViewById(R.id.title);
            c0627a2.cRQ = view.findViewById(R.id.divider_line);
            am.setViewTextColor(c0627a2.title, (int) R.color.cp_cont_b);
            am.setBackgroundColor(c0627a2.cRQ, R.color.cp_bg_line_c);
            view.setTag(c0627a2);
            c0627a = c0627a2;
        } else {
            c0627a = (C0627a) view.getTag();
        }
        am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0627a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void eD(List<VideoTitleData> list) {
        this.kPz = list;
        notifyDataSetChanged();
    }
}
