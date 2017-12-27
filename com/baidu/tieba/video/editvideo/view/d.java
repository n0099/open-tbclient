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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private HorizontalListView hBe;
    private com.baidu.tieba.video.editvideo.a.c hBi;
    private LinearLayout hBj;
    private ImageView hBk;
    private TextView hBl;
    private boolean hBm;
    private String hBn;
    private int hBo;
    private int hBp;
    private int hBq;
    private boolean hBr;
    private String hBs;
    private boolean hBt;
    private h hjJ;
    private MediaPlayer hxD;
    private a hyk;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hBm = true;
        this.hBo = 1;
        this.hyk = aVar;
        this.hjJ = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hBe = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hBi = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hBe.setAdapter((ListAdapter) this.hBi);
        this.hBe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hBi.bHd() != i || i == d.this.hBo) {
                    d.this.hBp = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
    }

    public boolean bHV() {
        return this.hxD != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hBi.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ab("obj_id", musicData.id);
            akVar.s("obj_locate", i + 1);
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hBi.yj(i);
                    bqK();
                    this.hyk.replay();
                    return;
                case 2:
                    this.hBo = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cp(String str, String str2) {
        this.hBr = false;
        this.hBp = this.hBo;
        this.hBs = str2;
        aJ(str, this.hBo);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hBs = musicData.id;
            this.hyk.bHc();
            String ug = com.baidu.tieba.video.editvideo.model.a.bHw().ug(musicData.resource);
            if (TextUtils.isEmpty(ug)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hxN.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bHw().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void co(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hxN.setVisibility(4);
                            d.this.aJ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void tX(String str) {
                            aVar.hxN.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hjJ != null) {
                                d.this.hjJ.R(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void bGJ() {
                            aVar.hxN.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bHw().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void co(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aJ(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tX(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hjJ != null) {
                            d.this.hjJ.R(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bGJ() {
                    }
                });
                return;
            }
            aJ(ug, i);
        }
    }

    public void replay() {
        this.hBr = false;
        if (this.hxD != null && this.hxD.isPlaying()) {
            this.hxD.pause();
        }
        if (this.hxD != null) {
            this.hxD.start();
            this.hxD.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, final int i) {
        this.hBq = i;
        if (this.hBp == this.hBq && !this.hBr) {
            if (this.hxD == null) {
                this.hxD = new MediaPlayer();
                this.hxD.setAudioStreamType(3);
            }
            try {
                this.hBn = str;
                this.hxD.reset();
                this.hxD.setDataSource(str);
                this.hxD.prepare();
                this.hxD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hBi.yj(i);
                        d.this.hxD.setLooping(true);
                        d.this.hxD.start();
                        d.this.hyk.replay();
                    }
                });
                this.hxD.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hjJ != null) {
                            d.this.hjJ.R(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aK(str, i);
                if (this.hjJ != null) {
                    this.hjJ.R(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aK(String str, int i) {
        this.hBn = null;
        bqK();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bHw().bHx();
        }
        a(i, this.hBe.getChildCount() > i ? this.hBe.getChildAt(i) : null, (MusicData) this.hBi.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hBi.setData(list);
        if (this.hBi != null) {
            this.hBq = this.hBi.bHd();
            this.hBp = this.hBq;
        }
    }

    public String bHT() {
        return this.hBn;
    }

    public String bHU() {
        return this.hBs;
    }

    public void cX(View view) {
        this.hBj = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hBk = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hBl = (TextView) view.findViewById(d.g.video_voice_text);
        this.hBj.setVisibility(8);
        this.hBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hBm = !d.this.hBm;
                if (d.this.hBm) {
                    d.this.hBk.setSelected(false);
                    d.this.hBl.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hBk.setSelected(true);
                    d.this.hBl.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hyk.setMute(!d.this.hBm);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hBm ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hBm) {
            this.hBk.setSelected(false);
            this.hBl.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hBk.setSelected(true);
        this.hBl.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nZ(boolean z) {
        if (z) {
            this.hBj.setVisibility(0);
            if (this.hBt && this.hxD == null && !TextUtils.isEmpty(this.hBn)) {
                aJ(this.hBn, this.hBq);
                this.hBt = false;
                if (this.hBq > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hBe.setSelection(d.this.hBq);
                            d.this.hBe.gg(d.this.hBp * l.s(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hBj.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hBr = true;
        if (this.hxD != null && this.hxD.isPlaying()) {
            this.hxD.pause();
        }
    }

    public void onResume() {
        this.hBr = false;
        if (this.hxD != null && this.hyk.mCurrentTabIndex == 2) {
            this.hxD.start();
            this.hxD.seekTo(0);
        }
    }

    private void bqK() {
        if (this.hxD != null) {
            if (this.hxD.isPlaying()) {
                this.hxD.stop();
            }
            this.hxD.release();
            this.hxD = null;
        }
        this.hBn = null;
        this.hBs = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hBt = true;
            this.hBs = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hBn = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hBi != null) {
                this.hBi.ud(this.hBs);
                this.hBq = this.hBi.bHd();
                this.hBo = this.hBq;
                this.hBp = this.hBq;
            }
        }
    }
}
