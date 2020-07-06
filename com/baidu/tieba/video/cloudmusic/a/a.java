package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e dPR;
    private b lVA;
    private List<CloudMusicData.MusicTagList.MusicList> lVz = new ArrayList();

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dPR = eVar;
    }

    public void eZ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.lVz.contains(musicList)) {
                    this.lVz.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lVz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FY */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lVz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0751a c0751a;
        if (view == null) {
            view = LayoutInflater.from(this.dPR.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0751a = new C0751a();
            c0751a.lVD = (TbImageView) view.findViewById(R.id.music_state);
            c0751a.lVC = (TbImageView) view.findViewById(R.id.music_image);
            c0751a.lVC.setDrawerType(1);
            c0751a.lVC.setIsRound(true);
            c0751a.lVC.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0751a.lVC.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0751a.lVC.setDefaultBgResource(R.color.transparent);
            c0751a.lVC.setBorderWidth(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds4));
            c0751a.lVC.setBorderColor(an.getColor(R.color.cp_link_tip_a));
            c0751a.lVC.setConrers(15);
            c0751a.lVE = view.findViewById(R.id.music_loading);
            c0751a.lVF = (TextView) view.findViewById(R.id.music_title);
            c0751a.lVG = (TextView) view.findViewById(R.id.music_author_name);
            c0751a.lVH = (TextView) view.findViewById(R.id.music_duration);
            c0751a.lVI = (TextView) view.findViewById(R.id.music_choose);
            c0751a.gCZ = view.findViewById(R.id.line);
            view.setTag(c0751a);
        } else {
            c0751a = (C0751a) view.getTag();
        }
        c0751a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lVz.get(i);
        if (musicList != null) {
            c0751a.lVF.setText(musicList.name);
            c0751a.lVC.startLoad(musicList.image, 10, false);
            c0751a.lVG.setText(musicList.author);
            c0751a.lVH.setText(ar.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0751a.lVE.setVisibility(0);
            } else {
                c0751a.lVE.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dmD().dmE())) {
                c0751a.lVD.setImageResource(R.drawable.btn_icon_stop_video);
                c0751a.lVC.setDrawBorder(true);
                c0751a.lVI.setVisibility(0);
                c0751a.lVE.setVisibility(4);
                musicList.isLoading = false;
                c0751a.lVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lVA != null) {
                            a.this.lVA.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0751a.lVD.setImageResource(R.drawable.btn_icon_play_video_n);
                c0751a.lVC.setDrawBorder(false);
                c0751a.lVI.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lVA = bVar;
    }

    public void af(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0751a {
        private View gCZ;
        public TbImageView lVC;
        public TbImageView lVD;
        public View lVE;
        public TextView lVF;
        public TextView lVG;
        public TextView lVH;
        public TextView lVI;

        public void onChangeSkin(int i) {
            an.setViewTextColor(this.lVF, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.lVG, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.lVH, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.lVI, (int) R.color.common_color_10140);
            an.setBackgroundResource(this.lVI, R.drawable.bg_music_choose);
            an.setBackgroundColor(this.gCZ, R.color.cp_bg_line_c);
            an.setImageResource(this.lVD, R.drawable.btn_icon_play_video_n);
        }
    }
}
