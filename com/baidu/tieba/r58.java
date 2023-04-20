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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.UserIdentificationConf;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class r58 {
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatAdapter.Holder a;
        public final /* synthetic */ BaseMsg b;

        public c(BaseChatAdapter.Holder holder, BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {holder, baseMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = holder;
            this.b = baseMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r25.d(this.a.itemView).f(R.color.transparent);
                this.b.setShowLocatedColor(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends bg<tm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w48 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseChatMsg c;
        public final /* synthetic */ int d;

        public d(w48 w48Var, View view2, BaseChatMsg baseChatMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w48Var, view2, baseChatMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w48Var;
            this.b = view2;
            this.c = baseChatMsg;
            this.d = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, tmVar, str, i) == null) {
                if (tmVar == null) {
                    this.a.onFailed();
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.b.getResources(), tmVar.p(), tmVar.p().getNinePatchChunk(), tmVar.o(), null);
                if (this.c.getItemStatus() == 5) {
                    s78.d("c15182", this.d, this.c.getCommonMsgField().getRoomId(), !this.c.isLeft());
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
                str = resources.getString(R.string.obfuscated_res_0x7f0f088c);
            } else if (role > 0 && role < 4) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f088d);
                i = R.color.CAM_X0302;
                i2 = R.string.A_X01;
            } else {
                str = "";
            }
            r25 d2 = r25.d(textView);
            d2.o(R.string.J_X04);
            d2.w(R.color.CAM_X0101);
            d2.e(i2);
            d2.f(i);
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
            r25.d(textView).w(R.color.CAM_X0107);
            textView.setText(userName);
        }
    }

    public static <ChildItemData extends BaseMsg> void g(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.Holder holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, childitemdata, holder) == null) {
            if (childitemdata.getShowLocatedColor()) {
                r25 d2 = r25.d(holder.itemView);
                d2.e(R.string.A_X06);
                d2.f(R.color.CAM_X0313);
                holder.itemView.postDelayed(new c(holder, childitemdata), 1000L);
                return;
            }
            r25.d(holder.itemView).f(R.color.transparent);
        }
    }

    public static View d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setTag(R.id.obfuscated_res_0x7f092226, new x78(context, recyclerView, new y68(), new a78(), ii.g(context, R.dimen.M_W_X004), 1));
            recyclerView.setId(R.id.obfuscated_res_0x7f090e10);
            return recyclerView;
        }
        return (View) invokeL.objValue;
    }

    public static ReplyContentView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ReplyContentView replyContentView = new ReplyContentView(context);
            replyContentView.setId(R.id.obfuscated_res_0x7f090e35);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.setMargins(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), dimenPixelSize, 0);
            replyContentView.setLayoutParams(layoutParams);
            return replyContentView;
        }
        return (ReplyContentView) invokeL.objValue;
    }

    public static boolean o(@NonNull CommonMsgField commonMsgField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, commonMsgField)) == null) {
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

    public static MaxHeightRecycleView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            MaxHeightRecycleView maxHeightRecycleView = new MaxHeightRecycleView(context);
            maxHeightRecycleView.setId(R.id.obfuscated_res_0x7f091fcc);
            maxHeightRecycleView.setLayoutParams(new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds782), -2));
            return maxHeightRecycleView;
        }
        return (MaxHeightRecycleView) invokeL.objValue;
    }

    public static void r(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void h(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, childitemdata, selfHolder) == null) {
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

    public static <ChildItemData extends BaseMsg> void k(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, childitemdata, selfHolder) == null) {
            ReMsgInfo reMsgInfo = childitemdata.getReMsgInfo();
            View findViewById = selfHolder.g.findViewById(R.id.obfuscated_res_0x7f090e35);
            if (findViewById instanceof ReplyContentView) {
                if (reMsgInfo != null) {
                    if (childitemdata instanceof TextGenImageMsg) {
                        ((ReplyContentView) findViewById).setFixedWidth(true, -2);
                    } else {
                        ((ReplyContentView) findViewById).setFixedWidth(false, -1);
                    }
                    if (childitemdata.isLeft()) {
                        ((ReplyContentView) findViewById).d(reMsgInfo);
                        return;
                    } else {
                        ((ReplyContentView) findViewById).e(reMsgInfo);
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
    public static int q(@NonNull BaseChatMsg<?> baseChatMsg, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, baseChatMsg, i)) == null) {
            BubbleInfo bubbleInfo = baseChatMsg.getCommonMsgField().getBubbleInfo();
            if (baseChatMsg.needBubbleInfo() && bubbleInfo != null && bubbleInfo.getColorInfo() != null) {
                BubbleInfo.ColorInfo colorInfo = bubbleInfo.getColorInfo();
                if (i == 0) {
                    str = colorInfo.getTextColor();
                } else if (i == 4) {
                    str = colorInfo.getTextColorDark();
                }
                if (StringUtils.isNull(str)) {
                    return fk9.f(str);
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

    public static <ChildItemData extends BaseMsg> void i(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, childitemdata, selfHolder) == null) {
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            boolean isLeft = childitemdata.isLeft();
            if (TbSingleton.getInstance().isUseDegradeCaseOfChatUserInfo() && commonMsgField.getEnableDegradeUserDataList() != null) {
                List<ax6> s = s(commonMsgField.getEnableDegradeUserDataList());
                if (isLeft) {
                    selfHolder.n.setGravity(16);
                } else {
                    selfHolder.n.setGravity(5);
                }
                selfHolder.n.j(s);
                selfHolder.b.setVisibility(8);
                selfHolder.c.setVisibility(8);
                selfHolder.d.setVisibility(8);
                selfHolder.n.setVisibility(0);
            } else {
                selfHolder.n.setVisibility(8);
                c(commonMsgField, selfHolder.b);
                a(commonMsgField, selfHolder.c);
                b(commonMsgField, selfHolder.d);
            }
            HeadImageView headImageView = selfHolder.a;
            headImageView.setAlpha(1.0f);
            selfHolder.j.setVisibility(8);
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.N(commonMsgField.getPortrait(), 12, false);
            headImageView.setOnClickListener(new a(selfHolder, commonMsgField));
            headImageView.setOnLongClickListener(new b(commonMsgField));
            if (o(commonMsgField)) {
                UserIdentificationConf userIdentificationConf = commonMsgField.getUserExtraInfo().getUserIdentificationConf();
                selfHolder.l.setText(userIdentificationConf.getContent());
                selfHolder.k.N(userIdentificationConf.getImageUrl(), 10, false);
                headImageView.setAlpha(0.5f);
                selfHolder.j.setVisibility(0);
                r25 d2 = r25.d(selfHolder.j);
                d2.o(R.string.J_X01);
                d2.f(R.color.CAM_X0625);
                r25.d(selfHolder.l).w(R.color.CAM_X0101);
            }
            if (isLeft && commonMsgField.isRobot()) {
                TiebaStatic.log(new StatisticItem("c15194").param("fid", commonMsgField.getForumId()).param("obj_id", commonMsgField.getUserId()).param("obj_name", commonMsgField.getUserName()).param("room_id", commonMsgField.getRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void j(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, b58 b58Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65545, null, context, childitemdata, selfHolder, b58Var) != null) || selfHolder.i == null) {
            return;
        }
        List<AbilityItem> quickOperate = childitemdata.getCommonMsgField().getQuickOperate();
        x78 x78Var = (x78) ((RecyclerView) selfHolder.i.findViewById(R.id.obfuscated_res_0x7f090e10)).getTag(R.id.obfuscated_res_0x7f092226);
        if (!ListUtils.isEmpty(m(quickOperate)) && x78Var != null) {
            selfHolder.i.setVisibility(0);
            x78Var.f(b58Var);
            x78Var.d(Collections.singletonList(childitemdata));
            return;
        }
        selfHolder.i.setVisibility(8);
    }

    public static void l(@NonNull TextView textView, @NonNull BaseChatMsg<?> baseChatMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, textView, baseChatMsg, i) == null) {
            int q = q(baseChatMsg, i);
            if (q != 0) {
                textView.setTextColor(q);
            } else if (baseChatMsg.isLeft()) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
            }
        }
    }

    public static List<AbilityItem> m(List<AbilityItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) {
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

    public static boolean n(@NonNull ChatRoomDetail chatRoomDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, chatRoomDetail)) == null) {
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

    public static void p(BdUniqueId bdUniqueId, @NonNull BaseChatMsg<?> baseChatMsg, @NonNull View view2, @NonNull w48 w48Var) {
        String androidRightDark;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, bdUniqueId, baseChatMsg, view2, w48Var) == null) {
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
                    cg.h().m(androidRightDark, 19, new d(w48Var, view2, baseChatMsg, id), bdUniqueId);
                    return;
                } else {
                    w48Var.onFailed();
                    return;
                }
            }
            w48Var.onFailed();
        }
    }

    public static List<ax6> s(@NonNull List<EnableDegradeUserData> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 1) {
                    if (enableDegradeUserData.getText() != null) {
                        String str = enableDegradeUserData.getText().getStr();
                        yw6 yw6Var = new yw6(enableDegradeUserData.getText().getTextColor().getType(), enableDegradeUserData.getText().getTextColor().getDay(), "");
                        int priority = enableDegradeUserData.getText().getPriority();
                        if (enableDegradeUserData.getText().getDegradeEnable() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        cx6 cx6Var = new cx6(str, yw6Var, null, priority, z, Integer.valueOf(enableDegradeUserData.getText().getDegradeLength()), enableDegradeUserData.getText().getSuffix(), Integer.valueOf(enableDegradeUserData.getText().getDegradePriority()));
                        cx6Var.h(enableDegradeUserData.getText().getBackgroundAlpha());
                        cx6Var.i(new yw6(enableDegradeUserData.getText().getBackgroundColor().getType(), enableDegradeUserData.getText().getBackgroundColor().getDay(), enableDegradeUserData.getText().getBackgroundColor().getNight()));
                        cx6Var.j(enableDegradeUserData.getText().getCorner());
                        arrayList.add(cx6Var);
                    }
                } else if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    arrayList.add(new bx6(enableDegradeUserData.getIcon().getUrl(), null, enableDegradeUserData.getIcon().getWidth(), enableDegradeUserData.getIcon().getHeight(), enableDegradeUserData.getIcon().getPriority(), false, null, null, null, null));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
