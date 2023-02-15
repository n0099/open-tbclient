package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatAdapter.SelfHolder a;
        public final /* synthetic */ CommonMsgField b;

        public a(BaseChatAdapter.SelfHolder selfHolder, CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selfHolder, commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selfHolder;
            this.b = commonMsgField;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getView() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getView().getContext(), String.valueOf(this.b.getUserId()), this.b.getUserName())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public b(CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonMsgField;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.a.getUserId()))) {
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921777, new AtSelectData(this.a.getPortrait(), this.a.getUserName(), String.valueOf(this.a.getUserId()), this.a.isRobot())));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static void a(@NonNull CommonMsgField commonMsgField, @NonNull TextView textView) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, commonMsgField, textView) == null) {
            int role = commonMsgField.getRole();
            if (!commonMsgField.isRobot() && (role <= 0 || role > 4)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            int i = R.color.CAM_X0334;
            int i2 = R.string.A_X05;
            if (commonMsgField.isRobot()) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f0889);
            } else if (role > 0 && role < 4) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f088a);
                i = R.color.CAM_X0302;
                i2 = R.string.A_X01;
            } else {
                str = "";
            }
            p15 d = p15.d(textView);
            d.n(R.string.J_X04);
            d.v(R.color.CAM_X0101);
            d.e(i2);
            d.f(i);
            textView.setText(str);
        }
    }

    public static void b(@NonNull CommonMsgField commonMsgField, @NonNull ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, commonMsgField, imageView) == null) {
            int level = commonMsgField.getLevel();
            if (level >= 1 && level <= 18) {
                imageView.setVisibility(0);
                imageView.setBackground(TbadkCoreApplication.getInst().getResources().getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(level)));
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public static void c(@NonNull CommonMsgField commonMsgField, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, commonMsgField, textView) == null) {
            String userName = commonMsgField.getUserName();
            if (StringUtils.isNull(userName)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            p15.d(textView).v(R.color.CAM_X0107);
            textView.setText(userName);
        }
    }

    public static ReplyContentView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ReplyContentView replyContentView = new ReplyContentView(context);
            replyContentView.setId(R.id.obfuscated_res_0x7f090dc5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.setMargins(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), dimenPixelSize, 0);
            replyContentView.setLayoutParams(layoutParams);
            return replyContentView;
        }
        return (ReplyContentView) invokeL.objValue;
    }

    public static MaxHeightRecycleView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            MaxHeightRecycleView maxHeightRecycleView = new MaxHeightRecycleView(context);
            maxHeightRecycleView.setId(R.id.obfuscated_res_0x7f091f4f);
            maxHeightRecycleView.setLayoutParams(new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds782), -2));
            return maxHeightRecycleView;
        }
        return (MaxHeightRecycleView) invokeL.objValue;
    }

    public static void i(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void f(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, childitemdata, selfHolder) == null) {
            int itemStatus = childitemdata.getItemStatus();
            if (itemStatus != 0) {
                if (itemStatus != 1) {
                    if (itemStatus != 2) {
                        if (itemStatus != 3) {
                            if (itemStatus != 4) {
                                if (itemStatus != 5) {
                                    return;
                                }
                            }
                        }
                    }
                    selfHolder.f.setVisibility(8);
                    selfHolder.e.setVisibility(0);
                    return;
                }
                selfHolder.f.setVisibility(0);
                selfHolder.e.setVisibility(8);
                return;
            }
            selfHolder.f.setVisibility(8);
            selfHolder.e.setVisibility(8);
        }
    }

    public static <ChildItemData extends BaseMsg> void g(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, childitemdata, selfHolder) == null) {
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            childitemdata.isLeft();
            c(commonMsgField, selfHolder.b);
            a(commonMsgField, selfHolder.c);
            b(commonMsgField, selfHolder.d);
            HeadImageView headImageView = selfHolder.a;
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.K(commonMsgField.getPortrait(), 12, false);
            headImageView.setOnClickListener(new a(selfHolder, commonMsgField));
            headImageView.setOnLongClickListener(new b(commonMsgField));
        }
    }

    public static <ChildItemData extends BaseMsg> void h(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, childitemdata, selfHolder) == null) {
            ReMsgInfo reMsgInfo = childitemdata.getReMsgInfo();
            View findViewById = selfHolder.g.findViewById(R.id.obfuscated_res_0x7f090dc5);
            if (findViewById instanceof ReplyContentView) {
                if (reMsgInfo != null) {
                    if (childitemdata instanceof TextGenImageMsg) {
                        ((ReplyContentView) findViewById).setFixedWidth(true, -2);
                    } else {
                        ((ReplyContentView) findViewById).setFixedWidth(false, -1);
                    }
                    if (childitemdata.isLeft()) {
                        ((ReplyContentView) findViewById).c(reMsgInfo);
                        return;
                    } else {
                        ((ReplyContentView) findViewById).d(reMsgInfo);
                        return;
                    }
                }
                findViewById.setVisibility(8);
                ((ReplyContentView) findViewById).setFixedWidth(false, -2);
            }
        }
    }
}
