package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<VideoTitleData> nKQ;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0884a {
        public View eHl;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.nKQ)) {
            return 0;
        }
        return this.nKQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LZ */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) y.getItem(this.nKQ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0884a c0884a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0884a c0884a2 = new C0884a();
            c0884a2.title = (TextView) view.findViewById(R.id.title);
            c0884a2.eHl = view.findViewById(R.id.divider_line);
            ap.setViewTextColor(c0884a2.title, R.color.CAM_X0105);
            ap.setBackgroundColor(c0884a2.eHl, R.color.CAM_X0204);
            view.setTag(c0884a2);
            c0884a = c0884a2;
        } else {
            c0884a = (C0884a) view.getTag();
        }
        ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0884a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void gc(List<VideoTitleData> list) {
        this.nKQ = list;
        notifyDataSetChanged();
    }
}
