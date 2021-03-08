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
/* loaded from: classes10.dex */
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
    /* renamed from: ND */
    public com.baidu.yuyinala.mode.b.a getItem(int i) {
        return (com.baidu.yuyinala.mode.b.a) ListUtils.getItem(this.mModeList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0968a c0968a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_mode, viewGroup, false);
            C0968a c0968a2 = new C0968a();
            c0968a2.oYf = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0968a2.oYg = (ImageView) view.findViewById(a.f.chosen_iv);
            c0968a2.gOL = (TextView) view.findViewById(a.f.mode_name_tv);
            c0968a2.oYf.setDefaultResource(a.e.loading_ala_audio_mode);
            c0968a2.oYf.setDefaultErrorResource(a.e.loading_ala_audio_mode);
            c0968a2.oYf.setDefaultBgResource(a.e.loading_ala_audio_mode);
            view.setTag(c0968a2);
            c0968a = c0968a2;
        } else {
            c0968a = (C0968a) view.getTag();
        }
        com.baidu.yuyinala.mode.b.a item = getItem(i);
        if (item != null) {
            view.setVisibility(0);
            c0968a.gOL.setText(item.getTitle());
            c0968a.oYf.startLoad(item.getIconUrl(), 10, false);
            c0968a.oYf.setVisibility(0);
            c0968a.oYg.setVisibility(item.ejl() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.mode.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0968a {
        private TextView gOL;
        private TbImageView oYf;
        private ImageView oYg;

        private C0968a() {
        }
    }
}
