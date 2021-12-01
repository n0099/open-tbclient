package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.m.b;
import c.a.q0.w0.a;
import c.a.r0.e2.c.k.f;
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
/* loaded from: classes10.dex */
public class CooperatePrivilegeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f46953b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f46954c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46955d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46956e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f46957f;
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
        this.a = view;
        this.f46953b = baseFragmentActivity;
        this.f46954c = (TbImageView) view.findViewById(R.id.privilege_icon);
        this.f46955d = (TextView) this.a.findViewById(R.id.privilege_name);
        this.f46956e = (TextView) this.a.findViewById(R.id.privilege_desc);
        this.f46957f = (TbImageView) this.a.findViewById(R.id.privilege_spread_icon);
        this.mNewIcon = (TbImageView) this.a.findViewById(R.id.privilege_new_icon);
        this.mRedDotIcon = (ImageView) this.a.findViewById(R.id.privilege_red_dot);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a(this.f46953b.getPageContext(), this.a);
            this.mNewIcon.setImageResource(R.drawable.icon_new_privilege);
        }
    }

    public void renderView(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f46954c.setIsRound(false);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f46954c.setDefaultBgResource(R.color.img_bg_color);
        } else {
            this.f46954c.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        }
        this.f46954c.startLoad(fVar.c(), 10, false);
        this.f46955d.setText(fVar.g());
        if (!TbadkCoreApplication.isLogin()) {
            this.f46957f.setVisibility(4);
        } else {
            this.f46957f.setVisibility(0);
            this.f46956e.setText(fVar.a());
        }
        if (StringUtils.isNull(fVar.e())) {
            this.f46957f.setVisibility(4);
        } else {
            this.f46957f.setVisibility(0);
        }
        this.mNewIcon.setAutoChangeStyle(false);
        if (TbadkCoreApplication.isLogin() && fVar.d() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b.g(fVar.h(), 0L) > b.g(c.a.q0.s.e0.b.j().p("member_center_item_red_tip_" + fVar.d() + currentAccount, "0"), 0L)) {
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
