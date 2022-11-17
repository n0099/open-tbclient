package com.baidu.tieba.redtip;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.ah;
import com.baidu.tieba.ei8;
import com.baidu.tieba.oa5;
import com.baidu.tieba.qy4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes5.dex */
public class PersonRedTipManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_PERSON = 4;
    public static final int TYPE_ACTIVITY_PRIZE = 9;
    public static final int TYPE_BOOK = 3;
    public static final int TYPE_DRESSUP = 6;
    public static final int TYPE_FANS = 2;
    public static final int TYPE_FEED_BACK = 10;
    public static final int TYPE_FREIND = 4;
    public static final int TYPE_GIFT = 1;
    public static final int TYPE_MEMBER = 7;
    public static final int TYPE_MESSAGE = 8;
    public static final int TYPE_NEW_GOD_INVITED = 11;
    public static final int TYPE_SETTING = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener bookMarksGiftAndFansListener;
    public CustomMessageListener feedBackRedTipListener;
    public boolean hasClicked;
    public boolean isPrimary;
    public int mBookMarks;
    public CustomMessageListener mDownloadCardListener;
    public int mFans;
    public int mGift;
    public boolean mHasNewVersion;
    public CustomMessageListener mHomePageTabClickListener;
    public boolean mIsDownloadCardMsg;
    public boolean mIsFeedbackNewMsg;
    public boolean mIsNewAddressList;
    public boolean mIsShowActivityNewMsg;
    public boolean mIsShowBookmarkNewMsg;
    public boolean mIsShowFansNewMsg;
    public boolean mIsShowGiftsNewMsg;
    public boolean mIsShowMemberCenerNewMsg;
    public boolean mShowActivityTip;
    public boolean mShowBookTip;
    public boolean mShowDownloadCardTip;
    public boolean mShowFanTip;
    public boolean mShowFeedbackTip;
    public boolean mShowFriendTip;
    public boolean mShowGifTip;
    public boolean mShowMemberTip;
    public boolean mShowNewGodInvitedTip;
    public boolean mShowSettingTip;
    public int maddressListNewCount;
    public CustomMessageListener memberCenterRedTipListener;
    public CustomMessageListener personInfoChangeListener;
    public CustomMessageListener syncFinishListener;
    public CustomMessageListener unreadNewAddressListListener;
    public CustomMessageListener updateVersionListener;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        public a(PersonRedTipManager personRedTipManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personRedTipManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.hasClicked) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001120) {
                return;
            }
            this.a.processNotify(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                if (responseUnreadPointNum.getNum() > 0 && this.a.maddressListNewCount < responseUnreadPointNum.getNum()) {
                    boolean z = true;
                    this.a.mIsNewAddressList = true;
                    PersonRedTipManager personRedTipManager = this.a;
                    if (!personRedTipManager.mIsNewAddressList) {
                        z = this.a.mShowFriendTip;
                    }
                    personRedTipManager.mShowFriendTip = z;
                    this.a.maddressListNewCount = responseUnreadPointNum.getNum();
                    this.a.notifyRedTipShow();
                } else {
                    this.a.maddressListNewCount = responseUnreadPointNum.getNum();
                    this.a.mIsNewAddressList = false;
                }
                this.a.saveAddressListRedState();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921740 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            Boolean bool = (Boolean) customResponsedMessage.getData();
            this.a.mIsDownloadCardMsg = bool.booleanValue();
            this.a.mShowDownloadCardTip = bool.booleanValue();
            this.a.notifyRedTipShow();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    qy4.k().u("key_feedback_tip_show", true);
                }
                this.a.mShowFeedbackTip = booleanValue;
                this.a.mIsFeedbackNewMsg = booleanValue;
                this.a.notifyRedTipShow();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
            if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= r2.m("maintab_member_center_red_tip_" + r1, 0)) goto L12;
         */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        qy4 k = qy4.k();
                    }
                    booleanValue = false;
                }
                this.a.mIsShowMemberCenerNewMsg = booleanValue;
                this.a.mShowMemberTip = booleanValue;
                this.a.notifyRedTipShow();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                PersonRedTipManager personRedTipManager = this.a;
                if (!personRedTipManager.mHasNewVersion) {
                    z = this.a.mShowSettingTip;
                } else {
                    z = true;
                }
                personRedTipManager.mShowSettingTip = z;
                this.a.notifyRedTipShow();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                this.a.removeTabTip();
                if (this.a.mShowNewGodInvitedTip) {
                    TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 1));
                    this.a.mShowNewGodInvitedTip = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.resetRedTip();
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonRedTipManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PersonRedTipManager personRedTipManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personRedTipManager, Integer.valueOf(i)};
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
            this.a = personRedTipManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        qy4 k = qy4.k();
                        String q = k.q("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (StringUtils.isNull(dotTimestamp) || dotTimestamp.equals(q)) {
                            return;
                        }
                        this.a.mShowActivityTip = true;
                        this.a.mIsShowActivityNewMsg = true;
                        this.a.notifyRedTipShow();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public static final PersonRedTipManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(757018429, "Lcom/baidu/tieba/redtip/PersonRedTipManager$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(757018429, "Lcom/baidu/tieba/redtip/PersonRedTipManager$k;");
                    return;
                }
            }
            a = new PersonRedTipManager(null);
        }
    }

    public PersonRedTipManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isPrimary = false;
        this.mShowFanTip = false;
        this.mShowBookTip = false;
        this.mShowGifTip = false;
        this.mShowFriendTip = false;
        this.mShowSettingTip = false;
        this.mShowMemberTip = false;
        this.mShowActivityTip = false;
        this.mShowFeedbackTip = qy4.k().h("key_feedback_tip_show", false);
        this.mShowNewGodInvitedTip = false;
        this.mShowDownloadCardTip = false;
        this.mFans = 0;
        this.mGift = 0;
        this.mBookMarks = 0;
        this.maddressListNewCount = 0;
        this.mIsNewAddressList = false;
        this.mHasNewVersion = false;
        this.mIsShowFansNewMsg = false;
        this.mIsShowGiftsNewMsg = false;
        this.mIsShowBookmarkNewMsg = false;
        this.mIsShowMemberCenerNewMsg = false;
        this.mIsShowActivityNewMsg = false;
        this.mIsFeedbackNewMsg = false;
        this.mIsDownloadCardMsg = false;
        this.bookMarksGiftAndFansListener = new b(this, 2001120);
        this.unreadNewAddressListListener = new c(this, 2001176);
        this.mDownloadCardListener = new d(this, 2921740);
        this.feedBackRedTipListener = new e(this, 2016561);
        this.memberCenterRedTipListener = new f(this, 2016459);
        this.updateVersionListener = new g(this, 2001436);
        this.mHomePageTabClickListener = new h(this, 2001384);
        this.personInfoChangeListener = new i(this, 2005016);
        this.syncFinishListener = new j(this, 2001371);
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRedTipShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            SparseArray sparseArray = new SparseArray();
            if (this.mIsNewAddressList) {
                sparseArray.append(4, new ei8.a(this.mShowFriendTip, this.maddressListNewCount));
            }
            if (this.mIsShowFansNewMsg) {
                sparseArray.append(2, new ei8.a(this.mShowFanTip, this.mFans));
            }
            if (this.mIsShowGiftsNewMsg) {
                sparseArray.append(1, new ei8.a(this.mShowGifTip, this.mGift));
            }
            if (this.mIsShowBookmarkNewMsg) {
                sparseArray.append(3, new ei8.a(this.mShowBookTip, this.mBookMarks));
            }
            if (this.mHasNewVersion) {
                sparseArray.append(5, new ei8.a(this.mShowSettingTip, 0));
            }
            if (this.mIsShowMemberCenerNewMsg) {
                sparseArray.append(7, new ei8.a(this.mShowMemberTip, 0));
            }
            if (this.mIsShowActivityNewMsg) {
                sparseArray.append(9, new ei8.a(this.mShowActivityTip, 0));
            }
            if (this.mIsFeedbackNewMsg) {
                sparseArray.append(10, new ei8.a(this.mShowFeedbackTip, 0));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new ei8(sparseArray)));
            updateTabTip();
        }
    }

    public /* synthetic */ PersonRedTipManager(b bVar) {
        this();
    }

    public void setIsPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isPrimary = z;
        }
    }

    public static final PersonRedTipManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return k.a;
        }
        return (PersonRedTipManager) invokeV.objValue;
    }

    private void initTabTip() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65564, this) == null) && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new oa5(this.mShowSettingTip)));
        }
    }

    public boolean isShowActivityTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mShowActivityTip;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowBookTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mShowBookTip;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowFanTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mShowFanTip;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowMemberTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mShowMemberTip;
        }
        return invokeV.booleanValue;
    }

    public void removeTabTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new oa5(false)));
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
            MessageManager.getInstance().registerListener(this.unreadNewAddressListListener);
            MessageManager.getInstance().registerListener(this.updateVersionListener);
            MessageManager.getInstance().registerListener(this.personInfoChangeListener);
            MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
            MessageManager.getInstance().registerListener(this.mHomePageTabClickListener);
            MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
            MessageManager.getInstance().registerListener(this.syncFinishListener);
            MessageManager.getInstance().registerListener(this.mDownloadCardListener);
        }
    }

    private void initRepTipState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (!qy4.k().h("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                this.mShowSettingTip = true;
            }
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder();
            sb.append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            this.hasClicked = inst.loadBoolean(sb.toString(), false);
        }
    }

    private void syncPersonTip() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            if (!this.mShowGifTip && !this.mShowBookTip && !this.mShowFanTip && !this.mShowFriendTip && !this.mShowSettingTip && !this.mShowMemberTip && !this.mShowActivityTip && !this.mShowNewGodInvitedTip) {
                z = false;
            } else {
                z = true;
            }
            if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new oa5(z, 0)));
            }
        }
    }

    private void updateTabTip() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            if ((this.mFans <= 0 || !this.mIsShowFansNewMsg) && ((this.mBookMarks <= 0 || !this.mIsShowBookmarkNewMsg) && !this.mHasNewVersion && !this.mIsShowActivityNewMsg && !this.mIsFeedbackNewMsg && !this.mIsDownloadCardMsg)) {
                z = false;
            } else {
                z = true;
            }
            if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
                if (this.mIsFeedbackNewMsg) {
                    qy4.k().u("key_feedback_tip_tab_show", true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new oa5(true, 0)));
            }
        }
    }

    public void resetRedTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mShowFanTip = false;
            this.mShowBookTip = false;
            this.mShowGifTip = false;
            this.mShowFriendTip = false;
            this.mShowSettingTip = false;
            this.mShowMemberTip = false;
            this.mShowActivityTip = false;
            this.mFans = 0;
            this.mGift = 0;
            this.mBookMarks = 0;
            this.maddressListNewCount = 0;
            this.mIsNewAddressList = false;
            this.mHasNewVersion = false;
            this.mIsShowFansNewMsg = false;
            this.mIsShowGiftsNewMsg = false;
            this.mIsShowBookmarkNewMsg = false;
            this.mIsShowMemberCenerNewMsg = false;
            this.mIsShowActivityNewMsg = false;
            initRepTipState();
            ah.a().post(new a(this));
            initTabTip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNotify(ResponsedMessage<?> responsedMessage) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65566, this, responsedMessage) != null) || responsedMessage == null || !(responsedMessage instanceof NewsNotifyMessage)) {
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
        boolean z6 = false;
        boolean z7 = true;
        if (newsNotifyMessage.getMsgBookmark() > this.mBookMarks) {
            z = true;
        } else {
            z = false;
        }
        this.mIsShowBookmarkNewMsg = z;
        if (newsNotifyMessage.getMsgFans() > this.mFans) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsShowFansNewMsg = z2;
        if (newsNotifyMessage.getMsgGiftNum() > this.mGift) {
            z6 = true;
        }
        this.mIsShowGiftsNewMsg = z6;
        this.mBookMarks = newsNotifyMessage.getMsgBookmark();
        this.mFans = newsNotifyMessage.getMsgFans();
        this.mGift = newsNotifyMessage.getMsgGiftNum();
        if (this.mIsShowBookmarkNewMsg || this.mIsShowFansNewMsg || this.mIsShowGiftsNewMsg || this.mHasNewVersion) {
            if (this.mIsShowFansNewMsg) {
                z3 = true;
            } else {
                z3 = this.mShowFanTip;
            }
            this.mShowFanTip = z3;
            if (this.mIsShowBookmarkNewMsg) {
                z4 = true;
            } else {
                z4 = this.mShowBookTip;
            }
            this.mShowBookTip = z4;
            if (this.mIsShowGiftsNewMsg) {
                z5 = true;
            } else {
                z5 = this.mShowGifTip;
            }
            this.mShowGifTip = z5;
            if (!this.mHasNewVersion) {
                z7 = this.mShowSettingTip;
            }
            this.mShowSettingTip = z7;
            notifyRedTipShow();
        }
    }

    public void saveAddressListRedState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder();
            sb.append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            inst.saveBoolean(sb.toString(), !this.mIsNewAddressList);
        }
    }

    public void syncRedTipState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || !z) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new ei8.a(this.mShowFriendTip, this.maddressListNewCount));
        sparseArray.append(2, new ei8.a(this.mShowFanTip, this.mFans));
        sparseArray.append(1, new ei8.a(this.mShowGifTip, this.mGift));
        sparseArray.append(3, new ei8.a(this.mShowBookTip, this.mBookMarks));
        sparseArray.append(5, new ei8.a(this.mShowSettingTip, 0));
        sparseArray.append(7, new ei8.a(this.mShowMemberTip, 0));
        sparseArray.append(9, new ei8.a(this.mShowActivityTip, 0));
        sparseArray.append(10, new ei8.a(this.mShowFeedbackTip, 0));
        sparseArray.append(11, new ei8.a(this.mShowNewGodInvitedTip, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new ei8(sparseArray)));
    }

    public void updateRedTipState(int i2, boolean z, boolean z2) {
        String currentAccount;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !z2) {
            return;
        }
        switch (i2) {
            case 1:
                this.mShowGifTip = z;
                break;
            case 2:
                this.mShowFanTip = z;
                break;
            case 3:
                this.mShowBookTip = z;
                break;
            case 4:
                this.mShowFriendTip = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    qy4.k().u("member_close_ad_setting_clicked", true);
                }
                this.mShowSettingTip = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = SevenZipUtils.FILE_NAME_TEMP;
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                qy4 k2 = qy4.k();
                k2.x("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                this.mShowMemberTip = z;
                break;
            case 9:
                this.mShowActivityTip = z;
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                qy4 k3 = qy4.k();
                k3.y("person_item_activity_prize_red_tip" + currentAccount2, TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                break;
            case 10:
                this.mShowFeedbackTip = z;
                break;
            case 11:
                this.mShowNewGodInvitedTip = z;
                break;
        }
        syncRedTipState(true);
        syncPersonTip();
    }
}
