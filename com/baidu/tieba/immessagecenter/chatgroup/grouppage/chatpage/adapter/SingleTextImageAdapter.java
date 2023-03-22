package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.StatisticInfoField;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.TaskInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.TextGenImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class SingleTextImageAdapter<T extends SingleTextImageMsg> extends BaseChatAdapter<T, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void W(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
        }
    }

    public void X(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public final TextGenImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = (TextGenImageView) view2;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                View view2 = this.a;
                if (view2 != null) {
                    view2.setOnLongClickListener(onLongClickListener);
                }
                TextGenImageView textGenImageView = this.b;
                if (textGenImageView != null && textGenImageView.getImageWithTailView() != null && this.b.getImageWithTailView().getImage() != null) {
                    this.b.getImageWithTailView().getImage().setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            TextGenImageView textGenImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && (textGenImageView = this.b) != null) {
                textGenImageView.getImageWithTailView().getImage().setOnClickListener(onClickListener);
            }
        }

        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                this.a = view2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleTextImageMsg a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ SingleTextImageAdapter e;

        public a(SingleTextImageAdapter singleTextImageAdapter, SingleTextImageMsg singleTextImageMsg, long j, String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleTextImageAdapter, singleTextImageMsg, Long.valueOf(j), str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = singleTextImageAdapter;
            this.a = singleTextImageMsg;
            this.b = j;
            this.c = str;
            this.d = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090e1c) {
                TaskInfo taskInfo = this.a.getTaskInfo();
                if (taskInfo != null && taskInfo.isComplete()) {
                    String bigSrc = this.a.getBigSrc();
                    if (StringUtils.isNull(bigSrc)) {
                        bigSrc = this.a.getThumbUrl();
                    }
                    String str = bigSrc;
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    PersonalMsgImageActivityConfig personalMsgImageActivityConfig = new PersonalMsgImageActivityConfig(view2.getContext(), str, TbadkCoreApplication.getCurrentAccountId(), "");
                    StatisticInfoField statisticInfoField = new StatisticInfoField();
                    statisticInfoField.setForumId(String.valueOf(this.b));
                    statisticInfoField.setForumName(this.c);
                    statisticInfoField.setChatRoomId(String.valueOf(this.d));
                    personalMsgImageActivityConfig.setFrom(1);
                    personalMsgImageActivityConfig.setStatisticInfoFild(statisticInfoField);
                    personalMsgImageActivityConfig.isFromGroupChat(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
                }
                this.e.W(this.d, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleTextImageAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: T */
    public Holder F(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            Holder holder = new Holder(S(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: U */
    public Holder H(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            Holder holder = new Holder(S(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.h = str;
        }
    }

    public final TextGenImageView S(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            TextGenImageView textGenImageView = new TextGenImageView(context);
            textGenImageView.setId(R.id.obfuscated_res_0x7f090e3c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.gravity = 17;
            textGenImageView.setLayoutParams(layoutParams);
            textGenImageView.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            return textGenImageView;
        }
        return (TextGenImageView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: V */
    public void N(int i, @NonNull ViewGroup viewGroup, @NonNull T t, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, t, holder, list, Integer.valueOf(i2)}) == null) {
            SkinManager.setBackgroundResource(viewGroup, R.drawable.icon_pic_im_bubble_left);
            holder.b.b(holder, t);
            CommonMsgField commonMsgField = t.getCommonMsgField();
            long roomId = commonMsgField.getRoomId();
            long forumId = commonMsgField.getForumId();
            String str = this.h;
            X(roomId, forumId, str);
            holder.a(new a(this, t, forumId, str, roomId));
        }
    }
}
