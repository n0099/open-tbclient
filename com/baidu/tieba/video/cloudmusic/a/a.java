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
    private List<CloudMusicData.MusicTagList.MusicList> hoH = new ArrayList();
    private b hoI;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dH(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hoH.contains(musicList)) {
                    this.hoH.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hoH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wK */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hoH.get(i);
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
            c0240a.hoL = (TbImageView) view.findViewById(d.g.music_state);
            c0240a.hoK = (TbImageView) view.findViewById(d.g.music_image);
            c0240a.hoK.setDrawerType(1);
            c0240a.hoK.setIsRound(true);
            c0240a.hoK.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0240a.hoK.setDefaultResource(d.f.bg_video_cloudmusic);
            c0240a.hoK.setDefaultBgResource(d.C0141d.transparent);
            c0240a.hoK.setBorderWidth(l.t(this.mPageContext.getPageActivity(), d.e.ds4));
            c0240a.hoK.setBorderColor(aj.getColor(d.C0141d.cp_link_tip_a));
            c0240a.hoM = view.findViewById(d.g.music_loading);
            c0240a.hoN = (TextView) view.findViewById(d.g.music_title);
            c0240a.hoO = (TextView) view.findViewById(d.g.music_author_name);
            c0240a.hoP = (TextView) view.findViewById(d.g.music_duration);
            c0240a.hoQ = (TextView) view.findViewById(d.g.music_choose);
            c0240a.eqL = view.findViewById(d.g.line);
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        c0240a.gB(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hoH.get(i);
        if (musicList != null) {
            c0240a.hoN.setText(musicList.name);
            c0240a.hoK.startLoad(musicList.image, 10, false);
            c0240a.hoO.setText(musicList.author);
            c0240a.hoP.setText(am.fV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0240a.hoM.setVisibility(0);
            } else {
                c0240a.hoM.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAX().bAY())) {
                c0240a.hoL.setImageResource(d.f.btn_icon_stop_video);
                c0240a.hoK.setDrawBorder(true);
                c0240a.hoQ.setVisibility(0);
                c0240a.hoM.setVisibility(4);
                musicList.isLoading = false;
                c0240a.hoQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hoI != null) {
                            a.this.hoI.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0240a.hoL.setImageResource(d.f.btn_icon_play_video_n);
                c0240a.hoK.setDrawBorder(false);
                c0240a.hoQ.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hoI = bVar;
    }

    public void U(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0240a {
        private View eqL;
        public TbImageView hoK;
        public TbImageView hoL;
        public View hoM;
        public TextView hoN;
        public TextView hoO;
        public TextView hoP;
        public TextView hoQ;

        public void gB(int i) {
            aj.r(this.hoN, d.C0141d.cp_cont_b);
            aj.r(this.hoO, d.C0141d.cp_cont_j);
            aj.r(this.hoP, d.C0141d.cp_cont_j);
            aj.r(this.hoQ, d.C0141d.common_color_10140);
            aj.s(this.hoQ, d.f.bg_music_choose);
            aj.t(this.eqL, d.C0141d.cp_bg_line_c);
            aj.c(this.hoL, d.f.btn_icon_play_video_n);
        }
    }
}
