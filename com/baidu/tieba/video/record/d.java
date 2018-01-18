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
public class d extends BaseAdapter implements View.OnClickListener {
    private String htf;
    private int htg = -1;
    private VideoEffectLayout.a hth;
    private List<e> mList;

    public void e(List<e> list, String str) {
        this.mList = list;
        this.htf = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.hth = aVar;
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
    /* renamed from: wR */
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
        aVar.hoe = (TbImageView) view.findViewById(d.g.iv_effect);
        aVar.hoe.setIsRound(true);
        aVar.hoe.setDrawerType(1);
        aVar.hoe.setDefaultBgResource(d.C0107d.transparent);
        aVar.hoe.setBorderWidth(com.baidu.adp.lib.util.l.s(viewGroup.getContext(), d.e.ds4));
        aVar.hoe.setBorderColor(aj.getColor(d.C0107d.cp_link_tip_a));
        aVar.fLG = (TextView) view.findViewById(d.g.tv_name);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            a aVar2 = new a();
            switch (getItemViewType(i)) {
                case 0:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.mProgressBar.setVisibility(4);
                    aj.r(aVar2.fLG, d.C0107d.cp_cont_i);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.hoe.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.hoe.setDefaultResource(d.f.bg_video_cloudmusic);
                    aj.r(aVar2.fLG, d.C0107d.cp_cont_i);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aj.r(aVar2.fLG, d.C0107d.cp_cont_i);
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
                    aVar.hoe.startLoad(String.valueOf(eVar.bCn()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.htf)) {
                        aVar.hoe.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hoe.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.hoe.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.hoe.startLoad(String.valueOf(eVar.bCn()), 24, false);
                    }
                    if (this.htg != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.hoe.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.htf)) {
                        aVar.hoe.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hoe.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.htf)) {
                        aVar.hoe.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.hoe.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.hoe.setTag(eVar);
            aVar.hoe.setTag(d.g.record_video_effect_holder, aVar);
            aVar.hoe.setOnClickListener(this);
            aVar.fLG.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                ak akVar = new ak("c12423");
                akVar.ab("obj_id", ((MusicData) eVar.getValue()).id);
                akVar.s("obj_locate", this.mList.indexOf(eVar) + 1);
                akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(akVar);
                if (view.getResources().getString(d.j.music_cloud).equals(eVar.getName()) && this.hth != null) {
                    this.hth.a(eVar, view.getTag(d.g.record_video_effect_holder));
                    this.htg = this.mList.indexOf(eVar);
                    this.htf = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.htf)) {
                    if (!eVar.getName().equals(view.getResources().getString(d.j.music_cloud))) {
                        this.htg = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.htg = this.mList.indexOf(eVar);
            }
            this.htf = eVar.getName();
            notifyDataSetChanged();
            if (this.hth != null) {
                this.hth.a(eVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bCj() {
        if (getItem(0) != null && getItem(0).getType() == 2) {
            this.htg = 0;
            this.htf = getItem(0).getName();
        }
    }

    public void bCk() {
        if (getItem(2) != null && getItem(2).getType() == 1) {
            this.htg = 0;
            this.htf = getItem(2).getName();
        }
    }

    public void bCl() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.htg = 0;
            this.htf = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCm() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.htg = 1;
            this.htf = TbadkCoreApplication.getInst().getString(d.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fLG;
        TbImageView hoe;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
