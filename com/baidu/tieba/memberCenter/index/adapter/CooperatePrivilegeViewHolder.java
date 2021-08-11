package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.m.b;
import c.a.o0.u0.a;
import c.a.p0.w1.c.k.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CooperatePrivilegeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f53982a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f53983b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f53984c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53985d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53986e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f53987f;
    public TbImageView mNewIcon;
    public ImageView mRedDotIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CooperatePrivilegeViewHolder(View view, BaseFragmentActivity baseFragmentActivity) {
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
        this.f53982a = view;
        this.f53983b = baseFragmentActivity;
        this.f53984c = (TbImageView) view.findViewById(R.id.privilege_icon);
        this.f53985d = (TextView) this.f53982a.findViewById(R.id.privilege_name);
        this.f53986e = (TextView) this.f53982a.findViewById(R.id.privilege_desc);
        this.f53987f = (TbImageView) this.f53982a.findViewById(R.id.privilege_spread_icon);
        this.mNewIcon = (TbImageView) this.f53982a.findViewById(R.id.privilege_new_icon);
        this.mRedDotIcon = (ImageView) this.f53982a.findViewById(R.id.privilege_red_dot);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a(this.f53983b.getPageContext(), this.f53982a);
            this.mNewIcon.setImageResource(R.drawable.icon_new_privilege);
        }
    }

    public void renderView(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f53984c.setIsRound(false);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f53984c.setDefaultBgResource(R.color.img_bg_color);
        } else {
            this.f53984c.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        }
        this.f53984c.startLoad(fVar.c(), 10, false);
        this.f53985d.setText(fVar.g());
        if (!TbadkCoreApplication.isLogin()) {
            this.f53987f.setVisibility(4);
        } else {
            this.f53987f.setVisibility(0);
            this.f53986e.setText(fVar.a());
        }
        if (StringUtils.isNull(fVar.e())) {
            this.f53987f.setVisibility(4);
        } else {
            this.f53987f.setVisibility(0);
        }
        this.mNewIcon.setAutoChangeStyle(false);
        if (TbadkCoreApplication.isLogin() && fVar.d() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b.f(fVar.h(), 0L) > b.f(c.a.o0.s.d0.b.j().p("member_center_item_red_tip_" + fVar.d() + currentAccount, "0"), 0L)) {
                if (fVar.i() == 1) {
                    this.mNewIcon.setVisibility(8);
                    this.mRedDotIcon.setVisibility(0);
                } else {
                    this.mNewIcon.setVisibility(0);
                    this.mRedDotIcon.setVisibility(8);
                }
            } else {
                this.mNewIcon.setVisibility(8);
                this.mRedDotIcon.setVisibility(8);
            }
        } else {
            this.mNewIcon.setVisibility(8);
            this.mRedDotIcon.setVisibility(8);
        }
        onChangeSkinType();
    }
}
