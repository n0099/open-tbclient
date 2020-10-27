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
    private com.baidu.tieba.pb.a.c fbT;
    private View.OnClickListener iEe;
    private PbFragment ljH;
    private UserIconBox llX;
    private UserIconBox llY;
    private LinearLayout lyA;
    private LinearLayout lyB;
    private ax lyE;
    private com.baidu.tieba.c.e lyn;
    private ImageView lyq;
    private f lyr;
    private ThreadSkinView lyt;
    private ImageView lyw;
    private HeadPendantView lyx;
    private TBLottieAnimationView lyy;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lyp = null;
    private ColumnLayout lys = null;
    private TextView lyu = null;
    private TextView lyv = null;
    private FrameLayout lyz = null;
    private ClickableHeaderImageView lyC = null;
    private PbFirstFloorUserLikeButton lyD = null;
    private TextView lyF = null;
    private TextView lyG = null;
    private TextView lyH = null;
    private TextView lyI = null;
    private TextView lyJ = null;
    private int lyK = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.iEe = null;
        this.ljH = pbFragment;
        this.fbT = cVar;
        this.iEe = onClickListener;
        int dimens = l.getDimens(this.ljH.getContext(), R.dimen.tbds6);
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(dimens).BY("#4D000000").bpr()});
        this.ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bpr(), com.baidu.tbadk.core.util.e.a.b.bpp().oZ(0).Z(dimens).BY("#4D000000").bpr()});
        initView();
    }

    private void initView() {
        this.lyp = (RelativeLayout) LayoutInflater.from(this.ljH.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lyq = (ImageView) this.lyp.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lyq.getLayoutParams().height = ay.dkC();
        this.lyr = new f(this.ljH.getBaseFragmentActivity(), this.lyp);
        this.lyr.init();
        this.lyr.setOnClickListener(this.lyr.dhh(), this.iEe);
        this.lys = (ColumnLayout) this.lyp.findViewById(R.id.pb_head_owner_root);
        this.lyt = (ThreadSkinView) this.lyp.findViewById(R.id.pb_thread_skin);
        this.lyu = (TextView) this.lys.findViewById(R.id.pb_head_owner_info_user_name);
        this.lyv = (TextView) this.lys.findViewById(R.id.floor_owner);
        this.lyw = (ImageView) this.lys.findViewById(R.id.icon_forum_level);
        this.lyz = (FrameLayout) this.lys.findViewById(R.id.pb_head_headImage_container);
        this.lyx = (HeadPendantView) this.lys.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lyx.setHasPendantStyle();
        this.lyy = (TBLottieAnimationView) this.lys.findViewById(R.id.pb_head_living_lottie);
        this.lys.setOnLongClickListener(this.mOnLongClickListener);
        this.lys.setOnTouchListener(this.fbT);
        this.lys.setVisibility(8);
        if (this.lyx.getHeadView() != null) {
            this.lyx.getHeadView().setIsRound(true);
            this.lyx.getHeadView().setDrawBorder(false);
            this.lyx.getHeadView().setPlaceHolder(1);
        }
        this.llX = (UserIconBox) this.lys.findViewById(R.id.show_icon_vip);
        this.llY = (UserIconBox) this.lys.findViewById(R.id.show_icon_yinji);
        this.lyA = (LinearLayout) this.lyp.findViewById(R.id.pb_head_owner_info_root);
        this.lyB = (LinearLayout) this.lys.findViewById(R.id.pb_first_floor_location_container);
        this.lyD = (PbFirstFloorUserLikeButton) this.lys.findViewById(R.id.pb_like_button);
        this.lyF = (TextView) this.lys.findViewById(R.id.pb_views);
        this.lyG = (TextView) this.lys.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lyH = (TextView) this.lys.findViewById(R.id.pb_item_first_floor_location_address);
        this.lyI = (TextView) this.lys.findViewById(R.id.pb_item_first_floor_distance);
        this.lyJ = (TextView) this.lys.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dmk() {
        return this.lyp;
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
        if (postData != null && postData.bka() != null) {
            MetaData bka = postData.bka();
            String string = bka.getName_show() == null ? StringUtils.string(bka.getUserName()) : StringUtils.string(bka.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bka().getSealPrefix())) {
                i2 = k.byteLength(bka.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bka.getIconInfo();
                    tShowInfoNew = bka.getTShowInfoNew();
                    if (this.llY != null) {
                        this.llY.setTag(R.id.tag_user_id, bka.getUserId());
                        if (this.ljH.diC() != null) {
                            this.llY.setOnClickListener(this.ljH.diC().ljT.lAe);
                        }
                        this.llY.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.llX != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.llX.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.ljH.diC() != null) {
                            this.llX.setOnClickListener(this.ljH.diC().ljT.lAf);
                        }
                        this.llX.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.lyu.setText(dT(bka.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lyu.setTag(R.id.tag_user_id, bka.getUserId());
                    this.lyu.setTag(R.id.tag_user_name, bka.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bka.isBigV()) {
                        ap.setViewTextColor(this.lyu, R.color.cp_cont_h, 1);
                    } else {
                        ap.setViewTextColor(this.lyu, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.dgl()) {
                        this.lyv.setVisibility(8);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bka.getBawu_type())) {
                        this.lyv.setText(R.string.bawu_member_bazhu_tip);
                        this.lyv.setVisibility(0);
                        if (i == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        this.lyv.setBackgroundDrawable(this.ajE);
                        ap.setViewTextColor(this.lyv, R.color.cp_cont_a);
                    } else if (bka.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bka.getBawu_type())) {
                        this.lyv.setText(R.string.bawu_member_xbazhu_tip);
                        this.lyv.setVisibility(0);
                        if (i == 1) {
                            if (this.ajF.getDrawable(1) != null) {
                                this.ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajF.getDrawable(1) != null) {
                            this.ajF.getDrawable(1).setAlpha(0);
                        }
                        this.lyv.setBackgroundDrawable(this.ajF);
                        ap.setViewTextColor(this.lyv, R.color.cp_cont_a);
                    } else {
                        this.lyv.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lyG.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lyG.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dgl()) {
                        this.lyH.setVisibility(8);
                        if (this.lyB.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lyB.getLayoutParams()).rightMargin = 0;
                        }
                        this.lys.setSpacingRight(0);
                        String str = null;
                        if (bka.getBaijiahaoInfo() != null) {
                            str = bka.getBaijiahaoInfo().auth_desc;
                        }
                        if (bka.isNewGod()) {
                            this.lyJ.setVisibility(0);
                            this.lyJ.setText(bka.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bka.showBazhuGrade()) {
                            this.lyJ.setVisibility(0);
                            this.lyJ.setText(at.cutChineseAndEnglishWithSuffix(bka.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lyJ.setVisibility(0);
                            this.lyJ.setText(str);
                        } else {
                            this.lyJ.setVisibility(8);
                        }
                    } else {
                        if (bka.isNewGod()) {
                            this.lyJ.setVisibility(0);
                            this.lyJ.setText(bka.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (bka.showBazhuGrade()) {
                            this.lyJ.setVisibility(0);
                            this.lyJ.setText(at.cutChineseAndEnglishWithSuffix(bka.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lyJ.setVisibility(8);
                        }
                        if (this.lyB.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lyB.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lys.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dHA = postData.dHA();
                        if (dHA != null && !TextUtils.isEmpty(dHA.getName()) && !TextUtils.isEmpty(dHA.getName().trim())) {
                            this.lyH.setVisibility(0);
                            this.lyH.setText(dHA.getName());
                        } else {
                            this.lyH.setVisibility(8);
                        }
                        if (dHA != null && !TextUtils.isEmpty(dHA.getDistance())) {
                            this.lyI.setText(dHA.getDistance());
                            this.lyI.setVisibility(0);
                            final int measureText = (int) this.lyI.getPaint().measureText(dHA.getDistance(), 0, dHA.getDistance().length());
                            this.lyB.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lyB.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lyG.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lyJ.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lyI.setVisibility(8);
                                        d.this.lyH.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lyH.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lyI.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dfI().bka() != null && fVar.dfI().bka().getAlaInfo() != null && fVar.dfI().bka().getAlaInfo().live_status == 1) {
                        dml();
                        z = true;
                    }
                    this.lyx.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lyx.a(bka, 4);
                        this.lyx.setIsclearmode(false);
                    } else {
                        this.lyx.setIsclearmode(true);
                    }
                    this.lyx.setVisibility(0);
                    if (this.lyC != null) {
                        this.lyC.setVisibility(8);
                    }
                    this.lyu.setOnClickListener(onClickListener);
                    this.lyx.getHeadView().setUserId(bka.getUserId());
                    this.lyx.getHeadView().setUserName(bka.getUserName());
                    this.lyx.getHeadView().setTid(postData.getId());
                    this.lyx.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lyx.getHeadView().setFName(fVar.getForumName());
                    this.lyx.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lyx.Cc(bka.getAvater());
                    } else {
                        this.lyx.a(bka);
                    }
                    String name_show = bka.getName_show();
                    String userName = bka.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lyu.setText(com.baidu.tieba.pb.c.aU(this.ljH.getPageContext().getPageActivity(), this.lyu.getText().toString()));
                        this.lyu.setGravity(16);
                        this.lyu.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dfs());
                        ap.setViewTextColor(this.lyu, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bka.getIconInfo();
                tShowInfoNew = bka.getTShowInfoNew();
                if (this.llY != null) {
                }
                if (this.llX != null) {
                }
                this.lyu.setText(dT(bka.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lyu.setTag(R.id.tag_user_id, bka.getUserId());
                this.lyu.setTag(R.id.tag_user_name, bka.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lyu, R.color.cp_cont_h, 1);
                if (!fVar.dgl()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dgl()) {
                }
                z = false;
                if (fVar.dfI().bka() != null) {
                    dml();
                    z = true;
                }
                this.lyx.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lyx.setVisibility(0);
                if (this.lyC != null) {
                }
                this.lyu.setOnClickListener(onClickListener);
                this.lyx.getHeadView().setUserId(bka.getUserId());
                this.lyx.getHeadView().setUserName(bka.getUserName());
                this.lyx.getHeadView().setTid(postData.getId());
                this.lyx.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lyx.getHeadView().setFName(fVar.getForumName());
                this.lyx.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bka.getName_show();
                String userName2 = bka.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lyu.setText(com.baidu.tieba.pb.c.aU(this.ljH.getPageContext().getPageActivity(), this.lyu.getText().toString()));
                    this.lyu.setGravity(16);
                    this.lyu.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dfs());
                    ap.setViewTextColor(this.lyu, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bka.getIconInfo();
                    tShowInfoNew = bka.getTShowInfoNew();
                    if (this.llY != null) {
                    }
                    if (this.llX != null) {
                    }
                    this.lyu.setText(dT(bka.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lyu.setTag(R.id.tag_user_id, bka.getUserId());
                    this.lyu.setTag(R.id.tag_user_name, bka.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.lyu, R.color.cp_cont_h, 1);
                    if (!fVar.dgl()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dgl()) {
                    }
                    z = false;
                    if (fVar.dfI().bka() != null) {
                    }
                    this.lyx.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lyx.setVisibility(0);
                    if (this.lyC != null) {
                    }
                    this.lyu.setOnClickListener(onClickListener);
                    this.lyx.getHeadView().setUserId(bka.getUserId());
                    this.lyx.getHeadView().setUserName(bka.getUserName());
                    this.lyx.getHeadView().setTid(postData.getId());
                    this.lyx.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lyx.getHeadView().setFName(fVar.getForumName());
                    this.lyx.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bka.getName_show();
                    String userName22 = bka.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bka.getIconInfo();
                tShowInfoNew = bka.getTShowInfoNew();
                if (this.llY != null) {
                }
                if (this.llX != null) {
                }
                this.lyu.setText(dT(bka.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lyu.setTag(R.id.tag_user_id, bka.getUserId());
                this.lyu.setTag(R.id.tag_user_name, bka.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lyu, R.color.cp_cont_h, 1);
                if (!fVar.dgl()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dgl()) {
                }
                z = false;
                if (fVar.dfI().bka() != null) {
                }
                this.lyx.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lyx.setVisibility(0);
                if (this.lyC != null) {
                }
                this.lyu.setOnClickListener(onClickListener);
                this.lyx.getHeadView().setUserId(bka.getUserId());
                this.lyx.getHeadView().setUserName(bka.getUserName());
                this.lyx.getHeadView().setTid(postData.getId());
                this.lyx.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lyx.getHeadView().setFName(fVar.getForumName());
                this.lyx.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bka.getName_show();
                String userName222 = bka.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lyr.aG(fVar.dfI());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dgo()) {
                this.lyD.setVisibility(0);
            }
            if (z) {
                this.lyD.setVisibility(8);
                if (fVar != null && fVar.dfI() != null && fVar.dfI().getBaijiahaoData() != null && fVar.dfI().getBaijiahaoData().oriUgcType == 3) {
                    this.lyF.setVisibility(8);
                } else {
                    this.lyF.setVisibility(0);
                }
                this.lyF.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.dgg())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bka().hadConcerned()) {
                this.lyD.setVisibility(8);
                this.lyF.setVisibility(8);
            } else {
                this.lyF.setVisibility(8);
            }
            if (fVar.lha || 3 == fVar.dgo()) {
                this.lyD.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.bka() != null) {
                postData.bka().setIsLike(postData.bka().hadConcerned());
            }
            if (this.lyE == null) {
                bw dfI = fVar.dfI();
                int i = 1;
                if (dfI != null) {
                    if (dfI.biI()) {
                        i = 4;
                    } else if (dfI.biJ()) {
                        i = 6;
                    } else if (dfI.blW()) {
                        i = 7;
                    } else if (dfI.blV()) {
                        i = 5;
                    }
                }
                this.lyE = new ax(this.ljH.getPageContext(), this.lyD, i);
                this.lyE.l(this.ljH.getUniqueId());
                this.lyE.setThreadData(dfI);
            }
            if (postData != null && postData.bka() != null) {
                postData.bka().setIsLike(postData.bka().hadConcerned());
                this.lyE.a(postData.bka());
                this.lyE.setTid(threadId);
            }
            this.lyE.luU = z2;
            this.lyE.FT(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bkw() != null) {
                this.lyt.setData(this.ljH.getPageContext(), fVar.dfK().get(0).bkw(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dfI().getId(), this.ljH.bhI() ? "FRS" : null));
                this.lys.setPadding(this.lys.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lys.getPaddingRight(), this.lys.getPaddingBottom());
                return;
            }
            this.lyt.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.ljH.dgO()) {
            this.lyK = 0;
            if (postData != null && postData.bka() != null) {
                this.lyK = postData.bka().getLevel_id();
            }
            if (this.lyK > 0 && !z) {
                this.lyw.setVisibility(0);
                ap.setImageResource(this.lyw, BitmapHelper.getGradeResourceIdInEnterForum(this.lyK));
                return;
            }
            this.lyw.setVisibility(8);
            return;
        }
        this.lyw.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dgi()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lys.getPaddingBottom();
            if (fVar.dgl()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lys.setPadding(this.lys.getPaddingLeft(), dimens, this.lys.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.lys.getPaddingBottom();
        if (fVar != null && !fVar.dfI().biG() && fVar.dgl() && (!StringUtils.isNull(fVar.dfI().getTitle()) || fVar.dfI().bkK() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lys.setPadding(this.lys.getPaddingLeft(), dimens2, this.lys.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lys.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lyp);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lyp, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lyp);
        }
    }

    public void setVisibility(int i) {
        this.lys.setVisibility(i);
    }

    private void dml() {
        if (this.lyy != null) {
            this.lyy.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lyy.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.ljH.diC(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.ljH.diC(), R.dimen.ds8);
            this.lyy.setLayoutParams(layoutParams);
            this.lyy.loop(true);
            this.lyy.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lyy.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lhb) {
            this.lyq.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lyq.setVisibility(0);
        } else if (z && z2) {
            this.lyq.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lyq.setVisibility(0);
        } else if (z) {
            this.lyq.setImageResource(R.drawable.pic_pb_refined_n);
            this.lyq.setVisibility(0);
        } else if (z2) {
            this.lyq.setImageResource(R.drawable.pic_pb_stick_n);
            this.lyq.setVisibility(0);
        } else {
            this.lyq.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return n.a((Context) this.ljH.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dmm() {
        SparseArray<Object> sparseArray = (SparseArray) this.lys.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lys.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dhh() {
        return this.lyr.dhh();
    }

    public void tP(boolean z) {
        this.lyr.tP(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lyw != null) {
            ap.setImageResource(this.lyw, BitmapHelper.getGradeResourceIdInEnterForum(this.lyK));
        }
        if (this.lyD != null) {
            this.lyD.onChangeSkinType(i);
        }
        if (this.lyH != null) {
            ap.setViewTextColor(this.lyH, R.color.cp_cont_d);
        }
        if (this.lyG != null) {
            ap.setViewTextColor(this.lyG, R.color.cp_cont_d);
        }
        if (this.lyF != null) {
            ap.setViewTextColor(this.lyF, R.color.cp_cont_d);
        }
        if (this.lyJ != null) {
            ap.setViewTextColor(this.lyJ, R.color.cp_cont_d);
        }
        if (this.lyI != null) {
            ap.setViewTextColor(this.lyI, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.lyy != null) {
                this.lyy.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lyy != null) {
                this.lyy.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lyy != null) {
            this.lyy.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lyn != null) {
            this.lyn.Qh();
        }
        if (this.lys != null && this.lyC != null) {
            this.lys.removeView(this.lyz);
            this.lyC = null;
        }
        if (this.lyy != null) {
            this.lyy.cancelAnimation();
        }
    }

    public void dly() {
        if (this.lyn != null) {
            this.lyn.Qh();
        }
    }
}
