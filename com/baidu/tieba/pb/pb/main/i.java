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
    public TextView aYK;
    public TbImageView eoz;
    private View.OnClickListener erH;
    private int from;
    public View iDD;
    public ImageView iMi;
    public View jPO;
    private boolean kAI;
    private PbActivity kAJ;
    private com.baidu.tbadk.core.data.n kAK;
    private String kAL;
    private boolean kAM;
    public View kAN;
    public View kAO;
    public View kAP;
    public View kAQ;
    public TextView kAR;
    public View kAS;
    public View kAT;
    public View kAU;
    public TextView kAV;
    public TextView kAW;
    public TextView kAX;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.erH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.kAK != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo beW = i.this.kAK.beW();
                        if (beW != null) {
                            if (beW.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kAK);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kAJ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kAK.bce() != null && i.this.kAK.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kAK.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (beW.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kAK);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kAJ, str2, i.this.kAK.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kAK.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kAK.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.Ae("c13535").dD("tid", tid).u("fid", i.this.kAK.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kAK.getFloorNum()).dD("obj_id", i.this.kAL).ai("obj_type", i.this.kAK.bgy() ? 1 : 0).bjn();
                            } else {
                                com.baidu.tbadk.core.util.aq.Ae("c13534").dD("tid", tid).u("fid", i.this.kAK.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kAK.getFloorNum()).dD("obj_id", i.this.kAL).bjn();
                            }
                        }
                        if (i.this.kAM) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dD("tid", i.this.kAK.getTid());
                            if (i.this.kAK.bgs() != null) {
                                aqVar.dD("fid", i.this.kAK.bgs().getForumId());
                            }
                            aqVar.dD("obj_param1", i.this.kAK.mRecomWeight);
                            aqVar.dD("obj_source", i.this.kAK.mRecomSource);
                            aqVar.dD("obj_id", i.this.kAL);
                            aqVar.ai("obj_locate", i.this.kAK.getFloorNum());
                            aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kAK.bce().getBaijiahaoData() != null) {
                                aqVar.dD("obj_param4", i.this.kAK.bce().getBaijiahaoData().oriUgcNid);
                                aqVar.dD("obj_param6", i.this.kAK.bce().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.ai("obj_param5", i.this.kAK.bgE());
                            aqVar.dD("ab_tag", i.this.kAK.mRecomAbTag);
                            aqVar.ai("is_vertical", i.this.kAK.beW().is_vertical.intValue());
                            aqVar.dD("extra", i.this.kAK.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.kAI) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kAJ).l(com.baidu.tieba.pb.videopb.e.class)).aQ(i.this.kAK);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kAJ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.kAL);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kAK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kAJ = pbActivity;
        this.jPO = view.findViewById(R.id.main_view);
        this.iDD = view.findViewById(R.id.first_head_divider_line);
        this.kAN = view.findViewById(R.id.bjh_main_content);
        this.kAO = view.findViewById(R.id.bjh_click_container);
        this.eoz = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.kAP = view.findViewById(R.id.bjh_gradient_cover);
        this.aYK = (TextView) view.findViewById(R.id.bjh_content);
        this.kAQ = view.findViewById(R.id.bjh_video_during_container);
        this.iMi = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kAR = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.kAS = view.findViewById(R.id.last_video_tail);
        this.kAV = (TextView) view.findViewById(R.id.tail_more_video);
        this.kAT = view.findViewById(R.id.last_tail_divider_line);
        this.kAU = view.findViewById(R.id.last_tail_padding);
        this.kAW = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kAX = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kAK = nVar;
        this.iDD.setVisibility(nVar.bcD() ? 0 : 8);
        this.kAU.setVisibility(nVar.bcE() ? 0 : 8);
        this.kAN.setVisibility(nVar.bcF() ? 8 : 0);
        this.kAS.setVisibility(nVar.bcF() ? 0 : 8);
        this.kAV.setOnClickListener(this.erH);
        this.kAP.setOnClickListener(this.erH);
        this.eoz.setOnClickListener(this.erH);
        this.eoz.setConrers(15);
        this.eoz.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eoz.setDrawCorner(true);
        this.eoz.setPlaceHolder(2);
        if (nVar.beW() != null) {
            this.aYK.setText(nVar.getTitle());
            this.eoz.startLoad(nVar.beW().thumbnail_url, 10, false);
            this.kAP.setVisibility(0);
            this.kAP.setAlpha(0.5f);
            this.kAQ.setVisibility(0);
            this.kAR.setText(StringUtils.translateSecondsToString(nVar.beW().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kAX.getLayoutParams();
            if (nVar.beE() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.beE().getName_show())) {
                this.kAW.setText(nVar.beE().getName_show());
                this.kAW.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kAW.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kAX.setLayoutParams(layoutParams);
            this.kAX.setText(String.format(this.kAJ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.beW().play_count.intValue())));
        } else {
            this.kAQ.setVisibility(8);
            this.kAP.setVisibility(8);
            this.eoz.startLoad(nVar.bgC(), 10, false);
            this.aYK.setText(nVar.getTitle());
        }
        this.jPO.setOnClickListener(this.erH);
    }

    public void Nr(String str) {
        this.kAL = str;
    }

    public void sQ(boolean z) {
        this.kAM = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void sP(boolean z) {
        this.kAI = z;
    }
}
