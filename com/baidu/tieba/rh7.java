package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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

    public static void a(boolean z, @NonNull CommonMsgField commonMsgField, @NonNull SpannableStringBuilder spannableStringBuilder) {
        int role;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), commonMsgField, spannableStringBuilder}) == null) && (role = commonMsgField.getRole()) > 0 && role <= 4) {
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0848);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string);
            uh7 uh7Var = new uh7(SkinManager.getColor(R.color.CAM_X0302), SkinManager.getColor(R.color.CAM_X0101));
            uh7Var.c(R.dimen.T_X10);
            uh7Var.b(R.dimen.tbds5);
            uh7Var.d(R.dimen.tbds10);
            uh7Var.a(R.dimen.tbds0);
            spannableStringBuilder2.setSpan(uh7Var, 0, string.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            spannableStringBuilder.append((CharSequence) g());
        }
    }

    public static void b(boolean z, @NonNull CommonMsgField commonMsgField, @NonNull SpannableStringBuilder spannableStringBuilder) {
        int level;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), commonMsgField, spannableStringBuilder}) == null) && (level = commonMsgField.getLevel()) >= 1 && level <= 18) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("P");
            Drawable drawable = TbadkCoreApplication.getInst().getResources().getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(level));
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds40), UtilHelper.getDimenPixelSize(R.dimen.tbds35));
            spannableStringBuilder2.setSpan(new ImageSpan(drawable), 0, 1, 17);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            if (!z) {
                spannableStringBuilder.append((CharSequence) g());
            }
        }
    }

    public static void c(boolean z, @NonNull CommonMsgField commonMsgField, @NonNull SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), commonMsgField, spannableStringBuilder}) == null) {
            String userName = commonMsgField.getUserName();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(userName);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.T_X08);
            int color = SkinManager.getColor(R.color.CAM_X0107);
            spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(dimenPixelSize), 0, userName.length(), 34);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(color), 0, userName.length(), 34);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            if (z) {
                spannableStringBuilder.append((CharSequence) g());
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void d(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, childitemdata, selfHolder) == null) {
            if (!(childitemdata instanceof TextMsg) && !(childitemdata instanceof VoiceMsg)) {
                if (childitemdata instanceof ImageMsg) {
                    selfHolder.e.setBackgroundColor(SkinManager.getColor(R.color.transparent));
                    return;
                }
                FrameLayout frameLayout = selfHolder.e;
                if (childitemdata.isLeft()) {
                    i2 = R.drawable.icon_pic_im_bubble_share_left;
                } else {
                    i2 = R.drawable.icon_pic_im_bubble_share_right;
                }
                SkinManager.setBackgroundResource(frameLayout, i2);
                return;
            }
            FrameLayout frameLayout2 = selfHolder.e;
            if (childitemdata.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            SkinManager.setBackgroundResource(frameLayout2, i);
        }
    }

    public static <ChildItemData extends BaseMsg> void e(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, childitemdata, selfHolder) == null) {
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
                    selfHolder.d.setVisibility(8);
                    selfHolder.c.setVisibility(0);
                    return;
                }
                selfHolder.d.setVisibility(0);
                selfHolder.c.setVisibility(8);
                return;
            }
            selfHolder.d.setVisibility(8);
            selfHolder.c.setVisibility(8);
        }
    }

    public static <ChildItemData extends BaseMsg> void f(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, childitemdata, selfHolder) == null) {
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            boolean isLeft = childitemdata.isLeft();
            TextView textView = selfHolder.b;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (isLeft) {
                c(true, commonMsgField, spannableStringBuilder);
                a(true, commonMsgField, spannableStringBuilder);
                b(true, commonMsgField, spannableStringBuilder);
            } else {
                b(false, commonMsgField, spannableStringBuilder);
                a(false, commonMsgField, spannableStringBuilder);
                c(false, commonMsgField, spannableStringBuilder);
            }
            textView.setText(spannableStringBuilder);
            HeadImageView headImageView = selfHolder.a;
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.K(commonMsgField.getPortrait(), 12, false);
            headImageView.setOnClickListener(new a(selfHolder, commonMsgField));
        }
    }

    public static SpannableString g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new SpannableString(" ");
        }
        return (SpannableString) invokeV.objValue;
    }

    public static void h(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }
}
