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
    private e cVD;
    private List<CloudMusicData.MusicTagList.MusicList> kvN = new ArrayList();
    private b kvO;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cVD = eVar;
    }

    public void eo(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.kvN.contains(musicList)) {
                    this.kvN.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kvN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dx */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.kvN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0618a c0618a;
        if (view == null) {
            view = LayoutInflater.from(this.cVD.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0618a = new C0618a();
            c0618a.kvR = (TbImageView) view.findViewById(R.id.music_state);
            c0618a.kvQ = (TbImageView) view.findViewById(R.id.music_image);
            c0618a.kvQ.setDrawerType(1);
            c0618a.kvQ.setIsRound(true);
            c0618a.kvQ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0618a.kvQ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0618a.kvQ.setDefaultBgResource(R.color.transparent);
            c0618a.kvQ.setBorderWidth(l.getDimens(this.cVD.getPageActivity(), R.dimen.ds4));
            c0618a.kvQ.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0618a.kvS = view.findViewById(R.id.music_loading);
            c0618a.kvT = (TextView) view.findViewById(R.id.music_title);
            c0618a.kvU = (TextView) view.findViewById(R.id.music_author_name);
            c0618a.kvV = (TextView) view.findViewById(R.id.music_duration);
            c0618a.kvW = (TextView) view.findViewById(R.id.music_choose);
            c0618a.fvH = view.findViewById(R.id.line);
            view.setTag(c0618a);
        } else {
            c0618a = (C0618a) view.getTag();
        }
        c0618a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.kvN.get(i);
        if (musicList != null) {
            c0618a.kvT.setText(musicList.name);
            c0618a.kvQ.startLoad(musicList.image, 10, false);
            c0618a.kvU.setText(musicList.author);
            c0618a.kvV.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0618a.kvS.setVisibility(0);
            } else {
                c0618a.kvS.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cPw().cPx())) {
                c0618a.kvR.setImageResource(R.drawable.btn_icon_stop_video);
                c0618a.kvQ.setDrawBorder(true);
                c0618a.kvW.setVisibility(0);
                c0618a.kvS.setVisibility(4);
                musicList.isLoading = false;
                c0618a.kvW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.kvO != null) {
                            a.this.kvO.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0618a.kvR.setImageResource(R.drawable.btn_icon_play_video_n);
                c0618a.kvQ.setDrawBorder(false);
                c0618a.kvW.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.kvO = bVar;
    }

    public void S(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0618a {
        private View fvH;
        public TbImageView kvQ;
        public TbImageView kvR;
        public View kvS;
        public TextView kvT;
        public TextView kvU;
        public TextView kvV;
        public TextView kvW;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.kvT, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kvU, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kvV, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kvW, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.kvW, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.fvH, R.color.cp_bg_line_c);
            am.setImageResource(this.kvR, R.drawable.btn_icon_play_video_n);
        }
    }
}
