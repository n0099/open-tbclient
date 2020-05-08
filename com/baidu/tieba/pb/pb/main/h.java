package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class h extends y.a {
    public TextView aJK;
    public TbImageView dDD;
    private View.OnClickListener dFZ;
    private int from;
    public View hFt;
    public View iKM;
    private boolean jra;
    private PbActivity jrb;
    private com.baidu.tbadk.core.data.l jrc;
    private String jrd;
    private boolean jre;
    public View jrf;
    public View jrg;
    public View jrh;
    public View jri;
    public ImageView jrj;
    public TextView jrk;
    public View jrl;
    public View jrm;
    public View jrn;
    public TextView jro;
    public TextView jrp;
    public TextView jrq;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dFZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.jrc != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aKT = h.this.jrc.aKT();
                        if (aKT != null) {
                            if (aKT.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.jrc);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(videoItemData);
                                String str = "";
                                if (h.this.from != 2) {
                                    if (h.this.from != 1) {
                                        if (h.this.from == 3) {
                                            str = "frs";
                                        }
                                    } else {
                                        str = "concern_tab";
                                    }
                                } else {
                                    str = "index";
                                }
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.jrb, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.jrc.aIu() != null && h.this.jrc.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.jrc.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aKT.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.jrc);
                                String str2 = "";
                                if (h.this.from != 2) {
                                    if (h.this.from != 1) {
                                        if (h.this.from == 3) {
                                            str2 = "frs";
                                        }
                                    } else {
                                        str2 = "concern_tab";
                                    }
                                } else {
                                    str2 = "index";
                                }
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.jrb, str2, h.this.jrc.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.jrc.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.jrc.threadType == 40) {
                                com.baidu.tbadk.core.util.an.uL("c13535").cI("tid", tid).t("fid", h.this.jrc.getFid()).af("obj_source", i).af("obj_locate", h.this.jrc.getFloorNum()).cI("obj_id", h.this.jrd).af("obj_type", h.this.jrc.aMv() ? 1 : 0).aOO();
                            } else {
                                com.baidu.tbadk.core.util.an.uL("c13534").cI("tid", tid).t("fid", h.this.jrc.getFid()).af("obj_source", i).af("obj_locate", h.this.jrc.getFloorNum()).cI("obj_id", h.this.jrd).aOO();
                            }
                        }
                        if (h.this.jre) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cI("tid", h.this.jrc.getTid());
                            if (h.this.jrc.aMn() != null) {
                                anVar.cI("fid", h.this.jrc.aMn().getForumId());
                            }
                            anVar.cI("obj_param1", h.this.jrc.mRecomWeight);
                            anVar.cI("obj_source", h.this.jrc.mRecomSource);
                            anVar.cI("obj_id", h.this.jrd);
                            anVar.af("obj_locate", h.this.jrc.getFloorNum());
                            anVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.jrc.aIu().getBaijiahaoData() != null) {
                                anVar.cI("obj_param4", h.this.jrc.aIu().getBaijiahaoData().oriUgcNid);
                                anVar.cI("obj_param6", h.this.jrc.aIu().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.af("obj_param5", h.this.jrc.aMC());
                            anVar.cI(TiebaInitialize.Params.AB_TAG, h.this.jrc.mRecomAbTag);
                            anVar.af("is_vertical", h.this.jrc.aKT().is_vertical.intValue());
                            anVar.cI("extra", h.this.jrc.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.jra) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.jrb).l(com.baidu.tieba.pb.videopb.e.class)).aR(h.this.jrc);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.jrb);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.jrd);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.jrc);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.jrb = pbActivity;
        this.iKM = view.findViewById(R.id.main_view);
        this.hFt = view.findViewById(R.id.first_head_divider_line);
        this.jrf = view.findViewById(R.id.bjh_main_content);
        this.jrg = view.findViewById(R.id.bjh_click_container);
        this.dDD = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.jrh = view.findViewById(R.id.bjh_gradient_cover);
        this.aJK = (TextView) view.findViewById(R.id.bjh_content);
        this.jri = view.findViewById(R.id.bjh_video_during_container);
        this.jrj = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.jrk = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.jrl = view.findViewById(R.id.last_video_tail);
        this.jro = (TextView) view.findViewById(R.id.tail_more_video);
        this.jrm = view.findViewById(R.id.last_tail_divider_line);
        this.jrn = view.findViewById(R.id.last_tail_padding);
        this.jrp = (TextView) view.findViewById(R.id.bjh_user_info);
        this.jrq = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.jrc = lVar;
        this.hFt.setVisibility(lVar.aIG() ? 0 : 8);
        this.jrn.setVisibility(lVar.aIH() ? 0 : 8);
        this.jrf.setVisibility(lVar.aII() ? 8 : 0);
        this.jrl.setVisibility(lVar.aII() ? 0 : 8);
        this.jro.setOnClickListener(this.dFZ);
        this.jrh.setOnClickListener(this.dFZ);
        this.dDD.setOnClickListener(this.dFZ);
        this.dDD.setConrers(15);
        this.dDD.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dDD.setDrawCorner(true);
        this.dDD.setPlaceHolder(2);
        if (lVar.aKT() != null) {
            this.aJK.setText(lVar.getTitle());
            this.dDD.startLoad(lVar.aKT().thumbnail_url, 10, false);
            this.jrh.setVisibility(0);
            this.jrh.setAlpha(0.5f);
            this.jri.setVisibility(0);
            this.jrk.setText(StringUtils.translateSecondsToString(lVar.aKT().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jrq.getLayoutParams();
            if (lVar.aKC() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aKC().getName_show())) {
                this.jrp.setText(lVar.aKC().getName_show());
                this.jrp.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jrp.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jrq.setLayoutParams(layoutParams);
            this.jrq.setText(String.format(this.jrb.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aKT().play_count.intValue())));
        } else {
            this.jri.setVisibility(8);
            this.jrh.setVisibility(8);
            this.dDD.startLoad(lVar.aMA(), 10, false);
            this.aJK.setText(lVar.getTitle());
        }
        this.iKM.setOnClickListener(this.dFZ);
    }

    public void Hx(String str) {
        this.jrd = str;
    }

    public void qR(boolean z) {
        this.jre = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void qQ(boolean z) {
        this.jra = z;
    }
}
