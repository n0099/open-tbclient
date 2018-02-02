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
    private h gZD;
    private MediaPlayer hnA;
    private a hoh;
    private HorizontalListView hrb;
    private com.baidu.tieba.video.editvideo.a.c hrf;
    private LinearLayout hrg;
    private ImageView hrh;
    private TextView hri;
    private boolean hrj;
    private String hrk;
    private int hrl;
    private int hrm;
    private int hrn;
    private boolean hro;
    private String hrp;
    private boolean hrq;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hrj = true;
        this.hrl = 1;
        this.hoh = aVar;
        this.gZD = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hrb = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.hrf = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hrb.setAdapter((ListAdapter) this.hrf);
        this.hrb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hrf.bAC() != i || i == d.this.hrl) {
                    d.this.hrm = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
    }

    public boolean bBu() {
        return this.hnA != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hrf.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.aa("obj_id", musicData.id);
            akVar.s("obj_locate", i + 1);
            akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hrf.wL(i);
                    bke();
                    this.hoh.replay();
                    return;
                case 2:
                    this.hrl = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ci(String str, String str2) {
        this.hro = false;
        this.hrm = this.hrl;
        this.hrp = str2;
        aL(str, this.hrl);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hrp = musicData.id;
            this.hoh.bAB();
            String tJ = com.baidu.tieba.video.editvideo.model.a.bAV().tJ(musicData.resource);
            if (TextUtils.isEmpty(tJ)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hnK.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bAV().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void ch(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hnK.setVisibility(4);
                            d.this.aL(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void tA(String str) {
                            aVar.hnK.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gZD != null) {
                                d.this.gZD.V(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                        public void bAi() {
                            aVar.hnK.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bAV().a(musicData.id, musicData.resource, new a.InterfaceC0160a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void ch(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aL(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void tA(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gZD != null) {
                            d.this.gZD.V(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0160a
                    public void bAi() {
                    }
                });
                return;
            }
            aL(tJ, i);
        }
    }

    public void replay() {
        this.hro = false;
        if (this.hnA != null && this.hnA.isPlaying()) {
            this.hnA.pause();
        }
        if (this.hnA != null) {
            this.hnA.start();
            this.hnA.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(String str, final int i) {
        this.hrn = i;
        if (this.hrm == this.hrn && !this.hro) {
            if (this.hnA == null) {
                this.hnA = new MediaPlayer();
                this.hnA.setAudioStreamType(3);
            }
            try {
                this.hrk = str;
                this.hnA.reset();
                this.hnA.setDataSource(str);
                this.hnA.prepare();
                this.hnA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hrf.wL(i);
                        d.this.hnA.setLooping(true);
                        d.this.hnA.start();
                        d.this.hoh.replay();
                    }
                });
                this.hnA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gZD != null) {
                            d.this.gZD.V(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aM(str, i);
                if (this.gZD != null) {
                    this.gZD.V(208, com.baidu.tieba.i.a.i(e));
                }
            }
        }
    }

    private void aM(String str, int i) {
        this.hrk = null;
        bke();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bAV().bAW();
        }
        a(i, this.hrb.getChildCount() > i ? this.hrb.getChildAt(i) : null, (MusicData) this.hrf.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hrf.setData(list);
        if (this.hrf != null) {
            this.hrn = this.hrf.bAC();
            this.hrm = this.hrn;
        }
    }

    public String bBs() {
        return this.hrk;
    }

    public String bBt() {
        return this.hrp;
    }

    public void cT(View view) {
        this.hrg = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.hrh = (ImageView) view.findViewById(d.g.video_voice_img);
        this.hri = (TextView) view.findViewById(d.g.video_voice_text);
        this.hrg.setVisibility(8);
        this.hrg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hrj = !d.this.hrj;
                if (d.this.hrj) {
                    d.this.hrh.setSelected(false);
                    d.this.hri.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.hrh.setSelected(true);
                    d.this.hri.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.hoh.setMute(!d.this.hrj);
                d.this.replay();
                ak akVar = new ak("c12423");
                akVar.s("obj_type", d.this.hrj ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.hrj) {
            this.hrh.setSelected(false);
            this.hri.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.hrh.setSelected(true);
        this.hri.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ne(boolean z) {
        if (z) {
            this.hrg.setVisibility(0);
            if (this.hrq && this.hnA == null && !TextUtils.isEmpty(this.hrk)) {
                aL(this.hrk, this.hrn);
                this.hrq = false;
                if (this.hrn > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hrb.setSelection(d.this.hrn);
                            d.this.hrb.ge(d.this.hrm * l.s(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hrg.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hro = true;
        if (this.hnA != null && this.hnA.isPlaying()) {
            this.hnA.pause();
        }
    }

    public void onResume() {
        this.hro = false;
        if (this.hnA != null && this.hoh.mCurrentTabIndex == 2) {
            this.hnA.start();
            this.hnA.seekTo(0);
        }
    }

    private void bke() {
        if (this.hnA != null) {
            if (this.hnA.isPlaying()) {
                this.hnA.stop();
            }
            this.hnA.release();
            this.hnA = null;
        }
        this.hrk = null;
        this.hrp = null;
    }

    public void ad(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hrq = true;
            this.hrp = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hrk = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hrf != null) {
                this.hrf.tG(this.hrp);
                this.hrn = this.hrf.bAC();
                this.hrl = this.hrn;
                this.hrm = this.hrn;
            }
        }
    }
}
