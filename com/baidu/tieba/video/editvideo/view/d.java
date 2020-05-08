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
    private h kTM;
    private MediaPlayer lhS;
    private a liy;
    private HorizontalListView llj;
    private com.baidu.tieba.video.editvideo.a.c lln;
    private LinearLayout llo;
    private ImageView llp;
    private TextView llq;
    private boolean llr;
    private String lls;
    private int llt;
    private int llu;
    private int llv;
    private boolean llw;
    private String llx;
    private boolean lly;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.llr = true;
        this.llt = 1;
        this.liy = aVar;
        this.kTM = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.llj = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.lln = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.llj.setAdapter((ListAdapter) this.lln);
        this.llj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.lln.daY() != i || i == d.this.llt) {
                    d.this.llu = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dbK() {
        return !TextUtils.isEmpty(this.llx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.lln.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.cI("obj_id", musicData.id);
            anVar.af("obj_locate", i + 1);
            anVar.af("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.lln.Ek(i);
                    beL();
                    this.liy.replay();
                    return;
                case 2:
                    this.llt = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eX(String str, String str2) {
        this.llw = false;
        this.llu = this.llt;
        this.llx = str2;
        bH(str, this.llt);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.llx = musicData.id;
            this.liy.daW();
            String LO = com.baidu.tieba.video.editvideo.model.a.dbn().LO(musicData.resource);
            if (TextUtils.isEmpty(LO)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lib.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dbn().a(musicData.id, musicData.resource, new a.InterfaceC0683a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                        public void eW(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lib.setVisibility(4);
                            d.this.bH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                        public void LG(String str) {
                            aVar.lib.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kTM != null) {
                                d.this.kTM.bg(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                        public void daE() {
                            aVar.lib.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dbn().a(musicData.id, musicData.resource, new a.InterfaceC0683a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void eW(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void LG(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.kTM != null) {
                            d.this.kTM.bg(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0683a
                    public void daE() {
                    }
                });
                return;
            }
            bH(LO, i);
        }
    }

    public void replay() {
        this.llw = false;
        if (this.lhS != null && this.lhS.isPlaying()) {
            this.lhS.pause();
        }
        if (this.lhS != null) {
            this.lhS.start();
            this.lhS.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, final int i) {
        this.llv = i;
        if (this.llu == this.llv && !this.llw) {
            if (this.lhS == null) {
                this.lhS = new MediaPlayer();
                this.lhS.setAudioStreamType(3);
            }
            try {
                this.lls = str;
                this.lhS.reset();
                this.lhS.setDataSource(str);
                this.lhS.prepare();
                this.lhS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.lln.Ek(i);
                        d.this.lhS.setLooping(true);
                        d.this.lhS.start();
                        d.this.liy.replay();
                    }
                });
                this.lhS.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kTM != null) {
                            d.this.kTM.bg(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bI(str, i);
                if (this.kTM != null) {
                    this.kTM.bg(208, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    private void bI(String str, int i) {
        this.lls = null;
        beL();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dbn().dbo();
        }
        a(i, this.llj.getChildCount() > i ? this.llj.getChildAt(i) : null, (MusicData) this.lln.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.lln.setData(list);
        if (this.lln != null) {
            this.llv = this.lln.daY();
            this.llu = this.llv;
        }
    }

    public String dbI() {
        return this.lls;
    }

    public String dbJ() {
        return this.llx;
    }

    public void de(View view) {
        this.llo = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.llp = (ImageView) view.findViewById(R.id.video_voice_img);
        this.llq = (TextView) view.findViewById(R.id.video_voice_text);
        this.llo.setVisibility(8);
        this.llo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.llr = !d.this.llr;
                if (d.this.llr) {
                    d.this.llp.setSelected(false);
                    d.this.llq.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.llp.setSelected(true);
                    d.this.llq.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.liy.setMute(!d.this.llr);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.af("obj_type", d.this.llr ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.llr) {
            this.llp.setSelected(false);
            this.llq.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.llp.setSelected(true);
        this.llq.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uv(boolean z) {
        if (z) {
            this.llo.setVisibility(0);
            if (this.lly && this.lhS == null && !TextUtils.isEmpty(this.lls)) {
                bH(this.lls, this.llv);
                this.lly = false;
                if (this.llv > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.llj.setSelection(d.this.llv);
                            d.this.llj.scrollTo(d.this.llu * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.llo.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.llw = true;
        if (this.lhS != null && this.lhS.isPlaying()) {
            this.lhS.pause();
        }
    }

    public void onResume() {
        this.llw = false;
        if (this.lhS != null && this.liy.mCurrentTabIndex == 2) {
            this.lhS.start();
            this.lhS.seekTo(0);
        }
    }

    private void beL() {
        if (this.lhS != null) {
            if (this.lhS.isPlaying()) {
                this.lhS.stop();
            }
            this.lhS.release();
            this.lhS = null;
        }
        this.lls = null;
        this.llx = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.lly = true;
            this.llx = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.lls = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.lln != null) {
                this.lln.LM(this.llx);
                this.llv = this.lln.daY();
                this.llt = this.llv;
                this.llu = this.llv;
            }
        }
    }
}
