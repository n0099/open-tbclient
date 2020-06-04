package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
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
public class i extends aa.a {
    public TextView aPv;
    public TbImageView dRP;
    private View.OnClickListener dUl;
    private int from;
    public View hUT;
    private boolean jIV;
    private PbActivity jIW;
    private com.baidu.tbadk.core.data.k jIX;
    private String jIY;
    private boolean jIZ;
    public View jJa;
    public View jJb;
    public View jJc;
    public View jJd;
    public ImageView jJe;
    public TextView jJf;
    public View jJg;
    public View jJh;
    public View jJi;
    public TextView jJj;
    public TextView jJk;
    public TextView jJl;
    public View jaz;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.dUl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.jIX != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aQQ = i.this.jIX.aQQ();
                        if (aQQ != null) {
                            if (aQQ.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.jIX);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.jIW, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.jIX.aOi() != null && i.this.jIX.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.jIX.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aQQ.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.jIX);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.jIW, str2, i.this.jIX.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.jIX.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.jIX.threadType == 40) {
                                com.baidu.tbadk.core.util.an.wr("c13535").dh("tid", tid).s("fid", i.this.jIX.getFid()).ag("obj_source", i).ag("obj_locate", i.this.jIX.getFloorNum()).dh("obj_id", i.this.jIY).ag("obj_type", i.this.jIX.aSu() ? 1 : 0).aUT();
                            } else {
                                com.baidu.tbadk.core.util.an.wr("c13534").dh("tid", tid).s("fid", i.this.jIX.getFid()).ag("obj_source", i).ag("obj_locate", i.this.jIX.getFloorNum()).dh("obj_id", i.this.jIY).aUT();
                            }
                        }
                        if (i.this.jIZ) {
                            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13589");
                            anVar.dh("tid", i.this.jIX.getTid());
                            if (i.this.jIX.aSm() != null) {
                                anVar.dh("fid", i.this.jIX.aSm().getForumId());
                            }
                            anVar.dh("obj_param1", i.this.jIX.mRecomWeight);
                            anVar.dh("obj_source", i.this.jIX.mRecomSource);
                            anVar.dh("obj_id", i.this.jIY);
                            anVar.ag("obj_locate", i.this.jIX.getFloorNum());
                            anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.jIX.aOi().getBaijiahaoData() != null) {
                                anVar.dh("obj_param4", i.this.jIX.aOi().getBaijiahaoData().oriUgcNid);
                                anVar.dh("obj_param6", i.this.jIX.aOi().getBaijiahaoData().oriUgcVid);
                            }
                            anVar.ag("obj_param5", i.this.jIX.aSB());
                            anVar.dh("ab_tag", i.this.jIX.mRecomAbTag);
                            anVar.ag("is_vertical", i.this.jIX.aQQ().is_vertical.intValue());
                            anVar.dh("extra", i.this.jIX.mRecomExtra);
                            TiebaStatic.log(anVar);
                        }
                        if (i.this.jIV) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.jIW).l(com.baidu.tieba.pb.videopb.e.class)).aR(i.this.jIX);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.jIW);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.jIY);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.jIX);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.jIW = pbActivity;
        this.jaz = view.findViewById(R.id.main_view);
        this.hUT = view.findViewById(R.id.first_head_divider_line);
        this.jJa = view.findViewById(R.id.bjh_main_content);
        this.jJb = view.findViewById(R.id.bjh_click_container);
        this.dRP = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.jJc = view.findViewById(R.id.bjh_gradient_cover);
        this.aPv = (TextView) view.findViewById(R.id.bjh_content);
        this.jJd = view.findViewById(R.id.bjh_video_during_container);
        this.jJe = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.jJf = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.jJg = view.findViewById(R.id.last_video_tail);
        this.jJj = (TextView) view.findViewById(R.id.tail_more_video);
        this.jJh = view.findViewById(R.id.last_tail_divider_line);
        this.jJi = view.findViewById(R.id.last_tail_padding);
        this.jJk = (TextView) view.findViewById(R.id.bjh_user_info);
        this.jJl = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.jIX = kVar;
        this.hUT.setVisibility(kVar.aOB() ? 0 : 8);
        this.jJi.setVisibility(kVar.aOC() ? 0 : 8);
        this.jJa.setVisibility(kVar.aOD() ? 8 : 0);
        this.jJg.setVisibility(kVar.aOD() ? 0 : 8);
        this.jJj.setOnClickListener(this.dUl);
        this.jJc.setOnClickListener(this.dUl);
        this.dRP.setOnClickListener(this.dUl);
        this.dRP.setConrers(15);
        this.dRP.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.dRP.setDrawCorner(true);
        this.dRP.setPlaceHolder(2);
        if (kVar.aQQ() != null) {
            this.aPv.setText(kVar.getTitle());
            this.dRP.startLoad(kVar.aQQ().thumbnail_url, 10, false);
            this.jJc.setVisibility(0);
            this.jJc.setAlpha(0.5f);
            this.jJd.setVisibility(0);
            this.jJf.setText(StringUtils.translateSecondsToString(kVar.aQQ().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jJl.getLayoutParams();
            if (kVar.aQx() != null && !com.baidu.tbadk.core.util.aq.isEmpty(kVar.aQx().getName_show())) {
                this.jJk.setText(kVar.aQx().getName_show());
                this.jJk.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jJk.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jJl.setLayoutParams(layoutParams);
            this.jJl.setText(String.format(this.jIW.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.aq.numFormatOverWan(kVar.aQQ().play_count.intValue())));
        } else {
            this.jJd.setVisibility(8);
            this.jJc.setVisibility(8);
            this.dRP.startLoad(kVar.aSz(), 10, false);
            this.aPv.setText(kVar.getTitle());
        }
        this.jaz.setOnClickListener(this.dUl);
    }

    public void Jj(String str) {
        this.jIY = str;
    }

    public void rp(boolean z) {
        this.jIZ = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void ro(boolean z) {
        this.jIV = z;
    }
}
