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
    private String gTJ;
    private int gTK = -1;
    private VideoEffectLayout.a gTL;
    private List<e> mList;

    public void d(List<e> list, String str) {
        this.mList = list;
        this.gTJ = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.gTL = aVar;
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
    /* renamed from: vo */
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
        aVar.gOL = (TbImageView) view.findViewById(d.g.iv_effect);
        aVar.gOL.setIsRound(true);
        aVar.gOL.setDrawerType(1);
        aVar.gOL.setDefaultBgResource(d.C0082d.transparent);
        aVar.gOL.setBorderWidth(com.baidu.adp.lib.util.l.f(viewGroup.getContext(), d.e.ds4));
        aVar.gOL.setBorderColor(aj.getColor(d.C0082d.cp_link_tip_a));
        aVar.eWk = (TextView) view.findViewById(d.g.tv_name);
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
                    aj.i(aVar2.eWk, d.C0082d.cp_cont_i);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.gOL.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.gOL.setDefaultResource(d.f.bg_video_cloudmusic);
                    aj.i(aVar2.eWk, d.C0082d.cp_cont_i);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aj.i(aVar2.eWk, d.C0082d.cp_cont_i);
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
                    aVar.gOL.startLoad(String.valueOf(eVar.bCL()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gTJ)) {
                        aVar.gOL.setDrawBorder(true);
                        break;
                    } else {
                        aVar.gOL.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.gOL.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.gOL.startLoad(String.valueOf(eVar.bCL()), 24, false);
                    }
                    if (this.gTK != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.gOL.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gTJ)) {
                        aVar.gOL.setDrawBorder(true);
                        break;
                    } else {
                        aVar.gOL.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gTJ)) {
                        aVar.gOL.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.gOL.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.gOL.setTag(eVar);
            aVar.gOL.setTag(d.g.record_video_effect_holder, aVar);
            aVar.gOL.setOnClickListener(this);
            aVar.eWk.setText(eVar.getName());
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
                akVar.ac("obj_id", ((MusicData) eVar.getValue()).id);
                akVar.r("obj_locate", this.mList.indexOf(eVar) + 1);
                akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(akVar);
                if (view.getResources().getString(d.j.music_cloud).equals(eVar.getName()) && this.gTL != null) {
                    this.gTL.a(eVar, view.getTag(d.g.record_video_effect_holder));
                    this.gTK = this.mList.indexOf(eVar);
                    this.gTJ = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.gTJ)) {
                    if (!eVar.getName().equals(view.getResources().getString(d.j.music_cloud))) {
                        this.gTK = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.gTK = this.mList.indexOf(eVar);
            }
            this.gTJ = eVar.getName();
            notifyDataSetChanged();
            if (this.gTL != null) {
                this.gTL.a(eVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bCJ() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gTK = 0;
            this.gTJ = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCK() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gTK = 1;
            this.gTJ = TbadkCoreApplication.getInst().getString(d.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TextView eWk;
        TbImageView gOL;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
