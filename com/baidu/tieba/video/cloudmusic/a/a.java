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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private e cfJ;
    private List<CloudMusicData.MusicTagList.MusicList> jya = new ArrayList();
    private b jyb;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cfJ = eVar;
    }

    public void eA(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.jya.contains(musicList)) {
                    this.jya.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jya.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AR */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.jya.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0526a c0526a;
        if (view == null) {
            view = LayoutInflater.from(this.cfJ.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0526a = new C0526a();
            c0526a.jye = (TbImageView) view.findViewById(R.id.music_state);
            c0526a.jyd = (TbImageView) view.findViewById(R.id.music_image);
            c0526a.jyd.setDrawerType(1);
            c0526a.jyd.setIsRound(true);
            c0526a.jyd.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0526a.jyd.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0526a.jyd.setDefaultBgResource(R.color.transparent);
            c0526a.jyd.setBorderWidth(l.getDimens(this.cfJ.getPageActivity(), R.dimen.ds4));
            c0526a.jyd.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0526a.jyf = view.findViewById(R.id.music_loading);
            c0526a.jyg = (TextView) view.findViewById(R.id.music_title);
            c0526a.jyh = (TextView) view.findViewById(R.id.music_author_name);
            c0526a.jyi = (TextView) view.findViewById(R.id.music_duration);
            c0526a.jyj = (TextView) view.findViewById(R.id.music_choose);
            c0526a.ezl = view.findViewById(R.id.line);
            view.setTag(c0526a);
        } else {
            c0526a = (C0526a) view.getTag();
        }
        c0526a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.jya.get(i);
        if (musicList != null) {
            c0526a.jyg.setText(musicList.name);
            c0526a.jyd.startLoad(musicList.image, 10, false);
            c0526a.jyh.setText(musicList.author);
            c0526a.jyi.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0526a.jyf.setVisibility(0);
            } else {
                c0526a.jyf.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.csS().csT())) {
                c0526a.jye.setImageResource(R.drawable.btn_icon_stop_video);
                c0526a.jyd.setDrawBorder(true);
                c0526a.jyj.setVisibility(0);
                c0526a.jyf.setVisibility(4);
                musicList.isLoading = false;
                c0526a.jyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.jyb != null) {
                            a.this.jyb.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0526a.jye.setImageResource(R.drawable.btn_icon_play_video_n);
                c0526a.jyd.setDrawBorder(false);
                c0526a.jyj.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.jyb = bVar;
    }

    public void R(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0526a {
        private View ezl;
        public TbImageView jyd;
        public TbImageView jye;
        public View jyf;
        public TextView jyg;
        public TextView jyh;
        public TextView jyi;
        public TextView jyj;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.jyg, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jyh, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.jyi, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.jyj, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.jyj, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.ezl, R.color.cp_bg_line_c);
            am.setImageResource(this.jye, R.drawable.btn_icon_play_video_n);
        }
    }
}
