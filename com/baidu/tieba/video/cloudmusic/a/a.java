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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> hcJ = new ArrayList();
    private b hcK;
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
                if (!this.hcJ.contains(musicList)) {
                    this.hcJ.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hcJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uF */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hcJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0240a c0240a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0240a = new C0240a();
            c0240a.hcN = (TbImageView) view.findViewById(d.g.music_state);
            c0240a.hcM = (TbImageView) view.findViewById(d.g.music_image);
            c0240a.hcM.setDrawerType(1);
            c0240a.hcM.setIsRound(true);
            c0240a.hcM.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0240a.hcM.setDefaultResource(d.f.bg_video_cloudmusic);
            c0240a.hcM.setDefaultBgResource(d.C0140d.transparent);
            c0240a.hcM.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0240a.hcM.setBorderColor(am.getColor(d.C0140d.cp_link_tip_a));
            c0240a.hcO = view.findViewById(d.g.music_loading);
            c0240a.hcP = (TextView) view.findViewById(d.g.music_title);
            c0240a.hcQ = (TextView) view.findViewById(d.g.music_author_name);
            c0240a.hcR = (TextView) view.findViewById(d.g.music_duration);
            c0240a.hcS = (TextView) view.findViewById(d.g.music_choose);
            c0240a.efM = view.findViewById(d.g.line);
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        c0240a.dG(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hcJ.get(i);
        if (musicList != null) {
            c0240a.hcP.setText(musicList.name);
            c0240a.hcM.startLoad(musicList.image, 10, false);
            c0240a.hcQ.setText(musicList.author);
            c0240a.hcR.setText(ap.da(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0240a.hcO.setVisibility(0);
            } else {
                c0240a.hcO.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAx().bAy())) {
                c0240a.hcN.setImageResource(d.f.btn_icon_stop_video);
                c0240a.hcM.setDrawBorder(true);
                c0240a.hcS.setVisibility(0);
                c0240a.hcO.setVisibility(4);
                musicList.isLoading = false;
                c0240a.hcS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hcK != null) {
                            a.this.hcK.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0240a.hcN.setImageResource(d.f.btn_icon_play_video_n);
                c0240a.hcM.setDrawBorder(false);
                c0240a.hcS.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hcK = bVar;
    }

    public void E(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0240a {
        private View efM;
        public TbImageView hcM;
        public TbImageView hcN;
        public View hcO;
        public TextView hcP;
        public TextView hcQ;
        public TextView hcR;
        public TextView hcS;

        public void dG(int i) {
            am.h(this.hcP, d.C0140d.cp_cont_b);
            am.h(this.hcQ, d.C0140d.cp_cont_j);
            am.h(this.hcR, d.C0140d.cp_cont_j);
            am.h(this.hcS, d.C0140d.common_color_10140);
            am.i(this.hcS, d.f.bg_music_choose);
            am.j(this.efM, d.C0140d.cp_bg_line_c);
            am.c(this.hcN, d.f.btn_icon_play_video_n);
        }
    }
}
