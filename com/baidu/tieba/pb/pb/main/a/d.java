package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class d {
    private LayerDrawable agg;
    private LayerDrawable agh;
    private com.baidu.tieba.pb.a.c dRh;
    private View.OnClickListener haA;
    private com.baidu.tieba.c.d jCM;
    private ImageView jCO;
    private com.baidu.tieba.pb.pb.main.e jCP;
    private ThreadSkinView jCR;
    private ImageView jCU;
    private HeadPendantView jCV;
    private TBLottieAnimationView jCW;
    private LinearLayout jCY;
    private LinearLayout jCZ;
    private al jDc;
    private PbFragment jpS;
    private UserIconBox jrO;
    private UserIconBox jrP;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout jCN = null;
    private ColumnLayout jCQ = null;
    private TextView jCS = null;
    private TextView jCT = null;
    private FrameLayout jCX = null;
    private ClickableHeaderImageView jDa = null;
    private PbFirstFloorUserLikeButton jDb = null;
    private TextView jDd = null;
    private TextView jDe = null;
    private TextView jDf = null;
    private TextView jDg = null;
    private int jDh = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.haA = null;
        this.jpS = pbFragment;
        this.dRh = cVar;
        this.haA = onClickListener;
        int dimens = l.getDimens(this.jpS.getContext(), R.dimen.tbds6);
        this.agg = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(dimens).va("#4D000000").aPA()});
        this.agh = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(dimens).va("#4D000000").aPA()});
        initView();
    }

    private void initView() {
        this.jCN = (RelativeLayout) LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.jCO = (ImageView) this.jCN.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.jCO.getLayoutParams().height = am.cAe();
        this.jCP = new com.baidu.tieba.pb.pb.main.e(this.jpS.getBaseFragmentActivity(), this.jCN);
        this.jCP.init();
        this.jCP.a(this.jCP.cwN(), this.haA);
        this.jCQ = (ColumnLayout) this.jCN.findViewById(R.id.pb_head_owner_root);
        this.jCR = (ThreadSkinView) this.jCN.findViewById(R.id.pb_thread_skin);
        this.jCS = (TextView) this.jCQ.findViewById(R.id.pb_head_owner_info_user_name);
        this.jCS.getPaint().setFakeBoldText(true);
        this.jCT = (TextView) this.jCQ.findViewById(R.id.floor_owner);
        this.jCU = (ImageView) this.jCQ.findViewById(R.id.icon_forum_level);
        this.jCX = (FrameLayout) this.jCQ.findViewById(R.id.pb_head_headImage_container);
        this.jCV = (HeadPendantView) this.jCQ.findViewById(R.id.pb_pendant_head_owner_photo);
        this.jCV.setHasPendantStyle();
        this.jCW = (TBLottieAnimationView) this.jCQ.findViewById(R.id.pb_head_living_lottie);
        this.jCQ.setOnLongClickListener(this.mOnLongClickListener);
        this.jCQ.setOnTouchListener(this.dRh);
        this.jCQ.setVisibility(8);
        if (this.jCV.getHeadView() != null) {
            this.jCV.getHeadView().setIsRound(true);
            this.jCV.getHeadView().setDrawBorder(false);
            this.jCV.getHeadView().setPlaceHolder(1);
        }
        this.jrO = (UserIconBox) this.jCQ.findViewById(R.id.show_icon_vip);
        this.jrP = (UserIconBox) this.jCQ.findViewById(R.id.show_icon_yinji);
        this.jCY = (LinearLayout) this.jCN.findViewById(R.id.pb_head_owner_info_root);
        this.jCZ = (LinearLayout) this.jCQ.findViewById(R.id.pb_first_floor_location_container);
        this.jDb = (PbFirstFloorUserLikeButton) this.jCQ.findViewById(R.id.pb_like_button);
        this.jDd = (TextView) this.jCQ.findViewById(R.id.pb_views);
        this.jDe = (TextView) this.jCQ.findViewById(R.id.pb_item_first_floor_reply_time);
        this.jDf = (TextView) this.jCQ.findViewById(R.id.pb_item_first_floor_location_address);
        this.jDg = (TextView) this.jCQ.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.e eVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aKE() != null) {
            MetaData aKE = postData.aKE();
            String string = aKE.getName_show() == null ? StringUtils.string(aKE.getUserName()) : StringUtils.string(aKE.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aKE().getSealPrefix())) {
                i2 = k.byteLength(aKE.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aKE.getIconInfo();
                    tShowInfoNew = aKE.getTShowInfoNew();
                    if (this.jrP != null) {
                        this.jrP.setTag(R.id.tag_user_id, aKE.getUserId());
                        if (this.jpS.cyk() != null) {
                            this.jrP.setOnClickListener(this.jpS.cyk().jqe.jEA);
                        }
                        this.jrP.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.jrO != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.jrO.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.jpS.cyk() != null) {
                            this.jrO.setOnClickListener(this.jpS.cyk().jqe.jEB);
                        }
                        this.jrO.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.jCS.setText(cL(aKE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jCS.setTag(R.id.tag_user_id, aKE.getUserId());
                    this.jCS.setTag(R.id.tag_user_name, aKE.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aKE.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cvS()) {
                        this.jCT.setVisibility(8);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKE.getBawu_type())) {
                        this.jCT.setText(R.string.bawu_member_bazhu_tip);
                        this.jCT.setVisibility(0);
                        if (i == 1) {
                            if (this.agg.getDrawable(1) != null) {
                                this.agg.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agg.getDrawable(1) != null) {
                            this.agg.getDrawable(1).setAlpha(0);
                        }
                        this.jCT.setBackgroundDrawable(this.agg);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCT, (int) R.color.cp_cont_a);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKE.getBawu_type())) {
                        this.jCT.setText(R.string.bawu_member_xbazhu_tip);
                        this.jCT.setVisibility(0);
                        if (i == 1) {
                            if (this.agh.getDrawable(1) != null) {
                                this.agh.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agh.getDrawable(1) != null) {
                            this.agh.getDrawable(1).setAlpha(0);
                        }
                        this.jCT.setBackgroundDrawable(this.agh);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCT, (int) R.color.cp_cont_a);
                    } else {
                        this.jCT.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.jDe.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.jDe.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cvS()) {
                        this.jDf.setVisibility(8);
                        if (this.jCZ.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jCZ.getLayoutParams()).rightMargin = 0;
                        }
                        this.jCQ.setSpacingRight(0);
                        String str = null;
                        if (aKE.getBaijiahaoInfo() != null) {
                            str = aKE.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.jDg.setVisibility(0);
                            this.jDg.setText(str);
                        } else {
                            this.jDg.setVisibility(8);
                        }
                    } else {
                        this.jDg.setVisibility(8);
                        if (this.jCZ.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jCZ.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.jCQ.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cWu = postData.cWu();
                        if (cWu != null && !TextUtils.isEmpty(cWu.getName()) && !TextUtils.isEmpty(cWu.getName().trim())) {
                            this.jDf.setVisibility(0);
                            this.jDf.setText(cWu.getName());
                        } else {
                            this.jDf.setVisibility(8);
                        }
                    }
                    if (eVar.cvu().aKE() != null || eVar.cvu().aKE().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.cvu().aKE().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cBK();
                        z = true;
                    }
                    if (z) {
                        this.jCV.a(aKE, 0);
                        this.jCV.setIsclearmode(false);
                    } else {
                        this.jCV.setIsclearmode(true);
                    }
                    this.jCV.setVisibility(0);
                    if (this.jDa != null) {
                        this.jDa.setVisibility(8);
                    }
                    this.jCS.setOnClickListener(onClickListener);
                    this.jCV.getHeadView().setUserId(aKE.getUserId());
                    this.jCV.getHeadView().setUserName(aKE.getUserName());
                    this.jCV.getHeadView().setTid(postData.getId());
                    this.jCV.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jCV.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.jCV.vh(aKE.getAvater());
                    } else {
                        this.jCV.a(aKE);
                    }
                    String name_show = aKE.getName_show();
                    String userName = aKE.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.jCS.setText(com.baidu.tieba.pb.c.aV(this.jpS.getPageContext().getPageActivity(), this.jCS.getText().toString()));
                        this.jCS.setGravity(16);
                        this.jCS.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvd());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aKE.getIconInfo();
                tShowInfoNew = aKE.getTShowInfoNew();
                if (this.jrP != null) {
                }
                if (this.jrO != null) {
                }
                this.jCS.setText(cL(aKE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jCS.setTag(R.id.tag_user_id, aKE.getUserId());
                this.jCS.setTag(R.id.tag_user_name, aKE.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_cont_h, 1);
                if (!eVar.cvS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cvS()) {
                }
                if (eVar.cvu().aKE() != null) {
                }
                z = false;
                if (z) {
                }
                this.jCV.setVisibility(0);
                if (this.jDa != null) {
                }
                this.jCS.setOnClickListener(onClickListener);
                this.jCV.getHeadView().setUserId(aKE.getUserId());
                this.jCV.getHeadView().setUserName(aKE.getUserName());
                this.jCV.getHeadView().setTid(postData.getId());
                this.jCV.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jCV.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aKE.getName_show();
                String userName2 = aKE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.jCS.setText(com.baidu.tieba.pb.c.aV(this.jpS.getPageContext().getPageActivity(), this.jCS.getText().toString()));
                    this.jCS.setGravity(16);
                    this.jCS.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvd());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aKE.getIconInfo();
                    tShowInfoNew = aKE.getTShowInfoNew();
                    if (this.jrP != null) {
                    }
                    if (this.jrO != null) {
                    }
                    this.jCS.setText(cL(aKE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jCS.setTag(R.id.tag_user_id, aKE.getUserId());
                    this.jCS.setTag(R.id.tag_user_name, aKE.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_cont_h, 1);
                    if (!eVar.cvS()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!eVar.cvS()) {
                    }
                    if (eVar.cvu().aKE() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.jCV.setVisibility(0);
                    if (this.jDa != null) {
                    }
                    this.jCS.setOnClickListener(onClickListener);
                    this.jCV.getHeadView().setUserId(aKE.getUserId());
                    this.jCV.getHeadView().setUserName(aKE.getUserName());
                    this.jCV.getHeadView().setTid(postData.getId());
                    this.jCV.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jCV.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aKE.getName_show();
                    String userName22 = aKE.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aKE.getIconInfo();
                tShowInfoNew = aKE.getTShowInfoNew();
                if (this.jrP != null) {
                }
                if (this.jrO != null) {
                }
                this.jCS.setText(cL(aKE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jCS.setTag(R.id.tag_user_id, aKE.getUserId());
                this.jCS.setTag(R.id.tag_user_name, aKE.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jCS, R.color.cp_cont_h, 1);
                if (!eVar.cvS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cvS()) {
                }
                if (eVar.cvu().aKE() != null) {
                }
                z = false;
                if (z) {
                }
                this.jCV.setVisibility(0);
                if (this.jDa != null) {
                }
                this.jCS.setOnClickListener(onClickListener);
                this.jCV.getHeadView().setUserId(aKE.getUserId());
                this.jCV.getHeadView().setUserName(aKE.getUserName());
                this.jCV.getHeadView().setTid(postData.getId());
                this.jCV.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jCV.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aKE.getName_show();
                String userName222 = aKE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.jCP.aH(eVar.cvu());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.cvV()) {
                this.jDb.setVisibility(0);
            }
            if (z) {
                this.jDb.setVisibility(8);
                if (eVar != null && eVar.cvu() != null && eVar.cvu().getBaijiahaoData() != null && eVar.cvu().getBaijiahaoData().oriUgcType == 3) {
                    this.jDd.setVisibility(8);
                } else {
                    this.jDd.setVisibility(0);
                }
                this.jDd.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.cvO())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aKE().hadConcerned()) {
                this.jDb.setVisibility(8);
                this.jDd.setVisibility(8);
            } else {
                this.jDd.setVisibility(8);
            }
            if (eVar.jny || 3 == eVar.cvV()) {
                this.jDb.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aKE() != null) {
                postData.aKE().setIsLike(postData.aKE().hadConcerned());
            }
            if (this.jDc == null) {
                bj cvu = eVar.cvu();
                int i = 1;
                if (cvu != null) {
                    if (cvu.aJt()) {
                        i = 4;
                    } else if (cvu.aJu()) {
                        i = 6;
                    } else if (cvu.aMz()) {
                        i = 7;
                    } else if (cvu.aMy()) {
                        i = 5;
                    }
                }
                this.jDc = new al(this.jpS.getPageContext(), this.jDb, i);
                this.jDc.j(this.jpS.getUniqueId());
            }
            if (postData != null && postData.aKE() != null) {
                postData.aKE().setIsLike(postData.aKE().hadConcerned());
                this.jDc.a(postData.aKE());
                this.jDc.setTid(threadId);
            }
            this.jDc.jzA = z2;
            this.jDc.zL(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvu() == null) {
            return 0;
        }
        if (eVar.cvu().aLY()) {
            return (v.isEmpty(eVar.cvN()) && (eVar.cvt() == null || StringUtils.isNull(eVar.cvt().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aKZ() != null) {
                this.jCR.setData(this.jpS.getPageContext(), eVar.cvw().get(0).aKZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cvu().getId(), this.jpS.aMu() ? "FRS" : null));
                this.jCQ.setPadding(this.jCQ.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.jCQ.getPaddingRight(), this.jCQ.getPaddingBottom());
                return;
            }
            this.jCR.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.jpS.cwt()) {
            this.jDh = 0;
            if (postData != null && postData.aKE() != null) {
                this.jDh = postData.aKE().getLevel_id();
            }
            if (this.jDh > 0 && !z) {
                this.jCU.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.jCU, BitmapHelper.getGradeResourceIdInEnterForum(this.jDh));
                return;
            }
            this.jCU.setVisibility(8);
            return;
        }
        this.jCU.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aQh()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.jCQ.getPaddingBottom();
            if (eVar.cvS()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.jCQ.setPadding(this.jCQ.getPaddingLeft(), dimens, this.jCQ.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.jCQ.getPaddingBottom();
        if (eVar != null && !eVar.cvu().aJr() && eVar.cvS() && (!StringUtils.isNull(eVar.cvu().getTitle()) || eVar.cvu().aLl() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.jCQ.setPadding(this.jCQ.getPaddingLeft(), dimens2, this.jCQ.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.jCQ.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jCN);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jCN, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jCN);
        }
    }

    public void setVisibility(int i) {
        this.jCQ.setVisibility(i);
    }

    private void cBK() {
        if (this.jCW != null) {
            this.jCW.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jCW.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.jpS.cyk(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.jpS.cyk(), R.dimen.ds8);
            this.jCW.setLayoutParams(layoutParams);
            this.jCW.loop(true);
            this.jCW.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jCW.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jnz) {
            this.jCO.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jCO.setVisibility(0);
        } else if (z && z2) {
            this.jCO.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jCO.setVisibility(0);
        } else if (z) {
            this.jCO.setImageResource(R.drawable.pic_pb_refined_n);
            this.jCO.setVisibility(0);
        } else if (z2) {
            this.jCO.setImageResource(R.drawable.pic_pb_stick_n);
            this.jCO.setVisibility(0);
        } else {
            this.jCO.setVisibility(8);
        }
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.jpS.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cBL() {
        SparseArray<Object> sparseArray = (SparseArray) this.jCQ.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.jCQ.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cwN() {
        return this.jCP.cwN();
    }

    public void qL(boolean z) {
        this.jCP.qL(z);
    }

    public void onChangeSkinType(int i) {
        if (this.jCU != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.jCU, BitmapHelper.getGradeResourceIdInEnterForum(this.jDh));
        }
        if (this.jDb != null) {
            this.jDb.onChangeSkinType(i);
        }
        if (this.jDf != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDf, (int) R.color.cp_cont_d);
        }
        if (this.jDe != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDe, (int) R.color.cp_cont_d);
        }
        if (this.jDd != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDd, (int) R.color.cp_cont_d);
        }
        if (this.jDg != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDg, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.jCW != null) {
                this.jCW.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.jCW != null) {
                this.jCW.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.jCW != null) {
            this.jCW.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.jCM != null) {
            this.jCM.EE();
        }
        if (this.jCQ != null && this.jDa != null) {
            this.jCQ.removeView(this.jCX);
            this.jDa = null;
        }
        if (this.jCW != null) {
            this.jCW.cancelAnimation();
        }
    }

    public void cBa() {
        if (this.jCM != null) {
            this.jCM.EE();
        }
    }
}
