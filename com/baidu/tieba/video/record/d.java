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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String hxi;
    private int hxj = -1;
    private VideoEffectLayout.a hxk;
    private List<e> mList;

    public void f(List<e> list, String str) {
        this.mList = list;
        this.hxi = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.hxk = aVar;
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
    /* renamed from: vJ */
    public e getItem(int i) {
        if (this.mList != null && i >= 0 && i < this.mList.size()) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        e item = getItem(i);
        if (item == null) {
            return 0;
        }
        switch (item.getType()) {
            case 1:
                return 2;
            case 2:
            default:
                return 0;
            case 3:
                return 1;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    private void a(a aVar, View view, ViewGroup viewGroup) {
        aVar.hsJ = (TbImageView) view.findViewById(e.g.iv_effect);
        aVar.hsJ.setIsRound(true);
        aVar.hsJ.setDrawerType(1);
        aVar.hsJ.setDefaultBgResource(e.d.transparent);
        aVar.hsJ.setBorderWidth(com.baidu.adp.lib.util.l.h(viewGroup.getContext(), e.C0175e.ds4));
        aVar.hsJ.setBorderColor(al.getColor(e.d.cp_link_tip_a));
        aVar.fPd = (TextView) view.findViewById(e.g.tv_name);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            a aVar2 = new a();
            switch (getItemViewType(i)) {
                case 0:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(e.g.iv_loading);
                    aVar2.mProgressBar.setVisibility(4);
                    al.h(aVar2.fPd, e.d.cp_cont_i);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(e.g.iv_loading);
                    aVar2.hsJ.setDefaultErrorResource(e.f.bg_video_cloudmusic);
                    aVar2.hsJ.setDefaultResource(e.f.bg_video_cloudmusic);
                    al.h(aVar2.fPd, e.d.cp_cont_i);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    al.h(aVar2.fPd, e.d.cp_cont_i);
                    break;
            }
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mList != null && i >= 0 && i <= this.mList.size() - 1 && (eVar = this.mList.get(i)) != null) {
            switch (getItemViewType(i)) {
                case 0:
                    aVar.hsJ.startLoad(String.valueOf(eVar.bIo()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hxi)) {
                        aVar.hsJ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hsJ.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.hsJ.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.hsJ.startLoad(String.valueOf(eVar.bIo()), 24, false);
                    }
                    if (this.hxj != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.hsJ.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hxi)) {
                        aVar.hsJ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hsJ.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hxi)) {
                        aVar.hsJ.setBackgroundResource(e.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.hsJ.setBackgroundResource(e.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.hsJ.setTag(eVar);
            aVar.hsJ.setTag(e.g.record_video_effect_holder, aVar);
            aVar.hsJ.setOnClickListener(this);
            aVar.fPd.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                am amVar = new am("c12423");
                amVar.ax(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                amVar.x("obj_locate", this.mList.indexOf(eVar) + 1);
                amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(amVar);
                if (view.getResources().getString(e.j.music_cloud).equals(eVar.getName()) && this.hxk != null) {
                    this.hxk.a(eVar, view.getTag(e.g.record_video_effect_holder));
                    this.hxj = this.mList.indexOf(eVar);
                    this.hxi = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.hxi)) {
                    if (!eVar.getName().equals(view.getResources().getString(e.j.music_cloud))) {
                        this.hxj = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.hxj = this.mList.indexOf(eVar);
            }
            this.hxi = eVar.getName();
            notifyDataSetChanged();
            if (this.hxk != null) {
                this.hxk.a(eVar, view.getTag(e.g.record_video_effect_holder));
            }
        }
    }

    public void bIm() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hxj = 0;
            this.hxi = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bIn() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hxj = 1;
            this.hxi = TbadkCoreApplication.getInst().getString(e.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        TextView fPd;
        TbImageView hsJ;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
