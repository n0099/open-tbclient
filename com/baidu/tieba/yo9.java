package com.baidu.tieba;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class yo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jl9 a;
    public fz6 b;
    public View.OnTouchListener c;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo9 a;

        public a(yo9 yo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.b != null) {
                    this.a.b.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up6 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yo9 yo9Var, int i, String str, up6 up6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo9Var, Integer.valueOf(i), str, up6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = up6Var;
        }

        @Override // com.baidu.tieba.e26, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                up6 up6Var = this.m;
                if (up6Var instanceof cq6) {
                    statisticItem = ((cq6) up6Var).N();
                } else if (up6Var instanceof dq6) {
                    statisticItem = ((dq6) up6Var).K(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public yo9(BdTypeRecyclerView bdTypeRecyclerView, jl9 jl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, jl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.c = aVar;
        this.a = jl9Var;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.b = new fz6();
    }

    public final cq6 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            cq6 cq6Var = new cq6();
            cq6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return cq6Var;
        }
        return (cq6) invokeL.objValue;
    }

    public final void f(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, up6Var) == null) {
            up6Var.n = true;
            up6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, up6Var) == null) {
            ((cq6) up6Var).q = true;
            up6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, up6Var) == null) {
            ((cq6) up6Var).p = true;
            up6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, up6Var) == null) {
            ((cq6) up6Var).r = true;
            up6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, up6Var) == null) {
            ((dq6) up6Var).s = true;
            up6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void b(List<ThreadInfo> list, List<cn> list2, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i2 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null) {
                        threadData2.getForumData().l = str;
                    }
                    if ((cq6.R(threadData2) || dq6.L(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        cq6 d = d(threadData2);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        up6 c = c(threadData2);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i;
                            if (c instanceof cq6) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof dq6) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        cq6 d2 = d(threadData2);
                        if (d2 != null) {
                            d2.g = threadData2.getTid();
                            d2.position = i;
                            e(d2);
                        }
                        if (d2 != null && d2.isValid()) {
                            list2.add(d2);
                        }
                    }
                    i++;
                }
            }
        }
    }

    public final up6 c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (cq6.R(threadData)) {
                cq6 cq6Var = new cq6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                cq6Var.a = threadData;
                return cq6Var;
            } else if (!dq6.L(threadData)) {
                return null;
            } else {
                return new dq6(threadData);
            }
        }
        return (up6) invokeL.objValue;
    }

    public final void e(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, up6Var) == null) {
            if (up6Var instanceof cq6) {
                ((cq6) up6Var).A = true;
            } else if (up6Var instanceof dq6) {
                ((dq6) up6Var).A = true;
            } else if (up6Var instanceof bq6) {
                ((bq6) up6Var).A = true;
            }
            up6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public void k(aj9 aj9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, aj9Var) != null) || aj9Var == null) {
            return;
        }
        if (aj9Var.k() != null) {
            str = aj9Var.k().getFirst_class();
        } else {
            str = "";
        }
        List<ThreadInfo> H = aj9Var.H();
        LinkedList linkedList = new LinkedList();
        b(H, linkedList, str);
        this.a.g(linkedList);
    }
}
