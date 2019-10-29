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
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.a.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.a;
import java.io.File;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
public class d extends com.baidu.adp.base.c {
    private int jBA;
    private boolean jBB;
    private String jBC;
    private boolean jBD;
    private HorizontalListView jBo;
    private com.baidu.tieba.video.editvideo.a.c jBs;
    private LinearLayout jBt;
    private ImageView jBu;
    private TextView jBv;
    private boolean jBw;
    private String jBx;
    private int jBy;
    private int jBz;
    private h jjG;
    private MediaPlayer jxW;
    private a jyC;
    private Resources mResources;
    private View mRootView;

    public d(e eVar, a aVar, h hVar) {
        super(eVar);
        this.jBw = true;
        this.jBy = 1;
        this.jyC = aVar;
        this.jjG = hVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jBo = (HorizontalListView) this.mRootView.findViewById(R.id.horizontal_list);
        this.jBs = new com.baidu.tieba.video.editvideo.a.c(this.mContext);
        this.jBo.setAdapter((ListAdapter) this.jBs);
        this.jBo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.jBs.ctf() != i || i == d.this.jBy) {
                    d.this.jBz = i;
                    d.this.l(i, view);
                }
            }
        });
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public boolean ctW() {
        return !TextUtils.isEmpty(this.jBC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, View view) {
        MusicData musicData = (MusicData) this.jBs.getItem(i);
        if (musicData != null) {
            an anVar = new an("c12423");
            anVar.bS("obj_id", musicData.id);
            anVar.O("obj_locate", i + 1);
            anVar.O("obj_source", 2);
            TiebaStatic.log(anVar);
            switch (musicData.editMusicType) {
                case 0:
                    a(i, view, musicData);
                    return;
                case 1:
                    this.jBs.AS(i);
                    aCa();
                    this.jyC.replay();
                    return;
                case 2:
                    this.jBy = i;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CloudMusicActivityConfig(this.mContext.getPageActivity(), RequestResponseCode.REQUEST_CLOUDMUSIC_ACTIVITY_START)));
                    return;
                default:
                    return;
            }
        }
    }

    public void eg(String str, String str2) {
        this.jBB = false;
        this.jBz = this.jBy;
        this.jBC = str2;
        bo(str, this.jBy);
    }

    private void a(final int i, View view, MusicData musicData) {
        if (musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.jBC = musicData.id;
            this.jyC.cte();
            String EP = com.baidu.tieba.video.editvideo.model.a.ctx().EP(musicData.resource);
            if (TextUtils.isEmpty(EP)) {
                if (view != null) {
                    final c.a aVar = (c.a) view.getTag();
                    aVar.jyf.setVisibility(0);
                    com.baidu.tieba.video.editvideo.model.a.ctx().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.editvideo.view.d.2
                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void ef(String str, String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            aVar.jyf.setVisibility(4);
                            d.this.bo(str, i);
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void EH(String str) {
                            aVar.jyf.setVisibility(4);
                            l.showToast(d.this.mContext.getPageActivity(), str);
                            if (d.this.jjG != null) {
                                d.this.jjG.ax(206, str);
                            }
                        }

                        @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                        public void csM() {
                            aVar.jyf.setVisibility(4);
                        }
                    });
                    return;
                }
                com.baidu.tieba.video.editvideo.model.a.ctx().a(musicData.id, musicData.resource, new a.InterfaceC0528a() { // from class: com.baidu.tieba.video.editvideo.view.d.3
                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void ef(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        d.this.bo(str, i);
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void EH(String str) {
                        l.showToast(d.this.mContext.getPageActivity(), str);
                        if (d.this.jjG != null) {
                            d.this.jjG.ax(206, str);
                        }
                    }

                    @Override // com.baidu.tieba.video.editvideo.model.a.InterfaceC0528a
                    public void csM() {
                    }
                });
                return;
            }
            bo(EP, i);
        }
    }

    public void replay() {
        this.jBB = false;
        if (this.jxW != null && this.jxW.isPlaying()) {
            this.jxW.pause();
        }
        if (this.jxW != null) {
            this.jxW.start();
            this.jxW.seekTo(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, final int i) {
        this.jBA = i;
        if (this.jBz == this.jBA && !this.jBB) {
            if (this.jxW == null) {
                this.jxW = new MediaPlayer();
                this.jxW.setAudioStreamType(3);
            }
            try {
                this.jBx = str;
                this.jxW.reset();
                this.jxW.setDataSource(str);
                this.jxW.prepare();
                this.jxW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.d.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        d.this.jBs.AS(i);
                        d.this.jxW.setLooping(true);
                        d.this.jxW.start();
                        d.this.jyC.replay();
                    }
                });
                this.jxW.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.editvideo.view.d.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        if (d.this.jjG != null) {
                            d.this.jjG.ax(HttpStatus.SC_MULTI_STATUS, "what-->" + i2 + "  extra-->" + i3);
                            return false;
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                bp(str, i);
                if (this.jjG != null) {
                    this.jjG.ax(208, com.baidu.tieba.j.a.o(e));
                }
            }
        }
    }

    private void bp(String str, int i) {
        this.jBx = null;
        aCa();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            com.baidu.tieba.video.editvideo.model.a.ctx().cty();
        }
        a(i, this.jBo.getChildCount() > i ? this.jBo.getChildAt(i) : null, (MusicData) this.jBs.getItem(i));
    }

    public void setMusicData(List<MusicData> list) {
        this.jBs.setData(list);
        if (this.jBs != null) {
            this.jBA = this.jBs.ctf();
            this.jBz = this.jBA;
        }
    }

    public String ctU() {
        return this.jBx;
    }

    public String ctV() {
        return this.jBC;
    }

    public void cT(View view) {
        this.jBt = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.jBu = (ImageView) view.findViewById(R.id.video_voice_img);
        this.jBv = (TextView) view.findViewById(R.id.video_voice_text);
        this.jBt.setVisibility(8);
        this.jBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.jBw = !d.this.jBw;
                if (d.this.jBw) {
                    d.this.jBu.setSelected(false);
                    d.this.jBv.setText(d.this.mResources.getString(R.string.video_voice_open));
                } else {
                    d.this.jBu.setSelected(true);
                    d.this.jBv.setText(d.this.mResources.getString(R.string.video_voice_close));
                }
                d.this.jyC.setMute(!d.this.jBw);
                d.this.replay();
                an anVar = new an("c12423");
                anVar.O("obj_type", d.this.jBw ? 0 : 1);
                TiebaStatic.log(anVar);
            }
        });
        if (this.jBw) {
            this.jBu.setSelected(false);
            this.jBv.setText(this.mResources.getString(R.string.video_voice_open));
            return;
        }
        this.jBu.setSelected(true);
        this.jBv.setText(this.mResources.getString(R.string.video_voice_close));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
        if (z) {
            this.jBt.setVisibility(0);
            if (this.jBD && this.jxW == null && !TextUtils.isEmpty(this.jBx)) {
                bo(this.jBx, this.jBA);
                this.jBD = false;
                if (this.jBA > 4) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.jBo.setSelection(d.this.jBA);
                            d.this.jBo.scrollTo(d.this.jBz * l.getDimens(d.this.getPageContext().getContext(), R.dimen.ds122));
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            replay();
            return;
        }
        this.jBt.setVisibility(8);
        onPause();
    }

    public void onPause() {
        this.jBB = true;
        if (this.jxW != null && this.jxW.isPlaying()) {
            this.jxW.pause();
        }
    }

    public void onResume() {
        this.jBB = false;
        if (this.jxW != null && this.jyC.mCurrentTabIndex == 2) {
            this.jxW.start();
            this.jxW.seekTo(0);
        }
    }

    private void aCa() {
        if (this.jxW != null) {
            if (this.jxW.isPlaying()) {
                this.jxW.stop();
            }
            this.jxW.release();
            this.jxW = null;
        }
        this.jBx = null;
        this.jBC = null;
    }

    public void aH(Intent intent) {
        if (intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.jBD = true;
            this.jBC = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.jBx = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            if (this.jBs != null) {
                this.jBs.EN(this.jBC);
                this.jBA = this.jBs.ctf();
                this.jBy = this.jBA;
                this.jBz = this.jBA;
            }
        }
    }
}
