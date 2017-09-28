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
    private Resources fEV;
    private MediaPlayer guv;
    private a gvb;
    private TextView gwA;
    private boolean gwB;
    private String gwC;
    private int gwD;
    private int gwE;
    private int gwF;
    private boolean gwG;
    private String gwH;
    private HorizontalListView gww;
    private com.baidu.tieba.video.editvideo.a.a gwx;
    private LinearLayout gwy;
    private ImageView gwz;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gwB = true;
        this.gwD = 1;
        this.gvb = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_music_layout, (ViewGroup) null);
        this.fEV = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gww = (HorizontalListView) this.mRootView.findViewById(d.h.horizontal_list);
        this.gwx = new com.baidu.tieba.video.editvideo.a.a(this.mContext);
        this.gww.setAdapter((ListAdapter) this.gwx);
        this.gww.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.gwx.bvS() != i || i == c.this.gwD) {
                    c.this.gwE = i;
                    c.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public boolean bwj() {
        return this.guv != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gwx.getItem(i);
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
                    this.gwx.ux(i);
                    ben();
                    this.gvb.bwc();
                    return;
                case 2:
                    this.gwD = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ck(String str, String str2) {
        this.gwG = false;
        this.gwE = this.gwD;
        this.gwH = str2;
        aB(str, this.gwD);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gwH = musicData.id;
            this.gvb.bvQ();
            String sB = com.baidu.tieba.video.editvideo.model.a.bvT().sB(musicData.resource);
            if (TextUtils.isEmpty(sB)) {
                if (view != null) {
                    final a.C0130a c0130a = (a.C0130a) view.getTag();
                    c0130a.guF.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bvT().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void cj(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            c0130a.guF.setVisibility(4);
                            c.this.aB(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void sy(String str) {
                            c0130a.guF.setVisibility(4);
                            l.showToast(c.this.mContext.getPageActivity(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void bvw() {
                            c0130a.guF.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bvT().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.3
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
                    public void bvw() {
                    }
                });
                return;
            }
            aB(sB, i);
        }
    }

    public void bwc() {
        this.gwG = false;
        if (this.guv != null && this.guv.isPlaying()) {
            this.guv.pause();
        }
        if (this.guv != null) {
            this.guv.start();
            this.guv.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, final int i) {
        this.gwF = i;
        if (this.gwE == this.gwF && !this.gwG) {
            if (this.guv == null) {
                this.guv = new MediaPlayer();
                this.guv.setAudioStreamType(3);
            }
            try {
                this.gwC = str;
                this.guv.reset();
                this.guv.setDataSource(str);
                this.guv.prepare();
                this.guv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.c.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.gwx.ux(i);
                        c.this.guv.setLooping(true);
                        c.this.guv.start();
                        c.this.gvb.bwc();
                    }
                });
                this.guv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.c.5
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
        this.gwC = null;
        ben();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bvT().bvU();
        }
        a(i, this.gww.getChildCount() > i ? this.gww.getChildAt(i) : null, (MusicData) this.gwx.getItem(i));
    }

    public void dz(List<MusicData> list) {
        this.gwx.setData(list);
    }

    public String bwg() {
        return this.gwC;
    }

    public String bwh() {
        return this.gwH;
    }

    public void bJ(View view) {
        this.gwy = (LinearLayout) view.findViewById(d.h.video_voice_layout);
        this.gwz = (ImageView) view.findViewById(d.h.video_voice_img);
        this.gwA = (TextView) view.findViewById(d.h.video_voice_text);
        this.gwy.setVisibility(8);
        this.gwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.gwB = !c.this.gwB;
                if (c.this.gwB) {
                    c.this.gwz.setSelected(false);
                    c.this.gwA.setText(c.this.fEV.getString(d.l.video_voice_open));
                } else {
                    c.this.gwz.setSelected(true);
                    c.this.gwA.setText(c.this.fEV.getString(d.l.video_voice_close));
                }
                c.this.gvb.nb(!c.this.gwB);
                c.this.bwc();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", c.this.gwB ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gwB) {
            this.gwz.setSelected(false);
            this.gwA.setText(this.fEV.getString(d.l.video_voice_open));
            return;
        }
        this.gwz.setSelected(true);
        this.gwA.setText(this.fEV.getString(d.l.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nc(boolean z) {
        if (z) {
            this.gwy.setVisibility(0);
            bwc();
            return;
        }
        this.gwy.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gwG = true;
        if (this.guv != null && this.guv.isPlaying()) {
            this.guv.pause();
        }
    }

    public void onResume() {
        this.gwG = false;
        if (this.guv != null && this.gvb.adR == 1) {
            this.guv.start();
            this.guv.seekTo(0);
        }
    }

    private void ben() {
        if (this.guv != null) {
            if (this.guv.isPlaying()) {
                this.guv.stop();
            }
            this.guv.release();
            this.guv = null;
        }
        this.gwC = null;
        this.gwH = null;
    }
}
