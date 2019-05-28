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
    private h iZT;
    private a joW;
    private MediaPlayer joq;
    private HorizontalListView jrI;
    private com.baidu.tieba.video.editvideo.a.c jrM;
    private LinearLayout jrN;
    private ImageView jrO;
    private TextView jrP;
    private boolean jrQ;
    private String jrR;
    private int jrS;
    private int jrT;
    private int jrU;
    private boolean jrV;
    private String jrW;
    private boolean jrX;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jrQ = true;
        this.jrS = 1;
        this.joW = aVar;
        this.iZT = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jrI = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jrM = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jrI.setAdapter((ListAdapter) this.jrM);
        this.jrI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jrM.crv() != i || i == d.this.jrS) {
                    d.this.jrT = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean csm() {
        return !TextUtils.isEmpty(this.jrW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jrM.getItem(i);
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
                    this.jrM.Bz(i);
                    aAl();
                    this.joW.replay();
                    return;
                case 2:
                    this.jrS = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void es(String str, String str2) {
        this.jrV = false;
        this.jrT = this.jrS;
        this.jrW = str2;
        bq(str, this.jrS);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jrW = musicData.id;
            this.joW.cru();
            String EW = com.baidu.tieba.video.editvideo.model.a.crN().EW(musicData.resource);
            if (TextUtils.isEmpty(EW)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.joz.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.crN().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void er(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.joz.setVisibility(4);
                            d.this.bq(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void EO(String str) {
                            aVar.joz.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iZT != null) {
                                d.this.iZT.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void crb() {
                            aVar.joz.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.crN().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void er(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bq(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void EO(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.iZT != null) {
                            d.this.iZT.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void crb() {
                    }
                });
                return;
            }
            bq(EW, i);
        }
    }

    public void replay() {
        this.jrV = false;
        if (this.joq != null && this.joq.isPlaying()) {
            this.joq.pause();
        }
        if (this.joq != null) {
            this.joq.start();
            this.joq.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(String str, final int i) {
        this.jrU = i;
        if (this.jrT == this.jrU && !this.jrV) {
            if (this.joq == null) {
                this.joq = new MediaPlayer();
                this.joq.setAudioStreamType(3);
            }
            try {
                this.jrR = str;
                this.joq.reset();
                this.joq.setDataSource(str);
                this.joq.prepare();
                this.joq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jrM.Bz(i);
                        d.this.joq.setLooping(true);
                        d.this.joq.start();
                        d.this.joW.replay();
                    }
                });
                this.joq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iZT != null) {
                            d.this.iZT.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                br(str, i);
                if (this.iZT != null) {
                    this.iZT.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void br(String str, int i) {
        this.jrR = null;
        aAl();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.crN().crO();
        }
        a(i, this.jrI.getChildCount() > i ? this.jrI.getChildAt(i) : null, (MusicData) this.jrM.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jrM.setData(list);
        if (this.jrM != null) {
            this.jrU = this.jrM.crv();
            this.jrT = this.jrU;
        }
    }

    public String csk() {
        return this.jrR;
    }

    public String csl() {
        return this.jrW;
    }

    public void cS(View view) {
        this.jrN = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jrO = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jrP = (TextView) view.findViewById(R.id.video_voice_text);
        this.jrN.setVisibility(8);
        this.jrN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jrQ = !d.this.jrQ;
                if (d.this.jrQ) {
                    d.this.jrO.setSelected(false);
                    d.this.jrP.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jrO.setSelected(true);
                    d.this.jrP.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.joW.setMute(!d.this.jrQ);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.P("obj_type", d.this.jrQ ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.jrQ) {
            this.jrO.setSelected(false);
            this.jrP.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jrO.setSelected(true);
        this.jrP.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rq(boolean z) {
        if (z) {
            this.jrN.setVisibility(0);
            if (this.jrX && this.joq == null && !TextUtils.isEmpty(this.jrR)) {
                bq(this.jrR, this.jrU);
                this.jrX = false;
                if (this.jrU > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jrI.setSelection(d.this.jrU);
                            d.this.jrI.scrollTo(d.this.jrT * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jrN.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jrV = true;
        if (this.joq != null && this.joq.isPlaying()) {
            this.joq.pause();
        }
    }

    public void onResume() {
        this.jrV = false;
        if (this.joq != null && this.joW.mCurrentTabIndex == 2) {
            this.joq.start();
            this.joq.seekTo(0);
        }
    }

    private void aAl() {
        if (this.joq != null) {
            if (this.joq.isPlaying()) {
                this.joq.stop();
            }
            this.joq.release();
            this.joq = null;
        }
        this.jrR = null;
        this.jrW = null;
    }

    public void ay(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jrX = true;
            this.jrW = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jrR = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jrM != null) {
                this.jrM.EU(this.jrW);
                this.jrU = this.jrM.crv();
                this.jrS = this.jrU;
                this.jrT = this.jrU;
            }
        }
    }
}
