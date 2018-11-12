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
    private h hfy;
    private MediaPlayer hty;
    private a hud;
    private HorizontalListView hwU;
    private com.baidu.tieba.video.editvideo.a.c hwY;
    private LinearLayout hwZ;
    private ImageView hxa;
    private TextView hxb;
    private boolean hxc;
    private String hxd;
    private int hxe;
    private int hxf;
    private int hxg;
    private boolean hxh;
    private String hxi;
    private boolean hxj;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hxc = true;
        this.hxe = 1;
        this.hud = aVar;
        this.hfy = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hwU = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hwY = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hwU.setAdapter((ListAdapter) this.hwY);
        this.hwU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hwY.bGp() != i || i == d.this.hxe) {
                    d.this.hxf = i;
                    d.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bHg() {
        return !TextUtils.isEmpty(this.hxi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.hwY.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.x("obj_locate", i + 1);
            amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hwY.vW(i);
                    TD();
                    this.hud.replay();
                    return;
                case 2:
                    this.hxe = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cN(String str, String str2) {
        this.hxh = false;
        this.hxf = this.hxe;
        this.hxi = str2;
        aW(str, this.hxe);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hxi = musicData.id;
            this.hud.bGo();
            String we = com.baidu.tieba.video.editvideo.model.a.bGH().we(musicData.resource);
            if (TextUtils.isEmpty(we)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.htH.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bGH().a(musicData.id, musicData.resource, new a.InterfaceC0311a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void cM(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.htH.setVisibility(4);
                            d.this.aW(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void vW(String str) {
                            aVar.htH.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.hfy != null) {
                                d.this.hfy.Z(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                        public void bFV() {
                            aVar.htH.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bGH().a(musicData.id, musicData.resource, new a.InterfaceC0311a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aW(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void vW(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.hfy != null) {
                            d.this.hfy.Z(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0311a
                    public void bFV() {
                    }
                });
                return;
            }
            aW(we, i);
        }
    }

    public void replay() {
        this.hxh = false;
        if (this.hty != null && this.hty.isPlaying()) {
            this.hty.pause();
        }
        if (this.hty != null) {
            this.hty.start();
            this.hty.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, final int i) {
        this.hxg = i;
        if (this.hxf == this.hxg && !this.hxh) {
            if (this.hty == null) {
                this.hty = new MediaPlayer();
                this.hty.setAudioStreamType(3);
            }
            try {
                this.hxd = str;
                this.hty.reset();
                this.hty.setDataSource(str);
                this.hty.prepare();
                this.hty.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hwY.vW(i);
                        d.this.hty.setLooping(true);
                        d.this.hty.start();
                        d.this.hud.replay();
                    }
                });
                this.hty.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.hfy != null) {
                            d.this.hfy.Z(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aX(str, i);
                if (this.hfy != null) {
                    this.hfy.Z(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void aX(String str, int i) {
        this.hxd = null;
        TD();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
        }
        a(i, this.hwU.getChildCount() > i ? this.hwU.getChildAt(i) : null, (MusicData) this.hwY.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hwY.setData(list);
        if (this.hwY != null) {
            this.hxg = this.hwY.bGp();
            this.hxf = this.hxg;
        }
    }

    public String bHe() {
        return this.hxd;
    }

    public String bHf() {
        return this.hxi;
    }

    public void bU(View view) {
        this.hwZ = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hxa = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hxb = (TextView) view.findViewById(e.g.video_voice_text);
        this.hwZ.setVisibility(8);
        this.hwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hxc = !d.this.hxc;
                if (d.this.hxc) {
                    d.this.hxa.setSelected(false);
                    d.this.hxb.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hxa.setSelected(true);
                    d.this.hxb.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hud.setMute(!d.this.hxc);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.x("obj_type", d.this.hxc ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hxc) {
            this.hxa.setSelected(false);
            this.hxb.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hxa.setSelected(true);
        this.hxb.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nV(boolean z) {
        if (z) {
            this.hwZ.setVisibility(0);
            if (this.hxj && this.hty == null && !TextUtils.isEmpty(this.hxd)) {
                aW(this.hxd, this.hxg);
                this.hxj = false;
                if (this.hxg > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hwU.setSelection(d.this.hxg);
                            d.this.hwU.scrollTo(d.this.hxf * l.h(d.this.getPageContext().getContext(), e.C0200e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hwZ.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hxh = true;
        if (this.hty != null && this.hty.isPlaying()) {
            this.hty.pause();
        }
    }

    public void onResume() {
        this.hxh = false;
        if (this.hty != null && this.hud.mCurrentTabIndex == 2) {
            this.hty.start();
            this.hty.seekTo(0);
        }
    }

    private void TD() {
        if (this.hty != null) {
            if (this.hty.isPlaying()) {
                this.hty.stop();
            }
            this.hty.release();
            this.hty = null;
        }
        this.hxd = null;
        this.hxi = null;
    }

    public void ae(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hxj = true;
            this.hxi = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hxd = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hwY != null) {
                this.hwY.wc(this.hxi);
                this.hxg = this.hwY.bGp();
                this.hxe = this.hxg;
                this.hxf = this.hxg;
            }
        }
    }
}
