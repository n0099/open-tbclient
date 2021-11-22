package com.baidu.tieba.memberCenter.index.adapter;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import b.a.r0.y1.c.j.i;
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
/* loaded from: classes9.dex */
public class VipRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f52444a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52445b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52446c;

    /* renamed from: d  reason: collision with root package name */
    public View f52447d;

    /* renamed from: e  reason: collision with root package name */
    public View f52448e;

    /* renamed from: f  reason: collision with root package name */
    public String f52449f;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VipRecommendViewHolder f52450e;

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
            this.f52450e = vipRecommendViewHolder;
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
                if (StringUtils.isNull(this.f52450e.f52449f)) {
                    return;
                }
                MemberCenterStatic.a(this.f52450e.f52444a.getPageContext(), new String[]{this.f52450e.f52449f});
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
        this.f52444a = baseFragmentActivity;
        this.f52448e = view;
        this.f52445b = (TextView) view.findViewById(R.id.speed_desc);
        this.f52446c = (TextView) this.f52448e.findViewById(R.id.speed_up);
        this.f52447d = this.f52448e.findViewById(R.id.divider_sp_line);
        this.f52446c.setOnClickListener(new a(this));
    }

    public void fillView(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        if (iVar.f28897e) {
            this.f52447d.setVisibility(0);
        } else {
            this.f52447d.setVisibility(8);
        }
        this.f52449f = iVar.h();
        this.f52445b.setText(getSpannableString(iVar));
        if (!StringUtils.isNull(iVar.a())) {
            this.f52446c.setText(iVar.a());
            this.f52446c.setVisibility(0);
        } else {
            this.f52446c.setVisibility(8);
        }
        if (TbadkCoreApplication.isLogin()) {
            SkinManager.setBackgroundResource(this.f52446c, R.drawable.member_center_orange_btn_bg);
        } else {
            SkinManager.setBackgroundResource(this.f52446c, R.drawable.member_center_blue_btn_bg);
        }
        if (iVar.f28897e) {
            this.f52447d.setVisibility(0);
        } else {
            this.f52447d.setVisibility(8);
        }
        b.a.q0.v0.a.a(this.f52444a.getPageContext(), this.f52448e);
    }

    public SpannableString getSpannableString(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar)) == null) {
            if (iVar == null || iVar.e() == null) {
                return null;
            }
            String e2 = iVar.e();
            String str = "" + iVar.d();
            String i2 = iVar.i();
            String str2 = "" + iVar.k();
            String g2 = iVar.g();
            SpannableString spannableString = new SpannableString(e2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            UtilHelper.setSpan(spannableString, e2, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, e2, i2, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, e2, str2, foregroundColorSpan3);
            UtilHelper.setSpan(spannableString, e2, g2, foregroundColorSpan4);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }
}
