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
    private List<VideoTitleData> nYY;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0900a {
        public View eOv;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.nYY)) {
            return 0;
        }
        return this.nYY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MR */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) y.getItem(this.nYY, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0900a c0900a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0900a c0900a2 = new C0900a();
            c0900a2.title = (TextView) view.findViewById(R.id.title);
            c0900a2.eOv = view.findViewById(R.id.divider_line);
            ap.setViewTextColor(c0900a2.title, R.color.CAM_X0105);
            ap.setBackgroundColor(c0900a2.eOv, R.color.CAM_X0204);
            view.setTag(c0900a2);
            c0900a = c0900a2;
        } else {
            c0900a = (C0900a) view.getTag();
        }
        ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0900a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void gq(List<VideoTitleData> list) {
        this.nYY = list;
        notifyDataSetChanged();
    }
}
