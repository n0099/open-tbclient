package com.baidu.tieba.pb.video;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.ab;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.au;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.c;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class d {
    private aj aMm;
    private PbActivity ehi;
    private com.baidu.tieba.play.c enG;
    private bb ett;
    private bh etu;
    private bh etv;
    private String etw;
    private c.InterfaceC0072c ety;
    private String aOm = null;
    private VideoInfo duU = null;
    private boolean etx = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new e(this, 2000994);
    private au.a dyu = new f(this);
    private c.e etz = new g(this);

    public d(PbActivity pbActivity, com.baidu.tieba.play.c cVar) {
        this.ehi = pbActivity;
        this.enG = cVar;
        if (this.enG != null) {
            this.enG.kr(true);
        }
    }

    public void a(VideoInfo videoInfo, bh bhVar, String str) {
        if (videoInfo != null && this.enG != null && bhVar != null) {
            this.duU = videoInfo;
            this.etu = bhVar;
            this.aOm = videoInfo.video_url;
            this.enG.stopPlay();
            this.enG.kq(true);
            this.aMm = new aj(this.ehi.getActivity());
            this.ett = new bb();
            this.ett.mLocate = "6";
            this.ett.bjS = bhVar.getTid();
            this.ett.bjT = str;
            this.ett.mUid = TbadkCoreApplication.getCurrentAccount();
            this.ett.mSource = bhVar.TW;
            this.ett.eTy = bhVar.TY;
            this.ett.eTz = bhVar.TX;
            this.ett.eTA = this.ehi.aKM();
            if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
                this.ett.Ql = new StringBuilder(String.valueOf(bhVar.sz().channelId)).toString();
            } else {
                this.ett.Ql = "0";
            }
            this.aMm.a(this.ett);
            this.enG.Kb().setBusiness(this.aMm);
            if (this.enG.azw()) {
                this.enG.azu();
            }
            this.enG.b(this.ety);
            if (this.enG != null) {
                this.enG.oG(this.etw);
            }
            this.etw = null;
            this.etv = null;
            this.enG.oG(this.etw);
            this.enG.azq().setOnDragingListener(this.dyu);
            this.enG.a(new h(this));
            this.enG.a(new i(this));
            this.enG.a(new j(this));
            this.enG.lS(videoInfo.thumbnail_url);
            this.enG.bP(videoInfo.play_count.intValue());
            this.enG.setVideoUrl(this.aOm);
            this.enG.pC(bhVar.getTitle());
            this.enG.a(this.etz);
            this.enG.amd();
            this.enG.show();
        }
    }

    public void a(c.InterfaceC0072c interfaceC0072c) {
        this.ety = interfaceC0072c;
    }

    public void I(bh bhVar) {
        this.etv = bhVar;
    }

    public void oG(String str) {
        this.etw = str;
        if (this.enG != null) {
            this.enG.oG(this.etw);
        }
    }

    public void startPlay() {
        if (this.enG != null) {
            this.enG.pB(this.aOm);
        }
        JB();
    }

    public void destroy() {
        if (this.enG != null) {
            this.enG.destroy();
        }
    }

    public void onPause() {
        if (this.enG != null) {
            if (this.enG.aYa()) {
                this.etx = true;
                this.enG.pausePlay();
            } else if (this.enG.aYf() == 3) {
                this.etx = false;
            } else {
                this.etx = false;
                this.enG.pausePlay();
            }
        }
    }

    public void onResume() {
        if (this.enG != null && this.etx) {
            this.enG.amW();
        }
    }

    public boolean aNV() {
        if (this.enG == null) {
            return false;
        }
        return this.enG.aXY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB() {
        if (this.duU != null) {
            ab.a(this.duU.video_md5, "", "1", this.ett);
        }
    }
}
