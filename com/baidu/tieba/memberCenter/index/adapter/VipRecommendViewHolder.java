package com.baidu.tieba.memberCenter.index.adapter;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import c.a.r0.x1.c.j.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VipRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f54294a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54295b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54296c;

    /* renamed from: d  reason: collision with root package name */
    public View f54297d;

    /* renamed from: e  reason: collision with root package name */
    public View f54298e;

    /* renamed from: f  reason: collision with root package name */
    public String f54299f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VipRecommendViewHolder f54300e;

        public a(VipRecommendViewHolder vipRecommendViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vipRecommendViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54300e = vipRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    i2 = TbadkCoreApplication.getCurrentMemberType() > 1 ? 2 : 3;
                } else {
                    i2 = 1;
                }
                TiebaStatic.log(new StatisticItem("c11215").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2));
                if (StringUtils.isNull(this.f54300e.f54299f)) {
                    return;
                }
                MemberCenterStatic.a(this.f54300e.f54294a.getPageContext(), new String[]{this.f54300e.f54299f});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipRecommendViewHolder(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54294a = baseFragmentActivity;
        this.f54298e = view;
        this.f54295b = (TextView) view.findViewById(R.id.speed_desc);
        this.f54296c = (TextView) this.f54298e.findViewById(R.id.speed_up);
        this.f54297d = this.f54298e.findViewById(R.id.divider_sp_line);
        this.f54296c.setOnClickListener(new a(this));
    }

    public void fillView(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        if (iVar.f28470e) {
            this.f54297d.setVisibility(0);
        } else {
            this.f54297d.setVisibility(8);
        }
        this.f54299f = iVar.h();
        this.f54295b.setText(getSpannableString(iVar));
        if (!StringUtils.isNull(iVar.b())) {
            this.f54296c.setText(iVar.b());
            this.f54296c.setVisibility(0);
        } else {
            this.f54296c.setVisibility(8);
        }
        if (TbadkCoreApplication.isLogin()) {
            SkinManager.setBackgroundResource(this.f54296c, R.drawable.member_center_orange_btn_bg);
        } else {
            SkinManager.setBackgroundResource(this.f54296c, R.drawable.member_center_blue_btn_bg);
        }
        if (iVar.f28470e) {
            this.f54297d.setVisibility(0);
        } else {
            this.f54297d.setVisibility(8);
        }
        c.a.q0.w0.a.a(this.f54294a.getPageContext(), this.f54298e);
    }

    public SpannableString getSpannableString(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar)) == null) {
            if (iVar == null || iVar.d() == null) {
                return null;
            }
            String d2 = iVar.d();
            String str = "" + iVar.c();
            String i2 = iVar.i();
            String str2 = "" + iVar.k();
            String g2 = iVar.g();
            SpannableString spannableString = new SpannableString(d2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            UtilHelper.setSpan(spannableString, d2, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, d2, i2, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, d2, str2, foregroundColorSpan3);
            UtilHelper.setSpan(spannableString, d2, g2, foregroundColorSpan4);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }
}
