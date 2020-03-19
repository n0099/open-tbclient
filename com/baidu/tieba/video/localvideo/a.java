package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<d> kBA = new ArrayList<>();
    private boolean kBB = false;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<d> list) {
        this.kBB = true;
        this.kBA.clear();
        if ((list != null ? list.size() : 0) > 0) {
            this.kBA.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void Kh(String str) {
        if (this.kBA != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kBA.size()) {
                    d dVar = this.kBA.get(i2);
                    if (dVar == null || !str.equals(dVar.getVideoPath())) {
                        i = i2 + 1;
                    } else {
                        this.kBA.remove(i2);
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
        if (v.isEmpty(this.kBA)) {
            return 0;
        }
        return this.kBA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DJ */
    public d getItem(int i) {
        if (this.kBA == null || this.kBA.isEmpty() || i < 0 || i >= this.kBA.size()) {
            return null;
        }
        return this.kBA.get(i);
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
        if (this.kBA != null && this.kBA.size() > i) {
            localVideoInfoView.a(this.kBA.get(i));
        } else if (i == 0 && this.kBB) {
            localVideoInfoView.tw(true);
        } else {
            localVideoInfoView.tw(false);
        }
        return view2;
    }
}
