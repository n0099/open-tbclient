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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eCK;
    private List<CloudMusicData.MusicTagList.MusicList> ngT = new ArrayList();
    private b ngU;

    /* loaded from: classes23.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eCK = eVar;
    }

    public void fI(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.ngT.contains(musicList)) {
                    this.ngT.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ngT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ks */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.ngT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0843a c0843a;
        if (view == null) {
            view = LayoutInflater.from(this.eCK.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0843a = new C0843a();
            c0843a.ngX = (TbImageView) view.findViewById(R.id.music_state);
            c0843a.ngW = (TbImageView) view.findViewById(R.id.music_image);
            c0843a.ngW.setDrawerType(1);
            c0843a.ngW.setIsRound(true);
            c0843a.ngW.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0843a.ngW.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0843a.ngW.setDefaultBgResource(R.color.transparent);
            c0843a.ngW.setBorderWidth(l.getDimens(this.eCK.getPageActivity(), R.dimen.ds4));
            c0843a.ngW.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0843a.ngW.setConrers(15);
            c0843a.ngY = view.findViewById(R.id.music_loading);
            c0843a.ngZ = (TextView) view.findViewById(R.id.music_title);
            c0843a.nha = (TextView) view.findViewById(R.id.music_author_name);
            c0843a.nhb = (TextView) view.findViewById(R.id.music_duration);
            c0843a.nhc = (TextView) view.findViewById(R.id.music_choose);
            c0843a.hzG = view.findViewById(R.id.line);
            view.setTag(c0843a);
        } else {
            c0843a = (C0843a) view.getTag();
        }
        c0843a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.ngT.get(i);
        if (musicList != null) {
            c0843a.ngZ.setText(musicList.name);
            c0843a.ngW.startLoad(musicList.image, 10, false);
            c0843a.nha.setText(musicList.author);
            c0843a.nhb.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0843a.ngY.setVisibility(0);
            } else {
                c0843a.ngY.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dMh().dMi())) {
                c0843a.ngX.setImageResource(R.drawable.btn_icon_stop_video);
                c0843a.ngW.setDrawBorder(true);
                c0843a.nhc.setVisibility(0);
                c0843a.ngY.setVisibility(4);
                musicList.isLoading = false;
                c0843a.nhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.ngU != null) {
                            a.this.ngU.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0843a.ngX.setImageResource(R.drawable.btn_icon_play_video_n);
                c0843a.ngW.setDrawBorder(false);
                c0843a.nhc.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.ngU = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0843a {
        private View hzG;
        public TbImageView ngW;
        public TbImageView ngX;
        public View ngY;
        public TextView ngZ;
        public TextView nha;
        public TextView nhb;
        public TextView nhc;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.ngZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.nha, R.color.cp_cont_j);
            ap.setViewTextColor(this.nhb, R.color.cp_cont_j);
            ap.setViewTextColor(this.nhc, R.color.common_color_10140);
            ap.setBackgroundResource(this.nhc, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hzG, R.color.cp_bg_line_c);
            ap.setImageResource(this.ngX, R.drawable.btn_icon_play_video_n);
        }
    }
}
