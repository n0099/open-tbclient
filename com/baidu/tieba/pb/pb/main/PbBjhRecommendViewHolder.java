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
    public View bUP;
    public TextView bkl;
    private String eTz;
    public View fHj;
    public TbImageView feK;
    private View.OnClickListener fhT;
    private int from;
    public View jWG;
    public ImageView kgT;
    public TextView lOA;
    public View lOB;
    public View lOC;
    public View lOD;
    public TextView lOE;
    public TextView lOF;
    public TextView lOG;
    private boolean lOr;
    private PbActivity lOs;
    private com.baidu.tbadk.core.data.p lOt;
    private String lOu;
    private boolean lOv;
    public View lOw;
    public View lOx;
    public View lOy;
    public View lOz;
    public int mSkinType;

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.fhT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (PbBjhRecommendViewHolder.this.lOt != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo boh = PbBjhRecommendViewHolder.this.lOt.boh();
                        if (boh != null) {
                            if (boh.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.lOt);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.lOs, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (PbBjhRecommendViewHolder.this.lOt.bln() != null && PbBjhRecommendViewHolder.this.lOt.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.lOt.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (boh.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.lOt);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.lOs, str2, PbBjhRecommendViewHolder.this.lOt.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.eTz);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = PbBjhRecommendViewHolder.this.lOt.getTid();
                        if (PbBjhRecommendViewHolder.this.from == 2) {
                            i = 1;
                        } else if (PbBjhRecommendViewHolder.this.from != 1) {
                            i = PbBjhRecommendViewHolder.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (PbBjhRecommendViewHolder.this.lOt.threadType == 40) {
                                com.baidu.tbadk.core.util.ar.Bd("c13535").dR("tid", tid).v("fid", PbBjhRecommendViewHolder.this.lOt.getFid()).ap("obj_source", i).ap("obj_locate", PbBjhRecommendViewHolder.this.lOt.getFloorNum()).dR("obj_id", PbBjhRecommendViewHolder.this.lOu).ap("obj_type", PbBjhRecommendViewHolder.this.lOt.bpM() ? 1 : 0).bsO();
                            } else {
                                com.baidu.tbadk.core.util.ar.Bd("c13534").dR("tid", tid).v("fid", PbBjhRecommendViewHolder.this.lOt.getFid()).ap("obj_source", i).ap("obj_locate", PbBjhRecommendViewHolder.this.lOt.getFloorNum()).dR("obj_id", PbBjhRecommendViewHolder.this.lOu).bsO();
                            }
                        }
                        if (PbBjhRecommendViewHolder.this.lOv) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13589");
                            arVar.dR("tid", PbBjhRecommendViewHolder.this.lOt.getTid());
                            if (PbBjhRecommendViewHolder.this.lOt.bpG() != null) {
                                arVar.dR("fid", PbBjhRecommendViewHolder.this.lOt.bpG().getForumId());
                            }
                            arVar.dR("obj_param1", PbBjhRecommendViewHolder.this.lOt.mRecomWeight);
                            arVar.dR("obj_source", PbBjhRecommendViewHolder.this.lOt.mRecomSource);
                            arVar.dR("obj_id", PbBjhRecommendViewHolder.this.lOu);
                            arVar.ap("obj_locate", PbBjhRecommendViewHolder.this.lOt.getFloorNum());
                            arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            if (PbBjhRecommendViewHolder.this.lOt.bln().getBaijiahaoData() != null) {
                                arVar.dR("obj_param4", PbBjhRecommendViewHolder.this.lOt.bln().getBaijiahaoData().oriUgcNid);
                                arVar.dR("obj_param6", PbBjhRecommendViewHolder.this.lOt.bln().getBaijiahaoData().oriUgcVid);
                            }
                            arVar.ap("obj_param5", PbBjhRecommendViewHolder.this.lOt.bpS());
                            arVar.dR("ab_tag", PbBjhRecommendViewHolder.this.lOt.mRecomAbTag);
                            arVar.ap("is_vertical", PbBjhRecommendViewHolder.this.lOt.boh().is_vertical.intValue());
                            arVar.dR("extra", PbBjhRecommendViewHolder.this.lOt.mRecomExtra);
                            TiebaStatic.log(arVar);
                        }
                        if (PbBjhRecommendViewHolder.this.lOr) {
                            ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.lOs).get(VideoPbViewModel.class)).aV(PbBjhRecommendViewHolder.this.lOt);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.lOs);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.from);
                        pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.lOu);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.lOt);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lOs = pbActivity;
        this.bUP = view.findViewById(R.id.main_view);
        this.jWG = view.findViewById(R.id.first_head_divider_line);
        this.lOw = view.findViewById(R.id.bjh_main_content);
        this.lOx = view.findViewById(R.id.bjh_click_container);
        this.feK = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lOy = view.findViewById(R.id.bjh_gradient_cover);
        this.bkl = (TextView) view.findViewById(R.id.bjh_content);
        this.lOz = view.findViewById(R.id.bjh_video_during_container);
        this.kgT = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lOA = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lOB = view.findViewById(R.id.last_video_tail);
        this.lOE = (TextView) view.findViewById(R.id.tail_more_video);
        this.lOC = view.findViewById(R.id.last_tail_divider_line);
        this.lOD = view.findViewById(R.id.last_tail_padding);
        this.lOF = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lOG = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fHj = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.lOt = pVar;
        this.jWG.setVisibility(pVar.blM() ? 0 : 8);
        this.lOD.setVisibility(pVar.blN() ? 0 : 8);
        this.lOw.setVisibility(pVar.blO() ? 8 : 0);
        this.lOB.setVisibility(pVar.blO() ? 0 : 8);
        this.lOE.setOnClickListener(this.fhT);
        this.lOy.setOnClickListener(this.fhT);
        this.feK.setOnClickListener(this.fhT);
        this.feK.setConrers(15);
        this.feK.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.feK.setDrawCorner(true);
        this.feK.setPlaceHolder(2);
        if (pVar.boh() != null) {
            this.bkl.setText(pVar.getTitle());
            this.feK.startLoad(pVar.boh().thumbnail_url, 10, false);
            this.lOy.setVisibility(0);
            this.lOy.setAlpha(0.5f);
            this.lOz.setVisibility(0);
            this.lOA.setText(StringUtils.translateSecondsToString(pVar.boh().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lOG.getLayoutParams();
            if (pVar.bnQ() != null && !com.baidu.tbadk.core.util.au.isEmpty(pVar.bnQ().getName_show())) {
                this.lOF.setText(pVar.bnQ().getName_show());
                this.lOF.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lOF.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lOG.setLayoutParams(layoutParams);
            this.lOG.setText(String.format(this.lOs.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.au.numFormatOverWan(pVar.boh().play_count.intValue())));
        } else {
            this.lOz.setVisibility(8);
            this.lOy.setVisibility(8);
            this.feK.startLoad(pVar.bpQ(), 10, false);
            this.bkl.setText(pVar.getTitle());
        }
        this.bUP.setOnClickListener(this.fhT);
    }

    public void Pp(String str) {
        this.lOu = str;
    }

    public void uV(boolean z) {
        this.lOv = z;
    }

    public void setNid(String str) {
        this.eTz = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uU(boolean z) {
        this.lOr = z;
    }
}
