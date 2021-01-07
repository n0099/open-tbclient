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
    private boolean lKf;
    private PbActivity lKg;
    private com.baidu.tbadk.core.data.o lKh;
    private String lKi;
    private boolean lKj;
    public View lKk;
    public View lKl;
    public View lKm;
    public View lKn;
    public TextView lKo;
    public View lKp;
    public View lKq;
    public View lKr;
    public TextView lKs;
    public TextView lKt;
    public TextView lKu;
    public int mSkinType;

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.fko = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (PbBjhRecommendViewHolder.this.lKh != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo brI = PbBjhRecommendViewHolder.this.lKh.brI();
                        if (brI != null) {
                            if (brI.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.lKh);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.lKg, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (PbBjhRecommendViewHolder.this.lKh.boP() != null && PbBjhRecommendViewHolder.this.lKh.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.lKh.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (brI.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.lKh);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.lKg, str2, PbBjhRecommendViewHolder.this.lKh.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.eVY);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = PbBjhRecommendViewHolder.this.lKh.getTid();
                        if (PbBjhRecommendViewHolder.this.from == 2) {
                            i = 1;
                        } else if (PbBjhRecommendViewHolder.this.from != 1) {
                            i = PbBjhRecommendViewHolder.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (PbBjhRecommendViewHolder.this.lKh.threadType == 40) {
                                com.baidu.tbadk.core.util.aq.BX("c13535").dX("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lKh.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lKh.getFloorNum()).dX("obj_id", PbBjhRecommendViewHolder.this.lKi).an("obj_type", PbBjhRecommendViewHolder.this.lKh.bto() ? 1 : 0).bwo();
                            } else {
                                com.baidu.tbadk.core.util.aq.BX("c13534").dX("tid", tid).w("fid", PbBjhRecommendViewHolder.this.lKh.getFid()).an("obj_source", i).an("obj_locate", PbBjhRecommendViewHolder.this.lKh.getFloorNum()).dX("obj_id", PbBjhRecommendViewHolder.this.lKi).bwo();
                            }
                        }
                        if (PbBjhRecommendViewHolder.this.lKj) {
                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13589");
                            aqVar.dX("tid", PbBjhRecommendViewHolder.this.lKh.getTid());
                            if (PbBjhRecommendViewHolder.this.lKh.bti() != null) {
                                aqVar.dX("fid", PbBjhRecommendViewHolder.this.lKh.bti().getForumId());
                            }
                            aqVar.dX("obj_param1", PbBjhRecommendViewHolder.this.lKh.mRecomWeight);
                            aqVar.dX("obj_source", PbBjhRecommendViewHolder.this.lKh.mRecomSource);
                            aqVar.dX("obj_id", PbBjhRecommendViewHolder.this.lKi);
                            aqVar.an("obj_locate", PbBjhRecommendViewHolder.this.lKh.getFloorNum());
                            aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            if (PbBjhRecommendViewHolder.this.lKh.boP().getBaijiahaoData() != null) {
                                aqVar.dX("obj_param4", PbBjhRecommendViewHolder.this.lKh.boP().getBaijiahaoData().oriUgcNid);
                                aqVar.dX("obj_param6", PbBjhRecommendViewHolder.this.lKh.boP().getBaijiahaoData().oriUgcVid);
                            }
                            aqVar.an("obj_param5", PbBjhRecommendViewHolder.this.lKh.btu());
                            aqVar.dX("ab_tag", PbBjhRecommendViewHolder.this.lKh.mRecomAbTag);
                            aqVar.an("is_vertical", PbBjhRecommendViewHolder.this.lKh.brI().is_vertical.intValue());
                            aqVar.dX("extra", PbBjhRecommendViewHolder.this.lKh.mRecomExtra);
                            TiebaStatic.log(aqVar);
                        }
                        if (PbBjhRecommendViewHolder.this.lKf) {
                            ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.lKg).get(VideoPbViewModel.class)).aU(PbBjhRecommendViewHolder.this.lKh);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.lKg);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.from);
                        pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.lKi);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.lKh);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.lKg = pbActivity;
        this.bVM = view.findViewById(R.id.main_view);
        this.jTJ = view.findViewById(R.id.first_head_divider_line);
        this.lKk = view.findViewById(R.id.bjh_main_content);
        this.lKl = view.findViewById(R.id.bjh_click_container);
        this.fhd = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.lKm = view.findViewById(R.id.bjh_gradient_cover);
        this.blJ = (TextView) view.findViewById(R.id.bjh_content);
        this.lKn = view.findViewById(R.id.bjh_video_during_container);
        this.kdV = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.lKo = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.lKp = view.findViewById(R.id.last_video_tail);
        this.lKs = (TextView) view.findViewById(R.id.tail_more_video);
        this.lKq = view.findViewById(R.id.last_tail_divider_line);
        this.lKr = view.findViewById(R.id.last_tail_padding);
        this.lKt = (TextView) view.findViewById(R.id.bjh_user_info);
        this.lKu = (TextView) view.findViewById(R.id.bjh_video_info);
        this.fJE = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.lKh = oVar;
        this.jTJ.setVisibility(oVar.bpo() ? 0 : 8);
        this.lKr.setVisibility(oVar.bpp() ? 0 : 8);
        this.lKk.setVisibility(oVar.bpq() ? 8 : 0);
        this.lKp.setVisibility(oVar.bpq() ? 0 : 8);
        this.lKs.setOnClickListener(this.fko);
        this.lKm.setOnClickListener(this.fko);
        this.fhd.setOnClickListener(this.fko);
        this.fhd.setConrers(15);
        this.fhd.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.fhd.setDrawCorner(true);
        this.fhd.setPlaceHolder(2);
        if (oVar.brI() != null) {
            this.blJ.setText(oVar.getTitle());
            this.fhd.startLoad(oVar.brI().thumbnail_url, 10, false);
            this.lKm.setVisibility(0);
            this.lKm.setAlpha(0.5f);
            this.lKn.setVisibility(0);
            this.lKo.setText(StringUtils.translateSecondsToString(oVar.brI().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKu.getLayoutParams();
            if (oVar.brr() != null && !com.baidu.tbadk.core.util.at.isEmpty(oVar.brr().getName_show())) {
                this.lKt.setText(oVar.brr().getName_show());
                this.lKt.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lKt.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lKu.setLayoutParams(layoutParams);
            this.lKu.setText(String.format(this.lKg.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.at.numFormatOverWan(oVar.brI().play_count.intValue())));
        } else {
            this.lKn.setVisibility(8);
            this.lKm.setVisibility(8);
            this.fhd.startLoad(oVar.bts(), 10, false);
            this.blJ.setText(oVar.getTitle());
        }
        this.bVM.setOnClickListener(this.fko);
    }

    public void PF(String str) {
        this.lKi = str;
    }

    public void uK(boolean z) {
        this.lKj = z;
    }

    public void setNid(String str) {
        this.eVY = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void uJ(boolean z) {
        this.lKf = z;
    }
}
