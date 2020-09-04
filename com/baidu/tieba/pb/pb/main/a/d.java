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
    private LayerDrawable aiR;
    private LayerDrawable aiS;
    private com.baidu.tieba.pb.a.c eFj;
    private View.OnClickListener hVH;
    private UserIconBox kBP;
    private UserIconBox kBQ;
    private com.baidu.tieba.c.e kNX;
    private ImageView kNZ;
    private f kOa;
    private ThreadSkinView kOc;
    private ImageView kOf;
    private HeadPendantView kOg;
    private TBLottieAnimationView kOh;
    private LinearLayout kOj;
    private LinearLayout kOk;
    private ax kOn;
    private PbFragment kzA;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kNY = null;
    private ColumnLayout kOb = null;
    private TextView kOd = null;
    private TextView kOe = null;
    private FrameLayout kOi = null;
    private ClickableHeaderImageView kOl = null;
    private PbFirstFloorUserLikeButton kOm = null;
    private TextView kOo = null;
    private TextView kOp = null;
    private TextView kOq = null;
    private TextView kOr = null;
    private int kOs = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hVH = null;
        this.kzA = pbFragment;
        this.eFj = cVar;
        this.hVH = onClickListener;
        int dimens = l.getDimens(this.kzA.getContext(), R.dimen.tbds6);
        this.aiR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).Ax("#4D000000").bjT()});
        this.aiS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(dimens).Ax("#4D000000").bjT()});
        initView();
    }

    private void initView() {
        this.kNY = (RelativeLayout) LayoutInflater.from(this.kzA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kNZ = (ImageView) this.kNY.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kNZ.getLayoutParams().height = ay.daj();
        this.kOa = new f(this.kzA.getBaseFragmentActivity(), this.kNY);
        this.kOa.init();
        this.kOa.setOnClickListener(this.kOa.cWO(), this.hVH);
        this.kOb = (ColumnLayout) this.kNY.findViewById(R.id.pb_head_owner_root);
        this.kOc = (ThreadSkinView) this.kNY.findViewById(R.id.pb_thread_skin);
        this.kOd = (TextView) this.kOb.findViewById(R.id.pb_head_owner_info_user_name);
        this.kOe = (TextView) this.kOb.findViewById(R.id.floor_owner);
        this.kOf = (ImageView) this.kOb.findViewById(R.id.icon_forum_level);
        this.kOi = (FrameLayout) this.kOb.findViewById(R.id.pb_head_headImage_container);
        this.kOg = (HeadPendantView) this.kOb.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kOg.setHasPendantStyle();
        this.kOh = (TBLottieAnimationView) this.kOb.findViewById(R.id.pb_head_living_lottie);
        this.kOb.setOnLongClickListener(this.mOnLongClickListener);
        this.kOb.setOnTouchListener(this.eFj);
        this.kOb.setVisibility(8);
        if (this.kOg.getHeadView() != null) {
            this.kOg.getHeadView().setIsRound(true);
            this.kOg.getHeadView().setDrawBorder(false);
            this.kOg.getHeadView().setPlaceHolder(1);
        }
        this.kBP = (UserIconBox) this.kOb.findViewById(R.id.show_icon_vip);
        this.kBQ = (UserIconBox) this.kOb.findViewById(R.id.show_icon_yinji);
        this.kOj = (LinearLayout) this.kNY.findViewById(R.id.pb_head_owner_info_root);
        this.kOk = (LinearLayout) this.kOb.findViewById(R.id.pb_first_floor_location_container);
        this.kOm = (PbFirstFloorUserLikeButton) this.kOb.findViewById(R.id.pb_like_button);
        this.kOo = (TextView) this.kOb.findViewById(R.id.pb_views);
        this.kOp = (TextView) this.kOb.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kOq = (TextView) this.kOb.findViewById(R.id.pb_item_first_floor_location_address);
        this.kOr = (TextView) this.kOb.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dbQ() {
        return this.kNY;
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
                    if (this.kBQ != null) {
                        this.kBQ.setTag(R.id.tag_user_id, beE.getUserId());
                        if (this.kzA.cYj() != null) {
                            this.kBQ.setOnClickListener(this.kzA.cYj().kzM.kPL);
                        }
                        this.kBQ.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kBP != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kBP.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kzA.cYj() != null) {
                            this.kBP.setOnClickListener(this.kzA.cYj().kzM.kPM);
                        }
                        this.kBP.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kOd.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kOd.setTag(R.id.tag_user_id, beE.getUserId());
                    this.kOd.setTag(R.id.tag_user_name, beE.getName_show());
                    if (y.isEmpty(tShowInfoNew) || beE.isBigV()) {
                        ap.setViewTextColor(this.kOd, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.kOd, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cVP()) {
                        this.kOe.setVisibility(8);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                        this.kOe.setText(R.string.bawu_member_bazhu_tip);
                        this.kOe.setVisibility(0);
                        if (i == 1) {
                            if (this.aiR.getDrawable(1) != null) {
                                this.aiR.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiR.getDrawable(1) != null) {
                            this.aiR.getDrawable(1).setAlpha(0);
                        }
                        this.kOe.setBackgroundDrawable(this.aiR);
                        ap.setViewTextColor(this.kOe, R.color.cp_cont_a);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                        this.kOe.setText(R.string.bawu_member_xbazhu_tip);
                        this.kOe.setVisibility(0);
                        if (i == 1) {
                            if (this.aiS.getDrawable(1) != null) {
                                this.aiS.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiS.getDrawable(1) != null) {
                            this.aiS.getDrawable(1).setAlpha(0);
                        }
                        this.kOe.setBackgroundDrawable(this.aiS);
                        ap.setViewTextColor(this.kOe, R.color.cp_cont_a);
                    } else {
                        this.kOe.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kOp.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kOp.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cVP()) {
                        this.kOq.setVisibility(8);
                        if (this.kOk.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kOk.getLayoutParams()).rightMargin = 0;
                        }
                        this.kOb.setSpacingRight(0);
                        String str = null;
                        if (beE.getBaijiahaoInfo() != null) {
                            str = beE.getBaijiahaoInfo().auth_desc;
                        }
                        if (beE.isNewGod()) {
                            this.kOr.setVisibility(0);
                            this.kOr.setText(beE.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (beE.showBazhuGrade()) {
                            this.kOr.setVisibility(0);
                            this.kOr.setText(at.cutChineseAndEnglishWithSuffix(beE.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.kOr.setVisibility(0);
                            this.kOr.setText(str);
                        } else {
                            this.kOr.setVisibility(8);
                        }
                    } else {
                        if (beE.isNewGod()) {
                            this.kOr.setVisibility(0);
                            this.kOr.setText(beE.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (beE.showBazhuGrade()) {
                            this.kOr.setVisibility(0);
                            this.kOr.setText(at.cutChineseAndEnglishWithSuffix(beE.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.kOr.setVisibility(8);
                        }
                        if (this.kOk.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kOk.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kOb.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dwN = postData.dwN();
                        if (dwN != null && !TextUtils.isEmpty(dwN.getName()) && !TextUtils.isEmpty(dwN.getName().trim())) {
                            this.kOq.setVisibility(0);
                            this.kOq.setText(dwN.getName());
                        } else {
                            this.kOq.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.cVm().beE() != null && fVar.cVm().beE().getAlaInfo() != null && fVar.cVm().beE().getAlaInfo().live_status == 1) {
                        dbR();
                        z = true;
                    }
                    this.kOg.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kOg.a(beE, 4);
                        this.kOg.setIsclearmode(false);
                    } else {
                        this.kOg.setIsclearmode(true);
                    }
                    this.kOg.setVisibility(0);
                    if (this.kOl != null) {
                        this.kOl.setVisibility(8);
                    }
                    this.kOd.setOnClickListener(onClickListener);
                    this.kOg.getHeadView().setUserId(beE.getUserId());
                    this.kOg.getHeadView().setUserName(beE.getUserName());
                    this.kOg.getHeadView().setTid(postData.getId());
                    this.kOg.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kOg.getHeadView().setFName(fVar.getForumName());
                    this.kOg.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kOg.AB(beE.getAvater());
                    } else {
                        this.kOg.a(beE);
                    }
                    String name_show = beE.getName_show();
                    String userName = beE.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kOd.setText(com.baidu.tieba.pb.c.aN(this.kzA.getPageContext().getPageActivity(), this.kOd.getText().toString()));
                        this.kOd.setGravity(16);
                        this.kOd.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUW());
                        ap.setViewTextColor(this.kOd, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = beE.getIconInfo();
                tShowInfoNew = beE.getTShowInfoNew();
                if (this.kBQ != null) {
                }
                if (this.kBP != null) {
                }
                this.kOd.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kOd.setTag(R.id.tag_user_id, beE.getUserId());
                this.kOd.setTag(R.id.tag_user_name, beE.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kOd, R.color.cp_cont_h, 1);
                if (!fVar.cVP()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cVP()) {
                }
                z = false;
                if (fVar.cVm().beE() != null) {
                    dbR();
                    z = true;
                }
                this.kOg.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kOg.setVisibility(0);
                if (this.kOl != null) {
                }
                this.kOd.setOnClickListener(onClickListener);
                this.kOg.getHeadView().setUserId(beE.getUserId());
                this.kOg.getHeadView().setUserName(beE.getUserName());
                this.kOg.getHeadView().setTid(postData.getId());
                this.kOg.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kOg.getHeadView().setFName(fVar.getForumName());
                this.kOg.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = beE.getName_show();
                String userName2 = beE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kOd.setText(com.baidu.tieba.pb.c.aN(this.kzA.getPageContext().getPageActivity(), this.kOd.getText().toString()));
                    this.kOd.setGravity(16);
                    this.kOd.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUW());
                    ap.setViewTextColor(this.kOd, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = beE.getIconInfo();
                    tShowInfoNew = beE.getTShowInfoNew();
                    if (this.kBQ != null) {
                    }
                    if (this.kBP != null) {
                    }
                    this.kOd.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kOd.setTag(R.id.tag_user_id, beE.getUserId());
                    this.kOd.setTag(R.id.tag_user_name, beE.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.kOd, R.color.cp_cont_h, 1);
                    if (!fVar.cVP()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.cVP()) {
                    }
                    z = false;
                    if (fVar.cVm().beE() != null) {
                    }
                    this.kOg.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kOg.setVisibility(0);
                    if (this.kOl != null) {
                    }
                    this.kOd.setOnClickListener(onClickListener);
                    this.kOg.getHeadView().setUserId(beE.getUserId());
                    this.kOg.getHeadView().setUserName(beE.getUserName());
                    this.kOg.getHeadView().setTid(postData.getId());
                    this.kOg.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kOg.getHeadView().setFName(fVar.getForumName());
                    this.kOg.getHeadView().setOnClickListener(onClickListener);
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
                if (this.kBQ != null) {
                }
                if (this.kBP != null) {
                }
                this.kOd.setText(dF(beE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kOd.setTag(R.id.tag_user_id, beE.getUserId());
                this.kOd.setTag(R.id.tag_user_name, beE.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.kOd, R.color.cp_cont_h, 1);
                if (!fVar.cVP()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cVP()) {
                }
                z = false;
                if (fVar.cVm().beE() != null) {
                }
                this.kOg.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kOg.setVisibility(0);
                if (this.kOl != null) {
                }
                this.kOd.setOnClickListener(onClickListener);
                this.kOg.getHeadView().setUserId(beE.getUserId());
                this.kOg.getHeadView().setUserName(beE.getUserName());
                this.kOg.getHeadView().setTid(postData.getId());
                this.kOg.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kOg.getHeadView().setFName(fVar.getForumName());
                this.kOg.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = beE.getName_show();
                String userName222 = beE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.kOa.aF(fVar.cVm());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cVS()) {
                this.kOm.setVisibility(0);
            }
            if (z) {
                this.kOm.setVisibility(8);
                if (fVar != null && fVar.cVm() != null && fVar.cVm().getBaijiahaoData() != null && fVar.cVm().getBaijiahaoData().oriUgcType == 3) {
                    this.kOo.setVisibility(8);
                } else {
                    this.kOo.setVisibility(0);
                }
                this.kOo.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.cVK())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.beE().hadConcerned()) {
                this.kOm.setVisibility(8);
                this.kOo.setVisibility(8);
            } else {
                this.kOo.setVisibility(8);
            }
            if (fVar.kwR || 3 == fVar.cVS()) {
                this.kOm.setVisibility(8);
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
            if (this.kOn == null) {
                bw cVm = fVar.cVm();
                int i = 1;
                if (cVm != null) {
                    if (cVm.bdm()) {
                        i = 4;
                    } else if (cVm.bdn()) {
                        i = 6;
                    } else if (cVm.bgA()) {
                        i = 7;
                    } else if (cVm.bgz()) {
                        i = 5;
                    }
                }
                this.kOn = new ax(this.kzA.getPageContext(), this.kOm, i);
                this.kOn.m(this.kzA.getUniqueId());
                this.kOn.setThreadData(cVm);
            }
            if (postData != null && postData.beE() != null) {
                postData.beE().setIsLike(postData.beE().hadConcerned());
                this.kOn.a(postData.beE());
                this.kOn.setTid(threadId);
            }
            this.kOn.kKE = z2;
            this.kOn.Et(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bfa() != null) {
                this.kOc.setData(this.kzA.getPageContext(), fVar.cVo().get(0).bfa(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.cVm().getId(), this.kzA.bcm() ? "FRS" : null));
                this.kOb.setPadding(this.kOb.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kOb.getPaddingRight(), this.kOb.getPaddingBottom());
                return;
            }
            this.kOc.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kzA.cWu()) {
            this.kOs = 0;
            if (postData != null && postData.beE() != null) {
                this.kOs = postData.beE().getLevel_id();
            }
            if (this.kOs > 0 && !z) {
                this.kOf.setVisibility(0);
                ap.setImageResource(this.kOf, BitmapHelper.getGradeResourceIdInEnterForum(this.kOs));
                return;
            }
            this.kOf.setVisibility(8);
            return;
        }
        this.kOf.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVM()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kOb.getPaddingBottom();
            if (fVar.cVP()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kOb.setPadding(this.kOb.getPaddingLeft(), dimens, this.kOb.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kOb.getPaddingBottom();
        if (fVar != null && !fVar.cVm().bdk() && fVar.cVP() && (!StringUtils.isNull(fVar.cVm().getTitle()) || fVar.cVm().bfo() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kOb.setPadding(this.kOb.getPaddingLeft(), dimens2, this.kOb.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kOb.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kNY);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kNY, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kNY);
        }
    }

    public void setVisibility(int i) {
        this.kOb.setVisibility(i);
    }

    private void dbR() {
        if (this.kOh != null) {
            this.kOh.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kOh.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kzA.cYj(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kzA.cYj(), R.dimen.ds8);
            this.kOh.setLayoutParams(layoutParams);
            this.kOh.loop(true);
            this.kOh.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kOh.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kwS) {
            this.kNZ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kNZ.setVisibility(0);
        } else if (z && z2) {
            this.kNZ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kNZ.setVisibility(0);
        } else if (z) {
            this.kNZ.setImageResource(R.drawable.pic_pb_refined_n);
            this.kNZ.setVisibility(0);
        } else if (z2) {
            this.kNZ.setImageResource(R.drawable.pic_pb_stick_n);
            this.kNZ.setVisibility(0);
        } else {
            this.kNZ.setVisibility(8);
        }
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kzA.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dbS() {
        SparseArray<Object> sparseArray = (SparseArray) this.kOb.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kOb.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cWO() {
        return this.kOa.cWO();
    }

    public void sK(boolean z) {
        this.kOa.sK(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kOf != null) {
            ap.setImageResource(this.kOf, BitmapHelper.getGradeResourceIdInEnterForum(this.kOs));
        }
        if (this.kOm != null) {
            this.kOm.onChangeSkinType(i);
        }
        if (this.kOq != null) {
            ap.setViewTextColor(this.kOq, R.color.cp_cont_d);
        }
        if (this.kOp != null) {
            ap.setViewTextColor(this.kOp, R.color.cp_cont_d);
        }
        if (this.kOo != null) {
            ap.setViewTextColor(this.kOo, R.color.cp_cont_d);
        }
        if (this.kOr != null) {
            ap.setViewTextColor(this.kOr, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kOh != null) {
                this.kOh.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kOh != null) {
                this.kOh.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kOh != null) {
            this.kOh.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kNX != null) {
            this.kNX.NG();
        }
        if (this.kOb != null && this.kOl != null) {
            this.kOb.removeView(this.kOi);
            this.kOl = null;
        }
        if (this.kOh != null) {
            this.kOh.cancelAnimation();
        }
    }

    public void dbf() {
        if (this.kNX != null) {
            this.kNX.NG();
        }
    }
}
