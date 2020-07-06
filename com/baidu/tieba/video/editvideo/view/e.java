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
    private MediaPlayer lVv;
    private a lWb;
    private HorizontalListView lYR;
    private com.baidu.tieba.video.editvideo.a.c lYV;
    private LinearLayout lYW;
    private ImageView lYX;
    private TextView lYY;
    private boolean lYZ;
    private String lZa;
    private int lZb;
    private int lZc;
    private int lZd;
    private boolean lZe;
    private String lZf;
    private boolean lZg;
    private String lZh;
    private String lZi;
    private Resources mResources;
    private View mRootView;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.lYZ = true;
        this.lZb = 1;
        this.lWb = aVar;
        this.lHf = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lYR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.lYV = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.lYR.setAdapter((ListAdapter) this.lYV);
        this.lYR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.lYV.dmP() != i || i == e.this.lZb) {
                    e.this.lZc = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dnC() {
        return !TextUtils.isEmpty(this.lZf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.lYV.getItem(i);
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
                    this.lYV.FZ(i);
                    aKF();
                    this.lWb.replay();
                    return;
                case 2:
                    this.lZb = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fH(String str, String str2) {
        this.lZe = false;
        this.lZc = this.lZb;
        this.lZf = str2;
        bH(str, this.lZb);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.lZf = musicData.id;
            this.lWb.dmO();
            String Oc = com.baidu.tieba.video.editvideo.model.a.dne().Oc(musicData.resource);
            if (TextUtils.isEmpty(Oc)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lVE.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dne().a(musicData.id, musicData.resource, new a.InterfaceC0753a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                        public void fE(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lVE.setVisibility(4);
                            e.this.bH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                        public void NW(String str) {
                            aVar.lVE.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.lHf != null) {
                                e.this.lHf.bp(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                        public void dmx() {
                            aVar.lVE.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dne().a(musicData.id, musicData.resource, new a.InterfaceC0753a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void fE(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void NW(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.lHf != null) {
                            e.this.lHf.bp(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0753a
                    public void dmx() {
                    }
                });
                return;
            }
            bH(Oc, i);
        }
    }

    public void replay() {
        this.lZe = false;
        if (this.lVv != null && this.lVv.isPlaying()) {
            this.lVv.pause();
        }
        if (this.lVv != null) {
            this.lVv.start();
            this.lVv.seekTo(0);
        }
    }

    public void fI(String str, String str2) {
        this.lZh = str;
        this.lZi = str2;
        dnI();
    }

    private void dnI() {
        if (!ar.isEmpty(this.lZi) && !ar.isEmpty(this.lZh)) {
            List<MusicData> data = this.lYV.getData();
            if (!w.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !ar.equals(data.get(i2).id, this.lZi)) {
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
        if (!ar.isEmpty(this.lZh)) {
            this.lZd = i;
            if (this.lVv == null) {
                this.lVv = new MediaPlayer();
                this.lVv.setAudioStreamType(3);
            }
            try {
                this.lZf = this.lZi;
                this.lZa = this.lZh;
                this.lVv.reset();
                this.lVv.setDataSource(this.lZh);
                this.lVv.prepare();
                this.lVv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.lYV.FZ(i);
                        e.this.lVv.setLooping(true);
                    }
                });
                this.lVv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
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
                bI(this.lZa, i);
                if (this.lHf != null) {
                    this.lHf.bp(208, com.baidu.tieba.k.a.t(e));
                }
            } finally {
                this.lZi = null;
                this.lZh = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, final int i) {
        this.lZd = i;
        if (this.lZc == this.lZd && !this.lZe) {
            if (this.lVv == null) {
                this.lVv = new MediaPlayer();
                this.lVv.setAudioStreamType(3);
            }
            try {
                this.lZa = str;
                this.lVv.reset();
                this.lVv.setDataSource(str);
                this.lVv.prepare();
                this.lVv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.lYV.FZ(i);
                        e.this.lVv.setLooping(true);
                        e.this.lVv.start();
                        e.this.lWb.replay();
                    }
                });
                this.lVv.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
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
        this.lZa = null;
        aKF();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dne().dnf();
        }
        a(i, this.lYR.getChildCount() > i ? this.lYR.getChildAt(i) : null, (MusicData) this.lYV.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.lYV.setData(list);
        if (this.lYV != null) {
            this.lZd = this.lYV.dmP();
            this.lZc = this.lZd;
        }
        dnI();
    }

    public String dnA() {
        return this.lZa;
    }

    public String dnB() {
        return this.lZf;
    }

    public void dg(View view) {
        this.lYW = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.lYX = (ImageView) view.findViewById(R.id.video_voice_img);
        this.lYY = (TextView) view.findViewById(R.id.video_voice_text);
        this.lYW.setVisibility(8);
        this.lYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.vl(!e.this.lYZ);
                e.this.lWb.setMute(!e.this.lYZ);
                e.this.replay();
                ao aoVar = new ao("c12423");
                aoVar.ag("obj_type", e.this.lYZ ? 0 : 1);
                TiebaStatic.log(aoVar);
            }
        });
        vl(this.lYZ);
        this.lWb.setMute(!this.lYZ);
    }

    public void vl(boolean z) {
        this.lYZ = z;
        if (this.lYZ) {
            this.lYX.setSelected(false);
            this.lYY.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.lYX.setSelected(true);
        this.lYY.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vj(boolean z) {
        if (z) {
            this.lYW.setVisibility(0);
            if (this.lZg && this.lVv == null && !TextUtils.isEmpty(this.lZa)) {
                bH(this.lZa, this.lZd);
                this.lZg = false;
                if (this.lZd > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.lYR.setSelection(e.this.lZd);
                            e.this.lYR.scrollTo(e.this.lZc * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.lYW.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.lZe = true;
        if (this.lVv != null && this.lVv.isPlaying()) {
            this.lVv.pause();
        }
    }

    public void onResume() {
        this.lZe = false;
        if (this.lVv != null && this.lWb.mCurrentTabIndex == 2) {
            this.lVv.start();
            this.lVv.seekTo(0);
        }
    }

    private void aKF() {
        if (this.lVv != null) {
            if (this.lVv.isPlaying()) {
                this.lVv.stop();
            }
            this.lVv.release();
            this.lVv = null;
        }
        this.lZa = null;
        this.lZf = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.lZg = true;
            this.lZf = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.lZa = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.lYV != null) {
                this.lYV.Oa(this.lZf);
                this.lZd = this.lYV.dmP();
                this.lZb = this.lZd;
                this.lZc = this.lZd;
            }
        }
    }
}
