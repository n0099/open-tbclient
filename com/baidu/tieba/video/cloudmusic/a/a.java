package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e cVC;
    private List<CloudMusicData.MusicTagList.MusicList> kvL = new ArrayList();
    private b kvM;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cVC = eVar;
    }

    public void eo(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.kvL.contains(musicList)) {
                    this.kvL.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kvL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dx */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.kvL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0618a c0618a;
        if (view == null) {
            view = LayoutInflater.from(this.cVC.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0618a = new C0618a();
            c0618a.kvP = (TbImageView) view.findViewById(R.id.music_state);
            c0618a.kvO = (TbImageView) view.findViewById(R.id.music_image);
            c0618a.kvO.setDrawerType(1);
            c0618a.kvO.setIsRound(true);
            c0618a.kvO.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0618a.kvO.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0618a.kvO.setDefaultBgResource(R.color.transparent);
            c0618a.kvO.setBorderWidth(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds4));
            c0618a.kvO.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0618a.kvQ = view.findViewById(R.id.music_loading);
            c0618a.kvR = (TextView) view.findViewById(R.id.music_title);
            c0618a.kvS = (TextView) view.findViewById(R.id.music_author_name);
            c0618a.kvT = (TextView) view.findViewById(R.id.music_duration);
            c0618a.kvU = (TextView) view.findViewById(R.id.music_choose);
            c0618a.fvG = view.findViewById(R.id.line);
            view.setTag(c0618a);
        } else {
            c0618a = (C0618a) view.getTag();
        }
        c0618a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.kvL.get(i);
        if (musicList != null) {
            c0618a.kvR.setText(musicList.name);
            c0618a.kvO.startLoad(musicList.image, 10, false);
            c0618a.kvS.setText(musicList.author);
            c0618a.kvT.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0618a.kvQ.setVisibility(0);
            } else {
                c0618a.kvQ.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cPu().cPv())) {
                c0618a.kvP.setImageResource(R.drawable.btn_icon_stop_video);
                c0618a.kvO.setDrawBorder(true);
                c0618a.kvU.setVisibility(0);
                c0618a.kvQ.setVisibility(4);
                musicList.isLoading = false;
                c0618a.kvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.kvM != null) {
                            a.this.kvM.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0618a.kvP.setImageResource(R.drawable.btn_icon_play_video_n);
                c0618a.kvO.setDrawBorder(false);
                c0618a.kvU.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.kvM = bVar;
    }

    public void S(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0618a {
        private View fvG;
        public TbImageView kvO;
        public TbImageView kvP;
        public View kvQ;
        public TextView kvR;
        public TextView kvS;
        public TextView kvT;
        public TextView kvU;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.kvR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kvS, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kvT, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kvU, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.kvU, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.fvG, R.color.cp_bg_line_c);
            am.setImageResource(this.kvP, R.drawable.btn_icon_play_video_n);
        }
    }
}
