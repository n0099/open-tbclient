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
/* loaded from: classes16.dex */
public class d {
    private LayerDrawable aiP;
    private LayerDrawable aiQ;
    private com.baidu.tieba.pb.a.c eFf;
    private View.OnClickListener hVB;
    private UserIconBox kBI;
    private UserIconBox kBJ;
    private com.baidu.tieba.c.e kNQ;
    private ImageView kNS;
    private f kNT;
    private ThreadSkinView kNV;
    private ImageView kNY;
    private HeadPendantView kNZ;
    private TBLottieAnimationView kOa;
    private LinearLayout kOc;
    private LinearLayout kOd;
    private ax kOg;
    private PbFragment kzt;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kNR = null;
    private ColumnLayout kNU = null;
    private TextView kNW = null;
    private TextView kNX = null;
    private FrameLayout kOb = null;
    private ClickableHeaderImageView kOe = null;
    private PbFirstFloorUserLikeButton kOf = null;
    private TextView kOh = null;
    private TextView kOi = null;
    private TextView kOj = null;
    private TextView kOk = null;
    private int kOl = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hVB = null;
        this.kzt = pbFragment;
        this.eFf = cVar;
        this.hVB = onClickListener;
        int dimens = l.getDimens(this.kzt.getContext(), R.dimen.tbds6);
        this.aiP = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).Aw("#4D000000").bjT()});
        this.aiQ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).Aw("#4D000000").bjT()});
        initView();
    }

    private void initView() {
        this.kNR = (RelativeLayout) LayoutInflater.from(this.kzt.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kNS = (ImageView) this.kNR.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kNS.getLayoutParams().height = ay.dai();
        this.kNT = new f(this.kzt.getBaseFragmentActivity(), this.kNR);
        this.kNT.init();
        this.kNT.setOnClickListener(this.kNT.cWN(), this.hVB);
        this.kNU = (ColumnLayout) this.kNR.findViewById(R.id.pb_head_owner_root);
        this.kNV = (ThreadSkinView) this.kNR.findViewById(R.id.pb_thread_skin);
        this.kNW = (TextView) this.kNU.findViewById(R.id.pb_head_owner_info_user_name);
        this.kNX = (TextView) this.kNU.findViewById(R.id.floor_owner);
        this.kNY = (ImageView) this.kNU.findViewById(R.id.icon_forum_level);
        this.kOb = (FrameLayout) this.kNU.findViewById(R.id.pb_head_headImage_container);
        this.kNZ = (HeadPendantView) this.kNU.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kNZ.setHasPendantStyle();
        this.kOa = (TBLottieAnimationView) this.kNU.findViewById(R.id.pb_head_living_lottie);
        this.kNU.setOnLongClickListener(this.mOnLongClickListener);
        this.kNU.setOnTouchListener(this.eFf);
        this.kNU.setVisibility(8);
        if (this.kNZ.getHeadView() != null) {
            this.kNZ.getHeadView().setIsRound(true);
            this.kNZ.getHeadView().setDrawBorder(false);
            this.kNZ.getHeadView().setPlaceHolder(1);
        }
        this.kBI = (UserIconBox) this.kNU.findViewById(R.id.show_icon_vip);
        this.kBJ = (UserIconBox) this.kNU.findViewById(R.id.show_icon_yinji);
        this.kOc = (LinearLayout) this.kNR.findViewById(R.id.pb_head_owner_info_root);
        this.kOd = (LinearLayout) this.kNU.findViewById(R.id.pb_first_floor_location_container);
        this.kOf = (PbFirstFloorUserLikeButton) this.kNU.findViewById(R.id.pb_like_button);
        this.kOh = (TextView) this.kNU.findViewById(R.id.pb_views);
        this.kOi = (TextView) this.kNU.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kOj = (TextView) this.kNU.findViewById(R.id.pb_item_first_floor_location_address);
        this.kOk = (TextView) this.kNU.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dbP() {
        return this.kNR;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x051a  */
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
        if (postData != null && postData.beE() != null) {
            MetaData beE = postData.beE();
            String string = beE.getName_show() == null ? StringUtils.string(beE.getUserName()) : StringUtils.string(beE.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.beE().getSealPrefix())) {
                i2 = k.byteLength(beE.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = beE.getIconInfo();
                    tShowInfoNew = beE.getTShowInfoNew();
                    if (this.kBJ != null) {
                        this.kBJ.setTag(R.id.tag_user_id, beE.getUserId());
                        if (this.kzt.cYi() != null) {
                            this.kBJ.setOnClickListener(this.kzt.cYi().kzF.kPE);
                        }
                        this.kBJ.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kBI != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kBI.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kzt.cYi() != null) {
                            this.kBI.setOnClickListener(this.kzt.cYi().kzF.kPF);
                        }
                        this.kBI.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kNW.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kNW.setTag(R.id.tag_user_id, beE.getUserId());
                    this.kNW.setTag(R.id.tag_user_name, beE.getName_show());
                    if (y.isEmpty(tShowInfoNew) || beE.isBigV()) {
                        ap.setViewTextColor(this.kNW, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.kNW, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cVO()) {
                        this.kNX.setVisibility(8);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                        this.kNX.setText(R.string.bawu_member_bazhu_tip);
                        this.kNX.setVisibility(0);
                        if (i == 1) {
                            if (this.aiP.getDrawable(1) != null) {
                                this.aiP.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiP.getDrawable(1) != null) {
                            this.aiP.getDrawable(1).setAlpha(0);
                        }
                        this.kNX.setBackgroundDrawable(this.aiP);
                        ap.setViewTextColor(this.kNX, R.color.cp_cont_a);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                        this.kNX.setText(R.string.bawu_member_xbazhu_tip);
                        this.kNX.setVisibility(0);
                        if (i == 1) {
                            if (this.aiQ.getDrawable(1) != null) {
                                this.aiQ.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiQ.getDrawable(1) != null) {
                            this.aiQ.getDrawable(1).setAlpha(0);
                        }
                        this.kNX.setBackgroundDrawable(this.aiQ);
                        ap.setViewTextColor(this.kNX, R.color.cp_cont_a);
                    } else {
                        this.kNX.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kOi.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kOi.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cVO()) {
                        this.kOj.setVisibility(8);
                        if (this.kOd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kOd.getLayoutParams()).rightMargin = 0;
                        }
                        this.kNU.setSpacingRight(0);
                        String str = null;
                        if (beE.getBaijiahaoInfo() != null) {
                            str = beE.getBaijiahaoInfo().auth_desc;
                        }
                        if (beE.isNewGod()) {
                            this.kOk.setVisibility(0);
                            this.kOk.setText(beE.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (beE.showBazhuGrade()) {
                            this.kOk.setVisibility(0);
                            this.kOk.setText(at.cutChineseAndEnglishWithSuffix(beE.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.kOk.setVisibility(0);
                            this.kOk.setText(str);
                        } else {
                            this.kOk.setVisibility(8);
                        }
                    } else {
                        if (beE.isNewGod()) {
                            this.kOk.setVisibility(0);
                            this.kOk.setText(beE.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (beE.showBazhuGrade()) {
                            this.kOk.setVisibility(0);
                            this.kOk.setText(at.cutChineseAndEnglishWithSuffix(beE.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.kOk.setVisibility(8);
                        }
                        if (this.kOd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kOd.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kNU.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dwI = postData.dwI();
                        if (dwI != null && !TextUtils.isEmpty(dwI.getName()) && !TextUtils.isEmpty(dwI.getName().trim())) {
                            this.kOj.setVisibility(0);
                            this.kOj.setText(dwI.getName());
                        } else {
                            this.kOj.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.cVl().beE() != null && fVar.cVl().beE().getAlaInfo() != null && fVar.cVl().beE().getAlaInfo().live_status == 1) {
                        dbQ();
                        z = true;
                    }
                    this.kNZ.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kNZ.a(beE, 4);
                        this.kNZ.setIsclearmode(false);
                    } else {
                        this.kNZ.setIsclearmode(true);
                    }
                    this.kNZ.setVisibility(0);
                    if (this.kOe != null) {
                        this.kOe.setVisibility(8);
                    }
                    this.kNW.setOnClickListener(onClickListener);
                    this.kNZ.getHeadView().setUserId(beE.getUserId());
                    this.kNZ.getHeadView().setUserName(beE.getUserName());
                    this.kNZ.getHeadView().setTid(postData.getId());
                    this.kNZ.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kNZ.getHeadView().setFName(fVar.getForumName());
                    this.kNZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kNZ.AA(beE.getAvater());
                    } else {
                        this.kNZ.a(beE);
                    }
                    String name_show = beE.getName_show();
                    String userName = beE.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kNW.setText(com.baidu.tieba.pb.c.aN(this.kzt.getPageContext().getPageActivity(), this.kNW.getText().toString()));
                        this.kNW.setGravity(16);
                        this.kNW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUV());
                        ap.setViewTextColor(this.kNW, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = beE.getIconInfo();
                tShowInfoNew = beE.getTShowInfoNew();
                if (this.kBJ != null) {
                }
                if (this.kBI != null) {
                }
                this.kNW.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kNW.setTag(R.id.tag_user_id, beE.getUserId());
                this.kNW.setTag(R.id.tag_user_name, beE.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kNW, R.color.cp_cont_h, 1);
                if (!fVar.cVO()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cVO()) {
                }
                z = false;
                if (fVar.cVl().beE() != null) {
                    dbQ();
                    z = true;
                }
                this.kNZ.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kNZ.setVisibility(0);
                if (this.kOe != null) {
                }
                this.kNW.setOnClickListener(onClickListener);
                this.kNZ.getHeadView().setUserId(beE.getUserId());
                this.kNZ.getHeadView().setUserName(beE.getUserName());
                this.kNZ.getHeadView().setTid(postData.getId());
                this.kNZ.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kNZ.getHeadView().setFName(fVar.getForumName());
                this.kNZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = beE.getName_show();
                String userName2 = beE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kNW.setText(com.baidu.tieba.pb.c.aN(this.kzt.getPageContext().getPageActivity(), this.kNW.getText().toString()));
                    this.kNW.setGravity(16);
                    this.kNW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUV());
                    ap.setViewTextColor(this.kNW, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = beE.getIconInfo();
                    tShowInfoNew = beE.getTShowInfoNew();
                    if (this.kBJ != null) {
                    }
                    if (this.kBI != null) {
                    }
                    this.kNW.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kNW.setTag(R.id.tag_user_id, beE.getUserId());
                    this.kNW.setTag(R.id.tag_user_name, beE.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.kNW, R.color.cp_cont_h, 1);
                    if (!fVar.cVO()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.cVO()) {
                    }
                    z = false;
                    if (fVar.cVl().beE() != null) {
                    }
                    this.kNZ.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kNZ.setVisibility(0);
                    if (this.kOe != null) {
                    }
                    this.kNW.setOnClickListener(onClickListener);
                    this.kNZ.getHeadView().setUserId(beE.getUserId());
                    this.kNZ.getHeadView().setUserName(beE.getUserName());
                    this.kNZ.getHeadView().setTid(postData.getId());
                    this.kNZ.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kNZ.getHeadView().setFName(fVar.getForumName());
                    this.kNZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = beE.getName_show();
                    String userName22 = beE.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = beE.getIconInfo();
                tShowInfoNew = beE.getTShowInfoNew();
                if (this.kBJ != null) {
                }
                if (this.kBI != null) {
                }
                this.kNW.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kNW.setTag(R.id.tag_user_id, beE.getUserId());
                this.kNW.setTag(R.id.tag_user_name, beE.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kNW, R.color.cp_cont_h, 1);
                if (!fVar.cVO()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cVO()) {
                }
                z = false;
                if (fVar.cVl().beE() != null) {
                }
                this.kNZ.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kNZ.setVisibility(0);
                if (this.kOe != null) {
                }
                this.kNW.setOnClickListener(onClickListener);
                this.kNZ.getHeadView().setUserId(beE.getUserId());
                this.kNZ.getHeadView().setUserName(beE.getUserName());
                this.kNZ.getHeadView().setTid(postData.getId());
                this.kNZ.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kNZ.getHeadView().setFName(fVar.getForumName());
                this.kNZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = beE.getName_show();
                String userName222 = beE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.kNT.aF(fVar.cVl());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cVR()) {
                this.kOf.setVisibility(0);
            }
            if (z) {
                this.kOf.setVisibility(8);
                if (fVar != null && fVar.cVl() != null && fVar.cVl().getBaijiahaoData() != null && fVar.cVl().getBaijiahaoData().oriUgcType == 3) {
                    this.kOh.setVisibility(8);
                } else {
                    this.kOh.setVisibility(0);
                }
                this.kOh.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.cVJ())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.beE().hadConcerned()) {
                this.kOf.setVisibility(8);
                this.kOh.setVisibility(8);
            } else {
                this.kOh.setVisibility(8);
            }
            if (fVar.kwK || 3 == fVar.cVR()) {
                this.kOf.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.beE() != null) {
                postData.beE().setIsLike(postData.beE().hadConcerned());
            }
            if (this.kOg == null) {
                bw cVl = fVar.cVl();
                int i = 1;
                if (cVl != null) {
                    if (cVl.bdm()) {
                        i = 4;
                    } else if (cVl.bdn()) {
                        i = 6;
                    } else if (cVl.bgA()) {
                        i = 7;
                    } else if (cVl.bgz()) {
                        i = 5;
                    }
                }
                this.kOg = new ax(this.kzt.getPageContext(), this.kOf, i);
                this.kOg.m(this.kzt.getUniqueId());
                this.kOg.setThreadData(cVl);
            }
            if (postData != null && postData.beE() != null) {
                postData.beE().setIsLike(postData.beE().hadConcerned());
                this.kOg.a(postData.beE());
                this.kOg.setTid(threadId);
            }
            this.kOg.kKx = z2;
            this.kOg.Et(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bfa() != null) {
                this.kNV.setData(this.kzt.getPageContext(), fVar.cVn().get(0).bfa(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.cVl().getId(), this.kzt.bcm() ? "FRS" : null));
                this.kNU.setPadding(this.kNU.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kNU.getPaddingRight(), this.kNU.getPaddingBottom());
                return;
            }
            this.kNV.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kzt.cWt()) {
            this.kOl = 0;
            if (postData != null && postData.beE() != null) {
                this.kOl = postData.beE().getLevel_id();
            }
            if (this.kOl > 0 && !z) {
                this.kNY.setVisibility(0);
                ap.setImageResource(this.kNY, BitmapHelper.getGradeResourceIdInEnterForum(this.kOl));
                return;
            }
            this.kNY.setVisibility(8);
            return;
        }
        this.kNY.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVL()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kNU.getPaddingBottom();
            if (fVar.cVO()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kNU.setPadding(this.kNU.getPaddingLeft(), dimens, this.kNU.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kNU.getPaddingBottom();
        if (fVar != null && !fVar.cVl().bdk() && fVar.cVO() && (!StringUtils.isNull(fVar.cVl().getTitle()) || fVar.cVl().bfo() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kNU.setPadding(this.kNU.getPaddingLeft(), dimens2, this.kNU.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kNU.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kNR);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kNR, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kNR);
        }
    }

    public void setVisibility(int i) {
        this.kNU.setVisibility(i);
    }

    private void dbQ() {
        if (this.kOa != null) {
            this.kOa.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kOa.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kzt.cYi(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kzt.cYi(), R.dimen.ds8);
            this.kOa.setLayoutParams(layoutParams);
            this.kOa.loop(true);
            this.kOa.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kOa.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kwL) {
            this.kNS.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kNS.setVisibility(0);
        } else if (z && z2) {
            this.kNS.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kNS.setVisibility(0);
        } else if (z) {
            this.kNS.setImageResource(R.drawable.pic_pb_refined_n);
            this.kNS.setVisibility(0);
        } else if (z2) {
            this.kNS.setImageResource(R.drawable.pic_pb_stick_n);
            this.kNS.setVisibility(0);
        } else {
            this.kNS.setVisibility(8);
        }
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kzt.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dbR() {
        SparseArray<Object> sparseArray = (SparseArray) this.kNU.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kNU.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cWN() {
        return this.kNT.cWN();
    }

    public void sI(boolean z) {
        this.kNT.sI(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kNY != null) {
            ap.setImageResource(this.kNY, BitmapHelper.getGradeResourceIdInEnterForum(this.kOl));
        }
        if (this.kOf != null) {
            this.kOf.onChangeSkinType(i);
        }
        if (this.kOj != null) {
            ap.setViewTextColor(this.kOj, R.color.cp_cont_d);
        }
        if (this.kOi != null) {
            ap.setViewTextColor(this.kOi, R.color.cp_cont_d);
        }
        if (this.kOh != null) {
            ap.setViewTextColor(this.kOh, R.color.cp_cont_d);
        }
        if (this.kOk != null) {
            ap.setViewTextColor(this.kOk, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kOa != null) {
                this.kOa.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kOa != null) {
                this.kOa.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kOa != null) {
            this.kOa.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kNQ != null) {
            this.kNQ.NG();
        }
        if (this.kNU != null && this.kOe != null) {
            this.kNU.removeView(this.kOb);
            this.kOe = null;
        }
        if (this.kOa != null) {
            this.kOa.cancelAnimation();
        }
    }

    public void dbe() {
        if (this.kNQ != null) {
            this.kNQ.NG();
        }
    }
}
