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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes10.dex */
public class e extends com.baidu.adp.base.c {
    private h lHf;
    private a lVY;
    private MediaPlayer lVs;
    private HorizontalListView lYO;
    private com.baidu.tieba.video.editvideo.a.c lYS;
    private LinearLayout lYT;
    private ImageView lYU;
    private TextView lYV;
    private boolean lYW;
    private String lYX;
    private int lYY;
    private int lYZ;
    private int lZa;
    private boolean lZb;
    private String lZc;
    private boolean lZd;
    private String lZe;
    private String lZf;
    private Resources mResources;
    private View mRootView;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.lYW = true;
        this.lYY = 1;
        this.lVY = aVar;
        this.lHf = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lYO = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.lYS = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.lYO.setAdapter((ListAdapter) this.lYS);
        this.lYO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.lYS.dmL() != i || i == e.this.lYY) {
                    e.this.lYZ = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dny() {
        return !TextUtils.isEmpty(this.lZc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.lYS.getItem(i);
        if (musicData != null) {
            ao aoVar = new ao("c12423");
            aoVar.dk("obj_id", musicData.id);
            aoVar.ag("obj_locate", i + 1);
            aoVar.ag("obj_source", 2);
            TiebaStatic.log(aoVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.lYS.FZ(i);
                    aKF();
                    this.lVY.replay();
                    return;
                case 2:
                    this.lYY = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fH(String str, String str2) {
        this.lZb = false;
        this.lYZ = this.lYY;
        this.lZc = str2;
        bH(str, this.lYY);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.lZc = musicData.id;
            this.lVY.dmK();
            String Ob = com.baidu.tieba.video.editvideo.model.a.dna().Ob(musicData.resource);
            if (TextUtils.isEmpty(Ob)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lVB.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dna().a(musicData.id, musicData.resource, new a.InterfaceC0752a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                        public void fE(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lVB.setVisibility(4);
                            e.this.bH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                        public void NV(String str) {
                            aVar.lVB.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.lHf != null) {
                                e.this.lHf.bp(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                        public void dmt() {
                            aVar.lVB.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dna().a(musicData.id, musicData.resource, new a.InterfaceC0752a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void fE(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void NV(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.lHf != null) {
                            e.this.lHf.bp(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0752a
                    public void dmt() {
                    }
                });
                return;
            }
            bH(Ob, i);
        }
    }

    public void replay() {
        this.lZb = false;
        if (this.lVs != null && this.lVs.isPlaying()) {
            this.lVs.pause();
        }
        if (this.lVs != null) {
            this.lVs.start();
            this.lVs.seekTo(0);
        }
    }

    public void fI(String str, String str2) {
        this.lZe = str;
        this.lZf = str2;
        dnE();
    }

    private void dnE() {
        if (!ar.isEmpty(this.lZf) && !ar.isEmpty(this.lZe)) {
            List<MusicData> data = this.lYS.getData();
            if (!w.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !ar.equals(data.get(i2).id, this.lZf)) {
                            i = i2 + 1;
                        } else {
                            Gc(i2);
                            return;
                        }
                    } else {
                        Gc(1);
                        return;
                    }
                }
            }
        }
    }

    private void Gc(final int i) {
        if (!ar.isEmpty(this.lZe)) {
            this.lZa = i;
            if (this.lVs == null) {
                this.lVs = new MediaPlayer();
                this.lVs.setAudioStreamType(3);
            }
            try {
                this.lZc = this.lZf;
                this.lYX = this.lZe;
                this.lVs.reset();
                this.lVs.setDataSource(this.lZe);
                this.lVs.prepare();
                this.lVs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.lYS.FZ(i);
                        e.this.lVs.setLooping(true);
                    }
                });
                this.lVs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lHf != null) {
                            e.this.lHf.bp(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bI(this.lYX, i);
                if (this.lHf != null) {
                    this.lHf.bp(208, com.baidu.tieba.k.a.t(e));
                }
            } finally {
                this.lZf = null;
                this.lZe = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, final int i) {
        this.lZa = i;
        if (this.lYZ == this.lZa && !this.lZb) {
            if (this.lVs == null) {
                this.lVs = new MediaPlayer();
                this.lVs.setAudioStreamType(3);
            }
            try {
                this.lYX = str;
                this.lVs.reset();
                this.lVs.setDataSource(str);
                this.lVs.prepare();
                this.lVs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.lYS.FZ(i);
                        e.this.lVs.setLooping(true);
                        e.this.lVs.start();
                        e.this.lVY.replay();
                    }
                });
                this.lVs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lHf != null) {
                            e.this.lHf.bp(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bI(str, i);
                if (this.lHf != null) {
                    this.lHf.bp(208, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    private void bI(String str, int i) {
        this.lYX = null;
        aKF();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dna().dnb();
        }
        a(i, this.lYO.getChildCount() > i ? this.lYO.getChildAt(i) : null, (MusicData) this.lYS.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.lYS.setData(list);
        if (this.lYS != null) {
            this.lZa = this.lYS.dmL();
            this.lYZ = this.lZa;
        }
        dnE();
    }

    public String dnw() {
        return this.lYX;
    }

    public String dnx() {
        return this.lZc;
    }

    public void dg(View view) {
        this.lYT = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.lYU = (ImageView) view.findViewById(R.id.video_voice_img);
        this.lYV = (TextView) view.findViewById(R.id.video_voice_text);
        this.lYT.setVisibility(8);
        this.lYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.vl(!e.this.lYW);
                e.this.lVY.setMute(!e.this.lYW);
                e.this.replay();
                ao aoVar = new ao("c12423");
                aoVar.ag("obj_type", e.this.lYW ? 0 : 1);
                TiebaStatic.log(aoVar);
            }
        });
        vl(this.lYW);
        this.lVY.setMute(!this.lYW);
    }

    public void vl(boolean z) {
        this.lYW = z;
        if (this.lYW) {
            this.lYU.setSelected(false);
            this.lYV.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.lYU.setSelected(true);
        this.lYV.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vj(boolean z) {
        if (z) {
            this.lYT.setVisibility(0);
            if (this.lZd && this.lVs == null && !TextUtils.isEmpty(this.lYX)) {
                bH(this.lYX, this.lZa);
                this.lZd = false;
                if (this.lZa > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.lYO.setSelection(e.this.lZa);
                            e.this.lYO.scrollTo(e.this.lYZ * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.lYT.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.lZb = true;
        if (this.lVs != null && this.lVs.isPlaying()) {
            this.lVs.pause();
        }
    }

    public void onResume() {
        this.lZb = false;
        if (this.lVs != null && this.lVY.mCurrentTabIndex == 2) {
            this.lVs.start();
            this.lVs.seekTo(0);
        }
    }

    private void aKF() {
        if (this.lVs != null) {
            if (this.lVs.isPlaying()) {
                this.lVs.stop();
            }
            this.lVs.release();
            this.lVs = null;
        }
        this.lYX = null;
        this.lZc = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.lZd = true;
            this.lZc = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.lYX = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.lYS != null) {
                this.lYS.NZ(this.lZc);
                this.lZa = this.lYS.dmL();
                this.lYY = this.lZa;
                this.lYZ = this.lZa;
            }
        }
    }
}
