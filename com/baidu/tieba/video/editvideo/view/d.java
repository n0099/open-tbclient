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
    private h jgo;
    private MediaPlayer juB;
    private a jvh;
    private HorizontalListView jxT;
    private com.baidu.tieba.video.editvideo.a.c jxX;
    private LinearLayout jxY;
    private ImageView jxZ;
    private TextView jya;
    private boolean jyb;
    private String jyc;
    private int jyd;
    private int jye;
    private int jyf;
    private boolean jyg;
    private String jyh;
    private boolean jyi;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jyb = true;
        this.jyd = 1;
        this.jvh = aVar;
        this.jgo = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jxT = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jxX = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jxT.setAdapter((ListAdapter) this.jxX);
        this.jxT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jxX.cuh() != i || i == d.this.jyd) {
                    d.this.jye = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cuY() {
        return !TextUtils.isEmpty(this.jyh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jxX.getItem(i);
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
                    this.jxX.Cg(i);
                    aBA();
                    this.jvh.replay();
                    return;
                case 2:
                    this.jyd = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void et(String str, String str2) {
        this.jyg = false;
        this.jye = this.jyd;
        this.jyh = str2;
        br(str, this.jyd);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jyh = musicData.id;
            this.jvh.cug();
            String FM = com.baidu.tieba.video.editvideo.model.a.cuz().FM(musicData.resource);
            if (TextUtils.isEmpty(FM)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.juK.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cuz().a(musicData.id, musicData.resource, new a.InterfaceC0422a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void es(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.juK.setVisibility(4);
                            d.this.br(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void FE(String str) {
                            aVar.juK.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.jgo != null) {
                                d.this.jgo.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void ctN() {
                            aVar.juK.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cuz().a(musicData.id, musicData.resource, new a.InterfaceC0422a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void es(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.br(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void FE(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.jgo != null) {
                            d.this.jgo.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void ctN() {
                    }
                });
                return;
            }
            br(FM, i);
        }
    }

    public void replay() {
        this.jyg = false;
        if (this.juB != null && this.juB.isPlaying()) {
            this.juB.pause();
        }
        if (this.juB != null) {
            this.juB.start();
            this.juB.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(String str, final int i) {
        this.jyf = i;
        if (this.jye == this.jyf && !this.jyg) {
            if (this.juB == null) {
                this.juB = new MediaPlayer();
                this.juB.setAudioStreamType(3);
            }
            try {
                this.jyc = str;
                this.juB.reset();
                this.juB.setDataSource(str);
                this.juB.prepare();
                this.juB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jxX.Cg(i);
                        d.this.juB.setLooping(true);
                        d.this.juB.start();
                        d.this.jvh.replay();
                    }
                });
                this.juB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.jgo != null) {
                            d.this.jgo.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bs(str, i);
                if (this.jgo != null) {
                    this.jgo.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bs(String str, int i) {
        this.jyc = null;
        aBA();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cuz().cuA();
        }
        a(i, this.jxT.getChildCount() > i ? this.jxT.getChildAt(i) : null, (MusicData) this.jxX.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jxX.setData(list);
        if (this.jxX != null) {
            this.jyf = this.jxX.cuh();
            this.jye = this.jyf;
        }
    }

    public String cuW() {
        return this.jyc;
    }

    public String cuX() {
        return this.jyh;
    }

    public void cV(View view) {
        this.jxY = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jxZ = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jya = (TextView) view.findViewById(R.id.video_voice_text);
        this.jxY.setVisibility(8);
        this.jxY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jyb = !d.this.jyb;
                if (d.this.jyb) {
                    d.this.jxZ.setSelected(false);
                    d.this.jya.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jxZ.setSelected(true);
                    d.this.jya.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jvh.setMute(!d.this.jyb);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.P("obj_type", d.this.jyb ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.jyb) {
            this.jxZ.setSelected(false);
            this.jya.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jxZ.setSelected(true);
        this.jya.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rE(boolean z) {
        if (z) {
            this.jxY.setVisibility(0);
            if (this.jyi && this.juB == null && !TextUtils.isEmpty(this.jyc)) {
                br(this.jyc, this.jyf);
                this.jyi = false;
                if (this.jyf > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jxT.setSelection(d.this.jyf);
                            d.this.jxT.scrollTo(d.this.jye * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jxY.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jyg = true;
        if (this.juB != null && this.juB.isPlaying()) {
            this.juB.pause();
        }
    }

    public void onResume() {
        this.jyg = false;
        if (this.juB != null && this.jvh.mCurrentTabIndex == 2) {
            this.juB.start();
            this.juB.seekTo(0);
        }
    }

    private void aBA() {
        if (this.juB != null) {
            if (this.juB.isPlaying()) {
                this.juB.stop();
            }
            this.juB.release();
            this.juB = null;
        }
        this.jyc = null;
        this.jyh = null;
    }

    public void ay(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jyi = true;
            this.jyh = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jyc = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jxX != null) {
                this.jxX.FK(this.jyh);
                this.jyf = this.jxX.cuh();
                this.jyd = this.jyf;
                this.jye = this.jyf;
            }
        }
    }
}
