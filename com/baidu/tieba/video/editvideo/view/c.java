package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.media.MediaPlayer;
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
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.c {
    private Resources fEG;
    private a guM;
    private MediaPlayer gug;
    private HorizontalListView gwh;
    private com.baidu.tieba.video.editvideo.a.a gwi;
    private LinearLayout gwj;
    private ImageView gwk;
    private TextView gwl;
    private boolean gwm;
    private String gwn;
    private int gwo;
    private int gwp;
    private int gwq;
    private boolean gwr;
    private String gws;
    private View mRootView;

    public c(e eVar, a aVar) {
        super(eVar);
        this.gwm = true;
        this.gwo = 1;
        this.guM = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_music_layout, (ViewGroup) null);
        this.fEG = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gwh = (HorizontalListView) this.mRootView.findViewById(d.h.horizontal_list);
        this.gwi = new com.baidu.tieba.video.editvideo.a.a(this.mContext);
        this.gwh.setAdapter((ListAdapter) this.gwi);
        this.gwh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.gwi.bvJ() != i || i == c.this.gwo) {
                    c.this.gwp = i;
                    c.this.i(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public boolean bwa() {
        return this.gug != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, View view) {
        MusicData musicData = (MusicData) this.gwi.getItem(i);
        if (musicData != null) {
            ak akVar = new ak("c12423");
            akVar.ac("obj_id", musicData.id);
            akVar.r("obj_locate", i + 1);
            TiebaStatic.log(akVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.gwi.uw(i);
                    beh();
                    this.guM.bvT();
                    return;
                case 2:
                    this.gwo = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                default:
                    return;
            }
        }
    }

    public void cj(String str, String str2) {
        this.gwr = false;
        this.gwp = this.gwo;
        this.gws = str2;
        aB(str, this.gwo);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.gws = musicData.id;
            this.guM.bvH();
            String sA = com.baidu.tieba.video.editvideo.model.a.bvK().sA(musicData.resource);
            if (TextUtils.isEmpty(sA)) {
                if (view != null) {
                    final a.C0130a c0130a = (a.C0130a) view.getTag();
                    c0130a.guq.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.bvK().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void ci(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            c0130a.guq.setVisibility(4);
                            c.this.aB(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void sx(String str) {
                            c0130a.guq.setVisibility(4);
                            l.showToast(c.this.mContext.getPageActivity(), str);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                        public void bvn() {
                            c0130a.guq.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.bvK().a(musicData.id, musicData.resource, new a.InterfaceC0131a() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        c.this.aB(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void sx(String str) {
                        l.showToast(c.this.mContext.getPageActivity(), str);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0131a
                    public void bvn() {
                    }
                });
                return;
            }
            aB(sA, i);
        }
    }

    public void bvT() {
        this.gwr = false;
        if (this.gug != null && this.gug.isPlaying()) {
            this.gug.pause();
        }
        if (this.gug != null) {
            this.gug.start();
            this.gug.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, final int i) {
        this.gwq = i;
        if (this.gwp == this.gwq && !this.gwr) {
            if (this.gug == null) {
                this.gug = new MediaPlayer();
                this.gug.setAudioStreamType(3);
            }
            try {
                this.gwn = str;
                this.gug.reset();
                this.gug.setDataSource(str);
                this.gug.prepare();
                this.gug.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.c.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.gwi.uw(i);
                        c.this.gug.setLooping(true);
                        c.this.gug.start();
                        c.this.guM.bvT();
                    }
                });
                this.gug.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.c.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aC(str, i);
            }
        }
    }

    private void aC(String str, int i) {
        this.gwn = null;
        beh();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.bvK().bvL();
        }
        a(i, this.gwh.getChildCount() > i ? this.gwh.getChildAt(i) : null, (MusicData) this.gwi.getItem(i));
    }

    public void dz(List<MusicData> list) {
        this.gwi.setData(list);
    }

    public String bvX() {
        return this.gwn;
    }

    public String bvY() {
        return this.gws;
    }

    public void bJ(View view) {
        this.gwj = (LinearLayout) view.findViewById(d.h.video_voice_layout);
        this.gwk = (ImageView) view.findViewById(d.h.video_voice_img);
        this.gwl = (TextView) view.findViewById(d.h.video_voice_text);
        this.gwj.setVisibility(8);
        this.gwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.gwm = !c.this.gwm;
                if (c.this.gwm) {
                    c.this.gwk.setSelected(false);
                    c.this.gwl.setText(c.this.fEG.getString(d.l.video_voice_open));
                } else {
                    c.this.gwk.setSelected(true);
                    c.this.gwl.setText(c.this.fEG.getString(d.l.video_voice_close));
                }
                c.this.guM.na(!c.this.gwm);
                c.this.bvT();
                ak akVar = new ak("c12423");
                akVar.r("obj_type", c.this.gwm ? 0 : 1);
                TiebaStatic.log(akVar);
            }
        });
        if (this.gwm) {
            this.gwk.setSelected(false);
            this.gwl.setText(this.fEG.getString(d.l.video_voice_open));
            return;
        }
        this.gwk.setSelected(true);
        this.gwl.setText(this.fEG.getString(d.l.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nb(boolean z) {
        if (z) {
            this.gwj.setVisibility(0);
            bvT();
            return;
        }
        this.gwj.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.gwr = true;
        if (this.gug != null && this.gug.isPlaying()) {
            this.gug.pause();
        }
    }

    public void onResume() {
        this.gwr = false;
        if (this.gug != null && this.guM.adF == 1) {
            this.gug.start();
            this.gug.seekTo(0);
        }
    }

    private void beh() {
        if (this.gug != null) {
            if (this.gug.isPlaying()) {
                this.gug.stop();
            }
            this.gug.release();
            this.gug = null;
        }
        this.gwn = null;
        this.gws = null;
    }
}
