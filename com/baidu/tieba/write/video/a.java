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
    private List<VideoTitleData> mRn;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0836a {
        public View efZ;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mRn)) {
            return 0;
        }
        return this.mRn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JG */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) y.getItem(this.mRn, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0836a c0836a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0836a c0836a2 = new C0836a();
            c0836a2.title = (TextView) view.findViewById(R.id.title);
            c0836a2.efZ = view.findViewById(R.id.divider_line);
            ap.setViewTextColor(c0836a2.title, R.color.cp_cont_b);
            ap.setBackgroundColor(c0836a2.efZ, R.color.cp_bg_line_c);
            view.setTag(c0836a2);
            c0836a = c0836a2;
        } else {
            c0836a = (C0836a) view.getTag();
        }
        ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0836a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void fA(List<VideoTitleData> list) {
        this.mRn = list;
        notifyDataSetChanged();
    }
}
