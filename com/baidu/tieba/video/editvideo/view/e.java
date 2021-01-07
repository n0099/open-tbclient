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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
    private a nGJ;
    private MediaPlayer nGd;
    private ImageView nJA;
    private TextView nJB;
    private boolean nJC;
    private String nJD;
    private int nJE;
    private int nJF;
    private int nJG;
    private boolean nJH;
    private String nJI;
    private boolean nJJ;
    private String nJK;
    private String nJL;
    private HorizontalListView nJu;
    private com.baidu.tieba.video.editvideo.a.c nJy;
    private LinearLayout nJz;
    private g nsO;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nJC = true;
        this.nJE = 1;
        this.nGJ = aVar;
        this.nsO = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nJu = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nJy = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nJu.setAdapter((ListAdapter) this.nJy);
        this.nJu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nJy.dUe() != i || i == e.this.nJE) {
                    e.this.nJF = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(f fVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nJy.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dX("obj_id", musicData.id);
            aqVar.an("obj_locate", i + 1);
            aqVar.an("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nJy.LP(i);
                    bjA();
                    this.nGJ.replay();
                    return;
                case 2:
                    this.nJE = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gB(String str, String str2) {
        this.nJH = false;
        this.nJF = this.nJE;
        this.nJI = str2;
        bX(str, this.nJE);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nJI = musicData.id;
            this.nGJ.dUd();
            String Us = com.baidu.tieba.video.editvideo.model.a.dUt().Us(musicData.resource);
            if (TextUtils.isEmpty(Us)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nGm.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dUt().a(musicData.id, musicData.resource, new a.InterfaceC0900a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                        public void gy(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nGm.setVisibility(4);
                            e.this.bX(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                        public void Um(String str) {
                            aVar.nGm.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nsO != null) {
                                e.this.nsO.bF(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                        public void dTN() {
                            aVar.nGm.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dUt().a(musicData.id, musicData.resource, new a.InterfaceC0900a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void gy(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bX(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void Um(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nsO != null) {
                            e.this.nsO.bF(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0900a
                    public void dTN() {
                    }
                });
                return;
            }
            bX(Us, i);
        }
    }

    public void replay() {
        this.nJH = false;
        if (this.nGd != null && this.nGd.isPlaying()) {
            this.nGd.pause();
        }
        if (this.nGd != null) {
            this.nGd.start();
            this.nGd.seekTo(0);
        }
    }

    public void gC(String str, String str2) {
        this.nJK = str;
        this.nJL = str2;
        dUX();
    }

    private void dUX() {
        if (!at.isEmpty(this.nJL) && !at.isEmpty(this.nJK)) {
            List<MusicData> data = this.nJy.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nJL)) {
                            i = i2 + 1;
                        } else {
                            LS(i2);
                            return;
                        }
                    } else {
                        LS(1);
                        return;
                    }
                }
            }
        }
    }

    private void LS(final int i) {
        if (!at.isEmpty(this.nJK)) {
            this.nJG = i;
            if (this.nGd == null) {
                this.nGd = new MediaPlayer();
                this.nGd.setAudioStreamType(3);
            }
            try {
                this.nJI = this.nJL;
                this.nJD = this.nJK;
                this.nGd.reset();
                this.nGd.setDataSource(this.nJK);
                this.nGd.prepare();
                this.nGd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nJy.LP(i);
                        e.this.nGd.setLooping(true);
                    }
                });
                this.nGd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nsO != null) {
                            e.this.nsO.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(this.nJD, i);
                if (this.nsO != null) {
                    this.nsO.bF(208, com.baidu.tieba.l.a.p(e));
                }
            } finally {
                this.nJL = null;
                this.nJK = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(String str, final int i) {
        this.nJG = i;
        if (this.nJF == this.nJG && !this.nJH) {
            if (this.nGd == null) {
                this.nGd = new MediaPlayer();
                this.nGd.setAudioStreamType(3);
            }
            try {
                this.nJD = str;
                this.nGd.reset();
                this.nGd.setDataSource(str);
                this.nGd.prepare();
                this.nGd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nJy.LP(i);
                        e.this.nGd.setLooping(true);
                        e.this.nGd.start();
                        e.this.nGJ.replay();
                    }
                });
                this.nGd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nsO != null) {
                            e.this.nsO.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(str, i);
                if (this.nsO != null) {
                    this.nsO.bF(208, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    private void bY(String str, int i) {
        this.nJD = null;
        bjA();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dUt().dUu();
        }
        a(i, this.nJu.getChildCount() > i ? this.nJu.getChildAt(i) : null, (MusicData) this.nJy.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nJy.setData(list);
        if (this.nJy != null) {
            this.nJG = this.nJy.dUe();
            this.nJF = this.nJG;
        }
        dUX();
    }

    public String dUQ() {
        return this.nJD;
    }

    public String dUR() {
        return this.nJI;
    }

    public void eo(View view) {
        this.nJz = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nJA = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nJB = (TextView) view.findViewById(R.id.video_voice_text);
        this.nJz.setVisibility(8);
        this.nJz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yL(!e.this.nJC);
                e.this.nGJ.setMute(!e.this.nJC);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.an("obj_type", e.this.nJC ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        yL(this.nJC);
        this.nGJ.setMute(!this.nJC);
    }

    public void yL(boolean z) {
        this.nJC = z;
        if (this.nJC) {
            this.nJA.setSelected(false);
            this.nJB.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nJA.setSelected(true);
        this.nJB.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yJ(boolean z) {
        if (z) {
            this.nJz.setVisibility(0);
            if (this.nJJ && this.nGd == null && !TextUtils.isEmpty(this.nJD)) {
                bX(this.nJD, this.nJG);
                this.nJJ = false;
                if (this.nJG > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nJu.setSelection(e.this.nJG);
                            e.this.nJu.scrollTo(e.this.nJF * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nJz.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nJH = true;
        if (this.nGd != null && this.nGd.isPlaying()) {
            this.nGd.pause();
        }
    }

    public void onResume() {
        this.nJH = false;
        if (this.nGd != null && this.nGJ.mCurrentTabIndex == 2) {
            this.nGd.start();
            this.nGd.seekTo(0);
        }
    }

    private void bjA() {
        if (this.nGd != null) {
            if (this.nGd.isPlaying()) {
                this.nGd.stop();
            }
            this.nGd.release();
            this.nGd = null;
        }
        this.nJD = null;
        this.nJI = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nJJ = true;
            this.nJI = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nJD = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nJy != null) {
                this.nJy.Uq(this.nJI);
                this.nJG = this.nJy.dUe();
                this.nJE = this.nJG;
                this.nJF = this.nJG;
            }
        }
    }
}
