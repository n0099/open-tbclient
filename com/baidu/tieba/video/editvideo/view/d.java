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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c {
    private h gWF;
    private MediaPlayer hky;
    private a hle;
    private HorizontalListView hnV;
    private com.baidu.tieba.video.editvideo.a.c hnZ;
    private LinearLayout hoa;
    private ImageView hob;
    private TextView hoc;
    private boolean hod;
    private String hoe;
    private int hof;
    private int hog;
    private int hoh;
    private boolean hoi;
    private String hoj;
    private boolean hok;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.hod = true;
        this.hof = 1;
        this.hle = aVar;
        this.gWF = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hnV = (HorizontalListView) this.mRootView.findViewById(e.g.horizontal_list);
        this.hnZ = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.hnV.setAdapter((ListAdapter) this.hnZ);
        this.hnV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.hnZ.bDC() != i || i == d.this.hof) {
                    d.this.hog = i;
                    d.this.h(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public boolean bEt() {
        return !TextUtils.isEmpty(this.hoj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, View view) {
        MusicData musicData = (MusicData) this.hnZ.getItem(i);
        if (musicData != null) {
            am amVar = new am("c12423");
            amVar.al(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            amVar.w("obj_locate", i + 1);
            amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(amVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.hnZ.vg(i);
                    Ry();
                    this.hle.replay();
                    return;
                case 2:
                    this.hof = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cC(String str, String str2) {
        this.hoi = false;
        this.hog = this.hof;
        this.hoj = str2;
        aS(str, this.hof);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.hoj = musicData.id;
            this.hle.bDB();
            String vy = com.baidu.tieba.video.editvideo.model.a.bDU().vy(musicData.resource);
            if (TextUtils.isEmpty(vy)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.hkH.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bDU().a(musicData.id, musicData.resource, new a.InterfaceC0248a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void cB(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.hkH.setVisibility(4);
                            d.this.aS(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void vp(String str) {
                            aVar.hkH.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.gWF != null) {
                                d.this.gWF.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                        public void bDi() {
                            aVar.hkH.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bDU().a(musicData.id, musicData.resource, new a.InterfaceC0248a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void cB(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.aS(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void vp(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.gWF != null) {
                            d.this.gWF.ad(HttpStatus.SC_PARTIAL_CONTENT, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0248a
                    public void bDi() {
                    }
                });
                return;
            }
            aS(vy, i);
        }
    }

    public void replay() {
        this.hoi = false;
        if (this.hky != null && this.hky.isPlaying()) {
            this.hky.pause();
        }
        if (this.hky != null) {
            this.hky.start();
            this.hky.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, final int i) {
        this.hoh = i;
        if (this.hog == this.hoh && !this.hoi) {
            if (this.hky == null) {
                this.hky = new MediaPlayer();
                this.hky.setAudioStreamType(3);
            }
            try {
                this.hoe = str;
                this.hky.reset();
                this.hky.setDataSource(str);
                this.hky.prepare();
                this.hky.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.hnZ.vg(i);
                        d.this.hky.setLooping(true);
                        d.this.hky.start();
                        d.this.hle.replay();
                    }
                });
                this.hky.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.gWF != null) {
                            d.this.gWF.ad(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aT(str, i);
                if (this.gWF != null) {
                    this.gWF.ad(208, com.baidu.tieba.j.a.m(e));
                }
            }
        }
    }

    private void aT(String str, int i) {
        this.hoe = null;
        Ry();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bDU().bDV();
        }
        a(i, this.hnV.getChildCount() > i ? this.hnV.getChildAt(i) : null, (MusicData) this.hnZ.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.hnZ.setData(list);
        if (this.hnZ != null) {
            this.hoh = this.hnZ.bDC();
            this.hog = this.hoh;
        }
    }

    public String bEr() {
        return this.hoe;
    }

    public String bEs() {
        return this.hoj;
    }

    public void bS(View view) {
        this.hoa = (LinearLayout) view.findViewById(e.g.video_voice_layout);
        this.hob = (ImageView) view.findViewById(e.g.video_voice_img);
        this.hoc = (TextView) view.findViewById(e.g.video_voice_text);
        this.hoa.setVisibility(8);
        this.hoa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.hod = !d.this.hod;
                if (d.this.hod) {
                    d.this.hob.setSelected(false);
                    d.this.hoc.setText(d.this.mResources.getString(e.j.video_voice_open));
                } else {
                    d.this.hob.setSelected(true);
                    d.this.hoc.setText(d.this.mResources.getString(e.j.video_voice_close));
                }
                d.this.hle.setMute(!d.this.hod);
                d.this.replay();
                am amVar = new am("c12423");
                amVar.w("obj_type", d.this.hod ? 0 : 1);
                TiebaStatic.log(amVar);
            }
        });
        if (this.hod) {
            this.hob.setSelected(false);
            this.hoc.setText(this.mResources.getString(e.j.video_voice_open));
            return;
        }
        this.hob.setSelected(true);
        this.hoc.setText(this.mResources.getString(e.j.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nq(boolean z) {
        if (z) {
            this.hoa.setVisibility(0);
            if (this.hok && this.hky == null && !TextUtils.isEmpty(this.hoe)) {
                aS(this.hoe, this.hoh);
                this.hok = false;
                if (this.hoh > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.hnV.setSelection(d.this.hoh);
                            d.this.hnV.scrollTo(d.this.hog * l.h(d.this.getPageContext().getContext(), e.C0141e.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.hoa.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.hoi = true;
        if (this.hky != null && this.hky.isPlaying()) {
            this.hky.pause();
        }
    }

    public void onResume() {
        this.hoi = false;
        if (this.hky != null && this.hle.mCurrentTabIndex == 2) {
            this.hky.start();
            this.hky.seekTo(0);
        }
    }

    private void Ry() {
        if (this.hky != null) {
            if (this.hky.isPlaying()) {
                this.hky.stop();
            }
            this.hky.release();
            this.hky = null;
        }
        this.hoe = null;
        this.hoj = null;
    }

    public void aa(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.hok = true;
            this.hoj = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.hoe = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.hnZ != null) {
                this.hnZ.vv(this.hoj);
                this.hoh = this.hnZ.bDC();
                this.hof = this.hoh;
                this.hog = this.hoh;
            }
        }
    }
}
