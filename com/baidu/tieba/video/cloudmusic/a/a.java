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
    private List<CloudMusicData.MusicTagList.MusicList> hDZ = new ArrayList();
    private b hEa;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dX(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hDZ.contains(musicList)) {
                    this.hDZ.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hDZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wF */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hDZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0323a c0323a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cloud_music_item, viewGroup, false);
            c0323a = new C0323a();
            c0323a.hEd = (TbImageView) view.findViewById(e.g.music_state);
            c0323a.hEc = (TbImageView) view.findViewById(e.g.music_image);
            c0323a.hEc.setDrawerType(1);
            c0323a.hEc.setIsRound(true);
            c0323a.hEc.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0323a.hEc.setDefaultResource(e.f.bg_video_cloudmusic);
            c0323a.hEc.setDefaultBgResource(e.d.transparent);
            c0323a.hEc.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds4));
            c0323a.hEc.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0323a.hEe = view.findViewById(e.g.music_loading);
            c0323a.hEf = (TextView) view.findViewById(e.g.music_title);
            c0323a.hEg = (TextView) view.findViewById(e.g.music_author_name);
            c0323a.hEh = (TextView) view.findViewById(e.g.music_duration);
            c0323a.hEi = (TextView) view.findViewById(e.g.music_choose);
            c0323a.cKd = view.findViewById(e.g.line);
            view.setTag(c0323a);
        } else {
            c0323a = (C0323a) view.getTag();
        }
        c0323a.eD(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hDZ.get(i);
        if (musicList != null) {
            c0323a.hEf.setText(musicList.name);
            c0323a.hEc.startLoad(musicList.image, 10, false);
            c0323a.hEg.setText(musicList.author);
            c0323a.hEh.setText(ao.dV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0323a.hEe.setVisibility(0);
            } else {
                c0323a.hEe.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bIV().bIW())) {
                c0323a.hEd.setImageResource(e.f.btn_icon_stop_video);
                c0323a.hEc.setDrawBorder(true);
                c0323a.hEi.setVisibility(0);
                c0323a.hEe.setVisibility(4);
                musicList.isLoading = false;
                c0323a.hEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hEa != null) {
                            a.this.hEa.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0323a.hEd.setImageResource(e.f.btn_icon_play_video_n);
                c0323a.hEc.setDrawBorder(false);
                c0323a.hEi.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hEa = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0323a {
        private View cKd;
        public TbImageView hEc;
        public TbImageView hEd;
        public View hEe;
        public TextView hEf;
        public TextView hEg;
        public TextView hEh;
        public TextView hEi;

        public void eD(int i) {
            al.h(this.hEf, e.d.cp_cont_b);
            al.h(this.hEg, e.d.cp_cont_j);
            al.h(this.hEh, e.d.cp_cont_j);
            al.h(this.hEi, e.d.common_color_10140);
            al.i(this.hEi, e.f.bg_music_choose);
            al.j(this.cKd, e.d.cp_bg_line_c);
            al.c(this.hEd, e.f.btn_icon_play_video_n);
        }
    }
}
