package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.r0.p3.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MemberRecommendView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_ALL_THEME_LIST = 3;
    public static final int FROM_AVATAR_PENDANT_LSIT = 8;
    public static final int FROM_BACKGROUND_GROUP = 4;
    public static final int FROM_BACKGROUND_LIST = 5;
    public static final int FROM_BUBBLE_ALL_LIST = 7;
    public static final int FROM_BUBBLE_GROUP = 6;
    public static final int FROM_CARD_LSIT = 9;
    public static final int FROM_DRESSUP_CENTER = 1;
    public static final int FROM_TOP_THEME_LIST = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57497e;

    /* renamed from: f  reason: collision with root package name */
    public View f57498f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57499g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57500h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57501i;

    /* renamed from: j  reason: collision with root package name */
    public e f57502j;
    public int k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberRecommendView f57503e;

        public a(MemberRecommendView memberRecommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberRecommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57503e = memberRecommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = 9;
                switch (this.f57503e.k) {
                    case 1:
                        TiebaStatic.log("c10261");
                        i2 = 8;
                        str = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                        break;
                    case 2:
                    case 3:
                    case 9:
                        TiebaStatic.log("c10266");
                        if (this.f57503e.k == 9) {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_CARDS;
                            break;
                        }
                        str = "";
                        break;
                    case 4:
                    case 5:
                        TiebaStatic.log("c10278");
                        i2 = 12;
                        if (this.f57503e.k != 4) {
                            str = MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                            break;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND;
                            break;
                        }
                    case 6:
                    case 7:
                        TiebaStatic.log("c10762");
                        i2 = 19;
                        if (this.f57503e.k != 7) {
                            str = MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                            break;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_ALL_BUBBLE;
                            break;
                        }
                    case 8:
                        i2 = 22;
                        TiebaStatic.log("c11613");
                        str = MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT;
                        break;
                    default:
                        i2 = 0;
                        str = "";
                        break;
                }
                if (this.f57503e.f57502j == null || (tbPageContext = (TbPageContext) j.a(this.f57503e.f57497e)) == null) {
                    return;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i2);
                memberPayActivityConfig.setReferPageClickZone(str, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57497e = context;
        d();
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f57498f, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.f57500h, R.color.CAM_X0108);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f57497e).inflate(R.layout.member_extend_view, this);
            this.f57498f = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.vip_icon);
            this.f57499g = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_vip_orange);
            this.f57499g.setDefaultBgResource(R.drawable.transparent_bg);
            this.f57499g.setAutoChangeStyle(true);
            this.f57500h = (TextView) this.f57498f.findViewById(R.id.title_view);
            TextView textView = (TextView) this.f57498f.findViewById(R.id.jump_button);
            this.f57501i = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public void fillView(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f57502j = eVar;
        this.f57499g.startLoad(eVar.b(), 10, false);
        this.f57500h.setText(this.f57502j.c());
        if (StringUtils.isNull(this.f57502j.a())) {
            this.f57501i.setVisibility(8);
            return;
        }
        this.f57501i.setVisibility(0);
        this.f57501i.setText(this.f57502j.a());
    }

    public View getButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57501i : (View) invokeV.objValue;
    }

    public int getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public void setFromType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57497e = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57497e = context;
        d();
    }
}
