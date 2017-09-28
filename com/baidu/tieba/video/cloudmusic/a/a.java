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
    private List<CloudMusicData.MusicTagList.MusicList> guA = new ArrayList();
    private b guB;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dy(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.guA.contains(musicList)) {
                    this.guA.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.guA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uv */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.guA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.j.cloud_music_item, viewGroup, false);
            c0129a = new C0129a();
            c0129a.guE = (TbImageView) view.findViewById(d.h.music_state);
            c0129a.guD = (TbImageView) view.findViewById(d.h.music_image);
            c0129a.guD.setDrawerType(1);
            c0129a.guD.setIsRound(true);
            c0129a.guD.setDefaultErrorResource(d.g.bg_video_cloudmusic);
            c0129a.guD.setDefaultResource(d.g.bg_video_cloudmusic);
            c0129a.guD.setDefaultBgResource(d.e.transparent);
            c0129a.guD.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.f.ds4));
            c0129a.guD.setBorderColor(aj.getColor(d.e.cp_link_tip_a));
            c0129a.guF = view.findViewById(d.h.music_loading);
            c0129a.guG = (TextView) view.findViewById(d.h.music_title);
            c0129a.guH = (TextView) view.findViewById(d.h.music_author_name);
            c0129a.guI = (TextView) view.findViewById(d.h.music_duration);
            c0129a.guJ = (TextView) view.findViewById(d.h.music_choose);
            c0129a.cLr = view.findViewById(d.h.line);
            view.setTag(c0129a);
        } else {
            c0129a = (C0129a) view.getTag();
        }
        c0129a.dE(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.guA.get(i);
        if (musicList != null) {
            c0129a.guG.setText(musicList.name);
            c0129a.guD.c(musicList.image, 10, false);
            c0129a.guH.setText(musicList.author);
            c0129a.guI.setText(am.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0129a.guF.setVisibility(0);
            } else {
                c0129a.guF.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bvC().bvD())) {
                c0129a.guE.setImageResource(d.g.btn_icon_stop_video);
                c0129a.guD.setDrawBorder(true);
                c0129a.guJ.setVisibility(0);
                c0129a.guF.setVisibility(4);
                musicList.isLoading = false;
                c0129a.guJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.guB != null) {
                            a.this.guB.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0129a.guE.setImageResource(d.g.btn_icon_play_video_n);
                c0129a.guD.setDrawBorder(false);
                c0129a.guJ.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.guB = bVar;
    }

    public void C(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0129a {
        private View cLr;
        public TbImageView guD;
        public TbImageView guE;
        public View guF;
        public TextView guG;
        public TextView guH;
        public TextView guI;
        public TextView guJ;

        public void dE(int i) {
            aj.i(this.guG, d.e.cp_cont_b);
            aj.i(this.guH, d.e.cp_cont_j);
            aj.i(this.guI, d.e.cp_cont_j);
            aj.i(this.guJ, d.e.common_color_10140);
            aj.j(this.guJ, d.g.bg_music_choose);
            aj.k(this.cLr, d.e.cp_bg_line_c);
            aj.c(this.guE, d.g.btn_icon_play_video_n);
        }
    }
}
