package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.q0.r.t.j;
import c.a.r0.u2.h.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbMoreDialog f45180e;

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
            this.f45180e = pbMoreDialog;
        }

        @Override // c.a.q0.r.t.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f45180e.dismiss();
                this.f45180e.A.onClick(view);
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
        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
        if (postData.q() != null) {
            boolean z2 = postData.q().hasAgree;
            int s = postData.s();
            if (z2 && s == 5) {
                tbPageContext = this.z;
                i3 = R.string.action_cancel_dislike;
            } else {
                tbPageContext = this.z;
                i3 = R.string.action_dislike;
            }
            String string = tbPageContext.getString(i3);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, postData);
            getDisagreeTextView().setTag(sparseArray2);
            getDisagreeTextView().setVisibility(0);
            getDisagreeTextView().setText(string);
        }
        boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue() : false;
        String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
        if (booleanValue) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_forbid_user_post_id, str);
            if (!c.a.r0.u2.k.f.h1.a.i(tVar) && booleanValue2) {
                sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            } else {
                sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            }
            if (booleanValue3) {
                sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                if (booleanValue5) {
                    getDeleteTextView().setVisibility(0);
                } else {
                    getDeleteTextView().setVisibility(8);
                }
            } else {
                sparseArray3.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                getDeleteTextView().setVisibility(8);
            }
            getManageTextView().setTag(sparseArray3);
            getDeleteTextView().setTag(sparseArray3);
            getManageTextView().setText(R.string.bar_manager);
            getManageTextView().setVisibility(0);
        } else if (booleanValue3) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
            sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
            getManageTextView().setTag(sparseArray4);
            getDeleteTextView().setTag(sparseArray4);
            getManageTextView().setText(R.string.delete);
            getDeleteTextView().setVisibility(0);
            if (i2 == 1002 && !booleanValue4) {
                getDeleteTextView().setText(R.string.report_text);
            } else {
                getDeleteTextView().setText(R.string.delete);
            }
            getManageTextView().setVisibility(8);
        } else {
            getManageTextView().setVisibility(8);
            getDeleteTextView().setVisibility(8);
        }
        boolean booleanValue6 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue7 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        if (!c.a.r0.u2.k.f.h1.a.i(tVar) && !booleanValue7 && booleanValue6) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
            sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray5.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            getReportTextView().setTag(sparseArray5);
            getReportTextView().setVisibility(0);
            getManageTextView().setVisibility(8);
            getReportTextView().setText(R.string.mute_option);
        } else {
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
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
        c.a.r0.u2.k.f.h1.a.l(this.w, postData, tVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void confirmItems(SparseArray<Object> sparseArray, int i2, boolean z, boolean z2, t tVar) {
        boolean z3;
        boolean booleanValue;
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), tVar}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
        sparseArray2.put(R.id.tag_is_subpb, Boolean.FALSE);
        getMarkTextView().setTag(sparseArray2);
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
        getCopyTextView().setTag(sparseArray3);
        boolean booleanValue2 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue() : false;
        String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
        if (booleanValue2) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray4.put(R.id.tag_forbid_user_post_id, str);
            if (!c.a.r0.u2.k.f.h1.a.i(tVar) && booleanValue3) {
                sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            } else {
                sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            }
            if (booleanValue4) {
                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
                sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                if (booleanValue6) {
                    getDeleteTextView().setVisibility(0);
                } else {
                    getDeleteTextView().setVisibility(8);
                }
            } else {
                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                getDeleteTextView().setVisibility(8);
            }
            getManageTextView().setTag(sparseArray4);
            getDeleteTextView().setTag(sparseArray4);
            getManageTextView().setText(R.string.bar_manager);
            getManageTextView().setVisibility(0);
        } else if (booleanValue4) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
            getManageTextView().setTag(sparseArray5);
            getDeleteTextView().setTag(sparseArray5);
            getManageTextView().setText(R.string.delete);
            getDeleteTextView().setVisibility(0);
            if (i2 == 1002 && !booleanValue5) {
                getDeleteTextView().setText(R.string.report_text);
            } else {
                getDeleteTextView().setText(R.string.delete);
            }
            getManageTextView().setVisibility(8);
        } else {
            getManageTextView().setVisibility(8);
            getDeleteTextView().setVisibility(8);
        }
        boolean booleanValue7 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue8 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        if (!c.a.r0.u2.k.f.h1.a.i(tVar) && !booleanValue8 && booleanValue7) {
            SparseArray sparseArray6 = new SparseArray();
            sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
            sparseArray6.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray6.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray6.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray6.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            getReportTextView().setTag(sparseArray6);
            getReportTextView().setVisibility(0);
            getManageTextView().setVisibility(8);
            getReportTextView().setText(R.string.mute_option);
        } else {
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z) {
                getReportTextView().setVisibility(0);
                getReportTextView().setTag(str2);
            } else {
                getReportTextView().setVisibility(8);
            }
        }
        boolean booleanValue9 = sparseArray.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_hide_chudian_visible)).booleanValue() : false;
        long longValue = sparseArray.get(R.id.tag_chudian_template_id) instanceof Long ? ((Long) sparseArray.get(R.id.tag_chudian_template_id)).longValue() : 0L;
        String str3 = sparseArray.get(R.id.tag_chudian_monitor_id) instanceof String ? (String) sparseArray.get(R.id.tag_chudian_monitor_id) : "";
        int intValue = sparseArray.get(R.id.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_chudian_hide_day)).intValue() : 0;
        if (booleanValue9) {
            getNewChudianHide().setVisibility(0);
            getNewChudianHide().setTag(R.id.tag_chudian_template_id, Long.valueOf(longValue));
            getNewChudianHide().setTag(R.id.tag_chudian_monitor_id, str3);
            getNewChudianHide().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
        } else {
            getNewChudianHide().setVisibility(8);
        }
        if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
            z3 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
            if (this.z.getPageActivity() instanceof NewSubPbActivity) {
                NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.z.getPageActivity();
                if (z3 && newSubPbActivity.getSubPbModel() != null && newSubPbActivity.getSubPbModel().j0() != null && newSubPbActivity.getSubPbModel().j0().l() != null && !newSubPbActivity.getSubPbModel().j0().l().U1()) {
                    z3 = true;
                }
            }
            booleanValue = !(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean) ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
            if (!z3) {
                i3 = 0;
                getEmotionTextView().setVisibility(0);
                i4 = 8;
            } else {
                i3 = 0;
                i4 = 8;
                getEmotionTextView().setVisibility(8);
            }
            if (!booleanValue) {
                getSaveLocalTextView().setVisibility(i3);
            } else {
                getSaveLocalTextView().setVisibility(i4);
            }
            if (z3 && !booleanValue) {
                getCopyTextView().setVisibility(i3);
            } else {
                getCopyTextView().setVisibility(i4);
            }
            getDisagreeTextView().setVisibility(i4);
            if (z2) {
                getDeleteTextView().setVisibility(i4);
                getManageTextView().setVisibility(i4);
                getReportTextView().setVisibility(i4);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                if (postData != null) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_load_sub_data, postData);
                    getReplyTextView().setTag(sparseArray7);
                    getReplyTextView().setText(R.string.action_reply);
                    getReplyTextView().setVisibility(0);
                }
                if (postData != null) {
                    SparseArray sparseArray8 = new SparseArray();
                    sparseArray8.put(R.id.tag_load_sub_data, postData);
                    sparseArray8.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.k0));
                    getShareTextView().setTag(sparseArray8);
                    getShareTextView().setText(R.string.action_share);
                    getReplyTextView().setVisibility(0);
                }
                if (postData.q() != null) {
                    boolean z4 = postData.q().hasAgree;
                    int s = postData.s();
                    if (z4 && s == 5) {
                        string = this.z.getString(R.string.action_cancel_dislike);
                    } else {
                        string = this.z.getString(R.string.action_dislike);
                    }
                    SparseArray sparseArray9 = new SparseArray();
                    sparseArray9.put(R.id.tag_clip_board, postData);
                    getDisagreeTextView().setTag(sparseArray9);
                    getDisagreeTextView().setVisibility(0);
                    getDisagreeTextView().setText(string);
                }
            }
            c.a.r0.u2.k.f.h1.a.l(this.w, postData, tVar);
        }
        z3 = false;
        if (!(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean)) {
        }
        if (!z3) {
        }
        if (!booleanValue) {
        }
        if (z3) {
        }
        getCopyTextView().setVisibility(i4);
        getDisagreeTextView().setVisibility(i4);
        if (z2) {
        }
        if (UbsABTestHelper.isPBPlanA()) {
        }
        c.a.r0.u2.k.f.h1.a.l(this.w, postData, tVar);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a aVar = new a(this);
            if (UbsABTestHelper.isPBPlanA()) {
                setDefaultContentView(null, new String[]{this.z.getString(R.string.action_reply), this.z.getString(R.string.action_share), this.z.getString(R.string.action_dislike), this.z.getString(R.string.no_interesting), this.z.getString(R.string.save_to_emotion), this.z.getString(R.string.save_to_local), this.z.getString(R.string.copy), this.z.getString(R.string.mark), this.z.getString(R.string.report_text), this.z.getString(R.string.delete), this.z.getString(R.string.mute), this.z.getString(R.string.block_user)}, aVar);
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
            setDefaultContentView(null, new String[]{this.z.getString(R.string.action_dislike), this.z.getString(R.string.no_interesting), this.z.getString(R.string.save_to_emotion), this.z.getString(R.string.save_to_local), this.z.getString(R.string.copy), this.z.getString(R.string.mark), this.z.getString(R.string.report_text), this.z.getString(R.string.delete), this.z.getString(R.string.mute), this.z.getString(R.string.block_user)}, aVar);
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
            if (view != null && (view instanceof ViewGroup) && (findViewById = view.findViewById(R.id.content_view)) != null && (findViewById instanceof ViewGroup)) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) ? (TextView) view.findViewById(R.id.item_view) : (TextView) invokeL.objValue;
    }
}
