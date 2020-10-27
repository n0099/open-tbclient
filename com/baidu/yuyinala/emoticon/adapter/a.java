package com.baidu.yuyinala.emoticon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<com.baidu.yuyinala.emoticon.a.a> oku;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oku);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MY */
    public com.baidu.yuyinala.emoticon.a.a getItem(int i) {
        return (com.baidu.yuyinala.emoticon.a.a) ListUtils.getItem(this.oku, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0920a c0920a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.item_emoticon, viewGroup, false);
            C0920a c0920a2 = new C0920a();
            c0920a2.mIconIv = (TbImageView) view.findViewById(a.g.emoticon_icon_iv);
            c0920a2.goX = (TextView) view.findViewById(a.g.emoticon_name_tv);
            c0920a2.mIconIv.setDefaultResource(a.f.loading_ala_audio_emoticon);
            c0920a2.mIconIv.setDefaultErrorResource(a.f.loading_ala_audio_emoticon);
            c0920a2.mIconIv.setDefaultBgResource(a.f.loading_ala_audio_emoticon);
            view.setTag(c0920a2);
            c0920a = c0920a2;
        } else {
            c0920a = (C0920a) view.getTag();
        }
        com.baidu.yuyinala.emoticon.a.a item = getItem(i);
        if (item == null) {
            c0920a.goX.setText("");
            c0920a.mIconIv.startLoad(null, 10, false);
        } else {
            c0920a.goX.setText(item.getName());
            c0920a.mIconIv.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    public void gf(List<com.baidu.yuyinala.emoticon.a.a> list) {
        this.oku = list;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.yuyinala.emoticon.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0920a {
        private TextView goX;
        private TbImageView mIconIv;

        public C0920a() {
        }
    }
}
