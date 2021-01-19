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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private MediaPlayer nBz;
    private a nCf;
    private HorizontalListView nEQ;
    private com.baidu.tieba.video.editvideo.a.c nEU;
    private LinearLayout nEV;
    private ImageView nEW;
    private TextView nEX;
    private boolean nEY;
    private String nEZ;
    private int nFa;
    private int nFb;
    private int nFc;
    private boolean nFd;
    private String nFe;
    private boolean nFf;
    private String nFg;
    private String nFh;
    private g noi;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nEY = true;
        this.nFa = 1;
        this.nCf = aVar;
        this.noi = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nEQ = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nEU = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nEQ.setAdapter((ListAdapter) this.nEU);
        this.nEQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nEU.dQm() != i || i == e.this.nFa) {
                    e.this.nFb = i;
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
        MusicData musicData = (MusicData) this.nEU.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dW("obj_id", musicData.id);
            aqVar.an("obj_locate", i + 1);
            aqVar.an("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nEU.Ki(i);
                    bfG();
                    this.nCf.replay();
                    return;
                case 2:
                    this.nFa = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gA(String str, String str2) {
        this.nFd = false;
        this.nFb = this.nFa;
        this.nFe = str2;
        bY(str, this.nFa);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nFe = musicData.id;
            this.nCf.dQl();
            String Tl = com.baidu.tieba.video.editvideo.model.a.dQB().Tl(musicData.resource);
            if (TextUtils.isEmpty(Tl)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nBI.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dQB().a(musicData.id, musicData.resource, new a.InterfaceC0883a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void gx(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nBI.setVisibility(4);
                            e.this.bY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void Tf(String str) {
                            aVar.nBI.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.noi != null) {
                                e.this.noi.bG(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void dPV() {
                            aVar.nBI.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dQB().a(musicData.id, musicData.resource, new a.InterfaceC0883a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void gx(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void Tf(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.noi != null) {
                            e.this.noi.bG(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void dPV() {
                    }
                });
                return;
            }
            bY(Tl, i);
        }
    }

    public void replay() {
        this.nFd = false;
        if (this.nBz != null && this.nBz.isPlaying()) {
            this.nBz.pause();
        }
        if (this.nBz != null) {
            this.nBz.start();
            this.nBz.seekTo(0);
        }
    }

    public void gB(String str, String str2) {
        this.nFg = str;
        this.nFh = str2;
        dRf();
    }

    private void dRf() {
        if (!at.isEmpty(this.nFh) && !at.isEmpty(this.nFg)) {
            List<MusicData> data = this.nEU.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nFh)) {
                            i = i2 + 1;
                        } else {
                            Kl(i2);
                            return;
                        }
                    } else {
                        Kl(1);
                        return;
                    }
                }
            }
        }
    }

    private void Kl(final int i) {
        if (!at.isEmpty(this.nFg)) {
            this.nFc = i;
            if (this.nBz == null) {
                this.nBz = new MediaPlayer();
                this.nBz.setAudioStreamType(3);
            }
            try {
                this.nFe = this.nFh;
                this.nEZ = this.nFg;
                this.nBz.reset();
                this.nBz.setDataSource(this.nFg);
                this.nBz.prepare();
                this.nBz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nEU.Ki(i);
                        e.this.nBz.setLooping(true);
                    }
                });
                this.nBz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.noi != null) {
                            e.this.noi.bG(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(this.nEZ, i);
                if (this.noi != null) {
                    this.noi.bG(208, com.baidu.tieba.l.a.p(e));
                }
            } finally {
                this.nFh = null;
                this.nFg = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(String str, final int i) {
        this.nFc = i;
        if (this.nFb == this.nFc && !this.nFd) {
            if (this.nBz == null) {
                this.nBz = new MediaPlayer();
                this.nBz.setAudioStreamType(3);
            }
            try {
                this.nEZ = str;
                this.nBz.reset();
                this.nBz.setDataSource(str);
                this.nBz.prepare();
                this.nBz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nEU.Ki(i);
                        e.this.nBz.setLooping(true);
                        e.this.nBz.start();
                        e.this.nCf.replay();
                    }
                });
                this.nBz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.noi != null) {
                            e.this.noi.bG(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(str, i);
                if (this.noi != null) {
                    this.noi.bG(208, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    private void bZ(String str, int i) {
        this.nEZ = null;
        bfG();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dQB().dQC();
        }
        a(i, this.nEQ.getChildCount() > i ? this.nEQ.getChildAt(i) : null, (MusicData) this.nEU.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nEU.setData(list);
        if (this.nEU != null) {
            this.nFc = this.nEU.dQm();
            this.nFb = this.nFc;
        }
        dRf();
    }

    public String dQY() {
        return this.nEZ;
    }

    public String dQZ() {
        return this.nFe;
    }

    public void eo(View view) {
        this.nEV = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nEW = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nEX = (TextView) view.findViewById(R.id.video_voice_text);
        this.nEV.setVisibility(8);
        this.nEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yH(!e.this.nEY);
                e.this.nCf.setMute(!e.this.nEY);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.an("obj_type", e.this.nEY ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        yH(this.nEY);
        this.nCf.setMute(!this.nEY);
    }

    public void yH(boolean z) {
        this.nEY = z;
        if (this.nEY) {
            this.nEW.setSelected(false);
            this.nEX.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nEW.setSelected(true);
        this.nEX.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yF(boolean z) {
        if (z) {
            this.nEV.setVisibility(0);
            if (this.nFf && this.nBz == null && !TextUtils.isEmpty(this.nEZ)) {
                bY(this.nEZ, this.nFc);
                this.nFf = false;
                if (this.nFc > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nEQ.setSelection(e.this.nFc);
                            e.this.nEQ.scrollTo(e.this.nFb * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nEV.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nFd = true;
        if (this.nBz != null && this.nBz.isPlaying()) {
            this.nBz.pause();
        }
    }

    public void onResume() {
        this.nFd = false;
        if (this.nBz != null && this.nCf.mCurrentTabIndex == 2) {
            this.nBz.start();
            this.nBz.seekTo(0);
        }
    }

    private void bfG() {
        if (this.nBz != null) {
            if (this.nBz.isPlaying()) {
                this.nBz.stop();
            }
            this.nBz.release();
            this.nBz = null;
        }
        this.nEZ = null;
        this.nFe = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nFf = true;
            this.nFe = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nEZ = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nEU != null) {
                this.nEU.Tj(this.nFe);
                this.nFc = this.nEU.dQm();
                this.nFa = this.nFc;
                this.nFb = this.nFc;
            }
        }
    }
}
