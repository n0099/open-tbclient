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
    private ArrayList<d> gOT = new ArrayList<>();
    private boolean gOU = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.gOU = true;
        this.gOT.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.gOT.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void ua(String str) {
        if (this.gOT != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gOT.size()) {
                    d dVar = this.gOT.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.gOT.remove(i2);
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
        if (v.w(this.gOT)) {
            return 0;
        }
        return this.gOT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uq */
    public d getItem(int i) {
        if (this.gOT == null || this.gOT.isEmpty() || i < 0 || i >= this.gOT.size()) {
            return null;
        }
        return this.gOT.get(i);
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
        if (this.gOT != null && this.gOT.size() > i) {
            localVideoInfoView.a(this.gOT.get(i));
        } else if (i == 0 && this.gOU) {
            localVideoInfoView.mU(true);
        } else {
            localVideoInfoView.mU(false);
        }
        return view3;
    }
}
