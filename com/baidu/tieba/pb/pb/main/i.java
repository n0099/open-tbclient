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
    public View ipt;
    public ImageView ixr;
    public View jAo;
    private boolean klj;
    private PbActivity klk;
    private com.baidu.tbadk.core.data.n kll;
    private String klm;
    private boolean kln;
    public View klo;
    public View klp;
    public View klq;
    public View klr;
    public TextView kls;
    public View klt;
    public View klu;
    public View klv;
    public TextView klw;
    public TextView klx;
    public TextView kly;
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
                if (i.this.kll != null) {
                    if (id == R.id.tail_more_video) {
                        VideoInfo aWD = i.this.kll.aWD();
                        if (aWD != null) {
                            if (aWD.is_vertical.intValue() == 1) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(i.this.kll);
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
                                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(i.this.klk, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str);
                                videoPlayActivityConfig.setIsFromBjhPb(true);
                                if (i.this.kll.aTN() != null && i.this.kll.getBaijiahaoData() != null) {
                                    videoPlayActivityConfig.setNid(i.this.kll.getBaijiahaoData().oriUgcNid);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
                            } else if (aWD.is_vertical.intValue() == 0) {
                                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                                videoSerializeVideoThreadInfo.copyFromThreadInfo(i.this.kll);
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
                                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(i.this.klk, str2, i.this.kll.getTid(), "", "", videoSerializeVideoThreadInfo);
                                videoMiddlePageActivityConfig.setNid(i.this.mNid);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
                            }
                        }
                    } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                        String tid = i.this.kll.getTid();
                        if (i.this.from == 2) {
                            i = 1;
                        } else if (i.this.from != 1) {
                            i = i.this.from == 3 ? 3 : 4;
                        }
                        if (i != 0) {
                            if (i.this.kll.threadType == 40) {
                                com.baidu.tbadk.core.util.ap.xP("c13535").dn("tid", tid).t("fid", i.this.kll.getFid()).ah("obj_source", i).ah("obj_locate", i.this.kll.getFloorNum()).dn("obj_id", i.this.klm).ah("obj_type", i.this.kll.aYf() ? 1 : 0).baO();
                            } else {
                                com.baidu.tbadk.core.util.ap.xP("c13534").dn("tid", tid).t("fid", i.this.kll.getFid()).ah("obj_source", i).ah("obj_locate", i.this.kll.getFloorNum()).dn("obj_id", i.this.klm).baO();
                            }
                        }
                        if (i.this.kln) {
                            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13589");
                            apVar.dn("tid", i.this.kll.getTid());
                            if (i.this.kll.aXZ() != null) {
                                apVar.dn("fid", i.this.kll.aXZ().getForumId());
                            }
                            apVar.dn("obj_param1", i.this.kll.mRecomWeight);
                            apVar.dn("obj_source", i.this.kll.mRecomSource);
                            apVar.dn("obj_id", i.this.klm);
                            apVar.ah("obj_locate", i.this.kll.getFloorNum());
                            apVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                            if (i.this.kll.aTN().getBaijiahaoData() != null) {
                                apVar.dn("obj_param4", i.this.kll.aTN().getBaijiahaoData().oriUgcNid);
                                apVar.dn("obj_param6", i.this.kll.aTN().getBaijiahaoData().oriUgcVid);
                            }
                            apVar.ah("obj_param5", i.this.kll.aYl());
                            apVar.dn("ab_tag", i.this.kll.mRecomAbTag);
                            apVar.ah("is_vertical", i.this.kll.aWD().is_vertical.intValue());
                            apVar.dn("extra", i.this.kll.mRecomExtra);
                            TiebaStatic.log(apVar);
                        }
                        if (i.this.klj) {
                            ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(i.this.klk).l(com.baidu.tieba.pb.videopb.e.class)).aP(i.this.kll);
                            return;
                        }
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(i.this.klk);
                        pbActivityConfig.createNormalCfg(tid, null, "pb");
                        pbActivityConfig.setBjhFrom(i.this.from);
                        pbActivityConfig.setLastTid(i.this.klm);
                        pbActivityConfig.setStartFrom(20);
                        pbActivityConfig.setThreadData(i.this.kll);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    }
                }
            }
        };
        this.klk = pbActivity;
        this.jAo = view.findViewById(R.id.main_view);
        this.ipt = view.findViewById(R.id.first_head_divider_line);
        this.klo = view.findViewById(R.id.bjh_main_content);
        this.klp = view.findViewById(R.id.bjh_click_container);
        this.eeU = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.klq = view.findViewById(R.id.bjh_gradient_cover);
        this.aTu = (TextView) view.findViewById(R.id.bjh_content);
        this.klr = view.findViewById(R.id.bjh_video_during_container);
        this.ixr = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.kls = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.klt = view.findViewById(R.id.last_video_tail);
        this.klw = (TextView) view.findViewById(R.id.tail_more_video);
        this.klu = view.findViewById(R.id.last_tail_divider_line);
        this.klv = view.findViewById(R.id.last_tail_padding);
        this.klx = (TextView) view.findViewById(R.id.bjh_user_info);
        this.kly = (TextView) view.findViewById(R.id.bjh_video_info);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.kll = nVar;
        this.ipt.setVisibility(nVar.aUk() ? 0 : 8);
        this.klv.setVisibility(nVar.aUl() ? 0 : 8);
        this.klo.setVisibility(nVar.aUm() ? 8 : 0);
        this.klt.setVisibility(nVar.aUm() ? 0 : 8);
        this.klw.setOnClickListener(this.ehM);
        this.klq.setOnClickListener(this.ehM);
        this.eeU.setOnClickListener(this.ehM);
        this.eeU.setConrers(15);
        this.eeU.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.eeU.setDrawCorner(true);
        this.eeU.setPlaceHolder(2);
        if (nVar.aWD() != null) {
            this.aTu.setText(nVar.getTitle());
            this.eeU.startLoad(nVar.aWD().thumbnail_url, 10, false);
            this.klq.setVisibility(0);
            this.klq.setAlpha(0.5f);
            this.klr.setVisibility(0);
            this.kls.setText(StringUtils.translateSecondsToString(nVar.aWD().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kly.getLayoutParams();
            if (nVar.aWl() != null && !com.baidu.tbadk.core.util.as.isEmpty(nVar.aWl().getName_show())) {
                this.klx.setText(nVar.aWl().getName_show());
                this.klx.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.klx.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kly.setLayoutParams(layoutParams);
            this.kly.setText(String.format(this.klk.getResources().getString(R.string.bjh_pb_recommend_video_tip), com.baidu.tbadk.core.util.as.numFormatOverWan(nVar.aWD().play_count.intValue())));
        } else {
            this.klr.setVisibility(8);
            this.klq.setVisibility(8);
            this.eeU.startLoad(nVar.aYj(), 10, false);
            this.aTu.setText(nVar.getTitle());
        }
        this.jAo.setOnClickListener(this.ehM);
    }

    public void Kx(String str) {
        this.klm = str;
    }

    public void sh(boolean z) {
        this.kln = z;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setBjhFrom(int i) {
        this.from = i;
    }

    public void sg(boolean z) {
        this.klj = z;
    }
}
