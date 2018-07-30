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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String hif;
    private int hig = -1;
    private VideoEffectLayout.a hih;
    private List<e> mList;

    public void f(List<e> list, String str) {
        this.mList = list;
        this.hif = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.hih = aVar;
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
    /* renamed from: uM */
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
        aVar.hdB = (TbImageView) view.findViewById(d.g.iv_effect);
        aVar.hdB.setIsRound(true);
        aVar.hdB.setDrawerType(1);
        aVar.hdB.setDefaultBgResource(d.C0140d.transparent);
        aVar.hdB.setBorderWidth(com.baidu.adp.lib.util.l.f(viewGroup.getContext(), d.e.ds4));
        aVar.hdB.setBorderColor(am.getColor(d.C0140d.cp_link_tip_a));
        aVar.fAa = (TextView) view.findViewById(d.g.tv_name);
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
                    am.h(aVar2.fAa, d.C0140d.cp_cont_i);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.hdB.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.hdB.setDefaultResource(d.f.bg_video_cloudmusic);
                    am.h(aVar2.fAa, d.C0140d.cp_cont_i);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    am.h(aVar2.fAa, d.C0140d.cp_cont_i);
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
                    aVar.hdB.startLoad(String.valueOf(eVar.bCk()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hif)) {
                        aVar.hdB.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hdB.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.hdB.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.hdB.startLoad(String.valueOf(eVar.bCk()), 24, false);
                    }
                    if (this.hig != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.hdB.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hif)) {
                        aVar.hdB.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hdB.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hif)) {
                        aVar.hdB.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.hdB.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.hdB.setTag(eVar);
            aVar.hdB.setTag(d.g.record_video_effect_holder, aVar);
            aVar.hdB.setOnClickListener(this);
            aVar.fAa.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                an anVar = new an("c12423");
                anVar.af(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                anVar.r("obj_locate", this.mList.indexOf(eVar) + 1);
                anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(anVar);
                if (view.getResources().getString(d.j.music_cloud).equals(eVar.getName()) && this.hih != null) {
                    this.hih.a(eVar, view.getTag(d.g.record_video_effect_holder));
                    this.hig = this.mList.indexOf(eVar);
                    this.hif = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.hif)) {
                    if (!eVar.getName().equals(view.getResources().getString(d.j.music_cloud))) {
                        this.hig = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.hig = this.mList.indexOf(eVar);
            }
            this.hif = eVar.getName();
            notifyDataSetChanged();
            if (this.hih != null) {
                this.hih.a(eVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bCi() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hig = 0;
            this.hif = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCj() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hig = 1;
            this.hif = TbadkCoreApplication.getInst().getString(d.j.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fAa;
        TbImageView hdB;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
