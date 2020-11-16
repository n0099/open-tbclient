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
    /* renamed from: NT */
    public com.baidu.yuyinala.background.b.a getItem(int i) {
        return (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0937a c0937a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.item_ala_audio_background, viewGroup, false);
            c0937a = new C0937a();
            c0937a.ouF = (TbImageView) view.findViewById(a.f.thumbnail_iv);
            c0937a.ouG = (ImageView) view.findViewById(a.f.chosen_iv);
            c0937a.gur = (TextView) view.findViewById(a.f.bg_name_tv);
            c0937a.ouH = (ProgressBar) view.findViewById(a.f.loading_pb);
            c0937a.ouF.setDefaultResource(a.e.loading_ala_audio_bg);
            c0937a.ouF.setDefaultErrorResource(a.e.loading_ala_audio_bg);
            c0937a.ouF.setDefaultBgResource(a.e.loading_ala_audio_bg);
            view.setTag(c0937a);
        } else {
            c0937a = (C0937a) view.getTag();
        }
        com.baidu.yuyinala.background.b.a aVar = (com.baidu.yuyinala.background.b.a) ListUtils.getItem(this.mBgList, i);
        if (aVar != null) {
            view.setVisibility(0);
            c0937a.gur.setText(aVar.getName());
            c0937a.ouF.startLoad(aVar.getThumbnailUrl(), 10, false);
            c0937a.ouF.setVisibility(0);
            c0937a.ouG.setVisibility(aVar.eey() ? 0 : 8);
            c0937a.ouH.setVisibility(aVar.isLoading() ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        return view;
    }

    /* renamed from: com.baidu.yuyinala.background.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0937a {
        private TextView gur;
        private TbImageView ouF;
        private ImageView ouG;
        private ProgressBar ouH;

        private C0937a() {
        }
    }
}
