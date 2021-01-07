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
    private List<CloudMusicData.MusicTagList.MusicList> nGh = new ArrayList();
    private b nGi;

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
                if (!this.nGh.contains(musicList)) {
                    this.nGh.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.nGh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LO */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.nGh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0898a c0898a;
        if (view == null) {
            view = LayoutInflater.from(this.eXW.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0898a = new C0898a();
            c0898a.nGl = (TbImageView) view.findViewById(R.id.music_state);
            c0898a.nGk = (TbImageView) view.findViewById(R.id.music_image);
            c0898a.nGk.setDrawerType(1);
            c0898a.nGk.setIsRound(true);
            c0898a.nGk.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0898a.nGk.setDefaultBgResource(R.color.transparent);
            c0898a.nGk.setBorderWidth(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds4));
            c0898a.nGk.setBorderColor(ao.getColor(R.color.CAM_X0302));
            c0898a.nGk.setConrers(15);
            c0898a.nGm = view.findViewById(R.id.music_loading);
            c0898a.nGn = (TextView) view.findViewById(R.id.music_title);
            c0898a.nGo = (TextView) view.findViewById(R.id.music_author_name);
            c0898a.nGp = (TextView) view.findViewById(R.id.music_duration);
            c0898a.nGq = (TextView) view.findViewById(R.id.music_choose);
            c0898a.ibo = view.findViewById(R.id.line);
            view.setTag(c0898a);
        } else {
            c0898a = (C0898a) view.getTag();
        }
        c0898a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.nGh.get(i);
        if (musicList != null) {
            c0898a.nGn.setText(musicList.name);
            c0898a.nGk.startLoad(musicList.image, 10, false);
            c0898a.nGo.setText(musicList.author);
            c0898a.nGp.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0898a.nGm.setVisibility(0);
            } else {
                c0898a.nGm.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dTT().dTU())) {
                c0898a.nGl.setImageResource(R.drawable.btn_icon_stop_video);
                c0898a.nGk.setDrawBorder(true);
                c0898a.nGq.setVisibility(0);
                c0898a.nGm.setVisibility(4);
                musicList.isLoading = false;
                c0898a.nGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.nGi != null) {
                            a.this.nGi.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0898a.nGl.setImageResource(R.drawable.btn_icon_play_video_n);
                c0898a.nGk.setDrawBorder(false);
                c0898a.nGq.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.nGi = bVar;
    }

    public void ah(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0898a {
        private View ibo;
        public TbImageView nGk;
        public TbImageView nGl;
        public View nGm;
        public TextView nGn;
        public TextView nGo;
        public TextView nGp;
        public TextView nGq;

        public void onChangeSkin(int i) {
            ao.setViewTextColor(this.nGn, R.color.CAM_X0105);
            ao.setViewTextColor(this.nGo, R.color.CAM_X0107);
            ao.setViewTextColor(this.nGp, R.color.CAM_X0107);
            ao.setViewTextColor(this.nGq, R.color.common_color_10140);
            ao.setBackgroundResource(this.nGq, R.drawable.bg_music_choose);
            ao.setBackgroundColor(this.ibo, R.color.CAM_X0204);
            ao.setImageResource(this.nGl, R.drawable.btn_icon_play_video_n);
        }
    }
}
