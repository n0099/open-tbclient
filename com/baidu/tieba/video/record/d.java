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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String jDt;
    private int jDu = -1;
    private VideoEffectLayout.a jDv;
    private List<e> mList;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.jDt = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.jDv = aVar;
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
    /* renamed from: Cs */
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
        aVar.jza = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.jza.setIsRound(true);
        aVar.jza.setDrawerType(1);
        aVar.jza.setDefaultBgResource(R.color.transparent);
        aVar.jza.setBorderWidth(com.baidu.adp.lib.util.l.g(viewGroup.getContext(), R.dimen.ds4));
        aVar.jza.setConrers(15);
        aVar.jza.setBorderColor(am.getColor(R.color.cp_link_tip_a));
        aVar.hRO = (TextView) view.findViewById(R.id.tv_name);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            a aVar2 = new a();
            switch (getItemViewType(i)) {
                case 0:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.mProgressBar.setVisibility(4);
                    am.j(aVar2.hRO, R.color.cp_cont_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.jza.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
                    aVar2.jza.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    am.j(aVar2.hRO, R.color.cp_cont_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    am.j(aVar2.hRO, R.color.cp_cont_a);
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
                    aVar.jza.startLoad(String.valueOf(eVar.cwS()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jDt)) {
                        aVar.jza.setDrawBorder(true);
                        break;
                    } else {
                        aVar.jza.setDrawBorder(false);
                        break;
                    }
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.jza.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.jza.startLoad(String.valueOf(eVar.cwS()), 24, false);
                    }
                    if (this.jDu != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.jza.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jDt)) {
                        aVar.jza.setDrawBorder(true);
                        break;
                    } else {
                        aVar.jza.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jDt)) {
                        aVar.jza.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.jza.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
            }
            aVar.jza.setTag(eVar);
            aVar.jza.setTag(R.id.record_video_effect_holder, aVar);
            aVar.jza.setOnClickListener(this);
            aVar.hRO.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                an anVar = new an("c12423");
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                anVar.P("obj_locate", this.mList.indexOf(eVar) + 1);
                anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(anVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.jDv != null) {
                    this.jDv.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.jDu = this.mList.indexOf(eVar);
                    this.jDt = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.jDt)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.jDu = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.jDu = this.mList.indexOf(eVar);
            }
            this.jDt = eVar.getName();
            notifyDataSetChanged();
            if (this.jDv != null) {
                this.jDv.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void cwQ() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jDu = 0;
            this.jDt = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cwR() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jDu = 1;
            this.jDt = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        TextView hRO;
        TbImageView jza;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
