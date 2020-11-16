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
/* loaded from: classes21.dex */
public class i extends af.a {
    public TextView bfP;
    public TbImageView eQn;
    private View.OnClickListener eTp;
    private int from;
    public View fsk;
    public ImageView jDd;
    public View jsP;
    public View kGn;
    private boolean lrf;
    private PbActivity lrg;
    private com.baidu.tbadk.core.data.o lrh;
    private String lri;
    private boolean lrj;
    public View lrk;
    public View lrl;
    public View lrm;
    public View lrn;
    public TextView lro;
    public View lrp;
    public View lrq;
    public View lrr;
    public TextView lrs;
    public TextView lrt;
    public TextView lru;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.eTp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.lrh != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo blU = i.this.lrh.blU();
                        if (blU != null) {
                            if (blU.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.lrh);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.lrg, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.lrh.bjd() != null && i.this.lrh.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.lrh.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (blU.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.lrh);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.lrg, str2, i.this.lrh.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.lrh.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.lrh.threadType == 40) {
                                com.baidu.tbadk.core.util.ar.Bs("c13535").dR("tid", tid).w("fid", i.this.lrh.getFid()).ak("obj_source", i).ak("obj_locate", i.this.lrh.getFloorNum()).dR("obj_id", i.this.lri).ak("obj_type", i.this.lrh.bny() ? 1 : 0).bqy();
                            } else {
                                com.baidu.tbadk.core.util.ar.Bs("c13534").dR("tid", tid).w("fid", i.this.lrh.getFid()).ak("obj_source", i).ak("obj_locate", i.this.lrh.getFloorNum()).dR("obj_id", i.this.lri).bqy();
                            }
                        }
                        if (i.this.lrj) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13589");
                            arVar.dR("tid", i.this.lrh.getTid());
                            if (i.this.lrh.bns() != null) {
                                arVar.dR("fid", i.this.lrh.bns().getForumId());
                            }
                            arVar.dR("obj_param1", i.this.lrh.mRecomWeight);
                            arVar.dR("obj_source", i.this.lrh.mRecomSource);
                            arVar.dR("obj_id", i.this.lri);
                            arVar.ak("obj_locate", i.this.lrh.getFloorNum());
                            arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.lrh.bjd().getBaijiahaoData() != null) {
                                arVar.dR("obj_param4", i.this.lrh.bjd().getBaijiahaoData().oriUgcNid);
                                arVar.dR("obj_param6", i.this.lrh.bjd().getBaijiahaoData().oriUgcVid);
                            }
                            arVar.ak("obj_param5", i.this.lrh.bnE());
                            arVar.dR("ab_tag", i.this.lrh.mRecomAbTag);
                            arVar.ak("is_vertical", i.this.lrh.blU().is_vertical.intValue());
                            arVar.dR("extra", i.this.lrh.mRecomExtra);
                            TiebaStatic.log(arVar);
                        }
                        if (i.this.lrf) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.lrg).l(com.baidu.tieba.pb.videopb.e.class)).aT(i.this.lrh);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.lrg);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.lri);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.lrh);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lrg = pbActivity;
        this.kGn = view.findViewById(R.id.main_view);
        this.jsP = view.findViewById(R.id.first_head_divider_line);
        this.lrk = view.findViewById(R.id.bjh_main_content);
        this.lrl = view.findViewById(R.id.bjh_click_container);
        this.eQn = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lrm = view.findViewById(R.id.bjh_gradient_cover);
        this.bfP = (TextView) view.findViewById(R.id.bjh_content);
        this.lrn = view.findViewById(R.id.bjh_video_during_container);
        this.jDd = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lro = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lrp = view.findViewById(R.id.last_video_tail);
        this.lrs = (TextView) view.findViewById(R.id.tail_more_video);
        this.lrq = view.findViewById(R.id.last_tail_divider_line);
        this.lrr = view.findViewById(R.id.last_tail_padding);
        this.lrt = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lru = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fsk = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lrh = oVar;
        this.jsP.setVisibility(oVar.bjB() ? 0 : 8);
        this.lrr.setVisibility(oVar.bjC() ? 0 : 8);
        this.lrk.setVisibility(oVar.bjD() ? 8 : 0);
        this.lrp.setVisibility(oVar.bjD() ? 0 : 8);
        this.lrs.setOnClickListener(this.eTp);
        this.lrm.setOnClickListener(this.eTp);
        this.eQn.setOnClickListener(this.eTp);
        this.eQn.setConrers(15);
        this.eQn.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.eQn.setDrawCorner(true);
        this.eQn.setPlaceHolder(2);
        if (oVar.blU() != null) {
            this.bfP.setText(oVar.getTitle());
            this.eQn.startLoad(oVar.blU().thumbnail_url, 10, false);
            this.lrm.setVisibility(0);
            this.lrm.setAlpha(0.5f);
            this.lrn.setVisibility(0);
            this.lro.setText(StringUtils.translateSecondsToString(oVar.blU().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lru.getLayoutParams();
            if (oVar.blC() != null && !com.baidu.tbadk.core.util.au.isEmpty(oVar.blC().getName_show())) {
                this.lrt.setText(oVar.blC().getName_show());
                this.lrt.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lrt.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lru.setLayoutParams(layoutParams);
            this.lru.setText(String.format(this.lrg.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.au.numFormatOverWan(oVar.blU().play_count.intValue())));
        } else {
            this.lrn.setVisibility(8);
            this.lrm.setVisibility(8);
            this.eQn.startLoad(oVar.bnC(), 10, false);
            this.bfP.setText(oVar.getTitle());
        }
        this.kGn.setOnClickListener(this.eTp);
    }

    public void OS(String str) {
        this.lri = str;
    }

    public void uh(boolean z) {
        this.lrj = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void ug(boolean z) {
        this.lrf = z;
    }
}
