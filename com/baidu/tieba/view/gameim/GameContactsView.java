package com.baidu.tieba.view.gameim;

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
import com.baidu.tieba.pk7;
import com.baidu.tieba.xl7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class GameContactsView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, GameContactsItemView> a;
    public a b;
    public boolean c;
    public int d;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, pk7 pk7Var, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(847107732, "Lcom/baidu/tieba/view/gameim/GameContactsView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(847107732, "Lcom/baidu/tieba/view/gameim/GameContactsView;");
                return;
            }
        }
        e = ej.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        f = ej.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
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

    public boolean b(pk7 pk7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk7Var)) == null) {
            int b = pk7Var.b();
            int i = this.d;
            if (b == i) {
                return false;
            }
            GameContactsItemView gameContactsItemView = this.a.get(Integer.valueOf(i));
            if (gameContactsItemView != null) {
                gameContactsItemView.a();
            }
            int b2 = pk7Var.b();
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

    public void a(@NonNull List<pk7> list) {
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i = 0; i < list.size(); i++) {
                pk7 pk7Var = list.get(i);
                GameContactsItemView gameContactsItemView = this.a.get(Integer.valueOf(pk7Var.b()));
                if (gameContactsItemView != null) {
                    gameContactsItemView.setGameMatchUser(pk7Var);
                    gameContactsItemView.setVisibility(0);
                    if (pk7Var.b() != this.d && (h = xl7.n().h(pk7Var.d(), 2)) != null && h.getUnread_count() > 0) {
                        gameContactsItemView.g(h.getUnread_count());
                    }
                }
            }
            if (this.c && this.b != null) {
                this.c = false;
                GameContactsItemView gameContactsItemView2 = this.a.get(1);
                if (gameContactsItemView2 != null) {
                    gameContactsItemView2.h();
                    gameContactsItemView2.b();
                    this.b.a(gameContactsItemView2, gameContactsItemView2.getGameMatchUser(), 1);
                }
            }
        }
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
        if ((interceptable == null || interceptable.invokeL(1048580, this, imMessageCenterPojo) == null) && imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            for (Integer num : this.a.keySet()) {
                GameContactsItemView gameContactsItemView = this.a.get(num);
                if (gameContactsItemView != null && gameContactsItemView.getGameMatchUser() != null && gameContactsItemView.getGameMatchUser().d().equals(gid)) {
                    gameContactsItemView.g(imMessageCenterPojo.getUnread_count());
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (view2 instanceof GameContactsItemView)) {
            GameContactsItemView gameContactsItemView = (GameContactsItemView) view2;
            GameContactsItemView gameContactsItemView2 = this.a.get(Integer.valueOf(this.d));
            if (gameContactsItemView2 != null) {
                gameContactsItemView2.a();
            }
            gameContactsItemView.h();
            if (this.d != gameContactsItemView.getGameMatchUser().b()) {
                z = true;
            } else {
                z = false;
            }
            this.d = gameContactsItemView.getGameMatchUser().b();
            a aVar = this.b;
            if (aVar != null) {
                pk7 gameMatchUser = gameContactsItemView.getGameMatchUser();
                if (z) {
                    i = 2;
                } else {
                    i = 3;
                }
                aVar.a(gameContactsItemView, gameMatchUser, i);
            }
        }
    }

    public void setOnContactsItemViewClick(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
