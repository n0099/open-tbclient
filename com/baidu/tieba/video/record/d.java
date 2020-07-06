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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private List<e> mList;
    private String maS;
    private int maT = -1;
    private VideoEffectLayout.a maU;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.maS = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.maU = aVar;
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
    /* renamed from: Gg */
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
        aVar.lWt = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.lWt.setIsRound(true);
        aVar.lWt.setDrawerType(1);
        aVar.lWt.setDefaultBgResource(R.color.transparent);
        aVar.lWt.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(viewGroup.getContext(), R.dimen.ds4));
        aVar.lWt.setConrers(15);
        aVar.lWt.setBorderColor(an.getColor(R.color.cp_link_tip_a));
        aVar.khh = (TextView) view.findViewById(R.id.tv_name);
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
                    an.setViewTextColor(aVar2.khh, (int) R.color.cp_cont_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.lWt.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
                    aVar2.lWt.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    an.setViewTextColor(aVar2.khh, (int) R.color.cp_cont_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    an.setViewTextColor(aVar2.khh, (int) R.color.cp_cont_a);
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
                    aVar.lWt.startLoad(String.valueOf(eVar.dok()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.maS)) {
                        aVar.lWt.setDrawBorder(true);
                        break;
                    } else {
                        aVar.lWt.setDrawBorder(false);
                        break;
                    }
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.lWt.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.lWt.startLoad(String.valueOf(eVar.dok()), 24, false);
                    }
                    if (this.maT != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.lWt.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.maS)) {
                        aVar.lWt.setDrawBorder(true);
                        break;
                    } else {
                        aVar.lWt.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.maS)) {
                        aVar.lWt.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.lWt.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
            }
            aVar.lWt.setTag(eVar);
            aVar.lWt.setTag(R.id.record_video_effect_holder, aVar);
            aVar.lWt.setOnClickListener(this);
            aVar.khh.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                ao aoVar = new ao("c12423");
                aoVar.dk("obj_id", ((MusicData) eVar.getValue()).id);
                aoVar.ag("obj_locate", this.mList.indexOf(eVar) + 1);
                aoVar.ag("obj_source", 1);
                TiebaStatic.log(aoVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.maU != null) {
                    this.maU.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.maT = this.mList.indexOf(eVar);
                    this.maS = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.maS)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.maT = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.maT = this.mList.indexOf(eVar);
            }
            this.maS = eVar.getName();
            notifyDataSetChanged();
            if (this.maU != null) {
                this.maU.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void doi() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.maT = 0;
            this.maS = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void doj() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.maT = 1;
            this.maS = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        TextView khh;
        TbImageView lWt;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
