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
/* loaded from: classes23.dex */
public class e extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private h mSh;
    private MediaPlayer ngP;
    private a nhv;
    private String nkA;
    private HorizontalListView nkj;
    private com.baidu.tieba.video.editvideo.a.c nkn;
    private LinearLayout nko;
    private ImageView nkp;
    private TextView nkq;
    private boolean nkr;
    private String nks;
    private int nkt;
    private int nku;
    private int nkv;
    private boolean nkw;
    private String nkx;
    private boolean nky;
    private String nkz;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.nkr = true;
        this.nkt = 1;
        this.nhv = aVar;
        this.mSh = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nkj = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.nkn = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.nkj.setAdapter((ListAdapter) this.nkn);
        this.nkj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.nkn.dMs() != i || i == e.this.nkt) {
                    e.this.nku = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dNe() {
        return !TextUtils.isEmpty(this.nkx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.nkn.getItem(i);
        if (musicData != null) {
            aq aqVar = new aq("c12423");
            aqVar.dR("obj_id", musicData.id);
            aqVar.aj("obj_locate", i + 1);
            aqVar.aj("obj_source", 2);
            TiebaStatic.log(aqVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.nkn.Kt(i);
                    bce();
                    this.nhv.replay();
                    return;
                case 2:
                    this.nkt = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gz(String str, String str2) {
        this.nkw = false;
        this.nku = this.nkt;
        this.nkx = str2;
        bM(str, this.nkt);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.nkx = musicData.id;
            this.nhv.dMr();
            String Tv = com.baidu.tieba.video.editvideo.model.a.dMH().Tv(musicData.resource);
            if (TextUtils.isEmpty(Tv)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.ngY.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dMH().a(musicData.id, musicData.resource, new a.InterfaceC0845a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                        public void gw(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.ngY.setVisibility(4);
                            e.this.bM(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                        public void Tp(String str) {
                            aVar.ngY.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mSh != null) {
                                e.this.mSh.bD(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                        public void dMb() {
                            aVar.ngY.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dMH().a(musicData.id, musicData.resource, new a.InterfaceC0845a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void gw(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bM(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void Tp(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mSh != null) {
                            e.this.mSh.bD(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0845a
                    public void dMb() {
                    }
                });
                return;
            }
            bM(Tv, i);
        }
    }

    public void replay() {
        this.nkw = false;
        if (this.ngP != null && this.ngP.isPlaying()) {
            this.ngP.pause();
        }
        if (this.ngP != null) {
            this.ngP.start();
            this.ngP.seekTo(0);
        }
    }

    public void gA(String str, String str2) {
        this.nkz = str;
        this.nkA = str2;
        dNk();
    }

    private void dNk() {
        if (!at.isEmpty(this.nkA) && !at.isEmpty(this.nkz)) {
            List<MusicData> data = this.nkn.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.nkA)) {
                            i = i2 + 1;
                        } else {
                            Kw(i2);
                            return;
                        }
                    } else {
                        Kw(1);
                        return;
                    }
                }
            }
        }
    }

    private void Kw(final int i) {
        if (!at.isEmpty(this.nkz)) {
            this.nkv = i;
            if (this.ngP == null) {
                this.ngP = new MediaPlayer();
                this.ngP.setAudioStreamType(3);
            }
            try {
                this.nkx = this.nkA;
                this.nks = this.nkz;
                this.ngP.reset();
                this.ngP.setDataSource(this.nkz);
                this.ngP.prepare();
                this.ngP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nkn.Kt(i);
                        e.this.ngP.setLooping(true);
                    }
                });
                this.ngP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mSh != null) {
                            e.this.mSh.bD(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bN(this.nks, i);
                if (this.mSh != null) {
                    this.mSh.bD(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.nkA = null;
                this.nkz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(String str, final int i) {
        this.nkv = i;
        if (this.nku == this.nkv && !this.nkw) {
            if (this.ngP == null) {
                this.ngP = new MediaPlayer();
                this.ngP.setAudioStreamType(3);
            }
            try {
                this.nks = str;
                this.ngP.reset();
                this.ngP.setDataSource(str);
                this.ngP.prepare();
                this.ngP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.nkn.Kt(i);
                        e.this.ngP.setLooping(true);
                        e.this.ngP.start();
                        e.this.nhv.replay();
                    }
                });
                this.ngP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mSh != null) {
                            e.this.mSh.bD(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bN(str, i);
                if (this.mSh != null) {
                    this.mSh.bD(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bN(String str, int i) {
        this.nks = null;
        bce();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dMH().dMI();
        }
        a(i, this.nkj.getChildCount() > i ? this.nkj.getChildAt(i) : null, (MusicData) this.nkn.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.nkn.setData(list);
        if (this.nkn != null) {
            this.nkv = this.nkn.dMs();
            this.nku = this.nkv;
        }
        dNk();
    }

    public String dNc() {
        return this.nks;
    }

    public String dNd() {
        return this.nkx;
    }

    public void dH(View view) {
        this.nko = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.nkp = (ImageView) view.findViewById(R.id.video_voice_img);
        this.nkq = (TextView) view.findViewById(R.id.video_voice_text);
        this.nko.setVisibility(8);
        this.nko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.xN(!e.this.nkr);
                e.this.nhv.setMute(!e.this.nkr);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.aj("obj_type", e.this.nkr ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        xN(this.nkr);
        this.nhv.setMute(!this.nkr);
    }

    public void xN(boolean z) {
        this.nkr = z;
        if (this.nkr) {
            this.nkp.setSelected(false);
            this.nkq.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.nkp.setSelected(true);
        this.nkq.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xL(boolean z) {
        if (z) {
            this.nko.setVisibility(0);
            if (this.nky && this.ngP == null && !TextUtils.isEmpty(this.nks)) {
                bM(this.nks, this.nkv);
                this.nky = false;
                if (this.nkv > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.nkj.setSelection(e.this.nkv);
                            e.this.nkj.scrollTo(e.this.nku * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.nko.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.nkw = true;
        if (this.ngP != null && this.ngP.isPlaying()) {
            this.ngP.pause();
        }
    }

    public void onResume() {
        this.nkw = false;
        if (this.ngP != null && this.nhv.mCurrentTabIndex == 2) {
            this.ngP.start();
            this.ngP.seekTo(0);
        }
    }

    private void bce() {
        if (this.ngP != null) {
            if (this.ngP.isPlaying()) {
                this.ngP.stop();
            }
            this.ngP.release();
            this.ngP = null;
        }
        this.nks = null;
        this.nkx = null;
    }

    public void am(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.nky = true;
            this.nkx = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.nks = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.nkn != null) {
                this.nkn.Tt(this.nkx);
                this.nkv = this.nkn.dMs();
                this.nkt = this.nkv;
                this.nku = this.nkv;
            }
        }
    }
}
