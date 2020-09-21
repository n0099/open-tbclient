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
/* loaded from: classes21.dex */
public class d {
    private LayerDrawable ajl;
    private LayerDrawable ajm;
    private com.baidu.tieba.pb.a.c eHq;
    private View.OnClickListener icH;
    private PbFragment kHX;
    private UserIconBox kKn;
    private UserIconBox kKo;
    private f kWA;
    private ThreadSkinView kWC;
    private ImageView kWF;
    private HeadPendantView kWG;
    private TBLottieAnimationView kWH;
    private LinearLayout kWJ;
    private LinearLayout kWK;
    private ax kWN;
    private com.baidu.tieba.c.e kWx;
    private ImageView kWz;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kWy = null;
    private ColumnLayout kWB = null;
    private TextView kWD = null;
    private TextView kWE = null;
    private FrameLayout kWI = null;
    private ClickableHeaderImageView kWL = null;
    private PbFirstFloorUserLikeButton kWM = null;
    private TextView kWO = null;
    private TextView kWP = null;
    private TextView kWQ = null;
    private TextView kWR = null;
    private TextView kWS = null;
    private int kWT = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.icH = null;
        this.kHX = pbFragment;
        this.eHq = cVar;
        this.icH = onClickListener;
        int dimens = l.getDimens(this.kHX.getContext(), R.dimen.tbds6);
        this.ajl = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(dimens).AT("#4D000000").bkO()});
        this.ajm = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bkO(), com.baidu.tbadk.core.util.e.a.b.bkM().oq(0).V(dimens).AT("#4D000000").bkO()});
        initView();
    }

    private void initView() {
        this.kWy = (RelativeLayout) LayoutInflater.from(this.kHX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kWz = (ImageView) this.kWy.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kWz.getLayoutParams().height = ay.ddM();
        this.kWA = new f(this.kHX.getBaseFragmentActivity(), this.kWy);
        this.kWA.init();
        this.kWA.setOnClickListener(this.kWA.dar(), this.icH);
        this.kWB = (ColumnLayout) this.kWy.findViewById(R.id.pb_head_owner_root);
        this.kWC = (ThreadSkinView) this.kWy.findViewById(R.id.pb_thread_skin);
        this.kWD = (TextView) this.kWB.findViewById(R.id.pb_head_owner_info_user_name);
        this.kWE = (TextView) this.kWB.findViewById(R.id.floor_owner);
        this.kWF = (ImageView) this.kWB.findViewById(R.id.icon_forum_level);
        this.kWI = (FrameLayout) this.kWB.findViewById(R.id.pb_head_headImage_container);
        this.kWG = (HeadPendantView) this.kWB.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kWG.setHasPendantStyle();
        this.kWH = (TBLottieAnimationView) this.kWB.findViewById(R.id.pb_head_living_lottie);
        this.kWB.setOnLongClickListener(this.mOnLongClickListener);
        this.kWB.setOnTouchListener(this.eHq);
        this.kWB.setVisibility(8);
        if (this.kWG.getHeadView() != null) {
            this.kWG.getHeadView().setIsRound(true);
            this.kWG.getHeadView().setDrawBorder(false);
            this.kWG.getHeadView().setPlaceHolder(1);
        }
        this.kKn = (UserIconBox) this.kWB.findViewById(R.id.show_icon_vip);
        this.kKo = (UserIconBox) this.kWB.findViewById(R.id.show_icon_yinji);
        this.kWJ = (LinearLayout) this.kWy.findViewById(R.id.pb_head_owner_info_root);
        this.kWK = (LinearLayout) this.kWB.findViewById(R.id.pb_first_floor_location_container);
        this.kWM = (PbFirstFloorUserLikeButton) this.kWB.findViewById(R.id.pb_like_button);
        this.kWO = (TextView) this.kWB.findViewById(R.id.pb_views);
        this.kWP = (TextView) this.kWB.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kWQ = (TextView) this.kWB.findViewById(R.id.pb_item_first_floor_location_address);
        this.kWR = (TextView) this.kWB.findViewById(R.id.pb_item_first_floor_distance);
        this.kWS = (TextView) this.kWB.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dfu() {
        return this.kWy;
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
        if (postData != null && postData.bfy() != null) {
            MetaData bfy = postData.bfy();
            String string = bfy.getName_show() == null ? StringUtils.string(bfy.getUserName()) : StringUtils.string(bfy.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bfy().getSealPrefix())) {
                i2 = k.byteLength(bfy.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bfy.getIconInfo();
                    tShowInfoNew = bfy.getTShowInfoNew();
                    if (this.kKo != null) {
                        this.kKo.setTag(R.id.tag_user_id, bfy.getUserId());
                        if (this.kHX.dbM() != null) {
                            this.kKo.setOnClickListener(this.kHX.dbM().kIj.kYn);
                        }
                        this.kKo.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kKn != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kKn.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kHX.dbM() != null) {
                            this.kKn.setOnClickListener(this.kHX.dbM().kIj.kYo);
                        }
                        this.kKn.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kWD.setText(dH(bfy.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kWD.setTag(R.id.tag_user_id, bfy.getUserId());
                    this.kWD.setTag(R.id.tag_user_name, bfy.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bfy.isBigV()) {
                        ap.setViewTextColor(this.kWD, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.kWD, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cZu()) {
                        this.kWE.setVisibility(8);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bfy.getBawu_type())) {
                        this.kWE.setText(R.string.bawu_member_bazhu_tip);
                        this.kWE.setVisibility(0);
                        if (i == 1) {
                            if (this.ajl.getDrawable(1) != null) {
                                this.ajl.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajl.getDrawable(1) != null) {
                            this.ajl.getDrawable(1).setAlpha(0);
                        }
                        this.kWE.setBackgroundDrawable(this.ajl);
                        ap.setViewTextColor(this.kWE, R.color.cp_cont_a);
                    } else if (bfy.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bfy.getBawu_type())) {
                        this.kWE.setText(R.string.bawu_member_xbazhu_tip);
                        this.kWE.setVisibility(0);
                        if (i == 1) {
                            if (this.ajm.getDrawable(1) != null) {
                                this.ajm.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajm.getDrawable(1) != null) {
                            this.ajm.getDrawable(1).setAlpha(0);
                        }
                        this.kWE.setBackgroundDrawable(this.ajm);
                        ap.setViewTextColor(this.kWE, R.color.cp_cont_a);
                    } else {
                        this.kWE.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kWP.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kWP.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cZu()) {
                        this.kWQ.setVisibility(8);
                        if (this.kWK.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kWK.getLayoutParams()).rightMargin = 0;
                        }
                        this.kWB.setSpacingRight(0);
                        String str = null;
                        if (bfy.getBaijiahaoInfo() != null) {
                            str = bfy.getBaijiahaoInfo().auth_desc;
                        }
                        if (bfy.isNewGod()) {
                            this.kWS.setVisibility(0);
                            this.kWS.setText(bfy.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bfy.showBazhuGrade()) {
                            this.kWS.setVisibility(0);
                            this.kWS.setText(at.cutChineseAndEnglishWithSuffix(bfy.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.kWS.setVisibility(0);
                            this.kWS.setText(str);
                        } else {
                            this.kWS.setVisibility(8);
                        }
                    } else {
                        if (bfy.isNewGod()) {
                            this.kWS.setVisibility(0);
                            this.kWS.setText(bfy.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bfy.showBazhuGrade()) {
                            this.kWS.setVisibility(0);
                            this.kWS.setText(at.cutChineseAndEnglishWithSuffix(bfy.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.kWS.setVisibility(8);
                        }
                        if (this.kWK.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kWK.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kWB.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dAG = postData.dAG();
                        if (dAG != null && !TextUtils.isEmpty(dAG.getName()) && !TextUtils.isEmpty(dAG.getName().trim())) {
                            this.kWQ.setVisibility(0);
                            this.kWQ.setText(dAG.getName());
                        } else {
                            this.kWQ.setVisibility(8);
                        }
                        if (dAG != null && !TextUtils.isEmpty(dAG.getDistance())) {
                            this.kWR.setText(dAG.getDistance());
                            this.kWR.setVisibility(0);
                            final int measureText = (int) this.kWR.getPaint().measureText(dAG.getDistance(), 0, dAG.getDistance().length());
                            this.kWK.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.kWK.getMeasuredWidth();
                                    int measuredWidth2 = d.this.kWP.getMeasuredWidth();
                                    int measuredWidth3 = d.this.kWS.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.kWR.setVisibility(8);
                                        d.this.kWQ.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.kWQ.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.kWR.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.cYR().bfy() != null && fVar.cYR().bfy().getAlaInfo() != null && fVar.cYR().bfy().getAlaInfo().live_status == 1) {
                        dfv();
                        z = true;
                    }
                    this.kWG.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kWG.a(bfy, 4);
                        this.kWG.setIsclearmode(false);
                    } else {
                        this.kWG.setIsclearmode(true);
                    }
                    this.kWG.setVisibility(0);
                    if (this.kWL != null) {
                        this.kWL.setVisibility(8);
                    }
                    this.kWD.setOnClickListener(onClickListener);
                    this.kWG.getHeadView().setUserId(bfy.getUserId());
                    this.kWG.getHeadView().setUserName(bfy.getUserName());
                    this.kWG.getHeadView().setTid(postData.getId());
                    this.kWG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kWG.getHeadView().setFName(fVar.getForumName());
                    this.kWG.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kWG.AX(bfy.getAvater());
                    } else {
                        this.kWG.a(bfy);
                    }
                    String name_show = bfy.getName_show();
                    String userName = bfy.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kWD.setText(com.baidu.tieba.pb.c.aQ(this.kHX.getPageContext().getPageActivity(), this.kWD.getText().toString()));
                        this.kWD.setGravity(16);
                        this.kWD.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cYB());
                        ap.setViewTextColor(this.kWD, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bfy.getIconInfo();
                tShowInfoNew = bfy.getTShowInfoNew();
                if (this.kKo != null) {
                }
                if (this.kKn != null) {
                }
                this.kWD.setText(dH(bfy.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kWD.setTag(R.id.tag_user_id, bfy.getUserId());
                this.kWD.setTag(R.id.tag_user_name, bfy.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kWD, R.color.cp_cont_h, 1);
                if (!fVar.cZu()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cZu()) {
                }
                z = false;
                if (fVar.cYR().bfy() != null) {
                    dfv();
                    z = true;
                }
                this.kWG.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kWG.setVisibility(0);
                if (this.kWL != null) {
                }
                this.kWD.setOnClickListener(onClickListener);
                this.kWG.getHeadView().setUserId(bfy.getUserId());
                this.kWG.getHeadView().setUserName(bfy.getUserName());
                this.kWG.getHeadView().setTid(postData.getId());
                this.kWG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kWG.getHeadView().setFName(fVar.getForumName());
                this.kWG.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bfy.getName_show();
                String userName2 = bfy.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kWD.setText(com.baidu.tieba.pb.c.aQ(this.kHX.getPageContext().getPageActivity(), this.kWD.getText().toString()));
                    this.kWD.setGravity(16);
                    this.kWD.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cYB());
                    ap.setViewTextColor(this.kWD, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bfy.getIconInfo();
                    tShowInfoNew = bfy.getTShowInfoNew();
                    if (this.kKo != null) {
                    }
                    if (this.kKn != null) {
                    }
                    this.kWD.setText(dH(bfy.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kWD.setTag(R.id.tag_user_id, bfy.getUserId());
                    this.kWD.setTag(R.id.tag_user_name, bfy.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.kWD, R.color.cp_cont_h, 1);
                    if (!fVar.cZu()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.cZu()) {
                    }
                    z = false;
                    if (fVar.cYR().bfy() != null) {
                    }
                    this.kWG.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kWG.setVisibility(0);
                    if (this.kWL != null) {
                    }
                    this.kWD.setOnClickListener(onClickListener);
                    this.kWG.getHeadView().setUserId(bfy.getUserId());
                    this.kWG.getHeadView().setUserName(bfy.getUserName());
                    this.kWG.getHeadView().setTid(postData.getId());
                    this.kWG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kWG.getHeadView().setFName(fVar.getForumName());
                    this.kWG.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bfy.getName_show();
                    String userName22 = bfy.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bfy.getIconInfo();
                tShowInfoNew = bfy.getTShowInfoNew();
                if (this.kKo != null) {
                }
                if (this.kKn != null) {
                }
                this.kWD.setText(dH(bfy.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kWD.setTag(R.id.tag_user_id, bfy.getUserId());
                this.kWD.setTag(R.id.tag_user_name, bfy.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kWD, R.color.cp_cont_h, 1);
                if (!fVar.cZu()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cZu()) {
                }
                z = false;
                if (fVar.cYR().bfy() != null) {
                }
                this.kWG.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kWG.setVisibility(0);
                if (this.kWL != null) {
                }
                this.kWD.setOnClickListener(onClickListener);
                this.kWG.getHeadView().setUserId(bfy.getUserId());
                this.kWG.getHeadView().setUserName(bfy.getUserName());
                this.kWG.getHeadView().setTid(postData.getId());
                this.kWG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kWG.getHeadView().setFName(fVar.getForumName());
                this.kWG.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bfy.getName_show();
                String userName222 = bfy.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.kWA.aG(fVar.cYR());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cZx()) {
                this.kWM.setVisibility(0);
            }
            if (z) {
                this.kWM.setVisibility(8);
                if (fVar != null && fVar.cYR() != null && fVar.cYR().getBaijiahaoData() != null && fVar.cYR().getBaijiahaoData().oriUgcType == 3) {
                    this.kWO.setVisibility(8);
                } else {
                    this.kWO.setVisibility(0);
                }
                this.kWO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.cZp())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bfy().hadConcerned()) {
                this.kWM.setVisibility(8);
                this.kWO.setVisibility(8);
            } else {
                this.kWO.setVisibility(8);
            }
            if (fVar.kFq || 3 == fVar.cZx()) {
                this.kWM.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.bfy() != null) {
                postData.bfy().setIsLike(postData.bfy().hadConcerned());
            }
            if (this.kWN == null) {
                bw cYR = fVar.cYR();
                int i = 1;
                if (cYR != null) {
                    if (cYR.beg()) {
                        i = 4;
                    } else if (cYR.beh()) {
                        i = 6;
                    } else if (cYR.bhu()) {
                        i = 7;
                    } else if (cYR.bht()) {
                        i = 5;
                    }
                }
                this.kWN = new ax(this.kHX.getPageContext(), this.kWM, i);
                this.kWN.l(this.kHX.getUniqueId());
                this.kWN.setThreadData(cYR);
            }
            if (postData != null && postData.bfy() != null) {
                postData.bfy().setIsLike(postData.bfy().hadConcerned());
                this.kWN.a(postData.bfy());
                this.kWN.setTid(threadId);
            }
            this.kWN.kTe = z2;
            this.kWN.EU(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bfU() != null) {
                this.kWC.setData(this.kHX.getPageContext(), fVar.cYT().get(0).bfU(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.cYR().getId(), this.kHX.bdg() ? "FRS" : null));
                this.kWB.setPadding(this.kWB.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kWB.getPaddingRight(), this.kWB.getPaddingBottom());
                return;
            }
            this.kWC.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kHX.cZX()) {
            this.kWT = 0;
            if (postData != null && postData.bfy() != null) {
                this.kWT = postData.bfy().getLevel_id();
            }
            if (this.kWT > 0 && !z) {
                this.kWF.setVisibility(0);
                ap.setImageResource(this.kWF, BitmapHelper.getGradeResourceIdInEnterForum(this.kWT));
                return;
            }
            this.kWF.setVisibility(8);
            return;
        }
        this.kWF.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cZr()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kWB.getPaddingBottom();
            if (fVar.cZu()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kWB.setPadding(this.kWB.getPaddingLeft(), dimens, this.kWB.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kWB.getPaddingBottom();
        if (fVar != null && !fVar.cYR().bee() && fVar.cZu() && (!StringUtils.isNull(fVar.cYR().getTitle()) || fVar.cYR().bgi() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kWB.setPadding(this.kWB.getPaddingLeft(), dimens2, this.kWB.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kWB.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kWy);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kWy, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kWy);
        }
    }

    public void setVisibility(int i) {
        this.kWB.setVisibility(i);
    }

    private void dfv() {
        if (this.kWH != null) {
            this.kWH.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kWH.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kHX.dbM(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kHX.dbM(), R.dimen.ds8);
            this.kWH.setLayoutParams(layoutParams);
            this.kWH.loop(true);
            this.kWH.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kWH.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kFr) {
            this.kWz.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kWz.setVisibility(0);
        } else if (z && z2) {
            this.kWz.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kWz.setVisibility(0);
        } else if (z) {
            this.kWz.setImageResource(R.drawable.pic_pb_refined_n);
            this.kWz.setVisibility(0);
        } else if (z2) {
            this.kWz.setImageResource(R.drawable.pic_pb_stick_n);
            this.kWz.setVisibility(0);
        } else {
            this.kWz.setVisibility(8);
        }
    }

    private SpannableStringBuilder dH(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kHX.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dfw() {
        SparseArray<Object> sparseArray = (SparseArray) this.kWB.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kWB.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dar() {
        return this.kWA.dar();
    }

    public void sR(boolean z) {
        this.kWA.sR(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kWF != null) {
            ap.setImageResource(this.kWF, BitmapHelper.getGradeResourceIdInEnterForum(this.kWT));
        }
        if (this.kWM != null) {
            this.kWM.onChangeSkinType(i);
        }
        if (this.kWQ != null) {
            ap.setViewTextColor(this.kWQ, R.color.cp_cont_d);
        }
        if (this.kWP != null) {
            ap.setViewTextColor(this.kWP, R.color.cp_cont_d);
        }
        if (this.kWO != null) {
            ap.setViewTextColor(this.kWO, R.color.cp_cont_d);
        }
        if (this.kWS != null) {
            ap.setViewTextColor(this.kWS, R.color.cp_cont_d);
        }
        if (this.kWR != null) {
            ap.setViewTextColor(this.kWR, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kWH != null) {
                this.kWH.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kWH != null) {
                this.kWH.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kWH != null) {
            this.kWH.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kWx != null) {
            this.kWx.Oj();
        }
        if (this.kWB != null && this.kWL != null) {
            this.kWB.removeView(this.kWI);
            this.kWL = null;
        }
        if (this.kWH != null) {
            this.kWH.cancelAnimation();
        }
    }

    public void deI() {
        if (this.kWx != null) {
            this.kWx.Oj();
        }
    }
}
