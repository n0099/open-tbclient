package com.baidu.tieba.pb.pb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> lCM = new SparseArray<>();
    private static SparseIntArray lCN = new SparseIntArray();
    public static final int amd = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lCN.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lCN.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, f fVar, boolean z) {
        if (nVar != null) {
            if (nVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ap.setViewTextColor(nVar.hPN, R.color.CAM_X0106, 1);
                ap.setViewTextColor(nVar.lFw, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lFx, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lFy, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lFS, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lFz, R.color.CAM_X0109, 1);
                nVar.lFC.setTextColor(ap.getColor(R.color.CAM_X0105));
                nVar.lFD.onChangeSkinType();
                if (z) {
                    SvgManager.btW().a(nVar.lFX, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lFP, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lFN, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.lFO, R.color.CAM_X0109);
                    ap.setViewTextColor(nVar.lFQ, R.color.CAM_X0109);
                }
                WebPManager.a(nVar.lFI, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.jYo, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.lFG, R.color.CAM_X0108);
                    nVar.lFG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ap.setViewTextColor(nVar.lFH, R.color.CAM_X0108);
                    ap.d(nVar.lFF, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    nVar.lFF.onChangeSkinType();
                    ap.setViewTextColor(nVar.lGc, R.color.CAM_X0304, 1);
                    ap.setViewTextColor(nVar.lGa, R.color.CAM_X0106, 1);
                    ap.setBackgroundResource(nVar.lFZ, R.color.CAM_X0205);
                    ap.setBackgroundResource(nVar.lGb, R.color.CAM_X0109);
                    ap.setImageResource(nVar.lGd, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.lGg, R.color.CAM_X0107);
                    if (nVar.lGe.getVisibility() == 8) {
                        nVar.lFG.setVisibility(8);
                        nVar.lFH.setVisibility(8);
                        nVar.lGg.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dnf())) {
                        nVar.lGg.setText(fVar.dnf());
                    } else {
                        nVar.lGg.setText(R.string.expand_content);
                    }
                } else {
                    nVar.lFF.setVisibility(8);
                    nVar.lFG.setVisibility(8);
                    nVar.lFH.setVisibility(8);
                    nVar.lFZ.setVisibility(8);
                    nVar.lGg.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.CAM_X0203);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, by byVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bqI() != null) {
            if (byVar != null) {
                postData.bqI().threadId = byVar.getTid();
                postData.bqI().forumId = String.valueOf(byVar.getFid());
            }
            if (i == 0) {
                postData.bqI().objType = 1;
            } else {
                postData.bqI().objType = 2;
            }
            postData.bqI().isInPost = true;
            if (z) {
                nVar.lFR.setAgreeAlone(true);
                nVar.lFR.setData(postData.bqI());
            }
            if (byVar != null && byVar.bnz()) {
                nVar.lFA.setAgreeAlone(true);
            }
            nVar.lFA.setData(postData.bqI());
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jYo != null && postData != null) {
            if (z2) {
                nVar.jYo.setVisibility(8);
                if (z) {
                    if (d.bki()) {
                        string = postData.dPl() > 0 ? String.valueOf(postData.dPl()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.lFQ.setText(string);
                    return;
                }
                return;
            }
            nVar.jYo.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, by byVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (byVar != null && byVar.bnz()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.boP() != null) {
                MetaData boP = postData.boP();
                if (str != null && !str.equals("0") && str.equals(boP.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.bm(textView).pA(R.string.J_X04).pD(R.dimen.L_X01).ps(R.color.CAM_X0302).pC(R.color.CAM_X0302);
                } else if (boP.getIs_bawu() == 1 && postData.dOZ()) {
                    c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                    c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                    c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_content_assist".equals(boP.getBawu_type())) {
                    c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_manage_assist".equals(boP.getBawu_type())) {
                    c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x048a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, int i, a aVar, by byVar, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (nVar != null && postData != null) {
            if (postData.boP() == null || postData.boP().isBaijiahaoUser()) {
            }
            if (postData.nmu) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.CAM_X0204);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (byVar == null || byVar.boP() == null) {
                str = null;
            } else {
                str = byVar.boP().getUserId();
            }
            nVar.lFB.setTag(null);
            nVar.lFB.setUserId(null);
            nVar.hPN.setText((CharSequence) null);
            nVar.lFU.getHeadView().setUserId(null);
            nVar.lFC.setIsHost(false);
            if (postData.boP() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.boP().getUserId())) {
                    nVar.lFC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.boP().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.boP().getTShowInfoNew();
                if (nVar.lFW != null) {
                    nVar.lFW.setTag(R.id.tag_user_id, postData.boP().getUserId());
                    nVar.lFW.setOnClickListener(aVar.doc().lUm);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lFW.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lFV != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lFV.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.lFV.setOnClickListener(aVar.doc().lUn);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lFV.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.boP().isBigV()) {
                    ap.setViewTextColor(nVar.hPN, R.color.CAM_X0301, 1);
                } else {
                    ap.setViewTextColor(nVar.hPN, R.color.CAM_X0106, 1);
                }
                String avater = postData.boP().getAvater();
                nVar.hPN.setTag(R.id.tag_user_id, postData.boP().getUserId());
                nVar.hPN.setTag(R.id.tag_user_name, postData.boP().getUserName());
                nVar.hPN.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                String name_show = postData.boP().getName_show();
                String userName = postData.boP().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hPN.setText(com.baidu.tieba.pb.c.aV(aVar.getPageContext().getPageActivity(), nVar.hPN.getText().toString()));
                    nVar.hPN.setGravity(16);
                    nVar.hPN.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmE());
                    ap.setViewTextColor(nVar.hPN, R.color.CAM_X0312, 1);
                }
                if (postData.boP().getPendantData() != null && !StringUtils.isNull(postData.boP().getPendantData().bmL())) {
                    nVar.lFU.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lFU.a(postData.boP(), 4);
                    nVar.lFB.setVisibility(8);
                    nVar.lFU.setVisibility(0);
                    nVar.lFU.getHeadView().startLoad(avater, 28, false);
                    nVar.lFU.getHeadView().setUserId(postData.boP().getUserId());
                    nVar.lFU.getHeadView().setUserName(postData.boP().getUserName());
                    nVar.lFU.Cw(postData.boP().getPendantData().bmL());
                } else {
                    nVar.lFB.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lFB, postData.boP(), 4);
                    nVar.lFB.setUserId(postData.boP().getUserId());
                    nVar.lFB.setUserName(postData.boP().getUserName(), postData.dPr());
                    nVar.lFB.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                    nVar.lFB.setImageDrawable(null);
                    nVar.lFB.startLoad(avater, 28, false);
                    nVar.lFB.setVisibility(0);
                    nVar.lFU.setVisibility(8);
                }
                a(nVar.lFv, postData, str, byVar);
            }
            int i2 = 0;
            if (aVar.dod() && postData.boP() != null) {
                i2 = postData.boP().getLevel_id();
            }
            if (byVar != null && byVar.bnz()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.lFT.setVisibility(0);
                ap.setImageResource(nVar.lFT, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.lFT.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.lFW.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.lFW.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.lFv.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.lFV.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.boP() != null ? postData.boP().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.boP() != null && !StringUtils.isNull(postData.boP().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.boP() != null && !StringUtils.isNull(postData.boP().getSealPrefix())) {
                nVar.hPN.setText(a(aVar, postData.boP().getSealPrefix(), name_show2));
            } else {
                nVar.hPN.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPh()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.boP() == null || StringUtils.isNull(postData.boP().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (byVar != null && aVar.dof() != 0) {
                if (aVar.dof() != 1002 && aVar.dof() != 3) {
                    z9 = true;
                }
                if (aVar.dof() != 3 && !byVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.boP() != null) {
                    String userId2 = postData.boP().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (byVar != null && byVar.boP() != null && postData.boP() != null) {
                            userId = byVar.boP().getUserId();
                            String userId3 = postData.boP().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.boP() != null && UtilHelper.isCurrentAccount(postData.boP().getUserId())) {
                                    z7 = true;
                                    z8 = true;
                                } else {
                                    z7 = z11;
                                    z8 = z5;
                                }
                                if (z2) {
                                    z3 = false;
                                    z8 = false;
                                    z6 = false;
                                }
                                int i4 = 1;
                                if (postData.dPh() == 1) {
                                    i4 = 0;
                                }
                                if (byVar != null && byVar.bnz()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dof()));
                                    if (postData.boP() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.boP() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.boP().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.boP().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.boP().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, byVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && byVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dof()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lFC.setTag(sparseArray);
                                if (z) {
                                    nVar.lFX.setTag(sparseArray);
                                    return;
                                }
                                return;
                            }
                        }
                        z5 = z4;
                        z6 = false;
                        if (postData == null) {
                        }
                        z7 = z11;
                        z8 = z5;
                        if (z2) {
                        }
                        int i42 = 1;
                        if (postData.dPh() == 1) {
                        }
                        if (byVar != null) {
                            z3 = false;
                            z6 = false;
                        }
                        if (z3) {
                        }
                        if (z6) {
                        }
                        if (!z8) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        nVar.lFC.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (byVar != null) {
                userId = byVar.boP().getUserId();
                String userId32 = postData.boP().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z5 = z4;
            z6 = false;
            if (postData == null) {
            }
            z7 = z11;
            z8 = z5;
            if (z2) {
            }
            int i422 = 1;
            if (postData.dPh() == 1) {
            }
            if (byVar != null) {
            }
            if (z3) {
            }
            if (z6) {
            }
            if (!z8) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            nVar.lFC.setTag(sparseArray);
            if (z) {
            }
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            if (z2) {
                tbRichTextView.getLayoutStrategy().to(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().to(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fPo = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().tp((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().tp((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.lFC.EZ(null);
                nVar.lFC.setBackgroundDrawable(null);
                nVar.lFC.getLayoutStrategy().tq(R.drawable.transparent_bg);
            } else {
                nVar.lFC.getLayoutStrategy().tq(R.drawable.icon_click);
            }
            nVar.lFC.getLayoutStrategy().tn(R.drawable.pic_video);
            a(nVar.lFC, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.lFC.setLayoutParams(layoutParams);
            nVar.lFC.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            nVar.lFC.setIsFromCDN(z3);
            nVar.lFC.setText(postData.dPj(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.lFC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.lFC.setTag(sparseArray);
            nVar.lFu.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, by byVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dPh() > 0 && byVar != null && !byVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dPh()));
                nVar.lFS.setVisibility(0);
                nVar.lFS.setText(format);
                z = true;
            } else {
                nVar.lFS.setVisibility(8);
                z = false;
            }
            g dPk = postData.dPk();
            boolean z2 = (dPk == null || StringUtils.isNull(dPk.getName()) || byVar == null || byVar.isBjh()) ? false : true;
            if (z) {
                nVar.lFx.setVisibility(0);
                i = amd;
            } else {
                nVar.lFx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lFy.setVisibility(0);
                i2 = amd;
            } else {
                nVar.lFy.setVisibility(8);
                i2 = 0;
            }
            nVar.lFw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lFw.setText(au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lFw.setText(au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lFz.setVisibility(0);
                nVar.lFz.setPadding(amd, 0, 0, 0);
                nVar.lFz.setText(dPk.getName());
                return;
            }
            nVar.lFz.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData) {
        if (postData == null || postData.duZ() == null) {
            nVar.lFY.setVisibility(8);
            return;
        }
        TbRichText dPj = postData.dPj();
        com.baidu.tieba.pb.view.b.a(postData.duZ(), nVar.lFY, false, false, dPj != null && StringUtils.isNull(dPj.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lFC.setLayoutParams(layoutParams);
            nVar.lFC.setPadding(0, 0, 0, 0);
            nVar.lFC.EZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lFC.setLayoutParams(layoutParams2);
            nVar.lFC.EZ(postData.getBimg_url());
        }
        nVar.lFC.setTextViewCheckSelection(false);
    }
}
