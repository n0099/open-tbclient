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
    private com.baidu.tieba.pb.a.c ftt;
    private View.OnClickListener jdo;
    private PbFragment lEi;
    private UserIconBox lGF;
    private UserIconBox lGG;
    private com.baidu.tieba.c.e lTb;
    private ImageView lTd;
    private com.baidu.tieba.pb.pb.main.f lTe;
    private ThreadSkinView lTg;
    private ImageView lTj;
    private HeadPendantView lTk;
    private TBLottieAnimationView lTl;
    private LinearLayout lTn;
    private LinearLayout lTo;
    private an lTr;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lTc = null;
    private ColumnLayout lTf = null;
    private TextView lTh = null;
    private TextView lTi = null;
    private FrameLayout lTm = null;
    private ClickableHeaderImageView lTp = null;
    private PbFirstFloorUserLikeButton lTq = null;
    private TextView lTs = null;
    private TextView lTt = null;
    private TextView lTu = null;
    private TextView lTv = null;
    private TextView lTw = null;
    private int lTx = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jdo = null;
        this.lEi = pbFragment;
        this.ftt = cVar;
        this.jdo = onClickListener;
        initView();
    }

    private void initView() {
        this.lTc = (RelativeLayout) LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lTd = (ImageView) this.lTc.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lTd.getLayoutParams().height = ao.dnQ();
        this.lTe = new com.baidu.tieba.pb.pb.main.f(this.lEi.getBaseFragmentActivity(), this.lTc);
        this.lTe.init();
        this.lTe.setOnClickListener(this.lTe.dkn(), this.jdo);
        this.lTf = (ColumnLayout) this.lTc.findViewById(R.id.pb_head_owner_root);
        this.lTg = (ThreadSkinView) this.lTc.findViewById(R.id.pb_thread_skin);
        this.lTh = (TextView) this.lTf.findViewById(R.id.pb_head_owner_info_user_name);
        this.lTi = (TextView) this.lTf.findViewById(R.id.floor_owner);
        this.lTj = (ImageView) this.lTf.findViewById(R.id.icon_forum_level);
        this.lTm = (FrameLayout) this.lTf.findViewById(R.id.pb_head_headImage_container);
        this.lTk = (HeadPendantView) this.lTf.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lTk.setHasPendantStyle();
        this.lTl = (TBLottieAnimationView) this.lTf.findViewById(R.id.pb_head_living_lottie);
        this.lTf.setOnLongClickListener(this.mOnLongClickListener);
        this.lTf.setOnTouchListener(this.ftt);
        this.lTf.setVisibility(8);
        if (this.lTk.getHeadView() != null) {
            this.lTk.getHeadView().setIsRound(true);
            this.lTk.getHeadView().setDrawBorder(true);
            this.lTk.getHeadView().setPlaceHolder(1);
        }
        this.lGF = (UserIconBox) this.lTf.findViewById(R.id.show_icon_vip);
        this.lGG = (UserIconBox) this.lTf.findViewById(R.id.show_icon_yinji);
        this.lTn = (LinearLayout) this.lTc.findViewById(R.id.pb_head_owner_info_root);
        this.lTo = (LinearLayout) this.lTf.findViewById(R.id.pb_first_floor_location_container);
        this.lTq = (PbFirstFloorUserLikeButton) this.lTf.findViewById(R.id.pb_like_button);
        this.lTs = (TextView) this.lTf.findViewById(R.id.pb_views);
        this.lTt = (TextView) this.lTf.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lTu = (TextView) this.lTf.findViewById(R.id.pb_item_first_floor_location_address);
        this.lTv = (TextView) this.lTf.findViewById(R.id.pb_item_first_floor_distance);
        this.lTw = (TextView) this.lTf.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dpC() {
        return this.lTc;
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
        if (postData != null && postData.bnx() != null) {
            MetaData bnx = postData.bnx();
            String string = bnx.getName_show() == null ? StringUtils.string(bnx.getUserName()) : StringUtils.string(bnx.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bnx().getSealPrefix())) {
                i2 = k.byteLength(bnx.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bnx.getIconInfo();
                    tShowInfoNew = bnx.getTShowInfoNew();
                    if (this.lGG != null) {
                        this.lGG.setTag(R.id.tag_user_id, bnx.getUserId());
                        if (this.lEi.dlL() != null) {
                            this.lGG.setOnClickListener(this.lEi.dlL().lEu.lUT);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lGG.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lGF != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lGF.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lEi.dlL() != null) {
                            this.lGF.setOnClickListener(this.lEi.dlL().lEu.lUU);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lGF.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lTh.setText(dY(bnx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lTh.setTag(R.id.tag_user_id, bnx.getUserId());
                    this.lTh.setTag(R.id.tag_user_name, bnx.getName_show());
                    if (x.isEmpty(tShowInfoNew) || bnx.isBigV()) {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0301, 1);
                    } else {
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.djq()) {
                        this.lTi.setVisibility(8);
                    } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                        this.lTi.setText(R.string.bawu_member_bazhu_tip);
                        this.lTi.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lTi).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                        this.lTi.setText(R.string.bawu_member_xbazhu_tip);
                        this.lTi.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bv(this.lTi).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lTi.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lTt.setText(at.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lTt.setText(at.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.djq()) {
                        this.lTu.setVisibility(8);
                        if (this.lTo.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lTo.getLayoutParams()).rightMargin = 0;
                        }
                        this.lTf.setSpacingRight(0);
                        String str = null;
                        if (bnx.getBaijiahaoInfo() != null) {
                            str = bnx.getBaijiahaoInfo().auth_desc;
                        }
                        if (bnx.isNewGod()) {
                            this.lTw.setVisibility(0);
                            this.lTw.setText(bnx.getNewGodData().getFieldName() + ag.lx(bnx.isVideoGod()));
                        } else if (bnx.showBazhuGrade()) {
                            this.lTw.setVisibility(0);
                            this.lTw.setText(at.cutChineseAndEnglishWithSuffix(bnx.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lTw.setVisibility(0);
                            this.lTw.setText(str);
                        } else {
                            this.lTw.setVisibility(8);
                        }
                    } else {
                        if (bnx.isNewGod()) {
                            this.lTw.setVisibility(0);
                            this.lTw.setText(bnx.getNewGodData().getFieldName() + ag.rA(bnx.getNewGodData().getType()));
                        } else if (bnx.showBazhuGrade()) {
                            this.lTw.setVisibility(0);
                            this.lTw.setText(at.cutChineseAndEnglishWithSuffix(bnx.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lTw.setVisibility(8);
                        }
                        if (this.lTo.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lTo.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lTf.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        g dLp = postData.dLp();
                        if (dLp != null && !TextUtils.isEmpty(dLp.getName()) && !TextUtils.isEmpty(dLp.getName().trim())) {
                            this.lTu.setVisibility(0);
                            this.lTu.setText(dLp.getName());
                        } else {
                            this.lTu.setVisibility(8);
                        }
                        if (dLp != null && !TextUtils.isEmpty(dLp.getDistance())) {
                            this.lTv.setText(dLp.getDistance());
                            this.lTv.setVisibility(0);
                            final int measureText = (int) this.lTv.getPaint().measureText(dLp.getDistance(), 0, dLp.getDistance().length());
                            this.lTo.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lTo.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lTt.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lTw.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lTv.setVisibility(8);
                                        d.this.lTu.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lTu.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lTv.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.diN().bnx() != null && fVar.diN().bnx().getAlaInfo() != null && fVar.diN().bnx().getAlaInfo().live_status == 1) {
                        dpD();
                        z = true;
                    }
                    this.lTk.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lTk.a(bnx, 4);
                        this.lTk.setIsclearmode(false);
                    } else {
                        this.lTk.setIsclearmode(true);
                    }
                    this.lTk.setVisibility(0);
                    if (this.lTp != null) {
                        this.lTp.setVisibility(8);
                    }
                    this.lTh.setOnClickListener(onClickListener);
                    this.lTk.getHeadView().setUserId(bnx.getUserId());
                    this.lTk.getHeadView().setUserName(bnx.getUserName());
                    this.lTk.getHeadView().setTid(postData.getId());
                    this.lTk.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lTk.getHeadView().setFName(fVar.getForumName());
                    this.lTk.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lTk.Bj(bnx.getAvater());
                    } else {
                        this.lTk.a(bnx);
                    }
                    String name_show = bnx.getName_show();
                    String userName = bnx.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lTh.setText(com.baidu.tieba.pb.c.bb(this.lEi.getPageContext().getPageActivity(), this.lTh.getText().toString()));
                        this.lTh.setGravity(16);
                        this.lTh.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dix());
                        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bnx.getIconInfo();
                tShowInfoNew = bnx.getTShowInfoNew();
                if (this.lGG != null) {
                }
                if (this.lGF != null) {
                }
                this.lTh.setText(dY(bnx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lTh.setTag(R.id.tag_user_id, bnx.getUserId());
                this.lTh.setTag(R.id.tag_user_name, bnx.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0301, 1);
                if (!fVar.djq()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.djq()) {
                }
                z = false;
                if (fVar.diN().bnx() != null) {
                    dpD();
                    z = true;
                }
                this.lTk.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lTk.setVisibility(0);
                if (this.lTp != null) {
                }
                this.lTh.setOnClickListener(onClickListener);
                this.lTk.getHeadView().setUserId(bnx.getUserId());
                this.lTk.getHeadView().setUserName(bnx.getUserName());
                this.lTk.getHeadView().setTid(postData.getId());
                this.lTk.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lTk.getHeadView().setFName(fVar.getForumName());
                this.lTk.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bnx.getName_show();
                String userName2 = bnx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lTh.setText(com.baidu.tieba.pb.c.bb(this.lEi.getPageContext().getPageActivity(), this.lTh.getText().toString()));
                    this.lTh.setGravity(16);
                    this.lTh.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dix());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bnx.getIconInfo();
                    tShowInfoNew = bnx.getTShowInfoNew();
                    if (this.lGG != null) {
                    }
                    if (this.lGF != null) {
                    }
                    this.lTh.setText(dY(bnx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lTh.setTag(R.id.tag_user_id, bnx.getUserId());
                    this.lTh.setTag(R.id.tag_user_name, bnx.getName_show());
                    if (x.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0301, 1);
                    if (!fVar.djq()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.djq()) {
                    }
                    z = false;
                    if (fVar.diN().bnx() != null) {
                    }
                    this.lTk.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lTk.setVisibility(0);
                    if (this.lTp != null) {
                    }
                    this.lTh.setOnClickListener(onClickListener);
                    this.lTk.getHeadView().setUserId(bnx.getUserId());
                    this.lTk.getHeadView().setUserName(bnx.getUserName());
                    this.lTk.getHeadView().setTid(postData.getId());
                    this.lTk.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lTk.getHeadView().setFName(fVar.getForumName());
                    this.lTk.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bnx.getName_show();
                    String userName22 = bnx.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bnx.getIconInfo();
                tShowInfoNew = bnx.getTShowInfoNew();
                if (this.lGG != null) {
                }
                if (this.lGF != null) {
                }
                this.lTh.setText(dY(bnx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lTh.setTag(R.id.tag_user_id, bnx.getUserId());
                this.lTh.setTag(R.id.tag_user_name, bnx.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTh, R.color.CAM_X0301, 1);
                if (!fVar.djq()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.djq()) {
                }
                z = false;
                if (fVar.diN().bnx() != null) {
                }
                this.lTk.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lTk.setVisibility(0);
                if (this.lTp != null) {
                }
                this.lTh.setOnClickListener(onClickListener);
                this.lTk.getHeadView().setUserId(bnx.getUserId());
                this.lTk.getHeadView().setUserName(bnx.getUserName());
                this.lTk.getHeadView().setTid(postData.getId());
                this.lTk.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lTk.getHeadView().setFName(fVar.getForumName());
                this.lTk.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bnx.getName_show();
                String userName222 = bnx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lTe.aJ(fVar.diN());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.djt()) {
                this.lTq.setVisibility(0);
            }
            if (z) {
                this.lTq.setVisibility(8);
                if (fVar != null && fVar.diN() != null && fVar.diN().getBaijiahaoData() != null && fVar.diN().getBaijiahaoData().oriUgcType == 3) {
                    this.lTs.setVisibility(8);
                } else {
                    this.lTs.setVisibility(0);
                }
                this.lTs.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(fVar.djl())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bnx().hadConcerned()) {
                this.lTq.setVisibility(8);
                this.lTs.setVisibility(8);
            } else {
                this.lTs.setVisibility(8);
            }
            if (fVar.lBo || 3 == fVar.djt()) {
                this.lTq.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.bnx() != null) {
                postData.bnx().setIsLike(postData.bnx().hadConcerned());
            }
            if (this.lTr == null) {
                bz diN = fVar.diN();
                int i = 1;
                if (diN != null) {
                    if (diN.bme()) {
                        i = 4;
                    } else if (diN.bmf()) {
                        i = 6;
                    } else if (diN.bpw()) {
                        i = 7;
                    } else if (diN.bpv()) {
                        i = 5;
                    }
                }
                this.lTr = new an(this.lEi.getPageContext(), this.lTq, i);
                this.lTr.l(this.lEi.getUniqueId());
                this.lTr.setThreadData(diN);
            }
            if (postData != null && postData.bnx() != null) {
                postData.bnx().setIsLike(postData.bnx().hadConcerned());
                this.lTr.a(postData.bnx());
                this.lTr.setTid(threadId);
            }
            this.lTr.lPF = z2;
            this.lTr.FH(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bnS() != null) {
                this.lTg.setData(this.lEi.getPageContext(), fVar.diP().get(0).bnS(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.diN().getId(), this.lEi.blc() ? "FRS" : null));
                this.lTf.setPadding(this.lTf.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lTf.getPaddingRight(), this.lTf.getPaddingBottom());
                return;
            }
            this.lTg.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lEi.djV()) {
            this.lTx = 0;
            if (postData != null && postData.bnx() != null) {
                this.lTx = postData.bnx().getLevel_id();
            }
            if (this.lTx > 0 && !z) {
                this.lTj.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(this.lTj, BitmapHelper.getGradeResourceIdInEnterForum(this.lTx));
                return;
            }
            this.lTj.setVisibility(8);
            return;
        }
        this.lTj.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.djn()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lTf.getPaddingBottom();
            if (fVar.djq()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lTf.setPadding(this.lTf.getPaddingLeft(), dimens, this.lTf.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.lTf.getPaddingBottom();
        if (fVar != null && !fVar.diN().bmc() && fVar.djq() && (!StringUtils.isNull(fVar.diN().getTitle()) || fVar.diN().bog() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lTf.setPadding(this.lTf.getPaddingLeft(), dimens2, this.lTf.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lTf.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lTc);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lTc, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lTc);
        }
    }

    public void setVisibility(int i) {
        this.lTf.setVisibility(i);
    }

    private void dpD() {
        if (this.lTl != null) {
            this.lTl.setVisibility(0);
            this.lTl.setSpeed(0.8f);
            this.lTl.loop(true);
            this.lTl.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lTl.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lBp) {
            this.lTd.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lTd.setVisibility(0);
        } else if (z && z2) {
            this.lTd.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lTd.setVisibility(0);
        } else if (z) {
            this.lTd.setImageResource(R.drawable.pic_pb_refined_n);
            this.lTd.setVisibility(0);
        } else if (z2) {
            this.lTd.setImageResource(R.drawable.pic_pb_stick_n);
            this.lTd.setVisibility(0);
        } else {
            this.lTd.setVisibility(8);
        }
    }

    private SpannableStringBuilder dY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lEi.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> dpE() {
        SparseArray<Object> sparseArray = (SparseArray) this.lTf.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lTf.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dkn() {
        return this.lTe.dkn();
    }

    public void uA(boolean z) {
        this.lTe.uA(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lTj != null) {
            com.baidu.tbadk.core.util.ao.setImageResource(this.lTj, BitmapHelper.getGradeResourceIdInEnterForum(this.lTx));
        }
        if (this.lTq != null) {
            this.lTq.onChangeSkinType(i);
        }
        if (this.lTu != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTu, R.color.CAM_X0109);
        }
        if (this.lTt != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTt, R.color.CAM_X0109);
        }
        if (this.lTs != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTs, R.color.CAM_X0109);
        }
        if (this.lTw != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTw, R.color.CAM_X0109);
        }
        if (this.lTv != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTv, R.color.CAM_X0109);
        }
        if (this.lTl != null) {
            com.baidu.tbadk.core.util.ao.a(this.lTl, R.raw.card_live_header_bg);
        }
    }

    public void onDestroy() {
        if (this.lTb != null) {
            this.lTb.RS();
        }
        if (this.lTf != null && this.lTp != null) {
            this.lTf.removeView(this.lTm);
            this.lTp = null;
        }
        if (this.lTl != null) {
            this.lTl.cancelAnimation();
        }
    }

    public void doP() {
        if (this.lTb != null) {
            this.lTb.RS();
        }
    }
}
