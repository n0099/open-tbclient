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
    private h kgF;
    private MediaPlayer kuF;
    private a kvk;
    private HorizontalListView kxR;
    private com.baidu.tieba.video.editvideo.a.c kxV;
    private LinearLayout kxW;
    private ImageView kxX;
    private TextView kxY;
    private boolean kxZ;
    private String kya;
    private int kyb;
    private int kyc;
    private int kyd;
    private boolean kye;
    private String kyf;
    private boolean kyg;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kxZ = true;
        this.kyb = 1;
        this.kvk = aVar;
        this.kgF = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kxR = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kxV = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kxR.setAdapter((ListAdapter) this.kxV);
        this.kxR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kxV.cOk() != i || i == d.this.kyb) {
                    d.this.kyc = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cOY() {
        return !TextUtils.isEmpty(this.kyf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kxV.getItem(i);
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
                    this.kxV.Ds(i);
                    aUk();
                    this.kvk.replay();
                    return;
                case 2:
                    this.kyb = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eB(String str, String str2) {
        this.kye = false;
        this.kyc = this.kyb;
        this.kyf = str2;
        by(str, this.kyb);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kyf = musicData.id;
            this.kvk.cOj();
            String JN = com.baidu.tieba.video.editvideo.model.a.cOB().JN(musicData.resource);
            if (TextUtils.isEmpty(JN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kuO.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cOB().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void eA(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kuO.setVisibility(4);
                            d.this.by(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void JG(String str) {
                            aVar.kuO.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kgF != null) {
                                d.this.kgF.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                        public void cNR() {
                            aVar.kuO.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cOB().a(musicData.id, musicData.resource, new a.InterfaceC0612a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
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
                        if (d.this.kgF != null) {
                            d.this.kgF.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0612a
                    public void cNR() {
                    }
                });
                return;
            }
            by(JN, i);
        }
    }

    public void replay() {
        this.kye = false;
        if (this.kuF != null && this.kuF.isPlaying()) {
            this.kuF.pause();
        }
        if (this.kuF != null) {
            this.kuF.start();
            this.kuF.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, final int i) {
        this.kyd = i;
        if (this.kyc == this.kyd && !this.kye) {
            if (this.kuF == null) {
                this.kuF = new MediaPlayer();
                this.kuF.setAudioStreamType(3);
            }
            try {
                this.kya = str;
                this.kuF.reset();
                this.kuF.setDataSource(str);
                this.kuF.prepare();
                this.kuF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kxV.Ds(i);
                        d.this.kuF.setLooping(true);
                        d.this.kuF.start();
                        d.this.kvk.replay();
                    }
                });
                this.kuF.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kgF != null) {
                            d.this.kgF.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bz(str, i);
                if (this.kgF != null) {
                    this.kgF.aR(208, com.baidu.tieba.j.a.r(e));
                }
            }
        }
    }

    private void bz(String str, int i) {
        this.kya = null;
        aUk();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cOB().cOC();
        }
        a(i, this.kxR.getChildCount() > i ? this.kxR.getChildAt(i) : null, (MusicData) this.kxV.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kxV.setData(list);
        if (this.kxV != null) {
            this.kyd = this.kxV.cOk();
            this.kyc = this.kyd;
        }
    }

    public String cOW() {
        return this.kya;
    }

    public String cOX() {
        return this.kyf;
    }

    public void cU(View view) {
        this.kxW = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kxX = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kxY = (TextView) view.findViewById(R.id.video_voice_text);
        this.kxW.setVisibility(8);
        this.kxW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kxZ = !d.this.kxZ;
                if (d.this.kxZ) {
                    d.this.kxX.setSelected(false);
                    d.this.kxY.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kxX.setSelected(true);
                    d.this.kxY.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kvk.setMute(!d.this.kxZ);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.Z("obj_type", d.this.kxZ ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kxZ) {
            this.kxX.setSelected(false);
            this.kxY.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kxX.setSelected(true);
        this.kxY.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tk(boolean z) {
        if (z) {
            this.kxW.setVisibility(0);
            if (this.kyg && this.kuF == null && !TextUtils.isEmpty(this.kya)) {
                by(this.kya, this.kyd);
                this.kyg = false;
                if (this.kyd > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kxR.setSelection(d.this.kyd);
                            d.this.kxR.scrollTo(d.this.kyc * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kxW.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kye = true;
        if (this.kuF != null && this.kuF.isPlaying()) {
            this.kuF.pause();
        }
    }

    public void onResume() {
        this.kye = false;
        if (this.kuF != null && this.kvk.mCurrentTabIndex == 2) {
            this.kuF.start();
            this.kuF.seekTo(0);
        }
    }

    private void aUk() {
        if (this.kuF != null) {
            if (this.kuF.isPlaying()) {
                this.kuF.stop();
            }
            this.kuF.release();
            this.kuF = null;
        }
        this.kya = null;
        this.kyf = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kyg = true;
            this.kyf = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kya = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kxV != null) {
                this.kxV.JL(this.kyf);
                this.kyd = this.kxV.cOk();
                this.kyb = this.kyd;
                this.kyc = this.kyd;
            }
        }
    }
}
