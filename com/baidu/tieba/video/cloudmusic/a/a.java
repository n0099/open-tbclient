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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e dJb;
    private List<CloudMusicData.MusicTagList.MusicList> lAH = new ArrayList();
    private b lAI;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dJb = eVar;
    }

    public void eK(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.lAH.contains(musicList)) {
                    this.lAH.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lAH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EU */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lAH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0734a c0734a;
        if (view == null) {
            view = LayoutInflater.from(this.dJb.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0734a = new C0734a();
            c0734a.lAL = (TbImageView) view.findViewById(R.id.music_state);
            c0734a.lAK = (TbImageView) view.findViewById(R.id.music_image);
            c0734a.lAK.setDrawerType(1);
            c0734a.lAK.setIsRound(true);
            c0734a.lAK.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0734a.lAK.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0734a.lAK.setDefaultBgResource(R.color.transparent);
            c0734a.lAK.setBorderWidth(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds4));
            c0734a.lAK.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0734a.lAK.setConrers(15);
            c0734a.lAM = view.findViewById(R.id.music_loading);
            c0734a.lAN = (TextView) view.findViewById(R.id.music_title);
            c0734a.lAO = (TextView) view.findViewById(R.id.music_author_name);
            c0734a.lAP = (TextView) view.findViewById(R.id.music_duration);
            c0734a.lAQ = (TextView) view.findViewById(R.id.music_choose);
            c0734a.gpZ = view.findViewById(R.id.line);
            view.setTag(c0734a);
        } else {
            c0734a = (C0734a) view.getTag();
        }
        c0734a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lAH.get(i);
        if (musicList != null) {
            c0734a.lAN.setText(musicList.name);
            c0734a.lAK.startLoad(musicList.image, 10, false);
            c0734a.lAO.setText(musicList.author);
            c0734a.lAP.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0734a.lAM.setVisibility(0);
            } else {
                c0734a.lAM.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dhZ().dia())) {
                c0734a.lAL.setImageResource(R.drawable.btn_icon_stop_video);
                c0734a.lAK.setDrawBorder(true);
                c0734a.lAQ.setVisibility(0);
                c0734a.lAM.setVisibility(4);
                musicList.isLoading = false;
                c0734a.lAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lAI != null) {
                            a.this.lAI.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0734a.lAL.setImageResource(R.drawable.btn_icon_play_video_n);
                c0734a.lAK.setDrawBorder(false);
                c0734a.lAQ.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lAI = bVar;
    }

    public void ac(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0734a {
        private View gpZ;
        public TbImageView lAK;
        public TbImageView lAL;
        public View lAM;
        public TextView lAN;
        public TextView lAO;
        public TextView lAP;
        public TextView lAQ;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.lAN, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lAO, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lAP, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lAQ, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.lAQ, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.gpZ, R.color.cp_bg_line_c);
            am.setImageResource(this.lAL, R.drawable.btn_icon_play_video_n);
        }
    }
}
