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
    private MediaPlayer nBy;
    private a nCe;
    private HorizontalListView nEP;
    private com.baidu.tieba.video.editvideo.a.c nET;
    private LinearLayout nEU;
    private ImageView nEV;
    private TextView nEW;
    private boolean nEX;
    private String nEY;
    private int nEZ;
    private int nFa;
    private int nFb;
    private boolean nFc;
    private String nFd;
    private boolean nFe;
    private String nFf;
    private String nFg;
    private g noh;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nEX = true;
        this.nEZ = 1;
        this.nCe = aVar;
        this.noh = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nEP = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nET = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nEP.setAdapter((ListAdapter) this.nET);
        this.nEP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nET.dQm() != i || i == e.this.nEZ) {
                    e.this.nFa = i;
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
        MusicData musicData = (MusicData) this.nET.getItem(i);
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
                    this.nET.Ki(i);
                    bfG();
                    this.nCe.replay();
                    return;
                case 2:
                    this.nEZ = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gA(String str, String str2) {
        this.nFc = false;
        this.nFa = this.nEZ;
        this.nFd = str2;
        bX(str, this.nEZ);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nFd = musicData.id;
            this.nCe.dQl();
            String Tk = com.baidu.tieba.video.editvideo.model.a.dQB().Tk(musicData.resource);
            if (TextUtils.isEmpty(Tk)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nBH.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dQB().a(musicData.id, musicData.resource, new a.InterfaceC0883a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void gx(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nBH.setVisibility(4);
                            e.this.bX(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void Te(String str) {
                            aVar.nBH.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.noh != null) {
                                e.this.noh.bG(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                        public void dPV() {
                            aVar.nBH.setVisibility(4);
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
                        e.this.bX(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void Te(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.noh != null) {
                            e.this.noh.bG(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0883a
                    public void dPV() {
                    }
                });
                return;
            }
            bX(Tk, i);
        }
    }

    public void replay() {
        this.nFc = false;
        if (this.nBy != null && this.nBy.isPlaying()) {
            this.nBy.pause();
        }
        if (this.nBy != null) {
            this.nBy.start();
            this.nBy.seekTo(0);
        }
    }

    public void gB(String str, String str2) {
        this.nFf = str;
        this.nFg = str2;
        dRf();
    }

    private void dRf() {
        if (!at.isEmpty(this.nFg) && !at.isEmpty(this.nFf)) {
            List<MusicData> data = this.nET.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nFg)) {
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
        if (!at.isEmpty(this.nFf)) {
            this.nFb = i;
            if (this.nBy == null) {
                this.nBy = new MediaPlayer();
                this.nBy.setAudioStreamType(3);
            }
            try {
                this.nFd = this.nFg;
                this.nEY = this.nFf;
                this.nBy.reset();
                this.nBy.setDataSource(this.nFf);
                this.nBy.prepare();
                this.nBy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nET.Ki(i);
                        e.this.nBy.setLooping(true);
                    }
                });
                this.nBy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.noh != null) {
                            e.this.noh.bG(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(this.nEY, i);
                if (this.noh != null) {
                    this.noh.bG(208, com.baidu.tieba.l.a.p(e));
                }
            } finally {
                this.nFg = null;
                this.nFf = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(String str, final int i) {
        this.nFb = i;
        if (this.nFa == this.nFb && !this.nFc) {
            if (this.nBy == null) {
                this.nBy = new MediaPlayer();
                this.nBy.setAudioStreamType(3);
            }
            try {
                this.nEY = str;
                this.nBy.reset();
                this.nBy.setDataSource(str);
                this.nBy.prepare();
                this.nBy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nET.Ki(i);
                        e.this.nBy.setLooping(true);
                        e.this.nBy.start();
                        e.this.nCe.replay();
                    }
                });
                this.nBy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.noh != null) {
                            e.this.noh.bG(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bY(str, i);
                if (this.noh != null) {
                    this.noh.bG(208, com.baidu.tieba.l.a.p(e));
                }
            }
        }
    }

    private void bY(String str, int i) {
        this.nEY = null;
        bfG();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dQB().dQC();
        }
        a(i, this.nEP.getChildCount() > i ? this.nEP.getChildAt(i) : null, (MusicData) this.nET.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nET.setData(list);
        if (this.nET != null) {
            this.nFb = this.nET.dQm();
            this.nFa = this.nFb;
        }
        dRf();
    }

    public String dQY() {
        return this.nEY;
    }

    public String dQZ() {
        return this.nFd;
    }

    public void eo(View view) {
        this.nEU = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nEV = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nEW = (TextView) view.findViewById(R.id.video_voice_text);
        this.nEU.setVisibility(8);
        this.nEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yH(!e.this.nEX);
                e.this.nCe.setMute(!e.this.nEX);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.an("obj_type", e.this.nEX ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        yH(this.nEX);
        this.nCe.setMute(!this.nEX);
    }

    public void yH(boolean z) {
        this.nEX = z;
        if (this.nEX) {
            this.nEV.setSelected(false);
            this.nEW.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nEV.setSelected(true);
        this.nEW.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yF(boolean z) {
        if (z) {
            this.nEU.setVisibility(0);
            if (this.nFe && this.nBy == null && !TextUtils.isEmpty(this.nEY)) {
                bX(this.nEY, this.nFb);
                this.nFe = false;
                if (this.nFb > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nEP.setSelection(e.this.nFb);
                            e.this.nEP.scrollTo(e.this.nFa * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nEU.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nFc = true;
        if (this.nBy != null && this.nBy.isPlaying()) {
            this.nBy.pause();
        }
    }

    public void onResume() {
        this.nFc = false;
        if (this.nBy != null && this.nCe.mCurrentTabIndex == 2) {
            this.nBy.start();
            this.nBy.seekTo(0);
        }
    }

    private void bfG() {
        if (this.nBy != null) {
            if (this.nBy.isPlaying()) {
                this.nBy.stop();
            }
            this.nBy.release();
            this.nBy = null;
        }
        this.nEY = null;
        this.nFd = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nFe = true;
            this.nFd = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nEY = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nET != null) {
                this.nET.Ti(this.nFd);
                this.nFb = this.nET.dQm();
                this.nEZ = this.nFb;
                this.nFa = this.nFb;
            }
        }
    }
}
