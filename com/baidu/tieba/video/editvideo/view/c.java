package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.media.MediaPlayer;
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
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private Resources fEU;
    private MediaPlayer guu;
    private a gva;
    private boolean gwA;
    private String gwB;
    private int gwC;
    private int gwD;
    private int gwE;
    private boolean gwF;
    private String gwG;
    private HorizontalListView gwv;
    private com.baidu.tieba.video.editvideo.a.a gww;
    private LinearLayout gwx;
    private ImageView gwy;
    private TextView gwz;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gwA = true;
        this.gwC = 1;
        this.gva = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_music_layout, (ViewGroup) null);
        this.fEU = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gwv = (HorizontalListView) this.mRootView.findViewById(d.h.horizontal_list);
        this.gww = new com.baidu.tieba.video.editvideo.a.a(this.mContext);
        this.gwv.setAdapter((ListAdapter) this.gww);
        this.gwv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.gww.bvR() != i || i == c.this.gwC) {
                    c.this.gwD = i;
                    c.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public boolean bwi() {
        return this.guu != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gww.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ad("obj_id", musicData.id);
            akVar.r("obj_locate", i + 1);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.gww.ux(i);
                    bem();
                    this.gva.bwb();
                    return;
                case 2:
                    this.gwC = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.gwF = false;
        this.gwD = this.gwC;
        this.gwG = str2;
        aB(str, this.gwC);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gwG = musicData.id;
            this.gva.bvP();
            String sB = com.baidu.tieba.video.editvideo.model.a.bvS().sB(musicData.resource);
            if (TextUtils.isEmpty(sB)) {
                if (view != null) {
                    final a.C0130a c0130a = (a.C0130a) view.getTag();
                    c0130a.guE.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bvS().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            c0130a.guE.setVisibility(4);
                            c.this.aB(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void sy(String str) {
                            c0130a.guE.setVisibility(4);
                            l.showToast(c.this.mContext.getPageActivity(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void bvv() {
                            c0130a.guE.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bvS().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void cj(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        c.this.aB(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void sy(String str) {
                        l.showToast(c.this.mContext.getPageActivity(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void bvv() {
                    }
                });
                return;
            }
            aB(sB, i);
        }
    }

    public void bwb() {
        this.gwF = false;
        if (this.guu != null && this.guu.isPlaying()) {
            this.guu.pause();
        }
        if (this.guu != null) {
            this.guu.start();
            this.guu.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, final int i) {
        this.gwE = i;
        if (this.gwD == this.gwE && !this.gwF) {
            if (this.guu == null) {
                this.guu = new MediaPlayer();
                this.guu.setAudioStreamType(3);
            }
            try {
                this.gwB = str;
                this.guu.reset();
                this.guu.setDataSource(str);
                this.guu.prepare();
                this.guu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.c.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.gww.ux(i);
                        c.this.guu.setLooping(true);
                        c.this.guu.start();
                        c.this.gva.bwb();
                    }
                });
                this.guu.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.c.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aC(str, i);
            }
        }
    }

    private void aC(String str, int i) {
        this.gwB = null;
        bem();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bvS().bvT();
        }
        a(i, this.gwv.getChildCount() > i ? this.gwv.getChildAt(i) : null, (MusicData) this.gww.getItem(i));
    }

    public void dz(List<MusicData> list) {
        this.gww.setData(list);
    }

    public String bwf() {
        return this.gwB;
    }

    public String bwg() {
        return this.gwG;
    }

    public void bJ(View view) {
        this.gwx = (LinearLayout) view.findViewById(d.h.video_voice_layout);
        this.gwy = (ImageView) view.findViewById(d.h.video_voice_img);
        this.gwz = (TextView) view.findViewById(d.h.video_voice_text);
        this.gwx.setVisibility(8);
        this.gwx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.gwA = !c.this.gwA;
                if (c.this.gwA) {
                    c.this.gwy.setSelected(false);
                    c.this.gwz.setText(c.this.fEU.getString(d.l.video_voice_open));
                } else {
                    c.this.gwy.setSelected(true);
                    c.this.gwz.setText(c.this.fEU.getString(d.l.video_voice_close));
                }
                c.this.gva.nb(!c.this.gwA);
                c.this.bwb();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", c.this.gwA ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gwA) {
            this.gwy.setSelected(false);
            this.gwz.setText(this.fEU.getString(d.l.video_voice_open));
            return;
        }
        this.gwy.setSelected(true);
        this.gwz.setText(this.fEU.getString(d.l.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nc(boolean z) {
        if (z) {
            this.gwx.setVisibility(0);
            bwb();
            return;
        }
        this.gwx.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gwF = true;
        if (this.guu != null && this.guu.isPlaying()) {
            this.guu.pause();
        }
    }

    public void onResume() {
        this.gwF = false;
        if (this.guu != null && this.gva.adR == 1) {
            this.guu.start();
            this.guu.seekTo(0);
        }
    }

    private void bem() {
        if (this.guu != null) {
            if (this.guu.isPlaying()) {
                this.guu.stop();
            }
            this.guu.release();
            this.guu = null;
        }
        this.gwB = null;
        this.gwG = null;
    }
}
