package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e cVR;
    private List<CloudMusicData.MusicTagList.MusicList> kxD = new ArrayList();
    private b kxE;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cVR = eVar;
    }

    public void eo(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.kxD.contains(musicList)) {
                    this.kxD.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kxD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DF */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.kxD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0619a c0619a;
        if (view == null) {
            view = LayoutInflater.from(this.cVR.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0619a = new C0619a();
            c0619a.kxH = (TbImageView) view.findViewById(R.id.music_state);
            c0619a.kxG = (TbImageView) view.findViewById(R.id.music_image);
            c0619a.kxG.setDrawerType(1);
            c0619a.kxG.setIsRound(true);
            c0619a.kxG.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0619a.kxG.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0619a.kxG.setDefaultBgResource(R.color.transparent);
            c0619a.kxG.setBorderWidth(l.getDimens(this.cVR.getPageActivity(), R.dimen.ds4));
            c0619a.kxG.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0619a.kxI = view.findViewById(R.id.music_loading);
            c0619a.kxJ = (TextView) view.findViewById(R.id.music_title);
            c0619a.kxK = (TextView) view.findViewById(R.id.music_author_name);
            c0619a.kxL = (TextView) view.findViewById(R.id.music_duration);
            c0619a.kxM = (TextView) view.findViewById(R.id.music_choose);
            c0619a.fwA = view.findViewById(R.id.line);
            view.setTag(c0619a);
        } else {
            c0619a = (C0619a) view.getTag();
        }
        c0619a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.kxD.get(i);
        if (musicList != null) {
            c0619a.kxJ.setText(musicList.name);
            c0619a.kxG.startLoad(musicList.image, 10, false);
            c0619a.kxK.setText(musicList.author);
            c0619a.kxL.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0619a.kxI.setVisibility(0);
            } else {
                c0619a.kxI.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cPR().cPS())) {
                c0619a.kxH.setImageResource(R.drawable.btn_icon_stop_video);
                c0619a.kxG.setDrawBorder(true);
                c0619a.kxM.setVisibility(0);
                c0619a.kxI.setVisibility(4);
                musicList.isLoading = false;
                c0619a.kxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.kxE != null) {
                            a.this.kxE.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0619a.kxH.setImageResource(R.drawable.btn_icon_play_video_n);
                c0619a.kxG.setDrawBorder(false);
                c0619a.kxM.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.kxE = bVar;
    }

    public void S(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0619a {
        private View fwA;
        public TbImageView kxG;
        public TbImageView kxH;
        public View kxI;
        public TextView kxJ;
        public TextView kxK;
        public TextView kxL;
        public TextView kxM;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.kxJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kxK, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kxL, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kxM, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.kxM, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.fwA, R.color.cp_bg_line_c);
            am.setImageResource(this.kxH, R.drawable.btn_icon_play_video_n);
        }
    }
}
