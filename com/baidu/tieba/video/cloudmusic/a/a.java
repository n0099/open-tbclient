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
    private List<CloudMusicData.MusicTagList.MusicList> gEl = new ArrayList();
    private b gEm;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dB(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gEl.contains(musicList)) {
                    this.gEl.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gEl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uP */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gEl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0132a c0132a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0132a = new C0132a();
            c0132a.gEp = (TbImageView) view.findViewById(d.g.music_state);
            c0132a.gEo = (TbImageView) view.findViewById(d.g.music_image);
            c0132a.gEo.setDrawerType(1);
            c0132a.gEo.setIsRound(true);
            c0132a.gEo.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0132a.gEo.setDefaultResource(d.f.bg_video_cloudmusic);
            c0132a.gEo.setDefaultBgResource(d.C0080d.transparent);
            c0132a.gEo.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            c0132a.gEo.setBorderColor(aj.getColor(d.C0080d.cp_link_tip_a));
            c0132a.gEq = view.findViewById(d.g.music_loading);
            c0132a.gEr = (TextView) view.findViewById(d.g.music_title);
            c0132a.gEs = (TextView) view.findViewById(d.g.music_author_name);
            c0132a.gEt = (TextView) view.findViewById(d.g.music_duration);
            c0132a.gEu = (TextView) view.findViewById(d.g.music_choose);
            c0132a.cUK = view.findViewById(d.g.line);
            view.setTag(c0132a);
        } else {
            c0132a = (C0132a) view.getTag();
        }
        c0132a.dD(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gEl.get(i);
        if (musicList != null) {
            c0132a.gEr.setText(musicList.name);
            c0132a.gEo.startLoad(musicList.image, 10, false);
            c0132a.gEs.setText(musicList.author);
            c0132a.gEt.setText(am.cX(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0132a.gEq.setVisibility(0);
            } else {
                c0132a.gEq.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.byI().byJ())) {
                c0132a.gEp.setImageResource(d.f.btn_icon_stop_video);
                c0132a.gEo.setDrawBorder(true);
                c0132a.gEu.setVisibility(0);
                c0132a.gEq.setVisibility(4);
                musicList.isLoading = false;
                c0132a.gEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gEm != null) {
                            a.this.gEm.b(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0132a.gEp.setImageResource(d.f.btn_icon_play_video_n);
                c0132a.gEo.setDrawBorder(false);
                c0132a.gEu.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gEm = bVar;
    }

    public void E(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0132a {
        private View cUK;
        public TbImageView gEo;
        public TbImageView gEp;
        public View gEq;
        public TextView gEr;
        public TextView gEs;
        public TextView gEt;
        public TextView gEu;

        public void dD(int i) {
            aj.i(this.gEr, d.C0080d.cp_cont_b);
            aj.i(this.gEs, d.C0080d.cp_cont_j);
            aj.i(this.gEt, d.C0080d.cp_cont_j);
            aj.i(this.gEu, d.C0080d.common_color_10140);
            aj.j(this.gEu, d.f.bg_music_choose);
            aj.k(this.cUK, d.C0080d.cp_bg_line_c);
            aj.c(this.gEp, d.f.btn_icon_play_video_n);
        }
    }
}
