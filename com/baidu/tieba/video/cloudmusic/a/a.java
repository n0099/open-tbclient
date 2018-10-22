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
    private List<CloudMusicData.MusicTagList.MusicList> hrT = new ArrayList();
    private b hrU;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dU(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hrT.contains(musicList)) {
                    this.hrT.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hrT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vC */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hrT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0281a c0281a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cloud_music_item, viewGroup, false);
            c0281a = new C0281a();
            c0281a.hrX = (TbImageView) view.findViewById(e.g.music_state);
            c0281a.hrW = (TbImageView) view.findViewById(e.g.music_image);
            c0281a.hrW.setDrawerType(1);
            c0281a.hrW.setIsRound(true);
            c0281a.hrW.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0281a.hrW.setDefaultResource(e.f.bg_video_cloudmusic);
            c0281a.hrW.setDefaultBgResource(e.d.transparent);
            c0281a.hrW.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds4));
            c0281a.hrW.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0281a.hrY = view.findViewById(e.g.music_loading);
            c0281a.hrZ = (TextView) view.findViewById(e.g.music_title);
            c0281a.hsa = (TextView) view.findViewById(e.g.music_author_name);
            c0281a.hsb = (TextView) view.findViewById(e.g.music_duration);
            c0281a.hsc = (TextView) view.findViewById(e.g.music_choose);
            c0281a.euY = view.findViewById(e.g.line);
            view.setTag(c0281a);
        } else {
            c0281a = (C0281a) view.getTag();
        }
        c0281a.ea(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hrT.get(i);
        if (musicList != null) {
            c0281a.hrZ.setText(musicList.name);
            c0281a.hrW.startLoad(musicList.image, 10, false);
            c0281a.hsa.setText(musicList.author);
            c0281a.hsb.setText(ao.dt(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0281a.hrY.setVisibility(0);
            } else {
                c0281a.hrY.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bGC().bGD())) {
                c0281a.hrX.setImageResource(e.f.btn_icon_stop_video);
                c0281a.hrW.setDrawBorder(true);
                c0281a.hsc.setVisibility(0);
                c0281a.hrY.setVisibility(4);
                musicList.isLoading = false;
                c0281a.hsc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hrU != null) {
                            a.this.hrU.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0281a.hrX.setImageResource(e.f.btn_icon_play_video_n);
                c0281a.hrW.setDrawBorder(false);
                c0281a.hsc.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hrU = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0281a {
        private View euY;
        public TbImageView hrW;
        public TbImageView hrX;
        public View hrY;
        public TextView hrZ;
        public TextView hsa;
        public TextView hsb;
        public TextView hsc;

        public void ea(int i) {
            al.h(this.hrZ, e.d.cp_cont_b);
            al.h(this.hsa, e.d.cp_cont_j);
            al.h(this.hsb, e.d.cp_cont_j);
            al.h(this.hsc, e.d.common_color_10140);
            al.i(this.hsc, e.f.bg_music_choose);
            al.j(this.euY, e.d.cp_bg_line_c);
            al.c(this.hrX, e.f.btn_icon_play_video_n);
        }
    }
}
