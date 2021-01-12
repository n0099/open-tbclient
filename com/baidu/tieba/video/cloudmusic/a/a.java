package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private f eTl;
    private List<CloudMusicData.MusicTagList.MusicList> nBC = new ArrayList();
    private b nBD;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(f fVar) {
        this.eTl = fVar;
    }

    public void fZ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nBC.contains(musicList)) {
                    this.nBC.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nBC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kh */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nBC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0881a c0881a;
        if (view == null) {
            view = LayoutInflater.from(this.eTl.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0881a = new C0881a();
            c0881a.nBG = (TbImageView) view.findViewById(R.id.music_state);
            c0881a.nBF = (TbImageView) view.findViewById(R.id.music_image);
            c0881a.nBF.setDrawerType(1);
            c0881a.nBF.setIsRound(true);
            c0881a.nBF.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0881a.nBF.setDefaultBgResource(R.color.transparent);
            c0881a.nBF.setBorderWidth(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds4));
            c0881a.nBF.setBorderColor(ao.getColor(R.color.CAM_X0302));
            c0881a.nBF.setConrers(15);
            c0881a.nBH = view.findViewById(R.id.music_loading);
            c0881a.nBI = (TextView) view.findViewById(R.id.music_title);
            c0881a.nBJ = (TextView) view.findViewById(R.id.music_author_name);
            c0881a.nBK = (TextView) view.findViewById(R.id.music_duration);
            c0881a.nBL = (TextView) view.findViewById(R.id.music_choose);
            c0881a.hWH = view.findViewById(R.id.line);
            view.setTag(c0881a);
        } else {
            c0881a = (C0881a) view.getTag();
        }
        c0881a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nBC.get(i);
        if (musicList != null) {
            c0881a.nBI.setText(musicList.name);
            c0881a.nBF.startLoad(musicList.image, 10, false);
            c0881a.nBJ.setText(musicList.author);
            c0881a.nBK.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0881a.nBH.setVisibility(0);
            } else {
                c0881a.nBH.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dQb().dQc())) {
                c0881a.nBG.setImageResource(R.drawable.btn_icon_stop_video);
                c0881a.nBF.setDrawBorder(true);
                c0881a.nBL.setVisibility(0);
                c0881a.nBH.setVisibility(4);
                musicList.isLoading = false;
                c0881a.nBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nBD != null) {
                            a.this.nBD.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0881a.nBG.setImageResource(R.drawable.btn_icon_play_video_n);
                c0881a.nBF.setDrawBorder(false);
                c0881a.nBL.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nBD = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0881a {
        private View hWH;
        public TbImageView nBF;
        public TbImageView nBG;
        public View nBH;
        public TextView nBI;
        public TextView nBJ;
        public TextView nBK;
        public TextView nBL;

        public void onChangeSkin(int i) {
            ao.setViewTextColor(this.nBI, R.color.CAM_X0105);
            ao.setViewTextColor(this.nBJ, R.color.CAM_X0107);
            ao.setViewTextColor(this.nBK, R.color.CAM_X0107);
            ao.setViewTextColor(this.nBL, R.color.common_color_10140);
            ao.setBackgroundResource(this.nBL, R.drawable.bg_music_choose);
            ao.setBackgroundColor(this.hWH, R.color.CAM_X0204);
            ao.setImageResource(this.nBG, R.drawable.btn_icon_play_video_n);
        }
    }
}
