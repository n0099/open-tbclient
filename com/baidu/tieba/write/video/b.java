package com.baidu.tieba.write.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoTitleData;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<VideoTitleData> hih;

    /* loaded from: classes2.dex */
    public static class a {
        public TextView axj;
        public View divider;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.hih)) {
            return 0;
        }
        return this.hih.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wd */
    public VideoTitleData getItem(int i) {
        return (VideoTitleData) v.c(this.hih, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.video_activity_title_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.axj = (TextView) view.findViewById(d.g.title);
            aVar2.divider = view.findViewById(d.g.divider_line);
            aj.i(aVar2.axj, d.C0096d.cp_cont_b);
            aj.k(aVar2.divider, d.C0096d.cp_bg_line_c);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aj.j(view, d.f.addresslist_item_bg);
        if (getItem(i) != null) {
            aVar.axj.setText("#" + getItem(i).name + "#");
        }
        return view;
    }

    public void dX(List<VideoTitleData> list) {
        this.hih = list;
        notifyDataSetChanged();
    }
}
