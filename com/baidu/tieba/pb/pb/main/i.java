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
    public TextView bkf;
    public TbImageView eXC;
    private View.OnClickListener faK;
    private int from;
    public View fzY;
    public View jGp;
    public ImageView jQF;
    public View kTF;
    private boolean lEO;
    private PbActivity lEP;
    private com.baidu.tbadk.core.data.o lEQ;
    private String lER;
    private boolean lES;
    public View lET;
    public View lEU;
    public View lEV;
    public View lEW;
    public TextView lEX;
    public View lEY;
    public View lEZ;
    public View lFa;
    public TextView lFb;
    public TextView lFc;
    public TextView lFd;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.faK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.lEQ != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bph = i.this.lEQ.bph();
                        if (bph != null) {
                            if (bph.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.lEQ);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.lEP, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.lEQ.bmn() != null && i.this.lEQ.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.lEQ.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bph.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.lEQ);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.lEP, str2, i.this.lEQ.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.lEQ.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.lEQ.threadType == 40) {
                                com.baidu.tbadk.core.util.ar.BZ("c13535").dY("tid", tid).w("fid", i.this.lEQ.getFid()).al("obj_source", i).al("obj_locate", i.this.lEQ.getFloorNum()).dY("obj_id", i.this.lER).al("obj_type", i.this.lEQ.bqL() ? 1 : 0).btT();
                            } else {
                                com.baidu.tbadk.core.util.ar.BZ("c13534").dY("tid", tid).w("fid", i.this.lEQ.getFid()).al("obj_source", i).al("obj_locate", i.this.lEQ.getFloorNum()).dY("obj_id", i.this.lER).btT();
                            }
                        }
                        if (i.this.lES) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13589");
                            arVar.dY("tid", i.this.lEQ.getTid());
                            if (i.this.lEQ.bqF() != null) {
                                arVar.dY("fid", i.this.lEQ.bqF().getForumId());
                            }
                            arVar.dY("obj_param1", i.this.lEQ.mRecomWeight);
                            arVar.dY("obj_source", i.this.lEQ.mRecomSource);
                            arVar.dY("obj_id", i.this.lER);
                            arVar.al("obj_locate", i.this.lEQ.getFloorNum());
                            arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.lEQ.bmn().getBaijiahaoData() != null) {
                                arVar.dY("obj_param4", i.this.lEQ.bmn().getBaijiahaoData().oriUgcNid);
                                arVar.dY("obj_param6", i.this.lEQ.bmn().getBaijiahaoData().oriUgcVid);
                            }
                            arVar.al("obj_param5", i.this.lEQ.bqR());
                            arVar.dY("ab_tag", i.this.lEQ.mRecomAbTag);
                            arVar.al("is_vertical", i.this.lEQ.bph().is_vertical.intValue());
                            arVar.dY("extra", i.this.lEQ.mRecomExtra);
                            TiebaStatic.log(arVar);
                        }
                        if (i.this.lEO) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.lEP).l(com.baidu.tieba.pb.videopb.e.class)).aT(i.this.lEQ);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.lEP);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.lER);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.lEQ);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lEP = pbActivity;
        this.kTF = view.findViewById(R.id.main_view);
        this.jGp = view.findViewById(R.id.first_head_divider_line);
        this.lET = view.findViewById(R.id.bjh_main_content);
        this.lEU = view.findViewById(R.id.bjh_click_container);
        this.eXC = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lEV = view.findViewById(R.id.bjh_gradient_cover);
        this.bkf = (TextView) view.findViewById(R.id.bjh_content);
        this.lEW = view.findViewById(R.id.bjh_video_during_container);
        this.jQF = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lEX = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lEY = view.findViewById(R.id.last_video_tail);
        this.lFb = (TextView) view.findViewById(R.id.tail_more_video);
        this.lEZ = view.findViewById(R.id.last_tail_divider_line);
        this.lFa = view.findViewById(R.id.last_tail_padding);
        this.lFc = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lFd = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fzY = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lEQ = oVar;
        this.jGp.setVisibility(oVar.bmO() ? 0 : 8);
        this.lFa.setVisibility(oVar.bmP() ? 0 : 8);
        this.lET.setVisibility(oVar.bmQ() ? 8 : 0);
        this.lEY.setVisibility(oVar.bmQ() ? 0 : 8);
        this.lFb.setOnClickListener(this.faK);
        this.lEV.setOnClickListener(this.faK);
        this.eXC.setOnClickListener(this.faK);
        this.eXC.setConrers(15);
        this.eXC.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.eXC.setDrawCorner(true);
        this.eXC.setPlaceHolder(2);
        if (oVar.bph() != null) {
            this.bkf.setText(oVar.getTitle());
            this.eXC.startLoad(oVar.bph().thumbnail_url, 10, false);
            this.lEV.setVisibility(0);
            this.lEV.setAlpha(0.5f);
            this.lEW.setVisibility(0);
            this.lEX.setText(StringUtils.translateSecondsToString(oVar.bph().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lFd.getLayoutParams();
            if (oVar.boP() != null && !com.baidu.tbadk.core.util.au.isEmpty(oVar.boP().getName_show())) {
                this.lFc.setText(oVar.boP().getName_show());
                this.lFc.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lFc.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lFd.setLayoutParams(layoutParams);
            this.lFd.setText(String.format(this.lEP.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.au.numFormatOverWan(oVar.bph().play_count.intValue())));
        } else {
            this.lEW.setVisibility(8);
            this.lEV.setVisibility(8);
            this.eXC.startLoad(oVar.bqP(), 10, false);
            this.bkf.setText(oVar.getTitle());
        }
        this.kTF.setOnClickListener(this.faK);
    }

    public void Qa(String str) {
        this.lER = str;
    }

    public void uJ(boolean z) {
        this.lES = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uI(boolean z) {
        this.lEO = z;
    }
}
