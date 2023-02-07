package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class uf8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View.OnClickListener b;
    public int c;
    public boolean d;
    public boolean e;
    public ThreadData f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public View.OnLongClickListener k;
    public View.OnClickListener l;

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090855);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090602);
            this.c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != this.a) {
                    SkinManager.setBackgroundColor(this.b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
                    this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public LinearLayout c;
        public TextView d;
        public TbRichTextView e;
        public View f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public uf8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.e = true;
        this.g = false;
        this.h = false;
        this.i = "";
        this.j = -1;
        this.k = null;
        this.l = null;
        this.a = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d067a, (ViewGroup) null);
            inflate.setTag(new a(inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d067b, (ViewGroup) null);
            bVar.b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a2);
            bVar.c = linearLayout;
            if (this.g) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                layoutParams.bottomMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams);
            }
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09157d);
            bVar.e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09178c);
            bVar.f = inflate.findViewById(R.id.obfuscated_res_0x7f09083a);
            bVar.e.getLayoutStrategy().v();
            if (!this.g) {
                bVar.e.getLayoutStrategy().p(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                bVar.e.getLayoutStrategy().k(0);
                bVar.e.getLayoutStrategy().m(ej.g(this.a, R.dimen.tbds20));
                bVar.e.getLayoutStrategy().n(ej.g(this.a, R.dimen.tbds14));
                bVar.e.setMaxLines(4);
                bVar.e.setTextEllipsize(TextUtils.TruncateAt.END);
                bVar.e.setAddTruncateListener(true);
                bVar.e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                bVar.e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            bVar.e.setSubPbPost(true);
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            bVar.e.setIsNeedResizeEmotion(true);
            bVar.e.setTextCenter(true);
            bVar.e.setOnClickListener(this.l);
            bVar.d.setOnClickListener(this.b);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_holder, bVar);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(b bVar, PostData postData, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && bVar != null && postData != null) {
            boolean z7 = true;
            boolean z8 = false;
            if (!postData.a0) {
                Context context = this.a;
                if (context instanceof gb8) {
                    gb8 gb8Var = (gb8) context;
                    TbPageContext pageContext = gb8Var.getPageContext();
                    if (postData.r() != null && gb8Var.E(postData.r().getUserId())) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    postData.l1(pageContext, z6);
                }
            }
            if (z2) {
                SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
            } else {
                bVar.b.setBackgroundResource(0);
            }
            if (postData.x0()) {
                bVar.f.setVisibility(0);
            } else {
                bVar.f.setVisibility(8);
            }
            bVar.e.setPadding(0, 0, 0, 0);
            if (postData.r() != null) {
                String name_show = postData.r().getName_show();
                String userId = postData.r().getUserId();
                String portrait = postData.r().getPortrait();
                SparseArray sparseArray2 = (SparseArray) bVar.b.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.b.setTag(sparseArray2);
                    bVar.e.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_photo_portrait, portrait);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
            }
            bVar.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            d(postData, this.g);
            TbRichText Z = postData.Z();
            if (Z != null) {
                bVar.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d092c);
                bVar.e.setIsFromCDN(this.e);
                if (bVar.a != TbadkCoreApplication.getInst().getSkinType()) {
                    Z.isChanged = true;
                }
                bVar.e.setText(Z);
            }
            String userId2 = postData.r().getUserId();
            int i = this.c;
            if (i != 0) {
                if (i != 1002 && i != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c != 3 && !this.f.isBjh()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            } else {
                z3 = false;
                z4 = false;
            }
            if (this.d) {
                if (!this.f.isBjh()) {
                    z4 = true;
                }
                if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = true;
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    } else {
                        z7 = z4;
                    }
                    bVar.d.setVisibility(8);
                    sparseArray = (SparseArray) bVar.b.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.b.setTag(sparseArray);
                        bVar.e.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.i);
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.c));
                        if (postData.r() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.r().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.r().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.r().getPortrait());
                        }
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.O());
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.O());
                    sparseArray.put(R.id.tag_clip_board, postData);
                    if (!z5) {
                        if (this.f != null) {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.r() != null) {
                                sparseArray.put(R.id.tag_user_mute_mute_userid, postData.r().getUserId());
                                sparseArray.put(R.id.tag_user_mute_mute_username, postData.r().getUserName());
                                sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.r().getName_show());
                            }
                            if (this.f.getId() != null) {
                                sparseArray.put(R.id.tag_user_mute_thread_id, this.f.getId());
                            }
                            sparseArray.put(R.id.tag_user_mute_post_id, postData.O());
                        }
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z7) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.c));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                        sparseArray.put(R.id.tag_del_post_type, 2);
                        sparseArray.put(R.id.tag_del_post_id, postData.O());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.t0()));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    if (this.g && z && this.h) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams.topMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                        layoutParams.bottomMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        bVar.c.setLayoutParams(layoutParams);
                    }
                    if (this.g && !z) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams2.topMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        layoutParams2.bottomMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        bVar.c.setLayoutParams(layoutParams2);
                    }
                    bVar.d.setTag(sparseArray);
                    bVar.e.setTag(sparseArray);
                    bVar.a = TbadkCoreApplication.getInst().getSkinType();
                    bVar.e.setOnLongClickListener(this.k);
                    if (postData == null && postData.r() != null && postData.p() != null) {
                        xf8.b("1", String.valueOf(postData.p().threadId), TbadkCoreApplication.getCurrentAccount(), postData.O(), postData.K(), postData.L());
                        return;
                    }
                    return;
                }
            }
            z5 = false;
            if (userId2 == null) {
            }
            z7 = z4;
            bVar.d.setVisibility(8);
            sparseArray = (SparseArray) bVar.b.getTag();
            if (sparseArray == null) {
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.i);
            if (!z3) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.O());
            sparseArray.put(R.id.tag_clip_board, postData);
            if (!z5) {
            }
            if (!z7) {
            }
            if (this.g) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams3.topMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                layoutParams3.bottomMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams3);
            }
            if (this.g) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams22.topMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                layoutParams22.bottomMargin = ej.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams22);
            }
            bVar.d.setTag(sparseArray);
            bVar.e.setTag(sparseArray);
            bVar.a = TbadkCoreApplication.getInst().getSkinType();
            bVar.e.setOnLongClickListener(this.k);
            if (postData == null) {
            }
        }
    }

    public final void d(PostData postData, boolean z) {
        TbRichText Z;
        SpannableStringBuilder S;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, postData, z) != null) || postData == null || (Z = postData.Z()) == null) {
            return;
        }
        ArrayList<TbRichTextData> I = Z.I();
        if (ListUtils.isEmpty(I)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = I.get(I.size() - 1);
            int i2 = -1;
            if (tbRichTextData != null) {
                i = tbRichTextData.getType();
            } else {
                i = -1;
            }
            if (i == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.k0());
                if (I.size() > 1) {
                    if (I.get(I.size() - 2) != null) {
                        i2 = I.get(I.size() - 2).getType();
                    }
                    if (i2 != i) {
                        str2 = StringHelper.getFormatTime(postData.k0());
                    }
                }
                SpannableStringBuilder S2 = tbRichTextData.S();
                if (Z.hasAppendTime && S2 != 0 && Z.appendLength <= S2.length()) {
                    S2.delete(S2.length() - Z.appendLength, S2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (S2 != null) {
                    S2.append((CharSequence) str);
                }
                Z.hasAppendTime = true;
                Z.appendLength = str.length();
            } else if (!Z.hasAppendTime) {
                String formatTime = StringHelper.getFormatTime(postData.k0());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.H(forceLToR);
                Z.hasAppendTime = true;
                Z.appendLength = forceLToR.length();
                I.add(tbRichTextData);
                str = forceLToR;
            } else {
                str = "";
            }
            SpannableStringBuilder S3 = tbRichTextData.S();
            if (S3 != null && str.length() <= S3.length()) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
                S3.setSpan(absoluteSizeSpan, S3.length() - str.length(), S3.length(), 33);
                S3.setSpan(foregroundColorSpan, S3.length() - str.length(), S3.length(), 33);
                return;
            }
            return;
        }
        TbRichTextData tbRichTextData2 = I.get(I.size() - 1);
        if (Z.hasAppendTime && tbRichTextData2 != null && (S = tbRichTextData2.S()) != null && Z.appendLength <= S.length()) {
            S.delete(S.length() - Z.appendLength, S.length());
        }
        Z.hasAppendTime = false;
        Z.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.e = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.f = threadData;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        PostData postData;
        b bVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (getItem(i) instanceof PostData) {
                postData = (PostData) getItem(i);
            } else {
                postData = null;
            }
            if (view2 == null) {
                if (postData.getType() == PostData.W0) {
                    view2 = a();
                } else {
                    view2 = b();
                }
            }
            if ((view2.getTag() instanceof a) && postData.getType() != PostData.W0) {
                view2 = b();
            }
            if ((view2.getTag() instanceof SparseArray) && postData.getType() == PostData.W0) {
                view2 = a();
            }
            if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(R.id.tag_holder)) != null && postData != null) {
                boolean z2 = true;
                if (i == this.j) {
                    z = true;
                } else {
                    z = false;
                }
                if (i != 0) {
                    z2 = false;
                }
                c(bVar, postData, z2, z);
                if (z) {
                    this.j = -1;
                }
            }
            if (view2.getTag() instanceof a) {
                ((a) view2.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void j(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.c = i;
            this.d = z;
        }
    }
}
