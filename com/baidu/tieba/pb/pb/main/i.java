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
    public View jGr;
    public ImageView jQH;
    public View kTH;
    private boolean lEQ;
    private PbActivity lER;
    private com.baidu.tbadk.core.data.o lES;
    private String lET;
    private boolean lEU;
    public View lEV;
    public View lEW;
    public View lEX;
    public View lEY;
    public TextView lEZ;
    public View lFa;
    public View lFb;
    public View lFc;
    public TextView lFd;
    public TextView lFe;
    public TextView lFf;
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
                if (i.this.lES != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo bph = i.this.lES.bph();
                        if (bph != null) {
                            if (bph.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.lES);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.lER, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.lES.bmn() != null && i.this.lES.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.lES.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (bph.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.lES);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.lER, str2, i.this.lES.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.lES.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.lES.threadType == 40) {
                                com.baidu.tbadk.core.util.ar.BZ("c13535").dY("tid", tid).w("fid", i.this.lES.getFid()).al("obj_source", i).al("obj_locate", i.this.lES.getFloorNum()).dY("obj_id", i.this.lET).al("obj_type", i.this.lES.bqL() ? 1 : 0).btT();
                            } else {
                                com.baidu.tbadk.core.util.ar.BZ("c13534").dY("tid", tid).w("fid", i.this.lES.getFid()).al("obj_source", i).al("obj_locate", i.this.lES.getFloorNum()).dY("obj_id", i.this.lET).btT();
                            }
                        }
                        if (i.this.lEU) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13589");
                            arVar.dY("tid", i.this.lES.getTid());
                            if (i.this.lES.bqF() != null) {
                                arVar.dY("fid", i.this.lES.bqF().getForumId());
                            }
                            arVar.dY("obj_param1", i.this.lES.mRecomWeight);
                            arVar.dY("obj_source", i.this.lES.mRecomSource);
                            arVar.dY("obj_id", i.this.lET);
                            arVar.al("obj_locate", i.this.lES.getFloorNum());
                            arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.lES.bmn().getBaijiahaoData() != null) {
                                arVar.dY("obj_param4", i.this.lES.bmn().getBaijiahaoData().oriUgcNid);
                                arVar.dY("obj_param6", i.this.lES.bmn().getBaijiahaoData().oriUgcVid);
                            }
                            arVar.al("obj_param5", i.this.lES.bqR());
                            arVar.dY("ab_tag", i.this.lES.mRecomAbTag);
                            arVar.al("is_vertical", i.this.lES.bph().is_vertical.intValue());
                            arVar.dY("extra", i.this.lES.mRecomExtra);
                            TiebaStatic.log(arVar);
                        }
                        if (i.this.lEQ) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.lER).l(com.baidu.tieba.pb.videopb.e.class)).aT(i.this.lES);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.lER);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.lET);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.lES);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lER = pbActivity;
        this.kTH = view.findViewById(R.id.main_view);
        this.jGr = view.findViewById(R.id.first_head_divider_line);
        this.lEV = view.findViewById(R.id.bjh_main_content);
        this.lEW = view.findViewById(R.id.bjh_click_container);
        this.eXC = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lEX = view.findViewById(R.id.bjh_gradient_cover);
        this.bkf = (TextView) view.findViewById(R.id.bjh_content);
        this.lEY = view.findViewById(R.id.bjh_video_during_container);
        this.jQH = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lEZ = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lFa = view.findViewById(R.id.last_video_tail);
        this.lFd = (TextView) view.findViewById(R.id.tail_more_video);
        this.lFb = view.findViewById(R.id.last_tail_divider_line);
        this.lFc = view.findViewById(R.id.last_tail_padding);
        this.lFe = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lFf = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fzY = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lES = oVar;
        this.jGr.setVisibility(oVar.bmO() ? 0 : 8);
        this.lFc.setVisibility(oVar.bmP() ? 0 : 8);
        this.lEV.setVisibility(oVar.bmQ() ? 8 : 0);
        this.lFa.setVisibility(oVar.bmQ() ? 0 : 8);
        this.lFd.setOnClickListener(this.faK);
        this.lEX.setOnClickListener(this.faK);
        this.eXC.setOnClickListener(this.faK);
        this.eXC.setConrers(15);
        this.eXC.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.eXC.setDrawCorner(true);
        this.eXC.setPlaceHolder(2);
        if (oVar.bph() != null) {
            this.bkf.setText(oVar.getTitle());
            this.eXC.startLoad(oVar.bph().thumbnail_url, 10, false);
            this.lEX.setVisibility(0);
            this.lEX.setAlpha(0.5f);
            this.lEY.setVisibility(0);
            this.lEZ.setText(StringUtils.translateSecondsToString(oVar.bph().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lFf.getLayoutParams();
            if (oVar.boP() != null && !com.baidu.tbadk.core.util.au.isEmpty(oVar.boP().getName_show())) {
                this.lFe.setText(oVar.boP().getName_show());
                this.lFe.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lFe.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lFf.setLayoutParams(layoutParams);
            this.lFf.setText(String.format(this.lER.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.au.numFormatOverWan(oVar.bph().play_count.intValue())));
        } else {
            this.lEY.setVisibility(8);
            this.lEX.setVisibility(8);
            this.eXC.startLoad(oVar.bqP(), 10, false);
            this.bkf.setText(oVar.getTitle());
        }
        this.kTH.setOnClickListener(this.faK);
    }

    public void Qa(String str) {
        this.lET = str;
    }

    public void uJ(boolean z) {
        this.lEU = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uI(boolean z) {
        this.lEQ = z;
    }
}
