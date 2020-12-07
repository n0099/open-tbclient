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
    private View.OnClickListener iVH;
    private PbFragment lDG;
    private UserIconBox lFT;
    private UserIconBox lFU;
    private ImageView lSA;
    private HeadPendantView lSB;
    private TBLottieAnimationView lSC;
    private LinearLayout lSE;
    private LinearLayout lSF;
    private ax lSI;
    private com.baidu.tieba.d.e lSs;
    private ImageView lSu;
    private com.baidu.tieba.pb.pb.main.f lSv;
    private ThreadSkinView lSx;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lSt = null;
    private ColumnLayout lSw = null;
    private TextView lSy = null;
    private TextView lSz = null;
    private FrameLayout lSD = null;
    private ClickableHeaderImageView lSG = null;
    private PbFirstFloorUserLikeButton lSH = null;
    private TextView lSJ = null;
    private TextView lSK = null;
    private TextView lSL = null;
    private TextView lSM = null;
    private TextView lSN = null;
    private int lSO = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.iVH = null;
        this.lDG = pbFragment;
        this.fos = cVar;
        this.iVH = onClickListener;
        initView();
    }

    private void initView() {
        this.lSt = (RelativeLayout) LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lSu = (ImageView) this.lSt.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lSu.getLayoutParams().height = ay.drU();
        this.lSv = new com.baidu.tieba.pb.pb.main.f(this.lDG.getBaseFragmentActivity(), this.lSt);
        this.lSv.init();
        this.lSv.setOnClickListener(this.lSv.dou(), this.iVH);
        this.lSw = (ColumnLayout) this.lSt.findViewById(R.id.pb_head_owner_root);
        this.lSx = (ThreadSkinView) this.lSt.findViewById(R.id.pb_thread_skin);
        this.lSy = (TextView) this.lSw.findViewById(R.id.pb_head_owner_info_user_name);
        this.lSz = (TextView) this.lSw.findViewById(R.id.floor_owner);
        this.lSA = (ImageView) this.lSw.findViewById(R.id.icon_forum_level);
        this.lSD = (FrameLayout) this.lSw.findViewById(R.id.pb_head_headImage_container);
        this.lSB = (HeadPendantView) this.lSw.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lSB.setHasPendantStyle();
        this.lSC = (TBLottieAnimationView) this.lSw.findViewById(R.id.pb_head_living_lottie);
        this.lSw.setOnLongClickListener(this.mOnLongClickListener);
        this.lSw.setOnTouchListener(this.fos);
        this.lSw.setVisibility(8);
        if (this.lSB.getHeadView() != null) {
            this.lSB.getHeadView().setIsRound(true);
            this.lSB.getHeadView().setDrawBorder(true);
            this.lSB.getHeadView().setPlaceHolder(1);
        }
        this.lFT = (UserIconBox) this.lSw.findViewById(R.id.show_icon_vip);
        this.lFU = (UserIconBox) this.lSw.findViewById(R.id.show_icon_yinji);
        this.lSE = (LinearLayout) this.lSt.findViewById(R.id.pb_head_owner_info_root);
        this.lSF = (LinearLayout) this.lSw.findViewById(R.id.pb_first_floor_location_container);
        this.lSH = (PbFirstFloorUserLikeButton) this.lSw.findViewById(R.id.pb_like_button);
        this.lSJ = (TextView) this.lSw.findViewById(R.id.pb_views);
        this.lSK = (TextView) this.lSw.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lSL = (TextView) this.lSw.findViewById(R.id.pb_item_first_floor_location_address);
        this.lSM = (TextView) this.lSw.findViewById(R.id.pb_item_first_floor_distance);
        this.lSN = (TextView) this.lSw.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dtD() {
        return this.lSt;
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
                    if (this.lFU != null) {
                        this.lFU.setTag(R.id.tag_user_id, boP.getUserId());
                        if (this.lDG.dpQ() != null) {
                            this.lFU.setOnClickListener(this.lDG.dpQ().lDS.lUk);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lFU.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lFT != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lFT.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lDG.dpQ() != null) {
                            this.lFT.setOnClickListener(this.lDG.dpQ().lDS.lUl);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lFT.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lSy.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lSy.setTag(R.id.tag_user_id, boP.getUserId());
                    this.lSy.setTag(R.id.tag_user_name, boP.getName_show());
                    if (y.isEmpty(tShowInfoNew) || boP.isBigV()) {
                        ap.setViewTextColor(this.lSy, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.lSy, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dnx()) {
                        this.lSz.setVisibility(8);
                    } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                        this.lSz.setText(R.string.bawu_member_bazhu_tip);
                        this.lSz.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bm(this.lSz).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                        this.lSz.setText(R.string.bawu_member_xbazhu_tip);
                        this.lSz.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bm(this.lSz).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lSz.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lSK.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lSK.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dnx()) {
                        this.lSL.setVisibility(8);
                        if (this.lSF.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lSF.getLayoutParams()).rightMargin = 0;
                        }
                        this.lSw.setSpacingRight(0);
                        String str = null;
                        if (boP.getBaijiahaoInfo() != null) {
                            str = boP.getBaijiahaoInfo().auth_desc;
                        }
                        if (boP.isNewGod()) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(boP.getNewGodData().getFieldName() + ah.lf(boP.isVideoGod()));
                        } else if (boP.showBazhuGrade()) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(au.cutChineseAndEnglishWithSuffix(boP.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(str);
                        } else {
                            this.lSN.setVisibility(8);
                        }
                    } else {
                        if (boP.isNewGod()) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(boP.getNewGodData().getFieldName() + ah.sV(boP.getNewGodData().getType()));
                        } else if (boP.showBazhuGrade()) {
                            this.lSN.setVisibility(0);
                            this.lSN.setText(au.cutChineseAndEnglishWithSuffix(boP.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lSN.setVisibility(8);
                        }
                        if (this.lSF.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lSF.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lSw.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        g dPj = postData.dPj();
                        if (dPj != null && !TextUtils.isEmpty(dPj.getName()) && !TextUtils.isEmpty(dPj.getName().trim())) {
                            this.lSL.setVisibility(0);
                            this.lSL.setText(dPj.getName());
                        } else {
                            this.lSL.setVisibility(8);
                        }
                        if (dPj != null && !TextUtils.isEmpty(dPj.getDistance())) {
                            this.lSM.setText(dPj.getDistance());
                            this.lSM.setVisibility(0);
                            final int measureText = (int) this.lSM.getPaint().measureText(dPj.getDistance(), 0, dPj.getDistance().length());
                            this.lSF.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lSF.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lSK.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lSN.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lSM.setVisibility(8);
                                        d.this.lSL.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lSL.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lSM.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dmT().boP() != null && fVar.dmT().boP().getAlaInfo() != null && fVar.dmT().boP().getAlaInfo().live_status == 1) {
                        dtE();
                        z = true;
                    }
                    this.lSB.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lSB.a(boP, 4);
                        this.lSB.setIsclearmode(false);
                    } else {
                        this.lSB.setIsclearmode(true);
                    }
                    this.lSB.setVisibility(0);
                    if (this.lSG != null) {
                        this.lSG.setVisibility(8);
                    }
                    this.lSy.setOnClickListener(onClickListener);
                    this.lSB.getHeadView().setUserId(boP.getUserId());
                    this.lSB.getHeadView().setUserName(boP.getUserName());
                    this.lSB.getHeadView().setTid(postData.getId());
                    this.lSB.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lSB.getHeadView().setFName(fVar.getForumName());
                    this.lSB.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lSB.Cx(boP.getAvater());
                    } else {
                        this.lSB.a(boP);
                    }
                    String name_show = boP.getName_show();
                    String userName = boP.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lSy.setText(com.baidu.tieba.pb.c.aV(this.lDG.getPageContext().getPageActivity(), this.lSy.getText().toString()));
                        this.lSy.setGravity(16);
                        this.lSy.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmD());
                        ap.setViewTextColor(this.lSy, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = boP.getIconInfo();
                tShowInfoNew = boP.getTShowInfoNew();
                if (this.lFU != null) {
                }
                if (this.lFT != null) {
                }
                this.lSy.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lSy.setTag(R.id.tag_user_id, boP.getUserId());
                this.lSy.setTag(R.id.tag_user_name, boP.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lSy, R.color.CAM_X0301, 1);
                if (!fVar.dnx()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dnx()) {
                }
                z = false;
                if (fVar.dmT().boP() != null) {
                    dtE();
                    z = true;
                }
                this.lSB.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lSB.setVisibility(0);
                if (this.lSG != null) {
                }
                this.lSy.setOnClickListener(onClickListener);
                this.lSB.getHeadView().setUserId(boP.getUserId());
                this.lSB.getHeadView().setUserName(boP.getUserName());
                this.lSB.getHeadView().setTid(postData.getId());
                this.lSB.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lSB.getHeadView().setFName(fVar.getForumName());
                this.lSB.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = boP.getName_show();
                String userName2 = boP.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lSy.setText(com.baidu.tieba.pb.c.aV(this.lDG.getPageContext().getPageActivity(), this.lSy.getText().toString()));
                    this.lSy.setGravity(16);
                    this.lSy.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmD());
                    ap.setViewTextColor(this.lSy, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = boP.getIconInfo();
                    tShowInfoNew = boP.getTShowInfoNew();
                    if (this.lFU != null) {
                    }
                    if (this.lFT != null) {
                    }
                    this.lSy.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lSy.setTag(R.id.tag_user_id, boP.getUserId());
                    this.lSy.setTag(R.id.tag_user_name, boP.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.lSy, R.color.CAM_X0301, 1);
                    if (!fVar.dnx()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dnx()) {
                    }
                    z = false;
                    if (fVar.dmT().boP() != null) {
                    }
                    this.lSB.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lSB.setVisibility(0);
                    if (this.lSG != null) {
                    }
                    this.lSy.setOnClickListener(onClickListener);
                    this.lSB.getHeadView().setUserId(boP.getUserId());
                    this.lSB.getHeadView().setUserName(boP.getUserName());
                    this.lSB.getHeadView().setTid(postData.getId());
                    this.lSB.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lSB.getHeadView().setFName(fVar.getForumName());
                    this.lSB.getHeadView().setOnClickListener(onClickListener);
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
                if (this.lFU != null) {
                }
                if (this.lFT != null) {
                }
                this.lSy.setText(ea(boP.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lSy.setTag(R.id.tag_user_id, boP.getUserId());
                this.lSy.setTag(R.id.tag_user_name, boP.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lSy, R.color.CAM_X0301, 1);
                if (!fVar.dnx()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dnx()) {
                }
                z = false;
                if (fVar.dmT().boP() != null) {
                }
                this.lSB.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lSB.setVisibility(0);
                if (this.lSG != null) {
                }
                this.lSy.setOnClickListener(onClickListener);
                this.lSB.getHeadView().setUserId(boP.getUserId());
                this.lSB.getHeadView().setUserName(boP.getUserName());
                this.lSB.getHeadView().setTid(postData.getId());
                this.lSB.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lSB.getHeadView().setFName(fVar.getForumName());
                this.lSB.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = boP.getName_show();
                String userName222 = boP.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lSv.aI(fVar.dmT());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dnA()) {
                this.lSH.setVisibility(0);
            }
            if (z) {
                this.lSH.setVisibility(8);
                if (fVar != null && fVar.dmT() != null && fVar.dmT().getBaijiahaoData() != null && fVar.dmT().getBaijiahaoData().oriUgcType == 3) {
                    this.lSJ.setVisibility(8);
                } else {
                    this.lSJ.setVisibility(0);
                }
                this.lSJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dnr())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.boP().hadConcerned()) {
                this.lSH.setVisibility(8);
                this.lSJ.setVisibility(8);
            } else {
                this.lSJ.setVisibility(8);
            }
            if (fVar.lAM || 3 == fVar.dnA()) {
                this.lSH.setVisibility(8);
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
            if (this.lSI == null) {
                by dmT = fVar.dmT();
                int i = 1;
                if (dmT != null) {
                    if (dmT.bnx()) {
                        i = 4;
                    } else if (dmT.bny()) {
                        i = 6;
                    } else if (dmT.bqN()) {
                        i = 7;
                    } else if (dmT.bqM()) {
                        i = 5;
                    }
                }
                this.lSI = new ax(this.lDG.getPageContext(), this.lSH, i);
                this.lSI.l(this.lDG.getUniqueId());
                this.lSI.setThreadData(dmT);
            }
            if (postData != null && postData.boP() != null) {
                postData.boP().setIsLike(postData.boP().hadConcerned());
                this.lSI.a(postData.boP());
                this.lSI.setTid(threadId);
            }
            this.lSI.lOW = z2;
            this.lSI.Hu(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bpl() != null) {
                this.lSx.setData(this.lDG.getPageContext(), fVar.dmV().get(0).bpl(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dmT().getId(), this.lDG.bmu() ? "FRS" : null));
                this.lSw.setPadding(this.lSw.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lSw.getPaddingRight(), this.lSw.getPaddingBottom());
                return;
            }
            this.lSx.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lDG.doc()) {
            this.lSO = 0;
            if (postData != null && postData.boP() != null) {
                this.lSO = postData.boP().getLevel_id();
            }
            if (this.lSO > 0 && !z) {
                this.lSA.setVisibility(0);
                ap.setImageResource(this.lSA, BitmapHelper.getGradeResourceIdInEnterForum(this.lSO));
                return;
            }
            this.lSA.setVisibility(8);
            return;
        }
        this.lSA.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dnu()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lSw.getPaddingBottom();
            if (fVar.dnx()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lSw.setPadding(this.lSw.getPaddingLeft(), dimens, this.lSw.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.lSw.getPaddingBottom();
        if (fVar != null && !fVar.dmT().bnv() && fVar.dnx() && (!StringUtils.isNull(fVar.dmT().getTitle()) || fVar.dmT().bpz() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lSw.setPadding(this.lSw.getPaddingLeft(), dimens2, this.lSw.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lSw.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lSt);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lSt, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lSt);
        }
    }

    public void setVisibility(int i) {
        this.lSw.setVisibility(i);
    }

    private void dtE() {
        if (this.lSC != null) {
            this.lSC.setVisibility(0);
            this.lSC.setSpeed(0.8f);
            this.lSC.loop(true);
            this.lSC.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lSC.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lAN) {
            this.lSu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lSu.setVisibility(0);
        } else if (z && z2) {
            this.lSu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lSu.setVisibility(0);
        } else if (z) {
            this.lSu.setImageResource(R.drawable.pic_pb_refined_n);
            this.lSu.setVisibility(0);
        } else if (z2) {
            this.lSu.setImageResource(R.drawable.pic_pb_stick_n);
            this.lSu.setVisibility(0);
        } else {
            this.lSu.setVisibility(8);
        }
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return n.a((Context) this.lDG.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dtF() {
        SparseArray<Object> sparseArray = (SparseArray) this.lSw.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lSw.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dou() {
        return this.lSv.dou();
    }

    public void uD(boolean z) {
        this.lSv.uD(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lSA != null) {
            ap.setImageResource(this.lSA, BitmapHelper.getGradeResourceIdInEnterForum(this.lSO));
        }
        if (this.lSH != null) {
            this.lSH.onChangeSkinType(i);
        }
        if (this.lSL != null) {
            ap.setViewTextColor(this.lSL, R.color.CAM_X0109);
        }
        if (this.lSK != null) {
            ap.setViewTextColor(this.lSK, R.color.CAM_X0109);
        }
        if (this.lSJ != null) {
            ap.setViewTextColor(this.lSJ, R.color.CAM_X0109);
        }
        if (this.lSN != null) {
            ap.setViewTextColor(this.lSN, R.color.CAM_X0109);
        }
        if (this.lSM != null) {
            ap.setViewTextColor(this.lSM, R.color.CAM_X0109);
        }
        if (i == 4) {
            if (this.lSC != null) {
                this.lSC.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lSC != null) {
                this.lSC.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lSC != null) {
            this.lSC.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lSs != null) {
            this.lSs.UG();
        }
        if (this.lSw != null && this.lSG != null) {
            this.lSw.removeView(this.lSD);
            this.lSG = null;
        }
        if (this.lSC != null) {
            this.lSC.cancelAnimation();
        }
    }

    public void dsR() {
        if (this.lSs != null) {
            this.lSs.UG();
        }
    }
}
