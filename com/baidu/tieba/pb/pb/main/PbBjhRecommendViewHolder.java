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
    public View bWp;
    public TextView blL;
    private String eVa;
    public View fII;
    public TbImageView fgj;
    private View.OnClickListener fjv;
    private int from;
    public View jYW;
    public ImageView kjk;
    private boolean lQI;
    private PbActivity lQJ;
    private com.baidu.tbadk.core.data.p lQK;
    private String lQL;
    private boolean lQM;
    public View lQN;
    public View lQO;
    public View lQP;
    public View lQQ;
    public TextView lQR;
    public View lQS;
    public View lQT;
    public View lQU;
    public TextView lQV;
    public TextView lQW;
    public TextView lQX;
    public int mSkinType;

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.fjv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (PbBjhRecommendViewHolder.this.lQK != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo boj = PbBjhRecommendViewHolder.this.lQK.boj();
                        if (boj != null) {
                            if (boj.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.lQK);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.lQJ, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (PbBjhRecommendViewHolder.this.lQK.blp() != null && PbBjhRecommendViewHolder.this.lQK.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.lQK.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (boj.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.lQK);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.lQJ, str2, PbBjhRecommendViewHolder.this.lQK.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.eVa);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = PbBjhRecommendViewHolder.this.lQK.getTid();
                        if (PbBjhRecommendViewHolder.this.from == 2) {
                            i = 1;
                        } else if (PbBjhRecommendViewHolder.this.from != 1) {
                            i = PbBjhRecommendViewHolder.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (PbBjhRecommendViewHolder.this.lQK.threadType == 40) {
                                com.baidu.tbadk.core.util.ar.Bk("c13535").dR("tid", tid).v("fid", PbBjhRecommendViewHolder.this.lQK.getFid()).aq("obj_source", i).aq("obj_locate", PbBjhRecommendViewHolder.this.lQK.getFloorNum()).dR("obj_id", PbBjhRecommendViewHolder.this.lQL).aq("obj_type", PbBjhRecommendViewHolder.this.lQK.bpO() ? 1 : 0).bsR();
                            } else {
                                com.baidu.tbadk.core.util.ar.Bk("c13534").dR("tid", tid).v("fid", PbBjhRecommendViewHolder.this.lQK.getFid()).aq("obj_source", i).aq("obj_locate", PbBjhRecommendViewHolder.this.lQK.getFloorNum()).dR("obj_id", PbBjhRecommendViewHolder.this.lQL).bsR();
                            }
                        }
                        if (PbBjhRecommendViewHolder.this.lQM) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13589");
                            arVar.dR("tid", PbBjhRecommendViewHolder.this.lQK.getTid());
                            if (PbBjhRecommendViewHolder.this.lQK.bpI() != null) {
                                arVar.dR("fid", PbBjhRecommendViewHolder.this.lQK.bpI().getForumId());
                            }
                            arVar.dR("obj_param1", PbBjhRecommendViewHolder.this.lQK.mRecomWeight);
                            arVar.dR("obj_source", PbBjhRecommendViewHolder.this.lQK.mRecomSource);
                            arVar.dR("obj_id", PbBjhRecommendViewHolder.this.lQL);
                            arVar.aq("obj_locate", PbBjhRecommendViewHolder.this.lQK.getFloorNum());
                            arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            if (PbBjhRecommendViewHolder.this.lQK.blp().getBaijiahaoData() != null) {
                                arVar.dR("obj_param4", PbBjhRecommendViewHolder.this.lQK.blp().getBaijiahaoData().oriUgcNid);
                                arVar.dR("obj_param6", PbBjhRecommendViewHolder.this.lQK.blp().getBaijiahaoData().oriUgcVid);
                            }
                            arVar.aq("obj_param5", PbBjhRecommendViewHolder.this.lQK.bpU());
                            arVar.dR("ab_tag", PbBjhRecommendViewHolder.this.lQK.mRecomAbTag);
                            arVar.aq("is_vertical", PbBjhRecommendViewHolder.this.lQK.boj().is_vertical.intValue());
                            arVar.dR("extra", PbBjhRecommendViewHolder.this.lQK.mRecomExtra);
                            TiebaStatic.log(arVar);
                        }
                        if (PbBjhRecommendViewHolder.this.lQI) {
                            ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.lQJ).get(VideoPbViewModel.class)).aV(PbBjhRecommendViewHolder.this.lQK);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.lQJ);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.from);
                        pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.lQL);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.lQK);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lQJ = pbActivity;
        this.bWp = view.findViewById(R.id.main_view);
        this.jYW = view.findViewById(R.id.first_head_divider_line);
        this.lQN = view.findViewById(R.id.bjh_main_content);
        this.lQO = view.findViewById(R.id.bjh_click_container);
        this.fgj = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lQP = view.findViewById(R.id.bjh_gradient_cover);
        this.blL = (TextView) view.findViewById(R.id.bjh_content);
        this.lQQ = view.findViewById(R.id.bjh_video_during_container);
        this.kjk = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lQR = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lQS = view.findViewById(R.id.last_video_tail);
        this.lQV = (TextView) view.findViewById(R.id.tail_more_video);
        this.lQT = view.findViewById(R.id.last_tail_divider_line);
        this.lQU = view.findViewById(R.id.last_tail_padding);
        this.lQW = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lQX = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fII = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.lQK = pVar;
        this.jYW.setVisibility(pVar.blO() ? 0 : 8);
        this.lQU.setVisibility(pVar.blP() ? 0 : 8);
        this.lQN.setVisibility(pVar.blQ() ? 8 : 0);
        this.lQS.setVisibility(pVar.blQ() ? 0 : 8);
        this.lQV.setOnClickListener(this.fjv);
        this.lQP.setOnClickListener(this.fjv);
        this.fgj.setOnClickListener(this.fjv);
        this.fgj.setConrers(15);
        this.fgj.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.fgj.setDrawCorner(true);
        this.fgj.setPlaceHolder(2);
        if (pVar.boj() != null) {
            this.blL.setText(pVar.getTitle());
            this.fgj.startLoad(pVar.boj().thumbnail_url, 10, false);
            this.lQP.setVisibility(0);
            this.lQP.setAlpha(0.5f);
            this.lQQ.setVisibility(0);
            this.lQR.setText(StringUtils.translateSecondsToString(pVar.boj().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lQX.getLayoutParams();
            if (pVar.bnS() != null && !com.baidu.tbadk.core.util.au.isEmpty(pVar.bnS().getName_show())) {
                this.lQW.setText(pVar.bnS().getName_show());
                this.lQW.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lQW.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lQX.setLayoutParams(layoutParams);
            this.lQX.setText(String.format(this.lQJ.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.au.numFormatOverWan(pVar.boj().play_count.intValue())));
        } else {
            this.lQQ.setVisibility(8);
            this.lQP.setVisibility(8);
            this.fgj.startLoad(pVar.bpS(), 10, false);
            this.blL.setText(pVar.getTitle());
        }
        this.bWp.setOnClickListener(this.fjv);
    }

    public void Pw(String str) {
        this.lQL = str;
    }

    public void uV(boolean z) {
        this.lQM = z;
    }

    public void setNid(String str) {
        this.eVa = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uU(boolean z) {
        this.lQI = z;
    }
}
