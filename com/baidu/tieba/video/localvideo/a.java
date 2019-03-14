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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private ArrayList<d> iZL = new ArrayList<>();
    private boolean iZM = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.iZM = true;
        this.iZL.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.iZL.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void DH(String str) {
        if (this.iZL != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iZL.size()) {
                    d dVar = this.iZL.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.iZL.remove(i2);
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
        if (v.T(this.iZL)) {
            return 0;
        }
        return this.iZL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ay */
    public d getItem(int i) {
        if (this.iZL == null || this.iZL.isEmpty() || i < 0 || i >= this.iZL.size()) {
            return null;
        }
        return this.iZL.get(i);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.local_video_item_layout, (ViewGroup) null);
            LocalVideoInfoView localVideoInfoView2 = (LocalVideoInfoView) inflate.findViewById(d.g.local_video_info_view);
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
        if (this.iZL != null && this.iZL.size() > i) {
            localVideoInfoView.a(this.iZL.get(i));
        } else if (i == 0 && this.iZM) {
            localVideoInfoView.qD(true);
        } else {
            localVideoInfoView.qD(false);
        }
        return view2;
    }
}
