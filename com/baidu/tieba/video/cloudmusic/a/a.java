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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private e cRq;
    private List<CloudMusicData.MusicTagList.MusicList> krg = new ArrayList();
    private b krh;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.cRq = eVar;
    }

    public void es(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.krg.contains(musicList)) {
                    this.krg.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.krg.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dl */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.krg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0605a c0605a;
        if (view == null) {
            view = LayoutInflater.from(this.cRq.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0605a = new C0605a();
            c0605a.krk = (TbImageView) view.findViewById(R.id.music_state);
            c0605a.krj = (TbImageView) view.findViewById(R.id.music_image);
            c0605a.krj.setDrawerType(1);
            c0605a.krj.setIsRound(true);
            c0605a.krj.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0605a.krj.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0605a.krj.setDefaultBgResource(R.color.transparent);
            c0605a.krj.setBorderWidth(l.getDimens(this.cRq.getPageActivity(), R.dimen.ds4));
            c0605a.krj.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0605a.krl = view.findViewById(R.id.music_loading);
            c0605a.krm = (TextView) view.findViewById(R.id.music_title);
            c0605a.krn = (TextView) view.findViewById(R.id.music_author_name);
            c0605a.kro = (TextView) view.findViewById(R.id.music_duration);
            c0605a.krp = (TextView) view.findViewById(R.id.music_choose);
            c0605a.fpV = view.findViewById(R.id.line);
            view.setTag(c0605a);
        } else {
            c0605a = (C0605a) view.getTag();
        }
        c0605a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.krg.get(i);
        if (musicList != null) {
            c0605a.krm.setText(musicList.name);
            c0605a.krj.startLoad(musicList.image, 10, false);
            c0605a.krn.setText(musicList.author);
            c0605a.kro.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0605a.krl.setVisibility(0);
            } else {
                c0605a.krl.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.cMS().cMT())) {
                c0605a.krk.setImageResource(R.drawable.btn_icon_stop_video);
                c0605a.krj.setDrawBorder(true);
                c0605a.krp.setVisibility(0);
                c0605a.krl.setVisibility(4);
                musicList.isLoading = false;
                c0605a.krp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.krh != null) {
                            a.this.krh.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0605a.krk.setImageResource(R.drawable.btn_icon_play_video_n);
                c0605a.krj.setDrawBorder(false);
                c0605a.krp.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.krh = bVar;
    }

    public void T(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0605a {
        private View fpV;
        public TbImageView krj;
        public TbImageView krk;
        public View krl;
        public TextView krm;
        public TextView krn;
        public TextView kro;
        public TextView krp;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.krm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.krn, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kro, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.krp, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.krp, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.fpV, R.color.cp_bg_line_c);
            am.setImageResource(this.krk, R.drawable.btn_icon_play_video_n);
        }
    }
}
