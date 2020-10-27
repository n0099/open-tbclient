package com.baidu.yuyinala.background.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.yuyinala.background.b.a> mBgList;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setBgList(List<com.baidu.yuyinala.background.b.a> list) {
        this.mBgList = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mBgList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MX */
    public com.baidu.yuyinala.background.b.a getItem(int i) {
        return (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0918a c0918a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.item_ala_audio_background, viewGroup, false);
            c0918a = new C0918a();
            c0918a.ojW = (TbImageView) view.findViewById(a.g.thumbnail_iv);
            c0918a.ojX = (ImageView) view.findViewById(a.g.chosen_iv);
            c0918a.goX = (TextView) view.findViewById(a.g.bg_name_tv);
            c0918a.ojY = (ProgressBar) view.findViewById(a.g.loading_pb);
            c0918a.ojW.setDefaultResource(a.f.loading_ala_audio_bg);
            c0918a.ojW.setDefaultErrorResource(a.f.loading_ala_audio_bg);
            c0918a.ojW.setDefaultBgResource(a.f.loading_ala_audio_bg);
            view.setTag(c0918a);
        } else {
            c0918a = (C0918a) view.getTag();
        }
        com.baidu.yuyinala.background.b.a aVar = (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
        if (aVar != null) {
            view.setVisibility(0);
            c0918a.goX.setText(aVar.getName());
            c0918a.ojW.startLoad(aVar.getThumbnailUrl(), 10, false);
            c0918a.ojW.setVisibility(0);
            c0918a.ojX.setVisibility(aVar.eaS() ? 0 : 8);
            c0918a.ojY.setVisibility(aVar.isLoading() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.background.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0918a {
        private TextView goX;
        private TbImageView ojW;
        private ImageView ojX;
        private ProgressBar ojY;

        private C0918a() {
        }
    }
}
