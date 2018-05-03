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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
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
    private MediaPlayer gKI;
    private a gLo;
    private HorizontalListView gOf;
    private com.baidu.tieba.video.editvideo.a.c gOj;
    private LinearLayout gOk;
    private ImageView gOl;
    private TextView gOm;
    private boolean gOn;
    private String gOo;
    private int gOp;
    private int gOq;
    private int gOr;
    private boolean gOs;
    private String gOt;
    private boolean gOu;
    private h gxt;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gOn = true;
        this.gOp = 1;
        this.gLo = aVar;
        this.gxt = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gOf = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gOj = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gOf.setAdapter((ListAdapter) this.gOj);
        this.gOf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (d.this.gOj.bwv() != i || i == d.this.gOp) {
                    d.this.gOq = i;
                    d.this.h(i, view2);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public boolean bxm() {
        return !TextUtils.isEmpty(this.gOt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view2) {
        MusicData musicData = (MusicData) this.gOj.getItem(i);
        if (musicData != null) {
            al alVar = new al("c12423");
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            alVar.r("obj_locate", i + 1);
            alVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(alVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view2, musicData);
                    return;
                case 1:
                    this.gOj.un(i);
                    bgx();
                    this.gLo.replay();
                    return;
                case 2:
                    this.gOp = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cj(String str, String str2) {
        this.gOs = false;
        this.gOq = this.gOp;
        this.gOt = str2;
        aN(str, this.gOp);
    }

    private void a(final int i, View view2, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gOt = musicData.id;
            this.gLo.bwu();
            String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(musicData.resource);
            if (TextUtils.isEmpty(tU)) {
                if (view2 != null) {
                    final c.a aVar = (c.a) view2.getTag();
                    aVar.gKR.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void ci(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gKR.setVisibility(4);
                            d.this.aN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void tL(String str) {
                            aVar.gKR.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gxt != null) {
                                d.this.gxt.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void bwb() {
                            aVar.gKR.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bwN().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tL(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gxt != null) {
                            d.this.gxt.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bwb() {
                    }
                });
                return;
            }
            aN(tU, i);
        }
    }

    public void replay() {
        this.gOs = false;
        if (this.gKI != null && this.gKI.isPlaying()) {
            this.gKI.pause();
        }
        if (this.gKI != null) {
            this.gKI.start();
            this.gKI.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, final int i) {
        this.gOr = i;
        if (this.gOq == this.gOr && !this.gOs) {
            if (this.gKI == null) {
                this.gKI = new MediaPlayer();
                this.gKI.setAudioStreamType(3);
            }
            try {
                this.gOo = str;
                this.gKI.reset();
                this.gKI.setDataSource(str);
                this.gKI.prepare();
                this.gKI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gOj.un(i);
                        d.this.gKI.setLooping(true);
                        d.this.gKI.start();
                        d.this.gLo.replay();
                    }
                });
                this.gKI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gxt != null) {
                            d.this.gxt.ae(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aO(str, i);
                if (this.gxt != null) {
                    this.gxt.ae(208, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    private void aO(String str, int i) {
        this.gOo = null;
        bgx();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
        }
        a(i, this.gOf.getChildCount() > i ? this.gOf.getChildAt(i) : null, (MusicData) this.gOj.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gOj.setData(list);
        if (this.gOj != null) {
            this.gOr = this.gOj.bwv();
            this.gOq = this.gOr;
        }
    }

    public String bxk() {
        return this.gOo;
    }

    public String bxl() {
        return this.gOt;
    }

    public void by(View view2) {
        this.gOk = (LinearLayout) view2.findViewById(d.g.video_voice_layout);
        this.gOl = (ImageView) view2.findViewById(d.g.video_voice_img);
        this.gOm = (TextView) view2.findViewById(d.g.video_voice_text);
        this.gOk.setVisibility(8);
        this.gOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                d.this.gOn = !d.this.gOn;
                if (d.this.gOn) {
                    d.this.gOl.setSelected(false);
                    d.this.gOm.setText(d.this.mResources.getString(d.k.video_voice_open));
                } else {
                    d.this.gOl.setSelected(true);
                    d.this.gOm.setText(d.this.mResources.getString(d.k.video_voice_close));
                }
                d.this.gLo.setMute(!d.this.gOn);
                d.this.replay();
                al alVar = new al("c12423");
                alVar.r("obj_type", d.this.gOn ? 0 : 1);
                TiebaStatic.log(alVar);
            }
        });
        if (this.gOn) {
            this.gOl.setSelected(false);
            this.gOm.setText(this.mResources.getString(d.k.video_voice_open));
            return;
        }
        this.gOl.setSelected(true);
        this.gOm.setText(this.mResources.getString(d.k.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
        if (z) {
            this.gOk.setVisibility(0);
            if (this.gOu && this.gKI == null && !TextUtils.isEmpty(this.gOo)) {
                aN(this.gOo, this.gOr);
                this.gOu = false;
                if (this.gOr > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gOf.setSelection(d.this.gOr);
                            d.this.gOf.df(d.this.gOq * l.e(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.gOk.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gOs = true;
        if (this.gKI != null && this.gKI.isPlaying()) {
            this.gKI.pause();
        }
    }

    public void onResume() {
        this.gOs = false;
        if (this.gKI != null && this.gLo.mCurrentTabIndex == 2) {
            this.gKI.start();
            this.gKI.seekTo(0);
        }
    }

    private void bgx() {
        if (this.gKI != null) {
            if (this.gKI.isPlaying()) {
                this.gKI.stop();
            }
            this.gKI.release();
            this.gKI = null;
        }
        this.gOo = null;
        this.gOt = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gOu = true;
            this.gOt = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gOo = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gOj != null) {
                this.gOj.tR(this.gOt);
                this.gOr = this.gOj.bwv();
                this.gOp = this.gOr;
                this.gOq = this.gOr;
            }
        }
    }
}
