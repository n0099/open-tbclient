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
    private MediaPlayer nBX;
    private a nCD;
    private int nFA;
    private int nFB;
    private int nFC;
    private boolean nFD;
    private String nFE;
    private boolean nFF;
    private String nFG;
    private String nFH;
    private HorizontalListView nFq;
    private com.baidu.tieba.video.editvideo.a.c nFu;
    private LinearLayout nFv;
    private ImageView nFw;
    private TextView nFx;
    private boolean nFy;
    private String nFz;
    private h nnd;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.nFy = true;
        this.nFA = 1;
        this.nCD = aVar;
        this.nnd = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nFq = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nFu = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nFq.setAdapter((ListAdapter) this.nFu);
        this.nFq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nFu.dUm() != i || i == e.this.nFA) {
                    e.this.nFB = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public boolean dVa() {
        return !TextUtils.isEmpty(this.nFE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nFu.getItem(i);
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
                    this.nFu.Mb(i);
                    bhc();
                    this.nCD.replay();
                    return;
                case 2:
                    this.nFA = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gE(String str, String str2) {
        this.nFD = false;
        this.nFB = this.nFA;
        this.nFE = str2;
        bQ(str, this.nFA);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nFE = musicData.id;
            this.nCD.dUl();
            String UM = com.baidu.tieba.video.editvideo.model.a.dUB().UM(musicData.resource);
            if (TextUtils.isEmpty(UM)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nCg.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dUB().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void gB(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nCg.setVisibility(4);
                            e.this.bQ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void UG(String str) {
                            aVar.nCg.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nnd != null) {
                                e.this.nnd.bF(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                        public void dTV() {
                            aVar.nCg.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dUB().a(musicData.id, musicData.resource, new a.InterfaceC0879a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
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
                        if (e.this.nnd != null) {
                            e.this.nnd.bF(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0879a
                    public void dTV() {
                    }
                });
                return;
            }
            bQ(UM, i);
        }
    }

    public void replay() {
        this.nFD = false;
        if (this.nBX != null && this.nBX.isPlaying()) {
            this.nBX.pause();
        }
        if (this.nBX != null) {
            this.nBX.start();
            this.nBX.seekTo(0);
        }
    }

    public void gF(String str, String str2) {
        this.nFG = str;
        this.nFH = str2;
        dVg();
    }

    private void dVg() {
        if (!au.isEmpty(this.nFH) && !au.isEmpty(this.nFG)) {
            List<MusicData> data = this.nFu.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nFH)) {
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
        if (!au.isEmpty(this.nFG)) {
            this.nFC = i;
            if (this.nBX == null) {
                this.nBX = new MediaPlayer();
                this.nBX.setAudioStreamType(3);
            }
            try {
                this.nFE = this.nFH;
                this.nFz = this.nFG;
                this.nBX.reset();
                this.nBX.setDataSource(this.nFG);
                this.nBX.prepare();
                this.nBX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nFu.Mb(i);
                        e.this.nBX.setLooping(true);
                    }
                });
                this.nBX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nnd != null) {
                            e.this.nnd.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bR(this.nFz, i);
                if (this.nnd != null) {
                    this.nnd.bF(FAUEnum.PR_ANIMATE_FAILED, com.baidu.tieba.l.a.r(e));
                }
            } finally {
                this.nFH = null;
                this.nFG = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(String str, final int i) {
        this.nFC = i;
        if (this.nFB == this.nFC && !this.nFD) {
            if (this.nBX == null) {
                this.nBX = new MediaPlayer();
                this.nBX.setAudioStreamType(3);
            }
            try {
                this.nFz = str;
                this.nBX.reset();
                this.nBX.setDataSource(str);
                this.nBX.prepare();
                this.nBX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nFu.Mb(i);
                        e.this.nBX.setLooping(true);
                        e.this.nBX.start();
                        e.this.nCD.replay();
                    }
                });
                this.nBX.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nnd != null) {
                            e.this.nnd.bF(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bR(str, i);
                if (this.nnd != null) {
                    this.nnd.bF(FAUEnum.PR_ANIMATE_FAILED, com.baidu.tieba.l.a.r(e));
                }
            }
        }
    }

    private void bR(String str, int i) {
        this.nFz = null;
        bhc();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dUB().dUC();
        }
        a(i, this.nFq.getChildCount() > i ? this.nFq.getChildAt(i) : null, (MusicData) this.nFu.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nFu.setData(list);
        if (this.nFu != null) {
            this.nFC = this.nFu.dUm();
            this.nFB = this.nFC;
        }
        dVg();
    }

    public String dUY() {
        return this.nFz;
    }

    public String dUZ() {
        return this.nFE;
    }

    public void ee(View view) {
        this.nFv = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nFw = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nFx = (TextView) view.findViewById(R.id.video_voice_text);
        this.nFv.setVisibility(8);
        this.nFv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yI(!e.this.nFy);
                e.this.nCD.setMute(!e.this.nFy);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.al("obj_type", e.this.nFy ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        yI(this.nFy);
        this.nCD.setMute(!this.nFy);
    }

    public void yI(boolean z) {
        this.nFy = z;
        if (this.nFy) {
            this.nFw.setSelected(false);
            this.nFx.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nFw.setSelected(true);
        this.nFx.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yG(boolean z) {
        if (z) {
            this.nFv.setVisibility(0);
            if (this.nFF && this.nBX == null && !TextUtils.isEmpty(this.nFz)) {
                bQ(this.nFz, this.nFC);
                this.nFF = false;
                if (this.nFC > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nFq.setSelection(e.this.nFC);
                            e.this.nFq.scrollTo(e.this.nFB * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nFv.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nFD = true;
        if (this.nBX != null && this.nBX.isPlaying()) {
            this.nBX.pause();
        }
    }

    public void onResume() {
        this.nFD = false;
        if (this.nBX != null && this.nCD.mCurrentTabIndex == 2) {
            this.nBX.start();
            this.nBX.seekTo(0);
        }
    }

    private void bhc() {
        if (this.nBX != null) {
            if (this.nBX.isPlaying()) {
                this.nBX.stop();
            }
            this.nBX.release();
            this.nBX = null;
        }
        this.nFz = null;
        this.nFE = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nFF = true;
            this.nFE = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nFz = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nFu != null) {
                this.nFu.UK(this.nFE);
                this.nFC = this.nFu.dUm();
                this.nFA = this.nFC;
                this.nFB = this.nFC;
            }
        }
    }
}
