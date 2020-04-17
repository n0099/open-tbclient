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
    private h kTI;
    private MediaPlayer lhO;
    private a liu;
    private HorizontalListView llf;
    private com.baidu.tieba.video.editvideo.a.c llj;
    private LinearLayout llk;
    private ImageView lll;
    private TextView llm;
    private boolean lln;
    private String llo;
    private int llp;
    private int llq;
    private int llr;
    private boolean lls;
    private String llt;
    private boolean llu;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.lln = true;
        this.llp = 1;
        this.liu = aVar;
        this.kTI = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.llf = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.llj = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.llf.setAdapter((ListAdapter) this.llj);
        this.llf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.llj.dbb() != i || i == d.this.llp) {
                    d.this.llq = i;
                    d.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dbN() {
        return !TextUtils.isEmpty(this.llt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.llj.getItem(i);
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
                    this.llj.Ek(i);
                    beN();
                    this.liu.replay();
                    return;
                case 2:
                    this.llp = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eX(String str, String str2) {
        this.lls = false;
        this.llq = this.llp;
        this.llt = str2;
        bH(str, this.llp);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.llt = musicData.id;
            this.liu.daZ();
            String LL = com.baidu.tieba.video.editvideo.model.a.dbq().LL(musicData.resource);
            if (TextUtils.isEmpty(LL)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.lhX.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dbq().a(musicData.id, musicData.resource, new a.InterfaceC0662a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                        public void eW(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.lhX.setVisibility(4);
                            d.this.bH(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                        public void LD(String str) {
                            aVar.lhX.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.kTI != null) {
                                d.this.kTI.bg(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                        public void daH() {
                            aVar.lhX.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dbq().a(musicData.id, musicData.resource, new a.InterfaceC0662a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void eW(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bH(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void LD(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.kTI != null) {
                            d.this.kTI.bg(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0662a
                    public void daH() {
                    }
                });
                return;
            }
            bH(LL, i);
        }
    }

    public void replay() {
        this.lls = false;
        if (this.lhO != null && this.lhO.isPlaying()) {
            this.lhO.pause();
        }
        if (this.lhO != null) {
            this.lhO.start();
            this.lhO.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, final int i) {
        this.llr = i;
        if (this.llq == this.llr && !this.lls) {
            if (this.lhO == null) {
                this.lhO = new MediaPlayer();
                this.lhO.setAudioStreamType(3);
            }
            try {
                this.llo = str;
                this.lhO.reset();
                this.lhO.setDataSource(str);
                this.lhO.prepare();
                this.lhO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.llj.Ek(i);
                        d.this.lhO.setLooping(true);
                        d.this.lhO.start();
                        d.this.liu.replay();
                    }
                });
                this.lhO.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.kTI != null) {
                            d.this.kTI.bg(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bI(str, i);
                if (this.kTI != null) {
                    this.kTI.bg(208, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    private void bI(String str, int i) {
        this.llo = null;
        beN();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dbq().dbr();
        }
        a(i, this.llf.getChildCount() > i ? this.llf.getChildAt(i) : null, (MusicData) this.llj.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.llj.setData(list);
        if (this.llj != null) {
            this.llr = this.llj.dbb();
            this.llq = this.llr;
        }
    }

    public String dbL() {
        return this.llo;
    }

    public String dbM() {
        return this.llt;
    }

    public void de(View view) {
        this.llk = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.lll = (ImageView) view.findViewById(R.id.video_voice_img);
        this.llm = (TextView) view.findViewById(R.id.video_voice_text);
        this.llk.setVisibility(8);
        this.llk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.lln = !d.this.lln;
                if (d.this.lln) {
                    d.this.lll.setSelected(false);
                    d.this.llm.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.lll.setSelected(true);
                    d.this.llm.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.liu.setMute(!d.this.lln);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.af("obj_type", d.this.lln ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.lln) {
            this.lll.setSelected(false);
            this.llm.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.lll.setSelected(true);
        this.llm.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uv(boolean z) {
        if (z) {
            this.llk.setVisibility(0);
            if (this.llu && this.lhO == null && !TextUtils.isEmpty(this.llo)) {
                bH(this.llo, this.llr);
                this.llu = false;
                if (this.llr > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.llf.setSelection(d.this.llr);
                            d.this.llf.scrollTo(d.this.llq * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.llk.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.lls = true;
        if (this.lhO != null && this.lhO.isPlaying()) {
            this.lhO.pause();
        }
    }

    public void onResume() {
        this.lls = false;
        if (this.lhO != null && this.liu.mCurrentTabIndex == 2) {
            this.lhO.start();
            this.lhO.seekTo(0);
        }
    }

    private void beN() {
        if (this.lhO != null) {
            if (this.lhO.isPlaying()) {
                this.lhO.stop();
            }
            this.lhO.release();
            this.lhO = null;
        }
        this.llo = null;
        this.llt = null;
    }

    public void az(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.llu = true;
            this.llt = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.llo = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.llj != null) {
                this.llj.LJ(this.llt);
                this.llr = this.llj.dbb();
                this.llp = this.llr;
                this.llq = this.llr;
            }
        }
    }
}
