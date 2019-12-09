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
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private com.baidu.tieba.video.editvideo.a.c jAB;
    private LinearLayout jAC;
    private ImageView jAD;
    private TextView jAE;
    private boolean jAF;
    private String jAG;
    private int jAH;
    private int jAI;
    private int jAJ;
    private boolean jAK;
    private String jAL;
    private boolean jAM;
    private HorizontalListView jAx;
    private h jiP;
    private a jxL;
    private MediaPlayer jxf;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jAF = true;
        this.jAH = 1;
        this.jxL = aVar;
        this.jiP = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jAx = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jAB = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jAx.setAdapter((ListAdapter) this.jAB);
        this.jAx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jAB.ctd() != i || i == d.this.jAH) {
                    d.this.jAI = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean ctU() {
        return !TextUtils.isEmpty(this.jAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jAB.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.bS("obj_id", musicData.id);
            anVar.O("obj_locate", i + 1);
            anVar.O("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.jAB.AR(i);
                    aBY();
                    this.jxL.replay();
                    return;
                case 2:
                    this.jAH = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eg(String str, String str2) {
        this.jAK = false;
        this.jAI = this.jAH;
        this.jAL = str2;
        bo(str, this.jAH);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jAL = musicData.id;
            this.jxL.ctc();
            String EP = com.baidu.tieba.video.editvideo.model.a.ctv().EP(musicData.resource);
            if (TextUtils.isEmpty(EP)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.jxo.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.ctv().a(musicData.id, musicData.resource, new a.InterfaceC0523a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                        public void ef(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.jxo.setVisibility(4);
                            d.this.bo(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                        public void EH(String str) {
                            aVar.jxo.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.jiP != null) {
                                d.this.jiP.aw(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                        public void csK() {
                            aVar.jxo.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.ctv().a(musicData.id, musicData.resource, new a.InterfaceC0523a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void ef(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bo(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void EH(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.jiP != null) {
                            d.this.jiP.aw(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0523a
                    public void csK() {
                    }
                });
                return;
            }
            bo(EP, i);
        }
    }

    public void replay() {
        this.jAK = false;
        if (this.jxf != null && this.jxf.isPlaying()) {
            this.jxf.pause();
        }
        if (this.jxf != null) {
            this.jxf.start();
            this.jxf.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, final int i) {
        this.jAJ = i;
        if (this.jAI == this.jAJ && !this.jAK) {
            if (this.jxf == null) {
                this.jxf = new MediaPlayer();
                this.jxf.setAudioStreamType(3);
            }
            try {
                this.jAG = str;
                this.jxf.reset();
                this.jxf.setDataSource(str);
                this.jxf.prepare();
                this.jxf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jAB.AR(i);
                        d.this.jxf.setLooping(true);
                        d.this.jxf.start();
                        d.this.jxL.replay();
                    }
                });
                this.jxf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.jiP != null) {
                            d.this.jiP.aw(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bp(str, i);
                if (this.jiP != null) {
                    this.jiP.aw(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void bp(String str, int i) {
        this.jAG = null;
        aBY();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.ctv().ctw();
        }
        a(i, this.jAx.getChildCount() > i ? this.jAx.getChildAt(i) : null, (MusicData) this.jAB.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jAB.setData(list);
        if (this.jAB != null) {
            this.jAJ = this.jAB.ctd();
            this.jAI = this.jAJ;
        }
    }

    public String ctS() {
        return this.jAG;
    }

    public String ctT() {
        return this.jAL;
    }

    public void cT(View view) {
        this.jAC = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jAD = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jAE = (TextView) view.findViewById(R.id.video_voice_text);
        this.jAC.setVisibility(8);
        this.jAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jAF = !d.this.jAF;
                if (d.this.jAF) {
                    d.this.jAD.setSelected(false);
                    d.this.jAE.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jAD.setSelected(true);
                    d.this.jAE.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jxL.setMute(!d.this.jAF);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.O("obj_type", d.this.jAF ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.jAF) {
            this.jAD.setSelected(false);
            this.jAE.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jAD.setSelected(true);
        this.jAE.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
        if (z) {
            this.jAC.setVisibility(0);
            if (this.jAM && this.jxf == null && !TextUtils.isEmpty(this.jAG)) {
                bo(this.jAG, this.jAJ);
                this.jAM = false;
                if (this.jAJ > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jAx.setSelection(d.this.jAJ);
                            d.this.jAx.scrollTo(d.this.jAI * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jAC.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jAK = true;
        if (this.jxf != null && this.jxf.isPlaying()) {
            this.jxf.pause();
        }
    }

    public void onResume() {
        this.jAK = false;
        if (this.jxf != null && this.jxL.mCurrentTabIndex == 2) {
            this.jxf.start();
            this.jxf.seekTo(0);
        }
    }

    private void aBY() {
        if (this.jxf != null) {
            if (this.jxf.isPlaying()) {
                this.jxf.stop();
            }
            this.jxf.release();
            this.jxf = null;
        }
        this.jAG = null;
        this.jAL = null;
    }

    public void aH(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jAM = true;
            this.jAL = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jAG = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jAB != null) {
                this.jAB.EN(this.jAL);
                this.jAJ = this.jAB.ctd();
                this.jAH = this.jAJ;
                this.jAI = this.jAJ;
            }
        }
    }
}
