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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes23.dex */
public class e extends com.baidu.adp.base.c {
    private h mFB;
    private Resources mResources;
    private View mRootView;
    private a mUV;
    private MediaPlayer mUp;
    private HorizontalListView mXJ;
    private com.baidu.tieba.video.editvideo.a.c mXN;
    private LinearLayout mXO;
    private ImageView mXP;
    private TextView mXQ;
    private boolean mXR;
    private String mXS;
    private int mXT;
    private int mXU;
    private int mXV;
    private boolean mXW;
    private String mXX;
    private boolean mXY;
    private String mXZ;
    private String mYa;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.mXR = true;
        this.mXT = 1;
        this.mUV = aVar;
        this.mFB = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mXJ = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mXN = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mXJ.setAdapter((ListAdapter) this.mXN);
        this.mXJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.mXN.dJk() != i || i == e.this.mXT) {
                    e.this.mXU = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dJW() {
        return !TextUtils.isEmpty(this.mXX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.mXN.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dK("obj_id", musicData.id);
            aqVar.aj("obj_locate", i + 1);
            aqVar.aj("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.mXN.Kb(i);
                    bal();
                    this.mUV.replay();
                    return;
                case 2:
                    this.mXT = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gu(String str, String str2) {
        this.mXW = false;
        this.mXU = this.mXT;
        this.mXX = str2;
        bL(str, this.mXT);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.mXX = musicData.id;
            this.mUV.dJj();
            String SW = com.baidu.tieba.video.editvideo.model.a.dJz().SW(musicData.resource);
            if (TextUtils.isEmpty(SW)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.mUy.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dJz().a(musicData.id, musicData.resource, new a.InterfaceC0830a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                        public void gr(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.mUy.setVisibility(4);
                            e.this.bL(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                        public void SQ(String str) {
                            aVar.mUy.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mFB != null) {
                                e.this.mFB.bC(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                        public void dIT() {
                            aVar.mUy.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dJz().a(musicData.id, musicData.resource, new a.InterfaceC0830a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void gr(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bL(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void SQ(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mFB != null) {
                            e.this.mFB.bC(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0830a
                    public void dIT() {
                    }
                });
                return;
            }
            bL(SW, i);
        }
    }

    public void replay() {
        this.mXW = false;
        if (this.mUp != null && this.mUp.isPlaying()) {
            this.mUp.pause();
        }
        if (this.mUp != null) {
            this.mUp.start();
            this.mUp.seekTo(0);
        }
    }

    public void gv(String str, String str2) {
        this.mXZ = str;
        this.mYa = str2;
        dKc();
    }

    private void dKc() {
        if (!at.isEmpty(this.mYa) && !at.isEmpty(this.mXZ)) {
            List<MusicData> data = this.mXN.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.mYa)) {
                            i = i2 + 1;
                        } else {
                            Ke(i2);
                            return;
                        }
                    } else {
                        Ke(1);
                        return;
                    }
                }
            }
        }
    }

    private void Ke(final int i) {
        if (!at.isEmpty(this.mXZ)) {
            this.mXV = i;
            if (this.mUp == null) {
                this.mUp = new MediaPlayer();
                this.mUp.setAudioStreamType(3);
            }
            try {
                this.mXX = this.mYa;
                this.mXS = this.mXZ;
                this.mUp.reset();
                this.mUp.setDataSource(this.mXZ);
                this.mUp.prepare();
                this.mUp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mXN.Kb(i);
                        e.this.mUp.setLooping(true);
                    }
                });
                this.mUp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mFB != null) {
                            e.this.mFB.bC(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bM(this.mXS, i);
                if (this.mFB != null) {
                    this.mFB.bC(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.mYa = null;
                this.mXZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(String str, final int i) {
        this.mXV = i;
        if (this.mXU == this.mXV && !this.mXW) {
            if (this.mUp == null) {
                this.mUp = new MediaPlayer();
                this.mUp.setAudioStreamType(3);
            }
            try {
                this.mXS = str;
                this.mUp.reset();
                this.mUp.setDataSource(str);
                this.mUp.prepare();
                this.mUp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mXN.Kb(i);
                        e.this.mUp.setLooping(true);
                        e.this.mUp.start();
                        e.this.mUV.replay();
                    }
                });
                this.mUp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mFB != null) {
                            e.this.mFB.bC(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bM(str, i);
                if (this.mFB != null) {
                    this.mFB.bC(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bM(String str, int i) {
        this.mXS = null;
        bal();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dJz().dJA();
        }
        a(i, this.mXJ.getChildCount() > i ? this.mXJ.getChildAt(i) : null, (MusicData) this.mXN.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.mXN.setData(list);
        if (this.mXN != null) {
            this.mXV = this.mXN.dJk();
            this.mXU = this.mXV;
        }
        dKc();
    }

    public String dJU() {
        return this.mXS;
    }

    public String dJV() {
        return this.mXX;
    }

    public void dD(View view) {
        this.mXO = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mXP = (ImageView) view.findViewById(R.id.video_voice_img);
        this.mXQ = (TextView) view.findViewById(R.id.video_voice_text);
        this.mXO.setVisibility(8);
        this.mXO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.xw(!e.this.mXR);
                e.this.mUV.setMute(!e.this.mXR);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.aj("obj_type", e.this.mXR ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        xw(this.mXR);
        this.mUV.setMute(!this.mXR);
    }

    public void xw(boolean z) {
        this.mXR = z;
        if (this.mXR) {
            this.mXP.setSelected(false);
            this.mXQ.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mXP.setSelected(true);
        this.mXQ.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xu(boolean z) {
        if (z) {
            this.mXO.setVisibility(0);
            if (this.mXY && this.mUp == null && !TextUtils.isEmpty(this.mXS)) {
                bL(this.mXS, this.mXV);
                this.mXY = false;
                if (this.mXV > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mXJ.setSelection(e.this.mXV);
                            e.this.mXJ.scrollTo(e.this.mXU * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.mXO.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.mXW = true;
        if (this.mUp != null && this.mUp.isPlaying()) {
            this.mUp.pause();
        }
    }

    public void onResume() {
        this.mXW = false;
        if (this.mUp != null && this.mUV.mCurrentTabIndex == 2) {
            this.mUp.start();
            this.mUp.seekTo(0);
        }
    }

    private void bal() {
        if (this.mUp != null) {
            if (this.mUp.isPlaying()) {
                this.mUp.stop();
            }
            this.mUp.release();
            this.mUp = null;
        }
        this.mXS = null;
        this.mXX = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.mXY = true;
            this.mXX = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.mXS = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.mXN != null) {
                this.mXN.SU(this.mXX);
                this.mXV = this.mXN.dJk();
                this.mXT = this.mXV;
                this.mXU = this.mXV;
            }
        }
    }
}
