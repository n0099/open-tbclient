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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
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
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.c {
    private h kgK;
    private MediaPlayer kuK;
    private a kvp;
    private HorizontalListView kxW;
    private com.baidu.tieba.video.editvideo.a.c kya;
    private LinearLayout kyb;
    private ImageView kyc;
    private TextView kyd;
    private boolean kye;
    private String kyf;
    private int kyg;
    private int kyh;
    private int kyi;
    private boolean kyj;
    private String kyk;
    private boolean kyl;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kye = true;
        this.kyg = 1;
        this.kvp = aVar;
        this.kgK = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kxW = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kya = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kxW.setAdapter((ListAdapter) this.kya);
        this.kxW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kya.cOm() != i || i == d.this.kyg) {
                    d.this.kyh = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cPa() {
        return !TextUtils.isEmpty(this.kyk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kya.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.cp("obj_id", musicData.id);
            anVar.Z("obj_locate", i + 1);
            anVar.Z("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.kya.Ds(i);
                    aUk();
                    this.kvp.replay();
                    return;
                case 2:
                    this.kyg = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eB(String str, String str2) {
        this.kyj = false;
        this.kyh = this.kyg;
        this.kyk = str2;
        by(str, this.kyg);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kyk = musicData.id;
            this.kvp.cOl();
            String JN = com.baidu.tieba.video.editvideo.model.a.cOD().JN(musicData.resource);
            if (TextUtils.isEmpty(JN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kuT.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cOD().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void eA(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kuT.setVisibility(4);
                            d.this.by(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void JG(String str) {
                            aVar.kuT.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kgK != null) {
                                d.this.kgK.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void cNT() {
                            aVar.kuT.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cOD().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void eA(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.by(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void JG(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.kgK != null) {
                            d.this.kgK.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void cNT() {
                    }
                });
                return;
            }
            by(JN, i);
        }
    }

    public void replay() {
        this.kyj = false;
        if (this.kuK != null && this.kuK.isPlaying()) {
            this.kuK.pause();
        }
        if (this.kuK != null) {
            this.kuK.start();
            this.kuK.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, final int i) {
        this.kyi = i;
        if (this.kyh == this.kyi && !this.kyj) {
            if (this.kuK == null) {
                this.kuK = new MediaPlayer();
                this.kuK.setAudioStreamType(3);
            }
            try {
                this.kyf = str;
                this.kuK.reset();
                this.kuK.setDataSource(str);
                this.kuK.prepare();
                this.kuK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kya.Ds(i);
                        d.this.kuK.setLooping(true);
                        d.this.kuK.start();
                        d.this.kvp.replay();
                    }
                });
                this.kuK.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kgK != null) {
                            d.this.kgK.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bz(str, i);
                if (this.kgK != null) {
                    this.kgK.aR(208, com.baidu.tieba.j.a.r(e));
                }
            }
        }
    }

    private void bz(String str, int i) {
        this.kyf = null;
        aUk();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cOD().cOE();
        }
        a(i, this.kxW.getChildCount() > i ? this.kxW.getChildAt(i) : null, (MusicData) this.kya.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kya.setData(list);
        if (this.kya != null) {
            this.kyi = this.kya.cOm();
            this.kyh = this.kyi;
        }
    }

    public String cOY() {
        return this.kyf;
    }

    public String cOZ() {
        return this.kyk;
    }

    public void cU(View view) {
        this.kyb = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kyc = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kyd = (TextView) view.findViewById(R.id.video_voice_text);
        this.kyb.setVisibility(8);
        this.kyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kye = !d.this.kye;
                if (d.this.kye) {
                    d.this.kyc.setSelected(false);
                    d.this.kyd.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kyc.setSelected(true);
                    d.this.kyd.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kvp.setMute(!d.this.kye);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.Z("obj_type", d.this.kye ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kye) {
            this.kyc.setSelected(false);
            this.kyd.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kyc.setSelected(true);
        this.kyd.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tk(boolean z) {
        if (z) {
            this.kyb.setVisibility(0);
            if (this.kyl && this.kuK == null && !TextUtils.isEmpty(this.kyf)) {
                by(this.kyf, this.kyi);
                this.kyl = false;
                if (this.kyi > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kxW.setSelection(d.this.kyi);
                            d.this.kxW.scrollTo(d.this.kyh * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kyb.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kyj = true;
        if (this.kuK != null && this.kuK.isPlaying()) {
            this.kuK.pause();
        }
    }

    public void onResume() {
        this.kyj = false;
        if (this.kuK != null && this.kvp.mCurrentTabIndex == 2) {
            this.kuK.start();
            this.kuK.seekTo(0);
        }
    }

    private void aUk() {
        if (this.kuK != null) {
            if (this.kuK.isPlaying()) {
                this.kuK.stop();
            }
            this.kuK.release();
            this.kuK = null;
        }
        this.kyf = null;
        this.kyk = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kyl = true;
            this.kyk = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kyf = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kya != null) {
                this.kya.JL(this.kyk);
                this.kyi = this.kya.cOm();
                this.kyg = this.kyi;
                this.kyh = this.kyi;
            }
        }
    }
}
