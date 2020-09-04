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
    private h mgu;
    private MediaPlayer muQ;
    private a mvw;
    private String myA;
    private boolean myB;
    private String myC;
    private String myD;
    private HorizontalListView mym;
    private com.baidu.tieba.video.editvideo.a.c myq;
    private LinearLayout myr;
    private ImageView mys;
    private TextView myt;
    private boolean myu;
    private String myv;
    private int myw;
    private int myx;
    private int myy;
    private boolean myz;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.myu = true;
        this.myw = 1;
        this.mvw = aVar;
        this.mgu = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mym = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.myq = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mym.setAdapter((ListAdapter) this.myq);
        this.mym.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.myq.dBE() != i || i == e.this.myw) {
                    e.this.myx = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dCq() {
        return !TextUtils.isEmpty(this.myA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.myq.getItem(i);
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
                    this.myq.IR(i);
                    aWR();
                    this.mvw.replay();
                    return;
                case 2:
                    this.myw = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void gb(String str, String str2) {
        this.myz = false;
        this.myx = this.myw;
        this.myA = str2;
        bK(str, this.myw);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.myA = musicData.id;
            this.mvw.dBD();
            String RI = com.baidu.tieba.video.editvideo.model.a.dBT().RI(musicData.resource);
            if (TextUtils.isEmpty(RI)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.muZ.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dBT().a(musicData.id, musicData.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void fY(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.muZ.setVisibility(4);
                            e.this.bK(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void RC(String str) {
                            aVar.muZ.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.mgu != null) {
                                e.this.mgu.bo(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                        public void dBn() {
                            aVar.muZ.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dBT().a(musicData.id, musicData.resource, new a.InterfaceC0815a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void fY(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bK(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void RC(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.mgu != null) {
                            e.this.mgu.bo(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0815a
                    public void dBn() {
                    }
                });
                return;
            }
            bK(RI, i);
        }
    }

    public void replay() {
        this.myz = false;
        if (this.muQ != null && this.muQ.isPlaying()) {
            this.muQ.pause();
        }
        if (this.muQ != null) {
            this.muQ.start();
            this.muQ.seekTo(0);
        }
    }

    public void gc(String str, String str2) {
        this.myC = str;
        this.myD = str2;
        dCw();
    }

    private void dCw() {
        if (!at.isEmpty(this.myD) && !at.isEmpty(this.myC)) {
            List<MusicData> data = this.myq.getData();
            if (!y.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !at.equals(data.get(i2).id, this.myD)) {
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
        if (!at.isEmpty(this.myC)) {
            this.myy = i;
            if (this.muQ == null) {
                this.muQ = new MediaPlayer();
                this.muQ.setAudioStreamType(3);
            }
            try {
                this.myA = this.myD;
                this.myv = this.myC;
                this.muQ.reset();
                this.muQ.setDataSource(this.myC);
                this.muQ.prepare();
                this.muQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.myq.IR(i);
                        e.this.muQ.setLooping(true);
                    }
                });
                this.muQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mgu != null) {
                            e.this.mgu.bo(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(this.myv, i);
                if (this.mgu != null) {
                    this.mgu.bo(208, com.baidu.tieba.k.a.r(e));
                }
            } finally {
                this.myD = null;
                this.myC = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(String str, final int i) {
        this.myy = i;
        if (this.myx == this.myy && !this.myz) {
            if (this.muQ == null) {
                this.muQ = new MediaPlayer();
                this.muQ.setAudioStreamType(3);
            }
            try {
                this.myv = str;
                this.muQ.reset();
                this.muQ.setDataSource(str);
                this.muQ.prepare();
                this.muQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.myq.IR(i);
                        e.this.muQ.setLooping(true);
                        e.this.muQ.start();
                        e.this.mvw.replay();
                    }
                });
                this.muQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.mgu != null) {
                            e.this.mgu.bo(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bL(str, i);
                if (this.mgu != null) {
                    this.mgu.bo(208, com.baidu.tieba.k.a.r(e));
                }
            }
        }
    }

    private void bL(String str, int i) {
        this.myv = null;
        aWR();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dBT().dBU();
        }
        a(i, this.mym.getChildCount() > i ? this.mym.getChildAt(i) : null, (MusicData) this.myq.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.myq.setData(list);
        if (this.myq != null) {
            this.myy = this.myq.dBE();
            this.myx = this.myy;
        }
        dCw();
    }

    public String dCo() {
        return this.myv;
    }

    public String dCp() {
        return this.myA;
    }

    public void dq(View view) {
        this.myr = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mys = (ImageView) view.findViewById(R.id.video_voice_img);
        this.myt = (TextView) view.findViewById(R.id.video_voice_text);
        this.myr.setVisibility(8);
        this.myr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.wG(!e.this.myu);
                e.this.mvw.setMute(!e.this.myu);
                e.this.replay();
                aq aqVar = new aq("c12423");
                aqVar.ai("obj_type", e.this.myu ? 0 : 1);
                TiebaStatic.log(aqVar);
            }
        });
        wG(this.myu);
        this.mvw.setMute(!this.myu);
    }

    public void wG(boolean z) {
        this.myu = z;
        if (this.myu) {
            this.mys.setSelected(false);
            this.myt.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mys.setSelected(true);
        this.myt.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wE(boolean z) {
        if (z) {
            this.myr.setVisibility(0);
            if (this.myB && this.muQ == null && !TextUtils.isEmpty(this.myv)) {
                bK(this.myv, this.myy);
                this.myB = false;
                if (this.myy > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mym.setSelection(e.this.myy);
                            e.this.mym.scrollTo(e.this.myx * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.myr.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.myz = true;
        if (this.muQ != null && this.muQ.isPlaying()) {
            this.muQ.pause();
        }
    }

    public void onResume() {
        this.myz = false;
        if (this.muQ != null && this.mvw.mCurrentTabIndex == 2) {
            this.muQ.start();
            this.muQ.seekTo(0);
        }
    }

    private void aWR() {
        if (this.muQ != null) {
            if (this.muQ.isPlaying()) {
                this.muQ.stop();
            }
            this.muQ.release();
            this.muQ = null;
        }
        this.myv = null;
        this.myA = null;
    }

    public void ap(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.myB = true;
            this.myA = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.myv = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.myq != null) {
                this.myq.RG(this.myA);
                this.myy = this.myq.dBE();
                this.myw = this.myy;
                this.myx = this.myy;
            }
        }
    }
}
