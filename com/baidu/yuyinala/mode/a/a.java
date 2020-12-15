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
/* loaded from: classes4.dex */
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
    /* renamed from: OU */
    public com.baidu.yuyinala.mode.b.a getItem(int i) {
        return (com.baidu.yuyinala.mode.b.a) ListUtils.getItem(this.mModeList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0958a c0958a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_mode, viewGroup, false);
            C0958a c0958a2 = new C0958a();
            c0958a2.oJN = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0958a2.oJO = (ImageView) view.findViewById(a.f.chosen_iv);
            c0958a2.gDc = (TextView) view.findViewById(a.f.mode_name_tv);
            c0958a2.oJN.setDefaultResource(a.e.loading_ala_audio_mode);
            c0958a2.oJN.setDefaultErrorResource(a.e.loading_ala_audio_mode);
            c0958a2.oJN.setDefaultBgResource(a.e.loading_ala_audio_mode);
            view.setTag(c0958a2);
            c0958a = c0958a2;
        } else {
            c0958a = (C0958a) view.getTag();
        }
        com.baidu.yuyinala.mode.b.a item = getItem(i);
        if (item != null) {
            view.setVisibility(0);
            c0958a.gDc.setText(item.getTitle());
            c0958a.oJN.startLoad(item.getIconUrl(), 10, false);
            c0958a.oJN.setVisibility(0);
            c0958a.oJO.setVisibility(item.ekm() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.mode.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0958a {
        private TextView gDc;
        private TbImageView oJN;
        private ImageView oJO;

        private C0958a() {
        }
    }
}
