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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> jvM = new ArrayList();
    private b jvN;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void en(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.jvM.contains(musicList)) {
                    this.jvM.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jvM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ch */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.jvM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0420a c0420a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0420a = new C0420a();
            c0420a.jvQ = (TbImageView) view.findViewById(R.id.music_state);
            c0420a.jvP = (TbImageView) view.findViewById(R.id.music_image);
            c0420a.jvP.setDrawerType(1);
            c0420a.jvP.setIsRound(true);
            c0420a.jvP.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0420a.jvP.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0420a.jvP.setDefaultBgResource(R.color.transparent);
            c0420a.jvP.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            c0420a.jvP.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0420a.jvR = view.findViewById(R.id.music_loading);
            c0420a.jvS = (TextView) view.findViewById(R.id.music_title);
            c0420a.jvT = (TextView) view.findViewById(R.id.music_author_name);
            c0420a.jvU = (TextView) view.findViewById(R.id.music_duration);
            c0420a.jvV = (TextView) view.findViewById(R.id.music_choose);
            c0420a.enk = view.findViewById(R.id.line);
            view.setTag(c0420a);
        } else {
            c0420a = (C0420a) view.getTag();
        }
        c0420a.jd(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.jvM.get(i);
        if (musicList != null) {
            c0420a.jvS.setText(musicList.name);
            c0420a.jvP.startLoad(musicList.image, 10, false);
            c0420a.jvT.setText(musicList.author);
            c0420a.jvU.setText(aq.is(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0420a.jvR.setVisibility(0);
            } else {
                c0420a.jvR.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cup().cuq())) {
                c0420a.jvQ.setImageResource(R.drawable.btn_icon_stop_video);
                c0420a.jvP.setDrawBorder(true);
                c0420a.jvV.setVisibility(0);
                c0420a.jvR.setVisibility(4);
                musicList.isLoading = false;
                c0420a.jvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.jvN != null) {
                            a.this.jvN.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0420a.jvQ.setImageResource(R.drawable.btn_icon_play_video_n);
                c0420a.jvP.setDrawBorder(false);
                c0420a.jvV.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.jvN = bVar;
    }

    public void S(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0420a {
        private View enk;
        public TbImageView jvP;
        public TbImageView jvQ;
        public View jvR;
        public TextView jvS;
        public TextView jvT;
        public TextView jvU;
        public TextView jvV;

        public void jd(int i) {
            am.j(this.jvS, R.color.cp_cont_b);
            am.j(this.jvT, R.color.cp_cont_j);
            am.j(this.jvU, R.color.cp_cont_j);
            am.j(this.jvV, R.color.common_color_10140);
            am.k(this.jvV, R.drawable.bg_music_choose);
            am.l(this.enk, R.color.cp_bg_line_c);
            am.c(this.jvQ, (int) R.drawable.btn_icon_play_video_n);
        }
    }
}
