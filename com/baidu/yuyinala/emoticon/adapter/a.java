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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<com.baidu.yuyinala.emoticon.a.a> oYH;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.oYH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: NB */
    public com.baidu.yuyinala.emoticon.a.a getItem(int i) {
        return (com.baidu.yuyinala.emoticon.a.a) ListUtils.getItem(this.oYH, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0966a c0966a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_emoticon, viewGroup, false);
            C0966a c0966a2 = new C0966a();
            c0966a2.mIconIv = (TbImageView) view.findViewById(a.f.emoticon_icon_iv);
            c0966a2.gOL = (TextView) view.findViewById(a.f.emoticon_name_tv);
            c0966a2.mIconIv.setDefaultResource(a.e.loading_ala_audio_emoticon);
            c0966a2.mIconIv.setDefaultErrorResource(a.e.loading_ala_audio_emoticon);
            c0966a2.mIconIv.setDefaultBgResource(a.e.loading_ala_audio_emoticon);
            view.setTag(c0966a2);
            c0966a = c0966a2;
        } else {
            c0966a = (C0966a) view.getTag();
        }
        com.baidu.yuyinala.emoticon.a.a item = getItem(i);
        if (item == null) {
            c0966a.gOL.setText("");
            c0966a.mIconIv.startLoad(null, 10, false);
        } else {
            c0966a.gOL.setText(item.getName());
            c0966a.mIconIv.startLoad(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }

    public void gt(List<com.baidu.yuyinala.emoticon.a.a> list) {
        this.oYH = list;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.yuyinala.emoticon.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0966a {
        private TextView gOL;
        private TbImageView mIconIv;

        public C0966a() {
        }
    }
}
