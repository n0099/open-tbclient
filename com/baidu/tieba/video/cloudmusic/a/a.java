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
    private e dJb;
    private List<CloudMusicData.MusicTagList.MusicList> lBQ = new ArrayList();
    private b lBR;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.dJb = eVar;
    }

    public void eM(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.lBQ.contains(musicList)) {
                    this.lBQ.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lBQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EW */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.lBQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0735a c0735a;
        if (view == null) {
            view = LayoutInflater.from(this.dJb.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0735a = new C0735a();
            c0735a.lBU = (TbImageView) view.findViewById(R.id.music_state);
            c0735a.lBT = (TbImageView) view.findViewById(R.id.music_image);
            c0735a.lBT.setDrawerType(1);
            c0735a.lBT.setIsRound(true);
            c0735a.lBT.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0735a.lBT.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0735a.lBT.setDefaultBgResource(R.color.transparent);
            c0735a.lBT.setBorderWidth(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds4));
            c0735a.lBT.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            c0735a.lBT.setConrers(15);
            c0735a.lBV = view.findViewById(R.id.music_loading);
            c0735a.lBW = (TextView) view.findViewById(R.id.music_title);
            c0735a.lBX = (TextView) view.findViewById(R.id.music_author_name);
            c0735a.lBY = (TextView) view.findViewById(R.id.music_duration);
            c0735a.lBZ = (TextView) view.findViewById(R.id.music_choose);
            c0735a.gqk = view.findViewById(R.id.line);
            view.setTag(c0735a);
        } else {
            c0735a = (C0735a) view.getTag();
        }
        c0735a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.lBQ.get(i);
        if (musicList != null) {
            c0735a.lBW.setText(musicList.name);
            c0735a.lBT.startLoad(musicList.image, 10, false);
            c0735a.lBX.setText(musicList.author);
            c0735a.lBY.setText(aq.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0735a.lBV.setVisibility(0);
            } else {
                c0735a.lBV.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dio().dip())) {
                c0735a.lBU.setImageResource(R.drawable.btn_icon_stop_video);
                c0735a.lBT.setDrawBorder(true);
                c0735a.lBZ.setVisibility(0);
                c0735a.lBV.setVisibility(4);
                musicList.isLoading = false;
                c0735a.lBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.lBR != null) {
                            a.this.lBR.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0735a.lBU.setImageResource(R.drawable.btn_icon_play_video_n);
                c0735a.lBT.setDrawBorder(false);
                c0735a.lBZ.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.lBR = bVar;
    }

    public void ac(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0735a {
        private View gqk;
        public TbImageView lBT;
        public TbImageView lBU;
        public View lBV;
        public TextView lBW;
        public TextView lBX;
        public TextView lBY;
        public TextView lBZ;

        public void onChangeSkin(int i) {
            am.setViewTextColor(this.lBW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.lBX, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lBY, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.lBZ, (int) R.color.common_color_10140);
            am.setBackgroundResource(this.lBZ, R.drawable.bg_music_choose);
            am.setBackgroundColor(this.gqk, R.color.cp_bg_line_c);
            am.setImageResource(this.lBU, R.drawable.btn_icon_play_video_n);
        }
    }
}
