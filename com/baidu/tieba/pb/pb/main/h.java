package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
/* loaded from: classes6.dex */
public class h extends v.a {
    public TextView amJ;
    public TbImageView cZk;
    private View.OnClickListener dbH;
    private int from;
    public View gOH;
    public View hTy;
    public View iAa;
    public View iAb;
    public View iAc;
    public TextView iAd;
    public TextView iAe;
    public TextView iAf;
    private boolean izP;
    private PbActivity izQ;
    private com.baidu.tbadk.core.data.l izR;
    private String izS;
    private boolean izT;
    public View izU;
    public View izV;
    public View izW;
    public View izX;
    public ImageView izY;
    public TextView izZ;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dbH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.izR != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo azV = h.this.izR.azV();
                        if (azV != null) {
                            if (azV.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.izR);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.izQ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.izR.axx() != null && h.this.izR.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.izR.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (azV.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.izR);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.izQ, str2, h.this.izR.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.izR.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.izR.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tb("c13535").cp("tid", tid).s("fid", h.this.izR.getFid()).Z("obj_source", i).Z("obj_locate", h.this.izR.getFloorNum()).cp("obj_id", h.this.izS).Z("obj_type", h.this.izR.aBy() ? 1 : 0).aDT();
                            } else {
                                com.baidu.tbadk.core.util.an.tb("c13534").cp("tid", tid).s("fid", h.this.izR.getFid()).Z("obj_source", i).Z("obj_locate", h.this.izR.getFloorNum()).cp("obj_id", h.this.izS).aDT();
                            }
                        }
                        if (h.this.izT) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cp("tid", h.this.izR.getTid());
                            if (h.this.izR.aBq() != null) {
                                anVar.cp("fid", h.this.izR.aBq().getForumId());
                            }
                            anVar.cp("obj_param1", h.this.izR.mRecomWeight);
                            anVar.cp("obj_source", h.this.izR.mRecomSource);
                            anVar.cp("obj_id", h.this.izS);
                            anVar.Z("obj_locate", h.this.izR.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.izR.axx().getBaijiahaoData() != null) {
                                anVar.cp("obj_param4", h.this.izR.axx().getBaijiahaoData().oriUgcNid);
                                anVar.cp("obj_param6", h.this.izR.axx().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.Z("obj_param5", h.this.izR.aBG());
                            anVar.cp(TiebaInitialize.Params.AB_TAG, h.this.izR.mRecomAbTag);
                            anVar.Z("is_vertical", h.this.izR.azV().is_vertical.intValue());
                            anVar.cp("extra", h.this.izR.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.izP) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.izQ).l(com.baidu.tieba.pb.videopb.e.class)).aL(h.this.izR);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.izQ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.izS);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.izR);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.izQ = pbActivity;
        this.hTy = view.findViewById(R.id.main_view);
        this.gOH = view.findViewById(R.id.first_head_divider_line);
        this.izU = view.findViewById(R.id.bjh_main_content);
        this.izV = view.findViewById(R.id.bjh_click_container);
        this.cZk = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.izW = view.findViewById(R.id.bjh_gradient_cover);
        this.amJ = (TextView) view.findViewById(R.id.bjh_content);
        this.izX = view.findViewById(R.id.bjh_video_during_container);
        this.izY = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.izZ = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iAa = view.findViewById(R.id.last_video_tail);
        this.iAd = (TextView) view.findViewById(R.id.tail_more_video);
        this.iAb = view.findViewById(R.id.last_tail_divider_line);
        this.iAc = view.findViewById(R.id.last_tail_padding);
        this.iAe = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iAf = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.izR = lVar;
        this.gOH.setVisibility(lVar.axJ() ? 0 : 8);
        this.iAc.setVisibility(lVar.axK() ? 0 : 8);
        this.izU.setVisibility(lVar.axL() ? 8 : 0);
        this.iAa.setVisibility(lVar.axL() ? 0 : 8);
        this.iAd.setOnClickListener(this.dbH);
        this.izW.setOnClickListener(this.dbH);
        this.cZk.setOnClickListener(this.dbH);
        this.cZk.setConrers(15);
        this.cZk.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.cZk.setDrawCorner(true);
        this.cZk.setPlaceHolder(2);
        if (lVar.azV() != null) {
            this.amJ.setText(lVar.getTitle());
            this.cZk.startLoad(lVar.azV().thumbnail_url, 10, false);
            this.izW.setVisibility(0);
            this.izW.setAlpha(0.5f);
            this.izX.setVisibility(0);
            this.izZ.setText(StringUtils.translateSecondsToString(lVar.azV().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iAf.getLayoutParams();
            if (lVar.azE() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.azE().getName_show())) {
                this.iAe.setText(lVar.azE().getName_show());
                this.iAe.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iAe.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iAf.setLayoutParams(layoutParams);
            this.iAf.setText(String.format(this.izQ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.azV().play_count.intValue())));
        } else {
            this.izX.setVisibility(8);
            this.izW.setVisibility(8);
            this.cZk.startLoad(lVar.aBE(), 10, false);
            this.amJ.setText(lVar.getTitle());
        }
        this.hTy.setOnClickListener(this.dbH);
    }

    public void Fn(String str) {
        this.izS = str;
    }

    public void ps(boolean z) {
        this.izT = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pr(boolean z) {
        this.izP = z;
    }
}
