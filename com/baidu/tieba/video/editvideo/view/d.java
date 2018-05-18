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
    private MediaPlayer gLL;
    private a gMr;
    private HorizontalListView gPi;
    private com.baidu.tieba.video.editvideo.a.c gPm;
    private LinearLayout gPn;
    private ImageView gPo;
    private TextView gPp;
    private boolean gPq;
    private String gPr;
    private int gPs;
    private int gPt;
    private int gPu;
    private boolean gPv;
    private String gPw;
    private boolean gPx;
    private h gyx;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.gPq = true;
        this.gPs = 1;
        this.gMr = aVar;
        this.gyx = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gPi = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.gPm = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.gPi.setAdapter((ListAdapter) this.gPm);
        this.gPi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (d.this.gPm.bwt() != i || i == d.this.gPs) {
                    d.this.gPt = i;
                    d.this.h(i, view2);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public boolean bxk() {
        return !TextUtils.isEmpty(this.gPw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view2) {
        MusicData musicData = (MusicData) this.gPm.getItem(i);
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
                    this.gPm.um(i);
                    bgx();
                    this.gMr.replay();
                    return;
                case 2:
                    this.gPs = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cj(String str, String str2) {
        this.gPv = false;
        this.gPt = this.gPs;
        this.gPw = str2;
        aN(str, this.gPs);
    }

    private void a(final int i, View view2, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gPw = musicData.id;
            this.gMr.bws();
            String tX = com.baidu.tieba.video.editvideo.model.a.bwL().tX(musicData.resource);
            if (TextUtils.isEmpty(tX)) {
                if (view2 != null) {
                    final c.a aVar = (c.a) view2.getTag();
                    aVar.gLU.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bwL().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void ci(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.gLU.setVisibility(4);
                            d.this.aN(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void tO(String str) {
                            aVar.gLU.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gyx != null) {
                                d.this.gyx.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                        public void bvZ() {
                            aVar.gLU.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bwL().a(musicData.id, musicData.resource, new a.InterfaceC0223a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aN(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void tO(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gyx != null) {
                            d.this.gyx.ae(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0223a
                    public void bvZ() {
                    }
                });
                return;
            }
            aN(tX, i);
        }
    }

    public void replay() {
        this.gPv = false;
        if (this.gLL != null && this.gLL.isPlaying()) {
            this.gLL.pause();
        }
        if (this.gLL != null) {
            this.gLL.start();
            this.gLL.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, final int i) {
        this.gPu = i;
        if (this.gPt == this.gPu && !this.gPv) {
            if (this.gLL == null) {
                this.gLL = new MediaPlayer();
                this.gLL.setAudioStreamType(3);
            }
            try {
                this.gPr = str;
                this.gLL.reset();
                this.gLL.setDataSource(str);
                this.gLL.prepare();
                this.gLL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.gPm.um(i);
                        d.this.gLL.setLooping(true);
                        d.this.gLL.start();
                        d.this.gMr.replay();
                    }
                });
                this.gLL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gyx != null) {
                            d.this.gyx.ae(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aO(str, i);
                if (this.gyx != null) {
                    this.gyx.ae(208, com.baidu.tieba.j.a.g(e));
                }
            }
        }
    }

    private void aO(String str, int i) {
        this.gPr = null;
        bgx();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bwL().bwM();
        }
        a(i, this.gPi.getChildCount() > i ? this.gPi.getChildAt(i) : null, (MusicData) this.gPm.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.gPm.setData(list);
        if (this.gPm != null) {
            this.gPu = this.gPm.bwt();
            this.gPt = this.gPu;
        }
    }

    public String bxi() {
        return this.gPr;
    }

    public String bxj() {
        return this.gPw;
    }

    public void by(View view2) {
        this.gPn = (LinearLayout) view2.findViewById(d.g.video_voice_layout);
        this.gPo = (ImageView) view2.findViewById(d.g.video_voice_img);
        this.gPp = (TextView) view2.findViewById(d.g.video_voice_text);
        this.gPn.setVisibility(8);
        this.gPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                d.this.gPq = !d.this.gPq;
                if (d.this.gPq) {
                    d.this.gPo.setSelected(false);
                    d.this.gPp.setText(d.this.mResources.getString(d.k.video_voice_open));
                } else {
                    d.this.gPo.setSelected(true);
                    d.this.gPp.setText(d.this.mResources.getString(d.k.video_voice_close));
                }
                d.this.gMr.setMute(!d.this.gPq);
                d.this.replay();
                al alVar = new al("c12423");
                alVar.r("obj_type", d.this.gPq ? 0 : 1);
                TiebaStatic.log(alVar);
            }
        });
        if (this.gPq) {
            this.gPo.setSelected(false);
            this.gPp.setText(this.mResources.getString(d.k.video_voice_open));
            return;
        }
        this.gPo.setSelected(true);
        this.gPp.setText(this.mResources.getString(d.k.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
        if (z) {
            this.gPn.setVisibility(0);
            if (this.gPx && this.gLL == null && !TextUtils.isEmpty(this.gPr)) {
                aN(this.gPr, this.gPu);
                this.gPx = false;
                if (this.gPu > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.gPi.setSelection(d.this.gPu);
                            d.this.gPi.dg(d.this.gPt * l.e(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.gPn.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gPv = true;
        if (this.gLL != null && this.gLL.isPlaying()) {
            this.gLL.pause();
        }
    }

    public void onResume() {
        this.gPv = false;
        if (this.gLL != null && this.gMr.mCurrentTabIndex == 2) {
            this.gLL.start();
            this.gLL.seekTo(0);
        }
    }

    private void bgx() {
        if (this.gLL != null) {
            if (this.gLL.isPlaying()) {
                this.gLL.stop();
            }
            this.gLL.release();
            this.gLL = null;
        }
        this.gPr = null;
        this.gPw = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.gPx = true;
            this.gPw = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.gPr = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.gPm != null) {
                this.gPm.tU(this.gPw);
                this.gPu = this.gPm.bwt();
                this.gPs = this.gPu;
                this.gPt = this.gPu;
            }
        }
    }
}
