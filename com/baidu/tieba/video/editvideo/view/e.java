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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes23.dex */
public class e extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private h mYk;
    private MediaPlayer nmL;
    private a nnr;
    private HorizontalListView nqg;
    private com.baidu.tieba.video.editvideo.a.c nqk;
    private LinearLayout nql;
    private ImageView nqm;
    private TextView nqn;
    private boolean nqo;
    private String nqp;
    private int nqq;
    private int nqr;
    private int nqs;
    private boolean nqt;
    private String nqu;
    private boolean nqv;
    private String nqw;
    private String nqx;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.nqo = true;
        this.nqq = 1;
        this.nnr = aVar;
        this.mYk = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nqg = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nqk = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nqg.setAdapter((ListAdapter) this.nqk);
        this.nqg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nqk.dOU() != i || i == e.this.nqq) {
                    e.this.nqr = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dPG() {
        return !TextUtils.isEmpty(this.nqu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nqk.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dR("obj_id", musicData.id);
            aqVar.al("obj_locate", i + 1);
            aqVar.al("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nqk.KG(i);
                    beE();
                    this.nnr.replay();
                    return;
                case 2:
                    this.nqq = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gz(String str, String str2) {
        this.nqt = false;
        this.nqr = this.nqq;
        this.nqu = str2;
        bO(str, this.nqq);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nqu = musicData.id;
            this.nnr.dOT();
            String TM = com.baidu.tieba.video.editvideo.model.a.dPj().TM(musicData.resource);
            if (TextUtils.isEmpty(TM)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nmU.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dPj().a(musicData.id, musicData.resource, new a.InterfaceC0860a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                        public void gw(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nmU.setVisibility(4);
                            e.this.bO(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                        public void TG(String str) {
                            aVar.nmU.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mYk != null) {
                                e.this.mYk.bH(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                        public void dOD() {
                            aVar.nmU.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dPj().a(musicData.id, musicData.resource, new a.InterfaceC0860a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void gw(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bO(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void TG(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mYk != null) {
                            e.this.mYk.bH(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0860a
                    public void dOD() {
                    }
                });
                return;
            }
            bO(TM, i);
        }
    }

    public void replay() {
        this.nqt = false;
        if (this.nmL != null && this.nmL.isPlaying()) {
            this.nmL.pause();
        }
        if (this.nmL != null) {
            this.nmL.start();
            this.nmL.seekTo(0);
        }
    }

    public void gA(String str, String str2) {
        this.nqw = str;
        this.nqx = str2;
        dPM();
    }

    private void dPM() {
        if (!at.isEmpty(this.nqx) && !at.isEmpty(this.nqw)) {
            List<MusicData> data = this.nqk.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nqx)) {
                            i = i2 + 1;
                        } else {
                            KJ(i2);
                            return;
                        }
                    } else {
                        KJ(1);
                        return;
                    }
                }
            }
        }
    }

    private void KJ(final int i) {
        if (!at.isEmpty(this.nqw)) {
            this.nqs = i;
            if (this.nmL == null) {
                this.nmL = new MediaPlayer();
                this.nmL.setAudioStreamType(3);
            }
            try {
                this.nqu = this.nqx;
                this.nqp = this.nqw;
                this.nmL.reset();
                this.nmL.setDataSource(this.nqw);
                this.nmL.prepare();
                this.nmL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nqk.KG(i);
                        e.this.nmL.setLooping(true);
                    }
                });
                this.nmL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mYk != null) {
                            e.this.mYk.bH(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bP(this.nqp, i);
                if (this.mYk != null) {
                    this.mYk.bH(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.nqx = null;
                this.nqw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(String str, final int i) {
        this.nqs = i;
        if (this.nqr == this.nqs && !this.nqt) {
            if (this.nmL == null) {
                this.nmL = new MediaPlayer();
                this.nmL.setAudioStreamType(3);
            }
            try {
                this.nqp = str;
                this.nmL.reset();
                this.nmL.setDataSource(str);
                this.nmL.prepare();
                this.nmL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nqk.KG(i);
                        e.this.nmL.setLooping(true);
                        e.this.nmL.start();
                        e.this.nnr.replay();
                    }
                });
                this.nmL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mYk != null) {
                            e.this.mYk.bH(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bP(str, i);
                if (this.mYk != null) {
                    this.mYk.bH(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bP(String str, int i) {
        this.nqp = null;
        beE();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dPj().dPk();
        }
        a(i, this.nqg.getChildCount() > i ? this.nqg.getChildAt(i) : null, (MusicData) this.nqk.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nqk.setData(list);
        if (this.nqk != null) {
            this.nqs = this.nqk.dOU();
            this.nqr = this.nqs;
        }
        dPM();
    }

    public String dPE() {
        return this.nqp;
    }

    public String dPF() {
        return this.nqu;
    }

    public void dM(View view) {
        this.nql = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nqm = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nqn = (TextView) view.findViewById(R.id.video_voice_text);
        this.nql.setVisibility(8);
        this.nql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.xW(!e.this.nqo);
                e.this.nnr.setMute(!e.this.nqo);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.al("obj_type", e.this.nqo ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        xW(this.nqo);
        this.nnr.setMute(!this.nqo);
    }

    public void xW(boolean z) {
        this.nqo = z;
        if (this.nqo) {
            this.nqm.setSelected(false);
            this.nqn.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nqm.setSelected(true);
        this.nqn.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xU(boolean z) {
        if (z) {
            this.nql.setVisibility(0);
            if (this.nqv && this.nmL == null && !TextUtils.isEmpty(this.nqp)) {
                bO(this.nqp, this.nqs);
                this.nqv = false;
                if (this.nqs > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nqg.setSelection(e.this.nqs);
                            e.this.nqg.scrollTo(e.this.nqr * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nql.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nqt = true;
        if (this.nmL != null && this.nmL.isPlaying()) {
            this.nmL.pause();
        }
    }

    public void onResume() {
        this.nqt = false;
        if (this.nmL != null && this.nnr.mCurrentTabIndex == 2) {
            this.nmL.start();
            this.nmL.seekTo(0);
        }
    }

    private void beE() {
        if (this.nmL != null) {
            if (this.nmL.isPlaying()) {
                this.nmL.stop();
            }
            this.nmL.release();
            this.nmL = null;
        }
        this.nqp = null;
        this.nqu = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nqv = true;
            this.nqu = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nqp = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nqk != null) {
                this.nqk.TK(this.nqu);
                this.nqs = this.nqk.dOU();
                this.nqq = this.nqs;
                this.nqr = this.nqs;
            }
        }
    }
}
