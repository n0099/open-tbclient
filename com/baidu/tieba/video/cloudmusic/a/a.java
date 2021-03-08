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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private f eXa;
    private List<CloudMusicData.MusicTagList.MusicList> nNS = new ArrayList();
    private b nNT;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(f fVar) {
        this.eXa = fVar;
    }

    public void fX(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nNS.contains(musicList)) {
                    this.nNS.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nNS.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KG */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nNS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0892a c0892a;
        if (view == null) {
            view = LayoutInflater.from(this.eXa.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0892a = new C0892a();
            c0892a.nNW = (TbImageView) view.findViewById(R.id.music_state);
            c0892a.nNV = (TbImageView) view.findViewById(R.id.music_image);
            c0892a.nNV.setDrawerType(1);
            c0892a.nNV.setIsRound(true);
            c0892a.nNV.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0892a.nNV.setDefaultBgResource(R.color.transparent);
            c0892a.nNV.setBorderWidth(l.getDimens(this.eXa.getPageActivity(), R.dimen.ds4));
            c0892a.nNV.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0892a.nNV.setConrers(15);
            c0892a.nNX = view.findViewById(R.id.music_loading);
            c0892a.nNY = (TextView) view.findViewById(R.id.music_title);
            c0892a.nNZ = (TextView) view.findViewById(R.id.music_author_name);
            c0892a.nOa = (TextView) view.findViewById(R.id.music_duration);
            c0892a.nOb = (TextView) view.findViewById(R.id.music_choose);
            c0892a.hjV = view.findViewById(R.id.line);
            view.setTag(c0892a);
        } else {
            c0892a = (C0892a) view.getTag();
        }
        c0892a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nNS.get(i);
        if (musicList != null) {
            c0892a.nNY.setText(musicList.name);
            c0892a.nNV.startLoad(musicList.image, 10, false);
            c0892a.nNZ.setText(musicList.author);
            c0892a.nOa.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0892a.nNX.setVisibility(0);
            } else {
                c0892a.nNX.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dSC().dSD())) {
                c0892a.nNW.setImageResource(R.drawable.btn_icon_stop_video);
                c0892a.nNV.setDrawBorder(true);
                c0892a.nOb.setVisibility(0);
                c0892a.nNX.setVisibility(4);
                musicList.isLoading = false;
                c0892a.nOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nNT != null) {
                            a.this.nNT.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0892a.nNW.setImageResource(R.drawable.btn_icon_play_video_n);
                c0892a.nNV.setDrawBorder(false);
                c0892a.nOb.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nNT = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0892a {
        private View hjV;
        public TbImageView nNV;
        public TbImageView nNW;
        public View nNX;
        public TextView nNY;
        public TextView nNZ;
        public TextView nOa;
        public TextView nOb;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nNY, R.color.CAM_X0105);
            ap.setViewTextColor(this.nNZ, R.color.CAM_X0107);
            ap.setViewTextColor(this.nOa, R.color.CAM_X0107);
            ap.setViewTextColor(this.nOb, R.color.common_color_10140);
            ap.setBackgroundResource(this.nOb, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hjV, R.color.CAM_X0204);
            ap.setImageResource(this.nNW, R.drawable.btn_icon_play_video_n);
        }
    }
}
