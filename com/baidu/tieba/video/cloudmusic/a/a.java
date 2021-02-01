package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private f eVB;
    private List<CloudMusicData.MusicTagList.MusicList> nLn = new ArrayList();
    private b nLo;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(f fVar) {
        this.eVB = fVar;
    }

    public void fX(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nLn.contains(musicList)) {
                    this.nLn.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nLn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KB */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nLn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0884a c0884a;
        if (view == null) {
            view = LayoutInflater.from(this.eVB.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0884a = new C0884a();
            c0884a.nLr = (TbImageView) view.findViewById(R.id.music_state);
            c0884a.nLq = (TbImageView) view.findViewById(R.id.music_image);
            c0884a.nLq.setDrawerType(1);
            c0884a.nLq.setIsRound(true);
            c0884a.nLq.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0884a.nLq.setDefaultBgResource(R.color.transparent);
            c0884a.nLq.setBorderWidth(l.getDimens(this.eVB.getPageActivity(), R.dimen.ds4));
            c0884a.nLq.setBorderColor(ap.getColor(R.color.CAM_X0302));
            c0884a.nLq.setConrers(15);
            c0884a.nLs = view.findViewById(R.id.music_loading);
            c0884a.nLt = (TextView) view.findViewById(R.id.music_title);
            c0884a.nLu = (TextView) view.findViewById(R.id.music_author_name);
            c0884a.nLv = (TextView) view.findViewById(R.id.music_duration);
            c0884a.nLw = (TextView) view.findViewById(R.id.music_choose);
            c0884a.hhX = view.findViewById(R.id.line);
            view.setTag(c0884a);
        } else {
            c0884a = (C0884a) view.getTag();
        }
        c0884a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nLn.get(i);
        if (musicList != null) {
            c0884a.nLt.setText(musicList.name);
            c0884a.nLq.startLoad(musicList.image, 10, false);
            c0884a.nLu.setText(musicList.author);
            c0884a.nLv.setText(au.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0884a.nLs.setVisibility(0);
            } else {
                c0884a.nLs.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dSm().dSn())) {
                c0884a.nLr.setImageResource(R.drawable.btn_icon_stop_video);
                c0884a.nLq.setDrawBorder(true);
                c0884a.nLw.setVisibility(0);
                c0884a.nLs.setVisibility(4);
                musicList.isLoading = false;
                c0884a.nLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nLo != null) {
                            a.this.nLo.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0884a.nLr.setImageResource(R.drawable.btn_icon_play_video_n);
                c0884a.nLq.setDrawBorder(false);
                c0884a.nLw.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nLo = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0884a {
        private View hhX;
        public TbImageView nLq;
        public TbImageView nLr;
        public View nLs;
        public TextView nLt;
        public TextView nLu;
        public TextView nLv;
        public TextView nLw;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.nLt, R.color.CAM_X0105);
            ap.setViewTextColor(this.nLu, R.color.CAM_X0107);
            ap.setViewTextColor(this.nLv, R.color.CAM_X0107);
            ap.setViewTextColor(this.nLw, R.color.common_color_10140);
            ap.setBackgroundResource(this.nLw, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hhX, R.color.CAM_X0204);
            ap.setImageResource(this.nLr, R.drawable.btn_icon_play_video_n);
        }
    }
}
