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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> hbw = new ArrayList();
    private b hbx;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dJ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hbw.contains(musicList)) {
                    this.hbw.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hbw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uG */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hbw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0240a c0240a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.cloud_music_item, viewGroup, false);
            c0240a = new C0240a();
            c0240a.hbA = (TbImageView) view.findViewById(d.g.music_state);
            c0240a.hbz = (TbImageView) view.findViewById(d.g.music_image);
            c0240a.hbz.setDrawerType(1);
            c0240a.hbz.setIsRound(true);
            c0240a.hbz.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0240a.hbz.setDefaultResource(d.f.bg_video_cloudmusic);
            c0240a.hbz.setDefaultBgResource(d.C0142d.transparent);
            c0240a.hbz.setBorderWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds4));
            c0240a.hbz.setBorderColor(am.getColor(d.C0142d.cp_link_tip_a));
            c0240a.hbB = view.findViewById(d.g.music_loading);
            c0240a.hbC = (TextView) view.findViewById(d.g.music_title);
            c0240a.hbD = (TextView) view.findViewById(d.g.music_author_name);
            c0240a.hbE = (TextView) view.findViewById(d.g.music_duration);
            c0240a.hbF = (TextView) view.findViewById(d.g.music_choose);
            c0240a.ebW = view.findViewById(d.g.line);
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        c0240a.dD(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hbw.get(i);
        if (musicList != null) {
            c0240a.hbC.setText(musicList.name);
            c0240a.hbz.startLoad(musicList.image, 10, false);
            c0240a.hbD.setText(musicList.author);
            c0240a.hbE.setText(ap.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0240a.hbB.setVisibility(0);
            } else {
                c0240a.hbB.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bBM().bBN())) {
                c0240a.hbA.setImageResource(d.f.btn_icon_stop_video);
                c0240a.hbz.setDrawBorder(true);
                c0240a.hbF.setVisibility(0);
                c0240a.hbB.setVisibility(4);
                musicList.isLoading = false;
                c0240a.hbF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hbx != null) {
                            a.this.hbx.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0240a.hbA.setImageResource(d.f.btn_icon_play_video_n);
                c0240a.hbz.setDrawBorder(false);
                c0240a.hbF.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hbx = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0240a {
        private View ebW;
        public TbImageView hbA;
        public View hbB;
        public TextView hbC;
        public TextView hbD;
        public TextView hbE;
        public TextView hbF;
        public TbImageView hbz;

        public void dD(int i) {
            am.h(this.hbC, d.C0142d.cp_cont_b);
            am.h(this.hbD, d.C0142d.cp_cont_j);
            am.h(this.hbE, d.C0142d.cp_cont_j);
            am.h(this.hbF, d.C0142d.common_color_10140);
            am.i(this.hbF, d.f.bg_music_choose);
            am.j(this.ebW, d.C0142d.cp_bg_line_c);
            am.c(this.hbA, d.f.btn_icon_play_video_n);
        }
    }
}
