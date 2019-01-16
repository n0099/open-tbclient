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
    private List<CloudMusicData.MusicTagList.MusicList> hFg = new ArrayList();
    private b hFh;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dY(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hFg.contains(musicList)) {
                    this.hFg.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hFg.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wI */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hFg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0322a c0322a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cloud_music_item, viewGroup, false);
            c0322a = new C0322a();
            c0322a.hFk = (TbImageView) view.findViewById(e.g.music_state);
            c0322a.hFj = (TbImageView) view.findViewById(e.g.music_image);
            c0322a.hFj.setDrawerType(1);
            c0322a.hFj.setIsRound(true);
            c0322a.hFj.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0322a.hFj.setDefaultResource(e.f.bg_video_cloudmusic);
            c0322a.hFj.setDefaultBgResource(e.d.transparent);
            c0322a.hFj.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds4));
            c0322a.hFj.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0322a.hFl = view.findViewById(e.g.music_loading);
            c0322a.hFm = (TextView) view.findViewById(e.g.music_title);
            c0322a.hFn = (TextView) view.findViewById(e.g.music_author_name);
            c0322a.hFo = (TextView) view.findViewById(e.g.music_duration);
            c0322a.hFp = (TextView) view.findViewById(e.g.music_choose);
            c0322a.cKO = view.findViewById(e.g.line);
            view.setTag(c0322a);
        } else {
            c0322a = (C0322a) view.getTag();
        }
        c0322a.eD(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hFg.get(i);
        if (musicList != null) {
            c0322a.hFm.setText(musicList.name);
            c0322a.hFj.startLoad(musicList.image, 10, false);
            c0322a.hFn.setText(musicList.author);
            c0322a.hFo.setText(ao.dV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0322a.hFl.setVisibility(0);
            } else {
                c0322a.hFl.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bJE().bJF())) {
                c0322a.hFk.setImageResource(e.f.btn_icon_stop_video);
                c0322a.hFj.setDrawBorder(true);
                c0322a.hFp.setVisibility(0);
                c0322a.hFl.setVisibility(4);
                musicList.isLoading = false;
                c0322a.hFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hFh != null) {
                            a.this.hFh.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0322a.hFk.setImageResource(e.f.btn_icon_play_video_n);
                c0322a.hFj.setDrawBorder(false);
                c0322a.hFp.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hFh = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0322a {
        private View cKO;
        public TbImageView hFj;
        public TbImageView hFk;
        public View hFl;
        public TextView hFm;
        public TextView hFn;
        public TextView hFo;
        public TextView hFp;

        public void eD(int i) {
            al.h(this.hFm, e.d.cp_cont_b);
            al.h(this.hFn, e.d.cp_cont_j);
            al.h(this.hFo, e.d.cp_cont_j);
            al.h(this.hFp, e.d.common_color_10140);
            al.i(this.hFp, e.f.bg_music_choose);
            al.j(this.cKO, e.d.cp_bg_line_c);
            al.c(this.hFk, e.f.btn_icon_play_video_n);
        }
    }
}
