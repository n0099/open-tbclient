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
    private HorizontalListView kAM;
    private com.baidu.tieba.video.editvideo.a.c kAQ;
    private LinearLayout kAR;
    private ImageView kAS;
    private TextView kAT;
    private boolean kAU;
    private String kAV;
    private int kAW;
    private int kAX;
    private int kAY;
    private boolean kAZ;
    private String kBa;
    private boolean kBb;
    private h kjC;
    private MediaPlayer kxz;
    private a kyf;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.kAU = true;
        this.kAW = 1;
        this.kyf = aVar;
        this.kjC = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kAM = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.kAQ = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.kAM.setAdapter((ListAdapter) this.kAQ);
        this.kAM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.kAQ.cQf() != i || i == d.this.kAW) {
                    d.this.kAX = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cQQ() {
        return !TextUtils.isEmpty(this.kBa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.kAQ.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.cx("obj_id", musicData.id);
            anVar.X("obj_locate", i + 1);
            anVar.X("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.kAQ.DG(i);
                    aWH();
                    this.kyf.replay();
                    return;
                case 2:
                    this.kAW = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eI(String str, String str2) {
        this.kAZ = false;
        this.kAX = this.kAW;
        this.kBa = str2;
        bx(str, this.kAW);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.kBa = musicData.id;
            this.kyf.cQd();
            String Kb = com.baidu.tieba.video.editvideo.model.a.cQt().Kb(musicData.resource);
            if (TextUtils.isEmpty(Kb)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.kxI.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cQt().a(musicData.id, musicData.resource, new a.InterfaceC0621a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                        public void eH(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.kxI.setVisibility(4);
                            d.this.bx(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                        public void JU(String str) {
                            aVar.kxI.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kjC != null) {
                                d.this.kjC.aR(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                        public void cPL() {
                            aVar.kxI.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cQt().a(musicData.id, musicData.resource, new a.InterfaceC0621a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void eH(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bx(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void JU(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.kjC != null) {
                            d.this.kjC.aR(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0621a
                    public void cPL() {
                    }
                });
                return;
            }
            bx(Kb, i);
        }
    }

    public void replay() {
        this.kAZ = false;
        if (this.kxz != null && this.kxz.isPlaying()) {
            this.kxz.pause();
        }
        if (this.kxz != null) {
            this.kxz.start();
            this.kxz.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, final int i) {
        this.kAY = i;
        if (this.kAX == this.kAY && !this.kAZ) {
            if (this.kxz == null) {
                this.kxz = new MediaPlayer();
                this.kxz.setAudioStreamType(3);
            }
            try {
                this.kAV = str;
                this.kxz.reset();
                this.kxz.setDataSource(str);
                this.kxz.prepare();
                this.kxz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.kAQ.DG(i);
                        d.this.kxz.setLooping(true);
                        d.this.kxz.start();
                        d.this.kyf.replay();
                    }
                });
                this.kxz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kjC != null) {
                            d.this.kjC.aR(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                by(str, i);
                if (this.kjC != null) {
                    this.kjC.aR(208, com.baidu.tieba.k.a.q(e));
                }
            }
        }
    }

    private void by(String str, int i) {
        this.kAV = null;
        aWH();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cQt().cQu();
        }
        a(i, this.kAM.getChildCount() > i ? this.kAM.getChildAt(i) : null, (MusicData) this.kAQ.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.kAQ.setData(list);
        if (this.kAQ != null) {
            this.kAY = this.kAQ.cQf();
            this.kAX = this.kAY;
        }
    }

    public String cQO() {
        return this.kAV;
    }

    public String cQP() {
        return this.kBa;
    }

    public void cW(View view) {
        this.kAR = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.kAS = (ImageView) view.findViewById(R.id.video_voice_img);
        this.kAT = (TextView) view.findViewById(R.id.video_voice_text);
        this.kAR.setVisibility(8);
        this.kAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.kAU = !d.this.kAU;
                if (d.this.kAU) {
                    d.this.kAS.setSelected(false);
                    d.this.kAT.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.kAS.setSelected(true);
                    d.this.kAT.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.kyf.setMute(!d.this.kAU);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.X("obj_type", d.this.kAU ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.kAU) {
            this.kAS.setSelected(false);
            this.kAT.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.kAS.setSelected(true);
        this.kAT.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tu(boolean z) {
        if (z) {
            this.kAR.setVisibility(0);
            if (this.kBb && this.kxz == null && !TextUtils.isEmpty(this.kAV)) {
                bx(this.kAV, this.kAY);
                this.kBb = false;
                if (this.kAY > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.kAM.setSelection(d.this.kAY);
                            d.this.kAM.scrollTo(d.this.kAX * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.kAR.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.kAZ = true;
        if (this.kxz != null && this.kxz.isPlaying()) {
            this.kxz.pause();
        }
    }

    public void onResume() {
        this.kAZ = false;
        if (this.kxz != null && this.kyf.mCurrentTabIndex == 2) {
            this.kxz.start();
            this.kxz.seekTo(0);
        }
    }

    private void aWH() {
        if (this.kxz != null) {
            if (this.kxz.isPlaying()) {
                this.kxz.stop();
            }
            this.kxz.release();
            this.kxz = null;
        }
        this.kAV = null;
        this.kBa = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.kBb = true;
            this.kBa = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.kAV = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.kAQ != null) {
                this.kAQ.JZ(this.kBa);
                this.kAY = this.kAQ.cQf();
                this.kAW = this.kAY;
                this.kAX = this.kAY;
            }
        }
    }
}
