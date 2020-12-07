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
import com.baidu.ar.face.algo.FAUEnum;
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
/* loaded from: classes23.dex */
public class e extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private MediaPlayer nBV;
    private a nCB;
    private int nFA;
    private boolean nFB;
    private String nFC;
    private boolean nFD;
    private String nFE;
    private String nFF;
    private HorizontalListView nFo;
    private com.baidu.tieba.video.editvideo.a.c nFs;
    private LinearLayout nFt;
    private ImageView nFu;
    private TextView nFv;
    private boolean nFw;
    private String nFx;
    private int nFy;
    private int nFz;
    private h nnb;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.nFw = true;
        this.nFy = 1;
        this.nCB = aVar;
        this.nnb = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nFo = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nFs = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nFo.setAdapter((ListAdapter) this.nFs);
        this.nFo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nFs.dUl() != i || i == e.this.nFy) {
                    e.this.nFz = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public boolean dUZ() {
        return !TextUtils.isEmpty(this.nFC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nFs.getItem(i);
        if (musicData != null) {
            ar arVar = new ar("c12423");
            arVar.dY("obj_id", musicData.id);
            arVar.al("obj_locate", i + 1);
            arVar.al("obj_source", 2);
            TiebaStatic.log(arVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nFs.Mb(i);
                    bhc();
                    this.nCB.replay();
                    return;
                case 2:
                    this.nFy = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gE(String str, String str2) {
        this.nFB = false;
        this.nFz = this.nFy;
        this.nFC = str2;
        bQ(str, this.nFy);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nFC = musicData.id;
            this.nCB.dUk();
            String UM = com.baidu.tieba.video.editvideo.model.a.dUA().UM(musicData.resource);
            if (TextUtils.isEmpty(UM)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nCe.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dUA().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void gB(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nCe.setVisibility(4);
                            e.this.bQ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void UG(String str) {
                            aVar.nCe.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nnb != null) {
                                e.this.nnb.bF(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void dTU() {
                            aVar.nCe.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dUA().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void gB(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bQ(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void UG(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nnb != null) {
                            e.this.nnb.bF(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void dTU() {
                    }
                });
                return;
            }
            bQ(UM, i);
        }
    }

    public void replay() {
        this.nFB = false;
        if (this.nBV != null && this.nBV.isPlaying()) {
            this.nBV.pause();
        }
        if (this.nBV != null) {
            this.nBV.start();
            this.nBV.seekTo(0);
        }
    }

    public void gF(String str, String str2) {
        this.nFE = str;
        this.nFF = str2;
        dVf();
    }

    private void dVf() {
        if (!au.isEmpty(this.nFF) && !au.isEmpty(this.nFE)) {
            List<MusicData> data = this.nFs.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nFF)) {
                            i = i2 + 1;
                        } else {
                            Me(i2);
                            return;
                        }
                    } else {
                        Me(1);
                        return;
                    }
                }
            }
        }
    }

    private void Me(final int i) {
        if (!au.isEmpty(this.nFE)) {
            this.nFA = i;
            if (this.nBV == null) {
                this.nBV = new MediaPlayer();
                this.nBV.setAudioStreamType(3);
            }
            try {
                this.nFC = this.nFF;
                this.nFx = this.nFE;
                this.nBV.reset();
                this.nBV.setDataSource(this.nFE);
                this.nBV.prepare();
                this.nBV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nFs.Mb(i);
                        e.this.nBV.setLooping(true);
                    }
                });
                this.nBV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nnb != null) {
                            e.this.nnb.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bR(this.nFx, i);
                if (this.nnb != null) {
                    this.nnb.bF(FAUEnum.PR_ANIMATE_FAILED, com.baidu.tieba.l.a.r(e));
                }
            } finally {
                this.nFF = null;
                this.nFE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(String str, final int i) {
        this.nFA = i;
        if (this.nFz == this.nFA && !this.nFB) {
            if (this.nBV == null) {
                this.nBV = new MediaPlayer();
                this.nBV.setAudioStreamType(3);
            }
            try {
                this.nFx = str;
                this.nBV.reset();
                this.nBV.setDataSource(str);
                this.nBV.prepare();
                this.nBV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nFs.Mb(i);
                        e.this.nBV.setLooping(true);
                        e.this.nBV.start();
                        e.this.nCB.replay();
                    }
                });
                this.nBV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nnb != null) {
                            e.this.nnb.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bR(str, i);
                if (this.nnb != null) {
                    this.nnb.bF(FAUEnum.PR_ANIMATE_FAILED, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    private void bR(String str, int i) {
        this.nFx = null;
        bhc();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dUA().dUB();
        }
        a(i, this.nFo.getChildCount() > i ? this.nFo.getChildAt(i) : null, (MusicData) this.nFs.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nFs.setData(list);
        if (this.nFs != null) {
            this.nFA = this.nFs.dUl();
            this.nFz = this.nFA;
        }
        dVf();
    }

    public String dUX() {
        return this.nFx;
    }

    public String dUY() {
        return this.nFC;
    }

    public void ee(View view) {
        this.nFt = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nFu = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nFv = (TextView) view.findViewById(R.id.video_voice_text);
        this.nFt.setVisibility(8);
        this.nFt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yI(!e.this.nFw);
                e.this.nCB.setMute(!e.this.nFw);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.al("obj_type", e.this.nFw ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        yI(this.nFw);
        this.nCB.setMute(!this.nFw);
    }

    public void yI(boolean z) {
        this.nFw = z;
        if (this.nFw) {
            this.nFu.setSelected(false);
            this.nFv.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nFu.setSelected(true);
        this.nFv.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yG(boolean z) {
        if (z) {
            this.nFt.setVisibility(0);
            if (this.nFD && this.nBV == null && !TextUtils.isEmpty(this.nFx)) {
                bQ(this.nFx, this.nFA);
                this.nFD = false;
                if (this.nFA > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nFo.setSelection(e.this.nFA);
                            e.this.nFo.scrollTo(e.this.nFz * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nFt.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nFB = true;
        if (this.nBV != null && this.nBV.isPlaying()) {
            this.nBV.pause();
        }
    }

    public void onResume() {
        this.nFB = false;
        if (this.nBV != null && this.nCB.mCurrentTabIndex == 2) {
            this.nBV.start();
            this.nBV.seekTo(0);
        }
    }

    private void bhc() {
        if (this.nBV != null) {
            if (this.nBV.isPlaying()) {
                this.nBV.stop();
            }
            this.nBV.release();
            this.nBV = null;
        }
        this.nFx = null;
        this.nFC = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nFD = true;
            this.nFC = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nFx = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nFs != null) {
                this.nFs.UK(this.nFC);
                this.nFA = this.nFs.dUl();
                this.nFy = this.nFA;
                this.nFz = this.nFA;
            }
        }
    }
}
