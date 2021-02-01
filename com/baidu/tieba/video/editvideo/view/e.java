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
    private a nLP;
    private MediaPlayer nLj;
    private HorizontalListView nOA;
    private com.baidu.tieba.video.editvideo.a.c nOE;
    private LinearLayout nOF;
    private ImageView nOG;
    private TextView nOH;
    private boolean nOI;
    private String nOJ;
    private int nOK;
    private int nOL;
    private int nOM;
    private boolean nON;
    private String nOO;
    private boolean nOP;
    private String nOQ;
    private String nOR;
    private g nxU;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nOI = true;
        this.nOK = 1;
        this.nLP = aVar;
        this.nxU = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nOA = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nOE = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nOA.setAdapter((ListAdapter) this.nOE);
        this.nOA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nOE.dSx() != i || i == e.this.nOK) {
                    e.this.nOL = i;
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
        MusicData musicData = (MusicData) this.nOE.getItem(i);
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
                    this.nOE.KC(i);
                    bfT();
                    this.nLP.replay();
                    return;
                case 2:
                    this.nOK = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gG(String str, String str2) {
        this.nON = false;
        this.nOL = this.nOK;
        this.nOO = str2;
        bY(str, this.nOK);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nOO = musicData.id;
            this.nLP.dSw();
            String Ui = com.baidu.tieba.video.editvideo.model.a.dSM().Ui(musicData.resource);
            if (TextUtils.isEmpty(Ui)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nLs.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dSM().a(musicData.id, musicData.resource, new a.InterfaceC0886a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                        public void gD(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nLs.setVisibility(4);
                            e.this.bY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                        public void Uc(String str) {
                            aVar.nLs.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nxU != null) {
                                e.this.nxU.bM(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                        public void dSg() {
                            aVar.nLs.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dSM().a(musicData.id, musicData.resource, new a.InterfaceC0886a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void gD(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void Uc(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nxU != null) {
                            e.this.nxU.bM(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0886a
                    public void dSg() {
                    }
                });
                return;
            }
            bY(Ui, i);
        }
    }

    public void replay() {
        this.nON = false;
        if (this.nLj != null && this.nLj.isPlaying()) {
            this.nLj.pause();
        }
        if (this.nLj != null) {
            this.nLj.start();
            this.nLj.seekTo(0);
        }
    }

    public void gH(String str, String str2) {
        this.nOQ = str;
        this.nOR = str2;
        dTq();
    }

    private void dTq() {
        if (!au.isEmpty(this.nOR) && !au.isEmpty(this.nOQ)) {
            List<MusicData> data = this.nOE.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nOR)) {
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
        if (!au.isEmpty(this.nOQ)) {
            this.nOM = i;
            if (this.nLj == null) {
                this.nLj = new MediaPlayer();
                this.nLj.setAudioStreamType(3);
            }
            try {
                this.nOO = this.nOR;
                this.nOJ = this.nOQ;
                this.nLj.reset();
                this.nLj.setDataSource(this.nOQ);
                this.nLj.prepare();
                this.nLj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nOE.KC(i);
                        e.this.nLj.setLooping(true);
                    }
                });
                this.nLj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nxU != null) {
                            e.this.nxU.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(this.nOJ, i);
                if (this.nxU != null) {
                    this.nxU.bM(208, com.baidu.tieba.l.a.o(e));
                }
            } finally {
                this.nOR = null;
                this.nOQ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(String str, final int i) {
        this.nOM = i;
        if (this.nOL == this.nOM && !this.nON) {
            if (this.nLj == null) {
                this.nLj = new MediaPlayer();
                this.nLj.setAudioStreamType(3);
            }
            try {
                this.nOJ = str;
                this.nLj.reset();
                this.nLj.setDataSource(str);
                this.nLj.prepare();
                this.nLj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nOE.KC(i);
                        e.this.nLj.setLooping(true);
                        e.this.nLj.start();
                        e.this.nLP.replay();
                    }
                });
                this.nLj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nxU != null) {
                            e.this.nxU.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(str, i);
                if (this.nxU != null) {
                    this.nxU.bM(208, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    private void bZ(String str, int i) {
        this.nOJ = null;
        bfT();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dSM().dSN();
        }
        a(i, this.nOA.getChildCount() > i ? this.nOA.getChildAt(i) : null, (MusicData) this.nOE.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nOE.setData(list);
        if (this.nOE != null) {
            this.nOM = this.nOE.dSx();
            this.nOL = this.nOM;
        }
        dTq();
    }

    public String dTj() {
        return this.nOJ;
    }

    public String dTk() {
        return this.nOO;
    }

    public void em(View view) {
        this.nOF = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nOG = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nOH = (TextView) view.findViewById(R.id.video_voice_text);
        this.nOF.setVisibility(8);
        this.nOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.za(!e.this.nOI);
                e.this.nLP.setMute(!e.this.nOI);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.ap("obj_type", e.this.nOI ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        za(this.nOI);
        this.nLP.setMute(!this.nOI);
    }

    public void za(boolean z) {
        this.nOI = z;
        if (this.nOI) {
            this.nOG.setSelected(false);
            this.nOH.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nOG.setSelected(true);
        this.nOH.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yY(boolean z) {
        if (z) {
            this.nOF.setVisibility(0);
            if (this.nOP && this.nLj == null && !TextUtils.isEmpty(this.nOJ)) {
                bY(this.nOJ, this.nOM);
                this.nOP = false;
                if (this.nOM > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nOA.setSelection(e.this.nOM);
                            e.this.nOA.scrollTo(e.this.nOL * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nOF.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nON = true;
        if (this.nLj != null && this.nLj.isPlaying()) {
            this.nLj.pause();
        }
    }

    public void onResume() {
        this.nON = false;
        if (this.nLj != null && this.nLP.mCurrentTabIndex == 2) {
            this.nLj.start();
            this.nLj.seekTo(0);
        }
    }

    private void bfT() {
        if (this.nLj != null) {
            if (this.nLj.isPlaying()) {
                this.nLj.stop();
            }
            this.nLj.release();
            this.nLj = null;
        }
        this.nOJ = null;
        this.nOO = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nOP = true;
            this.nOO = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nOJ = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nOE != null) {
                this.nOE.Ug(this.nOO);
                this.nOM = this.nOE.dSx();
                this.nOK = this.nOM;
                this.nOL = this.nOM;
            }
        }
    }
}
