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
    private h gCU;
    private MediaPlayer gQB;
    private a gRi;
    private HorizontalListView gUa;
    private com.baidu.tieba.video.editvideo.a.c gUe;
    private LinearLayout gUf;
    private ImageView gUg;
    private TextView gUh;
    private boolean gUi;
    private String gUj;
    private int gUk;
    private int gUl;
    private int gUm;
    private boolean gUn;
    private String gUo;
    private boolean gUp;
    private Resources gan;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gUi = true;
        this.gUk = 1;
        this.gRi = aVar;
        this.gCU = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.gan = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gUa = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gUe = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gUa.setAdapter((ListAdapter) this.gUe);
        this.gUa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.gUe.bBG() != i || i == d.this.gUk) {
                    d.this.gUl = i;
                    d.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0095d.cp_bg_line_d);
    }

    public boolean bCy() {
        return this.gQB != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gUe.getItem(i);
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
                    this.gUe.vt(i);
                    bjo();
                    this.gRi.replay();
                    return;
                case 2:
                    this.gUk = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void co(String str, String str2) {
        this.gUn = false;
        this.gUl = this.gUk;
        this.gUo = str2;
        aJ(str, this.gUk);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gUo = musicData.id;
            this.gRi.bBF();
            String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(musicData.resource);
            if (TextUtils.isEmpty(uf)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.gQL.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBZ().a(musicData.id, musicData.resource, new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void cn(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gQL.setVisibility(4);
                            d.this.aJ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void tW(String str) {
                            aVar.gQL.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gCU != null) {
                                d.this.gCU.S(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                        public void bBm() {
                            aVar.gQL.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBZ().a(musicData.id, musicData.resource, new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void cn(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aJ(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void tW(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gCU != null) {
                            d.this.gCU.S(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0147a
                    public void bBm() {
                    }
                });
                return;
            }
            aJ(uf, i);
        }
    }

    public void replay() {
        this.gUn = false;
        if (this.gQB != null && this.gQB.isPlaying()) {
            this.gQB.pause();
        }
        if (this.gQB != null) {
            this.gQB.start();
            this.gQB.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, final int i) {
        this.gUm = i;
        if (this.gUl == this.gUm && !this.gUn) {
            if (this.gQB == null) {
                this.gQB = new MediaPlayer();
                this.gQB.setAudioStreamType(3);
            }
            try {
                this.gUj = str;
                this.gQB.reset();
                this.gQB.setDataSource(str);
                this.gQB.prepare();
                this.gQB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gUe.vt(i);
                        d.this.gQB.setLooping(true);
                        d.this.gQB.start();
                        d.this.gRi.replay();
                    }
                });
                this.gQB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gCU != null) {
                            d.this.gCU.S(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aK(str, i);
                if (this.gCU != null) {
                    this.gCU.S(208, com.baidu.tieba.i.a.g(e));
                }
            }
        }
    }

    private void aK(String str, int i) {
        this.gUj = null;
        bjo();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBZ().bCa();
        }
        a(i, this.gUa.getChildCount() > i ? this.gUa.getChildAt(i) : null, (MusicData) this.gUe.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gUe.setData(list);
        if (this.gUe != null) {
            this.gUm = this.gUe.bBG();
            this.gUl = this.gUm;
        }
    }

    public String bCw() {
        return this.gUj;
    }

    public String bCx() {
        return this.gUo;
    }

    public void bM(View view) {
        this.gUf = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.gUg = (ImageView) view.findViewById(d.g.video_voice_img);
        this.gUh = (TextView) view.findViewById(d.g.video_voice_text);
        this.gUf.setVisibility(8);
        this.gUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.gUi = !d.this.gUi;
                if (d.this.gUi) {
                    d.this.gUg.setSelected(false);
                    d.this.gUh.setText(d.this.gan.getString(d.j.video_voice_open));
                } else {
                    d.this.gUg.setSelected(true);
                    d.this.gUh.setText(d.this.gan.getString(d.j.video_voice_close));
                }
                d.this.gRi.setMute(!d.this.gUi);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", d.this.gUi ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gUi) {
            this.gUg.setSelected(false);
            this.gUh.setText(this.gan.getString(d.j.video_voice_open));
            return;
        }
        this.gUg.setSelected(true);
        this.gUh.setText(this.gan.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nF(boolean z) {
        if (z) {
            this.gUf.setVisibility(0);
            if (this.gUp && this.gQB == null && !TextUtils.isEmpty(this.gUj)) {
                aJ(this.gUj, this.gUm);
                this.gUp = false;
                if (this.gUm > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gUa.setSelection(d.this.gUm);
                            d.this.gUa.dh(d.this.gUl * l.f(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.gUf.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gUn = true;
        if (this.gQB != null && this.gQB.isPlaying()) {
            this.gQB.pause();
        }
    }

    public void onResume() {
        this.gUn = false;
        if (this.gQB != null && this.gRi.mCurrentTabIndex == 2) {
            this.gQB.start();
            this.gQB.seekTo(0);
        }
    }

    private void bjo() {
        if (this.gQB != null) {
            if (this.gQB.isPlaying()) {
                this.gQB.stop();
            }
            this.gQB.release();
            this.gQB = null;
        }
        this.gUj = null;
        this.gUo = null;
    }

    public void ad(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gUp = true;
            this.gUo = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gUj = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gUe != null) {
                this.gUe.uc(this.gUo);
                this.gUm = this.gUe.bBG();
                this.gUk = this.gUm;
                this.gUl = this.gUm;
            }
        }
    }
}
