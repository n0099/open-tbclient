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
    private String hgQ;
    private int hgR = -1;
    private VideoEffectLayout.a hgS;
    private List<e> mList;

    public void f(List<e> list, String str) {
        this.mList = list;
        this.hgQ = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.hgS = aVar;
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
    /* renamed from: uN */
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
        aVar.hcp = (TbImageView) view.findViewById(d.g.iv_effect);
        aVar.hcp.setIsRound(true);
        aVar.hcp.setDrawerType(1);
        aVar.hcp.setDefaultBgResource(d.C0142d.transparent);
        aVar.hcp.setBorderWidth(com.baidu.adp.lib.util.l.e(viewGroup.getContext(), d.e.ds4));
        aVar.hcp.setBorderColor(am.getColor(d.C0142d.cp_link_tip_a));
        aVar.fzO = (TextView) view.findViewById(d.g.tv_name);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            a aVar2 = new a();
            switch (getItemViewType(i)) {
                case 0:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.mProgressBar.setVisibility(4);
                    am.h(aVar2.fzO, d.C0142d.cp_cont_i);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(d.g.iv_loading);
                    aVar2.hcp.setDefaultErrorResource(d.f.bg_video_cloudmusic);
                    aVar2.hcp.setDefaultResource(d.f.bg_video_cloudmusic);
                    am.h(aVar2.fzO, d.C0142d.cp_cont_i);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    am.h(aVar2.fzO, d.C0142d.cp_cont_i);
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
                    aVar.hcp.startLoad(String.valueOf(eVar.bDz()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hgQ)) {
                        aVar.hcp.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hcp.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.hcp.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.hcp.startLoad(String.valueOf(eVar.bDz()), 24, false);
                    }
                    if (this.hgR != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.hcp.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hgQ)) {
                        aVar.hcp.setDrawBorder(true);
                        break;
                    } else {
                        aVar.hcp.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.hgQ)) {
                        aVar.hcp.setBackgroundResource(d.f.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.hcp.setBackgroundResource(d.f.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.hcp.setTag(eVar);
            aVar.hcp.setTag(d.g.record_video_effect_holder, aVar);
            aVar.hcp.setOnClickListener(this);
            aVar.fzO.setText(eVar.getName());
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
                anVar.ah(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                anVar.r("obj_locate", this.mList.indexOf(eVar) + 1);
                anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(anVar);
                if (view.getResources().getString(d.k.music_cloud).equals(eVar.getName()) && this.hgS != null) {
                    this.hgS.a(eVar, view.getTag(d.g.record_video_effect_holder));
                    this.hgR = this.mList.indexOf(eVar);
                    this.hgQ = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.hgQ)) {
                    if (!eVar.getName().equals(view.getResources().getString(d.k.music_cloud))) {
                        this.hgR = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.hgR = this.mList.indexOf(eVar);
            }
            this.hgQ = eVar.getName();
            notifyDataSetChanged();
            if (this.hgS != null) {
                this.hgS.a(eVar, view.getTag(d.g.record_video_effect_holder));
            }
        }
    }

    public void bDx() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hgR = 0;
            this.hgQ = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bDy() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.hgR = 1;
            this.hgQ = TbadkCoreApplication.getInst().getString(d.k.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fzO;
        TbImageView hcp;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
