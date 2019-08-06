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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
    private h jhv;
    private MediaPlayer jvI;
    private a jwo;
    private HorizontalListView jza;
    private com.baidu.tieba.video.editvideo.a.c jze;
    private LinearLayout jzf;
    private ImageView jzg;
    private TextView jzh;
    private boolean jzi;
    private String jzj;
    private int jzk;
    private int jzl;
    private int jzm;
    private boolean jzn;
    private String jzo;
    private boolean jzp;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jzi = true;
        this.jzk = 1;
        this.jwo = aVar;
        this.jhv = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jza = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jze = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jza.setAdapter((ListAdapter) this.jze);
        this.jza.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jze.cuD() != i || i == d.this.jzk) {
                    d.this.jzl = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean cvu() {
        return !TextUtils.isEmpty(this.jzo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jze.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, musicData.id);
            anVar.P("obj_locate", i + 1);
            anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.jze.Ci(i);
                    aBC();
                    this.jwo.replay();
                    return;
                case 2:
                    this.jzk = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void et(String str, String str2) {
        this.jzn = false;
        this.jzl = this.jzk;
        this.jzo = str2;
        br(str, this.jzk);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jzo = musicData.id;
            this.jwo.cuC();
            String FN = com.baidu.tieba.video.editvideo.model.a.cuV().FN(musicData.resource);
            if (TextUtils.isEmpty(FN)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.jvR.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.cuV().a(musicData.id, musicData.resource, new a.InterfaceC0422a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void es(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.jvR.setVisibility(4);
                            d.this.br(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void FF(String str) {
                            aVar.jvR.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.jhv != null) {
                                d.this.jhv.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                        public void cuj() {
                            aVar.jvR.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.cuV().a(musicData.id, musicData.resource, new a.InterfaceC0422a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void es(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.br(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void FF(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.jhv != null) {
                            d.this.jhv.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0422a
                    public void cuj() {
                    }
                });
                return;
            }
            br(FN, i);
        }
    }

    public void replay() {
        this.jzn = false;
        if (this.jvI != null && this.jvI.isPlaying()) {
            this.jvI.pause();
        }
        if (this.jvI != null) {
            this.jvI.start();
            this.jvI.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(String str, final int i) {
        this.jzm = i;
        if (this.jzl == this.jzm && !this.jzn) {
            if (this.jvI == null) {
                this.jvI = new MediaPlayer();
                this.jvI.setAudioStreamType(3);
            }
            try {
                this.jzj = str;
                this.jvI.reset();
                this.jvI.setDataSource(str);
                this.jvI.prepare();
                this.jvI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jze.Ci(i);
                        d.this.jvI.setLooping(true);
                        d.this.jvI.start();
                        d.this.jwo.replay();
                    }
                });
                this.jvI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.jhv != null) {
                            d.this.jhv.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bs(str, i);
                if (this.jhv != null) {
                    this.jhv.ax(208, com.baidu.tieba.j.a.p(e));
                }
            }
        }
    }

    private void bs(String str, int i) {
        this.jzj = null;
        aBC();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.cuV().cuW();
        }
        a(i, this.jza.getChildCount() > i ? this.jza.getChildAt(i) : null, (MusicData) this.jze.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jze.setData(list);
        if (this.jze != null) {
            this.jzm = this.jze.cuD();
            this.jzl = this.jzm;
        }
    }

    public String cvs() {
        return this.jzj;
    }

    public String cvt() {
        return this.jzo;
    }

    public void cX(View view) {
        this.jzf = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jzg = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jzh = (TextView) view.findViewById(R.id.video_voice_text);
        this.jzf.setVisibility(8);
        this.jzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jzi = !d.this.jzi;
                if (d.this.jzi) {
                    d.this.jzg.setSelected(false);
                    d.this.jzh.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jzg.setSelected(true);
                    d.this.jzh.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jwo.setMute(!d.this.jzi);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.P("obj_type", d.this.jzi ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.jzi) {
            this.jzg.setSelected(false);
            this.jzh.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jzg.setSelected(true);
        this.jzh.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rF(boolean z) {
        if (z) {
            this.jzf.setVisibility(0);
            if (this.jzp && this.jvI == null && !TextUtils.isEmpty(this.jzj)) {
                br(this.jzj, this.jzm);
                this.jzp = false;
                if (this.jzm > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jza.setSelection(d.this.jzm);
                            d.this.jza.scrollTo(d.this.jzl * l.g(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jzf.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jzn = true;
        if (this.jvI != null && this.jvI.isPlaying()) {
            this.jvI.pause();
        }
    }

    public void onResume() {
        this.jzn = false;
        if (this.jvI != null && this.jwo.mCurrentTabIndex == 2) {
            this.jvI.start();
            this.jvI.seekTo(0);
        }
    }

    private void aBC() {
        if (this.jvI != null) {
            if (this.jvI.isPlaying()) {
                this.jvI.stop();
            }
            this.jvI.release();
            this.jvI = null;
        }
        this.jzj = null;
        this.jzo = null;
    }

    public void aA(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jzp = true;
            this.jzo = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jzj = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jze != null) {
                this.jze.FL(this.jzo);
                this.jzm = this.jze.cuD();
                this.jzk = this.jzm;
                this.jzl = this.jzm;
            }
        }
    }
}
