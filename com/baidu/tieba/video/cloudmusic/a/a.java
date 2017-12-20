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
    private List<CloudMusicData.MusicTagList.MusicList> gQB = new ArrayList();
    private b gQC;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dM(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gQB.contains(musicList)) {
                    this.gQB.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gQB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gQB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0146a c0146a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0146a = new C0146a();
            c0146a.gQF = (TbImageView) view.findViewById(d.g.music_state);
            c0146a.gQE = (TbImageView) view.findViewById(d.g.music_image);
            c0146a.gQE.setDrawerType(1);
            c0146a.gQE.setIsRound(true);
            c0146a.gQE.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0146a.gQE.setDefaultResource(d.f.bg_video_cloudmusic);
            c0146a.gQE.setDefaultBgResource(d.C0096d.transparent);
            c0146a.gQE.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0146a.gQE.setBorderColor(aj.getColor(d.C0096d.cp_link_tip_a));
            c0146a.gQG = view.findViewById(d.g.music_loading);
            c0146a.gQH = (TextView) view.findViewById(d.g.music_title);
            c0146a.gQI = (TextView) view.findViewById(d.g.music_author_name);
            c0146a.gQJ = (TextView) view.findViewById(d.g.music_duration);
            c0146a.gQK = (TextView) view.findViewById(d.g.music_choose);
            c0146a.dez = view.findViewById(d.g.line);
            view.setTag(c0146a);
        } else {
            c0146a = (C0146a) view.getTag();
        }
        c0146a.dE(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gQB.get(i);
        if (musicList != null) {
            c0146a.gQH.setText(musicList.name);
            c0146a.gQE.startLoad(musicList.image, 10, false);
            c0146a.gQI.setText(musicList.author);
            c0146a.gQJ.setText(am.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0146a.gQG.setVisibility(0);
            } else {
                c0146a.gQG.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bBr().bBs())) {
                c0146a.gQF.setImageResource(d.f.btn_icon_stop_video);
                c0146a.gQE.setDrawBorder(true);
                c0146a.gQK.setVisibility(0);
                c0146a.gQG.setVisibility(4);
                musicList.isLoading = false;
                c0146a.gQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gQC != null) {
                            a.this.gQC.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0146a.gQF.setImageResource(d.f.btn_icon_play_video_n);
                c0146a.gQE.setDrawBorder(false);
                c0146a.gQK.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gQC = bVar;
    }

    public void D(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0146a {
        private View dez;
        public TbImageView gQE;
        public TbImageView gQF;
        public View gQG;
        public TextView gQH;
        public TextView gQI;
        public TextView gQJ;
        public TextView gQK;

        public void dE(int i) {
            aj.i(this.gQH, d.C0096d.cp_cont_b);
            aj.i(this.gQI, d.C0096d.cp_cont_j);
            aj.i(this.gQJ, d.C0096d.cp_cont_j);
            aj.i(this.gQK, d.C0096d.common_color_10140);
            aj.j(this.gQK, d.f.bg_music_choose);
            aj.k(this.dez, d.C0096d.cp_bg_line_c);
            aj.c(this.gQF, d.f.btn_icon_play_video_n);
        }
    }
}
