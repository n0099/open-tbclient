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
    private List<CloudMusicData.MusicTagList.MusicList> jyi = new ArrayList();
    private b jyj;
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
                if (!this.jyi.contains(musicList)) {
                    this.jyi.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jyi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cl */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.jyi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0431a c0431a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0431a = new C0431a();
            c0431a.jym = (TbImageView) view.findViewById(R.id.music_state);
            c0431a.jyl = (TbImageView) view.findViewById(R.id.music_image);
            c0431a.jyl.setDrawerType(1);
            c0431a.jyl.setIsRound(true);
            c0431a.jyl.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0431a.jyl.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0431a.jyl.setDefaultBgResource(R.color.transparent);
            c0431a.jyl.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            c0431a.jyl.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0431a.jyn = view.findViewById(R.id.music_loading);
            c0431a.jyo = (TextView) view.findViewById(R.id.music_title);
            c0431a.jyp = (TextView) view.findViewById(R.id.music_author_name);
            c0431a.jyq = (TextView) view.findViewById(R.id.music_duration);
            c0431a.jyr = (TextView) view.findViewById(R.id.music_choose);
            c0431a.eoV = view.findViewById(R.id.line);
            view.setTag(c0431a);
        } else {
            c0431a = (C0431a) view.getTag();
        }
        c0431a.jg(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.jyi.get(i);
        if (musicList != null) {
            c0431a.jyo.setText(musicList.name);
            c0431a.jyl.startLoad(musicList.image, 10, false);
            c0431a.jyp.setText(musicList.author);
            c0431a.jyq.setText(aq.it(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0431a.jyn.setVisibility(0);
            } else {
                c0431a.jyn.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cvd().cve())) {
                c0431a.jym.setImageResource(R.drawable.btn_icon_stop_video);
                c0431a.jyl.setDrawBorder(true);
                c0431a.jyr.setVisibility(0);
                c0431a.jyn.setVisibility(4);
                musicList.isLoading = false;
                c0431a.jyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.jyj != null) {
                            a.this.jyj.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0431a.jym.setImageResource(R.drawable.btn_icon_play_video_n);
                c0431a.jyl.setDrawBorder(false);
                c0431a.jyr.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.jyj = bVar;
    }

    public void T(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0431a {
        private View eoV;
        public TbImageView jyl;
        public TbImageView jym;
        public View jyn;
        public TextView jyo;
        public TextView jyp;
        public TextView jyq;
        public TextView jyr;

        public void jg(int i) {
            am.j(this.jyo, R.color.cp_cont_b);
            am.j(this.jyp, R.color.cp_cont_j);
            am.j(this.jyq, R.color.cp_cont_j);
            am.j(this.jyr, R.color.common_color_10140);
            am.k(this.jyr, R.drawable.bg_music_choose);
            am.l(this.eoV, R.color.cp_bg_line_c);
            am.c(this.jym, (int) R.drawable.btn_icon_play_video_n);
        }
    }
}
