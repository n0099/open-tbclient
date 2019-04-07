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
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private h iGX;
    private a iVX;
    private MediaPlayer iVr;
    private HorizontalListView iYL;
    private com.baidu.tieba.video.editvideo.a.c iYP;
    private LinearLayout iYQ;
    private ImageView iYR;
    private TextView iYS;
    private boolean iYT;
    private String iYU;
    private int iYV;
    private int iYW;
    private int iYX;
    private boolean iYY;
    private String iYZ;
    private boolean iZa;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.iYT = true;
        this.iYV = 1;
        this.iVX = aVar;
        this.iGX = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.iYL = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.iYP = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.iYL.setAdapter((ListAdapter) this.iYP);
        this.iYL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.iYP.cjq() != i || i == d.this.iYV) {
                    d.this.iYW = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public boolean ckh() {
        return !TextUtils.isEmpty(this.iYZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.iYP.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.T("obj_locate", i + 1);
            amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.iYP.Ar(i);
                    avd();
                    this.iVX.replay();
                    return;
                case 2:
                    this.iYV = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ef(String str, String str2) {
        this.iYY = false;
        this.iYW = this.iYV;
        this.iYZ = str2;
        bu(str, this.iYV);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.iYZ = musicData.id;
            this.iVX.cjp();
            String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(musicData.resource);
            if (TextUtils.isEmpty(DA)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.iVA.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cjI().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ed(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.iVA.setVisibility(4);
                            d.this.bu(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void Ds(String str) {
                            aVar.iVA.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iGX != null) {
                                d.this.iGX.au(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ciW() {
                            aVar.iVA.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cjI().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ed(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bu(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void Ds(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.iGX != null) {
                            d.this.iGX.au(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                    public void ciW() {
                    }
                });
                return;
            }
            bu(DA, i);
        }
    }

    public void replay() {
        this.iYY = false;
        if (this.iVr != null && this.iVr.isPlaying()) {
            this.iVr.pause();
        }
        if (this.iVr != null) {
            this.iVr.start();
            this.iVr.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(String str, final int i) {
        this.iYX = i;
        if (this.iYW == this.iYX && !this.iYY) {
            if (this.iVr == null) {
                this.iVr = new MediaPlayer();
                this.iVr.setAudioStreamType(3);
            }
            try {
                this.iYU = str;
                this.iVr.reset();
                this.iVr.setDataSource(str);
                this.iVr.prepare();
                this.iVr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.iYP.Ar(i);
                        d.this.iVr.setLooping(true);
                        d.this.iVr.start();
                        d.this.iVX.replay();
                    }
                });
                this.iVr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iGX != null) {
                            d.this.iGX.au(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bv(str, i);
                if (this.iGX != null) {
                    this.iGX.au(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bv(String str, int i) {
        this.iYU = null;
        avd();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
        }
        a(i, this.iYL.getChildCount() > i ? this.iYL.getChildAt(i) : null, (MusicData) this.iYP.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.iYP.setData(list);
        if (this.iYP != null) {
            this.iYX = this.iYP.cjq();
            this.iYW = this.iYX;
        }
    }

    public String ckf() {
        return this.iYU;
    }

    public String ckg() {
        return this.iYZ;
    }

    public void cK(View view) {
        this.iYQ = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.iYR = (ImageView) view.findViewById(d.g.video_voice_img);
        this.iYS = (TextView) view.findViewById(d.g.video_voice_text);
        this.iYQ.setVisibility(8);
        this.iYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.iYT = !d.this.iYT;
                if (d.this.iYT) {
                    d.this.iYR.setSelected(false);
                    d.this.iYS.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.iYR.setSelected(true);
                    d.this.iYS.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.iVX.setMute(!d.this.iYT);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.T("obj_type", d.this.iYT ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.iYT) {
            this.iYR.setSelected(false);
            this.iYS.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.iYR.setSelected(true);
        this.iYS.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
        if (z) {
            this.iYQ.setVisibility(0);
            if (this.iZa && this.iVr == null && !TextUtils.isEmpty(this.iYU)) {
                bu(this.iYU, this.iYX);
                this.iZa = false;
                if (this.iYX > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.iYL.setSelection(d.this.iYX);
                            d.this.iYL.scrollTo(d.this.iYW * l.h(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.iYQ.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.iYY = true;
        if (this.iVr != null && this.iVr.isPlaying()) {
            this.iVr.pause();
        }
    }

    public void onResume() {
        this.iYY = false;
        if (this.iVr != null && this.iVX.mCurrentTabIndex == 2) {
            this.iVr.start();
            this.iVr.seekTo(0);
        }
    }

    private void avd() {
        if (this.iVr != null) {
            if (this.iVr.isPlaying()) {
                this.iVr.stop();
            }
            this.iVr.release();
            this.iVr = null;
        }
        this.iYU = null;
        this.iYZ = null;
    }

    public void av(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.iZa = true;
            this.iYZ = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.iYU = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.iYP != null) {
                this.iYP.Dy(this.iYZ);
                this.iYX = this.iYP.cjq();
                this.iYV = this.iYX;
                this.iYW = this.iYX;
            }
        }
    }
}
