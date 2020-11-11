package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eIz;
    private List<CloudMusicData.MusicTagList.MusicList> nmP = new ArrayList();
    private b nmQ;

    /* loaded from: classes23.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eIz = eVar;
    }

    public void fQ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nmP.contains(musicList)) {
                    this.nmP.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nmP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KF */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nmP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0858a c0858a;
        if (view == null) {
            view = LayoutInflater.from(this.eIz.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0858a = new C0858a();
            c0858a.nmT = (TbImageView) view.findViewById(R.id.music_state);
            c0858a.nmS = (TbImageView) view.findViewById(R.id.music_image);
            c0858a.nmS.setDrawerType(1);
            c0858a.nmS.setIsRound(true);
            c0858a.nmS.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0858a.nmS.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0858a.nmS.setDefaultBgResource(R.color.transparent);
            c0858a.nmS.setBorderWidth(l.getDimens(this.eIz.getPageActivity(), R.dimen.ds4));
            c0858a.nmS.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0858a.nmS.setConrers(15);
            c0858a.nmU = view.findViewById(R.id.music_loading);
            c0858a.nmV = (TextView) view.findViewById(R.id.music_title);
            c0858a.nmW = (TextView) view.findViewById(R.id.music_author_name);
            c0858a.nmX = (TextView) view.findViewById(R.id.music_duration);
            c0858a.nmY = (TextView) view.findViewById(R.id.music_choose);
            c0858a.hFD = view.findViewById(R.id.line);
            view.setTag(c0858a);
        } else {
            c0858a = (C0858a) view.getTag();
        }
        c0858a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nmP.get(i);
        if (musicList != null) {
            c0858a.nmV.setText(musicList.name);
            c0858a.nmS.startLoad(musicList.image, 10, false);
            c0858a.nmW.setText(musicList.author);
            c0858a.nmX.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0858a.nmU.setVisibility(0);
            } else {
                c0858a.nmU.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dOJ().dOK())) {
                c0858a.nmT.setImageResource(R.drawable.btn_icon_stop_video);
                c0858a.nmS.setDrawBorder(true);
                c0858a.nmY.setVisibility(0);
                c0858a.nmU.setVisibility(4);
                musicList.isLoading = false;
                c0858a.nmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nmQ != null) {
                            a.this.nmQ.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0858a.nmT.setImageResource(R.drawable.btn_icon_play_video_n);
                c0858a.nmS.setDrawBorder(false);
                c0858a.nmY.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nmQ = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0858a {
        private View hFD;
        public TbImageView nmS;
        public TbImageView nmT;
        public View nmU;
        public TextView nmV;
        public TextView nmW;
        public TextView nmX;
        public TextView nmY;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nmV, R.color.cp_cont_b);
            ap.setViewTextColor(this.nmW, R.color.cp_cont_j);
            ap.setViewTextColor(this.nmX, R.color.cp_cont_j);
            ap.setViewTextColor(this.nmY, R.color.common_color_10140);
            ap.setBackgroundResource(this.nmY, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hFD, R.color.cp_bg_line_c);
            ap.setImageResource(this.nmT, R.drawable.btn_icon_play_video_n);
        }
    }
}
