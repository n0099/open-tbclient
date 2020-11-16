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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private e eGT;
    private List<CloudMusicData.MusicTagList.MusicList> nnW = new ArrayList();
    private b nnX;

    /* loaded from: classes22.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eGT = eVar;
    }

    public void fQ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nnW.contains(musicList)) {
                    this.nnW.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nnW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Li */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nnW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0861a c0861a;
        if (view == null) {
            view = LayoutInflater.from(this.eGT.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0861a = new C0861a();
            c0861a.noa = (TbImageView) view.findViewById(R.id.music_state);
            c0861a.nnZ = (TbImageView) view.findViewById(R.id.music_image);
            c0861a.nnZ.setDrawerType(1);
            c0861a.nnZ.setIsRound(true);
            c0861a.nnZ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0861a.nnZ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0861a.nnZ.setDefaultBgResource(R.color.transparent);
            c0861a.nnZ.setBorderWidth(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds4));
            c0861a.nnZ.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0861a.nnZ.setConrers(15);
            c0861a.nob = view.findViewById(R.id.music_loading);
            c0861a.noc = (TextView) view.findViewById(R.id.music_title);
            c0861a.nod = (TextView) view.findViewById(R.id.music_author_name);
            c0861a.noe = (TextView) view.findViewById(R.id.music_duration);
            c0861a.nof = (TextView) view.findViewById(R.id.music_choose);
            c0861a.hFk = view.findViewById(R.id.line);
            view.setTag(c0861a);
        } else {
            c0861a = (C0861a) view.getTag();
        }
        c0861a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nnW.get(i);
        if (musicList != null) {
            c0861a.noc.setText(musicList.name);
            c0861a.nnZ.startLoad(musicList.image, 10, false);
            c0861a.nod.setText(musicList.author);
            c0861a.noe.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0861a.nob.setVisibility(0);
            } else {
                c0861a.nob.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dOI().dOJ())) {
                c0861a.noa.setImageResource(R.drawable.btn_icon_stop_video);
                c0861a.nnZ.setDrawBorder(true);
                c0861a.nof.setVisibility(0);
                c0861a.nob.setVisibility(4);
                musicList.isLoading = false;
                c0861a.nof.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nnX != null) {
                            a.this.nnX.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0861a.noa.setImageResource(R.drawable.btn_icon_play_video_n);
                c0861a.nnZ.setDrawBorder(false);
                c0861a.nof.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nnX = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0861a {
        private View hFk;
        public TbImageView nnZ;
        public TbImageView noa;
        public View nob;
        public TextView noc;
        public TextView nod;
        public TextView noe;
        public TextView nof;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.noc, R.color.CAM_X0105);
            ap.setViewTextColor(this.nod, R.color.CAM_X0107);
            ap.setViewTextColor(this.noe, R.color.CAM_X0107);
            ap.setViewTextColor(this.nof, R.color.common_color_10140);
            ap.setBackgroundResource(this.nof, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hFk, R.color.CAM_X0204);
            ap.setImageResource(this.noa, R.drawable.btn_icon_play_video_n);
        }
    }
}
