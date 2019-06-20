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
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<CloudMusicData.MusicTagList.MusicList> joy = new ArrayList();
    private b joz;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void el(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.joy.contains(musicList)) {
                    this.joy.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.joy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: By */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.joy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0415a c0415a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0415a = new C0415a();
            c0415a.joC = (TbImageView) view.findViewById(R.id.music_state);
            c0415a.joB = (TbImageView) view.findViewById(R.id.music_image);
            c0415a.joB.setDrawerType(1);
            c0415a.joB.setIsRound(true);
            c0415a.joB.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0415a.joB.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0415a.joB.setDefaultBgResource(R.color.transparent);
            c0415a.joB.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            c0415a.joB.setBorderColor(al.getColor(R.color.cp_link_tip_a));
            c0415a.joD = view.findViewById(R.id.music_loading);
            c0415a.joE = (TextView) view.findViewById(R.id.music_title);
            c0415a.joF = (TextView) view.findViewById(R.id.music_author_name);
            c0415a.joG = (TextView) view.findViewById(R.id.music_duration);
            c0415a.joH = (TextView) view.findViewById(R.id.music_choose);
            c0415a.eim = view.findViewById(R.id.line);
            view.setTag(c0415a);
        } else {
            c0415a = (C0415a) view.getTag();
        }
        c0415a.iW(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.joy.get(i);
        if (musicList != null) {
            c0415a.joE.setText(musicList.name);
            c0415a.joB.startLoad(musicList.image, 10, false);
            c0415a.joF.setText(musicList.author);
            c0415a.joG.setText(ap.im(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0415a.joD.setVisibility(0);
            } else {
                c0415a.joD.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cri().crj())) {
                c0415a.joC.setImageResource(R.drawable.btn_icon_stop_video);
                c0415a.joB.setDrawBorder(true);
                c0415a.joH.setVisibility(0);
                c0415a.joD.setVisibility(4);
                musicList.isLoading = false;
                c0415a.joH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.joz != null) {
                            a.this.joz.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0415a.joC.setImageResource(R.drawable.btn_icon_play_video_n);
                c0415a.joB.setDrawBorder(false);
                c0415a.joH.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.joz = bVar;
    }

    public void Q(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0415a {
        private View eim;
        public TbImageView joB;
        public TbImageView joC;
        public View joD;
        public TextView joE;
        public TextView joF;
        public TextView joG;
        public TextView joH;

        public void iW(int i) {
            al.j(this.joE, R.color.cp_cont_b);
            al.j(this.joF, R.color.cp_cont_j);
            al.j(this.joG, R.color.cp_cont_j);
            al.j(this.joH, R.color.common_color_10140);
            al.k(this.joH, R.drawable.bg_music_choose);
            al.l(this.eim, R.color.cp_bg_line_c);
            al.c(this.joC, (int) R.drawable.btn_icon_play_video_n);
        }
    }
}
