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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private g nAz;
    private MediaPlayer nNO;
    private a nOu;
    private HorizontalListView nRf;
    private com.baidu.tieba.video.editvideo.a.c nRj;
    private LinearLayout nRk;
    private ImageView nRl;
    private TextView nRm;
    private boolean nRn;
    private String nRo;
    private int nRp;
    private int nRq;
    private int nRr;
    private boolean nRs;
    private String nRt;
    private boolean nRu;
    private String nRv;
    private String nRw;

    public e(f fVar, a aVar, g gVar) {
        super(fVar);
        this.nRn = true;
        this.nRp = 1;
        this.nOu = aVar;
        this.nAz = gVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nRf = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nRj = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nRf.setAdapter((ListAdapter) this.nRj);
        this.nRf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nRj.dSN() != i || i == e.this.nRp) {
                    e.this.nRq = i;
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
        MusicData musicData = (MusicData) this.nRj.getItem(i);
        if (musicData != null) {
            ar arVar = new ar("c12423");
            arVar.dR("obj_id", musicData.id);
            arVar.aq("obj_locate", i + 1);
            arVar.aq("obj_source", 2);
            TiebaStatic.log(arVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nRj.KH(i);
                    bfV();
                    this.nOu.replay();
                    return;
                case 2:
                    this.nRp = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gI(String str, String str2) {
        this.nRs = false;
        this.nRq = this.nRp;
        this.nRt = str2;
        bY(str, this.nRp);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nRt = musicData.id;
            this.nOu.dSM();
            String UB = com.baidu.tieba.video.editvideo.model.a.dTc().UB(musicData.resource);
            if (TextUtils.isEmpty(UB)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.nNX.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dTc().a(musicData.id, musicData.resource, new a.InterfaceC0894a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                        public void gF(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.nNX.setVisibility(4);
                            e.this.bY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                        public void Uv(String str) {
                            aVar.nNX.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.nAz != null) {
                                e.this.nAz.bM(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                        public void dSw() {
                            aVar.nNX.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dTc().a(musicData.id, musicData.resource, new a.InterfaceC0894a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void gF(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void Uv(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.nAz != null) {
                            e.this.nAz.bM(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0894a
                    public void dSw() {
                    }
                });
                return;
            }
            bY(UB, i);
        }
    }

    public void replay() {
        this.nRs = false;
        if (this.nNO != null && this.nNO.isPlaying()) {
            this.nNO.pause();
        }
        if (this.nNO != null) {
            this.nNO.start();
            this.nNO.seekTo(0);
        }
    }

    public void gJ(String str, String str2) {
        this.nRv = str;
        this.nRw = str2;
        dTG();
    }

    private void dTG() {
        if (!au.isEmpty(this.nRw) && !au.isEmpty(this.nRv)) {
            List<MusicData> data = this.nRj.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !au.equals(data.get(i2).id, this.nRw)) {
                            i = i2 + 1;
                        } else {
                            KK(i2);
                            return;
                        }
                    } else {
                        KK(1);
                        return;
                    }
                }
            }
        }
    }

    private void KK(final int i) {
        if (!au.isEmpty(this.nRv)) {
            this.nRr = i;
            if (this.nNO == null) {
                this.nNO = new MediaPlayer();
                this.nNO.setAudioStreamType(3);
            }
            try {
                this.nRt = this.nRw;
                this.nRo = this.nRv;
                this.nNO.reset();
                this.nNO.setDataSource(this.nRv);
                this.nNO.prepare();
                this.nNO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nRj.KH(i);
                        e.this.nNO.setLooping(true);
                    }
                });
                this.nNO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nAz != null) {
                            e.this.nAz.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(this.nRo, i);
                if (this.nAz != null) {
                    this.nAz.bM(208, com.baidu.tieba.l.a.o(e));
                }
            } finally {
                this.nRw = null;
                this.nRv = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(String str, final int i) {
        this.nRr = i;
        if (this.nRq == this.nRr && !this.nRs) {
            if (this.nNO == null) {
                this.nNO = new MediaPlayer();
                this.nNO.setAudioStreamType(3);
            }
            try {
                this.nRo = str;
                this.nNO.reset();
                this.nNO.setDataSource(str);
                this.nNO.prepare();
                this.nNO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nRj.KH(i);
                        e.this.nNO.setLooping(true);
                        e.this.nNO.start();
                        e.this.nOu.replay();
                    }
                });
                this.nNO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.nAz != null) {
                            e.this.nAz.bM(207, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bZ(str, i);
                if (this.nAz != null) {
                    this.nAz.bM(208, com.baidu.tieba.l.a.o(e));
                }
            }
        }
    }

    private void bZ(String str, int i) {
        this.nRo = null;
        bfV();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dTc().dTd();
        }
        a(i, this.nRf.getChildCount() > i ? this.nRf.getChildAt(i) : null, (MusicData) this.nRj.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nRj.setData(list);
        if (this.nRj != null) {
            this.nRr = this.nRj.dSN();
            this.nRq = this.nRr;
        }
        dTG();
    }

    public String dTz() {
        return this.nRo;
    }

    public String dTA() {
        return this.nRt;
    }

    public void em(View view) {
        this.nRk = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nRl = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nRm = (TextView) view.findViewById(R.id.video_voice_text);
        this.nRk.setVisibility(8);
        this.nRk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.yZ(!e.this.nRn);
                e.this.nOu.setMute(!e.this.nRn);
                e.this.replay();
                ar arVar = new ar("c12423");
                arVar.aq("obj_type", e.this.nRn ? 0 : 1);
                TiebaStatic.log(arVar);
            }
        });
        yZ(this.nRn);
        this.nOu.setMute(!this.nRn);
    }

    public void yZ(boolean z) {
        this.nRn = z;
        if (this.nRn) {
            this.nRl.setSelected(false);
            this.nRm.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nRl.setSelected(true);
        this.nRm.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yX(boolean z) {
        if (z) {
            this.nRk.setVisibility(0);
            if (this.nRu && this.nNO == null && !TextUtils.isEmpty(this.nRo)) {
                bY(this.nRo, this.nRr);
                this.nRu = false;
                if (this.nRr > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nRf.setSelection(e.this.nRr);
                            e.this.nRf.scrollTo(e.this.nRq * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nRk.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nRs = true;
        if (this.nNO != null && this.nNO.isPlaying()) {
            this.nNO.pause();
        }
    }

    public void onResume() {
        this.nRs = false;
        if (this.nNO != null && this.nOu.mCurrentTabIndex == 2) {
            this.nNO.start();
            this.nNO.seekTo(0);
        }
    }

    private void bfV() {
        if (this.nNO != null) {
            if (this.nNO.isPlaying()) {
                this.nNO.stop();
            }
            this.nNO.release();
            this.nNO = null;
        }
        this.nRo = null;
        this.nRt = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nRu = true;
            this.nRt = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nRo = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nRj != null) {
                this.nRj.Uz(this.nRt);
                this.nRr = this.nRj.dSN();
                this.nRp = this.nRr;
                this.nRq = this.nRr;
            }
        }
    }
}
