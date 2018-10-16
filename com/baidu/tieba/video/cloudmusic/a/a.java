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
    private List<CloudMusicData.MusicTagList.MusicList> hrS = new ArrayList();
    private b hrT;
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
                if (!this.hrS.contains(musicList)) {
                    this.hrS.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hrS.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vC */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hrS.get(i);
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
            c0281a.hrW = (TbImageView) view.findViewById(e.g.music_state);
            c0281a.hrV = (TbImageView) view.findViewById(e.g.music_image);
            c0281a.hrV.setDrawerType(1);
            c0281a.hrV.setIsRound(true);
            c0281a.hrV.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0281a.hrV.setDefaultResource(e.f.bg_video_cloudmusic);
            c0281a.hrV.setDefaultBgResource(e.d.transparent);
            c0281a.hrV.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds4));
            c0281a.hrV.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0281a.hrX = view.findViewById(e.g.music_loading);
            c0281a.hrY = (TextView) view.findViewById(e.g.music_title);
            c0281a.hrZ = (TextView) view.findViewById(e.g.music_author_name);
            c0281a.hsa = (TextView) view.findViewById(e.g.music_duration);
            c0281a.hsb = (TextView) view.findViewById(e.g.music_choose);
            c0281a.euX = view.findViewById(e.g.line);
            view.setTag(c0281a);
        } else {
            c0281a = (C0281a) view.getTag();
        }
        c0281a.ea(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hrS.get(i);
        if (musicList != null) {
            c0281a.hrY.setText(musicList.name);
            c0281a.hrV.startLoad(musicList.image, 10, false);
            c0281a.hrZ.setText(musicList.author);
            c0281a.hsa.setText(ao.dt(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0281a.hrX.setVisibility(0);
            } else {
                c0281a.hrX.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bGC().bGD())) {
                c0281a.hrW.setImageResource(e.f.btn_icon_stop_video);
                c0281a.hrV.setDrawBorder(true);
                c0281a.hsb.setVisibility(0);
                c0281a.hrX.setVisibility(4);
                musicList.isLoading = false;
                c0281a.hsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hrT != null) {
                            a.this.hrT.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0281a.hrW.setImageResource(e.f.btn_icon_play_video_n);
                c0281a.hrV.setDrawBorder(false);
                c0281a.hsb.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hrT = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0281a {
        private View euX;
        public TbImageView hrV;
        public TbImageView hrW;
        public View hrX;
        public TextView hrY;
        public TextView hrZ;
        public TextView hsa;
        public TextView hsb;

        public void ea(int i) {
            al.h(this.hrY, e.d.cp_cont_b);
            al.h(this.hrZ, e.d.cp_cont_j);
            al.h(this.hsa, e.d.cp_cont_j);
            al.h(this.hsb, e.d.common_color_10140);
            al.i(this.hsb, e.f.bg_music_choose);
            al.j(this.euX, e.d.cp_bg_line_c);
            al.c(this.hrW, e.f.btn_icon_play_video_n);
        }
    }
}
