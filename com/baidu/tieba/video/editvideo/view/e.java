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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes17.dex */
public class e extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private h mgf;
    private MediaPlayer muy;
    private a mve;
    private HorizontalListView mxU;
    private com.baidu.tieba.video.editvideo.a.c mxY;
    private LinearLayout mxZ;
    private ImageView mya;
    private TextView myb;
    private boolean myc;
    private String myd;
    private int mye;
    private int myf;
    private int myg;
    private boolean myh;
    private String myi;
    private boolean myj;
    private String myk;
    private String myl;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.myc = true;
        this.mye = 1;
        this.mve = aVar;
        this.mgf = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mxU = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mxY = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mxU.setAdapter((ListAdapter) this.mxY);
        this.mxU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.mxY.dBv() != i || i == e.this.mye) {
                    e.this.myf = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dCh() {
        return !TextUtils.isEmpty(this.myi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.mxY.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dD("obj_id", musicData.id);
            aqVar.ai("obj_locate", i + 1);
            aqVar.ai("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.mxY.IR(i);
                    aWR();
                    this.mve.replay();
                    return;
                case 2:
                    this.mye = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void ga(String str, String str2) {
        this.myh = false;
        this.myf = this.mye;
        this.myi = str2;
        bK(str, this.mye);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.myi = musicData.id;
            this.mve.dBu();
            String RI = com.baidu.tieba.video.editvideo.model.a.dBK().RI(musicData.resource);
            if (TextUtils.isEmpty(RI)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.muH.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dBK().a(musicData.id, musicData.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void fX(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.muH.setVisibility(4);
                            e.this.bK(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void RC(String str) {
                            aVar.muH.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mgf != null) {
                                e.this.mgf.bp(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void dBe() {
                            aVar.muH.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dBK().a(musicData.id, musicData.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void fX(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bK(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void RC(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mgf != null) {
                            e.this.mgf.bp(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void dBe() {
                    }
                });
                return;
            }
            bK(RI, i);
        }
    }

    public void replay() {
        this.myh = false;
        if (this.muy != null && this.muy.isPlaying()) {
            this.muy.pause();
        }
        if (this.muy != null) {
            this.muy.start();
            this.muy.seekTo(0);
        }
    }

    public void gb(String str, String str2) {
        this.myk = str;
        this.myl = str2;
        dCn();
    }

    private void dCn() {
        if (!at.isEmpty(this.myl) && !at.isEmpty(this.myk)) {
            List<MusicData> data = this.mxY.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.myl)) {
                            i = i2 + 1;
                        } else {
                            IU(i2);
                            return;
                        }
                    } else {
                        IU(1);
                        return;
                    }
                }
            }
        }
    }

    private void IU(final int i) {
        if (!at.isEmpty(this.myk)) {
            this.myg = i;
            if (this.muy == null) {
                this.muy = new MediaPlayer();
                this.muy.setAudioStreamType(3);
            }
            try {
                this.myi = this.myl;
                this.myd = this.myk;
                this.muy.reset();
                this.muy.setDataSource(this.myk);
                this.muy.prepare();
                this.muy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mxY.IR(i);
                        e.this.muy.setLooping(true);
                    }
                });
                this.muy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mgf != null) {
                            e.this.mgf.bp(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(this.myd, i);
                if (this.mgf != null) {
                    this.mgf.bp(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.myl = null;
                this.myk = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(String str, final int i) {
        this.myg = i;
        if (this.myf == this.myg && !this.myh) {
            if (this.muy == null) {
                this.muy = new MediaPlayer();
                this.muy.setAudioStreamType(3);
            }
            try {
                this.myd = str;
                this.muy.reset();
                this.muy.setDataSource(str);
                this.muy.prepare();
                this.muy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mxY.IR(i);
                        e.this.muy.setLooping(true);
                        e.this.muy.start();
                        e.this.mve.replay();
                    }
                });
                this.muy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mgf != null) {
                            e.this.mgf.bp(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(str, i);
                if (this.mgf != null) {
                    this.mgf.bp(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bL(String str, int i) {
        this.myd = null;
        aWR();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dBK().dBL();
        }
        a(i, this.mxU.getChildCount() > i ? this.mxU.getChildAt(i) : null, (MusicData) this.mxY.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.mxY.setData(list);
        if (this.mxY != null) {
            this.myg = this.mxY.dBv();
            this.myf = this.myg;
        }
        dCn();
    }

    public String dCf() {
        return this.myd;
    }

    public String dCg() {
        return this.myi;
    }

    public void dq(View view) {
        this.mxZ = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mya = (ImageView) view.findViewById(R.id.video_voice_img);
        this.myb = (TextView) view.findViewById(R.id.video_voice_text);
        this.mxZ.setVisibility(8);
        this.mxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.wE(!e.this.myc);
                e.this.mve.setMute(!e.this.myc);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.ai("obj_type", e.this.myc ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        wE(this.myc);
        this.mve.setMute(!this.myc);
    }

    public void wE(boolean z) {
        this.myc = z;
        if (this.myc) {
            this.mya.setSelected(false);
            this.myb.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mya.setSelected(true);
        this.myb.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wC(boolean z) {
        if (z) {
            this.mxZ.setVisibility(0);
            if (this.myj && this.muy == null && !TextUtils.isEmpty(this.myd)) {
                bK(this.myd, this.myg);
                this.myj = false;
                if (this.myg > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mxU.setSelection(e.this.myg);
                            e.this.mxU.scrollTo(e.this.myf * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.mxZ.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.myh = true;
        if (this.muy != null && this.muy.isPlaying()) {
            this.muy.pause();
        }
    }

    public void onResume() {
        this.myh = false;
        if (this.muy != null && this.mve.mCurrentTabIndex == 2) {
            this.muy.start();
            this.muy.seekTo(0);
        }
    }

    private void aWR() {
        if (this.muy != null) {
            if (this.muy.isPlaying()) {
                this.muy.stop();
            }
            this.muy.release();
            this.muy = null;
        }
        this.myd = null;
        this.myi = null;
    }

    public void ap(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.myj = true;
            this.myi = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.myd = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.mxY != null) {
                this.mxY.RG(this.myi);
                this.myg = this.mxY.dBv();
                this.mye = this.myg;
                this.myf = this.myg;
            }
        }
    }
}
