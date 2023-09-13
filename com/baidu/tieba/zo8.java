package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.helper.BotEffectUIAssist;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.EmojiReplyView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.UserIdentificationConf;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.tieba.lo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class zo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public a(CommonMsgField commonMsgField) {
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

        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        public void a(@NonNull p87 p87Var, @NonNull View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, p87Var, view2) == null) && (p87Var instanceof q87)) {
                ap8.a(this.a.getUserId(), this.a.getRoomId(), ((q87) p87Var).j());
                if (!StringUtils.isNull(p87Var.F())) {
                    BrowserHelper.startWebActivity(view2.getContext(), "", p87Var.F(), false, true, true, null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatAdapter.SelfHolder a;
        public final /* synthetic */ CommonMsgField b;

        public b(BaseChatAdapter.SelfHolder selfHolder, CommonMsgField commonMsgField) {
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

    /* loaded from: classes9.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public c(CommonMsgField commonMsgField) {
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

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public d(CommonMsgField commonMsgField) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8.a(this.a.getUserId(), this.a.getRoomId(), "5");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseMsg b;

        public e(View view2, BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = baseMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager.from(this.a).setBackGroundColor(R.color.transparent);
                this.b.setShowLocatedColor(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao8 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseChatMsg c;
        public final /* synthetic */ int d;

        public f(ao8 ao8Var, View view2, BaseChatMsg baseChatMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao8Var, view2, baseChatMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ao8Var;
            this.b = view2;
            this.c = baseChatMsg;
            this.d = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                if (bdImage == null) {
                    this.a.onFailed();
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.b.getResources(), bdImage.getRawBitmap(), bdImage.getRawBitmap().getNinePatchChunk(), bdImage.getPadding(), null);
                if (this.c.getItemStatus() == 5) {
                    as8.i("c15182", this.d, this.c.getCommonMsgField().getRoomId(), !this.c.isLeft());
                }
                this.a.a(ninePatchDrawable);
            }
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
                str = resources.getString(R.string.obfuscated_res_0x7f0f0960);
            } else {
                if (role > 0 && role < 4) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f0962);
                    i = R.color.CAM_X0302;
                } else if (role == 4) {
                    str = resources.getString(R.string.obfuscated_res_0x7f0f0961);
                    i = R.color.CAM_X0319;
                } else {
                    str = "";
                }
                i2 = R.string.A_X01;
            }
            EMManager.from(textView).setCorner(R.string.J_X04).setTextColor(R.color.CAM_X0101).setAlpha(i2).setBackGroundColor(i);
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
            EMManager from = EMManager.from(textView);
            if (commonMsgField.getRole() == 4) {
                from.setTextColor(R.color.CAM_X0319);
            } else {
                from.setTextColor(R.color.CAM_X0107);
            }
            textView.setText(userName);
        }
    }

    public static void p(@NonNull List<EnableDegradeUserData> list, @NonNull CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, list, commonMsgField) == null) {
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    ap8.b(commonMsgField.getUserId(), commonMsgField.getRoomId(), enableDegradeUserData.getIcon().getType());
                }
            }
        }
    }

    public static View d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setTag(R.id.obfuscated_res_0x7f092400, new gs8(context, recyclerView, new br8(), new dr8(), BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 1));
            recyclerView.setId(R.id.obfuscated_res_0x7f090e8c);
            return recyclerView;
        }
        return (View) invokeL.objValue;
    }

    public static ReplyContentView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            ReplyContentView replyContentView = new ReplyContentView(context);
            replyContentView.setId(R.id.obfuscated_res_0x7f090eb4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.setMargins(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), dimenPixelSize, 0);
            replyContentView.setLayoutParams(layoutParams);
            return replyContentView;
        }
        return (ReplyContentView) invokeL.objValue;
    }

    public static boolean s(@NonNull CommonMsgField commonMsgField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, commonMsgField)) == null) {
            if (commonMsgField.getUserExtraInfo() == null) {
                return false;
            }
            UserIdentificationConf userIdentificationConf = commonMsgField.getUserExtraInfo().getUserIdentificationConf();
            if (!"user_banned".equals(userIdentificationConf.getResourceKey())) {
                return false;
            }
            if (StringUtils.isNull(userIdentificationConf.getImageUrl()) && StringUtils.isNull(userIdentificationConf.getContent())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull EmojiReplyView emojiReplyView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, emojiReplyView) == null) {
            emojiReplyView.setAdapter(new kp8(emojiReplyView));
        }
    }

    public static MaxHeightRecycleView g(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            MaxHeightRecycleView maxHeightRecycleView = new MaxHeightRecycleView(context);
            maxHeightRecycleView.setId(R.id.obfuscated_res_0x7f09218a);
            maxHeightRecycleView.setLayoutParams(new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds782), -2));
            return maxHeightRecycleView;
        }
        return (MaxHeightRecycleView) invokeL.objValue;
    }

    public static void w(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void h(@NonNull lo8.c cVar, @NonNull ChildItemData childitemdata, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, cVar, childitemdata, view2) == null) {
            if (childitemdata.getShowLocatedColor()) {
                EMManager.from(view2).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0313);
                cVar.d(new e(view2, childitemdata), 1000L);
                return;
            }
            EMManager.from(view2).setBackGroundColor(R.color.transparent);
        }
    }

    public static <ChildItemData extends BaseMsg> void i(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, childitemdata, selfHolder) == null) {
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

    public static <ChildItemData extends BaseMsg> void n(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, childitemdata, selfHolder) == null) {
            ReMsgInfo reMsgInfo = childitemdata.getReMsgInfo();
            View findViewById = selfHolder.j.findViewById(R.id.obfuscated_res_0x7f090eb4);
            if (findViewById instanceof ReplyContentView) {
                if (reMsgInfo != null) {
                    if (childitemdata instanceof TextGenImageMsg) {
                        ((ReplyContentView) findViewById).setFixedWidth(true, -2);
                    } else {
                        ((ReplyContentView) findViewById).setFixedWidth(false, -1);
                    }
                    if (childitemdata.isLeft()) {
                        ((ReplyContentView) findViewById).f(reMsgInfo);
                        return;
                    } else {
                        ((ReplyContentView) findViewById).h(reMsgInfo);
                        return;
                    }
                }
                findViewById.setVisibility(8);
                ((ReplyContentView) findViewById).setFixedWidth(false, -2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(@NonNull BaseChatMsg<?> baseChatMsg, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, baseChatMsg, i)) == null) {
            BubbleInfo bubbleInfo = baseChatMsg.getCommonMsgField().getBubbleInfo();
            if (baseChatMsg.needBubbleInfo() && bubbleInfo != null && bubbleInfo.getColorInfo() != null) {
                BubbleInfo.ColorInfo colorInfo = bubbleInfo.getColorInfo();
                if (i == 0) {
                    str = colorInfo.getTextColor();
                } else if (i == 4) {
                    str = colorInfo.getTextColorDark();
                }
                if (StringUtils.isNull(str)) {
                    return zfa.f(str);
                }
                return 0;
            }
            str = "";
            if (StringUtils.isNull(str)) {
            }
        } else {
            return invokeLI.intValue;
        }
    }

    public static <ChildItemData extends BaseMsg> void j(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, childitemdata, selfHolder) == null) {
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            boolean isLeft = childitemdata.isLeft();
            List<EnableDegradeUserData> enableDegradeUserDataList = commonMsgField.getEnableDegradeUserDataList();
            if (enableDegradeUserDataList != null && enableDegradeUserDataList.size() > 0) {
                List<p87> x = x(enableDegradeUserDataList);
                p(enableDegradeUserDataList, commonMsgField);
                if (isLeft) {
                    selfHolder.r.setGravity(16);
                } else {
                    selfHolder.r.setGravity(5);
                    selfHolder.t.setGravity(5);
                }
                selfHolder.r.j(x);
                selfHolder.b.setVisibility(8);
                selfHolder.c.setVisibility(8);
                selfHolder.d.setVisibility(8);
                selfHolder.r.setVisibility(0);
                selfHolder.r.setOnTagClickListener(new a(commonMsgField));
            } else {
                selfHolder.r.setVisibility(8);
                c(commonMsgField, selfHolder.b);
                a(commonMsgField, selfHolder.c);
                if (!commonMsgField.isRobot()) {
                    b(commonMsgField, selfHolder.d);
                } else {
                    selfHolder.d.setVisibility(8);
                }
            }
            List<EnableDegradeUserData> secondDegradeUserDataList = commonMsgField.getSecondDegradeUserDataList();
            if (secondDegradeUserDataList != null) {
                v(secondDegradeUserDataList, selfHolder, commonMsgField);
                EMManager.from(selfHolder.s).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X01);
            } else {
                selfHolder.s.setVisibility(8);
            }
            HeadImageView headImageView = selfHolder.a;
            headImageView.setAlpha(1.0f);
            selfHolder.n.setVisibility(8);
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.startLoad(commonMsgField.getPortrait(), 12, false);
            headImageView.setOnClickListener(new b(selfHolder, commonMsgField));
            headImageView.setOnLongClickListener(new c(commonMsgField));
            if (s(commonMsgField)) {
                UserIdentificationConf userIdentificationConf = commonMsgField.getUserExtraInfo().getUserIdentificationConf();
                selfHolder.p.setText(userIdentificationConf.getContent());
                selfHolder.o.startLoad(userIdentificationConf.getImageUrl(), 10, false);
                headImageView.setAlpha(0.5f);
                selfHolder.n.setVisibility(0);
                EMManager.from(selfHolder.n).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0625);
                EMManager.from(selfHolder.p).setTextColor(R.color.CAM_X0101);
            }
            if (isLeft && commonMsgField.isRobot()) {
                TiebaStatic.log(new StatisticItem("c15194").param("fid", commonMsgField.getForumId()).param("obj_id", commonMsgField.getUserId()).param("obj_name", commonMsgField.getUserName()).param("room_id", commonMsgField.getRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void k(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, io8 io8Var, ho8 ho8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65546, null, context, childitemdata, selfHolder, io8Var, ho8Var) != null) || selfHolder.l == null) {
            return;
        }
        List<AbilityItem> quickOperate = childitemdata.getCommonMsgField().getQuickOperate();
        gs8 gs8Var = (gs8) ((RecyclerView) selfHolder.l.findViewById(R.id.obfuscated_res_0x7f090e8c)).getTag(R.id.obfuscated_res_0x7f092400);
        if (!ListUtils.isEmpty(q(quickOperate)) && gs8Var != null) {
            selfHolder.l.setVisibility(0);
            gs8Var.f(io8Var, ho8Var);
            gs8Var.d(Collections.singletonList(childitemdata));
            return;
        }
        selfHolder.l.setVisibility(8);
    }

    public static <ChildItemData extends BaseMsg> void l(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, @NonNull lo8.c cVar, @Nullable io8 io8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, context, childitemdata, selfHolder, cVar, io8Var) == null) {
            if (((childitemdata instanceof TextMsg) || selfHolder.g == null) && selfHolder.h != null && selfHolder.i != null) {
                BotEffectUIAssist botEffectUIAssist = new BotEffectUIAssist(context, childitemdata, selfHolder, cVar, io8Var);
                botEffectUIAssist.k(childitemdata.getCommonMsgField().getRoomId());
                botEffectUIAssist.j(childitemdata.getCommonMsgField().getForumId());
                botEffectUIAssist.c();
                childitemdata.getCommonMsgField().setAbilityEffectItem(null);
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void m(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, io8 io8Var, ho8 ho8Var) {
        EmojiReplyView.AlignMode alignMode;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65548, null, context, childitemdata, selfHolder, io8Var, ho8Var) != null) || selfHolder.m == null) {
            return;
        }
        List<EmojiData> emojiList = childitemdata.getCommonMsgField().getEmojiList();
        EmojiReplyView emojiReplyView = selfHolder.m;
        if (childitemdata.isLeft()) {
            alignMode = EmojiReplyView.AlignMode.LEFT;
        } else {
            alignMode = EmojiReplyView.AlignMode.RIGHT;
        }
        emojiReplyView.setAlignMode(alignMode);
        kp8 adapter = selfHolder.m.getAdapter();
        if (emojiList != null && !emojiList.isEmpty()) {
            selfHolder.m.setVisibility(0);
            if (adapter != null) {
                adapter.c(io8Var);
                adapter.d(childitemdata);
                adapter.k(childitemdata.getCommonMsgField().isLocalEmojiReply(), emojiList);
                return;
            }
            return;
        }
        if (adapter != null) {
            adapter.j();
        }
        selfHolder.m.setVisibility(8);
    }

    public static void o(boolean z, @NonNull TextView textView, @NonNull BaseChatMsg<?> baseChatMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), textView, baseChatMsg, Integer.valueOf(i)}) == null) {
            int u = u(baseChatMsg, i);
            if (u != 0 && !z) {
                textView.setTextColor(u);
            } else if (baseChatMsg.isLeft()) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
            }
        }
    }

    public static List<AbilityItem> q(List<AbilityItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                AbilityItem abilityItem = list.get(i);
                if (abilityItem != null && abilityItem.getStyleConf() != null && abilityItem.getStyleConf().shouldShow()) {
                    arrayList.add(abilityItem);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean r(@NonNull ChatRoomDetail chatRoomDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, chatRoomDetail)) == null) {
            if (chatRoomDetail.getExtraInfo() == null || chatRoomDetail.getUserInfo() == null) {
                return true;
            }
            if (chatRoomDetail.getExtraInfo().getIsFreezing() == 1 || chatRoomDetail.getExtraInfo().getIsTalkBanned() == 1 || chatRoomDetail.getUserInfo().getIsBeenTalkBanned() == 1) {
                return false;
            }
            if (chatRoomDetail.getExtraInfo().getTalkType() == 1 && chatRoomDetail.getUserInfo().getIdentityRole() != 3) {
                return false;
            }
            int talkThresholdLevel = chatRoomDetail.getExtraInfo().getTalkThresholdLevel();
            int forumLevel = chatRoomDetail.getUserInfo().getForumLevel();
            if (talkThresholdLevel <= 1 || talkThresholdLevel <= forumLevel) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void t(BdUniqueId bdUniqueId, @NonNull BaseChatMsg<?> baseChatMsg, @NonNull View view2, @NonNull ao8 ao8Var) {
        String androidRightDark;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, bdUniqueId, baseChatMsg, view2, ao8Var) == null) {
            BubbleInfo bubbleInfo = baseChatMsg.getCommonMsgField().getBubbleInfo();
            if (baseChatMsg.needBubbleInfo() && bubbleInfo != null) {
                int id = bubbleInfo.getId();
                int skinType = TbadkApplication.getInst().getSkinType();
                BubbleInfo.ImgInfo imgInfo = bubbleInfo.getImgInfo();
                if (baseChatMsg.isLeft()) {
                    if (skinType == 0) {
                        androidRightDark = imgInfo.getAndroidLeft();
                    } else {
                        if (skinType == 4) {
                            androidRightDark = imgInfo.getAndroidLeftDark();
                        }
                        androidRightDark = "";
                    }
                } else if (skinType == 0) {
                    androidRightDark = imgInfo.getAndroidRight();
                } else {
                    if (skinType == 4) {
                        androidRightDark = imgInfo.getAndroidRightDark();
                    }
                    androidRightDark = "";
                }
                if (!StringUtils.isNull(androidRightDark)) {
                    BdResourceLoader.getInstance().loadResource(androidRightDark, 19, new f(ao8Var, view2, baseChatMsg, id), bdUniqueId);
                    return;
                } else {
                    ao8Var.onFailed();
                    return;
                }
            }
            ao8Var.onFailed();
        }
    }

    public static void v(@NonNull List<EnableDegradeUserData> list, @NonNull BaseChatAdapter.SelfHolder selfHolder, @NonNull CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, list, selfHolder, commonMsgField) == null) {
            if (list.size() > 0) {
                EnableDegradeUserData enableDegradeUserData = list.get(0);
                boolean z = true;
                if ((enableDegradeUserData.getType() != 1 || enableDegradeUserData.getText() == null || StringUtils.isNull(enableDegradeUserData.getText().getStr())) ? false : false) {
                    selfHolder.s.setText(enableDegradeUserData.getText().getStr());
                    selfHolder.s.setVisibility(0);
                    ap8.b(commonMsgField.getUserId(), commonMsgField.getRoomId(), "5");
                    selfHolder.s.setOnClickListener(new d(commonMsgField));
                    return;
                }
                selfHolder.s.setVisibility(8);
                return;
            }
            selfHolder.s.setVisibility(8);
        }
    }

    public static List<p87> x(@NonNull List<EnableDegradeUserData> list) {
        InterceptResult invokeL;
        m87 m87Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 1) {
                    if (enableDegradeUserData.getText() != null) {
                        if (enableDegradeUserData.getText().getTextColor() != null) {
                            m87Var = new m87(enableDegradeUserData.getText().getTextColor().getType(), enableDegradeUserData.getText().getTextColor().getDay(), enableDegradeUserData.getText().getTextColor().getNight());
                        } else {
                            m87Var = new m87(2, "CAM_X0107", null);
                        }
                        m87 m87Var2 = m87Var;
                        String str = enableDegradeUserData.getText().getStr();
                        String schema = enableDegradeUserData.getText().getSchema();
                        int priority = enableDegradeUserData.getText().getPriority();
                        if (enableDegradeUserData.getText().getDegradeEnable() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        r87 r87Var = new r87(str, m87Var2, schema, priority, z, enableDegradeUserData.getText().getDegradeLength(), enableDegradeUserData.getText().getSuffix(), enableDegradeUserData.getText().getDegradePriority());
                        r87Var.i(enableDegradeUserData.getText().getType());
                        arrayList.add(r87Var);
                    }
                } else if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    q87 q87Var = new q87(enableDegradeUserData.getIcon().getUrl(), enableDegradeUserData.getIcon().getSchema(), enableDegradeUserData.getIcon().getWidth(), enableDegradeUserData.getIcon().getHeight(), enableDegradeUserData.getIcon().getPriority(), false, null, null, null, null);
                    q87Var.n(enableDegradeUserData.getIcon().getType());
                    arrayList.add(q87Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
