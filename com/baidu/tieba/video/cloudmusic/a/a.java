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
    private List<CloudMusicData.MusicTagList.MusicList> hFh = new ArrayList();
    private b hFi;
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
                if (!this.hFh.contains(musicList)) {
                    this.hFh.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hFh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wI */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hFh.get(i);
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
            c0322a.hFl = (TbImageView) view.findViewById(e.g.music_state);
            c0322a.hFk = (TbImageView) view.findViewById(e.g.music_image);
            c0322a.hFk.setDrawerType(1);
            c0322a.hFk.setIsRound(true);
            c0322a.hFk.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0322a.hFk.setDefaultResource(e.f.bg_video_cloudmusic);
            c0322a.hFk.setDefaultBgResource(e.d.transparent);
            c0322a.hFk.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds4));
            c0322a.hFk.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0322a.hFm = view.findViewById(e.g.music_loading);
            c0322a.hFn = (TextView) view.findViewById(e.g.music_title);
            c0322a.hFo = (TextView) view.findViewById(e.g.music_author_name);
            c0322a.hFp = (TextView) view.findViewById(e.g.music_duration);
            c0322a.hFq = (TextView) view.findViewById(e.g.music_choose);
            c0322a.cKP = view.findViewById(e.g.line);
            view.setTag(c0322a);
        } else {
            c0322a = (C0322a) view.getTag();
        }
        c0322a.eD(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hFh.get(i);
        if (musicList != null) {
            c0322a.hFn.setText(musicList.name);
            c0322a.hFk.startLoad(musicList.image, 10, false);
            c0322a.hFo.setText(musicList.author);
            c0322a.hFp.setText(ao.dV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0322a.hFm.setVisibility(0);
            } else {
                c0322a.hFm.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bJE().bJF())) {
                c0322a.hFl.setImageResource(e.f.btn_icon_stop_video);
                c0322a.hFk.setDrawBorder(true);
                c0322a.hFq.setVisibility(0);
                c0322a.hFm.setVisibility(4);
                musicList.isLoading = false;
                c0322a.hFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hFi != null) {
                            a.this.hFi.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0322a.hFl.setImageResource(e.f.btn_icon_play_video_n);
                c0322a.hFk.setDrawBorder(false);
                c0322a.hFq.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hFi = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0322a {
        private View cKP;
        public TbImageView hFk;
        public TbImageView hFl;
        public View hFm;
        public TextView hFn;
        public TextView hFo;
        public TextView hFp;
        public TextView hFq;

        public void eD(int i) {
            al.h(this.hFn, e.d.cp_cont_b);
            al.h(this.hFo, e.d.cp_cont_j);
            al.h(this.hFp, e.d.cp_cont_j);
            al.h(this.hFq, e.d.common_color_10140);
            al.i(this.hFq, e.f.bg_music_choose);
            al.j(this.cKP, e.d.cp_bg_line_c);
            al.c(this.hFl, e.f.btn_icon_play_video_n);
        }
    }
}
