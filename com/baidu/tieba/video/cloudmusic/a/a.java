package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> gLP = new ArrayList();
    private b gLQ;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dB(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gLP.contains(musicList)) {
                    this.gLP.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gLP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ul */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gLP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view2, ViewGroup viewGroup) {
        C0221a c0221a;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.cloud_music_item, viewGroup, false);
            c0221a = new C0221a();
            c0221a.gLT = (TbImageView) view2.findViewById(d.g.music_state);
            c0221a.gLS = (TbImageView) view2.findViewById(d.g.music_image);
            c0221a.gLS.setDrawerType(1);
            c0221a.gLS.setIsRound(true);
            c0221a.gLS.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0221a.gLS.setDefaultResource(d.f.bg_video_cloudmusic);
            c0221a.gLS.setDefaultBgResource(d.C0126d.transparent);
            c0221a.gLS.setBorderWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds4));
            c0221a.gLS.setBorderColor(ak.getColor(d.C0126d.cp_link_tip_a));
            c0221a.gLU = view2.findViewById(d.g.music_loading);
            c0221a.gLV = (TextView) view2.findViewById(d.g.music_title);
            c0221a.gLW = (TextView) view2.findViewById(d.g.music_author_name);
            c0221a.gLX = (TextView) view2.findViewById(d.g.music_duration);
            c0221a.gLY = (TextView) view2.findViewById(d.g.music_choose);
            c0221a.dMQ = view2.findViewById(d.g.line);
            view2.setTag(c0221a);
        } else {
            c0221a = (C0221a) view2.getTag();
        }
        c0221a.dA(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gLP.get(i);
        if (musicList != null) {
            c0221a.gLV.setText(musicList.name);
            c0221a.gLS.startLoad(musicList.image, 10, false);
            c0221a.gLW.setText(musicList.author);
            c0221a.gLX.setText(an.cV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0221a.gLU.setVisibility(0);
            } else {
                c0221a.gLU.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bwf().bwg())) {
                c0221a.gLT.setImageResource(d.f.btn_icon_stop_video);
                c0221a.gLS.setDrawBorder(true);
                c0221a.gLY.setVisibility(0);
                c0221a.gLU.setVisibility(4);
                musicList.isLoading = false;
                c0221a.gLY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (a.this.gLQ != null) {
                            a.this.gLQ.a(view3, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0221a.gLT.setImageResource(d.f.btn_icon_play_video_n);
                c0221a.gLS.setDrawBorder(false);
                c0221a.gLY.setVisibility(8);
            }
        }
        return view2;
    }

    public void a(b bVar) {
        this.gLQ = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0221a {
        private View dMQ;
        public TbImageView gLS;
        public TbImageView gLT;
        public View gLU;
        public TextView gLV;
        public TextView gLW;
        public TextView gLX;
        public TextView gLY;

        public void dA(int i) {
            ak.h(this.gLV, d.C0126d.cp_cont_b);
            ak.h(this.gLW, d.C0126d.cp_cont_j);
            ak.h(this.gLX, d.C0126d.cp_cont_j);
            ak.h(this.gLY, d.C0126d.common_color_10140);
            ak.i(this.gLY, d.f.bg_music_choose);
            ak.j(this.dMQ, d.C0126d.cp_bg_line_c);
            ak.c(this.gLT, d.f.btn_icon_play_video_n);
        }
    }
}
