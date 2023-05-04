package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.GamePlayCardMsgView;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.sharecard.ChatShareCard;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class jz7 extends x8<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public static final String F;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCheckBox A;
    public LinearLayout B;
    public AbsMsglistView.j C;
    public int D;
    public ChatMessage E;
    public af b;
    public bf c;
    public long d;
    public Calendar e;
    public int f;
    public long g;
    public Long h;
    public TextView i;
    public TbRichTextView j;
    public ChatVoiceView k;
    public GifView l;
    public ShareFromPBView m;
    public ShareFromFrsView n;
    public ShareFromGameCenter o;
    public ChatImageWithTailView p;
    public ChatShareCard q;
    public GamePlayCardMsgView r;
    public ChatShareChatroomCard s;
    public Boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public ArrayList<ReportPrivateMsgData> y;
    public int z;

    public void V(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view2, chatMessage) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public a(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 10, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public b(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 15, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public c(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 15, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public d(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 11, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public e(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 12, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public f(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 11, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ jz7 b;

        public g(jz7 jz7Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz7Var;
            this.a = chatMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    if (this.b.y.size() < 20) {
                        this.b.A.setChecked(true);
                        this.b.y.add(new ReportPrivateMsgData(String.valueOf(this.a.getMsgId()), nx9.b(this.b.mContext, this.a), String.valueOf(this.a.getTime())));
                        if (this.b.C != null) {
                            this.b.C.a(this.b.y, true);
                        }
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_REPORT_PRIVATE_MSG_CHANGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921670, Boolean.TRUE));
                    return;
                }
                int i = 0;
                this.b.A.setChecked(false);
                while (true) {
                    if (i < this.b.y.size()) {
                        if (this.b.y.get(i) != null && TextUtils.equals(String.valueOf(this.a.getMsgId()), this.b.y.get(i).getMsgId())) {
                            this.b.y.remove(i);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (this.b.C != null) {
                    this.b.C.a(this.b.y, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public h(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tbRichTextView = this.a.j) != null && tbRichTextView.getTextView() != null) {
                CharSequence text = this.a.j.getTextView().getText();
                if (!TextUtils.isEmpty(text)) {
                    if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                        if (text.toString().contains("http://") || text.toString().contains("https://")) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) g9.a(view2.getContext()), new String[]{jz7.F});
                            f55.m().w(f55.q("key_person_post_recycle_bin_red_tip_show"), false);
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public i(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 5, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public j(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 4, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public k(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 4, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public l(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 13, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public m(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 3, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public n(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 7, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public o(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                jz7 jz7Var = this.a;
                jz7Var.c.Q(view2, 7, jz7Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public p(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jz7 jz7Var = this.a;
                jz7Var.b.D(view2, 10, jz7Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public q(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900674, "Lcom/baidu/tieba/jz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900674, "Lcom/baidu/tieba/jz7;");
                return;
            }
        }
        F = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jz7(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
        super(tbPageContext, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.t = Boolean.FALSE;
        this.u = true;
        this.v = false;
        this.w = false;
        this.x = false;
        this.D = 3;
        this.d = 0L;
        this.e = null;
        this.mContext = tbPageContext;
    }

    public final void C(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) && chatMessage != null && chatMessage.getMsgType() == 2) {
            ns5.d();
        }
    }

    public final void F(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setVoice_status(1);
                chatMessage.setCacheData(msgCacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
        }
    }

    public final boolean H(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 < 1000) {
                return false;
            }
            long j3 = this.d;
            if (j3 != 0 && j2 - j3 < 180) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void J(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            calendar.setTimeInMillis(j2 * 1000);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.x = z;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p.setVisibility(i2);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.w = z;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
        }
    }

    public void Q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.d = j2;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.u = z;
        }
    }

    public void S(af afVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, afVar) == null) {
            this.b = afVar;
        }
    }

    public void T(bf bfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bfVar) == null) {
            this.c = bfVar;
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f = i2;
        }
    }

    public void W(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            this.y = arrayList;
            AbsMsglistView.j jVar = this.C;
            if (jVar != null) {
                jVar.a(arrayList, false);
            }
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.z = i2;
        }
    }

    public void Z(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, chatMessage) == null) {
            ShareChatroomMsgData c2 = c48.c(chatMessage);
            ChatShareChatroomCard chatShareChatroomCard = this.s;
            if (chatShareChatroomCard != null) {
                chatShareChatroomCard.setVisibility(0);
                this.s.c(c2);
            }
        }
    }

    public void b0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, chatMessage) == null) {
            F(chatMessage);
            ShareForumMsgData d2 = c48.d(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 33);
            this.q.a(d2);
        }
    }

    public void g0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, chatMessage) == null) {
            F(chatMessage);
            ShareThreadMsgData e2 = c48.e(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 32);
            this.q.a(e2);
        }
    }

    public void setUpdateListener(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, jVar) == null) {
            this.C = jVar;
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.D = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public final String E(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 < 1000) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 * 1000);
            Calendar calendar2 = this.e;
            if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.e.get(6) == calendar.get(6)) {
                return hi.getDateStringHm(calendar.getTime());
            }
            return hi.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = (TextView) u(R.id.tex_msgitem_time);
            TbRichTextView tbRichTextView = (TbRichTextView) u(R.id.tex_msgitem_text);
            this.j = tbRichTextView;
            tbRichTextView.setLinkTextColor(-14845754);
            this.j.setFaceSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X04));
            this.p = (ChatImageWithTailView) u(R.id.img_msgitem_image);
            this.A = (TbCheckBox) u(R.id.ckb_select);
            this.B = (LinearLayout) u(R.id.ll_ckb_select);
            this.m = (ShareFromPBView) u(R.id.lay_msgitem_share_view);
            this.n = (ShareFromFrsView) u(R.id.lay_msgitem_share_frs);
            this.o = (ShareFromGameCenter) u(R.id.lay_msgitem_share_game);
            this.r = (GamePlayCardMsgView) u(R.id.lay_msgitem_gameplay_card);
            ChatVoiceView chatVoiceView = (ChatVoiceView) u(R.id.lay_msgitem_voice);
            this.k = chatVoiceView;
            chatVoiceView.setClickable(true);
            ChatVoiceView chatVoiceView2 = this.k;
            chatVoiceView2.setOnClickListener(chatVoiceView2);
            this.q = (ChatShareCard) u(R.id.share_card_container);
            this.s = (ChatShareChatroomCard) u(R.id.share_group_card);
            I();
            this.j.setOnClickListener(new h(this));
            this.k.setLongClickable(true);
            this.k.setOnLongClickListener(new i(this));
            this.p.getImage().setClickable(true);
            this.p.getImage().setOnClickListener(new j(this));
            this.p.getImage().setLongClickable(true);
            this.p.getImage().setOnLongClickListener(new k(this));
            this.p.getTail().setClickable(true);
            this.p.getTail().setOnClickListener(new l(this));
            this.j.setLongClickable(true);
            this.j.setOnLongClickListener(new m(this));
            GifView gifView = (GifView) u(R.id.emotion_msgitem_image);
            this.l = gifView;
            gifView.setSupportNoImage(false);
            this.l.setOnClickListener(new n(this));
            this.l.setLongClickable(true);
            this.l.setOnLongClickListener(new o(this));
            this.m.setClickable(true);
            this.m.setOnClickListener(new p(this));
            this.m.setLongClickable(true);
            this.m.setOnLongClickListener(new a(this));
            this.n.setClickable(true);
            this.n.setOnClickListener(new b(this));
            this.n.setLongClickable(true);
            this.n.setOnLongClickListener(new c(this));
            this.o.getContentBody().setClickable(true);
            this.o.getContentBody().setOnClickListener(new d(this));
            this.o.getTail().setClickable(true);
            this.o.getTail().setOnClickListener(new e(this));
            this.o.getContentBody().setLongClickable(true);
            this.o.getContentBody().setOnLongClickListener(new f(this));
        }
    }

    public void K(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, chatMessage) == null) {
            ChatMessage chatMessage2 = this.E;
            if (chatMessage2 == null || (chatMessage != null && chatMessage2.getMsgId() != chatMessage.getMsgId())) {
                C(chatMessage);
            }
            this.E = chatMessage;
            if (chatMessage != null) {
                chatMessage.setItemView(this);
                this.h = Long.valueOf(chatMessage.getMsgId());
            }
        }
    }

    public void Y(ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, chatMessage, z) == null) {
            mz7.b(this.mContext.getContext(), this.l, chatMessage, z);
        }
    }

    public void h0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, chatMessage, str) == null) {
            mz7.g(this.mContext.getContext(), this.k, chatMessage, str);
        }
    }

    public void a0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, view2, chatMessage, str) == null) {
            mz7.c(this.mContext.getContext(), view2, this.m, this.n, this.o, chatMessage, str);
        }
    }

    public void e0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, view2, chatMessage, str) == null) {
            mz7.e(this.mContext.getContext(), view2, this.p, chatMessage, this.g, str);
        }
    }

    public void c0(@NonNull ChatMessage chatMessage) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, chatMessage) == null) {
            if (!this.t.booleanValue() && (runTask = MessageManager.getInstance().runTask(2921735, null, null)) != null && runTask.getData() != null) {
                this.t = (Boolean) runTask.getData();
            }
            F(chatMessage);
            GamePlayOrderMsgData b2 = c48.b(chatMessage);
            this.r.setVisibility(0);
            this.r.setData(b2);
        }
    }

    public void d0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, chatMessage) == null) {
            if (chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1) {
                z = true;
            } else {
                z = false;
            }
            boolean H = H(chatMessage.getTime());
            if (!z && !H) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(E(chatMessage.getTime()));
            }
            if (!z && H) {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    MsgCacheData msgCacheData = new MsgCacheData();
                    msgCacheData.setIs_show_time(1);
                    chatMessage.setCacheData(msgCacheData);
                    return;
                }
                cacheData.setIs_show_time(1);
            }
        }
    }

    public void f0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, chatMessage, str) == null) {
            mz7.f(this.j, chatMessage, str, this.z);
            if (chatMessage != null && chatMessage.getContent() != null) {
                String[] split = chatMessage.getContent().split("#");
                StringBuffer stringBuffer = new StringBuffer();
                for (String str2 : split) {
                    stringBuffer.append(str2);
                }
                this.j.setContentDescription(stringBuffer.toString());
                this.j.getTextView().setContentDescription(stringBuffer.toString());
            }
        }
    }

    public void i0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, chatMessage) == null) {
            if (this.y == null) {
                this.y = new ArrayList<>();
            }
            if (this.x) {
                this.B.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 < this.y.size()) {
                        ReportPrivateMsgData reportPrivateMsgData = this.y.get(i2);
                        if (reportPrivateMsgData != null && TextUtils.equals(String.valueOf(chatMessage.getMsgId()), reportPrivateMsgData.getMsgId())) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                this.B.setTag(Boolean.valueOf(z));
                this.A.setTagData(new q(this));
                this.A.setBackgroundDrawableIdIsWebP(true);
                this.A.setClickable(false);
                this.A.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
                this.A.setChecked(((Boolean) this.B.getTag()).booleanValue());
                this.B.setOnClickListener(new g(this, chatMessage));
                return;
            }
            this.B.setVisibility(8);
        }
    }
}
