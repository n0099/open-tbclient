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
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.l.g;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private MediaPlayer nLJ;
    private a nMp;
    private HorizontalListView nPa;
    private com.baidu.tieba.video.editvideo.a.c nPe;
    private LinearLayout nPf;
    private ImageView nPg;
    private TextView nPh;
    private boolean nPi;
    private String nPj;
    private int nPk;
    private int nPl;
    private int nPm;
    private boolean nPn;
    private String nPo;
    private boolean nPp;
    private String nPq;
    private String nPr;
    private g nyu;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nPi = true;
        this.nPk = 1;
        this.nMp = aVar;
        this.nyu = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nPa = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nPe = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nPa.setAdapter((ListAdapter) this.nPe);
        this.nPa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nPe.dSF() != i || i == e.this.nPk) {
                    e.this.nPl = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(f fVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nPe.getItem(i);
        if (musicData != null) {
            ar arVar = new ar("c12423");
            arVar.dR("obj_id", musicData.id);
            arVar.ap("obj_locate", i + 1);
            arVar.ap("obj_source", 2);
            TiebaStatic.log(arVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nPe.KC(i);
                    bfT();
                    this.nMp.replay();
                    return;
                case 2:
                    this.nPk = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gI(String str, String str2) {
        this.nPn = false;
        this.nPl = this.nPk;
        this.nPo = str2;
        bY(str, this.nPk);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nPo = musicData.id;
            this.nMp.dSE();
            String Uu = com.baidu.tieba.video.editvideo.model.a.dSU().Uu(musicData.resource);
            if (TextUtils.isEmpty(Uu)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nLS.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dSU().a(musicData.id, musicData.resource, new a.InterfaceC0888a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void gF(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nLS.setVisibility(4);
                            e.this.bY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void Uo(String str) {
                            aVar.nLS.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nyu != null) {
                                e.this.nyu.bM(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                        public void dSo() {
                            aVar.nLS.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dSU().a(musicData.id, musicData.resource, new a.InterfaceC0888a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void gF(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void Uo(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nyu != null) {
                            e.this.nyu.bM(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0888a
                    public void dSo() {
                    }
                });
                return;
            }
            bY(Uu, i);
        }
    }

    public void replay() {
        this.nPn = false;
        if (this.nLJ != null && this.nLJ.isPlaying()) {
            this.nLJ.pause();
        }
        if (this.nLJ != null) {
            this.nLJ.start();
            this.nLJ.seekTo(0);
        }
    }

    public void gJ(String str, String str2) {
        this.nPq = str;
        this.nPr = str2;
        dTy();
    }

    private void dTy() {
        if (!au.isEmpty(this.nPr) && !au.isEmpty(this.nPq)) {
            List<MusicData> data = this.nPe.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nPr)) {
                            i = i2 + 1;
                        } else {
                            KF(i2);
                            return;
                        }
                    } else {
                        KF(1);
                        return;
                    }
                }
            }
        }
    }

    private void KF(final int i) {
        if (!au.isEmpty(this.nPq)) {
            this.nPm = i;
            if (this.nLJ == null) {
                this.nLJ = new MediaPlayer();
                this.nLJ.setAudioStreamType(3);
            }
            try {
                this.nPo = this.nPr;
                this.nPj = this.nPq;
                this.nLJ.reset();
                this.nLJ.setDataSource(this.nPq);
                this.nLJ.prepare();
                this.nLJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nPe.KC(i);
                        e.this.nLJ.setLooping(true);
                    }
                });
                this.nLJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nyu != null) {
                            e.this.nyu.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(this.nPj, i);
                if (this.nyu != null) {
                    this.nyu.bM(208, com.baidu.tieba.l.a.o(e));
                }
            } finally {
                this.nPr = null;
                this.nPq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(String str, final int i) {
        this.nPm = i;
        if (this.nPl == this.nPm && !this.nPn) {
            if (this.nLJ == null) {
                this.nLJ = new MediaPlayer();
                this.nLJ.setAudioStreamType(3);
            }
            try {
                this.nPj = str;
                this.nLJ.reset();
                this.nLJ.setDataSource(str);
                this.nLJ.prepare();
                this.nLJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nPe.KC(i);
                        e.this.nLJ.setLooping(true);
                        e.this.nLJ.start();
                        e.this.nMp.replay();
                    }
                });
                this.nLJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nyu != null) {
                            e.this.nyu.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(str, i);
                if (this.nyu != null) {
                    this.nyu.bM(208, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    private void bZ(String str, int i) {
        this.nPj = null;
        bfT();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dSU().dSV();
        }
        a(i, this.nPa.getChildCount() > i ? this.nPa.getChildAt(i) : null, (MusicData) this.nPe.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nPe.setData(list);
        if (this.nPe != null) {
            this.nPm = this.nPe.dSF();
            this.nPl = this.nPm;
        }
        dTy();
    }

    public String dTr() {
        return this.nPj;
    }

    public String dTs() {
        return this.nPo;
    }

    public void em(View view) {
        this.nPf = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nPg = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nPh = (TextView) view.findViewById(R.id.video_voice_text);
        this.nPf.setVisibility(8);
        this.nPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.za(!e.this.nPi);
                e.this.nMp.setMute(!e.this.nPi);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.ap("obj_type", e.this.nPi ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        za(this.nPi);
        this.nMp.setMute(!this.nPi);
    }

    public void za(boolean z) {
        this.nPi = z;
        if (this.nPi) {
            this.nPg.setSelected(false);
            this.nPh.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nPg.setSelected(true);
        this.nPh.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yY(boolean z) {
        if (z) {
            this.nPf.setVisibility(0);
            if (this.nPp && this.nLJ == null && !TextUtils.isEmpty(this.nPj)) {
                bY(this.nPj, this.nPm);
                this.nPp = false;
                if (this.nPm > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nPa.setSelection(e.this.nPm);
                            e.this.nPa.scrollTo(e.this.nPl * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nPf.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nPn = true;
        if (this.nLJ != null && this.nLJ.isPlaying()) {
            this.nLJ.pause();
        }
    }

    public void onResume() {
        this.nPn = false;
        if (this.nLJ != null && this.nMp.mCurrentTabIndex == 2) {
            this.nLJ.start();
            this.nLJ.seekTo(0);
        }
    }

    private void bfT() {
        if (this.nLJ != null) {
            if (this.nLJ.isPlaying()) {
                this.nLJ.stop();
            }
            this.nLJ.release();
            this.nLJ = null;
        }
        this.nPj = null;
        this.nPo = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nPp = true;
            this.nPo = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nPj = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nPe != null) {
                this.nPe.Us(this.nPo);
                this.nPm = this.nPe.dSF();
                this.nPk = this.nPm;
                this.nPl = this.nPm;
            }
        }
    }
}
