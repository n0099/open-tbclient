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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.l.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private h mZc;
    private MediaPlayer nnS;
    private a noA;
    private boolean nrA;
    private String nrB;
    private boolean nrC;
    private String nrD;
    private String nrE;
    private HorizontalListView nrn;
    private com.baidu.tieba.video.editvideo.a.c nrr;
    private LinearLayout nrs;
    private ImageView nrt;
    private TextView nru;
    private boolean nrv;
    private String nrw;
    private int nrx;
    private int nry;
    private int nrz;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.nrv = true;
        this.nrx = 1;
        this.noA = aVar;
        this.mZc = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nrn = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nrr = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nrn.setAdapter((ListAdapter) this.nrr);
        this.nrn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nrr.dOT() != i || i == e.this.nrx) {
                    e.this.nry = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public boolean dPF() {
        return !TextUtils.isEmpty(this.nrB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nrr.getItem(i);
        if (musicData != null) {
            ar arVar = new ar("c12423");
            arVar.dR("obj_id", musicData.id);
            arVar.ak("obj_locate", i + 1);
            arVar.ak("obj_source", 2);
            TiebaStatic.log(arVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nrr.Lj(i);
                    bdX();
                    this.noA.replay();
                    return;
                case 2:
                    this.nrx = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gz(String str, String str2) {
        this.nrA = false;
        this.nry = this.nrx;
        this.nrB = str2;
        bN(str, this.nrx);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nrB = musicData.id;
            this.noA.dOS();
            String Tx = com.baidu.tieba.video.editvideo.model.a.dPi().Tx(musicData.resource);
            if (TextUtils.isEmpty(Tx)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nob.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dPi().a(musicData.id, musicData.resource, new a.InterfaceC0863a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                        public void gw(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nob.setVisibility(4);
                            e.this.bN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                        public void Tr(String str) {
                            aVar.nob.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mZc != null) {
                                e.this.mZc.bF(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                        public void dOC() {
                            aVar.nob.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dPi().a(musicData.id, musicData.resource, new a.InterfaceC0863a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void gw(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void Tr(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mZc != null) {
                            e.this.mZc.bF(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0863a
                    public void dOC() {
                    }
                });
                return;
            }
            bN(Tx, i);
        }
    }

    public void replay() {
        this.nrA = false;
        if (this.nnS != null && this.nnS.isPlaying()) {
            this.nnS.pause();
        }
        if (this.nnS != null) {
            this.nnS.start();
            this.nnS.seekTo(0);
        }
    }

    public void gA(String str, String str2) {
        this.nrD = str;
        this.nrE = str2;
        dPL();
    }

    private void dPL() {
        if (!au.isEmpty(this.nrE) && !au.isEmpty(this.nrD)) {
            List<MusicData> data = this.nrr.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nrE)) {
                            i = i2 + 1;
                        } else {
                            Lm(i2);
                            return;
                        }
                    } else {
                        Lm(1);
                        return;
                    }
                }
            }
        }
    }

    private void Lm(final int i) {
        if (!au.isEmpty(this.nrD)) {
            this.nrz = i;
            if (this.nnS == null) {
                this.nnS = new MediaPlayer();
                this.nnS.setAudioStreamType(3);
            }
            try {
                this.nrB = this.nrE;
                this.nrw = this.nrD;
                this.nnS.reset();
                this.nnS.setDataSource(this.nrD);
                this.nnS.prepare();
                this.nnS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nrr.Lj(i);
                        e.this.nnS.setLooping(true);
                    }
                });
                this.nnS.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mZc != null) {
                            e.this.mZc.bF(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bO(this.nrw, i);
                if (this.mZc != null) {
                    this.mZc.bF(208, com.baidu.tieba.l.a.r(e));
                }
            } finally {
                this.nrE = null;
                this.nrD = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(String str, final int i) {
        this.nrz = i;
        if (this.nry == this.nrz && !this.nrA) {
            if (this.nnS == null) {
                this.nnS = new MediaPlayer();
                this.nnS.setAudioStreamType(3);
            }
            try {
                this.nrw = str;
                this.nnS.reset();
                this.nnS.setDataSource(str);
                this.nnS.prepare();
                this.nnS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nrr.Lj(i);
                        e.this.nnS.setLooping(true);
                        e.this.nnS.start();
                        e.this.noA.replay();
                    }
                });
                this.nnS.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mZc != null) {
                            e.this.mZc.bF(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bO(str, i);
                if (this.mZc != null) {
                    this.mZc.bF(208, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    private void bO(String str, int i) {
        this.nrw = null;
        bdX();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dPi().dPj();
        }
        a(i, this.nrn.getChildCount() > i ? this.nrn.getChildAt(i) : null, (MusicData) this.nrr.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nrr.setData(list);
        if (this.nrr != null) {
            this.nrz = this.nrr.dOT();
            this.nry = this.nrz;
        }
        dPL();
    }

    public String dPD() {
        return this.nrw;
    }

    public String dPE() {
        return this.nrB;
    }

    public void dT(View view) {
        this.nrs = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nrt = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nru = (TextView) view.findViewById(R.id.video_voice_text);
        this.nrs.setVisibility(8);
        this.nrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yd(!e.this.nrv);
                e.this.noA.setMute(!e.this.nrv);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.ak("obj_type", e.this.nrv ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        yd(this.nrv);
        this.noA.setMute(!this.nrv);
    }

    public void yd(boolean z) {
        this.nrv = z;
        if (this.nrv) {
            this.nrt.setSelected(false);
            this.nru.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nrt.setSelected(true);
        this.nru.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yb(boolean z) {
        if (z) {
            this.nrs.setVisibility(0);
            if (this.nrC && this.nnS == null && !TextUtils.isEmpty(this.nrw)) {
                bN(this.nrw, this.nrz);
                this.nrC = false;
                if (this.nrz > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nrn.setSelection(e.this.nrz);
                            e.this.nrn.scrollTo(e.this.nry * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nrs.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nrA = true;
        if (this.nnS != null && this.nnS.isPlaying()) {
            this.nnS.pause();
        }
    }

    public void onResume() {
        this.nrA = false;
        if (this.nnS != null && this.noA.mCurrentTabIndex == 2) {
            this.nnS.start();
            this.nnS.seekTo(0);
        }
    }

    private void bdX() {
        if (this.nnS != null) {
            if (this.nnS.isPlaying()) {
                this.nnS.stop();
            }
            this.nnS.release();
            this.nnS = null;
        }
        this.nrw = null;
        this.nrB = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nrC = true;
            this.nrB = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nrw = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nrr != null) {
                this.nrr.Tv(this.nrB);
                this.nrz = this.nrr.dOT();
                this.nrx = this.nrz;
                this.nry = this.nrz;
            }
        }
    }
}
