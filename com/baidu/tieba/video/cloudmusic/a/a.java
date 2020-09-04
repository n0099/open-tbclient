package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e efO;
    private List<CloudMusicData.MusicTagList.MusicList> muU = new ArrayList();
    private b muV;

    /* loaded from: classes17.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.efO = eVar;
    }

    public void fn(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.muU.contains(musicList)) {
                    this.muU.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.muU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: IQ */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.muU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0813a c0813a;
        if (view == null) {
            view = LayoutInflater.from(this.efO.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0813a = new C0813a();
            c0813a.muY = (TbImageView) view.findViewById(R.id.music_state);
            c0813a.muX = (TbImageView) view.findViewById(R.id.music_image);
            c0813a.muX.setDrawerType(1);
            c0813a.muX.setIsRound(true);
            c0813a.muX.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0813a.muX.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0813a.muX.setDefaultBgResource(R.color.transparent);
            c0813a.muX.setBorderWidth(l.getDimens(this.efO.getPageActivity(), R.dimen.ds4));
            c0813a.muX.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0813a.muX.setConrers(15);
            c0813a.muZ = view.findViewById(R.id.music_loading);
            c0813a.mva = (TextView) view.findViewById(R.id.music_title);
            c0813a.mvb = (TextView) view.findViewById(R.id.music_author_name);
            c0813a.mvc = (TextView) view.findViewById(R.id.music_duration);
            c0813a.mvd = (TextView) view.findViewById(R.id.music_choose);
            c0813a.gVd = view.findViewById(R.id.line);
            view.setTag(c0813a);
        } else {
            c0813a = (C0813a) view.getTag();
        }
        c0813a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.muU.get(i);
        if (musicList != null) {
            c0813a.mva.setText(musicList.name);
            c0813a.muX.startLoad(musicList.image, 10, false);
            c0813a.mvb.setText(musicList.author);
            c0813a.mvc.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0813a.muZ.setVisibility(0);
            } else {
                c0813a.muZ.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dBt().dBu())) {
                c0813a.muY.setImageResource(R.drawable.btn_icon_stop_video);
                c0813a.muX.setDrawBorder(true);
                c0813a.mvd.setVisibility(0);
                c0813a.muZ.setVisibility(4);
                musicList.isLoading = false;
                c0813a.mvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.muV != null) {
                            a.this.muV.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0813a.muY.setImageResource(R.drawable.btn_icon_play_video_n);
                c0813a.muX.setDrawBorder(false);
                c0813a.mvd.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.muV = bVar;
    }

    public void ag(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0813a {
        private View gVd;
        public TbImageView muX;
        public TbImageView muY;
        public View muZ;
        public TextView mva;
        public TextView mvb;
        public TextView mvc;
        public TextView mvd;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.mva, R.color.cp_cont_b);
            ap.setViewTextColor(this.mvb, R.color.cp_cont_j);
            ap.setViewTextColor(this.mvc, R.color.cp_cont_j);
            ap.setViewTextColor(this.mvd, R.color.common_color_10140);
            ap.setBackgroundResource(this.mvd, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.gVd, R.color.cp_bg_line_c);
            ap.setImageResource(this.muY, R.drawable.btn_icon_play_video_n);
        }
    }
}
