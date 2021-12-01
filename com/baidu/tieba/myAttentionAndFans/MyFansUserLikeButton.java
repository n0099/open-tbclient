package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.d.a.f;
import c.a.d.f.m.g;
import c.a.d.f.p.l;
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
/* loaded from: classes10.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MY_ATTENTION_PERSON = 1;
    public static final int MY_FANS = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public f f47070h;

    /* renamed from: i  reason: collision with root package name */
    public PopupDialog f47071i;

    /* renamed from: j  reason: collision with root package name */
    public String f47072j;

    /* renamed from: k  reason: collision with root package name */
    public int f47073k;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f47074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MyFansUserLikeButton f47075f;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C1848a implements i.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f47076b;

            public C1848a(a aVar, View view) {
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
                this.f47076b = aVar;
                this.a = view;
            }

            @Override // c.a.q0.s.s.i.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f47076b.f47074e) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.f47076b.f47075f.f47073k != 1) {
                    if (this.f47076b.f47075f.f47073k == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f47076b.f47075f.f47072j));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f47076b.f47075f.f47072j));
                }
                g.b(this.f47076b.f47075f.f47071i, this.f47076b.f47075f.f47070h);
            }
        }

        /* loaded from: classes10.dex */
        public class b implements i.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = aVar;
            }

            @Override // c.a.q0.s.s.i.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f47075f.f47071i == null) {
                    return;
                }
                g.b(this.a.f47075f.f47071i, this.a.f47075f.f47070h);
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
            this.f47075f = myFansUserLikeButton;
            this.f47074e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47075f.f47073k != 1) {
                    if (this.f47075f.f47073k == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f47075f.mCurrentIsLike ? 3 : 2).param("obj_param1", this.f47075f.f47072j));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f47075f.mCurrentIsLike ? "3" : "2").param("obj_param1", this.f47075f.f47072j));
                }
                if (this.f47075f.mCurrentIsLike) {
                    if (this.f47075f.f47070h != null) {
                        if (this.f47075f.f47071i == null) {
                            i iVar = new i(this.f47075f.f47070h.getContext());
                            iVar.p(this.f47075f.f47070h.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f47075f.f47070h.getString(R.string.confirm), iVar);
                            fVar.l(new C1848a(this, view));
                            arrayList.add(fVar);
                            iVar.l(new b(this));
                            iVar.j(arrayList);
                            this.f47075f.f47071i = new PopupDialog(this.f47075f.f47070h, iVar);
                            this.f47075f.f47071i.setWindowDimAmount(0.7f);
                        }
                        g.j(this.f47075f.f47071i, this.f47075f.f47070h);
                        return;
                    }
                    return;
                }
                this.f47074e.onClick(view);
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
        this.f47073k = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.q0.s.g0.t.b
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
            this.f47070h = fVar;
        }
    }

    public void setStatsParams(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            this.f47073k = i2;
            this.f47072j = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void updateLikeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, c.a.q0.s.g0.t.b
    public void updateLikeStatus(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.mCurrentIsLike = z;
            if (!z) {
                setTextSize(0, l.f(getContext(), R.dimen.ds26));
                setText(this.mStrFollow);
            } else if (i2 == 1) {
                setTextSize(0, l.f(getContext(), R.dimen.ds26));
                setText(this.mStrAlreadyFollowed);
            } else if (i2 != 2) {
                setTextSize(0, l.f(getContext(), R.dimen.ds26));
                setText(this.mStrAlreadyFollowed);
            } else {
                setTextSize(0, l.f(getContext(), R.dimen.ds24));
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
        this.f47073k = 1;
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
        this.f47073k = 1;
    }
}
