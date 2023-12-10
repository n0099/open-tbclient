package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.xl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public final class y3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(nwa postData, int i, SparseArray<Object> mHeaderTags, qw9 qw9Var) {
        boolean z;
        boolean z2;
        ThreadData threadData;
        boolean z3;
        boolean z4;
        String userId;
        int i2;
        boolean z5;
        boolean z6;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65536, null, postData, i, mHeaderTags, qw9Var) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(mHeaderTags, "mHeaderTags");
            if (i != 0) {
                if (i != 3) {
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                String userId2 = postData.u().getUserId();
                if (userId2 != null && Intrinsics.areEqual(userId2, TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                }
                if (userId2 == null || Intrinsics.areEqual(userId2, "0") || userId2.length() == 0) {
                    z = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (qw9Var != null) {
                threadData = qw9Var.l();
            } else {
                threadData = null;
            }
            if (threadData != null && qw9Var.l().getAuthor() != null && postData.u() != null) {
                String userId3 = qw9Var.l().getAuthor().getUserId();
                String userId4 = postData.u().getUserId();
                if (!StringUtils.isNull(userId3) && Intrinsics.areEqual(userId3, TbadkCoreApplication.getCurrentAccount())) {
                    if (!StringUtils.isNull(userId4) && Intrinsics.areEqual(userId4, TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                        userId = postData.u().getUserId();
                        if (userId != null) {
                            z2 = true;
                            z4 = true;
                        }
                        if (postData.L() == 1) {
                        }
                        if (z) {
                        }
                        if (z2) {
                        }
                        mHeaderTags.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                        mHeaderTags.put(R.id.tag_forbid_user_post_id, postData.U());
                        if (z) {
                        }
                        if (z3) {
                        }
                        if (z2) {
                        }
                    } else {
                        z2 = true;
                        z3 = true;
                        z4 = false;
                        userId = postData.u().getUserId();
                        if (userId != null && Intrinsics.areEqual(userId, TbadkCoreApplication.getCurrentAccount())) {
                            z2 = true;
                            z4 = true;
                        }
                        if (postData.L() == 1) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (z) {
                            mHeaderTags.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                            mHeaderTags.put(R.id.tag_forbid_user_post_id, postData.U());
                            if (postData.u() != null) {
                                mHeaderTags.put(R.id.tag_forbid_user_name, postData.u().getUserName());
                                mHeaderTags.put(R.id.tag_forbid_user_name_show, postData.u().getName_show());
                                mHeaderTags.put(R.id.tag_forbid_user_portrait, postData.u().getPortrait());
                            }
                            z5 = true;
                        } else {
                            mHeaderTags.put(R.id.tag_forbid_user_name, "");
                            mHeaderTags.put(R.id.tag_forbid_user_name_show, "");
                            mHeaderTags.put(R.id.tag_forbid_user_portrait, "");
                            z5 = false;
                        }
                        if (z2) {
                            mHeaderTags.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                            mHeaderTags.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                            mHeaderTags.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                            mHeaderTags.put(R.id.tag_del_post_id, postData.U());
                            z6 = true;
                        } else {
                            mHeaderTags.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                            mHeaderTags.put(R.id.tag_del_post_type, 0);
                            mHeaderTags.put(R.id.tag_del_post_id, "");
                            z6 = z5;
                        }
                        mHeaderTags.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                        mHeaderTags.put(R.id.tag_forbid_user_post_id, postData.U());
                        if (z) {
                            mHeaderTags.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            mHeaderTags.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                            if (postData.u() != null) {
                                mHeaderTags.put(R.id.tag_forbid_user_name, postData.u().getUserName());
                                mHeaderTags.put(R.id.tag_forbid_user_name_show, postData.u().getName_show());
                                mHeaderTags.put(R.id.tag_forbid_user_portrait, postData.u().getPortrait());
                            }
                        } else {
                            mHeaderTags.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                        }
                        if (z3) {
                            mHeaderTags.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            mHeaderTags.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.u() != null) {
                                mHeaderTags.put(R.id.tag_user_mute_mute_userid, postData.u().getUserId());
                                mHeaderTags.put(R.id.tag_user_mute_mute_username, postData.u().getUserName());
                                mHeaderTags.put(R.id.tag_user_mute_mute_nameshow, postData.u().getName_show());
                            }
                            if (qw9Var != null) {
                                threadData2 = qw9Var.l();
                            } else {
                                threadData2 = null;
                            }
                            if (threadData2 != null) {
                                mHeaderTags.put(R.id.tag_user_mute_thread_id, qw9Var.l().getId());
                            }
                            mHeaderTags.put(R.id.tag_user_mute_post_id, postData.U());
                        } else {
                            mHeaderTags.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z2) {
                            mHeaderTags.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            mHeaderTags.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                            mHeaderTags.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                            mHeaderTags.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                            mHeaderTags.put(R.id.tag_del_post_id, postData.U());
                            mHeaderTags.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.B0()));
                            return;
                        }
                        mHeaderTags.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        return;
                    }
                }
            }
            z3 = false;
            z4 = false;
            userId = postData.u().getUserId();
            if (userId != null) {
            }
            if (postData.L() == 1) {
            }
            if (z) {
            }
            if (z2) {
            }
            mHeaderTags.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
            mHeaderTags.put(R.id.tag_forbid_user_post_id, postData.U());
            if (z) {
            }
            if (z3) {
            }
            if (z2) {
            }
        }
    }

    public static final SpannableStringBuilder b(String str, String str2, NewSubPbActivity newSubPbActivity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, newSubPbActivity)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new xl6.a(str, R.drawable.pic_smalldot_title));
                return xl6.h(newSubPbActivity.getActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static final void c(int i, List<nwa> mSubList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, mSubList) == null) {
            Intrinsics.checkNotNullParameter(mSubList, "mSubList");
            if (mSubList.size() <= i) {
                mSubList.clear();
            }
            int i2 = 0;
            Iterator<nwa> it = mSubList.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public static final boolean d(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.Q() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.Q().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 17) {
                                    if (type != 18 && type != 1282) {
                                    }
                                } else {
                                    String str = next.R().mGifInfo.mSharpText;
                                    if (str != null && StringsKt__StringsJVMKt.startsWith$default(str, SmallTailInfo.EMOTION_PREFIX, false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(str, SmallTailInfo.EMOTION_SUFFIX, false, 2, null)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                        tbRichTextData.P('[' + substring + ']');
                                    }
                                }
                            }
                            tbRichTextData.n0(true);
                            textView.setMovementMethod(v9b.a());
                        } else {
                            tbRichTextData.P(next.Z());
                        }
                    }
                }
                if (!tbRichTextData.g0()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.Z() == null || tbRichTextData.Z().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.Z());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final void e(MetaData authorData, boolean z, TextView mUserName, HeadImageView mHeadPhoto, View view2, LinearLayout mHeaderUserRoot, TextView mFloorOwner, TbImageView mFloorOwnerImg, NewSubPbActivity mActivity) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{authorData, Boolean.valueOf(z), mUserName, mHeadPhoto, view2, mHeaderUserRoot, mFloorOwner, mFloorOwnerImg, mActivity}) == null) {
            Intrinsics.checkNotNullParameter(authorData, "authorData");
            Intrinsics.checkNotNullParameter(mUserName, "mUserName");
            Intrinsics.checkNotNullParameter(mHeadPhoto, "mHeadPhoto");
            Intrinsics.checkNotNullParameter(mHeaderUserRoot, "mHeaderUserRoot");
            Intrinsics.checkNotNullParameter(mFloorOwner, "mFloorOwner");
            Intrinsics.checkNotNullParameter(mFloorOwnerImg, "mFloorOwnerImg");
            Intrinsics.checkNotNullParameter(mActivity, "mActivity");
            String name_show = authorData.getName_show();
            int c = uu5.c(name_show);
            if (!StringUtils.isNull(authorData.getSealPrefix())) {
                i = rd.byteLength(authorData.getSealPrefix()) + 2;
            } else {
                i = 0;
            }
            if (c + i > 14) {
                String k = uu5.k(name_show, 0, 14);
                if (k.length() == name_show.length()) {
                    name_show = k;
                } else {
                    name_show = k + "...";
                }
            }
            if (!StringUtils.isNull(authorData.getSealPrefix())) {
                mUserName.setText(b(authorData.getSealPrefix(), name_show, mActivity));
            } else {
                mUserName.setText(name_show);
            }
            if (authorData.getAlaUserData() != null && view2 != null) {
                if (authorData.getAlaUserData().anchor_live == 0) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                    uq4 uq4Var = new uq4();
                    uq4Var.a = authorData.getAlaUserData();
                    uq4Var.b = 4;
                    view2.setTag(uq4Var);
                }
            }
            if (authorData.isBigV()) {
                SkinManager.setViewTextColor(mUserName, (int) R.color.cp_cont_r);
            } else {
                EMManager.from(mUserName).setTextColor(R.color.CAM_X0106);
            }
            mHeadPhoto.setVisibility(0);
            mHeadPhoto.setUserId(authorData.getUserId());
            mHeadPhoto.setTargetScheme(authorData.getTargetScheme());
            mHeadPhoto.setUserName(authorData.getUserName());
            mHeadPhoto.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(mHeadPhoto, authorData);
            ey9.a(mHeadPhoto, authorData.getAvatarUrl(), authorData.getAvater(), 28);
            mHeaderUserRoot.setTag(R.id.tag_user_id, authorData.getUserId());
            mHeaderUserRoot.setTag(R.id.tag_user_target_scheme, authorData.getTargetScheme());
            mHeaderUserRoot.setTag(R.id.tag_user_name, authorData.getUserName());
            mHeaderUserRoot.setTag(R.id.tag_virtual_user_url, authorData.getVirtualUserUrl());
            if (z) {
                mFloorOwner.setVisibility(0);
                SkinManager.setViewTextColor(mFloorOwner, (int) R.color.CAM_X0302);
                mFloorOwnerImg.setVisibility(8);
                return;
            }
            mFloorOwner.setVisibility(8);
            if (ListUtils.isEmpty(authorData.getTags())) {
                mFloorOwnerImg.setVisibility(8);
                return;
            }
            ThemeColorInfo info = authorData.getTags().get(0).img_info;
            Intrinsics.checkNotNullExpressionValue(info, "info");
            k2a.f(mFloorOwnerImg, info);
        }
    }
}
