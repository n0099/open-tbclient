package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestSwitch;
import com.baidu.tbadk.abtest.group.HomeGroupUbsABTest;
import com.baidu.tbadk.abtest.group.IThreadCardUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class sw4 extends BaseCardInfo implements IThreadCardUbsABTest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> feedBackReasonMap;
    public int floorPosition;
    public Map<BdUniqueId, UsbAbTestSwitch> mABTestMap;
    public int objType;

    public abstract py4 getNegFeedBackData();

    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract ThreadData getThreadData();

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public boolean showNoName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public boolean showWeakenName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public sw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.objType = 1;
        this.floorPosition = -1;
        this.mABTestMap = new HashMap();
        this.feedBackReasonMap = null;
    }

    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getThreadData() == null) {
                return null;
            }
            return getThreadData().getRecomReason();
        }
        return (String) invokeV.objValue;
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.isFromFrs();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo
    public boolean isHighLight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getThreadData() != null && getThreadData().isHighLight()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ThreadCardUtils.isSelf(getThreadData());
        }
        return invokeV.booleanValue;
    }

    public boolean showCardEnterFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            if (!threadData.isFromConcern && !threadData.isFromPersonPolymeric && !threadData.isWorksInfo()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showCardGoodsFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            if (!threadData.isFromConcern && !threadData.isFromPersonPolymeric && !threadData.isFromHomPage) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public boolean showNewPicCut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return UbsABTestHelper.isABTestByKeys(getCurUsbAbTestSwitchByKey(HomeGroupUbsABTest.ABTEST_GROUP_KEY), HomeGroupUbsABTest.SID_B);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return UbsABTestHelper.isABTestByKeys(getCurUsbAbTestSwitchByKey(HomeGroupUbsABTest.ABTEST_GROUP_KEY), HomeGroupUbsABTest.SID_A);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public boolean showNoReadState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return UbsABTestHelper.isABTestByKeys(getCurUsbAbTestSwitchByKey(HomeGroupUbsABTest.ABTEST_GROUP_KEY), HomeGroupUbsABTest.SID_E);
        }
        return invokeV.booleanValue;
    }

    private UsbAbTestSwitch getCurUsbAbTestSwitchByKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return null;
            }
            return this.mABTestMap.get(bdUniqueId);
        }
        return (UsbAbTestSwitch) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.abtest.group.IThreadCardUbsABTest
    public void setABTest(BdUniqueId bdUniqueId, UsbAbTestSwitch usbAbTestSwitch) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, bdUniqueId, usbAbTestSwitch) != null) || bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, usbAbTestSwitch);
    }

    public boolean showCardBottomOpWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            if (!threadData.isFromHomPage && !threadData.isFromConcern && !threadData.isFromPersonPolymeric && !threadData.isFromVideoTab && !threadData.isFromEnterFroumTabFeed && !threadData.isFromFeedTab) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showFollowBtn() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null || threadData.getAuthor() == null || threadData.isFromLocal || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            if (!threadData.isBjhDynamicThread() && !threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                z = false;
            } else {
                z = true;
            }
            if ((!threadData.isFromHomPage || (!z && !threadData.isWorksInfo())) && ((!threadData.isFromVideoTab || (!z && !threadData.isWorksInfo())) && (!threadData.isFromFrs() || (!z && !threadData.isWorksInfo())))) {
                if (!threadData.isFromFeedTab) {
                    return false;
                }
                if (!z && !threadData.isWorksInfo()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
