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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
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
    private h lOv;
    private Resources mResources;
    private View mRootView;
    private MediaPlayer mcN;
    private a mdt;
    private String mgA;
    private String mgB;
    private HorizontalListView mgk;
    private com.baidu.tieba.video.editvideo.a.c mgo;
    private LinearLayout mgp;
    private ImageView mgq;
    private TextView mgr;
    private boolean mgs;
    private String mgt;
    private int mgu;
    private int mgv;
    private int mgw;
    private boolean mgx;
    private String mgy;
    private boolean mgz;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.mgs = true;
        this.mgu = 1;
        this.mdt = aVar;
        this.lOv = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mgk = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mgo = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mgk.setAdapter((ListAdapter) this.mgo);
        this.mgk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.mgo.dqa() != i || i == e.this.mgu) {
                    e.this.mgv = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dqM() {
        return !TextUtils.isEmpty(this.mgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.mgo.getItem(i);
        if (musicData != null) {
            ap apVar = new ap("c12423");
            apVar.dn("obj_id", musicData.id);
            apVar.ah("obj_locate", i + 1);
            apVar.ah("obj_source", 2);
            TiebaStatic.log(apVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.mgo.Gv(i);
                    aOt();
                    this.mdt.replay();
                    return;
                case 2:
                    this.mgu = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fJ(String str, String str2) {
        this.mgx = false;
        this.mgv = this.mgu;
        this.mgy = str2;
        bF(str, this.mgu);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.mgy = musicData.id;
            this.mdt.dpZ();
            String OK = com.baidu.tieba.video.editvideo.model.a.dqp().OK(musicData.resource);
            if (TextUtils.isEmpty(OK)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.mcW.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dqp().a(musicData.id, musicData.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void fG(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.mcW.setVisibility(4);
                            e.this.bF(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void OE(String str) {
                            aVar.mcW.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.lOv != null) {
                                e.this.lOv.br(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void dpJ() {
                            aVar.mcW.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dqp().a(musicData.id, musicData.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void fG(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        e.this.bF(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void OE(String str) {
                        l.showToast(e.this.mContext.getPageActivity(), str);
                        if (e.this.lOv != null) {
                            e.this.lOv.br(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void dpJ() {
                    }
                });
                return;
            }
            bF(OK, i);
        }
    }

    public void replay() {
        this.mgx = false;
        if (this.mcN != null && this.mcN.isPlaying()) {
            this.mcN.pause();
        }
        if (this.mcN != null) {
            this.mcN.start();
            this.mcN.seekTo(0);
        }
    }

    public void fK(String str, String str2) {
        this.mgA = str;
        this.mgB = str2;
        dqS();
    }

    private void dqS() {
        if (!as.isEmpty(this.mgB) && !as.isEmpty(this.mgA)) {
            List<MusicData> data = this.mgo.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !as.equals(data.get(i2).id, this.mgB)) {
                            i = i2 + 1;
                        } else {
                            Gy(i2);
                            return;
                        }
                    } else {
                        Gy(1);
                        return;
                    }
                }
            }
        }
    }

    private void Gy(final int i) {
        if (!as.isEmpty(this.mgA)) {
            this.mgw = i;
            if (this.mcN == null) {
                this.mcN = new MediaPlayer();
                this.mcN.setAudioStreamType(3);
            }
            try {
                this.mgy = this.mgB;
                this.mgt = this.mgA;
                this.mcN.reset();
                this.mcN.setDataSource(this.mgA);
                this.mcN.prepare();
                this.mcN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mgo.Gv(i);
                        e.this.mcN.setLooping(true);
                    }
                });
                this.mcN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lOv != null) {
                            e.this.lOv.br(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bG(this.mgt, i);
                if (this.lOv != null) {
                    this.lOv.br(208, com.baidu.tieba.k.a.s(e));
                }
            } finally {
                this.mgB = null;
                this.mgA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(String str, final int i) {
        this.mgw = i;
        if (this.mgv == this.mgw && !this.mgx) {
            if (this.mcN == null) {
                this.mcN = new MediaPlayer();
                this.mcN.setAudioStreamType(3);
            }
            try {
                this.mgt = str;
                this.mcN.reset();
                this.mcN.setDataSource(str);
                this.mcN.prepare();
                this.mcN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mgo.Gv(i);
                        e.this.mcN.setLooping(true);
                        e.this.mcN.start();
                        e.this.mdt.replay();
                    }
                });
                this.mcN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lOv != null) {
                            e.this.lOv.br(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bG(str, i);
                if (this.lOv != null) {
                    this.lOv.br(208, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    private void bG(String str, int i) {
        this.mgt = null;
        aOt();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dqp().dqq();
        }
        a(i, this.mgk.getChildCount() > i ? this.mgk.getChildAt(i) : null, (MusicData) this.mgo.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.mgo.setData(list);
        if (this.mgo != null) {
            this.mgw = this.mgo.dqa();
            this.mgv = this.mgw;
        }
        dqS();
    }

    public String dqK() {
        return this.mgt;
    }

    public String dqL() {
        return this.mgy;
    }

    public void dm(View view) {
        this.mgp = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mgq = (ImageView) view.findViewById(R.id.video_voice_img);
        this.mgr = (TextView) view.findViewById(R.id.video_voice_text);
        this.mgp.setVisibility(8);
        this.mgp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.vP(!e.this.mgs);
                e.this.mdt.setMute(!e.this.mgs);
                e.this.replay();
                ap apVar = new ap("c12423");
                apVar.ah("obj_type", e.this.mgs ? 0 : 1);
                TiebaStatic.log(apVar);
            }
        });
        vP(this.mgs);
        this.mdt.setMute(!this.mgs);
    }

    public void vP(boolean z) {
        this.mgs = z;
        if (this.mgs) {
            this.mgq.setSelected(false);
            this.mgr.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mgq.setSelected(true);
        this.mgr.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vN(boolean z) {
        if (z) {
            this.mgp.setVisibility(0);
            if (this.mgz && this.mcN == null && !TextUtils.isEmpty(this.mgt)) {
                bF(this.mgt, this.mgw);
                this.mgz = false;
                if (this.mgw > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mgk.setSelection(e.this.mgw);
                            e.this.mgk.scrollTo(e.this.mgv * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.mgp.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.mgx = true;
        if (this.mcN != null && this.mcN.isPlaying()) {
            this.mcN.pause();
        }
    }

    public void onResume() {
        this.mgx = false;
        if (this.mcN != null && this.mdt.mCurrentTabIndex == 2) {
            this.mcN.start();
            this.mcN.seekTo(0);
        }
    }

    private void aOt() {
        if (this.mcN != null) {
            if (this.mcN.isPlaying()) {
                this.mcN.stop();
            }
            this.mcN.release();
            this.mcN = null;
        }
        this.mgt = null;
        this.mgy = null;
    }

    public void an(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.mgz = true;
            this.mgy = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.mgt = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.mgo != null) {
                this.mgo.OI(this.mgy);
                this.mgw = this.mgo.dqa();
                this.mgu = this.mgw;
                this.mgv = this.mgw;
            }
        }
    }
}
