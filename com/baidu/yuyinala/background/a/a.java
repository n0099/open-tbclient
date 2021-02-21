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
/* loaded from: classes11.dex */
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
    /* renamed from: Nw */
    public com.baidu.yuyinala.background.b.a getItem(int i) {
        return (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0957a c0957a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_background, viewGroup, false);
            c0957a = new C0957a();
            c0957a.oWa = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0957a.oWb = (ImageView) view.findViewById(a.f.chosen_iv);
            c0957a.gNc = (TextView) view.findViewById(a.f.bg_name_tv);
            c0957a.oWc = (ProgressBar) view.findViewById(a.f.loading_pb);
            c0957a.oWd = (TextView) view.findViewById(a.f.video_tag);
            c0957a.oWa.setDefaultResource(a.e.loading_ala_audio_bg);
            c0957a.oWa.setDefaultErrorResource(a.e.loading_ala_audio_bg);
            c0957a.oWa.setDefaultBgResource(a.e.loading_ala_audio_bg);
            view.setTag(c0957a);
        } else {
            c0957a = (C0957a) view.getTag();
        }
        com.baidu.yuyinala.background.b.a aVar = (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
        if (aVar != null) {
            view.setVisibility(0);
            c0957a.gNc.setText(aVar.getName());
            c0957a.oWa.startLoad(aVar.getThumbnailUrl(), 10, false);
            c0957a.oWa.setVisibility(0);
            c0957a.oWb.setVisibility(aVar.ejb() ? 0 : 8);
            c0957a.oWc.setVisibility(aVar.isLoading() ? 0 : 8);
            c0957a.oWd.setVisibility(aVar.getType() != 1 ? 8 : 0);
            if (aVar.getType() == 1 && !b.Yc(aVar.getMd5())) {
                b.b(aVar.ejc(), aVar.getMd5(), null);
            }
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.background.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0957a {
        private TextView gNc;
        private TbImageView oWa;
        private ImageView oWb;
        private ProgressBar oWc;
        private TextView oWd;

        private C0957a() {
        }
    }
}
