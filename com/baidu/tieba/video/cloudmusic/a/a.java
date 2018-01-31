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
    private List<CloudMusicData.MusicTagList.MusicList> hnF = new ArrayList();
    private b hnG;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dB(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hnF.contains(musicList)) {
                    this.hnF.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hnF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wK */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hnF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0158a c0158a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0158a = new C0158a();
            c0158a.hnJ = (TbImageView) view.findViewById(d.g.music_state);
            c0158a.hnI = (TbImageView) view.findViewById(d.g.music_image);
            c0158a.hnI.setDrawerType(1);
            c0158a.hnI.setIsRound(true);
            c0158a.hnI.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0158a.hnI.setDefaultResource(d.f.bg_video_cloudmusic);
            c0158a.hnI.setDefaultBgResource(d.C0108d.transparent);
            c0158a.hnI.setBorderWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds4));
            c0158a.hnI.setBorderColor(aj.getColor(d.C0108d.cp_link_tip_a));
            c0158a.hnK = view.findViewById(d.g.music_loading);
            c0158a.hnL = (TextView) view.findViewById(d.g.music_title);
            c0158a.hnM = (TextView) view.findViewById(d.g.music_author_name);
            c0158a.hnN = (TextView) view.findViewById(d.g.music_duration);
            c0158a.hnO = (TextView) view.findViewById(d.g.music_choose);
            c0158a.emK = view.findViewById(d.g.line);
            view.setTag(c0158a);
        } else {
            c0158a = (C0158a) view.getTag();
        }
        c0158a.gz(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hnF.get(i);
        if (musicList != null) {
            c0158a.hnL.setText(musicList.name);
            c0158a.hnI.startLoad(musicList.image, 10, false);
            c0158a.hnM.setText(musicList.author);
            c0158a.hnN.setText(am.fV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0158a.hnK.setVisibility(0);
            } else {
                c0158a.hnK.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAo().bAp())) {
                c0158a.hnJ.setImageResource(d.f.btn_icon_stop_video);
                c0158a.hnI.setDrawBorder(true);
                c0158a.hnO.setVisibility(0);
                c0158a.hnK.setVisibility(4);
                musicList.isLoading = false;
                c0158a.hnO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hnG != null) {
                            a.this.hnG.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0158a.hnJ.setImageResource(d.f.btn_icon_play_video_n);
                c0158a.hnI.setDrawBorder(false);
                c0158a.hnO.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hnG = bVar;
    }

    public void O(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0158a {
        private View emK;
        public TbImageView hnI;
        public TbImageView hnJ;
        public View hnK;
        public TextView hnL;
        public TextView hnM;
        public TextView hnN;
        public TextView hnO;

        public void gz(int i) {
            aj.r(this.hnL, d.C0108d.cp_cont_b);
            aj.r(this.hnM, d.C0108d.cp_cont_j);
            aj.r(this.hnN, d.C0108d.cp_cont_j);
            aj.r(this.hnO, d.C0108d.common_color_10140);
            aj.s(this.hnO, d.f.bg_music_choose);
            aj.t(this.emK, d.C0108d.cp_bg_line_c);
            aj.c(this.hnJ, d.f.btn_icon_play_video_n);
        }
    }
}
