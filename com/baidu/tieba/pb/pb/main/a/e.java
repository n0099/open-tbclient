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
    private com.baidu.tieba.pb.a.c fxj;
    private View.OnClickListener jkS;
    private PbFragment lPo;
    private UserIconBox lRN;
    private UserIconBox lRO;
    private com.baidu.tieba.pb.pb.main.f meA;
    private ThreadSkinView meC;
    private ImageView meF;
    private HeadPendantView meG;
    private TBLottieAnimationView meH;
    private LinearLayout meJ;
    private LinearLayout meK;
    private an meN;
    private com.baidu.tieba.c.e mex;
    private ImageView mez;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout mey = null;
    private ColumnLayout meB = null;
    private TextView meD = null;
    private TextView meE = null;
    private FrameLayout meI = null;
    private ClickableHeaderImageView meL = null;
    private PbFirstFloorUserLikeButton meM = null;
    private TextView meO = null;
    private TextView meP = null;
    private TextView meQ = null;
    private TextView meR = null;
    private TextView meS = null;
    private int meT = 0;

    public e(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jkS = null;
        this.lPo = pbFragment;
        this.fxj = cVar;
        this.jkS = onClickListener;
        initView();
    }

    private void initView() {
        this.mey = (RelativeLayout) LayoutInflater.from(this.lPo.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.mez = (ImageView) this.mey.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.mez.getLayoutParams().height = ao.dqu();
        this.meA = new com.baidu.tieba.pb.pb.main.f(this.lPo.getBaseFragmentActivity(), this.mey);
        this.meA.init();
        this.meA.setOnClickListener(this.meA.dmQ(), this.jkS);
        this.meB = (ColumnLayout) this.mey.findViewById(R.id.pb_head_owner_root);
        this.meC = (ThreadSkinView) this.mey.findViewById(R.id.pb_thread_skin);
        this.meD = (TextView) this.meB.findViewById(R.id.pb_head_owner_info_user_name);
        this.meE = (TextView) this.meB.findViewById(R.id.floor_owner);
        this.meF = (ImageView) this.meB.findViewById(R.id.icon_forum_level);
        this.meI = (FrameLayout) this.meB.findViewById(R.id.pb_head_headImage_container);
        this.meG = (HeadPendantView) this.meB.findViewById(R.id.pb_pendant_head_owner_photo);
        this.meG.setHasPendantStyle();
        this.meH = (TBLottieAnimationView) this.meB.findViewById(R.id.pb_head_living_lottie);
        this.meB.setOnLongClickListener(this.mOnLongClickListener);
        this.meB.setOnTouchListener(this.fxj);
        this.meB.setVisibility(8);
        if (this.meG.getHeadView() != null) {
            this.meG.getHeadView().setIsRound(true);
            this.meG.getHeadView().setDrawBorder(true);
            this.meG.getHeadView().setPlaceHolder(1);
        }
        this.lRN = (UserIconBox) this.meB.findViewById(R.id.show_icon_vip);
        this.lRO = (UserIconBox) this.meB.findViewById(R.id.show_icon_yinji);
        this.meJ = (LinearLayout) this.mey.findViewById(R.id.pb_head_owner_info_root);
        this.meK = (LinearLayout) this.meB.findViewById(R.id.pb_first_floor_location_container);
        this.meM = (PbFirstFloorUserLikeButton) this.meB.findViewById(R.id.pb_like_button);
        this.meO = (TextView) this.meB.findViewById(R.id.pb_views);
        this.meP = (TextView) this.meB.findViewById(R.id.pb_item_first_floor_reply_time);
        this.meQ = (TextView) this.meB.findViewById(R.id.pb_item_first_floor_location_address);
        this.meR = (TextView) this.meB.findViewById(R.id.pb_item_first_floor_distance);
        this.meS = (TextView) this.meB.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dsg() {
        return this.mey;
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
        if (postData != null && postData.bnS() != null) {
            MetaData bnS = postData.bnS();
            String string = bnS.getName_show() == null ? StringUtils.string(bnS.getUserName()) : StringUtils.string(bnS.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bnS().getSealPrefix())) {
                i2 = k.byteLength(bnS.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bnS.getIconInfo();
                    tShowInfoNew = bnS.getTShowInfoNew();
                    if (this.lRO != null) {
                        this.lRO.setTag(R.id.tag_user_id, bnS.getUserId());
                        if (this.lPo.doq() != null) {
                            this.lRO.setOnClickListener(this.lPo.doq().lPA.mgp);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lRO.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lRN != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lRN.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lPo.doq() != null) {
                            this.lRN.setOnClickListener(this.lPo.doq().lPA.mgq);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lRN.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.meD.setText(dT(bnS.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.meD.setTag(R.id.tag_user_id, bnS.getUserId());
                    this.meD.setTag(R.id.tag_user_name, bnS.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bnS.isBigV()) {
                        ap.setViewTextColor(this.meD, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.meD, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dlS()) {
                        this.meE.setVisibility(8);
                    } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                        this.meE.setText(R.string.bawu_member_bazhu_tip);
                        this.meE.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.meE).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                        this.meE.setText(R.string.bawu_member_xbazhu_tip);
                        this.meE.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.meE).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.meE.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.meP.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.meP.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dlS()) {
                        this.meQ.setVisibility(8);
                        if (this.meK.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.meK.getLayoutParams()).rightMargin = 0;
                        }
                        this.meB.setSpacingRight(0);
                        String str = null;
                        if (bnS.getBaijiahaoInfo() != null) {
                            str = bnS.getBaijiahaoInfo().auth_desc;
                        }
                        if (bnS.isNewGod()) {
                            this.meS.setVisibility(0);
                            this.meS.setText(bnS.getNewGodData().getFieldName() + aj.lA(bnS.isVideoGod()));
                        } else if (bnS.showBazhuGrade()) {
                            this.meS.setVisibility(0);
                            this.meS.setText(au.cutChineseAndEnglishWithSuffix(bnS.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.meS.setVisibility(0);
                            this.meS.setText(str);
                        } else {
                            this.meS.setVisibility(8);
                        }
                    } else {
                        if (bnS.isNewGod()) {
                            this.meS.setVisibility(0);
                            this.meS.setText(bnS.getNewGodData().getFieldName() + aj.rH(bnS.getNewGodData().getType()));
                        } else if (bnS.showBazhuGrade()) {
                            this.meS.setVisibility(0);
                            this.meS.setText(au.cutChineseAndEnglishWithSuffix(bnS.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.meS.setVisibility(8);
                        }
                        if (this.meK.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.meK.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.meB.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.g dNR = postData.dNR();
                        if (dNR != null && !TextUtils.isEmpty(dNR.getName()) && !TextUtils.isEmpty(dNR.getName().trim())) {
                            this.meQ.setVisibility(0);
                            this.meQ.setText(dNR.getName());
                        } else {
                            this.meQ.setVisibility(8);
                        }
                        if (dNR != null && !TextUtils.isEmpty(dNR.getDistance())) {
                            this.meR.setText(dNR.getDistance());
                            this.meR.setVisibility(0);
                            final int measureText = (int) this.meR.getPaint().measureText(dNR.getDistance(), 0, dNR.getDistance().length());
                            this.meK.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = e.this.meK.getMeasuredWidth();
                                    int measuredWidth2 = e.this.meP.getMeasuredWidth();
                                    int measuredWidth3 = e.this.meS.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        e.this.meR.setVisibility(8);
                                        e.this.meQ.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        e.this.meQ.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.meR.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dlp().bnS() != null && fVar.dlp().bnS().getAlaInfo() != null && fVar.dlp().bnS().getAlaInfo().live_status == 1) {
                        dsh();
                        z = true;
                    }
                    this.meG.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.meG.a(bnS, 4);
                        this.meG.setIsclearmode(false);
                    } else {
                        this.meG.setIsclearmode(true);
                    }
                    this.meG.setVisibility(0);
                    if (this.meL != null) {
                        this.meL.setVisibility(8);
                    }
                    this.meD.setOnClickListener(onClickListener);
                    this.meG.getHeadView().setUserId(bnS.getUserId());
                    this.meG.getHeadView().setUserName(bnS.getUserName());
                    this.meG.getHeadView().setTid(postData.getId());
                    this.meG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.meG.getHeadView().setFName(fVar.getForumName());
                    this.meG.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.meG.BH(bnS.getAvater());
                    } else {
                        this.meG.a(bnS);
                    }
                    String name_show = bnS.getName_show();
                    String userName = bnS.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.meD.setText(com.baidu.tieba.pb.c.aY(this.lPo.getPageContext().getPageActivity(), this.meD.getText().toString()));
                        this.meD.setGravity(16);
                        this.meD.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkZ());
                        ap.setViewTextColor(this.meD, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bnS.getIconInfo();
                tShowInfoNew = bnS.getTShowInfoNew();
                if (this.lRO != null) {
                }
                if (this.lRN != null) {
                }
                this.meD.setText(dT(bnS.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.meD.setTag(R.id.tag_user_id, bnS.getUserId());
                this.meD.setTag(R.id.tag_user_name, bnS.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.meD, R.color.CAM_X0301, 1);
                if (!fVar.dlS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlS()) {
                }
                z = false;
                if (fVar.dlp().bnS() != null) {
                    dsh();
                    z = true;
                }
                this.meG.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.meG.setVisibility(0);
                if (this.meL != null) {
                }
                this.meD.setOnClickListener(onClickListener);
                this.meG.getHeadView().setUserId(bnS.getUserId());
                this.meG.getHeadView().setUserName(bnS.getUserName());
                this.meG.getHeadView().setTid(postData.getId());
                this.meG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.meG.getHeadView().setFName(fVar.getForumName());
                this.meG.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bnS.getName_show();
                String userName2 = bnS.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.meD.setText(com.baidu.tieba.pb.c.aY(this.lPo.getPageContext().getPageActivity(), this.meD.getText().toString()));
                    this.meD.setGravity(16);
                    this.meD.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkZ());
                    ap.setViewTextColor(this.meD, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bnS.getIconInfo();
                    tShowInfoNew = bnS.getTShowInfoNew();
                    if (this.lRO != null) {
                    }
                    if (this.lRN != null) {
                    }
                    this.meD.setText(dT(bnS.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.meD.setTag(R.id.tag_user_id, bnS.getUserId());
                    this.meD.setTag(R.id.tag_user_name, bnS.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.meD, R.color.CAM_X0301, 1);
                    if (!fVar.dlS()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dlS()) {
                    }
                    z = false;
                    if (fVar.dlp().bnS() != null) {
                    }
                    this.meG.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.meG.setVisibility(0);
                    if (this.meL != null) {
                    }
                    this.meD.setOnClickListener(onClickListener);
                    this.meG.getHeadView().setUserId(bnS.getUserId());
                    this.meG.getHeadView().setUserName(bnS.getUserName());
                    this.meG.getHeadView().setTid(postData.getId());
                    this.meG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.meG.getHeadView().setFName(fVar.getForumName());
                    this.meG.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bnS.getName_show();
                    String userName22 = bnS.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bnS.getIconInfo();
                tShowInfoNew = bnS.getTShowInfoNew();
                if (this.lRO != null) {
                }
                if (this.lRN != null) {
                }
                this.meD.setText(dT(bnS.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.meD.setTag(R.id.tag_user_id, bnS.getUserId());
                this.meD.setTag(R.id.tag_user_name, bnS.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.meD, R.color.CAM_X0301, 1);
                if (!fVar.dlS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlS()) {
                }
                z = false;
                if (fVar.dlp().bnS() != null) {
                }
                this.meG.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.meG.setVisibility(0);
                if (this.meL != null) {
                }
                this.meD.setOnClickListener(onClickListener);
                this.meG.getHeadView().setUserId(bnS.getUserId());
                this.meG.getHeadView().setUserName(bnS.getUserName());
                this.meG.getHeadView().setTid(postData.getId());
                this.meG.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.meG.getHeadView().setFName(fVar.getForumName());
                this.meG.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bnS.getName_show();
                String userName222 = bnS.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.meA.aK(fVar.dlp());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dlV()) {
                this.meM.setVisibility(0);
            }
            if (z) {
                this.meM.setVisibility(8);
                if (fVar != null && fVar.dlp() != null && fVar.dlp().getBaijiahaoData() != null && fVar.dlp().getBaijiahaoData().oriUgcType == 3) {
                    this.meO.setVisibility(8);
                } else {
                    this.meO.setVisibility(0);
                }
                this.meO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dlN())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bnS().hadConcerned()) {
                this.meM.setVisibility(8);
                this.meO.setVisibility(8);
            } else {
                this.meO.setVisibility(8);
            }
            if (fVar.lMr || 3 == fVar.dlV()) {
                this.meM.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.bnS() != null) {
                postData.bnS().setIsLike(postData.bnS().hadConcerned());
            }
            if (this.meN == null) {
                cb dlp = fVar.dlp();
                int i = 1;
                if (dlp != null) {
                    if (dlp.bmz()) {
                        i = 4;
                    } else if (dlp.bmA()) {
                        i = 6;
                    } else if (dlp.bpQ()) {
                        i = 7;
                    } else if (dlp.bpP()) {
                        i = 5;
                    }
                }
                this.meN = new an(this.lPo.getPageContext(), this.meM, i);
                this.meN.l(this.lPo.getUniqueId());
                this.meN.setThreadData(dlp);
            }
            if (postData != null && postData.bnS() != null) {
                postData.bnS().setIsLike(postData.bnS().hadConcerned());
                this.meN.a(postData.bnS());
                this.meN.setTid(threadId);
            }
            this.meN.maV = z2;
            this.meN.Gd(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bon() != null) {
                this.meC.setData(this.lPo.getPageContext(), fVar.dlr().get(0).bon(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dlp().getId(), this.lPo.blw() ? "FRS" : null));
                this.meB.setPadding(this.meB.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.meB.getPaddingRight(), this.meB.getPaddingBottom());
                return;
            }
            this.meC.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lPo.dmy()) {
            this.meT = 0;
            if (postData != null && postData.bnS() != null) {
                this.meT = postData.bnS().getLevel_id();
            }
            if (this.meT > 0 && !z) {
                this.meF.setVisibility(0);
                ap.setImageResource(this.meF, BitmapHelper.getGradeResourceIdInEnterForum(this.meT));
                return;
            }
            this.meF.setVisibility(8);
            return;
        }
        this.meF.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlP()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.meB.getPaddingBottom();
            if (fVar.dlS()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.meB.setPadding(this.meB.getPaddingLeft(), dimens, this.meB.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.meB.getPaddingBottom();
        if (fVar != null && !fVar.dlp().bmx() && fVar.dlS() && (!StringUtils.isNull(fVar.dlp().getTitle()) || fVar.dlp().boB() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.meB.setPadding(this.meB.getPaddingLeft(), dimens2, this.meB.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.meB.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mey);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mey, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.mey);
        }
    }

    public void setVisibility(int i) {
        this.meB.setVisibility(i);
    }

    private void dsh() {
        if (this.meH != null) {
            this.meH.setVisibility(0);
            this.meH.setSpeed(0.8f);
            this.meH.loop(true);
            this.meH.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.meH.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lMs) {
            this.mez.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mez.setVisibility(0);
        } else if (z && z2) {
            this.mez.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mez.setVisibility(0);
        } else if (z) {
            this.mez.setImageResource(R.drawable.pic_pb_refined_n);
            this.mez.setVisibility(0);
        } else if (z2) {
            this.mez.setImageResource(R.drawable.pic_pb_stick_n);
            this.mez.setVisibility(0);
        } else {
            this.mez.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lPo.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dsi() {
        SparseArray<Object> sparseArray = (SparseArray) this.meB.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.meB.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dmQ() {
        return this.meA.dmQ();
    }

    public void uO(boolean z) {
        this.meA.uO(z);
    }

    public void onChangeSkinType(int i) {
        if (this.meF != null) {
            ap.setImageResource(this.meF, BitmapHelper.getGradeResourceIdInEnterForum(this.meT));
        }
        if (this.meM != null) {
            this.meM.onChangeSkinType(i);
        }
        if (this.meQ != null) {
            ap.setViewTextColor(this.meQ, R.color.CAM_X0109);
        }
        if (this.meP != null) {
            ap.setViewTextColor(this.meP, R.color.CAM_X0109);
        }
        if (this.meO != null) {
            ap.setViewTextColor(this.meO, R.color.CAM_X0109);
        }
        if (this.meS != null) {
            ap.setViewTextColor(this.meS, R.color.CAM_X0109);
        }
        if (this.meR != null) {
            ap.setViewTextColor(this.meR, R.color.CAM_X0109);
        }
        if (this.meH != null) {
            ap.a(this.meH, R.raw.card_live_header_bg);
        }
    }

    public void onDestroy() {
        if (this.mex != null) {
            this.mex.TC();
        }
        if (this.meB != null && this.meL != null) {
            this.meB.removeView(this.meI);
            this.meL = null;
        }
        if (this.meH != null) {
            this.meH.cancelAnimation();
        }
    }

    public void drt() {
        if (this.mex != null) {
            this.mex.TC();
        }
    }
}
