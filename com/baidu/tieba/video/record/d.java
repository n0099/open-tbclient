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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private String jtI;
    private int jtJ = -1;
    private VideoEffectLayout.a jtK;
    private List<e> mList;

    public void b(List<e> list, String str) {
        this.mList = list;
        this.jtI = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.jtK = aVar;
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
    /* renamed from: BF */
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
        aVar.jpq = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.jpq.setIsRound(true);
        aVar.jpq.setDrawerType(1);
        aVar.jpq.setDefaultBgResource(R.color.transparent);
        aVar.jpq.setBorderWidth(com.baidu.adp.lib.util.l.g(viewGroup.getContext(), R.dimen.ds4));
        aVar.jpq.setConrers(15);
        aVar.jpq.setBorderColor(al.getColor(R.color.cp_link_tip_a));
        aVar.hIJ = (TextView) view.findViewById(R.id.tv_name);
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
                    al.j(aVar2.hIJ, R.color.cp_btn_a);
                    break;
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    aVar2.mProgressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar2.jpq.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
                    aVar2.jpq.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    al.j(aVar2.hIJ, R.color.cp_btn_a);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    a(aVar2, view, viewGroup);
                    al.j(aVar2.hIJ, R.color.cp_btn_a);
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
                    aVar.jpq.startLoad(String.valueOf(eVar.csT()), 24, false);
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jtI)) {
                        aVar.jpq.setDrawBorder(true);
                        break;
                    } else {
                        aVar.jpq.setDrawBorder(false);
                        break;
                    }
                case 1:
                    MusicData musicData = (MusicData) eVar.getValue();
                    if (musicData.editMusicType == 0) {
                        aVar.jpq.startLoad(musicData.img, 10, false);
                    } else {
                        aVar.jpq.startLoad(String.valueOf(eVar.csT()), 24, false);
                    }
                    if (this.jtJ != i) {
                        aVar.mProgressBar.setVisibility(4);
                    } else if (aVar.mProgressBar.getVisibility() == 0) {
                        aVar.jpq.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jtI)) {
                        aVar.jpq.setDrawBorder(true);
                        break;
                    } else {
                        aVar.jpq.setDrawBorder(false);
                        break;
                    }
                    break;
                case 2:
                    if (!TextUtils.isEmpty(eVar.getName()) && eVar.getName().equals(this.jtI)) {
                        aVar.jpq.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                        break;
                    } else {
                        aVar.jpq.setBackgroundResource(R.drawable.bg_beauty_item);
                        break;
                    }
            }
            aVar.jpq.setTag(eVar);
            aVar.jpq.setTag(R.id.record_video_effect_holder, aVar);
            aVar.jpq.setOnClickListener(this);
            aVar.hIJ.setText(eVar.getName());
            aVar.position = i;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.getType() == 3 && (eVar.getValue() instanceof MusicData)) {
                am amVar = new am("c12423");
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, ((MusicData) eVar.getValue()).id);
                amVar.P("obj_locate", this.mList.indexOf(eVar) + 1);
                amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                TiebaStatic.log(amVar);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.getName()) && this.jtK != null) {
                    this.jtK.a(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.jtJ = this.mList.indexOf(eVar);
                    this.jtI = eVar.getName();
                }
                if (TextUtils.isEmpty(eVar.getName()) || !eVar.getName().equals(this.jtI)) {
                    if (!eVar.getName().equals(view.getResources().getString(R.string.music_cloud))) {
                        this.jtJ = this.mList.indexOf(eVar);
                    }
                } else {
                    return;
                }
            } else {
                this.jtJ = this.mList.indexOf(eVar);
            }
            this.jtI = eVar.getName();
            notifyDataSetChanged();
            if (this.jtK != null) {
                this.jtK.a(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }

    public void csR() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jtJ = 0;
            this.jtI = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void csS() {
        if (getItem(0) != null && getItem(0).getType() == 3) {
            this.jtJ = 1;
            this.jtI = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        TextView hIJ;
        TbImageView jpq;
        ProgressBar mProgressBar;
        int position;

        a() {
        }
    }
}
