package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.e.a.f;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import c.a.q0.s.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MY_ATTENTION_PERSON = 1;
    public static final int MY_FANS = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public f f54543h;

    /* renamed from: i  reason: collision with root package name */
    public PopupDialog f54544i;

    /* renamed from: j  reason: collision with root package name */
    public String f54545j;
    public int k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f54546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MyFansUserLikeButton f54547f;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1776a implements i.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f54548a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f54549b;

            public C1776a(a aVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54549b = aVar;
                this.f54548a = view;
            }

            @Override // c.a.q0.s.s.i.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f54549b.f54546e) == null) {
                    return;
                }
                onClickListener.onClick(this.f54548a);
                if (this.f54549b.f54547f.k != 1) {
                    if (this.f54549b.f54547f.k == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f54549b.f54547f.f54545j));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f54549b.f54547f.f54545j));
                }
                g.b(this.f54549b.f54547f.f54544i, this.f54549b.f54547f.f54543h);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements i.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f54550a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54550a = aVar;
            }

            @Override // c.a.q0.s.s.i.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54550a.f54547f.f54544i == null) {
                    return;
                }
                g.b(this.f54550a.f54547f.f54544i, this.f54550a.f54547f.f54543h);
            }
        }

        public a(MyFansUserLikeButton myFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54547f = myFansUserLikeButton;
            this.f54546e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54547f.k != 1) {
                    if (this.f54547f.k == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f54547f.mCurrentIsLike ? 3 : 2).param("obj_param1", this.f54547f.f54545j));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f54547f.mCurrentIsLike ? "3" : "2").param("obj_param1", this.f54547f.f54545j));
                }
                if (this.f54547f.mCurrentIsLike) {
                    if (this.f54547f.f54543h != null) {
                        if (this.f54547f.f54544i == null) {
                            i iVar = new i(this.f54547f.f54543h.getContext());
                            iVar.q(this.f54547f.f54543h.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f54547f.f54543h.getString(R.string.confirm), iVar);
                            fVar.l(new C1776a(this, view));
                            arrayList.add(fVar);
                            iVar.m(new b(this));
                            iVar.k(arrayList);
                            this.f54547f.f54544i = new PopupDialog(this.f54547f.f54543h, iVar);
                            this.f54547f.f54544i.setWindowDimAmount(0.7f);
                        }
                        g.j(this.f54547f.f54544i, this.f54547f.f54543h);
                        return;
                    }
                    return;
                }
                this.f54546e.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context) {
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
        this.k = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.q0.s.f0.t.b
    public void bindOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.mCurrentIsLike) {
                SkinManager.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
                SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
                return;
            }
            SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public void setContext(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f54543h = fVar;
        }
    }

    public void setStatsParams(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            this.k = i2;
            this.f54545j = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void updateLikeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.q0.s.f0.t.b
    public void updateLikeStatus(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.mCurrentIsLike = z;
            if (!z) {
                setTextSize(0, l.g(getContext(), R.dimen.ds26));
                setText(this.mStrFollow);
            } else if (i2 == 1) {
                setTextSize(0, l.g(getContext(), R.dimen.ds26));
                setText(this.mStrAlreadyFollowed);
            } else if (i2 != 2) {
                setTextSize(0, l.g(getContext(), R.dimen.ds26));
                setText(this.mStrAlreadyFollowed);
            } else {
                setTextSize(0, l.g(getContext(), R.dimen.ds24));
                setText(R.string.each_concerned);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
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
        this.k = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = 1;
    }
}
