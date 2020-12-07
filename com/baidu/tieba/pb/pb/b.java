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
    private static SparseArray<SoftReference<Drawable>> lCK = new SparseArray<>();
    private static SparseIntArray lCL = new SparseIntArray();
    public static final int amd = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lCL.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lCL.put(i, dimensionPixelSize);
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
                ap.setViewTextColor(nVar.hPL, R.color.CAM_X0106, 1);
                ap.setViewTextColor(nVar.lFu, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lFv, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lFw, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lFQ, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lFx, R.color.CAM_X0109, 1);
                nVar.lFA.setTextColor(ap.getColor(R.color.CAM_X0105));
                nVar.lFB.onChangeSkinType();
                if (z) {
                    SvgManager.btW().a(nVar.lFV, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lFN, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lFL, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.lFM, R.color.CAM_X0109);
                    ap.setViewTextColor(nVar.lFO, R.color.CAM_X0109);
                }
                WebPManager.a(nVar.lFG, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.jYm, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.lFE, R.color.CAM_X0108);
                    nVar.lFE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ap.setViewTextColor(nVar.lFF, R.color.CAM_X0108);
                    ap.d(nVar.lFD, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    nVar.lFD.onChangeSkinType();
                    ap.setViewTextColor(nVar.lGa, R.color.CAM_X0304, 1);
                    ap.setViewTextColor(nVar.lFY, R.color.CAM_X0106, 1);
                    ap.setBackgroundResource(nVar.lFX, R.color.CAM_X0205);
                    ap.setBackgroundResource(nVar.lFZ, R.color.CAM_X0109);
                    ap.setImageResource(nVar.lGb, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.lGe, R.color.CAM_X0107);
                    if (nVar.lGc.getVisibility() == 8) {
                        nVar.lFE.setVisibility(8);
                        nVar.lFF.setVisibility(8);
                        nVar.lGe.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dne())) {
                        nVar.lGe.setText(fVar.dne());
                    } else {
                        nVar.lGe.setText(R.string.expand_content);
                    }
                } else {
                    nVar.lFD.setVisibility(8);
                    nVar.lFE.setVisibility(8);
                    nVar.lFF.setVisibility(8);
                    nVar.lFX.setVisibility(8);
                    nVar.lGe.setVisibility(8);
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
                nVar.lFP.setAgreeAlone(true);
                nVar.lFP.setData(postData.bqI());
            }
            if (byVar != null && byVar.bnz()) {
                nVar.lFy.setAgreeAlone(true);
            }
            nVar.lFy.setData(postData.bqI());
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jYm != null && postData != null) {
            if (z2) {
                nVar.jYm.setVisibility(8);
                if (z) {
                    if (d.bki()) {
                        string = postData.dPk() > 0 ? String.valueOf(postData.dPk()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.lFO.setText(string);
                    return;
                }
                return;
            }
            nVar.jYm.setVisibility(z ? 0 : 8);
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
                } else if (boP.getIs_bawu() == 1 && postData.dOY()) {
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
            if (postData.nms) {
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
            nVar.lFz.setTag(null);
            nVar.lFz.setUserId(null);
            nVar.hPL.setText((CharSequence) null);
            nVar.lFS.getHeadView().setUserId(null);
            nVar.lFA.setIsHost(false);
            if (postData.boP() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.boP().getUserId())) {
                    nVar.lFA.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.boP().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.boP().getTShowInfoNew();
                if (nVar.lFU != null) {
                    nVar.lFU.setTag(R.id.tag_user_id, postData.boP().getUserId());
                    nVar.lFU.setOnClickListener(aVar.dob().lUk);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lFU.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lFT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lFT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.lFT.setOnClickListener(aVar.dob().lUl);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lFT.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.boP().isBigV()) {
                    ap.setViewTextColor(nVar.hPL, R.color.CAM_X0301, 1);
                } else {
                    ap.setViewTextColor(nVar.hPL, R.color.CAM_X0106, 1);
                }
                String avater = postData.boP().getAvater();
                nVar.hPL.setTag(R.id.tag_user_id, postData.boP().getUserId());
                nVar.hPL.setTag(R.id.tag_user_name, postData.boP().getUserName());
                nVar.hPL.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                String name_show = postData.boP().getName_show();
                String userName = postData.boP().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hPL.setText(com.baidu.tieba.pb.c.aV(aVar.getPageContext().getPageActivity(), nVar.hPL.getText().toString()));
                    nVar.hPL.setGravity(16);
                    nVar.hPL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmD());
                    ap.setViewTextColor(nVar.hPL, R.color.CAM_X0312, 1);
                }
                if (postData.boP().getPendantData() != null && !StringUtils.isNull(postData.boP().getPendantData().bmL())) {
                    nVar.lFS.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lFS.a(postData.boP(), 4);
                    nVar.lFz.setVisibility(8);
                    nVar.lFS.setVisibility(0);
                    nVar.lFS.getHeadView().startLoad(avater, 28, false);
                    nVar.lFS.getHeadView().setUserId(postData.boP().getUserId());
                    nVar.lFS.getHeadView().setUserName(postData.boP().getUserName());
                    nVar.lFS.Cw(postData.boP().getPendantData().bmL());
                } else {
                    nVar.lFz.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lFz, postData.boP(), 4);
                    nVar.lFz.setUserId(postData.boP().getUserId());
                    nVar.lFz.setUserName(postData.boP().getUserName(), postData.dPq());
                    nVar.lFz.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                    nVar.lFz.setImageDrawable(null);
                    nVar.lFz.startLoad(avater, 28, false);
                    nVar.lFz.setVisibility(0);
                    nVar.lFS.setVisibility(8);
                }
                a(nVar.lFt, postData, str, byVar);
            }
            int i2 = 0;
            if (aVar.doc() && postData.boP() != null) {
                i2 = postData.boP().getLevel_id();
            }
            if (byVar != null && byVar.bnz()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.lFR.setVisibility(0);
                ap.setImageResource(nVar.lFR, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.lFR.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.lFU.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.lFU.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.lFt.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.lFT.getChildCount() > 0) {
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
                nVar.hPL.setText(a(aVar, postData.boP().getSealPrefix(), name_show2));
            } else {
                nVar.hPL.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPg()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.boP() == null || StringUtils.isNull(postData.boP().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (byVar != null && aVar.doe() != 0) {
                if (aVar.doe() != 1002 && aVar.doe() != 3) {
                    z9 = true;
                }
                if (aVar.doe() != 3 && !byVar.isBjh()) {
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
                                if (postData.dPg() == 1) {
                                    i4 = 0;
                                }
                                if (byVar != null && byVar.bnz()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.doe()));
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
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.doe()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lFA.setTag(sparseArray);
                                if (z) {
                                    nVar.lFV.setTag(sparseArray);
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
                        if (postData.dPg() == 1) {
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
                        nVar.lFA.setTag(sparseArray);
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
            if (postData.dPg() == 1) {
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
            nVar.lFA.setTag(sparseArray);
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.lFA.EZ(null);
                nVar.lFA.setBackgroundDrawable(null);
                nVar.lFA.getLayoutStrategy().tq(R.drawable.transparent_bg);
            } else {
                nVar.lFA.getLayoutStrategy().tq(R.drawable.icon_click);
            }
            nVar.lFA.getLayoutStrategy().tn(R.drawable.pic_video);
            a(nVar.lFA, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.lFA.setLayoutParams(layoutParams);
            nVar.lFA.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            nVar.lFA.setIsFromCDN(z3);
            nVar.lFA.setText(postData.dPi(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.lFA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.lFA.setTag(sparseArray);
            nVar.lFs.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, by byVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dPg() > 0 && byVar != null && !byVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dPg()));
                nVar.lFQ.setVisibility(0);
                nVar.lFQ.setText(format);
                z = true;
            } else {
                nVar.lFQ.setVisibility(8);
                z = false;
            }
            g dPj = postData.dPj();
            boolean z2 = (dPj == null || StringUtils.isNull(dPj.getName()) || byVar == null || byVar.isBjh()) ? false : true;
            if (z) {
                nVar.lFv.setVisibility(0);
                i = amd;
            } else {
                nVar.lFv.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lFw.setVisibility(0);
                i2 = amd;
            } else {
                nVar.lFw.setVisibility(8);
                i2 = 0;
            }
            nVar.lFu.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lFu.setText(au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lFu.setText(au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lFx.setVisibility(0);
                nVar.lFx.setPadding(amd, 0, 0, 0);
                nVar.lFx.setText(dPj.getName());
                return;
            }
            nVar.lFx.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData) {
        if (postData == null || postData.duY() == null) {
            nVar.lFW.setVisibility(8);
            return;
        }
        TbRichText dPi = postData.dPi();
        com.baidu.tieba.pb.view.b.a(postData.duY(), nVar.lFW, false, false, dPi != null && StringUtils.isNull(dPi.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lFA.setLayoutParams(layoutParams);
            nVar.lFA.setPadding(0, 0, 0, 0);
            nVar.lFA.EZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lFA.setLayoutParams(layoutParams2);
            nVar.lFA.EZ(postData.getBimg_url());
        }
        nVar.lFA.setTextViewCheckSelection(false);
    }
}
