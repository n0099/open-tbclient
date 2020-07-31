package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private ArrayList<d> mgY = new ArrayList<>();
    private boolean mgZ = false;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.mgZ = true;
        this.mgY.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.mgY.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void OT(String str) {
        if (this.mgY != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mgY.size()) {
                    d dVar = this.mgY.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.mgY.remove(i2);
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
        if (x.isEmpty(this.mgY)) {
            return 0;
        }
        return this.mgY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Gz */
    public d getItem(int i) {
        if (this.mgY == null || this.mgY.isEmpty() || i < 0 || i >= this.mgY.size()) {
            return null;
        }
        return this.mgY.get(i);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.local_video_item_layout, (ViewGroup) null);
            LocalVideoInfoView localVideoInfoView2 = (LocalVideoInfoView) inflate.findViewById(R.id.local_video_info_view);
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
        if (this.mgY != null && this.mgY.size() > i) {
            localVideoInfoView.a(this.mgY.get(i));
        } else if (i == 0 && this.mgZ) {
            localVideoInfoView.vR(true);
        } else {
            localVideoInfoView.vR(false);
        }
        return view2;
    }
}
