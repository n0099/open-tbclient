package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tieba.j17;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class td8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId f;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public c b;
    @Nullable
    public e c;
    public d d;
    public final List<ChatRoomInfoData> e;

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view2, ChatRoomInfoData chatRoomInfoData);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData);
    }

    /* loaded from: classes7.dex */
    public interface e {
        boolean a(View view2, ChatRoomInfoData chatRoomInfoData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ChatRoomInfoData e;
        public TextView f;
        public final CustomMessageListener g;

        /* loaded from: classes7.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                    this.a.c(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnAttachStateChangeListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    MessageManager.getInstance().registerListener(this.a.g);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    MessageManager.getInstance().unRegisterListener(this.a.g);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements j17.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public c(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.j17.i
            public void a(SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                    this.a.d.setText(spannableStringBuilder);
                }
            }
        }

        public f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = new a(this, 2001304);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906bc);
            this.a = headImageView;
            headImageView.setIsRound(true);
            this.a.setPlaceHolder(1);
            this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906c3);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906c4);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906b0);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906a5);
            view2.addOnAttachStateChangeListener(new b(this));
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.setSkinType(i);
                this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
                m75 d = m75.d(this.c);
                d.C(R.string.F_X01);
                d.B(R.dimen.T_X09);
                d.w(R.color.CAM_X0108);
                m75 d2 = m75.d(this.b);
                d2.C(R.string.F_X01);
                d2.B(R.dimen.T_X09);
                d2.w(R.color.CAM_X0108);
                m75 d3 = m75.d(this.d);
                d3.C(R.string.F_X02);
                d3.B(R.dimen.T_X07);
                d3.w(R.color.CAM_X0105);
                d3.s(R.color.CAM_X0105);
                m75 d4 = m75.d(this.f);
                d4.w(R.color.CAM_X0301);
                d4.C(R.string.F_X02);
                d4.B(R.dimen.T_X07);
            }
        }

        public ChatRoomInfoData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return (ChatRoomInfoData) invokeV.objValue;
        }

        public final void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.c.setVisibility(0);
                    m75 d = m75.d(this.b);
                    d.C(R.string.F_X01);
                    d.B(R.dimen.T_X09);
                    d.w(R.color.CAM_X0108);
                    return;
                }
                this.c.setVisibility(8);
                m75 d2 = m75.d(this.b);
                d2.C(R.string.F_X02);
                d2.B(R.dimen.T_X07);
                d2.w(R.color.CAM_X0105);
            }
        }

        public void e(@Nullable TbPageContext<?> tbPageContext, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, chatRoomInfoData) == null) {
                ChatRoomInfoData.ChatroomInfoBasicData chatroomInfoBasicData = chatRoomInfoData.getChatroomInfoBasicData();
                ChatRoomInfoData.ChatroomMEMsgInfoData chatroomMEMsgInfoData = chatRoomInfoData.getChatroomMEMsgInfoData();
                if (chatroomInfoBasicData != null && chatroomMEMsgInfoData != null && tbPageContext != null) {
                    this.e = chatRoomInfoData;
                    this.a.N(chatroomInfoBasicData.getAvatar(), 10, false);
                    if (StringUtils.isNull(chatroomMEMsgInfoData.getContent())) {
                        this.d.setVisibility(8);
                        d(false);
                    } else {
                        this.d.setVisibility(0);
                        d(true);
                        String fromName = chatroomMEMsgInfoData.getFromName();
                        if (!StringUtils.isNull(chatroomMEMsgInfoData.getSpecialMsg()) && StringHelper.getChineseAndEnglishLength(fromName) > 8) {
                            fromName = StringHelper.cutChineseAndEnglishWithEmoji(fromName, 8, null);
                        }
                        j17.e(tbPageContext.getPageActivity(), vd8.e(tbPageContext, fromName, chatroomMEMsgInfoData.getContent()), UtilHelper.getDimenPixelSize(R.dimen.T_X04), new c(this));
                    }
                    if (!StringUtils.isNull(chatroomMEMsgInfoData.getSpecialMsg())) {
                        this.f.setVisibility(0);
                        this.f.setText(chatroomMEMsgInfoData.getSpecialMsg());
                    } else {
                        this.f.setVisibility(8);
                    }
                    this.b.setText(chatroomInfoBasicData.getName());
                    String newMsgTimeInterval = StringHelper.getNewMsgTimeInterval(chatroomMEMsgInfoData.getMsgId());
                    if (!StringUtils.isNull(newMsgTimeInterval)) {
                        this.c.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0916) + newMsgTimeInterval);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ td8 b;

        public a(td8 td8Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td8Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = td8Var;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b != null) {
                this.b.b.a(view2, this.a.b());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ td8 b;

        public b(td8 td8Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td8Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = td8Var;
            this.a = fVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.b.c != null) {
                    return this.b.c.a(view2, this.a.b());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948177473, "Lcom/baidu/tieba/td8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948177473, "Lcom/baidu/tieba/td8;");
                return;
            }
        }
        f = BdUniqueId.gen();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!ListUtils.isEmpty(this.e)) {
                return this.e.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public td8(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.a = tbPageContext;
    }

    public final void c(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i = 0; i < 20; i++) {
                this.e.add(new ChatRoomInfoData());
            }
            this.e.set(0, list.get(0));
            notifyDataSetChanged();
        }
    }

    public void d(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (ListUtils.isEmpty(this.e)) {
            c(list);
        } else {
            this.e.set(0, list.get(0));
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.d = dVar;
        }
    }

    public void g(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.c = eVar;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List<ChatRoomInfoData> list = this.e;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e6, viewGroup, false);
                fVar = new f(view2);
                view2.setTag(fVar);
            } else {
                fVar = (f) view2.getTag();
            }
            if (!ListUtils.isEmpty(this.e) && this.e.get(0) != null) {
                ChatRoomInfoData chatRoomInfoData = this.e.get(0);
                fVar.e(this.a, chatRoomInfoData);
                d dVar = this.d;
                if (dVar != null) {
                    dVar.a(view2, chatRoomInfoData);
                }
            }
            fVar.c(TbadkCoreApplication.getInst().getSkinType());
            view2.setOnClickListener(new a(this, fVar));
            view2.setOnLongClickListener(new b(this, fVar));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
