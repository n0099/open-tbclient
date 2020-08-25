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
    private e efK;
    private List<CloudMusicData.MusicTagList.MusicList> muC = new ArrayList();
    private b muD;

    /* loaded from: classes17.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.efK = eVar;
    }

    public void fn(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.muC.contains(musicList)) {
                    this.muC.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.muC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: IQ */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.muC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0813a c0813a;
        if (view == null) {
            view = LayoutInflater.from(this.efK.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0813a = new C0813a();
            c0813a.muG = (TbImageView) view.findViewById(R.id.music_state);
            c0813a.muF = (TbImageView) view.findViewById(R.id.music_image);
            c0813a.muF.setDrawerType(1);
            c0813a.muF.setIsRound(true);
            c0813a.muF.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0813a.muF.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0813a.muF.setDefaultBgResource(R.color.transparent);
            c0813a.muF.setBorderWidth(l.getDimens(this.efK.getPageActivity(), R.dimen.ds4));
            c0813a.muF.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0813a.muF.setConrers(15);
            c0813a.muH = view.findViewById(R.id.music_loading);
            c0813a.muI = (TextView) view.findViewById(R.id.music_title);
            c0813a.muJ = (TextView) view.findViewById(R.id.music_author_name);
            c0813a.muK = (TextView) view.findViewById(R.id.music_duration);
            c0813a.muL = (TextView) view.findViewById(R.id.music_choose);
            c0813a.gUZ = view.findViewById(R.id.line);
            view.setTag(c0813a);
        } else {
            c0813a = (C0813a) view.getTag();
        }
        c0813a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.muC.get(i);
        if (musicList != null) {
            c0813a.muI.setText(musicList.name);
            c0813a.muF.startLoad(musicList.image, 10, false);
            c0813a.muJ.setText(musicList.author);
            c0813a.muK.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0813a.muH.setVisibility(0);
            } else {
                c0813a.muH.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dBk().dBl())) {
                c0813a.muG.setImageResource(R.drawable.btn_icon_stop_video);
                c0813a.muF.setDrawBorder(true);
                c0813a.muL.setVisibility(0);
                c0813a.muH.setVisibility(4);
                musicList.isLoading = false;
                c0813a.muL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.muD != null) {
                            a.this.muD.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0813a.muG.setImageResource(R.drawable.btn_icon_play_video_n);
                c0813a.muF.setDrawBorder(false);
                c0813a.muL.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.muD = bVar;
    }

    public void ag(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0813a {
        private View gUZ;
        public TbImageView muF;
        public TbImageView muG;
        public View muH;
        public TextView muI;
        public TextView muJ;
        public TextView muK;
        public TextView muL;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.muI, R.color.cp_cont_b);
            ap.setViewTextColor(this.muJ, R.color.cp_cont_j);
            ap.setViewTextColor(this.muK, R.color.cp_cont_j);
            ap.setViewTextColor(this.muL, R.color.common_color_10140);
            ap.setBackgroundResource(this.muL, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.gUZ, R.color.cp_bg_line_c);
            ap.setImageResource(this.muG, R.drawable.btn_icon_play_video_n);
        }
    }
}
