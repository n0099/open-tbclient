package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> hcK = new ArrayList();
    private b hcL;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dF(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hcK.contains(musicList)) {
                    this.hcK.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hcK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uF */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hcK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0240a c0240a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.cloud_music_item, viewGroup, false);
            c0240a = new C0240a();
            c0240a.hcO = (TbImageView) view.findViewById(f.g.music_state);
            c0240a.hcN = (TbImageView) view.findViewById(f.g.music_image);
            c0240a.hcN.setDrawerType(1);
            c0240a.hcN.setIsRound(true);
            c0240a.hcN.setDefaultErrorResource(f.C0146f.bg_video_cloudmusic);
            c0240a.hcN.setDefaultResource(f.C0146f.bg_video_cloudmusic);
            c0240a.hcN.setDefaultBgResource(f.d.transparent);
            c0240a.hcN.setBorderWidth(l.f(this.mPageContext.getPageActivity(), f.e.ds4));
            c0240a.hcN.setBorderColor(am.getColor(f.d.cp_link_tip_a));
            c0240a.hcP = view.findViewById(f.g.music_loading);
            c0240a.hcQ = (TextView) view.findViewById(f.g.music_title);
            c0240a.hcR = (TextView) view.findViewById(f.g.music_author_name);
            c0240a.hcS = (TextView) view.findViewById(f.g.music_duration);
            c0240a.hcT = (TextView) view.findViewById(f.g.music_choose);
            c0240a.efJ = view.findViewById(f.g.line);
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        c0240a.dF(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hcK.get(i);
        if (musicList != null) {
            c0240a.hcQ.setText(musicList.name);
            c0240a.hcN.startLoad(musicList.image, 10, false);
            c0240a.hcR.setText(musicList.author);
            c0240a.hcS.setText(ap.da(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0240a.hcP.setVisibility(0);
            } else {
                c0240a.hcP.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAz().bAA())) {
                c0240a.hcO.setImageResource(f.C0146f.btn_icon_stop_video);
                c0240a.hcN.setDrawBorder(true);
                c0240a.hcT.setVisibility(0);
                c0240a.hcP.setVisibility(4);
                musicList.isLoading = false;
                c0240a.hcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hcL != null) {
                            a.this.hcL.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0240a.hcO.setImageResource(f.C0146f.btn_icon_play_video_n);
                c0240a.hcN.setDrawBorder(false);
                c0240a.hcT.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hcL = bVar;
    }

    public void E(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0240a {
        private View efJ;
        public TbImageView hcN;
        public TbImageView hcO;
        public View hcP;
        public TextView hcQ;
        public TextView hcR;
        public TextView hcS;
        public TextView hcT;

        public void dF(int i) {
            am.h(this.hcQ, f.d.cp_cont_b);
            am.h(this.hcR, f.d.cp_cont_j);
            am.h(this.hcS, f.d.cp_cont_j);
            am.h(this.hcT, f.d.common_color_10140);
            am.i(this.hcT, f.C0146f.bg_music_choose);
            am.j(this.efJ, f.d.cp_bg_line_c);
            am.c(this.hcO, f.C0146f.btn_icon_play_video_n);
        }
    }
}
