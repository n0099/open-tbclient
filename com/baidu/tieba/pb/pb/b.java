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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
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
/* loaded from: classes21.dex */
public class b {
    private static SparseArray<SoftReference<Drawable>> lpn = new SparseArray<>();
    private static SparseIntArray lpo = new SparseIntArray();
    public static final int alc = getDimensionPixelSize(R.dimen.tbds16);

    public static int getDimensionPixelSize(int i) {
        int i2 = lpo.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            lpo.put(i, dimensionPixelSize);
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
                ap.setViewTextColor(nVar.hGe, R.color.CAM_X0106, 1);
                ap.setViewTextColor(nVar.lrP, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lrQ, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lrR, R.color.CAM_X0109);
                ap.setViewTextColor(nVar.lsl, R.color.CAM_X0109, 1);
                ap.setViewTextColor(nVar.lrS, R.color.CAM_X0109, 1);
                nVar.lrV.setTextColor(ap.getColor(R.color.CAM_X0105));
                nVar.lrW.onChangeSkinType();
                if (z) {
                    SvgManager.bqB().a(nVar.lsq, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lsi, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lsg, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    ap.setViewTextColor(nVar.lsh, R.color.CAM_X0109);
                    ap.setViewTextColor(nVar.lsj, R.color.CAM_X0109);
                }
                WebPManager.a(nVar.lsb, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.jKJ, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                if (fVar != null) {
                    ap.setViewTextColor(nVar.lrZ, R.color.CAM_X0108);
                    nVar.lrZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                    ap.setViewTextColor(nVar.lsa, R.color.CAM_X0108);
                    ap.c(nVar.lrY, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                    nVar.lrY.onChangeSkinType();
                    ap.setViewTextColor(nVar.lsv, R.color.CAM_X0304, 1);
                    ap.setViewTextColor(nVar.lst, R.color.CAM_X0106, 1);
                    ap.setBackgroundResource(nVar.lss, R.color.CAM_X0205);
                    ap.setBackgroundResource(nVar.lsu, R.color.CAM_X0109);
                    ap.setImageResource(nVar.lsw, R.drawable.icon_arrow_more_gray);
                    ap.setViewTextColor(nVar.lsz, R.color.CAM_X0107);
                    if (nVar.lsx.getVisibility() == 8) {
                        nVar.lrZ.setVisibility(8);
                        nVar.lsa.setVisibility(8);
                        nVar.lsz.setText(R.string.close_content);
                    } else if (StringUtils.isNull(fVar.dhS())) {
                        nVar.lsz.setText(fVar.dhS());
                    } else {
                        nVar.lsz.setText(R.string.expand_content);
                    }
                } else {
                    nVar.lrY.setVisibility(8);
                    nVar.lrZ.setVisibility(8);
                    nVar.lsa.setVisibility(8);
                    nVar.lss.setVisibility(8);
                    nVar.lsz.setVisibility(8);
                }
                ap.setBackgroundColor(nVar.mBottomLine, R.color.CAM_X0203);
            }
            nVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bx bxVar, int i, boolean z) {
        if (nVar != null && postData != null && postData.bnv() != null) {
            if (bxVar != null) {
                postData.bnv().threadId = bxVar.getTid();
                postData.bnv().forumId = String.valueOf(bxVar.getFid());
            }
            if (i == 0) {
                postData.bnv().objType = 1;
            } else {
                postData.bnv().objType = 2;
            }
            postData.bnv().isInPost = true;
            if (z) {
                nVar.lsk.setAgreeAlone(true);
                nVar.lsk.setData(postData.bnv());
            }
            if (bxVar != null && bxVar.bkm()) {
                nVar.lrT.setAgreeAlone(true);
            }
            nVar.lrT.setData(postData.bnv());
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z, boolean z2) {
        String string;
        if (nVar.jKJ != null && postData != null) {
            if (z2) {
                nVar.jKJ.setVisibility(8);
                if (z) {
                    if (d.bhe()) {
                        string = postData.dJU() > 0 ? String.valueOf(postData.dJU()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.reply);
                    }
                    nVar.lsj.setText(string);
                    return;
                }
                return;
            }
            nVar.jKJ.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(TextView textView, PostData postData, String str, bx bxVar) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (bxVar != null && bxVar.bkm()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.blC() != null) {
                MetaData blC = postData.blC();
                if (str != null && !str.equals("0") && str.equals(blC.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.bj(textView).pb(R.string.J_X04).pd(R.dimen.L_X01).oT(R.color.CAM_X0302).pc(R.color.CAM_X0302);
                } else if (blC.getIs_bawu() == 1 && postData.dJI()) {
                    c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                    c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                    c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_content_assist".equals(blC.getBawu_type())) {
                    c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_manage_assist".equals(blC.getBawu_type())) {
                    c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, int i, a aVar, bx bxVar, boolean z) {
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
            if (postData.blC() == null || postData.blC().isBaijiahaoUser()) {
            }
            if (postData.mYu) {
                ap.setBackgroundColor(nVar.mTopLine, R.color.CAM_X0204);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            if (bxVar == null || bxVar.blC() == null) {
                str = null;
            } else {
                str = bxVar.blC().getUserId();
            }
            nVar.lrU.setTag(null);
            nVar.lrU.setUserId(null);
            nVar.hGe.setText((CharSequence) null);
            nVar.lsn.getHeadView().setUserId(null);
            nVar.lrV.setIsHost(false);
            if (postData.blC() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.blC().getUserId())) {
                    nVar.lrV.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.blC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.blC().getTShowInfoNew();
                if (nVar.lsp != null) {
                    nVar.lsp.setTag(R.id.tag_user_id, postData.blC().getUserId());
                    nVar.lsp.setOnClickListener(aVar.diM().lGr);
                    int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lsp.a(iconInfo, 2, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lso != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lso.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    nVar.lso.setOnClickListener(aVar.diM().lGs);
                    int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lso.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!y.isEmpty(tShowInfoNew) || postData.blC().isBigV()) {
                    ap.setViewTextColor(nVar.hGe, R.color.CAM_X0301, 1);
                } else {
                    ap.setViewTextColor(nVar.hGe, R.color.CAM_X0106, 1);
                }
                String avater = postData.blC().getAvater();
                nVar.hGe.setTag(R.id.tag_user_id, postData.blC().getUserId());
                nVar.hGe.setTag(R.id.tag_user_name, postData.blC().getUserName());
                nVar.hGe.setTag(R.id.tag_virtual_user_url, postData.blC().getVirtualUserUrl());
                String name_show = postData.blC().getName_show();
                String userName = postData.blC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hGe.setText(com.baidu.tieba.pb.c.aR(aVar.getPageContext().getPageActivity(), nVar.hGe.getText().toString()));
                    nVar.hGe.setGravity(16);
                    nVar.hGe.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhr());
                    ap.setViewTextColor(nVar.hGe, R.color.CAM_X0312, 1);
                }
                if (postData.blC().getPendantData() != null && !StringUtils.isNull(postData.blC().getPendantData().bjy())) {
                    nVar.lsn.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lsn.a(postData.blC(), 4);
                    nVar.lrU.setVisibility(8);
                    nVar.lsn.setVisibility(0);
                    nVar.lsn.getHeadView().startLoad(avater, 28, false);
                    nVar.lsn.getHeadView().setUserId(postData.blC().getUserId());
                    nVar.lsn.getHeadView().setUserName(postData.blC().getUserName());
                    nVar.lsn.BO(postData.blC().getPendantData().bjy());
                } else {
                    nVar.lrU.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lrU, postData.blC(), 4);
                    nVar.lrU.setUserId(postData.blC().getUserId());
                    nVar.lrU.setUserName(postData.blC().getUserName(), postData.dKa());
                    nVar.lrU.setTag(R.id.tag_virtual_user_url, postData.blC().getVirtualUserUrl());
                    nVar.lrU.setImageDrawable(null);
                    nVar.lrU.startLoad(avater, 28, false);
                    nVar.lrU.setVisibility(0);
                    nVar.lsn.setVisibility(8);
                }
                a(nVar.lrO, postData, str, bxVar);
            }
            int i2 = 0;
            if (aVar.diN() && postData.blC() != null) {
                i2 = postData.blC().getLevel_id();
            }
            if (bxVar != null && bxVar.bkm()) {
                i2 = 0;
            }
            if (i2 > 0) {
                nVar.lsm.setVisibility(0);
                ap.setImageResource(nVar.lsm, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                nVar.lsm.setVisibility(8);
            }
            int i3 = 20;
            if (nVar.lsp.getChildCount() == 1) {
                i3 = 18;
            } else if (nVar.lsp.getChildCount() > 1) {
                i3 = 16;
            }
            if (nVar.lrO.getVisibility() == 0) {
                i3 -= 2;
            }
            if (nVar.lso.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.blC() != null ? postData.blC().getName_show() : "";
            int textLengthWithEmoji = ae.getTextLengthWithEmoji(name_show2);
            if (postData.blC() != null && !StringUtils.isNull(postData.blC().getSealPrefix())) {
                if (textLengthWithEmoji > i3 - 2) {
                    name_show2 = ae.subStringWithEmoji(name_show2, i3 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i3) {
                name_show2 = ae.subStringWithEmoji(name_show2, i3) + StringHelper.STRING_MORE;
            }
            if (postData.blC() != null && !StringUtils.isNull(postData.blC().getSealPrefix())) {
                nVar.hGe.setText(a(aVar, postData.blC().getSealPrefix(), name_show2));
            } else {
                nVar.hGe.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJQ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (postData.blC() == null || StringUtils.isNull(postData.blC().getVirtualUserUrl())) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (bxVar != null && aVar.diP() != 0) {
                if (aVar.diP() != 1002 && aVar.diP() != 3) {
                    z9 = true;
                }
                if (aVar.diP() != 3 && !bxVar.isBjh()) {
                    z10 = true;
                }
                if (postData != null && postData.blC() != null) {
                    String userId2 = postData.blC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z12 = z10;
                        z3 = false;
                        z4 = z12;
                        if (bxVar != null && bxVar.blC() != null && postData.blC() != null) {
                            userId = bxVar.blC().getUserId();
                            String userId3 = postData.blC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z5 = true;
                                z6 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z6 = false;
                                    z11 = true;
                                }
                                if (postData == null && postData.blC() != null && UtilHelper.isCurrentAccount(postData.blC().getUserId())) {
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
                                if (postData.dJQ() == 1) {
                                    i4 = 0;
                                }
                                if (bxVar != null && bxVar.bkm()) {
                                    z3 = false;
                                    z6 = false;
                                }
                                if (z3) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.diP()));
                                    if (postData.blC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z6) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.blC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.blC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.blC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.blC().getName_show());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_thread_id, bxVar.getId());
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (!z8 && bxVar != null) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aVar.diP()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lrV.setTag(sparseArray);
                                if (z) {
                                    nVar.lsq.setTag(sparseArray);
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
                        if (postData.dJQ() == 1) {
                        }
                        if (bxVar != null) {
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
                        nVar.lrV.setTag(sparseArray);
                        if (z) {
                        }
                    }
                }
            }
            boolean z13 = z10;
            z3 = z9;
            z4 = z13;
            if (bxVar != null) {
                userId = bxVar.blC().getUserId();
                String userId32 = postData.blC().getUserId();
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
            if (postData.dJQ() == 1) {
            }
            if (bxVar != null) {
            }
            if (z3) {
            }
            if (z6) {
            }
            if (!z8) {
            }
            sparseArray.put(R.id.tag_should_delete_visible, false);
            nVar.lrV.setTag(sparseArray);
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
                tbRichTextView.getLayoutStrategy().sL(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sL(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fHC = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (z2) {
                tbRichTextView.getLayoutStrategy().sM((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().sM((int) (equipmentWidth * 1.618f));
            }
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, View view, boolean z, boolean z2, boolean z3, boolean z4, TbRichTextView.c cVar) {
        if (nVar != null && postData != null) {
            Activity pageActivity = aVar.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = l.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = l.getDimens(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                nVar.lrV.El(null);
                nVar.lrV.setBackgroundDrawable(null);
                nVar.lrV.getLayoutStrategy().sN(R.drawable.transparent_bg);
            } else {
                nVar.lrV.getLayoutStrategy().sN(R.drawable.icon_click);
            }
            nVar.lrV.getLayoutStrategy().sK(R.drawable.pic_video);
            a(nVar.lrV, view, StringUtils.isNull(postData.getBimg_url()) ? false : true, z2);
            nVar.lrV.setLayoutParams(layoutParams);
            nVar.lrV.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            nVar.lrV.setIsFromCDN(z3);
            nVar.lrV.setText(postData.dJS(), true, cVar);
            SparseArray sparseArray = (SparseArray) nVar.lrV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z4));
            nVar.lrV.setTag(sparseArray);
            nVar.lrN.setTag(R.id.tag_from, sparseArray);
        }
    }

    public static void a(a aVar, com.baidu.tieba.pb.pb.main.n nVar, PostData postData, bx bxVar) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dJQ() > 0 && bxVar != null && !bxVar.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.is_floor), Integer.valueOf(postData.dJQ()));
                nVar.lsl.setVisibility(0);
                nVar.lsl.setText(format);
                z = true;
            } else {
                nVar.lsl.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dJT = postData.dJT();
            boolean z2 = (dJT == null || StringUtils.isNull(dJT.getName()) || bxVar == null || bxVar.isBjh()) ? false : true;
            if (z) {
                nVar.lrQ.setVisibility(0);
                i = alc;
            } else {
                nVar.lrQ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lrR.setVisibility(0);
                i2 = alc;
            } else {
                nVar.lrR.setVisibility(8);
                i2 = 0;
            }
            nVar.lrP.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lrP.setText(au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lrP.setText(au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lrS.setVisibility(0);
                nVar.lrS.setPadding(alc, 0, 0, 0);
                nVar.lrS.setText(dJT.getName());
                return;
            }
            nVar.lrS.setVisibility(8);
        }
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData) {
        if (postData == null || postData.dpH() == null) {
            nVar.lsr.setVisibility(8);
            return;
        }
        TbRichText dJS = postData.dJS();
        com.baidu.tieba.pb.view.b.a(postData.dpH(), nVar.lsr, false, false, dJS != null && StringUtils.isNull(dJS.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    public static void a(com.baidu.tieba.pb.pb.main.n nVar, PostData postData, boolean z) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lrV.setLayoutParams(layoutParams);
            nVar.lrV.setPadding(0, 0, 0, 0);
            nVar.lrV.El(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lrV.setLayoutParams(layoutParams2);
            nVar.lrV.El(postData.getBimg_url());
        }
        nVar.lrV.setTextViewCheckSelection(false);
    }
}
