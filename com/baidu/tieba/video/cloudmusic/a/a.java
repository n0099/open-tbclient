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
    private List<CloudMusicData.MusicTagList.MusicList> gNT = new ArrayList();
    private b gNU;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dN(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gNT.contains(musicList)) {
                    this.gNT.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gNT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vh */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gNT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0131a c0131a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0131a = new C0131a();
            c0131a.gNX = (TbImageView) view.findViewById(d.g.music_state);
            c0131a.gNW = (TbImageView) view.findViewById(d.g.music_image);
            c0131a.gNW.setDrawerType(1);
            c0131a.gNW.setIsRound(true);
            c0131a.gNW.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0131a.gNW.setDefaultResource(d.f.bg_video_cloudmusic);
            c0131a.gNW.setDefaultBgResource(d.C0082d.transparent);
            c0131a.gNW.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0131a.gNW.setBorderColor(aj.getColor(d.C0082d.cp_link_tip_a));
            c0131a.gNY = view.findViewById(d.g.music_loading);
            c0131a.gNZ = (TextView) view.findViewById(d.g.music_title);
            c0131a.gOa = (TextView) view.findViewById(d.g.music_author_name);
            c0131a.gOb = (TextView) view.findViewById(d.g.music_duration);
            c0131a.gOc = (TextView) view.findViewById(d.g.music_choose);
            c0131a.ddr = view.findViewById(d.g.line);
            view.setTag(c0131a);
        } else {
            c0131a = (C0131a) view.getTag();
        }
        c0131a.dE(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gNT.get(i);
        if (musicList != null) {
            c0131a.gNZ.setText(musicList.name);
            c0131a.gNW.startLoad(musicList.image, 10, false);
            c0131a.gOa.setText(musicList.author);
            c0131a.gOb.setText(am.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0131a.gNY.setVisibility(0);
            } else {
                c0131a.gNY.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAL().bAM())) {
                c0131a.gNX.setImageResource(d.f.btn_icon_stop_video);
                c0131a.gNW.setDrawBorder(true);
                c0131a.gOc.setVisibility(0);
                c0131a.gNY.setVisibility(4);
                musicList.isLoading = false;
                c0131a.gOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gNU != null) {
                            a.this.gNU.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0131a.gNX.setImageResource(d.f.btn_icon_play_video_n);
                c0131a.gNW.setDrawBorder(false);
                c0131a.gOc.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gNU = bVar;
    }

    public void D(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0131a {
        private View ddr;
        public TbImageView gNW;
        public TbImageView gNX;
        public View gNY;
        public TextView gNZ;
        public TextView gOa;
        public TextView gOb;
        public TextView gOc;

        public void dE(int i) {
            aj.i(this.gNZ, d.C0082d.cp_cont_b);
            aj.i(this.gOa, d.C0082d.cp_cont_j);
            aj.i(this.gOb, d.C0082d.cp_cont_j);
            aj.i(this.gOc, d.C0082d.common_color_10140);
            aj.j(this.gOc, d.f.bg_music_choose);
            aj.k(this.ddr, d.C0082d.cp_bg_line_c);
            aj.c(this.gNX, d.f.btn_icon_play_video_n);
        }
    }
}
