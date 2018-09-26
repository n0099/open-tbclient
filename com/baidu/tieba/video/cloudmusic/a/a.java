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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> hkC = new ArrayList();
    private b hkD;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dG(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hkC.contains(musicList)) {
                    this.hkC.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hkC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vf */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hkC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0246a c0246a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cloud_music_item, viewGroup, false);
            c0246a = new C0246a();
            c0246a.hkG = (TbImageView) view.findViewById(e.g.music_state);
            c0246a.hkF = (TbImageView) view.findViewById(e.g.music_image);
            c0246a.hkF.setDrawerType(1);
            c0246a.hkF.setIsRound(true);
            c0246a.hkF.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0246a.hkF.setDefaultResource(e.f.bg_video_cloudmusic);
            c0246a.hkF.setDefaultBgResource(e.d.transparent);
            c0246a.hkF.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds4));
            c0246a.hkF.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0246a.hkH = view.findViewById(e.g.music_loading);
            c0246a.hkI = (TextView) view.findViewById(e.g.music_title);
            c0246a.hkJ = (TextView) view.findViewById(e.g.music_author_name);
            c0246a.hkK = (TextView) view.findViewById(e.g.music_duration);
            c0246a.hkL = (TextView) view.findViewById(e.g.music_choose);
            c0246a.enf = view.findViewById(e.g.line);
            view.setTag(c0246a);
        } else {
            c0246a = (C0246a) view.getTag();
        }
        c0246a.dQ(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hkC.get(i);
        if (musicList != null) {
            c0246a.hkI.setText(musicList.name);
            c0246a.hkF.startLoad(musicList.image, 10, false);
            c0246a.hkJ.setText(musicList.author);
            c0246a.hkK.setText(ao.dj(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0246a.hkH.setVisibility(0);
            } else {
                c0246a.hkH.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bDo().bDp())) {
                c0246a.hkG.setImageResource(e.f.btn_icon_stop_video);
                c0246a.hkF.setDrawBorder(true);
                c0246a.hkL.setVisibility(0);
                c0246a.hkH.setVisibility(4);
                musicList.isLoading = false;
                c0246a.hkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hkD != null) {
                            a.this.hkD.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0246a.hkG.setImageResource(e.f.btn_icon_play_video_n);
                c0246a.hkF.setDrawBorder(false);
                c0246a.hkL.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hkD = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0246a {
        private View enf;
        public TbImageView hkF;
        public TbImageView hkG;
        public View hkH;
        public TextView hkI;
        public TextView hkJ;
        public TextView hkK;
        public TextView hkL;

        public void dQ(int i) {
            al.h(this.hkI, e.d.cp_cont_b);
            al.h(this.hkJ, e.d.cp_cont_j);
            al.h(this.hkK, e.d.cp_cont_j);
            al.h(this.hkL, e.d.common_color_10140);
            al.i(this.hkL, e.f.bg_music_choose);
            al.j(this.enf, e.d.cp_bg_line_c);
            al.c(this.hkG, e.f.btn_icon_play_video_n);
        }
    }
}
