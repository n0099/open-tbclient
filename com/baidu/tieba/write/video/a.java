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
    private List<VideoTitleData> nDv;

    /* renamed from: com.baidu.tieba.write.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0866a {
        public View eCZ;
        public TextView title;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.nDv)) {
            return 0;
        }
        return this.nDv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lj */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) y.getItem(this.nDv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0866a c0866a;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_activity_title_item, (ViewGroup) null);
            C0866a c0866a2 = new C0866a();
            c0866a2.title = (TextView) view.findViewById(R.id.title);
            c0866a2.eCZ = view.findViewById(R.id.divider_line);
            ap.setViewTextColor(c0866a2.title, R.color.cp_cont_b);
            ap.setBackgroundColor(c0866a2.eCZ, R.color.cp_bg_line_c);
            view.setTag(c0866a2);
            c0866a = c0866a2;
        } else {
            c0866a = (C0866a) view.getTag();
        }
        ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        if (getItem(i) != null) {
            c0866a.title.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void fU(List<VideoTitleData> list) {
        this.nDv = list;
        notifyDataSetChanged();
    }
}
