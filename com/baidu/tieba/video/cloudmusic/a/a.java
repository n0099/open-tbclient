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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private e eid;
    private List<CloudMusicData.MusicTagList.MusicList> mEF = new ArrayList();
    private b mEG;

    /* loaded from: classes22.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eid = eVar;
    }

    public void fw(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.mEF.contains(musicList)) {
                    this.mEF.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mEF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ju */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.mEF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0810a c0810a;
        if (view == null) {
            view = LayoutInflater.from(this.eid.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0810a = new C0810a();
            c0810a.mEJ = (TbImageView) view.findViewById(R.id.music_state);
            c0810a.mEI = (TbImageView) view.findViewById(R.id.music_image);
            c0810a.mEI.setDrawerType(1);
            c0810a.mEI.setIsRound(true);
            c0810a.mEI.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0810a.mEI.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0810a.mEI.setDefaultBgResource(R.color.transparent);
            c0810a.mEI.setBorderWidth(l.getDimens(this.eid.getPageActivity(), R.dimen.ds4));
            c0810a.mEI.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0810a.mEI.setConrers(15);
            c0810a.mEK = view.findViewById(R.id.music_loading);
            c0810a.mEL = (TextView) view.findViewById(R.id.music_title);
            c0810a.mEM = (TextView) view.findViewById(R.id.music_author_name);
            c0810a.mEN = (TextView) view.findViewById(R.id.music_duration);
            c0810a.mEO = (TextView) view.findViewById(R.id.music_choose);
            c0810a.gYK = view.findViewById(R.id.line);
            view.setTag(c0810a);
        } else {
            c0810a = (C0810a) view.getTag();
        }
        c0810a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.mEF.get(i);
        if (musicList != null) {
            c0810a.mEL.setText(musicList.name);
            c0810a.mEI.startLoad(musicList.image, 10, false);
            c0810a.mEM.setText(musicList.author);
            c0810a.mEN.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0810a.mEK.setVisibility(0);
            } else {
                c0810a.mEK.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dFn().dFo())) {
                c0810a.mEJ.setImageResource(R.drawable.btn_icon_stop_video);
                c0810a.mEI.setDrawBorder(true);
                c0810a.mEO.setVisibility(0);
                c0810a.mEK.setVisibility(4);
                musicList.isLoading = false;
                c0810a.mEO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mEG != null) {
                            a.this.mEG.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0810a.mEJ.setImageResource(R.drawable.btn_icon_play_video_n);
                c0810a.mEI.setDrawBorder(false);
                c0810a.mEO.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.mEG = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0810a {
        private View gYK;
        public TbImageView mEI;
        public TbImageView mEJ;
        public View mEK;
        public TextView mEL;
        public TextView mEM;
        public TextView mEN;
        public TextView mEO;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.mEL, R.color.cp_cont_b);
            ap.setViewTextColor(this.mEM, R.color.cp_cont_j);
            ap.setViewTextColor(this.mEN, R.color.cp_cont_j);
            ap.setViewTextColor(this.mEO, R.color.common_color_10140);
            ap.setBackgroundResource(this.mEO, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.gYK, R.color.cp_bg_line_c);
            ap.setImageResource(this.mEJ, R.drawable.btn_icon_play_video_n);
        }
    }
}
