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
/* loaded from: classes7.dex */
public class h extends v.a {
    public TextView anw;
    public TbImageView cZu;
    private View.OnClickListener dbS;
    private int from;
    public View gSb;
    public View hXc;
    public View iDA;
    public View iDB;
    public ImageView iDC;
    public TextView iDD;
    public View iDE;
    public View iDF;
    public View iDG;
    public TextView iDH;
    public TextView iDI;
    public TextView iDJ;
    private boolean iDt;
    private PbActivity iDu;
    private com.baidu.tbadk.core.data.l iDv;
    private String iDw;
    private boolean iDx;
    public View iDy;
    public View iDz;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dbS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.iDv != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aAo = h.this.iDv.aAo();
                        if (aAo != null) {
                            if (aAo.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.iDv);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.iDu, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.iDv.axQ() != null && h.this.iDv.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.iDv.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aAo.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.iDv);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.iDu, str2, h.this.iDv.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.iDv.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.iDv.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tf("c13535").cp("tid", tid).s("fid", h.this.iDv.getFid()).Z("obj_source", i).Z("obj_locate", h.this.iDv.getFloorNum()).cp("obj_id", h.this.iDw).Z("obj_type", h.this.iDv.aBR() ? 1 : 0).aEm();
                            } else {
                                com.baidu.tbadk.core.util.an.tf("c13534").cp("tid", tid).s("fid", h.this.iDv.getFid()).Z("obj_source", i).Z("obj_locate", h.this.iDv.getFloorNum()).cp("obj_id", h.this.iDw).aEm();
                            }
                        }
                        if (h.this.iDx) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cp("tid", h.this.iDv.getTid());
                            if (h.this.iDv.aBJ() != null) {
                                anVar.cp("fid", h.this.iDv.aBJ().getForumId());
                            }
                            anVar.cp("obj_param1", h.this.iDv.mRecomWeight);
                            anVar.cp("obj_source", h.this.iDv.mRecomSource);
                            anVar.cp("obj_id", h.this.iDw);
                            anVar.Z("obj_locate", h.this.iDv.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.iDv.axQ().getBaijiahaoData() != null) {
                                anVar.cp("obj_param4", h.this.iDv.axQ().getBaijiahaoData().oriUgcNid);
                                anVar.cp("obj_param6", h.this.iDv.axQ().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.Z("obj_param5", h.this.iDv.aBZ());
                            anVar.cp(TiebaInitialize.Params.AB_TAG, h.this.iDv.mRecomAbTag);
                            anVar.Z("is_vertical", h.this.iDv.aAo().is_vertical.intValue());
                            anVar.cp("extra", h.this.iDv.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.iDt) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.iDu).l(com.baidu.tieba.pb.videopb.e.class)).aM(h.this.iDv);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.iDu);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.iDw);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.iDv);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.iDu = pbActivity;
        this.hXc = view.findViewById(R.id.main_view);
        this.gSb = view.findViewById(R.id.first_head_divider_line);
        this.iDy = view.findViewById(R.id.bjh_main_content);
        this.iDz = view.findViewById(R.id.bjh_click_container);
        this.cZu = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.iDA = view.findViewById(R.id.bjh_gradient_cover);
        this.anw = (TextView) view.findViewById(R.id.bjh_content);
        this.iDB = view.findViewById(R.id.bjh_video_during_container);
        this.iDC = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.iDD = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iDE = view.findViewById(R.id.last_video_tail);
        this.iDH = (TextView) view.findViewById(R.id.tail_more_video);
        this.iDF = view.findViewById(R.id.last_tail_divider_line);
        this.iDG = view.findViewById(R.id.last_tail_padding);
        this.iDI = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iDJ = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.iDv = lVar;
        this.gSb.setVisibility(lVar.ayc() ? 0 : 8);
        this.iDG.setVisibility(lVar.ayd() ? 0 : 8);
        this.iDy.setVisibility(lVar.aye() ? 8 : 0);
        this.iDE.setVisibility(lVar.aye() ? 0 : 8);
        this.iDH.setOnClickListener(this.dbS);
        this.iDA.setOnClickListener(this.dbS);
        this.cZu.setOnClickListener(this.dbS);
        this.cZu.setConrers(15);
        this.cZu.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.cZu.setDrawCorner(true);
        this.cZu.setPlaceHolder(2);
        if (lVar.aAo() != null) {
            this.anw.setText(lVar.getTitle());
            this.cZu.startLoad(lVar.aAo().thumbnail_url, 10, false);
            this.iDA.setVisibility(0);
            this.iDA.setAlpha(0.5f);
            this.iDB.setVisibility(0);
            this.iDD.setText(StringUtils.translateSecondsToString(lVar.aAo().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iDJ.getLayoutParams();
            if (lVar.azX() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.azX().getName_show())) {
                this.iDI.setText(lVar.azX().getName_show());
                this.iDI.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iDI.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iDJ.setLayoutParams(layoutParams);
            this.iDJ.setText(String.format(this.iDu.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aAo().play_count.intValue())));
        } else {
            this.iDB.setVisibility(8);
            this.iDA.setVisibility(8);
            this.cZu.startLoad(lVar.aBX(), 10, false);
            this.anw.setText(lVar.getTitle());
        }
        this.hXc.setOnClickListener(this.dbS);
    }

    public void Fx(String str) {
        this.iDw = str;
    }

    public void pE(boolean z) {
        this.iDx = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pD(boolean z) {
        this.iDt = z;
    }
}
