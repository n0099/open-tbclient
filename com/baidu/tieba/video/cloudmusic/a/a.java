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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private e cRA;
    private List<CloudMusicData.MusicTagList.MusicList> kuO = new ArrayList();
    private b kuP;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cRA = eVar;
    }

    public void es(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.kuO.contains(musicList)) {
                    this.kuO.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kuO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dr */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.kuO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0610a c0610a;
        if (view == null) {
            view = LayoutInflater.from(this.cRA.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0610a = new C0610a();
            c0610a.kuS = (TbImageView) view.findViewById(R.id.music_state);
            c0610a.kuR = (TbImageView) view.findViewById(R.id.music_image);
            c0610a.kuR.setDrawerType(1);
            c0610a.kuR.setIsRound(true);
            c0610a.kuR.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0610a.kuR.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0610a.kuR.setDefaultBgResource(R.color.transparent);
            c0610a.kuR.setBorderWidth(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds4));
            c0610a.kuR.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0610a.kuT = view.findViewById(R.id.music_loading);
            c0610a.kuU = (TextView) view.findViewById(R.id.music_title);
            c0610a.kuV = (TextView) view.findViewById(R.id.music_author_name);
            c0610a.kuW = (TextView) view.findViewById(R.id.music_duration);
            c0610a.kuX = (TextView) view.findViewById(R.id.music_choose);
            c0610a.fte = view.findViewById(R.id.line);
            view.setTag(c0610a);
        } else {
            c0610a = (C0610a) view.getTag();
        }
        c0610a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.kuO.get(i);
        if (musicList != null) {
            c0610a.kuU.setText(musicList.name);
            c0610a.kuR.startLoad(musicList.image, 10, false);
            c0610a.kuV.setText(musicList.author);
            c0610a.kuW.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0610a.kuT.setVisibility(0);
            } else {
                c0610a.kuT.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cNZ().cOa())) {
                c0610a.kuS.setImageResource(R.drawable.btn_icon_stop_video);
                c0610a.kuR.setDrawBorder(true);
                c0610a.kuX.setVisibility(0);
                c0610a.kuT.setVisibility(4);
                musicList.isLoading = false;
                c0610a.kuX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.kuP != null) {
                            a.this.kuP.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0610a.kuS.setImageResource(R.drawable.btn_icon_play_video_n);
                c0610a.kuR.setDrawBorder(false);
                c0610a.kuX.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.kuP = bVar;
    }

    public void T(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0610a {
        private View fte;
        public TbImageView kuR;
        public TbImageView kuS;
        public View kuT;
        public TextView kuU;
        public TextView kuV;
        public TextView kuW;
        public TextView kuX;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.kuU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.kuV, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kuW, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kuX, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.kuX, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.fte, R.color.cp_bg_line_c);
            am.setImageResource(this.kuS, R.drawable.btn_icon_play_video_n);
        }
    }
}
