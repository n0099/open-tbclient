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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> iVv = new ArrayList();
    private b iVw;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void eb(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.iVv.contains(musicList)) {
                    this.iVv.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.iVv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Aq */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.iVv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0396a c0396a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0396a = new C0396a();
            c0396a.iVz = (TbImageView) view.findViewById(d.g.music_state);
            c0396a.iVy = (TbImageView) view.findViewById(d.g.music_image);
            c0396a.iVy.setDrawerType(1);
            c0396a.iVy.setIsRound(true);
            c0396a.iVy.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0396a.iVy.setDefaultResource(d.f.bg_video_cloudmusic);
            c0396a.iVy.setDefaultBgResource(d.C0277d.transparent);
            c0396a.iVy.setBorderWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds4));
            c0396a.iVy.setBorderColor(al.getColor(d.C0277d.cp_link_tip_a));
            c0396a.iVA = view.findViewById(d.g.music_loading);
            c0396a.iVB = (TextView) view.findViewById(d.g.music_title);
            c0396a.iVC = (TextView) view.findViewById(d.g.music_author_name);
            c0396a.iVD = (TextView) view.findViewById(d.g.music_duration);
            c0396a.iVE = (TextView) view.findViewById(d.g.music_choose);
            c0396a.dXL = view.findViewById(d.g.line);
            view.setTag(c0396a);
        } else {
            c0396a = (C0396a) view.getTag();
        }
        c0396a.ii(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.iVv.get(i);
        if (musicList != null) {
            c0396a.iVB.setText(musicList.name);
            c0396a.iVy.startLoad(musicList.image, 10, false);
            c0396a.iVC.setText(musicList.author);
            c0396a.iVD.setText(ap.hy(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0396a.iVA.setVisibility(0);
            } else {
                c0396a.iVA.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cjc().cjd())) {
                c0396a.iVz.setImageResource(d.f.btn_icon_stop_video);
                c0396a.iVy.setDrawBorder(true);
                c0396a.iVE.setVisibility(0);
                c0396a.iVA.setVisibility(4);
                musicList.isLoading = false;
                c0396a.iVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.iVw != null) {
                            a.this.iVw.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0396a.iVz.setImageResource(d.f.btn_icon_play_video_n);
                c0396a.iVy.setDrawBorder(false);
                c0396a.iVE.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.iVw = bVar;
    }

    public void L(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0396a {
        private View dXL;
        public View iVA;
        public TextView iVB;
        public TextView iVC;
        public TextView iVD;
        public TextView iVE;
        public TbImageView iVy;
        public TbImageView iVz;

        public void ii(int i) {
            al.j(this.iVB, d.C0277d.cp_cont_b);
            al.j(this.iVC, d.C0277d.cp_cont_j);
            al.j(this.iVD, d.C0277d.cp_cont_j);
            al.j(this.iVE, d.C0277d.common_color_10140);
            al.k(this.iVE, d.f.bg_music_choose);
            al.l(this.dXL, d.C0277d.cp_bg_line_c);
            al.c(this.iVz, d.f.btn_icon_play_video_n);
        }
    }
}
