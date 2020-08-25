package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
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
/* loaded from: classes16.dex */
public class i extends af.a {
    public TextView aYI;
    public TbImageView eov;
    private View.OnClickListener erD;
    private int from;
    public View iDx;
    public ImageView iMc;
    public View jPI;
    private boolean kAB;
    private PbActivity kAC;
    private com.baidu.tbadk.core.data.n kAD;
    private String kAE;
    private boolean kAF;
    public View kAG;
    public View kAH;
    public View kAI;
    public View kAJ;
    public TextView kAK;
    public View kAL;
    public View kAM;
    public View kAN;
    public TextView kAO;
    public TextView kAP;
    public TextView kAQ;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.erD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.kAD != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo beW = i.this.kAD.beW();
                        if (beW != null) {
                            if (beW.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kAD);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(videoItemData);
                                String str = "";
                                if (i.this.from != 2) {
                                    if (i.this.from != 1) {
                                        if (i.this.from == 3) {
                                            str = "frs";
                                        }
                                    } else {
                                        str = "concern_tab";
                                    }
                                } else {
                                    str = "index";
                                }
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kAC, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kAD.bce() != null && i.this.kAD.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kAD.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (beW.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kAD);
                                String str2 = "";
                                if (i.this.from != 2) {
                                    if (i.this.from != 1) {
                                        if (i.this.from == 3) {
                                            str2 = "frs";
                                        }
                                    } else {
                                        str2 = "concern_tab";
                                    }
                                } else {
                                    str2 = "index";
                                }
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kAC, str2, i.this.kAD.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kAD.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kAD.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.Ad("c13535").dD("tid", tid).u("fid", i.this.kAD.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kAD.getFloorNum()).dD("obj_id", i.this.kAE).ai("obj_type", i.this.kAD.bgy() ? 1 : 0).bjn();
                            } else {
                                com.baidu.tbadk.core.util.aq.Ad("c13534").dD("tid", tid).u("fid", i.this.kAD.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kAD.getFloorNum()).dD("obj_id", i.this.kAE).bjn();
                            }
                        }
                        if (i.this.kAF) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dD("tid", i.this.kAD.getTid());
                            if (i.this.kAD.bgs() != null) {
                                aqVar.dD("fid", i.this.kAD.bgs().getForumId());
                            }
                            aqVar.dD("obj_param1", i.this.kAD.mRecomWeight);
                            aqVar.dD("obj_source", i.this.kAD.mRecomSource);
                            aqVar.dD("obj_id", i.this.kAE);
                            aqVar.ai("obj_locate", i.this.kAD.getFloorNum());
                            aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kAD.bce().getBaijiahaoData() != null) {
                                aqVar.dD("obj_param4", i.this.kAD.bce().getBaijiahaoData().oriUgcNid);
                                aqVar.dD("obj_param6", i.this.kAD.bce().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.ai("obj_param5", i.this.kAD.bgE());
                            aqVar.dD("ab_tag", i.this.kAD.mRecomAbTag);
                            aqVar.ai("is_vertical", i.this.kAD.beW().is_vertical.intValue());
                            aqVar.dD("extra", i.this.kAD.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.kAB) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kAC).l(com.baidu.tieba.pb.videopb.e.class)).aQ(i.this.kAD);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kAC);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.kAE);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kAD);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kAC = pbActivity;
        this.jPI = view.findViewById(R.id.main_view);
        this.iDx = view.findViewById(R.id.first_head_divider_line);
        this.kAG = view.findViewById(R.id.bjh_main_content);
        this.kAH = view.findViewById(R.id.bjh_click_container);
        this.eov = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.kAI = view.findViewById(R.id.bjh_gradient_cover);
        this.aYI = (TextView) view.findViewById(R.id.bjh_content);
        this.kAJ = view.findViewById(R.id.bjh_video_during_container);
        this.iMc = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kAK = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.kAL = view.findViewById(R.id.last_video_tail);
        this.kAO = (TextView) view.findViewById(R.id.tail_more_video);
        this.kAM = view.findViewById(R.id.last_tail_divider_line);
        this.kAN = view.findViewById(R.id.last_tail_padding);
        this.kAP = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kAQ = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kAD = nVar;
        this.iDx.setVisibility(nVar.bcD() ? 0 : 8);
        this.kAN.setVisibility(nVar.bcE() ? 0 : 8);
        this.kAG.setVisibility(nVar.bcF() ? 8 : 0);
        this.kAL.setVisibility(nVar.bcF() ? 0 : 8);
        this.kAO.setOnClickListener(this.erD);
        this.kAI.setOnClickListener(this.erD);
        this.eov.setOnClickListener(this.erD);
        this.eov.setConrers(15);
        this.eov.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eov.setDrawCorner(true);
        this.eov.setPlaceHolder(2);
        if (nVar.beW() != null) {
            this.aYI.setText(nVar.getTitle());
            this.eov.startLoad(nVar.beW().thumbnail_url, 10, false);
            this.kAI.setVisibility(0);
            this.kAI.setAlpha(0.5f);
            this.kAJ.setVisibility(0);
            this.kAK.setText(StringUtils.translateSecondsToString(nVar.beW().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kAQ.getLayoutParams();
            if (nVar.beE() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.beE().getName_show())) {
                this.kAP.setText(nVar.beE().getName_show());
                this.kAP.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kAP.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kAQ.setLayoutParams(layoutParams);
            this.kAQ.setText(String.format(this.kAC.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.beW().play_count.intValue())));
        } else {
            this.kAJ.setVisibility(8);
            this.kAI.setVisibility(8);
            this.eov.startLoad(nVar.bgC(), 10, false);
            this.aYI.setText(nVar.getTitle());
        }
        this.jPI.setOnClickListener(this.erD);
    }

    public void Nq(String str) {
        this.kAE = str;
    }

    public void sO(boolean z) {
        this.kAF = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void sN(boolean z) {
        this.kAB = z;
    }
}
