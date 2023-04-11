package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.dt6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o48 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId e;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public b b;
    public c c;
    public final List<ChatRoomInfoData> d;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view2, ChatRoomInfoData chatRoomInfoData);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ChatRoomInfoData e;
        public TextView f;
        public final CustomMessageListener g;

        /* loaded from: classes5.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i)};
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
                this.a = dVar;
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

        /* loaded from: classes5.dex */
        public class b implements View.OnAttachStateChangeListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
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

        /* loaded from: classes5.dex */
        public class c implements dt6.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.dt6.i
            public void a(SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                    this.a.d.setText(spannableStringBuilder);
                }
            }
        }

        public d(View view2) {
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
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090697);
            this.a = headImageView;
            headImageView.setIsRound(true);
            this.a.setPlaceHolder(1);
            this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X04));
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09069e);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09069f);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09068b);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090680);
            view2.addOnAttachStateChangeListener(new b(this));
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.setSkinType(i);
                this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
                q25 d = q25.d(this.c);
                d.C(R.string.F_X01);
                d.B(R.dimen.T_X09);
                d.w(R.color.CAM_X0108);
                q25 d2 = q25.d(this.d);
                d2.C(R.string.F_X02);
                d2.B(R.dimen.T_X07);
                d2.w(R.color.CAM_X0105);
                d2.s(R.color.CAM_X0105);
                q25 d3 = q25.d(this.f);
                d3.w(R.color.CAM_X0301);
                d3.C(R.string.F_X02);
                d3.B(R.dimen.T_X07);
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
                    q25 d = q25.d(this.b);
                    d.C(R.string.F_X01);
                    d.B(R.dimen.T_X09);
                    d.w(R.color.CAM_X0108);
                    return;
                }
                this.c.setVisibility(8);
                q25 d2 = q25.d(this.b);
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
                        dt6.d(tbPageContext.getPageActivity(), q48.e(tbPageContext, fromName, chatroomMEMsgInfoData.getContent()), UtilHelper.getDimenPixelSize(R.dimen.T_X04), new c(this));
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
                        this.c.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0863) + newMsgTimeInterval);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ o48 b;

        public a(o48 o48Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o48Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o48Var;
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.b != null) {
                this.b.b.a(view2, this.a.b());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982390, "Lcom/baidu/tieba/o48;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982390, "Lcom/baidu/tieba/o48;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!ListUtils.isEmpty(this.d)) {
                return this.d.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public o48(TbPageContext<?> tbPageContext) {
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
        this.d = new ArrayList();
        this.a = tbPageContext;
    }

    public final void b(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i = 0; i < 20; i++) {
                this.d.add(new ChatRoomInfoData());
            }
            this.d.set(0, list.get(0));
            notifyDataSetChanged();
        }
    }

    public void c(List<ChatRoomInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (ListUtils.isEmpty(this.d)) {
            b(list);
        } else {
            this.d.set(0, list.get(0));
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.c = cVar;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<ChatRoomInfoData> list = this.d;
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
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01d6, viewGroup, false);
                dVar = new d(view2);
                view2.setTag(dVar);
            } else {
                dVar = (d) view2.getTag();
            }
            if (!ListUtils.isEmpty(this.d) && this.d.get(0) != null) {
                ChatRoomInfoData chatRoomInfoData = this.d.get(0);
                dVar.e(this.a, chatRoomInfoData);
                c cVar = this.c;
                if (cVar != null) {
                    cVar.a(view2, chatRoomInfoData);
                }
            }
            dVar.c(TbadkCoreApplication.getInst().getSkinType());
            view2.setOnClickListener(new a(this, dVar));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
