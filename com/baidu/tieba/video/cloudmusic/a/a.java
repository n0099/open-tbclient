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
    private List<CloudMusicData.MusicTagList.MusicList> mcR = new ArrayList();
    private b mcS;

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
                if (!this.mcR.contains(musicList)) {
                    this.mcR.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mcR.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Gu */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.mcR.get(i);
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
            c0761a.mcV = (TbImageView) view.findViewById(R.id.music_state);
            c0761a.mcU = (TbImageView) view.findViewById(R.id.music_image);
            c0761a.mcU.setDrawerType(1);
            c0761a.mcU.setIsRound(true);
            c0761a.mcU.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0761a.mcU.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0761a.mcU.setDefaultBgResource(R.color.transparent);
            c0761a.mcU.setBorderWidth(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds4));
            c0761a.mcU.setBorderColor(ao.getColor(R.color.cp_link_tip_a));
            c0761a.mcU.setConrers(15);
            c0761a.mcW = view.findViewById(R.id.music_loading);
            c0761a.mcX = (TextView) view.findViewById(R.id.music_title);
            c0761a.mcY = (TextView) view.findViewById(R.id.music_author_name);
            c0761a.mcZ = (TextView) view.findViewById(R.id.music_duration);
            c0761a.mda = (TextView) view.findViewById(R.id.music_choose);
            c0761a.gIw = view.findViewById(R.id.line);
            view.setTag(c0761a);
        } else {
            c0761a = (C0761a) view.getTag();
        }
        c0761a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.mcR.get(i);
        if (musicList != null) {
            c0761a.mcX.setText(musicList.name);
            c0761a.mcU.startLoad(musicList.image, 10, false);
            c0761a.mcY.setText(musicList.author);
            c0761a.mcZ.setText(as.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0761a.mcW.setVisibility(0);
            } else {
                c0761a.mcW.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dpP().dpQ())) {
                c0761a.mcV.setImageResource(R.drawable.btn_icon_stop_video);
                c0761a.mcU.setDrawBorder(true);
                c0761a.mda.setVisibility(0);
                c0761a.mcW.setVisibility(4);
                musicList.isLoading = false;
                c0761a.mda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mcS != null) {
                            a.this.mcS.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0761a.mcV.setImageResource(R.drawable.btn_icon_play_video_n);
                c0761a.mcU.setDrawBorder(false);
                c0761a.mda.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.mcS = bVar;
    }

    public void ae(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0761a {
        private View gIw;
        public TbImageView mcU;
        public TbImageView mcV;
        public View mcW;
        public TextView mcX;
        public TextView mcY;
        public TextView mcZ;
        public TextView mda;

        public void onChangeSkin(int i) {
            ao.setViewTextColor(this.mcX, R.color.cp_cont_b);
            ao.setViewTextColor(this.mcY, R.color.cp_cont_j);
            ao.setViewTextColor(this.mcZ, R.color.cp_cont_j);
            ao.setViewTextColor(this.mda, R.color.common_color_10140);
            ao.setBackgroundResource(this.mda, R.drawable.bg_music_choose);
            ao.setBackgroundColor(this.gIw, R.color.cp_bg_line_c);
            ao.setImageResource(this.mcV, R.drawable.btn_icon_play_video_n);
        }
    }
}
