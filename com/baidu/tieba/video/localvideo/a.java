package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> hvY = new ArrayList<>();
    private boolean hvZ = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.hvZ = true;
        this.hvY.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.hvY.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void wf(String str) {
        if (this.hvY != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hvY.size()) {
                    d dVar = this.hvY.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.hvY.remove(i2);
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
        if (v.J(this.hvY)) {
            return 0;
        }
        return this.hvY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vG */
    public d getItem(int i) {
        if (this.hvY == null || this.hvY.isEmpty() || i < 0 || i >= this.hvY.size()) {
            return null;
        }
        return this.hvY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LocalVideoInfoView localVideoInfoView;
        View view2;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.local_video_item_layout, (ViewGroup) null);
            LocalVideoInfoView localVideoInfoView2 = (LocalVideoInfoView) inflate.findViewById(e.g.local_video_info_view);
            inflate.setTag(localVideoInfoView2);
            localVideoInfoView = localVideoInfoView2;
            view2 = inflate;
        } else if (view.getTag() instanceof LocalVideoInfoView) {
            localVideoInfoView = (LocalVideoInfoView) view.getTag();
            view2 = view;
        } else {
            localVideoInfoView = null;
            view2 = view;
        }
        if (localVideoInfoView == null) {
            return null;
        }
        if (this.hvY != null && this.hvY.size() > i) {
            localVideoInfoView.a(this.hvY.get(i));
        } else if (i == 0 && this.hvZ) {
            localVideoInfoView.nJ(true);
        } else {
            localVideoInfoView.nJ(false);
        }
        return view2;
    }
}
