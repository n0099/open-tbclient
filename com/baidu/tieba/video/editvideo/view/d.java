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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private a hFH;
    private MediaPlayer hFc;
    private com.baidu.tieba.video.editvideo.a.c hIC;
    private LinearLayout hID;
    private ImageView hIE;
    private TextView hIF;
    private boolean hIG;
    private String hIH;
    private int hII;
    private int hIJ;
    private int hIK;
    private boolean hIL;
    private String hIM;
    private boolean hIN;
    private HorizontalListView hIy;
    private h hqL;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hIG = true;
        this.hII = 1;
        this.hFH = aVar;
        this.hqL = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hIy = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hIC = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hIy.setAdapter((ListAdapter) this.hIC);
        this.hIy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hIC.bJS() != i || i == d.this.hII) {
                    d.this.hIJ = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bKJ() {
        return !TextUtils.isEmpty(this.hIM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hIC.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.y("obj_locate", i + 1);
            amVar.y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hIC.wJ(i);
                    Vh();
                    this.hFH.replay();
                    return;
                case 2:
                    this.hII = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cU(String str, String str2) {
        this.hIL = false;
        this.hIJ = this.hII;
        this.hIM = str2;
        aY(str, this.hII);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hIM = musicData.id;
            this.hFH.bJR();
            String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(musicData.resource);
            if (TextUtils.isEmpty(xa)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hFl.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bKk().a(musicData.id, musicData.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void cT(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hFl.setVisibility(4);
                            d.this.aY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void wS(String str) {
                            aVar.hFl.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hqL != null) {
                                d.this.hqL.ac(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void bJy() {
                            aVar.hFl.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bKk().a(musicData.id, musicData.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void cT(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aY(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void wS(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hqL != null) {
                            d.this.hqL.ac(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                    public void bJy() {
                    }
                });
                return;
            }
            aY(xa, i);
        }
    }

    public void replay() {
        this.hIL = false;
        if (this.hFc != null && this.hFc.isPlaying()) {
            this.hFc.pause();
        }
        if (this.hFc != null) {
            this.hFc.start();
            this.hFc.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, final int i) {
        this.hIK = i;
        if (this.hIJ == this.hIK && !this.hIL) {
            if (this.hFc == null) {
                this.hFc = new MediaPlayer();
                this.hFc.setAudioStreamType(3);
            }
            try {
                this.hIH = str;
                this.hFc.reset();
                this.hFc.setDataSource(str);
                this.hFc.prepare();
                this.hFc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hIC.wJ(i);
                        d.this.hFc.setLooping(true);
                        d.this.hFc.start();
                        d.this.hFH.replay();
                    }
                });
                this.hFc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hqL != null) {
                            d.this.hqL.ac(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aZ(str, i);
                if (this.hqL != null) {
                    this.hqL.ac(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aZ(String str, int i) {
        this.hIH = null;
        Vh();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
        }
        a(i, this.hIy.getChildCount() > i ? this.hIy.getChildAt(i) : null, (MusicData) this.hIC.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hIC.setData(list);
        if (this.hIC != null) {
            this.hIK = this.hIC.bJS();
            this.hIJ = this.hIK;
        }
    }

    public String bKH() {
        return this.hIH;
    }

    public String bKI() {
        return this.hIM;
    }

    public void bX(View view) {
        this.hID = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hIE = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hIF = (TextView) view.findViewById(e.g.video_voice_text);
        this.hID.setVisibility(8);
        this.hID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hIG = !d.this.hIG;
                if (d.this.hIG) {
                    d.this.hIE.setSelected(false);
                    d.this.hIF.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hIE.setSelected(true);
                    d.this.hIF.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hFH.setMute(!d.this.hIG);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.y("obj_type", d.this.hIG ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hIG) {
            this.hIE.setSelected(false);
            this.hIF.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hIE.setSelected(true);
        this.hIF.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ob(boolean z) {
        if (z) {
            this.hID.setVisibility(0);
            if (this.hIN && this.hFc == null && !TextUtils.isEmpty(this.hIH)) {
                aY(this.hIH, this.hIK);
                this.hIN = false;
                if (this.hIK > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hIy.setSelection(d.this.hIK);
                            d.this.hIy.scrollTo(d.this.hIJ * l.h(d.this.getPageContext().getContext(), e.C0210e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hID.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hIL = true;
        if (this.hFc != null && this.hFc.isPlaying()) {
            this.hFc.pause();
        }
    }

    public void onResume() {
        this.hIL = false;
        if (this.hFc != null && this.hFH.mCurrentTabIndex == 2) {
            this.hFc.start();
            this.hFc.seekTo(0);
        }
    }

    private void Vh() {
        if (this.hFc != null) {
            if (this.hFc.isPlaying()) {
                this.hFc.stop();
            }
            this.hFc.release();
            this.hFc = null;
        }
        this.hIH = null;
        this.hIM = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hIN = true;
            this.hIM = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hIH = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hIC != null) {
                this.hIC.wY(this.hIM);
                this.hIK = this.hIC.bJS();
                this.hII = this.hIK;
                this.hIJ = this.hIK;
            }
        }
    }
}
