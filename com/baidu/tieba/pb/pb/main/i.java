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
    public TextView beR;
    public TbImageView eDb;
    private View.OnClickListener eFW;
    private int from;
    public View iZQ;
    public ImageView jjM;
    public View kYA;
    public View kYB;
    public View kYC;
    public TextView kYD;
    public TextView kYE;
    public TextView kYF;
    private boolean kYq;
    private PbActivity kYr;
    private com.baidu.tbadk.core.data.n kYs;
    private String kYt;
    private boolean kYu;
    public View kYv;
    public View kYw;
    public View kYx;
    public View kYy;
    public TextView kYz;
    public View knH;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.eFW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.kYs != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo biz = i.this.kYs.biz();
                        if (biz != null) {
                            if (biz.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kYs);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kYr, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kYs.bfG() != null && i.this.kYs.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kYs.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (biz.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kYs);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kYr, str2, i.this.kYs.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kYs.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kYs.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.Bm("c13535").dK("tid", tid).u("fid", i.this.kYs.getFid()).aj("obj_source", i).aj("obj_locate", i.this.kYs.getFloorNum()).dK("obj_id", i.this.kYt).aj("obj_type", i.this.kYs.bkb() ? 1 : 0).bmR();
                            } else {
                                com.baidu.tbadk.core.util.aq.Bm("c13534").dK("tid", tid).u("fid", i.this.kYs.getFid()).aj("obj_source", i).aj("obj_locate", i.this.kYs.getFloorNum()).dK("obj_id", i.this.kYt).bmR();
                            }
                        }
                        if (i.this.kYu) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dK("tid", i.this.kYs.getTid());
                            if (i.this.kYs.bjV() != null) {
                                aqVar.dK("fid", i.this.kYs.bjV().getForumId());
                            }
                            aqVar.dK("obj_param1", i.this.kYs.mRecomWeight);
                            aqVar.dK("obj_source", i.this.kYs.mRecomSource);
                            aqVar.dK("obj_id", i.this.kYt);
                            aqVar.aj("obj_locate", i.this.kYs.getFloorNum());
                            aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kYs.bfG().getBaijiahaoData() != null) {
                                aqVar.dK("obj_param4", i.this.kYs.bfG().getBaijiahaoData().oriUgcNid);
                                aqVar.dK("obj_param6", i.this.kYs.bfG().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.aj("obj_param5", i.this.kYs.bkh());
                            aqVar.dK("ab_tag", i.this.kYs.mRecomAbTag);
                            aqVar.aj("is_vertical", i.this.kYs.biz().is_vertical.intValue());
                            aqVar.dK("extra", i.this.kYs.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (i.this.kYq) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kYr).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.kYs);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kYr);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.kYt);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kYs);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kYr = pbActivity;
        this.knH = view.findViewById(R.id.main_view);
        this.iZQ = view.findViewById(R.id.first_head_divider_line);
        this.kYv = view.findViewById(R.id.bjh_main_content);
        this.kYw = view.findViewById(R.id.bjh_click_container);
        this.eDb = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.kYx = view.findViewById(R.id.bjh_gradient_cover);
        this.beR = (TextView) view.findViewById(R.id.bjh_content);
        this.kYy = view.findViewById(R.id.bjh_video_during_container);
        this.jjM = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kYz = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.kYA = view.findViewById(R.id.last_video_tail);
        this.kYD = (TextView) view.findViewById(R.id.tail_more_video);
        this.kYB = view.findViewById(R.id.last_tail_divider_line);
        this.kYC = view.findViewById(R.id.last_tail_padding);
        this.kYE = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kYF = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kYs = nVar;
        this.iZQ.setVisibility(nVar.bgg() ? 0 : 8);
        this.kYC.setVisibility(nVar.bgh() ? 0 : 8);
        this.kYv.setVisibility(nVar.bgi() ? 8 : 0);
        this.kYA.setVisibility(nVar.bgi() ? 0 : 8);
        this.kYD.setOnClickListener(this.eFW);
        this.kYx.setOnClickListener(this.eFW);
        this.eDb.setOnClickListener(this.eFW);
        this.eDb.setConrers(15);
        this.eDb.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eDb.setDrawCorner(true);
        this.eDb.setPlaceHolder(2);
        if (nVar.biz() != null) {
            this.beR.setText(nVar.getTitle());
            this.eDb.startLoad(nVar.biz().thumbnail_url, 10, false);
            this.kYx.setVisibility(0);
            this.kYx.setAlpha(0.5f);
            this.kYy.setVisibility(0);
            this.kYz.setText(StringUtils.translateSecondsToString(nVar.biz().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kYF.getLayoutParams();
            if (nVar.bih() != null && !com.baidu.tbadk.core.util.at.isEmpty(nVar.bih().getName_show())) {
                this.kYE.setText(nVar.bih().getName_show());
                this.kYE.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kYE.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kYF.setLayoutParams(layoutParams);
            this.kYF.setText(String.format(this.kYr.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(nVar.biz().play_count.intValue())));
        } else {
            this.kYy.setVisibility(8);
            this.kYx.setVisibility(8);
            this.eDb.startLoad(nVar.bkf(), 10, false);
            this.beR.setText(nVar.getTitle());
        }
        this.knH.setOnClickListener(this.eFW);
    }

    public void OH(String str) {
        this.kYt = str;
    }

    public void tE(boolean z) {
        this.kYu = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void tD(boolean z) {
        this.kYq = z;
    }
}
