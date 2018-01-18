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
    private List<CloudMusicData.MusicTagList.MusicList> hnl = new ArrayList();
    private b hnm;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dB(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.hnl.contains(musicList)) {
                    this.hnl.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hnl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wK */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.hnl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0157a c0157a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0157a = new C0157a();
            c0157a.hnp = (TbImageView) view.findViewById(d.g.music_state);
            c0157a.hno = (TbImageView) view.findViewById(d.g.music_image);
            c0157a.hno.setDrawerType(1);
            c0157a.hno.setIsRound(true);
            c0157a.hno.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0157a.hno.setDefaultResource(d.f.bg_video_cloudmusic);
            c0157a.hno.setDefaultBgResource(d.C0107d.transparent);
            c0157a.hno.setBorderWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds4));
            c0157a.hno.setBorderColor(aj.getColor(d.C0107d.cp_link_tip_a));
            c0157a.hnq = view.findViewById(d.g.music_loading);
            c0157a.hnr = (TextView) view.findViewById(d.g.music_title);
            c0157a.hns = (TextView) view.findViewById(d.g.music_author_name);
            c0157a.hnt = (TextView) view.findViewById(d.g.music_duration);
            c0157a.hnu = (TextView) view.findViewById(d.g.music_choose);
            c0157a.emp = view.findViewById(d.g.line);
            view.setTag(c0157a);
        } else {
            c0157a = (C0157a) view.getTag();
        }
        c0157a.gz(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.hnl.get(i);
        if (musicList != null) {
            c0157a.hnr.setText(musicList.name);
            c0157a.hno.startLoad(musicList.image, 10, false);
            c0157a.hns.setText(musicList.author);
            c0157a.hnt.setText(am.fV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0157a.hnq.setVisibility(0);
            } else {
                c0157a.hnq.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bAm().bAn())) {
                c0157a.hnp.setImageResource(d.f.btn_icon_stop_video);
                c0157a.hno.setDrawBorder(true);
                c0157a.hnu.setVisibility(0);
                c0157a.hnq.setVisibility(4);
                musicList.isLoading = false;
                c0157a.hnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.hnm != null) {
                            a.this.hnm.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0157a.hnp.setImageResource(d.f.btn_icon_play_video_n);
                c0157a.hno.setDrawBorder(false);
                c0157a.hnu.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.hnm = bVar;
    }

    public void O(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0157a {
        private View emp;
        public TbImageView hno;
        public TbImageView hnp;
        public View hnq;
        public TextView hnr;
        public TextView hns;
        public TextView hnt;
        public TextView hnu;

        public void gz(int i) {
            aj.r(this.hnr, d.C0107d.cp_cont_b);
            aj.r(this.hns, d.C0107d.cp_cont_j);
            aj.r(this.hnt, d.C0107d.cp_cont_j);
            aj.r(this.hnu, d.C0107d.common_color_10140);
            aj.s(this.hnu, d.f.bg_music_choose);
            aj.t(this.emp, d.C0107d.cp_bg_line_c);
            aj.c(this.hnp, d.f.btn_icon_play_video_n);
        }
    }
}
