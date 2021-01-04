package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private f eXW;
    private List<CloudMusicData.MusicTagList.MusicList> nGi = new ArrayList();
    private b nGj;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(f fVar) {
        this.eXW = fVar;
    }

    public void fZ(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.nGi.contains(musicList)) {
                    this.nGi.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nGi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LO */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nGi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0860a c0860a;
        if (view == null) {
            view = LayoutInflater.from(this.eXW.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0860a = new C0860a();
            c0860a.nGm = (TbImageView) view.findViewById(R.id.music_state);
            c0860a.nGl = (TbImageView) view.findViewById(R.id.music_image);
            c0860a.nGl.setDrawerType(1);
            c0860a.nGl.setIsRound(true);
            c0860a.nGl.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0860a.nGl.setDefaultBgResource(R.color.transparent);
            c0860a.nGl.setBorderWidth(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds4));
            c0860a.nGl.setBorderColor(ao.getColor(R.color.CAM_X0302));
            c0860a.nGl.setConrers(15);
            c0860a.nGn = view.findViewById(R.id.music_loading);
            c0860a.nGo = (TextView) view.findViewById(R.id.music_title);
            c0860a.nGp = (TextView) view.findViewById(R.id.music_author_name);
            c0860a.nGq = (TextView) view.findViewById(R.id.music_duration);
            c0860a.nGr = (TextView) view.findViewById(R.id.music_choose);
            c0860a.ibo = view.findViewById(R.id.line);
            view.setTag(c0860a);
        } else {
            c0860a = (C0860a) view.getTag();
        }
        c0860a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nGi.get(i);
        if (musicList != null) {
            c0860a.nGo.setText(musicList.name);
            c0860a.nGl.startLoad(musicList.image, 10, false);
            c0860a.nGp.setText(musicList.author);
            c0860a.nGq.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0860a.nGn.setVisibility(0);
            } else {
                c0860a.nGn.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dTS().dTT())) {
                c0860a.nGm.setImageResource(R.drawable.btn_icon_stop_video);
                c0860a.nGl.setDrawBorder(true);
                c0860a.nGr.setVisibility(0);
                c0860a.nGn.setVisibility(4);
                musicList.isLoading = false;
                c0860a.nGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nGj != null) {
                            a.this.nGj.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0860a.nGm.setImageResource(R.drawable.btn_icon_play_video_n);
                c0860a.nGl.setDrawBorder(false);
                c0860a.nGr.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nGj = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0860a {
        private View ibo;
        public TbImageView nGl;
        public TbImageView nGm;
        public View nGn;
        public TextView nGo;
        public TextView nGp;
        public TextView nGq;
        public TextView nGr;

        public void onChangeSkin(int i) {
            ao.setViewTextColor(this.nGo, R.color.CAM_X0105);
            ao.setViewTextColor(this.nGp, R.color.CAM_X0107);
            ao.setViewTextColor(this.nGq, R.color.CAM_X0107);
            ao.setViewTextColor(this.nGr, R.color.common_color_10140);
            ao.setBackgroundResource(this.nGr, R.drawable.bg_music_choose);
            ao.setBackgroundColor(this.ibo, R.color.CAM_X0204);
            ao.setImageResource(this.nGm, R.drawable.btn_icon_play_video_n);
        }
    }
}
