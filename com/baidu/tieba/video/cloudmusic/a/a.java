package com.baidu.tieba.video.cloudmusic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eul;
    private List<CloudMusicData.MusicTagList.MusicList> mUt = new ArrayList();
    private b mUu;

    /* loaded from: classes23.dex */
    public interface b {
        void a(View view, String str, int i);
    }

    public a(e eVar) {
        this.eul = eVar;
    }

    public void fz(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list != null) {
            for (CloudMusicData.MusicTagList.MusicList musicList : list) {
                if (!this.mUt.contains(musicList)) {
                    this.mUt.add(musicList);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mUt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ka */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.mUt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0828a c0828a;
        if (view == null) {
            view = LayoutInflater.from(this.eul.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            c0828a = new C0828a();
            c0828a.mUx = (TbImageView) view.findViewById(R.id.music_state);
            c0828a.mUw = (TbImageView) view.findViewById(R.id.music_image);
            c0828a.mUw.setDrawerType(1);
            c0828a.mUw.setIsRound(true);
            c0828a.mUw.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            c0828a.mUw.setDefaultResource(R.drawable.bg_video_cloudmusic);
            c0828a.mUw.setDefaultBgResource(R.color.transparent);
            c0828a.mUw.setBorderWidth(l.getDimens(this.eul.getPageActivity(), R.dimen.ds4));
            c0828a.mUw.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            c0828a.mUw.setConrers(15);
            c0828a.mUy = view.findViewById(R.id.music_loading);
            c0828a.mUz = (TextView) view.findViewById(R.id.music_title);
            c0828a.mUA = (TextView) view.findViewById(R.id.music_author_name);
            c0828a.mUB = (TextView) view.findViewById(R.id.music_duration);
            c0828a.mUC = (TextView) view.findViewById(R.id.music_choose);
            c0828a.hnL = view.findViewById(R.id.line);
            view.setTag(c0828a);
        } else {
            c0828a = (C0828a) view.getTag();
        }
        c0828a.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        final CloudMusicData.MusicTagList.MusicList musicList = this.mUt.get(i);
        if (musicList != null) {
            c0828a.mUz.setText(musicList.name);
            c0828a.mUw.startLoad(musicList.image, 10, false);
            c0828a.mUA.setText(musicList.author);
            c0828a.mUB.setText(at.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                c0828a.mUy.setVisibility(0);
            } else {
                c0828a.mUy.setVisibility(4);
            }
            if (musicList.equals(com.baidu.tieba.video.cloudmusic.data.a.dIZ().dJa())) {
                c0828a.mUx.setImageResource(R.drawable.btn_icon_stop_video);
                c0828a.mUw.setDrawBorder(true);
                c0828a.mUC.setVisibility(0);
                c0828a.mUy.setVisibility(4);
                musicList.isLoading = false;
                c0828a.mUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mUu != null) {
                            a.this.mUu.a(view2, musicList.resource, i);
                        }
                    }
                });
            } else {
                c0828a.mUx.setImageResource(R.drawable.btn_icon_play_video_n);
                c0828a.mUw.setDrawBorder(false);
                c0828a.mUC.setVisibility(8);
            }
        }
        return view;
    }

    public void a(b bVar) {
        this.mUu = bVar;
    }

    public void aj(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    /* renamed from: com.baidu.tieba.video.cloudmusic.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0828a {
        private View hnL;
        public TextView mUA;
        public TextView mUB;
        public TextView mUC;
        public TbImageView mUw;
        public TbImageView mUx;
        public View mUy;
        public TextView mUz;

        public void onChangeSkin(int i) {
            ap.setViewTextColor(this.mUz, R.color.cp_cont_b);
            ap.setViewTextColor(this.mUA, R.color.cp_cont_j);
            ap.setViewTextColor(this.mUB, R.color.cp_cont_j);
            ap.setViewTextColor(this.mUC, R.color.common_color_10140);
            ap.setBackgroundResource(this.mUC, R.drawable.bg_music_choose);
            ap.setBackgroundColor(this.hnL, R.color.cp_bg_line_c);
            ap.setImageResource(this.mUx, R.drawable.btn_icon_play_video_n);
        }
    }
}
