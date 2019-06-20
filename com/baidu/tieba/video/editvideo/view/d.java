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
import com.baidu.tieba.R;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private h iZX;
    private MediaPlayer jou;
    private a jpa;
    private HorizontalListView jrL;
    private com.baidu.tieba.video.editvideo.a.c jrP;
    private LinearLayout jrQ;
    private ImageView jrR;
    private TextView jrS;
    private boolean jrT;
    private String jrU;
    private int jrV;
    private int jrW;
    private int jrX;
    private boolean jrY;
    private String jrZ;
    private boolean jsa;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jrT = true;
        this.jrV = 1;
        this.jpa = aVar;
        this.iZX = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jrL = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jrP = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jrL.setAdapter((ListAdapter) this.jrP);
        this.jrL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jrP.crw() != i || i == d.this.jrV) {
                    d.this.jrW = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean csl() {
        return !TextUtils.isEmpty(this.jrZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jrP.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.P("obj_locate", i + 1);
            amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.jrP.Bz(i);
                    aAl();
                    this.jpa.replay();
                    return;
                case 2:
                    this.jrV = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void es(String str, String str2) {
        this.jrY = false;
        this.jrW = this.jrV;
        this.jrZ = str2;
        bq(str, this.jrV);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jrZ = musicData.id;
            this.jpa.crv();
            String EY = com.baidu.tieba.video.editvideo.model.a.crM().EY(musicData.resource);
            if (TextUtils.isEmpty(EY)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.joD.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.crM().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void er(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.joD.setVisibility(4);
                            d.this.bq(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void EQ(String str) {
                            aVar.joD.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iZX != null) {
                                d.this.iZX.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void crc() {
                            aVar.joD.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.crM().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bq(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EQ(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.iZX != null) {
                            d.this.iZX.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crc() {
                    }
                });
                return;
            }
            bq(EY, i);
        }
    }

    public void replay() {
        this.jrY = false;
        if (this.jou != null && this.jou.isPlaying()) {
            this.jou.pause();
        }
        if (this.jou != null) {
            this.jou.start();
            this.jou.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(String str, final int i) {
        this.jrX = i;
        if (this.jrW == this.jrX && !this.jrY) {
            if (this.jou == null) {
                this.jou = new MediaPlayer();
                this.jou.setAudioStreamType(3);
            }
            try {
                this.jrU = str;
                this.jou.reset();
                this.jou.setDataSource(str);
                this.jou.prepare();
                this.jou.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jrP.Bz(i);
                        d.this.jou.setLooping(true);
                        d.this.jou.start();
                        d.this.jpa.replay();
                    }
                });
                this.jou.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iZX != null) {
                            d.this.iZX.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                br(str, i);
                if (this.iZX != null) {
                    this.iZX.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void br(String str, int i) {
        this.jrU = null;
        aAl();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.crM().crN();
        }
        a(i, this.jrL.getChildCount() > i ? this.jrL.getChildAt(i) : null, (MusicData) this.jrP.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jrP.setData(list);
        if (this.jrP != null) {
            this.jrX = this.jrP.crw();
            this.jrW = this.jrX;
        }
    }

    public String csj() {
        return this.jrU;
    }

    public String csk() {
        return this.jrZ;
    }

    public void cS(View view) {
        this.jrQ = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jrR = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jrS = (TextView) view.findViewById(R.id.video_voice_text);
        this.jrQ.setVisibility(8);
        this.jrQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jrT = !d.this.jrT;
                if (d.this.jrT) {
                    d.this.jrR.setSelected(false);
                    d.this.jrS.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jrR.setSelected(true);
                    d.this.jrS.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jpa.setMute(!d.this.jrT);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.P("obj_type", d.this.jrT ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.jrT) {
            this.jrR.setSelected(false);
            this.jrS.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jrR.setSelected(true);
        this.jrS.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
        if (z) {
            this.jrQ.setVisibility(0);
            if (this.jsa && this.jou == null && !TextUtils.isEmpty(this.jrU)) {
                bq(this.jrU, this.jrX);
                this.jsa = false;
                if (this.jrX > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jrL.setSelection(d.this.jrX);
                            d.this.jrL.scrollTo(d.this.jrW * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jrQ.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jrY = true;
        if (this.jou != null && this.jou.isPlaying()) {
            this.jou.pause();
        }
    }

    public void onResume() {
        this.jrY = false;
        if (this.jou != null && this.jpa.mCurrentTabIndex == 2) {
            this.jou.start();
            this.jou.seekTo(0);
        }
    }

    private void aAl() {
        if (this.jou != null) {
            if (this.jou.isPlaying()) {
                this.jou.stop();
            }
            this.jou.release();
            this.jou = null;
        }
        this.jrU = null;
        this.jrZ = null;
    }

    public void ay(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jsa = true;
            this.jrZ = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jrU = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jrP != null) {
                this.jrP.EW(this.jrZ);
                this.jrX = this.jrP.crw();
                this.jrV = this.jrX;
                this.jrW = this.jrX;
            }
        }
    }
}
