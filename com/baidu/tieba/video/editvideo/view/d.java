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
    private com.baidu.tieba.video.editvideo.a.c jBA;
    private LinearLayout jBB;
    private ImageView jBC;
    private TextView jBD;
    private boolean jBE;
    private String jBF;
    private int jBG;
    private int jBH;
    private int jBI;
    private boolean jBJ;
    private String jBK;
    private boolean jBL;
    private HorizontalListView jBw;
    private h jjR;
    private a jyK;
    private MediaPlayer jye;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jBE = true;
        this.jBG = 1;
        this.jyK = aVar;
        this.jjR = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jBw = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jBA = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jBw.setAdapter((ListAdapter) this.jBA);
        this.jBw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jBA.cvr() != i || i == d.this.jBG) {
                    d.this.jBH = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cwi() {
        return !TextUtils.isEmpty(this.jBK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jBA.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            anVar.P("obj_locate", i + 1);
            anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.jBA.Cm(i);
                    aBQ();
                    this.jyK.replay();
                    return;
                case 2:
                    this.jBG = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eu(String str, String str2) {
        this.jBJ = false;
        this.jBH = this.jBG;
        this.jBK = str2;
        bt(str, this.jBG);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jBK = musicData.id;
            this.jyK.cvq();
            String Gn = com.baidu.tieba.video.editvideo.model.a.cvJ().Gn(musicData.resource);
            if (TextUtils.isEmpty(Gn)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.jyn.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cvJ().a(musicData.id, musicData.resource, new a.InterfaceC0433a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void et(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.jyn.setVisibility(4);
                            d.this.bt(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void Gf(String str) {
                            aVar.jyn.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.jjR != null) {
                                d.this.jjR.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                        public void cuX() {
                            aVar.jyn.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cvJ().a(musicData.id, musicData.resource, new a.InterfaceC0433a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void et(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bt(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void Gf(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.jjR != null) {
                            d.this.jjR.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0433a
                    public void cuX() {
                    }
                });
                return;
            }
            bt(Gn, i);
        }
    }

    public void replay() {
        this.jBJ = false;
        if (this.jye != null && this.jye.isPlaying()) {
            this.jye.pause();
        }
        if (this.jye != null) {
            this.jye.start();
            this.jye.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(String str, final int i) {
        this.jBI = i;
        if (this.jBH == this.jBI && !this.jBJ) {
            if (this.jye == null) {
                this.jye = new MediaPlayer();
                this.jye.setAudioStreamType(3);
            }
            try {
                this.jBF = str;
                this.jye.reset();
                this.jye.setDataSource(str);
                this.jye.prepare();
                this.jye.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jBA.Cm(i);
                        d.this.jye.setLooping(true);
                        d.this.jye.start();
                        d.this.jyK.replay();
                    }
                });
                this.jye.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.jjR != null) {
                            d.this.jjR.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bu(str, i);
                if (this.jjR != null) {
                    this.jjR.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bu(String str, int i) {
        this.jBF = null;
        aBQ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cvJ().cvK();
        }
        a(i, this.jBw.getChildCount() > i ? this.jBw.getChildAt(i) : null, (MusicData) this.jBA.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jBA.setData(list);
        if (this.jBA != null) {
            this.jBI = this.jBA.cvr();
            this.jBH = this.jBI;
        }
    }

    public String cwg() {
        return this.jBF;
    }

    public String cwh() {
        return this.jBK;
    }

    public void cX(View view) {
        this.jBB = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jBC = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jBD = (TextView) view.findViewById(R.id.video_voice_text);
        this.jBB.setVisibility(8);
        this.jBB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jBE = !d.this.jBE;
                if (d.this.jBE) {
                    d.this.jBC.setSelected(false);
                    d.this.jBD.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jBC.setSelected(true);
                    d.this.jBD.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jyK.setMute(!d.this.jBE);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.P("obj_type", d.this.jBE ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.jBE) {
            this.jBC.setSelected(false);
            this.jBD.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jBC.setSelected(true);
        this.jBD.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rI(boolean z) {
        if (z) {
            this.jBB.setVisibility(0);
            if (this.jBL && this.jye == null && !TextUtils.isEmpty(this.jBF)) {
                bt(this.jBF, this.jBI);
                this.jBL = false;
                if (this.jBI > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jBw.setSelection(d.this.jBI);
                            d.this.jBw.scrollTo(d.this.jBH * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jBB.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jBJ = true;
        if (this.jye != null && this.jye.isPlaying()) {
            this.jye.pause();
        }
    }

    public void onResume() {
        this.jBJ = false;
        if (this.jye != null && this.jyK.mCurrentTabIndex == 2) {
            this.jye.start();
            this.jye.seekTo(0);
        }
    }

    private void aBQ() {
        if (this.jye != null) {
            if (this.jye.isPlaying()) {
                this.jye.stop();
            }
            this.jye.release();
            this.jye = null;
        }
        this.jBF = null;
        this.jBK = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jBL = true;
            this.jBK = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jBF = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jBA != null) {
                this.jBA.Gl(this.jBK);
                this.jBI = this.jBA.cvr();
                this.jBG = this.jBI;
                this.jBH = this.jBI;
            }
        }
    }
}
