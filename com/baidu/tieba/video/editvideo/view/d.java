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
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gOY;
    private MediaPlayer hcF;
    private a hdl;
    private HorizontalListView hge;
    private com.baidu.tieba.video.editvideo.a.c hgi;
    private LinearLayout hgj;
    private ImageView hgk;
    private TextView hgl;
    private boolean hgm;
    private String hgn;
    private int hgo;
    private int hgp;
    private int hgq;
    private boolean hgr;
    private String hgs;
    private boolean hgt;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hgm = true;
        this.hgo = 1;
        this.hdl = aVar;
        this.gOY = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hge = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hgi = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hge.setAdapter((ListAdapter) this.hgi);
        this.hge.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hgi.bAL() != i || i == d.this.hgo) {
                    d.this.hgp = i;
                    d.this.g(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public boolean bBC() {
        return !TextUtils.isEmpty(this.hgs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, View view) {
        MusicData musicData = (MusicData) this.hgi.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.af(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            anVar.r("obj_locate", i + 1);
            anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hgi.uG(i);
                    bkr();
                    this.hdl.replay();
                    return;
                case 2:
                    this.hgo = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cs(String str, String str2) {
        this.hgr = false;
        this.hgp = this.hgo;
        this.hgs = str2;
        aN(str, this.hgo);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hgs = musicData.id;
            this.hdl.bAK();
            String uL = com.baidu.tieba.video.editvideo.model.a.bBd().uL(musicData.resource);
            if (TextUtils.isEmpty(uL)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hcO.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBd().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cr(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hcO.setVisibility(4);
                            d.this.aN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void uC(String str) {
                            aVar.hcO.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gOY != null) {
                                d.this.gOY.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAr() {
                            aVar.hcO.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBd().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cr(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uC(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gOY != null) {
                            d.this.gOY.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAr() {
                    }
                });
                return;
            }
            aN(uL, i);
        }
    }

    public void replay() {
        this.hgr = false;
        if (this.hcF != null && this.hcF.isPlaying()) {
            this.hcF.pause();
        }
        if (this.hcF != null) {
            this.hcF.start();
            this.hcF.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, final int i) {
        this.hgq = i;
        if (this.hgp == this.hgq && !this.hgr) {
            if (this.hcF == null) {
                this.hcF = new MediaPlayer();
                this.hcF.setAudioStreamType(3);
            }
            try {
                this.hgn = str;
                this.hcF.reset();
                this.hcF.setDataSource(str);
                this.hcF.prepare();
                this.hcF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hgi.uG(i);
                        d.this.hcF.setLooping(true);
                        d.this.hcF.start();
                        d.this.hdl.replay();
                    }
                });
                this.hcF.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gOY != null) {
                            d.this.gOY.ad(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aO(str, i);
                if (this.gOY != null) {
                    this.gOY.ad(208, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    private void aO(String str, int i) {
        this.hgn = null;
        bkr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBd().bBe();
        }
        a(i, this.hge.getChildCount() > i ? this.hge.getChildAt(i) : null, (MusicData) this.hgi.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hgi.setData(list);
        if (this.hgi != null) {
            this.hgq = this.hgi.bAL();
            this.hgp = this.hgq;
        }
    }

    public String bBA() {
        return this.hgn;
    }

    public String bBB() {
        return this.hgs;
    }

    public void bF(View view) {
        this.hgj = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hgk = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hgl = (TextView) view.findViewById(d.g.video_voice_text);
        this.hgj.setVisibility(8);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hgm = !d.this.hgm;
                if (d.this.hgm) {
                    d.this.hgk.setSelected(false);
                    d.this.hgl.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hgk.setSelected(true);
                    d.this.hgl.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hdl.setMute(!d.this.hgm);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.r("obj_type", d.this.hgm ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.hgm) {
            this.hgk.setSelected(false);
            this.hgl.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hgk.setSelected(true);
        this.hgl.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
        if (z) {
            this.hgj.setVisibility(0);
            if (this.hgt && this.hcF == null && !TextUtils.isEmpty(this.hgn)) {
                aN(this.hgn, this.hgq);
                this.hgt = false;
                if (this.hgq > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hge.setSelection(d.this.hgq);
                            d.this.hge.dl(d.this.hgp * l.f(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hgj.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hgr = true;
        if (this.hcF != null && this.hcF.isPlaying()) {
            this.hcF.pause();
        }
    }

    public void onResume() {
        this.hgr = false;
        if (this.hcF != null && this.hdl.mCurrentTabIndex == 2) {
            this.hcF.start();
            this.hcF.seekTo(0);
        }
    }

    private void bkr() {
        if (this.hcF != null) {
            if (this.hcF.isPlaying()) {
                this.hcF.stop();
            }
            this.hcF.release();
            this.hcF = null;
        }
        this.hgn = null;
        this.hgs = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hgt = true;
            this.hgs = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hgn = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hgi != null) {
                this.hgi.uI(this.hgs);
                this.hgq = this.hgi.bAL();
                this.hgo = this.hgq;
                this.hgp = this.hgq;
            }
        }
    }
}
