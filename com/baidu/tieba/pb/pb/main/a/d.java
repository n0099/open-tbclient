package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.tieba.pb.a.c fos;
    private View.OnClickListener iVJ;
    private PbFragment lDI;
    private UserIconBox lFV;
    private UserIconBox lFW;
    private ImageView lSC;
    private HeadPendantView lSD;
    private TBLottieAnimationView lSE;
    private LinearLayout lSG;
    private LinearLayout lSH;
    private ax lSK;
    private com.baidu.tieba.d.e lSu;
    private ImageView lSw;
    private com.baidu.tieba.pb.pb.main.f lSx;
    private ThreadSkinView lSz;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lSv = null;
    private ColumnLayout lSy = null;
    private TextView lSA = null;
    private TextView lSB = null;
    private FrameLayout lSF = null;
    private ClickableHeaderImageView lSI = null;
    private PbFirstFloorUserLikeButton lSJ = null;
    private TextView lSL = null;
    private TextView lSM = null;
    private TextView lSN = null;
    private TextView lSO = null;
    private TextView lSP = null;
    private int lSQ = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.iVJ = null;
        this.lDI = pbFragment;
        this.fos = cVar;
        this.iVJ = onClickListener;
        initView();
    }

    private void initView() {
        this.lSv = (RelativeLayout) LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lSw = (ImageView) this.lSv.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lSw.getLayoutParams().height = ay.drV();
        this.lSx = new com.baidu.tieba.pb.pb.main.f(this.lDI.getBaseFragmentActivity(), this.lSv);
        this.lSx.init();
        this.lSx.setOnClickListener(this.lSx.dov(), this.iVJ);
        this.lSy = (ColumnLayout) this.lSv.findViewById(R.id.pb_head_owner_root);
        this.lSz = (ThreadSkinView) this.lSv.findViewById(R.id.pb_thread_skin);
        this.lSA = (TextView) this.lSy.findViewById(R.id.pb_head_owner_info_user_name);
        this.lSB = (TextView) this.lSy.findViewById(R.id.floor_owner);
        this.lSC = (ImageView) this.lSy.findViewById(R.id.icon_forum_level);
        this.lSF = (FrameLayout) this.lSy.findViewById(R.id.pb_head_headImage_container);
        this.lSD = (HeadPendantView) this.lSy.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lSD.setHasPendantStyle();
        this.lSE = (TBLottieAnimationView) this.lSy.findViewById(R.id.pb_head_living_lottie);
        this.lSy.setOnLongClickListener(this.mOnLongClickListener);
        this.lSy.setOnTouchListener(this.fos);
        this.lSy.setVisibility(8);
        if (this.lSD.getHeadView() != null) {
            this.lSD.getHeadView().setIsRound(true);
            this.lSD.getHeadView().setDrawBorder(true);
            this.lSD.getHeadView().setPlaceHolder(1);
        }
        this.lFV = (UserIconBox) this.lSy.findViewById(R.id.show_icon_vip);
        this.lFW = (UserIconBox) this.lSy.findViewById(R.id.show_icon_yinji);
        this.lSG = (LinearLayout) this.lSv.findViewById(R.id.pb_head_owner_info_root);
        this.lSH = (LinearLayout) this.lSy.findViewById(R.id.pb_first_floor_location_container);
        this.lSJ = (PbFirstFloorUserLikeButton) this.lSy.findViewById(R.id.pb_like_button);
        this.lSL = (TextView) this.lSy.findViewById(R.id.pb_views);
        this.lSM = (TextView) this.lSy.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lSN = (TextView) this.lSy.findViewById(R.id.pb_item_first_floor_location_address);
        this.lSO = (TextView) this.lSy.findViewById(R.id.pb_item_first_floor_distance);
        this.lSP = (TextView) this.lSy.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dtE() {
        return this.lSv;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0377  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.boP() != null) {
            MetaData boP = postData.boP();
            String string = boP.getName_show() == null ? StringUtils.string(boP.getUserName()) : StringUtils.string(boP.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.boP().getSealPrefix())) {
                i2 = k.byteLength(boP.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = boP.getIconInfo();
                    tShowInfoNew = boP.getTShowInfoNew();
                    if (this.lFW != null) {
                        this.lFW.setTag(R.id.tag_user_id, boP.getUserId());
                        if (this.lDI.dpR() != null) {
                            this.lFW.setOnClickListener(this.lDI.dpR().lDU.lUm);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lFW.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lFV != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lFV.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lDI.dpR() != null) {
                            this.lFV.setOnClickListener(this.lDI.dpR().lDU.lUn);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lFV.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lSA.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lSA.setTag(R.id.tag_user_id, boP.getUserId());
                    this.lSA.setTag(R.id.tag_user_name, boP.getName_show());
                    if (y.isEmpty(tShowInfoNew) || boP.isBigV()) {
                        ap.setViewTextColor(this.lSA, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.lSA, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dny()) {
                        this.lSB.setVisibility(8);
                    } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                        this.lSB.setText(R.string.bawu_member_bazhu_tip);
                        this.lSB.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bm(this.lSB).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                        this.lSB.setText(R.string.bawu_member_xbazhu_tip);
                        this.lSB.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bm(this.lSB).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lSB.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lSM.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lSM.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dny()) {
                        this.lSN.setVisibility(8);
                        if (this.lSH.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lSH.getLayoutParams()).rightMargin = 0;
                        }
                        this.lSy.setSpacingRight(0);
                        String str = null;
                        if (boP.getBaijiahaoInfo() != null) {
                            str = boP.getBaijiahaoInfo().auth_desc;
                        }
                        if (boP.isNewGod()) {
                            this.lSP.setVisibility(0);
                            this.lSP.setText(boP.getNewGodData().getFieldName() + ah.lf(boP.isVideoGod()));
                        } else if (boP.showBazhuGrade()) {
                            this.lSP.setVisibility(0);
                            this.lSP.setText(au.cutChineseAndEnglishWithSuffix(boP.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lSP.setVisibility(0);
                            this.lSP.setText(str);
                        } else {
                            this.lSP.setVisibility(8);
                        }
                    } else {
                        if (boP.isNewGod()) {
                            this.lSP.setVisibility(0);
                            this.lSP.setText(boP.getNewGodData().getFieldName() + ah.sV(boP.getNewGodData().getType()));
                        } else if (boP.showBazhuGrade()) {
                            this.lSP.setVisibility(0);
                            this.lSP.setText(au.cutChineseAndEnglishWithSuffix(boP.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lSP.setVisibility(8);
                        }
                        if (this.lSH.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lSH.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lSy.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        g dPk = postData.dPk();
                        if (dPk != null && !TextUtils.isEmpty(dPk.getName()) && !TextUtils.isEmpty(dPk.getName().trim())) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(dPk.getName());
                        } else {
                            this.lSN.setVisibility(8);
                        }
                        if (dPk != null && !TextUtils.isEmpty(dPk.getDistance())) {
                            this.lSO.setText(dPk.getDistance());
                            this.lSO.setVisibility(0);
                            final int measureText = (int) this.lSO.getPaint().measureText(dPk.getDistance(), 0, dPk.getDistance().length());
                            this.lSH.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lSH.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lSM.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lSP.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lSO.setVisibility(8);
                                        d.this.lSN.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lSN.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lSO.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dmU().boP() != null && fVar.dmU().boP().getAlaInfo() != null && fVar.dmU().boP().getAlaInfo().live_status == 1) {
                        dtF();
                        z = true;
                    }
                    this.lSD.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lSD.a(boP, 4);
                        this.lSD.setIsclearmode(false);
                    } else {
                        this.lSD.setIsclearmode(true);
                    }
                    this.lSD.setVisibility(0);
                    if (this.lSI != null) {
                        this.lSI.setVisibility(8);
                    }
                    this.lSA.setOnClickListener(onClickListener);
                    this.lSD.getHeadView().setUserId(boP.getUserId());
                    this.lSD.getHeadView().setUserName(boP.getUserName());
                    this.lSD.getHeadView().setTid(postData.getId());
                    this.lSD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lSD.getHeadView().setFName(fVar.getForumName());
                    this.lSD.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lSD.Cx(boP.getAvater());
                    } else {
                        this.lSD.a(boP);
                    }
                    String name_show = boP.getName_show();
                    String userName = boP.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lSA.setText(com.baidu.tieba.pb.c.aV(this.lDI.getPageContext().getPageActivity(), this.lSA.getText().toString()));
                        this.lSA.setGravity(16);
                        this.lSA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmE());
                        ap.setViewTextColor(this.lSA, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = boP.getIconInfo();
                tShowInfoNew = boP.getTShowInfoNew();
                if (this.lFW != null) {
                }
                if (this.lFV != null) {
                }
                this.lSA.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lSA.setTag(R.id.tag_user_id, boP.getUserId());
                this.lSA.setTag(R.id.tag_user_name, boP.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lSA, R.color.CAM_X0301, 1);
                if (!fVar.dny()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dny()) {
                }
                z = false;
                if (fVar.dmU().boP() != null) {
                    dtF();
                    z = true;
                }
                this.lSD.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lSD.setVisibility(0);
                if (this.lSI != null) {
                }
                this.lSA.setOnClickListener(onClickListener);
                this.lSD.getHeadView().setUserId(boP.getUserId());
                this.lSD.getHeadView().setUserName(boP.getUserName());
                this.lSD.getHeadView().setTid(postData.getId());
                this.lSD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lSD.getHeadView().setFName(fVar.getForumName());
                this.lSD.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = boP.getName_show();
                String userName2 = boP.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lSA.setText(com.baidu.tieba.pb.c.aV(this.lDI.getPageContext().getPageActivity(), this.lSA.getText().toString()));
                    this.lSA.setGravity(16);
                    this.lSA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmE());
                    ap.setViewTextColor(this.lSA, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = boP.getIconInfo();
                    tShowInfoNew = boP.getTShowInfoNew();
                    if (this.lFW != null) {
                    }
                    if (this.lFV != null) {
                    }
                    this.lSA.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lSA.setTag(R.id.tag_user_id, boP.getUserId());
                    this.lSA.setTag(R.id.tag_user_name, boP.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.lSA, R.color.CAM_X0301, 1);
                    if (!fVar.dny()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dny()) {
                    }
                    z = false;
                    if (fVar.dmU().boP() != null) {
                    }
                    this.lSD.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lSD.setVisibility(0);
                    if (this.lSI != null) {
                    }
                    this.lSA.setOnClickListener(onClickListener);
                    this.lSD.getHeadView().setUserId(boP.getUserId());
                    this.lSD.getHeadView().setUserName(boP.getUserName());
                    this.lSD.getHeadView().setTid(postData.getId());
                    this.lSD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lSD.getHeadView().setFName(fVar.getForumName());
                    this.lSD.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = boP.getName_show();
                    String userName22 = boP.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = boP.getIconInfo();
                tShowInfoNew = boP.getTShowInfoNew();
                if (this.lFW != null) {
                }
                if (this.lFV != null) {
                }
                this.lSA.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lSA.setTag(R.id.tag_user_id, boP.getUserId());
                this.lSA.setTag(R.id.tag_user_name, boP.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lSA, R.color.CAM_X0301, 1);
                if (!fVar.dny()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dny()) {
                }
                z = false;
                if (fVar.dmU().boP() != null) {
                }
                this.lSD.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lSD.setVisibility(0);
                if (this.lSI != null) {
                }
                this.lSA.setOnClickListener(onClickListener);
                this.lSD.getHeadView().setUserId(boP.getUserId());
                this.lSD.getHeadView().setUserName(boP.getUserName());
                this.lSD.getHeadView().setTid(postData.getId());
                this.lSD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lSD.getHeadView().setFName(fVar.getForumName());
                this.lSD.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = boP.getName_show();
                String userName222 = boP.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lSx.aI(fVar.dmU());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dnB()) {
                this.lSJ.setVisibility(0);
            }
            if (z) {
                this.lSJ.setVisibility(8);
                if (fVar != null && fVar.dmU() != null && fVar.dmU().getBaijiahaoData() != null && fVar.dmU().getBaijiahaoData().oriUgcType == 3) {
                    this.lSL.setVisibility(8);
                } else {
                    this.lSL.setVisibility(0);
                }
                this.lSL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dnt())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.boP().hadConcerned()) {
                this.lSJ.setVisibility(8);
                this.lSL.setVisibility(8);
            } else {
                this.lSL.setVisibility(8);
            }
            if (fVar.lAO || 3 == fVar.dnB()) {
                this.lSJ.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.boP() != null) {
                postData.boP().setIsLike(postData.boP().hadConcerned());
            }
            if (this.lSK == null) {
                by dmU = fVar.dmU();
                int i = 1;
                if (dmU != null) {
                    if (dmU.bnx()) {
                        i = 4;
                    } else if (dmU.bny()) {
                        i = 6;
                    } else if (dmU.bqN()) {
                        i = 7;
                    } else if (dmU.bqM()) {
                        i = 5;
                    }
                }
                this.lSK = new ax(this.lDI.getPageContext(), this.lSJ, i);
                this.lSK.l(this.lDI.getUniqueId());
                this.lSK.setThreadData(dmU);
            }
            if (postData != null && postData.boP() != null) {
                postData.boP().setIsLike(postData.boP().hadConcerned());
                this.lSK.a(postData.boP());
                this.lSK.setTid(threadId);
            }
            this.lSK.lOY = z2;
            this.lSK.Hu(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bpl() != null) {
                this.lSz.setData(this.lDI.getPageContext(), fVar.dmW().get(0).bpl(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dmU().getId(), this.lDI.bmu() ? "FRS" : null));
                this.lSy.setPadding(this.lSy.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lSy.getPaddingRight(), this.lSy.getPaddingBottom());
                return;
            }
            this.lSz.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lDI.dod()) {
            this.lSQ = 0;
            if (postData != null && postData.boP() != null) {
                this.lSQ = postData.boP().getLevel_id();
            }
            if (this.lSQ > 0 && !z) {
                this.lSC.setVisibility(0);
                ap.setImageResource(this.lSC, BitmapHelper.getGradeResourceIdInEnterForum(this.lSQ));
                return;
            }
            this.lSC.setVisibility(8);
            return;
        }
        this.lSC.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dnv()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lSy.getPaddingBottom();
            if (fVar.dny()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lSy.setPadding(this.lSy.getPaddingLeft(), dimens, this.lSy.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.lSy.getPaddingBottom();
        if (fVar != null && !fVar.dmU().bnv() && fVar.dny() && (!StringUtils.isNull(fVar.dmU().getTitle()) || fVar.dmU().bpz() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lSy.setPadding(this.lSy.getPaddingLeft(), dimens2, this.lSy.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lSy.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lSv);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lSv, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lSv);
        }
    }

    public void setVisibility(int i) {
        this.lSy.setVisibility(i);
    }

    private void dtF() {
        if (this.lSE != null) {
            this.lSE.setVisibility(0);
            this.lSE.setSpeed(0.8f);
            this.lSE.loop(true);
            this.lSE.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lSE.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lAP) {
            this.lSw.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lSw.setVisibility(0);
        } else if (z && z2) {
            this.lSw.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lSw.setVisibility(0);
        } else if (z) {
            this.lSw.setImageResource(R.drawable.pic_pb_refined_n);
            this.lSw.setVisibility(0);
        } else if (z2) {
            this.lSw.setImageResource(R.drawable.pic_pb_stick_n);
            this.lSw.setVisibility(0);
        } else {
            this.lSw.setVisibility(8);
        }
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return n.a((Context) this.lDI.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dtG() {
        SparseArray<Object> sparseArray = (SparseArray) this.lSy.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lSy.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dov() {
        return this.lSx.dov();
    }

    public void uD(boolean z) {
        this.lSx.uD(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lSC != null) {
            ap.setImageResource(this.lSC, BitmapHelper.getGradeResourceIdInEnterForum(this.lSQ));
        }
        if (this.lSJ != null) {
            this.lSJ.onChangeSkinType(i);
        }
        if (this.lSN != null) {
            ap.setViewTextColor(this.lSN, R.color.CAM_X0109);
        }
        if (this.lSM != null) {
            ap.setViewTextColor(this.lSM, R.color.CAM_X0109);
        }
        if (this.lSL != null) {
            ap.setViewTextColor(this.lSL, R.color.CAM_X0109);
        }
        if (this.lSP != null) {
            ap.setViewTextColor(this.lSP, R.color.CAM_X0109);
        }
        if (this.lSO != null) {
            ap.setViewTextColor(this.lSO, R.color.CAM_X0109);
        }
        if (i == 4) {
            if (this.lSE != null) {
                this.lSE.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lSE != null) {
                this.lSE.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lSE != null) {
            this.lSE.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lSu != null) {
            this.lSu.UG();
        }
        if (this.lSy != null && this.lSI != null) {
            this.lSy.removeView(this.lSF);
            this.lSI = null;
        }
        if (this.lSE != null) {
            this.lSE.cancelAnimation();
        }
    }

    public void dsS() {
        if (this.lSu != null) {
            this.lSu.UG();
        }
    }
}
