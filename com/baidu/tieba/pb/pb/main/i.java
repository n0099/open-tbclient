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
/* loaded from: classes16.dex */
public class i extends ad.a {
    public TextView aTu;
    public TbImageView eeU;
    private View.OnClickListener ehM;
    private int from;
    public View ipr;
    public ImageView ixp;
    public View jAm;
    private boolean klh;
    private PbActivity kli;
    private com.baidu.tbadk.core.data.n klj;
    private String klk;
    private boolean kll;
    public View klm;
    public View kln;
    public View klo;
    public View klp;
    public TextView klq;
    public View klr;
    public View kls;
    public View klt;
    public TextView klu;
    public TextView klv;
    public TextView klw;
    private String mNid;
    public int mSkinType;

    public i(View view, PbActivity pbActivity) {
        super(view);
        this.mSkinType = 3;
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i = 2;
                int id = view2.getId();
                if (i.this.klj != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aWD = i.this.klj.aWD();
                        if (aWD != null) {
                            if (aWD.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.klj);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.kli, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.klj.aTN() != null && i.this.klj.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.klj.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aWD.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.klj);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.kli, str2, i.this.klj.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.klj.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.klj.threadType == 40) {
                                com.baidu.tbadk.core.util.ap.xP("c13535").dn("tid", tid).t("fid", i.this.klj.getFid()).ah("obj_source", i).ah("obj_locate", i.this.klj.getFloorNum()).dn("obj_id", i.this.klk).ah("obj_type", i.this.klj.aYf() ? 1 : 0).baO();
                            } else {
                                com.baidu.tbadk.core.util.ap.xP("c13534").dn("tid", tid).t("fid", i.this.klj.getFid()).ah("obj_source", i).ah("obj_locate", i.this.klj.getFloorNum()).dn("obj_id", i.this.klk).baO();
                            }
                        }
                        if (i.this.kll) {
                            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13589");
                            apVar.dn("tid", i.this.klj.getTid());
                            if (i.this.klj.aXZ() != null) {
                                apVar.dn("fid", i.this.klj.aXZ().getForumId());
                            }
                            apVar.dn("obj_param1", i.this.klj.mRecomWeight);
                            apVar.dn("obj_source", i.this.klj.mRecomSource);
                            apVar.dn("obj_id", i.this.klk);
                            apVar.ah("obj_locate", i.this.klj.getFloorNum());
                            apVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.klj.aTN().getBaijiahaoData() != null) {
                                apVar.dn("obj_param4", i.this.klj.aTN().getBaijiahaoData().oriUgcNid);
                                apVar.dn("obj_param6", i.this.klj.aTN().getBaijiahaoData().oriUgcVid);
                            }
                            apVar.ah("obj_param5", i.this.klj.aYl());
                            apVar.dn("ab_tag", i.this.klj.mRecomAbTag);
                            apVar.ah("is_vertical", i.this.klj.aWD().is_vertical.intValue());
                            apVar.dn("extra", i.this.klj.mRecomExtra);
                            TiebaStatic.log(apVar);
                        }
                        if (i.this.klh) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.kli).l(com.baidu.tieba.pb.videopb.e.class)).aP(i.this.klj);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.kli);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.klk);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.klj);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.kli = pbActivity;
        this.jAm = view.findViewById(R.id.main_view);
        this.ipr = view.findViewById(R.id.first_head_divider_line);
        this.klm = view.findViewById(R.id.bjh_main_content);
        this.kln = view.findViewById(R.id.bjh_click_container);
        this.eeU = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.klo = view.findViewById(R.id.bjh_gradient_cover);
        this.aTu = (TextView) view.findViewById(R.id.bjh_content);
        this.klp = view.findViewById(R.id.bjh_video_during_container);
        this.ixp = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.klq = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.klr = view.findViewById(R.id.last_video_tail);
        this.klu = (TextView) view.findViewById(R.id.tail_more_video);
        this.kls = view.findViewById(R.id.last_tail_divider_line);
        this.klt = view.findViewById(R.id.last_tail_padding);
        this.klv = (TextView) view.findViewById(R.id.bjh_user_info);
        this.klw = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.klj = nVar;
        this.ipr.setVisibility(nVar.aUk() ? 0 : 8);
        this.klt.setVisibility(nVar.aUl() ? 0 : 8);
        this.klm.setVisibility(nVar.aUm() ? 8 : 0);
        this.klr.setVisibility(nVar.aUm() ? 0 : 8);
        this.klu.setOnClickListener(this.ehM);
        this.klo.setOnClickListener(this.ehM);
        this.eeU.setOnClickListener(this.ehM);
        this.eeU.setConrers(15);
        this.eeU.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eeU.setDrawCorner(true);
        this.eeU.setPlaceHolder(2);
        if (nVar.aWD() != null) {
            this.aTu.setText(nVar.getTitle());
            this.eeU.startLoad(nVar.aWD().thumbnail_url, 10, false);
            this.klo.setVisibility(0);
            this.klo.setAlpha(0.5f);
            this.klp.setVisibility(0);
            this.klq.setText(StringUtils.translateSecondsToString(nVar.aWD().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.klw.getLayoutParams();
            if (nVar.aWl() != null && !com.baidu.tbadk.core.util.as.isEmpty(nVar.aWl().getName_show())) {
                this.klv.setText(nVar.aWl().getName_show());
                this.klv.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.klv.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.klw.setLayoutParams(layoutParams);
            this.klw.setText(String.format(this.kli.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.as.numFormatOverWan(nVar.aWD().play_count.intValue())));
        } else {
            this.klp.setVisibility(8);
            this.klo.setVisibility(8);
            this.eeU.startLoad(nVar.aYj(), 10, false);
            this.aTu.setText(nVar.getTitle());
        }
        this.jAm.setOnClickListener(this.ehM);
    }

    public void Kx(String str) {
        this.klk = str;
    }

    public void sh(boolean z) {
        this.kll = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void sg(boolean z) {
        this.klh = z;
    }
}
