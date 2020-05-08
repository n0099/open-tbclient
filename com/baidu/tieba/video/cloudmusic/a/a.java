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
    private e dvg;
    private List<CloudMusicData.MusicTagList.MusicList> lhW = new ArrayList();
    private b lhX;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dvg = eVar;
    }

    public void eD(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.lhW.contains(musicList)) {
                    this.lhW.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lhW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ej */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lhW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0681a c0681a;
        if (view == null) {
            view = LayoutInflater.from(this.dvg.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0681a = new C0681a();
            c0681a.lia = (TbImageView) view.findViewById(R.id.music_state);
            c0681a.lhZ = (TbImageView) view.findViewById(R.id.music_image);
            c0681a.lhZ.setDrawerType(1);
            c0681a.lhZ.setIsRound(true);
            c0681a.lhZ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0681a.lhZ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0681a.lhZ.setDefaultBgResource(R.color.transparent);
            c0681a.lhZ.setBorderWidth(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds4));
            c0681a.lhZ.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0681a.lib = view.findViewById(R.id.music_loading);
            c0681a.lic = (TextView) view.findViewById(R.id.music_title);
            c0681a.lid = (TextView) view.findViewById(R.id.music_author_name);
            c0681a.lie = (TextView) view.findViewById(R.id.music_duration);
            c0681a.lif = (TextView) view.findViewById(R.id.music_choose);
            c0681a.gbf = view.findViewById(R.id.line);
            view.setTag(c0681a);
        } else {
            c0681a = (C0681a) view.getTag();
        }
        c0681a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lhW.get(i);
        if (musicList != null) {
            c0681a.lic.setText(musicList.name);
            c0681a.lhZ.startLoad(musicList.image, 10, false);
            c0681a.lid.setText(musicList.author);
            c0681a.lie.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0681a.lib.setVisibility(0);
            } else {
                c0681a.lib.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.daK().daL())) {
                c0681a.lia.setImageResource(R.drawable.btn_icon_stop_video);
                c0681a.lhZ.setDrawBorder(true);
                c0681a.lif.setVisibility(0);
                c0681a.lib.setVisibility(4);
                musicList.isLoading = false;
                c0681a.lif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lhX != null) {
                            a.this.lhX.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0681a.lia.setImageResource(R.drawable.btn_icon_play_video_n);
                c0681a.lhZ.setDrawBorder(false);
                c0681a.lif.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lhX = bVar;
    }

    public void Y(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0681a {
        private View gbf;
        public TbImageView lhZ;
        public TbImageView lia;
        public View lib;
        public TextView lic;
        public TextView lid;
        public TextView lie;
        public TextView lif;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.lic, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lid, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lie, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lif, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.lif, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.gbf, R.color.cp_bg_line_c);
            am.setImageResource(this.lia, R.drawable.btn_icon_play_video_n);
        }
    }
}
