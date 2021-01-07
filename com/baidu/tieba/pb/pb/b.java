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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> lHR = new SparseArray<>();
    private static SparseIntArray lHS = new SparseIntArray();
    public static final int amF = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lHS.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lHS.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }

    private static SpannableStringBuilder a(a aVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) aVar.getPageContext().getPageActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, f fVar, boolean z) {
        if (pbCommenFloorItemViewHolder != null) {
            if (pbCommenFloorItemViewHolder.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0106, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lKL, R.color.CAM_X0109, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lKM, R.color.CAM_X0109);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lKN, R.color.CAM_X0109);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lLg, R.color.CAM_X0109, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lKO, R.color.CAM_X0109, 1);
                pbCommenFloorItemViewHolder.lKR.setTextColor(ao.getColor(R.color.CAM_X0105));
                pbCommenFloorItemViewHolder.lKS.onChangeSkinType();
                if (z) {
                    SvgManager.bwr().a(pbCommenFloorItemViewHolder.lLl, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lLd, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lLb, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lLc, R.color.CAM_X0109);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lLe, R.color.CAM_X0109);
                }
                WebPManager.a(pbCommenFloorItemViewHolder.jQT, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jQR, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lKV, R.color.CAM_X0108);
                    pbCommenFloorItemViewHolder.lKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ao.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lKW, R.color.CAM_X0108);
                    ao.d(pbCommenFloorItemViewHolder.lKU, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    pbCommenFloorItemViewHolder.lKU.onChangeSkinType();
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lLq, R.color.CAM_X0304, 1);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lLo, R.color.CAM_X0106, 1);
                    ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLn, R.color.CAM_X0205);
                    ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLp, R.color.CAM_X0109);
                    ao.setImageResource(pbCommenFloorItemViewHolder.lLr, R.drawable.icon_arrow_more_gray);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lLu, R.color.CAM_X0107);
                    if (pbCommenFloorItemViewHolder.lLs.getVisibility() == 8) {
                        pbCommenFloorItemViewHolder.lKV.setVisibility(8);
                        pbCommenFloorItemViewHolder.lKW.setVisibility(8);
                        pbCommenFloorItemViewHolder.lLu.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dmQ())) {
                        pbCommenFloorItemViewHolder.lLu.setText(fVar.dmQ());
                    } else {
                        pbCommenFloorItemViewHolder.lLu.setText(R.string.expand_content);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lKU.setVisibility(8);
                    pbCommenFloorItemViewHolder.lKV.setVisibility(8);
                    pbCommenFloorItemViewHolder.lKW.setVisibility(8);
                    pbCommenFloorItemViewHolder.lLn.setVisibility(8);
                    pbCommenFloorItemViewHolder.lLu.setVisibility(8);
                }
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
            }
            pbCommenFloorItemViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, bz bzVar, int i, boolean z) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.btl() != null) {
            if (bzVar != null) {
                postData.btl().threadId = bzVar.getTid();
                postData.btl().forumId = String.valueOf(bzVar.getFid());
            }
            if (i == 0) {
                postData.btl().objType = 1;
            } else {
                postData.btl().objType = 2;
            }
            postData.btl().isInPost = true;
            if (z) {
                pbCommenFloorItemViewHolder.lLf.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.lLf.setData(postData.btl());
            }
            if (bzVar != null && bzVar.bqa()) {
                pbCommenFloorItemViewHolder.lKP.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lKP.setData(postData.btl());
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        if (pbCommenFloorItemViewHolder.jQR != null && postData != null) {
            if (z2) {
                pbCommenFloorItemViewHolder.jQR.setVisibility(8);
                if (z) {
                    pbCommenFloorItemViewHolder.lLe.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.jQR.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, bz bzVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (bzVar != null && bzVar.bqa()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.brr() != null) {
                MetaData brr = postData.brr();
                if (str != null && !str.equals("0") && str.equals(brr.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.bv(textView).pK(R.string.J_X04).pN(R.dimen.L_X01).pC(R.color.CAM_X0302).pM(R.color.CAM_X0302);
                } else if (brr.getIs_bawu() == 1 && postData.dOW()) {
                    c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                    c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                    c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_content_assist".equals(brr.getBawu_type())) {
                    c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_manage_assist".equals(brr.getBawu_type())) {
                    c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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

    /* JADX WARN: Removed duplicated region for block: B:127:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0487 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i, a aVar, bz bzVar, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.brr() == null || postData.brr().isBaijiahaoUser()) {
            }
            if (postData.nsf) {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            if (bzVar == null || bzVar.brr() == null) {
                str = null;
            } else {
                str = bzVar.brr().getUserId();
            }
            pbCommenFloorItemViewHolder.lKQ.setTag(null);
            pbCommenFloorItemViewHolder.lKQ.setUserId(null);
            pbCommenFloorItemViewHolder.icj.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lLi.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lKR.setIsHost(false);
            if (postData.brr() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.brr().getUserId())) {
                    pbCommenFloorItemViewHolder.lKR.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.brr().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.brr().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lLk != null) {
                    pbCommenFloorItemViewHolder.lLk.setTag(R.id.tag_user_id, postData.brr().getUserId());
                    pbCommenFloorItemViewHolder.lLk.setOnClickListener(aVar.dnN().lZx);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lLk.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lLj != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lLj.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.lLj.setOnClickListener(aVar.dnN().lZy);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lLj.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!x.isEmpty(tShowInfoNew) || postData.brr().isBigV()) {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0301, 1);
                } else {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0106, 1);
                }
                String avater = postData.brr().getAvater();
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_id, postData.brr().getUserId());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_name, postData.brr().getUserName());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_virtual_user_url, postData.brr().getVirtualUserUrl());
                String name_show = postData.brr().getName_show();
                String userName = postData.brr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.icj.setText(com.baidu.tieba.pb.c.bb(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.icj.getText().toString()));
                    pbCommenFloorItemViewHolder.icj.setGravity(16);
                    pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmp());
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0312, 1);
                }
                if (postData.brr().getPendantData() != null && !StringUtils.isNull(postData.brr().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lLi.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lLi.a(postData.brr(), 4);
                    pbCommenFloorItemViewHolder.lKQ.setVisibility(8);
                    pbCommenFloorItemViewHolder.lLi.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setUserId(postData.brr().getUserId());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setUserName(postData.brr().getUserName());
                    pbCommenFloorItemViewHolder.lLi.Ct(postData.brr().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lKQ.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lKQ, postData.brr(), 4);
                    pbCommenFloorItemViewHolder.lKQ.setUserId(postData.brr().getUserId());
                    pbCommenFloorItemViewHolder.lKQ.setUserName(postData.brr().getUserName(), postData.dPo());
                    pbCommenFloorItemViewHolder.lKQ.setTag(R.id.tag_virtual_user_url, postData.brr().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lKQ.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lKQ.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lKQ.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLi.setVisibility(8);
                }
                a(pbCommenFloorItemViewHolder.lKK, postData, str, bzVar);
            }
            int i2 = 0;
            if (aVar.dnO() && postData.brr() != null) {
                i2 = postData.brr().getLevel_id();
            }
            if (bzVar != null && bzVar.bqa()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.lLh.setVisibility(0);
                ao.setImageResource(pbCommenFloorItemViewHolder.lLh, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.lLh.setVisibility(8);
            }
            int i3 = 20;
            if (pbCommenFloorItemViewHolder.lLk.getChildCount() == 1) {
                i3 = 18;
            } else if (pbCommenFloorItemViewHolder.lLk.getChildCount() > 1) {
                i3 = 16;
            }
            if (pbCommenFloorItemViewHolder.lKK.getVisibility() == 0) {
                i3 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lLj.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.brr() != null ? postData.brr().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.brr() != null && !StringUtils.isNull(postData.brr().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.brr() != null && !StringUtils.isNull(postData.brr().getSealPrefix())) {
                pbCommenFloorItemViewHolder.icj.setText(a(aVar, postData.brr().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.icj.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPe()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.brr() == null || StringUtils.isNull(postData.brr().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (bzVar != null && aVar.dnQ() != 0) {
                if (aVar.dnQ() != 1002 && aVar.dnQ() != 3) {
                    z6 = true;
                }
                if (aVar.dnQ() != 3 && !bzVar.isBjh()) {
                    z7 = true;
                }
                if (postData != null && postData.brr() != null) {
                    String userId2 = postData.brr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z6 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        if (bzVar != null && bzVar.brr() != null && postData.brr() != null) {
                            userId = bzVar.brr().getUserId();
                            String userId3 = postData.brr().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z7 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z8 = true;
                                }
                                if (postData == null && postData.brr() != null && UtilHelper.isCurrentAccount(postData.brr().getUserId())) {
                                    z7 = true;
                                    z5 = true;
                                } else {
                                    z5 = z8;
                                }
                                if (z2) {
                                    z3 = false;
                                    z7 = false;
                                    z4 = false;
                                }
                                int i4 = 1;
                                if (postData.dPe() == 1) {
                                    i4 = 0;
                                }
                                if (bzVar != null && bzVar.bqa()) {
                                    z3 = false;
                                    z4 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dnQ()));
                                    if (postData.brr() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z4) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.brr() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brr().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.brr().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brr().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bzVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bzVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dnQ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
                                if (z) {
                                    pbCommenFloorItemViewHolder.lLl.setTag(sparseArray);
                                    return;
                                }
                                return;
                            }
                        }
                        z4 = false;
                        if (postData == null) {
                        }
                        z5 = z8;
                        if (z2) {
                        }
                        int i42 = 1;
                        if (postData.dPe() == 1) {
                        }
                        if (bzVar != null) {
                            z3 = false;
                            z4 = false;
                        }
                        if (z3) {
                        }
                        if (z4) {
                        }
                        if (!z7) {
                        }
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                        pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            z3 = z6;
            if (bzVar != null) {
                userId = bzVar.brr().getUserId();
                String userId32 = postData.brr().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z4 = false;
            if (postData == null) {
            }
            z5 = z8;
            if (z2) {
            }
            int i422 = 1;
            if (postData.dPe() == 1) {
            }
            if (bzVar != null) {
            }
            if (z3) {
            }
            if (z4) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
            if (z) {
            }
        }
    }

    private static void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().tz(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fYR = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().tA((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.lKR.EV(null);
                pbCommenFloorItemViewHolder.lKR.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tB(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tB(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().ty(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lKR, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKR.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lKR.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.lKR.setText(postData.dPg(), true, cVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lKR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lKJ.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, bz bzVar) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dPe() > 0 && bzVar != null && !bzVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dPe()));
                pbCommenFloorItemViewHolder.lLg.setVisibility(0);
                pbCommenFloorItemViewHolder.lLg.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lLg.setVisibility(8);
                z = false;
            }
            g dPh = postData.dPh();
            boolean z2 = (dPh == null || StringUtils.isNull(dPh.getName()) || bzVar == null || bzVar.isBjh()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lKM.setVisibility(0);
                i = amF;
            } else {
                pbCommenFloorItemViewHolder.lKM.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKN.setVisibility(0);
                i2 = amF;
            } else {
                pbCommenFloorItemViewHolder.lKN.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lKL.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lKL.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lKL.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKO.setVisibility(0);
                pbCommenFloorItemViewHolder.lKO.setPadding(amF, 0, 0, 0);
                pbCommenFloorItemViewHolder.lKO.setText(dPh.getName());
                return;
            }
            pbCommenFloorItemViewHolder.lKO.setVisibility(8);
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.duP() == null) {
            pbCommenFloorItemViewHolder.lLm.setVisibility(8);
            return;
        }
        TbRichText dPg = postData.dPg();
        com.baidu.tieba.pb.view.b.a(postData.duP(), pbCommenFloorItemViewHolder.lLm, false, false, dPg != null && StringUtils.isNull(dPg.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKR.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lKR.EV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lKR.EV(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lKR.setTextViewCheckSelection(false);
    }
}
