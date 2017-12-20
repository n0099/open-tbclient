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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gCP;
    private MediaPlayer gQw;
    private a gRd;
    private HorizontalListView gTV;
    private com.baidu.tieba.video.editvideo.a.c gTZ;
    private LinearLayout gUa;
    private ImageView gUb;
    private TextView gUc;
    private boolean gUd;
    private String gUe;
    private int gUf;
    private int gUg;
    private int gUh;
    private boolean gUi;
    private String gUj;
    private boolean gUk;
    private Resources gai;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gUd = true;
        this.gUf = 1;
        this.gRd = aVar;
        this.gCP = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.gai = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gTV = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gTZ = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gTV.setAdapter((ListAdapter) this.gTZ);
        this.gTV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.gTZ.bBF() != i || i == d.this.gUf) {
                    d.this.gUg = i;
                    d.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0096d.cp_bg_line_d);
    }

    public boolean bCx() {
        return this.gQw != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gTZ.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ac("obj_id", musicData.id);
            akVar.r("obj_locate", i + 1);
            akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.gTZ.vt(i);
                    bjn();
                    this.gRd.replay();
                    return;
                case 2:
                    this.gUf = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void co(String str, String str2) {
        this.gUi = false;
        this.gUg = this.gUf;
        this.gUj = str2;
        aJ(str, this.gUf);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gUj = musicData.id;
            this.gRd.bBE();
            String uf = com.baidu.tieba.video.editvideo.model.a.bBY().uf(musicData.resource);
            if (TextUtils.isEmpty(uf)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.gQG.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBY().a(musicData.id, musicData.resource, new a.InterfaceC0148a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void cn(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gQG.setVisibility(4);
                            d.this.aJ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void tW(String str) {
                            aVar.gQG.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gCP != null) {
                                d.this.gCP.S(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                        public void bBl() {
                            aVar.gQG.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBY().a(musicData.id, musicData.resource, new a.InterfaceC0148a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void cn(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aJ(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void tW(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gCP != null) {
                            d.this.gCP.S(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0148a
                    public void bBl() {
                    }
                });
                return;
            }
            aJ(uf, i);
        }
    }

    public void replay() {
        this.gUi = false;
        if (this.gQw != null && this.gQw.isPlaying()) {
            this.gQw.pause();
        }
        if (this.gQw != null) {
            this.gQw.start();
            this.gQw.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, final int i) {
        this.gUh = i;
        if (this.gUg == this.gUh && !this.gUi) {
            if (this.gQw == null) {
                this.gQw = new MediaPlayer();
                this.gQw.setAudioStreamType(3);
            }
            try {
                this.gUe = str;
                this.gQw.reset();
                this.gQw.setDataSource(str);
                this.gQw.prepare();
                this.gQw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gTZ.vt(i);
                        d.this.gQw.setLooping(true);
                        d.this.gQw.start();
                        d.this.gRd.replay();
                    }
                });
                this.gQw.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gCP != null) {
                            d.this.gCP.S(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aK(str, i);
                if (this.gCP != null) {
                    this.gCP.S(208, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    private void aK(String str, int i) {
        this.gUe = null;
        bjn();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBY().bBZ();
        }
        a(i, this.gTV.getChildCount() > i ? this.gTV.getChildAt(i) : null, (MusicData) this.gTZ.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gTZ.setData(list);
        if (this.gTZ != null) {
            this.gUh = this.gTZ.bBF();
            this.gUg = this.gUh;
        }
    }

    public String bCv() {
        return this.gUe;
    }

    public String bCw() {
        return this.gUj;
    }

    public void bM(View view) {
        this.gUa = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.gUb = (ImageView) view.findViewById(d.g.video_voice_img);
        this.gUc = (TextView) view.findViewById(d.g.video_voice_text);
        this.gUa.setVisibility(8);
        this.gUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.gUd = !d.this.gUd;
                if (d.this.gUd) {
                    d.this.gUb.setSelected(false);
                    d.this.gUc.setText(d.this.gai.getString(d.j.video_voice_open));
                } else {
                    d.this.gUb.setSelected(true);
                    d.this.gUc.setText(d.this.gai.getString(d.j.video_voice_close));
                }
                d.this.gRd.setMute(!d.this.gUd);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", d.this.gUd ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gUd) {
            this.gUb.setSelected(false);
            this.gUc.setText(this.gai.getString(d.j.video_voice_open));
            return;
        }
        this.gUb.setSelected(true);
        this.gUc.setText(this.gai.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nF(boolean z) {
        if (z) {
            this.gUa.setVisibility(0);
            if (this.gUk && this.gQw == null && !TextUtils.isEmpty(this.gUe)) {
                aJ(this.gUe, this.gUh);
                this.gUk = false;
                if (this.gUh > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gTV.setSelection(d.this.gUh);
                            d.this.gTV.dh(d.this.gUg * l.f(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.gUa.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gUi = true;
        if (this.gQw != null && this.gQw.isPlaying()) {
            this.gQw.pause();
        }
    }

    public void onResume() {
        this.gUi = false;
        if (this.gQw != null && this.gRd.mCurrentTabIndex == 2) {
            this.gQw.start();
            this.gQw.seekTo(0);
        }
    }

    private void bjn() {
        if (this.gQw != null) {
            if (this.gQw.isPlaying()) {
                this.gQw.stop();
            }
            this.gQw.release();
            this.gQw = null;
        }
        this.gUe = null;
        this.gUj = null;
    }

    public void ad(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gUk = true;
            this.gUj = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gUe = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gTZ != null) {
                this.gTZ.uc(this.gUj);
                this.gUh = this.gTZ.bBF();
                this.gUf = this.gUh;
                this.gUg = this.gUh;
            }
        }
    }
}
