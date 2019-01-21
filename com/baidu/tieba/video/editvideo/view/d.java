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
    private a hFI;
    private MediaPlayer hFd;
    private com.baidu.tieba.video.editvideo.a.c hID;
    private LinearLayout hIE;
    private ImageView hIF;
    private TextView hIG;
    private boolean hIH;
    private String hII;
    private int hIJ;
    private int hIK;
    private int hIL;
    private boolean hIM;
    private String hIN;
    private boolean hIO;
    private HorizontalListView hIz;
    private h hqM;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hIH = true;
        this.hIJ = 1;
        this.hFI = aVar;
        this.hqM = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hIz = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hID = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hIz.setAdapter((ListAdapter) this.hID);
        this.hIz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hID.bJS() != i || i == d.this.hIJ) {
                    d.this.hIK = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bKJ() {
        return !TextUtils.isEmpty(this.hIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.hID.getItem(i);
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
                    this.hID.wJ(i);
                    Vh();
                    this.hFI.replay();
                    return;
                case 2:
                    this.hIJ = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cU(String str, String str2) {
        this.hIM = false;
        this.hIK = this.hIJ;
        this.hIN = str2;
        aY(str, this.hIJ);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hIN = musicData.id;
            this.hFI.bJR();
            String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(musicData.resource);
            if (TextUtils.isEmpty(xa)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hFm.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bKk().a(musicData.id, musicData.resource, new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void cT(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hFm.setVisibility(4);
                            d.this.aY(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void wS(String str) {
                            aVar.hFm.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hqM != null) {
                                d.this.hqM.ac(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0324a
                        public void bJy() {
                            aVar.hFm.setVisibility(4);
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
                        if (d.this.hqM != null) {
                            d.this.hqM.ac(206, str);
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
        this.hIM = false;
        if (this.hFd != null && this.hFd.isPlaying()) {
            this.hFd.pause();
        }
        if (this.hFd != null) {
            this.hFd.start();
            this.hFd.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, final int i) {
        this.hIL = i;
        if (this.hIK == this.hIL && !this.hIM) {
            if (this.hFd == null) {
                this.hFd = new MediaPlayer();
                this.hFd.setAudioStreamType(3);
            }
            try {
                this.hII = str;
                this.hFd.reset();
                this.hFd.setDataSource(str);
                this.hFd.prepare();
                this.hFd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hID.wJ(i);
                        d.this.hFd.setLooping(true);
                        d.this.hFd.start();
                        d.this.hFI.replay();
                    }
                });
                this.hFd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hqM != null) {
                            d.this.hqM.ac(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aZ(str, i);
                if (this.hqM != null) {
                    this.hqM.ac(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aZ(String str, int i) {
        this.hII = null;
        Vh();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
        }
        a(i, this.hIz.getChildCount() > i ? this.hIz.getChildAt(i) : null, (MusicData) this.hID.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hID.setData(list);
        if (this.hID != null) {
            this.hIL = this.hID.bJS();
            this.hIK = this.hIL;
        }
    }

    public String bKH() {
        return this.hII;
    }

    public String bKI() {
        return this.hIN;
    }

    public void bX(View view) {
        this.hIE = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hIF = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hIG = (TextView) view.findViewById(e.g.video_voice_text);
        this.hIE.setVisibility(8);
        this.hIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hIH = !d.this.hIH;
                if (d.this.hIH) {
                    d.this.hIF.setSelected(false);
                    d.this.hIG.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hIF.setSelected(true);
                    d.this.hIG.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hFI.setMute(!d.this.hIH);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.y("obj_type", d.this.hIH ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hIH) {
            this.hIF.setSelected(false);
            this.hIG.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hIF.setSelected(true);
        this.hIG.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ob(boolean z) {
        if (z) {
            this.hIE.setVisibility(0);
            if (this.hIO && this.hFd == null && !TextUtils.isEmpty(this.hII)) {
                aY(this.hII, this.hIL);
                this.hIO = false;
                if (this.hIL > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hIz.setSelection(d.this.hIL);
                            d.this.hIz.scrollTo(d.this.hIK * l.h(d.this.getPageContext().getContext(), e.C0210e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hIE.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hIM = true;
        if (this.hFd != null && this.hFd.isPlaying()) {
            this.hFd.pause();
        }
    }

    public void onResume() {
        this.hIM = false;
        if (this.hFd != null && this.hFI.mCurrentTabIndex == 2) {
            this.hFd.start();
            this.hFd.seekTo(0);
        }
    }

    private void Vh() {
        if (this.hFd != null) {
            if (this.hFd.isPlaying()) {
                this.hFd.stop();
            }
            this.hFd.release();
            this.hFd = null;
        }
        this.hII = null;
        this.hIN = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hIO = true;
            this.hIN = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hII = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hID != null) {
                this.hID.wY(this.hIN);
                this.hIL = this.hID.bJS();
                this.hIJ = this.hIL;
                this.hIK = this.hIL;
            }
        }
    }
}
