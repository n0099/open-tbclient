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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class d {
    private LayerDrawable ajD;
    private LayerDrawable ajE;
    private com.baidu.tieba.pb.a.c eTx;
    private View.OnClickListener irI;
    private PbFragment kXi;
    private UserIconBox kZy;
    private UserIconBox kZz;
    private com.baidu.tieba.c.e llK;
    private ImageView llM;
    private f llN;
    private ThreadSkinView llP;
    private ImageView llS;
    private HeadPendantView llT;
    private TBLottieAnimationView llU;
    private LinearLayout llW;
    private LinearLayout llX;
    private ax lma;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout llL = null;
    private ColumnLayout llO = null;
    private TextView llQ = null;
    private TextView llR = null;
    private FrameLayout llV = null;
    private ClickableHeaderImageView llY = null;
    private PbFirstFloorUserLikeButton llZ = null;
    private TextView lmb = null;
    private TextView lmc = null;
    private TextView lmd = null;
    private TextView lme = null;
    private TextView lmf = null;
    private int lmg = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.irI = null;
        this.kXi = pbFragment;
        this.eTx = cVar;
        this.irI = onClickListener;
        int dimens = l.getDimens(this.kXi.getContext(), R.dimen.tbds6);
        this.ajD = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(dimens).BF("#4D000000").bny()});
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bny(), com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(dimens).BF("#4D000000").bny()});
        initView();
    }

    private void initView() {
        this.llL = (RelativeLayout) LayoutInflater.from(this.kXi.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.llM = (ImageView) this.llL.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.llM.getLayoutParams().height = ay.dhv();
        this.llN = new f(this.kXi.getBaseFragmentActivity(), this.llL);
        this.llN.init();
        this.llN.setOnClickListener(this.llN.dea(), this.irI);
        this.llO = (ColumnLayout) this.llL.findViewById(R.id.pb_head_owner_root);
        this.llP = (ThreadSkinView) this.llL.findViewById(R.id.pb_thread_skin);
        this.llQ = (TextView) this.llO.findViewById(R.id.pb_head_owner_info_user_name);
        this.llR = (TextView) this.llO.findViewById(R.id.floor_owner);
        this.llS = (ImageView) this.llO.findViewById(R.id.icon_forum_level);
        this.llV = (FrameLayout) this.llO.findViewById(R.id.pb_head_headImage_container);
        this.llT = (HeadPendantView) this.llO.findViewById(R.id.pb_pendant_head_owner_photo);
        this.llT.setHasPendantStyle();
        this.llU = (TBLottieAnimationView) this.llO.findViewById(R.id.pb_head_living_lottie);
        this.llO.setOnLongClickListener(this.mOnLongClickListener);
        this.llO.setOnTouchListener(this.eTx);
        this.llO.setVisibility(8);
        if (this.llT.getHeadView() != null) {
            this.llT.getHeadView().setIsRound(true);
            this.llT.getHeadView().setDrawBorder(false);
            this.llT.getHeadView().setPlaceHolder(1);
        }
        this.kZy = (UserIconBox) this.llO.findViewById(R.id.show_icon_vip);
        this.kZz = (UserIconBox) this.llO.findViewById(R.id.show_icon_yinji);
        this.llW = (LinearLayout) this.llL.findViewById(R.id.pb_head_owner_info_root);
        this.llX = (LinearLayout) this.llO.findViewById(R.id.pb_first_floor_location_container);
        this.llZ = (PbFirstFloorUserLikeButton) this.llO.findViewById(R.id.pb_like_button);
        this.lmb = (TextView) this.llO.findViewById(R.id.pb_views);
        this.lmc = (TextView) this.llO.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lmd = (TextView) this.llO.findViewById(R.id.pb_item_first_floor_location_address);
        this.lme = (TextView) this.llO.findViewById(R.id.pb_item_first_floor_distance);
        this.lmf = (TextView) this.llO.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View djd() {
        return this.llL;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.bih() != null) {
            MetaData bih = postData.bih();
            String string = bih.getName_show() == null ? StringUtils.string(bih.getUserName()) : StringUtils.string(bih.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bih().getSealPrefix())) {
                i2 = k.byteLength(bih.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bih.getIconInfo();
                    tShowInfoNew = bih.getTShowInfoNew();
                    if (this.kZz != null) {
                        this.kZz.setTag(R.id.tag_user_id, bih.getUserId());
                        if (this.kXi.dfv() != null) {
                            this.kZz.setOnClickListener(this.kXi.dfv().kXu.lnB);
                        }
                        this.kZz.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kZy != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kZy.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kXi.dfv() != null) {
                            this.kZy.setOnClickListener(this.kXi.dfv().kXu.lnC);
                        }
                        this.kZy.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.llQ.setText(dM(bih.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.llQ.setTag(R.id.tag_user_id, bih.getUserId());
                    this.llQ.setTag(R.id.tag_user_name, bih.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bih.isBigV()) {
                        ap.setViewTextColor(this.llQ, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.llQ, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.ddd()) {
                        this.llR.setVisibility(8);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bih.getBawu_type())) {
                        this.llR.setText(R.string.bawu_member_bazhu_tip);
                        this.llR.setVisibility(0);
                        if (i == 1) {
                            if (this.ajD.getDrawable(1) != null) {
                                this.ajD.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajD.getDrawable(1) != null) {
                            this.ajD.getDrawable(1).setAlpha(0);
                        }
                        this.llR.setBackgroundDrawable(this.ajD);
                        ap.setViewTextColor(this.llR, R.color.cp_cont_a);
                    } else if (bih.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bih.getBawu_type())) {
                        this.llR.setText(R.string.bawu_member_xbazhu_tip);
                        this.llR.setVisibility(0);
                        if (i == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        this.llR.setBackgroundDrawable(this.ajE);
                        ap.setViewTextColor(this.llR, R.color.cp_cont_a);
                    } else {
                        this.llR.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lmc.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lmc.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.ddd()) {
                        this.lmd.setVisibility(8);
                        if (this.llX.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.llX.getLayoutParams()).rightMargin = 0;
                        }
                        this.llO.setSpacingRight(0);
                        String str = null;
                        if (bih.getBaijiahaoInfo() != null) {
                            str = bih.getBaijiahaoInfo().auth_desc;
                        }
                        if (bih.isNewGod()) {
                            this.lmf.setVisibility(0);
                            this.lmf.setText(bih.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bih.showBazhuGrade()) {
                            this.lmf.setVisibility(0);
                            this.lmf.setText(at.cutChineseAndEnglishWithSuffix(bih.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lmf.setVisibility(0);
                            this.lmf.setText(str);
                        } else {
                            this.lmf.setVisibility(8);
                        }
                    } else {
                        if (bih.isNewGod()) {
                            this.lmf.setVisibility(0);
                            this.lmf.setText(bih.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bih.showBazhuGrade()) {
                            this.lmf.setVisibility(0);
                            this.lmf.setText(at.cutChineseAndEnglishWithSuffix(bih.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lmf.setVisibility(8);
                        }
                        if (this.llX.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.llX.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.llO.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dEs = postData.dEs();
                        if (dEs != null && !TextUtils.isEmpty(dEs.getName()) && !TextUtils.isEmpty(dEs.getName().trim())) {
                            this.lmd.setVisibility(0);
                            this.lmd.setText(dEs.getName());
                        } else {
                            this.lmd.setVisibility(8);
                        }
                        if (dEs != null && !TextUtils.isEmpty(dEs.getDistance())) {
                            this.lme.setText(dEs.getDistance());
                            this.lme.setVisibility(0);
                            final int measureText = (int) this.lme.getPaint().measureText(dEs.getDistance(), 0, dEs.getDistance().length());
                            this.llX.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.llX.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lmc.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lmf.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lme.setVisibility(8);
                                        d.this.lmd.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lmd.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lme.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dcA().bih() != null && fVar.dcA().bih().getAlaInfo() != null && fVar.dcA().bih().getAlaInfo().live_status == 1) {
                        dje();
                        z = true;
                    }
                    this.llT.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.llT.a(bih, 4);
                        this.llT.setIsclearmode(false);
                    } else {
                        this.llT.setIsclearmode(true);
                    }
                    this.llT.setVisibility(0);
                    if (this.llY != null) {
                        this.llY.setVisibility(8);
                    }
                    this.llQ.setOnClickListener(onClickListener);
                    this.llT.getHeadView().setUserId(bih.getUserId());
                    this.llT.getHeadView().setUserName(bih.getUserName());
                    this.llT.getHeadView().setTid(postData.getId());
                    this.llT.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.llT.getHeadView().setFName(fVar.getForumName());
                    this.llT.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.llT.BJ(bih.getAvater());
                    } else {
                        this.llT.a(bih);
                    }
                    String name_show = bih.getName_show();
                    String userName = bih.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.llQ.setText(com.baidu.tieba.pb.c.aS(this.kXi.getPageContext().getPageActivity(), this.llQ.getText().toString()));
                        this.llQ.setGravity(16);
                        this.llQ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dck());
                        ap.setViewTextColor(this.llQ, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bih.getIconInfo();
                tShowInfoNew = bih.getTShowInfoNew();
                if (this.kZz != null) {
                }
                if (this.kZy != null) {
                }
                this.llQ.setText(dM(bih.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.llQ.setTag(R.id.tag_user_id, bih.getUserId());
                this.llQ.setTag(R.id.tag_user_name, bih.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.llQ, R.color.cp_cont_h, 1);
                if (!fVar.ddd()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.ddd()) {
                }
                z = false;
                if (fVar.dcA().bih() != null) {
                    dje();
                    z = true;
                }
                this.llT.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.llT.setVisibility(0);
                if (this.llY != null) {
                }
                this.llQ.setOnClickListener(onClickListener);
                this.llT.getHeadView().setUserId(bih.getUserId());
                this.llT.getHeadView().setUserName(bih.getUserName());
                this.llT.getHeadView().setTid(postData.getId());
                this.llT.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.llT.getHeadView().setFName(fVar.getForumName());
                this.llT.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bih.getName_show();
                String userName2 = bih.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.llQ.setText(com.baidu.tieba.pb.c.aS(this.kXi.getPageContext().getPageActivity(), this.llQ.getText().toString()));
                    this.llQ.setGravity(16);
                    this.llQ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dck());
                    ap.setViewTextColor(this.llQ, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bih.getIconInfo();
                    tShowInfoNew = bih.getTShowInfoNew();
                    if (this.kZz != null) {
                    }
                    if (this.kZy != null) {
                    }
                    this.llQ.setText(dM(bih.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.llQ.setTag(R.id.tag_user_id, bih.getUserId());
                    this.llQ.setTag(R.id.tag_user_name, bih.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.llQ, R.color.cp_cont_h, 1);
                    if (!fVar.ddd()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.ddd()) {
                    }
                    z = false;
                    if (fVar.dcA().bih() != null) {
                    }
                    this.llT.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.llT.setVisibility(0);
                    if (this.llY != null) {
                    }
                    this.llQ.setOnClickListener(onClickListener);
                    this.llT.getHeadView().setUserId(bih.getUserId());
                    this.llT.getHeadView().setUserName(bih.getUserName());
                    this.llT.getHeadView().setTid(postData.getId());
                    this.llT.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.llT.getHeadView().setFName(fVar.getForumName());
                    this.llT.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bih.getName_show();
                    String userName22 = bih.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bih.getIconInfo();
                tShowInfoNew = bih.getTShowInfoNew();
                if (this.kZz != null) {
                }
                if (this.kZy != null) {
                }
                this.llQ.setText(dM(bih.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.llQ.setTag(R.id.tag_user_id, bih.getUserId());
                this.llQ.setTag(R.id.tag_user_name, bih.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.llQ, R.color.cp_cont_h, 1);
                if (!fVar.ddd()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.ddd()) {
                }
                z = false;
                if (fVar.dcA().bih() != null) {
                }
                this.llT.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.llT.setVisibility(0);
                if (this.llY != null) {
                }
                this.llQ.setOnClickListener(onClickListener);
                this.llT.getHeadView().setUserId(bih.getUserId());
                this.llT.getHeadView().setUserName(bih.getUserName());
                this.llT.getHeadView().setTid(postData.getId());
                this.llT.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.llT.getHeadView().setFName(fVar.getForumName());
                this.llT.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bih.getName_show();
                String userName222 = bih.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.llN.aG(fVar.dcA());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.ddg()) {
                this.llZ.setVisibility(0);
            }
            if (z) {
                this.llZ.setVisibility(8);
                if (fVar != null && fVar.dcA() != null && fVar.dcA().getBaijiahaoData() != null && fVar.dcA().getBaijiahaoData().oriUgcType == 3) {
                    this.lmb.setVisibility(8);
                } else {
                    this.lmb.setVisibility(0);
                }
                this.lmb.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.dcY())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bih().hadConcerned()) {
                this.llZ.setVisibility(8);
                this.lmb.setVisibility(8);
            } else {
                this.lmb.setVisibility(8);
            }
            if (fVar.kUB || 3 == fVar.ddg()) {
                this.llZ.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.bih() != null) {
                postData.bih().setIsLike(postData.bih().hadConcerned());
            }
            if (this.lma == null) {
                bw dcA = fVar.dcA();
                int i = 1;
                if (dcA != null) {
                    if (dcA.bgP()) {
                        i = 4;
                    } else if (dcA.bgQ()) {
                        i = 6;
                    } else if (dcA.bkd()) {
                        i = 7;
                    } else if (dcA.bkc()) {
                        i = 5;
                    }
                }
                this.lma = new ax(this.kXi.getPageContext(), this.llZ, i);
                this.lma.l(this.kXi.getUniqueId());
                this.lma.setThreadData(dcA);
            }
            if (postData != null && postData.bih() != null) {
                postData.bih().setIsLike(postData.bih().hadConcerned());
                this.lma.a(postData.bih());
                this.lma.setTid(threadId);
            }
            this.lma.lir = z2;
            this.lma.FA(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.biD() != null) {
                this.llP.setData(this.kXi.getPageContext(), fVar.dcC().get(0).biD(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dcA().getId(), this.kXi.bfP() ? "FRS" : null));
                this.llO.setPadding(this.llO.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.llO.getPaddingRight(), this.llO.getPaddingBottom());
                return;
            }
            this.llP.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kXi.ddG()) {
            this.lmg = 0;
            if (postData != null && postData.bih() != null) {
                this.lmg = postData.bih().getLevel_id();
            }
            if (this.lmg > 0 && !z) {
                this.llS.setVisibility(0);
                ap.setImageResource(this.llS, BitmapHelper.getGradeResourceIdInEnterForum(this.lmg));
                return;
            }
            this.llS.setVisibility(8);
            return;
        }
        this.llS.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dda()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.llO.getPaddingBottom();
            if (fVar.ddd()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.llO.setPadding(this.llO.getPaddingLeft(), dimens, this.llO.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.llO.getPaddingBottom();
        if (fVar != null && !fVar.dcA().bgN() && fVar.ddd() && (!StringUtils.isNull(fVar.dcA().getTitle()) || fVar.dcA().biR() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.llO.setPadding(this.llO.getPaddingLeft(), dimens2, this.llO.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.llO.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.llL);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.llL, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.llL);
        }
    }

    public void setVisibility(int i) {
        this.llO.setVisibility(i);
    }

    private void dje() {
        if (this.llU != null) {
            this.llU.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llU.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kXi.dfv(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kXi.dfv(), R.dimen.ds8);
            this.llU.setLayoutParams(layoutParams);
            this.llU.loop(true);
            this.llU.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.llU.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kUC) {
            this.llM.setImageResource(R.drawable.pic_frs_headlines_n);
            this.llM.setVisibility(0);
        } else if (z && z2) {
            this.llM.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.llM.setVisibility(0);
        } else if (z) {
            this.llM.setImageResource(R.drawable.pic_pb_refined_n);
            this.llM.setVisibility(0);
        } else if (z2) {
            this.llM.setImageResource(R.drawable.pic_pb_stick_n);
            this.llM.setVisibility(0);
        } else {
            this.llM.setVisibility(8);
        }
    }

    private SpannableStringBuilder dM(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kXi.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> djf() {
        SparseArray<Object> sparseArray = (SparseArray) this.llO.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.llO.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dea() {
        return this.llN.dea();
    }

    public void ty(boolean z) {
        this.llN.ty(z);
    }

    public void onChangeSkinType(int i) {
        if (this.llS != null) {
            ap.setImageResource(this.llS, BitmapHelper.getGradeResourceIdInEnterForum(this.lmg));
        }
        if (this.llZ != null) {
            this.llZ.onChangeSkinType(i);
        }
        if (this.lmd != null) {
            ap.setViewTextColor(this.lmd, R.color.cp_cont_d);
        }
        if (this.lmc != null) {
            ap.setViewTextColor(this.lmc, R.color.cp_cont_d);
        }
        if (this.lmb != null) {
            ap.setViewTextColor(this.lmb, R.color.cp_cont_d);
        }
        if (this.lmf != null) {
            ap.setViewTextColor(this.lmf, R.color.cp_cont_d);
        }
        if (this.lme != null) {
            ap.setViewTextColor(this.lme, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.llU != null) {
                this.llU.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.llU != null) {
                this.llU.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.llU != null) {
            this.llU.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.llK != null) {
            this.llK.Po();
        }
        if (this.llO != null && this.llY != null) {
            this.llO.removeView(this.llV);
            this.llY = null;
        }
        if (this.llU != null) {
            this.llU.cancelAnimation();
        }
    }

    public void dir() {
        if (this.llK != null) {
            this.llK.Po();
        }
    }
}
