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
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gJZ;
    private a gXT;
    private MediaPlayer gXn;
    private HorizontalListView haK;
    private com.baidu.tieba.video.editvideo.a.c haO;
    private LinearLayout haP;
    private ImageView haQ;
    private TextView haR;
    private boolean haS;
    private String haT;
    private int haU;
    private int haV;
    private int haW;
    private boolean haX;
    private String haY;
    private boolean haZ;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.haS = true;
        this.haU = 1;
        this.gXT = aVar;
        this.gJZ = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.haK = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.haO = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.haK.setAdapter((ListAdapter) this.haO);
        this.haK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.haO.bBA() != i || i == d.this.haU) {
                    d.this.haV = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public boolean bCr() {
        return !TextUtils.isEmpty(this.haY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.haO.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.r("obj_locate", i + 1);
            amVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.haO.uz(i);
                    blv();
                    this.gXT.replay();
                    return;
                case 2:
                    this.haU = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cr(String str, String str2) {
        this.haX = false;
        this.haV = this.haU;
        this.haY = str2;
        aQ(str, this.haU);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.haY = musicData.id;
            this.gXT.bBz();
            String uR = com.baidu.tieba.video.editvideo.model.a.bBS().uR(musicData.resource);
            if (TextUtils.isEmpty(uR)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.gXw.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bBS().a(musicData.id, musicData.resource, new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void cq(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gXw.setVisibility(4);
                            d.this.aQ(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void uI(String str) {
                            aVar.gXw.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gJZ != null) {
                                d.this.gJZ.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                        public void bBg() {
                            aVar.gXw.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bBS().a(musicData.id, musicData.resource, new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void cq(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aQ(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void uI(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gJZ != null) {
                            d.this.gJZ.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0240a
                    public void bBg() {
                    }
                });
                return;
            }
            aQ(uR, i);
        }
    }

    public void replay() {
        this.haX = false;
        if (this.gXn != null && this.gXn.isPlaying()) {
            this.gXn.pause();
        }
        if (this.gXn != null) {
            this.gXn.start();
            this.gXn.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str, final int i) {
        this.haW = i;
        if (this.haV == this.haW && !this.haX) {
            if (this.gXn == null) {
                this.gXn = new MediaPlayer();
                this.gXn.setAudioStreamType(3);
            }
            try {
                this.haT = str;
                this.gXn.reset();
                this.gXn.setDataSource(str);
                this.gXn.prepare();
                this.gXn.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.haO.uz(i);
                        d.this.gXn.setLooping(true);
                        d.this.gXn.start();
                        d.this.gXT.replay();
                    }
                });
                this.gXn.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gJZ != null) {
                            d.this.gJZ.ae(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aR(str, i);
                if (this.gJZ != null) {
                    this.gJZ.ae(208, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    private void aR(String str, int i) {
        this.haT = null;
        blv();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bBS().bBT();
        }
        a(i, this.haK.getChildCount() > i ? this.haK.getChildAt(i) : null, (MusicData) this.haO.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.haO.setData(list);
        if (this.haO != null) {
            this.haW = this.haO.bBA();
            this.haV = this.haW;
        }
    }

    public String bCp() {
        return this.haT;
    }

    public String bCq() {
        return this.haY;
    }

    public void bB(View view) {
        this.haP = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.haQ = (ImageView) view.findViewById(d.g.video_voice_img);
        this.haR = (TextView) view.findViewById(d.g.video_voice_text);
        this.haP.setVisibility(8);
        this.haP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.haS = !d.this.haS;
                if (d.this.haS) {
                    d.this.haQ.setSelected(false);
                    d.this.haR.setText(d.this.mResources.getString(d.k.video_voice_open));
                } else {
                    d.this.haQ.setSelected(true);
                    d.this.haR.setText(d.this.mResources.getString(d.k.video_voice_close));
                }
                d.this.gXT.setMute(!d.this.haS);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.r("obj_type", d.this.haS ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.haS) {
            this.haQ.setSelected(false);
            this.haR.setText(this.mResources.getString(d.k.video_voice_open));
            return;
        }
        this.haQ.setSelected(true);
        this.haR.setText(this.mResources.getString(d.k.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mZ(boolean z) {
        if (z) {
            this.haP.setVisibility(0);
            if (this.haZ && this.gXn == null && !TextUtils.isEmpty(this.haT)) {
                aQ(this.haT, this.haW);
                this.haZ = false;
                if (this.haW > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.haK.setSelection(d.this.haW);
                            d.this.haK.di(d.this.haV * l.e(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.haP.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.haX = true;
        if (this.gXn != null && this.gXn.isPlaying()) {
            this.gXn.pause();
        }
    }

    public void onResume() {
        this.haX = false;
        if (this.gXn != null && this.gXT.mCurrentTabIndex == 2) {
            this.gXn.start();
            this.gXn.seekTo(0);
        }
    }

    private void blv() {
        if (this.gXn != null) {
            if (this.gXn.isPlaying()) {
                this.gXn.stop();
            }
            this.gXn.release();
            this.gXn = null;
        }
        this.haT = null;
        this.haY = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.haZ = true;
            this.haY = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.haT = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.haO != null) {
                this.haO.uO(this.haY);
                this.haW = this.haO.bBA();
                this.haU = this.haW;
                this.haV = this.haW;
            }
        }
    }
}
