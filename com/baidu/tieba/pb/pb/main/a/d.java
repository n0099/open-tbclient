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
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class d {
    private LayerDrawable Nu;
    private LayerDrawable Nv;
    private com.baidu.tieba.pb.a.c dqX;
    private View.OnClickListener gqD;
    private PbFragment iEk;
    private UserIconBox iGg;
    private UserIconBox iGh;
    private com.baidu.tieba.c.d iRc;
    private ImageView iRe;
    private com.baidu.tieba.pb.pb.main.e iRf;
    private ThreadSkinView iRh;
    private ImageView iRk;
    private HeadPendantView iRl;
    private TBLottieAnimationView iRm;
    private LinearLayout iRo;
    private LinearLayout iRp;
    private al iRs;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iRd = null;
    private ColumnLayout iRg = null;
    private TextView iRi = null;
    private TextView iRj = null;
    private FrameLayout iRn = null;
    private ClickableHeaderImageView iRq = null;
    private PbFirstFloorUserLikeButton iRr = null;
    private TextView iRt = null;
    private TextView iRu = null;
    private TextView iRv = null;
    private TextView iRw = null;
    private int iRx = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.gqD = null;
        this.iEk = pbFragment;
        this.dqX = cVar;
        this.gqD = onClickListener;
        int dimens = l.getDimens(this.iEk.getContext(), R.dimen.tbds6);
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(dimens).tN("#4D000000").aHe()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(dimens).tN("#4D000000").aHe()});
        initView();
    }

    private void initView() {
        this.iRd = (RelativeLayout) LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iRe = (ImageView) this.iRd.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iRe.getLayoutParams().height = am.cpd();
        this.iRf = new com.baidu.tieba.pb.pb.main.e(this.iEk.getBaseFragmentActivity(), this.iRd);
        this.iRf.init();
        this.iRf.setOnClickListener(this.iRf.clM(), this.gqD);
        this.iRg = (ColumnLayout) this.iRd.findViewById(R.id.pb_head_owner_root);
        this.iRh = (ThreadSkinView) this.iRd.findViewById(R.id.pb_thread_skin);
        this.iRi = (TextView) this.iRg.findViewById(R.id.pb_head_owner_info_user_name);
        this.iRi.getPaint().setFakeBoldText(true);
        this.iRj = (TextView) this.iRg.findViewById(R.id.floor_owner);
        this.iRk = (ImageView) this.iRg.findViewById(R.id.icon_forum_level);
        this.iRn = (FrameLayout) this.iRg.findViewById(R.id.pb_head_headImage_container);
        this.iRl = (HeadPendantView) this.iRg.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iRl.setHasPendantStyle();
        this.iRm = (TBLottieAnimationView) this.iRg.findViewById(R.id.pb_head_living_lottie);
        this.iRg.setOnLongClickListener(this.mOnLongClickListener);
        this.iRg.setOnTouchListener(this.dqX);
        this.iRg.setVisibility(8);
        if (this.iRl.getHeadView() != null) {
            this.iRl.getHeadView().setIsRound(true);
            this.iRl.getHeadView().setDrawBorder(false);
            this.iRl.getHeadView().setPlaceHolder(1);
        }
        this.iGg = (UserIconBox) this.iRg.findViewById(R.id.show_icon_vip);
        this.iGh = (UserIconBox) this.iRg.findViewById(R.id.show_icon_yinji);
        this.iRo = (LinearLayout) this.iRd.findViewById(R.id.pb_head_owner_info_root);
        this.iRp = (LinearLayout) this.iRg.findViewById(R.id.pb_first_floor_location_container);
        this.iRr = (PbFirstFloorUserLikeButton) this.iRg.findViewById(R.id.pb_like_button);
        this.iRt = (TextView) this.iRg.findViewById(R.id.pb_views);
        this.iRu = (TextView) this.iRg.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iRv = (TextView) this.iRg.findViewById(R.id.pb_item_first_floor_location_address);
        this.iRw = (TextView) this.iRg.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.e eVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aCo() != null) {
            MetaData aCo = postData.aCo();
            String string = aCo.getName_show() == null ? StringUtils.string(aCo.getUserName()) : StringUtils.string(aCo.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aCo().getSealPrefix())) {
                i2 = k.byteLength(aCo.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aCo.getIconInfo();
                    tShowInfoNew = aCo.getTShowInfoNew();
                    if (this.iGh != null) {
                        this.iGh.setTag(R.id.tag_user_id, aCo.getUserId());
                        if (this.iEk.cnj() != null) {
                            this.iGh.setOnClickListener(this.iEk.cnj().iEw.iSQ);
                        }
                        this.iGh.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iGg != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iGg.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iEk.cnj() != null) {
                            this.iGg.setOnClickListener(this.iEk.cnj().iEw.iSR);
                        }
                        this.iGg.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iRi.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iRi.setTag(R.id.tag_user_id, aCo.getUserId());
                    this.iRi.setTag(R.id.tag_user_name, aCo.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aCo.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.ckT()) {
                        this.iRj.setVisibility(8);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        this.iRj.setText(R.string.bawu_member_bazhu_tip);
                        this.iRj.setVisibility(0);
                        if (i == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        this.iRj.setBackgroundDrawable(this.Nu);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iRj, (int) R.color.cp_cont_a);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        this.iRj.setText(R.string.bawu_member_xbazhu_tip);
                        this.iRj.setVisibility(0);
                        if (i == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        this.iRj.setBackgroundDrawable(this.Nv);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iRj, (int) R.color.cp_cont_a);
                    } else {
                        this.iRj.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iRu.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iRu.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.ckT()) {
                        this.iRv.setVisibility(8);
                        if (this.iRp.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRp.getLayoutParams()).rightMargin = 0;
                        }
                        this.iRg.setSpacingRight(0);
                        String str = null;
                        if (aCo.getBaijiahaoInfo() != null) {
                            str = aCo.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iRw.setVisibility(0);
                            this.iRw.setText(str);
                        } else {
                            this.iRw.setVisibility(8);
                        }
                    } else {
                        this.iRw.setVisibility(8);
                        if (this.iRp.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRp.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iRg.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cLe = postData.cLe();
                        if (cLe != null && !TextUtils.isEmpty(cLe.getName()) && !TextUtils.isEmpty(cLe.getName().trim())) {
                            this.iRv.setVisibility(0);
                            this.iRv.setText(cLe.getName());
                        } else {
                            this.iRv.setVisibility(8);
                        }
                    }
                    if (eVar.ckv().aCo() != null || eVar.ckv().aCo().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.ckv().aCo().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cqJ();
                        z = true;
                    }
                    if (z) {
                        this.iRl.a(aCo, 0);
                        this.iRl.setIsclearmode(false);
                    } else {
                        this.iRl.setIsclearmode(true);
                    }
                    this.iRl.setVisibility(0);
                    if (this.iRq != null) {
                        this.iRq.setVisibility(8);
                    }
                    this.iRi.setOnClickListener(onClickListener);
                    this.iRl.getHeadView().setUserId(aCo.getUserId());
                    this.iRl.getHeadView().setUserName(aCo.getUserName());
                    this.iRl.getHeadView().setTid(postData.getId());
                    this.iRl.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iRl.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.iRl.tU(aCo.getAvater());
                    } else {
                        this.iRl.a(aCo);
                    }
                    String name_show = aCo.getName_show();
                    String userName = aCo.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iRi.setText(com.baidu.tieba.pb.c.ba(this.iEk.getPageContext().getPageActivity(), this.iRi.getText().toString()));
                        this.iRi.setGravity(16);
                        this.iRi.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cke());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aCo.getIconInfo();
                tShowInfoNew = aCo.getTShowInfoNew();
                if (this.iGh != null) {
                }
                if (this.iGg != null) {
                }
                this.iRi.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iRi.setTag(R.id.tag_user_id, aCo.getUserId());
                this.iRi.setTag(R.id.tag_user_name, aCo.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_cont_h, 1);
                if (!eVar.ckT()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckT()) {
                }
                if (eVar.ckv().aCo() != null) {
                }
                z = false;
                if (z) {
                }
                this.iRl.setVisibility(0);
                if (this.iRq != null) {
                }
                this.iRi.setOnClickListener(onClickListener);
                this.iRl.getHeadView().setUserId(aCo.getUserId());
                this.iRl.getHeadView().setUserName(aCo.getUserName());
                this.iRl.getHeadView().setTid(postData.getId());
                this.iRl.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iRl.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aCo.getName_show();
                String userName2 = aCo.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iRi.setText(com.baidu.tieba.pb.c.ba(this.iEk.getPageContext().getPageActivity(), this.iRi.getText().toString()));
                    this.iRi.setGravity(16);
                    this.iRi.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cke());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aCo.getIconInfo();
                    tShowInfoNew = aCo.getTShowInfoNew();
                    if (this.iGh != null) {
                    }
                    if (this.iGg != null) {
                    }
                    this.iRi.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iRi.setTag(R.id.tag_user_id, aCo.getUserId());
                    this.iRi.setTag(R.id.tag_user_name, aCo.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_cont_h, 1);
                    if (!eVar.ckT()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!eVar.ckT()) {
                    }
                    if (eVar.ckv().aCo() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.iRl.setVisibility(0);
                    if (this.iRq != null) {
                    }
                    this.iRi.setOnClickListener(onClickListener);
                    this.iRl.getHeadView().setUserId(aCo.getUserId());
                    this.iRl.getHeadView().setUserName(aCo.getUserName());
                    this.iRl.getHeadView().setTid(postData.getId());
                    this.iRl.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iRl.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aCo.getName_show();
                    String userName22 = aCo.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aCo.getIconInfo();
                tShowInfoNew = aCo.getTShowInfoNew();
                if (this.iGh != null) {
                }
                if (this.iGg != null) {
                }
                this.iRi.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iRi.setTag(R.id.tag_user_id, aCo.getUserId());
                this.iRi.setTag(R.id.tag_user_name, aCo.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, R.color.cp_cont_h, 1);
                if (!eVar.ckT()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckT()) {
                }
                if (eVar.ckv().aCo() != null) {
                }
                z = false;
                if (z) {
                }
                this.iRl.setVisibility(0);
                if (this.iRq != null) {
                }
                this.iRi.setOnClickListener(onClickListener);
                this.iRl.getHeadView().setUserId(aCo.getUserId());
                this.iRl.getHeadView().setUserName(aCo.getUserName());
                this.iRl.getHeadView().setTid(postData.getId());
                this.iRl.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iRl.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aCo.getName_show();
                String userName222 = aCo.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.iRf.aF(eVar.ckv());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.ckW()) {
                this.iRr.setVisibility(0);
            }
            if (z) {
                this.iRr.setVisibility(8);
                if (eVar != null && eVar.ckv() != null && eVar.ckv().getBaijiahaoData() != null && eVar.ckv().getBaijiahaoData().oriUgcType == 3) {
                    this.iRt.setVisibility(8);
                } else {
                    this.iRt.setVisibility(0);
                }
                this.iRt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.ckP())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCo().hadConcerned()) {
                this.iRr.setVisibility(8);
                this.iRt.setVisibility(8);
            } else {
                this.iRt.setVisibility(8);
            }
            if (eVar.iBS || 3 == eVar.ckW()) {
                this.iRr.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aCo() != null) {
                postData.aCo().setIsLike(postData.aCo().hadConcerned());
            }
            if (this.iRs == null) {
                bj ckv = eVar.ckv();
                int i = 1;
                if (ckv != null) {
                    if (ckv.aBd()) {
                        i = 4;
                    } else if (ckv.aBe()) {
                        i = 6;
                    } else if (ckv.aEh()) {
                        i = 7;
                    } else if (ckv.aEg()) {
                        i = 5;
                    }
                }
                this.iRs = new al(this.iEk.getPageContext(), this.iRr, i);
                this.iRs.j(this.iEk.getUniqueId());
                this.iRs.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z3) {
                        if (d.this.iEk != null && z3) {
                            l.showToast(d.this.iEk.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.aCo() != null) {
                postData.aCo().setIsLike(postData.aCo().hadConcerned());
                this.iRs.a(postData.aCo());
                this.iRs.setTid(threadId);
            }
            this.iRs.iNQ = z2;
            this.iRs.zc(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckv() == null) {
            return 0;
        }
        if (eVar.ckv().aDG()) {
            return (v.isEmpty(eVar.ckO()) && (eVar.cku() == null || StringUtils.isNull(eVar.cku().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aCJ() != null) {
                this.iRh.setData(this.iEk.getPageContext(), eVar.ckx().get(0).aCJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.ckv().getId(), this.iEk.aEc() ? "FRS" : null));
                this.iRg.setPadding(this.iRg.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iRg.getPaddingRight(), this.iRg.getPaddingBottom());
                return;
            }
            this.iRh.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iEk.cls()) {
            this.iRx = 0;
            if (postData != null && postData.aCo() != null) {
                this.iRx = postData.aCo().getLevel_id();
            }
            if (this.iRx > 0 && !z) {
                this.iRk.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.iRk, BitmapHelper.getGradeResourceIdInEnterForum(this.iRx));
                return;
            }
            this.iRk.setVisibility(8);
            return;
        }
        this.iRk.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aHL()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iRg.getPaddingBottom();
            if (eVar.ckT()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iRg.setPadding(this.iRg.getPaddingLeft(), dimens, this.iRg.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iRg.getPaddingBottom();
        if (eVar != null && !eVar.ckv().aBb() && eVar.ckT() && (!StringUtils.isNull(eVar.ckv().getTitle()) || eVar.ckv().aCV() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iRg.setPadding(this.iRg.getPaddingLeft(), dimens2, this.iRg.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iRg.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iRd);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iRd, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iRd);
        }
    }

    public void setVisibility(int i) {
        this.iRg.setVisibility(i);
    }

    private void cqJ() {
        if (this.iRm != null) {
            this.iRm.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iRm.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.iEk.cnj(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.iEk.cnj(), R.dimen.ds8);
            this.iRm.setLayoutParams(layoutParams);
            this.iRm.loop(true);
            this.iRm.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iRm.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBT) {
            this.iRe.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iRe.setVisibility(0);
        } else if (z && z2) {
            this.iRe.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iRe.setVisibility(0);
        } else if (z) {
            this.iRe.setImageResource(R.drawable.pic_pb_refined_n);
            this.iRe.setVisibility(0);
        } else if (z2) {
            this.iRe.setImageResource(R.drawable.pic_pb_stick_n);
            this.iRe.setVisibility(0);
        } else {
            this.iRe.setVisibility(8);
        }
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iEk.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cqK() {
        SparseArray<Object> sparseArray = (SparseArray) this.iRg.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iRg.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView clM() {
        return this.iRf.clM();
    }

    public void pB(boolean z) {
        this.iRf.pB(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iRk != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.iRk, BitmapHelper.getGradeResourceIdInEnterForum(this.iRx));
        }
        if (this.iRr != null) {
            this.iRr.onChangeSkinType(i);
        }
        if (this.iRv != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRv, (int) R.color.cp_cont_d);
        }
        if (this.iRu != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRu, (int) R.color.cp_cont_d);
        }
        if (this.iRt != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRt, (int) R.color.cp_cont_d);
        }
        if (this.iRw != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRw, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.iRm != null) {
                this.iRm.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.iRm != null) {
                this.iRm.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.iRm != null) {
            this.iRm.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.iRc != null) {
            this.iRc.zz();
        }
        if (this.iRg != null && this.iRq != null) {
            this.iRg.removeView(this.iRn);
            this.iRq = null;
        }
        if (this.iRm != null) {
            this.iRm.cancelAnimation();
        }
    }

    public void cpZ() {
        if (this.iRc != null) {
            this.iRc.zz();
        }
    }
}
