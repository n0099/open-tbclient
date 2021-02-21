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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.aj;
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
public class e {
    private com.baidu.tieba.pb.a.c fvK;
    private View.OnClickListener jjj;
    private PbFragment lNm;
    private UserIconBox lPL;
    private UserIconBox lPM;
    private ImageView mcC;
    private HeadPendantView mcD;
    private TBLottieAnimationView mcE;
    private LinearLayout mcG;
    private LinearLayout mcH;
    private an mcK;
    private com.baidu.tieba.c.e mcu;
    private ImageView mcw;
    private com.baidu.tieba.pb.pb.main.f mcx;
    private ThreadSkinView mcz;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout mcv = null;
    private ColumnLayout mcy = null;
    private TextView mcA = null;
    private TextView mcB = null;
    private FrameLayout mcF = null;
    private ClickableHeaderImageView mcI = null;
    private PbFirstFloorUserLikeButton mcJ = null;
    private TextView mcL = null;
    private TextView mcM = null;
    private TextView mcN = null;
    private TextView mcO = null;
    private TextView mcP = null;
    private int mcQ = 0;

    public e(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jjj = null;
        this.lNm = pbFragment;
        this.fvK = cVar;
        this.jjj = onClickListener;
        initView();
    }

    private void initView() {
        this.mcv = (RelativeLayout) LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.mcw = (ImageView) this.mcv.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.mcw.getLayoutParams().height = ao.dql();
        this.mcx = new com.baidu.tieba.pb.pb.main.f(this.lNm.getBaseFragmentActivity(), this.mcv);
        this.mcx.init();
        this.mcx.setOnClickListener(this.mcx.dmH(), this.jjj);
        this.mcy = (ColumnLayout) this.mcv.findViewById(R.id.pb_head_owner_root);
        this.mcz = (ThreadSkinView) this.mcv.findViewById(R.id.pb_thread_skin);
        this.mcA = (TextView) this.mcy.findViewById(R.id.pb_head_owner_info_user_name);
        this.mcB = (TextView) this.mcy.findViewById(R.id.floor_owner);
        this.mcC = (ImageView) this.mcy.findViewById(R.id.icon_forum_level);
        this.mcF = (FrameLayout) this.mcy.findViewById(R.id.pb_head_headImage_container);
        this.mcD = (HeadPendantView) this.mcy.findViewById(R.id.pb_pendant_head_owner_photo);
        this.mcD.setHasPendantStyle();
        this.mcE = (TBLottieAnimationView) this.mcy.findViewById(R.id.pb_head_living_lottie);
        this.mcy.setOnLongClickListener(this.mOnLongClickListener);
        this.mcy.setOnTouchListener(this.fvK);
        this.mcy.setVisibility(8);
        if (this.mcD.getHeadView() != null) {
            this.mcD.getHeadView().setIsRound(true);
            this.mcD.getHeadView().setDrawBorder(true);
            this.mcD.getHeadView().setPlaceHolder(1);
        }
        this.lPL = (UserIconBox) this.mcy.findViewById(R.id.show_icon_vip);
        this.lPM = (UserIconBox) this.mcy.findViewById(R.id.show_icon_yinji);
        this.mcG = (LinearLayout) this.mcv.findViewById(R.id.pb_head_owner_info_root);
        this.mcH = (LinearLayout) this.mcy.findViewById(R.id.pb_first_floor_location_container);
        this.mcJ = (PbFirstFloorUserLikeButton) this.mcy.findViewById(R.id.pb_like_button);
        this.mcL = (TextView) this.mcy.findViewById(R.id.pb_views);
        this.mcM = (TextView) this.mcy.findViewById(R.id.pb_item_first_floor_reply_time);
        this.mcN = (TextView) this.mcy.findViewById(R.id.pb_item_first_floor_location_address);
        this.mcO = (TextView) this.mcy.findViewById(R.id.pb_item_first_floor_distance);
        this.mcP = (TextView) this.mcy.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View drX() {
        return this.mcv;
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
        if (postData != null && postData.bnQ() != null) {
            MetaData bnQ = postData.bnQ();
            String string = bnQ.getName_show() == null ? StringUtils.string(bnQ.getUserName()) : StringUtils.string(bnQ.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                i2 = k.byteLength(bnQ.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bnQ.getIconInfo();
                    tShowInfoNew = bnQ.getTShowInfoNew();
                    if (this.lPM != null) {
                        this.lPM.setTag(R.id.tag_user_id, bnQ.getUserId());
                        if (this.lNm.doh() != null) {
                            this.lPM.setOnClickListener(this.lNm.doh().lNy.men);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lPM.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lPL != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lPL.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lNm.doh() != null) {
                            this.lPL.setOnClickListener(this.lNm.doh().lNy.meo);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lPL.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.mcA.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.mcA.setTag(R.id.tag_user_id, bnQ.getUserId());
                    this.mcA.setTag(R.id.tag_user_name, bnQ.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bnQ.isBigV()) {
                        ap.setViewTextColor(this.mcA, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.mcA, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dlJ()) {
                        this.mcB.setVisibility(8);
                    } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                        this.mcB.setText(R.string.bawu_member_bazhu_tip);
                        this.mcB.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.mcB).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                        this.mcB.setText(R.string.bawu_member_xbazhu_tip);
                        this.mcB.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.mcB).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.mcB.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.mcM.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.mcM.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dlJ()) {
                        this.mcN.setVisibility(8);
                        if (this.mcH.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.mcH.getLayoutParams()).rightMargin = 0;
                        }
                        this.mcy.setSpacingRight(0);
                        String str = null;
                        if (bnQ.getBaijiahaoInfo() != null) {
                            str = bnQ.getBaijiahaoInfo().auth_desc;
                        }
                        if (bnQ.isNewGod()) {
                            this.mcP.setVisibility(0);
                            this.mcP.setText(bnQ.getNewGodData().getFieldName() + aj.lA(bnQ.isVideoGod()));
                        } else if (bnQ.showBazhuGrade()) {
                            this.mcP.setVisibility(0);
                            this.mcP.setText(au.cutChineseAndEnglishWithSuffix(bnQ.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.mcP.setVisibility(0);
                            this.mcP.setText(str);
                        } else {
                            this.mcP.setVisibility(8);
                        }
                    } else {
                        if (bnQ.isNewGod()) {
                            this.mcP.setVisibility(0);
                            this.mcP.setText(bnQ.getNewGodData().getFieldName() + aj.rF(bnQ.getNewGodData().getType()));
                        } else if (bnQ.showBazhuGrade()) {
                            this.mcP.setVisibility(0);
                            this.mcP.setText(au.cutChineseAndEnglishWithSuffix(bnQ.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.mcP.setVisibility(8);
                        }
                        if (this.mcH.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.mcH.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.mcy.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.g dNI = postData.dNI();
                        if (dNI != null && !TextUtils.isEmpty(dNI.getName()) && !TextUtils.isEmpty(dNI.getName().trim())) {
                            this.mcN.setVisibility(0);
                            this.mcN.setText(dNI.getName());
                        } else {
                            this.mcN.setVisibility(8);
                        }
                        if (dNI != null && !TextUtils.isEmpty(dNI.getDistance())) {
                            this.mcO.setText(dNI.getDistance());
                            this.mcO.setVisibility(0);
                            final int measureText = (int) this.mcO.getPaint().measureText(dNI.getDistance(), 0, dNI.getDistance().length());
                            this.mcH.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = e.this.mcH.getMeasuredWidth();
                                    int measuredWidth2 = e.this.mcM.getMeasuredWidth();
                                    int measuredWidth3 = e.this.mcP.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        e.this.mcO.setVisibility(8);
                                        e.this.mcN.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        e.this.mcN.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.mcO.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dlg().bnQ() != null && fVar.dlg().bnQ().getAlaInfo() != null && fVar.dlg().bnQ().getAlaInfo().live_status == 1) {
                        drY();
                        z = true;
                    }
                    this.mcD.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.mcD.a(bnQ, 4);
                        this.mcD.setIsclearmode(false);
                    } else {
                        this.mcD.setIsclearmode(true);
                    }
                    this.mcD.setVisibility(0);
                    if (this.mcI != null) {
                        this.mcI.setVisibility(8);
                    }
                    this.mcA.setOnClickListener(onClickListener);
                    this.mcD.getHeadView().setUserId(bnQ.getUserId());
                    this.mcD.getHeadView().setUserName(bnQ.getUserName());
                    this.mcD.getHeadView().setTid(postData.getId());
                    this.mcD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.mcD.getHeadView().setFName(fVar.getForumName());
                    this.mcD.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.mcD.BA(bnQ.getAvater());
                    } else {
                        this.mcD.a(bnQ);
                    }
                    String name_show = bnQ.getName_show();
                    String userName = bnQ.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.mcA.setText(com.baidu.tieba.pb.c.aY(this.lNm.getPageContext().getPageActivity(), this.mcA.getText().toString()));
                        this.mcA.setGravity(16);
                        this.mcA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkQ());
                        ap.setViewTextColor(this.mcA, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bnQ.getIconInfo();
                tShowInfoNew = bnQ.getTShowInfoNew();
                if (this.lPM != null) {
                }
                if (this.lPL != null) {
                }
                this.mcA.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.mcA.setTag(R.id.tag_user_id, bnQ.getUserId());
                this.mcA.setTag(R.id.tag_user_name, bnQ.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.mcA, R.color.CAM_X0301, 1);
                if (!fVar.dlJ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlJ()) {
                }
                z = false;
                if (fVar.dlg().bnQ() != null) {
                    drY();
                    z = true;
                }
                this.mcD.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.mcD.setVisibility(0);
                if (this.mcI != null) {
                }
                this.mcA.setOnClickListener(onClickListener);
                this.mcD.getHeadView().setUserId(bnQ.getUserId());
                this.mcD.getHeadView().setUserName(bnQ.getUserName());
                this.mcD.getHeadView().setTid(postData.getId());
                this.mcD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.mcD.getHeadView().setFName(fVar.getForumName());
                this.mcD.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bnQ.getName_show();
                String userName2 = bnQ.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.mcA.setText(com.baidu.tieba.pb.c.aY(this.lNm.getPageContext().getPageActivity(), this.mcA.getText().toString()));
                    this.mcA.setGravity(16);
                    this.mcA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkQ());
                    ap.setViewTextColor(this.mcA, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bnQ.getIconInfo();
                    tShowInfoNew = bnQ.getTShowInfoNew();
                    if (this.lPM != null) {
                    }
                    if (this.lPL != null) {
                    }
                    this.mcA.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.mcA.setTag(R.id.tag_user_id, bnQ.getUserId());
                    this.mcA.setTag(R.id.tag_user_name, bnQ.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.mcA, R.color.CAM_X0301, 1);
                    if (!fVar.dlJ()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dlJ()) {
                    }
                    z = false;
                    if (fVar.dlg().bnQ() != null) {
                    }
                    this.mcD.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.mcD.setVisibility(0);
                    if (this.mcI != null) {
                    }
                    this.mcA.setOnClickListener(onClickListener);
                    this.mcD.getHeadView().setUserId(bnQ.getUserId());
                    this.mcD.getHeadView().setUserName(bnQ.getUserName());
                    this.mcD.getHeadView().setTid(postData.getId());
                    this.mcD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.mcD.getHeadView().setFName(fVar.getForumName());
                    this.mcD.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bnQ.getName_show();
                    String userName22 = bnQ.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bnQ.getIconInfo();
                tShowInfoNew = bnQ.getTShowInfoNew();
                if (this.lPM != null) {
                }
                if (this.lPL != null) {
                }
                this.mcA.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.mcA.setTag(R.id.tag_user_id, bnQ.getUserId());
                this.mcA.setTag(R.id.tag_user_name, bnQ.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.mcA, R.color.CAM_X0301, 1);
                if (!fVar.dlJ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlJ()) {
                }
                z = false;
                if (fVar.dlg().bnQ() != null) {
                }
                this.mcD.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.mcD.setVisibility(0);
                if (this.mcI != null) {
                }
                this.mcA.setOnClickListener(onClickListener);
                this.mcD.getHeadView().setUserId(bnQ.getUserId());
                this.mcD.getHeadView().setUserName(bnQ.getUserName());
                this.mcD.getHeadView().setTid(postData.getId());
                this.mcD.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.mcD.getHeadView().setFName(fVar.getForumName());
                this.mcD.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bnQ.getName_show();
                String userName222 = bnQ.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.mcx.aK(fVar.dlg());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dlM()) {
                this.mcJ.setVisibility(0);
            }
            if (z) {
                this.mcJ.setVisibility(8);
                if (fVar != null && fVar.dlg() != null && fVar.dlg().getBaijiahaoData() != null && fVar.dlg().getBaijiahaoData().oriUgcType == 3) {
                    this.mcL.setVisibility(8);
                } else {
                    this.mcL.setVisibility(0);
                }
                this.mcL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dlE())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bnQ().hadConcerned()) {
                this.mcJ.setVisibility(8);
                this.mcL.setVisibility(8);
            } else {
                this.mcL.setVisibility(8);
            }
            if (fVar.lKp || 3 == fVar.dlM()) {
                this.mcJ.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.bnQ() != null) {
                postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
            }
            if (this.mcK == null) {
                cb dlg = fVar.dlg();
                int i = 1;
                if (dlg != null) {
                    if (dlg.bmx()) {
                        i = 4;
                    } else if (dlg.bmy()) {
                        i = 6;
                    } else if (dlg.bpO()) {
                        i = 7;
                    } else if (dlg.bpN()) {
                        i = 5;
                    }
                }
                this.mcK = new an(this.lNm.getPageContext(), this.mcJ, i);
                this.mcK.l(this.lNm.getUniqueId());
                this.mcK.setThreadData(dlg);
            }
            if (postData != null && postData.bnQ() != null) {
                postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
                this.mcK.a(postData.bnQ());
                this.mcK.setTid(threadId);
            }
            this.mcK.lYQ = z2;
            this.mcK.Ga(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bol() != null) {
                this.mcz.setData(this.lNm.getPageContext(), fVar.dli().get(0).bol(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dlg().getId(), this.lNm.blu() ? "FRS" : null));
                this.mcy.setPadding(this.mcy.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.mcy.getPaddingRight(), this.mcy.getPaddingBottom());
                return;
            }
            this.mcz.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lNm.dmp()) {
            this.mcQ = 0;
            if (postData != null && postData.bnQ() != null) {
                this.mcQ = postData.bnQ().getLevel_id();
            }
            if (this.mcQ > 0 && !z) {
                this.mcC.setVisibility(0);
                ap.setImageResource(this.mcC, BitmapHelper.getGradeResourceIdInEnterForum(this.mcQ));
                return;
            }
            this.mcC.setVisibility(8);
            return;
        }
        this.mcC.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlG()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.mcy.getPaddingBottom();
            if (fVar.dlJ()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.mcy.setPadding(this.mcy.getPaddingLeft(), dimens, this.mcy.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.mcy.getPaddingBottom();
        if (fVar != null && !fVar.dlg().bmv() && fVar.dlJ() && (!StringUtils.isNull(fVar.dlg().getTitle()) || fVar.dlg().boz() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.mcy.setPadding(this.mcy.getPaddingLeft(), dimens2, this.mcy.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.mcy.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mcv);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mcv, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.mcv);
        }
    }

    public void setVisibility(int i) {
        this.mcy.setVisibility(i);
    }

    private void drY() {
        if (this.mcE != null) {
            this.mcE.setVisibility(0);
            this.mcE.setSpeed(0.8f);
            this.mcE.loop(true);
            this.mcE.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.mcE.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lKq) {
            this.mcw.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mcw.setVisibility(0);
        } else if (z && z2) {
            this.mcw.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mcw.setVisibility(0);
        } else if (z) {
            this.mcw.setImageResource(R.drawable.pic_pb_refined_n);
            this.mcw.setVisibility(0);
        } else if (z2) {
            this.mcw.setImageResource(R.drawable.pic_pb_stick_n);
            this.mcw.setVisibility(0);
        } else {
            this.mcw.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lNm.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> drZ() {
        SparseArray<Object> sparseArray = (SparseArray) this.mcy.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.mcy.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dmH() {
        return this.mcx.dmH();
    }

    public void uO(boolean z) {
        this.mcx.uO(z);
    }

    public void onChangeSkinType(int i) {
        if (this.mcC != null) {
            ap.setImageResource(this.mcC, BitmapHelper.getGradeResourceIdInEnterForum(this.mcQ));
        }
        if (this.mcJ != null) {
            this.mcJ.onChangeSkinType(i);
        }
        if (this.mcN != null) {
            ap.setViewTextColor(this.mcN, R.color.CAM_X0109);
        }
        if (this.mcM != null) {
            ap.setViewTextColor(this.mcM, R.color.CAM_X0109);
        }
        if (this.mcL != null) {
            ap.setViewTextColor(this.mcL, R.color.CAM_X0109);
        }
        if (this.mcP != null) {
            ap.setViewTextColor(this.mcP, R.color.CAM_X0109);
        }
        if (this.mcO != null) {
            ap.setViewTextColor(this.mcO, R.color.CAM_X0109);
        }
        if (this.mcE != null) {
            ap.a(this.mcE, R.raw.card_live_header_bg);
        }
    }

    public void onDestroy() {
        if (this.mcu != null) {
            this.mcu.Tz();
        }
        if (this.mcy != null && this.mcI != null) {
            this.mcy.removeView(this.mcF);
            this.mcI = null;
        }
        if (this.mcE != null) {
            this.mcE.cancelAnimation();
        }
    }

    public void drk() {
        if (this.mcu != null) {
            this.mcu.Tz();
        }
    }
}
