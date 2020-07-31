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
    private h lOt;
    private Resources mResources;
    private View mRootView;
    private MediaPlayer mcL;
    private a mdr;
    private HorizontalListView mgi;
    private com.baidu.tieba.video.editvideo.a.c mgm;
    private LinearLayout mgn;
    private ImageView mgo;
    private TextView mgp;
    private boolean mgq;
    private String mgr;
    private int mgs;
    private int mgt;
    private int mgu;
    private boolean mgv;
    private String mgw;
    private boolean mgx;
    private String mgy;
    private String mgz;

    public e(com.baidu.adp.base.e eVar, a aVar, h hVar) {
        super(eVar);
        this.mgq = true;
        this.mgs = 1;
        this.mdr = aVar;
        this.lOt = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mgi = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.mgm = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.mgi.setAdapter((ListAdapter) this.mgm);
        this.mgi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.mgm.dpZ() != i || i == e.this.mgs) {
                    e.this.mgt = i;
                    e.this.j(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean dqL() {
        return !TextUtils.isEmpty(this.mgw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, View view) {
        MusicData musicData = (MusicData) this.mgm.getItem(i);
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
                    this.mgm.Gv(i);
                    aOt();
                    this.mdr.replay();
                    return;
                case 2:
                    this.mgs = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void fJ(String str, String str2) {
        this.mgv = false;
        this.mgt = this.mgs;
        this.mgw = str2;
        bF(str, this.mgs);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.mgw = musicData.id;
            this.mdr.dpY();
            String OK = com.baidu.tieba.video.editvideo.model.a.dqo().OK(musicData.resource);
            if (TextUtils.isEmpty(OK)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.mcU.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.dqo().a(musicData.id, musicData.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.editvideo.view.e.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void fG(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.mcU.setVisibility(4);
                            e.this.bF(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void OE(String str) {
                            aVar.mcU.setVisibility(4);
                            l.showToast(e.this.mContext.getPageActivity(), str);
                            if (e.this.lOt != null) {
                                e.this.lOt.br(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                        public void dpI() {
                            aVar.mcU.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.dqo().a(musicData.id, musicData.resource, new a.InterfaceC0763a() { // from class: com.baidu.tieba.video.editvideo.view.e.3
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
                        if (e.this.lOt != null) {
                            e.this.lOt.br(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0763a
                    public void dpI() {
                    }
                });
                return;
            }
            bF(OK, i);
        }
    }

    public void replay() {
        this.mgv = false;
        if (this.mcL != null && this.mcL.isPlaying()) {
            this.mcL.pause();
        }
        if (this.mcL != null) {
            this.mcL.start();
            this.mcL.seekTo(0);
        }
    }

    public void fK(String str, String str2) {
        this.mgy = str;
        this.mgz = str2;
        dqR();
    }

    private void dqR() {
        if (!as.isEmpty(this.mgz) && !as.isEmpty(this.mgy)) {
            List<MusicData> data = this.mgm.getData();
            if (!x.isEmpty(data)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        if (data.get(i2) == null || !as.equals(data.get(i2).id, this.mgz)) {
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
        if (!as.isEmpty(this.mgy)) {
            this.mgu = i;
            if (this.mcL == null) {
                this.mcL = new MediaPlayer();
                this.mcL.setAudioStreamType(3);
            }
            try {
                this.mgw = this.mgz;
                this.mgr = this.mgy;
                this.mcL.reset();
                this.mcL.setDataSource(this.mgy);
                this.mcL.prepare();
                this.mcL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mgm.Gv(i);
                        e.this.mcL.setLooping(true);
                    }
                });
                this.mcL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lOt != null) {
                            e.this.lOt.br(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bG(this.mgr, i);
                if (this.lOt != null) {
                    this.lOt.br(208, com.baidu.tieba.k.a.s(e));
                }
            } finally {
                this.mgz = null;
                this.mgy = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(String str, final int i) {
        this.mgu = i;
        if (this.mgt == this.mgu && !this.mgv) {
            if (this.mcL == null) {
                this.mcL = new MediaPlayer();
                this.mcL.setAudioStreamType(3);
            }
            try {
                this.mgr = str;
                this.mcL.reset();
                this.mcL.setDataSource(str);
                this.mcL.prepare();
                this.mcL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.e.6
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        e.this.mgm.Gv(i);
                        e.this.mcL.setLooping(true);
                        e.this.mcL.start();
                        e.this.mdr.replay();
                    }
                });
                this.mcL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.e.7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (e.this.lOt != null) {
                            e.this.lOt.br(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bG(str, i);
                if (this.lOt != null) {
                    this.lOt.br(208, com.baidu.tieba.k.a.s(e));
                }
            }
        }
    }

    private void bG(String str, int i) {
        this.mgr = null;
        aOt();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.dqo().dqp();
        }
        a(i, this.mgi.getChildCount() > i ? this.mgi.getChildAt(i) : null, (MusicData) this.mgm.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.mgm.setData(list);
        if (this.mgm != null) {
            this.mgu = this.mgm.dpZ();
            this.mgt = this.mgu;
        }
        dqR();
    }

    public String dqJ() {
        return this.mgr;
    }

    public String dqK() {
        return this.mgw;
    }

    public void dm(View view) {
        this.mgn = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.mgo = (ImageView) view.findViewById(R.id.video_voice_img);
        this.mgp = (TextView) view.findViewById(R.id.video_voice_text);
        this.mgn.setVisibility(8);
        this.mgn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.vP(!e.this.mgq);
                e.this.mdr.setMute(!e.this.mgq);
                e.this.replay();
                ap apVar = new ap("c12423");
                apVar.ah("obj_type", e.this.mgq ? 0 : 1);
                TiebaStatic.log(apVar);
            }
        });
        vP(this.mgq);
        this.mdr.setMute(!this.mgq);
    }

    public void vP(boolean z) {
        this.mgq = z;
        if (this.mgq) {
            this.mgo.setSelected(false);
            this.mgp.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.mgo.setSelected(true);
        this.mgp.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vN(boolean z) {
        if (z) {
            this.mgn.setVisibility(0);
            if (this.mgx && this.mcL == null && !TextUtils.isEmpty(this.mgr)) {
                bF(this.mgr, this.mgu);
                this.mgx = false;
                if (this.mgu > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mgi.setSelection(e.this.mgu);
                            e.this.mgi.scrollTo(e.this.mgt * l.getDimens(e.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.mgn.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.mgv = true;
        if (this.mcL != null && this.mcL.isPlaying()) {
            this.mcL.pause();
        }
    }

    public void onResume() {
        this.mgv = false;
        if (this.mcL != null && this.mdr.mCurrentTabIndex == 2) {
            this.mcL.start();
            this.mcL.seekTo(0);
        }
    }

    private void aOt() {
        if (this.mcL != null) {
            if (this.mcL.isPlaying()) {
                this.mcL.stop();
            }
            this.mcL.release();
            this.mcL = null;
        }
        this.mgr = null;
        this.mgw = null;
    }

    public void an(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.mgx = true;
            this.mgw = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.mgr = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.mgm != null) {
                this.mgm.OI(this.mgw);
                this.mgu = this.mgm.dpZ();
                this.mgs = this.mgu;
                this.mgt = this.mgu;
            }
        }
    }
}
