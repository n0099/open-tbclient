package com.baidu.tieba.video.record;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String lnb;
    private int lnc = -1;
    private VideoEffectLayout.a lnd;
    private List<e> mList;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.lnb = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.lnd = aVar;
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
    /* renamed from: Eq */
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
        aVar.liJ = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.liJ.setIsRound(true);
        aVar.liJ.setDrawerType(1);
        aVar.liJ.setDefaultBgResource(R.color.transparent);
        aVar.liJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(viewGroup.getContext(), R.dimen.ds4));
        aVar.liJ.setConrers(15);
        aVar.liJ.setBorderColor(am.getColor(R.color.cp_link_tip_a));
        aVar.jvl = (TextView) view.findViewById(R.id.tv_name);
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
                    am.setViewTextColor(aVar2.jvl, (int) R.color.cp_cont_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.liJ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
                    aVar2.liJ.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    am.setViewTextColor(aVar2.jvl, (int) R.color.cp_cont_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    am.setViewTextColor(aVar2.jvl, (int) R.color.cp_cont_a);
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
                    aVar.liJ.startLoad(String.valueOf(eVar.dct()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.lnb)) {
                        aVar.liJ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.liJ.setDrawBorder(false);
                        break;
                    }
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.liJ.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.liJ.startLoad(String.valueOf(eVar.dct()), 24, false);
                    }
                    if (this.lnc != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.liJ.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.lnb)) {
                        aVar.liJ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.liJ.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.lnb)) {
                        aVar.liJ.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.liJ.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
            }
            aVar.liJ.setTag(eVar);
            aVar.liJ.setTag(R.id.record_video_effect_holder, aVar);
            aVar.liJ.setOnClickListener(this);
            aVar.jvl.setText(eVar.getName());
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
                anVar.cI("obj_id", ((MusicData) eVar.getValue()).id);
                anVar.af("obj_locate", this.mList.indexOf(eVar) + 1);
                anVar.af("obj_source", 1);
                TiebaStatic.log(anVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.lnd != null) {
                    this.lnd.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.lnc = this.mList.indexOf(eVar);
                    this.lnb = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.lnb)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.lnc = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.lnc = this.mList.indexOf(eVar);
            }
            this.lnb = eVar.getName();
            notifyDataSetChanged();
            if (this.lnd != null) {
                this.lnd.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void dcr() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.lnc = 0;
            this.lnb = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dcs() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.lnc = 1;
            this.lnb = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        TextView jvl;
        TbImageView liJ;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
