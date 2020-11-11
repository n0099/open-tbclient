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
import com.baidu.tieba.card.n;
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
    private LayerDrawable ajE;
    private LayerDrawable ajF;
    private com.baidu.tieba.pb.a.c fhK;
    private View.OnClickListener iKb;
    private ax lEA;
    private com.baidu.tieba.c.e lEk;
    private ImageView lEm;
    private f lEn;
    private ThreadSkinView lEp;
    private ImageView lEs;
    private HeadPendantView lEt;
    private TBLottieAnimationView lEu;
    private LinearLayout lEw;
    private LinearLayout lEx;
    private PbFragment lpI;
    private UserIconBox lrY;
    private UserIconBox lrZ;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lEl = null;
    private ColumnLayout lEo = null;
    private TextView lEq = null;
    private TextView lEr = null;
    private FrameLayout lEv = null;
    private ClickableHeaderImageView lEy = null;
    private PbFirstFloorUserLikeButton lEz = null;
    private TextView lEB = null;
    private TextView lEC = null;
    private TextView lED = null;
    private TextView lEE = null;
    private TextView lEF = null;
    private int lEG = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.iKb = null;
        this.lpI = pbFragment;
        this.fhK = cVar;
        this.iKb = onClickListener;
        int dimens = l.getDimens(this.lpI.getContext(), R.dimen.tbds6);
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(dimens).Cm("#4D000000").brR()});
        this.ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(dimens).Cm("#4D000000").brR()});
        initView();
    }

    private void initView() {
        this.lEl = (RelativeLayout) LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lEm = (ImageView) this.lEl.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lEm.getLayoutParams().height = ay.dne();
        this.lEn = new f(this.lpI.getBaseFragmentActivity(), this.lEl);
        this.lEn.init();
        this.lEn.setOnClickListener(this.lEn.djJ(), this.iKb);
        this.lEo = (ColumnLayout) this.lEl.findViewById(R.id.pb_head_owner_root);
        this.lEp = (ThreadSkinView) this.lEl.findViewById(R.id.pb_thread_skin);
        this.lEq = (TextView) this.lEo.findViewById(R.id.pb_head_owner_info_user_name);
        this.lEr = (TextView) this.lEo.findViewById(R.id.floor_owner);
        this.lEs = (ImageView) this.lEo.findViewById(R.id.icon_forum_level);
        this.lEv = (FrameLayout) this.lEo.findViewById(R.id.pb_head_headImage_container);
        this.lEt = (HeadPendantView) this.lEo.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lEt.setHasPendantStyle();
        this.lEu = (TBLottieAnimationView) this.lEo.findViewById(R.id.pb_head_living_lottie);
        this.lEo.setOnLongClickListener(this.mOnLongClickListener);
        this.lEo.setOnTouchListener(this.fhK);
        this.lEo.setVisibility(8);
        if (this.lEt.getHeadView() != null) {
            this.lEt.getHeadView().setIsRound(true);
            this.lEt.getHeadView().setDrawBorder(false);
            this.lEt.getHeadView().setPlaceHolder(1);
        }
        this.lrY = (UserIconBox) this.lEo.findViewById(R.id.show_icon_vip);
        this.lrZ = (UserIconBox) this.lEo.findViewById(R.id.show_icon_yinji);
        this.lEw = (LinearLayout) this.lEl.findViewById(R.id.pb_head_owner_info_root);
        this.lEx = (LinearLayout) this.lEo.findViewById(R.id.pb_first_floor_location_container);
        this.lEz = (PbFirstFloorUserLikeButton) this.lEo.findViewById(R.id.pb_like_button);
        this.lEB = (TextView) this.lEo.findViewById(R.id.pb_views);
        this.lEC = (TextView) this.lEo.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lED = (TextView) this.lEo.findViewById(R.id.pb_item_first_floor_location_address);
        this.lEE = (TextView) this.lEo.findViewById(R.id.pb_item_first_floor_distance);
        this.lEF = (TextView) this.lEo.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View doN() {
        return this.lEl;
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
        if (postData != null && postData.bmA() != null) {
            MetaData bmA = postData.bmA();
            String string = bmA.getName_show() == null ? StringUtils.string(bmA.getUserName()) : StringUtils.string(bmA.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bmA().getSealPrefix())) {
                i2 = k.byteLength(bmA.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bmA.getIconInfo();
                    tShowInfoNew = bmA.getTShowInfoNew();
                    if (this.lrZ != null) {
                        this.lrZ.setTag(R.id.tag_user_id, bmA.getUserId());
                        if (this.lpI.dle() != null) {
                            this.lrZ.setOnClickListener(this.lpI.dle().lpU.lGa);
                        }
                        this.lrZ.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.lrY != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lrY.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lpI.dle() != null) {
                            this.lrY.setOnClickListener(this.lpI.dle().lpU.lGb);
                        }
                        this.lrY.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.lEq.setText(dT(bmA.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lEq.setTag(R.id.tag_user_id, bmA.getUserId());
                    this.lEq.setTag(R.id.tag_user_name, bmA.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bmA.isBigV()) {
                        ap.setViewTextColor(this.lEq, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.lEq, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.diN()) {
                        this.lEr.setVisibility(8);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bmA.getBawu_type())) {
                        this.lEr.setText(R.string.bawu_member_bazhu_tip);
                        this.lEr.setVisibility(0);
                        if (i == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        this.lEr.setBackgroundDrawable(this.ajE);
                        ap.setViewTextColor(this.lEr, R.color.cp_cont_a);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bmA.getBawu_type())) {
                        this.lEr.setText(R.string.bawu_member_xbazhu_tip);
                        this.lEr.setVisibility(0);
                        if (i == 1) {
                            if (this.ajF.getDrawable(1) != null) {
                                this.ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajF.getDrawable(1) != null) {
                            this.ajF.getDrawable(1).setAlpha(0);
                        }
                        this.lEr.setBackgroundDrawable(this.ajF);
                        ap.setViewTextColor(this.lEr, R.color.cp_cont_a);
                    } else {
                        this.lEr.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lEC.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lEC.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.diN()) {
                        this.lED.setVisibility(8);
                        if (this.lEx.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lEx.getLayoutParams()).rightMargin = 0;
                        }
                        this.lEo.setSpacingRight(0);
                        String str = null;
                        if (bmA.getBaijiahaoInfo() != null) {
                            str = bmA.getBaijiahaoInfo().auth_desc;
                        }
                        if (bmA.isNewGod()) {
                            this.lEF.setVisibility(0);
                            this.lEF.setText(bmA.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bmA.showBazhuGrade()) {
                            this.lEF.setVisibility(0);
                            this.lEF.setText(at.cutChineseAndEnglishWithSuffix(bmA.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lEF.setVisibility(0);
                            this.lEF.setText(str);
                        } else {
                            this.lEF.setVisibility(8);
                        }
                    } else {
                        if (bmA.isNewGod()) {
                            this.lEF.setVisibility(0);
                            this.lEF.setText(bmA.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bmA.showBazhuGrade()) {
                            this.lEF.setVisibility(0);
                            this.lEF.setText(at.cutChineseAndEnglishWithSuffix(bmA.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lEF.setVisibility(8);
                        }
                        if (this.lEx.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lEx.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lEo.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dKc = postData.dKc();
                        if (dKc != null && !TextUtils.isEmpty(dKc.getName()) && !TextUtils.isEmpty(dKc.getName().trim())) {
                            this.lED.setVisibility(0);
                            this.lED.setText(dKc.getName());
                        } else {
                            this.lED.setVisibility(8);
                        }
                        if (dKc != null && !TextUtils.isEmpty(dKc.getDistance())) {
                            this.lEE.setText(dKc.getDistance());
                            this.lEE.setVisibility(0);
                            final int measureText = (int) this.lEE.getPaint().measureText(dKc.getDistance(), 0, dKc.getDistance().length());
                            this.lEx.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lEx.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lEC.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lEF.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lEE.setVisibility(8);
                                        d.this.lED.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lED.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lEE.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dik().bmA() != null && fVar.dik().bmA().getAlaInfo() != null && fVar.dik().bmA().getAlaInfo().live_status == 1) {
                        doO();
                        z = true;
                    }
                    this.lEt.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lEt.a(bmA, 4);
                        this.lEt.setIsclearmode(false);
                    } else {
                        this.lEt.setIsclearmode(true);
                    }
                    this.lEt.setVisibility(0);
                    if (this.lEy != null) {
                        this.lEy.setVisibility(8);
                    }
                    this.lEq.setOnClickListener(onClickListener);
                    this.lEt.getHeadView().setUserId(bmA.getUserId());
                    this.lEt.getHeadView().setUserName(bmA.getUserName());
                    this.lEt.getHeadView().setTid(postData.getId());
                    this.lEt.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lEt.getHeadView().setFName(fVar.getForumName());
                    this.lEt.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lEt.Cq(bmA.getAvater());
                    } else {
                        this.lEt.a(bmA);
                    }
                    String name_show = bmA.getName_show();
                    String userName = bmA.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lEq.setText(com.baidu.tieba.pb.c.aU(this.lpI.getPageContext().getPageActivity(), this.lEq.getText().toString()));
                        this.lEq.setGravity(16);
                        this.lEq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhU());
                        ap.setViewTextColor(this.lEq, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bmA.getIconInfo();
                tShowInfoNew = bmA.getTShowInfoNew();
                if (this.lrZ != null) {
                }
                if (this.lrY != null) {
                }
                this.lEq.setText(dT(bmA.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lEq.setTag(R.id.tag_user_id, bmA.getUserId());
                this.lEq.setTag(R.id.tag_user_name, bmA.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lEq, R.color.cp_cont_h, 1);
                if (!fVar.diN()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.diN()) {
                }
                z = false;
                if (fVar.dik().bmA() != null) {
                    doO();
                    z = true;
                }
                this.lEt.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lEt.setVisibility(0);
                if (this.lEy != null) {
                }
                this.lEq.setOnClickListener(onClickListener);
                this.lEt.getHeadView().setUserId(bmA.getUserId());
                this.lEt.getHeadView().setUserName(bmA.getUserName());
                this.lEt.getHeadView().setTid(postData.getId());
                this.lEt.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lEt.getHeadView().setFName(fVar.getForumName());
                this.lEt.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bmA.getName_show();
                String userName2 = bmA.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lEq.setText(com.baidu.tieba.pb.c.aU(this.lpI.getPageContext().getPageActivity(), this.lEq.getText().toString()));
                    this.lEq.setGravity(16);
                    this.lEq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhU());
                    ap.setViewTextColor(this.lEq, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bmA.getIconInfo();
                    tShowInfoNew = bmA.getTShowInfoNew();
                    if (this.lrZ != null) {
                    }
                    if (this.lrY != null) {
                    }
                    this.lEq.setText(dT(bmA.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lEq.setTag(R.id.tag_user_id, bmA.getUserId());
                    this.lEq.setTag(R.id.tag_user_name, bmA.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.lEq, R.color.cp_cont_h, 1);
                    if (!fVar.diN()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.diN()) {
                    }
                    z = false;
                    if (fVar.dik().bmA() != null) {
                    }
                    this.lEt.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lEt.setVisibility(0);
                    if (this.lEy != null) {
                    }
                    this.lEq.setOnClickListener(onClickListener);
                    this.lEt.getHeadView().setUserId(bmA.getUserId());
                    this.lEt.getHeadView().setUserName(bmA.getUserName());
                    this.lEt.getHeadView().setTid(postData.getId());
                    this.lEt.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lEt.getHeadView().setFName(fVar.getForumName());
                    this.lEt.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bmA.getName_show();
                    String userName22 = bmA.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bmA.getIconInfo();
                tShowInfoNew = bmA.getTShowInfoNew();
                if (this.lrZ != null) {
                }
                if (this.lrY != null) {
                }
                this.lEq.setText(dT(bmA.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lEq.setTag(R.id.tag_user_id, bmA.getUserId());
                this.lEq.setTag(R.id.tag_user_name, bmA.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lEq, R.color.cp_cont_h, 1);
                if (!fVar.diN()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.diN()) {
                }
                z = false;
                if (fVar.dik().bmA() != null) {
                }
                this.lEt.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lEt.setVisibility(0);
                if (this.lEy != null) {
                }
                this.lEq.setOnClickListener(onClickListener);
                this.lEt.getHeadView().setUserId(bmA.getUserId());
                this.lEt.getHeadView().setUserName(bmA.getUserName());
                this.lEt.getHeadView().setTid(postData.getId());
                this.lEt.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lEt.getHeadView().setFName(fVar.getForumName());
                this.lEt.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bmA.getName_show();
                String userName222 = bmA.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lEn.aG(fVar.dik());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.diQ()) {
                this.lEz.setVisibility(0);
            }
            if (z) {
                this.lEz.setVisibility(8);
                if (fVar != null && fVar.dik() != null && fVar.dik().getBaijiahaoData() != null && fVar.dik().getBaijiahaoData().oriUgcType == 3) {
                    this.lEB.setVisibility(8);
                } else {
                    this.lEB.setVisibility(0);
                }
                this.lEB.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.diI())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bmA().hadConcerned()) {
                this.lEz.setVisibility(8);
                this.lEB.setVisibility(8);
            } else {
                this.lEB.setVisibility(8);
            }
            if (fVar.lmW || 3 == fVar.diQ()) {
                this.lEz.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.bmA() != null) {
                postData.bmA().setIsLike(postData.bmA().hadConcerned());
            }
            if (this.lEA == null) {
                bw dik = fVar.dik();
                int i = 1;
                if (dik != null) {
                    if (dik.bli()) {
                        i = 4;
                    } else if (dik.blj()) {
                        i = 6;
                    } else if (dik.bow()) {
                        i = 7;
                    } else if (dik.bov()) {
                        i = 5;
                    }
                }
                this.lEA = new ax(this.lpI.getPageContext(), this.lEz, i);
                this.lEA.l(this.lpI.getUniqueId());
                this.lEA.setThreadData(dik);
            }
            if (postData != null && postData.bmA() != null) {
                postData.bmA().setIsLike(postData.bmA().hadConcerned());
                this.lEA.a(postData.bmA());
                this.lEA.setTid(threadId);
            }
            this.lEA.lAR = z2;
            this.lEA.Gg(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bmW() != null) {
                this.lEp.setData(this.lpI.getPageContext(), fVar.dim().get(0).bmW(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dik().getId(), this.lpI.bki() ? "FRS" : null));
                this.lEo.setPadding(this.lEo.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lEo.getPaddingRight(), this.lEo.getPaddingBottom());
                return;
            }
            this.lEp.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lpI.djq()) {
            this.lEG = 0;
            if (postData != null && postData.bmA() != null) {
                this.lEG = postData.bmA().getLevel_id();
            }
            if (this.lEG > 0 && !z) {
                this.lEs.setVisibility(0);
                ap.setImageResource(this.lEs, BitmapHelper.getGradeResourceIdInEnterForum(this.lEG));
                return;
            }
            this.lEs.setVisibility(8);
            return;
        }
        this.lEs.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diK()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lEo.getPaddingBottom();
            if (fVar.diN()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lEo.setPadding(this.lEo.getPaddingLeft(), dimens, this.lEo.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.lEo.getPaddingBottom();
        if (fVar != null && !fVar.dik().blg() && fVar.diN() && (!StringUtils.isNull(fVar.dik().getTitle()) || fVar.dik().bnk() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lEo.setPadding(this.lEo.getPaddingLeft(), dimens2, this.lEo.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lEo.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lEl);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lEl, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lEl);
        }
    }

    public void setVisibility(int i) {
        this.lEo.setVisibility(i);
    }

    private void doO() {
        if (this.lEu != null) {
            this.lEu.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lEu.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.lpI.dle(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.lpI.dle(), R.dimen.ds8);
            this.lEu.setLayoutParams(layoutParams);
            this.lEu.loop(true);
            this.lEu.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lEu.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lmX) {
            this.lEm.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lEm.setVisibility(0);
        } else if (z && z2) {
            this.lEm.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lEm.setVisibility(0);
        } else if (z) {
            this.lEm.setImageResource(R.drawable.pic_pb_refined_n);
            this.lEm.setVisibility(0);
        } else if (z2) {
            this.lEm.setImageResource(R.drawable.pic_pb_stick_n);
            this.lEm.setVisibility(0);
        } else {
            this.lEm.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return n.a((Context) this.lpI.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> doP() {
        SparseArray<Object> sparseArray = (SparseArray) this.lEo.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lEo.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView djJ() {
        return this.lEn.djJ();
    }

    public void tY(boolean z) {
        this.lEn.tY(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lEs != null) {
            ap.setImageResource(this.lEs, BitmapHelper.getGradeResourceIdInEnterForum(this.lEG));
        }
        if (this.lEz != null) {
            this.lEz.onChangeSkinType(i);
        }
        if (this.lED != null) {
            ap.setViewTextColor(this.lED, R.color.cp_cont_d);
        }
        if (this.lEC != null) {
            ap.setViewTextColor(this.lEC, R.color.cp_cont_d);
        }
        if (this.lEB != null) {
            ap.setViewTextColor(this.lEB, R.color.cp_cont_d);
        }
        if (this.lEF != null) {
            ap.setViewTextColor(this.lEF, R.color.cp_cont_d);
        }
        if (this.lEE != null) {
            ap.setViewTextColor(this.lEE, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.lEu != null) {
                this.lEu.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lEu != null) {
                this.lEu.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lEu != null) {
            this.lEu.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lEk != null) {
            this.lEk.SR();
        }
        if (this.lEo != null && this.lEy != null) {
            this.lEo.removeView(this.lEv);
            this.lEy = null;
        }
        if (this.lEu != null) {
            this.lEu.cancelAnimation();
        }
    }

    public void dob() {
        if (this.lEk != null) {
            this.lEk.SR();
        }
    }
}
