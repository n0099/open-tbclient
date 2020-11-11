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
    public TextView bhB;
    public TbImageView eRm;
    private View.OnClickListener eUh;
    private int from;
    public ImageView jCg;
    public View jsi;
    public View kFY;
    private boolean lqQ;
    private PbActivity lqR;
    private com.baidu.tbadk.core.data.n lqS;
    private String lqT;
    private boolean lqU;
    public View lqV;
    public View lqW;
    public View lqX;
    public View lqY;
    public TextView lqZ;
    public View lra;
    public View lrb;
    public View lrc;
    public TextView lrd;
    public TextView lre;
    public TextView lrf;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.eUh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.lqS != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bmS = i.this.lqS.bmS();
                        if (bmS != null) {
                            if (bmS.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.lqS);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.lqR, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.lqS.bjZ() != null && i.this.lqS.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.lqS.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bmS.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.lqS);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.lqR, str2, i.this.lqS.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.lqS.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.lqS.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.BT("c13535").dR("tid", tid).w("fid", i.this.lqS.getFid()).al("obj_source", i).al("obj_locate", i.this.lqS.getFloorNum()).dR("obj_id", i.this.lqT).al("obj_type", i.this.lqS.bou() ? 1 : 0).brk();
                            } else {
                                com.baidu.tbadk.core.util.aq.BT("c13534").dR("tid", tid).w("fid", i.this.lqS.getFid()).al("obj_source", i).al("obj_locate", i.this.lqS.getFloorNum()).dR("obj_id", i.this.lqT).brk();
                            }
                        }
                        if (i.this.lqU) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dR("tid", i.this.lqS.getTid());
                            if (i.this.lqS.boo() != null) {
                                aqVar.dR("fid", i.this.lqS.boo().getForumId());
                            }
                            aqVar.dR("obj_param1", i.this.lqS.mRecomWeight);
                            aqVar.dR("obj_source", i.this.lqS.mRecomSource);
                            aqVar.dR("obj_id", i.this.lqT);
                            aqVar.al("obj_locate", i.this.lqS.getFloorNum());
                            aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.lqS.bjZ().getBaijiahaoData() != null) {
                                aqVar.dR("obj_param4", i.this.lqS.bjZ().getBaijiahaoData().oriUgcNid);
                                aqVar.dR("obj_param6", i.this.lqS.bjZ().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.al("obj_param5", i.this.lqS.boA());
                            aqVar.dR("ab_tag", i.this.lqS.mRecomAbTag);
                            aqVar.al("is_vertical", i.this.lqS.bmS().is_vertical.intValue());
                            aqVar.dR("extra", i.this.lqS.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.lqQ) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.lqR).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.lqS);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.lqR);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.lqT);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.lqS);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lqR = pbActivity;
        this.kFY = view.findViewById(R.id.main_view);
        this.jsi = view.findViewById(R.id.first_head_divider_line);
        this.lqV = view.findViewById(R.id.bjh_main_content);
        this.lqW = view.findViewById(R.id.bjh_click_container);
        this.eRm = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lqX = view.findViewById(R.id.bjh_gradient_cover);
        this.bhB = (TextView) view.findViewById(R.id.bjh_content);
        this.lqY = view.findViewById(R.id.bjh_video_during_container);
        this.jCg = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lqZ = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lra = view.findViewById(R.id.last_video_tail);
        this.lrd = (TextView) view.findViewById(R.id.tail_more_video);
        this.lrb = view.findViewById(R.id.last_tail_divider_line);
        this.lrc = view.findViewById(R.id.last_tail_padding);
        this.lre = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lrf = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.lqS = nVar;
        this.jsi.setVisibility(nVar.bkz() ? 0 : 8);
        this.lrc.setVisibility(nVar.bkA() ? 0 : 8);
        this.lqV.setVisibility(nVar.bkB() ? 8 : 0);
        this.lra.setVisibility(nVar.bkB() ? 0 : 8);
        this.lrd.setOnClickListener(this.eUh);
        this.lqX.setOnClickListener(this.eUh);
        this.eRm.setOnClickListener(this.eUh);
        this.eRm.setConrers(15);
        this.eRm.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eRm.setDrawCorner(true);
        this.eRm.setPlaceHolder(2);
        if (nVar.bmS() != null) {
            this.bhB.setText(nVar.getTitle());
            this.eRm.startLoad(nVar.bmS().thumbnail_url, 10, false);
            this.lqX.setVisibility(0);
            this.lqX.setAlpha(0.5f);
            this.lqY.setVisibility(0);
            this.lqZ.setText(StringUtils.translateSecondsToString(nVar.bmS().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lrf.getLayoutParams();
            if (nVar.bmA() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.bmA().getName_show())) {
                this.lre.setText(nVar.bmA().getName_show());
                this.lre.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.lre.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lrf.setLayoutParams(layoutParams);
            this.lrf.setText(String.format(this.lqR.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.bmS().play_count.intValue())));
        } else {
            this.lqY.setVisibility(8);
            this.lqX.setVisibility(8);
            this.eRm.startLoad(nVar.boy(), 10, false);
            this.bhB.setText(nVar.getTitle());
        }
        this.kFY.setOnClickListener(this.eUh);
    }

    public void Pw(String str) {
        this.lqT = str;
    }

    public void ue(boolean z) {
        this.lqU = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void ud(boolean z) {
        this.lqQ = z;
    }
}
