package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
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
public class i extends aa.a {
    public TextView aPv;
    public TbImageView dRP;
    private View.OnClickListener dUl;
    private int from;
    public View hUg;
    public View iZM;
    private boolean jHP;
    private PbActivity jHQ;
    private com.baidu.tbadk.core.data.k jHR;
    private String jHS;
    private boolean jHT;
    public View jHU;
    public View jHV;
    public View jHW;
    public View jHX;
    public ImageView jHY;
    public TextView jHZ;
    public View jIa;
    public View jIb;
    public View jIc;
    public TextView jId;
    public TextView jIe;
    public TextView jIf;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dUl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.jHR != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aQQ = i.this.jHR.aQQ();
                        if (aQQ != null) {
                            if (aQQ.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.jHR);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.jHQ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.jHR.aOi() != null && i.this.jHR.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.jHR.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aQQ.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.jHR);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.jHQ, str2, i.this.jHR.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.jHR.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.jHR.threadType == 40) {
                                com.baidu.tbadk.core.util.an.wr("c13535").dh("tid", tid).s("fid", i.this.jHR.getFid()).ag("obj_source", i).ag("obj_locate", i.this.jHR.getFloorNum()).dh("obj_id", i.this.jHS).ag("obj_type", i.this.jHR.aSu() ? 1 : 0).aUS();
                            } else {
                                com.baidu.tbadk.core.util.an.wr("c13534").dh("tid", tid).s("fid", i.this.jHR.getFid()).ag("obj_source", i).ag("obj_locate", i.this.jHR.getFloorNum()).dh("obj_id", i.this.jHS).aUS();
                            }
                        }
                        if (i.this.jHT) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.dh("tid", i.this.jHR.getTid());
                            if (i.this.jHR.aSm() != null) {
                                anVar.dh("fid", i.this.jHR.aSm().getForumId());
                            }
                            anVar.dh("obj_param1", i.this.jHR.mRecomWeight);
                            anVar.dh("obj_source", i.this.jHR.mRecomSource);
                            anVar.dh("obj_id", i.this.jHS);
                            anVar.ag("obj_locate", i.this.jHR.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.jHR.aOi().getBaijiahaoData() != null) {
                                anVar.dh("obj_param4", i.this.jHR.aOi().getBaijiahaoData().oriUgcNid);
                                anVar.dh("obj_param6", i.this.jHR.aOi().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.ag("obj_param5", i.this.jHR.aSB());
                            anVar.dh("ab_tag", i.this.jHR.mRecomAbTag);
                            anVar.ag("is_vertical", i.this.jHR.aQQ().is_vertical.intValue());
                            anVar.dh("extra", i.this.jHR.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (i.this.jHP) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.jHQ).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.jHR);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.jHQ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.jHS);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.jHR);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.jHQ = pbActivity;
        this.iZM = view.findViewById(R.id.main_view);
        this.hUg = view.findViewById(R.id.first_head_divider_line);
        this.jHU = view.findViewById(R.id.bjh_main_content);
        this.jHV = view.findViewById(R.id.bjh_click_container);
        this.dRP = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.jHW = view.findViewById(R.id.bjh_gradient_cover);
        this.aPv = (TextView) view.findViewById(R.id.bjh_content);
        this.jHX = view.findViewById(R.id.bjh_video_during_container);
        this.jHY = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.jHZ = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.jIa = view.findViewById(R.id.last_video_tail);
        this.jId = (TextView) view.findViewById(R.id.tail_more_video);
        this.jIb = view.findViewById(R.id.last_tail_divider_line);
        this.jIc = view.findViewById(R.id.last_tail_padding);
        this.jIe = (TextView) view.findViewById(R.id.bjh_user_info);
        this.jIf = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.jHR = kVar;
        this.hUg.setVisibility(kVar.aOB() ? 0 : 8);
        this.jIc.setVisibility(kVar.aOC() ? 0 : 8);
        this.jHU.setVisibility(kVar.aOD() ? 8 : 0);
        this.jIa.setVisibility(kVar.aOD() ? 0 : 8);
        this.jId.setOnClickListener(this.dUl);
        this.jHW.setOnClickListener(this.dUl);
        this.dRP.setOnClickListener(this.dUl);
        this.dRP.setConrers(15);
        this.dRP.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dRP.setDrawCorner(true);
        this.dRP.setPlaceHolder(2);
        if (kVar.aQQ() != null) {
            this.aPv.setText(kVar.getTitle());
            this.dRP.startLoad(kVar.aQQ().thumbnail_url, 10, false);
            this.jHW.setVisibility(0);
            this.jHW.setAlpha(0.5f);
            this.jHX.setVisibility(0);
            this.jHZ.setText(StringUtils.translateSecondsToString(kVar.aQQ().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jIf.getLayoutParams();
            if (kVar.aQx() != null && !com.baidu.tbadk.core.util.aq.isEmpty(kVar.aQx().getName_show())) {
                this.jIe.setText(kVar.aQx().getName_show());
                this.jIe.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jIe.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jIf.setLayoutParams(layoutParams);
            this.jIf.setText(String.format(this.jHQ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(kVar.aQQ().play_count.intValue())));
        } else {
            this.jHX.setVisibility(8);
            this.jHW.setVisibility(8);
            this.dRP.startLoad(kVar.aSz(), 10, false);
            this.aPv.setText(kVar.getTitle());
        }
        this.iZM.setOnClickListener(this.dUl);
    }

    public void Ji(String str) {
        this.jHS = str;
    }

    public void rp(boolean z) {
        this.jHT = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void ro(boolean z) {
        this.jHP = z;
    }
}
