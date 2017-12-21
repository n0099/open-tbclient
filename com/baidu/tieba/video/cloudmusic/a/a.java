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
    private List<CloudMusicData.MusicTagList.MusicList> gQG = new ArrayList();
    private b gQH;
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
                if (!this.gQG.contains(musicList)) {
                    this.gQG.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gQG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gQG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0145a c0145a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0145a = new C0145a();
            c0145a.gQK = (TbImageView) view.findViewById(d.g.music_state);
            c0145a.gQJ = (TbImageView) view.findViewById(d.g.music_image);
            c0145a.gQJ.setDrawerType(1);
            c0145a.gQJ.setIsRound(true);
            c0145a.gQJ.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0145a.gQJ.setDefaultResource(d.f.bg_video_cloudmusic);
            c0145a.gQJ.setDefaultBgResource(d.C0095d.transparent);
            c0145a.gQJ.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0145a.gQJ.setBorderColor(aj.getColor(d.C0095d.cp_link_tip_a));
            c0145a.gQL = view.findViewById(d.g.music_loading);
            c0145a.gQM = (TextView) view.findViewById(d.g.music_title);
            c0145a.gQN = (TextView) view.findViewById(d.g.music_author_name);
            c0145a.gQO = (TextView) view.findViewById(d.g.music_duration);
            c0145a.gQP = (TextView) view.findViewById(d.g.music_choose);
            c0145a.deD = view.findViewById(d.g.line);
            view.setTag(c0145a);
        } else {
            c0145a = (C0145a) view.getTag();
        }
        c0145a.dE(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gQG.get(i);
        if (musicList != null) {
            c0145a.gQM.setText(musicList.name);
            c0145a.gQJ.startLoad(musicList.image, 10, false);
            c0145a.gQN.setText(musicList.author);
            c0145a.gQO.setText(am.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0145a.gQL.setVisibility(0);
            } else {
                c0145a.gQL.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bBs().bBt())) {
                c0145a.gQK.setImageResource(d.f.btn_icon_stop_video);
                c0145a.gQJ.setDrawBorder(true);
                c0145a.gQP.setVisibility(0);
                c0145a.gQL.setVisibility(4);
                musicList.isLoading = false;
                c0145a.gQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gQH != null) {
                            a.this.gQH.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0145a.gQK.setImageResource(d.f.btn_icon_play_video_n);
                c0145a.gQJ.setDrawBorder(false);
                c0145a.gQP.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gQH = bVar;
    }

    public void D(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0145a {
        private View deD;
        public TbImageView gQJ;
        public TbImageView gQK;
        public View gQL;
        public TextView gQM;
        public TextView gQN;
        public TextView gQO;
        public TextView gQP;

        public void dE(int i) {
            aj.i(this.gQM, d.C0095d.cp_cont_b);
            aj.i(this.gQN, d.C0095d.cp_cont_j);
            aj.i(this.gQO, d.C0095d.cp_cont_j);
            aj.i(this.gQP, d.C0095d.common_color_10140);
            aj.j(this.gQP, d.f.bg_music_choose);
            aj.k(this.deD, d.C0095d.cp_bg_line_c);
            aj.c(this.gQK, d.f.btn_icon_play_video_n);
        }
    }
}
