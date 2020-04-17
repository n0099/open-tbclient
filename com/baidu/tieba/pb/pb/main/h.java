package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
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
public class h extends y.a {
    public TextView aJE;
    public TbImageView dDz;
    private View.OnClickListener dFV;
    private int from;
    public View hFn;
    public View iKI;
    private boolean jqW;
    private PbActivity jqX;
    private com.baidu.tbadk.core.data.l jqY;
    private String jqZ;
    private boolean jra;
    public View jrb;
    public View jrc;
    public View jrd;
    public View jre;
    public ImageView jrf;
    public TextView jrg;
    public View jrh;
    public View jri;
    public View jrj;
    public TextView jrk;
    public TextView jrl;
    public TextView jrm;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dFV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.jqY != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aKV = h.this.jqY.aKV();
                        if (aKV != null) {
                            if (aKV.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.jqY);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(videoItemData);
                                String str = "";
                                if (h.this.from != 2) {
                                    if (h.this.from != 1) {
                                        if (h.this.from == 3) {
                                            str = "frs";
                                        }
                                    } else {
                                        str = "concern_tab";
                                    }
                                } else {
                                    str = "index";
                                }
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.jqX, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.jqY.aIw() != null && h.this.jqY.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.jqY.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aKV.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.jqY);
                                String str2 = "";
                                if (h.this.from != 2) {
                                    if (h.this.from != 1) {
                                        if (h.this.from == 3) {
                                            str2 = "frs";
                                        }
                                    } else {
                                        str2 = "concern_tab";
                                    }
                                } else {
                                    str2 = "index";
                                }
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.jqX, str2, h.this.jqY.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.jqY.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.jqY.threadType == 40) {
                                com.baidu.tbadk.core.util.an.uI("c13535").cI("tid", tid).t("fid", h.this.jqY.getFid()).af("obj_source", i).af("obj_locate", h.this.jqY.getFloorNum()).cI("obj_id", h.this.jqZ).af("obj_type", h.this.jqY.aMx() ? 1 : 0).aOR();
                            } else {
                                com.baidu.tbadk.core.util.an.uI("c13534").cI("tid", tid).t("fid", h.this.jqY.getFid()).af("obj_source", i).af("obj_locate", h.this.jqY.getFloorNum()).cI("obj_id", h.this.jqZ).aOR();
                            }
                        }
                        if (h.this.jra) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cI("tid", h.this.jqY.getTid());
                            if (h.this.jqY.aMp() != null) {
                                anVar.cI("fid", h.this.jqY.aMp().getForumId());
                            }
                            anVar.cI("obj_param1", h.this.jqY.mRecomWeight);
                            anVar.cI("obj_source", h.this.jqY.mRecomSource);
                            anVar.cI("obj_id", h.this.jqZ);
                            anVar.af("obj_locate", h.this.jqY.getFloorNum());
                            anVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.jqY.aIw().getBaijiahaoData() != null) {
                                anVar.cI("obj_param4", h.this.jqY.aIw().getBaijiahaoData().oriUgcNid);
                                anVar.cI("obj_param6", h.this.jqY.aIw().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.af("obj_param5", h.this.jqY.aME());
                            anVar.cI(TiebaInitialize.Params.AB_TAG, h.this.jqY.mRecomAbTag);
                            anVar.af("is_vertical", h.this.jqY.aKV().is_vertical.intValue());
                            anVar.cI("extra", h.this.jqY.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.jqW) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.jqX).l(com.baidu.tieba.pb.videopb.e.class)).aR(h.this.jqY);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.jqX);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.jqZ);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.jqY);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.jqX = pbActivity;
        this.iKI = view.findViewById(R.id.main_view);
        this.hFn = view.findViewById(R.id.first_head_divider_line);
        this.jrb = view.findViewById(R.id.bjh_main_content);
        this.jrc = view.findViewById(R.id.bjh_click_container);
        this.dDz = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.jrd = view.findViewById(R.id.bjh_gradient_cover);
        this.aJE = (TextView) view.findViewById(R.id.bjh_content);
        this.jre = view.findViewById(R.id.bjh_video_during_container);
        this.jrf = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.jrg = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.jrh = view.findViewById(R.id.last_video_tail);
        this.jrk = (TextView) view.findViewById(R.id.tail_more_video);
        this.jri = view.findViewById(R.id.last_tail_divider_line);
        this.jrj = view.findViewById(R.id.last_tail_padding);
        this.jrl = (TextView) view.findViewById(R.id.bjh_user_info);
        this.jrm = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.jqY = lVar;
        this.hFn.setVisibility(lVar.aII() ? 0 : 8);
        this.jrj.setVisibility(lVar.aIJ() ? 0 : 8);
        this.jrb.setVisibility(lVar.aIK() ? 8 : 0);
        this.jrh.setVisibility(lVar.aIK() ? 0 : 8);
        this.jrk.setOnClickListener(this.dFV);
        this.jrd.setOnClickListener(this.dFV);
        this.dDz.setOnClickListener(this.dFV);
        this.dDz.setConrers(15);
        this.dDz.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dDz.setDrawCorner(true);
        this.dDz.setPlaceHolder(2);
        if (lVar.aKV() != null) {
            this.aJE.setText(lVar.getTitle());
            this.dDz.startLoad(lVar.aKV().thumbnail_url, 10, false);
            this.jrd.setVisibility(0);
            this.jrd.setAlpha(0.5f);
            this.jre.setVisibility(0);
            this.jrg.setText(StringUtils.translateSecondsToString(lVar.aKV().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jrm.getLayoutParams();
            if (lVar.aKE() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aKE().getName_show())) {
                this.jrl.setText(lVar.aKE().getName_show());
                this.jrl.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jrl.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jrm.setLayoutParams(layoutParams);
            this.jrm.setText(String.format(this.jqX.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aKV().play_count.intValue())));
        } else {
            this.jre.setVisibility(8);
            this.jrd.setVisibility(8);
            this.dDz.startLoad(lVar.aMC(), 10, false);
            this.aJE.setText(lVar.getTitle());
        }
        this.iKI.setOnClickListener(this.dFV);
    }

    public void Hu(String str) {
        this.jqZ = str;
    }

    public void qR(boolean z) {
        this.jra = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void qQ(boolean z) {
        this.jqW = z;
    }
}
