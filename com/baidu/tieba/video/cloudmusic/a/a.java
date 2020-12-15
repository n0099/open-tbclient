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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eNZ;
    private List<CloudMusicData.MusicTagList.MusicList> nCb = new ArrayList();
    private b nCc;

    /* loaded from: classes23.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eNZ = eVar;
    }

    public void ge(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nCb.contains(musicList)) {
                    this.nCb.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nCb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ma */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nCb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0877a c0877a;
        if (view == null) {
            view = LayoutInflater.from(this.eNZ.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0877a = new C0877a();
            c0877a.nCf = (TbImageView) view.findViewById(R.id.music_state);
            c0877a.nCe = (TbImageView) view.findViewById(R.id.music_image);
            c0877a.nCe.setDrawerType(1);
            c0877a.nCe.setIsRound(true);
            c0877a.nCe.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0877a.nCe.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0877a.nCe.setDefaultBgResource(R.color.transparent);
            c0877a.nCe.setBorderWidth(l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds4));
            c0877a.nCe.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0877a.nCe.setConrers(15);
            c0877a.nCg = view.findViewById(R.id.music_loading);
            c0877a.nCh = (TextView) view.findViewById(R.id.music_title);
            c0877a.nCi = (TextView) view.findViewById(R.id.music_author_name);
            c0877a.nCj = (TextView) view.findViewById(R.id.music_duration);
            c0877a.nCk = (TextView) view.findViewById(R.id.music_choose);
            c0877a.hOT = view.findViewById(R.id.line);
            view.setTag(c0877a);
        } else {
            c0877a = (C0877a) view.getTag();
        }
        c0877a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nCb.get(i);
        if (musicList != null) {
            c0877a.nCh.setText(musicList.name);
            c0877a.nCe.startLoad(musicList.image, 10, false);
            c0877a.nCi.setText(musicList.author);
            c0877a.nCj.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0877a.nCg.setVisibility(0);
            } else {
                c0877a.nCg.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dUb().dUc())) {
                c0877a.nCf.setImageResource(R.drawable.btn_icon_stop_video);
                c0877a.nCe.setDrawBorder(true);
                c0877a.nCk.setVisibility(0);
                c0877a.nCg.setVisibility(4);
                musicList.isLoading = false;
                c0877a.nCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nCc != null) {
                            a.this.nCc.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0877a.nCf.setImageResource(R.drawable.btn_icon_play_video_n);
                c0877a.nCe.setDrawBorder(false);
                c0877a.nCk.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nCc = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0877a {
        private View hOT;
        public TbImageView nCe;
        public TbImageView nCf;
        public View nCg;
        public TextView nCh;
        public TextView nCi;
        public TextView nCj;
        public TextView nCk;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nCh, R.color.CAM_X0105);
            ap.setViewTextColor(this.nCi, R.color.CAM_X0107);
            ap.setViewTextColor(this.nCj, R.color.CAM_X0107);
            ap.setViewTextColor(this.nCk, R.color.common_color_10140);
            ap.setBackgroundResource(this.nCk, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hOT, R.color.CAM_X0204);
            ap.setImageResource(this.nCf, R.drawable.btn_icon_play_video_n);
        }
    }
}
