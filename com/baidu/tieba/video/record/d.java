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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes17.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String mAk;
    private int mAl = -1;
    private VideoEffectLayout.a mAm;
    private List<e> mList;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.mAk = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.mAm = aVar;
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
    /* renamed from: IY */
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
        aVar.mvO = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.mvO.setIsRound(true);
        aVar.mvO.setDrawerType(1);
        aVar.mvO.setDefaultBgResource(R.color.transparent);
        aVar.mvO.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(viewGroup.getContext(), R.dimen.ds4));
        aVar.mvO.setConrers(15);
        aVar.mvO.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
        aVar.kFy = (TextView) view.findViewById(R.id.tv_name);
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
                    ap.setViewTextColor(aVar2.kFy, R.color.cp_cont_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.mvO.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
                    aVar2.mvO.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    ap.setViewTextColor(aVar2.kFy, R.color.cp_cont_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    ap.setViewTextColor(aVar2.kFy, R.color.cp_cont_a);
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
                    aVar.mvO.startLoad(String.valueOf(eVar.dCY()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.mAk)) {
                        aVar.mvO.setDrawBorder(true);
                        break;
                    } else {
                        aVar.mvO.setDrawBorder(false);
                        break;
                    }
                    break;
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.mvO.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.mvO.startLoad(String.valueOf(eVar.dCY()), 24, false);
                    }
                    if (this.mAl != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.mvO.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.mAk)) {
                        aVar.mvO.setDrawBorder(true);
                        break;
                    } else {
                        aVar.mvO.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.mAk)) {
                        aVar.mvO.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.mvO.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
                    break;
            }
            aVar.mvO.setTag(eVar);
            aVar.mvO.setTag(R.id.record_video_effect_holder, aVar);
            aVar.mvO.setOnClickListener(this);
            aVar.kFy.setText(eVar.getName());
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
                aqVar.dD("obj_id", ((MusicData) eVar.getValue()).id);
                aqVar.ai("obj_locate", this.mList.indexOf(eVar) + 1);
                aqVar.ai("obj_source", 1);
                TiebaStatic.log(aqVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.mAm != null) {
                    this.mAm.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.mAl = this.mList.indexOf(eVar);
                    this.mAk = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.mAk)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.mAl = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.mAl = this.mList.indexOf(eVar);
            }
            this.mAk = eVar.getName();
            notifyDataSetChanged();
            if (this.mAm != null) {
                this.mAm.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void dCW() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.mAl = 0;
            this.mAk = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dCX() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.mAl = 1;
            this.mAk = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a {
        TextView kFy;
        ProgressBar mProgressBar;
        TbImageView mvO;
        int position;

        a() {
        }
    }
}
