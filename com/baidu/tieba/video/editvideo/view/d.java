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
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes10.dex */
public class d extends com.baidu.adp.base.c {
    private h khZ;
    private MediaPlayer kvV;
    private a kwA;
    private HorizontalListView kzf;
    private com.baidu.tieba.video.editvideo.a.c kzj;
    private LinearLayout kzk;
    private ImageView kzl;
    private TextView kzm;
    private boolean kzn;
    private String kzo;
    private int kzp;
    private int kzq;
    private int kzr;
    private boolean kzs;
    private String kzt;
    private boolean kzu;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kzn = true;
        this.kzp = 1;
        this.kwA = aVar;
        this.khZ = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kzf = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kzj = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kzf.setAdapter((ListAdapter) this.kzj);
        this.kzf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kzj.cPL() != i || i == d.this.kzp) {
                    d.this.kzq = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cQw() {
        return !TextUtils.isEmpty(this.kzt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kzj.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.cy("obj_id", musicData.id);
            anVar.X("obj_locate", i + 1);
            anVar.X("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.kzj.Dy(i);
                    aWD();
                    this.kwA.replay();
                    return;
                case 2:
                    this.kzp = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eK(String str, String str2) {
        this.kzs = false;
        this.kzq = this.kzp;
        this.kzt = str2;
        bx(str, this.kzp);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kzt = musicData.id;
            this.kwA.cPJ();
            String Kb = com.baidu.tieba.video.editvideo.model.a.cPZ().Kb(musicData.resource);
            if (TextUtils.isEmpty(Kb)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kwe.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cPZ().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void eJ(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kwe.setVisibility(4);
                            d.this.bx(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void JU(String str) {
                            aVar.kwe.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.khZ != null) {
                                d.this.khZ.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                        public void cPr() {
                            aVar.kwe.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cPZ().a(musicData.id, musicData.resource, new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void eJ(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bx(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void JU(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.khZ != null) {
                            d.this.khZ.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0620a
                    public void cPr() {
                    }
                });
                return;
            }
            bx(Kb, i);
        }
    }

    public void replay() {
        this.kzs = false;
        if (this.kvV != null && this.kvV.isPlaying()) {
            this.kvV.pause();
        }
        if (this.kvV != null) {
            this.kvV.start();
            this.kvV.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, final int i) {
        this.kzr = i;
        if (this.kzq == this.kzr && !this.kzs) {
            if (this.kvV == null) {
                this.kvV = new MediaPlayer();
                this.kvV.setAudioStreamType(3);
            }
            try {
                this.kzo = str;
                this.kvV.reset();
                this.kvV.setDataSource(str);
                this.kvV.prepare();
                this.kvV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kzj.Dy(i);
                        d.this.kvV.setLooping(true);
                        d.this.kvV.start();
                        d.this.kwA.replay();
                    }
                });
                this.kvV.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.khZ != null) {
                            d.this.khZ.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                by(str, i);
                if (this.khZ != null) {
                    this.khZ.aR(208, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    private void by(String str, int i) {
        this.kzo = null;
        aWD();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cPZ().cQa();
        }
        a(i, this.kzf.getChildCount() > i ? this.kzf.getChildAt(i) : null, (MusicData) this.kzj.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kzj.setData(list);
        if (this.kzj != null) {
            this.kzr = this.kzj.cPL();
            this.kzq = this.kzr;
        }
    }

    public String cQu() {
        return this.kzo;
    }

    public String cQv() {
        return this.kzt;
    }

    public void cW(View view) {
        this.kzk = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kzl = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kzm = (TextView) view.findViewById(R.id.video_voice_text);
        this.kzk.setVisibility(8);
        this.kzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kzn = !d.this.kzn;
                if (d.this.kzn) {
                    d.this.kzl.setSelected(false);
                    d.this.kzm.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kzl.setSelected(true);
                    d.this.kzm.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kwA.setMute(!d.this.kzn);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.X("obj_type", d.this.kzn ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kzn) {
            this.kzl.setSelected(false);
            this.kzm.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kzl.setSelected(true);
        this.kzm.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void to(boolean z) {
        if (z) {
            this.kzk.setVisibility(0);
            if (this.kzu && this.kvV == null && !TextUtils.isEmpty(this.kzo)) {
                bx(this.kzo, this.kzr);
                this.kzu = false;
                if (this.kzr > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kzf.setSelection(d.this.kzr);
                            d.this.kzf.scrollTo(d.this.kzq * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kzk.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kzs = true;
        if (this.kvV != null && this.kvV.isPlaying()) {
            this.kvV.pause();
        }
    }

    public void onResume() {
        this.kzs = false;
        if (this.kvV != null && this.kwA.mCurrentTabIndex == 2) {
            this.kvV.start();
            this.kvV.seekTo(0);
        }
    }

    private void aWD() {
        if (this.kvV != null) {
            if (this.kvV.isPlaying()) {
                this.kvV.stop();
            }
            this.kvV.release();
            this.kvV = null;
        }
        this.kzo = null;
        this.kzt = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kzu = true;
            this.kzt = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kzo = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kzj != null) {
                this.kzj.JZ(this.kzt);
                this.kzr = this.kzj.cPL();
                this.kzp = this.kzr;
                this.kzq = this.kzr;
            }
        }
    }
}
