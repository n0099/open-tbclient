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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.util.ag;
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
    private static SparseArray<SoftReference<Drawable>> lMq = new SparseArray<>();
    private static SparseIntArray lMr = new SparseIntArray();
    public static final int alE = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lMr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lMr.put(i, dimensionPixelSize);
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
                ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0106, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lPn, R.color.CAM_X0109, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lPo, R.color.CAM_X0109);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lPp, R.color.CAM_X0109);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lPI, R.color.CAM_X0109, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lPq, R.color.CAM_X0109, 1);
                pbCommenFloorItemViewHolder.lPt.setTextColor(ap.getColor(R.color.CAM_X0105));
                pbCommenFloorItemViewHolder.lPu.onChangeSkinType();
                if (z) {
                    SvgManager.bsR().a(pbCommenFloorItemViewHolder.lPN, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lPF, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lPD, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPE, R.color.CAM_X0109);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPG, R.color.CAM_X0109);
                }
                WebPManager.a(pbCommenFloorItemViewHolder.jTF, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jTD, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPx, R.color.CAM_X0108);
                    pbCommenFloorItemViewHolder.lPx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPy, R.color.CAM_X0108);
                    ap.d(pbCommenFloorItemViewHolder.lPw, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    pbCommenFloorItemViewHolder.lPw.onChangeSkinType();
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPS, R.color.CAM_X0304, 1);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPQ, R.color.CAM_X0106, 1);
                    ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPP, R.color.CAM_X0205);
                    ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPR, R.color.CAM_X0109);
                    ap.setImageResource(pbCommenFloorItemViewHolder.lPT, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lPW, R.color.CAM_X0107);
                    if (pbCommenFloorItemViewHolder.lPU.getVisibility() == 8) {
                        pbCommenFloorItemViewHolder.lPx.setVisibility(8);
                        pbCommenFloorItemViewHolder.lPy.setVisibility(8);
                        pbCommenFloorItemViewHolder.lPW.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dlr())) {
                        pbCommenFloorItemViewHolder.lPW.setText(fVar.dlr());
                    } else {
                        pbCommenFloorItemViewHolder.lPW.setText(R.string.expand_content);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lPw.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPx.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPy.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPP.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPW.setVisibility(8);
                }
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
            }
            pbCommenFloorItemViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, cb cbVar, int i, boolean z) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpJ() != null) {
            if (cbVar != null) {
                postData.bpJ().threadId = cbVar.getTid();
                postData.bpJ().forumId = String.valueOf(cbVar.getFid());
            }
            if (i == 0) {
                postData.bpJ().objType = 1;
            } else {
                postData.bpJ().objType = 2;
            }
            postData.bpJ().isInPost = true;
            if (z) {
                pbCommenFloorItemViewHolder.lPH.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.lPH.setData(postData.bpJ());
            }
            if (cbVar != null && cbVar.bmz()) {
                pbCommenFloorItemViewHolder.lPr.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lPr.setData(postData.bpJ());
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        if (pbCommenFloorItemViewHolder.jTD != null && postData != null) {
            if (z2) {
                pbCommenFloorItemViewHolder.jTD.setVisibility(8);
                if (z) {
                    pbCommenFloorItemViewHolder.lPG.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.jTD.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, cb cbVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (cbVar != null && cbVar.bmz()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnQ() != null) {
                MetaData bnQ = postData.bnQ();
                if (str != null && !str.equals("0") && str.equals(bnQ.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.br(textView).og(R.string.J_X04).ok(R.dimen.L_X01).nY(R.color.CAM_X0302).oj(R.color.CAM_X0302);
                } else if (bnQ.getIs_bawu() == 1 && postData.dNx()) {
                    c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                    c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                    c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_content_assist".equals(bnQ.getBawu_type())) {
                    c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_manage_assist".equals(bnQ.getBawu_type())) {
                    c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i, a aVar, cb cbVar, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.bnQ() == null || postData.bnQ().isBaijiahaoUser()) {
            }
            if (postData.nxJ) {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            if (cbVar == null || cbVar.bnQ() == null) {
                str = null;
            } else {
                str = cbVar.bnQ().getUserId();
            }
            pbCommenFloorItemViewHolder.lPs.setTag(null);
            pbCommenFloorItemViewHolder.lPs.setUserId(null);
            pbCommenFloorItemViewHolder.ick.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lPK.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lPt.setIsHost(false);
            if (postData.bnQ() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bnQ().getUserId())) {
                    pbCommenFloorItemViewHolder.lPt.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnQ().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnQ().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lPM != null) {
                    pbCommenFloorItemViewHolder.lPM.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPM.setOnClickListener(aVar.dmo().men);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lPM.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lPL != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lPL.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.lPL.setOnClickListener(aVar.dmo().meo);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lPL.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bnQ().isBigV()) {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0301, 1);
                } else {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0106, 1);
                }
                String avater = postData.bnQ().getAvater();
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_user_name, postData.bnQ().getUserName());
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                String name_show = postData.bnQ().getName_show();
                String userName = postData.bnQ().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.ick.setText(com.baidu.tieba.pb.c.aY(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.ick.getText().toString()));
                    pbCommenFloorItemViewHolder.ick.setGravity(16);
                    pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkQ());
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0312, 1);
                }
                if (postData.bnQ().getPendantData() != null && !StringUtils.isNull(postData.bnQ().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lPK.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lPK.a(postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPs.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPK.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setUserName(postData.bnQ().getUserName());
                    pbCommenFloorItemViewHolder.lPK.Bz(postData.bnQ().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lPs.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lPs, postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPs.setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPs.setUserName(postData.bnQ().getUserName(), postData.dNP());
                    pbCommenFloorItemViewHolder.lPs.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lPs.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lPs.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPs.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPK.setVisibility(8);
                }
                a(pbCommenFloorItemViewHolder.lPm, postData, str, cbVar);
            }
            int i2 = 0;
            if (aVar.dmp() && postData.bnQ() != null) {
                i2 = postData.bnQ().getLevel_id();
            }
            if (cbVar != null && cbVar.bmz()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(0);
                ap.setImageResource(pbCommenFloorItemViewHolder.lPJ, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(8);
            }
            int i3 = 20;
            if (pbCommenFloorItemViewHolder.lPM.getChildCount() == 1) {
                i3 = 18;
            } else if (pbCommenFloorItemViewHolder.lPM.getChildCount() > 1) {
                i3 = 16;
            }
            if (pbCommenFloorItemViewHolder.lPm.getVisibility() == 0) {
                i3 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lPL.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bnQ() != null ? postData.bnQ().getName_show() : "";
            int textLengthWithEmoji = ag.getTextLengthWithEmoji(name_show2);
            if (postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ag.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ag.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                pbCommenFloorItemViewHolder.ick.setText(a(aVar, postData.bnQ().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.ick.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNF()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bnQ() == null || StringUtils.isNull(postData.bnQ().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (cbVar != null && aVar.dmr() != 0) {
                if (aVar.dmr() != 1002 && aVar.dmr() != 3) {
                    z6 = true;
                }
                if (aVar.dmr() != 3 && !cbVar.isBjh()) {
                    z7 = true;
                }
                if (postData != null && postData.bnQ() != null) {
                    String userId2 = postData.bnQ().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z6 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        if (cbVar != null && cbVar.bnQ() != null && postData.bnQ() != null) {
                            userId = cbVar.bnQ().getUserId();
                            String userId3 = postData.bnQ().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z7 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z8 = true;
                                }
                                if (postData == null && postData.bnQ() != null && UtilHelper.isCurrentAccount(postData.bnQ().getUserId())) {
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
                                if (postData.dNF() == 1) {
                                    i4 = 0;
                                }
                                if (cbVar != null && cbVar.bmz()) {
                                    z3 = false;
                                    z4 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dmr()));
                                    if (postData.bnQ() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z4) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bnQ() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnQ().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnQ().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnQ().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, cbVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && cbVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dmr()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
                                if (z) {
                                    pbCommenFloorItemViewHolder.lPN.setTag(sparseArray);
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
                        if (postData.dNF() == 1) {
                        }
                        if (cbVar != null) {
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
                        pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            z3 = z6;
            if (cbVar != null) {
                userId = cbVar.bnQ().getUserId();
                String userId32 = postData.bnQ().getUserId();
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
            if (postData.dNF() == 1) {
            }
            if (cbVar != null) {
            }
            if (z3) {
            }
            if (z4) {
            }
            if (!z7) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().rY(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fWz = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().rZ((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.lPt.Ef(null);
                pbCommenFloorItemViewHolder.lPt.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sa(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sa(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().rX(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lPt, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPt.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lPt.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.lPt.setText(postData.dNH(), true, cVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPt.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lPl.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, cb cbVar) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNF() > 0 && cbVar != null && !cbVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dNF()));
                pbCommenFloorItemViewHolder.lPI.setVisibility(0);
                pbCommenFloorItemViewHolder.lPI.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lPI.setVisibility(8);
                z = false;
            }
            g dNI = postData.dNI();
            boolean z2 = (dNI == null || StringUtils.isNull(dNI.getName()) || cbVar == null || cbVar.isBjh()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lPo.setVisibility(0);
                i = alE;
            } else {
                pbCommenFloorItemViewHolder.lPo.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPp.setVisibility(0);
                i2 = alE;
            } else {
                pbCommenFloorItemViewHolder.lPp.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lPn.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lPn.setText(au.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lPn.setText(au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPq.setVisibility(0);
                pbCommenFloorItemViewHolder.lPq.setPadding(alE, 0, 0, 0);
                pbCommenFloorItemViewHolder.lPq.setText(dNI.getName());
                return;
            }
            pbCommenFloorItemViewHolder.lPq.setVisibility(8);
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dts() == null) {
            pbCommenFloorItemViewHolder.lPO.setVisibility(8);
            return;
        }
        TbRichText dNH = postData.dNH();
        com.baidu.tieba.pb.view.b.a(postData.dts(), pbCommenFloorItemViewHolder.lPO, false, false, dNH != null && StringUtils.isNull(dNH.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPt.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lPt.Ef(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lPt.Ef(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lPt.setTextViewCheckSelection(false);
    }
}
