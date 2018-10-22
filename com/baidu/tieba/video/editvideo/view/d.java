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
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private h heb;
    private MediaPlayer hrP;
    private a hsu;
    private boolean hvA;
    private HorizontalListView hvl;
    private com.baidu.tieba.video.editvideo.a.c hvp;
    private LinearLayout hvq;
    private ImageView hvr;
    private TextView hvs;
    private boolean hvt;
    private String hvu;
    private int hvv;
    private int hvw;
    private int hvx;
    private boolean hvy;
    private String hvz;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hvt = true;
        this.hvv = 1;
        this.hsu = aVar;
        this.heb = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hvl = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hvp = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hvl.setAdapter((ListAdapter) this.hvp);
        this.hvl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hvp.bGQ() != i || i == d.this.hvv) {
                    d.this.hvw = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bHH() {
        return !TextUtils.isEmpty(this.hvz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hvp.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.x("obj_locate", i + 1);
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hvp.vD(i);
                    Tu();
                    this.hsu.replay();
                    return;
                case 2:
                    this.hvv = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cN(String str, String str2) {
        this.hvy = false;
        this.hvw = this.hvv;
        this.hvz = str2;
        aW(str, this.hvv);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hvz = musicData.id;
            this.hsu.bGP();
            String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(musicData.resource);
            if (TextUtils.isEmpty(vZ)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hrY.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void cM(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hrY.setVisibility(4);
                            d.this.aW(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void vR(String str) {
                            aVar.hrY.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.heb != null) {
                                d.this.heb.ad(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void bGw() {
                            aVar.hrY.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aW(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void vR(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.heb != null) {
                            d.this.heb.ad(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void bGw() {
                    }
                });
                return;
            }
            aW(vZ, i);
        }
    }

    public void replay() {
        this.hvy = false;
        if (this.hrP != null && this.hrP.isPlaying()) {
            this.hrP.pause();
        }
        if (this.hrP != null) {
            this.hrP.start();
            this.hrP.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, final int i) {
        this.hvx = i;
        if (this.hvw == this.hvx && !this.hvy) {
            if (this.hrP == null) {
                this.hrP = new MediaPlayer();
                this.hrP.setAudioStreamType(3);
            }
            try {
                this.hvu = str;
                this.hrP.reset();
                this.hrP.setDataSource(str);
                this.hrP.prepare();
                this.hrP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hvp.vD(i);
                        d.this.hrP.setLooping(true);
                        d.this.hrP.start();
                        d.this.hsu.replay();
                    }
                });
                this.hrP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.heb != null) {
                            d.this.heb.ad(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aX(str, i);
                if (this.heb != null) {
                    this.heb.ad(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aX(String str, int i) {
        this.hvu = null;
        Tu();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
        }
        a(i, this.hvl.getChildCount() > i ? this.hvl.getChildAt(i) : null, (MusicData) this.hvp.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hvp.setData(list);
        if (this.hvp != null) {
            this.hvx = this.hvp.bGQ();
            this.hvw = this.hvx;
        }
    }

    public String bHF() {
        return this.hvu;
    }

    public String bHG() {
        return this.hvz;
    }

    public void bS(View view) {
        this.hvq = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hvr = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hvs = (TextView) view.findViewById(e.g.video_voice_text);
        this.hvq.setVisibility(8);
        this.hvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hvt = !d.this.hvt;
                if (d.this.hvt) {
                    d.this.hvr.setSelected(false);
                    d.this.hvs.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hvr.setSelected(true);
                    d.this.hvs.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hsu.setMute(!d.this.hvt);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.x("obj_type", d.this.hvt ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hvt) {
            this.hvr.setSelected(false);
            this.hvs.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hvr.setSelected(true);
        this.hvs.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nH(boolean z) {
        if (z) {
            this.hvq.setVisibility(0);
            if (this.hvA && this.hrP == null && !TextUtils.isEmpty(this.hvu)) {
                aW(this.hvu, this.hvx);
                this.hvA = false;
                if (this.hvx > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hvl.setSelection(d.this.hvx);
                            d.this.hvl.scrollTo(d.this.hvw * l.h(d.this.getPageContext().getContext(), e.C0175e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hvq.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hvy = true;
        if (this.hrP != null && this.hrP.isPlaying()) {
            this.hrP.pause();
        }
    }

    public void onResume() {
        this.hvy = false;
        if (this.hrP != null && this.hsu.mCurrentTabIndex == 2) {
            this.hrP.start();
            this.hrP.seekTo(0);
        }
    }

    private void Tu() {
        if (this.hrP != null) {
            if (this.hrP.isPlaying()) {
                this.hrP.stop();
            }
            this.hrP.release();
            this.hrP = null;
        }
        this.hvu = null;
        this.hvz = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hvA = true;
            this.hvz = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hvu = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hvp != null) {
                this.hvp.vX(this.hvz);
                this.hvx = this.hvp.bGQ();
                this.hvv = this.hvx;
                this.hvw = this.hvx;
            }
        }
    }
}
