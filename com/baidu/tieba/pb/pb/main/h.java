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
    public TbImageView ddA;
    private View.OnClickListener dfY;
    private int from;
    public View gUd;
    public View hZc;
    private boolean iFc;
    private PbActivity iFd;
    private com.baidu.tbadk.core.data.l iFe;
    private String iFf;
    private boolean iFg;
    public View iFh;
    public View iFi;
    public View iFj;
    public View iFk;
    public ImageView iFl;
    public TextView iFm;
    public View iFn;
    public View iFo;
    public View iFp;
    public TextView iFq;
    public TextView iFr;
    public TextView iFs;
    private String mNid;
    public int mSkinType;

    public h(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dfY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (h.this.iFe != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aCF = h.this.iFe.aCF();
                        if (aCF != null) {
                            if (aCF.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(h.this.iFe);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(h.this.iFd, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (h.this.iFe.aAg() != null && h.this.iFe.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(h.this.iFe.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aCF.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(h.this.iFe);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(h.this.iFd, str2, h.this.iFe.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(h.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = h.this.iFe.getTid();
                        if (h.this.from == 2) {
                            i = 1;
                        } else if (h.this.from != 1) {
                            i = h.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (h.this.iFe.threadType == 40) {
                                com.baidu.tbadk.core.util.an.tv("c13535").cy("tid", tid).s("fid", h.this.iFe.getFid()).X("obj_source", i).X("obj_locate", h.this.iFe.getFloorNum()).cy("obj_id", h.this.iFf).X("obj_type", h.this.iFe.aEf() ? 1 : 0).aGz();
                            } else {
                                com.baidu.tbadk.core.util.an.tv("c13534").cy("tid", tid).s("fid", h.this.iFe.getFid()).X("obj_source", i).X("obj_locate", h.this.iFe.getFloorNum()).cy("obj_id", h.this.iFf).aGz();
                            }
                        }
                        if (h.this.iFg) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.cy("tid", h.this.iFe.getTid());
                            if (h.this.iFe.aDX() != null) {
                                anVar.cy("fid", h.this.iFe.aDX().getForumId());
                            }
                            anVar.cy("obj_param1", h.this.iFe.mRecomWeight);
                            anVar.cy("obj_source", h.this.iFe.mRecomSource);
                            anVar.cy("obj_id", h.this.iFf);
                            anVar.X("obj_locate", h.this.iFe.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            if (h.this.iFe.aAg().getBaijiahaoData() != null) {
                                anVar.cy("obj_param4", h.this.iFe.aAg().getBaijiahaoData().oriUgcNid);
                                anVar.cy("obj_param6", h.this.iFe.aAg().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.X("obj_param5", h.this.iFe.aEm());
                            anVar.cy(TiebaInitialize.Params.AB_TAG, h.this.iFe.mRecomAbTag);
                            anVar.X("is_vertical", h.this.iFe.aCF().is_vertical.intValue());
                            anVar.cy("extra", h.this.iFe.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (h.this.iFc) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(h.this.iFd).l(com.baidu.tieba.pb.videopb.e.class)).aP(h.this.iFe);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(h.this.iFd);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(h.this.from);
                        pbActivityConfig.setLastTid(h.this.iFf);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(h.this.iFe);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.iFd = pbActivity;
        this.hZc = view.findViewById(R.id.main_view);
        this.gUd = view.findViewById(R.id.first_head_divider_line);
        this.iFh = view.findViewById(R.id.bjh_main_content);
        this.iFi = view.findViewById(R.id.bjh_click_container);
        this.ddA = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.iFj = view.findViewById(R.id.bjh_gradient_cover);
        this.aqO = (TextView) view.findViewById(R.id.bjh_content);
        this.iFk = view.findViewById(R.id.bjh_video_during_container);
        this.iFl = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.iFm = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.iFn = view.findViewById(R.id.last_video_tail);
        this.iFq = (TextView) view.findViewById(R.id.tail_more_video);
        this.iFo = view.findViewById(R.id.last_tail_divider_line);
        this.iFp = view.findViewById(R.id.last_tail_padding);
        this.iFr = (TextView) view.findViewById(R.id.bjh_user_info);
        this.iFs = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.iFe = lVar;
        this.gUd.setVisibility(lVar.aAs() ? 0 : 8);
        this.iFp.setVisibility(lVar.aAt() ? 0 : 8);
        this.iFh.setVisibility(lVar.aAu() ? 8 : 0);
        this.iFn.setVisibility(lVar.aAu() ? 0 : 8);
        this.iFq.setOnClickListener(this.dfY);
        this.iFj.setOnClickListener(this.dfY);
        this.ddA.setOnClickListener(this.dfY);
        this.ddA.setConrers(15);
        this.ddA.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.ddA.setDrawCorner(true);
        this.ddA.setPlaceHolder(2);
        if (lVar.aCF() != null) {
            this.aqO.setText(lVar.getTitle());
            this.ddA.startLoad(lVar.aCF().thumbnail_url, 10, false);
            this.iFj.setVisibility(0);
            this.iFj.setAlpha(0.5f);
            this.iFk.setVisibility(0);
            this.iFm.setText(StringUtils.translateSecondsToString(lVar.aCF().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFs.getLayoutParams();
            if (lVar.aCo() != null && !com.baidu.tbadk.core.util.aq.isEmpty(lVar.aCo().getName_show())) {
                this.iFr.setText(lVar.aCo().getName_show());
                this.iFr.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.iFr.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.iFs.setLayoutParams(layoutParams);
            this.iFs.setText(String.format(this.iFd.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(lVar.aCF().play_count.intValue())));
        } else {
            this.iFk.setVisibility(8);
            this.iFj.setVisibility(8);
            this.ddA.startLoad(lVar.aEk(), 10, false);
            this.aqO.setText(lVar.getTitle());
        }
        this.hZc.setOnClickListener(this.dfY);
    }

    public void FM(String str) {
        this.iFf = str;
    }

    public void pH(boolean z) {
        this.iFg = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void pG(boolean z) {
        this.iFc = z;
    }
}
