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
    private static SparseArray<SoftReference<Drawable>> lDm = new SparseArray<>();
    private static SparseIntArray lDn = new SparseIntArray();
    public static final int alO = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lDn.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lDn.put(i, dimensionPixelSize);
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
                ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0106, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lGh, R.color.CAM_X0109, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lGi, R.color.CAM_X0109);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lGj, R.color.CAM_X0109);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lGC, R.color.CAM_X0109, 1);
                ao.setViewTextColor(pbCommenFloorItemViewHolder.lGk, R.color.CAM_X0109, 1);
                pbCommenFloorItemViewHolder.lGn.setTextColor(ao.getColor(R.color.CAM_X0105));
                pbCommenFloorItemViewHolder.lGo.onChangeSkinType();
                if (z) {
                    SvgManager.bsx().a(pbCommenFloorItemViewHolder.lGH, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lGz, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lGx, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGy, R.color.CAM_X0109);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGA, R.color.CAM_X0109);
                }
                WebPManager.a(pbCommenFloorItemViewHolder.jMo, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jMm, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGr, R.color.CAM_X0108);
                    pbCommenFloorItemViewHolder.lGr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ao.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGs, R.color.CAM_X0108);
                    ao.d(pbCommenFloorItemViewHolder.lGq, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    pbCommenFloorItemViewHolder.lGq.onChangeSkinType();
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGM, R.color.CAM_X0304, 1);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGK, R.color.CAM_X0106, 1);
                    ao.setBackgroundResource(pbCommenFloorItemViewHolder.lGJ, R.color.CAM_X0205);
                    ao.setBackgroundResource(pbCommenFloorItemViewHolder.lGL, R.color.CAM_X0109);
                    ao.setImageResource(pbCommenFloorItemViewHolder.lGN, R.drawable.icon_arrow_more_gray);
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.lGQ, R.color.CAM_X0107);
                    if (pbCommenFloorItemViewHolder.lGO.getVisibility() == 8) {
                        pbCommenFloorItemViewHolder.lGr.setVisibility(8);
                        pbCommenFloorItemViewHolder.lGs.setVisibility(8);
                        pbCommenFloorItemViewHolder.lGQ.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.diY())) {
                        pbCommenFloorItemViewHolder.lGQ.setText(fVar.diY());
                    } else {
                        pbCommenFloorItemViewHolder.lGQ.setText(R.string.expand_content);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lGq.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGr.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGs.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGJ.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGQ.setVisibility(8);
                }
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
            }
            pbCommenFloorItemViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, bz bzVar, int i, boolean z) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpr() != null) {
            if (bzVar != null) {
                postData.bpr().threadId = bzVar.getTid();
                postData.bpr().forumId = String.valueOf(bzVar.getFid());
            }
            if (i == 0) {
                postData.bpr().objType = 1;
            } else {
                postData.bpr().objType = 2;
            }
            postData.bpr().isInPost = true;
            if (z) {
                pbCommenFloorItemViewHolder.lGB.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.lGB.setData(postData.bpr());
            }
            if (bzVar != null && bzVar.bmg()) {
                pbCommenFloorItemViewHolder.lGl.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lGl.setData(postData.bpr());
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        if (pbCommenFloorItemViewHolder.jMm != null && postData != null) {
            if (z2) {
                pbCommenFloorItemViewHolder.jMm.setVisibility(8);
                if (z) {
                    pbCommenFloorItemViewHolder.lGA.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.jMm.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, bz bzVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (bzVar != null && bzVar.bmg()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnx() != null) {
                MetaData bnx = postData.bnx();
                if (str != null && !str.equals("0") && str.equals(bnx.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.bv(textView).od(R.string.J_X04).og(R.dimen.L_X01).nV(R.color.CAM_X0302).of(R.color.CAM_X0302);
                } else if (bnx.getIs_bawu() == 1 && postData.dLe()) {
                    c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                    c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                    c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_content_assist".equals(bnx.getBawu_type())) {
                    c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_manage_assist".equals(bnx.getBawu_type())) {
                    c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
            if (postData.bnx() == null || postData.bnx().isBaijiahaoUser()) {
            }
            if (postData.nny) {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            if (bzVar == null || bzVar.bnx() == null) {
                str = null;
            } else {
                str = bzVar.bnx().getUserId();
            }
            pbCommenFloorItemViewHolder.lGm.setTag(null);
            pbCommenFloorItemViewHolder.lGm.setUserId(null);
            pbCommenFloorItemViewHolder.hXC.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lGE.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lGn.setIsHost(false);
            if (postData.bnx() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bnx().getUserId())) {
                    pbCommenFloorItemViewHolder.lGn.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnx().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lGG != null) {
                    pbCommenFloorItemViewHolder.lGG.setTag(R.id.tag_user_id, postData.bnx().getUserId());
                    pbCommenFloorItemViewHolder.lGG.setOnClickListener(aVar.djU().lUT);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lGG.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lGF != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lGF.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.lGF.setOnClickListener(aVar.djU().lUU);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lGF.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!x.isEmpty(tShowInfoNew) || postData.bnx().isBigV()) {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0301, 1);
                } else {
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0106, 1);
                }
                String avater = postData.bnx().getAvater();
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_user_id, postData.bnx().getUserId());
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_user_name, postData.bnx().getUserName());
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_virtual_user_url, postData.bnx().getVirtualUserUrl());
                String name_show = postData.bnx().getName_show();
                String userName = postData.bnx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.hXC.setText(com.baidu.tieba.pb.c.bb(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.hXC.getText().toString()));
                    pbCommenFloorItemViewHolder.hXC.setGravity(16);
                    pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dix());
                    ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0312, 1);
                }
                if (postData.bnx().getPendantData() != null && !StringUtils.isNull(postData.bnx().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lGE.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lGE.a(postData.bnx(), 4);
                    pbCommenFloorItemViewHolder.lGm.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGE.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setUserId(postData.bnx().getUserId());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setUserName(postData.bnx().getUserName());
                    pbCommenFloorItemViewHolder.lGE.Bi(postData.bnx().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lGm.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lGm, postData.bnx(), 4);
                    pbCommenFloorItemViewHolder.lGm.setUserId(postData.bnx().getUserId());
                    pbCommenFloorItemViewHolder.lGm.setUserName(postData.bnx().getUserName(), postData.dLw());
                    pbCommenFloorItemViewHolder.lGm.setTag(R.id.tag_virtual_user_url, postData.bnx().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lGm.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lGm.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lGm.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGE.setVisibility(8);
                }
                a(pbCommenFloorItemViewHolder.lGg, postData, str, bzVar);
            }
            int i2 = 0;
            if (aVar.djV() && postData.bnx() != null) {
                i2 = postData.bnx().getLevel_id();
            }
            if (bzVar != null && bzVar.bmg()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.lGD.setVisibility(0);
                ao.setImageResource(pbCommenFloorItemViewHolder.lGD, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.lGD.setVisibility(8);
            }
            int i3 = 20;
            if (pbCommenFloorItemViewHolder.lGG.getChildCount() == 1) {
                i3 = 18;
            } else if (pbCommenFloorItemViewHolder.lGG.getChildCount() > 1) {
                i3 = 16;
            }
            if (pbCommenFloorItemViewHolder.lGg.getVisibility() == 0) {
                i3 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lGF.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bnx() != null ? postData.bnx().getName_show() : "";
            int textLengthWithEmoji = ad.getTextLengthWithEmoji(name_show2);
            if (postData.bnx() != null && !StringUtils.isNull(postData.bnx().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ad.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ad.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bnx() != null && !StringUtils.isNull(postData.bnx().getSealPrefix())) {
                pbCommenFloorItemViewHolder.hXC.setText(a(aVar, postData.bnx().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.hXC.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dLm()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bnx() == null || StringUtils.isNull(postData.bnx().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (bzVar != null && aVar.djX() != 0) {
                if (aVar.djX() != 1002 && aVar.djX() != 3) {
                    z6 = true;
                }
                if (aVar.djX() != 3 && !bzVar.isBjh()) {
                    z7 = true;
                }
                if (postData != null && postData.bnx() != null) {
                    String userId2 = postData.bnx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z6 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        if (bzVar != null && bzVar.bnx() != null && postData.bnx() != null) {
                            userId = bzVar.bnx().getUserId();
                            String userId3 = postData.bnx().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z7 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z8 = true;
                                }
                                if (postData == null && postData.bnx() != null && UtilHelper.isCurrentAccount(postData.bnx().getUserId())) {
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
                                if (postData.dLm() == 1) {
                                    i4 = 0;
                                }
                                if (bzVar != null && bzVar.bmg()) {
                                    z3 = false;
                                    z4 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.djX()));
                                    if (postData.bnx() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z4) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bnx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnx().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnx().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnx().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bzVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && bzVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.djX()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
                                if (z) {
                                    pbCommenFloorItemViewHolder.lGH.setTag(sparseArray);
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
                        if (postData.dLm() == 1) {
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
                        pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            z3 = z6;
            if (bzVar != null) {
                userId = bzVar.bnx().getUserId();
                String userId32 = postData.bnx().getUserId();
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
            if (postData.dLm() == 1) {
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
            pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().rT(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fUk = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().rU((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.lGn.DK(null);
                pbCommenFloorItemViewHolder.lGn.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rV(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rV(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rS(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lGn, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lGn.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lGn.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.lGn.setText(postData.dLo(), true, cVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lGn.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lGf.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, bz bzVar) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dLm() > 0 && bzVar != null && !bzVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dLm()));
                pbCommenFloorItemViewHolder.lGC.setVisibility(0);
                pbCommenFloorItemViewHolder.lGC.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lGC.setVisibility(8);
                z = false;
            }
            g dLp = postData.dLp();
            boolean z2 = (dLp == null || StringUtils.isNull(dLp.getName()) || bzVar == null || bzVar.isBjh()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lGi.setVisibility(0);
                i = alO;
            } else {
                pbCommenFloorItemViewHolder.lGi.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lGj.setVisibility(0);
                i2 = alO;
            } else {
                pbCommenFloorItemViewHolder.lGj.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lGh.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lGh.setText(at.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lGh.setText(at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lGk.setVisibility(0);
                pbCommenFloorItemViewHolder.lGk.setPadding(alO, 0, 0, 0);
                pbCommenFloorItemViewHolder.lGk.setText(dLp.getName());
                return;
            }
            pbCommenFloorItemViewHolder.lGk.setVisibility(8);
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dqX() == null) {
            pbCommenFloorItemViewHolder.lGI.setVisibility(8);
            return;
        }
        TbRichText dLo = postData.dLo();
        com.baidu.tieba.pb.view.b.a(postData.dqX(), pbCommenFloorItemViewHolder.lGI, false, false, dLo != null && StringUtils.isNull(dLo.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lGn.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lGn.DK(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lGn.DK(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lGn.setTextViewCheckSelection(false);
    }
}
