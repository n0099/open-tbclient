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
    public TextView bbh;
    public TbImageView eqP;
    private View.OnClickListener etM;
    private int from;
    public View iKY;
    public ImageView iUO;
    public View jYr;
    private boolean kJf;
    private PbActivity kJg;
    private com.baidu.tbadk.core.data.n kJh;
    private String kJi;
    private boolean kJj;
    public View kJk;
    public View kJl;
    public View kJm;
    public View kJn;
    public TextView kJo;
    public View kJp;
    public View kJq;
    public View kJr;
    public TextView kJs;
    public TextView kJt;
    public TextView kJu;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.kJh != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bfQ = i.this.kJh.bfQ();
                        if (bfQ != null) {
                            if (bfQ.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kJh);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kJg, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kJh.bcY() != null && i.this.kJh.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kJh.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bfQ.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kJh);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kJg, str2, i.this.kJh.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kJh.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kJh.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.AA("c13535").dF("tid", tid).u("fid", i.this.kJh.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kJh.getFloorNum()).dF("obj_id", i.this.kJi).ai("obj_type", i.this.kJh.bhs() ? 1 : 0).bki();
                            } else {
                                com.baidu.tbadk.core.util.aq.AA("c13534").dF("tid", tid).u("fid", i.this.kJh.getFid()).ai("obj_source", i).ai("obj_locate", i.this.kJh.getFloorNum()).dF("obj_id", i.this.kJi).bki();
                            }
                        }
                        if (i.this.kJj) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dF("tid", i.this.kJh.getTid());
                            if (i.this.kJh.bhm() != null) {
                                aqVar.dF("fid", i.this.kJh.bhm().getForumId());
                            }
                            aqVar.dF("obj_param1", i.this.kJh.mRecomWeight);
                            aqVar.dF("obj_source", i.this.kJh.mRecomSource);
                            aqVar.dF("obj_id", i.this.kJi);
                            aqVar.ai("obj_locate", i.this.kJh.getFloorNum());
                            aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kJh.bcY().getBaijiahaoData() != null) {
                                aqVar.dF("obj_param4", i.this.kJh.bcY().getBaijiahaoData().oriUgcNid);
                                aqVar.dF("obj_param6", i.this.kJh.bcY().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.ai("obj_param5", i.this.kJh.bhy());
                            aqVar.dF("ab_tag", i.this.kJh.mRecomAbTag);
                            aqVar.ai("is_vertical", i.this.kJh.bfQ().is_vertical.intValue());
                            aqVar.dF("extra", i.this.kJh.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.kJf) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kJg).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.kJh);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kJg);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.kJi);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kJh);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kJg = pbActivity;
        this.jYr = view.findViewById(R.id.main_view);
        this.iKY = view.findViewById(R.id.first_head_divider_line);
        this.kJk = view.findViewById(R.id.bjh_main_content);
        this.kJl = view.findViewById(R.id.bjh_click_container);
        this.eqP = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.kJm = view.findViewById(R.id.bjh_gradient_cover);
        this.bbh = (TextView) view.findViewById(R.id.bjh_content);
        this.kJn = view.findViewById(R.id.bjh_video_during_container);
        this.iUO = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kJo = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.kJp = view.findViewById(R.id.last_video_tail);
        this.kJs = (TextView) view.findViewById(R.id.tail_more_video);
        this.kJq = view.findViewById(R.id.last_tail_divider_line);
        this.kJr = view.findViewById(R.id.last_tail_padding);
        this.kJt = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kJu = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kJh = nVar;
        this.iKY.setVisibility(nVar.bdx() ? 0 : 8);
        this.kJr.setVisibility(nVar.bdy() ? 0 : 8);
        this.kJk.setVisibility(nVar.bdz() ? 8 : 0);
        this.kJp.setVisibility(nVar.bdz() ? 0 : 8);
        this.kJs.setOnClickListener(this.etM);
        this.kJm.setOnClickListener(this.etM);
        this.eqP.setOnClickListener(this.etM);
        this.eqP.setConrers(15);
        this.eqP.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eqP.setDrawCorner(true);
        this.eqP.setPlaceHolder(2);
        if (nVar.bfQ() != null) {
            this.bbh.setText(nVar.getTitle());
            this.eqP.startLoad(nVar.bfQ().thumbnail_url, 10, false);
            this.kJm.setVisibility(0);
            this.kJm.setAlpha(0.5f);
            this.kJn.setVisibility(0);
            this.kJo.setText(StringUtils.translateSecondsToString(nVar.bfQ().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kJu.getLayoutParams();
            if (nVar.bfy() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.bfy().getName_show())) {
                this.kJt.setText(nVar.bfy().getName_show());
                this.kJt.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kJt.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kJu.setLayoutParams(layoutParams);
            this.kJu.setText(String.format(this.kJg.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.bfQ().play_count.intValue())));
        } else {
            this.kJn.setVisibility(8);
            this.kJm.setVisibility(8);
            this.eqP.startLoad(nVar.bhw(), 10, false);
            this.bbh.setText(nVar.getTitle());
        }
        this.jYr.setOnClickListener(this.etM);
    }

    public void NS(String str) {
        this.kJi = str;
    }

    public void sX(boolean z) {
        this.kJj = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void sW(boolean z) {
        this.kJf = z;
    }
}
