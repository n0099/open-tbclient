package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public View bVM;
    public TextView blJ;
    private String eVY;
    public View fJE;
    public TbImageView fhd;
    private View.OnClickListener fko;
    private int from;
    public View jTJ;
    public ImageView kdV;
    private boolean lKg;
    private PbActivity lKh;
    private com.baidu.tbadk.core.data.o lKi;
    private String lKj;
    private boolean lKk;
    public View lKl;
    public View lKm;
    public View lKn;
    public View lKo;
    public TextView lKp;
    public View lKq;
    public View lKr;
    public View lKs;
    public TextView lKt;
    public TextView lKu;
    public TextView lKv;
    public int mSkinType;

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.fko = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (PbBjhRecommendViewHolder.this.lKi != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo brH = PbBjhRecommendViewHolder.this.lKi.brH();
                        if (brH != null) {
                            if (brH.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.lKi);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(videoItemData);
                                String str = "";
                                if (PbBjhRecommendViewHolder.this.from != 2) {
                                    if (PbBjhRecommendViewHolder.this.from != 1) {
                                        if (PbBjhRecommendViewHolder.this.from == 3) {
                                            str = "frs";
                                        }
                                    } else {
                                        str = "concern_tab";
                                    }
                                } else {
                                    str = "index";
                                }
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.lKh, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (PbBjhRecommendViewHolder.this.lKi.boO() != null && PbBjhRecommendViewHolder.this.lKi.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.lKi.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (brH.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.lKi);
                                String str2 = "";
                                if (PbBjhRecommendViewHolder.this.from != 2) {
                                    if (PbBjhRecommendViewHolder.this.from != 1) {
                                        if (PbBjhRecommendViewHolder.this.from == 3) {
                                            str2 = "frs";
                                        }
                                    } else {
                                        str2 = "concern_tab";
                                    }
                                } else {
                                    str2 = "index";
                                }
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.lKh, str2, PbBjhRecommendViewHolder.this.lKi.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.eVY);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = PbBjhRecommendViewHolder.this.lKi.getTid();
                        if (PbBjhRecommendViewHolder.this.from == 2) {
                            i = 1;
                        } else if (PbBjhRecommendViewHolder.this.from != 1) {
                            i = PbBjhRecommendViewHolder.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (PbBjhRecommendViewHolder.this.lKi.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.BY("c13535").dX("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lKi.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lKi.getFloorNum()).dX("obj_id", PbBjhRecommendViewHolder.this.lKj).an("obj_type", PbBjhRecommendViewHolder.this.lKi.btn() ? 1 : 0).bwn();
                            } else {
                                com.baidu.tbadk.core.util.aq.BY("c13534").dX("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lKi.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lKi.getFloorNum()).dX("obj_id", PbBjhRecommendViewHolder.this.lKj).bwn();
                            }
                        }
                        if (PbBjhRecommendViewHolder.this.lKk) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dX("tid", PbBjhRecommendViewHolder.this.lKi.getTid());
                            if (PbBjhRecommendViewHolder.this.lKi.bth() != null) {
                                aqVar.dX("fid", PbBjhRecommendViewHolder.this.lKi.bth().getForumId());
                            }
                            aqVar.dX("obj_param1", PbBjhRecommendViewHolder.this.lKi.mRecomWeight);
                            aqVar.dX("obj_source", PbBjhRecommendViewHolder.this.lKi.mRecomSource);
                            aqVar.dX("obj_id", PbBjhRecommendViewHolder.this.lKj);
                            aqVar.an("obj_locate", PbBjhRecommendViewHolder.this.lKi.getFloorNum());
                            aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            if (PbBjhRecommendViewHolder.this.lKi.boO().getBaijiahaoData() != null) {
                                aqVar.dX("obj_param4", PbBjhRecommendViewHolder.this.lKi.boO().getBaijiahaoData().oriUgcNid);
                                aqVar.dX("obj_param6", PbBjhRecommendViewHolder.this.lKi.boO().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.an("obj_param5", PbBjhRecommendViewHolder.this.lKi.btt());
                            aqVar.dX("ab_tag", PbBjhRecommendViewHolder.this.lKi.mRecomAbTag);
                            aqVar.an("is_vertical", PbBjhRecommendViewHolder.this.lKi.brH().is_vertical.intValue());
                            aqVar.dX("extra", PbBjhRecommendViewHolder.this.lKi.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (PbBjhRecommendViewHolder.this.lKg) {
                            ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.lKh).get(VideoPbViewModel.class)).aU(PbBjhRecommendViewHolder.this.lKi);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.lKh);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.from);
                        pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.lKj);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.lKi);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lKh = pbActivity;
        this.bVM = view.findViewById(R.id.main_view);
        this.jTJ = view.findViewById(R.id.first_head_divider_line);
        this.lKl = view.findViewById(R.id.bjh_main_content);
        this.lKm = view.findViewById(R.id.bjh_click_container);
        this.fhd = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lKn = view.findViewById(R.id.bjh_gradient_cover);
        this.blJ = (TextView) view.findViewById(R.id.bjh_content);
        this.lKo = view.findViewById(R.id.bjh_video_during_container);
        this.kdV = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lKp = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lKq = view.findViewById(R.id.last_video_tail);
        this.lKt = (TextView) view.findViewById(R.id.tail_more_video);
        this.lKr = view.findViewById(R.id.last_tail_divider_line);
        this.lKs = view.findViewById(R.id.last_tail_padding);
        this.lKu = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lKv = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fJE = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lKi = oVar;
        this.jTJ.setVisibility(oVar.bpn() ? 0 : 8);
        this.lKs.setVisibility(oVar.bpo() ? 0 : 8);
        this.lKl.setVisibility(oVar.bpp() ? 8 : 0);
        this.lKq.setVisibility(oVar.bpp() ? 0 : 8);
        this.lKt.setOnClickListener(this.fko);
        this.lKn.setOnClickListener(this.fko);
        this.fhd.setOnClickListener(this.fko);
        this.fhd.setConrers(15);
        this.fhd.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.fhd.setDrawCorner(true);
        this.fhd.setPlaceHolder(2);
        if (oVar.brH() != null) {
            this.blJ.setText(oVar.getTitle());
            this.fhd.startLoad(oVar.brH().thumbnail_url, 10, false);
            this.lKn.setVisibility(0);
            this.lKn.setAlpha(0.5f);
            this.lKo.setVisibility(0);
            this.lKp.setText(StringUtils.translateSecondsToString(oVar.brH().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKv.getLayoutParams();
            if (oVar.brq() != null && !com.baidu.tbadk.core.util.at.isEmpty(oVar.brq().getName_show())) {
                this.lKu.setText(oVar.brq().getName_show());
                this.lKu.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lKu.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lKv.setLayoutParams(layoutParams);
            this.lKv.setText(String.format(this.lKh.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(oVar.brH().play_count.intValue())));
        } else {
            this.lKo.setVisibility(8);
            this.lKn.setVisibility(8);
            this.fhd.startLoad(oVar.btr(), 10, false);
            this.blJ.setText(oVar.getTitle());
        }
        this.bVM.setOnClickListener(this.fko);
    }

    public void PG(String str) {
        this.lKj = str;
    }

    public void uK(boolean z) {
        this.lKk = z;
    }

    public void setNid(String str) {
        this.eVY = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uJ(boolean z) {
        this.lKg = z;
    }
}
