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
    private List<CloudMusicData.MusicTagList.MusicList> lVw = new ArrayList();
    private b lVx;

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
                if (!this.lVw.contains(musicList)) {
                    this.lVw.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lVw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FY */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lVw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0750a c0750a;
        if (view == null) {
            view = LayoutInflater.from(this.dPR.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0750a = new C0750a();
            c0750a.lVA = (TbImageView) view.findViewById(R.id.music_state);
            c0750a.lVz = (TbImageView) view.findViewById(R.id.music_image);
            c0750a.lVz.setDrawerType(1);
            c0750a.lVz.setIsRound(true);
            c0750a.lVz.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0750a.lVz.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0750a.lVz.setDefaultBgResource(R.color.transparent);
            c0750a.lVz.setBorderWidth(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds4));
            c0750a.lVz.setBorderColor(an.getColor(R.color.cp_link_tip_a));
            c0750a.lVz.setConrers(15);
            c0750a.lVB = view.findViewById(R.id.music_loading);
            c0750a.lVC = (TextView) view.findViewById(R.id.music_title);
            c0750a.lVD = (TextView) view.findViewById(R.id.music_author_name);
            c0750a.lVE = (TextView) view.findViewById(R.id.music_duration);
            c0750a.lVF = (TextView) view.findViewById(R.id.music_choose);
            c0750a.gCZ = view.findViewById(R.id.line);
            view.setTag(c0750a);
        } else {
            c0750a = (C0750a) view.getTag();
        }
        c0750a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lVw.get(i);
        if (musicList != null) {
            c0750a.lVC.setText(musicList.name);
            c0750a.lVz.startLoad(musicList.image, 10, false);
            c0750a.lVD.setText(musicList.author);
            c0750a.lVE.setText(ar.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0750a.lVB.setVisibility(0);
            } else {
                c0750a.lVB.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dmz().dmA())) {
                c0750a.lVA.setImageResource(R.drawable.btn_icon_stop_video);
                c0750a.lVz.setDrawBorder(true);
                c0750a.lVF.setVisibility(0);
                c0750a.lVB.setVisibility(4);
                musicList.isLoading = false;
                c0750a.lVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lVx != null) {
                            a.this.lVx.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0750a.lVA.setImageResource(R.drawable.btn_icon_play_video_n);
                c0750a.lVz.setDrawBorder(false);
                c0750a.lVF.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lVx = bVar;
    }

    public void af(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0750a {
        private View gCZ;
        public TbImageView lVA;
        public View lVB;
        public TextView lVC;
        public TextView lVD;
        public TextView lVE;
        public TextView lVF;
        public TbImageView lVz;

        public void onChangeSkin(int i) {
            an.setViewTextColor(this.lVC, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.lVD, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.lVE, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.lVF, (int) R.color.common_color_10140);
            an.setBackgroundResource(this.lVF, R.drawable.bg_music_choose);
            an.setBackgroundColor(this.gCZ, R.color.cp_bg_line_c);
            an.setImageResource(this.lVA, R.drawable.btn_icon_play_video_n);
        }
    }
}
