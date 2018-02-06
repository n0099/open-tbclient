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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h hbR;
    private MediaPlayer hoP;
    private a hpw;
    private String hsA;
    private int hsB;
    private int hsC;
    private int hsD;
    private boolean hsE;
    private String hsF;
    private boolean hsG;
    private HorizontalListView hsq;
    private com.baidu.tieba.video.editvideo.a.c hsu;
    private LinearLayout hsw;
    private ImageView hsx;
    private TextView hsy;
    private boolean hsz;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hsz = true;
        this.hsB = 1;
        this.hpw = aVar;
        this.hbR = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hsq = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hsu = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hsq.setAdapter((ListAdapter) this.hsu);
        this.hsq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hsu.bBm() != i || i == d.this.hsB) {
                    d.this.hsC = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public boolean bCd() {
        return this.hoP != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hsu.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ab("obj_id", musicData.id);
            akVar.s("obj_locate", i + 1);
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hsu.wK(i);
                    blr();
                    this.hpw.replay();
                    return;
                case 2:
                    this.hsB = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.hsE = false;
        this.hsC = this.hsB;
        this.hsF = str2;
        aM(str, this.hsB);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hsF = musicData.id;
            this.hpw.bBl();
            String tN = com.baidu.tieba.video.editvideo.model.a.bBE().tN(musicData.resource);
            if (TextUtils.isEmpty(tN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hoZ.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBE().a(musicData.id, musicData.resource, new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hoZ.setVisibility(4);
                            d.this.aM(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void tE(String str) {
                            aVar.hoZ.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hbR != null) {
                                d.this.hbR.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                        public void bAS() {
                            aVar.hoZ.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBE().a(musicData.id, musicData.resource, new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aM(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void tE(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hbR != null) {
                            d.this.hbR.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0241a
                    public void bAS() {
                    }
                });
                return;
            }
            aM(tN, i);
        }
    }

    public void replay() {
        this.hsE = false;
        if (this.hoP != null && this.hoP.isPlaying()) {
            this.hoP.pause();
        }
        if (this.hoP != null) {
            this.hoP.start();
            this.hoP.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, final int i) {
        this.hsD = i;
        if (this.hsC == this.hsD && !this.hsE) {
            if (this.hoP == null) {
                this.hoP = new MediaPlayer();
                this.hoP.setAudioStreamType(3);
            }
            try {
                this.hsA = str;
                this.hoP.reset();
                this.hoP.setDataSource(str);
                this.hoP.prepare();
                this.hoP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hsu.wK(i);
                        d.this.hoP.setLooping(true);
                        d.this.hoP.start();
                        d.this.hpw.replay();
                    }
                });
                this.hoP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hbR != null) {
                            d.this.hbR.W(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aN(str, i);
                if (this.hbR != null) {
                    this.hbR.W(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aN(String str, int i) {
        this.hsA = null;
        blr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBE().bBF();
        }
        a(i, this.hsq.getChildCount() > i ? this.hsq.getChildAt(i) : null, (MusicData) this.hsu.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hsu.setData(list);
        if (this.hsu != null) {
            this.hsD = this.hsu.bBm();
            this.hsC = this.hsD;
        }
    }

    public String bCb() {
        return this.hsA;
    }

    public String bCc() {
        return this.hsF;
    }

    public void cS(View view) {
        this.hsw = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hsx = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hsy = (TextView) view.findViewById(d.g.video_voice_text);
        this.hsw.setVisibility(8);
        this.hsw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hsz = !d.this.hsz;
                if (d.this.hsz) {
                    d.this.hsx.setSelected(false);
                    d.this.hsy.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hsx.setSelected(true);
                    d.this.hsy.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hpw.setMute(!d.this.hsz);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hsz ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hsz) {
            this.hsx.setSelected(false);
            this.hsy.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hsx.setSelected(true);
        this.hsy.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nl(boolean z) {
        if (z) {
            this.hsw.setVisibility(0);
            if (this.hsG && this.hoP == null && !TextUtils.isEmpty(this.hsA)) {
                aM(this.hsA, this.hsD);
                this.hsG = false;
                if (this.hsD > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hsq.setSelection(d.this.hsD);
                            d.this.hsq.gg(d.this.hsC * l.t(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hsw.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hsE = true;
        if (this.hoP != null && this.hoP.isPlaying()) {
            this.hoP.pause();
        }
    }

    public void onResume() {
        this.hsE = false;
        if (this.hoP != null && this.hpw.mCurrentTabIndex == 2) {
            this.hoP.start();
            this.hoP.seekTo(0);
        }
    }

    private void blr() {
        if (this.hoP != null) {
            if (this.hoP.isPlaying()) {
                this.hoP.stop();
            }
            this.hoP.release();
            this.hoP = null;
        }
        this.hsA = null;
        this.hsF = null;
    }

    public void ab(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hsG = true;
            this.hsF = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hsA = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hsu != null) {
                this.hsu.tK(this.hsF);
                this.hsD = this.hsu.bBm();
                this.hsB = this.hsD;
                this.hsC = this.hsD;
            }
        }
    }
}
