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
    private static SparseArray<SoftReference<Drawable>> lOs = new SparseArray<>();
    private static SparseIntArray lOt = new SparseIntArray();
    public static final int amW = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lOt.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lOt.put(i, dimensionPixelSize);
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
                ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0106, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lRp, R.color.CAM_X0109, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lRq, R.color.CAM_X0109);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lRr, R.color.CAM_X0109);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lRK, R.color.CAM_X0109, 1);
                ap.setViewTextColor(pbCommenFloorItemViewHolder.lRs, R.color.CAM_X0109, 1);
                pbCommenFloorItemViewHolder.lRv.setTextColor(ap.getColor(R.color.CAM_X0105));
                pbCommenFloorItemViewHolder.lRw.onChangeSkinType();
                if (z) {
                    SvgManager.bsU().a(pbCommenFloorItemViewHolder.lRP, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lRH, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(pbCommenFloorItemViewHolder.lRF, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRG, R.color.CAM_X0109);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRI, R.color.CAM_X0109);
                }
                WebPManager.a(pbCommenFloorItemViewHolder.jVW, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jVU, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRz, R.color.CAM_X0108);
                    pbCommenFloorItemViewHolder.lRz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRA, R.color.CAM_X0108);
                    ap.d(pbCommenFloorItemViewHolder.lRy, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    pbCommenFloorItemViewHolder.lRy.onChangeSkinType();
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRU, R.color.CAM_X0304, 1);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRS, R.color.CAM_X0106, 1);
                    ap.setBackgroundResource(pbCommenFloorItemViewHolder.lRR, R.color.CAM_X0205);
                    ap.setBackgroundResource(pbCommenFloorItemViewHolder.lRT, R.color.CAM_X0109);
                    ap.setImageResource(pbCommenFloorItemViewHolder.lRV, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.lRY, R.color.CAM_X0107);
                    if (pbCommenFloorItemViewHolder.lRW.getVisibility() == 8) {
                        pbCommenFloorItemViewHolder.lRz.setVisibility(8);
                        pbCommenFloorItemViewHolder.lRA.setVisibility(8);
                        pbCommenFloorItemViewHolder.lRY.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dlA())) {
                        pbCommenFloorItemViewHolder.lRY.setText(fVar.dlA());
                    } else {
                        pbCommenFloorItemViewHolder.lRY.setText(R.string.expand_content);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lRy.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRz.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRA.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRR.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRY.setVisibility(8);
                }
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
            }
            pbCommenFloorItemViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, cb cbVar, int i, boolean z) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpL() != null) {
            if (cbVar != null) {
                postData.bpL().threadId = cbVar.getTid();
                postData.bpL().forumId = String.valueOf(cbVar.getFid());
            }
            if (i == 0) {
                postData.bpL().objType = 1;
            } else {
                postData.bpL().objType = 2;
            }
            postData.bpL().isInPost = true;
            if (z) {
                pbCommenFloorItemViewHolder.lRJ.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.lRJ.setData(postData.bpL());
            }
            if (cbVar != null && cbVar.bmB()) {
                pbCommenFloorItemViewHolder.lRt.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lRt.setData(postData.bpL());
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        if (pbCommenFloorItemViewHolder.jVU != null && postData != null) {
            if (z2) {
                pbCommenFloorItemViewHolder.jVU.setVisibility(8);
                if (z) {
                    pbCommenFloorItemViewHolder.lRI.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.jVU.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, cb cbVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (cbVar != null && cbVar.bmB()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnS() != null) {
                MetaData bnS = postData.bnS();
                if (str != null && !str.equals("0") && str.equals(bnS.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.br(textView).oh(R.string.J_X04).ol(R.dimen.L_X01).nZ(R.color.CAM_X0302).ok(R.color.CAM_X0302);
                } else if (bnS.getIs_bawu() == 1 && postData.dNG()) {
                    c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                    c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                    c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_content_assist".equals(bnS.getBawu_type())) {
                    c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_manage_assist".equals(bnS.getBawu_type())) {
                    c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
            if (postData.bnS() == null || postData.bnS().isBaijiahaoUser()) {
            }
            if (postData.nzO) {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            if (cbVar == null || cbVar.bnS() == null) {
                str = null;
            } else {
                str = cbVar.bnS().getUserId();
            }
            pbCommenFloorItemViewHolder.lRu.setTag(null);
            pbCommenFloorItemViewHolder.lRu.setUserId(null);
            pbCommenFloorItemViewHolder.idX.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lRM.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lRv.setIsHost(false);
            if (postData.bnS() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.bnS().getUserId())) {
                    pbCommenFloorItemViewHolder.lRv.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnS().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnS().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lRO != null) {
                    pbCommenFloorItemViewHolder.lRO.setTag(R.id.tag_user_id, postData.bnS().getUserId());
                    pbCommenFloorItemViewHolder.lRO.setOnClickListener(aVar.dmx().mgp);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lRO.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lRN != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lRN.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.lRN.setOnClickListener(aVar.dmx().mgq);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lRN.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.bnS().isBigV()) {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0301, 1);
                } else {
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0106, 1);
                }
                String avater = postData.bnS().getAvater();
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_user_id, postData.bnS().getUserId());
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_user_name, postData.bnS().getUserName());
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_virtual_user_url, postData.bnS().getVirtualUserUrl());
                String name_show = postData.bnS().getName_show();
                String userName = postData.bnS().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.idX.setText(com.baidu.tieba.pb.c.aY(aVar.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.idX.getText().toString()));
                    pbCommenFloorItemViewHolder.idX.setGravity(16);
                    pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkZ());
                    ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0312, 1);
                }
                if (postData.bnS().getPendantData() != null && !StringUtils.isNull(postData.bnS().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lRM.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lRM.a(postData.bnS(), 4);
                    pbCommenFloorItemViewHolder.lRu.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRM.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setUserId(postData.bnS().getUserId());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setUserName(postData.bnS().getUserName());
                    pbCommenFloorItemViewHolder.lRM.BG(postData.bnS().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lRu.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lRu, postData.bnS(), 4);
                    pbCommenFloorItemViewHolder.lRu.setUserId(postData.bnS().getUserId());
                    pbCommenFloorItemViewHolder.lRu.setUserName(postData.bnS().getUserName(), postData.dNY());
                    pbCommenFloorItemViewHolder.lRu.setTag(R.id.tag_virtual_user_url, postData.bnS().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lRu.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lRu.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lRu.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRM.setVisibility(8);
                }
                a(pbCommenFloorItemViewHolder.lRo, postData, str, cbVar);
            }
            int i2 = 0;
            if (aVar.dmy() && postData.bnS() != null) {
                i2 = postData.bnS().getLevel_id();
            }
            if (cbVar != null && cbVar.bmB()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.lRL.setVisibility(0);
                ap.setImageResource(pbCommenFloorItemViewHolder.lRL, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.lRL.setVisibility(8);
            }
            int i3 = 20;
            if (pbCommenFloorItemViewHolder.lRO.getChildCount() == 1) {
                i3 = 18;
            } else if (pbCommenFloorItemViewHolder.lRO.getChildCount() > 1) {
                i3 = 16;
            }
            if (pbCommenFloorItemViewHolder.lRo.getVisibility() == 0) {
                i3 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lRN.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.bnS() != null ? postData.bnS().getName_show() : "";
            int textLengthWithEmoji = ag.getTextLengthWithEmoji(name_show2);
            if (postData.bnS() != null && !StringUtils.isNull(postData.bnS().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ag.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ag.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.bnS() != null && !StringUtils.isNull(postData.bnS().getSealPrefix())) {
                pbCommenFloorItemViewHolder.idX.setText(a(aVar, postData.bnS().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.idX.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNO()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.bnS() == null || StringUtils.isNull(postData.bnS().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (cbVar != null && aVar.dmA() != 0) {
                if (aVar.dmA() != 1002 && aVar.dmA() != 3) {
                    z6 = true;
                }
                if (aVar.dmA() != 3 && !cbVar.isBjh()) {
                    z7 = true;
                }
                if (postData != null && postData.bnS() != null) {
                    String userId2 = postData.bnS().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z6 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        if (cbVar != null && cbVar.bnS() != null && postData.bnS() != null) {
                            userId = cbVar.bnS().getUserId();
                            String userId3 = postData.bnS().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z7 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z8 = true;
                                }
                                if (postData == null && postData.bnS() != null && UtilHelper.isCurrentAccount(postData.bnS().getUserId())) {
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
                                if (postData.dNO() == 1) {
                                    i4 = 0;
                                }
                                if (cbVar != null && cbVar.bmB()) {
                                    z3 = false;
                                    z4 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dmA()));
                                    if (postData.bnS() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z4) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bnS() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnS().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnS().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnS().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, cbVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z7 && cbVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.dmA()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
                                if (z) {
                                    pbCommenFloorItemViewHolder.lRP.setTag(sparseArray);
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
                        if (postData.dNO() == 1) {
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
                        pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            z3 = z6;
            if (cbVar != null) {
                userId = cbVar.bnS().getUserId();
                String userId32 = postData.bnS().getUserId();
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
            if (postData.dNO() == 1) {
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
            pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().sa(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fXZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().sb((int) (equipmentWidth * 1.618f));
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, boolean z, boolean z2, boolean z3, TbRichTextView.c cVar) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.lRv.Em(null);
                pbCommenFloorItemViewHolder.lRv.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sc(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sc(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().rZ(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lRv, view, StringUtils.isNull(postData.getBimg_url()) ? false : true);
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lRv.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lRv.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.lRv.setText(postData.dNQ(), true, cVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lRv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lRn.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, cb cbVar) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNO() > 0 && cbVar != null && !cbVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dNO()));
                pbCommenFloorItemViewHolder.lRK.setVisibility(0);
                pbCommenFloorItemViewHolder.lRK.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lRK.setVisibility(8);
                z = false;
            }
            g dNR = postData.dNR();
            boolean z2 = (dNR == null || StringUtils.isNull(dNR.getName()) || cbVar == null || cbVar.isBjh()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lRq.setVisibility(0);
                i = amW;
            } else {
                pbCommenFloorItemViewHolder.lRq.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lRr.setVisibility(0);
                i2 = amW;
            } else {
                pbCommenFloorItemViewHolder.lRr.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lRp.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lRp.setText(au.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lRp.setText(au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lRs.setVisibility(0);
                pbCommenFloorItemViewHolder.lRs.setPadding(amW, 0, 0, 0);
                pbCommenFloorItemViewHolder.lRs.setText(dNR.getName());
                return;
            }
            pbCommenFloorItemViewHolder.lRs.setVisibility(8);
        }
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dtB() == null) {
            pbCommenFloorItemViewHolder.lRQ.setVisibility(8);
            return;
        }
        TbRichText dNQ = postData.dNQ();
        com.baidu.tieba.pb.view.b.a(postData.dtB(), pbCommenFloorItemViewHolder.lRQ, false, false, dNQ != null && StringUtils.isNull(dNQ.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lRv.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lRv.Em(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lRv.Em(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lRv.setTextViewCheckSelection(false);
    }
}
