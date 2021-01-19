package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public View bRa;
    public TextView bgU;
    private String eRn;
    public View fEX;
    public TbImageView fcv;
    private View.OnClickListener ffD;
    private int from;
    public View jPe;
    public ImageView jZq;
    private boolean lFB;
    private PbActivity lFC;
    private com.baidu.tbadk.core.data.o lFD;
    private String lFE;
    private boolean lFF;
    public View lFG;
    public View lFH;
    public View lFI;
    public View lFJ;
    public TextView lFK;
    public View lFL;
    public View lFM;
    public View lFN;
    public TextView lFO;
    public TextView lFP;
    public TextView lFQ;
    public int mSkinType;

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.ffD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (PbBjhRecommendViewHolder.this.lFD != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bnO = PbBjhRecommendViewHolder.this.lFD.bnO();
                        if (bnO != null) {
                            if (bnO.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.lFD);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(videoItemData);
                                String str = "";
                                if (PbBjhRecommendViewHolder.this.from != 2) {
                                    if (PbBjhRecommendViewHolder.this.from != 1) {
                                        if (PbBjhRecommendViewHolder.this.from == 3) {
                                            str = "frs";
                                        }
                                    } else {
                                        str = "concern_tab";
                                    }
                                } else {
                                    str = "index";
                                }
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.lFC, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (PbBjhRecommendViewHolder.this.lFD.bkV() != null && PbBjhRecommendViewHolder.this.lFD.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.lFD.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bnO.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.lFD);
                                String str2 = "";
                                if (PbBjhRecommendViewHolder.this.from != 2) {
                                    if (PbBjhRecommendViewHolder.this.from != 1) {
                                        if (PbBjhRecommendViewHolder.this.from == 3) {
                                            str2 = "frs";
                                        }
                                    } else {
                                        str2 = "concern_tab";
                                    }
                                } else {
                                    str2 = "index";
                                }
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.lFC, str2, PbBjhRecommendViewHolder.this.lFD.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.eRn);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = PbBjhRecommendViewHolder.this.lFD.getTid();
                        if (PbBjhRecommendViewHolder.this.from == 2) {
                            i = 1;
                        } else if (PbBjhRecommendViewHolder.this.from != 1) {
                            i = PbBjhRecommendViewHolder.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (PbBjhRecommendViewHolder.this.lFD.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.AM("c13535").dW("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lFD.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lFD.getFloorNum()).dW("obj_id", PbBjhRecommendViewHolder.this.lFE).an("obj_type", PbBjhRecommendViewHolder.this.lFD.bpu() ? 1 : 0).bsu();
                            } else {
                                com.baidu.tbadk.core.util.aq.AM("c13534").dW("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lFD.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lFD.getFloorNum()).dW("obj_id", PbBjhRecommendViewHolder.this.lFE).bsu();
                            }
                        }
                        if (PbBjhRecommendViewHolder.this.lFF) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dW("tid", PbBjhRecommendViewHolder.this.lFD.getTid());
                            if (PbBjhRecommendViewHolder.this.lFD.bpo() != null) {
                                aqVar.dW("fid", PbBjhRecommendViewHolder.this.lFD.bpo().getForumId());
                            }
                            aqVar.dW("obj_param1", PbBjhRecommendViewHolder.this.lFD.mRecomWeight);
                            aqVar.dW("obj_source", PbBjhRecommendViewHolder.this.lFD.mRecomSource);
                            aqVar.dW("obj_id", PbBjhRecommendViewHolder.this.lFE);
                            aqVar.an("obj_locate", PbBjhRecommendViewHolder.this.lFD.getFloorNum());
                            aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                            if (PbBjhRecommendViewHolder.this.lFD.bkV().getBaijiahaoData() != null) {
                                aqVar.dW("obj_param4", PbBjhRecommendViewHolder.this.lFD.bkV().getBaijiahaoData().oriUgcNid);
                                aqVar.dW("obj_param6", PbBjhRecommendViewHolder.this.lFD.bkV().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.an("obj_param5", PbBjhRecommendViewHolder.this.lFD.bpA());
                            aqVar.dW("ab_tag", PbBjhRecommendViewHolder.this.lFD.mRecomAbTag);
                            aqVar.an("is_vertical", PbBjhRecommendViewHolder.this.lFD.bnO().is_vertical.intValue());
                            aqVar.dW("extra", PbBjhRecommendViewHolder.this.lFD.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (PbBjhRecommendViewHolder.this.lFB) {
                            ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.lFC).get(VideoPbViewModel.class)).aU(PbBjhRecommendViewHolder.this.lFD);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.lFC);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.from);
                        pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.lFE);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.lFD);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lFC = pbActivity;
        this.bRa = view.findViewById(R.id.main_view);
        this.jPe = view.findViewById(R.id.first_head_divider_line);
        this.lFG = view.findViewById(R.id.bjh_main_content);
        this.lFH = view.findViewById(R.id.bjh_click_container);
        this.fcv = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lFI = view.findViewById(R.id.bjh_gradient_cover);
        this.bgU = (TextView) view.findViewById(R.id.bjh_content);
        this.lFJ = view.findViewById(R.id.bjh_video_during_container);
        this.jZq = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lFK = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lFL = view.findViewById(R.id.last_video_tail);
        this.lFO = (TextView) view.findViewById(R.id.tail_more_video);
        this.lFM = view.findViewById(R.id.last_tail_divider_line);
        this.lFN = view.findViewById(R.id.last_tail_padding);
        this.lFP = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lFQ = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fEX = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lFD = oVar;
        this.jPe.setVisibility(oVar.blu() ? 0 : 8);
        this.lFN.setVisibility(oVar.blv() ? 0 : 8);
        this.lFG.setVisibility(oVar.blw() ? 8 : 0);
        this.lFL.setVisibility(oVar.blw() ? 0 : 8);
        this.lFO.setOnClickListener(this.ffD);
        this.lFI.setOnClickListener(this.ffD);
        this.fcv.setOnClickListener(this.ffD);
        this.fcv.setConrers(15);
        this.fcv.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.fcv.setDrawCorner(true);
        this.fcv.setPlaceHolder(2);
        if (oVar.bnO() != null) {
            this.bgU.setText(oVar.getTitle());
            this.fcv.startLoad(oVar.bnO().thumbnail_url, 10, false);
            this.lFI.setVisibility(0);
            this.lFI.setAlpha(0.5f);
            this.lFJ.setVisibility(0);
            this.lFK.setText(StringUtils.translateSecondsToString(oVar.bnO().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lFQ.getLayoutParams();
            if (oVar.bnx() != null && !com.baidu.tbadk.core.util.at.isEmpty(oVar.bnx().getName_show())) {
                this.lFP.setText(oVar.bnx().getName_show());
                this.lFP.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lFP.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lFQ.setLayoutParams(layoutParams);
            this.lFQ.setText(String.format(this.lFC.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(oVar.bnO().play_count.intValue())));
        } else {
            this.lFJ.setVisibility(8);
            this.lFI.setVisibility(8);
            this.fcv.startLoad(oVar.bpy(), 10, false);
            this.bgU.setText(oVar.getTitle());
        }
        this.bRa.setOnClickListener(this.ffD);
    }

    public void Oy(String str) {
        this.lFE = str;
    }

    public void uG(boolean z) {
        this.lFF = z;
    }

    public void setNid(String str) {
        this.eRn = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uF(boolean z) {
        this.lFB = z;
    }
}
