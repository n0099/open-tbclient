package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e dWk;
    private List<CloudMusicData.MusicTagList.MusicList> mcP = new ArrayList();
    private b mcQ;

    /* loaded from: classes17.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dWk = eVar;
    }

    public void ff(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.mcP.contains(musicList)) {
                    this.mcP.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mcP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Gu */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.mcP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0761a c0761a;
        if (view == null) {
            view = LayoutInflater.from(this.dWk.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0761a = new C0761a();
            c0761a.mcT = (TbImageView) view.findViewById(R.id.music_state);
            c0761a.mcS = (TbImageView) view.findViewById(R.id.music_image);
            c0761a.mcS.setDrawerType(1);
            c0761a.mcS.setIsRound(true);
            c0761a.mcS.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0761a.mcS.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0761a.mcS.setDefaultBgResource(R.color.transparent);
            c0761a.mcS.setBorderWidth(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds4));
            c0761a.mcS.setBorderColor(ao.getColor(R.color.cp_link_tip_a));
            c0761a.mcS.setConrers(15);
            c0761a.mcU = view.findViewById(R.id.music_loading);
            c0761a.mcV = (TextView) view.findViewById(R.id.music_title);
            c0761a.mcW = (TextView) view.findViewById(R.id.music_author_name);
            c0761a.mcX = (TextView) view.findViewById(R.id.music_duration);
            c0761a.mcY = (TextView) view.findViewById(R.id.music_choose);
            c0761a.gIw = view.findViewById(R.id.line);
            view.setTag(c0761a);
        } else {
            c0761a = (C0761a) view.getTag();
        }
        c0761a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.mcP.get(i);
        if (musicList != null) {
            c0761a.mcV.setText(musicList.name);
            c0761a.mcS.startLoad(musicList.image, 10, false);
            c0761a.mcW.setText(musicList.author);
            c0761a.mcX.setText(as.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0761a.mcU.setVisibility(0);
            } else {
                c0761a.mcU.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dpO().dpP())) {
                c0761a.mcT.setImageResource(R.drawable.btn_icon_stop_video);
                c0761a.mcS.setDrawBorder(true);
                c0761a.mcY.setVisibility(0);
                c0761a.mcU.setVisibility(4);
                musicList.isLoading = false;
                c0761a.mcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mcQ != null) {
                            a.this.mcQ.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0761a.mcT.setImageResource(R.drawable.btn_icon_play_video_n);
                c0761a.mcS.setDrawBorder(false);
                c0761a.mcY.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.mcQ = bVar;
    }

    public void ae(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0761a {
        private View gIw;
        public TbImageView mcS;
        public TbImageView mcT;
        public View mcU;
        public TextView mcV;
        public TextView mcW;
        public TextView mcX;
        public TextView mcY;

        public void onChangeSkin(int i) {
            ao.setViewTextColor(this.mcV, R.color.cp_cont_b);
            ao.setViewTextColor(this.mcW, R.color.cp_cont_j);
            ao.setViewTextColor(this.mcX, R.color.cp_cont_j);
            ao.setViewTextColor(this.mcY, R.color.common_color_10140);
            ao.setBackgroundResource(this.mcY, R.drawable.bg_music_choose);
            ao.setBackgroundColor(this.gIw, R.color.cp_bg_line_c);
            ao.setImageResource(this.mcT, R.drawable.btn_icon_play_video_n);
        }
    }
}
