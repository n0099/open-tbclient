package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.en8;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.im.base.core.tag.MaxHeightRecycleView;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.ReplyContentView;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbNormalMsg;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BubbleInfo;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.im.lib.socket.msg.data.EnableDegradeUserData;
import com.baidu.tieba.im.lib.socket.msg.data.UserExtraInfo;
import com.baidu.tieba.im.lib.socket.msg.data.UserIdentificationConf;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BaseStyleNormalAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BotEffectUIAssist;
import com.baidu.tieba.im.under.common.uiliststyle.group.emjio.view.EmojiReplyView;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextGenImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class mv8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbNormalMsg a;

        public a(TbNormalMsg tbNormalMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbNormalMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbNormalMsg;
        }

        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        public void a(@NonNull t57 t57Var, @NonNull View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t57Var, view2) == null) && (t57Var instanceof v57)) {
                tv8.a(this.a.getUserId(), this.a.getSessionId(), ((v57) t57Var).j());
                if (!StringUtils.isNull(t57Var.G())) {
                    BrowserHelper.startWebActivity(view2.getContext(), "", t57Var.G(), false, true, true, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseStyleNormalAdapter.SelfHolder a;
        public final /* synthetic */ TbNormalMsg b;

        public b(BaseStyleNormalAdapter.SelfHolder selfHolder, TbNormalMsg tbNormalMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selfHolder, tbNormalMsg};
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
            this.b = tbNormalMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getView() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getView().getContext(), String.valueOf(this.b.getUserId()), this.b.getUserName())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbNormalMsg a;

        public c(TbNormalMsg tbNormalMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbNormalMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbNormalMsg;
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbNormalMsg a;

        public d(TbNormalMsg tbNormalMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbNormalMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbNormalMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tv8.a(this.a.getUserId(), this.a.getSessionId(), "5");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseItem b;

        public e(View view2, BaseItem baseItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseItem};
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
            this.b = baseItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager.from(this.a).setBackGroundColor(R.color.transparent);
                this.b.setShowLocatedColor(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv8 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseItem c;
        public final /* synthetic */ int d;

        public f(nv8 nv8Var, View view2, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv8Var, view2, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv8Var;
            this.b = view2;
            this.c = baseItem;
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
                if (this.c.getSendStatus() == 5) {
                    uv8.k("c15182", this.d, ((TbNormalMsg) this.c.getTbMsg()).getSessionId(), !this.c.isLeft());
                }
                this.a.a(ninePatchDrawable);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986234, "Lcom/baidu/tieba/mv8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986234, "Lcom/baidu/tieba/mv8;");
                return;
            }
        }
        a = SkinManager.getColor(R.color.CAM_X0304);
    }

    public static void a(@NonNull TbNormalMsg tbNormalMsg, @NonNull TextView textView) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tbNormalMsg, textView) == null) {
            int role = tbNormalMsg.getRole();
            if (!tbNormalMsg.isRobot() && (role <= 0 || role > 4)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            int i = R.color.CAM_X0334;
            int i2 = R.string.A_X05;
            if (tbNormalMsg.isRobot()) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f0979);
            } else if (role > 0 && role < 4) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f097b);
                i = R.color.CAM_X0302;
                i2 = R.string.A_X01;
            } else {
                str = "";
            }
            EMManager.from(textView).setCorner(R.string.J_X04).setTextColor(R.color.CAM_X0101).setAlpha(i2).setBackGroundColor(i);
            textView.setText(str);
        }
    }

    public static void b(@NonNull TbNormalMsg tbNormalMsg, @NonNull ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tbNormalMsg, imageView) == null) {
            int b2 = q(tbNormalMsg).b();
            if (b2 >= 1 && b2 <= 18) {
                imageView.setVisibility(0);
                imageView.setBackground(TbadkCoreApplication.getInst().getResources().getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(b2)));
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public static void c(@NonNull TbNormalMsg tbNormalMsg, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tbNormalMsg, textView) == null) {
            String userName = tbNormalMsg.getUserName();
            if (StringUtils.isNull(userName)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0107);
            textView.setText(userName);
        }
    }

    public static void p(@NonNull List<EnableDegradeUserData> list, @NonNull TbNormalMsg tbNormalMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, list, tbNormalMsg) == null) {
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    tv8.b(tbNormalMsg.getUserId(), tbNormalMsg.getSessionId(), enableDegradeUserData.getIcon().getType());
                }
            }
        }
    }

    public static View d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setTag(R.id.obfuscated_res_0x7f09242c, new rm8(context, recyclerView, new ru8(), new tu8(), BdUtilHelper.getDimens(context, R.dimen.M_W_X004), 1));
            recyclerView.setId(R.id.obfuscated_res_0x7f090ed6);
            return recyclerView;
        }
        return (View) invokeL.objValue;
    }

    public static ReplyContentView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            ReplyContentView replyContentView = new ReplyContentView(context);
            replyContentView.setId(R.id.obfuscated_res_0x7f090efd);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.setMargins(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), dimenPixelSize, 0);
            replyContentView.setLayoutParams(layoutParams);
            return replyContentView;
        }
        return (ReplyContentView) invokeL.objValue;
    }

    public static boolean s(@NonNull UserExtraInfo userExtraInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, userExtraInfo)) == null) {
            UserIdentificationConf userIdentificationConf = userExtraInfo.getUserIdentificationConf();
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
        if (interceptable == null || interceptable.invokeL(65541, null, emojiReplyView) == null) {
            emojiReplyView.setAdapter(new pv8(emojiReplyView));
        }
    }

    public static MaxHeightRecycleView g(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            MaxHeightRecycleView maxHeightRecycleView = new MaxHeightRecycleView(context);
            maxHeightRecycleView.setId(R.id.obfuscated_res_0x7f0921a8);
            maxHeightRecycleView.setLayoutParams(new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds782), -2));
            return maxHeightRecycleView;
        }
        return (MaxHeightRecycleView) invokeL.objValue;
    }

    @NonNull
    public static TbBaseMsg.c q(@NonNull TbBaseMsg tbBaseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tbBaseMsg)) == null) {
            TbBaseMsg.c forumExt = tbBaseMsg.getForumExt();
            if (forumExt == null) {
                return new TbBaseMsg.c();
            }
            return forumExt;
        }
        return (TbBaseMsg.c) invokeL.objValue;
    }

    public static void w(@NonNull BaseStyleNormalAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, selfHolder) == null) && selfHolder.g.getVisibility() != 8) {
            selfHolder.g.setVisibility(8);
        }
    }

    public static void y(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void h(@NonNull en8.c cVar, @NonNull ChildItemData childitemdata, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, cVar, childitemdata, view2) == null) {
            if (childitemdata.isShowLocatedColor()) {
                EMManager.from(view2).setAlpha(R.string.A_X06).setBackGroundColor(R.color.CAM_X0313);
                cVar.d(new e(view2, childitemdata), 1000L);
                return;
            }
            EMManager.from(view2).setBackGroundColor(R.color.transparent);
        }
    }

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void i(@NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, childitemdata, selfHolder) == null) {
            int sendStatus = childitemdata.getSendStatus();
            if (sendStatus != 0) {
                if (sendStatus != 1) {
                    if (sendStatus != 2) {
                        if (sendStatus != 3) {
                            if (sendStatus != 4) {
                                if (sendStatus != 5) {
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

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void n(@NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, childitemdata, selfHolder) == null) {
            TbReMsgInfo reMsgInfo = ((TbNormalMsg) childitemdata.getTbMsg()).getReMsgInfo();
            View findViewById = selfHolder.j.findViewById(R.id.obfuscated_res_0x7f090efd);
            if (findViewById instanceof ReplyContentView) {
                if (reMsgInfo != null) {
                    if (childitemdata instanceof TextGenImageItem) {
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(@NonNull BaseItem<? extends TbNormalMsg> baseItem, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, baseItem, i)) == null) {
            int i2 = a;
            BubbleInfo bubbleInfo = baseItem.getTbMsg().getBubbleInfo();
            if (baseItem.needBubbleInfo() && bubbleInfo != null && bubbleInfo.getColorInfo() != null) {
                BubbleInfo.ColorInfo colorInfo = bubbleInfo.getColorInfo();
                if (i == 0) {
                    str = colorInfo.getAtTextColor();
                } else if (i == 4) {
                    str = colorInfo.getAtTextColorDark();
                }
                if (StringUtils.isNull(str)) {
                    return aqa.f(str);
                }
                return i2;
            }
            str = "";
            if (StringUtils.isNull(str)) {
            }
        } else {
            return invokeLI.intValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int v(@NonNull BaseItem<? extends TbNormalMsg> baseItem, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, baseItem, i)) == null) {
            BubbleInfo bubbleInfo = baseItem.getTbMsg().getBubbleInfo();
            if (baseItem.needBubbleInfo() && bubbleInfo != null && bubbleInfo.getColorInfo() != null) {
                BubbleInfo.ColorInfo colorInfo = bubbleInfo.getColorInfo();
                if (i == 0) {
                    str = colorInfo.getTextColor();
                } else if (i == 4) {
                    str = colorInfo.getTextColorDark();
                }
                if (StringUtils.isNull(str)) {
                    return aqa.f(str);
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

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void j(@NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, childitemdata, selfHolder) == null) {
            TbNormalMsg tbNormalMsg = (TbNormalMsg) childitemdata.getTbMsg();
            boolean isLeft = childitemdata.isLeft();
            List<EnableDegradeUserData> enableDegradeUserDataList = tbNormalMsg.getEnableDegradeUserDataList();
            if (enableDegradeUserDataList != null && enableDegradeUserDataList.size() > 0) {
                List<t57> z = z(enableDegradeUserDataList);
                p(enableDegradeUserDataList, tbNormalMsg);
                if (isLeft) {
                    selfHolder.r.setGravity(16);
                } else {
                    selfHolder.r.setGravity(5);
                    selfHolder.t.setGravity(5);
                }
                selfHolder.r.i(z);
                selfHolder.b.setVisibility(8);
                selfHolder.c.setVisibility(8);
                selfHolder.d.setVisibility(8);
                selfHolder.r.setVisibility(0);
                selfHolder.r.setOnTagClickListener(new a(tbNormalMsg));
            } else {
                selfHolder.r.setVisibility(8);
                c(tbNormalMsg, selfHolder.b);
                a(tbNormalMsg, selfHolder.c);
                if (!tbNormalMsg.isRobot()) {
                    b(tbNormalMsg, selfHolder.d);
                } else {
                    selfHolder.d.setVisibility(8);
                }
            }
            List<EnableDegradeUserData> secondDegradeUserDataList = tbNormalMsg.getSecondDegradeUserDataList();
            if (secondDegradeUserDataList != null) {
                x(secondDegradeUserDataList, selfHolder, tbNormalMsg);
                EMManager.from(selfHolder.s).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X01);
            } else {
                selfHolder.s.setVisibility(8);
            }
            HeadImageView headImageView = selfHolder.a;
            headImageView.setAlpha(1.0f);
            ViewGroup viewGroup = selfHolder.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.startLoad(tbNormalMsg.getPortrait(), 12, false);
            headImageView.setOnClickListener(new b(selfHolder, tbNormalMsg));
            headImageView.setOnLongClickListener(new c(tbNormalMsg));
            if (tbNormalMsg.getUserExtraInfo() != null && s(tbNormalMsg.getUserExtraInfo())) {
                UserIdentificationConf userIdentificationConf = tbNormalMsg.getUserExtraInfo().getUserIdentificationConf();
                selfHolder.p.setText(userIdentificationConf.getContent());
                selfHolder.o.startLoad(userIdentificationConf.getImageUrl(), 10, false);
                headImageView.setAlpha(0.5f);
                selfHolder.n.setVisibility(0);
                EMManager.from(selfHolder.n).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0625);
                EMManager.from(selfHolder.p).setTextColor(R.color.CAM_X0101);
            }
            if (isLeft && tbNormalMsg.isRobot()) {
                TiebaStatic.log(new StatisticItem("c15194").param("fid", q(tbNormalMsg).a()).param("obj_id", tbNormalMsg.getUserId()).param("obj_name", tbNormalMsg.getUserName()).param("room_id", tbNormalMsg.getSessionId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void k(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder, cn8 cn8Var, bn8 bn8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65547, null, context, childitemdata, selfHolder, cn8Var, bn8Var) != null) || selfHolder.l == null) {
            return;
        }
        List<AbilityItem> quickOperate = ((TbNormalMsg) childitemdata.getTbMsg()).getQuickOperate();
        rm8 rm8Var = (rm8) ((RecyclerView) selfHolder.l.findViewById(R.id.obfuscated_res_0x7f090ed6)).getTag(R.id.obfuscated_res_0x7f09242c);
        if (!ListUtils.isEmpty(r(quickOperate)) && rm8Var != null) {
            selfHolder.l.setVisibility(0);
            rm8Var.f(cn8Var, bn8Var);
            rm8Var.d(Collections.singletonList((TbNormalMsg) childitemdata.getTbMsg()));
            return;
        }
        selfHolder.l.setVisibility(8);
    }

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void l(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder, @NonNull en8.c cVar, @Nullable cn8 cn8Var, @Nullable in8 in8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, childitemdata, selfHolder, cVar, cn8Var, in8Var}) == null) {
            if (((childitemdata instanceof TextItem) || selfHolder.g == null) && selfHolder.h != null && selfHolder.i != null) {
                BotEffectUIAssist botEffectUIAssist = new BotEffectUIAssist(context, childitemdata, selfHolder, cVar, cn8Var);
                botEffectUIAssist.m(((TbNormalMsg) childitemdata.getTbMsg()).getSessionId());
                botEffectUIAssist.k(q(childitemdata.getTbMsg()).a());
                botEffectUIAssist.l(in8Var);
                botEffectUIAssist.c();
                ((TbNormalMsg) childitemdata.getTbMsg()).setAbilityEffectItem(null);
            }
        }
    }

    public static <ChildItemData extends BaseItem<? extends TbNormalMsg>> void m(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder, cn8 cn8Var, bn8 bn8Var) {
        EmojiReplyView.AlignMode alignMode;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65549, null, context, childitemdata, selfHolder, cn8Var, bn8Var) != null) || selfHolder.m == null) {
            return;
        }
        List<EmojiData> emojiList = ((TbNormalMsg) childitemdata.getTbMsg()).getEmojiList();
        EmojiReplyView emojiReplyView = selfHolder.m;
        if (childitemdata.isLeft()) {
            alignMode = EmojiReplyView.AlignMode.LEFT;
        } else {
            alignMode = EmojiReplyView.AlignMode.RIGHT;
        }
        emojiReplyView.setAlignMode(alignMode);
        pv8 adapter = selfHolder.m.getAdapter();
        if (emojiList != null && !emojiList.isEmpty()) {
            selfHolder.m.setVisibility(0);
            if (adapter != null) {
                adapter.c(cn8Var);
                adapter.d(childitemdata);
                adapter.k(((TbNormalMsg) childitemdata.getTbMsg()).isLocalEmojiReply(), emojiList);
                return;
            }
            return;
        }
        if (adapter != null) {
            adapter.j();
        }
        selfHolder.m.setVisibility(8);
    }

    public static void o(boolean z, @NonNull TextView textView, @NonNull BaseItem<? extends TbNormalMsg> baseItem, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), textView, baseItem, Integer.valueOf(i)}) == null) {
            int v = v(baseItem, i);
            if (v != 0 && !z) {
                textView.setTextColor(v);
            } else if (baseItem.isLeft()) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
            }
        }
    }

    public static List<AbilityItem> r(List<AbilityItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, list)) == null) {
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

    public static void t(BdUniqueId bdUniqueId, @NonNull BaseItem<? extends TbNormalMsg> baseItem, @NonNull View view2, @NonNull nv8 nv8Var) {
        String androidRightDark;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, bdUniqueId, baseItem, view2, nv8Var) == null) {
            BubbleInfo bubbleInfo = baseItem.getTbMsg().getBubbleInfo();
            if (baseItem.needBubbleInfo() && bubbleInfo != null) {
                int id = bubbleInfo.getId();
                int skinType = TbadkApplication.getInst().getSkinType();
                BubbleInfo.ImgInfo imgInfo = bubbleInfo.getImgInfo();
                if (baseItem.isLeft()) {
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
                    BdResourceLoader.getInstance().loadResource(androidRightDark, 59, new f(nv8Var, view2, baseItem, id), bdUniqueId);
                    return;
                } else {
                    nv8Var.onFailed();
                    return;
                }
            }
            nv8Var.onFailed();
        }
    }

    public static void x(@NonNull List<EnableDegradeUserData> list, @NonNull BaseStyleNormalAdapter.SelfHolder selfHolder, @NonNull TbNormalMsg tbNormalMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, list, selfHolder, tbNormalMsg) == null) {
            if (list.size() > 0) {
                EnableDegradeUserData enableDegradeUserData = list.get(0);
                boolean z = true;
                if ((enableDegradeUserData.getType() != 1 || enableDegradeUserData.getText() == null || StringUtils.isNull(enableDegradeUserData.getText().getStr())) ? false : false) {
                    selfHolder.s.setText(enableDegradeUserData.getText().getStr());
                    selfHolder.s.setVisibility(0);
                    tv8.b(tbNormalMsg.getUserId(), tbNormalMsg.getSessionId(), "5");
                    selfHolder.s.setOnClickListener(new d(tbNormalMsg));
                    return;
                }
                selfHolder.s.setVisibility(8);
                return;
            }
            selfHolder.s.setVisibility(8);
        }
    }

    public static List<t57> z(@NonNull List<EnableDegradeUserData> list) {
        InterceptResult invokeL;
        m57 m57Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 1) {
                    if (enableDegradeUserData.getText() != null) {
                        if (enableDegradeUserData.getText().getTextColor() != null) {
                            m57Var = new m57(enableDegradeUserData.getText().getTextColor().getType(), enableDegradeUserData.getText().getTextColor().getDay(), enableDegradeUserData.getText().getTextColor().getNight());
                        } else {
                            m57Var = new m57(2, "CAM_X0107", null);
                        }
                        m57 m57Var2 = m57Var;
                        String str = enableDegradeUserData.getText().getStr();
                        String schema = enableDegradeUserData.getText().getSchema();
                        int priority = enableDegradeUserData.getText().getPriority();
                        if (enableDegradeUserData.getText().getDegradeEnable() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        w57 w57Var = new w57(str, m57Var2, schema, priority, z, enableDegradeUserData.getText().getDegradeLength().intValue(), enableDegradeUserData.getText().getSuffix(), enableDegradeUserData.getText().getDegradePriority().intValue());
                        w57Var.i(enableDegradeUserData.getText().getType());
                        arrayList.add(w57Var);
                    }
                } else if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    v57 v57Var = new v57(enableDegradeUserData.getIcon().getUrl(), enableDegradeUserData.getIcon().getSchema(), enableDegradeUserData.getIcon().getWidth(), enableDegradeUserData.getIcon().getHeight(), enableDegradeUserData.getIcon().getPriority(), false, null, null, null, null);
                    v57Var.n(enableDegradeUserData.getIcon().getType());
                    arrayList.add(v57Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
