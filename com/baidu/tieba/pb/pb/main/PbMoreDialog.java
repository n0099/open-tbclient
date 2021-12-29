package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.s0.b.d;
import c.a.s0.s.s.j;
import c.a.t0.s2.i;
import c.a.t0.s2.l;
import c.a.t0.s2.r.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PbMoreDialog extends PopupDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TbPageContext<?> z;

    /* loaded from: classes12.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbMoreDialog f48406e;

        public a(PbMoreDialog pbMoreDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbMoreDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48406e = pbMoreDialog;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f48406e.dismiss();
                this.f48406e.A.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbMoreDialog(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = tbPageContext;
        this.A = onClickListener;
        g();
    }

    public void changeLoginStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void confirmFeedback(SparseArray<Object> sparseArray, int i2, boolean z, t tVar) {
        TbPageContext<?> tbPageContext;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z), tVar}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(i.tag_clip_board);
        if (postData.q() != null) {
            boolean z2 = postData.q().hasAgree;
            int s = postData.s();
            if (z2 && s == 5) {
                tbPageContext = this.z;
                i3 = l.action_cancel_dislike;
            } else {
                tbPageContext = this.z;
                i3 = l.action_dislike;
            }
            String string = tbPageContext.getString(i3);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.tag_clip_board, postData);
            getDisagreeTextView().setTag(sparseArray2);
            getDisagreeTextView().setVisibility(0);
            getDisagreeTextView().setText(string);
        }
        boolean booleanValue = sparseArray.get(i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_is_self_post)).booleanValue() : false;
        String str = sparseArray.get(i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(i.tag_forbid_user_post_id) : null;
        if (booleanValue) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(i.tag_should_manage_visible, Boolean.TRUE);
            int i4 = i.tag_manage_user_identity;
            sparseArray3.put(i4, sparseArray.get(i4));
            int i5 = i.tag_forbid_user_name;
            sparseArray3.put(i5, sparseArray.get(i5));
            int i6 = i.tag_forbid_user_name_show;
            sparseArray3.put(i6, sparseArray.get(i6));
            int i7 = i.tag_forbid_user_portrait;
            sparseArray3.put(i7, sparseArray.get(i7));
            sparseArray3.put(i.tag_forbid_user_post_id, str);
            if (!c.a.t0.s2.u.f.g1.a.i(tVar) && booleanValue2) {
                sparseArray3.put(i.tag_user_mute_visible, Boolean.TRUE);
                int i8 = i.tag_is_mem;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = i.tag_user_mute_mute_userid;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = i.tag_user_mute_mute_username;
                sparseArray3.put(i10, sparseArray.get(i10));
                int i11 = i.tag_user_mute_mute_nameshow;
                sparseArray3.put(i11, sparseArray.get(i11));
                int i12 = i.tag_user_mute_post_id;
                sparseArray3.put(i12, sparseArray.get(i12));
                int i13 = i.tag_user_mute_thread_id;
                sparseArray3.put(i13, sparseArray.get(i13));
            } else {
                sparseArray3.put(i.tag_user_mute_visible, Boolean.FALSE);
            }
            if (booleanValue3) {
                sparseArray3.put(i.tag_should_delete_visible, Boolean.TRUE);
                sparseArray3.put(i.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                int i14 = i.tag_del_post_id;
                sparseArray3.put(i14, sparseArray.get(i14));
                int i15 = i.tag_del_post_type;
                sparseArray3.put(i15, sparseArray.get(i15));
                int i16 = i.tag_has_sub_post;
                sparseArray3.put(i16, sparseArray.get(i16));
                if (booleanValue5) {
                    getDeleteTextView().setVisibility(0);
                } else {
                    getDeleteTextView().setVisibility(8);
                }
            } else {
                sparseArray3.put(i.tag_should_delete_visible, Boolean.FALSE);
                getDeleteTextView().setVisibility(8);
            }
            getManageTextView().setTag(sparseArray3);
            getDeleteTextView().setTag(sparseArray3);
            getManageTextView().setText(l.bar_manager);
            getManageTextView().setVisibility(0);
        } else if (booleanValue3) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.tag_should_manage_visible, Boolean.FALSE);
            sparseArray4.put(i.tag_user_mute_visible, Boolean.FALSE);
            sparseArray4.put(i.tag_should_delete_visible, Boolean.TRUE);
            int i17 = i.tag_manage_user_identity;
            sparseArray4.put(i17, sparseArray.get(i17));
            sparseArray4.put(i.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
            int i18 = i.tag_del_post_id;
            sparseArray4.put(i18, sparseArray.get(i18));
            int i19 = i.tag_del_post_type;
            sparseArray4.put(i19, sparseArray.get(i19));
            int i20 = i.tag_has_sub_post;
            sparseArray4.put(i20, sparseArray.get(i20));
            getManageTextView().setTag(sparseArray4);
            getDeleteTextView().setTag(sparseArray4);
            getManageTextView().setText(l.delete);
            getDeleteTextView().setVisibility(0);
            if (i2 == 1002 && !booleanValue4) {
                getDeleteTextView().setText(l.report_text);
            } else {
                getDeleteTextView().setText(l.delete);
            }
            getManageTextView().setVisibility(8);
        } else {
            getManageTextView().setVisibility(8);
            getDeleteTextView().setVisibility(8);
        }
        boolean booleanValue6 = sparseArray.get(i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue7 = sparseArray.get(i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_manage_visible)).booleanValue() : false;
        if (!c.a.t0.s2.u.f.g1.a.i(tVar) && !booleanValue7 && booleanValue6) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(i.tag_user_mute_visible, Boolean.TRUE);
            int i21 = i.tag_is_mem;
            sparseArray5.put(i21, sparseArray.get(i21));
            int i22 = i.tag_user_mute_mute_userid;
            sparseArray5.put(i22, sparseArray.get(i22));
            int i23 = i.tag_user_mute_mute_username;
            sparseArray5.put(i23, sparseArray.get(i23));
            int i24 = i.tag_user_mute_mute_nameshow;
            sparseArray5.put(i24, sparseArray.get(i24));
            int i25 = i.tag_user_mute_post_id;
            sparseArray5.put(i25, sparseArray.get(i25));
            int i26 = i.tag_user_mute_thread_id;
            sparseArray5.put(i26, sparseArray.get(i26));
            int i27 = i.tag_del_post_is_self;
            sparseArray5.put(i27, sparseArray.get(i27));
            int i28 = i.tag_del_post_type;
            sparseArray5.put(i28, sparseArray.get(i28));
            int i29 = i.tag_del_post_id;
            sparseArray5.put(i29, sparseArray.get(i29));
            int i30 = i.tag_manage_user_identity;
            sparseArray5.put(i30, sparseArray.get(i30));
            getReportTextView().setTag(sparseArray5);
            getReportTextView().setVisibility(0);
            getManageTextView().setVisibility(8);
            getReportTextView().setText(l.mute_option);
        } else {
            if (sparseArray.get(i.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray.get(i.tag_del_post_is_self)).booleanValue();
            }
            String str2 = sparseArray.get(i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(i.tag_forbid_user_post_id) : null;
            if (z) {
                getReportTextView().setVisibility(0);
                getReportTextView().setTag(str2);
            } else {
                getReportTextView().setVisibility(8);
            }
        }
        getNewChudianHide().setVisibility(8);
        getCopyTextView().setVisibility(8);
        getEmotionTextView().setVisibility(8);
        getMarkTextView().setVisibility(8);
        getSaveLocalTextView().setVisibility(8);
        c.a.t0.s2.u.f.g1.a.l(this.w, postData, tVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void confirmItems(SparseArray<Object> sparseArray, int i2, boolean z, boolean z2, t tVar) {
        boolean z3;
        boolean booleanValue;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), tVar}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(i.tag_clip_board);
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(i.tag_clip_board, (PostData) sparseArray.get(i.tag_clip_board));
        sparseArray2.put(i.tag_is_subpb, Boolean.FALSE);
        getMarkTextView().setTag(sparseArray2);
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(i.tag_clip_board, (PostData) sparseArray.get(i.tag_clip_board));
        getCopyTextView().setTag(sparseArray3);
        boolean booleanValue2 = sparseArray.get(i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_is_self_post)).booleanValue() : false;
        String str = sparseArray.get(i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(i.tag_forbid_user_post_id) : null;
        if (booleanValue2) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.tag_should_manage_visible, Boolean.TRUE);
            int i3 = i.tag_manage_user_identity;
            sparseArray4.put(i3, sparseArray.get(i3));
            int i4 = i.tag_forbid_user_name;
            sparseArray4.put(i4, sparseArray.get(i4));
            int i5 = i.tag_forbid_user_name_show;
            sparseArray4.put(i5, sparseArray.get(i5));
            int i6 = i.tag_forbid_user_portrait;
            sparseArray4.put(i6, sparseArray.get(i6));
            sparseArray4.put(i.tag_forbid_user_post_id, str);
            if (!c.a.t0.s2.u.f.g1.a.i(tVar) && booleanValue3) {
                sparseArray4.put(i.tag_user_mute_visible, Boolean.TRUE);
                int i7 = i.tag_is_mem;
                sparseArray4.put(i7, sparseArray.get(i7));
                int i8 = i.tag_user_mute_mute_userid;
                sparseArray4.put(i8, sparseArray.get(i8));
                int i9 = i.tag_user_mute_mute_username;
                sparseArray4.put(i9, sparseArray.get(i9));
                int i10 = i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i10, sparseArray.get(i10));
                int i11 = i.tag_user_mute_post_id;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = i.tag_user_mute_thread_id;
                sparseArray4.put(i12, sparseArray.get(i12));
            } else {
                sparseArray4.put(i.tag_user_mute_visible, Boolean.FALSE);
            }
            if (booleanValue4) {
                sparseArray4.put(i.tag_should_delete_visible, Boolean.TRUE);
                sparseArray4.put(i.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
                int i13 = i.tag_del_post_id;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = i.tag_del_post_type;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = i.tag_has_sub_post;
                sparseArray4.put(i15, sparseArray.get(i15));
                if (booleanValue6) {
                    getDeleteTextView().setVisibility(0);
                } else {
                    getDeleteTextView().setVisibility(8);
                }
            } else {
                sparseArray4.put(i.tag_should_delete_visible, Boolean.FALSE);
                getDeleteTextView().setVisibility(8);
            }
            getManageTextView().setTag(sparseArray4);
            getDeleteTextView().setTag(sparseArray4);
            getManageTextView().setText(l.bar_manager);
            getManageTextView().setVisibility(0);
        } else if (booleanValue4) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(i.tag_should_manage_visible, Boolean.FALSE);
            sparseArray5.put(i.tag_user_mute_visible, Boolean.FALSE);
            sparseArray5.put(i.tag_should_delete_visible, Boolean.TRUE);
            int i16 = i.tag_manage_user_identity;
            sparseArray5.put(i16, sparseArray.get(i16));
            sparseArray5.put(i.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
            int i17 = i.tag_del_post_id;
            sparseArray5.put(i17, sparseArray.get(i17));
            int i18 = i.tag_del_post_type;
            sparseArray5.put(i18, sparseArray.get(i18));
            int i19 = i.tag_has_sub_post;
            sparseArray5.put(i19, sparseArray.get(i19));
            getManageTextView().setTag(sparseArray5);
            getDeleteTextView().setTag(sparseArray5);
            getManageTextView().setText(l.delete);
            getDeleteTextView().setVisibility(0);
            if (i2 == 1002 && !booleanValue5) {
                getDeleteTextView().setText(l.report_text);
            } else {
                getDeleteTextView().setText(l.delete);
            }
            getManageTextView().setVisibility(8);
        } else {
            getManageTextView().setVisibility(8);
            getDeleteTextView().setVisibility(8);
        }
        boolean booleanValue7 = sparseArray.get(i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue8 = sparseArray.get(i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_manage_visible)).booleanValue() : false;
        if (!c.a.t0.s2.u.f.g1.a.i(tVar) && !booleanValue8 && booleanValue7) {
            SparseArray sparseArray6 = new SparseArray();
            sparseArray6.put(i.tag_user_mute_visible, Boolean.TRUE);
            int i20 = i.tag_is_mem;
            sparseArray6.put(i20, sparseArray.get(i20));
            int i21 = i.tag_user_mute_mute_userid;
            sparseArray6.put(i21, sparseArray.get(i21));
            int i22 = i.tag_user_mute_mute_username;
            sparseArray6.put(i22, sparseArray.get(i22));
            int i23 = i.tag_user_mute_mute_nameshow;
            sparseArray6.put(i23, sparseArray.get(i23));
            int i24 = i.tag_user_mute_post_id;
            sparseArray6.put(i24, sparseArray.get(i24));
            int i25 = i.tag_user_mute_thread_id;
            sparseArray6.put(i25, sparseArray.get(i25));
            int i26 = i.tag_del_post_is_self;
            sparseArray6.put(i26, sparseArray.get(i26));
            int i27 = i.tag_del_post_type;
            sparseArray6.put(i27, sparseArray.get(i27));
            int i28 = i.tag_del_post_id;
            sparseArray6.put(i28, sparseArray.get(i28));
            int i29 = i.tag_manage_user_identity;
            sparseArray6.put(i29, sparseArray.get(i29));
            getReportTextView().setTag(sparseArray6);
            getReportTextView().setVisibility(0);
            getManageTextView().setVisibility(8);
            getReportTextView().setText(l.mute_option);
        } else {
            if (sparseArray.get(i.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray.get(i.tag_del_post_is_self)).booleanValue();
            }
            String str2 = sparseArray.get(i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(i.tag_forbid_user_post_id) : null;
            if (z) {
                getReportTextView().setVisibility(0);
                getReportTextView().setTag(str2);
            } else {
                getReportTextView().setVisibility(8);
            }
        }
        boolean booleanValue9 = sparseArray.get(i.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.tag_should_hide_chudian_visible)).booleanValue() : false;
        long longValue = sparseArray.get(i.tag_chudian_template_id) instanceof Long ? ((Long) sparseArray.get(i.tag_chudian_template_id)).longValue() : 0L;
        String str3 = sparseArray.get(i.tag_chudian_monitor_id) instanceof String ? (String) sparseArray.get(i.tag_chudian_monitor_id) : "";
        int intValue = sparseArray.get(i.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(i.tag_chudian_hide_day)).intValue() : 0;
        if (booleanValue9) {
            getNewChudianHide().setVisibility(0);
            getNewChudianHide().setTag(i.tag_chudian_template_id, Long.valueOf(longValue));
            getNewChudianHide().setTag(i.tag_chudian_monitor_id, str3);
            getNewChudianHide().setTag(i.tag_chudian_hide_day, Integer.valueOf(intValue));
        } else {
            getNewChudianHide().setVisibility(8);
        }
        if (sparseArray.get(i.tag_richtext_emotion) instanceof Boolean) {
            z3 = ((Boolean) sparseArray.get(i.tag_richtext_emotion)).booleanValue();
            if (this.z.getPageActivity() instanceof NewSubPbActivity) {
                NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.z.getPageActivity();
                if (z3 && newSubPbActivity.getSubPbModel() != null && newSubPbActivity.getSubPbModel().j0() != null && newSubPbActivity.getSubPbModel().j0().l() != null && !newSubPbActivity.getSubPbModel().j0().l().T1()) {
                    z3 = true;
                }
            }
            booleanValue = !(sparseArray.get(i.tag_richtext_image) instanceof Boolean) ? ((Boolean) sparseArray.get(i.tag_richtext_image)).booleanValue() : false;
            if (!z3) {
                getEmotionTextView().setVisibility(0);
            } else {
                getEmotionTextView().setVisibility(8);
            }
            if (!booleanValue) {
                getSaveLocalTextView().setVisibility(0);
            } else {
                getSaveLocalTextView().setVisibility(8);
            }
            if (z3 && !booleanValue) {
                getCopyTextView().setVisibility(0);
            } else {
                getCopyTextView().setVisibility(8);
            }
            getDisagreeTextView().setVisibility(8);
            if (z2) {
                getDeleteTextView().setVisibility(8);
                getManageTextView().setVisibility(8);
                getReportTextView().setVisibility(8);
            }
            if (d.N()) {
                if (postData != null) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(i.tag_load_sub_data, postData);
                    getReplyTextView().setTag(sparseArray7);
                    getReplyTextView().setText(l.action_reply);
                    getReplyTextView().setVisibility(0);
                }
                if (postData != null) {
                    SparseArray sparseArray8 = new SparseArray();
                    sparseArray8.put(i.tag_load_sub_data, postData);
                    sparseArray8.put(i.tag_is_subpb, Boolean.valueOf(!postData.k0));
                    getShareTextView().setTag(sparseArray8);
                    getShareTextView().setText(l.action_share);
                    getReplyTextView().setVisibility(0);
                }
                if (postData.q() != null) {
                    boolean z4 = postData.q().hasAgree;
                    int s = postData.s();
                    if (z4 && s == 5) {
                        string = this.z.getString(l.action_cancel_dislike);
                    } else {
                        string = this.z.getString(l.action_dislike);
                    }
                    SparseArray sparseArray9 = new SparseArray();
                    sparseArray9.put(i.tag_clip_board, postData);
                    getDisagreeTextView().setTag(sparseArray9);
                    getDisagreeTextView().setVisibility(0);
                    getDisagreeTextView().setText(string);
                }
            }
            c.a.t0.s2.u.f.g1.a.l(this.w, postData, tVar);
        }
        z3 = false;
        if (!(sparseArray.get(i.tag_richtext_image) instanceof Boolean)) {
        }
        if (!z3) {
        }
        if (!booleanValue) {
        }
        if (z3) {
        }
        getCopyTextView().setVisibility(8);
        getDisagreeTextView().setVisibility(8);
        if (z2) {
        }
        if (d.N()) {
        }
        c.a.t0.s2.u.f.g1.a.l(this.w, postData, tVar);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a aVar = new a(this);
            if (d.N()) {
                setDefaultContentView(null, new String[]{this.z.getString(l.action_reply), this.z.getString(l.action_share), this.z.getString(l.action_dislike), this.z.getString(l.no_interesting), this.z.getString(l.save_to_emotion), this.z.getString(l.save_to_local), this.z.getString(l.copy), this.z.getString(l.mark), this.z.getString(l.report_text), this.z.getString(l.delete), this.z.getString(l.mute), this.z.getString(l.block_user)}, aVar);
                this.x = h(getItemView(0));
                this.y = h(getItemView(1));
                this.v = h(getItemView(2));
                this.u = h(getItemView(3));
                this.s = h(getItemView(4));
                this.t = h(getItemView(5));
                this.r = h(getItemView(6));
                this.n = h(getItemView(7));
                this.p = h(getItemView(8));
                this.q = h(getItemView(9));
                this.o = h(getItemView(10));
                this.w = h(getItemView(11));
                return;
            }
            setDefaultContentView(null, new String[]{this.z.getString(l.action_dislike), this.z.getString(l.no_interesting), this.z.getString(l.save_to_emotion), this.z.getString(l.save_to_local), this.z.getString(l.copy), this.z.getString(l.mark), this.z.getString(l.report_text), this.z.getString(l.delete), this.z.getString(l.mute), this.z.getString(l.block_user)}, aVar);
            this.u = h(getItemView(1));
            this.n = h(getItemView(5));
            this.o = h(getItemView(8));
            this.p = h(getItemView(6));
            this.q = h(getItemView(7));
            this.r = h(getItemView(4));
            this.s = h(getItemView(2));
            this.t = h(getItemView(3));
            this.v = h(getItemView(0));
            this.w = h(getItemView(9));
        }
    }

    public TextView getBlockTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w : (TextView) invokeV.objValue;
    }

    public TextView getCopyTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : (TextView) invokeV.objValue;
    }

    public TextView getDeleteTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView getDisagreeTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public TextView getEmotionTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s : (TextView) invokeV.objValue;
    }

    public View getItemView(int i2) {
        InterceptResult invokeI;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            View view = this.mContentView;
            if (view != null && (view instanceof ViewGroup) && (findViewById = view.findViewById(i.content_view)) != null && (findViewById instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) findViewById;
                int childCount = viewGroup.getChildCount();
                if (i2 >= 0 && i2 <= childCount - 1) {
                    return viewGroup.getChildAt(i2);
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public TextView getManageTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView getMarkTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView getNewChudianHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u : (TextView) invokeV.objValue;
    }

    public TextView getReplyTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.x : (TextView) invokeV.objValue;
    }

    public TextView getReportTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public TextView getSaveLocalTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView getShareTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.y : (TextView) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getRootView() : (View) invokeV.objValue;
    }

    public final TextView h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) ? (TextView) view.findViewById(i.item_view) : (TextView) invokeL.objValue;
    }
}
