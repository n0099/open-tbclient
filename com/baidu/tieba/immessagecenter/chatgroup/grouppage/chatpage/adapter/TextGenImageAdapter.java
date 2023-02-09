package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.StatisticInfoField;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.gr7;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.TaskInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.TextGenImageView;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.tieba.nq7;
import com.baidu.tieba.sr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TextGenImageAdapter extends BaseChatAdapter<TextGenImageMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long g;
    public long h;
    public String i;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextGenImageMsg a;
        public final /* synthetic */ TextGenImageAdapter b;

        public a(TextGenImageAdapter textGenImageAdapter, TextGenImageMsg textGenImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textGenImageAdapter, textGenImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = textGenImageAdapter;
            this.a = textGenImageMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090dad) {
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
                    statisticInfoField.setForumId(String.valueOf(this.b.g));
                    statisticInfoField.setForumName(this.b.i);
                    statisticInfoField.setChatRoomId(String.valueOf(this.b.h));
                    personalMsgImageActivityConfig.setFrom(1);
                    personalMsgImageActivityConfig.setStatisticInfoFild(statisticInfoField);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
                }
                TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 2).param("fid", this.b.g).param("room_id", this.b.h).param("fname", this.b.i).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextGenImageAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public void A(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) {
            super.A(frameLayout);
            MaxHeightRecycleView e = nq7.e(this.mContext);
            frameLayout.addView(e);
            Context context = this.mContext;
            frameLayout.setTag(R.id.obfuscated_res_0x7f0921d1, gr7.c(context, e, ej.g(context, R.dimen.M_W_X004)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: S */
    public Holder B(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            Holder holder = new Holder(R(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: T */
    public Holder D(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            Holder holder = new Holder(R(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public void W(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.g = j;
        }
    }

    public void X(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.h = j;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.i = str;
        }
    }

    public final TextGenImageView R(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            TextGenImageView textGenImageView = new TextGenImageView(context);
            textGenImageView.setId(R.id.obfuscated_res_0x7f090dcd);
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
    /* renamed from: U */
    public void H(int i, @NonNull TextGenImageMsg textGenImageMsg, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), textGenImageMsg, frameLayout, list, Integer.valueOf(i2)}) == null) {
            super.H(i, textGenImageMsg, frameLayout, list, i2);
            sr7 sr7Var = (sr7) frameLayout.getTag(R.id.obfuscated_res_0x7f0921d1);
            if (sr7Var != null && textGenImageMsg.getSubSkillConfig() != null && !textGenImageMsg.getSubSkillConfig().a.isEmpty()) {
                frameLayout.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(textGenImageMsg);
                sr7Var.d(arrayList);
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: V */
    public void J(int i, @NonNull ViewGroup viewGroup, @NonNull TextGenImageMsg textGenImageMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), viewGroup, textGenImageMsg, holder, list, Integer.valueOf(i2)}) == null) {
            SkinManager.setBackgroundResource(viewGroup, R.drawable.icon_pic_im_bubble_share_left);
            holder.b.b(holder, textGenImageMsg);
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 1).param("fid", this.g).param("room_id", this.h).param("fname", this.i).param("uid", TbadkCoreApplication.getCurrentAccount()));
            holder.a(new a(this, textGenImageMsg));
        }
    }
}
