package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> hoU = new ArrayList();
    private b hoV;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dH(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hoU.contains(musicList)) {
                    this.hoU.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hoU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wJ */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hoU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0239a c0239a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0239a = new C0239a();
            c0239a.hoY = (TbImageView) view.findViewById(d.g.music_state);
            c0239a.hoX = (TbImageView) view.findViewById(d.g.music_image);
            c0239a.hoX.setDrawerType(1);
            c0239a.hoX.setIsRound(true);
            c0239a.hoX.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0239a.hoX.setDefaultResource(d.f.bg_video_cloudmusic);
            c0239a.hoX.setDefaultBgResource(d.C0140d.transparent);
            c0239a.hoX.setBorderWidth(l.t(this.mPageContext.getPageActivity(), d.e.ds4));
            c0239a.hoX.setBorderColor(aj.getColor(d.C0140d.cp_link_tip_a));
            c0239a.hoZ = view.findViewById(d.g.music_loading);
            c0239a.hpa = (TextView) view.findViewById(d.g.music_title);
            c0239a.hpb = (TextView) view.findViewById(d.g.music_author_name);
            c0239a.hpc = (TextView) view.findViewById(d.g.music_duration);
            c0239a.hpd = (TextView) view.findViewById(d.g.music_choose);
            c0239a.eqX = view.findViewById(d.g.line);
            view.setTag(c0239a);
        } else {
            c0239a = (C0239a) view.getTag();
        }
        c0239a.gB(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hoU.get(i);
        if (musicList != null) {
            c0239a.hpa.setText(musicList.name);
            c0239a.hoX.startLoad(musicList.image, 10, false);
            c0239a.hpb.setText(musicList.author);
            c0239a.hpc.setText(am.fV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0239a.hoZ.setVisibility(0);
            } else {
                c0239a.hoZ.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAY().bAZ())) {
                c0239a.hoY.setImageResource(d.f.btn_icon_stop_video);
                c0239a.hoX.setDrawBorder(true);
                c0239a.hpd.setVisibility(0);
                c0239a.hoZ.setVisibility(4);
                musicList.isLoading = false;
                c0239a.hpd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hoV != null) {
                            a.this.hoV.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0239a.hoY.setImageResource(d.f.btn_icon_play_video_n);
                c0239a.hoX.setDrawBorder(false);
                c0239a.hpd.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hoV = bVar;
    }

    public void U(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0239a {
        private View eqX;
        public TbImageView hoX;
        public TbImageView hoY;
        public View hoZ;
        public TextView hpa;
        public TextView hpb;
        public TextView hpc;
        public TextView hpd;

        public void gB(int i) {
            aj.r(this.hpa, d.C0140d.cp_cont_b);
            aj.r(this.hpb, d.C0140d.cp_cont_j);
            aj.r(this.hpc, d.C0140d.cp_cont_j);
            aj.r(this.hpd, d.C0140d.common_color_10140);
            aj.s(this.hpd, d.f.bg_music_choose);
            aj.t(this.eqX, d.C0140d.cp_bg_line_c);
            aj.c(this.hoY, d.f.btn_icon_play_video_n);
        }
    }
}
