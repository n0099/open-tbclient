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
    private ArrayList<d> hrP = new ArrayList<>();
    private boolean hrQ = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.hrQ = true;
        this.hrP.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.hrP.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void tP(String str) {
        if (this.hrP != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hrP.size()) {
                    d dVar = this.hrP.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.hrP.remove(i2);
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
        if (v.E(this.hrP)) {
            return 0;
        }
        return this.hrP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wO */
    public d getItem(int i) {
        if (this.hrP == null || this.hrP.isEmpty() || i < 0 || i >= this.hrP.size()) {
            return null;
        }
        return this.hrP.get(i);
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
        if (this.hrP != null && this.hrP.size() > i) {
            localVideoInfoView.a(this.hrP.get(i));
        } else if (i == 0 && this.hrQ) {
            localVideoInfoView.ng(true);
        } else {
            localVideoInfoView.ng(false);
        }
        return view2;
    }
}
