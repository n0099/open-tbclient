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
    private List<CloudMusicData.MusicTagList.MusicList> juF = new ArrayList();
    private b juG;
    private e mPageContext;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void eo(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.juF.contains(musicList)) {
                    this.juF.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.juF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cf */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.juF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0414a c0414a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0414a = new C0414a();
            c0414a.juJ = (TbImageView) view.findViewById(R.id.music_state);
            c0414a.juI = (TbImageView) view.findViewById(R.id.music_image);
            c0414a.juI.setDrawerType(1);
            c0414a.juI.setIsRound(true);
            c0414a.juI.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0414a.juI.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0414a.juI.setDefaultBgResource(R.color.transparent);
            c0414a.juI.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            c0414a.juI.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0414a.juK = view.findViewById(R.id.music_loading);
            c0414a.juL = (TextView) view.findViewById(R.id.music_title);
            c0414a.juM = (TextView) view.findViewById(R.id.music_author_name);
            c0414a.juN = (TextView) view.findViewById(R.id.music_duration);
            c0414a.juO = (TextView) view.findViewById(R.id.music_choose);
            c0414a.enc = view.findViewById(R.id.line);
            view.setTag(c0414a);
        } else {
            c0414a = (C0414a) view.getTag();
        }
        c0414a.jc(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.juF.get(i);
        if (musicList != null) {
            c0414a.juL.setText(musicList.name);
            c0414a.juI.startLoad(musicList.image, 10, false);
            c0414a.juM.setText(musicList.author);
            c0414a.juN.setText(aq.is(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0414a.juK.setVisibility(0);
            } else {
                c0414a.juK.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.ctT().ctU())) {
                c0414a.juJ.setImageResource(R.drawable.btn_icon_stop_video);
                c0414a.juI.setDrawBorder(true);
                c0414a.juO.setVisibility(0);
                c0414a.juK.setVisibility(4);
                musicList.isLoading = false;
                c0414a.juO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.juG != null) {
                            a.this.juG.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0414a.juJ.setImageResource(R.drawable.btn_icon_play_video_n);
                c0414a.juI.setDrawBorder(false);
                c0414a.juO.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.juG = bVar;
    }

    public void S(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0414a {
        private View enc;
        public TbImageView juI;
        public TbImageView juJ;
        public View juK;
        public TextView juL;
        public TextView juM;
        public TextView juN;
        public TextView juO;

        public void jc(int i) {
            am.j(this.juL, R.color.cp_cont_b);
            am.j(this.juM, R.color.cp_cont_j);
            am.j(this.juN, R.color.cp_cont_j);
            am.j(this.juO, R.color.common_color_10140);
            am.k(this.juO, R.drawable.bg_music_choose);
            am.l(this.enc, R.color.cp_bg_line_c);
            am.c(this.juJ, (int) R.drawable.btn_icon_play_video_n);
        }
    }
}
