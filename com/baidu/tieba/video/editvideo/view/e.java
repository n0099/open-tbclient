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
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c {
    private MediaPlayer mEB;
    private a mFi;
    private HorizontalListView mHY;
    private com.baidu.tieba.video.editvideo.a.c mIc;
    private LinearLayout mIe;
    private ImageView mIf;
    private TextView mIg;
    private boolean mIh;
    private String mIi;
    private int mIj;
    private int mIk;
    private int mIl;
    private boolean mIm;
    private String mIn;
    private boolean mIo;
    private String mIq;
    private String mIr;
    private Resources mResources;
    private View mRootView;
    private h mpU;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.mIh = true;
        this.mIj = 1;
        this.mFi = aVar;
        this.mpU = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mHY = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mIc = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mHY.setAdapter((ListAdapter) this.mIc);
        this.mHY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.mIc.dFy() != i || i == e.this.mIj) {
                    e.this.mIk = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dGk() {
        return !TextUtils.isEmpty(this.mIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.mIc.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dF("obj_id", musicData.id);
            aqVar.ai("obj_locate", i + 1);
            aqVar.ai("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.mIc.Jv(i);
                    aXD();
                    this.mFi.replay();
                    return;
                case 2:
                    this.mIj = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gn(String str, String str2) {
        this.mIm = false;
        this.mIk = this.mIj;
        this.mIn = str2;
        bK(str, this.mIj);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.mIn = musicData.id;
            this.mFi.dFx();
            String Si = com.baidu.tieba.video.editvideo.model.a.dFN().Si(musicData.resource);
            if (TextUtils.isEmpty(Si)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.mEK.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dFN().a(musicData.id, musicData.resource, new a.InterfaceC0812a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                        public void gk(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.mEK.setVisibility(4);
                            e.this.bK(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                        public void Sc(String str) {
                            aVar.mEK.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mpU != null) {
                                e.this.mpU.bs(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                        public void dFh() {
                            aVar.mEK.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dFN().a(musicData.id, musicData.resource, new a.InterfaceC0812a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void gk(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bK(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void Sc(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mpU != null) {
                            e.this.mpU.bs(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0812a
                    public void dFh() {
                    }
                });
                return;
            }
            bK(Si, i);
        }
    }

    public void replay() {
        this.mIm = false;
        if (this.mEB != null && this.mEB.isPlaying()) {
            this.mEB.pause();
        }
        if (this.mEB != null) {
            this.mEB.start();
            this.mEB.seekTo(0);
        }
    }

    public void go(String str, String str2) {
        this.mIq = str;
        this.mIr = str2;
        dGq();
    }

    private void dGq() {
        if (!at.isEmpty(this.mIr) && !at.isEmpty(this.mIq)) {
            List<MusicData> data = this.mIc.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.mIr)) {
                            i = i2 + 1;
                        } else {
                            Jy(i2);
                            return;
                        }
                    } else {
                        Jy(1);
                        return;
                    }
                }
            }
        }
    }

    private void Jy(final int i) {
        if (!at.isEmpty(this.mIq)) {
            this.mIl = i;
            if (this.mEB == null) {
                this.mEB = new MediaPlayer();
                this.mEB.setAudioStreamType(3);
            }
            try {
                this.mIn = this.mIr;
                this.mIi = this.mIq;
                this.mEB.reset();
                this.mEB.setDataSource(this.mIq);
                this.mEB.prepare();
                this.mEB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mIc.Jv(i);
                        e.this.mEB.setLooping(true);
                    }
                });
                this.mEB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mpU != null) {
                            e.this.mpU.bs(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(this.mIi, i);
                if (this.mpU != null) {
                    this.mpU.bs(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.mIr = null;
                this.mIq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(String str, final int i) {
        this.mIl = i;
        if (this.mIk == this.mIl && !this.mIm) {
            if (this.mEB == null) {
                this.mEB = new MediaPlayer();
                this.mEB.setAudioStreamType(3);
            }
            try {
                this.mIi = str;
                this.mEB.reset();
                this.mEB.setDataSource(str);
                this.mEB.prepare();
                this.mEB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mIc.Jv(i);
                        e.this.mEB.setLooping(true);
                        e.this.mEB.start();
                        e.this.mFi.replay();
                    }
                });
                this.mEB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mpU != null) {
                            e.this.mpU.bs(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(str, i);
                if (this.mpU != null) {
                    this.mpU.bs(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bL(String str, int i) {
        this.mIi = null;
        aXD();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dFN().dFO();
        }
        a(i, this.mHY.getChildCount() > i ? this.mHY.getChildAt(i) : null, (MusicData) this.mIc.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.mIc.setData(list);
        if (this.mIc != null) {
            this.mIl = this.mIc.dFy();
            this.mIk = this.mIl;
        }
        dGq();
    }

    public String dGi() {
        return this.mIi;
    }

    public String dGj() {
        return this.mIn;
    }

    public void dz(View view) {
        this.mIe = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mIf = (ImageView) view.findViewById(R.id.video_voice_img);
        this.mIg = (TextView) view.findViewById(R.id.video_voice_text);
        this.mIe.setVisibility(8);
        this.mIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.wP(!e.this.mIh);
                e.this.mFi.setMute(!e.this.mIh);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.ai("obj_type", e.this.mIh ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        wP(this.mIh);
        this.mFi.setMute(!this.mIh);
    }

    public void wP(boolean z) {
        this.mIh = z;
        if (this.mIh) {
            this.mIf.setSelected(false);
            this.mIg.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mIf.setSelected(true);
        this.mIg.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wN(boolean z) {
        if (z) {
            this.mIe.setVisibility(0);
            if (this.mIo && this.mEB == null && !TextUtils.isEmpty(this.mIi)) {
                bK(this.mIi, this.mIl);
                this.mIo = false;
                if (this.mIl > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mHY.setSelection(e.this.mIl);
                            e.this.mHY.scrollTo(e.this.mIk * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.mIe.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.mIm = true;
        if (this.mEB != null && this.mEB.isPlaying()) {
            this.mEB.pause();
        }
    }

    public void onResume() {
        this.mIm = false;
        if (this.mEB != null && this.mFi.mCurrentTabIndex == 2) {
            this.mEB.start();
            this.mEB.seekTo(0);
        }
    }

    private void aXD() {
        if (this.mEB != null) {
            if (this.mEB.isPlaying()) {
                this.mEB.stop();
            }
            this.mEB.release();
            this.mEB = null;
        }
        this.mIi = null;
        this.mIn = null;
    }

    public void ao(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.mIo = true;
            this.mIn = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.mIi = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.mIc != null) {
                this.mIc.Sg(this.mIn);
                this.mIl = this.mIc.dFy();
                this.mIj = this.mIl;
                this.mIk = this.mIl;
            }
        }
    }
}
