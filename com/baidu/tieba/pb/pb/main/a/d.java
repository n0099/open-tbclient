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
import com.baidu.android.util.time.DateTimeUtil;
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
import com.baidu.tbadk.core.view.userLike.c;
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
    private LayerDrawable Nv;
    private LayerDrawable Nw;
    private com.baidu.tieba.pb.a.c drk;
    private View.OnClickListener grn;
    private PbFragment iFL;
    private UserIconBox iHH;
    private UserIconBox iHI;
    private com.baidu.tieba.c.d iSD;
    private ImageView iSF;
    private com.baidu.tieba.pb.pb.main.e iSG;
    private ThreadSkinView iSI;
    private ImageView iSL;
    private HeadPendantView iSM;
    private TBLottieAnimationView iSN;
    private LinearLayout iSP;
    private LinearLayout iSQ;
    private al iST;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iSE = null;
    private ColumnLayout iSH = null;
    private TextView iSJ = null;
    private TextView iSK = null;
    private FrameLayout iSO = null;
    private ClickableHeaderImageView iSR = null;
    private PbFirstFloorUserLikeButton iSS = null;
    private TextView iSU = null;
    private TextView iSV = null;
    private TextView iSW = null;
    private TextView iSX = null;
    private int iSY = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.grn = null;
        this.iFL = pbFragment;
        this.drk = cVar;
        this.grn = onClickListener;
        int dimens = l.getDimens(this.iFL.getContext(), R.dimen.tbds6);
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(dimens).tN("#4D000000").aHi()});
        this.Nw = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(dimens).tN("#4D000000").aHi()});
        initView();
    }

    private void initView() {
        this.iSE = (RelativeLayout) LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iSF = (ImageView) this.iSE.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iSF.getLayoutParams().height = am.cpy();
        this.iSG = new com.baidu.tieba.pb.pb.main.e(this.iFL.getBaseFragmentActivity(), this.iSE);
        this.iSG.init();
        this.iSG.setOnClickListener(this.iSG.cmh(), this.grn);
        this.iSH = (ColumnLayout) this.iSE.findViewById(R.id.pb_head_owner_root);
        this.iSI = (ThreadSkinView) this.iSE.findViewById(R.id.pb_thread_skin);
        this.iSJ = (TextView) this.iSH.findViewById(R.id.pb_head_owner_info_user_name);
        this.iSJ.getPaint().setFakeBoldText(true);
        this.iSK = (TextView) this.iSH.findViewById(R.id.floor_owner);
        this.iSL = (ImageView) this.iSH.findViewById(R.id.icon_forum_level);
        this.iSO = (FrameLayout) this.iSH.findViewById(R.id.pb_head_headImage_container);
        this.iSM = (HeadPendantView) this.iSH.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iSM.setHasPendantStyle();
        this.iSN = (TBLottieAnimationView) this.iSH.findViewById(R.id.pb_head_living_lottie);
        this.iSH.setOnLongClickListener(this.mOnLongClickListener);
        this.iSH.setOnTouchListener(this.drk);
        this.iSH.setVisibility(8);
        if (this.iSM.getHeadView() != null) {
            this.iSM.getHeadView().setIsRound(true);
            this.iSM.getHeadView().setDrawBorder(false);
            this.iSM.getHeadView().setPlaceHolder(1);
        }
        this.iHH = (UserIconBox) this.iSH.findViewById(R.id.show_icon_vip);
        this.iHI = (UserIconBox) this.iSH.findViewById(R.id.show_icon_yinji);
        this.iSP = (LinearLayout) this.iSE.findViewById(R.id.pb_head_owner_info_root);
        this.iSQ = (LinearLayout) this.iSH.findViewById(R.id.pb_first_floor_location_container);
        this.iSS = (PbFirstFloorUserLikeButton) this.iSH.findViewById(R.id.pb_like_button);
        this.iSU = (TextView) this.iSH.findViewById(R.id.pb_views);
        this.iSV = (TextView) this.iSH.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iSW = (TextView) this.iSH.findViewById(R.id.pb_item_first_floor_location_address);
        this.iSX = (TextView) this.iSH.findViewById(R.id.pb_item_first_floor_bjh_desc);
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
        if (postData != null && postData.aCr() != null) {
            MetaData aCr = postData.aCr();
            String string = aCr.getName_show() == null ? StringUtils.string(aCr.getUserName()) : StringUtils.string(aCr.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aCr().getSealPrefix())) {
                i2 = k.byteLength(aCr.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aCr.getIconInfo();
                    tShowInfoNew = aCr.getTShowInfoNew();
                    if (this.iHI != null) {
                        this.iHI.setTag(R.id.tag_user_id, aCr.getUserId());
                        if (this.iFL.cnE() != null) {
                            this.iHI.setOnClickListener(this.iFL.cnE().iFX.iUr);
                        }
                        this.iHI.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iHH != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iHH.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iFL.cnE() != null) {
                            this.iHH.setOnClickListener(this.iFL.cnE().iFX.iUs);
                        }
                        this.iHH.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iSJ.setText(cA(aCr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iSJ.setTag(R.id.tag_user_id, aCr.getUserId());
                    this.iSJ.setTag(R.id.tag_user_name, aCr.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aCr.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cln()) {
                        this.iSK.setVisibility(8);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCr.getBawu_type())) {
                        this.iSK.setText(R.string.bawu_member_bazhu_tip);
                        this.iSK.setVisibility(0);
                        if (i == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        this.iSK.setBackgroundDrawable(this.Nv);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iSK, (int) R.color.cp_cont_a);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCr.getBawu_type())) {
                        this.iSK.setText(R.string.bawu_member_xbazhu_tip);
                        this.iSK.setVisibility(0);
                        if (i == 1) {
                            if (this.Nw.getDrawable(1) != null) {
                                this.Nw.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nw.getDrawable(1) != null) {
                            this.Nw.getDrawable(1).setAlpha(0);
                        }
                        this.iSK.setBackgroundDrawable(this.Nw);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iSK, (int) R.color.cp_cont_a);
                    } else {
                        this.iSK.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iSV.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iSV.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cln()) {
                        this.iSW.setVisibility(8);
                        if (this.iSQ.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iSQ.getLayoutParams()).rightMargin = 0;
                        }
                        this.iSH.setSpacingRight(0);
                        String str = null;
                        if (aCr.getBaijiahaoInfo() != null) {
                            str = aCr.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iSX.setVisibility(0);
                            this.iSX.setText(str);
                        } else {
                            this.iSX.setVisibility(8);
                        }
                    } else {
                        this.iSX.setVisibility(8);
                        if (this.iSQ.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iSQ.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iSH.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cLy = postData.cLy();
                        if (cLy != null && !TextUtils.isEmpty(cLy.getName()) && !TextUtils.isEmpty(cLy.getName().trim())) {
                            this.iSW.setVisibility(0);
                            this.iSW.setText(cLy.getName());
                        } else {
                            this.iSW.setVisibility(8);
                        }
                    }
                    if (eVar.ckP().aCr() != null || eVar.ckP().aCr().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.ckP().aCr().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cre();
                        z = true;
                    }
                    if (z) {
                        this.iSM.a(aCr, 0);
                        this.iSM.setIsclearmode(false);
                    } else {
                        this.iSM.setIsclearmode(true);
                    }
                    this.iSM.setVisibility(0);
                    if (this.iSR != null) {
                        this.iSR.setVisibility(8);
                    }
                    this.iSJ.setOnClickListener(onClickListener);
                    this.iSM.getHeadView().setUserId(aCr.getUserId());
                    this.iSM.getHeadView().setUserName(aCr.getUserName());
                    this.iSM.getHeadView().setTid(postData.getId());
                    this.iSM.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iSM.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.iSM.tU(aCr.getAvater());
                    } else {
                        this.iSM.a(aCr);
                    }
                    String name_show = aCr.getName_show();
                    String userName = aCr.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iSJ.setText(com.baidu.tieba.pb.c.ba(this.iFL.getPageContext().getPageActivity(), this.iSJ.getText().toString()));
                        this.iSJ.setGravity(16);
                        this.iSJ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cky());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aCr.getIconInfo();
                tShowInfoNew = aCr.getTShowInfoNew();
                if (this.iHI != null) {
                }
                if (this.iHH != null) {
                }
                this.iSJ.setText(cA(aCr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iSJ.setTag(R.id.tag_user_id, aCr.getUserId());
                this.iSJ.setTag(R.id.tag_user_name, aCr.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_cont_h, 1);
                if (!eVar.cln()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.cln()) {
                }
                if (eVar.ckP().aCr() != null) {
                }
                z = false;
                if (z) {
                }
                this.iSM.setVisibility(0);
                if (this.iSR != null) {
                }
                this.iSJ.setOnClickListener(onClickListener);
                this.iSM.getHeadView().setUserId(aCr.getUserId());
                this.iSM.getHeadView().setUserName(aCr.getUserName());
                this.iSM.getHeadView().setTid(postData.getId());
                this.iSM.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iSM.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aCr.getName_show();
                String userName2 = aCr.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iSJ.setText(com.baidu.tieba.pb.c.ba(this.iFL.getPageContext().getPageActivity(), this.iSJ.getText().toString()));
                    this.iSJ.setGravity(16);
                    this.iSJ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cky());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aCr.getIconInfo();
                    tShowInfoNew = aCr.getTShowInfoNew();
                    if (this.iHI != null) {
                    }
                    if (this.iHH != null) {
                    }
                    this.iSJ.setText(cA(aCr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iSJ.setTag(R.id.tag_user_id, aCr.getUserId());
                    this.iSJ.setTag(R.id.tag_user_name, aCr.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_cont_h, 1);
                    if (!eVar.cln()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!eVar.cln()) {
                    }
                    if (eVar.ckP().aCr() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.iSM.setVisibility(0);
                    if (this.iSR != null) {
                    }
                    this.iSJ.setOnClickListener(onClickListener);
                    this.iSM.getHeadView().setUserId(aCr.getUserId());
                    this.iSM.getHeadView().setUserName(aCr.getUserName());
                    this.iSM.getHeadView().setTid(postData.getId());
                    this.iSM.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iSM.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aCr.getName_show();
                    String userName22 = aCr.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aCr.getIconInfo();
                tShowInfoNew = aCr.getTShowInfoNew();
                if (this.iHI != null) {
                }
                if (this.iHH != null) {
                }
                this.iSJ.setText(cA(aCr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iSJ.setTag(R.id.tag_user_id, aCr.getUserId());
                this.iSJ.setTag(R.id.tag_user_name, aCr.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iSJ, R.color.cp_cont_h, 1);
                if (!eVar.cln()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.cln()) {
                }
                if (eVar.ckP().aCr() != null) {
                }
                z = false;
                if (z) {
                }
                this.iSM.setVisibility(0);
                if (this.iSR != null) {
                }
                this.iSJ.setOnClickListener(onClickListener);
                this.iSM.getHeadView().setUserId(aCr.getUserId());
                this.iSM.getHeadView().setUserName(aCr.getUserName());
                this.iSM.getHeadView().setTid(postData.getId());
                this.iSM.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iSM.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aCr.getName_show();
                String userName222 = aCr.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.iSG.aG(eVar.ckP());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.clq()) {
                this.iSS.setVisibility(0);
            }
            if (z) {
                this.iSS.setVisibility(8);
                if (eVar != null && eVar.ckP() != null && eVar.ckP().getBaijiahaoData() != null && eVar.ckP().getBaijiahaoData().oriUgcType == 3) {
                    this.iSU.setVisibility(8);
                } else {
                    this.iSU.setVisibility(0);
                }
                this.iSU.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.clj())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCr().hadConcerned()) {
                this.iSS.setVisibility(8);
                this.iSU.setVisibility(8);
            } else {
                this.iSU.setVisibility(8);
            }
            if (eVar.iDs || 3 == eVar.clq()) {
                this.iSS.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aCr() != null) {
                postData.aCr().setIsLike(postData.aCr().hadConcerned());
            }
            if (this.iST == null) {
                bj ckP = eVar.ckP();
                int i = 1;
                if (ckP != null) {
                    if (ckP.aBg()) {
                        i = 4;
                    } else if (ckP.aBh()) {
                        i = 6;
                    } else if (ckP.aEl()) {
                        i = 7;
                    } else if (ckP.aEk()) {
                        i = 5;
                    }
                }
                this.iST = new al(this.iFL.getPageContext(), this.iSS, i);
                this.iST.j(this.iFL.getUniqueId());
                this.iST.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fW(boolean z3) {
                        if (d.this.iFL != null && z3) {
                            l.showToast(d.this.iFL.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.aCr() != null) {
                postData.aCr().setIsLike(postData.aCr().hadConcerned());
                this.iST.a(postData.aCr());
                this.iST.setTid(threadId);
            }
            this.iST.iPr = z2;
            this.iST.zk(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckP() == null) {
            return 0;
        }
        if (eVar.ckP().aDK()) {
            return (v.isEmpty(eVar.cli()) && (eVar.ckO() == null || StringUtils.isNull(eVar.ckO().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aCM() != null) {
                this.iSI.setData(this.iFL.getPageContext(), eVar.ckR().get(0).aCM(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.ckP().getId(), this.iFL.aEg() ? "FRS" : null));
                this.iSH.setPadding(this.iSH.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iSH.getPaddingRight(), this.iSH.getPaddingBottom());
                return;
            }
            this.iSI.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iFL.clN()) {
            this.iSY = 0;
            if (postData != null && postData.aCr() != null) {
                this.iSY = postData.aCr().getLevel_id();
            }
            if (this.iSY > 0 && !z) {
                this.iSL.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.iSL, BitmapHelper.getGradeResourceIdInEnterForum(this.iSY));
                return;
            }
            this.iSL.setVisibility(8);
            return;
        }
        this.iSL.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aHP()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iSH.getPaddingBottom();
            if (eVar.cln()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iSH.setPadding(this.iSH.getPaddingLeft(), dimens, this.iSH.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iSH.getPaddingBottom();
        if (eVar != null && !eVar.ckP().aBe() && eVar.cln() && (!StringUtils.isNull(eVar.ckP().getTitle()) || eVar.ckP().aCY() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iSH.setPadding(this.iSH.getPaddingLeft(), dimens2, this.iSH.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iSH.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iSE);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iSE, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iSE);
        }
    }

    public void setVisibility(int i) {
        this.iSH.setVisibility(i);
    }

    private void cre() {
        if (this.iSN != null) {
            this.iSN.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iSN.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.iFL.cnE(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.iFL.cnE(), R.dimen.ds8);
            this.iSN.setLayoutParams(layoutParams);
            this.iSN.loop(true);
            this.iSN.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iSN.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iDt) {
            this.iSF.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iSF.setVisibility(0);
        } else if (z && z2) {
            this.iSF.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iSF.setVisibility(0);
        } else if (z) {
            this.iSF.setImageResource(R.drawable.pic_pb_refined_n);
            this.iSF.setVisibility(0);
        } else if (z2) {
            this.iSF.setImageResource(R.drawable.pic_pb_stick_n);
            this.iSF.setVisibility(0);
        } else {
            this.iSF.setVisibility(8);
        }
    }

    private SpannableStringBuilder cA(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iFL.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> crf() {
        SparseArray<Object> sparseArray = (SparseArray) this.iSH.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iSH.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cmh() {
        return this.iSG.cmh();
    }

    public void pH(boolean z) {
        this.iSG.pH(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iSL != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.iSL, BitmapHelper.getGradeResourceIdInEnterForum(this.iSY));
        }
        if (this.iSS != null) {
            this.iSS.onChangeSkinType(i);
        }
        if (this.iSW != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSW, (int) R.color.cp_cont_d);
        }
        if (this.iSV != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSV, (int) R.color.cp_cont_d);
        }
        if (this.iSU != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSU, (int) R.color.cp_cont_d);
        }
        if (this.iSX != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSX, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.iSN != null) {
                this.iSN.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.iSN != null) {
                this.iSN.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.iSN != null) {
            this.iSN.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.iSD != null) {
            this.iSD.zG();
        }
        if (this.iSH != null && this.iSR != null) {
            this.iSH.removeView(this.iSO);
            this.iSR = null;
        }
        if (this.iSN != null) {
            this.iSN.cancelAnimation();
        }
    }

    public void cqu() {
        if (this.iSD != null) {
            this.iSD.zG();
        }
    }
}
