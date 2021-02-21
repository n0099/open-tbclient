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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<com.baidu.yuyinala.emoticon.a.a> oWC;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oWC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nx */
    public com.baidu.yuyinala.emoticon.a.a getItem(int i) {
        return (com.baidu.yuyinala.emoticon.a.a) ListUtils.getItem(this.oWC, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0960a c0960a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_emoticon, viewGroup, false);
            C0960a c0960a2 = new C0960a();
            c0960a2.mIconIv = (TbImageView) view.findViewById(a.f.emoticon_icon_iv);
            c0960a2.gNc = (TextView) view.findViewById(a.f.emoticon_name_tv);
            c0960a2.mIconIv.setDefaultResource(a.e.loading_ala_audio_emoticon);
            c0960a2.mIconIv.setDefaultErrorResource(a.e.loading_ala_audio_emoticon);
            c0960a2.mIconIv.setDefaultBgResource(a.e.loading_ala_audio_emoticon);
            view.setTag(c0960a2);
            c0960a = c0960a2;
        } else {
            c0960a = (C0960a) view.getTag();
        }
        com.baidu.yuyinala.emoticon.a.a item = getItem(i);
        if (item == null) {
            c0960a.gNc.setText("");
            c0960a.mIconIv.startLoad(null, 10, false);
        } else {
            c0960a.gNc.setText(item.getName());
            c0960a.mIconIv.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    public void gt(List<com.baidu.yuyinala.emoticon.a.a> list) {
        this.oWC = list;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.yuyinala.emoticon.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0960a {
        private TextView gNc;
        private TbImageView mIconIv;

        public C0960a() {
        }
    }
}
