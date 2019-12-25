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
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.base.c {
    private h kdc;
    private a krH;
    private MediaPlayer krc;
    private int kuA;
    private boolean kuB;
    private String kuC;
    private boolean kuD;
    private HorizontalListView kuo;
    private com.baidu.tieba.video.editvideo.a.c kus;
    private LinearLayout kut;
    private ImageView kuu;
    private TextView kuv;
    private boolean kuw;
    private String kux;
    private int kuy;
    private int kuz;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kuw = true;
        this.kuy = 1;
        this.krH = aVar;
        this.kdc = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kuo = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kus = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kuo.setAdapter((ListAdapter) this.kus);
        this.kuo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kus.cNf() != i || i == d.this.kuy) {
                    d.this.kuz = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cNV() {
        return !TextUtils.isEmpty(this.kuC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kus.getItem(i);
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
                    this.kus.Dm(i);
                    aTQ();
                    this.krH.replay();
                    return;
                case 2:
                    this.kuy = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ez(String str, String str2) {
        this.kuB = false;
        this.kuz = this.kuy;
        this.kuC = str2;
        bx(str, this.kuy);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kuC = musicData.id;
            this.krH.cNe();
            String JD = com.baidu.tieba.video.editvideo.model.a.cNw().JD(musicData.resource);
            if (TextUtils.isEmpty(JD)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.krl.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cNw().a(musicData.id, musicData.resource, new a.InterfaceC0607a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                        public void ey(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.krl.setVisibility(4);
                            d.this.bx(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                        public void Jw(String str) {
                            aVar.krl.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kdc != null) {
                                d.this.kdc.aL(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                        public void cMM() {
                            aVar.krl.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cNw().a(musicData.id, musicData.resource, new a.InterfaceC0607a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void ey(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bx(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void Jw(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.kdc != null) {
                            d.this.kdc.aL(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0607a
                    public void cMM() {
                    }
                });
                return;
            }
            bx(JD, i);
        }
    }

    public void replay() {
        this.kuB = false;
        if (this.krc != null && this.krc.isPlaying()) {
            this.krc.pause();
        }
        if (this.krc != null) {
            this.krc.start();
            this.krc.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, final int i) {
        this.kuA = i;
        if (this.kuz == this.kuA && !this.kuB) {
            if (this.krc == null) {
                this.krc = new MediaPlayer();
                this.krc.setAudioStreamType(3);
            }
            try {
                this.kux = str;
                this.krc.reset();
                this.krc.setDataSource(str);
                this.krc.prepare();
                this.krc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kus.Dm(i);
                        d.this.krc.setLooping(true);
                        d.this.krc.start();
                        d.this.krH.replay();
                    }
                });
                this.krc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kdc != null) {
                            d.this.kdc.aL(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                by(str, i);
                if (this.kdc != null) {
                    this.kdc.aL(208, com.baidu.tieba.j.a.r(e));
                }
            }
        }
    }

    private void by(String str, int i) {
        this.kux = null;
        aTQ();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cNw().cNx();
        }
        a(i, this.kuo.getChildCount() > i ? this.kuo.getChildAt(i) : null, (MusicData) this.kus.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kus.setData(list);
        if (this.kus != null) {
            this.kuA = this.kus.cNf();
            this.kuz = this.kuA;
        }
    }

    public String cNT() {
        return this.kux;
    }

    public String cNU() {
        return this.kuC;
    }

    public void cO(View view) {
        this.kut = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kuu = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kuv = (TextView) view.findViewById(R.id.video_voice_text);
        this.kut.setVisibility(8);
        this.kut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kuw = !d.this.kuw;
                if (d.this.kuw) {
                    d.this.kuu.setSelected(false);
                    d.this.kuv.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kuu.setSelected(true);
                    d.this.kuv.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.krH.setMute(!d.this.kuw);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.Z("obj_type", d.this.kuw ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kuw) {
            this.kuu.setSelected(false);
            this.kuv.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kuu.setSelected(true);
        this.kuv.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void sY(boolean z) {
        if (z) {
            this.kut.setVisibility(0);
            if (this.kuD && this.krc == null && !TextUtils.isEmpty(this.kux)) {
                bx(this.kux, this.kuA);
                this.kuD = false;
                if (this.kuA > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kuo.setSelection(d.this.kuA);
                            d.this.kuo.scrollTo(d.this.kuz * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kut.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kuB = true;
        if (this.krc != null && this.krc.isPlaying()) {
            this.krc.pause();
        }
    }

    public void onResume() {
        this.kuB = false;
        if (this.krc != null && this.krH.mCurrentTabIndex == 2) {
            this.krc.start();
            this.krc.seekTo(0);
        }
    }

    private void aTQ() {
        if (this.krc != null) {
            if (this.krc.isPlaying()) {
                this.krc.stop();
            }
            this.krc.release();
            this.krc = null;
        }
        this.kux = null;
        this.kuC = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kuD = true;
            this.kuC = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kux = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kus != null) {
                this.kus.JB(this.kuC);
                this.kuA = this.kus.cNf();
                this.kuy = this.kuA;
                this.kuz = this.kuA;
            }
        }
    }
}
