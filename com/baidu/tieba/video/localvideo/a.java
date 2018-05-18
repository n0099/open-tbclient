package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<d> gPW = new ArrayList<>();
    private boolean gPX = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.gPX = true;
        this.gPW.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.gPW.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void ud(String str) {
        if (this.gPW != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gPW.size()) {
                    d dVar = this.gPW.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.gPW.remove(i2);
                        notifyDataSetChanged();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.gPW)) {
            return 0;
        }
        return this.gPW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: up */
    public d getItem(int i) {
        if (this.gPW == null || this.gPW.isEmpty() || i < 0 || i >= this.gPW.size()) {
            return null;
        }
        return this.gPW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        LocalVideoInfoView localVideoInfoView;
        View view3;
        if (view2 == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.local_video_item_layout, (ViewGroup) null);
            LocalVideoInfoView localVideoInfoView2 = (LocalVideoInfoView) inflate.findViewById(d.g.local_video_info_view);
            inflate.setTag(localVideoInfoView2);
            localVideoInfoView = localVideoInfoView2;
            view3 = inflate;
        } else if (view2.getTag() instanceof LocalVideoInfoView) {
            localVideoInfoView = (LocalVideoInfoView) view2.getTag();
            view3 = view2;
        } else {
            localVideoInfoView = null;
            view3 = view2;
        }
        if (localVideoInfoView == null) {
            return null;
        }
        if (this.gPW != null && this.gPW.size() > i) {
            localVideoInfoView.a(this.gPW.get(i));
        } else if (i == 0 && this.gPX) {
            localVideoInfoView.mV(true);
        } else {
            localVideoInfoView.mV(false);
        }
        return view3;
    }
}
