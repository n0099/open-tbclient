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
    private h hbC;
    private MediaPlayer hoC;
    private a hpj;
    private HorizontalListView hsd;
    private com.baidu.tieba.video.editvideo.a.c hsh;
    private LinearLayout hsi;
    private ImageView hsj;
    private TextView hsk;
    private boolean hsl;
    private String hsm;
    private int hsn;
    private int hso;
    private int hsp;
    private boolean hsq;
    private String hsr;
    private boolean hss;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hsl = true;
        this.hsn = 1;
        this.hpj = aVar;
        this.hbC = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hsd = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hsh = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hsd.setAdapter((ListAdapter) this.hsh);
        this.hsd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hsh.bBl() != i || i == d.this.hsn) {
                    d.this.hso = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public boolean bCc() {
        return this.hoC != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hsh.getItem(i);
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
                    this.hsh.wL(i);
                    blq();
                    this.hpj.replay();
                    return;
                case 2:
                    this.hsn = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.hsq = false;
        this.hso = this.hsn;
        this.hsr = str2;
        aM(str, this.hsn);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hsr = musicData.id;
            this.hpj.bBk();
            String tN = com.baidu.tieba.video.editvideo.model.a.bBD().tN(musicData.resource);
            if (TextUtils.isEmpty(tN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hoM.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBD().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hoM.setVisibility(4);
                            d.this.aM(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void tE(String str) {
                            aVar.hoM.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hbC != null) {
                                d.this.hbC.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAR() {
                            aVar.hoM.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBD().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aM(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void tE(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hbC != null) {
                            d.this.hbC.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAR() {
                    }
                });
                return;
            }
            aM(tN, i);
        }
    }

    public void replay() {
        this.hsq = false;
        if (this.hoC != null && this.hoC.isPlaying()) {
            this.hoC.pause();
        }
        if (this.hoC != null) {
            this.hoC.start();
            this.hoC.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, final int i) {
        this.hsp = i;
        if (this.hso == this.hsp && !this.hsq) {
            if (this.hoC == null) {
                this.hoC = new MediaPlayer();
                this.hoC.setAudioStreamType(3);
            }
            try {
                this.hsm = str;
                this.hoC.reset();
                this.hoC.setDataSource(str);
                this.hoC.prepare();
                this.hoC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hsh.wL(i);
                        d.this.hoC.setLooping(true);
                        d.this.hoC.start();
                        d.this.hpj.replay();
                    }
                });
                this.hoC.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hbC != null) {
                            d.this.hbC.W(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aN(str, i);
                if (this.hbC != null) {
                    this.hbC.W(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aN(String str, int i) {
        this.hsm = null;
        blq();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBD().bBE();
        }
        a(i, this.hsd.getChildCount() > i ? this.hsd.getChildAt(i) : null, (MusicData) this.hsh.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hsh.setData(list);
        if (this.hsh != null) {
            this.hsp = this.hsh.bBl();
            this.hso = this.hsp;
        }
    }

    public String bCa() {
        return this.hsm;
    }

    public String bCb() {
        return this.hsr;
    }

    public void cS(View view) {
        this.hsi = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hsj = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hsk = (TextView) view.findViewById(d.g.video_voice_text);
        this.hsi.setVisibility(8);
        this.hsi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hsl = !d.this.hsl;
                if (d.this.hsl) {
                    d.this.hsj.setSelected(false);
                    d.this.hsk.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hsj.setSelected(true);
                    d.this.hsk.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hpj.setMute(!d.this.hsl);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hsl ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hsl) {
            this.hsj.setSelected(false);
            this.hsk.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hsj.setSelected(true);
        this.hsk.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nl(boolean z) {
        if (z) {
            this.hsi.setVisibility(0);
            if (this.hss && this.hoC == null && !TextUtils.isEmpty(this.hsm)) {
                aM(this.hsm, this.hsp);
                this.hss = false;
                if (this.hsp > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hsd.setSelection(d.this.hsp);
                            d.this.hsd.gg(d.this.hso * l.t(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hsi.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hsq = true;
        if (this.hoC != null && this.hoC.isPlaying()) {
            this.hoC.pause();
        }
    }

    public void onResume() {
        this.hsq = false;
        if (this.hoC != null && this.hpj.mCurrentTabIndex == 2) {
            this.hoC.start();
            this.hoC.seekTo(0);
        }
    }

    private void blq() {
        if (this.hoC != null) {
            if (this.hoC.isPlaying()) {
                this.hoC.stop();
            }
            this.hoC.release();
            this.hoC = null;
        }
        this.hsm = null;
        this.hsr = null;
    }

    public void ab(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hss = true;
            this.hsr = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hsm = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hsh != null) {
                this.hsh.tK(this.hsr);
                this.hsp = this.hsh.bBl();
                this.hsn = this.hsp;
                this.hso = this.hsp;
            }
        }
    }
}
