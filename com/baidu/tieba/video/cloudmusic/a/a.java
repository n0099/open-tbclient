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
    private e ceS;
    private List<CloudMusicData.MusicTagList.MusicList> jxj = new ArrayList();
    private b jxk;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.ceS = eVar;
    }

    public void eA(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.jxj.contains(musicList)) {
                    this.jxj.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jxj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AQ */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.jxj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0521a c0521a;
        if (view == null) {
            view = LayoutInflater.from(this.ceS.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0521a = new C0521a();
            c0521a.jxn = (TbImageView) view.findViewById(R.id.music_state);
            c0521a.jxm = (TbImageView) view.findViewById(R.id.music_image);
            c0521a.jxm.setDrawerType(1);
            c0521a.jxm.setIsRound(true);
            c0521a.jxm.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0521a.jxm.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0521a.jxm.setDefaultBgResource(R.color.transparent);
            c0521a.jxm.setBorderWidth(l.getDimens(this.ceS.getPageActivity(), R.dimen.ds4));
            c0521a.jxm.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0521a.jxo = view.findViewById(R.id.music_loading);
            c0521a.jxp = (TextView) view.findViewById(R.id.music_title);
            c0521a.jxq = (TextView) view.findViewById(R.id.music_author_name);
            c0521a.jxr = (TextView) view.findViewById(R.id.music_duration);
            c0521a.jxs = (TextView) view.findViewById(R.id.music_choose);
            c0521a.eyu = view.findViewById(R.id.line);
            view.setTag(c0521a);
        } else {
            c0521a = (C0521a) view.getTag();
        }
        c0521a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.jxj.get(i);
        if (musicList != null) {
            c0521a.jxp.setText(musicList.name);
            c0521a.jxm.startLoad(musicList.image, 10, false);
            c0521a.jxq.setText(musicList.author);
            c0521a.jxr.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0521a.jxo.setVisibility(0);
            } else {
                c0521a.jxo.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.csQ().csR())) {
                c0521a.jxn.setImageResource(R.drawable.btn_icon_stop_video);
                c0521a.jxm.setDrawBorder(true);
                c0521a.jxs.setVisibility(0);
                c0521a.jxo.setVisibility(4);
                musicList.isLoading = false;
                c0521a.jxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.jxk != null) {
                            a.this.jxk.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0521a.jxn.setImageResource(R.drawable.btn_icon_play_video_n);
                c0521a.jxm.setDrawBorder(false);
                c0521a.jxs.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.jxk = bVar;
    }

    public void R(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0521a {
        private View eyu;
        public TbImageView jxm;
        public TbImageView jxn;
        public View jxo;
        public TextView jxp;
        public TextView jxq;
        public TextView jxr;
        public TextView jxs;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.jxp, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jxq, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.jxr, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.jxs, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.jxs, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.eyu, R.color.cp_bg_line_c);
            am.setImageResource(this.jxn, R.drawable.btn_icon_play_video_n);
        }
    }
}
