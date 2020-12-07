package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private ArrayList<d> nGe = new ArrayList<>();
    private boolean nGf = false;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.nGf = true;
        this.nGe.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.nGe.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void UV(String str) {
        if (this.nGe != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nGe.size()) {
                    d dVar = this.nGe.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.nGe.remove(i2);
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
        if (y.isEmpty(this.nGe)) {
            return 0;
        }
        return this.nGe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mf */
    public d getItem(int i) {
        if (this.nGe == null || this.nGe.isEmpty() || i < 0 || i >= this.nGe.size()) {
            return null;
        }
        return this.nGe.get(i);
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
        if (this.nGe != null && this.nGe.size() > i) {
            localVideoInfoView.a(this.nGe.get(i));
        } else if (i == 0 && this.nGf) {
            localVideoInfoView.yK(true);
        } else {
            localVideoInfoView.yK(false);
        }
        return view2;
    }
}
