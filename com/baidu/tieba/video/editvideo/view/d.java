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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gZj;
    private a hnN;
    private MediaPlayer hng;
    private HorizontalListView hqH;
    private com.baidu.tieba.video.editvideo.a.c hqL;
    private LinearLayout hqM;
    private ImageView hqN;
    private TextView hqO;
    private boolean hqP;
    private String hqQ;
    private int hqR;
    private int hqS;
    private int hqT;
    private boolean hqU;
    private String hqV;
    private boolean hqW;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hqP = true;
        this.hqR = 1;
        this.hnN = aVar;
        this.gZj = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hqH = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hqL = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hqH.setAdapter((ListAdapter) this.hqL);
        this.hqH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hqL.bAA() != i || i == d.this.hqR) {
                    d.this.hqS = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0107d.cp_bg_line_d);
    }

    public boolean bBs() {
        return this.hng != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hqL.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ab("obj_id", musicData.id);
            akVar.s("obj_locate", i + 1);
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hqL.wL(i);
                    bkd();
                    this.hnN.replay();
                    return;
                case 2:
                    this.hqR = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cj(String str, String str2) {
        this.hqU = false;
        this.hqS = this.hqR;
        this.hqV = str2;
        aL(str, this.hqR);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hqV = musicData.id;
            this.hnN.bAz();
            String tB = com.baidu.tieba.video.editvideo.model.a.bAT().tB(musicData.resource);
            if (TextUtils.isEmpty(tB)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hnq.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bAT().a(musicData.id, musicData.resource, new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void ci(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hnq.setVisibility(4);
                            d.this.aL(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void ts(String str) {
                            aVar.hnq.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gZj != null) {
                                d.this.gZj.T(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                        public void bAg() {
                            aVar.hnq.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bAT().a(musicData.id, musicData.resource, new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aL(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void ts(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gZj != null) {
                            d.this.gZj.T(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0159a
                    public void bAg() {
                    }
                });
                return;
            }
            aL(tB, i);
        }
    }

    public void replay() {
        this.hqU = false;
        if (this.hng != null && this.hng.isPlaying()) {
            this.hng.pause();
        }
        if (this.hng != null) {
            this.hng.start();
            this.hng.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(String str, final int i) {
        this.hqT = i;
        if (this.hqS == this.hqT && !this.hqU) {
            if (this.hng == null) {
                this.hng = new MediaPlayer();
                this.hng.setAudioStreamType(3);
            }
            try {
                this.hqQ = str;
                this.hng.reset();
                this.hng.setDataSource(str);
                this.hng.prepare();
                this.hng.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hqL.wL(i);
                        d.this.hng.setLooping(true);
                        d.this.hng.start();
                        d.this.hnN.replay();
                    }
                });
                this.hng.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gZj != null) {
                            d.this.gZj.T(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aM(str, i);
                if (this.gZj != null) {
                    this.gZj.T(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aM(String str, int i) {
        this.hqQ = null;
        bkd();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bAT().bAU();
        }
        a(i, this.hqH.getChildCount() > i ? this.hqH.getChildAt(i) : null, (MusicData) this.hqL.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hqL.setData(list);
        if (this.hqL != null) {
            this.hqT = this.hqL.bAA();
            this.hqS = this.hqT;
        }
    }

    public String bBq() {
        return this.hqQ;
    }

    public String bBr() {
        return this.hqV;
    }

    public void cT(View view) {
        this.hqM = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hqN = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hqO = (TextView) view.findViewById(d.g.video_voice_text);
        this.hqM.setVisibility(8);
        this.hqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hqP = !d.this.hqP;
                if (d.this.hqP) {
                    d.this.hqN.setSelected(false);
                    d.this.hqO.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hqN.setSelected(true);
                    d.this.hqO.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hnN.setMute(!d.this.hqP);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hqP ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hqP) {
            this.hqN.setSelected(false);
            this.hqO.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hqN.setSelected(true);
        this.hqO.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nb(boolean z) {
        if (z) {
            this.hqM.setVisibility(0);
            if (this.hqW && this.hng == null && !TextUtils.isEmpty(this.hqQ)) {
                aL(this.hqQ, this.hqT);
                this.hqW = false;
                if (this.hqT > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hqH.setSelection(d.this.hqT);
                            d.this.hqH.ge(d.this.hqS * l.s(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hqM.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hqU = true;
        if (this.hng != null && this.hng.isPlaying()) {
            this.hng.pause();
        }
    }

    public void onResume() {
        this.hqU = false;
        if (this.hng != null && this.hnN.mCurrentTabIndex == 2) {
            this.hng.start();
            this.hng.seekTo(0);
        }
    }

    private void bkd() {
        if (this.hng != null) {
            if (this.hng.isPlaying()) {
                this.hng.stop();
            }
            this.hng.release();
            this.hng = null;
        }
        this.hqQ = null;
        this.hqV = null;
    }

    public void ad(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hqW = true;
            this.hqV = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hqQ = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hqL != null) {
                this.hqL.ty(this.hqV);
                this.hqT = this.hqL.bAA();
                this.hqR = this.hqT;
                this.hqS = this.hqT;
            }
        }
    }
}
