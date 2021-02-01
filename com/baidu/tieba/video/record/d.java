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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private List<e> mList;
    private String nPK;
    private int nPL = -1;
    private VideoEffectLayout.a nPM;

    public void setData(List<e> list, String str) {
        this.mList = list;
        this.nPK = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.nPM = aVar;
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
    /* renamed from: KI */
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
        aVar.nMf = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.nMf.setIsRound(true);
        aVar.nMf.setDrawerType(1);
        aVar.nMf.setDefaultBgResource(R.color.transparent);
        aVar.nMf.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(viewGroup.getContext(), R.dimen.ds4));
        aVar.nMf.setConrers(15);
        aVar.nMf.setBorderColor(ap.getColor(R.color.CAM_X0302));
        aVar.lTu = (TextView) view.findViewById(R.id.tv_name);
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
                    ap.setViewTextColor(aVar2.lTu, R.color.CAM_X0101);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.nMf.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    ap.setViewTextColor(aVar2.lTu, R.color.CAM_X0101);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    ap.setViewTextColor(aVar2.lTu, R.color.CAM_X0101);
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
                    aVar.nMf.startLoad(String.valueOf(eVar.dTE()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nPK)) {
                        aVar.nMf.setDrawBorder(true);
                        break;
                    } else {
                        aVar.nMf.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.nMf.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.nMf.startLoad(String.valueOf(eVar.dTE()), 24, false);
                    }
                    if (this.nPL != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.nMf.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nPK)) {
                        aVar.nMf.setDrawBorder(true);
                        break;
                    } else {
                        aVar.nMf.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.nPK)) {
                        aVar.nMf.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.nMf.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.nMf.setTag(eVar);
            aVar.nMf.setTag(R.id.record_video_effect_holder, aVar);
            aVar.nMf.setOnClickListener(this);
            aVar.lTu.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                ar arVar = new ar("c12423");
                arVar.dR("obj_id", ((MusicData) eVar.getValue()).id);
                arVar.ap("obj_locate", this.mList.indexOf(eVar) + 1);
                arVar.ap("obj_source", 1);
                TiebaStatic.log(arVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.nPM != null) {
                    this.nPM.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.nPL = this.mList.indexOf(eVar);
                    this.nPK = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.nPK)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.nPL = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.nPL = this.mList.indexOf(eVar);
            }
            this.nPK = eVar.getName();
            notifyDataSetChanged();
            if (this.nPM != null) {
                this.nPM.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void dTC() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.nPL = 0;
            this.nPK = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dTD() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.nPL = 1;
            this.nPK = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        TextView lTu;
        ProgressBar mProgressBar;
        TbImageView nMf;
        int position;

        a() {
        }
    }
}
