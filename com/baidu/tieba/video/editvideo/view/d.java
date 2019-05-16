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
    private h iZR;
    private a joV;
    private MediaPlayer jop;
    private HorizontalListView jrH;
    private com.baidu.tieba.video.editvideo.a.c jrL;
    private LinearLayout jrM;
    private ImageView jrN;
    private TextView jrO;
    private boolean jrP;
    private String jrQ;
    private int jrR;
    private int jrS;
    private int jrT;
    private boolean jrU;
    private String jrV;
    private boolean jrW;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jrP = true;
        this.jrR = 1;
        this.joV = aVar;
        this.iZR = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jrH = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jrL = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jrH.setAdapter((ListAdapter) this.jrL);
        this.jrH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jrL.crt() != i || i == d.this.jrR) {
                    d.this.jrS = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean csk() {
        return !TextUtils.isEmpty(this.jrV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jrL.getItem(i);
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
                    this.jrL.Bz(i);
                    aAi();
                    this.joV.replay();
                    return;
                case 2:
                    this.jrR = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void es(String str, String str2) {
        this.jrU = false;
        this.jrS = this.jrR;
        this.jrV = str2;
        bq(str, this.jrR);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jrV = musicData.id;
            this.joV.crs();
            String EW = com.baidu.tieba.video.editvideo.model.a.crL().EW(musicData.resource);
            if (TextUtils.isEmpty(EW)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.joy.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.crL().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void er(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.joy.setVisibility(4);
                            d.this.bq(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void EO(String str) {
                            aVar.joy.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iZR != null) {
                                d.this.iZR.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                        public void cqZ() {
                            aVar.joy.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.crL().a(musicData.id, musicData.resource, new a.InterfaceC0417a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
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
                        if (d.this.iZR != null) {
                            d.this.iZR.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0417a
                    public void cqZ() {
                    }
                });
                return;
            }
            bq(EW, i);
        }
    }

    public void replay() {
        this.jrU = false;
        if (this.jop != null && this.jop.isPlaying()) {
            this.jop.pause();
        }
        if (this.jop != null) {
            this.jop.start();
            this.jop.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(String str, final int i) {
        this.jrT = i;
        if (this.jrS == this.jrT && !this.jrU) {
            if (this.jop == null) {
                this.jop = new MediaPlayer();
                this.jop.setAudioStreamType(3);
            }
            try {
                this.jrQ = str;
                this.jop.reset();
                this.jop.setDataSource(str);
                this.jop.prepare();
                this.jop.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jrL.Bz(i);
                        d.this.jop.setLooping(true);
                        d.this.jop.start();
                        d.this.joV.replay();
                    }
                });
                this.jop.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iZR != null) {
                            d.this.iZR.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                br(str, i);
                if (this.iZR != null) {
                    this.iZR.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void br(String str, int i) {
        this.jrQ = null;
        aAi();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.crL().crM();
        }
        a(i, this.jrH.getChildCount() > i ? this.jrH.getChildAt(i) : null, (MusicData) this.jrL.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jrL.setData(list);
        if (this.jrL != null) {
            this.jrT = this.jrL.crt();
            this.jrS = this.jrT;
        }
    }

    public String csi() {
        return this.jrQ;
    }

    public String csj() {
        return this.jrV;
    }

    public void cS(View view) {
        this.jrM = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jrN = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jrO = (TextView) view.findViewById(R.id.video_voice_text);
        this.jrM.setVisibility(8);
        this.jrM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jrP = !d.this.jrP;
                if (d.this.jrP) {
                    d.this.jrN.setSelected(false);
                    d.this.jrO.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jrN.setSelected(true);
                    d.this.jrO.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.joV.setMute(!d.this.jrP);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.P("obj_type", d.this.jrP ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.jrP) {
            this.jrN.setSelected(false);
            this.jrO.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jrN.setSelected(true);
        this.jrO.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rq(boolean z) {
        if (z) {
            this.jrM.setVisibility(0);
            if (this.jrW && this.jop == null && !TextUtils.isEmpty(this.jrQ)) {
                bq(this.jrQ, this.jrT);
                this.jrW = false;
                if (this.jrT > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jrH.setSelection(d.this.jrT);
                            d.this.jrH.scrollTo(d.this.jrS * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jrM.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jrU = true;
        if (this.jop != null && this.jop.isPlaying()) {
            this.jop.pause();
        }
    }

    public void onResume() {
        this.jrU = false;
        if (this.jop != null && this.joV.mCurrentTabIndex == 2) {
            this.jop.start();
            this.jop.seekTo(0);
        }
    }

    private void aAi() {
        if (this.jop != null) {
            if (this.jop.isPlaying()) {
                this.jop.stop();
            }
            this.jop.release();
            this.jop = null;
        }
        this.jrQ = null;
        this.jrV = null;
    }

    public void ay(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jrW = true;
            this.jrV = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jrQ = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jrL != null) {
                this.jrL.EU(this.jrV);
                this.jrT = this.jrL.crt();
                this.jrR = this.jrT;
                this.jrS = this.jrT;
            }
        }
    }
}
