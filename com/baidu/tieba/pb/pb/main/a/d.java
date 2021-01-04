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
    private PbFragment lIO;
    private UserIconBox lLk;
    private UserIconBox lLl;
    private com.baidu.tieba.c.e lXG;
    private ImageView lXI;
    private com.baidu.tieba.pb.pb.main.f lXJ;
    private ThreadSkinView lXL;
    private ImageView lXO;
    private HeadPendantView lXP;
    private TBLottieAnimationView lXQ;
    private LinearLayout lXS;
    private LinearLayout lXT;
    private an lXW;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lXH = null;
    private ColumnLayout lXK = null;
    private TextView lXM = null;
    private TextView lXN = null;
    private FrameLayout lXR = null;
    private ClickableHeaderImageView lXU = null;
    private PbFirstFloorUserLikeButton lXV = null;
    private TextView lXX = null;
    private TextView lXY = null;
    private TextView lXZ = null;
    private TextView lYa = null;
    private TextView lYb = null;
    private int lYc = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jhV = null;
        this.lIO = pbFragment;
        this.fyb = cVar;
        this.jhV = onClickListener;
        initView();
    }

    private void initView() {
        this.lXH = (RelativeLayout) LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lXI = (ImageView) this.lXH.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lXI.getLayoutParams().height = ao.drH();
        this.lXJ = new com.baidu.tieba.pb.pb.main.f(this.lIO.getBaseFragmentActivity(), this.lXH);
        this.lXJ.init();
        this.lXJ.setOnClickListener(this.lXJ.dof(), this.jhV);
        this.lXK = (ColumnLayout) this.lXH.findViewById(R.id.pb_head_owner_root);
        this.lXL = (ThreadSkinView) this.lXH.findViewById(R.id.pb_thread_skin);
        this.lXM = (TextView) this.lXK.findViewById(R.id.pb_head_owner_info_user_name);
        this.lXN = (TextView) this.lXK.findViewById(R.id.floor_owner);
        this.lXO = (ImageView) this.lXK.findViewById(R.id.icon_forum_level);
        this.lXR = (FrameLayout) this.lXK.findViewById(R.id.pb_head_headImage_container);
        this.lXP = (HeadPendantView) this.lXK.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lXP.setHasPendantStyle();
        this.lXQ = (TBLottieAnimationView) this.lXK.findViewById(R.id.pb_head_living_lottie);
        this.lXK.setOnLongClickListener(this.mOnLongClickListener);
        this.lXK.setOnTouchListener(this.fyb);
        this.lXK.setVisibility(8);
        if (this.lXP.getHeadView() != null) {
            this.lXP.getHeadView().setIsRound(true);
            this.lXP.getHeadView().setDrawBorder(true);
            this.lXP.getHeadView().setPlaceHolder(1);
        }
        this.lLk = (UserIconBox) this.lXK.findViewById(R.id.show_icon_vip);
        this.lLl = (UserIconBox) this.lXK.findViewById(R.id.show_icon_yinji);
        this.lXS = (LinearLayout) this.lXH.findViewById(R.id.pb_head_owner_info_root);
        this.lXT = (LinearLayout) this.lXK.findViewById(R.id.pb_first_floor_location_container);
        this.lXV = (PbFirstFloorUserLikeButton) this.lXK.findViewById(R.id.pb_like_button);
        this.lXX = (TextView) this.lXK.findViewById(R.id.pb_views);
        this.lXY = (TextView) this.lXK.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lXZ = (TextView) this.lXK.findViewById(R.id.pb_item_first_floor_location_address);
        this.lYa = (TextView) this.lXK.findViewById(R.id.pb_item_first_floor_distance);
        this.lYb = (TextView) this.lXK.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dtt() {
        return this.lXH;
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
        if (postData != null && postData.brq() != null) {
            MetaData brq = postData.brq();
            String string = brq.getName_show() == null ? StringUtils.string(brq.getUserName()) : StringUtils.string(brq.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.brq().getSealPrefix())) {
                i2 = k.byteLength(brq.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = brq.getIconInfo();
                    tShowInfoNew = brq.getTShowInfoNew();
                    if (this.lLl != null) {
                        this.lLl.setTag(R.id.tag_user_id, brq.getUserId());
                        if (this.lIO.dpD() != null) {
                            this.lLl.setOnClickListener(this.lIO.dpD().lJa.lZy);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lLl.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lLk != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lLk.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lIO.dpD() != null) {
                            this.lLk.setOnClickListener(this.lIO.dpD().lJa.lZz);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lLk.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lXM.setText(dZ(brq.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lXM.setTag(R.id.tag_user_id, brq.getUserId());
                    this.lXM.setTag(R.id.tag_user_name, brq.getName_show());
                    if (x.isEmpty(tShowInfoNew) || brq.isBigV()) {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0301, 1);
                    } else {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dnh()) {
                        this.lXN.setVisibility(8);
                    } else if (brq.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brq.getBawu_type())) {
                        this.lXN.setText(R.string.bawu_member_bazhu_tip);
                        this.lXN.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lXN).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (brq.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brq.getBawu_type())) {
                        this.lXN.setText(R.string.bawu_member_xbazhu_tip);
                        this.lXN.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lXN).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lXN.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lXY.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lXY.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dnh()) {
                        this.lXZ.setVisibility(8);
                        if (this.lXT.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lXT.getLayoutParams()).rightMargin = 0;
                        }
                        this.lXK.setSpacingRight(0);
                        String str = null;
                        if (brq.getBaijiahaoInfo() != null) {
                            str = brq.getBaijiahaoInfo().auth_desc;
                        }
                        if (brq.isNewGod()) {
                            this.lYb.setVisibility(0);
                            this.lYb.setText(brq.getNewGodData().getFieldName() + ag.lB(brq.isVideoGod()));
                        } else if (brq.showBazhuGrade()) {
                            this.lYb.setVisibility(0);
                            this.lYb.setText(at.cutChineseAndEnglishWithSuffix(brq.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lYb.setVisibility(0);
                            this.lYb.setText(str);
                        } else {
                            this.lYb.setVisibility(8);
                        }
                    } else {
                        if (brq.isNewGod()) {
                            this.lYb.setVisibility(0);
                            this.lYb.setText(brq.getNewGodData().getFieldName() + ag.tg(brq.getNewGodData().getType()));
                        } else if (brq.showBazhuGrade()) {
                            this.lYb.setVisibility(0);
                            this.lYb.setText(at.cutChineseAndEnglishWithSuffix(brq.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lYb.setVisibility(8);
                        }
                        if (this.lXT.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lXT.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lXK.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        g dPg = postData.dPg();
                        if (dPg != null && !TextUtils.isEmpty(dPg.getName()) && !TextUtils.isEmpty(dPg.getName().trim())) {
                            this.lXZ.setVisibility(0);
                            this.lXZ.setText(dPg.getName());
                        } else {
                            this.lXZ.setVisibility(8);
                        }
                        if (dPg != null && !TextUtils.isEmpty(dPg.getDistance())) {
                            this.lYa.setText(dPg.getDistance());
                            this.lYa.setVisibility(0);
                            final int measureText = (int) this.lYa.getPaint().measureText(dPg.getDistance(), 0, dPg.getDistance().length());
                            this.lXT.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lXT.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lXY.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lYb.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lYa.setVisibility(8);
                                        d.this.lXZ.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lXZ.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lYa.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dmE().brq() != null && fVar.dmE().brq().getAlaInfo() != null && fVar.dmE().brq().getAlaInfo().live_status == 1) {
                        dtu();
                        z = true;
                    }
                    this.lXP.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lXP.a(brq, 4);
                        this.lXP.setIsclearmode(false);
                    } else {
                        this.lXP.setIsclearmode(true);
                    }
                    this.lXP.setVisibility(0);
                    if (this.lXU != null) {
                        this.lXU.setVisibility(8);
                    }
                    this.lXM.setOnClickListener(onClickListener);
                    this.lXP.getHeadView().setUserId(brq.getUserId());
                    this.lXP.getHeadView().setUserName(brq.getUserName());
                    this.lXP.getHeadView().setTid(postData.getId());
                    this.lXP.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lXP.getHeadView().setFName(fVar.getForumName());
                    this.lXP.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lXP.Cv(brq.getAvater());
                    } else {
                        this.lXP.a(brq);
                    }
                    String name_show = brq.getName_show();
                    String userName = brq.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lXM.setText(com.baidu.tieba.pb.c.bb(this.lIO.getPageContext().getPageActivity(), this.lXM.getText().toString()));
                        this.lXM.setGravity(16);
                        this.lXM.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmo());
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = brq.getIconInfo();
                tShowInfoNew = brq.getTShowInfoNew();
                if (this.lLl != null) {
                }
                if (this.lLk != null) {
                }
                this.lXM.setText(dZ(brq.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lXM.setTag(R.id.tag_user_id, brq.getUserId());
                this.lXM.setTag(R.id.tag_user_name, brq.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0301, 1);
                if (!fVar.dnh()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dnh()) {
                }
                z = false;
                if (fVar.dmE().brq() != null) {
                    dtu();
                    z = true;
                }
                this.lXP.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lXP.setVisibility(0);
                if (this.lXU != null) {
                }
                this.lXM.setOnClickListener(onClickListener);
                this.lXP.getHeadView().setUserId(brq.getUserId());
                this.lXP.getHeadView().setUserName(brq.getUserName());
                this.lXP.getHeadView().setTid(postData.getId());
                this.lXP.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lXP.getHeadView().setFName(fVar.getForumName());
                this.lXP.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = brq.getName_show();
                String userName2 = brq.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lXM.setText(com.baidu.tieba.pb.c.bb(this.lIO.getPageContext().getPageActivity(), this.lXM.getText().toString()));
                    this.lXM.setGravity(16);
                    this.lXM.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmo());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = brq.getIconInfo();
                    tShowInfoNew = brq.getTShowInfoNew();
                    if (this.lLl != null) {
                    }
                    if (this.lLk != null) {
                    }
                    this.lXM.setText(dZ(brq.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lXM.setTag(R.id.tag_user_id, brq.getUserId());
                    this.lXM.setTag(R.id.tag_user_name, brq.getName_show());
                    if (x.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0301, 1);
                    if (!fVar.dnh()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dnh()) {
                    }
                    z = false;
                    if (fVar.dmE().brq() != null) {
                    }
                    this.lXP.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lXP.setVisibility(0);
                    if (this.lXU != null) {
                    }
                    this.lXM.setOnClickListener(onClickListener);
                    this.lXP.getHeadView().setUserId(brq.getUserId());
                    this.lXP.getHeadView().setUserName(brq.getUserName());
                    this.lXP.getHeadView().setTid(postData.getId());
                    this.lXP.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lXP.getHeadView().setFName(fVar.getForumName());
                    this.lXP.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = brq.getName_show();
                    String userName22 = brq.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = brq.getIconInfo();
                tShowInfoNew = brq.getTShowInfoNew();
                if (this.lLl != null) {
                }
                if (this.lLk != null) {
                }
                this.lXM.setText(dZ(brq.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lXM.setTag(R.id.tag_user_id, brq.getUserId());
                this.lXM.setTag(R.id.tag_user_name, brq.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXM, R.color.CAM_X0301, 1);
                if (!fVar.dnh()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dnh()) {
                }
                z = false;
                if (fVar.dmE().brq() != null) {
                }
                this.lXP.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lXP.setVisibility(0);
                if (this.lXU != null) {
                }
                this.lXM.setOnClickListener(onClickListener);
                this.lXP.getHeadView().setUserId(brq.getUserId());
                this.lXP.getHeadView().setUserName(brq.getUserName());
                this.lXP.getHeadView().setTid(postData.getId());
                this.lXP.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lXP.getHeadView().setFName(fVar.getForumName());
                this.lXP.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = brq.getName_show();
                String userName222 = brq.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lXJ.aJ(fVar.dmE());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dnk()) {
                this.lXV.setVisibility(0);
            }
            if (z) {
                this.lXV.setVisibility(8);
                if (fVar != null && fVar.dmE() != null && fVar.dmE().getBaijiahaoData() != null && fVar.dmE().getBaijiahaoData().oriUgcType == 3) {
                    this.lXX.setVisibility(8);
                } else {
                    this.lXX.setVisibility(0);
                }
                this.lXX.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.dnc())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.brq().hadConcerned()) {
                this.lXV.setVisibility(8);
                this.lXX.setVisibility(8);
            } else {
                this.lXX.setVisibility(8);
            }
            if (fVar.lFU || 3 == fVar.dnk()) {
                this.lXV.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.brq() != null) {
                postData.brq().setIsLike(postData.brq().hadConcerned());
            }
            if (this.lXW == null) {
                bz dmE = fVar.dmE();
                int i = 1;
                if (dmE != null) {
                    if (dmE.bpX()) {
                        i = 4;
                    } else if (dmE.bpY()) {
                        i = 6;
                    } else if (dmE.btp()) {
                        i = 7;
                    } else if (dmE.bto()) {
                        i = 5;
                    }
                }
                this.lXW = new an(this.lIO.getPageContext(), this.lXV, i);
                this.lXW.l(this.lIO.getUniqueId());
                this.lXW.setThreadData(dmE);
            }
            if (postData != null && postData.brq() != null) {
                postData.brq().setIsLike(postData.brq().hadConcerned());
                this.lXW.a(postData.brq());
                this.lXW.setTid(threadId);
            }
            this.lXW.lUk = z2;
            this.lXW.Hn(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.brL() != null) {
                this.lXL.setData(this.lIO.getPageContext(), fVar.dmG().get(0).brL(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dmE().getId(), this.lIO.boV() ? "FRS" : null));
                this.lXK.setPadding(this.lXK.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lXK.getPaddingRight(), this.lXK.getPaddingBottom());
                return;
            }
            this.lXL.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lIO.dnN()) {
            this.lYc = 0;
            if (postData != null && postData.brq() != null) {
                this.lYc = postData.brq().getLevel_id();
            }
            if (this.lYc > 0 && !z) {
                this.lXO.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(this.lXO, BitmapHelper.getGradeResourceIdInEnterForum(this.lYc));
                return;
            }
            this.lXO.setVisibility(8);
            return;
        }
        this.lXO.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dne()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lXK.getPaddingBottom();
            if (fVar.dnh()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lXK.setPadding(this.lXK.getPaddingLeft(), dimens, this.lXK.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.lXK.getPaddingBottom();
        if (fVar != null && !fVar.dmE().bpV() && fVar.dnh() && (!StringUtils.isNull(fVar.dmE().getTitle()) || fVar.dmE().brZ() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lXK.setPadding(this.lXK.getPaddingLeft(), dimens2, this.lXK.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lXK.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lXH);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lXH, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lXH);
        }
    }

    public void setVisibility(int i) {
        this.lXK.setVisibility(i);
    }

    private void dtu() {
        if (this.lXQ != null) {
            this.lXQ.setVisibility(0);
            this.lXQ.setSpeed(0.8f);
            this.lXQ.loop(true);
            this.lXQ.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lXQ.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lFV) {
            this.lXI.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lXI.setVisibility(0);
        } else if (z && z2) {
            this.lXI.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lXI.setVisibility(0);
        } else if (z) {
            this.lXI.setImageResource(R.drawable.pic_pb_refined_n);
            this.lXI.setVisibility(0);
        } else if (z2) {
            this.lXI.setImageResource(R.drawable.pic_pb_stick_n);
            this.lXI.setVisibility(0);
        } else {
            this.lXI.setVisibility(8);
        }
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lIO.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dtv() {
        SparseArray<Object> sparseArray = (SparseArray) this.lXK.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lXK.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dof() {
        return this.lXJ.dof();
    }

    public void uE(boolean z) {
        this.lXJ.uE(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lXO != null) {
            com.baidu.tbadk.core.util.ao.setImageResource(this.lXO, BitmapHelper.getGradeResourceIdInEnterForum(this.lYc));
        }
        if (this.lXV != null) {
            this.lXV.onChangeSkinType(i);
        }
        if (this.lXZ != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXZ, R.color.CAM_X0109);
        }
        if (this.lXY != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXY, R.color.CAM_X0109);
        }
        if (this.lXX != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXX, R.color.CAM_X0109);
        }
        if (this.lYb != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lYb, R.color.CAM_X0109);
        }
        if (this.lYa != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lYa, R.color.CAM_X0109);
        }
        if (i == 4) {
            if (this.lXQ != null) {
                this.lXQ.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lXQ != null) {
                this.lXQ.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lXQ != null) {
            this.lXQ.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lXG != null) {
            this.lXG.VL();
        }
        if (this.lXK != null && this.lXU != null) {
            this.lXK.removeView(this.lXR);
            this.lXU = null;
        }
        if (this.lXQ != null) {
            this.lXQ.cancelAnimation();
        }
    }

    public void dsG() {
        if (this.lXG != null) {
            this.lXG.VL();
        }
    }
}
