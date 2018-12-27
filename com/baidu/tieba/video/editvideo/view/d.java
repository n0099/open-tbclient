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
    private MediaPlayer hDV;
    private a hEA;
    private String hHA;
    private int hHB;
    private int hHC;
    private int hHD;
    private boolean hHE;
    private String hHF;
    private boolean hHG;
    private HorizontalListView hHr;
    private com.baidu.tieba.video.editvideo.a.c hHv;
    private LinearLayout hHw;
    private ImageView hHx;
    private TextView hHy;
    private boolean hHz;
    private h hpD;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hHz = true;
        this.hHB = 1;
        this.hEA = aVar;
        this.hpD = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hHr = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hHv = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hHr.setAdapter((ListAdapter) this.hHv);
        this.hHr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hHv.bJj() != i || i == d.this.hHB) {
                    d.this.hHC = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bKa() {
        return !TextUtils.isEmpty(this.hHF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hHv.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.x("obj_locate", i + 1);
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hHv.wG(i);
                    UL();
                    this.hEA.replay();
                    return;
                case 2:
                    this.hHB = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cS(String str, String str2) {
        this.hHE = false;
        this.hHC = this.hHB;
        this.hHF = str2;
        aY(str, this.hHB);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hHF = musicData.id;
            this.hEA.bJi();
            String wK = com.baidu.tieba.video.editvideo.model.a.bJB().wK(musicData.resource);
            if (TextUtils.isEmpty(wK)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hEe.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bJB().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void cR(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hEe.setVisibility(4);
                            d.this.aY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void wC(String str) {
                            aVar.hEe.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hpD != null) {
                                d.this.hpD.aa(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                        public void bIP() {
                            aVar.hEe.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bJB().a(musicData.id, musicData.resource, new a.InterfaceC0325a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void cR(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void wC(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hpD != null) {
                            d.this.hpD.aa(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0325a
                    public void bIP() {
                    }
                });
                return;
            }
            aY(wK, i);
        }
    }

    public void replay() {
        this.hHE = false;
        if (this.hDV != null && this.hDV.isPlaying()) {
            this.hDV.pause();
        }
        if (this.hDV != null) {
            this.hDV.start();
            this.hDV.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, final int i) {
        this.hHD = i;
        if (this.hHC == this.hHD && !this.hHE) {
            if (this.hDV == null) {
                this.hDV = new MediaPlayer();
                this.hDV.setAudioStreamType(3);
            }
            try {
                this.hHA = str;
                this.hDV.reset();
                this.hDV.setDataSource(str);
                this.hDV.prepare();
                this.hDV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hHv.wG(i);
                        d.this.hDV.setLooping(true);
                        d.this.hDV.start();
                        d.this.hEA.replay();
                    }
                });
                this.hDV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hpD != null) {
                            d.this.hpD.aa(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aZ(str, i);
                if (this.hpD != null) {
                    this.hpD.aa(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aZ(String str, int i) {
        this.hHA = null;
        UL();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bJB().bJC();
        }
        a(i, this.hHr.getChildCount() > i ? this.hHr.getChildAt(i) : null, (MusicData) this.hHv.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hHv.setData(list);
        if (this.hHv != null) {
            this.hHD = this.hHv.bJj();
            this.hHC = this.hHD;
        }
    }

    public String bJY() {
        return this.hHA;
    }

    public String bJZ() {
        return this.hHF;
    }

    public void bX(View view) {
        this.hHw = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hHx = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hHy = (TextView) view.findViewById(e.g.video_voice_text);
        this.hHw.setVisibility(8);
        this.hHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hHz = !d.this.hHz;
                if (d.this.hHz) {
                    d.this.hHx.setSelected(false);
                    d.this.hHy.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hHx.setSelected(true);
                    d.this.hHy.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hEA.setMute(!d.this.hHz);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.x("obj_type", d.this.hHz ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hHz) {
            this.hHx.setSelected(false);
            this.hHy.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hHx.setSelected(true);
        this.hHy.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oa(boolean z) {
        if (z) {
            this.hHw.setVisibility(0);
            if (this.hHG && this.hDV == null && !TextUtils.isEmpty(this.hHA)) {
                aY(this.hHA, this.hHD);
                this.hHG = false;
                if (this.hHD > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hHr.setSelection(d.this.hHD);
                            d.this.hHr.scrollTo(d.this.hHC * l.h(d.this.getPageContext().getContext(), e.C0210e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hHw.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hHE = true;
        if (this.hDV != null && this.hDV.isPlaying()) {
            this.hDV.pause();
        }
    }

    public void onResume() {
        this.hHE = false;
        if (this.hDV != null && this.hEA.mCurrentTabIndex == 2) {
            this.hDV.start();
            this.hDV.seekTo(0);
        }
    }

    private void UL() {
        if (this.hDV != null) {
            if (this.hDV.isPlaying()) {
                this.hDV.stop();
            }
            this.hDV.release();
            this.hDV = null;
        }
        this.hHA = null;
        this.hHF = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hHG = true;
            this.hHF = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hHA = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hHv != null) {
                this.hHv.wI(this.hHF);
                this.hHD = this.hHv.bJj();
                this.hHB = this.hHD;
                this.hHC = this.hHD;
            }
        }
    }
}
