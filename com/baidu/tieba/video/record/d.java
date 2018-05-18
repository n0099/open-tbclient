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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String gRj;
    private int gRk = -1;
    private VideoEffectLayout.a gRl;
    private List<e> mList;

    public void f(List<e> list, String str) {
        this.mList = list;
        this.gRj = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.gRl = aVar;
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
    /* renamed from: us */
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

    private void a(a aVar, View view2, ViewGroup viewGroup) {
        aVar.gMI = (TbImageView) view2.findViewById(d.g.iv_effect);
        aVar.gMI.setIsRound(true);
        aVar.gMI.setDrawerType(1);
        aVar.gMI.setDefaultBgResource(d.C0126d.transparent);
        aVar.gMI.setBorderWidth(com.baidu.adp.lib.util.l.e(viewGroup.getContext(), d.e.ds4));
        aVar.gMI.setBorderColor(ak.getColor(d.C0126d.cp_link_tip_a));
        aVar.fks = (TextView) view2.findViewById(d.g.tv_name);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view2 == null) {
            a aVar2 = new a();
            switch (getItemViewType(i)) {
                case 0:
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_effect, (ViewGroup) null);
                    a(aVar2, view2, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view2.findViewById(d.g.iv_loading);
                    aVar2.mProgressBar.setVisibility(4);
                    ak.h(aVar2.fks, d.C0126d.cp_cont_i);
                    break;
                case 1:
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_effect, (ViewGroup) null);
                    a(aVar2, view2, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view2.findViewById(d.g.iv_loading);
                    aVar2.gMI.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.gMI.setDefaultResource(d.f.bg_video_cloudmusic);
                    ak.h(aVar2.fks, d.C0126d.cp_cont_i);
                    break;
                case 2:
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view2, viewGroup);
                    ak.h(aVar2.fks, d.C0126d.cp_cont_i);
                    break;
            }
            view2.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view2.getTag();
        }
        if (this.mList != null && i >= 0 && i <= this.mList.size() - 1 && (eVar = this.mList.get(i)) != null) {
            switch (getItemViewType(i)) {
                case 0:
                    aVar.gMI.startLoad(String.valueOf(eVar.bxT()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gRj)) {
                        aVar.gMI.setDrawBorder(true);
                        break;
                    } else {
                        aVar.gMI.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.gMI.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.gMI.startLoad(String.valueOf(eVar.bxT()), 24, false);
                    }
                    if (this.gRk != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.gMI.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gRj)) {
                        aVar.gMI.setDrawBorder(true);
                        break;
                    } else {
                        aVar.gMI.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.gRj)) {
                        aVar.gMI.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.gMI.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.gMI.setTag(eVar);
            aVar.gMI.setTag(d.g.record_video_effect_holder, aVar);
            aVar.gMI.setOnClickListener(this);
            aVar.fks.setText(eVar.getName());
            aVar.position = i;
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.iv_effect && (view2.getTag() instanceof e)) {
            e eVar = (e) view2.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                al alVar = new al("c12423");
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                alVar.r("obj_locate", this.mList.indexOf(eVar) + 1);
                alVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(alVar);
                if (view2.getResources().getString(d.k.music_cloud).equals(eVar.getName()) && this.gRl != null) {
                    this.gRl.a(eVar, view2.getTag(d.g.record_video_effect_holder));
                    this.gRk = this.mList.indexOf(eVar);
                    this.gRj = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.gRj)) {
                    if (!eVar.getName().equals(view2.getResources().getString(d.k.music_cloud))) {
                        this.gRk = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.gRk = this.mList.indexOf(eVar);
            }
            this.gRj = eVar.getName();
            notifyDataSetChanged();
            if (this.gRl != null) {
                this.gRl.a(eVar, view2.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bxR() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gRk = 0;
            this.gRj = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bxS() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.gRk = 1;
            this.gRj = TbadkCoreApplication.getInst().getString(d.k.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fks;
        TbImageView gMI;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
