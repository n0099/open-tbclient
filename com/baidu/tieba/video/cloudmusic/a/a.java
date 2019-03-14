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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> iVH = new ArrayList();
    private b iVI;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void ee(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.iVH.contains(musicList)) {
                    this.iVH.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.iVH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Au */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.iVH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0396a c0396a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cloud_music_item, viewGroup, false);
            c0396a = new C0396a();
            c0396a.iVL = (TbImageView) view.findViewById(d.g.music_state);
            c0396a.iVK = (TbImageView) view.findViewById(d.g.music_image);
            c0396a.iVK.setDrawerType(1);
            c0396a.iVK.setIsRound(true);
            c0396a.iVK.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            c0396a.iVK.setDefaultResource(d.f.bg_video_cloudmusic);
            c0396a.iVK.setDefaultBgResource(d.C0277d.transparent);
            c0396a.iVK.setBorderWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds4));
            c0396a.iVK.setBorderColor(al.getColor(d.C0277d.cp_link_tip_a));
            c0396a.iVM = view.findViewById(d.g.music_loading);
            c0396a.iVN = (TextView) view.findViewById(d.g.music_title);
            c0396a.iVO = (TextView) view.findViewById(d.g.music_author_name);
            c0396a.iVP = (TextView) view.findViewById(d.g.music_duration);
            c0396a.iVQ = (TextView) view.findViewById(d.g.music_choose);
            c0396a.dYo = view.findViewById(d.g.line);
            view.setTag(c0396a);
        } else {
            c0396a = (C0396a) view.getTag();
        }
        c0396a.ij(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.iVH.get(i);
        if (musicList != null) {
            c0396a.iVN.setText(musicList.name);
            c0396a.iVK.startLoad(musicList.image, 10, false);
            c0396a.iVO.setText(musicList.author);
            c0396a.iVP.setText(ap.hz(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0396a.iVM.setVisibility(0);
            } else {
                c0396a.iVM.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cje().cjf())) {
                c0396a.iVL.setImageResource(d.f.btn_icon_stop_video);
                c0396a.iVK.setDrawBorder(true);
                c0396a.iVQ.setVisibility(0);
                c0396a.iVM.setVisibility(4);
                musicList.isLoading = false;
                c0396a.iVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.iVI != null) {
                            a.this.iVI.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0396a.iVL.setImageResource(d.f.btn_icon_play_video_n);
                c0396a.iVK.setDrawBorder(false);
                c0396a.iVQ.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.iVI = bVar;
    }

    public void L(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0396a {
        private View dYo;
        public TbImageView iVK;
        public TbImageView iVL;
        public View iVM;
        public TextView iVN;
        public TextView iVO;
        public TextView iVP;
        public TextView iVQ;

        public void ij(int i) {
            al.j(this.iVN, d.C0277d.cp_cont_b);
            al.j(this.iVO, d.C0277d.cp_cont_j);
            al.j(this.iVP, d.C0277d.cp_cont_j);
            al.j(this.iVQ, d.C0277d.common_color_10140);
            al.k(this.iVQ, d.f.bg_music_choose);
            al.l(this.dYo, d.C0277d.cp_bg_line_c);
            al.c(this.iVL, d.f.btn_icon_play_video_n);
        }
    }
}
