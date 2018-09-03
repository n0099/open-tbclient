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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.f;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gPa;
    private MediaPlayer hcG;
    private a hdm;
    private HorizontalListView hgf;
    private com.baidu.tieba.video.editvideo.a.c hgj;
    private LinearLayout hgk;
    private ImageView hgl;
    private TextView hgm;
    private boolean hgn;
    private String hgo;
    private int hgp;
    private int hgq;
    private int hgr;
    private boolean hgs;
    private String hgt;
    private boolean hgu;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hgn = true;
        this.hgp = 1;
        this.hdm = aVar;
        this.gPa = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(f.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hgf = (HorizontalListView) this.mRootView.findViewById(f.g.horizontal_list);
        this.hgj = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hgf.setAdapter((ListAdapter) this.hgj);
        this.hgf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hgj.bAN() != i || i == d.this.hgp) {
                    d.this.hgq = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, f.d.cp_bg_line_d);
    }

    public boolean bBE() {
        return !TextUtils.isEmpty(this.hgt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hgj.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            anVar.r("obj_locate", i + 1);
            anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hgj.uG(i);
                    bko();
                    this.hdm.replay();
                    return;
                case 2:
                    this.hgp = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cs(String str, String str2) {
        this.hgs = false;
        this.hgq = this.hgp;
        this.hgt = str2;
        aN(str, this.hgp);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hgt = musicData.id;
            this.hdm.bAM();
            String uP = com.baidu.tieba.video.editvideo.model.a.bBf().uP(musicData.resource);
            if (TextUtils.isEmpty(uP)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hcP.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBf().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cr(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hcP.setVisibility(4);
                            d.this.aN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void uG(String str) {
                            aVar.hcP.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gPa != null) {
                                d.this.gPa.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAt() {
                            aVar.hcP.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBf().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cr(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uG(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gPa != null) {
                            d.this.gPa.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAt() {
                    }
                });
                return;
            }
            aN(uP, i);
        }
    }

    public void replay() {
        this.hgs = false;
        if (this.hcG != null && this.hcG.isPlaying()) {
            this.hcG.pause();
        }
        if (this.hcG != null) {
            this.hcG.start();
            this.hcG.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, final int i) {
        this.hgr = i;
        if (this.hgq == this.hgr && !this.hgs) {
            if (this.hcG == null) {
                this.hcG = new MediaPlayer();
                this.hcG.setAudioStreamType(3);
            }
            try {
                this.hgo = str;
                this.hcG.reset();
                this.hcG.setDataSource(str);
                this.hcG.prepare();
                this.hcG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hgj.uG(i);
                        d.this.hcG.setLooping(true);
                        d.this.hcG.start();
                        d.this.hdm.replay();
                    }
                });
                this.hcG.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gPa != null) {
                            d.this.gPa.ad(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aO(str, i);
                if (this.gPa != null) {
                    this.gPa.ad(208, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    private void aO(String str, int i) {
        this.hgo = null;
        bko();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBf().bBg();
        }
        a(i, this.hgf.getChildCount() > i ? this.hgf.getChildAt(i) : null, (MusicData) this.hgj.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hgj.setData(list);
        if (this.hgj != null) {
            this.hgr = this.hgj.bAN();
            this.hgq = this.hgr;
        }
    }

    public String bBC() {
        return this.hgo;
    }

    public String bBD() {
        return this.hgt;
    }

    public void bF(View view) {
        this.hgk = (LinearLayout) view.findViewById(f.g.video_voice_layout);
        this.hgl = (ImageView) view.findViewById(f.g.video_voice_img);
        this.hgm = (TextView) view.findViewById(f.g.video_voice_text);
        this.hgk.setVisibility(8);
        this.hgk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hgn = !d.this.hgn;
                if (d.this.hgn) {
                    d.this.hgl.setSelected(false);
                    d.this.hgm.setText(d.this.mResources.getString(f.j.video_voice_open));
                } else {
                    d.this.hgl.setSelected(true);
                    d.this.hgm.setText(d.this.mResources.getString(f.j.video_voice_close));
                }
                d.this.hdm.setMute(!d.this.hgn);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.r("obj_type", d.this.hgn ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.hgn) {
            this.hgl.setSelected(false);
            this.hgm.setText(this.mResources.getString(f.j.video_voice_open));
            return;
        }
        this.hgl.setSelected(true);
        this.hgm.setText(this.mResources.getString(f.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
        if (z) {
            this.hgk.setVisibility(0);
            if (this.hgu && this.hcG == null && !TextUtils.isEmpty(this.hgo)) {
                aN(this.hgo, this.hgr);
                this.hgu = false;
                if (this.hgr > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hgf.setSelection(d.this.hgr);
                            d.this.hgf.scrollTo(d.this.hgq * l.f(d.this.getPageContext().getContext(), f.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hgk.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hgs = true;
        if (this.hcG != null && this.hcG.isPlaying()) {
            this.hcG.pause();
        }
    }

    public void onResume() {
        this.hgs = false;
        if (this.hcG != null && this.hdm.mCurrentTabIndex == 2) {
            this.hcG.start();
            this.hcG.seekTo(0);
        }
    }

    private void bko() {
        if (this.hcG != null) {
            if (this.hcG.isPlaying()) {
                this.hcG.stop();
            }
            this.hcG.release();
            this.hcG = null;
        }
        this.hgo = null;
        this.hgt = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hgu = true;
            this.hgt = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hgo = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hgj != null) {
                this.hgj.uM(this.hgt);
                this.hgr = this.hgj.bAN();
                this.hgp = this.hgr;
                this.hgq = this.hgr;
            }
        }
    }
}
