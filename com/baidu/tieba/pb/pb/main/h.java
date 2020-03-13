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
    public TextView aqP;
    public TbImageView ddN;
    private View.OnClickListener dgl;
    private int from;
    public View gUp;
    public View hZo;
    public View iFA;
    public View iFB;
    public TextView iFC;
    public TextView iFD;
    public TextView iFE;
    private boolean iFo;
    private PbActivity iFp;
    private com.baidu.tbadk.core.data.l iFq;
    private String iFr;
    private boolean iFs;
    public View iFt;
    public View iFu;
    public View iFv;
    public View iFw;
    public ImageView iFx;
    public TextView iFy;
    public View iFz;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dgl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.iFq != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aCF = h.this.iFq.aCF();
                        if (aCF != null) {
                            if (aCF.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.iFq);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.iFp, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.iFq.aAg() != null && h.this.iFq.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.iFq.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aCF.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.iFq);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.iFp, str2, h.this.iFq.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.iFq.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.iFq.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tv("c13535").cy("tid", tid).s("fid", h.this.iFq.getFid()).X("obj_source", i).X("obj_locate", h.this.iFq.getFloorNum()).cy("obj_id", h.this.iFr).X("obj_type", h.this.iFq.aEf() ? 1 : 0).aGz();
                            } else {
                                com.baidu.tbadk.core.util.an.tv("c13534").cy("tid", tid).s("fid", h.this.iFq.getFid()).X("obj_source", i).X("obj_locate", h.this.iFq.getFloorNum()).cy("obj_id", h.this.iFr).aGz();
                            }
                        }
                        if (h.this.iFs) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cy("tid", h.this.iFq.getTid());
                            if (h.this.iFq.aDX() != null) {
                                anVar.cy("fid", h.this.iFq.aDX().getForumId());
                            }
                            anVar.cy("obj_param1", h.this.iFq.mRecomWeight);
                            anVar.cy("obj_source", h.this.iFq.mRecomSource);
                            anVar.cy("obj_id", h.this.iFr);
                            anVar.X("obj_locate", h.this.iFq.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.iFq.aAg().getBaijiahaoData() != null) {
                                anVar.cy("obj_param4", h.this.iFq.aAg().getBaijiahaoData().oriUgcNid);
                                anVar.cy("obj_param6", h.this.iFq.aAg().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.X("obj_param5", h.this.iFq.aEm());
                            anVar.cy(TiebaInitialize.Params.AB_TAG, h.this.iFq.mRecomAbTag);
                            anVar.X("is_vertical", h.this.iFq.aCF().is_vertical.intValue());
                            anVar.cy("extra", h.this.iFq.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.iFo) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.iFp).l(com.baidu.tieba.pb.videopb.e.class)).aP(h.this.iFq);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.iFp);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.iFr);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.iFq);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.iFp = pbActivity;
        this.hZo = view.findViewById(R.id.main_view);
        this.gUp = view.findViewById(R.id.first_head_divider_line);
        this.iFt = view.findViewById(R.id.bjh_main_content);
        this.iFu = view.findViewById(R.id.bjh_click_container);
        this.ddN = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.iFv = view.findViewById(R.id.bjh_gradient_cover);
        this.aqP = (TextView) view.findViewById(R.id.bjh_content);
        this.iFw = view.findViewById(R.id.bjh_video_during_container);
        this.iFx = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.iFy = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iFz = view.findViewById(R.id.last_video_tail);
        this.iFC = (TextView) view.findViewById(R.id.tail_more_video);
        this.iFA = view.findViewById(R.id.last_tail_divider_line);
        this.iFB = view.findViewById(R.id.last_tail_padding);
        this.iFD = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iFE = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.iFq = lVar;
        this.gUp.setVisibility(lVar.aAs() ? 0 : 8);
        this.iFB.setVisibility(lVar.aAt() ? 0 : 8);
        this.iFt.setVisibility(lVar.aAu() ? 8 : 0);
        this.iFz.setVisibility(lVar.aAu() ? 0 : 8);
        this.iFC.setOnClickListener(this.dgl);
        this.iFv.setOnClickListener(this.dgl);
        this.ddN.setOnClickListener(this.dgl);
        this.ddN.setConrers(15);
        this.ddN.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.ddN.setDrawCorner(true);
        this.ddN.setPlaceHolder(2);
        if (lVar.aCF() != null) {
            this.aqP.setText(lVar.getTitle());
            this.ddN.startLoad(lVar.aCF().thumbnail_url, 10, false);
            this.iFv.setVisibility(0);
            this.iFv.setAlpha(0.5f);
            this.iFw.setVisibility(0);
            this.iFy.setText(StringUtils.translateSecondsToString(lVar.aCF().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFE.getLayoutParams();
            if (lVar.aCo() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aCo().getName_show())) {
                this.iFD.setText(lVar.aCo().getName_show());
                this.iFD.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iFD.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iFE.setLayoutParams(layoutParams);
            this.iFE.setText(String.format(this.iFp.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aCF().play_count.intValue())));
        } else {
            this.iFw.setVisibility(8);
            this.iFv.setVisibility(8);
            this.ddN.startLoad(lVar.aEk(), 10, false);
            this.aqP.setText(lVar.getTitle());
        }
        this.hZo.setOnClickListener(this.dgl);
    }

    public void FN(String str) {
        this.iFr = str;
    }

    public void pH(boolean z) {
        this.iFs = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pG(boolean z) {
        this.iFo = z;
    }
}
