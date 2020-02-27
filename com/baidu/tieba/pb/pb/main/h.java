package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
public class h extends v.a {
    public TextView aqO;
    public TbImageView ddz;
    private View.OnClickListener dfX;
    private int from;
    public View gUb;
    public View hZa;
    private boolean iFa;
    private PbActivity iFb;
    private com.baidu.tbadk.core.data.l iFc;
    private String iFd;
    private boolean iFe;
    public View iFf;
    public View iFg;
    public View iFh;
    public View iFi;
    public ImageView iFj;
    public TextView iFk;
    public View iFl;
    public View iFm;
    public View iFn;
    public TextView iFo;
    public TextView iFp;
    public TextView iFq;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dfX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.iFc != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aCD = h.this.iFc.aCD();
                        if (aCD != null) {
                            if (aCD.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.iFc);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.iFb, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.iFc.aAe() != null && h.this.iFc.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.iFc.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aCD.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.iFc);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.iFb, str2, h.this.iFc.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.iFc.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.iFc.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tv("c13535").cy("tid", tid).s("fid", h.this.iFc.getFid()).X("obj_source", i).X("obj_locate", h.this.iFc.getFloorNum()).cy("obj_id", h.this.iFd).X("obj_type", h.this.iFc.aEd() ? 1 : 0).aGx();
                            } else {
                                com.baidu.tbadk.core.util.an.tv("c13534").cy("tid", tid).s("fid", h.this.iFc.getFid()).X("obj_source", i).X("obj_locate", h.this.iFc.getFloorNum()).cy("obj_id", h.this.iFd).aGx();
                            }
                        }
                        if (h.this.iFe) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cy("tid", h.this.iFc.getTid());
                            if (h.this.iFc.aDV() != null) {
                                anVar.cy("fid", h.this.iFc.aDV().getForumId());
                            }
                            anVar.cy("obj_param1", h.this.iFc.mRecomWeight);
                            anVar.cy("obj_source", h.this.iFc.mRecomSource);
                            anVar.cy("obj_id", h.this.iFd);
                            anVar.X("obj_locate", h.this.iFc.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.iFc.aAe().getBaijiahaoData() != null) {
                                anVar.cy("obj_param4", h.this.iFc.aAe().getBaijiahaoData().oriUgcNid);
                                anVar.cy("obj_param6", h.this.iFc.aAe().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.X("obj_param5", h.this.iFc.aEk());
                            anVar.cy(TiebaInitialize.Params.AB_TAG, h.this.iFc.mRecomAbTag);
                            anVar.X("is_vertical", h.this.iFc.aCD().is_vertical.intValue());
                            anVar.cy("extra", h.this.iFc.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.iFa) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.iFb).l(com.baidu.tieba.pb.videopb.e.class)).aP(h.this.iFc);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.iFb);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.iFd);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.iFc);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.iFb = pbActivity;
        this.hZa = view.findViewById(R.id.main_view);
        this.gUb = view.findViewById(R.id.first_head_divider_line);
        this.iFf = view.findViewById(R.id.bjh_main_content);
        this.iFg = view.findViewById(R.id.bjh_click_container);
        this.ddz = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.iFh = view.findViewById(R.id.bjh_gradient_cover);
        this.aqO = (TextView) view.findViewById(R.id.bjh_content);
        this.iFi = view.findViewById(R.id.bjh_video_during_container);
        this.iFj = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.iFk = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iFl = view.findViewById(R.id.last_video_tail);
        this.iFo = (TextView) view.findViewById(R.id.tail_more_video);
        this.iFm = view.findViewById(R.id.last_tail_divider_line);
        this.iFn = view.findViewById(R.id.last_tail_padding);
        this.iFp = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iFq = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.iFc = lVar;
        this.gUb.setVisibility(lVar.aAq() ? 0 : 8);
        this.iFn.setVisibility(lVar.aAr() ? 0 : 8);
        this.iFf.setVisibility(lVar.aAs() ? 8 : 0);
        this.iFl.setVisibility(lVar.aAs() ? 0 : 8);
        this.iFo.setOnClickListener(this.dfX);
        this.iFh.setOnClickListener(this.dfX);
        this.ddz.setOnClickListener(this.dfX);
        this.ddz.setConrers(15);
        this.ddz.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.ddz.setDrawCorner(true);
        this.ddz.setPlaceHolder(2);
        if (lVar.aCD() != null) {
            this.aqO.setText(lVar.getTitle());
            this.ddz.startLoad(lVar.aCD().thumbnail_url, 10, false);
            this.iFh.setVisibility(0);
            this.iFh.setAlpha(0.5f);
            this.iFi.setVisibility(0);
            this.iFk.setText(StringUtils.translateSecondsToString(lVar.aCD().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFq.getLayoutParams();
            if (lVar.aCm() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aCm().getName_show())) {
                this.iFp.setText(lVar.aCm().getName_show());
                this.iFp.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iFp.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iFq.setLayoutParams(layoutParams);
            this.iFq.setText(String.format(this.iFb.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aCD().play_count.intValue())));
        } else {
            this.iFi.setVisibility(8);
            this.iFh.setVisibility(8);
            this.ddz.startLoad(lVar.aEi(), 10, false);
            this.aqO.setText(lVar.getTitle());
        }
        this.hZa.setOnClickListener(this.dfX);
    }

    public void FM(String str) {
        this.iFd = str;
    }

    public void pH(boolean z) {
        this.iFe = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pG(boolean z) {
        this.iFa = z;
    }
}
