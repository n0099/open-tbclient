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
    private List<CloudMusicData.MusicTagList.MusicList> jot = new ArrayList();
    private b jou;
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
                if (!this.jot.contains(musicList)) {
                    this.jot.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jot.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: By */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.jot.get(i);
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
            c0415a.jox = (TbImageView) view.findViewById(R.id.music_state);
            c0415a.jow = (TbImageView) view.findViewById(R.id.music_image);
            c0415a.jow.setDrawerType(1);
            c0415a.jow.setIsRound(true);
            c0415a.jow.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0415a.jow.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0415a.jow.setDefaultBgResource(R.color.transparent);
            c0415a.jow.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            c0415a.jow.setBorderColor(al.getColor(R.color.cp_link_tip_a));
            c0415a.joy = view.findViewById(R.id.music_loading);
            c0415a.joz = (TextView) view.findViewById(R.id.music_title);
            c0415a.joA = (TextView) view.findViewById(R.id.music_author_name);
            c0415a.joB = (TextView) view.findViewById(R.id.music_duration);
            c0415a.joC = (TextView) view.findViewById(R.id.music_choose);
            c0415a.eil = view.findViewById(R.id.line);
            view.setTag(c0415a);
        } else {
            c0415a = (C0415a) view.getTag();
        }
        c0415a.iW(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.jot.get(i);
        if (musicList != null) {
            c0415a.joz.setText(musicList.name);
            c0415a.jow.startLoad(musicList.image, 10, false);
            c0415a.joA.setText(musicList.author);
            c0415a.joB.setText(ap.im(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0415a.joy.setVisibility(0);
            } else {
                c0415a.joy.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.crf().crg())) {
                c0415a.jox.setImageResource(R.drawable.btn_icon_stop_video);
                c0415a.jow.setDrawBorder(true);
                c0415a.joC.setVisibility(0);
                c0415a.joy.setVisibility(4);
                musicList.isLoading = false;
                c0415a.joC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.jou != null) {
                            a.this.jou.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0415a.jox.setImageResource(R.drawable.btn_icon_play_video_n);
                c0415a.jow.setDrawBorder(false);
                c0415a.joC.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.jou = bVar;
    }

    public void Q(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0415a {
        private View eil;
        public TextView joA;
        public TextView joB;
        public TextView joC;
        public TbImageView jow;
        public TbImageView jox;
        public View joy;
        public TextView joz;

        public void iW(int i) {
            al.j(this.joz, R.color.cp_cont_b);
            al.j(this.joA, R.color.cp_cont_j);
            al.j(this.joB, R.color.cp_cont_j);
            al.j(this.joC, R.color.common_color_10140);
            al.k(this.joC, R.drawable.bg_music_choose);
            al.l(this.eil, R.color.cp_bg_line_c);
            al.c(this.jox, (int) R.drawable.btn_icon_play_video_n);
        }
    }
}
