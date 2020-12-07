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
    private List<CloudMusicData.MusicTagList.MusicList> nBZ = new ArrayList();
    private b nCa;

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
                if (!this.nBZ.contains(musicList)) {
                    this.nBZ.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nBZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ma */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nBZ.get(i);
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
            c0877a.nCd = (TbImageView) view.findViewById(R.id.music_state);
            c0877a.nCc = (TbImageView) view.findViewById(R.id.music_image);
            c0877a.nCc.setDrawerType(1);
            c0877a.nCc.setIsRound(true);
            c0877a.nCc.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0877a.nCc.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0877a.nCc.setDefaultBgResource(R.color.transparent);
            c0877a.nCc.setBorderWidth(l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds4));
            c0877a.nCc.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0877a.nCc.setConrers(15);
            c0877a.nCe = view.findViewById(R.id.music_loading);
            c0877a.nCf = (TextView) view.findViewById(R.id.music_title);
            c0877a.nCg = (TextView) view.findViewById(R.id.music_author_name);
            c0877a.nCh = (TextView) view.findViewById(R.id.music_duration);
            c0877a.nCi = (TextView) view.findViewById(R.id.music_choose);
            c0877a.hOR = view.findViewById(R.id.line);
            view.setTag(c0877a);
        } else {
            c0877a = (C0877a) view.getTag();
        }
        c0877a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nBZ.get(i);
        if (musicList != null) {
            c0877a.nCf.setText(musicList.name);
            c0877a.nCc.startLoad(musicList.image, 10, false);
            c0877a.nCg.setText(musicList.author);
            c0877a.nCh.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0877a.nCe.setVisibility(0);
            } else {
                c0877a.nCe.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dUa().dUb())) {
                c0877a.nCd.setImageResource(R.drawable.btn_icon_stop_video);
                c0877a.nCc.setDrawBorder(true);
                c0877a.nCi.setVisibility(0);
                c0877a.nCe.setVisibility(4);
                musicList.isLoading = false;
                c0877a.nCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nCa != null) {
                            a.this.nCa.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0877a.nCd.setImageResource(R.drawable.btn_icon_play_video_n);
                c0877a.nCc.setDrawBorder(false);
                c0877a.nCi.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nCa = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0877a {
        private View hOR;
        public TbImageView nCc;
        public TbImageView nCd;
        public View nCe;
        public TextView nCf;
        public TextView nCg;
        public TextView nCh;
        public TextView nCi;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nCf, R.color.CAM_X0105);
            ap.setViewTextColor(this.nCg, R.color.CAM_X0107);
            ap.setViewTextColor(this.nCh, R.color.CAM_X0107);
            ap.setViewTextColor(this.nCi, R.color.common_color_10140);
            ap.setBackgroundResource(this.nCi, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hOR, R.color.CAM_X0204);
            ap.setImageResource(this.nCd, R.drawable.btn_icon_play_video_n);
        }
    }
}
