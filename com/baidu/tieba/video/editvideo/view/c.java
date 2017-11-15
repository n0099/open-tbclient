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
    private Resources fOt;
    private a gEN;
    private MediaPlayer gEg;
    private HorizontalListView gGS;
    private com.baidu.tieba.video.editvideo.a.b gGT;
    private LinearLayout gGU;
    private ImageView gGV;
    private TextView gGW;
    private boolean gGX;
    private String gGY;
    private int gGZ;
    private int gHa;
    private int gHb;
    private boolean gHc;
    private String gHd;
    private boolean gHe;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gGX = true;
        this.gGZ = 1;
        this.gEN = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.fOt = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gGS = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gGT = new com.baidu.tieba.video.editvideo.a.b(this.mContext);
        this.gGS.setAdapter((ListAdapter) this.gGT);
        this.gGS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.gGT.bza() != i || i == c.this.gGZ) {
                    c.this.gHa = i;
                    c.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
    }

    public boolean bzz() {
        return this.gEg != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.gGT.getItem(i);
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
                    this.gGT.uR(i);
                    bhy();
                    this.gEN.bzt();
                    return;
                case 2:
                    this.gGZ = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.gHc = false;
        this.gHa = this.gGZ;
        this.gHd = str2;
        aH(str, this.gGZ);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gHd = musicData.id;
            this.gEN.byY();
            String tp = com.baidu.tieba.video.editvideo.model.a.bzc().tp(musicData.resource);
            if (TextUtils.isEmpty(tp)) {
                if (view != null) {
                    final b.a aVar = (b.a) view.getTag();
                    aVar.gEq.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bzc().a(musicData.id, musicData.resource, new a.InterfaceC0134a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gEq.setVisibility(4);
                            c.this.aH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void tl(String str) {
                            aVar.gEq.setVisibility(4);
                            l.showToast(c.this.mContext.getPageActivity(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                        public void byC() {
                            aVar.gEq.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bzc().a(musicData.id, musicData.resource, new a.InterfaceC0134a() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        c.this.aH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void tl(String str) {
                        l.showToast(c.this.mContext.getPageActivity(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0134a
                    public void byC() {
                    }
                });
                return;
            }
            aH(tp, i);
        }
    }

    public void bzt() {
        this.gHc = false;
        if (this.gEg != null && this.gEg.isPlaying()) {
            this.gEg.pause();
        }
        if (this.gEg != null) {
            this.gEg.start();
            this.gEg.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, final int i) {
        this.gHb = i;
        if (this.gHa == this.gHb && !this.gHc) {
            if (this.gEg == null) {
                this.gEg = new MediaPlayer();
                this.gEg.setAudioStreamType(3);
            }
            try {
                this.gGY = str;
                this.gEg.reset();
                this.gEg.setDataSource(str);
                this.gEg.prepare();
                this.gEg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.c.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.gGT.uR(i);
                        c.this.gEg.setLooping(true);
                        c.this.gEg.start();
                        c.this.gEN.bzt();
                    }
                });
                this.gEg.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.c.5
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
        this.gGY = null;
        bhy();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bzc().bzd();
        }
        a(i, this.gGS.getChildCount() > i ? this.gGS.getChildAt(i) : null, (MusicData) this.gGT.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gGT.setData(list);
        if (this.gGT != null) {
            this.gHb = this.gGT.bza();
            this.gHa = this.gHb;
        }
    }

    public String bzx() {
        return this.gGY;
    }

    public String bzy() {
        return this.gHd;
    }

    public void bM(View view) {
        this.gGU = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.gGV = (ImageView) view.findViewById(d.g.video_voice_img);
        this.gGW = (TextView) view.findViewById(d.g.video_voice_text);
        this.gGU.setVisibility(8);
        this.gGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.gGX = !c.this.gGX;
                if (c.this.gGX) {
                    c.this.gGV.setSelected(false);
                    c.this.gGW.setText(c.this.fOt.getString(d.j.video_voice_open));
                } else {
                    c.this.gGV.setSelected(true);
                    c.this.gGW.setText(c.this.fOt.getString(d.j.video_voice_close));
                }
                c.this.gEN.setMute(!c.this.gGX);
                c.this.bzt();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", c.this.gGX ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gGX) {
            this.gGV.setSelected(false);
            this.gGW.setText(this.fOt.getString(d.j.video_voice_open));
            return;
        }
        this.gGV.setSelected(true);
        this.gGW.setText(this.fOt.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ne(boolean z) {
        if (z) {
            this.gGU.setVisibility(0);
            if (this.gHe && this.gEg == null && !TextUtils.isEmpty(this.gGY)) {
                aH(this.gGY, this.gHb);
                this.gHe = false;
                if (this.gHb > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.7
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.gGS.setSelection(c.this.gHb);
                            c.this.gGS.dg(c.this.gHa * l.f(c.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            bzt();
            return;
        }
        this.gGU.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gHc = true;
        if (this.gEg != null && this.gEg.isPlaying()) {
            this.gEg.pause();
        }
    }

    public void onResume() {
        this.gHc = false;
        if (this.gEg != null && this.gEN.mCurrentTabIndex == 1) {
            this.gEg.start();
            this.gEg.seekTo(0);
        }
    }

    private void bhy() {
        if (this.gEg != null) {
            if (this.gEg.isPlaying()) {
                this.gEg.stop();
            }
            this.gEg.release();
            this.gEg = null;
        }
        this.gGY = null;
        this.gHd = null;
    }

    public void Z(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gHe = true;
            this.gHd = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gGY = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gGT != null) {
                this.gGT.to(this.gHd);
                this.gHb = this.gGT.bza();
                this.gGZ = this.gHb;
                this.gHa = this.gHb;
            }
        }
    }
}
