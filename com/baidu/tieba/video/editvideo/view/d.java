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
    private h hca;
    private a hpH;
    private MediaPlayer hpa;
    private HorizontalListView hsC;
    private com.baidu.tieba.video.editvideo.a.c hsG;
    private LinearLayout hsH;
    private ImageView hsI;
    private TextView hsJ;
    private boolean hsK;
    private String hsL;
    private int hsM;
    private int hsN;
    private int hsO;
    private boolean hsP;
    private String hsQ;
    private boolean hsR;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hsK = true;
        this.hsM = 1;
        this.hpH = aVar;
        this.hca = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hsC = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hsG = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hsC.setAdapter((ListAdapter) this.hsG);
        this.hsC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hsG.bBq() != i || i == d.this.hsM) {
                    d.this.hsN = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public boolean bCh() {
        return this.hpa != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hsG.getItem(i);
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
                    this.hsG.wL(i);
                    blr();
                    this.hpH.replay();
                    return;
                case 2:
                    this.hsM = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.hsP = false;
        this.hsN = this.hsM;
        this.hsQ = str2;
        aM(str, this.hsM);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hsQ = musicData.id;
            this.hpH.bBp();
            String tN = com.baidu.tieba.video.editvideo.model.a.bBI().tN(musicData.resource);
            if (TextUtils.isEmpty(tN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hpk.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBI().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hpk.setVisibility(4);
                            d.this.aM(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void tE(String str) {
                            aVar.hpk.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hca != null) {
                                d.this.hca.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bAW() {
                            aVar.hpk.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBI().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
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
                        if (d.this.hca != null) {
                            d.this.hca.W(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bAW() {
                    }
                });
                return;
            }
            aM(tN, i);
        }
    }

    public void replay() {
        this.hsP = false;
        if (this.hpa != null && this.hpa.isPlaying()) {
            this.hpa.pause();
        }
        if (this.hpa != null) {
            this.hpa.start();
            this.hpa.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, final int i) {
        this.hsO = i;
        if (this.hsN == this.hsO && !this.hsP) {
            if (this.hpa == null) {
                this.hpa = new MediaPlayer();
                this.hpa.setAudioStreamType(3);
            }
            try {
                this.hsL = str;
                this.hpa.reset();
                this.hpa.setDataSource(str);
                this.hpa.prepare();
                this.hpa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hsG.wL(i);
                        d.this.hpa.setLooping(true);
                        d.this.hpa.start();
                        d.this.hpH.replay();
                    }
                });
                this.hpa.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hca != null) {
                            d.this.hca.W(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aN(str, i);
                if (this.hca != null) {
                    this.hca.W(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aN(String str, int i) {
        this.hsL = null;
        blr();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBI().bBJ();
        }
        a(i, this.hsC.getChildCount() > i ? this.hsC.getChildAt(i) : null, (MusicData) this.hsG.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hsG.setData(list);
        if (this.hsG != null) {
            this.hsO = this.hsG.bBq();
            this.hsN = this.hsO;
        }
    }

    public String bCf() {
        return this.hsL;
    }

    public String bCg() {
        return this.hsQ;
    }

    public void cS(View view) {
        this.hsH = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hsI = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hsJ = (TextView) view.findViewById(d.g.video_voice_text);
        this.hsH.setVisibility(8);
        this.hsH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hsK = !d.this.hsK;
                if (d.this.hsK) {
                    d.this.hsI.setSelected(false);
                    d.this.hsJ.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hsI.setSelected(true);
                    d.this.hsJ.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hpH.setMute(!d.this.hsK);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hsK ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hsK) {
            this.hsI.setSelected(false);
            this.hsJ.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hsI.setSelected(true);
        this.hsJ.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nq(boolean z) {
        if (z) {
            this.hsH.setVisibility(0);
            if (this.hsR && this.hpa == null && !TextUtils.isEmpty(this.hsL)) {
                aM(this.hsL, this.hsO);
                this.hsR = false;
                if (this.hsO > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hsC.setSelection(d.this.hsO);
                            d.this.hsC.gg(d.this.hsN * l.t(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hsH.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hsP = true;
        if (this.hpa != null && this.hpa.isPlaying()) {
            this.hpa.pause();
        }
    }

    public void onResume() {
        this.hsP = false;
        if (this.hpa != null && this.hpH.mCurrentTabIndex == 2) {
            this.hpa.start();
            this.hpa.seekTo(0);
        }
    }

    private void blr() {
        if (this.hpa != null) {
            if (this.hpa.isPlaying()) {
                this.hpa.stop();
            }
            this.hpa.release();
            this.hpa = null;
        }
        this.hsL = null;
        this.hsQ = null;
    }

    public void ab(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hsR = true;
            this.hsQ = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hsL = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hsG != null) {
                this.hsG.tK(this.hsQ);
                this.hsO = this.hsG.bBq();
                this.hsM = this.hsO;
                this.hsN = this.hsO;
            }
        }
    }
}
