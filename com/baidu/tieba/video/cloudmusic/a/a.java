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
    private List<CloudMusicData.MusicTagList.MusicList> hAO = new ArrayList();
    private b hAP;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dW(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hAO.contains(musicList)) {
                    this.hAO.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hAO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ws */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hAO.get(i);
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
            c0323a.hAS = (TbImageView) view.findViewById(e.g.music_state);
            c0323a.hAR = (TbImageView) view.findViewById(e.g.music_image);
            c0323a.hAR.setDrawerType(1);
            c0323a.hAR.setIsRound(true);
            c0323a.hAR.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            c0323a.hAR.setDefaultResource(e.f.bg_video_cloudmusic);
            c0323a.hAR.setDefaultBgResource(e.d.transparent);
            c0323a.hAR.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds4));
            c0323a.hAR.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            c0323a.hAT = view.findViewById(e.g.music_loading);
            c0323a.hAU = (TextView) view.findViewById(e.g.music_title);
            c0323a.hAV = (TextView) view.findViewById(e.g.music_author_name);
            c0323a.hAW = (TextView) view.findViewById(e.g.music_duration);
            c0323a.hAX = (TextView) view.findViewById(e.g.music_choose);
            c0323a.cJd = view.findViewById(e.g.line);
            view.setTag(c0323a);
        } else {
            c0323a = (C0323a) view.getTag();
        }
        c0323a.eC(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hAO.get(i);
        if (musicList != null) {
            c0323a.hAU.setText(musicList.name);
            c0323a.hAR.startLoad(musicList.image, 10, false);
            c0323a.hAV.setText(musicList.author);
            c0323a.hAW.setText(ao.dV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0323a.hAT.setVisibility(0);
            } else {
                c0323a.hAT.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bIf().bIg())) {
                c0323a.hAS.setImageResource(e.f.btn_icon_stop_video);
                c0323a.hAR.setDrawBorder(true);
                c0323a.hAX.setVisibility(0);
                c0323a.hAT.setVisibility(4);
                musicList.isLoading = false;
                c0323a.hAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hAP != null) {
                            a.this.hAP.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0323a.hAS.setImageResource(e.f.btn_icon_play_video_n);
                c0323a.hAR.setDrawBorder(false);
                c0323a.hAX.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hAP = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0323a {
        private View cJd;
        public TbImageView hAR;
        public TbImageView hAS;
        public View hAT;
        public TextView hAU;
        public TextView hAV;
        public TextView hAW;
        public TextView hAX;

        public void eC(int i) {
            al.h(this.hAU, e.d.cp_cont_b);
            al.h(this.hAV, e.d.cp_cont_j);
            al.h(this.hAW, e.d.cp_cont_j);
            al.h(this.hAX, e.d.common_color_10140);
            al.i(this.hAX, e.f.bg_music_choose);
            al.j(this.cJd, e.d.cp_bg_line_c);
            al.c(this.hAS, e.f.btn_icon_play_video_n);
        }
    }
}
