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
    private h iGY;
    private a iVY;
    private MediaPlayer iVs;
    private HorizontalListView iYM;
    private com.baidu.tieba.video.editvideo.a.c iYQ;
    private LinearLayout iYR;
    private ImageView iYS;
    private TextView iYT;
    private boolean iYU;
    private String iYV;
    private int iYW;
    private int iYX;
    private int iYY;
    private boolean iYZ;
    private String iZa;
    private boolean iZb;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.iYU = true;
        this.iYW = 1;
        this.iVY = aVar;
        this.iGY = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.iYM = (HorizontalListView) this.mRootView.findViewById(d.g.horizontal_list);
        this.iYQ = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.iYM.setAdapter((ListAdapter) this.iYQ);
        this.iYM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.iYQ.cjq() != i || i == d.this.iYW) {
                    d.this.iYX = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public boolean ckh() {
        return !TextUtils.isEmpty(this.iZa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.iYQ.getItem(i);
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
                    this.iYQ.Ar(i);
                    avd();
                    this.iVY.replay();
                    return;
                case 2:
                    this.iYW = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ef(String str, String str2) {
        this.iYZ = false;
        this.iYX = this.iYW;
        this.iZa = str2;
        bu(str, this.iYW);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.iZa = musicData.id;
            this.iVY.cjp();
            String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(musicData.resource);
            if (TextUtils.isEmpty(DA)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.iVB.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cjI().a(musicData.id, musicData.resource, new a.InterfaceC0398a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ed(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.iVB.setVisibility(4);
                            d.this.bu(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void Ds(String str) {
                            aVar.iVB.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.iGY != null) {
                                d.this.iGY.au(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0398a
                        public void ciW() {
                            aVar.iVB.setVisibility(4);
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
                        if (d.this.iGY != null) {
                            d.this.iGY.au(206, str);
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
        this.iYZ = false;
        if (this.iVs != null && this.iVs.isPlaying()) {
            this.iVs.pause();
        }
        if (this.iVs != null) {
            this.iVs.start();
            this.iVs.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(String str, final int i) {
        this.iYY = i;
        if (this.iYX == this.iYY && !this.iYZ) {
            if (this.iVs == null) {
                this.iVs = new MediaPlayer();
                this.iVs.setAudioStreamType(3);
            }
            try {
                this.iYV = str;
                this.iVs.reset();
                this.iVs.setDataSource(str);
                this.iVs.prepare();
                this.iVs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.iYQ.Ar(i);
                        d.this.iVs.setLooping(true);
                        d.this.iVs.start();
                        d.this.iVY.replay();
                    }
                });
                this.iVs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.iGY != null) {
                            d.this.iGY.au(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bv(str, i);
                if (this.iGY != null) {
                    this.iGY.au(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bv(String str, int i) {
        this.iYV = null;
        avd();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
        }
        a(i, this.iYM.getChildCount() > i ? this.iYM.getChildAt(i) : null, (MusicData) this.iYQ.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.iYQ.setData(list);
        if (this.iYQ != null) {
            this.iYY = this.iYQ.cjq();
            this.iYX = this.iYY;
        }
    }

    public String ckf() {
        return this.iYV;
    }

    public String ckg() {
        return this.iZa;
    }

    public void cK(View view) {
        this.iYR = (LinearLayout) view.findViewById(d.g.video_voice_layout);
        this.iYS = (ImageView) view.findViewById(d.g.video_voice_img);
        this.iYT = (TextView) view.findViewById(d.g.video_voice_text);
        this.iYR.setVisibility(8);
        this.iYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.iYU = !d.this.iYU;
                if (d.this.iYU) {
                    d.this.iYS.setSelected(false);
                    d.this.iYT.setText(d.this.mResources.getString(d.j.video_voice_open));
                } else {
                    d.this.iYS.setSelected(true);
                    d.this.iYT.setText(d.this.mResources.getString(d.j.video_voice_close));
                }
                d.this.iVY.setMute(!d.this.iYU);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.T("obj_type", d.this.iYU ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.iYU) {
            this.iYS.setSelected(false);
            this.iYT.setText(this.mResources.getString(d.j.video_voice_open));
            return;
        }
        this.iYS.setSelected(true);
        this.iYT.setText(this.mResources.getString(d.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
        if (z) {
            this.iYR.setVisibility(0);
            if (this.iZb && this.iVs == null && !TextUtils.isEmpty(this.iYV)) {
                bu(this.iYV, this.iYY);
                this.iZb = false;
                if (this.iYY > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.iYM.setSelection(d.this.iYY);
                            d.this.iYM.scrollTo(d.this.iYX * l.h(d.this.getPageContext().getContext(), d.e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.iYR.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.iYZ = true;
        if (this.iVs != null && this.iVs.isPlaying()) {
            this.iVs.pause();
        }
    }

    public void onResume() {
        this.iYZ = false;
        if (this.iVs != null && this.iVY.mCurrentTabIndex == 2) {
            this.iVs.start();
            this.iVs.seekTo(0);
        }
    }

    private void avd() {
        if (this.iVs != null) {
            if (this.iVs.isPlaying()) {
                this.iVs.stop();
            }
            this.iVs.release();
            this.iVs = null;
        }
        this.iYV = null;
        this.iZa = null;
    }

    public void av(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.iZb = true;
            this.iZa = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.iYV = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.iYQ != null) {
                this.iYQ.Dy(this.iZa);
                this.iYY = this.iYQ.cjq();
                this.iYW = this.iYY;
                this.iYX = this.iYY;
            }
        }
    }
}
