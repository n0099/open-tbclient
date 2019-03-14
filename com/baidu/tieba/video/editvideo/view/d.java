package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private h iHn;
    private MediaPlayer iVD;
    private a iWj;
    private HorizontalListView iYX;
    private com.baidu.tieba.video.editvideo.a.c iZb;
    private LinearLayout iZc;
    private ImageView iZd;
    private TextView iZe;
    private boolean iZf;
    private String iZg;
    private int iZh;
    private int iZi;
    private int iZj;
    private boolean iZk;
    private String iZl;
    private boolean iZm;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.iZf = true;
        this.iZh = 1;
        this.iWj = aVar;
        this.iHn = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.iYX = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.iZb = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.iYX.setAdapter((ListAdapter) this.iZb);
        this.iYX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.iZb.cjs() != i || i == d.this.iZh) {
                    d.this.iZi = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public boolean ckj() {
        return !TextUtils.isEmpty(this.iZl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.iZb.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.T("obj_locate", i + 1);
            amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.iZb.Av(i);
                    avg();
                    this.iWj.replay();
                    return;
                case 2:
                    this.iZh = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ed(String str, String str2) {
        this.iZk = false;
        this.iZi = this.iZh;
        this.iZl = str2;
        bu(str, this.iZh);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.iZl = musicData.id;
            this.iWj.cjr();
            String DB = com.baidu.tieba.video.editvideo.model.a.cjK().DB(musicData.resource);
            if (TextUtils.isEmpty(DB)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.iVM.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cjK().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ec(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.iVM.setVisibility(4);
                            d.this.bu(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void Dt(String str) {
                            aVar.iVM.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iHn != null) {
                                d.this.iHn.as(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ciY() {
                            aVar.iVM.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cjK().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ec(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bu(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Dt(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.iHn != null) {
                            d.this.iHn.as(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciY() {
                    }
                });
                return;
            }
            bu(DB, i);
        }
    }

    public void replay() {
        this.iZk = false;
        if (this.iVD != null && this.iVD.isPlaying()) {
            this.iVD.pause();
        }
        if (this.iVD != null) {
            this.iVD.start();
            this.iVD.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(String str, final int i) {
        this.iZj = i;
        if (this.iZi == this.iZj && !this.iZk) {
            if (this.iVD == null) {
                this.iVD = new MediaPlayer();
                this.iVD.setAudioStreamType(3);
            }
            try {
                this.iZg = str;
                this.iVD.reset();
                this.iVD.setDataSource(str);
                this.iVD.prepare();
                this.iVD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.iZb.Av(i);
                        d.this.iVD.setLooping(true);
                        d.this.iVD.start();
                        d.this.iWj.replay();
                    }
                });
                this.iVD.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iHn != null) {
                            d.this.iHn.as(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bv(str, i);
                if (this.iHn != null) {
                    this.iHn.as(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bv(String str, int i) {
        this.iZg = null;
        avg();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cjK().cjL();
        }
        a(i, this.iYX.getChildCount() > i ? this.iYX.getChildAt(i) : null, (MusicData) this.iZb.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.iZb.setData(list);
        if (this.iZb != null) {
            this.iZj = this.iZb.cjs();
            this.iZi = this.iZj;
        }
    }

    public String ckh() {
        return this.iZg;
    }

    public String cki() {
        return this.iZl;
    }

    public void cK(View view) {
        this.iZc = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.iZd = (ImageView) view.findViewById(d.g.video_voice_img);
        this.iZe = (TextView) view.findViewById(d.g.video_voice_text);
        this.iZc.setVisibility(8);
        this.iZc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.iZf = !d.this.iZf;
                if (d.this.iZf) {
                    d.this.iZd.setSelected(false);
                    d.this.iZe.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.iZd.setSelected(true);
                    d.this.iZe.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.iWj.setMute(!d.this.iZf);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.T("obj_type", d.this.iZf ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.iZf) {
            this.iZd.setSelected(false);
            this.iZe.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.iZd.setSelected(true);
        this.iZe.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
        if (z) {
            this.iZc.setVisibility(0);
            if (this.iZm && this.iVD == null && !TextUtils.isEmpty(this.iZg)) {
                bu(this.iZg, this.iZj);
                this.iZm = false;
                if (this.iZj > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.iYX.setSelection(d.this.iZj);
                            d.this.iYX.scrollTo(d.this.iZi * l.h(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.iZc.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.iZk = true;
        if (this.iVD != null && this.iVD.isPlaying()) {
            this.iVD.pause();
        }
    }

    public void onResume() {
        this.iZk = false;
        if (this.iVD != null && this.iWj.mCurrentTabIndex == 2) {
            this.iVD.start();
            this.iVD.seekTo(0);
        }
    }

    private void avg() {
        if (this.iVD != null) {
            if (this.iVD.isPlaying()) {
                this.iVD.stop();
            }
            this.iVD.release();
            this.iVD = null;
        }
        this.iZg = null;
        this.iZl = null;
    }

    public void av(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.iZm = true;
            this.iZl = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.iZg = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.iZb != null) {
                this.iZb.Dz(this.iZl);
                this.iZj = this.iZb.cjs();
                this.iZh = this.iZj;
                this.iZi = this.iZj;
            }
        }
    }
}
