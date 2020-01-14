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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class d {
    private LayerDrawable MV;
    private LayerDrawable MW;
    private com.baidu.tieba.pb.a.c dmA;
    private View.OnClickListener gon;
    private PbFragment iCe;
    private UserIconBox iEo;
    private UserIconBox iEp;
    private ImageView iPB;
    private HeadPendantView iPC;
    private TBLottieAnimationView iPD;
    private LinearLayout iPF;
    private LinearLayout iPG;
    private ao iPJ;
    private com.baidu.tieba.c.d iPt;
    private ImageView iPv;
    private com.baidu.tieba.pb.pb.main.e iPw;
    private ThreadSkinView iPy;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iPu = null;
    private ColumnLayout iPx = null;
    private TextView iPz = null;
    private TextView iPA = null;
    private FrameLayout iPE = null;
    private ClickableHeaderImageView iPH = null;
    private PbFirstFloorUserLikeButton iPI = null;
    private TextView iPK = null;
    private TextView iPL = null;
    private TextView iPM = null;
    private TextView iPN = null;
    private int iPO = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.gon = null;
        this.iCe = pbFragment;
        this.dmA = cVar;
        this.gon = onClickListener;
        int dimens = l.getDimens(this.iCe.getContext(), R.dimen.tbds6);
        this.MV = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(dimens).tw("#4D000000").aEP()});
        this.MW = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEP(), com.baidu.tbadk.core.util.f.a.b.aEN().kk(0).ag(dimens).tw("#4D000000").aEP()});
        initView();
    }

    private void initView() {
        this.iPu = (RelativeLayout) LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iPv = (ImageView) this.iPu.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iPv.getLayoutParams().height = ap.cnJ();
        this.iPw = new com.baidu.tieba.pb.pb.main.e(this.iCe.getBaseFragmentActivity(), this.iPu);
        this.iPw.init();
        this.iPw.setOnClickListener(this.iPw.ckn(), this.gon);
        this.iPx = (ColumnLayout) this.iPu.findViewById(R.id.pb_head_owner_root);
        this.iPy = (ThreadSkinView) this.iPu.findViewById(R.id.pb_thread_skin);
        this.iPz = (TextView) this.iPx.findViewById(R.id.pb_head_owner_info_user_name);
        this.iPz.getPaint().setFakeBoldText(true);
        this.iPA = (TextView) this.iPx.findViewById(R.id.floor_owner);
        this.iPB = (ImageView) this.iPx.findViewById(R.id.icon_forum_level);
        this.iPE = (FrameLayout) this.iPx.findViewById(R.id.pb_head_headImage_container);
        this.iPC = (HeadPendantView) this.iPx.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iPC.setHasPendantStyle();
        this.iPD = (TBLottieAnimationView) this.iPx.findViewById(R.id.pb_head_living_lottie);
        this.iPx.setOnLongClickListener(this.mOnLongClickListener);
        this.iPx.setOnTouchListener(this.dmA);
        this.iPx.setVisibility(8);
        if (this.iPC.getHeadView() != null) {
            this.iPC.getHeadView().setIsRound(true);
            this.iPC.getHeadView().setDrawBorder(false);
            this.iPC.getHeadView().setPlaceHolder(1);
        }
        this.iEo = (UserIconBox) this.iPx.findViewById(R.id.show_icon_vip);
        this.iEp = (UserIconBox) this.iPx.findViewById(R.id.show_icon_yinji);
        this.iPF = (LinearLayout) this.iPu.findViewById(R.id.pb_head_owner_info_root);
        this.iPG = (LinearLayout) this.iPx.findViewById(R.id.pb_first_floor_location_container);
        this.iPI = (PbFirstFloorUserLikeButton) this.iPx.findViewById(R.id.pb_like_button);
        this.iPK = (TextView) this.iPx.findViewById(R.id.pb_views);
        this.iPL = (TextView) this.iPx.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iPM = (TextView) this.iPx.findViewById(R.id.pb_item_first_floor_location_address);
        this.iPN = (TextView) this.iPx.findViewById(R.id.pb_item_first_floor_bjh_desc);
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
    public void a(int i, f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.azX() != null) {
            MetaData azX = postData.azX();
            String string = azX.getName_show() == null ? StringUtils.string(azX.getUserName()) : StringUtils.string(azX.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.azX().getSealPrefix())) {
                i2 = k.byteLength(azX.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = azX.getIconInfo();
                    tShowInfoNew = azX.getTShowInfoNew();
                    if (this.iEp != null) {
                        this.iEp.setTag(R.id.tag_user_id, azX.getUserId());
                        if (this.iCe.clM() != null) {
                            this.iEp.setOnClickListener(this.iCe.clM().iCz.iRh);
                        }
                        this.iEp.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iEo != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iEo.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iCe.clM() != null) {
                            this.iEo.setOnClickListener(this.iCe.clM().iCz.iRi);
                        }
                        this.iEo.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iPz.setText(cs(azX.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iPz.setTag(R.id.tag_user_id, azX.getUserId());
                    this.iPz.setTag(R.id.tag_user_name, azX.getName_show());
                    if (v.isEmpty(tShowInfoNew) || azX.isBigV()) {
                        am.setViewTextColor(this.iPz, R.color.cp_cont_h, 1);
                    } else {
                        am.setViewTextColor(this.iPz, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cjs()) {
                        this.iPA.setVisibility(8);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azX.getBawu_type())) {
                        this.iPA.setText(R.string.bawu_member_bazhu_tip);
                        this.iPA.setVisibility(0);
                        if (i == 1) {
                            if (this.MV.getDrawable(1) != null) {
                                this.MV.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MV.getDrawable(1) != null) {
                            this.MV.getDrawable(1).setAlpha(0);
                        }
                        this.iPA.setBackgroundDrawable(this.MV);
                        am.setViewTextColor(this.iPA, (int) R.color.cp_cont_a);
                    } else if (azX.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azX.getBawu_type())) {
                        this.iPA.setText(R.string.bawu_member_xbazhu_tip);
                        this.iPA.setVisibility(0);
                        if (i == 1) {
                            if (this.MW.getDrawable(1) != null) {
                                this.MW.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MW.getDrawable(1) != null) {
                            this.MW.getDrawable(1).setAlpha(0);
                        }
                        this.iPA.setBackgroundDrawable(this.MW);
                        am.setViewTextColor(this.iPA, (int) R.color.cp_cont_a);
                    } else {
                        this.iPA.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iPL.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iPL.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cjs()) {
                        this.iPM.setVisibility(8);
                        if (this.iPG.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iPG.getLayoutParams()).rightMargin = 0;
                        }
                        this.iPx.setSpacingRight(0);
                        String str = null;
                        if (azX.getBaijiahaoInfo() != null) {
                            str = azX.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iPN.setVisibility(0);
                            this.iPN.setText(str);
                        } else {
                            this.iPN.setVisibility(8);
                        }
                    } else {
                        this.iPN.setVisibility(8);
                        if (this.iPG.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iPG.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iPx.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f cJC = postData.cJC();
                        if (cJC != null && !TextUtils.isEmpty(cJC.getName()) && !TextUtils.isEmpty(cJC.getName().trim())) {
                            this.iPM.setVisibility(0);
                            this.iPM.setText(cJC.getName());
                        } else {
                            this.iPM.setVisibility(8);
                        }
                    }
                    if (fVar.ciS().azX() != null || fVar.ciS().azX().getAlaUserData() == null) {
                        z = false;
                    } else if (fVar.ciS().azX().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cpo();
                        z = true;
                    }
                    if (z) {
                        this.iPC.a(azX, 0);
                        this.iPC.setIsclearmode(false);
                    } else {
                        this.iPC.setIsclearmode(true);
                    }
                    this.iPC.setVisibility(0);
                    if (this.iPH != null) {
                        this.iPH.setVisibility(8);
                    }
                    this.iPz.setOnClickListener(onClickListener);
                    this.iPC.getHeadView().setUserId(azX.getUserId());
                    this.iPC.getHeadView().setUserName(azX.getUserName());
                    this.iPC.getHeadView().setTid(postData.getId());
                    this.iPC.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.iPC.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.iPC.tD(azX.getAvater());
                    } else {
                        this.iPC.a(azX);
                    }
                    String name_show = azX.getName_show();
                    String userName = azX.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iPz.setText(com.baidu.tieba.pb.d.ba(this.iCe.getPageContext().getPageActivity(), this.iPz.getText().toString()));
                        this.iPz.setGravity(16);
                        this.iPz.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.cix());
                        am.setViewTextColor(this.iPz, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = azX.getIconInfo();
                tShowInfoNew = azX.getTShowInfoNew();
                if (this.iEp != null) {
                }
                if (this.iEo != null) {
                }
                this.iPz.setText(cs(azX.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iPz.setTag(R.id.tag_user_id, azX.getUserId());
                this.iPz.setTag(R.id.tag_user_name, azX.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.iPz, R.color.cp_cont_h, 1);
                if (!fVar.cjs()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!fVar.cjs()) {
                }
                if (fVar.ciS().azX() != null) {
                }
                z = false;
                if (z) {
                }
                this.iPC.setVisibility(0);
                if (this.iPH != null) {
                }
                this.iPz.setOnClickListener(onClickListener);
                this.iPC.getHeadView().setUserId(azX.getUserId());
                this.iPC.getHeadView().setUserName(azX.getUserName());
                this.iPC.getHeadView().setTid(postData.getId());
                this.iPC.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.iPC.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = azX.getName_show();
                String userName2 = azX.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iPz.setText(com.baidu.tieba.pb.d.ba(this.iCe.getPageContext().getPageActivity(), this.iPz.getText().toString()));
                    this.iPz.setGravity(16);
                    this.iPz.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.cix());
                    am.setViewTextColor(this.iPz, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = azX.getIconInfo();
                    tShowInfoNew = azX.getTShowInfoNew();
                    if (this.iEp != null) {
                    }
                    if (this.iEo != null) {
                    }
                    this.iPz.setText(cs(azX.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iPz.setTag(R.id.tag_user_id, azX.getUserId());
                    this.iPz.setTag(R.id.tag_user_name, azX.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    am.setViewTextColor(this.iPz, R.color.cp_cont_h, 1);
                    if (!fVar.cjs()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!fVar.cjs()) {
                    }
                    if (fVar.ciS().azX() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.iPC.setVisibility(0);
                    if (this.iPH != null) {
                    }
                    this.iPz.setOnClickListener(onClickListener);
                    this.iPC.getHeadView().setUserId(azX.getUserId());
                    this.iPC.getHeadView().setUserName(azX.getUserName());
                    this.iPC.getHeadView().setTid(postData.getId());
                    this.iPC.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.iPC.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = azX.getName_show();
                    String userName22 = azX.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = azX.getIconInfo();
                tShowInfoNew = azX.getTShowInfoNew();
                if (this.iEp != null) {
                }
                if (this.iEo != null) {
                }
                this.iPz.setText(cs(azX.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iPz.setTag(R.id.tag_user_id, azX.getUserId());
                this.iPz.setTag(R.id.tag_user_name, azX.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.iPz, R.color.cp_cont_h, 1);
                if (!fVar.cjs()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!fVar.cjs()) {
                }
                if (fVar.ciS().azX() != null) {
                }
                z = false;
                if (z) {
                }
                this.iPC.setVisibility(0);
                if (this.iPH != null) {
                }
                this.iPz.setOnClickListener(onClickListener);
                this.iPC.getHeadView().setUserId(azX.getUserId());
                this.iPC.getHeadView().setUserName(azX.getUserName());
                this.iPC.getHeadView().setTid(postData.getId());
                this.iPC.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.iPC.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = azX.getName_show();
                String userName222 = azX.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.iPw.aB(fVar.ciS());
        }
    }

    public void a(f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cjv()) {
                this.iPI.setVisibility(0);
            }
            if (z) {
                this.iPI.setVisibility(8);
                if (fVar != null && fVar.ciS() != null && fVar.ciS().getBaijiahaoData() != null && fVar.ciS().getBaijiahaoData().oriUgcType == 3) {
                    this.iPK.setVisibility(8);
                } else {
                    this.iPK.setVisibility(0);
                }
                this.iPK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(fVar.cjn())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.azX().hadConcerned()) {
                this.iPI.setVisibility(8);
                this.iPK.setVisibility(8);
            } else {
                this.iPK.setVisibility(8);
            }
            if (fVar.izM || 3 == fVar.cjv()) {
                this.iPI.setVisibility(8);
            }
        }
    }

    public void a(f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int z3 = z(fVar);
            if (z && postData != null && postData.azX() != null) {
                postData.azX().setIsLike(postData.azX().hadConcerned());
            }
            if (this.iPJ == null) {
                bj ciS = fVar.ciS();
                int i = 1;
                if (ciS != null) {
                    if (ciS.ayL()) {
                        i = 4;
                    } else if (ciS.aBS()) {
                        i = 6;
                    } else if (ciS.aBU()) {
                        i = 7;
                    } else if (ciS.aBT()) {
                        i = 5;
                    }
                }
                this.iPJ = new ao(this.iCe.getPageContext(), this.iPI, i);
                this.iPJ.j(this.iCe.getUniqueId());
                this.iPJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fO(boolean z4) {
                        if (d.this.iCe != null && z4) {
                            l.showToast(d.this.iCe.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.azX() != null) {
                postData.azX().setIsLike(postData.azX().hadConcerned());
                this.iPJ.a(postData.azX());
                this.iPJ.setTid(threadId);
            }
            this.iPJ.iMi = z2;
            this.iPJ.yW(z3);
        }
    }

    public int z(f fVar) {
        if (fVar == null || fVar.ciS() == null) {
            return 0;
        }
        if (fVar.ciS().aBr()) {
            return (v.isEmpty(fVar.cjm()) && (fVar.ciR() == null || StringUtils.isNull(fVar.ciR().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, f fVar) {
        if (postData != null && fVar != null) {
            if (postData.aAs() != null) {
                this.iPy.setData(this.iCe.getPageContext(), fVar.ciU().get(0).aAs(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.ciS().getId(), this.iCe.aBO() ? "FRS" : null));
                this.iPx.setPadding(this.iPx.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iPx.getPaddingRight(), this.iPx.getPaddingBottom());
                return;
            }
            this.iPy.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iCe.cjR()) {
            this.iPO = 0;
            if (postData != null && postData.azX() != null) {
                this.iPO = postData.azX().getLevel_id();
            }
            if (this.iPO > 0 && !z) {
                this.iPB.setVisibility(0);
                am.setImageResource(this.iPB, BitmapHelper.getGradeResourceIdInEnterForum(this.iPO));
                return;
            }
            this.iPB.setVisibility(8);
            return;
        }
        this.iPB.setVisibility(8);
    }

    public void A(f fVar) {
        if (fVar != null && fVar.cjp()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iPx.getPaddingBottom();
            if (fVar.cjs()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iPx.setPadding(this.iPx.getPaddingLeft(), dimens, this.iPx.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iPx.getPaddingBottom();
        if (fVar != null && !fVar.ciS().aAX() && fVar.cjs() && (!StringUtils.isNull(fVar.ciS().getTitle()) || fVar.ciS().aAE() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iPx.setPadding(this.iPx.getPaddingLeft(), dimens2, this.iPx.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iPx.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iPu);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iPu, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iPu);
        }
    }

    public void setVisibility(int i) {
        this.iPx.setVisibility(i);
    }

    private void cpo() {
        if (this.iPD != null) {
            this.iPD.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iPD.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.iCe.clM(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.iCe.clM(), R.dimen.ds8);
            this.iPD.setLayoutParams(layoutParams);
            this.iPD.loop(true);
            this.iPD.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iPD.playAnimation();
                }
            });
        }
    }

    public void d(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.izN) {
            this.iPv.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iPv.setVisibility(0);
        } else if (z && z2) {
            this.iPv.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iPv.setVisibility(0);
        } else if (z) {
            this.iPv.setImageResource(R.drawable.pic_pb_refined_n);
            this.iPv.setVisibility(0);
        } else if (z2) {
            this.iPv.setImageResource(R.drawable.pic_pb_stick_n);
            this.iPv.setVisibility(0);
        } else {
            this.iPv.setVisibility(8);
        }
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iCe.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cpp() {
        SparseArray<Object> sparseArray = (SparseArray) this.iPx.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iPx.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView ckn() {
        return this.iPw.ckn();
    }

    public void py(boolean z) {
        this.iPw.py(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iPB != null) {
            am.setImageResource(this.iPB, BitmapHelper.getGradeResourceIdInEnterForum(this.iPO));
        }
        if (this.iPI != null) {
            this.iPI.onChangeSkinType(i);
        }
        if (this.iPM != null) {
            am.setViewTextColor(this.iPM, (int) R.color.cp_cont_d);
        }
        if (this.iPL != null) {
            am.setViewTextColor(this.iPL, (int) R.color.cp_cont_d);
        }
        if (this.iPK != null) {
            am.setViewTextColor(this.iPK, (int) R.color.cp_cont_d);
        }
        if (this.iPN != null) {
            am.setViewTextColor(this.iPN, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.iPD != null) {
                this.iPD.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.iPD != null) {
                this.iPD.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.iPD != null) {
            this.iPD.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.iPt != null) {
            this.iPt.xg();
        }
        if (this.iPx != null && this.iPH != null) {
            this.iPx.removeView(this.iPE);
            this.iPH = null;
        }
        if (this.iPD != null) {
            this.iPD.cancelAnimation();
        }
    }

    public void coF() {
        if (this.iPt != null) {
            this.iPt.xg();
        }
    }
}
