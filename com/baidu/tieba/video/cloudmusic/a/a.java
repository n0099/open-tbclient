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
    private List<CloudMusicData.MusicTagList.MusicList> gKP = new ArrayList();
    private b gKQ;
    private e mPageContext;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void dy(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.gKP.contains(musicList)) {
                    this.gKP.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gKP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: un */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.gKP.get(i);
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
            c0221a.gKT = (TbImageView) view2.findViewById(d.g.music_state);
            c0221a.gKS = (TbImageView) view2.findViewById(d.g.music_image);
            c0221a.gKS.setDrawerType(1);
            c0221a.gKS.setIsRound(true);
            c0221a.gKS.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0221a.gKS.setDefaultResource(d.f.bg_video_cloudmusic);
            c0221a.gKS.setDefaultBgResource(d.C0126d.transparent);
            c0221a.gKS.setBorderWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds4));
            c0221a.gKS.setBorderColor(ak.getColor(d.C0126d.cp_link_tip_a));
            c0221a.gKU = view2.findViewById(d.g.music_loading);
            c0221a.gKV = (TextView) view2.findViewById(d.g.music_title);
            c0221a.gKW = (TextView) view2.findViewById(d.g.music_author_name);
            c0221a.gKX = (TextView) view2.findViewById(d.g.music_duration);
            c0221a.gKY = (TextView) view2.findViewById(d.g.music_choose);
            c0221a.dLN = view2.findViewById(d.g.line);
            view2.setTag(c0221a);
        } else {
            c0221a = (C0221a) view2.getTag();
        }
        c0221a.dA(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.gKP.get(i);
        if (musicList != null) {
            c0221a.gKV.setText(musicList.name);
            c0221a.gKS.startLoad(musicList.image, 10, false);
            c0221a.gKW.setText(musicList.author);
            c0221a.gKX.setText(an.cV(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0221a.gKU.setVisibility(0);
            } else {
                c0221a.gKU.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.bwh().bwi())) {
                c0221a.gKT.setImageResource(d.f.btn_icon_stop_video);
                c0221a.gKS.setDrawBorder(true);
                c0221a.gKY.setVisibility(0);
                c0221a.gKU.setVisibility(4);
                musicList.isLoading = false;
                c0221a.gKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (a.this.gKQ != null) {
                            a.this.gKQ.a(view3, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0221a.gKT.setImageResource(d.f.btn_icon_play_video_n);
                c0221a.gKS.setDrawBorder(false);
                c0221a.gKY.setVisibility(8);
            }
        }
        return view2;
    }

    public void a(b bVar) {
        this.gKQ = bVar;
    }

    public void F(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0221a {
        private View dLN;
        public TbImageView gKS;
        public TbImageView gKT;
        public View gKU;
        public TextView gKV;
        public TextView gKW;
        public TextView gKX;
        public TextView gKY;

        public void dA(int i) {
            ak.h(this.gKV, d.C0126d.cp_cont_b);
            ak.h(this.gKW, d.C0126d.cp_cont_j);
            ak.h(this.gKX, d.C0126d.cp_cont_j);
            ak.h(this.gKY, d.C0126d.common_color_10140);
            ak.i(this.gKY, d.f.bg_music_choose);
            ak.j(this.dLN, d.C0126d.cp_bg_line_c);
            ak.c(this.gKT, d.f.btn_icon_play_video_n);
        }
    }
}
