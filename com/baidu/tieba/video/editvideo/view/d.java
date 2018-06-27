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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private h gOa;
    private a hbY;
    private MediaPlayer hbs;
    private HorizontalListView heP;
    private com.baidu.tieba.video.editvideo.a.c heT;
    private LinearLayout heU;
    private ImageView heV;
    private TextView heW;
    private boolean heX;
    private String heY;
    private int heZ;
    private int hfa;
    private int hfb;
    private boolean hfc;
    private String hfd;
    private boolean hfe;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.heX = true;
        this.heZ = 1;
        this.hbY = aVar;
        this.gOa = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.heP = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.heT = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.heP.setAdapter((ListAdapter) this.heT);
        this.heP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.heT.bCa() != i || i == d.this.heZ) {
                    d.this.hfa = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
    }

    public boolean bCR() {
        return !TextUtils.isEmpty(this.hfd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.heT.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            anVar.r("obj_locate", i + 1);
            anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.heT.uH(i);
                    blZ();
                    this.hbY.replay();
                    return;
                case 2:
                    this.heZ = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cv(String str, String str2) {
        this.hfc = false;
        this.hfa = this.heZ;
        this.hfd = str2;
        aR(str, this.heZ);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hfd = musicData.id;
            this.hbY.bBZ();
            String uN = com.baidu.tieba.video.editvideo.model.a.bCs().uN(musicData.resource);
            if (TextUtils.isEmpty(uN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hbB.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bCs().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void cu(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hbB.setVisibility(4);
                            d.this.aR(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void uE(String str) {
                            aVar.hbB.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gOa != null) {
                                d.this.gOa.ab(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                        public void bBG() {
                            aVar.hbB.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bCs().a(musicData.id, musicData.resource, new a.InterfaceC0242a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void cu(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aR(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void uE(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gOa != null) {
                            d.this.gOa.ab(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0242a
                    public void bBG() {
                    }
                });
                return;
            }
            aR(uN, i);
        }
    }

    public void replay() {
        this.hfc = false;
        if (this.hbs != null && this.hbs.isPlaying()) {
            this.hbs.pause();
        }
        if (this.hbs != null) {
            this.hbs.start();
            this.hbs.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(String str, final int i) {
        this.hfb = i;
        if (this.hfa == this.hfb && !this.hfc) {
            if (this.hbs == null) {
                this.hbs = new MediaPlayer();
                this.hbs.setAudioStreamType(3);
            }
            try {
                this.heY = str;
                this.hbs.reset();
                this.hbs.setDataSource(str);
                this.hbs.prepare();
                this.hbs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.heT.uH(i);
                        d.this.hbs.setLooping(true);
                        d.this.hbs.start();
                        d.this.hbY.replay();
                    }
                });
                this.hbs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gOa != null) {
                            d.this.gOa.ab(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aS(str, i);
                if (this.gOa != null) {
                    this.gOa.ab(208, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    private void aS(String str, int i) {
        this.heY = null;
        blZ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bCs().bCt();
        }
        a(i, this.heP.getChildCount() > i ? this.heP.getChildAt(i) : null, (MusicData) this.heT.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.heT.setData(list);
        if (this.heT != null) {
            this.hfb = this.heT.bCa();
            this.hfa = this.hfb;
        }
    }

    public String bCP() {
        return this.heY;
    }

    public String bCQ() {
        return this.hfd;
    }

    public void bC(View view) {
        this.heU = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.heV = (ImageView) view.findViewById(d.g.video_voice_img);
        this.heW = (TextView) view.findViewById(d.g.video_voice_text);
        this.heU.setVisibility(8);
        this.heU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.heX = !d.this.heX;
                if (d.this.heX) {
                    d.this.heV.setSelected(false);
                    d.this.heW.setText(d.this.mResources.getString(d.k.video_voice_open));
                } else {
                    d.this.heV.setSelected(true);
                    d.this.heW.setText(d.this.mResources.getString(d.k.video_voice_close));
                }
                d.this.hbY.setMute(!d.this.heX);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.r("obj_type", d.this.heX ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.heX) {
            this.heV.setSelected(false);
            this.heW.setText(this.mResources.getString(d.k.video_voice_open));
            return;
        }
        this.heV.setSelected(true);
        this.heW.setText(this.mResources.getString(d.k.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nh(boolean z) {
        if (z) {
            this.heU.setVisibility(0);
            if (this.hfe && this.hbs == null && !TextUtils.isEmpty(this.heY)) {
                aR(this.heY, this.hfb);
                this.hfe = false;
                if (this.hfb > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.heP.setSelection(d.this.hfb);
                            d.this.heP.dj(d.this.hfa * l.e(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.heU.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hfc = true;
        if (this.hbs != null && this.hbs.isPlaying()) {
            this.hbs.pause();
        }
    }

    public void onResume() {
        this.hfc = false;
        if (this.hbs != null && this.hbY.mCurrentTabIndex == 2) {
            this.hbs.start();
            this.hbs.seekTo(0);
        }
    }

    private void blZ() {
        if (this.hbs != null) {
            if (this.hbs.isPlaying()) {
                this.hbs.stop();
            }
            this.hbs.release();
            this.hbs = null;
        }
        this.heY = null;
        this.hfd = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hfe = true;
            this.hfd = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.heY = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.heT != null) {
                this.heT.uK(this.hfd);
                this.hfb = this.heT.bCa();
                this.heZ = this.hfb;
                this.hfa = this.hfb;
            }
        }
    }
}
