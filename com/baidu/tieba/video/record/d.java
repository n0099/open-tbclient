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
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String jaJ;
    private int jaK = -1;
    private VideoEffectLayout.a jaL;
    private List<e> mList;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.jaJ = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.jaL = aVar;
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
    /* renamed from: Ax */
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
        aVar.iWo = (TbImageView) view.findViewById(d.g.iv_effect);
        aVar.iWo.setIsRound(true);
        aVar.iWo.setDrawerType(1);
        aVar.iWo.setDefaultBgResource(d.C0277d.transparent);
        aVar.iWo.setBorderWidth(com.baidu.adp.lib.util.l.h(viewGroup.getContext(), d.e.ds4));
        aVar.iWo.setConrers(15);
        aVar.iWo.setBorderColor(al.getColor(d.C0277d.cp_link_tip_a));
        aVar.hrb = (TextView) view.findViewById(d.g.tv_name);
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
                    al.j(aVar2.hrb, d.C0277d.cp_btn_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.iWo.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.iWo.setDefaultResource(d.f.bg_video_cloudmusic);
                    al.j(aVar2.hrb, d.C0277d.cp_btn_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    al.j(aVar2.hrb, d.C0277d.cp_btn_a);
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
                    aVar.iWo.startLoad(String.valueOf(eVar.ckP()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jaJ)) {
                        aVar.iWo.setDrawBorder(true);
                        break;
                    } else {
                        aVar.iWo.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.iWo.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.iWo.startLoad(String.valueOf(eVar.ckP()), 24, false);
                    }
                    if (this.jaK != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.iWo.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jaJ)) {
                        aVar.iWo.setDrawBorder(true);
                        break;
                    } else {
                        aVar.iWo.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jaJ)) {
                        aVar.iWo.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.iWo.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.iWo.setTag(eVar);
            aVar.iWo.setTag(d.g.record_video_effect_holder, aVar);
            aVar.iWo.setOnClickListener(this);
            aVar.hrb.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                am amVar = new am("c12423");
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                amVar.T("obj_locate", this.mList.indexOf(eVar) + 1);
                amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(amVar);
                if (view.getResources().getString(d.j.music_cloud).equals(eVar.getName()) && this.jaL != null) {
                    this.jaL.a(eVar, view.getTag(d.g.record_video_effect_holder));
                    this.jaK = this.mList.indexOf(eVar);
                    this.jaJ = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.jaJ)) {
                    if (!eVar.getName().equals(view.getResources().getString(d.j.music_cloud))) {
                        this.jaK = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.jaK = this.mList.indexOf(eVar);
            }
            this.jaJ = eVar.getName();
            notifyDataSetChanged();
            if (this.jaL != null) {
                this.jaL.a(eVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void ckN() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jaK = 0;
            this.jaJ = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void ckO() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jaK = 1;
            this.jaJ = TbadkCoreApplication.getInst().getString(d.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        TextView hrb;
        TbImageView iWo;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
