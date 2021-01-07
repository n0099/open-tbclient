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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private List<e> mList;
    private String nKF;
    private int nKG = -1;
    private VideoEffectLayout.a nKH;

    public void c(List<e> list, String str) {
        this.mList = list;
        this.nKF = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.nKH = aVar;
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
    /* renamed from: LV */
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
        aVar.nGZ = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.nGZ.setIsRound(true);
        aVar.nGZ.setDrawerType(1);
        aVar.nGZ.setDefaultBgResource(R.color.transparent);
        aVar.nGZ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(viewGroup.getContext(), R.dimen.ds4));
        aVar.nGZ.setConrers(15);
        aVar.nGZ.setBorderColor(ao.getColor(R.color.CAM_X0302));
        aVar.lPc = (TextView) view.findViewById(R.id.tv_name);
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
                    ao.setViewTextColor(aVar2.lPc, R.color.CAM_X0101);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.nGZ.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    ao.setViewTextColor(aVar2.lPc, R.color.CAM_X0101);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    ao.setViewTextColor(aVar2.lPc, R.color.CAM_X0101);
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
                    aVar.nGZ.startLoad(String.valueOf(eVar.dVl()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nKF)) {
                        aVar.nGZ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.nGZ.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.nGZ.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.nGZ.startLoad(String.valueOf(eVar.dVl()), 24, false);
                    }
                    if (this.nKG != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.nGZ.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nKF)) {
                        aVar.nGZ.setDrawBorder(true);
                        break;
                    } else {
                        aVar.nGZ.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nKF)) {
                        aVar.nGZ.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.nGZ.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.nGZ.setTag(eVar);
            aVar.nGZ.setTag(R.id.record_video_effect_holder, aVar);
            aVar.nGZ.setOnClickListener(this);
            aVar.lPc.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                aq aqVar = new aq("c12423");
                aqVar.dX("obj_id", ((MusicData) eVar.getValue()).id);
                aqVar.an("obj_locate", this.mList.indexOf(eVar) + 1);
                aqVar.an("obj_source", 1);
                TiebaStatic.log(aqVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.nKH != null) {
                    this.nKH.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.nKG = this.mList.indexOf(eVar);
                    this.nKF = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.nKF)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.nKG = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.nKG = this.mList.indexOf(eVar);
            }
            this.nKF = eVar.getName();
            notifyDataSetChanged();
            if (this.nKH != null) {
                this.nKH.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void dVj() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.nKG = 0;
            this.nKF = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dVk() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.nKG = 1;
            this.nKF = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        TextView lPc;
        ProgressBar mProgressBar;
        TbImageView nGZ;
        int position;

        a() {
        }
    }
}
