package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private f eVB;
    private List<CloudMusicData.MusicTagList.MusicList> nLN = new ArrayList();
    private b nLO;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(f fVar) {
        this.eVB = fVar;
    }

    public void fX(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nLN.contains(musicList)) {
                    this.nLN.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nLN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KB */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nLN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0886a c0886a;
        if (view == null) {
            view = LayoutInflater.from(this.eVB.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0886a = new C0886a();
            c0886a.nLR = (TbImageView) view.findViewById(R.id.music_state);
            c0886a.nLQ = (TbImageView) view.findViewById(R.id.music_image);
            c0886a.nLQ.setDrawerType(1);
            c0886a.nLQ.setIsRound(true);
            c0886a.nLQ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0886a.nLQ.setDefaultBgResource(R.color.transparent);
            c0886a.nLQ.setBorderWidth(l.getDimens(this.eVB.getPageActivity(), R.dimen.ds4));
            c0886a.nLQ.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0886a.nLQ.setConrers(15);
            c0886a.nLS = view.findViewById(R.id.music_loading);
            c0886a.nLT = (TextView) view.findViewById(R.id.music_title);
            c0886a.nLU = (TextView) view.findViewById(R.id.music_author_name);
            c0886a.nLV = (TextView) view.findViewById(R.id.music_duration);
            c0886a.nLW = (TextView) view.findViewById(R.id.music_choose);
            c0886a.him = view.findViewById(R.id.line);
            view.setTag(c0886a);
        } else {
            c0886a = (C0886a) view.getTag();
        }
        c0886a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nLN.get(i);
        if (musicList != null) {
            c0886a.nLT.setText(musicList.name);
            c0886a.nLQ.startLoad(musicList.image, 10, false);
            c0886a.nLU.setText(musicList.author);
            c0886a.nLV.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0886a.nLS.setVisibility(0);
            } else {
                c0886a.nLS.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dSu().dSv())) {
                c0886a.nLR.setImageResource(R.drawable.btn_icon_stop_video);
                c0886a.nLQ.setDrawBorder(true);
                c0886a.nLW.setVisibility(0);
                c0886a.nLS.setVisibility(4);
                musicList.isLoading = false;
                c0886a.nLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nLO != null) {
                            a.this.nLO.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0886a.nLR.setImageResource(R.drawable.btn_icon_play_video_n);
                c0886a.nLQ.setDrawBorder(false);
                c0886a.nLW.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nLO = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0886a {
        private View him;
        public TbImageView nLQ;
        public TbImageView nLR;
        public View nLS;
        public TextView nLT;
        public TextView nLU;
        public TextView nLV;
        public TextView nLW;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nLT, R.color.CAM_X0105);
            ap.setViewTextColor(this.nLU, R.color.CAM_X0107);
            ap.setViewTextColor(this.nLV, R.color.CAM_X0107);
            ap.setViewTextColor(this.nLW, R.color.common_color_10140);
            ap.setBackgroundResource(this.nLW, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.him, R.color.CAM_X0204);
            ap.setImageResource(this.nLR, R.drawable.btn_icon_play_video_n);
        }
    }
}
