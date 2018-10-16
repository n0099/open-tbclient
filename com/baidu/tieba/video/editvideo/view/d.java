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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private h hea;
    private MediaPlayer hrO;
    private a hst;
    private HorizontalListView hvk;
    private com.baidu.tieba.video.editvideo.a.c hvo;
    private LinearLayout hvp;
    private ImageView hvq;
    private TextView hvr;
    private boolean hvs;
    private String hvt;
    private int hvu;
    private int hvv;
    private int hvw;
    private boolean hvx;
    private String hvy;
    private boolean hvz;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hvs = true;
        this.hvu = 1;
        this.hst = aVar;
        this.hea = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hvk = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hvo = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hvk.setAdapter((ListAdapter) this.hvo);
        this.hvk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hvo.bGQ() != i || i == d.this.hvu) {
                    d.this.hvv = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bHH() {
        return !TextUtils.isEmpty(this.hvy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hvo.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.x("obj_locate", i + 1);
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hvo.vD(i);
                    Tu();
                    this.hst.replay();
                    return;
                case 2:
                    this.hvu = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cN(String str, String str2) {
        this.hvx = false;
        this.hvv = this.hvu;
        this.hvy = str2;
        aW(str, this.hvu);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hvy = musicData.id;
            this.hst.bGP();
            String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(musicData.resource);
            if (TextUtils.isEmpty(vZ)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hrX.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void cM(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hrX.setVisibility(4);
                            d.this.aW(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void vR(String str) {
                            aVar.hrX.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hea != null) {
                                d.this.hea.ad(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                        public void bGw() {
                            aVar.hrX.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bHi().a(musicData.id, musicData.resource, new a.InterfaceC0283a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aW(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void vR(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hea != null) {
                            d.this.hea.ad(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0283a
                    public void bGw() {
                    }
                });
                return;
            }
            aW(vZ, i);
        }
    }

    public void replay() {
        this.hvx = false;
        if (this.hrO != null && this.hrO.isPlaying()) {
            this.hrO.pause();
        }
        if (this.hrO != null) {
            this.hrO.start();
            this.hrO.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, final int i) {
        this.hvw = i;
        if (this.hvv == this.hvw && !this.hvx) {
            if (this.hrO == null) {
                this.hrO = new MediaPlayer();
                this.hrO.setAudioStreamType(3);
            }
            try {
                this.hvt = str;
                this.hrO.reset();
                this.hrO.setDataSource(str);
                this.hrO.prepare();
                this.hrO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hvo.vD(i);
                        d.this.hrO.setLooping(true);
                        d.this.hrO.start();
                        d.this.hst.replay();
                    }
                });
                this.hrO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hea != null) {
                            d.this.hea.ad(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aX(str, i);
                if (this.hea != null) {
                    this.hea.ad(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aX(String str, int i) {
        this.hvt = null;
        Tu();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
        }
        a(i, this.hvk.getChildCount() > i ? this.hvk.getChildAt(i) : null, (MusicData) this.hvo.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hvo.setData(list);
        if (this.hvo != null) {
            this.hvw = this.hvo.bGQ();
            this.hvv = this.hvw;
        }
    }

    public String bHF() {
        return this.hvt;
    }

    public String bHG() {
        return this.hvy;
    }

    public void bS(View view) {
        this.hvp = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hvq = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hvr = (TextView) view.findViewById(e.g.video_voice_text);
        this.hvp.setVisibility(8);
        this.hvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hvs = !d.this.hvs;
                if (d.this.hvs) {
                    d.this.hvq.setSelected(false);
                    d.this.hvr.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hvq.setSelected(true);
                    d.this.hvr.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hst.setMute(!d.this.hvs);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.x("obj_type", d.this.hvs ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hvs) {
            this.hvq.setSelected(false);
            this.hvr.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hvq.setSelected(true);
        this.hvr.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nH(boolean z) {
        if (z) {
            this.hvp.setVisibility(0);
            if (this.hvz && this.hrO == null && !TextUtils.isEmpty(this.hvt)) {
                aW(this.hvt, this.hvw);
                this.hvz = false;
                if (this.hvw > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hvk.setSelection(d.this.hvw);
                            d.this.hvk.scrollTo(d.this.hvv * l.h(d.this.getPageContext().getContext(), e.C0175e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hvp.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hvx = true;
        if (this.hrO != null && this.hrO.isPlaying()) {
            this.hrO.pause();
        }
    }

    public void onResume() {
        this.hvx = false;
        if (this.hrO != null && this.hst.mCurrentTabIndex == 2) {
            this.hrO.start();
            this.hrO.seekTo(0);
        }
    }

    private void Tu() {
        if (this.hrO != null) {
            if (this.hrO.isPlaying()) {
                this.hrO.stop();
            }
            this.hrO.release();
            this.hrO = null;
        }
        this.hvt = null;
        this.hvy = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hvz = true;
            this.hvy = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hvt = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hvo != null) {
                this.hvo.vX(this.hvy);
                this.hvw = this.hvo.bGQ();
                this.hvu = this.hvw;
                this.hvv = this.hvw;
            }
        }
    }
}
