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
    private List<CloudMusicData.MusicTagList.MusicList> gDd = new ArrayList();
    private b gDe;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dA(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gDd.contains(musicList)) {
                    this.gDd.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gDd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uL */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gDd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0129a = new C0129a();
            c0129a.gDh = (TbImageView) view.findViewById(d.g.music_state);
            c0129a.gDg = (TbImageView) view.findViewById(d.g.music_image);
            c0129a.gDg.setDrawerType(1);
            c0129a.gDg.setIsRound(true);
            c0129a.gDg.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0129a.gDg.setDefaultResource(d.f.bg_video_cloudmusic);
            c0129a.gDg.setDefaultBgResource(d.C0080d.transparent);
            c0129a.gDg.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0129a.gDg.setBorderColor(aj.getColor(d.C0080d.cp_link_tip_a));
            c0129a.gDi = view.findViewById(d.g.music_loading);
            c0129a.gDj = (TextView) view.findViewById(d.g.music_title);
            c0129a.gDk = (TextView) view.findViewById(d.g.music_author_name);
            c0129a.gDl = (TextView) view.findViewById(d.g.music_duration);
            c0129a.gDm = (TextView) view.findViewById(d.g.music_choose);
            c0129a.cUq = view.findViewById(d.g.line);
            view.setTag(c0129a);
        } else {
            c0129a = (C0129a) view.getTag();
        }
        c0129a.dE(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gDd.get(i);
        if (musicList != null) {
            c0129a.gDj.setText(musicList.name);
            c0129a.gDg.startLoad(musicList.image, 10, false);
            c0129a.gDk.setText(musicList.author);
            c0129a.gDl.setText(am.cY(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0129a.gDi.setVisibility(0);
            } else {
                c0129a.gDi.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.byw().byx())) {
                c0129a.gDh.setImageResource(d.f.btn_icon_stop_video);
                c0129a.gDg.setDrawBorder(true);
                c0129a.gDm.setVisibility(0);
                c0129a.gDi.setVisibility(4);
                musicList.isLoading = false;
                c0129a.gDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gDe != null) {
                            a.this.gDe.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0129a.gDh.setImageResource(d.f.btn_icon_play_video_n);
                c0129a.gDg.setDrawBorder(false);
                c0129a.gDm.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gDe = bVar;
    }

    public void D(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0129a {
        private View cUq;
        public TbImageView gDg;
        public TbImageView gDh;
        public View gDi;
        public TextView gDj;
        public TextView gDk;
        public TextView gDl;
        public TextView gDm;

        public void dE(int i) {
            aj.i(this.gDj, d.C0080d.cp_cont_b);
            aj.i(this.gDk, d.C0080d.cp_cont_j);
            aj.i(this.gDl, d.C0080d.cp_cont_j);
            aj.i(this.gDm, d.C0080d.common_color_10140);
            aj.j(this.gDm, d.f.bg_music_choose);
            aj.k(this.cUq, d.C0080d.cp_bg_line_c);
            aj.c(this.gDh, d.f.btn_icon_play_video_n);
        }
    }
}
