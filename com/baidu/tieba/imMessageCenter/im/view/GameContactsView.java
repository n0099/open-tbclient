package com.baidu.tieba.imMessageCenter.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.q87;
import com.baidu.tieba.y97;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class GameContactsView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, GameContactsItemView> a;
    public a b;
    public boolean c;
    public int d;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view2, q87 q87Var, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750267949, "Lcom/baidu/tieba/imMessageCenter/im/view/GameContactsView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750267949, "Lcom/baidu/tieba/imMessageCenter/im/view/GameContactsView;");
                return;
            }
        }
        e = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        f = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameContactsView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(@NonNull List<q87> list) {
        ImMessageCenterPojo i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                q87 q87Var = list.get(i2);
                GameContactsItemView gameContactsItemView = this.a.get(Integer.valueOf(q87Var.b()));
                if (gameContactsItemView != null) {
                    gameContactsItemView.setGameMatchUser(q87Var);
                    gameContactsItemView.setVisibility(0);
                    if (q87Var.b() != this.d && (i = y97.o().i(q87Var.d(), 2)) != null && i.getUnread_count() > 0) {
                        gameContactsItemView.g(i.getUnread_count());
                    }
                }
            }
            if (!this.c || this.b == null) {
                return;
            }
            this.c = false;
            GameContactsItemView gameContactsItemView2 = this.a.get(1);
            if (gameContactsItemView2 != null) {
                gameContactsItemView2.h();
                gameContactsItemView2.b();
                this.b.a(gameContactsItemView2, gameContactsItemView2.getGameMatchUser(), 1);
            }
        }
    }

    public boolean b(q87 q87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q87Var)) == null) {
            int b = q87Var.b();
            int i = this.d;
            if (b == i) {
                return false;
            }
            GameContactsItemView gameContactsItemView = this.a.get(Integer.valueOf(i));
            if (gameContactsItemView != null) {
                gameContactsItemView.a();
            }
            int b2 = q87Var.b();
            this.d = b2;
            GameContactsItemView gameContactsItemView2 = this.a.get(Integer.valueOf(b2));
            if (gameContactsItemView2 != null) {
                gameContactsItemView2.h();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = 1;
            this.c = true;
            removeAllViews();
            d();
        }
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = 0;
            while (i2 < 3) {
                GameContactsItemView gameContactsItemView = new GameContactsItemView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i2 == 0) {
                    i = e;
                } else {
                    i = f;
                }
                layoutParams.setMargins(0, i, 0, 0);
                gameContactsItemView.setLayoutParams(layoutParams);
                gameContactsItemView.setVisibility(8);
                gameContactsItemView.setOnClickListener(this);
                addView(gameContactsItemView, i2);
                i2++;
                this.a.put(Integer.valueOf(i2), gameContactsItemView);
            }
        }
    }

    public void e(@Nullable ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, imMessageCenterPojo) == null) || imMessageCenterPojo == null) {
            return;
        }
        String gid = imMessageCenterPojo.getGid();
        for (Integer num : this.a.keySet()) {
            GameContactsItemView gameContactsItemView = this.a.get(num);
            if (gameContactsItemView != null && gameContactsItemView.getGameMatchUser() != null && gameContactsItemView.getGameMatchUser().d().equals(gid)) {
                gameContactsItemView.g(imMessageCenterPojo.getUnread_count());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (view2 instanceof GameContactsItemView)) {
            GameContactsItemView gameContactsItemView = (GameContactsItemView) view2;
            GameContactsItemView gameContactsItemView2 = this.a.get(Integer.valueOf(this.d));
            if (gameContactsItemView2 != null) {
                gameContactsItemView2.a();
            }
            gameContactsItemView.h();
            boolean z = this.d != gameContactsItemView.getGameMatchUser().b();
            this.d = gameContactsItemView.getGameMatchUser().b();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(gameContactsItemView, gameContactsItemView.getGameMatchUser(), z ? 2 : 3);
            }
        }
    }

    public void setOnContactsItemViewClick(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.b = aVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameContactsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameContactsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = 1;
        this.a = new HashMap<>();
        d();
    }
}
