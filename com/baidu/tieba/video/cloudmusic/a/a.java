package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> htC = new ArrayList();
    private b htD;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dS(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.htC.contains(musicList)) {
                    this.htC.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.htC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vV */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.htC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0309a c0309a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cloud_music_item, viewGroup, false);
            c0309a = new C0309a();
            c0309a.htG = (TbImageView) view.findViewById(e.g.music_state);
            c0309a.htF = (TbImageView) view.findViewById(e.g.music_image);
            c0309a.htF.setDrawerType(1);
            c0309a.htF.setIsRound(true);
            c0309a.htF.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0309a.htF.setDefaultResource(e.f.bg_video_cloudmusic);
            c0309a.htF.setDefaultBgResource(e.d.transparent);
            c0309a.htF.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds4));
            c0309a.htF.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0309a.htH = view.findViewById(e.g.music_loading);
            c0309a.htI = (TextView) view.findViewById(e.g.music_title);
            c0309a.htJ = (TextView) view.findViewById(e.g.music_author_name);
            c0309a.htK = (TextView) view.findViewById(e.g.music_duration);
            c0309a.htL = (TextView) view.findViewById(e.g.music_choose);
            c0309a.ewr = view.findViewById(e.g.line);
            view.setTag(c0309a);
        } else {
            c0309a = (C0309a) view.getTag();
        }
        c0309a.eo(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.htC.get(i);
        if (musicList != null) {
            c0309a.htI.setText(musicList.name);
            c0309a.htF.startLoad(musicList.image, 10, false);
            c0309a.htJ.setText(musicList.author);
            c0309a.htK.setText(ao.dH(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0309a.htH.setVisibility(0);
            } else {
                c0309a.htH.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bGb().bGc())) {
                c0309a.htG.setImageResource(e.f.btn_icon_stop_video);
                c0309a.htF.setDrawBorder(true);
                c0309a.htL.setVisibility(0);
                c0309a.htH.setVisibility(4);
                musicList.isLoading = false;
                c0309a.htL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.htD != null) {
                            a.this.htD.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0309a.htG.setImageResource(e.f.btn_icon_play_video_n);
                c0309a.htF.setDrawBorder(false);
                c0309a.htL.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.htD = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0309a {
        private View ewr;
        public TbImageView htF;
        public TbImageView htG;
        public View htH;
        public TextView htI;
        public TextView htJ;
        public TextView htK;
        public TextView htL;

        public void eo(int i) {
            al.h(this.htI, e.d.cp_cont_b);
            al.h(this.htJ, e.d.cp_cont_j);
            al.h(this.htK, e.d.cp_cont_j);
            al.h(this.htL, e.d.common_color_10140);
            al.i(this.htL, e.f.bg_music_choose);
            al.j(this.ewr, e.d.cp_bg_line_c);
            al.c(this.htG, e.f.btn_icon_play_video_n);
        }
    }
}
