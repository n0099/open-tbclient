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
/* loaded from: classes22.dex */
public class i extends af.a {
    public TextView bgh;
    public TbImageView eLx;
    private View.OnClickListener eOs;
    private int from;
    public View jmk;
    public ImageView jwj;
    public View kAe;
    private boolean lkP;
    private PbActivity lkQ;
    private com.baidu.tbadk.core.data.n lkR;
    private String lkS;
    private boolean lkT;
    public View lkU;
    public View lkV;
    public View lkW;
    public View lkX;
    public TextView lkY;
    public View lkZ;
    public View lla;
    public View llb;
    public TextView llc;
    public TextView lld;
    public TextView lle;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.eOs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.lkR != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bks = i.this.lkR.bks();
                        if (bks != null) {
                            if (bks.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.lkR);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.lkQ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.lkR.bhz() != null && i.this.lkR.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.lkR.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bks.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.lkR);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.lkQ, str2, i.this.lkR.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.lkR.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.lkR.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.BF("c13535").dR("tid", tid).w("fid", i.this.lkR.getFid()).aj("obj_source", i).aj("obj_locate", i.this.lkR.getFloorNum()).dR("obj_id", i.this.lkS).aj("obj_type", i.this.lkR.blU() ? 1 : 0).boK();
                            } else {
                                com.baidu.tbadk.core.util.aq.BF("c13534").dR("tid", tid).w("fid", i.this.lkR.getFid()).aj("obj_source", i).aj("obj_locate", i.this.lkR.getFloorNum()).dR("obj_id", i.this.lkS).boK();
                            }
                        }
                        if (i.this.lkT) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dR("tid", i.this.lkR.getTid());
                            if (i.this.lkR.blO() != null) {
                                aqVar.dR("fid", i.this.lkR.blO().getForumId());
                            }
                            aqVar.dR("obj_param1", i.this.lkR.mRecomWeight);
                            aqVar.dR("obj_source", i.this.lkR.mRecomSource);
                            aqVar.dR("obj_id", i.this.lkS);
                            aqVar.aj("obj_locate", i.this.lkR.getFloorNum());
                            aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.lkR.bhz().getBaijiahaoData() != null) {
                                aqVar.dR("obj_param4", i.this.lkR.bhz().getBaijiahaoData().oriUgcNid);
                                aqVar.dR("obj_param6", i.this.lkR.bhz().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.aj("obj_param5", i.this.lkR.bma());
                            aqVar.dR("ab_tag", i.this.lkR.mRecomAbTag);
                            aqVar.aj("is_vertical", i.this.lkR.bks().is_vertical.intValue());
                            aqVar.dR("extra", i.this.lkR.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.lkP) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.lkQ).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.lkR);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.lkQ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.lkS);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.lkR);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lkQ = pbActivity;
        this.kAe = view.findViewById(R.id.main_view);
        this.jmk = view.findViewById(R.id.first_head_divider_line);
        this.lkU = view.findViewById(R.id.bjh_main_content);
        this.lkV = view.findViewById(R.id.bjh_click_container);
        this.eLx = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lkW = view.findViewById(R.id.bjh_gradient_cover);
        this.bgh = (TextView) view.findViewById(R.id.bjh_content);
        this.lkX = view.findViewById(R.id.bjh_video_during_container);
        this.jwj = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lkY = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lkZ = view.findViewById(R.id.last_video_tail);
        this.llc = (TextView) view.findViewById(R.id.tail_more_video);
        this.lla = view.findViewById(R.id.last_tail_divider_line);
        this.llb = view.findViewById(R.id.last_tail_padding);
        this.lld = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lle = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.lkR = nVar;
        this.jmk.setVisibility(nVar.bhZ() ? 0 : 8);
        this.llb.setVisibility(nVar.bia() ? 0 : 8);
        this.lkU.setVisibility(nVar.bib() ? 8 : 0);
        this.lkZ.setVisibility(nVar.bib() ? 0 : 8);
        this.llc.setOnClickListener(this.eOs);
        this.lkW.setOnClickListener(this.eOs);
        this.eLx.setOnClickListener(this.eOs);
        this.eLx.setConrers(15);
        this.eLx.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eLx.setDrawCorner(true);
        this.eLx.setPlaceHolder(2);
        if (nVar.bks() != null) {
            this.bgh.setText(nVar.getTitle());
            this.eLx.startLoad(nVar.bks().thumbnail_url, 10, false);
            this.lkW.setVisibility(0);
            this.lkW.setAlpha(0.5f);
            this.lkX.setVisibility(0);
            this.lkY.setText(StringUtils.translateSecondsToString(nVar.bks().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lle.getLayoutParams();
            if (nVar.bka() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.bka().getName_show())) {
                this.lld.setText(nVar.bka().getName_show());
                this.lld.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.lld.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lle.setLayoutParams(layoutParams);
            this.lle.setText(String.format(this.lkQ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.bks().play_count.intValue())));
        } else {
            this.lkX.setVisibility(8);
            this.lkW.setVisibility(8);
            this.eLx.startLoad(nVar.blY(), 10, false);
            this.bgh.setText(nVar.getTitle());
        }
        this.kAe.setOnClickListener(this.eOs);
    }

    public void Pf(String str) {
        this.lkS = str;
    }

    public void tV(boolean z) {
        this.lkT = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void tU(boolean z) {
        this.lkP = z;
    }
}
