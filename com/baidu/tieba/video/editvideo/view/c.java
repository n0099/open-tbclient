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
import com.baidu.tieba.video.editvideo.a.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private Resources fNu;
    private MediaPlayer gCY;
    private a gDF;
    private HorizontalListView gFK;
    private com.baidu.tieba.video.editvideo.a.b gFL;
    private LinearLayout gFM;
    private ImageView gFN;
    private TextView gFO;
    private boolean gFP;
    private String gFQ;
    private int gFR;
    private int gFS;
    private int gFT;
    private boolean gFU;
    private String gFV;
    private boolean gFW;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gFP = true;
        this.gFR = 1;
        this.gDF = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.fNu = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gFK = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gFL = new com.baidu.tieba.video.editvideo.a.b(this.mContext);
        this.gFK.setAdapter((ListAdapter) this.gFL);
        this.gFK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.gFL.byO() != i || i == c.this.gFR) {
                    c.this.gFS = i;
                    c.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
    }

    public boolean bzn() {
        return this.gCY != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.gFL.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ac("obj_id", musicData.id);
            akVar.r("obj_locate", i + 1);
            akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.gFL.uN(i);
                    bhq();
                    this.gDF.bzh();
                    return;
                case 2:
                    this.gFR = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cg(String str, String str2) {
        this.gFU = false;
        this.gFS = this.gFR;
        this.gFV = str2;
        aH(str, this.gFR);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gFV = musicData.id;
            this.gDF.byM();
            String tj = com.baidu.tieba.video.editvideo.model.a.byQ().tj(musicData.resource);
            if (TextUtils.isEmpty(tj)) {
                if (view != null) {
                    final b.a aVar = (b.a) view.getTag();
                    aVar.gDi.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.byQ().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void cf(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gDi.setVisibility(4);
                            c.this.aH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void tf(String str) {
                            aVar.gDi.setVisibility(4);
                            l.showToast(c.this.mContext.getPageActivity(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void byq() {
                            aVar.gDi.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.byQ().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cf(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        c.this.aH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void tf(String str) {
                        l.showToast(c.this.mContext.getPageActivity(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void byq() {
                    }
                });
                return;
            }
            aH(tj, i);
        }
    }

    public void bzh() {
        this.gFU = false;
        if (this.gCY != null && this.gCY.isPlaying()) {
            this.gCY.pause();
        }
        if (this.gCY != null) {
            this.gCY.start();
            this.gCY.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, final int i) {
        this.gFT = i;
        if (this.gFS == this.gFT && !this.gFU) {
            if (this.gCY == null) {
                this.gCY = new MediaPlayer();
                this.gCY.setAudioStreamType(3);
            }
            try {
                this.gFQ = str;
                this.gCY.reset();
                this.gCY.setDataSource(str);
                this.gCY.prepare();
                this.gCY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.c.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.gFL.uN(i);
                        c.this.gCY.setLooping(true);
                        c.this.gCY.start();
                        c.this.gDF.bzh();
                    }
                });
                this.gCY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.c.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aI(str, i);
            }
        }
    }

    private void aI(String str, int i) {
        this.gFQ = null;
        bhq();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.byQ().byR();
        }
        a(i, this.gFK.getChildCount() > i ? this.gFK.getChildAt(i) : null, (MusicData) this.gFL.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gFL.setData(list);
        if (this.gFL != null) {
            this.gFT = this.gFL.byO();
            this.gFS = this.gFT;
        }
    }

    public String bzl() {
        return this.gFQ;
    }

    public String bzm() {
        return this.gFV;
    }

    public void bL(View view) {
        this.gFM = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.gFN = (ImageView) view.findViewById(d.g.video_voice_img);
        this.gFO = (TextView) view.findViewById(d.g.video_voice_text);
        this.gFM.setVisibility(8);
        this.gFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.gFP = !c.this.gFP;
                if (c.this.gFP) {
                    c.this.gFN.setSelected(false);
                    c.this.gFO.setText(c.this.fNu.getString(d.j.video_voice_open));
                } else {
                    c.this.gFN.setSelected(true);
                    c.this.gFO.setText(c.this.fNu.getString(d.j.video_voice_close));
                }
                c.this.gDF.setMute(!c.this.gFP);
                c.this.bzh();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", c.this.gFP ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gFP) {
            this.gFN.setSelected(false);
            this.gFO.setText(this.fNu.getString(d.j.video_voice_open));
            return;
        }
        this.gFN.setSelected(true);
        this.gFO.setText(this.fNu.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mW(boolean z) {
        if (z) {
            this.gFM.setVisibility(0);
            if (this.gFW && this.gCY == null && !TextUtils.isEmpty(this.gFQ)) {
                aH(this.gFQ, this.gFT);
                this.gFW = false;
                if (this.gFT > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.7
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.gFK.setSelection(c.this.gFT);
                            c.this.gFK.dh(c.this.gFS * l.f(c.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            bzh();
            return;
        }
        this.gFM.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gFU = true;
        if (this.gCY != null && this.gCY.isPlaying()) {
            this.gCY.pause();
        }
    }

    public void onResume() {
        this.gFU = false;
        if (this.gCY != null && this.gDF.mCurrentTabIndex == 1) {
            this.gCY.start();
            this.gCY.seekTo(0);
        }
    }

    private void bhq() {
        if (this.gCY != null) {
            if (this.gCY.isPlaying()) {
                this.gCY.stop();
            }
            this.gCY.release();
            this.gCY = null;
        }
        this.gFQ = null;
        this.gFV = null;
    }

    public void Z(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gFW = true;
            this.gFV = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gFQ = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gFL != null) {
                this.gFL.ti(this.gFV);
                this.gFT = this.gFL.byO();
                this.gFR = this.gFT;
                this.gFS = this.gFT;
            }
        }
    }
}
