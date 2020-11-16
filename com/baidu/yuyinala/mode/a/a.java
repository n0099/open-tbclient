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
    /* renamed from: NW */
    public com.baidu.yuyinala.mode.b.a getItem(int i) {
        return (com.baidu.yuyinala.mode.b.a) ListUtils.getItem(this.mModeList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0941a c0941a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_mode, viewGroup, false);
            C0941a c0941a2 = new C0941a();
            c0941a2.ouF = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0941a2.ouG = (ImageView) view.findViewById(a.f.chosen_iv);
            c0941a2.gur = (TextView) view.findViewById(a.f.mode_name_tv);
            c0941a2.ouF.setDefaultResource(a.e.loading_ala_audio_mode);
            c0941a2.ouF.setDefaultErrorResource(a.e.loading_ala_audio_mode);
            c0941a2.ouF.setDefaultBgResource(a.e.loading_ala_audio_mode);
            view.setTag(c0941a2);
            c0941a = c0941a2;
        } else {
            c0941a = (C0941a) view.getTag();
        }
        com.baidu.yuyinala.mode.b.a item = getItem(i);
        if (item != null) {
            view.setVisibility(0);
            c0941a.gur.setText(item.getTitle());
            c0941a.ouF.startLoad(item.getIconUrl(), 10, false);
            c0941a.ouF.setVisibility(0);
            c0941a.ouG.setVisibility(item.eey() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.mode.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0941a {
        private TextView gur;
        private TbImageView ouF;
        private ImageView ouG;

        private C0941a() {
        }
    }
}
