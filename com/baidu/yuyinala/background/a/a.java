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
import com.baidu.yuyinala.background.c.b;
import java.util.List;
/* loaded from: classes10.dex */
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
    /* renamed from: MZ */
    public com.baidu.yuyinala.background.b.a getItem(int i) {
        return (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0951a c0951a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_background, viewGroup, false);
            c0951a = new C0951a();
            c0951a.oLt = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0951a.oLu = (ImageView) view.findViewById(a.f.chosen_iv);
            c0951a.gKi = (TextView) view.findViewById(a.f.bg_name_tv);
            c0951a.oLv = (ProgressBar) view.findViewById(a.f.loading_pb);
            c0951a.oLw = (TextView) view.findViewById(a.f.video_tag);
            c0951a.oLt.setDefaultResource(a.e.loading_ala_audio_bg);
            c0951a.oLt.setDefaultErrorResource(a.e.loading_ala_audio_bg);
            c0951a.oLt.setDefaultBgResource(a.e.loading_ala_audio_bg);
            view.setTag(c0951a);
        } else {
            c0951a = (C0951a) view.getTag();
        }
        com.baidu.yuyinala.background.b.a aVar = (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
        if (aVar != null) {
            view.setVisibility(0);
            c0951a.gKi.setText(aVar.getName());
            c0951a.oLt.startLoad(aVar.getThumbnailUrl(), 10, false);
            c0951a.oLt.setVisibility(0);
            c0951a.oLu.setVisibility(aVar.egB() ? 0 : 8);
            c0951a.oLv.setVisibility(aVar.isLoading() ? 0 : 8);
            c0951a.oLw.setVisibility(aVar.getType() != 1 ? 8 : 0);
            if (aVar.getType() == 1 && !b.WQ(aVar.getMd5())) {
                b.b(aVar.egC(), aVar.getMd5(), null);
            }
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.background.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0951a {
        private TextView gKi;
        private TbImageView oLt;
        private ImageView oLu;
        private ProgressBar oLv;
        private TextView oLw;

        private C0951a() {
        }
    }
}
