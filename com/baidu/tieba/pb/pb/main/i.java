package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
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
public class i extends ad.a {
    public TextView aSb;
    public TbImageView dYH;
    private View.OnClickListener ebA;
    private int from;
    public View ijo;
    public ImageView irl;
    public View jrJ;
    private boolean kcF;
    private PbActivity kcG;
    private com.baidu.tbadk.core.data.n kcH;
    private String kcI;
    private boolean kcJ;
    public View kcK;
    public View kcL;
    public View kcM;
    public View kcN;
    public TextView kcO;
    public View kcP;
    public View kcQ;
    public View kcR;
    public TextView kcS;
    public TextView kcT;
    public TextView kcU;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.ebA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.kcH != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aSH = i.this.kcH.aSH();
                        if (aSH != null) {
                            if (aSH.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kcH);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kcG, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kcH.aPS() != null && i.this.kcH.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kcH.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aSH.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kcH);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kcG, str2, i.this.kcH.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kcH.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kcH.threadType == 40) {
                                com.baidu.tbadk.core.util.ao.wH("c13535").dk("tid", tid).s("fid", i.this.kcH.getFid()).ag("obj_source", i).ag("obj_locate", i.this.kcH.getFloorNum()).dk("obj_id", i.this.kcI).ag("obj_type", i.this.kcH.aUk() ? 1 : 0).aWN();
                            } else {
                                com.baidu.tbadk.core.util.ao.wH("c13534").dk("tid", tid).s("fid", i.this.kcH.getFid()).ag("obj_source", i).ag("obj_locate", i.this.kcH.getFloorNum()).dk("obj_id", i.this.kcI).aWN();
                            }
                        }
                        if (i.this.kcJ) {
                            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13589");
                            aoVar.dk("tid", i.this.kcH.getTid());
                            if (i.this.kcH.aUd() != null) {
                                aoVar.dk("fid", i.this.kcH.aUd().getForumId());
                            }
                            aoVar.dk("obj_param1", i.this.kcH.mRecomWeight);
                            aoVar.dk("obj_source", i.this.kcH.mRecomSource);
                            aoVar.dk("obj_id", i.this.kcI);
                            aoVar.ag("obj_locate", i.this.kcH.getFloorNum());
                            aoVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kcH.aPS().getBaijiahaoData() != null) {
                                aoVar.dk("obj_param4", i.this.kcH.aPS().getBaijiahaoData().oriUgcNid);
                                aoVar.dk("obj_param6", i.this.kcH.aPS().getBaijiahaoData().oriUgcVid);
                            }
                            aoVar.ag("obj_param5", i.this.kcH.aUq());
                            aoVar.dk("ab_tag", i.this.kcH.mRecomAbTag);
                            aoVar.ag("is_vertical", i.this.kcH.aSH().is_vertical.intValue());
                            aoVar.dk("extra", i.this.kcH.mRecomExtra);
                            TiebaStatic.log(aoVar);
                        }
                        if (i.this.kcF) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kcG).l(com.baidu.tieba.pb.videopb.e.class)).aS(i.this.kcH);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kcG);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.kcI);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kcH);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kcG = pbActivity;
        this.jrJ = view.findViewById(R.id.main_view);
        this.ijo = view.findViewById(R.id.first_head_divider_line);
        this.kcK = view.findViewById(R.id.bjh_main_content);
        this.kcL = view.findViewById(R.id.bjh_click_container);
        this.dYH = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.kcM = view.findViewById(R.id.bjh_gradient_cover);
        this.aSb = (TextView) view.findViewById(R.id.bjh_content);
        this.kcN = view.findViewById(R.id.bjh_video_during_container);
        this.irl = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kcO = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.kcP = view.findViewById(R.id.last_video_tail);
        this.kcS = (TextView) view.findViewById(R.id.tail_more_video);
        this.kcQ = view.findViewById(R.id.last_tail_divider_line);
        this.kcR = view.findViewById(R.id.last_tail_padding);
        this.kcT = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kcU = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kcH = nVar;
        this.ijo.setVisibility(nVar.aQo() ? 0 : 8);
        this.kcR.setVisibility(nVar.aQp() ? 0 : 8);
        this.kcK.setVisibility(nVar.aQq() ? 8 : 0);
        this.kcP.setVisibility(nVar.aQq() ? 0 : 8);
        this.kcS.setOnClickListener(this.ebA);
        this.kcM.setOnClickListener(this.ebA);
        this.dYH.setOnClickListener(this.ebA);
        this.dYH.setConrers(15);
        this.dYH.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dYH.setDrawCorner(true);
        this.dYH.setPlaceHolder(2);
        if (nVar.aSH() != null) {
            this.aSb.setText(nVar.getTitle());
            this.dYH.startLoad(nVar.aSH().thumbnail_url, 10, false);
            this.kcM.setVisibility(0);
            this.kcM.setAlpha(0.5f);
            this.kcN.setVisibility(0);
            this.kcO.setText(StringUtils.translateSecondsToString(nVar.aSH().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kcU.getLayoutParams();
            if (nVar.aSp() != null && !com.baidu.tbadk.core.util.ar.isEmpty(nVar.aSp().getName_show())) {
                this.kcT.setText(nVar.aSp().getName_show());
                this.kcT.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kcT.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kcU.setLayoutParams(layoutParams);
            this.kcU.setText(String.format(this.kcG.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.ar.numFormatOverWan(nVar.aSH().play_count.intValue())));
        } else {
            this.kcN.setVisibility(8);
            this.kcM.setVisibility(8);
            this.dYH.startLoad(nVar.aUo(), 10, false);
            this.aSb.setText(nVar.getTitle());
        }
        this.jrJ.setOnClickListener(this.ebA);
    }

    public void JL(String str) {
        this.kcI = str;
    }

    public void rC(boolean z) {
        this.kcJ = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void rB(boolean z) {
        this.kcF = z;
    }
}
