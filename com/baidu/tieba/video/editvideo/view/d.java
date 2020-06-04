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
    private MediaPlayer lBM;
    private a lCs;
    private HorizontalListView lFc;
    private com.baidu.tieba.video.editvideo.a.c lFg;
    private LinearLayout lFh;
    private ImageView lFi;
    private TextView lFj;
    private boolean lFk;
    private String lFl;
    private int lFm;
    private int lFn;
    private int lFo;
    private boolean lFp;
    private String lFq;
    private boolean lFr;
    private h lnq;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.lFk = true;
        this.lFm = 1;
        this.lCs = aVar;
        this.lnq = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lFc = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.lFg = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.lFc.setAdapter((ListAdapter) this.lFg);
        this.lFc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.lFg.diC() != i || i == d.this.lFm) {
                    d.this.lFn = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean djo() {
        return !TextUtils.isEmpty(this.lFq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.lFg.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.dh("obj_id", musicData.id);
            anVar.ag("obj_locate", i + 1);
            anVar.ag("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.lFg.EX(i);
                    aJz();
                    this.lCs.replay();
                    return;
                case 2:
                    this.lFm = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fy(String str, String str2) {
        this.lFp = false;
        this.lFn = this.lFm;
        this.lFq = str2;
        bI(str, this.lFm);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.lFq = musicData.id;
            this.lCs.diA();
            String NC = com.baidu.tieba.video.editvideo.model.a.diR().NC(musicData.resource);
            if (TextUtils.isEmpty(NC)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lBV.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.diR().a(musicData.id, musicData.resource, new a.InterfaceC0737a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                        public void fx(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lBV.setVisibility(4);
                            d.this.bI(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                        public void Nu(String str) {
                            aVar.lBV.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.lnq != null) {
                                d.this.lnq.bl(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                        public void dii() {
                            aVar.lBV.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.diR().a(musicData.id, musicData.resource, new a.InterfaceC0737a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void fx(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bI(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void Nu(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.lnq != null) {
                            d.this.lnq.bl(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0737a
                    public void dii() {
                    }
                });
                return;
            }
            bI(NC, i);
        }
    }

    public void replay() {
        this.lFp = false;
        if (this.lBM != null && this.lBM.isPlaying()) {
            this.lBM.pause();
        }
        if (this.lBM != null) {
            this.lBM.start();
            this.lBM.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, final int i) {
        this.lFo = i;
        if (this.lFn == this.lFo && !this.lFp) {
            if (this.lBM == null) {
                this.lBM = new MediaPlayer();
                this.lBM.setAudioStreamType(3);
            }
            try {
                this.lFl = str;
                this.lBM.reset();
                this.lBM.setDataSource(str);
                this.lBM.prepare();
                this.lBM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.lFg.EX(i);
                        d.this.lBM.setLooping(true);
                        d.this.lBM.start();
                        d.this.lCs.replay();
                    }
                });
                this.lBM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.lnq != null) {
                            d.this.lnq.bl(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bJ(str, i);
                if (this.lnq != null) {
                    this.lnq.bl(208, com.baidu.tieba.k.a.t(e));
                }
            }
        }
    }

    private void bJ(String str, int i) {
        this.lFl = null;
        aJz();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.diR().diS();
        }
        a(i, this.lFc.getChildCount() > i ? this.lFc.getChildAt(i) : null, (MusicData) this.lFg.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.lFg.setData(list);
        if (this.lFg != null) {
            this.lFo = this.lFg.diC();
            this.lFn = this.lFo;
        }
    }

    public String djm() {
        return this.lFl;
    }

    public String djn() {
        return this.lFq;
    }

    public void df(View view) {
        this.lFh = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.lFi = (ImageView) view.findViewById(R.id.video_voice_img);
        this.lFj = (TextView) view.findViewById(R.id.video_voice_text);
        this.lFh.setVisibility(8);
        this.lFh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.lFk = !d.this.lFk;
                if (d.this.lFk) {
                    d.this.lFi.setSelected(false);
                    d.this.lFj.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.lFi.setSelected(true);
                    d.this.lFj.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.lCs.setMute(!d.this.lFk);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.ag("obj_type", d.this.lFk ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.lFk) {
            this.lFi.setSelected(false);
            this.lFj.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.lFi.setSelected(true);
        this.lFj.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uT(boolean z) {
        if (z) {
            this.lFh.setVisibility(0);
            if (this.lFr && this.lBM == null && !TextUtils.isEmpty(this.lFl)) {
                bI(this.lFl, this.lFo);
                this.lFr = false;
                if (this.lFo > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.lFc.setSelection(d.this.lFo);
                            d.this.lFc.scrollTo(d.this.lFn * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.lFh.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.lFp = true;
        if (this.lBM != null && this.lBM.isPlaying()) {
            this.lBM.pause();
        }
    }

    public void onResume() {
        this.lFp = false;
        if (this.lBM != null && this.lCs.mCurrentTabIndex == 2) {
            this.lBM.start();
            this.lBM.seekTo(0);
        }
    }

    private void aJz() {
        if (this.lBM != null) {
            if (this.lBM.isPlaying()) {
                this.lBM.stop();
            }
            this.lBM.release();
            this.lBM = null;
        }
        this.lFl = null;
        this.lFq = null;
    }

    public void al(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.lFr = true;
            this.lFq = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.lFl = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.lFg != null) {
                this.lFg.NA(this.lFq);
                this.lFo = this.lFg.diC();
                this.lFm = this.lFo;
                this.lFn = this.lFo;
            }
        }
    }
}
