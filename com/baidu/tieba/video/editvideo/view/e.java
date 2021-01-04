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
    private a nGK;
    private MediaPlayer nGe;
    private LinearLayout nJA;
    private ImageView nJB;
    private TextView nJC;
    private boolean nJD;
    private String nJE;
    private int nJF;
    private int nJG;
    private int nJH;
    private boolean nJI;
    private String nJJ;
    private boolean nJK;
    private String nJL;
    private String nJM;
    private HorizontalListView nJv;
    private com.baidu.tieba.video.editvideo.a.c nJz;
    private g nsP;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nJD = true;
        this.nJF = 1;
        this.nGK = aVar;
        this.nsP = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nJv = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nJz = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nJv.setAdapter((ListAdapter) this.nJz);
        this.nJv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nJz.dUd() != i || i == e.this.nJF) {
                    e.this.nJG = i;
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
        MusicData musicData = (MusicData) this.nJz.getItem(i);
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
                    this.nJz.LP(i);
                    bjz();
                    this.nGK.replay();
                    return;
                case 2:
                    this.nJF = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gB(String str, String str2) {
        this.nJI = false;
        this.nJG = this.nJF;
        this.nJJ = str2;
        bX(str, this.nJF);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nJJ = musicData.id;
            this.nGK.dUc();
            String Ut = com.baidu.tieba.video.editvideo.model.a.dUs().Ut(musicData.resource);
            if (TextUtils.isEmpty(Ut)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nGn.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dUs().a(musicData.id, musicData.resource, new a.InterfaceC0862a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                        public void gy(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nGn.setVisibility(4);
                            e.this.bX(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                        public void Un(String str) {
                            aVar.nGn.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nsP != null) {
                                e.this.nsP.bF(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                        public void dTM() {
                            aVar.nGn.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dUs().a(musicData.id, musicData.resource, new a.InterfaceC0862a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void gy(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bX(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void Un(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nsP != null) {
                            e.this.nsP.bF(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0862a
                    public void dTM() {
                    }
                });
                return;
            }
            bX(Ut, i);
        }
    }

    public void replay() {
        this.nJI = false;
        if (this.nGe != null && this.nGe.isPlaying()) {
            this.nGe.pause();
        }
        if (this.nGe != null) {
            this.nGe.start();
            this.nGe.seekTo(0);
        }
    }

    public void gC(String str, String str2) {
        this.nJL = str;
        this.nJM = str2;
        dUW();
    }

    private void dUW() {
        if (!at.isEmpty(this.nJM) && !at.isEmpty(this.nJL)) {
            List<MusicData> data = this.nJz.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nJM)) {
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
        if (!at.isEmpty(this.nJL)) {
            this.nJH = i;
            if (this.nGe == null) {
                this.nGe = new MediaPlayer();
                this.nGe.setAudioStreamType(3);
            }
            try {
                this.nJJ = this.nJM;
                this.nJE = this.nJL;
                this.nGe.reset();
                this.nGe.setDataSource(this.nJL);
                this.nGe.prepare();
                this.nGe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nJz.LP(i);
                        e.this.nGe.setLooping(true);
                    }
                });
                this.nGe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nsP != null) {
                            e.this.nsP.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(this.nJE, i);
                if (this.nsP != null) {
                    this.nsP.bF(208, com.baidu.tieba.l.a.p(e));
                }
            } finally {
                this.nJM = null;
                this.nJL = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(String str, final int i) {
        this.nJH = i;
        if (this.nJG == this.nJH && !this.nJI) {
            if (this.nGe == null) {
                this.nGe = new MediaPlayer();
                this.nGe.setAudioStreamType(3);
            }
            try {
                this.nJE = str;
                this.nGe.reset();
                this.nGe.setDataSource(str);
                this.nGe.prepare();
                this.nGe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nJz.LP(i);
                        e.this.nGe.setLooping(true);
                        e.this.nGe.start();
                        e.this.nGK.replay();
                    }
                });
                this.nGe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nsP != null) {
                            e.this.nsP.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(str, i);
                if (this.nsP != null) {
                    this.nsP.bF(208, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    private void bY(String str, int i) {
        this.nJE = null;
        bjz();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dUs().dUt();
        }
        a(i, this.nJv.getChildCount() > i ? this.nJv.getChildAt(i) : null, (MusicData) this.nJz.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nJz.setData(list);
        if (this.nJz != null) {
            this.nJH = this.nJz.dUd();
            this.nJG = this.nJH;
        }
        dUW();
    }

    public String dUP() {
        return this.nJE;
    }

    public String dUQ() {
        return this.nJJ;
    }

    public void eo(View view) {
        this.nJA = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nJB = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nJC = (TextView) view.findViewById(R.id.video_voice_text);
        this.nJA.setVisibility(8);
        this.nJA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yL(!e.this.nJD);
                e.this.nGK.setMute(!e.this.nJD);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.an("obj_type", e.this.nJD ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        yL(this.nJD);
        this.nGK.setMute(!this.nJD);
    }

    public void yL(boolean z) {
        this.nJD = z;
        if (this.nJD) {
            this.nJB.setSelected(false);
            this.nJC.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nJB.setSelected(true);
        this.nJC.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yJ(boolean z) {
        if (z) {
            this.nJA.setVisibility(0);
            if (this.nJK && this.nGe == null && !TextUtils.isEmpty(this.nJE)) {
                bX(this.nJE, this.nJH);
                this.nJK = false;
                if (this.nJH > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nJv.setSelection(e.this.nJH);
                            e.this.nJv.scrollTo(e.this.nJG * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nJA.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nJI = true;
        if (this.nGe != null && this.nGe.isPlaying()) {
            this.nGe.pause();
        }
    }

    public void onResume() {
        this.nJI = false;
        if (this.nGe != null && this.nGK.mCurrentTabIndex == 2) {
            this.nGe.start();
            this.nGe.seekTo(0);
        }
    }

    private void bjz() {
        if (this.nGe != null) {
            if (this.nGe.isPlaying()) {
                this.nGe.stop();
            }
            this.nGe.release();
            this.nGe = null;
        }
        this.nJE = null;
        this.nJJ = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nJK = true;
            this.nJJ = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nJE = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nJz != null) {
                this.nJz.Ur(this.nJJ);
                this.nJH = this.nJz.dUd();
                this.nJF = this.nJH;
                this.nJG = this.nJH;
            }
        }
    }
}
