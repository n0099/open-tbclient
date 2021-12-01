package com.baidu.webkit.sdk.performance;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class PageLongTaskData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mDomComplete;
    public long mEnd;
    public long mFCP;
    public long mFMP;
    public long mFSP;
    public ArrayList<Pair<Long, Integer>> mIframeLongTaskList;
    public ArrayList<Pair<Long, Integer>> mLongTaskList;
    public int mLongTaskSize;
    public long mNavigationStart;
    public long mSameDomNavigation;
    public long mSwapIn;

    public PageLongTaskData() {
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
        this.mLongTaskList = new ArrayList<>();
        this.mIframeLongTaskList = new ArrayList<>();
    }
}
