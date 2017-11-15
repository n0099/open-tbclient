package com.baidu.tieba.video.record;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private String gJq;
    private int gJr = -1;
    private VideoEffectLayout.a gJs;
    private List<d> mList;

    public void d(List<d> list, String str) {
        this.mList = list;
        this.gJq = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.gJs = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uV */
    public d getItem(int i) {
        if (this.mList != null && i >= 0 && i < this.mList.size()) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d dVar;
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
            aVar2.gJt = (TbImageView) view.findViewById(d.g.iv_effect);
            aVar2.gJt.setIsRound(true);
            aVar2.gJt.setDrawerType(1);
            aVar2.gJt.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            aVar2.gJt.setDefaultResource(d.f.bg_video_cloudmusic);
            aVar2.gJt.setDefaultBgResource(d.C0080d.transparent);
            aVar2.gJt.setBorderWidth(com.baidu.adp.lib.util.l.f(viewGroup.getContext(), d.e.ds4));
            aVar2.gJt.setBorderColor(aj.getColor(d.C0080d.cp_link_tip_a));
            aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
            aVar2.gtU = (TextView) view.findViewById(d.g.tv_name);
            aj.i(aVar2.gtU, d.C0080d.cp_cont_j);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mList != null && i >= 0 && i <= this.mList.size() - 1 && (dVar = this.mList.get(i)) != null) {
            if (!TextUtils.isEmpty(dVar.getName()) && dVar.getName().equals(this.gJq)) {
                aVar.gJt.setDrawBorder(true);
            } else {
                aVar.gJt.setDrawBorder(false);
            }
            if (dVar.getType() == 3) {
                MusicData musicData = (MusicData) dVar.getValue();
                if (musicData.editMusicType == 0) {
                    aVar.gJt.startLoad(musicData.img, 10, false);
                } else {
                    aVar.gJt.startLoad(String.valueOf(dVar.bAo()), 24, false);
                }
                if (this.gJr != i) {
                    aVar.mProgressBar.setVisibility(4);
                } else if (aVar.mProgressBar.getVisibility() == 0) {
                    aVar.gJt.setDrawBorder(false);
                }
            } else {
                aVar.gJt.startLoad(String.valueOf(dVar.bAo()), 24, false);
                aVar.mProgressBar.setVisibility(4);
            }
            aVar.gJt.setTag(dVar);
            aVar.gJt.setTag(d.g.record_video_effect_holder, aVar);
            aVar.gJt.setOnClickListener(this);
            aVar.gtU.setText(dVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof d)) {
            d dVar = (d) view.getTag();
            if (dVar.getType() == 3 && (dVar.getValue() instanceof MusicData)) {
                ak akVar = new ak("c12423");
                akVar.ac("obj_id", ((MusicData) dVar.getValue()).id);
                akVar.r("obj_locate", this.mList.indexOf(dVar) + 1);
                akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(akVar);
                if (view.getResources().getString(d.j.music_cloud).equals(dVar.getName()) && this.gJs != null) {
                    this.gJs.a(dVar, view.getTag(d.g.record_video_effect_holder));
                    this.gJr = this.mList.indexOf(dVar);
                    this.gJq = dVar.getName();
                }
                if (TextUtils.isEmpty(dVar.getName()) || !dVar.getName().equals(this.gJq)) {
                    if (!dVar.getName().equals(view.getResources().getString(d.j.music_cloud))) {
                        this.gJr = this.mList.indexOf(dVar);
                    }
                } else {
                    return;
                }
            } else {
                this.gJr = this.mList.indexOf(dVar);
            }
            this.gJq = dVar.getName();
            notifyDataSetChanged();
            if (this.gJs != null) {
                this.gJs.a(dVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bAm() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gJr = 0;
            this.gJq = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bAn() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gJr = 1;
            this.gJq = TbadkCoreApplication.getInst().getString(d.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView gJt;
        TextView gtU;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
