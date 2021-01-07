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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.tieba.pb.a.c fyb;
    private View.OnClickListener jhV;
    private PbFragment lIN;
    private UserIconBox lLj;
    private UserIconBox lLk;
    private com.baidu.tieba.c.e lXF;
    private ImageView lXH;
    private com.baidu.tieba.pb.pb.main.f lXI;
    private ThreadSkinView lXK;
    private ImageView lXN;
    private HeadPendantView lXO;
    private TBLottieAnimationView lXP;
    private LinearLayout lXR;
    private LinearLayout lXS;
    private an lXV;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lXG = null;
    private ColumnLayout lXJ = null;
    private TextView lXL = null;
    private TextView lXM = null;
    private FrameLayout lXQ = null;
    private ClickableHeaderImageView lXT = null;
    private PbFirstFloorUserLikeButton lXU = null;
    private TextView lXW = null;
    private TextView lXX = null;
    private TextView lXY = null;
    private TextView lXZ = null;
    private TextView lYa = null;
    private int lYb = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jhV = null;
        this.lIN = pbFragment;
        this.fyb = cVar;
        this.jhV = onClickListener;
        initView();
    }

    private void initView() {
        this.lXG = (RelativeLayout) LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lXH = (ImageView) this.lXG.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lXH.getLayoutParams().height = ao.drI();
        this.lXI = new com.baidu.tieba.pb.pb.main.f(this.lIN.getBaseFragmentActivity(), this.lXG);
        this.lXI.init();
        this.lXI.setOnClickListener(this.lXI.dog(), this.jhV);
        this.lXJ = (ColumnLayout) this.lXG.findViewById(R.id.pb_head_owner_root);
        this.lXK = (ThreadSkinView) this.lXG.findViewById(R.id.pb_thread_skin);
        this.lXL = (TextView) this.lXJ.findViewById(R.id.pb_head_owner_info_user_name);
        this.lXM = (TextView) this.lXJ.findViewById(R.id.floor_owner);
        this.lXN = (ImageView) this.lXJ.findViewById(R.id.icon_forum_level);
        this.lXQ = (FrameLayout) this.lXJ.findViewById(R.id.pb_head_headImage_container);
        this.lXO = (HeadPendantView) this.lXJ.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lXO.setHasPendantStyle();
        this.lXP = (TBLottieAnimationView) this.lXJ.findViewById(R.id.pb_head_living_lottie);
        this.lXJ.setOnLongClickListener(this.mOnLongClickListener);
        this.lXJ.setOnTouchListener(this.fyb);
        this.lXJ.setVisibility(8);
        if (this.lXO.getHeadView() != null) {
            this.lXO.getHeadView().setIsRound(true);
            this.lXO.getHeadView().setDrawBorder(true);
            this.lXO.getHeadView().setPlaceHolder(1);
        }
        this.lLj = (UserIconBox) this.lXJ.findViewById(R.id.show_icon_vip);
        this.lLk = (UserIconBox) this.lXJ.findViewById(R.id.show_icon_yinji);
        this.lXR = (LinearLayout) this.lXG.findViewById(R.id.pb_head_owner_info_root);
        this.lXS = (LinearLayout) this.lXJ.findViewById(R.id.pb_first_floor_location_container);
        this.lXU = (PbFirstFloorUserLikeButton) this.lXJ.findViewById(R.id.pb_like_button);
        this.lXW = (TextView) this.lXJ.findViewById(R.id.pb_views);
        this.lXX = (TextView) this.lXJ.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lXY = (TextView) this.lXJ.findViewById(R.id.pb_item_first_floor_location_address);
        this.lXZ = (TextView) this.lXJ.findViewById(R.id.pb_item_first_floor_distance);
        this.lYa = (TextView) this.lXJ.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dtu() {
        return this.lXG;
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
        if (postData != null && postData.brr() != null) {
            MetaData brr = postData.brr();
            String string = brr.getName_show() == null ? StringUtils.string(brr.getUserName()) : StringUtils.string(brr.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.brr().getSealPrefix())) {
                i2 = k.byteLength(brr.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = brr.getIconInfo();
                    tShowInfoNew = brr.getTShowInfoNew();
                    if (this.lLk != null) {
                        this.lLk.setTag(R.id.tag_user_id, brr.getUserId());
                        if (this.lIN.dpE() != null) {
                            this.lLk.setOnClickListener(this.lIN.dpE().lIZ.lZx);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lLk.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lLj != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lLj.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lIN.dpE() != null) {
                            this.lLj.setOnClickListener(this.lIN.dpE().lIZ.lZy);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lLj.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lXL.setText(dZ(brr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lXL.setTag(R.id.tag_user_id, brr.getUserId());
                    this.lXL.setTag(R.id.tag_user_name, brr.getName_show());
                    if (x.isEmpty(tShowInfoNew) || brr.isBigV()) {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0301, 1);
                    } else {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dni()) {
                        this.lXM.setVisibility(8);
                    } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                        this.lXM.setText(R.string.bawu_member_bazhu_tip);
                        this.lXM.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lXM).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                        this.lXM.setText(R.string.bawu_member_xbazhu_tip);
                        this.lXM.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lXM).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lXM.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lXX.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lXX.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dni()) {
                        this.lXY.setVisibility(8);
                        if (this.lXS.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lXS.getLayoutParams()).rightMargin = 0;
                        }
                        this.lXJ.setSpacingRight(0);
                        String str = null;
                        if (brr.getBaijiahaoInfo() != null) {
                            str = brr.getBaijiahaoInfo().auth_desc;
                        }
                        if (brr.isNewGod()) {
                            this.lYa.setVisibility(0);
                            this.lYa.setText(brr.getNewGodData().getFieldName() + ag.lB(brr.isVideoGod()));
                        } else if (brr.showBazhuGrade()) {
                            this.lYa.setVisibility(0);
                            this.lYa.setText(at.cutChineseAndEnglishWithSuffix(brr.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lYa.setVisibility(0);
                            this.lYa.setText(str);
                        } else {
                            this.lYa.setVisibility(8);
                        }
                    } else {
                        if (brr.isNewGod()) {
                            this.lYa.setVisibility(0);
                            this.lYa.setText(brr.getNewGodData().getFieldName() + ag.tg(brr.getNewGodData().getType()));
                        } else if (brr.showBazhuGrade()) {
                            this.lYa.setVisibility(0);
                            this.lYa.setText(at.cutChineseAndEnglishWithSuffix(brr.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lYa.setVisibility(8);
                        }
                        if (this.lXS.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lXS.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lXJ.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        g dPh = postData.dPh();
                        if (dPh != null && !TextUtils.isEmpty(dPh.getName()) && !TextUtils.isEmpty(dPh.getName().trim())) {
                            this.lXY.setVisibility(0);
                            this.lXY.setText(dPh.getName());
                        } else {
                            this.lXY.setVisibility(8);
                        }
                        if (dPh != null && !TextUtils.isEmpty(dPh.getDistance())) {
                            this.lXZ.setText(dPh.getDistance());
                            this.lXZ.setVisibility(0);
                            final int measureText = (int) this.lXZ.getPaint().measureText(dPh.getDistance(), 0, dPh.getDistance().length());
                            this.lXS.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lXS.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lXX.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lYa.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lXZ.setVisibility(8);
                                        d.this.lXY.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lXY.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lXZ.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dmF().brr() != null && fVar.dmF().brr().getAlaInfo() != null && fVar.dmF().brr().getAlaInfo().live_status == 1) {
                        dtv();
                        z = true;
                    }
                    this.lXO.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lXO.a(brr, 4);
                        this.lXO.setIsclearmode(false);
                    } else {
                        this.lXO.setIsclearmode(true);
                    }
                    this.lXO.setVisibility(0);
                    if (this.lXT != null) {
                        this.lXT.setVisibility(8);
                    }
                    this.lXL.setOnClickListener(onClickListener);
                    this.lXO.getHeadView().setUserId(brr.getUserId());
                    this.lXO.getHeadView().setUserName(brr.getUserName());
                    this.lXO.getHeadView().setTid(postData.getId());
                    this.lXO.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lXO.getHeadView().setFName(fVar.getForumName());
                    this.lXO.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lXO.Cu(brr.getAvater());
                    } else {
                        this.lXO.a(brr);
                    }
                    String name_show = brr.getName_show();
                    String userName = brr.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lXL.setText(com.baidu.tieba.pb.c.bb(this.lIN.getPageContext().getPageActivity(), this.lXL.getText().toString()));
                        this.lXL.setGravity(16);
                        this.lXL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmp());
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = brr.getIconInfo();
                tShowInfoNew = brr.getTShowInfoNew();
                if (this.lLk != null) {
                }
                if (this.lLj != null) {
                }
                this.lXL.setText(dZ(brr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lXL.setTag(R.id.tag_user_id, brr.getUserId());
                this.lXL.setTag(R.id.tag_user_name, brr.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0301, 1);
                if (!fVar.dni()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dni()) {
                }
                z = false;
                if (fVar.dmF().brr() != null) {
                    dtv();
                    z = true;
                }
                this.lXO.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lXO.setVisibility(0);
                if (this.lXT != null) {
                }
                this.lXL.setOnClickListener(onClickListener);
                this.lXO.getHeadView().setUserId(brr.getUserId());
                this.lXO.getHeadView().setUserName(brr.getUserName());
                this.lXO.getHeadView().setTid(postData.getId());
                this.lXO.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lXO.getHeadView().setFName(fVar.getForumName());
                this.lXO.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = brr.getName_show();
                String userName2 = brr.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lXL.setText(com.baidu.tieba.pb.c.bb(this.lIN.getPageContext().getPageActivity(), this.lXL.getText().toString()));
                    this.lXL.setGravity(16);
                    this.lXL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmp());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = brr.getIconInfo();
                    tShowInfoNew = brr.getTShowInfoNew();
                    if (this.lLk != null) {
                    }
                    if (this.lLj != null) {
                    }
                    this.lXL.setText(dZ(brr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lXL.setTag(R.id.tag_user_id, brr.getUserId());
                    this.lXL.setTag(R.id.tag_user_name, brr.getName_show());
                    if (x.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0301, 1);
                    if (!fVar.dni()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dni()) {
                    }
                    z = false;
                    if (fVar.dmF().brr() != null) {
                    }
                    this.lXO.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lXO.setVisibility(0);
                    if (this.lXT != null) {
                    }
                    this.lXL.setOnClickListener(onClickListener);
                    this.lXO.getHeadView().setUserId(brr.getUserId());
                    this.lXO.getHeadView().setUserName(brr.getUserName());
                    this.lXO.getHeadView().setTid(postData.getId());
                    this.lXO.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lXO.getHeadView().setFName(fVar.getForumName());
                    this.lXO.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = brr.getName_show();
                    String userName22 = brr.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = brr.getIconInfo();
                tShowInfoNew = brr.getTShowInfoNew();
                if (this.lLk != null) {
                }
                if (this.lLj != null) {
                }
                this.lXL.setText(dZ(brr.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lXL.setTag(R.id.tag_user_id, brr.getUserId());
                this.lXL.setTag(R.id.tag_user_name, brr.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXL, R.color.CAM_X0301, 1);
                if (!fVar.dni()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dni()) {
                }
                z = false;
                if (fVar.dmF().brr() != null) {
                }
                this.lXO.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lXO.setVisibility(0);
                if (this.lXT != null) {
                }
                this.lXL.setOnClickListener(onClickListener);
                this.lXO.getHeadView().setUserId(brr.getUserId());
                this.lXO.getHeadView().setUserName(brr.getUserName());
                this.lXO.getHeadView().setTid(postData.getId());
                this.lXO.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lXO.getHeadView().setFName(fVar.getForumName());
                this.lXO.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = brr.getName_show();
                String userName222 = brr.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lXI.aJ(fVar.dmF());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dnl()) {
                this.lXU.setVisibility(0);
            }
            if (z) {
                this.lXU.setVisibility(8);
                if (fVar != null && fVar.dmF() != null && fVar.dmF().getBaijiahaoData() != null && fVar.dmF().getBaijiahaoData().oriUgcType == 3) {
                    this.lXW.setVisibility(8);
                } else {
                    this.lXW.setVisibility(0);
                }
                this.lXW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.dnd())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.brr().hadConcerned()) {
                this.lXU.setVisibility(8);
                this.lXW.setVisibility(8);
            } else {
                this.lXW.setVisibility(8);
            }
            if (fVar.lFT || 3 == fVar.dnl()) {
                this.lXU.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.brr() != null) {
                postData.brr().setIsLike(postData.brr().hadConcerned());
            }
            if (this.lXV == null) {
                bz dmF = fVar.dmF();
                int i = 1;
                if (dmF != null) {
                    if (dmF.bpY()) {
                        i = 4;
                    } else if (dmF.bpZ()) {
                        i = 6;
                    } else if (dmF.btq()) {
                        i = 7;
                    } else if (dmF.btp()) {
                        i = 5;
                    }
                }
                this.lXV = new an(this.lIN.getPageContext(), this.lXU, i);
                this.lXV.l(this.lIN.getUniqueId());
                this.lXV.setThreadData(dmF);
            }
            if (postData != null && postData.brr() != null) {
                postData.brr().setIsLike(postData.brr().hadConcerned());
                this.lXV.a(postData.brr());
                this.lXV.setTid(threadId);
            }
            this.lXV.lUj = z2;
            this.lXV.Hn(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.brM() != null) {
                this.lXK.setData(this.lIN.getPageContext(), fVar.dmH().get(0).brM(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dmF().getId(), this.lIN.boW() ? "FRS" : null));
                this.lXJ.setPadding(this.lXJ.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lXJ.getPaddingRight(), this.lXJ.getPaddingBottom());
                return;
            }
            this.lXK.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lIN.dnO()) {
            this.lYb = 0;
            if (postData != null && postData.brr() != null) {
                this.lYb = postData.brr().getLevel_id();
            }
            if (this.lYb > 0 && !z) {
                this.lXN.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(this.lXN, BitmapHelper.getGradeResourceIdInEnterForum(this.lYb));
                return;
            }
            this.lXN.setVisibility(8);
            return;
        }
        this.lXN.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dnf()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lXJ.getPaddingBottom();
            if (fVar.dni()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lXJ.setPadding(this.lXJ.getPaddingLeft(), dimens, this.lXJ.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.lXJ.getPaddingBottom();
        if (fVar != null && !fVar.dmF().bpW() && fVar.dni() && (!StringUtils.isNull(fVar.dmF().getTitle()) || fVar.dmF().bsa() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lXJ.setPadding(this.lXJ.getPaddingLeft(), dimens2, this.lXJ.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lXJ.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lXG);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lXG, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lXG);
        }
    }

    public void setVisibility(int i) {
        this.lXJ.setVisibility(i);
    }

    private void dtv() {
        if (this.lXP != null) {
            this.lXP.setVisibility(0);
            this.lXP.setSpeed(0.8f);
            this.lXP.loop(true);
            this.lXP.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lXP.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lFU) {
            this.lXH.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lXH.setVisibility(0);
        } else if (z && z2) {
            this.lXH.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lXH.setVisibility(0);
        } else if (z) {
            this.lXH.setImageResource(R.drawable.pic_pb_refined_n);
            this.lXH.setVisibility(0);
        } else if (z2) {
            this.lXH.setImageResource(R.drawable.pic_pb_stick_n);
            this.lXH.setVisibility(0);
        } else {
            this.lXH.setVisibility(8);
        }
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lIN.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dtw() {
        SparseArray<Object> sparseArray = (SparseArray) this.lXJ.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lXJ.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dog() {
        return this.lXI.dog();
    }

    public void uE(boolean z) {
        this.lXI.uE(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lXN != null) {
            com.baidu.tbadk.core.util.ao.setImageResource(this.lXN, BitmapHelper.getGradeResourceIdInEnterForum(this.lYb));
        }
        if (this.lXU != null) {
            this.lXU.onChangeSkinType(i);
        }
        if (this.lXY != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXY, R.color.CAM_X0109);
        }
        if (this.lXX != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXX, R.color.CAM_X0109);
        }
        if (this.lXW != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXW, R.color.CAM_X0109);
        }
        if (this.lYa != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lYa, R.color.CAM_X0109);
        }
        if (this.lXZ != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXZ, R.color.CAM_X0109);
        }
        if (i == 4) {
            if (this.lXP != null) {
                this.lXP.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lXP != null) {
                this.lXP.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lXP != null) {
            this.lXP.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lXF != null) {
            this.lXF.VL();
        }
        if (this.lXJ != null && this.lXT != null) {
            this.lXJ.removeView(this.lXQ);
            this.lXT = null;
        }
        if (this.lXP != null) {
            this.lXP.cancelAnimation();
        }
    }

    public void dsH() {
        if (this.lXF != null) {
            this.lXF.VL();
        }
    }
}
