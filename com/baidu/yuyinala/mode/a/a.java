package com.baidu.yuyinala.mode.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<com.baidu.yuyinala.mode.b.a> mModeList;

    public a(Context context) {
        this.mContext = context;
    }

    public void setModeList(List<com.baidu.yuyinala.mode.b.a> list) {
        this.mModeList = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mModeList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nz */
    public com.baidu.yuyinala.mode.b.a getItem(int i) {
        return (com.baidu.yuyinala.mode.b.a) ListUtils.getItem(this.mModeList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0962a c0962a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_mode, viewGroup, false);
            C0962a c0962a2 = new C0962a();
            c0962a2.oWa = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0962a2.oWb = (ImageView) view.findViewById(a.f.chosen_iv);
            c0962a2.gNc = (TextView) view.findViewById(a.f.mode_name_tv);
            c0962a2.oWa.setDefaultResource(a.e.loading_ala_audio_mode);
            c0962a2.oWa.setDefaultErrorResource(a.e.loading_ala_audio_mode);
            c0962a2.oWa.setDefaultBgResource(a.e.loading_ala_audio_mode);
            view.setTag(c0962a2);
            c0962a = c0962a2;
        } else {
            c0962a = (C0962a) view.getTag();
        }
        com.baidu.yuyinala.mode.b.a item = getItem(i);
        if (item != null) {
            view.setVisibility(0);
            c0962a.gNc.setText(item.getTitle());
            c0962a.oWa.startLoad(item.getIconUrl(), 10, false);
            c0962a.oWa.setVisibility(0);
            c0962a.oWb.setVisibility(item.ejb() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.mode.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0962a {
        private TextView gNc;
        private TbImageView oWa;
        private ImageView oWb;

        private C0962a() {
        }
    }
}
