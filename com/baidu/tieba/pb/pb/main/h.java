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
/* loaded from: classes9.dex */
public class h extends v.a {
    public TextView aqZ;
    public TbImageView dea;
    private View.OnClickListener dgy;
    private int from;
    public View gVw;
    private boolean iGP;
    private PbActivity iGQ;
    private com.baidu.tbadk.core.data.l iGR;
    private String iGS;
    private boolean iGT;
    public View iGU;
    public View iGV;
    public View iGW;
    public View iGX;
    public ImageView iGY;
    public TextView iGZ;
    public View iHa;
    public View iHb;
    public View iHc;
    public TextView iHd;
    public TextView iHe;
    public TextView iHf;
    public View iaO;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dgy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.iGR != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aCI = h.this.iGR.aCI();
                        if (aCI != null) {
                            if (aCI.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.iGR);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.iGQ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.iGR.aAj() != null && h.this.iGR.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.iGR.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aCI.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.iGR);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.iGQ, str2, h.this.iGR.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.iGR.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.iGR.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tu("c13535").cx("tid", tid).s("fid", h.this.iGR.getFid()).X("obj_source", i).X("obj_locate", h.this.iGR.getFloorNum()).cx("obj_id", h.this.iGS).X("obj_type", h.this.iGR.aEj() ? 1 : 0).aGD();
                            } else {
                                com.baidu.tbadk.core.util.an.tu("c13534").cx("tid", tid).s("fid", h.this.iGR.getFid()).X("obj_source", i).X("obj_locate", h.this.iGR.getFloorNum()).cx("obj_id", h.this.iGS).aGD();
                            }
                        }
                        if (h.this.iGT) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cx("tid", h.this.iGR.getTid());
                            if (h.this.iGR.aEb() != null) {
                                anVar.cx("fid", h.this.iGR.aEb().getForumId());
                            }
                            anVar.cx("obj_param1", h.this.iGR.mRecomWeight);
                            anVar.cx("obj_source", h.this.iGR.mRecomSource);
                            anVar.cx("obj_id", h.this.iGS);
                            anVar.X("obj_locate", h.this.iGR.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.iGR.aAj().getBaijiahaoData() != null) {
                                anVar.cx("obj_param4", h.this.iGR.aAj().getBaijiahaoData().oriUgcNid);
                                anVar.cx("obj_param6", h.this.iGR.aAj().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.X("obj_param5", h.this.iGR.aEq());
                            anVar.cx(TiebaInitialize.Params.AB_TAG, h.this.iGR.mRecomAbTag);
                            anVar.X("is_vertical", h.this.iGR.aCI().is_vertical.intValue());
                            anVar.cx("extra", h.this.iGR.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.iGP) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.iGQ).l(com.baidu.tieba.pb.videopb.e.class)).aQ(h.this.iGR);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.iGQ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.iGS);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.iGR);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.iGQ = pbActivity;
        this.iaO = view.findViewById(R.id.main_view);
        this.gVw = view.findViewById(R.id.first_head_divider_line);
        this.iGU = view.findViewById(R.id.bjh_main_content);
        this.iGV = view.findViewById(R.id.bjh_click_container);
        this.dea = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.iGW = view.findViewById(R.id.bjh_gradient_cover);
        this.aqZ = (TextView) view.findViewById(R.id.bjh_content);
        this.iGX = view.findViewById(R.id.bjh_video_during_container);
        this.iGY = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.iGZ = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iHa = view.findViewById(R.id.last_video_tail);
        this.iHd = (TextView) view.findViewById(R.id.tail_more_video);
        this.iHb = view.findViewById(R.id.last_tail_divider_line);
        this.iHc = view.findViewById(R.id.last_tail_padding);
        this.iHe = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iHf = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.iGR = lVar;
        this.gVw.setVisibility(lVar.aAv() ? 0 : 8);
        this.iHc.setVisibility(lVar.aAw() ? 0 : 8);
        this.iGU.setVisibility(lVar.aAx() ? 8 : 0);
        this.iHa.setVisibility(lVar.aAx() ? 0 : 8);
        this.iHd.setOnClickListener(this.dgy);
        this.iGW.setOnClickListener(this.dgy);
        this.dea.setOnClickListener(this.dgy);
        this.dea.setConrers(15);
        this.dea.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dea.setDrawCorner(true);
        this.dea.setPlaceHolder(2);
        if (lVar.aCI() != null) {
            this.aqZ.setText(lVar.getTitle());
            this.dea.startLoad(lVar.aCI().thumbnail_url, 10, false);
            this.iGW.setVisibility(0);
            this.iGW.setAlpha(0.5f);
            this.iGX.setVisibility(0);
            this.iGZ.setText(StringUtils.translateSecondsToString(lVar.aCI().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iHf.getLayoutParams();
            if (lVar.aCr() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aCr().getName_show())) {
                this.iHe.setText(lVar.aCr().getName_show());
                this.iHe.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iHe.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iHf.setLayoutParams(layoutParams);
            this.iHf.setText(String.format(this.iGQ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aCI().play_count.intValue())));
        } else {
            this.iGX.setVisibility(8);
            this.iGW.setVisibility(8);
            this.dea.startLoad(lVar.aEo(), 10, false);
            this.aqZ.setText(lVar.getTitle());
        }
        this.iaO.setOnClickListener(this.dgy);
    }

    public void FM(String str) {
        this.iGS = str;
    }

    public void pN(boolean z) {
        this.iGT = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pM(boolean z) {
        this.iGP = z;
    }
}
