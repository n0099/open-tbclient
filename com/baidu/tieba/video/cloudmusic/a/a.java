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
    private e dvc;
    private List<CloudMusicData.MusicTagList.MusicList> lhS = new ArrayList();
    private b lhT;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dvc = eVar;
    }

    public void eD(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.lhS.contains(musicList)) {
                    this.lhS.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lhS.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ej */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lhS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0660a c0660a;
        if (view == null) {
            view = LayoutInflater.from(this.dvc.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0660a = new C0660a();
            c0660a.lhW = (TbImageView) view.findViewById(R.id.music_state);
            c0660a.lhV = (TbImageView) view.findViewById(R.id.music_image);
            c0660a.lhV.setDrawerType(1);
            c0660a.lhV.setIsRound(true);
            c0660a.lhV.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0660a.lhV.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0660a.lhV.setDefaultBgResource(R.color.transparent);
            c0660a.lhV.setBorderWidth(l.getDimens(this.dvc.getPageActivity(), R.dimen.ds4));
            c0660a.lhV.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0660a.lhX = view.findViewById(R.id.music_loading);
            c0660a.lhY = (TextView) view.findViewById(R.id.music_title);
            c0660a.lhZ = (TextView) view.findViewById(R.id.music_author_name);
            c0660a.lia = (TextView) view.findViewById(R.id.music_duration);
            c0660a.lib = (TextView) view.findViewById(R.id.music_choose);
            c0660a.gba = view.findViewById(R.id.line);
            view.setTag(c0660a);
        } else {
            c0660a = (C0660a) view.getTag();
        }
        c0660a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lhS.get(i);
        if (musicList != null) {
            c0660a.lhY.setText(musicList.name);
            c0660a.lhV.startLoad(musicList.image, 10, false);
            c0660a.lhZ.setText(musicList.author);
            c0660a.lia.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0660a.lhX.setVisibility(0);
            } else {
                c0660a.lhX.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.daN().daO())) {
                c0660a.lhW.setImageResource(R.drawable.btn_icon_stop_video);
                c0660a.lhV.setDrawBorder(true);
                c0660a.lib.setVisibility(0);
                c0660a.lhX.setVisibility(4);
                musicList.isLoading = false;
                c0660a.lib.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lhT != null) {
                            a.this.lhT.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0660a.lhW.setImageResource(R.drawable.btn_icon_play_video_n);
                c0660a.lhV.setDrawBorder(false);
                c0660a.lib.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lhT = bVar;
    }

    public void Y(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0660a {
        private View gba;
        public TbImageView lhV;
        public TbImageView lhW;
        public View lhX;
        public TextView lhY;
        public TextView lhZ;
        public TextView lia;
        public TextView lib;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.lhY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lhZ, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lia, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lib, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.lib, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.gba, R.color.cp_bg_line_c);
            am.setImageResource(this.lhW, R.drawable.btn_icon_play_video_n);
        }
    }
}
