package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.d.a.f;
import c.a.d.f.m.g;
import c.a.s0.s.s.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class NewMyFansUserLikeButton extends FollowUserButton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MY_ATTENTION_PERSON = 1;
    public static final int MY_FANS = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String mStrAlreadyFollowed;
    public String mStrFollow;
    public f u;
    public PopupDialog v;
    public String w;
    public int x;
    public boolean y;
    public b z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f47799e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewMyFansUserLikeButton f47800f;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1915a implements j.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f47801b;

            public C1915a(a aVar, View view) {
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
                this.f47801b = aVar;
                this.a = view;
            }

            @Override // c.a.s0.s.s.j.d
            public void onClick() {
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onClickListener = this.f47801b.f47799e) == null) {
                    return;
                }
                onClickListener.onClick(this.a);
                if (this.f47801b.f47800f.x != 1) {
                    if (this.f47801b.f47800f.x == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", this.f47801b.f47800f.w));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", this.f47801b.f47800f.w));
                }
                g.b(this.f47801b.f47800f.v, this.f47801b.f47800f.u);
            }
        }

        /* loaded from: classes12.dex */
        public class b implements j.c {
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

            @Override // c.a.s0.s.s.j.c
            public void onClick() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f47800f.v == null) {
                    return;
                }
                g.b(this.a.f47800f.v, this.a.f47800f.u);
            }
        }

        public a(NewMyFansUserLikeButton newMyFansUserLikeButton, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newMyFansUserLikeButton, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47800f = newMyFansUserLikeButton;
            this.f47799e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47800f.x != 1) {
                    if (this.f47800f.x == 2) {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", this.f47800f.y ? 3 : 2).param("obj_param1", this.f47800f.w));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", this.f47800f.y ? "3" : "2").param("obj_param1", this.f47800f.w));
                }
                if (this.f47800f.y) {
                    if (this.f47800f.u != null) {
                        if (this.f47800f.v == null) {
                            j jVar = new j(this.f47800f.u.getContext());
                            jVar.p(this.f47800f.u.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(this.f47800f.u.getString(R.string.confirm), jVar);
                            gVar.l(new C1915a(this, view));
                            arrayList.add(gVar);
                            jVar.l(new b(this));
                            jVar.j(arrayList);
                            this.f47800f.v = new PopupDialog(this.f47800f.u, jVar);
                            this.f47800f.v.setWindowDimAmount(0.7f);
                        }
                        g.j(this.f47800f.v, this.f47800f.u);
                    }
                } else {
                    this.f47799e.onClick(view);
                }
                if (this.f47800f.z != null) {
                    this.f47800f.z.callback();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void callback();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.x = 1;
        this.y = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, c.a.s0.s.i0.t.b
    public void bindOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            setOnClickListener(new a(this, onClickListener));
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.z = bVar;
        }
    }

    public void setContext(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setStatsParams(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            this.x = i2;
            this.w = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, c.a.s0.s.i0.t.b
    public void updateLikeStatus(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            super.updateLikeStatus(z, i2);
            this.y = z;
            if (!z) {
                setText(this.mStrFollow);
            } else if (i2 == 1) {
                setText(this.mStrAlreadyFollowed);
            } else if (i2 != 2) {
                setText(this.mStrAlreadyFollowed);
            } else {
                setText(this.u.getString(R.string.each_concerned));
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.x = 1;
        this.y = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mStrAlreadyFollowed = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.mStrFollow = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.x = 1;
        this.y = false;
    }
}
