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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> gXr = new ArrayList();
    private b gXs;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dG(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gXr.contains(musicList)) {
                    this.gXr.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gXr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uy */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gXr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0238a c0238a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.cloud_music_item, viewGroup, false);
            c0238a = new C0238a();
            c0238a.gXv = (TbImageView) view.findViewById(d.g.music_state);
            c0238a.gXu = (TbImageView) view.findViewById(d.g.music_image);
            c0238a.gXu.setDrawerType(1);
            c0238a.gXu.setIsRound(true);
            c0238a.gXu.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0238a.gXu.setDefaultResource(d.f.bg_video_cloudmusic);
            c0238a.gXu.setDefaultBgResource(d.C0141d.transparent);
            c0238a.gXu.setBorderWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds4));
            c0238a.gXu.setBorderColor(al.getColor(d.C0141d.cp_link_tip_a));
            c0238a.gXw = view.findViewById(d.g.music_loading);
            c0238a.gXx = (TextView) view.findViewById(d.g.music_title);
            c0238a.gXy = (TextView) view.findViewById(d.g.music_author_name);
            c0238a.gXz = (TextView) view.findViewById(d.g.music_duration);
            c0238a.gXA = (TextView) view.findViewById(d.g.music_choose);
            c0238a.dYc = view.findViewById(d.g.line);
            view.setTag(c0238a);
        } else {
            c0238a = (C0238a) view.getTag();
        }
        c0238a.dC(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gXr.get(i);
        if (musicList != null) {
            c0238a.gXx.setText(musicList.name);
            c0238a.gXu.startLoad(musicList.image, 10, false);
            c0238a.gXy.setText(musicList.author);
            c0238a.gXz.setText(ao.cX(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0238a.gXw.setVisibility(0);
            } else {
                c0238a.gXw.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bBm().bBn())) {
                c0238a.gXv.setImageResource(d.f.btn_icon_stop_video);
                c0238a.gXu.setDrawBorder(true);
                c0238a.gXA.setVisibility(0);
                c0238a.gXw.setVisibility(4);
                musicList.isLoading = false;
                c0238a.gXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.gXs != null) {
                            a.this.gXs.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0238a.gXv.setImageResource(d.f.btn_icon_play_video_n);
                c0238a.gXu.setDrawBorder(false);
                c0238a.gXA.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.gXs = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0238a {
        private View dYc;
        public TextView gXA;
        public TbImageView gXu;
        public TbImageView gXv;
        public View gXw;
        public TextView gXx;
        public TextView gXy;
        public TextView gXz;

        public void dC(int i) {
            al.h(this.gXx, d.C0141d.cp_cont_b);
            al.h(this.gXy, d.C0141d.cp_cont_j);
            al.h(this.gXz, d.C0141d.cp_cont_j);
            al.h(this.gXA, d.C0141d.common_color_10140);
            al.i(this.gXA, d.f.bg_music_choose);
            al.j(this.dYc, d.C0141d.cp_bg_line_c);
            al.c(this.gXv, d.f.btn_icon_play_video_n);
        }
    }
}
